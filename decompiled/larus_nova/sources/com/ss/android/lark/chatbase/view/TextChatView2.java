package com.ss.android.lark.chatbase.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.view.TextChatView;
import com.ss.android.lark.chat.utils.b0;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.ss.android.lark.widget.light.LKUILightTextView;
import mcc.i;
import mcc.l;
import mcc.o;

/* JADX INFO: loaded from: classes35.dex */
public class TextChatView2 extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LKUILightTextView f416909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f416910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f416911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f416912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EllipsizeFrameLayout f416913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f416914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f416915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f416916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextChatView.a f416917i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f416918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f416919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f416920l;

    public void setTextColor(int r100) {
    }

    private CharSequence getShowMoreText() {
        CharSequence r100 = this.f416912d;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return UIHelper.getString(R.string.Lark_Legacy_ChatShowMore);
    }

    public LKUILightTextView getLightTextView() {
        return this.f416909a;
    }

    public CharSequence getText() {
        return this.f416919k;
    }

    public TextChatView2(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f416920l == false) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    public void setAbbreviationClickListener(mcc.a r100) {
        this.f416909a.setAbbreviationClickListener(r100);
    }

    public void setAtSpanClickListener(mcc.b r100) {
        this.f416909a.setAtSpanClickListener(r100);
    }

    public void setAtUserGroupSpanClickListener(mcc.c r100) {
        this.f416909a.setAtUserGroupSpanClickListener(r100);
    }

    public void setDisableTouchEvent(boolean r100) {
        this.f416920l = r100;
    }

    public void setEnableEllipsize(boolean r100) {
        this.f416913e.setEnableEllipsize(r100);
    }

    public void setMaxHeightFactor(EllipsizeFrameLayout.a r100) {
        this.f416913e.setMaxHeightFactor(r100);
    }

    public void setMentionSpanClickListener(i r100) {
        this.f416909a.setMentionSpanClickListener(r100);
    }

    public void setOnShoreMoreClickListener(TextChatView.a r100) {
        this.f416917i = r100;
    }

    public void setPhoneSpanClickListener(l r100) {
        this.f416909a.setPhoneSpanClickListener(r100);
    }

    public void setRenderWithCharSequence(boolean r100) {
        this.f416918j = r100;
    }

    public void setShowMoreTextOverride(CharSequence r100) {
        this.f416912d = r100;
    }

    public void setShowMoreTextSize(float r100) {
        this.f416911c.setTextSize(0, r100);
    }

    public void setShowMoreViewBg(int r100) {
        this.f416910b.setBackgroundResource(r100);
    }

    public void setText(CharSequence r100) {
        this.f416919k = r100;
    }

    public void setTextSize(float r100) {
        this.f416909a.setTextSize((int) r100);
    }

    public void setUrlSpanClickListener(o r100) {
        this.f416909a.setUrlSpanClickListener(r100);
    }

    public TextChatView2(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public TextChatView2(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f416912d = null;
        this.f416918j = false;
        this.f416919k = null;
        this.f416920l = false;
        EllipsizeFrameLayout r103 = new EllipsizeFrameLayout(r100);
        this.f416913e = r103;
        r103.setId(R.id.post_content_container);
        this.f416913e.setEnableEllipsize(false);
        ConstraintLayout.LayoutParams r104 = b0.a(-2.0f, -2.0f, 0, 0);
        r104.startToStart = 0;
        r104.endToEnd = 0;
        r104.topToTop = 0;
        r104.horizontalBias = 0.0f;
        addView(this.f416913e, r104);
        LinearLayout r105 = new LinearLayout(r100);
        this.f416914f = r105;
        r105.setOrientation(1);
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        this.f416913e.addView(this.f416914f, r106);
        this.f416909a = new LKUILightTextView(r100);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        this.f416909a.setId(R.id.message);
        this.f416914f.addView(this.f416909a, r107);
        View r108 = new View(r100);
        this.f416910b = r108;
        r108.setId(R.id.post_show_more);
        ConstraintLayout.LayoutParams r109 = b0.a(0.0f, 48.0f, 0, 0);
        r109.startToStart = 0;
        r109.endToEnd = 0;
        r109.bottomToBottom = R.id.post_content_container;
        this.f416910b.setVisibility(8);
        addView(this.f416910b, r109);
        TextView r110 = new TextView(r100);
        this.f416911c = r110;
        r110.setId(R.id.post_show_more_text);
        this.f416911c.setBackgroundResource(R.drawable.chat_post_bg_show_more);
        this.f416911c.setGravity(17);
        this.f416911c.setPadding(y9c.d.b(r100, 15.0f), 0, y9c.d.b(r100, 15.0f), y9c.d.b(r100, 5.0f));
        this.f416911c.setText(R.string.Lark_Legacy_ChatShowMore);
        this.f416911c.setVisibility(8);
        zz7.a.c(this.f416911c, 14);
        this.f416911c.setTextColor(y9c.d.c(r100, R.color.text_title));
        ConstraintLayout.LayoutParams r111 = b0.a(-2.0f, -2.0f, 0, -5);
        r111.startToStart = 0;
        r111.endToEnd = 0;
        r111.bottomToBottom = R.id.post_content_container;
        addView(this.f416911c, r111);
    }

    public final void R5(Layout r100, Drawable r101, boolean r102, EllipsizeFrameLayout.a r103) {
        this.f416911c.setText(getShowMoreText());
        this.f416910b.setBackground(r101);
        this.f416911c.setOnClickListener(new e(this));
        this.f416913e.setMaxHeightFactor(r103);
        this.f416913e.setEnableEllipsize(r102);
        this.f416913e.setEllipsizeListener(new d(this));
        boolean r104 = this.f416918j;
        if (r100 != null) goto L5;
        UIUtils.hide(this.f416909a);
        return;
    L5:
        UIUtils.show(this.f416909a);
        this.f416909a.setContentLayout(r100);
    }
}
