package com.obric.oui.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.oui.text.OTextView;
import com.obric.oui.widget.VerticalFadeFrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0002CDB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u0002¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u0002J\u0010\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#J\b\u0010&\u001a\u0004\u0018\u00010#J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002J\b\u0010(\u001a\u0004\u0018\u00010\u0010J\u0010\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0012J\b\u0010+\u001a\u0004\u0018\u00010\u0012J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0002H\u0016J\u0006\u00101\u001a\u00020\u0002J\u000e\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0007J\u000e\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0007R\u0017\u0010;\u001a\u0002068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006E"}, d2 = {"Lcom/obric/oui/forms/OInputLayout;", "Landroid/widget/FrameLayout;", "", "type", "", "setType", "getType", "", "enabled", "setEnabled", "setInputType", "getInputType", "resId", "setCustomStart", "defaultStart", "setDefaultCustomStart", "Landroid/view/View;", "getCustomStart", "", "label", "setLabel", "getLabel", "text", "setText", "getText", "hint", "setHint", "getHint", GXTemplateKey.STYLE_FONT_LINES, "setMaxLines", "", "lengthPx", "setFadeLength", "getFadeLength", "getMaxLines", "Landroid/text/TextUtils$TruncateAt;", "where", "setEllipsize", "getEllipsize", "setCustomEnd", "getCustomEnd", AppConstants.BUNDLE_TIP, "setTip", "getTip", "Lcom/obric/oui/forms/OInputLayout$b;", "limitStateChangeListener", "setLimitStateChangeListener", "count", "setLimitCount", "getLimitCount", "auto", "setAutoChangeWithLimit", "isError", "setTextState", "Lcom/obric/oui/forms/OEditText;", ce.f26396k, "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInput", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OInputLayout extends FrameLayout {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f400899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f400900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f400901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f400902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f400903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f400904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final VerticalFadeFrameLayout f400905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f400906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f400907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OTextView f400908j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OEditText f400909k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f400910l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f400911m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f400912n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f400913o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f400914p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f400915q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final FrameLayout f400916r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f400917s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final OTextView f400918t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final OTextView f400919u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final OTextView f400920v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f400921w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f400922x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f400923y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f400924z;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public OInputLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OInputLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static boolean d(int r100) {
        int r101 = r100 & UnixStat.PERM_MASK;
        if (r101 != 129) goto L5;
        boolean r102 = true;
    L7:
        if (r101 != 225) goto L9;
        boolean r103 = true;
    L11:
        if (r101 != 18) goto L13;
        boolean r104 = true;
    L14:
        if (r102 == true) goto L17;
        if (r103 == true) goto L17;
        if (r104 == true) goto L17;
        return false;
    L17:
        return true;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L7
    }

    public void a(Editable r100) {
    }

    public final void setLimitStateChangeListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "limitStateChangeListener");
    }

    public final View getCustomEnd() {
        if (this.f400916r.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f400916r.getChildAt(0);
    }

    public final View getCustomStart() {
        if (this.f400907i.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f400907i.getChildAt(0);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.f400909k.getEllipsize();
    }

    public final float getFadeLength() {
        return this.f400905g.getFadeLength();
    }

    public final CharSequence getHint() {
        return this.f400909k.getHint();
    }

    public final CharSequence getLabel() {
        return this.f400908j.getText();
    }

    public final int getMaxLines() {
        return this.f400909k.getMaxLines();
    }

    public CharSequence getText() {
        return this.f400909k.getText();
    }

    public final CharSequence getTip() {
        return this.f400918t.getText();
    }

    public final void h() {
        ImageView r100 = this.f400912n;
        if (e(this) == true) goto L5;
    L15:
        int r101 = 8;
    L16:
        r100.setVisibility(r101);
        m();
        return;
    L5:
        if (this.f400913o == false) goto L15;
        Editable r102 = this.f400909k.getText();
        r101 = 0;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    }

    public final void i() {
        ImageView r100 = this.f400914p;
        if (e(this) == true) goto L5;
    L17:
        int r101 = 8;
    L18:
        r100.setVisibility(r101);
        return;
    L5:
        if (this.f400915q == false) goto L17;
        if (d(this.f400911m) == false) goto L17;
        Editable r102 = this.f400909k.getText();
        r101 = 0;
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    }

    public final void j() {
        FrameLayout r100 = this.f400906h;
        boolean r101 = true;
        int r102 = 0;
        if (this.f400918t.getVisibility() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L14:
        r100.setVisibility(r102);
        return;
    L8:
        if (this.f400920v.getVisibility() == 0) goto L11;
        r101 = false;
    L11:
        if (r101 == true) goto L14;
        r102 = 8;
        goto L14
    L5:
        r103 = false;
        goto L6
    }

    public final void l() {
        if (this.f400921w <= 0) goto L5;
        OTextView r100 = this.f400919u;
        StringBuilder r101 = new StringBuilder();
        Editable r102 = this.f400909k.getText();
        Intrinsics.checkNotNull(r102);
        r101.append(b(r102));
        r101.append('/');
        r101.append(this.f400921w);
        r100.setText(r101.toString());
        OTextView r103 = this.f400920v;
        StringBuilder r104 = new StringBuilder();
        Editable r105 = this.f400909k.getText();
        Intrinsics.checkNotNull(r105);
        r104.append(b(r105));
        r104.append('/');
        r104.append(this.f400921w);
        r103.setText(r104.toString());
    L5:
        OTextView r106 = this.f400919u;
        int r107 = 8;
        boolean r108 = false;
        if (e(this) == true) goto L8;
    L10:
        int r109 = 8;
    L11:
        r106.setVisibility(r109);
        OTextView r110 = this.f400920v;
        if (c(this) == true) goto L14;
    L16:
        r110.setVisibility(r107);
        if (this.f400921w <= 0) goto L29;
        Editable r111 = this.f400909k.getText();
        if (r111 != null) goto L21;
    L24:
        boolean r112 = true;
    L25:
        if (r112 == true) goto L29;
        Editable r113 = this.f400909k.getText();
        Intrinsics.checkNotNull(r113);
        if (b(r113) <= this.f400921w) goto L29;
        boolean r114 = true;
    L30:
        boolean r115 = this.A;
        if (r114 == r115) goto L38;
        this.A = r114;
        if (r114 == true) goto L35;
    L37:
        setTextState(r108);
        return;
    L35:
        if (this.f400923y == false) goto L37;
        r108 = true;
        goto L37
    L38:
        if (r115 == false) goto L46;
        if (r115 == true) goto L41;
    L43:
        setTextState(r108);
        return;
    L41:
        if (this.f400923y == false) goto L43;
        r108 = true;
        goto L43
    L46:
        return;
    L21:
        if (r111.length() == 0) goto L24;
        r112 = false;
    L29:
        r114 = false;
        goto L30
    L14:
        if (this.f400922x == false) goto L16;
        r107 = 0;
        goto L16
    L8:
        if (this.f400922x == false) goto L10;
        r109 = 0;
        goto L11
    }

    public final void k() {
        boolean r100 = true;
        if (getMaxLines() != 1) goto L6;
        r100 = false;
    L6:
        int r101 = this.f400911m;
        if (r100 == true) goto L9;
    L11:
        int r102 = r101 ^ 131072;
    L12:
        this.f400909k.setInputType(r102);
        this.f400909k.invalidate();
        this.f400905g.c(false);
        return;
    L9:
        if (d(r101) == true) goto L11;
        r102 = r101 | 131072;
        goto L12
    }

    public final void m() {
        boolean r100 = true;
        if (e(this) == true) goto L5;
        LinearLayout r101 = this.f400904f;
        int r102 = pla.d.n(this, 12);
        int r103 = pla.d.n(this, 8);
        if (this.f400906h.getVisibility() == 0) goto L20;
        r100 = false;
    L20:
        if (r100 == false) goto L22;
        int r104 = pla.d.n(this, 0);
    L23:
        r101.setPadding(r102, r103, 0, r104);
        this.f400908j.setPadding(0, 0, pla.d.n(this, 12), 0);
        this.f400909k.setPadding(0, 0, pla.d.n(this, 12), 0);
        this.f400909k.setGravity(8388659);
        this.f400909k.setScrollBarStyle(33554432);
        this.f400906h.setPadding(pla.d.n(this, 12), pla.d.n(this, 6), pla.d.n(this, 12), pla.d.n(this, 8));
        return;
    L22:
        r104 = pla.d.n(this, 8);
        goto L23
    L5:
        if (this.f400908j.getVisibility() == 0) goto L8;
        r100 = false;
    L8:
        if (r100 == false) goto L10;
        int r105 = pla.d.l(this, 8.5d);
    L11:
        LinearLayout r106 = this.f400904f;
        int r107 = pla.d.n(this, 12);
        if (this.f400913o == false) goto L14;
        int r108 = pla.d.n(this, 8);
    L15:
        r106.setPadding(r107, r105, r108, r105);
        this.f400908j.setPadding(0, 0, 0, 0);
        this.f400909k.setPadding(0, 0, 0, 0);
        this.f400909k.setGravity(8388627);
        this.f400909k.setScrollBarStyle(0);
        int r109 = pla.d.n(this, 5);
        this.f400906h.setPadding(pla.d.n(this, 12), r109, pla.d.n(this, 8), r109);
        return;
    L14:
        r108 = pla.d.n(this, 12);
        goto L15
    L10:
        r105 = pla.d.n(this, 13);
        goto L11
    }

    public final int getInputType() {
        return this.f400911m;
    }

    public final int getLimitCount() {
        return this.f400921w;
    }

    public final int getType() {
        return this.f400899a;
    }

    public final OEditText getVInput() {
        return this.f400909k;
    }

    public static boolean c(OInputLayout r100) {
        int r101 = r100.f400899a;
        r100.getClass();
        if (r101 != 1) goto L5;
        return true;
    L5:
        if (r101 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean e(OInputLayout r100) {
        int r101 = r100.f400899a;
        r100.getClass();
        if (r101 != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int b(CharSequence r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.length();
    }

    public void f(boolean r100) {
        if (c(this) == false) goto L5;
        return;
    L5:
        int r101 = 8;
        if (this.f400907i.getChildCount() == 0) goto L11;
        FrameLayout r102 = this.f400907i;
        if (r100 == false) goto L10;
        r101 = 0;
    L10:
        r102.setVisibility(r101);
        return;
    L11:
        this.f400907i.setVisibility(8);
    }

    public final void g(boolean r100) {
        CharSequence r101 = getLabel();
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L16;
        OTextView r104 = this.f400908j;
        if (r100 == true) goto L15;
        r102 = 8;
    L15:
        r104.setVisibility(r102);
    L17:
        m();
        return;
    L16:
        this.f400908j.setVisibility(8);
        goto L17
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public final void setAutoChangeWithLimit(boolean r100) {
        this.f400923y = r100;
        if (this.A == false) goto L6;
        if (r100 == false) goto L6;
        boolean r101 = true;
    L7:
        setTextState(r101);
        return;
    L6:
        r101 = false;
        goto L7
    }

    public final void setCustomEnd(int r100) {
        this.f400916r.removeAllViews();
        if (r100 == 0) goto L9;
        FrameLayout.inflate(getContext(), r100, this.f400916r);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setCustomStart(int r100) {
        this.f400907i.removeAllViews();
        if (r100 == 0) goto L9;
        FrameLayout.inflate(getContext(), r100, this.f400907i);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setDefaultCustomStart(int r100) {
        this.f400907i.removeAllViews();
        if (r100 != 0) goto L5;
        setCustomStart(R.layout.o_input_custom_start_area_code);
        return;
    L5:
        f(false);
    }

    public final void setEllipsize(TextUtils.TruncateAt r100) {
        this.f400909k.setEllipsize(r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        Iterator<View> r101 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().setEnabled(r100);
        goto L4
    L6:
        this.f400909k.setEnabled(r100);
    }

    public final void setFadeLength(float r100) {
        float r101 = RangesKt.coerceAtLeast(r100, 0.0f);
        if (this.f400903e != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f400903e = r101;
        if (r101 < 0.0f) goto L11;
        this.f400905g.setFadeLength(r101);
    L11:
        this.f400905g.c(false);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setHint(CharSequence r100) {
        this.f400909k.setHint(r100);
    }

    public final void setInputType(int r100) {
        if ((r100 & 1) != 0) goto L12;
        if ((r100 & 2) != 0) goto L12;
        if ((r100 & 3) != 0) goto L12;
        if ((r100 & 4) != 0) goto L12;
        r100 = r100 | 1;
    L12:
        if (this.f400911m == r100) goto L14;
        this.f400911m = r100;
    L14:
        k();
        i();
        a(this.f400909k.getText());
    }

    public final void setLabel(CharSequence r100) {
        this.f400908j.setText(r100);
    }

    public void setLimitCount(int r100) {
        if (this.f400921w != r100) goto L5;
        return;
    L5:
        this.f400921w = r100;
        l();
        a(this.f400909k.getText());
    }

    public final void setMaxLines(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        this.f400902d = r100;
        OEditText r101 = this.f400909k;
        boolean r102 = true;
        if (r100 == 1) goto L8;
        r102 = false;
    L8:
        r101.setSingleLine(r102);
        this.f400909k.setMaxLines(r100);
        k();
        this.f400905g.c(false);
    }

    public final void setText(CharSequence r100) {
        this.f400909k.setText(r100);
        a(this.f400909k.getText());
    }

    public final void setTextState(boolean r110) {
        if (this.f400924z == false) goto L5;
        return;
    L5:
        boolean r100 = true;
        this.f400924z = true;
        int r101 = this.f400909k.getSelectionStart();
        int r102 = this.f400909k.getSelectionEnd();
        Editable r103 = this.f400909k.getText();
        if (r103 == null) goto L57;
        int r104 = r103.length();     // Catch: Exception -> L54
        if (r110 == false) goto L10;
        int r105 = ContextCompat.getColor(getContext(), R.color.oui_functional_red_2);     // Catch: Exception -> L54
    L11:
        ErrorBackgroundSpan[] r106 = (ErrorBackgroundSpan[]) r103.getSpans(0, r104, ErrorBackgroundSpan.class);     // Catch: Exception -> L54
        int r107 = r106.length;     // Catch: Exception -> L54
        int r108 = 0;
    L12:
        if (r108 >= r107) goto L20;
        ErrorBackgroundSpan r111 = r106[r108];     // Catch: Exception -> L54
        if (r111.getBackgroundColor() != r105) goto L16;
        boolean r112 = true;
    L17:
        if (r112 == true) goto L21;
        r108 = r108 + 1;     // Catch: Exception -> L54
    L21:
        if (r111 != null) goto L23;
        r111 = new ErrorBackgroundSpan(r105);     // Catch: Exception -> L54
    L23:
        int r109 = r106.length;     // Catch: Exception -> L54
        int r113 = 0;
    L24:
        if (r113 >= r109) goto L26;
        r103.removeSpan(r106[r113]);     // Catch: Exception -> L54
        r113 = r113 + 1;     // Catch: Exception -> L54
        goto L24
    L26:
        r103.setSpan(r111, 0, r104, 33);     // Catch: Exception -> L54
        u[] r114 = (u[]) r103.getSpans(0, r104, u.class);     // Catch: Exception -> L54
        int r115 = r114.length;     // Catch: Exception -> L54
        int r116 = 0;
    L27:
        if (r116 >= r115) goto L41;
        u r117 = r114[r116];     // Catch: Exception -> L54
        if (r117 == null) goto L40;
        if (r117.f401046d == r110) goto L38;
        r117.f401046d = r110;     // Catch: Exception -> L54
        u.b r118 = r117.f401047e;     // Catch: Exception -> L54
        if (r118 == null) goto L38;
        r118.f401057e = r110;     // Catch: Exception -> L54
        int r119 = 0;
    L36:
        if (r119 >= r118.f401058f.size()) goto L38;
        ((u.a) ListProtector.get(r118.f401058f, r119)).f401052e = r110;     // Catch: Exception -> L54
        r119 = r119 + 1;     // Catch: Exception -> L54
    L38:
        r116 = r116 + 1;     // Catch: Exception -> L54
        goto L27
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.forms.OPasswordTransformationMethod");     // Catch: Exception -> L54
    L41:
        if (r101 < 0) goto L44;
        if (r101 > r104) goto L44;
        boolean r120 = true;
    L45:
        if (r120 == false) goto L52;
        if (r102 < 0) goto L49;
        if (r102 > r104) goto L49;
    L50:
        if (r100 == false) goto L52;
        this.f400909k.setSelection(r101, r102);     // Catch: Exception -> L54
    L49:
        r100 = false;
    L52:
        this.f400909k.setSelection(r101, r104);     // Catch: Exception -> L54
    L44:
        r120 = false;
        goto L45
    L16:
        r112 = false;
        goto L17
    L20:
        r111 = null;
        goto L21
    L10:
        r105 = 0;
    L54:
        e = move-exception;
        Intrinsics.stringPlus("Error setTextState: ", e);
    L57:
        if (this.B == r110) goto L65;
        this.B = r110;
        if (Build.VERSION.SDK_INT < 29) goto L65;
        OEditText r121 = this.f400909k;
        if (r110 == false) goto L63;
        int r122 = R.drawable.o_input_cursor_red;
    L64:
        r121.setTextCursorDrawable(r122);
        goto L65
    L63:
        r122 = R.drawable.o_input_cursor_blue;
    L65:
        OTextView r123 = this.f400918t;
        Resources r124 = getResources();
        int r125 = R.color.oui_basic_text_3b;
        if (r110 == false) goto L68;
        int r126 = R.color.oui_functional_red_6;
    L69:
        r123.setTextColor(r124.getColor(r126));
        OTextView r127 = this.f400919u;
        Resources r128 = getResources();
        if (r110 == false) goto L72;
        int r129 = R.color.oui_functional_red_6;
    L73:
        r127.setTextColor(r128.getColor(r129));
        OTextView r130 = this.f400920v;
        Resources r131 = getResources();
        if (r110 == false) goto L76;
        r125 = R.color.oui_functional_red_6;
    L76:
        r130.setTextColor(r131.getColor(r125));
        this.f400924z = false;
        this.f400905g.c(false);
        return;
    L72:
        r129 = R.color.oui_basic_text_3b;
        goto L73
    L68:
        r126 = R.color.oui_basic_text_3b;
        goto L69
    }

    public final void setTip(CharSequence r100) {
        this.f400918t.setText(r100);
    }

    public void setType(int r100) {
        boolean r101 = true;
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L9;
        boolean r102 = false;
    L10:
        if (r102 == true) goto L12;
        return;
    L12:
        this.f400899a = r100;
        OEditText r103 = this.f400909k;
        int r104 = this.f400900b;
        if (r104 != (-1)) goto L28;
        if (r100 != 0) goto L17;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
        float r106 = pla.d.r(this, 22.0f);
    L27:
        r104 = (int) r106;
        goto L28
    L21:
        if (r100 != 1) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == false) goto L26;
        r104 = pla.d.n(this, 120);
        goto L28
    L26:
        r106 = pla.d.r(this, 22.0f);
        goto L27
    L23:
        r107 = false;
        goto L24
    L17:
        r105 = false;
    L28:
        r103.setMinimumHeight(r104);
        OEditText r108 = this.f400909k;
        int r109 = this.f400901c;
        if (r109 != (-1)) goto L38;
        if (r100 != 0) goto L33;
        boolean r110 = true;
    L34:
        if (r110 == false) goto L36;
        int r111 = 66;
    L37:
        r109 = pla.d.n(this, r111);
        goto L38
    L36:
        r111 = 240;
        goto L37
    L33:
        r110 = false;
    L38:
        r108.setMaxHeight(r109);
        int r112 = this.f400902d;
        if (r112 != (-1)) goto L47;
        if (r100 != 0) goto L43;
        boolean r113 = true;
    L44:
        if (r113 == false) goto L46;
        r112 = 1;
        goto L47
    L46:
        r112 = 12;
        goto L47
    L43:
        r113 = false;
    L47:
        OEditText r114 = this.f400909k;
        if (r112 == 1) goto L51;
        r101 = false;
    L51:
        r114.setSingleLine(r101);
        this.f400909k.setMaxLines(r112);
        k();
        this.f400905g.c(false);
        m();
        l();
        h();
        i();
        return;
    L9:
        r102 = true;
        goto L10
    }

    public OInputLayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f400900b = -1;
        this.f400901c = -1;
        this.f400902d = -1;
        this.f400903e = -1.0f;
        this.f400911m = 131073;
        this.f400921w = -1;
        View r113 = LayoutInflater.from(r110).inflate(R.layout.o_input_view_layout, this, true);
        if (r113 == null) goto L78;
        FrameLayout r114 = (FrameLayout) r113;
        LinearLayout r115 = (LinearLayout) findViewById(R.id.input_container);
        this.f400904f = r115;
        LinearLayout r100 = (LinearLayout) findViewById(R.id.edit_container);
        VerticalFadeFrameLayout r101 = (VerticalFadeFrameLayout) findViewById(R.id.input_fade_container);
        this.f400905g = r101;
        this.f400906h = (FrameLayout) findViewById(R.id.helper_container);
        this.f400907i = (FrameLayout) findViewById(R.id.custom_start_container);
        this.f400908j = (OTextView) findViewById(R.id.label);
        OEditText r102 = (OEditText) findViewById(R.id.input);
        this.f400909k = r102;
        if (this.f400899a != 0) goto L7;
        int r103 = (int) pla.d.r(this, 22.0f);
    L8:
        r102.setMinimumHeight(r103);
        if (this.f400899a != 0) goto L11;
        int r104 = 66;
    L12:
        r102.setMaxHeight(pla.d.n(this, r104));
        FrameLayout r105 = (FrameLayout) findViewById(R.id.custom_end_container);
        this.f400916r = r105;
        this.f400917s = findViewById(R.id.input_divider);
        this.f400912n = (ImageView) findViewById(R.id.clear);
        this.f400914p = (ImageView) findViewById(R.id.eyes);
        OTextView r106 = (OTextView) findViewById(R.id.tip);
        this.f400918t = r106;
        this.f400919u = (OTextView) findViewById(R.id.limit_single);
        this.f400920v = (OTextView) findViewById(R.id.limit_multi);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        r102.setFocusable(true);
        r102.setFocusableInTouchMode(true);
        if (r111 == null) goto L59;
        TypedArray r116 = getContext().getTheme().obtainStyledAttributes(r111, new int[]{android.R.attr.ellipsize, android.R.attr.maxLines, android.R.attr.digits, android.R.attr.inputType, R.attr.oinput_autoChangeWithLimit, R.attr.oinput_customEnd, R.attr.oinput_customStart, R.attr.oinput_fadeLength, R.attr.oinput_hint, R.attr.oinput_label, R.attr.oinput_limitCount, R.attr.oinput_maxHeight, R.attr.oinput_minHeight, R.attr.oinput_showClear, R.attr.oinput_showCustomEnd, R.attr.oinput_showCustomStart, R.attr.oinput_showEyes, R.attr.oinput_showInputBackground, R.attr.oinput_showLabel, R.attr.oinput_showLimit, R.attr.oinput_showTip, R.attr.oinput_text, R.attr.oinput_tip, R.attr.oinput_type}, r112, 0);
        this.f400900b = r116.getDimensionPixelSize(12, this.f400900b);
        this.f400901c = r116.getDimensionPixelSize(11, this.f400901c);
        this.f400903e = r116.getDimension(7, this.f400903e);
        setType(r116.getInt(23, 0));
        if (r116.getBoolean(17, false) == false) goto L18;
        int r117 = getResources().getColor(R.color.oui_fill_list_item_card);
    L19:
        r115.setBackgroundColor(r117);
        setCustomStart(r116.getResourceId(6, 0));
        f(r116.getBoolean(15, false));
        setLabel(r116.getString(9));
        g(r116.getBoolean(18, false));
        setText(r116.getString(21));
        int r118 = 8;
        setHint(r116.getString(8));
        this.f400910l = r116.getText(2);
        this.f400911m = r116.getInt(3, this.f400911m);
        setMaxLines(r116.getInt(1, -1));
        if (r116.hasValue(0) == false) goto L32;
        int r107 = r116.getInt(0, 0);
        if (r107 == 1) goto L30;
        if (r107 == 2) goto L29;
        if (r107 == 3) goto L28;
        if (r107 == 4) goto L27;
        TextUtils.TruncateAt r119 = null;
    L31:
        setEllipsize(r119);
        goto L32
    L27:
        r119 = TextUtils.TruncateAt.MARQUEE;
        goto L31
    L28:
        r119 = TextUtils.TruncateAt.END;
        goto L31
    L29:
        r119 = TextUtils.TruncateAt.MIDDLE;
        goto L31
    L30:
        r119 = TextUtils.TruncateAt.START;
    L32:
        setCustomEnd(r116.getResourceId(5, 0));
        boolean r120 = r116.getBoolean(14, false);
        if (c(this) == false) goto L36;
    L42:
        this.f400913o = r116.getBoolean(13, false);
        this.f400915q = r116.getBoolean(16, false);
        setTip(r116.getString(22));
        boolean r121 = r116.getBoolean(20, false);
        CharSequence r108 = getTip();
        if (r108 != null) goto L45;
    L48:
        boolean r109 = true;
    L49:
        if (r109 == true) goto L53;
        if (r121 == false) goto L52;
        r118 = 0;
    L52:
        r106.setVisibility(r118);
    L54:
        j();
        setLimitCount(r116.getInt(10, -1));
        boolean r122 = r116.getBoolean(19, false);
        if (this.f400922x == r122) goto L58;
        this.f400922x = r122;
        l();
        j();
    L58:
        setAutoChangeWithLimit(r116.getBoolean(4, false));
        goto L59
    L53:
        r106.setVisibility(8);
        goto L54
    L45:
        if (r108.length() == 0) goto L48;
        r109 = false;
        goto L49
    L36:
        if (r105.getChildCount() == 0) goto L41;
        if (r120 == false) goto L39;
        int r123 = 0;
    L40:
        r105.setVisibility(r123);
        goto L42
    L39:
        r123 = 8;
        goto L40
    L41:
        r105.setVisibility(8);
        goto L42
    L18:
        r117 = 0;
    L59:
        float r124 = this.f400903e;
        if (r124 < 0.0f) goto L79;
        r101.setFadeLength(r124);
    L79:
        Method r125 = TextView.class.getDeclaredMethod("enableUpdateCursorDrawable", new Class[0]);     // Catch: Exception -> L64
        r125.setAccessible(true);     // Catch: Exception -> L64
        r125.invoke(r102, new Object[0]);     // Catch: Exception -> L64
    L65:
        CharSequence r126 = this.f400910l;
        if (r126 == null) goto L72;
        this.f400909k.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r126)));
        int r127 = this.f400911m;
        if (r127 != 0) goto L71;
        r127 = 1;
    L71:
        this.f400911m = r127;
    L72:
        int r128 = this.f400911m;
        if (r128 == 0) goto L75;
        setInputType(r128);
    L75:
        OEditText r129 = this.f400909k;
        Function1<Boolean, Unit> r130 = new OInputLayout$initInput$1(this);
        r129.getClass();
        Intrinsics.checkNotNullParameter(r130, "action");
        r129.f400880a.f400887a = r130;
        OEditText r131 = this.f400909k;
        Function4<CharSequence, Integer, Integer, Integer, Unit> r132 = new OInputLayout$initInput$2(this);
        r131.getClass();
        Intrinsics.checkNotNullParameter(r132, "action");
        r131.f400882c.f400891a = r132;
        OEditText r133 = this.f400909k;
        Function1<Editable, Unit> r134 = new OInputLayout$initInput$3(this);
        r133.getClass();
        Intrinsics.checkNotNullParameter(r134, "action");
        r133.f400882c.f400892b = r134;
        this.f400912n.setOnClickListener(new f(this));
        this.f400914p.setOnClickListener(new g(this));
        this.f400904f.setOnClickListener(new h(this));
        this.f400904f.setClipToOutline(true);
        this.f400904f.setOutlineProvider(new i(this));
        this.f400904f.invalidateOutline();
        return;
    L11:
        r104 = 240;
        goto L12
    L7:
        r103 = pla.d.n(this, 120);
        goto L8
    L78:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public /* synthetic */ OInputLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
