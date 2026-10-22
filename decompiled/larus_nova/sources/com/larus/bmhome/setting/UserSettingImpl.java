package com.larus.bmhome.setting;

import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.model.repo.IUserSettingRepoService;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.setting.bean.UserConfigPullReason;
import com.larus.platform.model.UserConfigItem;
import com.larus.utils.logger.FLogger;
import hq9.y4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J.\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0010H\u0016J\u000f\u0010!\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\"J\n\u0010#\u001a\u0004\u0018\u00010\rH\u0016¨\u0006$"}, d2 = {"Lcom/larus/bmhome/setting/UserSettingImpl;", "Lcom/larus/bmhome/chat/model/repo/IUserSettingRepoService;", "<init>", "()V", "init", "", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", "", "", "reason", "source", "", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateDenoiseTrainAuthorizeUserConfig", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMainBotTtsSwitch", "cvsId", "openTts", "getMainTtsSwitch", "setGlobalTtsSwitch", "setBotTtsSwitch", "getGlobalTtsSwitch", "getTtsSwitch", "hasSetTts", "setTts", "getMainBotUserChangedTtsSwitch", "setGlobalUserChangedTtsSwitch", "switch", "getGlobalUserChangedTtsSwitch", "saveIsInCvsList", "isInCvsList", "()Ljava/lang/Boolean;", "getCvsId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserSettingImpl implements IUserSettingRepoService {
    public UserSettingImpl() {
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final String Y1() {
        UserSettingRepo r100 = UserSettingRepo.f313819a;
        return UserSettingRepo.a();
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final int b() {
        UserSettingRepo r100 = UserSettingRepo.f313819a;
        Keva r101 = UserSettingRepo.c();
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.getInt("bot_global_tts_switch", -1);
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final Boolean c() {
        UserSettingRepo r100 = UserSettingRepo.f313819a;
        return UserSettingRepo.b();
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void init() {
        UserSettingRepo.f313819a.getClass();
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final int a(String r100) {
        UserSettingRepo r101 = UserSettingRepo.f313819a;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        EnsureManager.ensureNotReachHere("cvs id is null please check code !!!");
        return -1;
    L12:
        Keva r103 = UserSettingRepo.c();
        if (r103 != null) goto L15;
        return -1;
    L15:
        return r103.getInt("bot_tts_switch_" + r100, -1);
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final int d(String r100) {
        UserSettingRepo r101 = UserSettingRepo.f313819a;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        FLogger.f375446a.e("SettingRepo", "cvs id is null please check code !!!");
        return -1;
    L12:
        Keva r103 = UserSettingRepo.c();
        if (r103 != null) goto L15;
        return -1;
    L15:
        return r103.getInt("bot_tts_switch_" + r100, -1);
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final Object g(Continuation<? super Boolean> r100) {
        if ((r100 instanceof UserSettingImpl$requireUpdateDenoiseTrainAuthorizeUserConfig$1) == false) goto L7;
        UserSettingImpl$requireUpdateDenoiseTrainAuthorizeUserConfig$1 r101 = (UserSettingImpl$requireUpdateDenoiseTrainAuthorizeUserConfig$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        y4 r106 = (y4) r103;
        if (r106 == null) goto L24;
        ArrayList<UserConfigItem> r107 = r106.a();
        if (r107 == null) goto L24;
        UserSettingCacheManager.o(UserSettingCacheManager.f313814a, r107, false, null, 6);
        return Boxing.boxBoolean(true);
    L24:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        List<Integer> r108 = CollectionsKt.listOf(Boxing.boxInt(UserConfigKey.REALTIME_VOICE_FEATURE.getValue()));
        int r109 = UserConfigPullReason.NOTIFIED.getValue();
        r101.label = 1;
        r103 = e(r108, r109, "denoise", r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new UserSettingImpl$requireUpdateDenoiseTrainAuthorizeUserConfig$1(this, r100);
        goto L8
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void i(int r100) {
        UserSettingRepo r101 = UserSettingRepo.f313819a;
        Keva r102 = UserSettingRepo.c();
        if (r102 == null) goto L6;
        r102.storeInt("bot_global_tts_switch", r100);
        return;
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void f(String r100, int r101) {
        UserSettingRepo r102 = UserSettingRepo.f313819a;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        EnsureManager.ensureNotReachHere("cvs id is null please check code !!!");
    L11:
        Keva r104 = UserSettingRepo.c();
        if (r104 == null) goto L15;
        r104.storeInt("bot_tts_switch_" + r100, r101);
        return;
    L15:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final void h(String r100, int r101) {
        UserSettingRepo r102 = UserSettingRepo.f313819a;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        EnsureManager.ensureNotReachHere("cvs id is null please check code !!!");
    L11:
        Keva r104 = UserSettingRepo.c();
        if (r104 == null) goto L15;
        r104.storeInt("bot_tts_switch_" + r100, r101);
        return;
    L15:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.larus.bmhome.chat.model.repo.IUserSettingRepoService
    public final Object e(List<Integer> r100, int r101, String r102, Continuation<? super y4> r103) {
        return UserSettingRepo.f313819a.d(r100, r101, r102, r103);
    }
}
