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
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileExtraInfoView extends FrameLayout {
    public ConstraintLayout a;
    public TextView b;
    public ImageView c;
    public CommentInfoView d;
    public int e;
    public LikeInfoView f;
    public LikeCircleImageView g;
    public a h;

    public interface a {
        void a();

        void b(int r1);

        void c();
    }

    private View getInputView() {
        if (n.d == false) goto L7;
        return this.a;
    L7:
        return this.b;
    }

    public final void b() {
        if (n.d == false) goto L5;
        LayoutInflater.from(getContext()).inflate(2131560189, this);
    L6:
        this.a = findViewById(2131366816);
        this.b = (TextView) findViewById(2131390368);
        this.c = (ImageView) findViewById(2131375911);
        this.d = (CommentInfoView) findViewById(2131367321);
        this.f = (LikeInfoView) findViewById(2131370279);
        this.g = (LikeCircleImageView) findViewById(2131370274);
        setClickable(true);
        return;
    L5:
        LayoutInflater.from(getContext()).inflate(2131560188, this);
        goto L6
    }

    public LikeCircleImageView getLikeCircleImageView() {
        return this.g;
    }

    public LikeInfoView getLikeInfoView() {
        return this.f;
    }

    public FileExtraInfoView(Context r1) {
        super(r1);
        b();
    }

    private void setCommentEnterStateV1(boolean r3) {
        View r0 = getInputView();
        if (r3 == false) goto L5;
        r0.setVisibility(0);
        r0.setEnabled(true);
        return;
    L5:
        r0.setVisibility(4);
        r0.setEnabled(false);
    }

    private void setCommentEnterStateV2(boolean r2) {
        View r0 = getInputView();
        if (r2 == false) goto L7;
        r0.setEnabled(true);
        ImageView r1 = this.c;
        if (r1 == null) goto L11;
        r1.setEnabled(true);
        this.c.setAlpha(1.0f);
        return;
    L11:
        return;
    L7:
        r0.setEnabled(false);
        ImageView r3 = this.c;
        if (r3 == null) goto L13;
        r3.setEnabled(false);
        this.c.setAlpha(0.4f);
        return;
    }

    private void setCommentInfoEnable(boolean r2) {
        if (r2 == false) goto L4;
        this.d.setContentAlpha(255);
        this.d.setEnabled(true);
        return;
    L4:
        this.d.setContentAlpha(127);
        this.d.setEnabled(false);
    }

    public void setAreaMarkerEnable(boolean r2) {
        ImageView r0 = this.c;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public void setCommentEnterState(boolean r2) {
        if (n.d == false) goto L5;
        setCommentEnterStateV2(r2);
        return;
    L5:
        setCommentEnterStateV1(r2);
    }

    public void setCommentInputHint(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        this.b.setText(2131888385);
        return;
    L5:
        this.b.setText(r2);
    }

    public void setOnCommentListener(a r1) {
        this.h = r1;
    }

    public FileExtraInfoView(Context r1, AttributeSet r2) {
        super(r1, r2);
        b();
    }

    public final void a(DriveViewModel r2, boolean r3) {
        if (r2 != null) goto L6;
        tt5.a.d("DRIVE_FileExtraInfoView", "init: illegal parameter");
        return;
    L6:
        if (r3 == false) goto L8;
        int r4 = 0;
    L9:
        setVisibility(r4);
        this.d.setTvCommentCardText(0);
        o75.b.a().Ke();
        if (n.d == false) goto L18;
        View r5 = getInputView();
        if (this.d == null) goto L15;
        if (r5 == null) goto L15;
        setCommentInfoEnable(false);
        r5.setEnabled(false);
    L15:
        ImageView r6 = this.c;
        if (r6 == null) goto L22;
        r6.setEnabled(false);
        this.c.setAlpha(0.4f);
    L22:
        getInputView().setOnClickListener(new com.bytedance.ee.bear.drive.biz.extra_info.a(this));
        this.d.setOnClickListener(new b(this));
        ImageView r7 = this.c;
        if (r7 == null) goto L26;
        r7.setOnClickListener(new e55.a(this));
        return;
    L26:
        return;
    L18:
        View r8 = getInputView();
        if (this.d == null) goto L22;
        if (r8 == null) goto L22;
        setCommentInfoEnable(false);
        r8.setEnabled(false);
        r8.setVisibility(4);
        goto L22
    L8:
        r4 = 8;
        goto L9
    }

    public final void c(boolean r1, boolean r2) {
        if (r1 == true) goto L4;
        setCommentInfoEnable(false);
        return;
    L4:
        if (this.e <= 0) goto L6;
        setCommentInfoEnable(true);
        return;
    L6:
        setCommentInfoEnable(r2);
    }

    public FileExtraInfoView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        b();
    }
}
