package com.larus.bmhome.chat.actionbar;

import cc8.a;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.z0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\nH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0006H&J6\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u001a\u0010\u0014\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00110\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0006H&J\b\u0010\u0018\u001a\u00020\u0006H&J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H&J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\nH&J\u000f\u0010$\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010'R\u0018\u0010\u0019\u001a\u00020\u001aX¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/actionbar/IActionBarService;", "", "getActionBarItems", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "botId", "", "getActionBarImagePrefetchEntries", "Lcom/larus/bmhome/chat/actionbar/ActionBarImagePrefetchEntry;", "preloadActionBarCache", "", "scene", "getMainBotActionBarItem", "instructionType", "getMainBotActionBarItemByItemId", "itemId", "updateConfigFromRemote", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "callback", "Lkotlin/Function1;", "updateCustomCacheKeySuffix", "key", "getCustomCacheKeySuffix", "compatDeprecateForbidUnnecessaryConversationRefresh", "", "getCompatDeprecateForbidUnnecessaryConversationRefresh", "()Z", "setCompatDeprecateForbidUnnecessaryConversationRefresh", "(Z)V", "isMoaMode", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getSwitchState", "switchType", "getMainBotCurrentDeepThinkStatus", "()Ljava/lang/Integer;", "getAgentModeValue", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;)Ljava/lang/Integer;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IActionBarService {
    Integer a();

    void b(boolean r100);

    boolean c();

    void d(CoroutineScope r100, String r101, Function1<? super List<z0>, Unit> r102);

    z0 e(int r100);

    List<z0> f(String r100);

    z0 g(String r100);

    ReplyOption h(String r100, int r101);

    Integer i(ReplyOption r100);

    void j(String r100);

    List<a> k(String r100);

    int l(String r100, String r101);

    boolean m(ReplyOption r100);

    String n();
}
