package com.larus.bmhome.chat.setting;

import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.platform.model.UserConfigItem;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u000bH&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0016H&J$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H¦@¢\u0006\u0002\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/setting/IUserSettingCacheService;", "", "init", "", "saveAnswerWithVideo", "", "value", "", "notifyServer", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnswerWithVideo", "", "saveKeywordHighlightEngine", "getKeywordHighlightEngine", "getSettingEngineType", "saveUserSettings", "userConfigs", "", "Lcom/larus/platform/model/UserConfigItem;", "getLocalUserSettingList", "getUserSetting", "key", "Lcom/larus/bmhome/chat/setting/bean/UserConfigKey;", "syncUserConfig", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "userConfigUpdatedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUserConfigUpdatedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IUserSettingCacheService {
    int S();

    Object a(List<UserConfigItem> r100, Continuation<? super List<UserConfigItem>> r101);

    UserConfigItem b(UserConfigKey r100);

    void c(List<UserConfigItem> r100);

    Object d(String r100, boolean r101, Continuation<? super Boolean> r102);

    String e();

    int f();

    List<UserConfigItem> g();

    Object h(String r100, boolean r101, Continuation<? super Boolean> r102);

    d1<UserConfigKey> i();

    void init();
}
