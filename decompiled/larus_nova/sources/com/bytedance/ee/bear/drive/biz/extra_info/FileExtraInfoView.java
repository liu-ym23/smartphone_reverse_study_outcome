package com.bytedance.ee.bear.drive.biz.extra_info;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.larus.nova.R;
import w55.n;

/* JADX INFO: loaded from: classes16.dex */
public class FileExtraInfoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintLayout f222954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f222955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f222956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommentInfoView f222957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f222958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LikeInfoView f222959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LikeCircleImageView f222960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f222961h;

    public interface a {
        void a();

        void b(int r100);

        void c();
    }

    private View getInputView() {
        if (n.f558339d == false) goto L7;
        return this.f222954a;
    L7:
        return this.f222955b;
    }

    public final void b() {
        if (n.f558339d == false) goto L5;
        LayoutInflater.from(getContext()).inflate(R.layout.drive_extra_info_entry_view_v2, this);
    L6:
        this.f222954a = (ConstraintLayout) findViewById(R.id.clDriveCommentInputContainer);
        this.f222955b = (TextView) findViewById(R.id.tv_comment_enter);
        this.f222956c = (ImageView) findViewById(R.id.ivDriveCommentAreaMarker);
        this.f222957d = (CommentInfoView) findViewById(R.id.comment_card_layout);
        this.f222959f = (LikeInfoView) findViewById(R.id.drive_like_item);
        this.f222960g = (LikeCircleImageView) findViewById(R.id.drive_like_circle_image);
        setClickable(true);
        return;
    L5:
        LayoutInflater.from(getContext()).inflate(R.layout.drive_extra_info_entry_view, this);
        goto L6
    }

    public LikeCircleImageView getLikeCircleImageView() {
        return this.f222960g;
    }

    public LikeInfoView getLikeInfoView() {
        return this.f222959f;
    }

    public FileExtraInfoView(Context r100) {
        super(r100);
        b();
    }

    private void setCommentEnterStateV1(boolean r100) {
        View r101 = getInputView();
        if (r100 == false) goto L5;
        r101.setVisibility(0);
        r101.setEnabled(true);
        return;
    L5:
        r101.setVisibility(4);
        r101.setEnabled(false);
    }

    private void setCommentEnterStateV2(boolean r100) {
        View r101 = getInputView();
        if (r100 == false) goto L7;
        r101.setEnabled(true);
        ImageView r102 = this.f222956c;
        if (r102 == null) goto L11;
        r102.setEnabled(true);
        this.f222956c.setAlpha(1.0f);
        return;
    L11:
        return;
    L7:
        r101.setEnabled(false);
        ImageView r103 = this.f222956c;
        if (r103 == null) goto L13;
        r103.setEnabled(false);
        this.f222956c.setAlpha(0.4f);
        return;
    }

    private void setCommentInfoEnable(boolean r100) {
        if (r100 == false) goto L4;
        this.f222957d.setContentAlpha(255);
        this.f222957d.setEnabled(true);
        return;
    L4:
        this.f222957d.setContentAlpha(127);
        this.f222957d.setEnabled(false);
    }

    public void setAreaMarkerEnable(boolean r100) {
        ImageView r101 = this.f222956c;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public void setCommentEnterState(boolean r100) {
        if (n.f558339d == false) goto L5;
        setCommentEnterStateV2(r100);
        return;
    L5:
        setCommentEnterStateV1(r100);
    }

    public void setCommentInputHint(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.f222955b.setText(R.string.Drive_Drive_EnterComment);
        return;
    L5:
        this.f222955b.setText(r100);
    }

    public void setOnCommentListener(a r100) {
        this.f222961h = r100;
    }

    public FileExtraInfoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        b();
    }

    public final void a(DriveViewModel r100, boolean r101) {
        if (r100 != null) goto L6;
        tt5.a.d("DRIVE_FileExtraInfoView", "init: illegal parameter");
        return;
    L6:
        if (r101 == false) goto L8;
        int r102 = 0;
    L9:
        setVisibility(r102);
        this.f222957d.setTvCommentCardText(0);
        o75.b.a().Ke();
        if (n.f558339d == false) goto L18;
        View r103 = getInputView();
        if (this.f222957d == null) goto L15;
        if (r103 == null) goto L15;
        setCommentInfoEnable(false);
        r103.setEnabled(false);
    L15:
        ImageView r104 = this.f222956c;
        if (r104 == null) goto L22;
        r104.setEnabled(false);
        this.f222956c.setAlpha(0.4f);
    L22:
        getInputView().setOnClickListener(new com.bytedance.ee.bear.drive.biz.extra_info.a(this));
        this.f222957d.setOnClickListener(new b(this));
        ImageView r105 = this.f222956c;
        if (r105 == null) goto L26;
        r105.setOnClickListener(new e55.a(this));
        return;
    L26:
        return;
    L18:
        View r106 = getInputView();
        if (this.f222957d == null) goto L22;
        if (r106 == null) goto L22;
        setCommentInfoEnable(false);
        r106.setEnabled(false);
        r106.setVisibility(4);
        goto L22
    L8:
        r102 = 8;
        goto L9
    }

    public final void c(boolean r100, boolean r101) {
        if (r100 == true) goto L4;
        setCommentInfoEnable(false);
        return;
    L4:
        if (this.f222958e <= 0) goto L6;
        setCommentInfoEnable(true);
        return;
    L6:
        setCommentInfoEnable(r101);
    }

    public FileExtraInfoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        b();
    }
}
