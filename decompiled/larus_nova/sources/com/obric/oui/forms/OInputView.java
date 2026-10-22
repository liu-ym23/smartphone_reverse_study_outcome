package com.obric.oui.forms;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.larus.nova.R;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001:\u0005ghijkB'\b\u0007\u0012\u0006\u0010a\u001a\u00020`\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u0012\b\b\u0002\u0010d\u001a\u00020\u0004¢\u0006\u0004\be\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0013J\u0010\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0004J\n\u0010#\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0013J)\u00100\u001a\u00020\b2!\u0010/\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\b0*J)\u00101\u001a\u00020\b2!\u0010/\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\b0*J\u000e\u00103\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u000104J\b\u00107\u001a\u0004\u0018\u000104J\u000e\u00109\u001a\u00020\b2\u0006\u00108\u001a\u00020\u0004J\u0010\u0010:\u001a\u00020\b2\u0006\u00108\u001a\u00020\u0004H\u0016J\u0006\u0010;\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0013J\u0010\u0010>\u001a\u00020\b2\b\b\u0001\u0010=\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010B\u001a\u00020\b2\b\u0010A\u001a\u0004\u0018\u00010@J\u0010\u0010D\u001a\u00020\b2\b\u0010A\u001a\u0004\u0018\u00010CJ\u0010\u0010F\u001a\u00020\b2\b\u0010E\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010G\u001a\u00020\b2\b\u0010E\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010J\u001a\u00020\b2\u0006\u0010I\u001a\u00020HJ\n\u0010L\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010M\u001a\u00020\b2\b\u0010A\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010N\u001a\u00020\b2\b\u0010A\u001a\u0004\u0018\u00010@H\u0016J\u000e\u0010P\u001a\u00020\b2\u0006\u0010O\u001a\u00020\u0004J\u000e\u0010R\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\u0013R\u0017\u0010X\u001a\u00020S8\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\"\u0010_\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006l"}, d2 = {"Lcom/obric/oui/forms/OInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getFakeInputOffsetY", "", "getContentViewRes", "Landroid/text/method/KeyListener;", "keyListener", "", "setKeyListener", "radius", "setRadius", "type", "setInputType", "getInputType", "Lcom/obric/oui/forms/OEditText$a;", "commitCompletionListener", "setCommitCompletionListener", "getCommitCompletionListener", "", "enabled", "setEnabled", "error", "setErrorState", "inScrollableView", "setIsInScrollableView", "", "label", "setLabel", "show", "setShowLabel", "setShowLabelAnim", "setShowLabelIcon", "height", "setInputHeight", "getText", "text", "setText", "hint", "setHint", "single", "setSingleLine", "Lkotlin/Function1;", "Landroid/widget/FrameLayout;", "Lkotlin/ParameterName;", "name", "parent", "creator", "setLeftView", "setActionView", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "setMaxLines", "Landroid/text/TextUtils$TruncateAt;", "where", "setEllipsize", "getEllipsize", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "setLimitCountValue", "setLimitCount", "getLimitCount", "setShowLimitIndicator", "mode", "setInputMode", "setComboInputEnabled", "Landroid/view/View$OnClickListener;", "l", "setOnComboArrowClickListener", "Lcom/obric/oui/forms/OInputView$c;", "setOnTextExceedLengthListener", AppConstants.BUNDLE_TIP, "setErrorTip", "setCommonTip", "Lcom/obric/oui/forms/OInputView$b;", "listener", "setOnTextClearedListener", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusChangeListener", "setOnFocusChangeListener", "setOnClickListener", "resId", "setBgResId", "hide", "setAlwaysHideEye", "Lcom/obric/oui/forms/OEditText;", ExifInterface.LONGITUDE_EAST, "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInput", ExifInterface.LATITUDE_SOUTH, "Z", "getAutoHideSoftInputWhenLoseFocus", "()Z", "setAutoHideSoftInputWhenLoseFocus", "(Z)V", "autoHideSoftInputWhenLoseFocus", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "InputMode", "LabelUIState", "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OInputView extends ConstraintLayout {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f400925k0 = 0;
    public final OUIConstraintLayout A;
    public final LinearLayout B;
    public final OTextView C;
    public final ImageView D;
    public final OEditText E;
    public final FrameLayout F;
    public final FrameLayout G;
    public final View H;
    public final View I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final View f400926J;
    public final ImageView K;
    public final View L;
    public final OTextView M;
    public final OTextView N;
    public final OTextView O;
    public final TextView P;
    public boolean Q;
    public View.OnClickListener R;
    public boolean S;
    public int T;
    public boolean U;
    public ValueAnimator V;
    public ValueAnimator W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f400927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f400928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f400929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f400930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextUtils.TruncateAt f400931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f400932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f400933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f400934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f400935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f400936j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f400937k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f400938l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f400939m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f400940n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f400941o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f400942p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f400943q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f400944r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f400945s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f400946t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f400947u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f400948v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f400949w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f400950x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f400951y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f400952z;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/forms/OInputView$InputMode;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public @interface InputMode {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/forms/OInputView$LabelUIState;", "", "REAL_LABEL_SHOW", "FAKE_LABEL_SHOW", "LABEL_NONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum LabelUIState extends Enum<LabelUIState> {
        public static final LabelUIState FAKE_LABEL_SHOW = null;
        public static final LabelUIState LABEL_NONE = null;
        public static final LabelUIState REAL_LABEL_SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LabelUIState[] f400953a = null;

        public static LabelUIState valueOf(String r100) {
            return (LabelUIState) r27.a.a(LabelUIState.class, r100);
        }

        public static LabelUIState[] values() {
            return (LabelUIState[]) f400953a.clone();
        }

        static {
            LabelUIState r100 = new LabelUIState("REAL_LABEL_SHOW", 0);
            REAL_LABEL_SHOW = r100;
            LabelUIState r101 = new LabelUIState("FAKE_LABEL_SHOW", 1);
            FAKE_LABEL_SHOW = r101;
            LabelUIState r102 = new LabelUIState("LABEL_NONE", 2);
            LABEL_NONE = r102;
            f400953a = new LabelUIState[]{r100, r101, r102};
        }

        public LabelUIState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f400954a = null;

        static {
            int[] r100 = new int[LabelUIState.values().length];
            r100[LabelUIState.REAL_LABEL_SHOW.ordinal()] = 1;
            r100[LabelUIState.FAKE_LABEL_SHOW.ordinal()] = 2;
            r100[LabelUIState.LABEL_NONE.ordinal()] = 3;
            f400954a = r100;
        }
    }

    static {
    }

    public OInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void T5(Editable r100) {
    }

    public int getContentViewRes() {
        return R.layout.o_input_view_layout_vertical;
    }

    public final void setOnTextClearedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final void setOnTextExceedLengthListener(c r100) {
    }

    private final float getFakeInputOffsetY() {
        if (this.B.getHeight() > 0) goto L5;
    L7:
        wma.b.h("OInputView", "getFakeInputOffsetY, use default offset, vTitleContainer.height: " + this.B.getHeight() + ", height: " + getHeight());
        float r100 = pla.d.p(this, -11.0f);
    L8:
        wma.b.a("OInputView", Intrinsics.stringPlus("getFakeInputOffsetY, offsetY: ", Float.valueOf(r100)));
        return r100;
    L5:
        if (getHeight() <= 0) goto L7;
        r100 = (this.B.getY() + (this.B.getHeight() / 2.0f)) - (getHeight() / 2.0f);
        goto L8
    }

    public final boolean Y5() {
        int r100 = this.f400948v & UnixStat.PERM_MASK;
        if (r100 != 129) goto L5;
        boolean r101 = true;
    L7:
        if (r100 != 225) goto L9;
        boolean r102 = true;
    L11:
        if (r100 != 18) goto L13;
        boolean r103 = true;
    L14:
        if (r101 == true) goto L20;
        if (r102 == true) goto L21;
        if (r103 == true) goto L22;
        return false;
    L22:
        return true;
    L21:
        return true;
    L20:
        return true;
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L7
    }

    public final void c6() {
        if (this.f400936j == true) goto L5;
        return;
    L5:
        boolean r100 = true;
        if (Y5() == false) goto L8;
    L22:
        boolean r101 = false;
    L23:
        pla.j.h(this.I, r101);
        if (r101 == false) goto L26;
        pla.j.h(this.K, false);
    L26:
        View r102 = this.H;
        if (this.I.getVisibility() != 0) goto L29;
        boolean r103 = true;
    L30:
        if (r103 == false) goto L32;
    L43:
        pla.j.h(r102, r100);
        return;
    L32:
        if (this.K.getVisibility() != 0) goto L34;
        boolean r104 = true;
    L35:
        if (r104 == true) goto L43;
        if (this.f400926J.getVisibility() != 0) goto L39;
        boolean r105 = true;
    L40:
        if (r105 == true) goto L43;
        r100 = false;
        goto L43
    L39:
        r105 = false;
        goto L40
    L34:
        r104 = false;
        goto L35
    L29:
        r103 = false;
        goto L30
    L8:
        if (this.f400928b != 0) goto L22;
        if (this.f400945s == false) goto L22;
        if (this.E.hasFocus() == false) goto L22;
        Editable r106 = this.E.getText();
        if (r106 != null) goto L16;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == true) goto L22;
        r101 = true;
        goto L23
    L16:
        if (r106.length() == 0) goto L19;
        r107 = false;
        goto L20
    }

    public final OEditText.a getCommitCompletionListener() {
        this.E.getCommitCompletionListener();
        return null;
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.E.getEllipsize();
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.E.getOnFocusChangeListener();
    }

    public String getText() {
        Editable r100 = this.E.getText();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.toString();
    }

    public final void i6() {
        boolean r100 = true;
        if (Y5() == true) goto L5;
    L17:
        boolean r101 = false;
    L18:
        pla.j.h(this.K, r101);
        if (r101 == false) goto L21;
        pla.j.h(this.I, false);
    L21:
        View r102 = this.H;
        if (this.I.getVisibility() != 0) goto L24;
        boolean r103 = true;
    L25:
        if (r103 == false) goto L27;
    L38:
        pla.j.h(r102, r100);
        return;
    L27:
        if (this.K.getVisibility() != 0) goto L29;
        boolean r104 = true;
    L30:
        if (r104 == true) goto L38;
        if (this.f400926J.getVisibility() != 0) goto L34;
        boolean r105 = true;
    L35:
        if (r105 == true) goto L38;
        r100 = false;
        goto L38
    L34:
        r105 = false;
        goto L35
    L29:
        r104 = false;
        goto L30
    L24:
        r103 = false;
        goto L25
    L5:
        if (this.f400945s == false) goto L17;
        Editable r106 = this.E.getText();
        if (r106 != null) goto L9;
    L12:
        boolean r107 = true;
    L13:
        if (r107 == true) goto L17;
        if (this.U == true) goto L17;
        r101 = true;
        goto L18
    L9:
        if (r106.length() == 0) goto L12;
        r107 = false;
        goto L13
    }

    public final boolean getAutoHideSoftInputWhenLoseFocus() {
        return this.S;
    }

    public final int getInputType() {
        return this.f400948v;
    }

    public final int getLimitCount() {
        return this.f400939m;
    }

    public final OEditText getVInput() {
        return this.E;
    }

    public final void S5(String r100) {
        if (this.f400941o == true) goto L5;
        return;
    L5:
        TextView r101 = this.P;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f400940n == true) goto L12;
        this.E.setHint(this.f400947u);
        k6(LabelUIState.LABEL_NONE, r101, "adjustInputViewAndLabel, " + r100 + ", no label");
        return;
    L12:
        if (this.f400929c == true) goto L14;
        this.E.setHint(this.f400947u);
        k6(LabelUIState.REAL_LABEL_SHOW, r101, "adjustInputViewAndLabel, " + r100 + ", can not show label anim");
        return;
    L14:
        this.E.setHint("");
        r101.setText(this.f400943q);
        Editable r102 = this.E.getText();
        if (r102 != null) goto L17;
    L20:
        boolean r103 = true;
    L21:
        if (r103 == true) goto L23;
        k6(LabelUIState.REAL_LABEL_SHOW, r101, "adjustInputViewAndLabel, " + r100 + ", can show label anim, vInput.text not empty");
        return;
    L23:
        if (this.E.hasFocus() == false) goto L25;
        k6(LabelUIState.REAL_LABEL_SHOW, r101, "adjustInputViewAndLabel, " + r100 + ", can show label anim, vInput.text empty, focused");
        return;
    L25:
        k6(LabelUIState.FAKE_LABEL_SHOW, r101, "adjustInputViewAndLabel, " + r100 + ", can show label anim, vInput.text empty, not focused");
        return;
    L17:
        if (r102.length() == 0) goto L20;
        r103 = false;
        goto L21
    }

    public int U5(CharSequence r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.length();
    }

    public final float V5(TextView r100) {
        if (this.C.getTextSize() > 0.0f) goto L5;
    L7:
        wma.b.h("OInputView", "getScaleRatio, use default scale, vTitle.textSize: " + this.C.getTextSize() + ", vFakeInput.textSize: " + r100.getTextSize());
        float r101 = 0.857143f;
    L8:
        wma.b.a("OInputView", Intrinsics.stringPlus("getScaleRatio, scale: ", Float.valueOf(r101)));
        return r101;
    L5:
        if (r100.getTextSize() <= 0.0f) goto L7;
        r101 = this.C.getTextSize() / r100.getTextSize();
        goto L8
    }

    public final void Z5(boolean r100) {
        int r101 = this.T;
        if (r101 == 0) goto L6;
        this.A.setBackgroundResource(r101);
        return;
    L6:
        boolean r102 = this.f400945s;
        int r103 = R.drawable.o_input_view_pressed_background;
        if (r102 == false) goto L15;
        if (r100 == true) goto L15;
        if (this.E.hasFocus() == false) goto L14;
        r103 = R.drawable.o_input_view_focused_background;
        goto L15
    L14:
        r103 = R.drawable.o_input_view_normal_background;
    L15:
        this.A.setBackgroundResource(r103);
    }

    public final void b6(boolean r100) {
        int r101 = 0;
        if (this.f400932f == false) goto L7;
        this.A.setBorderWidth(0);
        this.A.setBorderColor(ContextCompat.getColor(getContext(), R.color.Transparent));
        return;
    L7:
        if (this.f400945s == true) goto L9;
    L8:
        int r102 = pla.d.n(this, 0);
    L14:
        this.A.setBorderWidth(r102);
        if (this.f400945s == true) goto L18;
        r101 = pla.d.n(this, 0);
    L22:
        if (r101 == 0) goto L25;
        this.A.setBorderColor(ContextCompat.getColor(getContext(), r101));
        return;
    L25:
        return;
    L18:
        if (this.f400944r == false) goto L20;
        r101 = R.color.oui_functional_red_7;
        goto L22
    L20:
        if (r100 == false) goto L22;
        r101 = R.color.oui_basic_line_3;
        goto L22
    L9:
        if (r100 == false) goto L12;
        r102 = pla.d.n(this, 2);
        goto L14
    L12:
        if (this.f400944r == false) goto L8;
        r102 = pla.d.l(this, 1.2d);
        goto L14
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L36;
        if (this.f400935i == false) goto L36;
        float r101 = r100.getX();
        float r102 = r100.getY();
        int r103 = r100.getAction();
        if (r103 != 0) goto L8;
        this.f400933g = r102;
        goto L36
    L8:
        if (r103 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L16:
        if (r101 <= this.f400934h) goto L20;
        if (this.E.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.f400934h = r101;
        this.f400933g = r102;
    L20:
        if (r101 >= this.f400934h) goto L24;
        if (this.E.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r102 >= this.f400933g) goto L28;
        if (this.E.canScrollVertically(1) == true) goto L31;
    L28:
        if (r102 <= this.f400933g) goto L32;
        if (this.E.canScrollVertically(-1) == false) goto L32;
    L36:
        return super.dispatchTouchEvent(r100);
    }

    public final void n6(String r100) {
        OTextView r101 = this.O;
        if (this.f400938l == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        pla.j.h(r101, r102);
        if (this.f400938l == true) goto L11;
        return;
    L11:
        if (this.f400939m <= 0) goto L18;
        int r103 = U5(r100);
        SpannableString r104 = new SpannableString(getResources().getString(R.string.oui_form_counter, new Object[]{String.valueOf(r103), String.valueOf(this.f400939m)}));
        if (r103 <= this.f400939m) goto L15;
        r104.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.oui_functional_red_7)), 0, String.valueOf(r103).length(), 18);
    L15:
        this.O.setText(r104, TextView.BufferType.SPANNABLE);
        return;
    L18:
        return;
    L5:
        if (this.f400939m <= 0) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
    L13:
        if (r100 != null) goto L15;
    L22:
        return super.onInterceptTouchEvent(r100);
    L15:
        if (r100.getAction() == 1) goto L19;
        if (r100.getAction() != 3) goto L22;
    L19:
        if (this.Q == false) goto L22;
        this.Q = false;
        goto L22
    L5:
        if (r100.getAction() != 0) goto L13;
        float r101 = r100.getX();
        int r102 = this.E.getLeft();
        int r103 = this.E.getRight();
        if (r101 >= r102) goto L9;
    L12:
        this.Q = false;
        goto L22
    L9:
        if (r101 > r103) goto L12;
        this.Q = true;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L12;
        if (this.Q == false) goto L12;
        MotionEvent r101 = MotionEvent.obtain(r100);
        r101.offsetLocation(-this.E.getLeft(), -this.E.getTop());
        boolean r102 = this.E.dispatchTouchEvent(r101);
        r101.recycle();
        if (r100.getAction() != 1) goto L8;
    L9:
        this.Q = false;
    L10:
        return r102;
    L8:
        if (r100.getAction() != 3) goto L10;
    L12:
        return super.onTouchEvent(r100);
    }

    public final void setActionView(Function1<? super FrameLayout, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        this.G.removeAllViews();
        r100.invoke(this.G);
        FrameLayout r101 = this.G;
        if (r101.getChildCount() <= 0) goto L5;
        boolean r102 = true;
    L6:
        pla.j.h(r101, r102);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setAlwaysHideEye(boolean r100) {
        this.U = r100;
        if (r100 == false) goto L6;
        pla.j.h(this.K, false);
        return;
    }

    public final void setAutoHideSoftInputWhenLoseFocus(boolean r100) {
        this.S = r100;
    }

    public final void setBgResId(int r100) {
        this.T = r100;
        Z5(true);
    }

    public final void setComboInputEnabled(boolean r100) {
        this.f400927a = r100;
        this.E.setFocusable(r100);
        this.E.setFocusableInTouchMode(r100);
        View.OnClickListener r101 = this.R;
        if (r101 == null) goto L7;
        getVInput().setOnClickListener(r101);
        return;
    }

    public final void setCommitCompletionListener(OEditText.a r100) {
        Intrinsics.checkNotNullParameter(r100, "commitCompletionListener");
        this.E.setCommitCompletionListener(r100);
    }

    public final void setCommonTip(String r100) {
        this.f400950x = r100;
        this.N.setText(r100);
    }

    public final void setEllipsize(TextUtils.TruncateAt r100) {
        this.f400931e = r100;
        this.E.setEllipsize(r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        this.f400945s = r100;
        super.setEnabled(r100);
        Iterator<View> r101 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().setEnabled(r100);
        goto L4
    L6:
        this.E.setEnabled(r100);
        b6(this.E.hasFocus());
        Z5(false);
    }

    public final void setErrorState(boolean r100) {
        this.f400944r = r100;
        b6(this.E.hasFocus());
        Z5(false);
    }

    public final void setErrorTip(String r100) {
        this.f400949w = r100;
        this.M.setText(r100);
    }

    public final void setHint(String r100) {
        this.f400947u = r100;
        this.E.setHint(r100);
        S5("setHint");
    }

    public final void setInputHeight(int r100) {
        this.f400946t = Integer.valueOf(r100);
        OEditText r101 = this.E;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L7;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        ((ViewGroup.MarginLayoutParams) r103).height = r100;
        r101.setLayoutParams(r103);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setInputMode(@InputMode int r100) {
        this.f400928b = r100;
        boolean r101 = false;
        if (r100 == 0) goto L23;
        if (r100 != 1) goto L42;
        setSingleLine(true);
        pla.j.h(this.f400926J, true);
        View r102 = this.H;
        if (this.I.getVisibility() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L21:
        r101 = true;
    L22:
        pla.j.h(r102, r101);
        setComboInputEnabled(this.f400927a);
        return;
    L12:
        if (this.K.getVisibility() != 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L21;
        if (this.f400926J.getVisibility() != 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == false) goto L22;
    L19:
        r105 = false;
        goto L20
    L14:
        r104 = false;
        goto L15
    L9:
        r103 = false;
        goto L10
    L42:
        return;
    L23:
        pla.j.h(this.f400926J, false);
        View r106 = this.H;
        if (this.I.getVisibility() != 0) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == false) goto L29;
    L38:
        r101 = true;
    L39:
        pla.j.h(r106, r101);
        this.E.setFocusable(true);
        this.E.setFocusableInTouchMode(true);
        return;
    L29:
        if (this.K.getVisibility() != 0) goto L31;
        boolean r108 = true;
    L32:
        if (r108 == true) goto L38;
        if (this.f400926J.getVisibility() != 0) goto L36;
        boolean r109 = true;
    L37:
        if (r109 == false) goto L39;
    L36:
        r109 = false;
        goto L37
    L31:
        r108 = false;
        goto L32
    L26:
        r107 = false;
        goto L27
    }

    public final void setInputType(int r100) {
        if ((r100 & 1) == 0) goto L5;
    L11:
        this.f400948v = r100;
        if (r100 != this.E.getInputType()) goto L15;
        T5(this.E.getText());
        return;
    L15:
        this.E.setInputType(this.f400948v);
        i6();
        T5(this.E.getText());
        return;
    L5:
        if ((r100 & 2) != 0) goto L11;
        if ((r100 & 3) != 0) goto L11;
        if ((r100 & 4) != 0) goto L11;
        r100 = r100 | 1;
        goto L11
    }

    public final void setIsInScrollableView(boolean r100) {
        this.f400935i = r100;
    }

    public final void setKeyListener(KeyListener r100) {
        this.E.setKeyListener(r100);
    }

    public final void setLabel(String r100) {
        this.f400943q = r100;
        this.C.setText(r100);
    }

    public final void setLeftView(Function1<? super FrameLayout, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        this.F.removeAllViews();
        r100.invoke(this.F);
        FrameLayout r101 = this.F;
        if (r101.getChildCount() <= 0) goto L5;
        boolean r102 = true;
    L6:
        pla.j.h(r101, r102);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setLimitCount(int r100) {
        setLimitCountValue(r100);
        Editable r101 = this.E.getText();
        if (r101 != null) goto L5;
        String r102 = null;
    L6:
        n6(r102);
        T5(this.E.getText());
        return;
    L5:
        r102 = r101.toString();
        goto L6
    }

    public final void setLimitCountValue(int r100) {
        this.f400939m = r100;
    }

    public final void setMaxLines(int r100) {
        int r101 = 1;
        if (r100 >= 1) goto L5;
        r100 = Integer.MAX_VALUE;
    L5:
        this.f400930d = r100;
        OEditText r102 = this.E;
        if (this.f400929c == true) goto L9;
        r101 = r100;
    L9:
        r102.setMaxLines(r101);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        if (this.f400928b == 1) goto L5;
    L7:
        super.setOnClickListener(r100);
        return;
    L5:
        if (this.f400927a == true) goto L7;
        this.f400926J.setOnClickListener(r100);
        this.E.setOnClickListener(r100);
        goto L7
    }

    public final void setOnComboArrowClickListener(View.OnClickListener r100) {
        this.R = r100;
        this.f400926J.setOnClickListener(r100);
        if (this.f400927a == true) goto L9;
        View.OnClickListener r101 = this.R;
        if (r101 == null) goto L10;
        getVInput().setOnClickListener(r101);
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r100) {
        this.E.setOnFocusChangeListener(r100);
    }

    public final void setRadius(int r100) {
        if (r100 != this.f400952z) goto L5;
        return;
    L5:
        this.f400952z = r100;
        this.A.setRadius(r100);
    }

    public final void setShowLabel(boolean r100) {
        this.f400940n = r100;
        pla.j.h(this.B, r100);
        OEditText r101 = this.E;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L11;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        if (this.f400940n == false) goto L7;
        int r104 = 16;
    L8:
        int r105 = pla.d.n(this, r104);
        r103.goneLeftMargin = r105;
        r103.goneStartMargin = r105;
        r101.setLayoutParams(r103);
        S5("setShowLabel");
        return;
    L7:
        r104 = 12;
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setShowLabelAnim(boolean r100) {
        this.f400941o = r100;
        S5("setShowLabelAnim");
    }

    public final void setShowLabelIcon(boolean r100) {
        this.f400942p = r100;
        pla.j.h(this.D, r100);
    }

    public final void setShowLimitIndicator(boolean r100) {
        this.f400938l = r100;
        Editable r101 = this.E.getText();
        if (r101 != null) goto L5;
        String r102 = null;
    L6:
        n6(r102);
        return;
    L5:
        r102 = r101.toString();
        goto L6
    }

    public final void setSingleLine(boolean r110) {
        this.f400929c = r110;
        int r100 = getResources().getDimensionPixelSize(R.dimen.o_input_view_space_top_bottom);
        ViewGroup.LayoutParams r101 = null;
        if (r110 == false) goto L40;
        pla.j.h(this.L, false);
        this.E.setMaxLines(1);
        this.E.setSingleLine(true);
        OEditText r111 = this.E;
        ViewGroup.LayoutParams r102 = r111.getLayoutParams();
        if (r102 == null) goto L39;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        ViewGroup.LayoutParams r104 = getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r104 = null;
    L9:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L12;
        int r106 = r105.leftMargin;
    L13:
        ViewGroup.LayoutParams r107 = getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r101 = r107;
    L17:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r101;
        if (r108 == null) goto L20;
        int r109 = r108.rightMargin;
    L21:
        r103.setMargins(r106, 0, r109, r100);
        r103.goneTopMargin = r100;
        if (this.f400940n == false) goto L24;
        int r112 = pla.d.n(this, 16);
    L25:
        r103.goneLeftMargin = r112;
        r103.goneStartMargin = r112;
        r111.setLayoutParams(r103);
        View r113 = this.H;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L37;
        ConstraintLayout.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
        r115.topToTop = 0;
        r115.bottomToBottom = 0;
        r113.setLayoutParams(r115);
        FrameLayout r116 = this.G;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117 == null) goto L35;
        ConstraintLayout.LayoutParams r118 = (ConstraintLayout.LayoutParams) r117;
        r118.topToTop = 0;
        r118.bottomToBottom = 0;
        r116.setLayoutParams(r118);
        FrameLayout r119 = this.F;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if (r120 == null) goto L33;
        ConstraintLayout.LayoutParams r121 = (ConstraintLayout.LayoutParams) r120;
        r121.setMargins(pla.d.n(this, 4), pla.d.n(this, 4), 0, pla.d.n(this, 4));
        r121.topToTop = 0;
        r121.bottomToBottom = 0;
        r119.setLayoutParams(r121);
    L89:
        S5("setSingleLine");
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L24:
        r112 = pla.d.n(this, 12);
        goto L25
    L20:
        r109 = 0;
        goto L21
    L12:
        r106 = 0;
        goto L13
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L40:
        pla.j.h(this.L, this.f400937k);
        this.E.setMaxLines(this.f400930d);
        this.E.setSingleLine(false);
        this.E.setPadding(getPaddingLeft(), pla.d.n(this, 2), getPaddingRight(), getPaddingBottom());
        this.E.setGravity(48);
        OEditText r122 = this.E;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        if (r123 == null) goto L98;
        ConstraintLayout.LayoutParams r124 = (ConstraintLayout.LayoutParams) r123;
        ViewGroup.LayoutParams r125 = getLayoutParams();
        if ((r125 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r125 = null;
    L45:
        ViewGroup.MarginLayoutParams r126 = (ViewGroup.MarginLayoutParams) r125;
        if (r126 == null) goto L48;
        int r127 = r126.leftMargin;
    L49:
        ViewGroup.LayoutParams r128 = getLayoutParams();
        if ((r128 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r128 = null;
    L52:
        ViewGroup.MarginLayoutParams r129 = (ViewGroup.MarginLayoutParams) r128;
        if (r129 == null) goto L55;
        int r130 = r129.rightMargin;
    L56:
        r124.setMargins(r127, 0, r130, pla.d.n(this, 8));
        r124.goneTopMargin = pla.d.n(this, 8);
        if (this.f400940n == false) goto L59;
        int r131 = pla.d.n(this, 16);
    L60:
        r124.goneLeftMargin = r131;
        r124.goneStartMargin = r131;
        r122.setLayoutParams(r124);
        View r132 = this.H;
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
        if (r133 == null) goto L96;
        ConstraintLayout.LayoutParams r134 = (ConstraintLayout.LayoutParams) r133;
        r134.topToTop = 0;
        ViewGroup.LayoutParams r135 = getLayoutParams();
        if ((r135 instanceof ViewGroup.MarginLayoutParams) == true) goto L65;
        r135 = null;
    L65:
        ViewGroup.MarginLayoutParams r136 = (ViewGroup.MarginLayoutParams) r135;
        if (r136 == null) goto L68;
        int r137 = r136.leftMargin;
    L69:
        int r138 = pla.d.n(this, 4);
        ViewGroup.LayoutParams r139 = getLayoutParams();
        if ((r139 instanceof ViewGroup.MarginLayoutParams) == true) goto L72;
        r139 = null;
    L72:
        ViewGroup.MarginLayoutParams r140 = (ViewGroup.MarginLayoutParams) r139;
        if (r140 == null) goto L75;
        int r141 = r140.rightMargin;
    L76:
        ViewGroup.LayoutParams r142 = getLayoutParams();
        if ((r142 instanceof ViewGroup.MarginLayoutParams) == false) goto L80;
        r101 = r142;
    L80:
        ViewGroup.MarginLayoutParams r143 = (ViewGroup.MarginLayoutParams) r101;
        if (r143 == null) goto L83;
        int r144 = r143.bottomMargin;
    L84:
        r134.setMargins(r137, r138, r141, r144);
        r134.bottomToBottom = -1;
        r132.setLayoutParams(r134);
        FrameLayout r145 = this.G;
        ViewGroup.LayoutParams r146 = r145.getLayoutParams();
        if (r146 == null) goto L94;
        ConstraintLayout.LayoutParams r147 = (ConstraintLayout.LayoutParams) r146;
        r147.topToTop = 0;
        r147.bottomToBottom = 0;
        r145.setLayoutParams(r147);
        FrameLayout r148 = this.F;
        ViewGroup.LayoutParams r149 = r148.getLayoutParams();
        if (r149 == null) goto L92;
        ConstraintLayout.LayoutParams r150 = (ConstraintLayout.LayoutParams) r149;
        r150.setMargins(pla.d.n(this, 4), pla.d.n(this, 4), 0, 0);
        r150.topToTop = 0;
        r150.bottomToBottom = -1;
        r148.setLayoutParams(r150);
        goto L89
    L92:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L94:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L83:
        r144 = 0;
        goto L84
    L75:
        r141 = 0;
        goto L76
    L68:
        r137 = 0;
        goto L69
    L96:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L59:
        r131 = pla.d.n(this, 12);
        goto L60
    L55:
        r130 = 0;
        goto L56
    L48:
        r127 = 0;
        goto L49
    L98:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setText(String r100) {
        this.E.setText(r100);
        S5("setText");
        T5(this.E.getText());
    }

    public static final void R5(final OInputView r110, boolean r111) {
        if (r110.f400941o == true) goto L6;
        return;
    L6:
        if (r110.f400940n == true) goto L9;
        return;
    L9:
        if (r110.f400929c == true) goto L12;
        return;
    L12:
        if (r110.P == null) goto L91;
        Editable r100 = r110.E.getText();
        boolean r101 = false;
        if (r100 != null) goto L17;
    L20:
        boolean r102 = true;
    L21:
        if (r102 == true) goto L23;
        LabelUIState r103 = LabelUIState.REAL_LABEL_SHOW;
        TextView r104 = r110.P;
        Intrinsics.checkNotNull(r104);
        r110.k6(r103, r104, Intrinsics.stringPlus("playLabelAnim, hasFocus: ", Boolean.valueOf(r111)));
        return;
    L23:
        ValueAnimator r105 = null;
        if (r111 == false) goto L54;
        ValueAnimator r112 = r110.W;
        if (r112 == null) goto L29;
        r112.cancel();
    L29:
        ValueAnimator r113 = r110.W;
        if (r113 == null) goto L33;
        r113.removeAllUpdateListeners();
    L33:
        ValueAnimator r114 = r110.W;
        if (r114 == null) goto L37;
        r114.removeAllListeners();
    L37:
        ValueAnimator r115 = r110.V;
        if (r115 != null) goto L41;
    L43:
        if (r101 == true) goto L53;
        final int r106 = ContextCompat.getColor(r110.getContext(), R.color.oui_text_3);
        final int r107 = ContextCompat.getColor(r110.getContext(), R.color.oui_text_4);
        final TextView r116 = r110.P;
        if (r116 == null) goto L48;
        final float r108 = r110.getFakeInputOffsetY();
        final float r117 = r110.V5(r116);
        r116.setPivotX(0.0f);
        r116.setPivotY(-r108);
        ValueAnimator r118 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r118.setDuration(200);
        r118.setInterpolator(new DecelerateInterpolator());
        r118.addUpdateListener(new j(r108, r110, r107, r106, r117, r116));
        r118.addListener(new p(r110, r116));
        r105 = r118;
    L48:
        r110.V = r105;
        if (r105 == null) goto L52;
        r105.start();
    L52:
        wma.b.a("OInputView", "start label show anim");
        return;
    L53:
        wma.b.h("OInputView", "label show anim is running, do nothing");
        return;
    L41:
        if (r115.isRunning() != true) goto L43;
        r101 = true;
        goto L43
    L54:
        ValueAnimator r119 = r110.V;
        if (r119 == null) goto L58;
        r119.cancel();
    L58:
        ValueAnimator r120 = r110.V;
        if (r120 == null) goto L62;
        r120.removeAllUpdateListeners();
    L62:
        ValueAnimator r121 = r110.V;
        if (r121 == null) goto L66;
        r121.removeAllListeners();
    L66:
        ValueAnimator r122 = r110.W;
        if (r122 != null) goto L70;
    L72:
        if (r101 == true) goto L82;
        final int r109 = ContextCompat.getColor(r110.getContext(), R.color.oui_text_3);
        final int r123 = ContextCompat.getColor(r110.getContext(), R.color.oui_text_4);
        final TextView r124 = r110.P;
        if (r124 == null) goto L77;
        final float r125 = r110.getFakeInputOffsetY();
        final float r126 = r110.V5(r124);
        r124.setPivotX(0.0f);
        r124.setPivotY(-r125);
        ValueAnimator r127 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r127.setDuration(200);
        r127.setInterpolator(new DecelerateInterpolator());
        r127.addUpdateListener(new k(r125, r110, r109, r123, r126, r124));
        r127.addListener(new o(r110, r124));
        r105 = r127;
    L77:
        r110.W = r105;
        if (r105 == null) goto L81;
        r105.start();
    L81:
        wma.b.a("OInputView", "start label hide anim");
        return;
    L82:
        wma.b.h("OInputView", "label hide anim is running, do nothing");
        return;
    L70:
        if (r122.isRunning() != true) goto L72;
        r101 = true;
        goto L72
    L17:
        if (r100.length() == 0) goto L20;
        r102 = false;
        goto L21
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OInputView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        int r100 = 1;
        this.f400927a = true;
        this.f400929c = true;
        this.f400930d = Integer.MAX_VALUE;
        this.f400936j = true;
        this.f400937k = true;
        this.f400939m = -1;
        this.f400940n = true;
        this.f400942p = true;
        this.f400945s = true;
        this.f400952z = pla.d.n(this, 10);
        TypedArray r113 = r110.getTheme().obtainStyledAttributes(r111, new int[]{android.R.attr.enabled, android.R.attr.ellipsize, android.R.attr.gravity, android.R.attr.orientation, android.R.attr.text, android.R.attr.hint, android.R.attr.maxLines, android.R.attr.digits, android.R.attr.inputType, R.attr.oui_autoShowClear, R.attr.oui_comboInputEnabled, R.attr.oui_commonTip, R.attr.oui_errorTip, R.attr.oui_inputBorderRadius, R.attr.oui_inputHeight, R.attr.oui_inputInScrollableView, R.attr.oui_inputLabel, R.attr.oui_inputMode, R.attr.oui_inputSingleLine, R.attr.oui_limitCount, R.attr.oui_showCommonTip, R.attr.oui_showLabel, R.attr.oui_showLabelAnim, R.attr.oui_showLabelIcon, R.attr.oui_showLimitIndicator, R.attr.oui_showResizer}, r112, 0);
        this.f400935i = r113.getBoolean(15, false);
        this.f400936j = r113.getBoolean(9, true);
        this.f400937k = r113.getBoolean(25, true);
        this.f400940n = r113.getBoolean(21, true);
        this.f400941o = r113.getBoolean(22, false);
        this.f400942p = r113.getBoolean(23, true);
        this.f400943q = r113.getString(16);
        this.f400949w = r113.getString(12);
        this.f400950x = r113.getString(11);
        boolean r101 = r113.getBoolean(20, false);
        this.f400951y = r101;
        this.f400952z = r113.getDimensionPixelSize(13, this.f400952z);
        this.f400927a = r113.getBoolean(10, true);
        this.f400928b = r113.getInt(17, 0);
        this.f400929c = r113.getBoolean(18, true);
        int r102 = r113.getDimensionPixelSize(14, 0);
        if (r102 <= 0) goto L5;
        this.f400946t = Integer.valueOf(r102);
    L5:
        this.f400939m = r113.getInt(19, -1);
        this.f400938l = r113.getBoolean(24, false);
        CharSequence r103 = r113.getText(7);
        this.f400947u = r113.getString(5);
        this.f400948v = r113.getInt(8, 0);
        String r104 = r113.getString(4);
        this.f400945s = r113.getBoolean(0, true);
        this.f400930d = r113.getInt(6, Integer.MAX_VALUE);
        r113.getInt(3, 0);
        int r114 = r113.getInt(2, 16);
        if (r113.hasValue(1) == false) goto L18;
        int r105 = r113.getInt(1, 0);
        if (r105 == 1) goto L16;
        if (r105 == 2) goto L15;
        if (r105 == 3) goto L14;
        if (r105 == 4) goto L13;
        TextUtils.TruncateAt r106 = null;
    L17:
        this.f400931e = r106;
        goto L18
    L13:
        r106 = TextUtils.TruncateAt.MARQUEE;
        goto L17
    L14:
        r106 = TextUtils.TruncateAt.END;
        goto L17
    L15:
        r106 = TextUtils.TruncateAt.MIDDLE;
        goto L17
    L16:
        r106 = TextUtils.TruncateAt.START;
    L18:
        r113.recycle();
        LayoutInflater.from(r110).inflate(getContentViewRes(), this);
        OUIConstraintLayout r115 = (OUIConstraintLayout) findViewById(R.id.o_input_border_container);
        this.A = r115;
        r115.setRadius(this.f400952z);
        this.B = (LinearLayout) findViewById(R.id.o_input_title_container);
        this.C = (OTextView) findViewById(R.id.o_input_title);
        this.D = (ImageView) findViewById(R.id.o_input_title_icon);
        OEditText r116 = (OEditText) findViewById(R.id.o_input);
        this.E = r116;
        r116.setVerticalScrollBarEnabled(false);
        this.F = (FrameLayout) findViewById(R.id.o_input_left_view_container);
        this.G = (FrameLayout) findViewById(R.id.o_input_custom_action_container);
        this.H = findViewById(R.id.o_input_action_container);
        View r107 = findViewById(R.id.o_input_clear);
        this.I = r107;
        this.f400926J = findViewById(R.id.o_input_combo_arrow);
        ImageView r108 = (ImageView) findViewById(R.id.o_input_eyes_slash);
        this.K = r108;
        this.L = findViewById(R.id.o_input_resizer);
        OTextView r109 = (OTextView) findViewById(R.id.o_input_error_tip);
        this.M = r109;
        OTextView r117 = (OTextView) findViewById(R.id.o_input_common_tip);
        this.N = r117;
        this.O = (OTextView) findViewById(R.id.o_input_limit_indicator);
        this.P = (TextView) findViewById(R.id.o_input_view_fake_label);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        if (r103 == null) goto L24;
        r116.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r103)));
        int r118 = this.f400948v;
        if (r118 == 0) goto L23;
        r100 = r118;
    L23:
        this.f400948v = r100;
    L24:
        r116.setGravity(r114);
        Integer r119 = this.f400946t;
        if (r119 == null) goto L28;
        setInputHeight(r119.intValue());
    L28:
        Function1<Boolean, Unit> r120 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r120, "action");
        r116.f400880a.f400887a = r120;
        Function1<MotionEvent, Unit> r121 = new AnonymousClass4(this);
        Intrinsics.checkNotNullParameter(r121, "action");
        r116.f400881b.f400889a = r121;
        Function4<CharSequence, Integer, Integer, Integer, Unit> r122 = new AnonymousClass5(this);
        Intrinsics.checkNotNullParameter(r122, "action");
        r116.f400882c.f400891a = r122;
        Function1<Editable, Unit> r123 = new AnonymousClass6(this);
        Intrinsics.checkNotNullParameter(r123, "action");
        r116.f400882c.f400892b = r123;
        r107.setOnClickListener(new l(this));
        setCommonTip(this.f400950x);
        pla.j.h(r117, r101);
        setErrorTip(this.f400949w);
        pla.j.h(r109, false);
        setComboInputEnabled(this.f400927a);
        setLabel(this.f400943q);
        setShowLabel(this.f400940n);
        setShowLabelIcon(this.f400942p);
        setLimitCount(this.f400939m);
        setShowLimitIndicator(this.f400938l);
        setSingleLine(this.f400929c);
        setMaxLines(this.f400930d);
        setEllipsize(this.f400931e);
        setHint(this.f400947u);
        setText(r104);
        setInputMode(this.f400928b);
        setEnabled(this.f400945s);
        c6();
        b6(r116.hasFocus());
        int r124 = this.f400948v;
        if (r124 == 0) goto L31;
        setInputType(r124);
    L31:
        i6();
        r108.setOnClickListener(new m(this));
        r115.setOnClickListener(new n(this));
        S5("init");
    }

    public final void k6(LabelUIState r100, TextView r101, String r102) {
        wma.b.a("OInputView", "updateLabelUIState, state: " + r100 + ", scene: [" + r102 + ']');
        int r103 = d.f400954a[r100.ordinal()];
        if (r103 != 1) goto L5;
        this.B.setVisibility(0);
        r101.setVisibility(8);
        this.E.setAlpha(1.0f);
        return;
    L5:
        if (r103 != 2) goto L7;
        this.B.setVisibility(4);
        r101.setVisibility(0);
        this.E.setAlpha(0.0f);
        return;
    L7:
        if (r103 != 3) goto L15;
        this.B.setVisibility(8);
        r101.setVisibility(8);
        this.E.setAlpha(1.0f);
        return;
    }

    public /* synthetic */ OInputView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
