package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BlockLoadingView extends FrameLayout implements m85.a {
    public final CompositeDisposable a;
    public DriveComponentRenderVM b;

    @Override // m85.a
    public String getReleaseKey() {
        return "BlockLoadingView";
    }

    @Override // m85.a
    public final void onRelease() {
        this.a.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public BlockLoadingView(Context r2) {
        super(r2);
        this.a = new CompositeDisposable();
        a(r2, true);
    }

    public BlockLoadingView(Context r1, int r2) {
        super(r1);
        this.a = new CompositeDisposable();
        a(r1, false);
    }

    public final void a(Context r3, boolean r4) {
        setBackgroundDrawable(r3.getResources().getDrawable(2131234010));
        if (r4 == false) goto L6;
        addView(new SpaceLoadingImage(r3));
        return;
    }

    public BlockLoadingView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new CompositeDisposable();
        a(r1, true);
    }

    public BlockLoadingView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new CompositeDisposable();
        a(r1, true);
    }
}
