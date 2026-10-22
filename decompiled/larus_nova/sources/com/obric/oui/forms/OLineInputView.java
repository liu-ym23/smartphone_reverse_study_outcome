package com.obric.oui.forms;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.obric.oui.divider.ODivider;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0004{|}~J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0017\u0010,\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00102\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00105\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b3\u0010)\u001a\u0004\b4\u0010+R\u0017\u00108\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b6\u0010)\u001a\u0004\b7\u0010+R\u0017\u0010;\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b9\u0010)\u001a\u0004\b:\u0010+R\u0017\u0010A\u001a\u00020<8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010G\u001a\u00020B8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010J\u001a\u00020<8\u0006¢\u0006\f\n\u0004\bH\u0010>\u001a\u0004\bI\u0010@R\u0017\u0010M\u001a\u00020B8\u0006¢\u0006\f\n\u0004\bK\u0010D\u001a\u0004\bL\u0010FR\u0017\u0010S\u001a\u00020N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0017\u0010Y\u001a\u00020T8\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0017\u0010\\\u001a\u00020T8\u0006¢\u0006\f\n\u0004\bZ\u0010V\u001a\u0004\b[\u0010XR\u0017\u0010_\u001a\u00020<8\u0006¢\u0006\f\n\u0004\b]\u0010>\u001a\u0004\b^\u0010@R\u0017\u0010b\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b`\u0010)\u001a\u0004\ba\u0010+R\u0017\u0010h\u001a\u00020c8\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u0017\u0010k\u001a\u00020c8\u0006¢\u0006\f\n\u0004\bi\u0010e\u001a\u0004\bj\u0010gR\u0017\u0010n\u001a\u00020c8\u0006¢\u0006\f\n\u0004\bl\u0010e\u001a\u0004\bm\u0010gR$\u0010v\u001a\u0004\u0018\u00010o8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010z\u001a\u0004\u0018\u00010o8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010q\u001a\u0004\bx\u0010s\"\u0004\by\u0010u¨\u0006\u007f"}, d2 = {"Lcom/obric/oui/forms/OLineInputView;", "Lcom/obric/oui/forms/AbsOForm;", "", "enabled", "", "setEnabled", "Landroid/graphics/drawable/Drawable;", "drawable", "setInputContainerBackground", "", "getText", "text", "setText", "Lcom/obric/oui/forms/OLineInputView$b;", "getConfig", ForwardDependency$ForwardLocation.FLAG, "setAutoHideClearWhenTextEmpty", "Landroid/view/View$OnFocusChangeListener;", "listener", "setEditTextOnFocusChangeListener", "Landroid/widget/EditText;", "getInterEditText", "Lcom/obric/oui/forms/OLineInputView$d;", "textExceedLengthListener", "setTextExceedLengthListener", "Lcom/obric/oui/forms/OLineInputView$c;", "textClearedListener", "setTextClearedListener", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "", "e", "I", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "arrangeDirection", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Lcom/obric/oui/forms/OFormEditText;", ce.f26391f, "Lcom/obric/oui/forms/OFormEditText;", "getEditText", "()Lcom/obric/oui/forms/OFormEditText;", "editText", "h", "getTvErrorTips", "tvErrorTips", RXScreenCaptureService.KEY_INDEX, "getTvCounter", "tvCounter", ce.f26395j, "getTvAction", "tvAction", "Landroid/widget/ImageView;", ce.f26396k, "Landroid/widget/ImageView;", "getIvClear", "()Landroid/widget/ImageView;", "ivClear", "Landroid/widget/LinearLayout;", "l", "Landroid/widget/LinearLayout;", "getIvClearContainer", "()Landroid/widget/LinearLayout;", "ivClearContainer", "m", "getIvAction", "ivAction", OfficeSDKRequestTag.KEY_NEW_USER, "getIvActionContainer", "ivActionContainer", "Lcom/obric/oui/divider/ODivider;", "o", "Lcom/obric/oui/divider/ODivider;", "getDivider", "()Lcom/obric/oui/divider/ODivider;", ItemStyle.ITEM_STYLE_DIVIDER, "Landroid/widget/RelativeLayout;", "p", "Landroid/widget/RelativeLayout;", "getPrefixContainer", "()Landroid/widget/RelativeLayout;", "prefixContainer", "q", "getSuffixContainer", "suffixContainer", "r", "getIvTitleIcon", "ivTitleIcon", "s", "getTvInputTips", "tvInputTips", "Landroid/view/ViewGroup;", "t", "Landroid/view/ViewGroup;", "getTitleContainer", "()Landroid/view/ViewGroup;", "titleContainer", "u", "getInputContainer", "inputContainer", BaseSwitches.V, "getActionContainer", "actionContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "w", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getActiveBorderView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setActiveBorderView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "activeBorderView", "x", "getLeftContainer", "setLeftContainer", "leftContainer", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OLineInputView extends AbsOForm {
    public static final /* synthetic */ int P = 0;
    public e A;
    public final boolean B;
    public final int C;
    public final int D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f400955J;
    public boolean K;
    public boolean L;
    public final int M;
    public String N;
    public String O;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f400956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f400957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OFormEditText f400958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f400959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f400960i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f400961j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f400962k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinearLayout f400963l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f400964m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinearLayout f400965n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ODivider f400966o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RelativeLayout f400967p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RelativeLayout f400968q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ImageView f400969r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f400970s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ViewGroup f400971t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ViewGroup f400972u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f400973v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ConstraintLayout f400974w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ConstraintLayout f400975x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f400976y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b f400977z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f400978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f400979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f400980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f400981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f400982e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f400983f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f400984g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f400985h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f400986i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public TextWatcher f400987j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final View.OnFocusChangeListener f400988k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f400989l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Drawable f400990m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final View.OnClickListener f400991n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final View.OnClickListener f400992o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f400993p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Integer f400994q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Integer f400995r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Drawable f400996s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final boolean f400997t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f400998u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f400999v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final int f401000w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final boolean f401001x;

        public b(String r100, boolean r101, boolean r102, String r103, View r104, View r105, Integer r106, boolean r110, String r111, TextWatcher r112, View.OnFocusChangeListener r113, boolean r114, Drawable r115, View.OnClickListener r116, View.OnClickListener r117, String r118, Integer r119, Integer r210, Drawable r211, boolean r212, boolean r213, boolean r214, int r215, boolean r216) {
            this.f400978a = r100;
            this.f400979b = r101;
            this.f400980c = r102;
            this.f400981d = r103;
            this.f400982e = r104;
            this.f400983f = r105;
            this.f400984g = r106;
            this.f400985h = r110;
            this.f400986i = r111;
            this.f400987j = r112;
            this.f400988k = r113;
            this.f400989l = r114;
            this.f400990m = r115;
            this.f400991n = r116;
            this.f400992o = r117;
            this.f400993p = r118;
            this.f400994q = r119;
            this.f400995r = r210;
            this.f400996s = r211;
            this.f400997t = r212;
            this.f400998u = r213;
            this.f400999v = r214;
            this.f401000w = r215;
            this.f401001x = r216;
        }
    }

    public interface c {
    }

    public interface d {
    }

    public static final class e implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OLineInputView f401002a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public e(OLineInputView r100) {
            this.f401002a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (this.f401002a.f400977z.f400984g == null) goto L15;
            int r101 = 0;
            if (r100 != null) goto L7;
            int r102 = 0;
        L8:
            Integer r103 = this.f401002a.f400977z.f400984g;
            if (r103 == null) goto L12;
            r101 = r103.intValue();
        L12:
            if (r102 <= r101) goto L16;
            this.f401002a.f400977z.getClass();
            return;
        L16:
            return;
        L7:
            r102 = r100.length();
            goto L8
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            OLineInputView r104 = this.f401002a;
            if (r104.f400977z.f400984g == null) goto L28;
            Resources r105 = r104.getResources();
            Object[] r106 = new Object[2];
            if (r100 != null) goto L7;
            String r107 = null;
        L8:
            r106[0] = r107;
            r106[1] = String.valueOf(this.f401002a.f400977z.f400984g);
            SpannableString r108 = new SpannableString(r105.getString(R.string.oui_form_counter, r106));
            if (r100 != null) goto L11;
            int r109 = 0;
        L12:
            Integer r110 = this.f401002a.f400977z.f400984g;
            if (r110 != null) goto L15;
            int r111 = 0;
        L16:
            if (r109 <= r111) goto L25;
            ForegroundColorSpan r112 = new ForegroundColorSpan(ContextCompat.getColor(this.f401002a.getContext(), R.color.Primary));
            if (r100 != null) goto L20;
        L19:
            int r113 = 0;
        L24:
            r108.setSpan(r112, 0, r113, 18);
            this.f401002a.getDivider().setBackgroundColor(ContextCompat.getColor(this.f401002a.getContext(), R.color.Primary));
        L26:
            this.f401002a.getTvCounter().setText(r108, TextView.BufferType.SPANNABLE);
            return;
        L20:
            String r114 = Integer.valueOf(r100.length()).toString();
            if (r114 == null) goto L19;
            r113 = r114.length();
            goto L24
        L25:
            this.f401002a.getDivider().setStyle(0);
            goto L26
        L15:
            r111 = r110.intValue();
            goto L16
        L11:
            r109 = Integer.valueOf(r100.length()).intValue();
            goto L12
        L7:
            r107 = Integer.valueOf(r100.length()).toString();
            goto L8
        }
    }

    public static final class f implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OLineInputView f401003a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public f(OLineInputView r100) {
            this.f401003a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            this.f401003a.hideClear();
            return;
        L11:
            OLineInputView r102 = this.f401003a;
            pla.j.f(r102.f400963l);
            pla.j.f(r102.f400962k);
            r102.f400977z.f400980c = false;
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }
    }

    static {
    }

    public OLineInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14, 0);
    }

    public OLineInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12, 0);
    }

    public OLineInputView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r110, 8, 0);
    }

    public final void R5() {
        pla.j.e(this.f400959h);
        this.f400966o.setStyle(0);
        if (this.f400970s.getText().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        U5(this.f400970s.getText().toString());
    L8:
        this.F = false;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void T5() {
        String r100 = this.f400977z.f400978a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        this.f400957f.setText(this.f400977z.f400978a);
    L13:
        if (this.E == false) goto L15;
        n3();
    L22:
        Drawable r102 = this.f400977z.f400996s;
        if (r102 == null) goto L26;
        this.f400969r.setImageDrawable(r102);
        this.L = true;
    L26:
        if (this.L == true) goto L28;
        pla.j.e(this.f400969r);
        if (this.f400957f.getVisibility() != 0) goto L37;
        boolean r103 = true;
    L38:
        if (r103 == true) goto L40;
    L41:
        pla.j.e(this.f400971t);
    L42:
        this.L = false;
    L43:
        int r104 = this.C;
        if (r104 == 0) goto L48;
        if (r104 == 1) goto L47;
        ViewGroup.LayoutParams r105 = this.f400969r.getLayoutParams();
        r105.width = pla.d.n(this, 10);
        r105.height = pla.d.n(this, 10);
        this.f400969r.setLayoutParams(r105);
    L50:
        if (this.f400977z.f400998u == false) goto L52;
        f r106 = new f(this);
        getTextWatchers().add(new WeakReference(r106));
        this.f400958g.addTextChangedListener(r106);
    L52:
        b r107 = this.f400977z;
        if (r107.f400979b == false) goto L58;
        if (r107.f400984g == null) goto L58;
        this.A = new e(this);
        ArrayList<WeakReference<TextWatcher>> r108 = getTextWatchers();
        e r109 = this.A;
        Intrinsics.checkNotNull(r109);
        r108.add(new WeakReference(r109));
        this.f400958g.addTextChangedListener(this.A);
        pla.j.f(this.f400960i);
    L58:
        if (this.f400977z.f400980c == true) goto L60;
        hideClear();
        this.f400958g.setOnFocusChangeListener(new q(this));
    L64:
        String r110 = this.f400977z.f400981d;
        if (r110 != null) goto L67;
    L70:
        boolean r111 = true;
    L71:
        if (r111 == true) goto L74;
        this.f400958g.setHint(this.f400977z.f400981d);
    L74:
        if (this.f400977z.f400982e == null) goto L77;
        this.f400967p.removeAllViews();
        this.f400967p.addView(this.f400977z.f400982e, new ConstraintLayout.LayoutParams(-2, -2));
        pla.j.f(this.f400967p);
        this.H = true;
    L77:
        if (this.f400977z.f400983f == null) goto L79;
        this.f400968q.removeAllViews();
        this.f400968q.addView(this.f400977z.f400983f, new ConstraintLayout.LayoutParams(-2, -2));
        pla.j.f(this.f400968q);
        this.I = true;
    L79:
        b r112 = this.f400977z;
        if (r112.f400997t == false) goto L83;
        r112.f400985h = false;
    L83:
        if (r112.f400985h == false) goto L85;
        pla.j.f(this.f400966o);
        this.f400977z.f400985h = true;
    L86:
        String r113 = this.f400977z.f400986i;
        if (r113 != null) goto L89;
    L92:
        boolean r114 = true;
    L93:
        if (r114 == true) goto L105;
        this.f400961j.setText(this.f400977z.f400986i);
        Integer r115 = this.f400977z.f400994q;
        if (r115 == null) goto L97;
        TextView r116 = this.f400961j;
        Intrinsics.checkNotNull(r115);
        r116.setTextColor(r115.intValue());
    L98:
        b r117 = this.f400977z;
        if (r117.f400989l == false) goto L103;
        View.OnClickListener r118 = r117.f400991n;
        if (r118 == null) goto L103;
        this.f400961j.setOnClickListener(r118);
    L103:
        pla.j.f(this.f400961j);
        this.f400955J = true;
        goto L105
    L97:
        this.f400961j.setTextColor(ContextCompat.getColor(getContext(), R.color.TextPrimary));
    L105:
        if (this.f400977z.f400987j == null) goto L107;
        ArrayList<WeakReference<TextWatcher>> r119 = getTextWatchers();
        TextWatcher r120 = this.f400977z.f400987j;
        Intrinsics.checkNotNull(r120);
        r119.add(new WeakReference(r120));
        this.f400958g.addTextChangedListener(this.f400977z.f400987j);
    L107:
        Drawable r121 = this.f400977z.f400990m;
        if (r121 == null) goto L120;
        this.f400964m.setImageDrawable(r121);
        View.OnClickListener r122 = this.f400977z.f400992o;
        if (r122 == null) goto L113;
        this.f400964m.setOnClickListener(r122);
    L113:
        if (this.f400964m.getVisibility() != 0) goto L115;
        boolean r123 = true;
    L116:
        if (r123 == true) goto L118;
        pla.j.f(this.f400964m);
    L118:
        this.K = true;
        goto L120
    L115:
        r123 = false;
    L120:
        if (TextUtils.isEmpty(this.f400977z.f400993p) == true) goto L123;
        String r124 = this.f400977z.f400993p;
        Intrinsics.checkNotNull(r124);
        U5(r124);
    L123:
        if (this.f400977z.f400995r == null) goto L129;
        ViewGroup r125 = this.f400972u;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
        if (r126 == null) goto L128;
        ConstraintLayout.LayoutParams r127 = (ConstraintLayout.LayoutParams) r126;
        Integer r128 = this.f400977z.f400995r;
        Intrinsics.checkNotNull(r128);
        ((ViewGroup.MarginLayoutParams) r127).height = r128.intValue();
        r125.setLayoutParams(r127);
    L143:
        if (this.f400977z.f400999v == false) goto L145;
        OFormEditText r129 = this.f400958g;
        r129.setSingleLine(false);
        r129.setLines(this.M);
    L146:
        String r130 = this.f400976y;
        if (r130 != null) goto L149;
    L152:
        boolean r131 = true;
    L153:
        if (r131 == true) goto L156;
        setText(this.f400976y);
    L156:
        if (this.B == true) goto L158;
    L166:
        this.f400958g.setGravity(this.D);
        View.OnFocusChangeListener r132 = this.f400977z.f400988k;
        if (r132 == null) goto L170;
        Intrinsics.checkNotNull(r132);
        setEditTextOnFocusChangeListener(r132);
    L170:
        if (this.E == false) goto L172;
        n3();
    L180:
        if (this.F == false) goto L191;
        String r133 = this.N;
        Intrinsics.checkNotNull(r133);
        if (r133 == null) goto L193;
        pla.j.f(this.f400959h);
        this.f400959h.setText(r133);
        this.f400966o.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.Primary));
        TextView r134 = this.f400970s;
        Intrinsics.checkNotNullParameter(r134, "<this>");
        if (r134.getVisibility() != 0) goto L187;
        boolean r135 = true;
    L188:
        if (r135 == false) goto L190;
        pla.j.e(this.f400970s);
        this.G = false;
    L190:
        this.F = true;
        this.N = r133;
        goto L193
    L187:
        r135 = false;
    L193:
        if (this.G == false) goto L195;
        String r136 = this.O;
        Intrinsics.checkNotNull(r136);
        U5(r136);
    L197:
        if (this.H == false) goto L199;
        pla.j.f(this.f400967p);
        this.H = true;
    L201:
        if (this.I == false) goto L203;
        pla.j.f(this.f400968q);
        this.I = true;
    L205:
        if (this.f400955J == false) goto L207;
        pla.j.f(this.f400961j);
        this.f400955J = true;
    L209:
        if (this.K == false) goto L218;
        if (this.f400964m.getVisibility() != 0) goto L213;
        boolean r137 = true;
    L214:
        if (r137 == true) goto L216;
        pla.j.f(this.f400964m);
    L216:
        this.K = true;
    L224:
        int r138 = this.f400977z.f401000w;
        if (r138 != 2) goto L227;
        this.f400958g.setFocusable(true);
        this.f400958g.setFocusableInTouchMode(true);
        this.f400958g.setOnClickListener(null);
        setOnClickListener(null);
        return;
    L227:
        if (r138 != 3) goto L235;
        this.f400958g.setFocusable(false);
        this.f400958g.setFocusableInTouchMode(false);
        this.f400958g.setOnClickListener(this.f400977z.f400992o);
        setOnClickListener(this.f400977z.f400992o);
        return;
    L235:
        return;
    L213:
        r137 = false;
        goto L214
    L218:
        if (this.f400964m.getVisibility() != 0) goto L220;
        boolean r139 = true;
    L221:
        if (r139 == false) goto L223;
        pla.j.e(this.f400964m);
    L223:
        this.K = false;
        goto L224
    L220:
        r139 = false;
        goto L221
    L207:
        pla.j.e(this.f400961j);
        this.f400955J = false;
        goto L209
    L203:
        pla.j.e(this.f400968q);
        this.I = false;
        goto L205
    L199:
        pla.j.e(this.f400967p);
        this.H = false;
        goto L201
    L195:
        pla.j.e(this.f400970s);
        this.G = false;
        goto L197
    L191:
        R5();
        goto L193
    L172:
        pla.j.e(this.f400957f);
        if (this.f400969r.getVisibility() != 0) goto L175;
        boolean r140 = true;
    L176:
        if (r140 == true) goto L178;
        pla.j.e(this.f400971t);
    L178:
        this.E = false;
        goto L180
    L175:
        r140 = false;
        goto L176
    L158:
        if (this.f400977z.f400996s != null) goto L166;
        if (this.f400971t.getVisibility() != 0) goto L162;
        boolean r141 = true;
    L163:
        if (r141 == true) goto L165;
        pla.j.f(this.f400971t);
    L165:
        pla.j.f(this.f400969r);
        this.L = true;
        goto L166
    L162:
        r141 = false;
        goto L163
    L149:
        if (r130.length() == 0) goto L152;
        r131 = false;
        goto L153
    L145:
        this.f400958g.setSingleLine(true);
        goto L146
    L128:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L129:
        ViewGroup r142 = this.f400972u;
        ViewGroup.LayoutParams r143 = r142.getLayoutParams();
        if (r143 == null) goto L233;
        ConstraintLayout.LayoutParams r144 = (ConstraintLayout.LayoutParams) r143;
        int r145 = getArrangeDirection();
        if (r145 == 1) goto L138;
        if (r145 == 2) goto L136;
        int r146 = pla.d.n(this, 40);
    L141:
        ((ViewGroup.MarginLayoutParams) r144).height = r146;
        r142.setLayoutParams(r144);
        goto L143
    L136:
        r146 = pla.d.n(this, 40);
        goto L141
    L138:
        if (this.f400977z.f400997t == false) goto L140;
        r146 = pla.d.n(this, 36);
        goto L141
    L140:
        r146 = pla.d.n(this, 52);
        goto L141
    L233:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L89:
        if (r113.length() == 0) goto L92;
        r114 = false;
        goto L93
    L85:
        pla.j.e(this.f400966o);
        this.f400977z.f400985h = false;
        goto L86
    L67:
        if (r110.length() == 0) goto L70;
        r111 = false;
        goto L71
    L60:
        this.f400962k.setOnClickListener(new r(this));
        if (TextUtils.isEmpty(this.f400958g.getText()) == false) goto L63;
        pla.j.e(this.f400962k);
        pla.j.e(this.f400963l);
    L63:
        this.f400958g.setOnFocusChangeListener(new s(this));
        this.f400958g.setOnTouchListener(new t(this));
        goto L64
    L47:
        ViewGroup.LayoutParams r147 = this.f400969r.getLayoutParams();
        r147.width = pla.d.n(this, 16);
        r147.height = pla.d.n(this, 16);
        this.f400969r.setLayoutParams(r147);
        goto L50
    L48:
        ViewGroup.LayoutParams r148 = this.f400969r.getLayoutParams();
        r148.width = pla.d.n(this, 10);
        r148.height = pla.d.n(this, 10);
        this.f400969r.setLayoutParams(r148);
        goto L50
    L40:
        if (TextUtils.isEmpty(this.f400957f.getText()) == false) goto L42;
    L37:
        r103 = false;
        goto L38
    L28:
        if (this.f400971t.getVisibility() != 0) goto L30;
        boolean r149 = true;
    L31:
        if (r149 == true) goto L33;
        pla.j.f(this.f400971t);
    L33:
        pla.j.f(this.f400969r);
        this.L = true;
        goto L43
    L30:
        r149 = false;
        goto L31
    L15:
        pla.j.e(this.f400957f);
        if (this.f400969r.getVisibility() != 0) goto L18;
        boolean r150 = true;
    L19:
        if (r150 == true) goto L21;
        pla.j.e(this.f400971t);
    L21:
        this.E = false;
        goto L22
    L18:
        r150 = false;
        goto L19
    L11:
        this.E = false;
        goto L13
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final String getText() {
        return String.valueOf(this.f400958g.getText());
    }

    public final void hideClear() {
        pla.j.e(this.f400963l);
        pla.j.e(this.f400962k);
        this.f400977z.f400980c = false;
    }

    public final void n3() {
        pla.j.f(this.f400957f);
        if (this.f400971t.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        pla.j.f(this.f400971t);
    L8:
        this.E = true;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void S5() {
        Object r100 = getContext().getSystemService("input_method");
        if (r100 == null) goto L7;
        ((InputMethodManager) r100).hideSoftInputFromWindow(getWindowToken(), 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r100 = pla.d.n(this, 44);
        pla.j.a(this.f400973v, pla.d.n(this, 44));
        pla.j.c(this.f400973v, r100, r100, new View[]{this.f400961j, this.f400964m});
    }

    public final ViewGroup getActionContainer() {
        return this.f400973v;
    }

    public final ConstraintLayout getActiveBorderView() {
        return this.f400974w;
    }

    public final int getArrangeDirection() {
        return this.f400956e;
    }

    public final b getConfig() {
        return this.f400977z;
    }

    public final ODivider getDivider() {
        return this.f400966o;
    }

    public final OFormEditText getEditText() {
        return this.f400958g;
    }

    public final ViewGroup getInputContainer() {
        return this.f400972u;
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return this.f400958g;
    }

    public final ImageView getIvAction() {
        return this.f400964m;
    }

    public final LinearLayout getIvActionContainer() {
        return this.f400965n;
    }

    public final ImageView getIvClear() {
        return this.f400962k;
    }

    public final LinearLayout getIvClearContainer() {
        return this.f400963l;
    }

    public final ImageView getIvTitleIcon() {
        return this.f400969r;
    }

    public final ConstraintLayout getLeftContainer() {
        return this.f400975x;
    }

    public final RelativeLayout getPrefixContainer() {
        return this.f400967p;
    }

    public final RelativeLayout getSuffixContainer() {
        return this.f400968q;
    }

    public final ViewGroup getTitleContainer() {
        return this.f400971t;
    }

    public final TextView getTvAction() {
        return this.f400961j;
    }

    public final TextView getTvCounter() {
        return this.f400960i;
    }

    public final TextView getTvErrorTips() {
        return this.f400959h;
    }

    public final TextView getTvInputTips() {
        return this.f400970s;
    }

    public final TextView getTvTitle() {
        return this.f400957f;
    }

    public final void U5(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f400970s.setText(r100);
        pla.j.f(this.f400970s);
        if (this.f400959h.getVisibility() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        R5();
    L10:
        this.G = true;
        this.O = r100;
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final void V5(b r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        this.f400977z = r100;
        Iterator<WeakReference<TextWatcher>> r101 = getTextWatchers().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        WeakReference<TextWatcher> r102 = r101.next();
        this.f400958g.removeTextChangedListener(r102.get());
        goto L4
    L6:
        T5();
    }

    public final void setActiveBorderView(ConstraintLayout r100) {
        this.f400974w = r100;
    }

    public final void setArrangeDirection(int r100) {
        this.f400956e = r100;
    }

    public final void setAutoHideClearWhenTextEmpty(boolean r100) {
        b r101 = getConfig();
        r101.f400998u = r100;
        V5(r101);
    }

    public final void setEditTextOnFocusChangeListener(View.OnFocusChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f400958g.setOnFocusChangeListener(r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        this.f400958g.setEnabled(r100);
        super.setEnabled(r100);
    }

    public final void setInputContainerBackground(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f400972u.setBackground(r100);
    }

    public final void setLeftContainer(ConstraintLayout r100) {
        this.f400975x = r100;
    }

    public final void setText(String r100) {
        if (r100 == null) goto L8;
        this.f400958g.setText(r100);
        e r101 = this.A;
        if (r101 == null) goto L9;
        r101.onTextChanged(r100, 0, 0, r100.length());
        return;
    L9:
        return;
    }

    public final void setTextClearedListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "textClearedListener");
        this.f400977z.getClass();
    }

    public final void setTextExceedLengthListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "textExceedLengthListener");
        this.f400977z.getClass();
    }

    public final void setTextWatcher(TextWatcher r100) {
        this.f400977z.f400987j = r100;
        T5();
    }

    public OLineInputView(Context r210, AttributeSet r310, int r311, int r312) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r310, r311);
        this.f400956e = r312;
        String r100 = "title";
        Intrinsics.checkNotNullParameter("标题", "title");
        this.f400977z = new b("标题", false, false, null, null, null, null, true, null, null, null, false, null, null, null, null, null, null, null, false, false, false, 2, true);
        this.D = 16;
        this.E = true;
        this.M = 20;
        this.N = "";
        this.O = "";
        TypedArray r101 = r210.getTheme().obtainStyledAttributes(r310, new int[]{android.R.attr.gravity, android.R.attr.text, android.R.attr.hint, R.attr.oui_formArrangeDirection, R.attr.oui_formInputHeight, R.attr.oui_formInputTips, R.attr.oui_formLengthLimit, R.attr.oui_formMultiLine, R.attr.oui_formShowClear, R.attr.oui_formShowCounter, R.attr.oui_formShowDivider, R.attr.oui_formShowTitleDefaultIcon, R.attr.oui_formTitle, R.attr.oui_formTitleDefaultIconSize}, r311, 0);
        setArrangeDirection(r101.getInt(3, 0));
        String r102 = r101.getString(12);
        b r103 = this.f400977z;
        if (r102 == null) goto L6;
        r100 = r102;
    L6:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r103.f400978a = r100;
        this.f400977z.f400980c = r101.getBoolean(8, true);
        this.f400977z.f400981d = r101.getString(2);
        this.f400977z.f400979b = r101.getBoolean(9, false);
        int r104 = r101.getInt(6, 0);
        if (r104 <= 0) goto L9;
        b r105 = this.f400977z;
        r105.f400984g = Integer.valueOf(r104);
    L9:
        int r106 = r101.getDimensionPixelSize(4, 0);
        if (r106 <= 0) goto L12;
        b r107 = this.f400977z;
        r107.f400995r = Integer.valueOf(r106);
    L12:
        b r108 = this.f400977z;
        r108.f400999v = r101.getBoolean(7, false);
        this.f400977z.f400985h = r101.getBoolean(10, true);
        this.f400977z.f400993p = r101.getString(5);
        this.f400976y = r101.getString(1);
        this.B = r101.getBoolean(11, false);
        this.C = r101.getInt(13, 0);
        this.D = r101.getInt(0, 16);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        int r109 = this.f400956e;
        if (r109 == 0) goto L19;
        if (r109 == 1) goto L18;
        if (r109 != 2) goto L19;
        int r110 = R.layout.o_form_line_input_vertical_single_box;
    L20:
        LayoutInflater.from(r210).inflate(r110, this);
        this.f400957f = (TextView) findViewById(R.id.tv_title);
        OFormEditText r111 = (OFormEditText) findViewById(R.id.et_input);
        this.f400958g = r111;
        this.f400959h = (TextView) findViewById(R.id.tv_error_tips);
        this.f400960i = (TextView) findViewById(R.id.tv_counter);
        this.f400961j = (TextView) findViewById(R.id.tv_action);
        this.f400962k = (ImageView) findViewById(R.id.iv_clear);
        this.f400964m = (ImageView) findViewById(R.id.iv_action);
        this.f400966o = (ODivider) findViewById(R.id.divider);
        this.f400969r = (ImageView) findViewById(R.id.iv_title_icon);
        this.f400967p = (RelativeLayout) findViewById(R.id.prefix_container);
        this.f400968q = (RelativeLayout) findViewById(R.id.suffix_container);
        this.f400970s = (TextView) findViewById(R.id.tv_input_tips);
        this.f400971t = (ViewGroup) findViewById(R.id.title_container);
        this.f400972u = (ViewGroup) findViewById(R.id.input_container);
        this.f400975x = (ConstraintLayout) findViewById(R.id.left_container);
        this.f400973v = (ViewGroup) findViewById(R.id.action_container);
        this.f400974w = (ConstraintLayout) findViewById(R.id.active_border_view);
        this.f400963l = (LinearLayout) findViewById(R.id.iv_clear_container);
        this.f400965n = (LinearLayout) findViewById(R.id.iv_action_container);
        V5(this.f400977z);
        r111.setVerticalScrollBarEnabled(false);
        return;
    L18:
        r110 = R.layout.o_form_line_input_horizontal;
    L19:
        r110 = R.layout.o_form_line_input_vertical;
        goto L20
    }

    public /* synthetic */ OLineInputView(Context r100, AttributeSet r101, int r102, int r103, int r104) {
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
