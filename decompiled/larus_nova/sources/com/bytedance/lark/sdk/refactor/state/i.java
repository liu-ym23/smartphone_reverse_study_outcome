package com.bytedance.lark.sdk.refactor.state;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.sdk.InvokeResponse;
import com.bytedance.lark.sdk.refactor.m;
import com.bytedance.lark.sdk.refactor.q;
import com.ss.android.lark.log.Log;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes20.dex */
public final class i implements com.bytedance.lark.sdk.refactor.state.c, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f254314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile j f254315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<g> f254316c;

    public final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SdkState f254317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SdkState f254318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f254319c;

        /* JADX INFO: renamed from: com.bytedance.lark.sdk.refactor.state.i$a$a, reason: collision with other inner class name */
        public static final class C3616a<T, R> implements Function {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C3616a<T, R> f254320a = null;

            static {
                f254320a = new C3616a();
            }

            public C3616a() {
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object r100) {
                com.bytedance.lark.sdk.refactor.state.h r101 = (com.bytedance.lark.sdk.refactor.state.h) r100;
                Intrinsics.checkNotNullParameter(r101, "it");
                return Boolean.valueOf(r101.f254311a);
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f254321a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f254322b;

            public b(i r100, a r101) {
                this.f254321a = r100;
                this.f254322b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                if (((com.bytedance.lark.sdk.refactor.state.h) r100).f254311a == false) goto L6;
                i.b(this.f254321a, this.f254322b.f254317a);
                return;
            }
        }

        public static final class c<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f254323a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f254324b;

            public c(a r100, i r101) {
                this.f254323a = r100;
                this.f254324b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                SdkState r102 = this.f254323a.f254318b;
                if (r102 == null) goto L6;
                i.b(this.f254324b, r102);
                return;
            }
        }

        @Override // com.bytedance.lark.sdk.refactor.state.i.e
        public final f a(Function0<? extends Single<com.bytedance.lark.sdk.refactor.state.h>> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return new f(r100.invoke().doOnSuccess(new b(this.f254319c, this)).doOnError(new c(this, this.f254319c)).toObservable().map(C3616a.f254320a));
        }

        public a(i r100, SdkState r101, SdkState r102) {
            Intrinsics.checkNotNullParameter(r101, "nextState");
            this.f254319c = r100;
            this.f254317a = r101;
            this.f254318b = r102;
        }
    }

    public final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final StateUpdateType f254325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f254326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f254327c;

        @Override // com.bytedance.lark.sdk.refactor.state.i.e
        public final f a(Function0<? extends Single<com.bytedance.lark.sdk.refactor.state.h>> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            Log.e("RustSDK", "illegal transfer , current state = &" + this.f254327c.f254315b.a().name() + " updateStateType = " + this.f254325a.name() + " reason = " + this.f254326b);
            return new f(Observable.just(Boolean.FALSE));
        }

        public b(i r100, StateUpdateType r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "updateStateType");
            Intrinsics.checkNotNullParameter(r102, "errorMessage");
            this.f254327c = r100;
            this.f254325a = r101;
            this.f254326b = r102;
        }
    }

    public final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UpdateUserLoginStateType f254328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f254329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f254330c;

        @Override // com.bytedance.lark.sdk.refactor.state.i.e
        public final f a(Function0<? extends Single<com.bytedance.lark.sdk.refactor.state.h>> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            Log.e("RustSDK", "illegal transfer , current state = &" + this.f254330c.f254315b.a().name() + " updateStateType = " + this.f254328a.name() + " reason = " + this.f254329b);
            return new f(Observable.just(Boolean.FALSE));
        }

        public c(i r100, UpdateUserLoginStateType r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "updateStateType");
            Intrinsics.checkNotNullParameter(r102, "errorMessage");
            this.f254330c = r100;
            this.f254328a = r101;
            this.f254329b = r102;
        }
    }

    public final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f254331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LoginState f254332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LoginState f254333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SdkState f254334d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SdkState f254335e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ i f254336f;

        public static final class a<T, R> implements Function {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T, R> f254337a = null;

            static {
                f254337a = new a();
            }

            public a() {
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object r100) {
                com.bytedance.lark.sdk.refactor.state.h r101 = (com.bytedance.lark.sdk.refactor.state.h) r100;
                Intrinsics.checkNotNullParameter(r101, "it");
                return Boolean.valueOf(r101.f254311a);
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f254338a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f254339b;

            public b(d r100, i r101) {
                this.f254338a = r100;
                this.f254339b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                com.bytedance.lark.sdk.refactor.state.h r101 = (com.bytedance.lark.sdk.refactor.state.h) r100;
                if (r101.f254311a == false) goto L8;
                SdkState r102 = this.f254338a.f254334d;
                if (r102 == null) goto L8;
                i.b(this.f254339b, r102);
            L8:
                if (r101.f254311a == false) goto L11;
                d r103 = this.f254338a;
                String r104 = r103.f254331a;
                LoginState r105 = r103.f254332b;
                Long r106 = r101.f254312b;
                Long r107 = r101.f254313c;
                this.f254339b.f(r104, r105, r106, r107);
                return;
            }
        }

        public static final class c<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f254340a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i f254341b;

            public c(d r100, i r101) {
                this.f254340a = r100;
                this.f254341b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                SdkState r102 = this.f254340a.f254335e;
                if (r102 == null) goto L5;
                i.b(this.f254341b, r102);
            L5:
                i r103 = this.f254341b;
                d r104 = this.f254340a;
                r103.f(r104.f254331a, r104.f254333c, null, null);
            }
        }

        @Override // com.bytedance.lark.sdk.refactor.state.i.e
        public final f a(Function0<? extends Single<com.bytedance.lark.sdk.refactor.state.h>> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return new f(r100.invoke().doOnSuccess(new b(this, this.f254336f)).doOnError(new c(this, this.f254336f)).toObservable().map(a.f254337a));
        }

        public /* synthetic */ d(i r100, String r101, LoginState r110, LoginState r111) {
            this(r100, r101, r110, r111, null, null);
        }

        public d(i r100, String r101, LoginState r102, LoginState r103, SdkState r104, SdkState r105) {
            Intrinsics.checkNotNullParameter(r101, "uid");
            Intrinsics.checkNotNullParameter(r102, "nextLoginState");
            Intrinsics.checkNotNullParameter(r103, "fallbackLoginState");
            this.f254336f = r100;
            this.f254331a = r101;
            this.f254332b = r102;
            this.f254333c = r103;
            this.f254334d = r104;
            this.f254335e = r105;
        }
    }

    public static abstract class e {
        public e() {
        }

        public abstract f a(Function0<? extends Single<com.bytedance.lark.sdk.refactor.state.h>> r100);
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observable<Boolean> f254342a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f254342a, ((f) r100).f254342a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f254342a.hashCode();
        }

        public final String toString() {
            return "TransferData(job=" + this.f254342a + ')';
        }

        public f(Observable<Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "job");
            this.f254342a = r100;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f254343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LoginState f254344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f254345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f254346d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f254343a, r101.f254343a) == true) goto L12;
            return false;
        L12:
            if (this.f254344b == r101.f254344b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f254345c, r101.f254345c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f254346d, r101.f254346d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f254343a.hashCode() * 31) + this.f254344b.hashCode()) * 31;
            Long r101 = this.f254345c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Long r105 = this.f254346d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "UserLoginStateContext(userId=" + this.f254343a + ", loginState=" + this.f254344b + ", destinationContainerId=" + this.f254345c + ", userContainerId=" + this.f254346d + ')';
        }

        public g(String r100, LoginState r101, Long r102, Long r103) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            Intrinsics.checkNotNullParameter(r101, "loginState");
            this.f254343a = r100;
            this.f254344b = r101;
            this.f254345c = r102;
            this.f254346d = r103;
        }
    }

    public /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f254347a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f254348b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f254349c = null;

        static {
            int[] r100 = new int[SdkState.values().length];
            r100[SdkState.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L44:
            r100[SdkState.INIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L60:
            r100[SdkState.ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L46:
            r100[SdkState.OFFLINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L10:
            f254347a = r100;
            int[] r101 = new int[UpdateUserLoginStateType.values().length];
            r101[UpdateUserLoginStateType.FOREGROUND_ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L50:
            r101[UpdateUserLoginStateType.SWITCH_FOREGROUND_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L36:
            r101[UpdateUserLoginStateType.BACKGROUND_ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L48:
            r101[UpdateUserLoginStateType.FOREGROUND_OFFLINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L40:
            r101[UpdateUserLoginStateType.SWITCH_BACKGROUND_ONLINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L52:
            r101[UpdateUserLoginStateType.BACKGROUND_OFFLINE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L17:
            f254348b = r101;
            int[] r102 = new int[StateUpdateType.values().length];
            r102[StateUpdateType.INIT_SDK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L42:
            r102[StateUpdateType.MAKE_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L54:
            r102[StateUpdateType.MAKE_OFFLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L21:
            f254349c = r102;
        }
    }

    @Inject
    public i(m r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f254314a = r100;
        this.f254315b = c(SdkState.NONE);
        this.f254316c = new ArrayList();
    }

    @Override // com.bytedance.lark.sdk.refactor.state.c
    public final Long a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        List<g> r101 = this.f254316c;
        monitor-enter(r101);
        Iterator<T> r102 = this.f254316c.iterator();     // Catch: Throwable -> L16
    L5:
        Long r103 = null;
        if (r102.hasNext() == false) goto L10;
        Object r104 = r102.next();     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(((g) r104).f254343a, r100) == false) goto L5;
    L11:
        g r105 = (g) r104;     // Catch: Throwable -> L16
        if (r105 == null) goto L14;
        r103 = r105.f254345c;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);
        return r103;
    L10:
        r104 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public final j c(SdkState r100) {
        int r101 = h.f254347a[r100.ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 != 4) goto L12;
        return new com.bytedance.lark.sdk.refactor.state.f(this.f254314a);
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return new com.bytedance.lark.sdk.refactor.state.g(this.f254314a);
    L19:
        return new com.bytedance.lark.sdk.refactor.state.d(this.f254314a);
    L16:
        return new com.bytedance.lark.sdk.refactor.state.e(this.f254314a);
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final void j(se6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        this.f254315b.j(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final int p(InitSDKRequest.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "requestBuilder");
        return this.f254315b.p(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final InvokeResponse r(se6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return this.f254315b.r(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void v(q r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f254315b.v(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.h
    public final void y(com.bytedance.lark.sdk.refactor.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f254315b.y(r100);
    }

    public static final void b(i r100, SdkState r101) {
        monitor-enter(r100);
        r100.f254315b = r100.c(r101);     // Catch: Throwable -> L7
        Log.i("RustSDK", "sdk state : " + r100.f254315b.a());     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.lark.sdk.refactor.l
    public final int l(String r100, byte[] r101) {
        return this.f254315b.l(r100, r101);
    }

    public final Observable<Boolean> h(String r110, UpdateUserLoginStateType r111, Function0<? extends Single<com.bytedance.lark.sdk.refactor.state.h>> r112) {
        Intrinsics.checkNotNullParameter(r110, "uid");
        Intrinsics.checkNotNullParameter(r111, "loginStateUpdateType");
        Intrinsics.checkNotNullParameter(r112, WikiFolderPushPlugin.OPT);
        switch(h.f254348b[r111.ordinal()]) {
            case 1: goto L71;
            case 2: goto L58;
            case 3: goto L45;
            case 4: goto L32;
            case 5: goto L19;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        j r113 = this.f254315b;
        if ((r113 instanceof com.bytedance.lark.sdk.refactor.state.e) == false) goto L10;
        e r114 = new c(this, UpdateUserLoginStateType.BACKGROUND_OFFLINE, "sdk not init");
    L86:
        return r114.a(r112).f254342a;
    L10:
        if ((r113 instanceof com.bytedance.lark.sdk.refactor.state.d) == false) goto L13;
        r114 = new c(this, UpdateUserLoginStateType.BACKGROUND_OFFLINE, "not has user foreground online yet");
        goto L86
    L13:
        if ((r113 instanceof com.bytedance.lark.sdk.refactor.state.g) == false) goto L15;
    L18:
        LoginState r100 = LoginState.OFFLINE;
        d r115 = new d(this, r110, r100, r100);
    L84:
        r114 = r115;
        goto L86
    L15:
        if ((r113 instanceof com.bytedance.lark.sdk.refactor.state.f) == true) goto L18;
        r114 = new b(this, StateUpdateType.MAKE_OFFLINE, "error transfer");
        goto L86
    L19:
        j r116 = this.f254315b;
        if ((r116 instanceof com.bytedance.lark.sdk.refactor.state.e) == false) goto L23;
        r114 = new c(this, UpdateUserLoginStateType.SWITCH_BACKGROUND_ONLINE, "sdk not init");
        goto L86
    L23:
        if ((r116 instanceof com.bytedance.lark.sdk.refactor.state.d) == false) goto L25;
    L31:
        r114 = new c(this, UpdateUserLoginStateType.SWITCH_BACKGROUND_ONLINE, "not has foreground user online yet");
        goto L86
    L25:
        if ((r116 instanceof com.bytedance.lark.sdk.refactor.state.f) == true) goto L31;
        if ((r116 instanceof com.bytedance.lark.sdk.refactor.state.g) == false) goto L30;
        LoginState r101 = LoginState.BACKGROUND;
        LoginState r102 = LoginState.OFFLINE;
        SdkState r103 = SdkState.OFFLINE;
        r115 = new d(this, r110, r101, r102, r103, r103);
        goto L84
    L30:
        r114 = new b(this, StateUpdateType.MAKE_OFFLINE, "error transfer");
        goto L86
    L32:
        j r117 = this.f254315b;
        if ((r117 instanceof com.bytedance.lark.sdk.refactor.state.e) == false) goto L36;
        r114 = new b(this, StateUpdateType.MAKE_ONLINE, "sdk not init");
        goto L86
    L36:
        if ((r117 instanceof com.bytedance.lark.sdk.refactor.state.d) == false) goto L39;
        r114 = new b(this, StateUpdateType.MAKE_OFFLINE, "not has foreground user online yet");
        goto L86
    L39:
        if ((r117 instanceof com.bytedance.lark.sdk.refactor.state.g) == false) goto L41;
    L44:
        LoginState r104 = LoginState.OFFLINE;
        SdkState r105 = SdkState.OFFLINE;
        r115 = new d(this, r110, r104, r104, r105, r105);
        goto L84
    L41:
        if ((r117 instanceof com.bytedance.lark.sdk.refactor.state.f) == true) goto L44;
        r114 = new b(this, StateUpdateType.MAKE_OFFLINE, "error transfer");
        goto L86
    L45:
        j r118 = this.f254315b;
        if ((r118 instanceof com.bytedance.lark.sdk.refactor.state.e) == false) goto L49;
        r114 = new c(this, UpdateUserLoginStateType.BACKGROUND_ONLINE, "sdk not init");
        goto L86
    L49:
        if ((r118 instanceof com.bytedance.lark.sdk.refactor.state.d) == false) goto L51;
    L57:
        r115 = new d(this, r110, LoginState.BACKGROUND, LoginState.OFFLINE);
        goto L84
    L51:
        if ((r118 instanceof com.bytedance.lark.sdk.refactor.state.g) == true) goto L57;
        if ((r118 instanceof com.bytedance.lark.sdk.refactor.state.f) == false) goto L56;
        r114 = new c(this, UpdateUserLoginStateType.BACKGROUND_ONLINE, "not has user foreground online yet");
        goto L86
    L56:
        r114 = new c(this, UpdateUserLoginStateType.BACKGROUND_ONLINE, "error transfer");
        goto L86
    L58:
        j r119 = this.f254315b;
        if ((r119 instanceof com.bytedance.lark.sdk.refactor.state.e) == false) goto L62;
        r114 = new c(this, UpdateUserLoginStateType.SWITCH_FOREGROUND_ONLINE, "sdk not init");
        goto L86
    L62:
        if ((r119 instanceof com.bytedance.lark.sdk.refactor.state.d) == false) goto L65;
        r114 = new c(this, UpdateUserLoginStateType.SWITCH_FOREGROUND_ONLINE, "not has user foreground online yet");
        goto L86
    L65:
        if ((r119 instanceof com.bytedance.lark.sdk.refactor.state.g) == false) goto L68;
        r114 = new c(this, UpdateUserLoginStateType.SWITCH_FOREGROUND_ONLINE, "already foreground online");
        goto L86
    L68:
        if ((r119 instanceof com.bytedance.lark.sdk.refactor.state.f) == false) goto L70;
        r115 = new d(this, r110, LoginState.FOREGROUND, LoginState.OFFLINE, SdkState.ONLINE, SdkState.OFFLINE);
        goto L84
    L70:
        r114 = new b(this, StateUpdateType.MAKE_ONLINE, "error transfer");
        goto L86
    L71:
        j r120 = this.f254315b;
        if ((r120 instanceof com.bytedance.lark.sdk.refactor.state.e) == false) goto L75;
        r114 = new b(this, StateUpdateType.MAKE_ONLINE, "sdk not init");
        goto L86
    L75:
        if ((r120 instanceof com.bytedance.lark.sdk.refactor.state.d) == false) goto L77;
    L83:
        r115 = new d(this, r110, LoginState.FOREGROUND, LoginState.OFFLINE, SdkState.ONLINE, SdkState.OFFLINE);
        goto L84
    L77:
        if ((r120 instanceof com.bytedance.lark.sdk.refactor.state.f) == true) goto L83;
        if ((r120 instanceof com.bytedance.lark.sdk.refactor.state.g) == false) goto L82;
        r114 = new b(this, StateUpdateType.MAKE_ONLINE, "already has user foreground online");
        goto L86
    L82:
        r114 = new b(this, StateUpdateType.MAKE_ONLINE, "error transfer");
        goto L86
    L5:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.bytedance.lark.sdk.refactor.state.i$g, java.lang.Object] */
    public final void f(String r100, LoginState r101, Long r102, Long r103) {
        List<g> r104 = this.f254316c;
        monitor-enter(r104);
        Ref.ObjectRef r105 = new Ref.ObjectRef();     // Catch: Throwable -> L19
        Iterator r106 = ((ArrayList) this.f254316c).iterator();     // Catch: Throwable -> L19
    L6:
        if (r106.hasNext() == false) goto L10;
        Object r107 = r106.next();     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(((g) r107).f254343a, r100) == false) goto L6;
        T r108 = r107;
    L11:
        r105.element = r108;     // Catch: Throwable -> L19
        if (r108 != 0) goto L14;
        ?? r109 = new g(r100, r101, r102, r103);     // Catch: Throwable -> L19
        r105.element = r109;     // Catch: Throwable -> L19
        ((ArrayList) this.f254316c).add(r109);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r104);
        return;
    L14:
        Intrinsics.checkNotNullParameter(r101, "<set-?>");     // Catch: Throwable -> L19
        ((g) r108).f254344b = r101;     // Catch: Throwable -> L19
        if (r102 == null) goto L17;
        long r110 = r102.longValue();     // Catch: Throwable -> L19
        g r111 = (g) r105.element;     // Catch: Throwable -> L19
        r111.f254345c = Long.valueOf(r110);     // Catch: Throwable -> L19
        ((g) r105.element).f254346d = r103;     // Catch: Throwable -> L19
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L19
        goto L17
    L10:
        r108 = 0;
    L19:
        th = move-exception;
        throw th;
    }
}
