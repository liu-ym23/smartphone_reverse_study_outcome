package com.obric.oui.forms;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0002?@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u000fH\u0016R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010'\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001dR\u0017\u0010*\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010\u001dR\u0017\u00100\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00106\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u00109\u001a\u0002018\u0006¢\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u00105R\"\u0010>\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00103\u001a\u0004\b;\u00105\"\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView;", "Lcom/obric/oui/forms/AbsOForm;", "Landroid/view/View;", "view", "", "setPrefixView", "", "getText", "text", "setText", "Lcom/obric/oui/forms/OBoxInputView$b;", "getConfig", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "Landroid/widget/EditText;", "getInterEditText", "", "e", "I", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "arrangeDirection", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Landroidx/appcompat/widget/AppCompatEditText;", ce.f26391f, "Landroidx/appcompat/widget/AppCompatEditText;", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "editText", "h", "getTvErrorTips", "tvErrorTips", RXScreenCaptureService.KEY_INDEX, "getTvCounter", "tvCounter", "Landroid/widget/ImageView;", ce.f26395j, "Landroid/widget/ImageView;", "getIvTitleIcon", "()Landroid/widget/ImageView;", "ivTitleIcon", "Landroid/view/ViewGroup;", ce.f26396k, "Landroid/view/ViewGroup;", "getInputContainer", "()Landroid/view/ViewGroup;", "inputContainer", "l", "getPrefixContainer", "prefixContainer", "m", "getTitleContainer", "setTitleContainer", "(Landroid/view/ViewGroup;)V", "titleContainer", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBoxInputView extends AbsOForm {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f400857p = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f400858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f400859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatEditText f400860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f400861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f400862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f400863j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f400864k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f400865l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f400866m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f400867n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e f400868o;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f400869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f400870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f400871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f400872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f400873e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f400874f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextWatcher f400875g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f400876h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f400877i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f400878j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Drawable f400879k;

        public b(boolean r100, String r101, boolean r102, Integer r103, String r104, View r105, TextWatcher r106, int r107, int r108, boolean r110, Drawable r111) {
            this.f400869a = r100;
            this.f400870b = r101;
            this.f400871c = r102;
            this.f400872d = r103;
            this.f400873e = r104;
            this.f400874f = r105;
            this.f400875g = r106;
            this.f400876h = r107;
            this.f400877i = r108;
            this.f400878j = r110;
            this.f400879k = r111;
        }
    }

    static {
    }

    public OBoxInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14, 0);
    }

    public OBoxInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12, 0);
    }

    public OBoxInputView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 8, 0);
    }

    public final String getText() {
        return String.valueOf(this.f400860g.getText());
    }

    public final int getArrangeDirection() {
        return this.f400858e;
    }

    public final b getConfig() {
        return this.f400867n;
    }

    public final AppCompatEditText getEditText() {
        return this.f400860g;
    }

    public final ViewGroup getInputContainer() {
        return this.f400864k;
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return this.f400860g;
    }

    public final ImageView getIvTitleIcon() {
        return this.f400863j;
    }

    public final ViewGroup getPrefixContainer() {
        return this.f400865l;
    }

    public final ViewGroup getTitleContainer() {
        return this.f400866m;
    }

    public final TextView getTvCounter() {
        return this.f400862i;
    }

    public final TextView getTvErrorTips() {
        return this.f400861h;
    }

    public final TextView getTvTitle() {
        return this.f400859f;
    }

    public static final void R5(OBoxInputView r100) {
        int r101 = r100.f400860g.getLineCount();
        int r102 = r100.f400860g.getLineHeight();
        int r103 = r100.f400860g.getHeight();
        int r104 = r100.f400864k.getHeight();
        int r105 = ((r101 * r102) + r104) - r103;
        b r106 = r100.f400867n;
        if (r105 >= r106.f400876h) goto L5;
    L8:
        ViewGroup.LayoutParams r107 = r100.f400864k.getLayoutParams();
        r107.height = r104;
        r100.f400864k.setLayoutParams(r107);
        return;
    L5:
        if (r105 >= r106.f400877i) goto L8;
        r104 = r105;
        goto L8
    }

    private final void setPrefixView(View r100) {
        if (r100 == null) goto L5;
        this.f400865l.removeAllViews();
        this.f400865l.addView(r100, new ConstraintLayout.LayoutParams(-2, -2));
        return;
    }

    public final void setArrangeDirection(int r100) {
        this.f400858e = r100;
    }

    public final void setText(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L15;
        this.f400860g.setText(r100);
        e r102 = this.f400868o;
        if (r102 == null) goto L16;
        Intrinsics.checkNotNull(r100);
        r102.onTextChanged(r100, 0, 0, r100.length());
        return;
    L16:
        return;
    L15:
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
        this.f400860g.removeTextChangedListener(r102.get());
        goto L4
    L6:
        getTextWatchers().add(new WeakReference(r100));
        this.f400860g.addTextChangedListener(r100);
    }

    public final void setTitleContainer(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f400866m = r100;
    }

    public OBoxInputView(Context r110, AttributeSet r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f400858e = r113;
        this.f400867n = new b(false, null, false, null, null, null, null, 144, Integer.MAX_VALUE, false, null);
        TypedArray r100 = r110.getTheme().obtainStyledAttributes(r111, new int[]{R.attr.gravity, R.attr.text, R.attr.hint, com.larus.nova.R.attr.oui_formArrangeDirection, com.larus.nova.R.attr.oui_formAutoAdjustHeight, com.larus.nova.R.attr.oui_formInputHeight, com.larus.nova.R.attr.oui_formInputMaxHeight, com.larus.nova.R.attr.oui_formLengthLimit, com.larus.nova.R.attr.oui_formShowCounter, com.larus.nova.R.attr.oui_formShowTitleDefaultIcon, com.larus.nova.R.attr.oui_formTitle}, 0, 0);
        boolean r101 = true;
        setArrangeDirection(r100.getInt(3, 1));     // Catch: Throwable -> L96
        this.f400867n.f400873e = r100.getString(2);     // Catch: Throwable -> L96
        this.f400867n.f400871c = r100.getBoolean(8, false);     // Catch: Throwable -> L96
        int r102 = r100.getInt(7, 0);     // Catch: Throwable -> L96
        if (r102 <= 0) goto L6;
        b r103 = this.f400867n;     // Catch: Throwable -> L96
        r103.f400872d = Integer.valueOf(r102);     // Catch: Throwable -> L96
    L6:
        String r104 = r100.getString(10);     // Catch: Throwable -> L96
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L15;
        b r106 = this.f400867n;     // Catch: Throwable -> L96
        r106.f400870b = r104;     // Catch: Throwable -> L96
        r106.f400869a = true;     // Catch: Throwable -> L96
    L16:
        b r107 = this.f400867n;     // Catch: Throwable -> L96
        r107.f400876h = r100.getDimensionPixelSize(5, pla.d.c(r110, 144));     // Catch: Throwable -> L96
        b r108 = this.f400867n;     // Catch: Throwable -> L96
        r108.f400877i = r100.getDimensionPixelSize(6, Integer.MAX_VALUE);     // Catch: Throwable -> L96
        String r109 = r100.getString(1);     // Catch: Throwable -> L96
        boolean r114 = r100.getBoolean(9, false);     // Catch: Throwable -> L96
        b r115 = this.f400867n;     // Catch: Throwable -> L96
        r115.f400878j = r100.getBoolean(4, false);     // Catch: Throwable -> L96
        int r116 = r100.getInt(0, 48);     // Catch: Throwable -> L96
        r100.recycle();
        if (this.f400858e != 1) goto L20;
        int r117 = com.larus.nova.R.layout.o_form_box_horizontal;
    L21:
        LayoutInflater.from(r110).inflate(r117, this);
        TextView r118 = (TextView) findViewById(com.larus.nova.R.id.tv_title);
        this.f400859f = r118;
        ImageView r119 = (ImageView) findViewById(com.larus.nova.R.id.iv_title_icon);
        this.f400863j = r119;
        this.f400865l = (ViewGroup) findViewById(com.larus.nova.R.id.prefix_container);
        AppCompatEditText r120 = (AppCompatEditText) findViewById(com.larus.nova.R.id.edittext);
        this.f400860g = r120;
        TextView r121 = (TextView) findViewById(com.larus.nova.R.id.tv_counter);
        this.f400862i = r121;
        this.f400861h = (TextView) findViewById(com.larus.nova.R.id.tv_error_tips);
        r120.setOnFocusChangeListener(new com.obric.oui.forms.a(this));
        ViewGroup r122 = (ViewGroup) findViewById(com.larus.nova.R.id.input_container);
        this.f400864k = r122;
        this.f400866m = (ViewGroup) findViewById(com.larus.nova.R.id.title_container);
        b r123 = this.f400867n;
        Intrinsics.checkNotNullParameter(r123, "config");
        this.f400867n = r123;
        String r124 = r123.f400870b;
        if (r124 != null) goto L24;
    L27:
        boolean r125 = true;
    L28:
        if (r125 == true) goto L31;
        r118.setText(r123.f400870b);
    L31:
        if (r123.f400869a == false) goto L39;
        pla.j.f(r118);
        if (this.f400866m.getVisibility() != 0) goto L35;
        boolean r126 = true;
    L36:
        if (r126 == true) goto L38;
        pla.j.f(this.f400866m);
    L38:
        this.f400867n.f400869a = true;
    L46:
        View r127 = r123.f400874f;
        if (r127 == null) goto L50;
        Intrinsics.checkNotNull(r127);
        setPrefixView(r127);
    L50:
        if (TextUtils.isEmpty(r123.f400873e) == true) goto L53;
        r120.setHint(r123.f400873e);
    L53:
        if (r123.f400878j == false) goto L56;
        r120.addTextChangedListener(new c(this));
    L56:
        if (r123.f400871c == false) goto L65;
        if (r123.f400872d == null) goto L65;
        this.f400868o = new e(r123, this);
        ArrayList<WeakReference<TextWatcher>> r128 = getTextWatchers();
        e r129 = this.f400868o;
        Intrinsics.checkNotNull(r129);
        r128.add(new WeakReference(r129));
        r120.addTextChangedListener(this.f400868o);
        e r130 = this.f400868o;
        if (r130 == null) goto L63;
        r130.onTextChanged(r120.getText(), 0, 0, 0);
    L63:
        pla.j.f(r121);
    L65:
        if (r123.f400876h <= 0) goto L72;
        ViewGroup.LayoutParams r131 = r122.getLayoutParams();
        if (r131 == null) goto L70;
        ConstraintLayout.LayoutParams r132 = (ConstraintLayout.LayoutParams) r131;
        ((ViewGroup.MarginLayoutParams) r132).height = r123.f400876h;
        r122.setLayoutParams(r132);
        goto L72
    L70:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L72:
        if (r123.f400875g == null) goto L74;
        TextWatcher r133 = r123.f400875g;
        Intrinsics.checkNotNull(r133);
        setTextWatcher(r133);
    L74:
        Drawable r134 = r123.f400879k;
        if (r134 == null) goto L77;
        r119.setImageDrawable(r134);
    L77:
        if (r114 == true) goto L79;
    L87:
        if (r109 != null) goto L89;
    L92:
        if (r101 == true) goto L94;
        setText(r109);
    L94:
        r120.setGravity(r116);
        r120.setLines(20);
        r120.setSingleLine(false);
        return;
    L89:
        if (r109.length() == 0) goto L92;
        r101 = false;
        goto L92
    L79:
        if (r123.f400879k != null) goto L87;
        if (this.f400866m.getVisibility() != 0) goto L83;
        boolean r135 = true;
    L84:
        if (r135 == true) goto L86;
        pla.j.f(this.f400866m);
    L86:
        pla.j.f(r119);
        goto L87
    L83:
        r135 = false;
        goto L84
    L35:
        r126 = false;
        goto L36
    L39:
        pla.j.e(r118);
        if (r119.getVisibility() != 0) goto L42;
        boolean r136 = true;
    L43:
        if (r136 == true) goto L45;
        pla.j.e(this.f400866m);
    L45:
        this.f400867n.f400869a = false;
        goto L46
    L42:
        r136 = false;
        goto L43
    L24:
        if (StringsKt.isBlank(r124) == true) goto L27;
        r125 = false;
        goto L28
    L20:
        r117 = com.larus.nova.R.layout.o_form_box_vertical;
        goto L21
    L15:
        this.f400867n.f400870b = "标题";     // Catch: Throwable -> L96
        goto L16
    L9:
        if (r104.length() == 0) goto L12;
        r105 = false;
    L96:
        th = move-exception;
        r100.recycle();
        throw th;
    }

    public /* synthetic */ OBoxInputView(Context r100, AttributeSet r101, int r102, int r103, int r104) {
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        int r105 = 0;
        if ((r103 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r105 = 1;
    L11:
        this(r100, r101, r102, r105);
    }
}
