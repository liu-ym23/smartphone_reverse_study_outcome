package le2;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.c;
import com.bytedance.android.livesdk.ktvimpl.base.sei.h;
import com.bytedance.android.livesdk.ktvimpl.base.sei.n;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import sb0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements c {
    public final KtvContext a;

    public a(KtvContext r2) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(w r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r5.b;
        if ((r0 instanceof n) == false) goto L5;
        return true;
    L5:
        if ((r0 instanceof h) == true) goto L7;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == true) goto L23;
        return false;
    L23:
        return true;
    L7:
        if ((!Intrinsics.areEqual(r0.a(), k.n(IMiddlewareUserService.class).user().n().toString().toString())) == false) goto L15;
        h r7 = (h) r5.b;
        sb0.b r1 = (sb0.b) this.a.getDataEntity().getValue();
        if (r1 == null) goto L13;
        e r2 = r1.b();
        if (r2 == null) goto L13;
        r2.a();
    L13:
        r7.getClass();
    L16:
        r6 = true;
        goto L18
    L15:
        if (((Number) this.a.getKtvAllState().getValue()).intValue() != 8) goto L17;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r3 = r2.b;
        if ((r3 instanceof n) == false) goto L5;
    L6:
        this.a.updateSingEndedFeedback(r3);
        return;
    L5:
        if ((r3 instanceof h) == true) goto L6;
    }
}
