package com.bytedance.ee.bear.drive.view.preview.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ee.bear.middleground.drive.export.player.view.VideoSurfaceView;
import com.bytedance.ee.drive.preview.f;
import com.bytedance.ee.drive.render.k;
import com.larus.nova.R;
import ea5.n;

/* JADX INFO: loaded from: classes16.dex */
public class VideoPlayerContentView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f225467d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f225468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VideoSurfaceView f225469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f225470c;

    public VideoSurfaceView getSurfaceView() {
        return this.f225469b;
    }

    public VideoPlayerContentView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        boolean r101 = true;
        LayoutInflater.from(r100).inflate(R.layout.drive_preview_video_texture_view, this, true);
        this.f225468a = findViewById(R.id.drive_video_view_empty);
        this.f225469b = (VideoSurfaceView) findViewById(R.id.drive_video_texture_view);
        this.f225470c = (ImageView) findViewById(R.id.cover);
        boolean r102 = false;
        k r103 = ((f) org.koin.java.a.a(f.class)).U4(getContext()).b();     // Catch: Throwable -> L20
        k.c r104 = r103.d();     // Catch: Throwable -> L20
        k.h r105 = r103.getVideo();     // Catch: Throwable -> L20
        if (r104 != null) goto L6;
    L8:
        boolean r106 = false;
    L9:
        if (r105 != null) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r106 == false) goto L17;
        if (r107 == false) goto L17;
    L18:
        tt5.a.h("DRIVE_VideoPlayer", "resolveBlackBackgroundEnabled, enabled=" + r101 + ", mediaImmersive=" + r106 + ", videoControlBarV2=" + r107);     // Catch: Throwable -> L20
        r102 = r101;
    L22:
        if (r102 == false) goto L35;
        View r108 = findViewById(R.id.video_view_root);
        if (r108 != null) goto L27;
    L30:
        tt5.a.d("DRIVE_VideoPlayer", "applyHostVideoBackground failed, requiredViewMissing=true");
        return;
    L27:
        if (this.f225468a == null) goto L30;
        r108.setBackgroundColor(getResources().getColor(R.color.static_black));
        this.f225468a.setBackgroundColor(getResources().getColor(R.color.lkui_transparent));
        return;
    L35:
        return;
    L17:
        r101 = false;
        goto L18
    L11:
        if (r105.f242754c == false) goto L13;
        r107 = true;
        goto L14
    L6:
        if (r104.f242744a == false) goto L8;
        r106 = true;
    L20:
        th = move-exception;
        tt5.a.e("DRIVE_VideoPlayer", "resolveBlackBackgroundEnabled failed, keep default background", th, false);
        goto L22
    }

    public final void b(boolean r100) {
        tt5.a.h("DRIVE_VideoPlayer", "showCover() show=" + r100);
        if (r100 == true) goto L6;
        this.f225470c.setImageBitmap(null);
        this.f225470c.setVisibility(8);
        return;
    L6:
        TextureView r101 = this.f225469b.f232524c;
        if (r101 == null) goto L15;
        Bitmap r102 = r101.getBitmap();
        if (this.f225470c.getVisibility() == 0) goto L13;
        if (r102 == null) goto L13;
        this.f225470c.setVisibility(0);
        this.f225470c.setImageBitmap(r102);
        return;
    L13:
        tt5.a.k("DRIVE_VideoPlayer", "showCover() mCover.getVisibility() == VISIBLE || bitmap == null, bitmap=" + r102);
        return;
    }

    public void setEmptyViewColor(int r100) {
        this.f225468a.setBackgroundColor(r100);
    }

    public void setEmptyViewVisibility(int r100) {
        this.f225468a.setVisibility(r100);
    }

    public void setRootViewClickable(boolean r100) {
        this.f225468a.setBackgroundColor(getResources().getColor(R.color.lkui_transparent));
        View r101 = this.f225468a;
        if (r100 == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        if (r100 == true) goto L10;
        this.f225468a.setOnClickListener(new n());
        return;
    L10:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public VideoPlayerContentView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public VideoPlayerContentView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
