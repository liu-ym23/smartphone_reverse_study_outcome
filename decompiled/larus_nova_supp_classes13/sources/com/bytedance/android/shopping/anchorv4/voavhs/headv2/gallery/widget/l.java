package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d {
    public final /* synthetic */ h c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
    public final void c(boolean r2) {
        h r0 = this.c;
        r0.d = r2;
        if (r2 == true) goto L9;
        Runnable r3 = r0.f;
        if (r3 == null) goto L7;
        r3.run();
        return;
    L7:
        r0.c.setVisibility(4);
        return;
    }

    public l(h r7, h r8) {
        this.c = r7;
        super(r8, true, false, true, 8);
    }
}
