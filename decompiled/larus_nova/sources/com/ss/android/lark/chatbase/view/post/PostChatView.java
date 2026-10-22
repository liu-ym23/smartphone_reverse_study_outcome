package com.ss.android.lark.chatbase.view.post;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.PostContentBlock;
import com.ss.android.lark.chat.utils.b0;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.ss.android.lark.widget.light.LKUILightTextView;
import mcc.b;
import mcc.c;
import mcc.e;
import mcc.f;
import mcc.g;
import mcc.h;
import mcc.i;
import mcc.l;
import mcc.n;
import mcc.o;
import y9c.d;

/* JADX INFO: loaded from: classes35.dex */
public class PostChatView extends ConstraintLayout {
    public boolean A;
    public boolean B;
    public boolean C;
    public PostContentBlock.e D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f416928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f416929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LKUILightTextView f416930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f416931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f416932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EllipsizeFrameLayout f416933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f416934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f416935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f416936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View.OnLongClickListener f416937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View.OnClickListener f416938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View.OnClickListener f416939l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f416940m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f416941n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public EllipsizeFrameLayout.a f416942o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f416943p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f416944q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f416945r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f416946s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f416947t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f416948u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f416949v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f416950w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f416951x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f416952y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f416953z;

    public interface a {
        void onClick();
    }

    private CharSequence getShowMoreText() {
        CharSequence r100 = this.f416951x;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return UIHelper.getString(R.string.Lark_Legacy_ChatShowMore);
    }

    public LKUILightTextView getContentView() {
        return this.f416930c;
    }

    public View getTitleDivisionView() {
        return this.f416929b;
    }

    public TextView getTitleView() {
        return this.f416928a;
    }

