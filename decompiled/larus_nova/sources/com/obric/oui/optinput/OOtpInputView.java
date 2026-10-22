package com.obric.oui.optinput;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u00041234B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0012J\u0010\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u0010\u001a\u00020\u0002R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00065"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView;", "Landroid/view/View;", "", "length", "", "setCodeLength", "getCodeLength", "", "getCode", "code", "setCode", "", "enabled", "setPasswordMode", "visible", "setCursorVisible", "color", "setCursorColor", "", GXTemplateKey.GAIAX_PX, "setCellSpacing", "setCellCornerRadius", "setCellStrokeWidth", "setCellStrokeColor", "setCellBackgroundColor", CloudControlInf.SP, "setTextSizeSp", "setTextColor", "Lcom/obric/oui/optinput/OOtpInputView$c;", "onCodeCompleteListener", "Lcom/obric/oui/optinput/OOtpInputView$c;", "getOnCodeCompleteListener", "()Lcom/obric/oui/optinput/OOtpInputView$c;", "setOnCodeCompleteListener", "(Lcom/obric/oui/optinput/OOtpInputView$c;)V", "Lcom/obric/oui/optinput/OOtpInputView$b;", "onCodeChangeListener", "Lcom/obric/oui/optinput/OOtpInputView$b;", "getOnCodeChangeListener", "()Lcom/obric/oui/optinput/OOtpInputView$b;", "setOnCodeChangeListener", "(Lcom/obric/oui/optinput/OOtpInputView$b;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OOtpInputView extends View {
    public float A;
    public float B;
    public float C;
    public boolean D;
    public boolean E;
    public final e F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f401495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public char[] f401496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f401497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f401498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f401499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f401500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f401501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f401502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f401503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f401504j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f401505k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f401506l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f401507m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f401508n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f401509o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f401510p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f401511q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f401512r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f401513s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RectF f401514t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Paint.FontMetrics f401515u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f401516v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final char[] f401517w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f401518x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f401519y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f401520z;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    public static final class d extends BaseInputConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OOtpInputView f401521a;

        public d(OOtpInputView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100, false);
            this.f401521a = r100;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (r100.getAction() != 0) goto L14;
            if (r100.getKeyCode() == 67) goto L7;
            char r101 = (char) r100.getUnicodeChar();
            if (Character.isDigit(r101) == false) goto L14;
            this.f401521a.a(String.valueOf(r101));
            return true;
        L7:
            if (this.f401521a.b() == false) goto L14;
            return true;
        L14:
            return super.sendKeyEvent(r100);
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r100, int r101) {
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L11;
            return true;
        L11:
            this.f401521a.a(r100);
            return true;
        L5:
            if (r100.length() == 0) goto L8;
            r102 = false;
            goto L9
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r100, int r101) {
            if (this.f401521a.b() == false) goto L6;
            return true;
        L6:
            return super.deleteSurroundingText(r100, r101);
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OOtpInputView f401522a;

        @Override // java.lang.Runnable
        public final void run() {
            OOtpInputView r100 = this.f401522a;     // Catch: Throwable -> L7
            if (r100.E == false) goto L10;
            r100.D = !r100.D;     // Catch: Throwable -> L7
            r100.invalidate();     // Catch: Throwable -> L7
            this.f401522a.postDelayed(this, 500);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }

        public e(OOtpInputView r100) {
            this.f401522a = r100;
        }
    }

    static {
    }

    public OOtpInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OOtpInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final b getOnCodeChangeListener() {
        return null;
    }

    public final c getOnCodeCompleteListener() {
        return null;
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        return true;
    }

    public final void setOnCodeChangeListener(b r100) {
    }

    public final void setOnCodeCompleteListener(c r100) {
    }

    public final boolean b() {
        int r100 = this.f401497c;
        boolean r101 = false;
        if (r100 <= 0) goto L17;
        int r102 = RangesKt.coerceAtLeast(r100 - 1, 0);
        char[] r103 = this.f401496b;
        if (r103[r102] != 0) goto L15;
        if (r102 < 0) goto L14;
    L8:
        int r104 = r102 - 1;
        char[] r105 = this.f401496b;
        if (r105[r102] != 0) goto L10;
        if (r104 < 0) goto L14;
        r102 = r104;
        goto L8
    L10:
        r105[r102] = 0;
        this.f401497c = r102;
    L16:
        r101 = true;
    L14:
        this.f401497c = 0;
        goto L17
    L15:
        r103[r102] = 0;
        this.f401497c = r102;
    L17:
        if (r101 == false) goto L19;
        invalidate();
    L19:
        return r101;
    }

    public final void d() {
        if (this.E == false) goto L5;
        return;
    L5:
        this.E = true;
        this.D = true;
        removeCallbacks(this.F);
        postDelayed(this.F, 500);
    }

    public final String getCode() {
        StringBuilder r100 = new StringBuilder(this.f401495a);
        int r101 = this.f401495a;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        int r103 = r102 + 1;
        char r104 = this.f401496b[r102];
        if (r104 == 0) goto L8;
        r100.append(r104);
        r102 = r103;
    L8:
        return r100.toString();
    }

    public final void c() {
        Object r100 = getContext().getSystemService("input_method");
        if ((r100 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r101 = (InputMethodManager) r100;
    L6:
        if (r101 == null) goto L10;
        r101.showSoftInput(this, 1);
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isFocusable() == false) goto L10;
        if (isFocusableInTouchMode() == false) goto L10;
        if (isInEditMode() == true) goto L10;
        requestFocus();
        c();
    L10:
        if (hasFocus() == true) goto L12;
        return;
    L12:
        if (this.f401509o == false) goto L16;
        d();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.E = false;
        removeCallbacks(this.F);
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return true;
    }

    public final int getCodeLength() {
        return this.f401495a;
    }

    public final void a(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        int r101 = 0;
        boolean r102 = true;
        if (this.f401497c < this.f401495a) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        boolean r104 = false;
    L10:
        if (r101 >= r100.length()) goto L21;
        char r105 = r100.charAt(r101);
        r101 = r101 + 1;
        if (Character.isDigit(r105) == false) goto L10;
        int r106 = this.f401497c;
        int r107 = this.f401495a;
        if (r106 >= r107) goto L21;
        this.f401496b[r106] = r105;
        int r108 = r106 + 1;
        this.f401497c = r108;
        if (r108 >= r107) goto L22;
        r104 = true;
    L22:
        if (r102 == false) goto L32;
        invalidate();
        return;
    L32:
        return;
    L21:
        r102 = r104;
        goto L22
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.B = pla.d.p(this, 4.0f);
        this.C = pla.d.p(this, 1.0f);
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "outAttrs");
        if (this.f401508n == false) goto L5;
        int r101 = 16;
    L6:
        r100.inputType = r101 | 2;
        r100.imeOptions = 268435462;
        int r102 = this.f401497c;
        r100.initialSelStart = r102;
        r100.initialSelEnd = r102;
        return new d(this);
    L5:
        r101 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        this.f401510p.setColor(this.f401503i);
        this.f401511q.setColor(this.f401504j);
        int r100 = this.f401495a;
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L16;
        int r102 = r101 + 1;
        float r103 = this.f401518x;
        float r104 = this.f401498d;
        float r105 = r103 + (r101 * (this.A + r104));
        float r106 = this.f401519y;
        float r107 = this.f401499e + r106;
        this.f401514t.set(r105, r106, r104 + r105, r107);
        RectF r108 = this.f401514t;
        float r109 = this.f401501g;
        r110.drawRoundRect(r108, r109, r109, this.f401510p);
        float r111 = this.f401502h;
        if (r111 <= 0.0f) goto L8;
        float r112 = r111 / 2.0f;
        float r113 = RangesKt.coerceAtLeast(this.f401501g - r112, 0.0f);
        this.f401514t.inset(r112, r112);
        r110.drawRoundRect(this.f401514t, r113, r113, this.f401511q);
        float r114 = -r112;
        this.f401514t.inset(r114, r114);
    L8:
        char r115 = this.f401496b[r101];
        if (r115 == 0) goto L14;
        float r116 = this.f401514t.centerX();
        if (this.f401508n == false) goto L13;
        r110.drawCircle(r116, this.f401520z, this.B, this.f401512r);
        goto L14
    L13:
        char[] r117 = this.f401517w;
        r117[0] = r115;
        r110.drawText(r117, 0, 1, r116, this.f401520z + this.f401516v, this.f401512r);
    L14:
        r101 = r102;
        goto L4
    L16:
        if (isFocused() == true) goto L18;
    L27:
        boolean r118 = false;
    L28:
        if (r118 == false) goto L35;
        int r119 = RangesKt.coerceIn(this.f401497c, 0, this.f401495a - 1);
        float r120 = this.f401518x;
        float r121 = this.f401498d;
        float r122 = r120 + (r119 * (this.A + r121));
        float r123 = (r122 + (r121 + r122)) / 2.0f;
        float r124 = this.f401499e * 0.375f;
        float r125 = this.f401520z;
        float r126 = r124 / 2.0f;
        float r127 = r125 - r126;
        float r128 = r125 + r126;
        float r129 = this.C;
        r110.drawRect(r123 - r129, r127, r123 + r129, r128, this.f401513s);
        return;
    L35:
        return;
    L18:
        if (this.f401509o == false) goto L27;
        if (this.D == false) goto L27;
        if (this.f401497c >= this.f401495a) goto L27;
        r118 = true;
        goto L28
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L6;
        super.performClick();
        return true;
    L6:
        return super.onTouchEvent(r100);
    L9:
        requestFocus();
        c();
        return true;
    }

    public final void setCellBackgroundColor(int r100) {
        if (this.f401503i != r100) goto L5;
        return;
    L5:
        this.f401503i = r100;
        invalidate();
    }

    public final void setCellCornerRadius(float r100) {
        if (this.f401501g != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        this.f401501g = r100;
        invalidate();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setCellSpacing(float r100) {
        if (this.f401500f != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        this.f401500f = r100;
        requestLayout();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setCellStrokeColor(int r100) {
        if (this.f401504j != r100) goto L5;
        return;
    L5:
        this.f401504j = r100;
        invalidate();
    }

    public final void setCellStrokeWidth(float r100) {
        if (this.f401502h != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        this.f401502h = r100;
        this.f401511q.setStrokeWidth(r100);
        invalidate();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setCode(String r100) {
        int r101 = this.f401495a;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        this.f401496b[r103] = 0;
        r103 = r103 + 1;
        goto L3
    L5:
        this.f401497c = 0;
        if (r100 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        invalidate();
        return;
    L15:
        int r105 = 0;
    L17:
        if (r102 >= r100.length()) goto L25;
        char r106 = r100.charAt(r102);
        r102 = r102 + 1;
        if (Character.isDigit(r106) == false) goto L17;
        if (r105 >= this.f401495a) goto L25;
        this.f401496b[r105] = r106;
        r105 = r105 + 1;
    L25:
        this.f401497c = r105;
        invalidate();
        return;
    L8:
        if (r100.length() == 0) goto L11;
        r104 = false;
        goto L12
    }

    public final void setCodeLength(int r100) {
        int r101 = RangesKt.coerceIn(r100, 1, 6);
        if (r101 != this.f401495a) goto L5;
        return;
    L5:
        this.f401495a = r101;
        char[] r102 = this.f401496b;
        this.f401496b = new char[r101];
        int r103 = Math.min(r102.length, r101);
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r105 >= r103) goto L8;
        this.f401496b[r105] = r102[r105];
        r105 = r105 + 1;
        goto L6
    L8:
        int r106 = this.f401495a;
    L9:
        if (r104 >= r106) goto L14;
        int r107 = r104 + 1;
        if (this.f401496b[r104] == 0) goto L15;
        r104 = r107;
    L15:
        this.f401497c = r104;
        requestLayout();
        invalidate();
        return;
    L14:
        r104 = this.f401495a;
        goto L15
    }

    public final void setCursorColor(int r100) {
        if (this.f401507m != r100) goto L5;
        return;
    L5:
        this.f401507m = r100;
        this.f401513s.setColor(r100);
        invalidate();
    }

    public final void setCursorVisible(boolean r100) {
        if (this.f401509o != r100) goto L5;
        return;
    L5:
        this.f401509o = r100;
        if (r100 == true) goto L9;
        this.E = false;
        removeCallbacks(this.F);
    L11:
        invalidate();
        return;
    L9:
        if (hasFocus() == false) goto L11;
        d();
        goto L11
    }

    public final void setPasswordMode(boolean r100) {
        if (this.f401508n != r100) goto L5;
        return;
    L5:
        this.f401508n = r100;
        invalidate();
        Object r101 = getContext().getSystemService("input_method");
        if ((r101 instanceof InputMethodManager) == false) goto L8;
        InputMethodManager r102 = (InputMethodManager) r101;
    L9:
        if (r102 == null) goto L13;
        r102.restartInput(this);
        return;
    L13:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void setTextColor(int r100) {
        if (this.f401505k != r100) goto L5;
        return;
    L5:
        this.f401505k = r100;
        this.f401512r.setColor(r100);
        invalidate();
    }

    public final void setTextSizeSp(float r100) {
        float r101 = pla.d.r(this, r100);
        if (this.f401506l != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f401506l = r101;
        this.f401512r.setTextSize(r101);
        this.f401512r.getFontMetrics(this.f401515u);
        Paint.FontMetrics r103 = this.f401515u;
        this.f401516v = -((r103.ascent + r103.descent) / 2.0f);
        invalidate();
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r100 != 67) goto L8;
        if (b() == false) goto L8;
        return true;
    L8:
        if (r100 < 7) goto L14;
        if (r100 > 16) goto L14;
        a(String.valueOf((char) ((r100 - 7) + 48)));
        return true;
    L14:
        if (r100 < 144) goto L20;
        if (r100 > 153) goto L20;
        a(String.valueOf((char) ((r100 - 144) + 48)));
        return true;
    L20:
        return super.onKeyDown(r100, r101);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        float r102 = this.f401498d;
        int r103 = this.f401495a;
        setMeasuredDimension(View.resolveSize((int) ((getPaddingLeft() + getPaddingRight()) + ((r102 * r103) + (this.f401500f * (r103 - 1)))), r100), View.resolveSize((int) ((getPaddingTop() + getPaddingBottom()) + this.f401499e), r101));
    }

    public OOtpInputView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f401495a = 6;
        this.f401496b = new char[6];
        Paint r100 = new Paint(1);
        this.f401510p = r100;
        Paint r101 = new Paint(1);
        this.f401511q = r101;
        Paint r102 = new Paint(1);
        this.f401512r = r102;
        Paint r103 = new Paint(1);
        this.f401513s = r103;
        this.f401514t = new RectF();
        Paint.FontMetrics r104 = new Paint.FontMetrics();
        this.f401515u = r104;
        this.f401517w = new char[1];
        this.D = true;
        this.F = new e(this);
        this.B = pla.d.p(this, 4.0f);
        this.C = pla.d.p(this, 1.0f);
        float r105 = pla.d.p(this, 42.0f);
        this.f401498d = r105;
        float r106 = pla.d.p(this, 48.0f);
        this.f401499e = r106;
        this.f401500f = pla.d.p(this, 12.0f);
        this.f401501g = pla.d.p(this, 10.0f);
        this.f401502h = pla.d.p(this, 1.0f);
        this.f401506l = pla.d.r(this, 20.0f);
        this.f401503i = ContextCompat.getColor(r110, R.color.oui_advanced_fill_list_item_card);
        this.f401504j = ContextCompat.getColor(r110, R.color.oui_advanced_fill_list_item_card);
        this.f401505k = ContextCompat.getColor(r110, R.color.oui_basic_text_1);
        this.f401507m = ContextCompat.getColor(r110, R.color.oui_functional_blue_6);
        this.f401508n = false;
        this.f401509o = true;
        if (r111 == null) goto L14;
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.o_otpCellBackgroundColor, R.attr.o_otpCellCornerRadius, R.attr.o_otpCellHeight, R.attr.o_otpCellSpacing, R.attr.o_otpCellStrokeColor, R.attr.o_otpCellStrokeWidth, R.attr.o_otpCellWidth, R.attr.o_otpCodeLength, R.attr.o_otpCursorColor, R.attr.o_otpCursorVisible, R.attr.o_otpPasswordMode, R.attr.o_otpTextColor, R.attr.o_otpTextSize}, r112, 0);
        int r114 = RangesKt.coerceIn(r113.getInt(7, 6), 1, 6);     // Catch: Throwable -> L11
        if (r114 == this.f401495a) goto L9;
        this.f401495a = r114;     // Catch: Throwable -> L11
        this.f401496b = new char[r114];     // Catch: Throwable -> L11
        this.f401497c = 0;     // Catch: Throwable -> L11
    L9:
        this.f401498d = r113.getDimension(6, r105);     // Catch: Throwable -> L11
        this.f401499e = r113.getDimension(2, r106);     // Catch: Throwable -> L11
        this.f401500f = r113.getDimension(3, this.f401500f);     // Catch: Throwable -> L11
        this.f401501g = r113.getDimension(1, this.f401501g);     // Catch: Throwable -> L11
        this.f401502h = r113.getDimension(5, this.f401502h);     // Catch: Throwable -> L11
        this.f401503i = r113.getColor(0, this.f401503i);     // Catch: Throwable -> L11
        this.f401504j = r113.getColor(4, this.f401504j);     // Catch: Throwable -> L11
        this.f401505k = r113.getColor(11, this.f401505k);     // Catch: Throwable -> L11
        this.f401506l = r113.getDimension(12, this.f401506l);     // Catch: Throwable -> L11
        this.f401507m = r113.getColor(8, this.f401507m);     // Catch: Throwable -> L11
        this.f401508n = r113.getBoolean(10, this.f401508n);     // Catch: Throwable -> L11
        this.f401509o = r113.getBoolean(9, this.f401509o);     // Catch: Throwable -> L11
        r113.recycle();
    L11:
        th = move-exception;
        r113.recycle();
        throw th;
    L14:
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        r100.setStyle(Paint.Style.FILL);
        r101.setStyle(Paint.Style.STROKE);
        r101.setStrokeWidth(this.f401502h);
        r102.setColor(this.f401505k);
        r102.setTextSize(this.f401506l);
        r102.setTextAlign(Paint.Align.CENTER);
        if (Build.VERSION.SDK_INT < 28) goto L17;
        Typeface r115 = Typeface.create(Typeface.DEFAULT, 400, false);
    L18:
        r102.setTypeface(r115);
        r103.setColor(this.f401507m);
        r103.setStyle(Paint.Style.FILL);
        r102.getFontMetrics(r104);
        this.f401516v = -((r104.ascent + r104.descent) / 2.0f);
        return;
    L17:
        r115 = Typeface.create(Typeface.DEFAULT, 0);
        goto L18
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean r100, int r101, Rect r102) {
        super.onFocusChanged(r100, r101, r102);
        if (r100 == true) goto L5;
        this.E = false;
        removeCallbacks(this.F);
        Object r103 = getContext().getSystemService("input_method");
        if ((r103 instanceof InputMethodManager) == false) goto L11;
        InputMethodManager r104 = (InputMethodManager) r103;
    L12:
        if (r104 == null) goto L15;
        r104.hideSoftInputFromWindow(getWindowToken(), 0);
    L15:
        invalidate();
        return;
    L11:
        r104 = null;
        goto L12
    L5:
        if (this.f401509o == false) goto L7;
        d();
    L7:
        c();
        goto L15
    }

    public /* synthetic */ OOtpInputView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = ((r103 - r101) - getPaddingLeft()) - getPaddingRight();
        int r106 = ((r104 - r102) - getPaddingTop()) - getPaddingBottom();
        float r107 = this.f401500f;
        float r108 = this.f401498d;
        int r109 = this.f401495a;
        float r110 = r105;
        if (((r109 * r108) + ((r109 - 1) * r107)) <= r110) goto L8;
        if (r109 <= 1) goto L8;
        r107 = (r110 - (r109 * r108)) / (r109 - 1);
        if (r107 >= 0.0f) goto L8;
        r107 = 0.0f;
    L8:
        this.A = r107;
        this.f401518x = getPaddingLeft() + ((r110 - ((r108 * r109) + (r107 * (r109 - 1)))) / 2.0f);
        float r111 = getPaddingTop();
        float r112 = this.f401499e;
        float r113 = r111 + ((r106 - r112) / 2.0f);
        this.f401519y = r113;
        this.f401520z = r113 + (r112 / 2.0f);
    }
}
