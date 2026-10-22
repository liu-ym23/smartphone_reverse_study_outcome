package com.bytedance.android.shopping.utils.gallery;

import android.content.DialogInterface;
import com.bytedance.android.shopping.utils.r;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements DialogInterface.OnCancelListener {
    public final /* synthetic */ ECGalleryActivity a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ List d;

    public h(ECGalleryActivity r1, List r2, List r3, List r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r2) {
        int r3 = r.a;
        int r4 = this.a.k;
        Intrinsics.checkNotNullParameter("willDismiss", "type");
        this.a.finish();
    }
}