    public PostChatView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.B == false) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    public void setAbbreviationsClickListener(mcc.a r100) {
        this.f416930c.setAbbreviationClickListener(r100);
    }

    public void setAtSpanClickListener(b r100) {
        this.f416930c.setAtSpanClickListener(r100);
    }

    public void setAtUserGroupSpanClickListener(c r100) {
        this.f416930c.setAtUserGroupSpanClickListener(r100);
    }

    public void setCodeBlockV2ClickListener(e r100) {
        this.f416930c.setCodeBlockV2SpanCLickListener(r100);
    }

    public void setColumnsClickListener(f r100) {
        this.f416930c.setColumnsSpanClickListener(r100);
    }

    public void setEnableEllipsize(boolean r100) {
        this.f416941n = r100;
    }

    public void setImageClickListener(g r100) {
        this.f416930c.setImageSpanClickListener(r100);
    }

    public void setMaxHeightFactor(EllipsizeFrameLayout.a r100) {
        this.f416942o = r100;
    }

    public void setMentionSpanClickListener(i r100) {
        this.f416930c.setMentionSpanClickListener(r100);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        super.setOnClickListener(r100);
        this.f416938k = r100;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r100) {
        super.setOnLongClickListener(r100);
        this.f416937j = r100;
    }

    public void setOnLongTextClickListener(a r100) {
        this.f416940m = r100;
    }

    public void setPhoneSpanClickListener(l r100) {
        this.f416930c.setPhoneSpanClickListener(r100);
    }

    public void setPreMessageOnClickListener(View.OnClickListener r100) {
        this.f416939l = r100;
    }

    public void setShowMoreText(boolean r100) {
        this.f416950w = r100;
    }

    public void setShowMoreTextOverride(CharSequence r100) {
        this.f416951x = r100;
        TextView r101 = this.f416932e;
        if (r101 == null) goto L6;
        r101.setText(getShowMoreText());
        return;
    }

    public void setShowMoreTextSize(float r100) {
        this.f416932e.setTextSize(0, r100);
    }

    public void setShowMoreViewBg(int r100) {
        this.f416931d.setBackgroundResource(r100);
    }

    public void setSupportJumpToThread(boolean r100) {
        this.A = r100;
    }

    public void setTableClickListener(n r100) {
        this.f416930c.setTableSpanClickListener(r100);
    }

    public void setTextSize(int r100) {
        this.f416930c.setTextSize(r100);
    }

    public void setTitleDivisionViewVisible(int r100) {
        if (this.f416929b.getVisibility() == r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return;
    L8:
        ConstraintSet r102 = new ConstraintSet();
        r102.clone(this);
        r102.setVisibility(R.id.title_division, r100);
        r102.applyTo(this);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setTitleDrawableStart(Drawable r100) {
        this.f416928a.setCompoundDrawablesRelative(r100, null, null, null);
        this.f416928a.setCompoundDrawablePadding(UIHelper.dp2px(8.0f));
    }

    public void setTitleLayoutVisible(boolean r100) {
        boolean r101 = true;
        int r102 = 8;
        if (r100 == false) goto L11;
        if (this.f416929b.getVisibility() == 0) goto L7;
    L14:
        if (r101 == true) goto L16;
        return;
    L16:
        ConstraintSet r103 = new ConstraintSet();
        r103.clone(this);
        if (r100 == false) goto L19;
        int r104 = 0;
    L20:
        r103.setVisibility(R.id.title_division, r104);
        if (r100 == false) goto L23;
        r102 = 0;
    L23:
        r103.setVisibility(R.id.title, r102);
        r103.applyTo(this);
        if ((this.f416933f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        if (r100 == false) goto L27;
        float r105 = 8.0f;
    L28:
        int r106 = UIHelper.dp2px(r105);
        ((ViewGroup.MarginLayoutParams) this.f416933f.getLayoutParams()).setMargins(0, r106, 0, 0);
        return;
    L27:
        r105 = 0.0f;
        goto L28
    L30:
        return;
    L19:
        r104 = 8;
        goto L20
    L7:
        if (this.f416928a.getVisibility() != 0) goto L14;
    L9:
        r101 = false;
        goto L14
    L11:
        if (this.f416929b.getVisibility() != 8) goto L14;
        if (this.f416928a.getVisibility() == 8) goto L9;
        goto L9
    }

    public void setTitleTextColor(int r100) {
        this.f416928a.setTextColor(r100);
    }

    public void setTitleTextSize(float r100) {
        this.f416928a.setTextSize(0, r100);
    }

    public void setUrlSpanClickListener(o r100) {
        this.f416930c.setUrlSpanClickListener(r100);
    }

    public void setUsername(String r100) {
        this.f416952y = r100;
    }

    public void setVideoClickListener(h r100) {
        this.f416930c.setMediaSpanClickListener(r100);
    }

    public void setShowMoreViewBg(Drawable r100) {
        this.f416931d.setBackground(r100);
    }

    public PostChatView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public PostChatView(Context r100, AttributeSet r101, int r110) {
        super(r100, r101, r110);
        this.f416942o = new EllipsizeFrameLayout.a();
        this.f416949v = false;
        this.f416950w = true;
        this.f416951x = null;
        this.f416953z = false;
        this.A = true;
        this.B = false;
        this.C = false;
        this.D = null;
        TextView r102 = new TextView(r100);
        this.f416928a = r102;
        r102.setId(R.id.title);
        zz7.a.c(this.f416928a, 17);
        this.f416928a.setEllipsize(TextUtils.TruncateAt.END);
        ConstraintLayout.LayoutParams r103 = b0.a(-2.0f, -2.0f, 0, 0);
        r103.startToStart = 0;
        r103.endToEnd = 0;
        r103.topToTop = 0;
        r103.horizontalBias = 0.0f;
        addView(this.f416928a, r103);
        View r104 = new View(r100);
        this.f416929b = r104;
        r104.setId(R.id.title_division);
        this.f416929b.setBackgroundColor(UDColorUtils.getColor(r100, R.color.line_divider_default));
        ConstraintLayout.LayoutParams r105 = b0.a(0.0f, 0.5f, 8, 0);
        r105.startToStart = 0;
        r105.endToEnd = 0;
        r105.topToBottom = R.id.title;
        r105.horizontalBias = 0.0f;
        r105.goneTopMargin = 0;
        addView(this.f416929b, r105);
        EllipsizeFrameLayout r106 = new EllipsizeFrameLayout(r100);
        this.f416933f = r106;
        r106.setId(R.id.post_content_container);
        this.f416933f.setEnableEllipsize(false);
        ConstraintLayout.LayoutParams r107 = b0.a(-2.0f, -2.0f, 8, 0);
        r107.startToStart = 0;
        r107.endToEnd = 0;
        r107.topToBottom = R.id.title_division;
        r107.goneTopMargin = 0;
        r107.horizontalBias = 0.0f;
        addView(this.f416933f, r107);
        LinearLayout r108 = new LinearLayout(r100);
        this.f416934g = r108;
        r108.setOrientation(1);
        this.f416933f.addView(this.f416934g, new ViewGroup.LayoutParams(-2, -2));
        LKUILightTextView r111 = new LKUILightTextView(r100);
        this.f416930c = r111;
        r111.setId(R.id.post_content);
        this.f416934g.addView(this.f416930c);
        View r112 = new View(r100);
        this.f416931d = r112;
        r112.setId(R.id.post_show_more);
        ConstraintLayout.LayoutParams r113 = b0.a(0.0f, 48.0f, 0, 0);
        r113.startToStart = 0;
        r113.endToEnd = 0;
        r113.bottomToBottom = 0;
        this.f416931d.setVisibility(8);
        addView(this.f416931d, r113);
        TextView r114 = new TextView(r100);
        this.f416932e = r114;
        r114.setId(R.id.post_show_more_text);
        this.f416932e.setBackgroundResource(R.drawable.chat_post_bg_show_more);
        this.f416932e.setGravity(17);
        this.f416932e.setPadding(d.b(r100, 15.0f), d.b(r100, 2.0f), d.b(r100, 15.0f), d.b(r100, 6.0f));
        this.f416932e.setText(R.string.Lark_Legacy_ChatShowMore);
        this.f416932e.setVisibility(8);
        zz7.a.c(this.f416932e, 14);
        this.f416932e.setTextColor(d.c(r100, R.color.text_title));
        this.f416932e.setVisibility(8);
        ConstraintLayout.LayoutParams r109 = b0.a(-2.0f, -2.0f, 0, 3);
        r109.startToStart = 0;
        r109.endToEnd = 0;
        r109.bottomToBottom = 0;
        addView(this.f416932e, r109);
    }

    public final void R5(String r100, Layout r101, CharSequence r102, boolean r103, String r104, String r105, String r106, boolean r107, String r108, boolean r110, boolean r111, boolean r112, boolean r113) {
        this.f416943p = r107;
        this.f416944q = r108;
        this.f416945r = r103;
        this.f416948u = r104;
        this.f416947t = r105;
        this.f416946s = r106;
        this.f416949v = r111;
        this.B = r113;
        this.f416953z = r112;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        setTitleLayoutVisible(false);
    L20:
        this.f416932e.setText(getShowMoreText());
        this.f416932e.setOnClickListener(new com.ss.android.lark.chatbase.view.post.a(this));
        if ((this.f416933f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) this.f416933f.getLayoutParams();
        if (this.f416943p == false) goto L25;
        r109.topMargin = 0;
        this.f416933f.setLayoutParams(r109);
        goto L26
    L25:
        r109.topMargin = 8;
        this.f416933f.setLayoutParams(r109);
    L26:
        this.f416933f.setMaxHeightFactor(this.f416942o);
        this.f416933f.setEllipsizeListener(new c7b.a(this));
        if (r110 == true) goto L29;
        this.f416933f.setEnableEllipsize(this.f416941n);
    L31:
        if (this.B == true) goto L34;
        this.f416930c.setOnClickListener(new c7b.b(this));
        this.f416930c.setOnLongClickListener(new c7b.d(this));
    L34:
        if (this.f416953z == false) goto L38;
        if (r102 != null) goto L37;
        UIUtils.hide(this.f416930c);
    L42:
        if (this.B == true) goto L46;
        setOnClickListener(new c7b.e(this));
        return;
    L46:
        return;
    L37:
        UIUtils.show(this.f416930c);
        this.f416930c.setContentText(r102);
        goto L42
    L38:
        if (r101 != null) goto L40;
        UIUtils.hide(this.f416930c);
        goto L42
    L40:
        UIUtils.show(this.f416930c);
        this.f416930c.setContentLayout(r101);
        goto L42
    L29:
        this.f416933f.setEnableEllipsize(false);
        goto L31
    L5:
        setTitleLayoutVisible(true);
        if (r110 == false) goto L8;
        this.f416928a.setMaxLines(1000);
    L9:
        SpannableStringBuilder r114 = new SpannableStringBuilder();
        if (TextUtils.isEmpty(this.f416952y) == true) goto L12;
        r114.append(this.f416952y).append(": ");
    L12:
        SpannableString r115 = new SpannableString(r100);
        if (this.f416943p == false) goto L15;
        r115.setSpan(new StyleSpan(0), 0, r115.length(), 33);
    L16:
        r114.append(r115);
        this.f416928a.setText(r114);
        if (this.f416943p == true) goto L19;
        this.f416928a.setTextColor(UDColorUtils.getColor(getContext(), R.color.text_title));
        setTitleDrawableStart(null);
        goto L20
    L19:
        this.f416928a.setPadding(UIUtils.dp2px(getContext(), 1.0f), UIUtils.dp2px(getContext(), 3.0f), UIUtils.dp2px(getContext(), 1.0f), UIUtils.dp2px(getContext(), 3.0f));
        this.f416928a.requestLayout();
        this.f416928a.setTextColor(UDColorUtils.getColor(getContext(), R.color.text_title));
        setTitleDrawableStart(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_announce_filled, UDColorUtils.getColor(getContext(), R.color.udtoken_message_card_text_orange), new UDDimension.Dp(zz7.b.f(16.0f))));
        zz7.a.d(this.f416928a, LarkFont.HEADLINE);
        goto L20
    L15:
        r115.setSpan(new StyleSpan(1), 0, r115.length(), 33);
        goto L16
    L8:
        this.f416928a.setMaxLines(2);
        goto L9
    }
}
