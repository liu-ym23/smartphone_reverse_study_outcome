package com.bytedance.ee.bear.middleground.drive.export.player.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class VideoSurfaceView extends FrameLayout {
    public FrameLayout a;
    public Surface b;
    public TextureView c;
    public SurfaceTexture d;

    public interface a {
    }

    public VideoSurfaceView(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r3) {
        LayoutInflater.from(r3).inflate(2131560250, this, true);
        this.a = (FrameLayout) findViewById(2131387769);
    }

    public VideoSurfaceView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public VideoSurfaceView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }
}
