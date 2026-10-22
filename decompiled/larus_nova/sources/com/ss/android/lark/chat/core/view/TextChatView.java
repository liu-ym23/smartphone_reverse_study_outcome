package com.ss.android.lark.chat.core.view;

import a08.b;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.richtext.RichTextView;
import mcc.i;
import y9c.d;

/* JADX INFO: loaded from: classes35.dex */
public class TextChatView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RichTextView f414778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f414779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f414780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EllipsizeFrameLayout f414781d;

    public interface a {
        void onClick();
    }

    public void setOnShoreMoreClickListener(a r100) {
    }

    public RichTextView getRichTextView() {
        return this.f414778a;
    }

    public TextChatView(Context r100) {
        this(r100, null);
    }

    public void setAbbreviationClickListener(LinkEmojiTextView.e r100) {
        this.f414778a.setAbbreviationListener(r100);
    }

    public void setAtStringClickListener(LinkEmojiTextView.f r100) {
        this.f414778a.setAtStringClickListner(r100);
    }

    public void setEmojiSize(int r100) {
        int r101 = DesktopUtil.f420394a;
        this.f414778a.setEmojIconSize(r100);
    }

    public void setEnableEllipsize(boolean r100) {
        this.f414781d.setEnableEllipsize(r100);
    }

    public void setMaxHeightFactor(EllipsizeFrameLayout.a r100) {
        this.f414781d.setMaxHeightFactor(r100);
    }

    public void setMentionStringClickListener(i r100) {
        this.f414778a.setMentionListener(r100);
    }

    public void setPhoneStringClickListener(LinkEmojiTextView.h r100) {
        this.f414778a.setPhoneStringClickListener(r100);
    }

    public void setRichTextClickListener(RichTextView.d r100) {
        this.f414778a.setRichTextListener(r100);
    }

    public void setShowMoreTextSize(float r100) {
        TextView r101 = this.f414780c;
        r101.setTextSize(0, b.a(r100, r101.getContext()));
    }

    public void setShowMoreViewBg(Drawable r100) {
        this.f414779b.setBackground(r100);
    }

    public void setTextColor(int r100) {
        this.f414778a.setTextColor(r100);
    }

    public void setTextSize(float r100) {
        this.f414778a.setTextSize(b.a(r100, getContext()));
    }

    public void setUrlStringClickListener(LinkEmojiTextView.i r100) {
        this.f414778a.setUrlStringClickListner(r100);
    }

    public void setUseNewAtStyle(boolean r100) {
        this.f414778a.setUseNewAtStyle(r100);
    }

    public TextChatView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public TextChatView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        EllipsizeFrameLayout r103 = new EllipsizeFrameLayout(r100);
        this.f414781d = r103;
        r103.setId(R.id.post_content_container);
        this.f414781d.setEnableEllipsize(false);
        ConstraintLayout.LayoutParams r104 = z4b.a.a(r100, -2.0f, -2.0f, 0);
        r104.startToStart = 0;
        r104.endToEnd = 0;
        r104.topToTop = 0;
        r104.horizontalBias = 0.0f;
        addView(this.f414781d, r104);
        RichTextView r105 = new RichTextView(r100);
        this.f414778a = r105;
        r105.setId(R.id.message);
        DesktopUtil.a(getContext());
        this.f414778a.setTextSize(zz7.b.h(getContext(), 17));
        this.f414778a.setEmojIconSize(zz7.b.g(r100, 20));
        this.f414781d.addView(this.f414778a);
        View r106 = new View(r100);
        this.f414779b = r106;
        r106.setId(R.id.post_show_more);
        this.f414779b.setVisibility(8);
        ConstraintLayout.LayoutParams r107 = z4b.a.a(r100, 0.0f, 48.0f, 0);
        r107.startToStart = 0;
        r107.endToEnd = 0;
        r107.bottomToBottom = R.id.post_content_container;
        addView(this.f414779b, r107);
        TextView r108 = new TextView(r100);
        this.f414780c = r108;
        r108.setId(R.id.post_show_more_text);
        this.f414780c.setBackgroundResource(R.drawable.chat_post_bg_show_more);
        this.f414780c.setGravity(17);
        this.f414780c.setPadding(d.b(r100, 15.0f), 0, d.b(r100, 15.0f), d.b(r100, 5.0f));
        this.f414780c.setText(R.string.Lark_Legacy_ChatShowMore);
        zz7.a.c(this.f414780c, 14);
        this.f414780c.setTextColor(d.c(r100, R.color.text_title));
        this.f414780c.setVisibility(8);
        ConstraintLayout.LayoutParams r109 = z4b.a.a(r100, -2.0f, -2.0f, -5);
        r109.startToStart = 0;
        r109.endToEnd = 0;
        r109.bottomToBottom = R.id.post_content_container;
        addView(this.f414780c, r109);
    }
}
