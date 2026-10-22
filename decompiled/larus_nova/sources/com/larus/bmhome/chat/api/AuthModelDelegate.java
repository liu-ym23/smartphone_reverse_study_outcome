package com.larus.bmhome.chat.api;

import androidx.lifecycle.LiveData;
import com.larus.bmhome.auth.LaunchBiz;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.c1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u000b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\u001f\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0096\u0001J'\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J!\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0096\u0001J!\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0096\u0001J)\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\t\u0010!\u001a\u00020\u0013H\u0096\u0001J\u001d\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0001J\u001e\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020$H\u0096A¢\u0006\u0002\u0010*J\u001d\u0010+\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010\u00152\b\u0010-\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0013\u0010.\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u00010$H\u0096\u0001J\u0013\u00100\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010&H\u0096\u0001R\u001a\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010403X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00106R\u0018\u00107\u001a\b\u0012\u0004\u0012\u00020803X\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u00106R\u001e\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0;03X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u00106R\u001e\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0;03X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u00106R\u001e\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;03X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u00106R\u001e\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0;03X\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u00106R\u001e\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0;03X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u00106R\u001e\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0;03X\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u00106R\u001e\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0;03X\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u00106R\u001e\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0;03X\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u00106R\u001a\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$03X\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u00106R\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020N03X\u0096\u0005¢\u0006\u0006\u001a\u0004\bO\u00106R\u001a\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&03X\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u00106R\u001a\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&03X\u0096\u0005¢\u0006\u0006\u001a\u0004\bS\u00106¨\u0006T"}, d2 = {"Lcom/larus/bmhome/chat/api/AuthModelDelegate;", "Lcom/larus/bmhome/chat/api/IAuthModelService;", "<init>", "()V", "advancedWhiteEnabled", "", "advancedWhiteEnabledInCici", "appIconEditEnable", "getAudioLaunchForConsumer", "Lcom/larus/bmhome/auth/AudioLaunchInfo;", "getBasicLaunchForConsumer", "Lcom/larus/bmhome/auth/BasicLaunchInfo;", "getCoreLaunchForConsumer", "Lcom/larus/bmhome/auth/CoreLaunchInfo;", "getIMLaunchForConsumer", "Lcom/larus/bmhome/auth/IMLaunchInfo;", "isAdvancedWhiteUserOrDebugEntranceEnable", "isEnablePromptDetail", "requestAppLaunch", "", "from", "", "requestColdStartLaunchAfterFirstFeed", "bizSet", "", "Lcom/larus/bmhome/auth/LaunchBiz;", "requestLaunch", "isForce", "requestLaunchCore", "forceRequestIgnoreStatus", "requestLaunchInfo", "scene", "Lcom/larus/bmhome/chat/api/LaunchRequestScene;", "resetInfo", "saveCache", "launchInfo", "Lcom/larus/bmhome/auth/LaunchInfo;", "conversationInfo", "Lcom/larus/im/bean/conversation/Conversation;", "socialDefaultConversationRequest", "metricType", "launchData", "(Ljava/lang/String;Lcom/larus/bmhome/auth/LaunchInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversationModeDefaultKeys", "defaultNewChatModeKey", "defaultNewOfficeModeKey", "updateLaunchInfoCache", "newData", "updateMainBotConversationInfo", "cvsInfo", "appLaunchInfoDataWithCache", "Landroidx/lifecycle/LiveData;", "Lcom/larus/bmhome/auth/AppLaunchInfo;", "getAppLaunchInfoDataWithCache", "()Landroidx/lifecycle/LiveData;", "appLaunchInfoWithStatusLiveData", "Lcom/larus/bmhome/chat/api/AppLaunchInfoWithStatus;", "getAppLaunchInfoWithStatusLiveData", "audioLaunchForConsumerLiveData", "Lcom/larus/bmhome/auth/LaunchResult;", "getAudioLaunchForConsumerLiveData", "audioLaunchWithStatusLiveData", "getAudioLaunchWithStatusLiveData", "basicLaunchForConsumerLiveData", "getBasicLaunchForConsumerLiveData", "basicLaunchWithStatusLiveData", "getBasicLaunchWithStatusLiveData", "coreLaunchForConsumerLiveData", "getCoreLaunchForConsumerLiveData", "coreLaunchWithStatusLiveData", "getCoreLaunchWithStatusLiveData", "imLaunchForConsumerLiveData", "getImLaunchForConsumerLiveData", "imLaunchWithStatusLiveData", "getImLaunchWithStatusLiveData", "launchInfoDataWithCache", "getLaunchInfoDataWithCache", "launchInfoWithStatusLiveData", "Lcom/larus/bmhome/chat/api/LaunchInfoWithStatus;", "getLaunchInfoWithStatusLiveData", "mainBotConversationInfo", "getMainBotConversationInfo", "mainBotConversationInfoWithCache", "getMainBotConversationInfoWithCache", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthModelDelegate implements IAuthModelService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AuthModelDelegate f297134b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAuthModelService f297135a;

    static {
        f297134b = new AuthModelDelegate();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<com.larus.bmhome.auth.a> A() {
        return this.f297135a.A();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<c1<com.larus.bmhome.auth.j0>> B() {
        return this.f297135a.B();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final com.larus.bmhome.auth.j0 C() {
        return this.f297135a.C();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final com.larus.bmhome.auth.e0 D() {
        return this.f297135a.D();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<c1<com.larus.bmhome.auth.b>> E() {
        return this.f297135a.E();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final void F(String r100, Set<? extends LaunchBiz> r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "bizSet");
        this.f297135a.F(r100, r101);
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final Object G(LaunchInfo r100, Continuation r101) {
        return this.f297135a.G(r100, r101);
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<c1<com.larus.bmhome.auth.h0>> H() {
        return this.f297135a.H();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<c1<com.larus.bmhome.auth.h0>> a() {
        return this.f297135a.a();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final boolean b() {
        return this.f297135a.b();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<c1<com.larus.bmhome.auth.e0>> c() {
        return this.f297135a.c();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final boolean d() {
        return this.f297135a.d();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<e0> e() {
        return this.f297135a.e();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final void f(wc9.e r100) {
        this.f297135a.f(r100);
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final boolean g() {
        return this.f297135a.g();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final void h(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f297135a.h(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<c1<com.larus.bmhome.auth.j0>> i() {
        return this.f297135a.i();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<c1<com.larus.bmhome.auth.b>> j() {
        return this.f297135a.j();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final void k(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.f297135a.k(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<c1<com.larus.bmhome.auth.e0>> l() {
        return this.f297135a.l();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<a> m() {
        return this.f297135a.m();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final void n() {
        this.f297135a.n();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final com.larus.bmhome.auth.b o() {
        return this.f297135a.o();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final void p(String r100, String r101) {
        this.f297135a.p(r100, r101);
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final void q(String r100, boolean r101, LaunchRequestScene r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f297135a.q(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final void r(LaunchInfo r100, wc9.e r101) {
        this.f297135a.r(r100, null);
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final boolean s() {
        return this.f297135a.s();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final void t(String r100, Set<? extends LaunchBiz> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "bizSet");
        this.f297135a.t(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<wc9.e> u() {
        return this.f297135a.u();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final com.larus.bmhome.auth.h0 v() {
        return this.f297135a.v();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter("Main_setupLaunchInfo", "from");
        this.f297135a.w("Main_setupLaunchInfo");
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<LaunchInfo> x() {
        return this.f297135a.x();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final LiveData<wc9.e> y() {
        return this.f297135a.y();
    }

    @Override // com.larus.bmhome.chat.api.IAuthModelService
    public final boolean z() {
        return this.f297135a.z();
    }

    private AuthModelDelegate() {
        IAuthModelService r100 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r100 != null) goto L5;
        r100 = new AuthModelServiceNoop();
    L5:
        this.f297135a = r100;
    }
}
