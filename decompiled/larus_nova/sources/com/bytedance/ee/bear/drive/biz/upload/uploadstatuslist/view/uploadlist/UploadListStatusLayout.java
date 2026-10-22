package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.view.uploadlist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class UploadListStatusLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LottieAnimationView f223949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f223950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f223951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f223952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UDProgress f223953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f223954f;

    public interface a {
    }

    public UploadListStatusLayout(Context r100) {
        super(r100);
    }

    public static String b(int r100) {
        return String.format("%d%%", new Object[]{Integer.valueOf(r100)});
    }

    public final void a(Context r100) {
        FrameLayout.inflate(r100, R.layout.drive_uploadlist_state, this);
        this.f223953e = (UDProgress) findViewById(R.id.upload_item_progress_bar);
        this.f223952d = (TextView) findViewById(R.id.upload_item_progress_text);
        this.f223949a = (LottieAnimationView) findViewById(R.id.uploadlist_lottie);
        this.f223950b = (ImageView) findViewById(R.id.upload_finish_image);
        this.f223951c = (LinearLayout) findViewById(R.id.upload_item_retry);
        this.f223954f = (TextView) findViewById(R.id.upload_item_status_tip);
    }

    public void setRetryStatus(boolean r100) {
        LinearLayout r101 = this.f223951c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public UploadListStatusLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public UploadListStatusLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }

    public final void c(int r100, int r101, boolean r102) {
        if (r100 != 1) goto L5;
        this.f223953e.setProgress(0);
        this.f223953e.setVisibility(8);
        this.f223952d.setText(b(0));
        this.f223952d.setVisibility(8);
        this.f223949a.setVisibility(8);
        this.f223950b.setVisibility(8);
        this.f223951c.setClickable(true);
        this.f223951c.setVisibility(0);
        this.f223954f.setVisibility(8);
        return;
    L5:
        if (r100 != 2) goto L7;
        this.f223953e.setProgress(r101);
        this.f223953e.setVisibility(8);
        this.f223952d.setText(b(r101));
        this.f223952d.setVisibility(8);
        this.f223949a.setVisibility(8);
        this.f223950b.setVisibility(8);
        this.f223951c.setClickable(false);
        this.f223951c.setVisibility(8);
        this.f223954f.setText(getContext().getString(R.string.Drive_Drive_WaitingForUpload));
        this.f223954f.setVisibility(0);
        return;
    L7:
        if (r100 != 3) goto L9;
        this.f223953e.setProgress(r101);
        this.f223953e.setVisibility(0);
        this.f223952d.setText(b(r101));
        this.f223952d.setVisibility(0);
        this.f223949a.setVisibility(8);
        this.f223950b.setVisibility(8);
        this.f223951c.setClickable(false);
        this.f223951c.setVisibility(8);
        this.f223954f.setVisibility(8);
        return;
    L9:
        if (r100 == 4) goto L11;
        this.f223953e.setProgress(0);
        this.f223953e.setVisibility(0);
        this.f223952d.setText(b(0));
        this.f223952d.setVisibility(0);
        this.f223949a.setVisibility(8);
        this.f223950b.setVisibility(8);
        this.f223951c.setClickable(false);
        this.f223951c.setVisibility(8);
        this.f223954f.setVisibility(8);
        return;
    L11:
        this.f223953e.setProgress(r101);
        this.f223953e.setVisibility(8);
        this.f223952d.setText(b(r101));
        this.f223952d.setVisibility(8);
        this.f223949a.setVisibility(8);
        if (r102 == false) goto L14;
        this.f223949a.setVisibility(0);
        this.f223949a.setAnimation("drive_lottie_file_upload_done.json");
        this.f223949a.setRepeatCount(0);
        this.f223949a.playAnimation();
    L15:
        this.f223950b.setVisibility(8);
        this.f223951c.setClickable(false);
        this.f223951c.setVisibility(8);
        this.f223954f.setVisibility(8);
        return;
    L14:
        tt5.a.h("UpdateListTAG", "close lottie image");
        this.f223950b.setVisibility(0);
        this.f223950b.setImageResource(R.drawable.drive_upload_finish_image);
        goto L15
    }
}
