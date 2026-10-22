package com.bytedance.dux.forms;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import em4.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0002?@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u000fH\u0016R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010'\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR\u0017\u0010*\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010\u001dR\u0017\u00100\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00106\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u00109\u001a\u0002018\u0006¢\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u00105R\"\u0010>\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00103\u001a\u0004\b;\u00105\"\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/bytedance/dux/forms/DuxBoxInputView;", "Lcom/bytedance/dux/forms/AbsDuxForm;", "Landroid/view/View;", "view", "", "setPrefixView", "", "getText", "text", "setText", "Lcom/bytedance/dux/forms/DuxBoxInputView$b;", "getConfig", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "Landroid/widget/EditText;", "getInterEditText", "", "h", "I", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "arrangeDirection", "Landroid/widget/TextView;", RXScreenCaptureService.KEY_INDEX, "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Landroidx/appcompat/widget/AppCompatEditText;", ce.f26395j, "Landroidx/appcompat/widget/AppCompatEditText;", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "editText", ce.f26396k, "getTvErrorTips", "tvErrorTips", "l", "getTvCounter", "tvCounter", "Landroid/widget/ImageView;", "m", "Landroid/widget/ImageView;", "getIvTitleIcon", "()Landroid/widget/ImageView;", "ivTitleIcon", "Landroid/view/ViewGroup;", OfficeSDKRequestTag.KEY_NEW_USER, "Landroid/view/ViewGroup;", "getInputContainer", "()Landroid/view/ViewGroup;", "inputContainer", "o", "getPrefixContainer", "prefixContainer", "p", "getTitleContainer", "setTitleContainer", "(Landroid/view/ViewGroup;)V", "titleContainer", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxBoxInputView extends AbsDuxForm {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f205098s = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f205099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f205100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AppCompatEditText f205101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f205102k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f205103l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f205104m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewGroup f205105n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ViewGroup f205106o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f205107p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f205108q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public tl4.b f205109r;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f205110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f205111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f205112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f205113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f205114e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f205115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextWatcher f205116g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f205117h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Drawable f205118i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Boolean f205119j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f205120k;

        public b(boolean r100, String r101, boolean r102, Integer r103, String r104, View r105, TextWatcher r106, int r107, Drawable r108, Boolean r110, boolean r111) {
            this.f205110a = r100;
            this.f205111b = r101;
            this.f205112c = r102;
            this.f205113d = r103;
            this.f205114e = r104;
            this.f205115f = r105;
            this.f205116g = r106;
            this.f205117h = r107;
            this.f205118i = r108;
            this.f205119j = r110;
            this.f205120k = r111;
        }
    }

    public DuxBoxInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 62);
    }

    public DuxBoxInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 60);
    }

    public DuxBoxInputView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 56);
    }

    static {
        Resources r100 = Resources.getSystem();
        f205098s = MathKt.roundToInt(TypedValue.applyDimension(1, 144, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
    }

    public final String getText() {
        return String.valueOf(this.f205101j.getText());
    }

    public final int getArrangeDirection() {
        return this.f205099h;
    }

    public final b getConfig() {
        return this.f205108q;
    }

    public final AppCompatEditText getEditText() {
        return this.f205101j;
    }

    public final ViewGroup getInputContainer() {
        return this.f205105n;
    }

    @Override // com.bytedance.dux.forms.AbsDuxForm
    public EditText getInterEditText() {
        return this.f205101j;
    }

    public final ImageView getIvTitleIcon() {
        return this.f205104m;
    }

    public final ViewGroup getPrefixContainer() {
        return this.f205106o;
    }

    public final ViewGroup getTitleContainer() {
        return this.f205107p;
    }

    public final TextView getTvCounter() {
        return this.f205103l;
    }

    public final TextView getTvErrorTips() {
        return this.f205102k;
    }

    public final TextView getTvTitle() {
        return this.f205100i;
    }

    private final void setPrefixView(View r100) {
        if (r100 == null) goto L5;
        this.f205106o.removeAllViews();
        this.f205106o.addView(r100, new ConstraintLayout.LayoutParams(-2, -2));
        return;
    }

    public final void setArrangeDirection(int r100) {
        this.f205099h = r100;
    }

    public final void setText(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L14;
        this.f205101j.setText(r100);
        tl4.b r102 = this.f205109r;
        if (r102 == null) goto L15;
        Intrinsics.checkNotNull(r100);
        r102.onTextChanged(r100, 0, 0, r100.length());
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void setTextWatcher(TextWatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "textWatcher");
        Iterator<WeakReference<TextWatcher>> r101 = getTextWatchers().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        WeakReference<TextWatcher> r102 = r101.next();
        this.f205101j.removeTextChangedListener(r102.get());
        goto L4
    L6:
        getTextWatchers().add(new WeakReference(r100));
        this.f205101j.addTextChangedListener(r100);
    }

    public final void setTitleContainer(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f205107p = r100;
    }

    public DuxBoxInputView(Context r210, AttributeSet r211, int r212, int r310) {
        if ((r310 & 2) == 0) goto L5;
        AttributeSet r100 = null;
    L7:
        if ((r310 & 4) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r310 & 8) == 0) goto L13;
        int r110 = 1;
    L14:
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r100, r101, null, false);
        this.f205099h = r110;
        int r102 = f205098s;
        this.f205108q = new b(false, null, false, null, null, null, null, r102, null, null, false);
        TypedArray r103 = r210.getTheme().obtainStyledAttributes(r100, new int[]{R.attr.gravity, R.attr.text, R.attr.hint, com.larus.nova.R.attr.adaptLargeFontMode, com.larus.nova.R.attr.formArrangeDirection, com.larus.nova.R.attr.formInputHeight, com.larus.nova.R.attr.formLengthLimit, com.larus.nova.R.attr.formShowCounter, com.larus.nova.R.attr.formShowTitleDefaultIcon, com.larus.nova.R.attr.formTitle, com.larus.nova.R.attr.limitLargeFontScale}, 0, 0);
        this.f205099h = r103.getInt(4, 1);     // Catch: Throwable -> L134
        this.f205108q.f205114e = r103.getString(2);     // Catch: Throwable -> L134
        this.f205108q.f205112c = r103.getBoolean(7, false);     // Catch: Throwable -> L134
        int r104 = r103.getInt(6, 0);     // Catch: Throwable -> L134
        if (r104 <= 0) goto L18;
        this.f205108q.f205113d = Integer.valueOf(r104);     // Catch: Throwable -> L134
    L18:
        String r105 = r103.getString(9);     // Catch: Throwable -> L134
        if (r105 != null) goto L21;
    L24:
        boolean r106 = true;
    L25:
        if (r106 == true) goto L27;
        b r107 = this.f205108q;     // Catch: Throwable -> L134
        r107.f205111b = r105;     // Catch: Throwable -> L134
        r107.f205110a = true;     // Catch: Throwable -> L134
    L28:
        this.f205108q.f205117h = r103.getDimensionPixelSize(5, r102);     // Catch: Throwable -> L134
        String r108 = r103.getString(1);     // Catch: Throwable -> L134
        boolean r109 = r103.getBoolean(8, false);     // Catch: Throwable -> L134
        int r111 = r103.getInt(0, 48);     // Catch: Throwable -> L134
        if (r103.hasValue(3) == false) goto L31;
        this.f205108q.f205119j = Boolean.valueOf(r103.getBoolean(3, false));     // Catch: Throwable -> L134
    L31:
        this.f205108q.f205120k = r103.getBoolean(10, false);     // Catch: Throwable -> L134
        r103.recycle();
        if (this.f205099h != 1) goto L35;
        int r112 = com.larus.nova.R.layout.dux_form_box_horizontal;
    L36:
        LayoutInflater.from(r210).inflate(r112, this);
        TextView r113 = (TextView) findViewById(com.larus.nova.R.id.tv_title);
        this.f205100i = r113;
        ImageView r114 = (ImageView) findViewById(com.larus.nova.R.id.iv_title_icon);
        this.f205104m = r114;
        this.f205106o = (ViewGroup) findViewById(com.larus.nova.R.id.prefix_container);
        AppCompatEditText r115 = (AppCompatEditText) findViewById(com.larus.nova.R.id.edittext);
        this.f205101j = r115;
        TextView r116 = (TextView) findViewById(com.larus.nova.R.id.tv_counter);
        this.f205103l = r116;
        TextView r117 = (TextView) findViewById(com.larus.nova.R.id.tv_error_tips);
        this.f205102k = r117;
        r115.setOnFocusChangeListener(new tl4.a(this));
        ViewGroup r118 = (ViewGroup) findViewById(com.larus.nova.R.id.input_container);
        this.f205105n = r118;
        this.f205107p = (ViewGroup) findViewById(com.larus.nova.R.id.title_container);
        b r119 = this.f205108q;
        Intrinsics.checkNotNullParameter(r119, "config");
        this.f205108q = r119;
        setAdaptLargeFontInternal(r119.f205119j);
        String r120 = r119.f205111b;
        if (r120 != null) goto L39;
    L42:
        boolean r121 = true;
    L43:
        if (r121 == true) goto L46;
        r113.setText(r119.f205111b);
    L46:
        if (r119.f205110a == false) goto L54;
        n.f(r113);
        if (this.f205107p.getVisibility() != 0) goto L50;
        boolean r122 = true;
    L51:
        if (r122 == true) goto L53;
        n.f(this.f205107p);
    L53:
        this.f205108q.f205110a = true;
    L61:
        View r123 = r119.f205115f;
        if (r123 == null) goto L65;
        Intrinsics.checkNotNull(r123);
        setPrefixView(r123);
    L65:
        if (TextUtils.isEmpty(r119.f205114e) == true) goto L68;
        r115.setHint(r119.f205114e);
    L68:
        if (r119.f205112c == false) goto L76;
        if (r119.f205113d == null) goto L76;
        this.f205109r = new tl4.b(r119, this);
        ArrayList<WeakReference<TextWatcher>> r124 = getTextWatchers();
        tl4.b r125 = this.f205109r;
        Intrinsics.checkNotNull(r125);
        r124.add(new WeakReference(r125));
        r115.addTextChangedListener(this.f205109r);
        tl4.b r126 = this.f205109r;
        if (r126 == null) goto L74;
        r126.onTextChanged(r115.getText(), 0, 0, 0);
    L74:
        n.f(r116);
    L76:
        if (r119.f205117h <= 0) goto L83;
        ViewGroup.LayoutParams r127 = r118.getLayoutParams();
        if (r127 == null) goto L81;
        ConstraintLayout.LayoutParams r128 = (ConstraintLayout.LayoutParams) r127;
        ((ViewGroup.MarginLayoutParams) r128).height = r119.f205117h;
        r118.setLayoutParams(r128);
        goto L83
    L81:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L83:
        if (r119.f205116g == null) goto L85;
        TextWatcher r129 = r119.f205116g;
        Intrinsics.checkNotNull(r129);
        setTextWatcher(r129);
    L85:
        Drawable r130 = r119.f205118i;
        if (r130 == null) goto L88;
        r114.setImageDrawable(r130);
    L88:
        if (r109 == true) goto L90;
    L98:
        if (r108 != null) goto L100;
    L103:
        boolean r131 = true;
    L104:
        if (r131 == true) goto L106;
        setText(r108);
    L106:
        r115.setGravity(r111);
        if (getAdaptLargeFont() == false) goto L119;
        if (this.f205099h != 0) goto L112;
        r113.setTextSize(2, 13.0f);
        r117.setTextSize(2, 11.0f);
        r116.setTextSize(2, 11.0f);
    L115:
        ViewGroup.LayoutParams r132 = r114.getLayoutParams();
        if (r132 == null) goto L131;
        float r133 = 10;
        Resources r134 = Resources.getSystem();
        r132.width = MathKt.roundToInt(TypedValue.applyDimension(2, r133, WindowDisplayMetricsOverride.apply(r134, r134.getDisplayMetrics())));
        Resources r135 = Resources.getSystem();
        r132.height = MathKt.roundToInt(TypedValue.applyDimension(2, r133, WindowDisplayMetricsOverride.apply(r135, r135.getDisplayMetrics())));
        r114.setLayoutParams(r132);
        goto L119
    L131:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L112:
        ViewGroup.LayoutParams r136 = r116.getLayoutParams();
        if (r136 == null) goto L133;
        ViewGroup.MarginLayoutParams r137 = (ViewGroup.MarginLayoutParams) r136;
        Resources r138 = Resources.getSystem();
        r137.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r138, r138.getDisplayMetrics())));
        r116.setLayoutParams(r137);
        goto L115
    L133:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L119:
        if (this.f205108q.f205120k == true) goto L121;
    L128:
        r115.setLines(20);
        r115.setSingleLine(false);
        return;
    L121:
        if (getAdaptLargeFont() == false) goto L128;
        if (this.f205099h != 0) goto L126;
        com.bytedance.dux.largefont.a.c(r113, 13.0f);
        com.bytedance.dux.largefont.a.c(r116, 11.0f);
    L127:
        com.bytedance.dux.largefont.a.c(r117, 11.0f);
        com.bytedance.dux.largefont.a.a(r114, 10, 10);
        com.bytedance.dux.largefont.a.c(r115, 15.0f);
        goto L128
    L126:
        com.bytedance.dux.largefont.a.c(r113, 15.0f);
        com.bytedance.dux.largefont.a.c(r116, 12.0f);
        goto L127
    L100:
        if (r108.length() == 0) goto L103;
        r131 = false;
        goto L104
    L90:
        if (r119.f205118i != null) goto L98;
        if (this.f205107p.getVisibility() != 0) goto L94;
        boolean r139 = true;
    L95:
        if (r139 == true) goto L97;
        n.f(this.f205107p);
    L97:
        n.f(r114);
        goto L98
    L94:
        r139 = false;
        goto L95
    L50:
        r122 = false;
        goto L51
    L54:
        n.e(r113);
        if (r114.getVisibility() != 0) goto L57;
        boolean r140 = true;
    L58:
        if (r140 == true) goto L60;
        n.e(this.f205107p);
    L60:
        this.f205108q.f205110a = false;
        goto L61
    L57:
        r140 = false;
        goto L58
    L39:
        if (StringsKt.isBlank(r120) == true) goto L42;
        r121 = false;
        goto L43
    L35:
        r112 = com.larus.nova.R.layout.dux_form_box_vertical;
        goto L36
    L27:
        this.f205108q.f205111b = "标题";     // Catch: Throwable -> L134
        goto L28
    L21:
        if (r105.length() == 0) goto L24;
        r106 = false;
    L134:
        th = move-exception;
        r103.recycle();
        throw th;
    L13:
        r110 = 0;
        goto L14
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
