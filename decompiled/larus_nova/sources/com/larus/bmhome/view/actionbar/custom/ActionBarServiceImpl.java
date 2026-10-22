package com.larus.bmhome.view.actionbar.custom;

import android.os.SystemClock;
import androidx.lifecycle.FlowLiveDataConversions;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.manager.ExpertSwitchManager;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.view.actionbar.custom.cache.ActionBarCacheStore;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\tH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\u001aH\u0016J\u001a\u0010$\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010%2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J4\u0010&\u001a\u00020\u000b2$\u0010'\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0*\u0012\u0006\u0012\u0004\u0018\u00010+0(H\u0082@¢\u0006\u0002\u0010,J\"\u0010-\u001a\u00020\u000b2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010%2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0002J(\u0010/\u001a\u00020\u000b2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010%2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0002\u00100J6\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u0002032\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u001a\u0010'\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010%\u0012\u0004\u0012\u00020\u000b04H\u0016J\u0017\u00105\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u00107J\u0017\u00108\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u00109R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006;"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/ActionBarServiceImpl;", "Lcom/larus/bmhome/chat/actionbar/IActionBarService;", "<init>", "()V", "cache", "Lcom/bytedance/keva/Keva;", "repo", "Lcom/larus/bmhome/chat/model/repo/BotRepo;", "customCacheKeySuffix", "", "updateCustomCacheKeySuffix", "", "key", "getCustomCacheKeySuffix", "compatDeprecateForbidUnnecessaryConversationRefresh", "", "getCompatDeprecateForbidUnnecessaryConversationRefresh", "()Z", "setCompatDeprecateForbidUnnecessaryConversationRefresh", "(Z)V", "isMoaMode", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getSwitchState", "botId", "switchType", "", "getMainBotCurrentDeepThinkStatus", "()Ljava/lang/Integer;", "preloadActionBarCache", "scene", "getMainBotActionBarItemByItemId", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "itemId", "getMainBotActionBarItem", "instructionType", "getActionBarItems", "", "getMainBotConversationInfo", "callback", "Lkotlin/Function2;", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalCache", "actionBarItemList", "updateLocalCacheFromRemote", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConfigFromRemote", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Function1;", "actionMatchLibra", ReportConstant.COMMON_ACTION_TYPE, "(Ljava/lang/Integer;)Z", "getAgentModeValue", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;)Ljava/lang/Integer;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarServiceImpl implements IActionBarService {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f315700e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f315701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BotRepo f315702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f315703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f315704d;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final Integer a() {
        com.larus.bmhome.chat.api.e0 r100 = AuthModelDelegate.f297134b.e().getValue();
        if (r100 == null) goto L17;
        LaunchInfo r101 = r100.f297186a;
        if (r101 == null) goto L17;
        String r102 = r101.W();
        if (r102 == null) goto L17;
        if (r102.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L17;
    L18:
        List<com.larus.bmhome.actionbar.model.z0> r104 = f(r102);
        if (r104 != null) goto L21;
        return null;
    L21:
        Iterator<T> r105 = r104.iterator();
    L23:
        if (r105.hasNext() == false) goto L35;
        Object r106 = r105.next();
        com.larus.bmhome.actionbar.model.p0 r107 = ((com.larus.bmhome.actionbar.model.z0) r106).f295619o;
        if (r107 == null) goto L32;
        Integer r108 = r107.f295366a;
        int r109 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r108 == null) goto L32;
        if (r108.intValue() != r109) goto L32;
        boolean r110 = true;
    L33:
        if (r110 == false) goto L23;
    L36:
        com.larus.bmhome.actionbar.model.z0 r111 = (com.larus.bmhome.actionbar.model.z0) r106;
        if (r111 == null) goto L45;
        com.larus.bmhome.actionbar.model.p0 r112 = r111.f295619o;
        if (r112 == null) goto L45;
        Object r113 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        com.larus.bmhome.view.actionbar.custom.cache.e.j(r104);
        com.larus.bmhome.instruction.c r114 = com.larus.bmhome.instruction.c.f311900a;
        ActiveSwitchType r115 = ActiveSwitchType.DEEPTHINK;
        int r116 = r115.getValue();
        Intrinsics.checkNotNullParameter(r102, "botId");
        if (com.larus.bmhome.instruction.c.f311904e.containsKey(com.larus.bmhome.instruction.c.b(r102, r116)) == true) goto L43;
        com.larus.bmhome.instruction.c.c(r102, r115.getValue(), r112.b());
    L43:
        ReplyOption r117 = h(r102, r115.getValue());
        FLogger.f375446a.i("ActionBarServiceImpl", "getMainBotCurrentDeepThinkStatus, botId=" + r102 + ", status=" + r117.getModel());
        return Integer.valueOf(r117.getModel().getDeprecatedItemId());
    L45:
        return null;
    L32:
        r110 = false;
        goto L33
    L35:
        r106 = null;
        goto L36
    L11:
        r103 = false;
    L17:
        r102 = "7234781073513644036";
        goto L18
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final String n() {
        String r100 = this.f315703c;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public ActionBarServiceImpl() {
        this.f315701a = Keva.getRepo(CustomActionBarViewModel.CACHE_FILE);
        RepoDispatcher.f307729a.getClass();
        this.f315702b = RepoDispatcher.f307735g;
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final boolean c() {
        return this.f315704d;
    }

    public static boolean p(Integer r100) {
        int r101 = ActionBarExecutionType.COMPLEX_SEARCH.getValue();
        if (r100 != null) goto L6;
    L8:
        return true;
    L6:
        if (r100.intValue() != r101) goto L8;
        CoroutineScope r102 = ExpertSwitchManager.f306663a;
        boolean r103 = FeatureKitDelegate.f295792b.Y().b();
        FLogger.f375446a.w("ActionBarServiceImpl", "complex search matched = " + r103);
        return r103;
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final void b(boolean r100) {
        this.f315704d = r100;
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final com.larus.bmhome.actionbar.model.z0 e(int r100) {
        com.larus.bmhome.chat.api.e0 r101 = AuthModelDelegate.f297134b.e().getValue();
        if (r101 == null) goto L8;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L8;
        String r103 = r102.W();
        if (r103 == null) goto L8;
    L9:
        List<com.larus.bmhome.actionbar.model.z0> r104 = f(r103);
        String r105 = null;
        if (r104 == null) goto L26;
        Iterator<T> r106 = r104.iterator();
    L13:
        if (r106.hasNext() == false) goto L24;
        Object r107 = r106.next();
        com.larus.bmhome.actionbar.model.r r108 = ((com.larus.bmhome.actionbar.model.z0) r107).f295621q;
        boolean r109 = false;
        if (r108 == null) goto L22;
        Integer r110 = r108.f295408a;
        if (r110 == null) goto L22;
        if (r110.intValue() != r100) goto L22;
        r109 = true;
    L22:
        if (r109 == false) goto L13;
    L25:
        com.larus.bmhome.actionbar.model.z0 r111 = (com.larus.bmhome.actionbar.model.z0) r107;
    L27:
        if (r111 != null) goto L34;
        FLogger r112 = FLogger.f375446a;
        StringBuilder r113 = new StringBuilder("actionBarItem is null , request_id:");
        if (r104 == null) goto L33;
        com.larus.bmhome.actionbar.model.z0 r114 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r104);
        if (r114 == null) goto L33;
        r105 = r114.A;
    L33:
        r113.append(r105);
        r112.e("ActionBarServiceImpl", r113.toString());
    L34:
        return r111;
    L24:
        r107 = null;
        goto L25
    L26:
        r111 = null;
    L8:
        r103 = "7234781073513644036";
        goto L9
    }

    /* JADX WARN: Type inference failed for: r2v18, types: [com.larus.bmhome.view.actionbar.custom.k] */
    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final List<com.larus.bmhome.actionbar.model.z0> f(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = CustomActionBar.f315707c0;
        String r102 = CustomActionBar.b.a();
        if (com.larus.platform.exp.a.f365360a == true) goto L8;
        String r103 = AccountService.f365697a.getUserId() + '-' + r102 + '-' + r100 + this.f315703c;
        FLogger r104 = FLogger.f375446a;
        r104.i("ActionBarServiceImpl", "getCacheConfig, cacheKey=" + r103);
        String r105 = this.f315701a.getString(r103, "");
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == false) goto L19;
        r104.i("ActionBarServiceImpl", "getCacheConfig, has no cache");
        return null;
    L19:
        ArrayList r107 = new ArrayList();
        ActionBarCacheStore r108 = ActionBarCacheStore.f315858a;     // Catch: Exception -> L37
        List r109 = ActionBarCacheStore.h(r105, new l());     // Catch: Exception -> L37
        if (r109 != null) goto L23;
        r109 = CollectionsKt.emptyList();     // Catch: Exception -> L37
    L23:
        ArrayList r110 = new ArrayList();     // Catch: Exception -> L37
        Iterator r111 = r109.iterator();     // Catch: Exception -> L37
    L25:
        if (r111.hasNext() == false) goto L29;
        Object r112 = r111.next();     // Catch: Exception -> L37
        if (p(((com.larus.bmhome.actionbar.model.z0) r112).f295611g) == false) goto L25;
        r110.add(r112);     // Catch: Exception -> L37
        goto L25
    L29:
        ArrayList r113 = new ArrayList();     // Catch: Exception -> L37
        Iterator r114 = r110.iterator();     // Catch: Exception -> L37
    L31:
        if (r114.hasNext() == false) goto L35;
        Object r115 = r114.next();     // Catch: Exception -> L37
        if (com.larus.utils.o0.d(((com.larus.bmhome.actionbar.model.z0) r115).f295609e) == false) goto L31;
        r113.add(r115);     // Catch: Exception -> L37
        goto L31
    L35:
        r107.addAll(r113);     // Catch: Exception -> L37
    L39:
        FLogger.f375446a.i("ActionBarServiceImpl", "getCacheConfig, result=" + r107.size());
        return r107;
    L37:
        e = move-exception;
        FLogger.f375446a.e("ActionBarServiceImpl", "getCacheConfig, err.msg=" + e.getMessage());
        goto L39
    L12:
        if (r105.length() == 0) goto L15;
        r106 = false;
        goto L16
    L8:
        return ActionBarCacheStore.c(r102, r100, null, new k(this), 4);
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final com.larus.bmhome.actionbar.model.z0 g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        com.larus.bmhome.chat.api.e0 r101 = AuthModelDelegate.f297134b.e().getValue();
        if (r101 == null) goto L8;
        LaunchInfo r102 = r101.f297186a;
        if (r102 == null) goto L8;
        String r103 = r102.W();
        if (r103 == null) goto L8;
    L9:
        List<com.larus.bmhome.actionbar.model.z0> r104 = f(r103);
        String r105 = null;
        if (r104 == null) goto L19;
        Iterator<T> r106 = r104.iterator();
    L13:
        if (r106.hasNext() == false) goto L17;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r107).f295605a, StringsKt.toLongOrNull(r100)) == false) goto L13;
    L18:
        com.larus.bmhome.actionbar.model.z0 r108 = (com.larus.bmhome.actionbar.model.z0) r107;
    L20:
        if (r108 != null) goto L27;
        FLogger r109 = FLogger.f375446a;
        StringBuilder r110 = new StringBuilder("[getMainBotActionBarItemByItemId] actionBarItem is null , request_id:");
        if (r104 == null) goto L26;
        com.larus.bmhome.actionbar.model.z0 r111 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r104);
        if (r111 == null) goto L26;
        r105 = r111.A;
    L26:
        r110.append(r105);
        r109.e("ActionBarServiceImpl", r110.toString());
    L27:
        return r108;
    L17:
        r107 = null;
        goto L18
    L19:
        r108 = null;
    L8:
        r103 = "7234781073513644036";
        goto L9
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final Integer i(ReplyOption r100) {
        Intrinsics.checkNotNullParameter(r100, "replyOption");
        Object r101 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        return Integer.valueOf(com.larus.bmhome.view.actionbar.custom.cache.e.c(r100));
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f315703c = r100;
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final List<cc8.a> k(String r100) {
        boolean r101 = v19.h.f552477a;
        boolean r102 = v19.h.b(AppHost.f326268a.getApplication());
        List<com.larus.bmhome.actionbar.model.z0> r103 = f(r100);
        if (r103 == null) goto L32;
        List<com.larus.bmhome.actionbar.model.z0> r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L28;
        com.larus.bmhome.actionbar.model.z0 r107 = (com.larus.bmhome.actionbar.model.z0) r106.next();
        if (r102 == false) goto L12;
        com.larus.bmhome.actionbar.model.g1 r108 = r107.f295608d;
        if (r108 != null) goto L14;
    L15:
        String r109 = null;
    L16:
        Long r110 = r107.f295605a;
        if (r109 == null) goto L25;
        boolean r111 = false;
        if (StringsKt.startsWith$default(r109, "http://", false, 2, null) == false) goto L21;
    L22:
        r111 = true;
    L23:
        if (r111 == false) goto L25;
    L26:
        r105.add(new cc8.a(r110, CollectionsKt.listOfNotNull(r109)));
        goto L6
    L21:
        if (StringsKt.startsWith$default(r109, "https://", false, 2, null) == false) goto L23;
    L25:
        r109 = null;
    L14:
        r109 = r108.f295156b;
        goto L16
    L12:
        r108 = r107.f295607c;
        if (r108 == null) goto L15;
    L28:
        return r105;
    L32:
        return null;
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final boolean m(ReplyOption r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Object r101 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        return com.larus.bmhome.view.actionbar.custom.cache.e.i(r100);
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final ReplyOption h(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        com.larus.bmhome.instruction.c r102 = com.larus.bmhome.instruction.c.f311900a;
        Intrinsics.checkNotNullParameter(r100, "botId");
        if (com.larus.bmhome.instruction.c.f311904e.containsKey(com.larus.bmhome.instruction.c.b(r100, r101)) == true) goto L28;
        List<com.larus.bmhome.actionbar.model.z0> r103 = f(r100);
        if (r103 == null) goto L28;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L20;
        Object r105 = r104.next();
        com.larus.bmhome.actionbar.model.p0 r106 = ((com.larus.bmhome.actionbar.model.z0) r105).f295619o;
        if (r106 == null) goto L17;
        Integer r107 = r106.f295366a;
        if (r107 == null) goto L17;
        if (r107.intValue() != r101) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L8;
    L21:
        com.larus.bmhome.actionbar.model.z0 r109 = (com.larus.bmhome.actionbar.model.z0) r105;
        if (r109 == null) goto L28;
        com.larus.bmhome.actionbar.model.p0 r110 = r109.f295619o;
        if (r110 == null) goto L28;
        ReplyOption r111 = r110.a();
        Object r112 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        com.larus.bmhome.view.actionbar.custom.cache.e.j(r103);
        return r111;
    L17:
        r108 = false;
        goto L18
    L20:
        r105 = null;
    L28:
        return com.larus.bmhome.instruction.c.f311900a.a(r100, r101);
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final int l(String r100, String r110) {
        Integer r101 = null;
        if (r100 != null) goto L5;
    L12:
        com.larus.bmhome.chat.api.e0 r102 = AuthModelDelegate.f297134b.e().getValue();
        if (r102 == null) goto L17;
        LaunchInfo r103 = r102.f297186a;
        if (r103 == null) goto L17;
        r100 = r103.W();
    L18:
        if (r100 != null) goto L20;
        r100 = "7234781073513644036";
    L20:
        int r104 = CustomActionBar.f315707c0;
        String r105 = CustomActionBar.b.a();
        long r106 = SystemClock.elapsedRealtime();
        List r107 = ActionBarCacheStore.c(r105, r100, r110, null, 8);
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("preloadActionBarCache, botId=");
        r109.append(r100);
        r109.append(", scene=");
        r109.append(r110);
        r109.append(", result=");
        if (r107 == null) goto L23;
        r101 = Integer.valueOf(r107.size());
    L23:
        r109.append(r101);
        r109.append(", costMs=");
        r109.append(SystemClock.elapsedRealtime() - r106);
        r108.i("ActionBarServiceImpl", r109.toString());
        if (r107 != null) goto L26;
        return 0;
    L26:
        return r107.size();
    L17:
        r100 = null;
        goto L18
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == true) goto L11;
        r100 = null;
    L11:
        if (r100 != null) goto L20;
    L7:
        r111 = false;
        goto L8
    }

    public final void q(List<com.larus.bmhome.actionbar.model.z0> r100, String r101) {
        String r102 = AccountService.f365697a.getUserId();
        if (r101 != null) goto L5;
        return;
    L5:
        int r103 = CustomActionBar.f315707c0;
        String r104 = CustomActionBar.b.a();
        boolean r105 = com.larus.platform.exp.a.f365360a;
        if (r105 == false) goto L8;
        String r106 = n();
    L9:
        String r107 = r102 + '-' + r104 + '-' + r101 + r106;
        if (r100 == null) goto L25;
        this.f315701a.storeString(r107, xt7.d.f565073b.a(kuc.a.b(com.larus.bmhome.actionbar.model.z0.Companion.serializer()), r100));     // Catch: Exception -> L18
        if (r105 == true) goto L14;
    L21:
        return;
    L14:
        if (com.larus.platform.exp.a.f365361b == false) goto L16;
        ActionBarCacheStore r108 = ActionBarCacheStore.f315858a;     // Catch: Exception -> L18
        ActionBarCacheStore.k(r104, r101, null, r100);     // Catch: Exception -> L18
        goto L21
    L16:
        ActionBarCacheStore r109 = ActionBarCacheStore.f315858a;     // Catch: Exception -> L18
        ActionBarCacheStore.a(r104, r101, null);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        FLogger.f375446a.e("ActionBarServiceImpl", "save cache error=" + e.getMessage());
        return;
    L25:
        return;
    L8:
        r106 = this.f315703c;
        goto L9
    }

    public static final Object o(ActionBarServiceImpl r100, Function2 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ActionBarServiceImpl$getMainBotConversationInfo$1) == false) goto L7;
        ActionBarServiceImpl$getMainBotConversationInfo$1 r103 = (ActionBarServiceImpl$getMainBotConversationInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (Function2) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        wc9.e r108 = (wc9.e) r105;
    L25:
        r103.L$0 = null;
        r103.label = 2;
        if (r101.invoke(r108, r103) != r106) goto L29;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        ILaunchCacheService r109 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r109 == null) goto L21;
        r108 = r109.b();
        if (r108 != null) goto L25;
    L21:
        Flow r110 = FlowLiveDataConversions.asFlow(AuthModelDelegate.f297134b.y());
        ActionBarServiceImpl$getMainBotConversationInfo$cvs$2 r111 = new ActionBarServiceImpl$getMainBotConversationInfo$cvs$2(null);
        r103.L$0 = r101;
        r103.label = 1;
        r105 = kotlinx.coroutines.flow.e.t(r110, r111, r103);
        if (r105 != r106) goto L24;
        return r106;
    L7:
        r103 = new ActionBarServiceImpl$getMainBotConversationInfo$1(r100, r102);
        goto L8
    }

    @Override // com.larus.bmhome.chat.actionbar.IActionBarService
    public final void d(CoroutineScope r110, String r111, Function1<? super List<com.larus.bmhome.actionbar.model.z0>, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "scope");
        Intrinsics.checkNotNullParameter(r112, "callback");
        AccountService.f365697a.getUserId();
        int r100 = CustomActionBar.f315707c0;
        BuildersKt.launch$default(r110, null, null, new ActionBarServiceImpl$updateConfigFromRemote$1(this, CustomActionBar.b.a(), r111, r112, null), 3, null);
    }
}
