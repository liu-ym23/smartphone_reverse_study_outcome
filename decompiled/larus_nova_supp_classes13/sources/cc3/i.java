package cc3;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.response.r0;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements Observer<r0> {
    public final /* synthetic */ zb3.b a;
    public final /* synthetic */ Function1 b;

    public final void onComplete() {
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onNext(Object r12) {
        r0 r13 = (r0) r12;
        Intrinsics.checkNotNullParameter(r13, "t");
        if (this.a.b != 1) goto L5;
        boolean r0 = true;
    L7:
        if (r13.a() != 0) goto L16;
        zb3.b r14 = this.a;
        if (r0 == false) goto L11;
        long r1 = r14.c + 1;
    L12:
        Function1 r3 = this.b;
        if (r3 == null) goto L15;
        Unit r15 = (Unit) r3.invoke(new zb3.a(String.valueOf(r14.a), r0, r1, 8));
    L15:
        s0.a(new vb3.a(this.a.a, r0, r1));
        return;
    L11:
        r1 = r14.c - 1;
        goto L12
    L16:
        Function1 r16 = this.b;
        if (r16 == null) goto L21;
        Unit r17 = (Unit) r16.invoke(new zb3.a(String.valueOf(this.a.a), !r0, this.a.c, 8));
        return;
    L21:
        return;
    L5:
        r0 = false;
        goto L7
    }

    public i(zb3.b r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
