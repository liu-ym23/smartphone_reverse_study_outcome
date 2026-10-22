package com.bytedance.dux.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.bytedance.dux.divider.DuxDivider;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import em4.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0004defgJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u00100\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00103\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b1\u0010'\u001a\u0004\b2\u0010)R\u0017\u00106\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b4\u0010'\u001a\u0004\b5\u0010)R\u0017\u00109\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b7\u0010'\u001a\u0004\b8\u0010)R\u0017\u0010?\u001a\u00020:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010B\u001a\u00020:8\u0006¢\u0006\f\n\u0004\b@\u0010<\u001a\u0004\bA\u0010>R\u0017\u0010H\u001a\u00020C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0017\u0010N\u001a\u00020I8\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0017\u0010Q\u001a\u00020I8\u0006¢\u0006\f\n\u0004\bO\u0010K\u001a\u0004\bP\u0010MR\u0017\u0010T\u001a\u00020:8\u0006¢\u0006\f\n\u0004\bR\u0010<\u001a\u0004\bS\u0010>R\u0017\u0010W\u001a\u00020%8\u0006¢\u0006\f\n\u0004\bU\u0010'\u001a\u0004\bV\u0010)R\u0017\u0010]\u001a\u00020X8\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0017\u0010`\u001a\u00020X8\u0006¢\u0006\f\n\u0004\b^\u0010Z\u001a\u0004\b_\u0010\\R\u0017\u0010c\u001a\u00020X8\u0006¢\u0006\f\n\u0004\ba\u0010Z\u001a\u0004\bb\u0010\\¨\u0006h"}, d2 = {"Lcom/bytedance/dux/forms/DuxLineInputView;", "Lcom/bytedance/dux/forms/AbsDuxForm;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setInputContainerBackground", "", "getText", "text", "setText", "Lcom/bytedance/dux/forms/DuxLineInputView$b;", "getConfig", "", ForwardDependency$ForwardLocation.FLAG, "setAutoHideClearWhenTextEmpty", "Landroid/view/View$OnFocusChangeListener;", "listener", "setEditTextOnFocusChangeListener", "Landroid/widget/EditText;", "getInterEditText", "Lcom/bytedance/dux/forms/DuxLineInputView$d;", "textExceedLengthListener", "setTextExceedLengthListener", "Lcom/bytedance/dux/forms/DuxLineInputView$c;", "textClearedListener", "setTextClearedListener", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "", "h", "I", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "arrangeDirection", "Landroid/widget/TextView;", RXScreenCaptureService.KEY_INDEX, "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Landroidx/appcompat/widget/AppCompatEditText;", ce.f26395j, "Landroidx/appcompat/widget/AppCompatEditText;", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "editText", ce.f26396k, "getTvErrorTips", "tvErrorTips", "l", "getTvCounter", "tvCounter", "m", "getTvAction", "tvAction", "Landroid/widget/ImageView;", OfficeSDKRequestTag.KEY_NEW_USER, "Landroid/widget/ImageView;", "getIvClear", "()Landroid/widget/ImageView;", "ivClear", "o", "getIvAction", "ivAction", "Lcom/bytedance/dux/divider/DuxDivider;", "p", "Lcom/bytedance/dux/divider/DuxDivider;", "getDivider", "()Lcom/bytedance/dux/divider/DuxDivider;", ItemStyle.ITEM_STYLE_DIVIDER, "Landroid/widget/RelativeLayout;", "q", "Landroid/widget/RelativeLayout;", "getPrefixContainer", "()Landroid/widget/RelativeLayout;", "prefixContainer", "r", "getSuffixContainer", "suffixContainer", "s", "getIvTitleIcon", "ivTitleIcon", "t", "getTvInputTips", "tvInputTips", "Landroid/view/ViewGroup;", "u", "Landroid/view/ViewGroup;", "getTitleContainer", "()Landroid/view/ViewGroup;", "titleContainer", BaseSwitches.V, "getInputContainer", "inputContainer", "w", "getActionContainer", "actionContainer", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxLineInputView extends AbsDuxForm {
    public static final /* synthetic */ int N = 0;
    public final boolean A;
    public final int B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f205125J;
    public final int K;
    public String L;
    public String M;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f205126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f205127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AppCompatEditText f205128j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f205129k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f205130l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f205131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f205132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ImageView f205133o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DuxDivider f205134p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RelativeLayout f205135q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RelativeLayout f205136r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ImageView f205137s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextView f205138t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ViewGroup f205139u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f205140v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ViewGroup f205141w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f205142x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b f205143y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public e f205144z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f205145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f205146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f205147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f205148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f205149e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f205150f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f205151g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f205152h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f205153i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public TextWatcher f205154j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View.OnFocusChangeListener f205155k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f205156l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Drawable f205157m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final View.OnClickListener f205158n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public View.OnClickListener f205159o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f205160p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Integer f205161q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Integer f205162r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Drawable f205163s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f205164t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f205165u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f205166v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final int f205167w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f205168x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Boolean f205169y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f205170z;

        public b(String r100, boolean r101, boolean r102, String r103, View r104, View r105, Integer r106, boolean r110, String r111, TextWatcher r112, View.OnFocusChangeListener r113, boolean r114, Drawable r115, View.OnClickListener r116, View.OnClickListener r117, String r118, Integer r119, Integer r210, Drawable r211, boolean r212, boolean r213, boolean r214, int r215, boolean r216, Boolean r217, boolean r218) {
            this.f205145a = r100;
            this.f205146b = r101;
            this.f205147c = r102;
            this.f205148d = r103;
            this.f205149e = r104;
            this.f205150f = r105;
            this.f205151g = r106;
            this.f205152h = r110;
            this.f205153i = r111;
            this.f205154j = r112;
            this.f205155k = r113;
            this.f205156l = r114;
            this.f205157m = r115;
            this.f205158n = r116;
            this.f205159o = r117;
            this.f205160p = r118;
            this.f205161q = r119;
            this.f205162r = r210;
            this.f205163s = r211;
            this.f205164t = r212;
            this.f205165u = r213;
            this.f205166v = r214;
            this.f205167w = r215;
            this.f205168x = r216;
            this.f205169y = r217;
            this.f205170z = r218;
        }
    }

    public interface c {
    }

    public interface d {
    }

    public static final class e implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxLineInputView f205171a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public e(DuxLineInputView r100) {
            this.f205171a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (this.f205171a.f205143y.f205151g == null) goto L14;
            int r101 = 0;
            if (r100 == null) goto L7;
            int r102 = r100.length();
        L8:
            Integer r103 = this.f205171a.f205143y.f205151g;
            if (r103 == null) goto L11;
            r101 = r103.intValue();
        L11:
            if (r102 <= r101) goto L15;
            this.f205171a.f205143y.getClass();
            return;
        L15:
            return;
        L7:
            r102 = 0;
            goto L8
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            DuxLineInputView r104 = this.f205171a;
            if (r104.f205143y.f205151g == null) goto L27;
            Resources r105 = r104.getResources();
            Object[] r106 = new Object[2];
            if (r100 == null) goto L7;
            String r107 = Integer.valueOf(r100.length()).toString();
        L8:
            r106[0] = r107;
            r106[1] = String.valueOf(this.f205171a.f205143y.f205151g);
            SpannableString r108 = new SpannableString(r105.getString(R.string.dux_form_counter, r106));
            if (r100 == null) goto L11;
            int r109 = r100.length();
        L12:
            Integer r110 = this.f205171a.f205143y.f205151g;
            if (r110 == null) goto L15;
            int r111 = r110.intValue();
        L16:
            if (r109 <= r111) goto L24;
            ForegroundColorSpan r112 = new ForegroundColorSpan(ContextCompat.getColor(this.f205171a.getContext(), R.color.Primary));
            if (r100 == null) goto L22;
            String r113 = Integer.valueOf(r100.length()).toString();
            if (r113 == null) goto L22;
            int r114 = r113.length();
        L23:
            r108.setSpan(r112, 0, r114, 18);
            this.f205171a.getDivider().setBackgroundColor(ContextCompat.getColor(this.f205171a.getContext(), R.color.Primary));
        L25:
            this.f205171a.getTvCounter().setText(r108, TextView.BufferType.SPANNABLE);
            return;
        L22:
            r114 = 0;
            goto L23
        L24:
            this.f205171a.getDivider().setStyle(0);
            goto L25
        L15:
            r111 = 0;
            goto L16
        L11:
            r109 = 0;
            goto L12
        L7:
            r107 = null;
            goto L8
        }
    }

    public static final class f implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxLineInputView f205172a;

        public f(DuxLineInputView r100) {
            this.f205172a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L5;
            DuxLineInputView r102 = this.f205172a;
            int r103 = DuxLineInputView.N;
            Object r104 = r102.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) r104).showSoftInput(r102, 0);
            return;
        L5:
            DuxLineInputView r105 = this.f205172a;
            int r106 = DuxLineInputView.N;
            Object r107 = r105.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) r107).hideSoftInputFromWindow(r105.getWindowToken(), 0);
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxLineInputView f205173a;

        public g(DuxLineInputView r100) {
            this.f205173a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f205173a.f205143y.getClass();
            this.f205173a.setText("");
            this.f205173a.f205143y.getClass();
        }
    }

    public static final class h implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxLineInputView f205174a;

        public h(DuxLineInputView r100) {
            this.f205174a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L11;
            DuxLineInputView r102 = this.f205174a;
            if (r102.f205143y.f205165u == true) goto L7;
        L9:
            DuxLineInputView r103 = this.f205174a;
            n.f(r103.f205132n);
            r103.f205143y.f205147c = false;
        L10:
            DuxLineInputView r104 = this.f205174a;
            Object r105 = r104.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) r105).showSoftInput(r104, 0);
            return;
        L7:
            if (TextUtils.isEmpty(r102.getText()) == false) goto L9;
            this.f205174a.hideClear();
            goto L10
        L11:
            DuxLineInputView r106 = this.f205174a;
            if (r106.f205143y.f205168x == false) goto L14;
        L15:
            this.f205174a.hideClear();
        L16:
            DuxLineInputView r107 = this.f205174a;
            Object r108 = r107.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) r108).hideSoftInputFromWindow(r107.getWindowToken(), 0);
            return;
        L14:
            if (TextUtils.isEmpty(r106.getText()) == false) goto L16;
            goto L15
        }
    }

    public static final class i implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxLineInputView f205175a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public i(DuxLineInputView r100) {
            this.f205175a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            this.f205175a.hideClear();
            return;
        L11:
            DuxLineInputView r102 = this.f205175a;
            n.f(r102.f205132n);
            r102.f205143y.f205147c = false;
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }
    }

    static {
    }

    public DuxLineInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 62);
    }

    public DuxLineInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 60);
    }

    public DuxLineInputView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 56);
    }

    public final void La() {
        n.e(this.f205127i);
        if (this.f205137s.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        n.e(this.f205139u);
    L8:
        this.C = false;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void S5() {
        n.e(this.f205129k);
        this.f205134p.setStyle(0);
        if (this.f205138t.getText().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        V5(this.f205138t.getText().toString());
    L8:
        this.D = false;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void T5() {
        setAdaptLargeFontInternal(this.f205143y.f205169y);
        String r100 = this.f205143y.f205145a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        this.f205127i.setText(this.f205143y.f205145a);
    L13:
        if (this.C == false) goto L15;
        n3();
    L16:
        Drawable r102 = this.f205143y.f205163s;
        if (r102 == null) goto L20;
        this.f205137s.setImageDrawable(r102);
        this.f205125J = true;
    L20:
        if (this.f205125J == true) goto L22;
        n.e(this.f205137s);
        if (this.f205127i.getVisibility() != 0) goto L31;
        boolean r103 = true;
    L32:
        if (r103 == true) goto L34;
    L35:
        n.e(this.f205139u);
    L36:
        this.f205125J = false;
    L38:
        if (this.f205143y.f205165u == false) goto L40;
        i r104 = new i(this);
        getTextWatchers().add(new WeakReference(r104));
        this.f205128j.addTextChangedListener(r104);
    L40:
        b r105 = this.f205143y;
        if (r105.f205146b == false) goto L46;
        if (r105.f205151g == null) goto L46;
        this.f205144z = new e(this);
        ArrayList<WeakReference<TextWatcher>> r106 = getTextWatchers();
        e r107 = this.f205144z;
        Intrinsics.checkNotNull(r107);
        r106.add(new WeakReference(r107));
        this.f205128j.addTextChangedListener(this.f205144z);
        n.f(this.f205130l);
    L46:
        if (this.f205143y.f205147c == true) goto L48;
        hideClear();
        this.f205128j.setOnFocusChangeListener(new f(this));
    L52:
        String r108 = this.f205143y.f205148d;
        if (r108 != null) goto L55;
    L58:
        boolean r109 = true;
    L59:
        if (r109 == true) goto L62;
        this.f205128j.setHint(this.f205143y.f205148d);
    L62:
        if (this.f205143y.f205149e == null) goto L65;
        this.f205135q.removeAllViews();
        this.f205135q.addView(this.f205143y.f205149e, new ConstraintLayout.LayoutParams(-2, -2));
        n.f(this.f205135q);
        this.F = true;
    L65:
        if (this.f205143y.f205150f == null) goto L67;
        this.f205136r.removeAllViews();
        this.f205136r.addView(this.f205143y.f205150f, new ConstraintLayout.LayoutParams(-2, -2));
        n.f(this.f205136r);
        this.G = true;
    L67:
        b r110 = this.f205143y;
        if (r110.f205164t == false) goto L71;
        r110.f205152h = false;
    L71:
        if (r110.f205152h == false) goto L73;
        n.f(this.f205134p);
        this.f205143y.f205152h = true;
    L74:
        String r111 = this.f205143y.f205153i;
        if (r111 != null) goto L77;
    L80:
        boolean r112 = true;
    L81:
        if (r112 == true) goto L93;
        this.f205131m.setText(this.f205143y.f205153i);
        Integer r113 = this.f205143y.f205161q;
        if (r113 == null) goto L85;
        TextView r114 = this.f205131m;
        Intrinsics.checkNotNull(r113);
        r114.setTextColor(r113.intValue());
    L86:
        b r115 = this.f205143y;
        if (r115.f205156l == false) goto L91;
        View.OnClickListener r116 = r115.f205158n;
        if (r116 == null) goto L91;
        this.f205131m.setOnClickListener(r116);
    L91:
        n.f(this.f205131m);
        this.H = true;
        goto L93
    L85:
        this.f205131m.setTextColor(ContextCompat.getColor(getContext(), R.color.TextPrimary));
    L93:
        if (this.f205143y.f205154j == null) goto L95;
        ArrayList<WeakReference<TextWatcher>> r117 = getTextWatchers();
        TextWatcher r118 = this.f205143y.f205154j;
        Intrinsics.checkNotNull(r118);
        r117.add(new WeakReference(r118));
        this.f205128j.addTextChangedListener(this.f205143y.f205154j);
    L95:
        Drawable r119 = this.f205143y.f205157m;
        if (r119 == null) goto L102;
        this.f205133o.setImageDrawable(r119);
        View.OnClickListener r120 = this.f205143y.f205159o;
        if (r120 == null) goto L100;
        this.f205133o.setOnClickListener(r120);
    L100:
        U5();
    L102:
        if (TextUtils.isEmpty(this.f205143y.f205160p) == true) goto L105;
        String r121 = this.f205143y.f205160p;
        Intrinsics.checkNotNull(r121);
        V5(r121);
    L105:
        if (this.f205143y.f205162r == null) goto L112;
        ViewGroup r122 = this.f205140v;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        if (r123 == null) goto L110;
        ConstraintLayout.LayoutParams r124 = (ConstraintLayout.LayoutParams) r123;
        Integer r125 = this.f205143y.f205162r;
        Intrinsics.checkNotNull(r125);
        ((ViewGroup.MarginLayoutParams) r124).height = r125.intValue();
        r122.setLayoutParams(r124);
    L129:
        if (this.f205143y.f205166v == false) goto L131;
        AppCompatEditText r126 = this.f205128j;
        r126.setSingleLine(false);
        r126.setLines(this.K);
    L132:
        String r127 = this.f205142x;
        if (r127 != null) goto L135;
    L138:
        boolean r128 = true;
    L139:
        if (r128 == true) goto L142;
        setText(this.f205142x);
    L142:
        if (this.A == true) goto L144;
    L152:
        this.f205128j.setGravity(this.B);
        View.OnFocusChangeListener r129 = this.f205143y.f205155k;
        if (r129 == null) goto L156;
        Intrinsics.checkNotNull(r129);
        setEditTextOnFocusChangeListener(r129);
    L156:
        if (this.C == false) goto L158;
        n3();
    L160:
        if (this.D == false) goto L168;
        String r130 = this.L;
        Intrinsics.checkNotNull(r130);
        if (r130 == null) goto L170;
        n.f(this.f205129k);
        this.f205129k.setText(r130);
        this.f205134p.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.Primary));
        if (n.d(this.f205138t) == false) goto L167;
        n.e(this.f205138t);
        this.E = false;
    L167:
        this.D = true;
        this.L = r130;
    L170:
        if (this.E == false) goto L172;
        String r131 = this.M;
        Intrinsics.checkNotNull(r131);
        V5(r131);
    L174:
        if (this.F == false) goto L176;
        n.f(this.f205135q);
        this.F = true;
    L178:
        if (this.G == false) goto L180;
        n.f(this.f205136r);
        this.G = true;
    L182:
        if (this.H == false) goto L184;
        n.f(this.f205131m);
        this.H = true;
    L186:
        if (this.I == false) goto L189;
        U5();
    L195:
        int r132 = this.f205143y.f205167w;
        if (r132 != 2) goto L198;
        this.f205128j.setFocusable(true);
        this.f205128j.setFocusableInTouchMode(true);
        this.f205128j.setOnClickListener(null);
        setOnClickListener(null);
    L203:
        if (getAdaptLargeFont() == false) goto L227;
        if (this.f205126h != 0) goto L212;
        this.f205127i.setTextSize(2, 13.0f);
        ViewGroup r133 = this.f205139u;
        ViewGroup.LayoutParams r134 = r133.getLayoutParams();
        if (r134 == null) goto L211;
        r134.height = -2;
        r133.setLayoutParams(r134);
        float r135 = 8;
        this.f205139u.setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, r135, R5(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r135, R5(Resources.getSystem()))));
    L213:
        this.f205131m.setTextSize(2, 15.0f);
        this.f205130l.setTextSize(2, 11.0f);
        ImageView r136 = this.f205132n;
        ViewGroup.LayoutParams r137 = r136.getLayoutParams();
        if (r137 == null) goto L248;
        float r138 = 20;
        r137.width = MathKt.roundToInt(TypedValue.applyDimension(2, r138, R5(Resources.getSystem())));
        r137.height = MathKt.roundToInt(TypedValue.applyDimension(2, r138, R5(Resources.getSystem())));
        r136.setLayoutParams(r137);
        ImageView r139 = this.f205133o;
        ViewGroup.LayoutParams r140 = r139.getLayoutParams();
        if (r140 == null) goto L246;
        r140.width = MathKt.roundToInt(TypedValue.applyDimension(2, r138, R5(Resources.getSystem())));
        r140.height = MathKt.roundToInt(TypedValue.applyDimension(2, r138, R5(Resources.getSystem())));
        r139.setLayoutParams(r140);
        ImageView r141 = this.f205137s;
        ViewGroup.LayoutParams r142 = r141.getLayoutParams();
        if (r142 == null) goto L244;
        float r143 = 10;
        r142.width = MathKt.roundToInt(TypedValue.applyDimension(2, r143, R5(Resources.getSystem())));
        r142.height = MathKt.roundToInt(TypedValue.applyDimension(2, r143, R5(Resources.getSystem())));
        r141.setLayoutParams(r142);
        TextView r144 = this.f205129k;
        ViewGroup.LayoutParams r145 = r144.getLayoutParams();
        if (r145 == null) goto L242;
        ViewGroup.MarginLayoutParams r146 = (ViewGroup.MarginLayoutParams) r145;
        r146.width = 0;
        r146.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 16, R5(Resources.getSystem()))));
        r144.setLayoutParams(r146);
        this.f205129k.setMaxLines(1);
        TextView r147 = this.f205138t;
        ViewGroup.LayoutParams r148 = r147.getLayoutParams();
        if (r148 == null) goto L240;
        ConstraintLayout.LayoutParams r149 = (ConstraintLayout.LayoutParams) r148;
        ((ViewGroup.MarginLayoutParams) r149).width = 0;
        r149.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r138, R5(Resources.getSystem()))));
        r149.goneEndMargin = 0;
        r147.setLayoutParams(r149);
        this.f205138t.setMaxLines(1);
        ConstraintSet r150 = new ConstraintSet();
        r150.clone(this);
        DuxDivider r151 = this.f205134p;
        ViewGroup.LayoutParams r152 = r151.getLayoutParams();
        if (r152 == null) goto L238;
        r152.height = MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.5d, R5(Resources.getSystem())));
        r151.setLayoutParams(r152);
        r150.connect(this.f205129k.getId(), 7, this.f205130l.getId(), 6);
        r150.connect(this.f205138t.getId(), 7, this.f205130l.getId(), 6);
        r150.applyTo(this);
        goto L227
    L238:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L240:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L242:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L244:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L246:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L248:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L211:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L212:
        this.f205127i.setTextSize(2, 15.0f);
    L227:
        if (this.f205143y.f205170z == true) goto L229;
        return;
    L229:
        if (getAdaptLargeFont() == true) goto L232;
        return;
    L232:
        if (this.f205126h != 0) goto L234;
        com.bytedance.dux.largefont.a.c(this.f205127i, 13.0f);
    L235:
        com.bytedance.dux.largefont.a.a(this.f205137s, 10, 10);
        com.bytedance.dux.largefont.a.c(this.f205128j, 15.0f);
        com.bytedance.dux.largefont.a.a(this.f205132n, 20, 20);
        com.bytedance.dux.largefont.a.a(this.f205133o, 20, 20);
        com.bytedance.dux.largefont.a.c(this.f205131m, 15.0f);
        com.bytedance.dux.largefont.a.c(this.f205129k, 11.0f);
        com.bytedance.dux.largefont.a.c(this.f205138t, 11.0f);
        com.bytedance.dux.largefont.a.c(this.f205130l, 12.0f);
        return;
    L234:
        com.bytedance.dux.largefont.a.c(this.f205127i, 15.0f);
        goto L235
    L198:
        if (r132 != 3) goto L203;
        this.f205128j.setFocusable(false);
        this.f205128j.setFocusableInTouchMode(false);
        this.f205128j.setOnClickListener(this.f205143y.f205159o);
        setOnClickListener(this.f205143y.f205159o);
        goto L203
    L189:
        if (this.f205133o.getVisibility() != 0) goto L191;
        boolean r153 = true;
    L192:
        if (r153 == false) goto L194;
        n.e(this.f205133o);
    L194:
        this.I = false;
        goto L195
    L191:
        r153 = false;
        goto L192
    L184:
        n.e(this.f205131m);
        this.H = false;
        goto L186
    L180:
        n.e(this.f205136r);
        this.G = false;
        goto L182
    L176:
        n.e(this.f205135q);
        this.F = false;
        goto L178
    L172:
        n.e(this.f205138t);
        this.E = false;
        goto L174
    L168:
        S5();
        goto L170
    L158:
        La();
        goto L160
    L144:
        if (this.f205143y.f205163s != null) goto L152;
        if (this.f205139u.getVisibility() != 0) goto L148;
        boolean r154 = true;
    L149:
        if (r154 == true) goto L151;
        n.f(this.f205139u);
    L151:
        n.f(this.f205137s);
        this.f205125J = true;
        goto L152
    L148:
        r154 = false;
        goto L149
    L135:
        if (r127.length() == 0) goto L138;
        r128 = false;
        goto L139
    L131:
        this.f205128j.setSingleLine(true);
        goto L132
    L110:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L112:
        if (getAdaptLargeFont() == false) goto L118;
        ViewGroup r155 = this.f205140v;
        ViewGroup.LayoutParams r156 = r155.getLayoutParams();
        if (r156 == null) goto L117;
        r156.height = -2;
        r155.setLayoutParams(r156);
        goto L129
    L117:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L118:
        ViewGroup r157 = this.f205140v;
        ViewGroup.LayoutParams r158 = r157.getLayoutParams();
        if (r158 == null) goto L250;
        ConstraintLayout.LayoutParams r159 = (ConstraintLayout.LayoutParams) r158;
        if (this.f205126h == 1) goto L123;
        int r160 = MathKt.roundToInt(TypedValue.applyDimension(1, 40, R5(Resources.getSystem())));
    L127:
        ((ViewGroup.MarginLayoutParams) r159).height = r160;
        r157.setLayoutParams(r159);
        goto L129
    L123:
        if (this.f205143y.f205164t == false) goto L125;
        r160 = MathKt.roundToInt(TypedValue.applyDimension(1, 36, R5(Resources.getSystem())));
        goto L127
    L125:
        r160 = MathKt.roundToInt(TypedValue.applyDimension(1, 52, R5(Resources.getSystem())));
        goto L127
    L250:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L77:
        if (r111.length() == 0) goto L80;
        r112 = false;
        goto L81
    L73:
        n.e(this.f205134p);
        this.f205143y.f205152h = false;
        goto L74
    L55:
        if (r108.length() == 0) goto L58;
        r109 = false;
        goto L59
    L48:
        this.f205132n.setOnClickListener(new g(this));
        if (TextUtils.isEmpty(this.f205128j.getText()) == false) goto L51;
        n.e(this.f205132n);
    L51:
        this.f205128j.setOnFocusChangeListener(new h(this));
        goto L52
    L34:
        if (TextUtils.isEmpty(this.f205127i.getText()) == false) goto L36;
    L31:
        r103 = false;
        goto L32
    L22:
        if (this.f205139u.getVisibility() != 0) goto L24;
        boolean r161 = true;
    L25:
        if (r161 == true) goto L27;
        n.f(this.f205139u);
    L27:
        n.f(this.f205137s);
        this.f205125J = true;
        goto L38
    L24:
        r161 = false;
        goto L25
    L15:
        La();
        goto L16
    L11:
        this.C = false;
        goto L13
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final void U5() {
        if (this.f205133o.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        n.f(this.f205133o);
    L8:
        this.I = true;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final String getText() {
        return String.valueOf(this.f205128j.getText());
    }

    public final void hideClear() {
        n.e(this.f205132n);
        this.f205143y.f205147c = false;
    }

    public final void n3() {
        n.f(this.f205127i);
        if (this.f205139u.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        n.f(this.f205139u);
    L8:
        this.C = true;
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        float r100 = 44;
        int r101 = MathKt.roundToInt(TypedValue.applyDimension(1, r100, R5(Resources.getSystem())));
        n.a(this.f205141w, MathKt.roundToInt(TypedValue.applyDimension(1, r100, R5(Resources.getSystem()))));
        n.c(this.f205141w, r101, r101, new View[]{this.f205131m, this.f205133o});
    }

    public final ViewGroup getActionContainer() {
        return this.f205141w;
    }

    public final int getArrangeDirection() {
        return this.f205126h;
    }

    public final b getConfig() {
        return this.f205143y;
    }

    public final DuxDivider getDivider() {
        return this.f205134p;
    }

    public final AppCompatEditText getEditText() {
        return this.f205128j;
    }

    public final ViewGroup getInputContainer() {
        return this.f205140v;
    }

    @Override // com.bytedance.dux.forms.AbsDuxForm
    public EditText getInterEditText() {
        return this.f205128j;
    }

    public final ImageView getIvAction() {
        return this.f205133o;
    }

    public final ImageView getIvClear() {
        return this.f205132n;
    }

    public final ImageView getIvTitleIcon() {
        return this.f205137s;
    }

    public final RelativeLayout getPrefixContainer() {
        return this.f205135q;
    }

    public final RelativeLayout getSuffixContainer() {
        return this.f205136r;
    }

    public final ViewGroup getTitleContainer() {
        return this.f205139u;
    }

    public final TextView getTvAction() {
        return this.f205131m;
    }

    public final TextView getTvCounter() {
        return this.f205130l;
    }

    public final TextView getTvErrorTips() {
        return this.f205129k;
    }

    public final TextView getTvInputTips() {
        return this.f205138t;
    }

    public final TextView getTvTitle() {
        return this.f205127i;
    }

    public static DisplayMetrics R5(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void V5(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f205138t.setText(r100);
        n.f(this.f205138t);
        if (this.f205129k.getVisibility() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        S5();
    L10:
        this.E = true;
        this.M = r100;
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final void Y5(b r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        this.f205143y = r100;
        Iterator<WeakReference<TextWatcher>> r101 = getTextWatchers().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        WeakReference<TextWatcher> r102 = r101.next();
        this.f205128j.removeTextChangedListener(r102.get());
        goto L4
    L6:
        T5();
    }

    public final void setArrangeDirection(int r100) {
        this.f205126h = r100;
    }

    public final void setAutoHideClearWhenTextEmpty(boolean r100) {
        b r101 = getConfig();
        r101.f205165u = r100;
        Y5(r101);
    }

    public final void setEditTextOnFocusChangeListener(View.OnFocusChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f205128j.setOnFocusChangeListener(r100);
    }

    public final void setInputContainerBackground(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f205140v.setBackground(r100);
    }

    public final void setText(String r100) {
        if (r100 == null) goto L7;
        this.f205128j.setText(r100);
        e r101 = this.f205144z;
        if (r101 == null) goto L8;
        r101.onTextChanged(r100, 0, 0, r100.length());
        return;
    L8:
        return;
    }

    public final void setTextClearedListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "textClearedListener");
        this.f205143y.getClass();
    }

    public final void setTextExceedLengthListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "textExceedLengthListener");
        this.f205143y.getClass();
    }

    public final void setTextWatcher(TextWatcher r100) {
        this.f205143y.f205154j = r100;
        T5();
    }

    public DuxLineInputView(Context r410, AttributeSet r411, int r412, int r413) {
        if ((r413 & 2) == 0) goto L5;
        AttributeSet r100 = null;
    L7:
        if ((r413 & 4) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r413 & 8) == 0) goto L13;
        int r110 = 1;
    L14:
        Intrinsics.checkNotNullParameter(r410, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r410, r100, r101, null, false);
        this.f205126h = r110;
        String r102 = "标题";
        Intrinsics.checkNotNullParameter("标题", "title");
        this.f205143y = new b("标题", false, false, null, null, null, null, true, null, null, null, false, null, null, null, null, null, null, null, false, false, false, 2, true, null, false);
        this.B = 16;
        this.C = true;
        this.K = 20;
        this.L = "";
        this.M = "";
        TypedArray r103 = r410.getTheme().obtainStyledAttributes(r100, new int[]{android.R.attr.gravity, android.R.attr.text, android.R.attr.hint, R.attr.adaptLargeFontMode, R.attr.formArrangeDirection, R.attr.formInputHeight, R.attr.formInputTips, R.attr.formLengthLimit, R.attr.formMultiLine, R.attr.formShowClear, R.attr.formShowCounter, R.attr.formShowDivider, R.attr.formShowTitleDefaultIcon, R.attr.formTitle, R.attr.limitLargeFontScale}, r101, 0);
        this.f205126h = r103.getInt(4, 1);
        String r104 = r103.getString(13);
        b r105 = this.f205143y;
        if (r104 == null) goto L18;
        r102 = r104;
    L18:
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r105.f205145a = r102;
        this.f205143y.f205147c = r103.getBoolean(9, true);
        this.f205143y.f205148d = r103.getString(2);
        this.f205143y.f205146b = r103.getBoolean(10, false);
        int r106 = r103.getInt(7, 0);
        if (r106 <= 0) goto L21;
        this.f205143y.f205151g = Integer.valueOf(r106);
    L21:
        int r107 = r103.getDimensionPixelSize(5, 0);
        if (r107 <= 0) goto L24;
        this.f205143y.f205162r = Integer.valueOf(r107);
    L24:
        this.f205143y.f205166v = r103.getBoolean(8, false);
        this.f205143y.f205152h = r103.getBoolean(11, true);
        this.f205143y.f205160p = r103.getString(6);
        this.f205142x = r103.getString(1);
        this.A = r103.getBoolean(12, false);
        this.B = r103.getInt(0, 16);
        if (r103.hasValue(3) == false) goto L27;
        this.f205143y.f205169y = Boolean.valueOf(r103.getBoolean(3, false));
    L27:
        this.f205143y.f205170z = r103.getBoolean(14, false);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        if (this.f205126h != 0) goto L30;
        int r108 = R.layout.dux_form_line_input_vertical;
    L31:
        LayoutInflater.from(r410).inflate(r108, this);
        this.f205127i = (TextView) findViewById(R.id.tv_title);
        AppCompatEditText r109 = (AppCompatEditText) findViewById(R.id.et_input);
        this.f205128j = r109;
        this.f205129k = (TextView) findViewById(R.id.tv_error_tips);
        this.f205130l = (TextView) findViewById(R.id.tv_counter);
        this.f205131m = (TextView) findViewById(R.id.tv_action);
        this.f205132n = (ImageView) findViewById(R.id.iv_clear);
        this.f205133o = (ImageView) findViewById(R.id.iv_action);
        this.f205134p = (DuxDivider) findViewById(R.id.divider);
        this.f205137s = (ImageView) findViewById(R.id.iv_title_icon);
        this.f205135q = (RelativeLayout) findViewById(R.id.prefix_container);
        this.f205136r = (RelativeLayout) findViewById(R.id.suffix_container);
        this.f205138t = (TextView) findViewById(R.id.tv_input_tips);
        this.f205139u = (ViewGroup) findViewById(R.id.title_container);
        this.f205140v = (ViewGroup) findViewById(R.id.input_container);
        this.f205141w = (ViewGroup) findViewById(R.id.action_container);
        Y5(this.f205143y);
        r109.setVerticalScrollBarEnabled(false);
        return;
    L30:
        r108 = R.layout.dux_form_line_input_horizontal;
        goto L31
    L13:
        r110 = 0;
        goto L14
    L9:
        r101 = r412;
        goto L11
    L5:
        r100 = r411;
        goto L7
    }
}
