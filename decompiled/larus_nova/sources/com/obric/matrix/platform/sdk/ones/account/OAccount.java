package com.obric.matrix.platform.sdk.ones.account;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.obric.assistant.onelogin.ObricOneLoginImpl;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class OAccount {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OAccount f396900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile AtomicBoolean f396901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CountDownLatch f396902c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static g f396903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Handler f396904e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static IAccountService f396905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f396906g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f396907h = null;

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00128\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016R@\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/OAccount$AsyncResultCallback;", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountActionCallback$Stub;", "methodName", "", "onSuccess", "Lkotlin/Function0;", "", "onFailed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "errorMsg", "onSuccessEx", "Lkotlin/Function1;", "Landroid/os/Bundle;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "_onFailed", "_onSuccess", "_onSuccessEx", "onResult", "success", "", "extra", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AsyncResultCallback extends IAccountActionCallback.Stub {
        private Function2<? super Integer, ? super String, Unit> _onFailed;
        private Function0<Unit> _onSuccess;
        private Function1<? super Bundle, Unit> _onSuccessEx;
        private final String methodName;

        public static final /* synthetic */ void access$set_onFailed$p(AsyncResultCallback r100, Function2 r101) {
            r100._onFailed = r101;
        }

        public static final /* synthetic */ void access$set_onSuccess$p(AsyncResultCallback r100, Function0 r101) {
            r100._onSuccess = r101;
        }

        public static final /* synthetic */ void access$set_onSuccessEx$p(AsyncResultCallback r100, Function1 r101) {
            r100._onSuccessEx = r101;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.IAccountActionCallback
        public void onResult(final boolean r110, final Bundle r111) {
            OAccount r100 = OAccount.f396900a;
            final String r101 = this.methodName;
            final Function0<Unit> r102 = this._onSuccess;
            final Function1<? super Bundle, Unit> r103 = this._onSuccessEx;
            final Function2<? super Integer, ? super String, Unit> r104 = this._onFailed;
            final Function0<Unit> r105 = new OAccount$AsyncResultCallback$onResult$1(this);
            r100.getClass();
            OAccount.f396904e.post(new e(r110, r101, r103, r111, r102, r105, r104));
        }

        public AsyncResultCallback(String r100, Function0<Unit> r101, Function2<? super Integer, ? super String, Unit> r102, Function1<? super Bundle, Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "methodName");
            this.methodName = r100;
            this._onSuccess = r101;
            this._onFailed = r102;
            this._onSuccessEx = r103;
        }

        public /* synthetic */ AsyncResultCallback(String r100, Function0 r101, Function2 r102, Function1 r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 8) == 0) goto L5;
            r103 = null;
        L5:
            this(r100, r101, r102, r103);
        }
    }

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            dka.a.f("AccountSDK_OAccount", "onServiceDisconnected: name=" + r100);
            OAccount.f396905f = null;
            OAccount.f396900a.getClass();
            OAccount.d();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "service");
            dka.a.c("AccountSDK_OAccount", "onServiceConnected: ");
            OAccount r102 = OAccount.f396900a;
            OAccount.f396905f = IAccountService.Stub.asInterface(r101);
        }
    }

    public OAccount() {
    }

    public static void d() {
        c(true);
        dka.a.c("AccountSDK_OAccount", "startBindService: ");
        Intent r100 = new Intent();
        r100.setClassName("com.obric.matrix", "com.obric.matrix.account.service.OAccountService");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (AppGlobals.a().bindService(r100, f396906g, 1) == true) goto L6;
        dka.a.b("AccountSDK_OAccount", "startBindService: failed");     // Catch: Throwable -> L8
    L6:
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L16;
        dka.a.f469052a.e("AccountSDK_OAccount", "onFailure startBindService: failed", r103);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    static {
        f396900a = new OAccount();
        f396901b = new AtomicBoolean(false);
        f396902c = new CountDownLatch(1);
        f396904e = new Handler(Looper.getMainLooper());
        f396906g = new a();
        f396907h = LazyKt.lazy(OAccount$defaultErrorMsg$2.INSTANCE);
    }

    public static void a(ObricOneLoginImpl.e r100) {
        Intrinsics.checkNotNullParameter(r100, "accountStatusListener");
        g r101 = f396903d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "accountStatusListener");
        Set<cka.a> r102 = g.f396944f;
        monitor-enter(r102);
        ((CopyOnWriteArraySet) r102).add(r100);     // Catch: Throwable -> L10
        monitor-exit(r102);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void b(ObricOneLoginImpl.e r100) {
        Intrinsics.checkNotNullParameter(r100, "accountStatusListener");
        c(true);
        g r101 = f396903d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "accountStatusListener");
        Set<cka.a> r102 = g.f396946h;
        monitor-enter(r102);
        ((CopyOnWriteArraySet) r102).add(r100);     // Catch: Throwable -> L10
        monitor-exit(r102);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void c(boolean r100) throws AccountException {
        if (r100 == false) goto L11;
        if (f396901b.get() == false) goto L15;
        return;
    L15:
        f396902c.await(3000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        return;
    L9:
        throw new AccountException(1002, "account init timeout", null, 4, null);
    L11:
        if (f396901b.get() == false) goto L14;
        return;
    L14:
        throw new AccountException(1001, "please call init first ", null, 4, null);
    }
}
