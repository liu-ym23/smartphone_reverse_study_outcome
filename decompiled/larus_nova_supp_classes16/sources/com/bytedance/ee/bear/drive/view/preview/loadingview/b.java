package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.render.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends AbsLoadingView {
    public final FileLoadingView a;

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public final void show() {
        int r0 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).c3(this.mFileModel.b);
        this.a.e(r0);
        FileLoadingView r1 = this.a;
        r1.getClass();
        int r2 = y9c.d.a(42);
        r1.c.getLayoutParams().width = r2;
        r1.c.getLayoutParams().height = r2;
        ViewGroup.LayoutParams r3 = r1.b.getLayoutParams();
        r3.width = y9c.d.a(188);
        r1.a.setPadding(0, 0, 0, 0);
        r1.requestLayout();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public final View getView() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public final void setProgress(int r2) {
        this.a.setProgress(r2);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public final void setUIConfig(k.b r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.a.d(r4.a, r4.b);
        this.a.c(r4.d, r4.c);
    }

    public b(FragmentActivity r1, ViewOwner r2, z r3, g85.e r4) {
        super(r1, r2, r3, r4);
        FileLoadingView r5 = new FileLoadingView(r1);
        this.a = r5;
        r5.b(r2);
    }
}
