package com.bytedance.ee.bear.drive.biz.extra_info;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;
import w55.n;

/* JADX INFO: loaded from: classes16.dex */
public class CommentInfoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f222936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f222937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f222938c;

    public CommentInfoView(Context r100) {
        super(r100);
    }

    private void setNormalTextViewAttribute(TextView r100) {
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, -2);
        r101.gravity = 17;
        r101.setMargins(getResources().getDimensionPixelOffset(R.dimen.drive_comment_card_left_margin), getResources().getDimensionPixelOffset(R.dimen.drive_comment_card_normal_top_margin), getResources().getDimensionPixelOffset(R.dimen.drive_comment_textview_zero), getResources().getDimensionPixelOffset(R.dimen.drive_comment_textview_zero));
        r100.setLayoutParams(r101);
        r100.setPadding(getResources().getDimensionPixelOffset(R.dimen.drive_comment_card_left_padding), getResources().getDimensionPixelOffset(R.dimen.drive_comment_textview_zero), getResources().getDimensionPixelOffset(R.dimen.drive_comment_textview_zero), getResources().getDimensionPixelOffset(R.dimen.drive_comment_card_bottom_padding));
    }

    private void setTvCommentCardTextV1(int r100) {
        if (r100 != getResources().getInteger(R.integer.drive_no_comment)) goto L5;
        this.f222937b.setImageResource(R.drawable.ud_icon_add_comment_outlined);
        this.f222936a.setVisibility(8);
        return;
    L5:
        this.f222937b.setImageResource(R.drawable.ud_icon_comment_number_a_outlined);
        this.f222936a.setVisibility(0);
        if (r100 > getResources().getInteger(R.integer.drive_comment_max_count)) goto L8;
        setNormalTextViewAttribute(this.f222936a);
        this.f222936a.setText(String.format("%d", new Object[]{Integer.valueOf(r100)}));
        return;
    L8:
        setUnnormalTextViewAttribute(this.f222936a);
        this.f222936a.setText("99+");
    }

    private void setTvCommentCardTextV2(int r100) {
        if (r100 > getResources().getInteger(R.integer.drive_comment_max_count)) goto L5;
        this.f222936a.setText(String.format("%d", new Object[]{Integer.valueOf(r100)}));
        return;
    L5:
        this.f222936a.setText("99+");
    }

    private void setUnnormalTextViewAttribute(TextView r100) {
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100.getLayoutParams();
        r101.gravity = 5;
        r101.setMargins(getResources().getDimensionPixelOffset(R.dimen.drive_comment_textview_zero), getResources().getDimensionPixelOffset(R.dimen.drive_comment_card_unnormal_top_margin), getResources().getDimensionPixelOffset(R.dimen.drive_comment_textview_zero), getResources().getDimensionPixelOffset(R.dimen.drive_comment_textview_zero));
        r100.setLayoutParams(r101);
        r100.setPadding(getResources().getDimensionPixelOffset(R.dimen.drive_comment_card_left_padding), getResources().getDimensionPixelOffset(R.dimen.drive_comment_textview_zero), getResources().getDimensionPixelOffset(R.dimen.drive_comment_textview_zero), getResources().getDimensionPixelOffset(R.dimen.drive_comment_card_bottom_padding));
    }

    public final void a(Context r100) {
        if (n.f558339d == false) goto L5;
        FrameLayout.inflate(r100, R.layout.drive_comment_card_view_v2, this);
        this.f222938c = getResources().getColor(R.color.text_caption);
    L6:
        this.f222936a = (TextView) findViewById(R.id.tv_comment_card);
        this.f222937b = (ImageView) findViewById(R.id.iv_comment_card);
        return;
    L5:
        FrameLayout.inflate(r100, R.layout.drive_comment_card_view, this);
        this.f222938c = getResources().getColor(R.color.text_title);
        goto L6
    }

    public void setContentAlpha(int r100) {
        this.f222937b.setImageAlpha(r100);
        this.f222936a.setTextColor(ColorUtils.c(r100, this.f222938c));
    }

    public void setTvCommentCardText(int r100) {
        if (n.f558339d == false) goto L5;
        setTvCommentCardTextV2(r100);
        return;
    L5:
        setTvCommentCardTextV1(r100);
    }

    public CommentInfoView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public CommentInfoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
