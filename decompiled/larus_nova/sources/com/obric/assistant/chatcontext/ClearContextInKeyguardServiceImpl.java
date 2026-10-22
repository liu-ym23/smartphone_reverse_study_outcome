package com.obric.assistant.chatcontext;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IClearContextInKeyguardService;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.interaction.api.IKeyguardState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.n;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import lha.f;
import uc9.t;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0016\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/chatcontext/ClearContextInKeyguardServiceImpl;", "Lcom/obric/assistant/IClearContextInKeyguardService;", "<init>", "()V", "isNeedCheckClearContextWhenComeToForeground", "", "isNeedClearContextOnKeyguard", "isAuthenticationPassedOnceWhenForeground", "keyguardState", "Lcom/obric/assistant/interaction/api/IKeyguardState;", "getKeyguardState", "()Lcom/obric/assistant/interaction/api/IKeyguardState;", "keyguardState$delegate", "Lkotlin/Lazy;", "sessionAuthenticationService", "Lcom/obric/assistant/ISessionAuthenticationService;", "getSessionAuthenticationService", "()Lcom/obric/assistant/ISessionAuthenticationService;", "sessionAuthenticationService$delegate", "isClearContextFeatureEnabled", "init", "", "updateClearContextStateWhenDeviceLockedStateChanged", "isDeviceLocked", "clearContext", "conversationId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldClearContextOnKeyguard", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClearContextInKeyguardServiceImpl implements IClearContextInKeyguardService {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f386990f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f386991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f386992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f386993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f386994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f386995e;

    public static final class a {
    }

    public static final class b implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClearContextInKeyguardServiceImpl f386996a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            FLogger r100 = FLogger.f375446a;
            r100.i("ClearContextInKeyguardServiceImpl", "onAppBackground");
            if (this.f386996a.f386993c == false) goto L5;
        L6:
            r100.i("ClearContextInKeyguardServiceImpl", "set isNeedCheckClearContextWhenComeToForeground");
            this.f386996a.f386991a = true;
            return;
        L5:
            if (this.f386996a.f386992b == true) goto L6;
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            FLogger r100 = FLogger.f375446a;
            r100.i("ClearContextInKeyguardServiceImpl", "onAppForeground: isNeedCheckClearContextOnForeground = " + this.f386996a.f386991a);
            IKeyguardState r101 = (IKeyguardState) this.f386996a.f386994d.getValue();
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L17;
            IKeyguardState r103 = (IKeyguardState) this.f386996a.f386994d.getValue();
            if (r103 != null) goto L12;
        L14:
            boolean r104 = false;
        L15:
            if (r104 == false) goto L17;
            boolean r105 = true;
        L18:
            int r106 = t1.f393353a.Q1();
            r100.i("ClearContextInKeyguardServiceImpl", "onAppForeground: isLocked = " + r105 + ", authenticationType: " + r106);
            if (r106 == 0) goto L24;
            if (r106 == 3) goto L24;
        L27:
            this.f386996a.f386991a = false;
            this.f386996a.f386993c = false;
            return;
        L24:
            if (this.f386996a.f386991a == false) goto L27;
            if (r105 == false) goto L27;
            this.f386996a.f386992b = true;
            goto L27
        L12:
            if (r103.isDeviceLocked() != true) goto L14;
            r104 = true;
        L17:
            r105 = false;
            goto L18
        L5:
            if (r101.isKeyguardLocked() != true) goto L7;
            r102 = true;
            goto L8
        }

        public b(ClearContextInKeyguardServiceImpl r100) {
            this.f386996a = r100;
        }
    }

    public static final class c implements lha.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClearContextInKeyguardServiceImpl f386997a;

        public c(ClearContextInKeyguardServiceImpl r100) {
            this.f386997a = r100;
        }

        @Override // lha.d
        public final void onChange(boolean r100) {
            FLogger.f375446a.i("ClearContextInKeyguardServiceImpl", "onDeviceLockedStateChanged: isDeviceLocked = " + r100);
            ClearContextInKeyguardServiceImpl r101 = this.f386997a;
            if (r100 == false) goto L5;
            r101.f386991a = true;
            return;
        L5:
            r101.f386991a = false;
            r101.f386992b = false;
        }
    }

    public static final class d implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClearContextInKeyguardServiceImpl f386998a;

        public d(ClearContextInKeyguardServiceImpl r100) {
            this.f386998a = r100;
        }

        @Override // com.obric.assistant.n
        public final void a(boolean r100) {
            if (r100 == true) goto L4;
            return;
        L4:
            if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L6;
            return;
        L6:
            if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L13;
            FLogger.f375446a.i("ClearContextInKeyguardServiceImpl", "is authentication pass");
            if (t1.f393353a.Q1() == 3) goto L14;
            this.f386998a.f386992b = false;
            this.f386998a.f386993c = true;
            return;
        L14:
            return;
        }
    }

    static {
    }

    @Override // com.obric.assistant.IClearContextInKeyguardService
    public final boolean b() {
        FLogger r100 = FLogger.f375446a;
        r100.i("ClearContextInKeyguardServiceImpl", "shouldClearContextOnKeyguard, " + this.f386992b + ", " + this.f386991a);
        IKeyguardState r101 = (IKeyguardState) this.f386994d.getValue();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        return false;
    L10:
        ISessionAuthenticationService r103 = (ISessionAuthenticationService) this.f386995e.getValue();
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == true) goto L18;
    L20:
        t1 r105 = t1.f393353a;
        if (r105.i() == true) goto L24;
        r100.i("ClearContextInKeyguardServiceImpl", "isClearContextFeatureEnabled: isLockedScreenUseEnabled = false");
    L26:
        boolean r106 = false;
    L27:
        if (r106 == true) goto L30;
        return false;
    L30:
        if (this.f386992b == false) goto L32;
    L35:
        return true;
    L32:
        if (this.f386991a == true) goto L35;
        return false;
    L24:
        if (r105.Q1() == 2) goto L26;
        r100.i("ClearContextInKeyguardServiceImpl", "isClearContextFeatureEnabled: accessChatHistoryNeedAuthentication = true");
        r106 = true;
        goto L27
    L18:
        if (t1.f393353a.Q1() == 3) goto L20;
        return false;
    L13:
        if (r103.isAuthenticationPass() != true) goto L15;
        r104 = true;
        goto L16
    L5:
        if (r101.isDeviceLocked() == true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.obric.assistant.IClearContextInKeyguardService
    public final void init() {
        AppHost.f326268a.a().j(new b(this));
        f.a().a(new c(this));
        ISessionAuthenticationService r100 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r100 == null) goto L6;
        r100.h(new d(this));
        return;
    }

    public ClearContextInKeyguardServiceImpl() {
        this.f386991a = true;
        this.f386994d = LazyKt.lazy(new com.obric.assistant.chatcontext.a());
        this.f386995e = LazyKt.lazy(new com.obric.assistant.chatcontext.b());
    }

    @Override // com.obric.assistant.IClearContextInKeyguardService
    public final Object a(String r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof ClearContextInKeyguardServiceImpl$clearContext$1) == false) goto L7;
        ClearContextInKeyguardServiceImpl$clearContext$1 r102 = (ClearContextInKeyguardServiceImpl$clearContext$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
    L19:
        Object r108 = Result.m9449constructorimpl((ub8.b) r104);     // Catch: Throwable -> L21
    L23:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L26;
        FLogger.f375446a.e("ClearContextInKeyguardServiceImpl", "clearContextWhenLaunchInKeyguard clear context failed", r109);
    L26:
        boolean r110 = false;
        if (Result.m9456isSuccessimpl(r108) == false) goto L41;
        ub8.b r111 = (ub8.b) r108;
        FLogger r112 = FLogger.f375446a;
        StringBuilder r113 = new StringBuilder("clearContext: success = ");
        t r114 = r111.f549370a;
        if (r114 == null) goto L31;
        Boolean r115 = Boxing.boxBoolean(r114.f549696a);
    L32:
        r113.append(r115);
        r113.append(", error = ");
        r113.append(r111.f549372c);
        r112.i("ClearContextInKeyguardServiceImpl", r113.toString());
        t r116 = r111.f549370a;
        if (r116 != null) goto L35;
    L37:
        r107 = false;
    L38:
        if (r107 == false) goto L41;
        this.f386992b = false;
        this.f386991a = false;
        goto L41
    L35:
        if (r116.f549696a != true) goto L37;
    L31:
        r115 = null;
    L41:
        if (Result.m9455isFailureimpl(r108) == false) goto L43;
        r108 = null;
    L43:
        ub8.b r117 = (ub8.b) r108;
        if (r117 == null) goto L49;
        t r118 = r117.f549370a;
        if (r118 == null) goto L49;
        r110 = r118.f549696a;
    L49:
        return Boxing.boxBoolean(r110);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        FLogger.f375446a.i("ClearContextInKeyguardServiceImpl", "clearContext: conversationId = " + r100);
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L21
        IChatRepoService r120 = zh8.a.f572196a;     // Catch: Throwable -> L21
        IConversationRepoService r121 = zh8.a.f572197b;     // Catch: Throwable -> L21
        r102.label = 1;     // Catch: Throwable -> L21
        r104 = r121.n(r100, 3, "launch_in_keyguard_locked", r102);     // Catch: Throwable -> L21
        if (r104 != r105) goto L19;
        return r105;
    L21:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new ClearContextInKeyguardServiceImpl$clearContext$1(this, r101);
        goto L8
    }
}
