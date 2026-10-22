package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.widgets.universedesign.SpaceLoadingImage;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes16.dex */
public class BlockLoadingView extends FrameLayout implements m85.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f225039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DriveComponentRenderVM f225040b;

    @Override // m85.a
    public String getReleaseKey() {
        return "BlockLoadingView";
    }

    @Override // m85.a
    public final void onRelease() {
        this.f225039a.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f225040b.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public BlockLoadingView(Context r100) {
        super(r100);
        this.f225039a = new CompositeDisposable();
        a(r100, true);
    }

    public BlockLoadingView(Context r100, int r101) {
        super(r100);
        this.f225039a = new CompositeDisposable();
        a(r100, false);
    }

    public final void a(Context r100, boolean r101) {
        setBackgroundDrawable(r100.getResources().getDrawable(R.drawable.drive_bg_file_block_loading_bg));
        if (r101 == false) goto L6;
        addView(new SpaceLoadingImage(r100));
        return;
    }

    public BlockLoadingView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225039a = new CompositeDisposable();
        a(r100, true);
    }

    public BlockLoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225039a = new CompositeDisposable();
        a(r100, true);
    }
}
