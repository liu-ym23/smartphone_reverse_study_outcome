package com.larus.bmhome.setting;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.setting.IUserSettingCacheService;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.setting.migrate.UserSettingMigrateRepo;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.y;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.y4;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u000bJ\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0096@¢\u0006\u0002\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/larus/bmhome/setting/UserSettingCacheImpl;", "Lcom/larus/bmhome/chat/setting/IUserSettingCacheService;", "<init>", "()V", "init", "", "saveAnswerWithVideo", "", "value", "", "notifyServer", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnswerWithVideo", "", "saveKeywordHighlightEngine", "getKeywordHighlightEngine", "getSettingEngineType", "saveUserSettings", "userConfigs", "", "Lcom/larus/platform/model/UserConfigItem;", "getLocalUserSettingList", "getUserSetting", "key", "Lcom/larus/bmhome/chat/setting/bean/UserConfigKey;", "syncUserConfig", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "userConfigUpdatedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUserConfigUpdatedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserSettingCacheImpl implements IUserSettingCacheService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1 f313813a;

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final int S() {
        UserSettingCacheManager.f313814a.getClass();
        return UserSettingCacheManager.b();
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final String e() {
        UserSettingCacheManager.f313814a.getClass();
        return UserSettingCacheManager.f();
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final int f() {
        ISettingRepoService r100 = (ISettingRepoService) ServiceManager.get().getService(ISettingRepoService.class);
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.K();
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final List<UserConfigItem> g() {
        UserSettingCacheManager.f313814a.getClass();
        return UserSettingCacheManager.g();
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final void init() {
        UserSettingCacheManager.f313814a.getClass();
        FLogger r100 = FLogger.f375446a;
        r100.d("UserSettingCacheManager", "init");
        Keva r101 = UserSettingCacheManager.f313816c;
        if (r101 != null) goto L5;
        r100.w("UserSettingCacheManager", "migrateLocalUserSettings, keva is null");
    L46:
        AccountService.f365697a.E(new n());
        return;
    L5:
        r100.d("UserSettingCacheManager", "migrateAnswerWithVideo");
        UserConfigKey r102 = UserConfigKey.ANSWER_WITH_SUGGEST;
        UserConfigKey r103 = UserConfigKey.ANSWER_WITH_VIDEO;
        if (r101.contains(UserSettingCacheManager.c(r103)) == false) goto L8;
        r100.d("UserSettingCacheManager", "migrateAnswerWithVideo, new key exist(" + UserSettingCacheManager.j(r103) + ')');
        r101.erase("video_setting_key");
    L8:
        String r104 = "";
        if (r101.contains("video_setting_key") == false) goto L14;
        int r105 = r101.getInt("video_setting_key", 0);
        r100.d("UserSettingCacheManager", "migrateAnswerWithVideo, old key exist(" + r105 + ')');
        UserConfigItem r106 = new UserConfigItem(Integer.valueOf(r102.getValue()), String.valueOf(r105), 1L);
        String r107 = UserSettingCacheManager.c(r102);
        String r108 = GsonProtectorUtils.toJson(new Gson(), r106);
        if (r108 != null) goto L13;
        r108 = "";
    L13:
        r101.storeString(r107, r108);
    L14:
        r100.d("UserSettingCacheManager", "migrateAnswerWithSuggest");
        Keva r109 = UserSettingCacheManager.f313817d;
        if (r101.contains(UserSettingCacheManager.c(r102)) == false) goto L17;
        r100.d("UserSettingCacheManager", "migrateAnswerWithSuggest, new key exist(" + UserSettingCacheManager.j(r102) + ')');
        r109.erase("chat_prompt");
    L17:
        String r110 = "1";
        String r111 = "0";
        if (r109.contains("chat_prompt") == false) goto L27;
        boolean r112 = r109.getBoolean("chat_prompt", FeatureKitDelegate.f295792b.i0().a());
        r100.d("UserSettingCacheManager", "migrateAnswerWithSuggest, old key exist(" + r112 + ')');
        Integer r113 = Integer.valueOf(r102.getValue());
        if (r112 == false) goto L22;
        String r114 = "1";
    L23:
        UserConfigItem r115 = new UserConfigItem(r113, r114, 1L);
        String r116 = UserSettingCacheManager.c(r102);
        String r117 = GsonProtectorUtils.toJson(new Gson(), r115);
        if (r117 != null) goto L26;
        r117 = "";
    L26:
        r101.storeString(r116, r117);
        goto L27
    L22:
        r114 = "0";
    L27:
        r100.d("UserSettingCacheManager", "migrateHighlightKeyword");
        UserConfigKey r118 = UserConfigKey.HIGHLIGHT_KEYWORD;
        if (r101.contains(UserSettingCacheManager.c(r118)) == false) goto L31;
        r100.d("UserSettingCacheManager", "migrateHighlightKeyword, new key exist, item(" + UserSettingCacheManager.j(r118) + ')');
        r109.erase("chat_highlight_enable");
        r109.erase("chat_highlight_engine");
    L31:
        if (r109.contains("chat_highlight_engine") == true) goto L35;
        if (r109.contains("chat_highlight_enable") == false) goto L46;
    L35:
        if (r109.getBoolean("chat_highlight_enable", false) == true) goto L37;
    L41:
        r100.d("UserSettingCacheManager", "migrateAnswerWithSuggest, old key exist, value(" + r111 + ')');
        UserConfigItem r119 = new UserConfigItem(Integer.valueOf(r118.getValue()), r111, 1L);
        String r120 = UserSettingCacheManager.c(r118);
        String r121 = GsonProtectorUtils.toJson(new Gson(), r119);
        if (r121 == null) goto L45;
        r104 = r121;
    L45:
        r101.storeString(r120, r104);
        goto L46
    L37:
        if (AppHost.f326268a.isOversea() == true) goto L40;
        r110 = "2";
    L40:
        r111 = r109.getString("chat_highlight_engine", r110);
        goto L41
    }

    public UserSettingCacheImpl() {
        UserSettingCacheManager.f313814a.getClass();
        this.f313813a = kotlinx.coroutines.flow.e.a(UserSettingCacheManager.f313818e);
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final d1<UserConfigKey> i() {
        return this.f313813a;
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final UserConfigItem b(UserConfigKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        UserSettingCacheManager.f313814a.getClass();
        return UserSettingCacheManager.j(r100);
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final void c(List<UserConfigItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "userConfigs");
        UserSettingCacheManager.o(UserSettingCacheManager.f313814a, r100, false, null, 6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final Object a(List<UserConfigItem> r100, Continuation<? super List<UserConfigItem>> r101) {
        if ((r101 instanceof UserSettingCacheImpl$syncUserConfig$1) == false) goto L7;
        UserSettingCacheImpl$syncUserConfig$1 r102 = (UserSettingCacheImpl$syncUserConfig$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        com.larus.network.http.a r107 = (com.larus.network.http.a) r104;
        if ((r107 instanceof y) == false) goto L22;
        y4 r108 = (y4) ((y) r107).f360135b;
        if (r108 == null) goto L22;
        return r108.a();
    L22:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        int r109 = UserSettingMigrateRepo.f313824a;
        r102.label = 1;
        r104 = UserSettingMigrateRepo.b(r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new UserSettingCacheImpl$syncUserConfig$1(this, r101);
        goto L8
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final Object d(String r100, boolean r101, Continuation<? super Boolean> r102) {
        UserSettingCacheManager.f313814a.getClass();
        FLogger.f375446a.w("UserSettingCacheManager", "saveAnswerWithVideo, value(" + r100 + ')');
        return UserSettingCacheManager.p(UserConfigKey.ANSWER_WITH_VIDEO, r100, r102);
    }

    @Override // com.larus.bmhome.chat.setting.IUserSettingCacheService
    public final Object h(String r100, boolean r101, Continuation<? super Boolean> r102) {
        UserSettingCacheManager.f313814a.getClass();
        return UserSettingCacheManager.m(r100, r101, r102);
    }
}
