package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.sdk.refactor.observer.ExecuteType;
import com.bytedance.lark.sdk.refactor.state.StateUpdateType;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class w implements te6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c3c.d.b f425715a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f425716a = null;

        static {
            int[] r100 = new int[ExecuteType.values().length];
            r100[ExecuteType.BEFORE_EXECUTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ExecuteType.EXECUTE_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ExecuteType.EXECUTE_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f425716a = r100;
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Inject
    public w(c3c.d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "perfBoostDispatcher");
        this.f425715a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        String r101 = "RustSdk make online failed error :+" + r100.getMessage();
        c3c.d.b r102 = this.f425715a;
        new ErrorResult(r101);
        r102.onError();
    }

    @Override // io.reactivex.Observer
    public final void onNext(te6.a r100) {
        te6.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        if (r101.f545577a != StateUpdateType.MAKE_ONLINE) goto L19;
        ExecuteType r102 = r101.f545578b;
        int r103 = a.f425716a[r102.ordinal()];
        if (r103 != 1) goto L8;
        Log.d("RustSDK", "MakeOnlineObserver onNext BEFORE_EXECUTE");
        this.f425715a.d();
        return;
    L8:
        if (r103 != 2) goto L10;
        Log.d("RustSDK", "MakeOnlineObserver onNext EXECUTE_SUCCESS");
        this.f425715a.c();
        return;
    L10:
        if (r103 != 3) goto L13;
        Log.d("RustSDK", "MakeOnlineObserver onNext EXECUTE_FAILED");
        c3c.d.b r104 = this.f425715a;
        new ErrorResult("RustSdk make online failed");
        r104.onError();
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
