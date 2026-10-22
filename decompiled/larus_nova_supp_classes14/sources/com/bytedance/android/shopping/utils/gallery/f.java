package com.bytedance.android.shopping.utils.gallery;

import com.bytedance.android.shopping.utils.r;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements OnDismissListener {
    public final /* synthetic */ ECGalleryActivity a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ List d;

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener
    public final void onDismiss(int r2) {
        ECGalleryActivity r3 = this.a;
        int r0 = ECGalleryActivity.m;
        r3.getClass();
        int r4 = r.a;
        Intrinsics.checkNotNullParameter("willDismiss", "type");
        this.a.finish();
    }

    public f(ECGalleryActivity r1, List r2, List r3, List r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
