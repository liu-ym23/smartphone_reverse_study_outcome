package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.sdk.refactor.observer.ExecuteType;
import com.bytedance.lark.sdk.refactor.state.StateUpdateType;
import com.ss.android.lark.log.Log;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class v implements te6.b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f425714a = null;

        static {
            int[] r100 = new int[ExecuteType.values().length];
            r100[ExecuteType.BEFORE_EXECUTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ExecuteType.EXECUTE_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ExecuteType.EXECUTE_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f425714a = r100;
        }
    }

    @Inject
    public v() {
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.Observer
    public final void onNext(te6.a r100) {
        te6.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        if (r101.f545577a != StateUpdateType.INIT_SDK) goto L18;
        ExecuteType r102 = r101.f545578b;
        int r103 = a.f425714a[r102.ordinal()];
        if (r103 != 1) goto L8;
        Log.d("RustSDK", "InitRustObserver onNext ExecuteMethodEvent = BEFORE_EXECUTE");
        com.ss.android.lark.sdk.i.f439883c.a();
        return;
    L8:
        if (r103 != 2) goto L10;
    L14:
        Log.d("RustSDK", "InitRustObserver onNext ExecuteMethodEvent = EXECUTE_FINISH");
        com.ss.android.lark.sdk.i.f439883c.b();
        return;
    L10:
        if (r103 == 3) goto L14;
        throw new NoWhenBranchMatchedException();
    }
}
