package le2;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.c;
import com.bytedance.android.livesdk.ktvimpl.base.sei.o;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.x;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements c {
    public final NextLiveData<x> a;

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(w r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        return r2.b instanceof o;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(w r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r8 = r7.b;
        if ((r8 instanceof o) == true) goto L5;
        r8 = null;
    L5:
        o r9 = (o) r8;
        if (r9 == null) goto L9;
        this.a.setValue(new x(r9.d(), r9.c(), r9.b()));
        return;
    }

    public b(KtvContext r2, NextLiveData<x> r3) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "singhotInfo");
        this.a = r3;
    }
}
