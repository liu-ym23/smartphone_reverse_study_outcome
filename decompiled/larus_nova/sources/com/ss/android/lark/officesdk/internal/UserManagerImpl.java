package com.ss.android.lark.officesdk.internal;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.ILoginCallback;
import com.ss.android.lark.officesdk.api.ILogoutCallback;
import com.ss.android.lark.officesdk.api.IOfficeSDKHostSessionProvider;
import com.ss.android.lark.officesdk.api.IOfficeSDKUserHandle;
import com.ss.android.lark.officesdk.api.IOnlineOfflineService;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.OfficeSDKDriveErrorCodes;
import com.ss.android.lark.officesdk.api.OfficeSDKDriveResult;
import com.ss.android.lark.officesdk.api.OfficeSDKHostSession;
import com.ss.android.lark.officesdk.api.OfficeSDKPassportUserAction;
import com.ss.android.lark.officesdk.api.OfficeSDKUserAccessException;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKUserServiceInjector;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.statistics.Statistics;
import dagger.hilt.EntryPoints;
import io.reactivex.Single;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKGlobalScope
public final class UserManagerImpl implements IUserManager {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f433324q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IOnlineOfflineService f433325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IOfficeSDKTokenProvider f433326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IOfficeSDKLifeCycle f433327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<String> f433328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f433329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<? super Continuation<? super Unit>, ? extends Object> f433330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<? extends OfficeSDKUserApi> f433331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<? extends IOfficeSDKHostSessionProvider> f433332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<? extends IOfficeSDKUserServiceInjector> f433333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile OfficeSDKHostSession f433334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final StateFlowImpl f433335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f433336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayDeque<c> f433337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f433338n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Channel<Unit> f433339o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f433340p;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.internal.UserManagerImpl$a$a, reason: collision with other inner class name */
        public static final class C5154a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f433341a;

