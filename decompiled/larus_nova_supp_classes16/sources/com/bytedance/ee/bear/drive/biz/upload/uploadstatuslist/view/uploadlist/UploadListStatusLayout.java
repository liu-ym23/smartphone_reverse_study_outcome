package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.view.uploadlist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.larksuite.component.universe_design.progress.UDProgress;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class UploadListStatusLayout extends FrameLayout {
    public LottieAnimationView a;
    public ImageView b;
    public LinearLayout c;
    public TextView d;
    public UDProgress e;
    public TextView f;

    public interface a {
    }

    public UploadListStatusLayout(Context r1) {
        super(r1);
    }

    public static String b(int r2) {
        return String.format("%d%%", new Object[]{Integer.valueOf(r2)});
    }

    public final void a(Context r2) {
        FrameLayout.inflate(r2, 2131560246, this);
        this.e = findViewById(2131391923);
        this.d = (TextView) findViewById(2131391924);
        this.a = findViewById(2131391941);
        this.b = (ImageView) findViewById(2131391917);
        this.c = (LinearLayout) findViewById(2131391925);
        this.f = (TextView) findViewById(2131391928);
    }

    public void setRetryStatus(boolean r2) {
        LinearLayout r0 = this.c;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public UploadListStatusLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public UploadListStatusLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }

    public final void c(int r4, int r5, boolean r6) {
        if (r4 != 1) goto L5;
        this.e.setProgress(0);
        this.e.setVisibility(8);
        this.d.setText(b(0));
        this.d.setVisibility(8);
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setClickable(true);
        this.c.setVisibility(0);
        this.f.setVisibility(8);
        return;
    L5:
        if (r4 != 2) goto L7;
        this.e.setProgress(r5);
        this.e.setVisibility(8);
        this.d.setText(b(r5));
        this.d.setVisibility(8);
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setClickable(false);
        this.c.setVisibility(8);
        this.f.setText(getContext().getString(2131888466));
        this.f.setVisibility(0);
        return;
    L7:
        if (r4 != 3) goto L9;
        this.e.setProgress(r5);
        this.e.setVisibility(0);
        this.d.setText(b(r5));
        this.d.setVisibility(0);
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setClickable(false);
        this.c.setVisibility(8);
        this.f.setVisibility(8);
        return;
    L9:
        if (r4 == 4) goto L11;
        this.e.setProgress(0);
        this.e.setVisibility(0);
        this.d.setText(b(0));
        this.d.setVisibility(0);
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setClickable(false);
        this.c.setVisibility(8);
        this.f.setVisibility(8);
        return;
    L11:
        this.e.setProgress(r5);
        this.e.setVisibility(8);
        this.d.setText(b(r5));
        this.d.setVisibility(8);
        this.a.setVisibility(8);
        if (r6 == false) goto L14;
        this.a.setVisibility(0);
        this.a.setAnimation("drive_lottie_file_upload_done.json");
        this.a.setRepeatCount(0);
        this.a.playAnimation();
    L15:
        this.b.setVisibility(8);
        this.c.setClickable(false);
        this.c.setVisibility(8);
        this.f.setVisibility(8);
        return;
    L14:
        tt5.a.h("UpdateListTAG", "close lottie image");
        this.b.setVisibility(0);
        this.b.setImageResource(2131234040);
        goto L15
    }
}
