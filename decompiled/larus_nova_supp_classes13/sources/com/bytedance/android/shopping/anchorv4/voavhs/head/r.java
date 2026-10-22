package com.bytedance.android.shopping.anchorv4.voavhs.head;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r implements com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.j {
    public final Set<Integer> a;
    public final /* synthetic */ SlidesAndIndicatorV4Component b;

    public r(SlidesAndIndicatorV4Component r1) {
        this.b = r1;
        this.a = new LinkedHashSet();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.j
    public final void a(int r1, String r2, String r3) {
        if (this.a.contains(Integer.valueOf(r1)) == true) goto L6;
        this.a.add(Integer.valueOf(r1));
        this.b.y.t(r1, null, null);
        return;
    }
}
