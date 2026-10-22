package com.suite.lark.platform.component.widget_biz_userstatus;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.f0;
import hpc.b;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes36.dex */
public class UserStatusLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f461150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UserStatusTextView f461151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f461152c;

    public class a implements LinkEmojiTextView.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkEmojiTextView.i f461153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UserStatusLinearLayout f461154b;

        public a(UserStatusLinearLayout r100, LinkEmojiTextView.i r101) {
            this.f461154b = r100;
            this.f461153a = r101;
        }

        @Override // com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView.i
        public final void a(View r100, String r101) {
            LinkEmojiTextView.i r102 = this.f461153a;
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            ipc.a r103 = b.a();
            this.f461154b.getClass();
            r103.a();
            return;
        }

        @Override // com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView.i
        public final boolean b(View r100, String r101) {
            LinkEmojiTextView.i r102 = this.f461153a;
            if (r102 != null) goto L5;
        L7:
            return false;
        L5:
            if (r102.b(r100, r101) == false) goto L7;
            return true;
        }
    }

    public final void a() {
        LinearLayout r100 = new LinearLayout(getContext());
        ViewGroup.LayoutParams r101 = new LinearLayout.LayoutParams(-1, -1);
        r100.setGravity(16);
        r100.setOrientation(0);
        addView(r100, r101);
        ImageView r102 = new ImageView(getContext());
        r102.setId(R.id.iv_icon);
        r102.setImageTintList(getContext().getResources().getColorStateList(R.color.line_divider_default));
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, UIUtils.dp2px(getContext(), 12.0f));
        r103.rightMargin = UIUtils.dp2px(getContext(), 6.0f);
        r103.topMargin = UIUtils.dp2px(getContext(), 1.0f);
        r100.addView(r102, r103);
        UserStatusTextView r104 = new UserStatusTextView(getContext());
        r104.setId(R.id.tv_desc);
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-2, -2);
        r104.setEllipsize(TextUtils.TruncateAt.END);
        r104.setMaxLines(1);
        r104.setSingleLine(true);
        r104.setTextColor(UIUtils.getColor(getContext(), R.color.text_placeholder));
        r100.addView(r104, r105);
        this.f461150a = (ImageView) findViewById(R.id.iv_icon);
        UserStatusTextView r106 = (UserStatusTextView) findViewById(R.id.tv_desc);
        this.f461151b = r106;
        r106.setUrlTextColor(getResources().getColor(R.color.text_link_normal));
        this.f461151b.setPhoneTextColor(getResources().getColor(R.color.text_link_normal));
        this.f461152c = "";
        setTextSize(12);
    }

    public int getMaxLines() {
        return this.f461151b.getMaxLines();
    }

    @Override // android.view.View
    public int getMinimumWidth() {
        return Math.max(super.getMinimumWidth(), this.f461150a.getMeasuredWidth());
    }

    public String getUserStatus() {
        return this.f461152c;
    }

    public UserStatusLinearLayout(Context r100) {
        super(r100);
        a();
    }

    public void setDividerDrawableColor(int r100) {
        this.f461150a.setImageTintList(getContext().getResources().getColorStateList(r100));
    }

    public void setIconGravity(int r100) {
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) this.f461150a.getLayoutParams();
        r101.gravity = r100;
        this.f461150a.setLayoutParams(r101);
    }

    public void setIconVisibility(int r100) {
        this.f461150a.setVisibility(r100);
    }

    public void setMaxLines(int r100) {
        this.f461151b.setMaxLines(r100);
    }

    public void setNeedToRecognize(boolean r100) {
        this.f461151b.setNeedToRecognize(r100);
    }

    public void setOnPhoneClickListener(LinkEmojiTextView.h r100) {
        this.f461151b.setPhoneStringClickListener(r100);
    }

    public void setOnURLClickListener(LinkEmojiTextView.i r100) {
        this.f461151b.setUrlStringClickListner(new a(this, r100));
    }

    public void setRecognizeTextColor(int r100) {
        this.f461151b.setPhoneTextColor(r100);
        this.f461151b.setUrlTextColor(r100);
    }

    public void setShowArrow(boolean r100) {
        this.f461151b.setShowArrow(r100);
    }

    public void setTextColor(int r100) {
        this.f461151b.setTextColor(r100);
    }

    public void setTextMaxWidth(int r100) {
        this.f461151b.setMaxWidth(r100);
    }

    public void setTextSize(int r100) {
        float r101 = r100;
        this.f461151b.setTextSize(r101);
        this.f461151b.setEmojiconSize(UIUtils.dp2px(getContext(), r101));
        this.f461151b.setMinHeight(UIUtils.dp2px(getContext(), r100 + 2));
    }

    public void setUrlOrPhoneColor(int r100) {
        this.f461151b.setUrlTextColor(r100);
        this.f461151b.setPhoneTextColor(r100);
    }

    public void setWidth(int r100) {
        this.f461151b.setWidth(r100);
    }

    public UserStatusLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public UserStatusLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }

    public final void b(String r100, String r101, Drawable r102, boolean r103, String r104, Long r110) {
        new WeakReference(this.f461151b);
        String r105 = r101 + r100 + 10;
        if (r110 != null) goto L5;
    L7:
        f0 r106 = f0.a.f448675a;
        RecogniseSpansResult r111 = r106.a(r105);
        if (TextUtils.isEmpty(r100) == false) goto L10;
        this.f461151b.H(r100, null, r103, r105);
    L13:
        this.f461150a.setImageDrawable(r102);
        this.f461152c = r100;
        return;
    L10:
        if (r111 != null) goto L12;
        this.f461151b.H(r100, r106.a(r100), r103, r105);
        b.a().b();
        goto L13
    L12:
        this.f461151b.H(r100, r111, r103, r105);
        goto L13
    L5:
        if (r110.longValue() <= 0) goto L7;
        r105 = r105 + "_" + r110;
        goto L7
    }
}
