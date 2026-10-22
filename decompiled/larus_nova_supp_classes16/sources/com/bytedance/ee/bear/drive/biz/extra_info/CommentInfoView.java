package com.bytedance.ee.bear.drive.biz.extra_info;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.util.ui.ColorUtils;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CommentInfoView extends FrameLayout {
    public TextView a;
    public ImageView b;
    public int c;

    public CommentInfoView(Context r1) {
        super(r1);
    }

    private void setNormalTextViewAttribute(TextView r7) {
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        r0.setMargins(getResources().getDimensionPixelOffset(2131166305), getResources().getDimensionPixelOffset(2131166307), getResources().getDimensionPixelOffset(2131166309), getResources().getDimensionPixelOffset(2131166309));
        r7.setLayoutParams(r0);
        r7.setPadding(getResources().getDimensionPixelOffset(2131166306), getResources().getDimensionPixelOffset(2131166309), getResources().getDimensionPixelOffset(2131166309), getResources().getDimensionPixelOffset(2131166304));
    }

    private void setTvCommentCardTextV1(int r4) {
        if (r4 != getResources().getInteger(2131427353)) goto L5;
        this.b.setImageResource(2131253538);
        this.a.setVisibility(8);
        return;
    L5:
        this.b.setImageResource(2131254144);
        this.a.setVisibility(0);
        if (r4 > getResources().getInteger(2131427352)) goto L8;
        setNormalTextViewAttribute(this.a);
        this.a.setText(String.format("%d", new Object[]{Integer.valueOf(r4)}));
        return;
    L8:
        setUnnormalTextViewAttribute(this.a);
        this.a.setText("99+");
    }

    private void setTvCommentCardTextV2(int r4) {
        if (r4 > getResources().getInteger(2131427352)) goto L5;
        this.a.setText(String.format("%d", new Object[]{Integer.valueOf(r4)}));
        return;
    L5:
        this.a.setText("99+");
    }

    private void setUnnormalTextViewAttribute(TextView r7) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) r7.getLayoutParams();
        r0.gravity = 5;
        r0.setMargins(getResources().getDimensionPixelOffset(2131166309), getResources().getDimensionPixelOffset(2131166308), getResources().getDimensionPixelOffset(2131166309), getResources().getDimensionPixelOffset(2131166309));
        r7.setLayoutParams(r0);
        r7.setPadding(getResources().getDimensionPixelOffset(2131166306), getResources().getDimensionPixelOffset(2131166309), getResources().getDimensionPixelOffset(2131166309), getResources().getDimensionPixelOffset(2131166304));
    }

    public final void a(Context r2) {
        if (n.d == false) goto L5;
        FrameLayout.inflate(r2, 2131560183, this);
        this.c = getResources().getColor(2131106607);
    L6:
        this.a = (TextView) findViewById(2131390341);
        this.b = (ImageView) findViewById(2131376120);
        return;
    L5:
        FrameLayout.inflate(r2, 2131560182, this);
        this.c = getResources().getColor(2131106622);
        goto L6
    }

    public void setContentAlpha(int r3) {
        this.b.setImageAlpha(r3);
        this.a.setTextColor(ColorUtils.c(r3, this.c));
    }

    public void setTvCommentCardText(int r2) {
        if (n.d == false) goto L5;
        setTvCommentCardTextV2(r2);
        return;
    L5:
        setTvCommentCardTextV1(r2);
    }

    public CommentInfoView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public CommentInfoView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }
}
