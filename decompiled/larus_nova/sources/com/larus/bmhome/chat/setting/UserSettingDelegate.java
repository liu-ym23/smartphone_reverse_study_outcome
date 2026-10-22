package com.larus.bmhome.chat.setting;

import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.platform.model.UserConfigItem;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0012H\u0096A¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0012H\u0096A¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0001J$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096A¢\u0006\u0002\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/setting/UserSettingDelegate;", "Lcom/larus/bmhome/chat/setting/IUserSettingCacheService;", "<init>", "()V", "getAnswerWithVideo", "", "getKeywordHighlightEngine", "", "getLocalUserSettingList", "", "Lcom/larus/platform/model/UserConfigItem;", "getSettingEngineType", "getUserSetting", "key", "Lcom/larus/bmhome/chat/setting/bean/UserConfigKey;", "init", "", "saveAnswerWithVideo", "", "value", "notifyServer", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveKeywordHighlightEngine", "saveUserSettings", "userConfigs", "syncUserConfig", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "userConfigUpdatedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUserConfigUpdatedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserSettingDelegate implements IUserSettingCacheService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UserSettingDelegate f308901b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IUserSettingCacheService f308902a;

    static {
        f308901b = new UserSettingDelegate();
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final int S() {
        return this.f308902a.S();
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final Object a(List<UserConfigItem> r100, Continuation<? super List<UserConfigItem>> r101) {
        return this.f308902a.a(r100, r101);
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final UserConfigItem b(UserConfigKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f308902a.b(r100);
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final void c(List<UserConfigItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "userConfigs");
        this.f308902a.c(r100);
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final Object d(String r100, boolean r101, Continuation<? super Boolean> r102) {
        return this.f308902a.d(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final String e() {
        return this.f308902a.e();
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final int f() {
        return this.f308902a.f();
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final List<UserConfigItem> g() {
        return this.f308902a.g();
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final Object h(String r100, boolean r101, Continuation<? super Boolean> r102) {
        return this.f308902a.h(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final d1<UserConfigKey> i() {
        return this.f308902a.i();
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final void init() {
        this.f308902a.init();
    }

    private UserSettingDelegate() {
        IUserSettingCacheService r100 = (IUserSettingCacheService) ServiceManager.get().getService(IUserSettingCacheService.class);
        if (r100 != null) goto L5;
        r100 = new UserSettingCacheServiceNoop();
    L5:
        this.f308902a = r100;
    }
}
