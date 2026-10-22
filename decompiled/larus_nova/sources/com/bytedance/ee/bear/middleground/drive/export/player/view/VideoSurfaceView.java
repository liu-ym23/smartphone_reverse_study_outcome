package com.bytedance.ee.bear.middleground.drive.export.player.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class VideoSurfaceView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f232522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Surface f232523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextureView f232524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SurfaceTexture f232525d;

    public interface a {
    }

    public VideoSurfaceView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.drive_video_surface_view, this, true);
        this.f232522a = (FrameLayout) findViewById(R.id.surface_container_root);
    }

    public VideoSurfaceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public VideoSurfaceView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
