package com.larus.bmhome.chat.setting;

import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.platform.model.UserConfigItem;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u0016\u0010\u001e\u001a\u00020\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u0006H\u0016J$\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0096@¢\u0006\u0002\u0010%R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/setting/UserSettingCacheServiceNoop;", "Lcom/larus/bmhome/chat/setting/IUserSettingCacheService;", "<init>", "()V", "userConfigs", "", "Lcom/larus/bmhome/chat/setting/bean/UserConfigKey;", "Lcom/larus/platform/model/UserConfigItem;", "updatedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "answerWithVideo", "", "keywordHighlightEngine", "", "settingEngineType", "userConfigUpdatedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUserConfigUpdatedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "init", "", "saveAnswerWithVideo", "", "value", "notifyServer", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnswerWithVideo", "saveKeywordHighlightEngine", "getKeywordHighlightEngine", "getSettingEngineType", "saveUserSettings", "", "getLocalUserSettingList", "getUserSetting", "key", "syncUserConfig", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserSettingCacheServiceNoop implements IUserSettingCacheService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<UserConfigKey, UserConfigItem> f308896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableSharedFlow<UserConfigKey> f308897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f308898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f308899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableSharedFlow f308900e;

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final int f() {
        return 0;
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final void init() {
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final List<UserConfigItem> g() {
        return CollectionsKt.toList(((LinkedHashMap) this.f308896a).values());
    }

    public UserSettingCacheServiceNoop() {
        this.f308896a = new LinkedHashMap();
        MutableSharedFlow<UserConfigKey> r100 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f308897b = r100;
        this.f308899d = "";
        this.f308900e = r100;
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final int S() {
        return this.f308898c;
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final String e() {
        return this.f308899d;
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final d1<UserConfigKey> i() {
        return this.f308900e;
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final UserConfigItem b(UserConfigKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (UserConfigItem) ((LinkedHashMap) this.f308896a).get(r100);
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final void c(List<UserConfigItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "userConfigs");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        UserConfigItem r102 = (UserConfigItem) r101.next();
        Integer r103 = r102.b();
        if (r103 == null) goto L4;
        UserConfigKey.a r104 = UserConfigKey.Companion;
        int r105 = r103.intValue();
        r104.getClass();
        UserConfigKey r106 = UserConfigKey.a.a(r105);
        if (r106 == null) goto L4;
        this.f308896a.put(r106, r102);
        this.f308897b.tryEmit(r106);
        goto L4
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final Object a(List<UserConfigItem> r100, Continuation<? super List<UserConfigItem>> r101) {
        c(r100);
        return r100;
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final Object d(String r100, boolean r101, Continuation<? super Boolean> r102) {
        Integer r103 = StringsKt.toIntOrNull(r100);
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L6:
        this.f308898c = r104;
        return Boxing.boxBoolean(true);
    L5:
        r104 = 0;
        goto L6
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final Object h(String r100, boolean r101, Continuation<? super Boolean> r102) {
        this.f308899d = r100;
        return Boxing.boxBoolean(true);
    }
}
