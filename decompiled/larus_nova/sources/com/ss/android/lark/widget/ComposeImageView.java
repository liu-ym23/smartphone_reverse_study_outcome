package com.ss.android.lark.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class ComposeImageView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SubsamplingScaleImageView f445572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f445573b;

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    public ImageView getNormalImageView() {
        return this.f445573b;
    }

    public ComposeImageView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.__compose_image_view, this, true);
        this.f445572a = (SubsamplingScaleImageView) findViewById(R.id.large_image_view);
        this.f445573b = (ImageView) findViewById(R.id.image_view);
        this.f445572a.setVisibility(8);
        this.f445573b.setVisibility(0);
        this.f445572a.setExecutor(CoreThreadPool.getDefault().getCachedThreadPool());
    }

    public ComposeImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public ComposeImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
