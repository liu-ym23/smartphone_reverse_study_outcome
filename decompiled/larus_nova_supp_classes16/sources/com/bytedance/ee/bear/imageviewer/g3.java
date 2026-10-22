package com.bytedance.ee.bear.imageviewer;

import android.widget.FrameLayout;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g3 implements LargeImageView.c {
    public final /* synthetic */ LargeImageView a;
    public final /* synthetic */ ImageData.Image b;
    public final /* synthetic */ FrameLayout c;
    public final /* synthetic */ c3 d;

    public final void a() {
    }

    public final void b() {
        c3 r0 = this.d;
        if (r0.k == false) goto L5;
        r0.m(this.a);
    L5:
        uw4.b r1 = this.d.L;
        if (r1 == null) goto L9;
        String r2 = this.b.getUuid();
        int r3 = this.d.G;
        r1.d(r2, this.c, this.a);
    L9:
        if (Objects.equals(this.d.c7(), this.b) == true) goto L11;
        return;
    L11:
        if (this.d.L == null) goto L15;
        tt5.a.h("ImageViewer", "onLoadSuccess... uuid = " + du5.b.h(this.b.getUuid()) + ", index = " + this.d.G);
        this.d.L.b(this.b.getUuid(), this.d.G, this.b, this.a);
        this.d.getClass();
        return;
    }

    public final void c(int r1, ErrorResult r2) {
        c3 r3 = this.d;
        if (r3.k == false) goto L6;
        r3.m(this.a);
        return;
    }

    public g3(c3 r1, LargeImageView r2, ImageData.Image r3, FrameLayout r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
