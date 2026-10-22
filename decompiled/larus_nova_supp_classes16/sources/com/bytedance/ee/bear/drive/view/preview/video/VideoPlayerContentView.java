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
import ea5.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VideoPlayerContentView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public View a;
    public VideoSurfaceView b;
    public ImageView c;

    public VideoSurfaceView getSurfaceView() {
        return this.b;
    }

    public VideoPlayerContentView(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r7) {
        boolean r1 = true;
        LayoutInflater.from(r7).inflate(2131560222, this, true);
        this.a = findViewById(2131370350);
        this.b = findViewById(2131370349);
        this.c = (ImageView) findViewById(2131368133);
        boolean r2 = false;
        k r3 = ((f) org.koin.java.a.a(f.class)).U4(getContext()).b();     // Catch: Throwable -> L20
        k.c r4 = r3.d();     // Catch: Throwable -> L20
        k.h r5 = r3.getVideo();     // Catch: Throwable -> L20
        if (r4 != null) goto L6;
    L8:
        boolean r6 = false;
    L9:
        if (r5 != null) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r6 == false) goto L17;
        if (r8 == false) goto L17;
    L18:
        tt5.a.h("DRIVE_VideoPlayer", "resolveBlackBackgroundEnabled, enabled=" + r1 + ", mediaImmersive=" + r6 + ", videoControlBarV2=" + r8);     // Catch: Throwable -> L20
        r2 = r1;
    L22:
        if (r2 == false) goto L35;
        View r0 = findViewById(2131392409);
        if (r0 != null) goto L27;
    L30:
        tt5.a.d("DRIVE_VideoPlayer", "applyHostVideoBackground failed, requiredViewMissing=true");
        return;
    L27:
        if (this.a == null) goto L30;
        r0.setBackgroundColor(getResources().getColor(2131106500));
        this.a.setBackgroundColor(getResources().getColor(2131103546));
        return;
    L35:
        return;
    L17:
        r1 = false;
        goto L18
    L11:
        if (r5.c == false) goto L13;
        r8 = true;
        goto L14
    L6:
        if (r4.a == false) goto L8;
        r6 = true;
    L20:
        th = move-exception;
        tt5.a.e("DRIVE_VideoPlayer", "resolveBlackBackgroundEnabled failed, keep default background", th, false);
        goto L22
    }

    public final void b(boolean r4) {
        tt5.a.h("DRIVE_VideoPlayer", "showCover() show=" + r4);
        if (r4 == true) goto L6;
        this.c.setImageBitmap(null);
        this.c.setVisibility(8);
        return;
    L6:
        TextureView r5 = this.b.c;
        if (r5 == null) goto L15;
        Bitmap r6 = r5.getBitmap();
        if (this.c.getVisibility() == 0) goto L13;
        if (r6 == null) goto L13;
        this.c.setVisibility(0);
        this.c.setImageBitmap(r6);
        return;
    L13:
        tt5.a.k("DRIVE_VideoPlayer", "showCover() mCover.getVisibility() == VISIBLE || bitmap == null, bitmap=" + r6);
        return;
    }

    public void setEmptyViewColor(int r2) {
        this.a.setBackgroundColor(r2);
    }

    public void setEmptyViewVisibility(int r2) {
        this.a.setVisibility(r2);
    }

    public void setRootViewClickable(boolean r4) {
        this.a.setBackgroundColor(getResources().getColor(2131103546));
        View r0 = this.a;
        if (r4 == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        if (r4 == true) goto L10;
        this.a.setOnClickListener(new n());
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public VideoPlayerContentView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public VideoPlayerContentView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }
}