            public C5154a(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, "error");
                this.f433341a = r100;
            }
        }

        public static final class b extends a {
            public b() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.internal.UserManagerImpl$awaitUserApi$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl", f = "UserManagerImpl.kt", i = {0}, l = {518}, m = "awaitUserApi", n = {"timeoutMs"}, s = {"J$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ UserManagerImpl this$0;

        public AnonymousClass1(UserManagerImpl r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitUserApi(0, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.internal.UserManagerImpl$awaitUserApi$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl$awaitUserApi$2", f = "UserManagerImpl.kt", i = {}, l = {525}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OfficeSDKUserApi>, Object> {
        int label;
        final /* synthetic */ UserManagerImpl this$0;

        public AnonymousClass2(UserManagerImpl r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super OfficeSDKUserApi> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super OfficeSDKUserApi> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L29:
            a r103 = (a) r100;
            if ((r103 instanceof a.b) == false) goto L37;
            OfficeSDKUserApi r104 = this.this$0.f433331g.invoke();
            if (r104 == null) goto L35;
            return r104;
        L35:
            throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.LOGIN_FAILED, "userApi unavailable after login", null, 4, null);
        L37:
            if ((r103 instanceof a.C5154a) == false) goto L44;
            a.C5154a r105 = (a.C5154a) r103;
            String r106 = r105.f433341a.getMessage();
            if (r106 != null) goto L42;
            r106 = "login failed";
        L42:
            throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.LOGIN_FAILED, r106, r105.f433341a);
        L44:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            UserManagerImpl r107 = this.this$0;
            Object r108 = r107.f433336l;
            monitor-enter(r108);
        L45:
            th = move-exception;
            throw th;
        L11:
            if (r107.f433337m.isEmpty() == false) goto L15;
            if (r107.f433338n != null) goto L15;
            boolean r109 = true;
        L16:
            monitor-exit(r108);
            if (r109 == true) goto L20;
        L23:
            OfficeSDKUserApi r110 = null;
        L24:
            if (r110 == null) goto L26;
            return r110;
        L26:
            CompletableDeferred<a> r111 = this.this$0.g(null, null).f433342a;
            this.label = 1;
            r100 = r111.await(this);
            if (r100 != r101) goto L29;
            return r101;
        L20:
            if (r107.f433328d.get() == null) goto L23;
            r110 = r107.f433331g.invoke();
        L15:
            r109 = false;
            goto L16
        }
    }

    public static final class b {
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CompletableDeferred<a> f433342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f433343b;

        public static final class a extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public volatile OfficeSDKHostSession f433344c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final CopyOnWriteArrayList<ILoginCallback> f433345d;

            public a(ILoginCallback r100, OfficeSDKHostSession r101) {
                this.f433344c = r101;
                CopyOnWriteArrayList<ILoginCallback> r102 = new CopyOnWriteArrayList();
                this.f433345d = r102;
                if (r100 == null) goto L6;
                r102.add(r100);
                return;
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final OfficeSDKPassportUserAction f433346c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final OfficeSDKHostSession f433347d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final CopyOnWriteArrayList<ILogoutCallback> f433348e;

            public b(ILogoutCallback r100, OfficeSDKPassportUserAction r101, OfficeSDKHostSession r102) {
                Intrinsics.checkNotNullParameter(r101, "action");
                this.f433346c = r101;
                this.f433347d = r102;
                CopyOnWriteArrayList<ILogoutCallback> r103 = new CopyOnWriteArrayList();
                this.f433348e = r103;
                if (r100 == null) goto L6;
                r103.add(r100);
                return;
            }
        }

        public c() {
            this.f433342a = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }
    }

    static {
    }

    public final void f() {
        StateFlowImpl r100 = this.f433335k;
        r100.setValue(Integer.valueOf(((Number) r100.getValue()).intValue() + 1));
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final i1<IOnlineOfflineService.State> loginState() {
        return this.f433325a.getState();
    }

    public static OfficeSDKUserApi i() {
        OfficeSDKUserComponent r100 = OfficeSDKManager.getOfficeSDKUserComponent();     // Catch: Exception -> L6
        if (r100 == null) goto L8;
        return ((OfficeSDKUserEntryPoint) EntryPoints.get(r100, OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi();
    L8:
        return null;
    L6:
        e = move-exception;
        Log.e("UserManagerImpl", "getOfficeSDKUserApi failed", e);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final OfficeSDKUserApi getUserApi() {
        return i();
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final IOfficeSDKUserHandle createUserHandle(OfficeSDKHostSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return new i(r100, this);
    }

    public final OfficeSDKUserApi j(OfficeSDKHostSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        if (this.f433328d.get() != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(this.f433334j, r100) == true) goto L8;
        return null;
    L8:
        return this.f433331g.invoke();
    }

    public final void l(c r100) {
        Object r101 = this.f433336l;
        monitor-enter(r101);
        r100.f433343b = true;     // Catch: Throwable -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r101);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final void login(ILoginCallback r100) {
        Log.i("UserManagerImpl", "login called");
        if (OfficeSDKManager.isEmbeddedLarkHost() == false) goto L22;
        String r101 = OfficeSDKManager.getEmbeddedLarkCurrentUserId();
        if (r101 != null) goto L9;
        IllegalStateException r102 = new IllegalStateException("No embedded Feishu current user");
        Log.w("UserManagerImpl", "embedded feishu login skipped, no current user");
        if (r100 == null) goto L24;
        r100.onLoginError(r102);
        return;
    L24:
        return;
    L9:
        String r103 = this.f433328d.getAndSet(r101);
        if (r103 != null) goto L12;
    L14:
        OfficeSDKManager.setCurrentUid$officesdk_core_release(r101);
        OfficeSDKUserApi r104 = i();
        if (r104 == null) goto L17;
        this.f433327c.onLoginSuccess(r104);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r105 = g.f433363a;
        Statistics.sendEvent("officesdk_login");
    L18:
        if (r100 == null) goto L20;
        r100.onLoginSuccess(r101);
    L20:
        Log.i("UserManagerImpl", "embedded feishu login success, uid=".concat(r101));
        return;
    L17:
        Log.e("UserManagerImpl", "embedded feishu login success but userApi is null");
        goto L18
    L12:
        if (Intrinsics.areEqual(r103, r101) == true) goto L14;
        OfficeSDKManager.clearCurrentUid$officesdk_core_release(r103);
        OfficeSDKManager.unregisterOfficeSDKUserComponent(r103);
        OfficeSDKManager.clearUserServices$officesdk_core_release(r103);
        this.f433327c.onLogoutSuccess(r103);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r106 = g.f433363a;
        Statistics.sendEvent("officesdk_logout");
        goto L14
    L22:
        g(r100, null);
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final Single<OfficeSDKDriveResult> loginRx(final OfficeSDKHostSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return Single.create(new UserManagerImpl$driveRx$1(this, new C119341(this, r100), 30000, OfficeSDKDriveErrorCodes.LOGIN_FAILED));
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final Single<OfficeSDKDriveResult> logoutRx(final OfficeSDKHostSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        return Single.create(new UserManagerImpl$driveRx$1(this, new C119351(this, r100), 5000, OfficeSDKDriveErrorCodes.LOGOUT_FAILED));
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final Object awaitUserApi(long r100, Continuation<? super OfficeSDKUserApi> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = r102.J$0;
        ResultKt.throwOnFailure(r104);
    L24:
        OfficeSDKUserApi r107 = (OfficeSDKUserApi) r104;
        if (r107 == null) goto L28;
        return r107;
    L28:
        throw new OfficeSDKUserAccessException("timeout", "awaitUserApi timed out after " + r100 + "ms", null, 4, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (OfficeSDKManager.isEmbeddedLarkHost() == false) goto L21;
        OfficeSDKUserApi r108 = i();
        if (r108 == null) goto L20;
        return r108;
    L20:
        throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.NOT_SUPPORTED, "awaitUserApi does not drive login for embedded host", null, 4, null);
    L21:
        AnonymousClass2 r109 = new AnonymousClass2(this, null);
        r102.J$0 = r100;
        r102.label = 1;
        r104 = TimeoutKt.c(r100, r109, r102);
        if (r104 != r105) goto L24;
        return r105;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }

    public final c.a g(ILoginCallback r100, OfficeSDKHostSession r110) {
        Object r101 = this.f433336l;
        monitor-enter(r101);
        c r102 = this.f433337m.lastOrNull();     // Catch: Throwable -> L37
        if (r102 != null) goto L8;
        r102 = this.f433338n;     // Catch: Throwable -> L37
    L8:
        if ((r102 instanceof c.a) == true) goto L10;
    L29:
        c.a r103 = new c.a(r100, r110);     // Catch: Throwable -> L37
        this.f433337m.add(r103);     // Catch: Throwable -> L37
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r101);
        if (this.f433340p.compareAndSet(false, true) == false) goto L35;
        BuildersKt.launch$default(this.f433329e, null, null, new UserManagerImpl$startWorker$1(this, null), 3, null);
    L35:
        this.f433339o.mo10962trySendJP2dKIU(Unit.INSTANCE);
        return r103;
    L10:
        if (((c.a) r102).f433343b == true) goto L29;
        OfficeSDKHostSession r105 = ((c.a) r102).f433344c;     // Catch: Throwable -> L37
        if (r105 == null) goto L18;
        if (r110 == null) goto L18;
        if (Intrinsics.areEqual(r105, r110) == true) goto L18;
        boolean r106 = false;
    L19:
        if (r106 == false) goto L29;
        if (r100 == null) goto L23;
        ((c.a) r102).f433345d.add(r100);     // Catch: Throwable -> L37
    L23:
        if (((c.a) r102).f433344c != null) goto L26;
        if (r110 == null) goto L26;
        ((c.a) r102).f433344c = r110;     // Catch: Throwable -> L37
    L26:
        Log.i("UserManagerImpl", "login joined in-flight command");     // Catch: Throwable -> L37
        c.a r107 = (c.a) r102;     // Catch: Throwable -> L37
        monitor-exit(r101);
        return r107;
    L18:
        r106 = true;
    L37:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.officesdk.api.IUserManager
    public final void logout(ILogoutCallback r100, OfficeSDKPassportUserAction r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        String r102 = this.f433328d.get();
        Log.i("UserManagerImpl", "logout called, currentUid=" + r102 + ", action=" + r101);
        if (OfficeSDKManager.isEmbeddedLarkHost() == false) goto L14;
        String r103 = this.f433328d.getAndSet(null);
        if (r103 != null) goto L9;
        Log.w("UserManagerImpl", "embedded feishu logout, no user logged in");
        if (r100 == null) goto L21;
        r100.onLogoutError(new IllegalStateException("No user logged in"));
        return;
    L21:
        return;
    L9:
        OfficeSDKManager.clearCurrentUid$officesdk_core_release(r103);
        OfficeSDKManager.unregisterOfficeSDKUserComponent(r103);
        OfficeSDKManager.clearUserServices$officesdk_core_release(r103);
        if (r100 == null) goto L12;
        r100.onLogoutSuccess(r103);
    L12:
        this.f433327c.onLogoutSuccess(r103);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r104 = g.f433363a;
        Statistics.sendEvent("officesdk_logout");
        Log.i("UserManagerImpl", "embedded feishu logout success, uid=".concat(r103));
        return;
    L14:
        if (r102 != null) goto L19;
        Log.w("UserManagerImpl", "logout, no user logged in");
        if (r100 == null) goto L23;
        r100.onLogoutError(new IllegalStateException("No user logged in"));
        return;
    L23:
        return;
    L19:
        h(r100, r101, null);
    }

    @Inject
    public UserManagerImpl(IOnlineOfflineService r100, IOfficeSDKTokenProvider r101, IOfficeSDKLifeCycle r102) {
        Intrinsics.checkNotNullParameter(r100, "onlineOfflineService");
        Intrinsics.checkNotNullParameter(r101, "tokenProvider");
        Intrinsics.checkNotNullParameter(r102, "officeSDKLifeCycle");
        this.f433325a = r100;
        this.f433326b = r101;
        this.f433327c = r102;
        this.f433328d = new AtomicReference(null);
        this.f433329e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.f433330f = new UserManagerImpl$sdkInitAwaiter$1(null);
        this.f433331g = new UserManagerImpl$userApiProvider$1(this);
        this.f433332h = UserManagerImpl$hostSessionProviderResolver$1.INSTANCE;
        this.f433333i = UserManagerImpl$userServiceInjectorResolver$1.INSTANCE;
        this.f433335k = j1.a(0);
        this.f433336l = new Object();
        this.f433337m = new ArrayDeque();
        this.f433339o = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.f433340p = new AtomicBoolean(false);
    }

    public static final Object b(UserManagerImpl r110, c.a r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof UserManagerImpl$executeLogin$1) == false) goto L7;
        UserManagerImpl$executeLogin$1 r100 = (UserManagerImpl$executeLogin$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        long r104 = r100.J$0;
        r111 = (c.a) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L52:
        Object r114 = ((Result) r113).m9458unboximpl();
        if (Result.m9456isSuccessimpl(r114) == false) goto L78;
        long r105 = SystemClock.elapsedRealtime() - r104;
        Log.i("UserManagerImpl", "OfficeSDK_Login_Online_End: " + r105 + "ms");
        String r106 = ((IOnlineOfflineService.OnlineResult) r114).getUser().userId;
        r110.f433328d.set(r106);
        r110.f433334j = r111.f433344c;
        OfficeSDKManager.setCurrentUid$officesdk_core_release(r106);
        OfficeSDKUserApi r107 = r110.f433331g.invoke();
        if (r107 == null) goto L66;
        IOfficeSDKUserServiceInjector r108 = r110.f433333i.invoke();
        if (r108 == null) goto L66;
        r108.onUserLogin(r107);     // Catch: Throwable -> L60
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r109);
        if (r115 == null) goto L65;
        Log.e("UserManagerImpl", "userServiceInjector.onUserLogin failed", r115);
    L65:
        Result.m9448boximpl(r109);
    L60:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L66:
        r110.l(r111);
        r110.f();
        r111.f433342a.complete(new a.b());
        long r117 = SystemClock.elapsedRealtime();
        if (r107 == null) goto L69;
        r110.f433327c.onLoginSuccess(r107);
        long r118 = SystemClock.elapsedRealtime() - r117;
        Log.i("UserManagerImpl", "OfficeSDK_Login_Lifecycle_End: " + r118 + "ms");
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r119 = g.f433363a;
        Statistics.sendEvent("officesdk_login");
    L70:
        long r120 = SystemClock.elapsedRealtime();
        Iterator<ILoginCallback> r121 = r111.f433345d.iterator();
    L72:
        if (r121.hasNext() == false) goto L74;
        ILoginCallback r122 = r121.next();
        Intrinsics.checkNotNull(r106);
        r122.onLoginSuccess(r106);
        goto L72
    L74:
        long r123 = SystemClock.elapsedRealtime() - r120;
        Log.i("UserManagerImpl", "OfficeSDK_Login_Callback_End: " + r123 + "ms");
        if (r107 == null) goto L77;
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r124 = g.f433363a;
        JSONObject r125 = new JSONObject();
        r125.put("online_cost", r105);
        r125.put("lifecycle_cost", r118);
        r125.put("callback_cost", r123);
    L77:
        Log.i("UserManagerImpl", "login success, uid=" + r106);
        goto L78
    L69:
        Log.e("UserManagerImpl", "login success but userApi is null");
        r118 = 0;
    L78:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r114);
        if (r126 == null) goto L85;
        Log.e("UserManagerImpl", "login failed", r126);
        r110.l(r111);
        r111.f433342a.complete(new a.C5154a(r126));
        Iterator<ILoginCallback> r127 = r111.f433345d.iterator();
    L82:
        if (r127.hasNext() == false) goto L85;
        r127.next().onLoginError(r126);
    L85:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r111 = (c.a) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L48:
        long r128 = SystemClock.elapsedRealtime();
        Flow<Result<IOnlineOfflineService.OnlineResult>> r129 = r110.f433325a.online(new IOnlineOfflineService.OnlineParams(false, 1, null));
        r100.L$0 = r111;
        r100.J$0 = r128;
        r100.label = 3;
        r113 = kotlinx.coroutines.flow.e.s(r129, r100);
        if (r113 == r102) goto L94;
        r104 = r128;
        goto L52
    L94:
        return r102;
    L17:
        String r130 = (String) r100.L$1;
        c.a r131 = (c.a) r100.L$0;
        ResultKt.throwOnFailure(r113);
        Object r132 = ((Result) r113).m9458unboximpl();
    L31:
        if (Result.m9456isSuccessimpl(r132) == false) goto L33;
        IOnlineOfflineService.OfflineResult r133 = (IOnlineOfflineService.OfflineResult) r132;
        r110.f433327c.onLogoutSuccess(r130);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r134 = g.f433363a;
        Statistics.sendEvent("officesdk_logout");
    L33:
        Throwable r135 = Result.m9452exceptionOrNullimpl(r132);
        if (r135 == null) goto L36;
        Log.w("UserManagerImpl", "implicit drain failed, converging to offline anyway", r135);
    L36:
        r111 = r131;
    L45:
        Function1<? super Continuation<? super Unit>, ? extends Object> r136 = r110.f433330f;
        r100.L$0 = r111;
        r100.L$1 = null;
        r100.label = 2;
        if (r136.invoke(r100) != r102) goto L48;
        return r102;
    L18:
        ResultKt.throwOnFailure(r113);
        String r137 = r110.f433328d.get();
        if (r137 == null) goto L45;
        OfficeSDKHostSession r138 = r111.f433344c;
        OfficeSDKHostSession r139 = r110.f433334j;
        if (r138 == null) goto L37;
        if (r139 == null) goto L37;
        if (Intrinsics.areEqual(r138, r139) == true) goto L37;
        Log.i("UserManagerImpl", "login converging via implicit drain, switching host session");
        OfficeSDKPassportUserAction r140 = OfficeSDKPassportUserAction.SWITCH;
        r100.L$0 = r111;
        r100.L$1 = r137;
        r100.label = 1;
        Object r141 = r110.k(r137, r140, r100);
        if (r141 == r102) goto L92;
        r131 = r111;
        r130 = r137;
        r132 = r141;
        goto L31
    L92:
        return r102;
    L37:
        if (r138 == null) goto L40;
        if (r139 != null) goto L40;
        r110.f433334j = r138;
        r110.f();
    L40:
        Log.i("UserManagerImpl", "login converged, already online");
        r110.l(r111);
        r111.f433342a.complete(new a.b());
        Iterator<ILoginCallback> r142 = r111.f433345d.iterator();
    L42:
        if (r142.hasNext() == false) goto L91;
        r142.next().onLoginSuccess(r137);
        goto L42
    L91:
        return Unit.INSTANCE;
    L7:
        r100 = new UserManagerImpl$executeLogin$1(r110, r112);
        goto L8
    }

    public static final Object c(UserManagerImpl r100, c.b r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof UserManagerImpl$executeLogout$1) == false) goto L7;
        UserManagerImpl$executeLogout$1 r102 = (UserManagerImpl$executeLogout$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r106 = (String) r102.L$1;
        c.b r107 = (c.b) r102.L$0;
        ResultKt.throwOnFailure(r111);
        Object r112 = ((Result) r111).m9458unboximpl();
        String r113 = r106;
        r101 = r107;
        Object r108 = r112;
    L35:
        if (Result.m9456isSuccessimpl(r108) == false) goto L41;
        IOnlineOfflineService.OfflineResult r109 = (IOnlineOfflineService.OfflineResult) r108;
        r100.l(r101);
        r101.f433342a.complete(new a.b());
        Iterator<ILogoutCallback> r114 = r101.f433348e.iterator();
    L38:
        if (r114.hasNext() == false) goto L40;
        r114.next().onLogoutSuccess(r113);
        goto L38
    L40:
        r100.f433327c.onLogoutSuccess(r113);
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r115 = g.f433363a;
        Statistics.sendEvent("officesdk_logout");
        Log.i("UserManagerImpl", "logout success, uid=" + r113);
    L41:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r108);
        if (r116 == null) goto L48;
        Log.e("UserManagerImpl", "logout failed", r116);
        r100.l(r101);
        r101.f433342a.complete(new a.C5154a(r116));
        Iterator<ILogoutCallback> r117 = r101.f433348e.iterator();
    L45:
        if (r117.hasNext() == false) goto L48;
        r117.next().onLogoutError(r116);
    L48:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r113 = r100.f433328d.get();
        if (r113 != null) goto L21;
        Log.i("UserManagerImpl", "logout converged, no user online");
        r100.l(r101);
        r101.f433342a.complete(new a.b());
        Iterator<ILogoutCallback> r118 = r101.f433348e.iterator();
    L18:
        if (r118.hasNext() == false) goto L53;
        r118.next().onLogoutSuccess("");
        goto L18
    L53:
        return Unit.INSTANCE;
    L21:
        OfficeSDKHostSession r119 = r101.f433347d;
        OfficeSDKHostSession r120 = r100.f433334j;
        if (r119 == null) goto L31;
        if (r120 == null) goto L31;
        if (Intrinsics.areEqual(r119, r120) == true) goto L31;
        Log.i("UserManagerImpl", "logout converged, stale host session");
        r100.l(r101);
        r101.f433342a.complete(new a.b());
        Iterator<ILogoutCallback> r121 = r101.f433348e.iterator();
    L28:
        if (r121.hasNext() == false) goto L54;
        r121.next().onLogoutSuccess("");
        goto L28
    L54:
        return Unit.INSTANCE;
    L31:
        OfficeSDKPassportUserAction r122 = r101.f433346c;
        r102.L$0 = r101;
        r102.L$1 = r113;
        r102.label = 1;
        r108 = r100.k(r113, r122, r102);
        if (r108 != r104) goto L35;
        return r104;
    L7:
        r102 = new UserManagerImpl$executeLogout$1(r100, r110);
        goto L8
    }

    public static final void d(UserManagerImpl r100, c r101, Throwable r102) {
        Object r103 = r100.f433336l;
        monitor-enter(r103);
        boolean r104 = r101.f433343b;     // Catch: Throwable -> L24
        r101.f433343b = true;     // Catch: Throwable -> L24
        monitor-exit(r103);
        r101.f433342a.complete(new a.C5154a(r102));
        if (r104 == false) goto L10;
        return;
    L10:
        if ((r101 instanceof c.a) == false) goto L16;
        Iterator<ILoginCallback> r105 = ((c.a) r101).f433345d.iterator();
    L13:
        if (r105.hasNext() == false) goto L31;
        r105.next().onLoginError(r102);
        goto L13
    L31:
        return;
    L16:
        if ((r101 instanceof c.b) == false) goto L23;
        Iterator<ILogoutCallback> r106 = ((c.b) r101).f433348e.iterator();
    L19:
        if (r106.hasNext() == false) goto L32;
        r106.next().onLogoutError(r102);
        goto L19
    L32:
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        th = move-exception;
        throw th;
    }

    public final Object e(OfficeSDKHostSession r110, long r111, Continuation<? super OfficeSDKUserApi> r210) {
        long r100 = r111;
        if ((r210 instanceof UserManagerImpl$awaitUserApiForSession$1) == false) goto L7;
        UserManagerImpl$awaitUserApiForSession$1 r101 = (UserManagerImpl$awaitUserApiForSession$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = r101.J$0;
        ResultKt.throwOnFailure(r103);
    L19:
        OfficeSDKUserApi r106 = (OfficeSDKUserApi) r103;
        if (r106 == null) goto L23;
        return r106;
    L23:
        throw new OfficeSDKUserAccessException("timeout", "awaitUserApi timed out after " + r100 + "ms", null, 4, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        IOfficeSDKHostSessionProvider r107 = this.f433332h.invoke();
        if (r107 == null) goto L25;
        UserManagerImpl$awaitUserApiForSession$2 r108 = new UserManagerImpl$awaitUserApiForSession$2(this, r110, r107, null);
        r101.J$0 = r100;
        r101.label = 1;
        r103 = TimeoutKt.c(r100, r108, r101);
        if (r103 != r104) goto L19;
        return r104;
    L25:
        throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.HOST_CAPABILITY_NOT_CONFIGURED, "hostSessionProvider not configured in OfficeSDKInitConfig", null, 4, null);
    L7:
        r101 = new UserManagerImpl$awaitUserApiForSession$1(this, r210);
        goto L8
    }

    public final c.b h(ILogoutCallback r100, OfficeSDKPassportUserAction r110, OfficeSDKHostSession r111) {
        Object r101 = this.f433336l;
        monitor-enter(r101);
        c r102 = this.f433337m.lastOrNull();     // Catch: Throwable -> L33
        if (r102 != null) goto L8;
        r102 = this.f433338n;     // Catch: Throwable -> L33
    L8:
        if ((r102 instanceof c.b) == true) goto L10;
    L25:
        c.b r103 = new c.b(r100, r110, r111);     // Catch: Throwable -> L33
        this.f433337m.add(r103);     // Catch: Throwable -> L33
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r101);
        if (this.f433340p.compareAndSet(false, true) == false) goto L31;
        BuildersKt.launch$default(this.f433329e, null, null, new UserManagerImpl$startWorker$1(this, null), 3, null);
    L31:
        this.f433339o.mo10962trySendJP2dKIU(Unit.INSTANCE);
        return r103;
    L10:
        if (((c.b) r102).f433343b == true) goto L25;
        OfficeSDKHostSession r105 = ((c.b) r102).f433347d;     // Catch: Throwable -> L33
        if (r105 == null) goto L18;
        if (r111 == null) goto L18;
        if (Intrinsics.areEqual(r105, r111) == true) goto L18;
        boolean r106 = false;
    L19:
        if (r106 == false) goto L25;
        if (r100 == null) goto L22;
        ((c.b) r102).f433348e.add(r100);     // Catch: Throwable -> L33
    L22:
        Log.i("UserManagerImpl", "logout joined in-flight command");     // Catch: Throwable -> L33
        c.b r107 = (c.b) r102;     // Catch: Throwable -> L33
        monitor-exit(r101);
        return r107;
    L18:
        r106 = true;
    L33:
        th = move-exception;
        throw th;
    }

    public final Object k(String r100, OfficeSDKPassportUserAction r101, Continuation<? super Result<IOnlineOfflineService.OfflineResult>> r102) {
        if ((r102 instanceof UserManagerImpl$performDrain$1) == false) goto L7;
        UserManagerImpl$performDrain$1 r103 = (UserManagerImpl$performDrain$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        Result r108 = (Result) r105;
        r108.m9458unboximpl();
        OfficeSDKManager.unregisterOfficeSDKUserComponent(r100);
        OfficeSDKManager.clearUserServices$officesdk_core_release(r100);
        return r108.m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        this.f433328d.set(null);
        this.f433334j = null;
        OfficeSDKManager.clearCurrentUid$officesdk_core_release(r100);
        f();
        Flow<Result<IOnlineOfflineService.OfflineResult>> r109 = this.f433325a.offline(new IOnlineOfflineService.OfflineParams(r101));
        r103.L$0 = r100;
        r103.label = 1;
        r105 = kotlinx.coroutines.flow.e.s(r109, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new UserManagerImpl$performDrain$1(this, r102);
        goto L8
    }

    public static final Object a(UserManagerImpl r110, OfficeSDKHostSession r111, IOfficeSDKHostSessionProvider r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof UserManagerImpl$awaitReadyUserApi$1) == false) goto L7;
        UserManagerImpl$awaitReadyUserApi$1 r100 = (UserManagerImpl$awaitReadyUserApi$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        IOfficeSDKHostSessionProvider r105 = (IOfficeSDKHostSessionProvider) r100.L$1;
        OfficeSDKHostSession r106 = (OfficeSDKHostSession) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L15:
        int r107 = ((Number) r110.f433335k.getValue()).intValue();
        OfficeSDKUserApi r108 = r110.j(r106);
        if (r108 != null) goto L24;
        if (r105.currentHostSession() == null) goto L28;
        if (r105.isCurrentHostSession(r106) == false) goto L26;
        StateFlowImpl r109 = r110.f433335k;
        UserManagerImpl$awaitReadyUserApi$3 r114 = new UserManagerImpl$awaitReadyUserApi$3(r107, null);
        r100.L$0 = r106;
        r100.L$1 = r105;
        r100.label = 1;
        if (kotlinx.coroutines.flow.e.t(r109, r114, r100) != r103) goto L15;
        return r103;
    L26:
        throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.HOST_USER_CHANGED, "host session changed while awaiting userApi", null, 4, null);
    L28:
        throw new OfficeSDKUserAccessException(OfficeSDKDriveErrorCodes.HOST_USER_OFFLINE, "no host user online", null, 4, null);
    L24:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        r106 = r111;
        r105 = r112;
    L7:
        r100 = new UserManagerImpl$awaitReadyUserApi$1(r110, r113);
        goto L8
    }
}
