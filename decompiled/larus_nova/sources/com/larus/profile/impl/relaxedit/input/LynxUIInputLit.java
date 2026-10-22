package com.larus.profile.impl.relaxedit.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.larus.nova.R;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.utils.ColorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ks9.c;
import ks9.d;
import ks9.e;
import ks9.f;
import ks9.g;
import ks9.h;
import ks9.i;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001RB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0016J\u0012\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0012\u0010)\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0012\u0010*\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010+H\u0007J\u0012\u0010,\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\nH\u0007J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\nH\u0007J\u0010\u0010/\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\nH\u0007J\u0012\u00100\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0012\u00101\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0010\u00102\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020+H\u0007J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020+H\u0007J\u0012\u00104\u001a\u00020\u001d2\b\u00105\u001a\u0004\u0018\u00010(H\u0016J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u000fH\u0007J\u001c\u00108\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\u001c\u0010<\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\u001c\u0010=\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\u001c\u0010>\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\u001c\u0010?\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\b\u0010@\u001a\u00020\u001dH\u0002J\u0012\u0010A\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\u0012\u0010C\u001a\u00020\u001d2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0018\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\u000fH\u0002J\u0010\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020(H\u0002J\u0012\u0010K\u001a\u00020\u001d2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010L\u001a\u00020\u001d2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0017\u0010M\u001a\u0004\u0018\u00010\u000f2\u0006\u0010'\u001a\u00020+H\u0002¢\u0006\u0002\u0010NJ\u0012\u0010O\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0010\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\u000fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larus/profile/impl/relaxedit/input/LynxUIInputLit;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larus/profile/impl/relaxedit/input/LynxLitEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "params", "", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "suppressInputEvent", "", "defaultValueConsumed", "readOnly", "disabled", "maxLength", "", "maxLengthFilter", "Landroid/text/InputFilter$LengthFilter;", "inputRegexFilter", "Landroid/text/InputFilter;", "readOnlyFilter", "showSoftInputOnFocus", "lastPaddingLeft", "lastPaddingTop", "lastPaddingRight", "lastPaddingBottom", "createView", "Landroid/content/Context;", "afterPropsUpdated", "", SlcElement.KEY_PROPS, "Lcom/lynx/tasm/behavior/StylesDiffMap;", "onNodeReady", "onLayoutUpdated", "isFocusable", "onFocusChanged", "hasFocus", "isFocusTransition", "setDefaultValue", "value", "", "setPlaceholder", "setMaxLength", "Lcom/lynx/react/bridge/Dynamic;", "setInputFilter", "setReadOnly", "setDisabled", "setShowSoftInputOnFocus", "setConfirmType", "setInputType", "setTextColor", "setPlaceholderColor", "setCaretColor", "caretColor", "setTextAlign", "align", "setValue", "Lcom/lynx/react/bridge/ReadableMap;", "callback", "Lcom/lynx/react/bridge/Callback;", "getValue", "setSelectionRange", ButtonColorBean.StateFocus, "blur", "applyInteractionState", "replaceText", "applyTextFilters", "emitInputEvent", "text", "Landroid/text/Editable;", "emitSelectionEvent", "selectionStart", "selectionEnd", "emitValueEvent", "name", "doFocus", "doBlur", "parseColor", "(Lcom/lynx/react/bridge/Dynamic;)Ljava/lang/Integer;", "hasComposingText", "isConfirmAction", "actionId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxUIInputLit extends LynxUI<ks9.a> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f366838n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f366839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f366840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f366841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f366842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f366843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InputFilter.LengthFilter f366844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f366845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f366846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f366847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f366848j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f366849k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f366850l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f366851m;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f366852a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            r100[ReadableType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ReadableType.Long.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f366852a = r100;
        }
    }

    static {
    }

    public final void N() {
        ks9.a r100 = (ks9.a) this.mView;
        h r101 = this.f366845g;
        if (r101 == null) goto L5;
        InputFilter[] r102 = {this.f366846h, r101, this.f366844f};
    L6:
        r100.setFilters(r102);
        return;
    L5:
        r102 = new InputFilter[]{this.f366846h, this.f366844f};
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean isFocusable() {
        return ((ks9.a) this.mView).isFocusable();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r100 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r101 = this.mPaddingTop + this.mBorderTopWidth;
        int r102 = this.mPaddingRight + this.mBorderRightWidth;
        int r103 = this.mPaddingBottom + this.mBorderBottomWidth;
        if (r100 == this.f366848j) goto L5;
    L10:
        this.f366848j = r100;
        this.f366849k = r101;
        this.f366850l = r102;
        this.f366851m = r103;
        ((ks9.a) this.mView).setPadding(r100, r101, r102, r103);
        return;
    L5:
        if (r101 != this.f366849k) goto L10;
        if (r102 != this.f366850l) goto L10;
        if (r103 != this.f366851m) goto L10;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        super.onNodeReady();
        this.f366840b = true;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [ks9.c] */
    public LynxUIInputLit(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
        this.f366843e = Integer.MAX_VALUE;
        this.f366844f = new InputFilter.LengthFilter(Integer.MAX_VALUE);
        this.f366846h = new c(this);
        this.f366847i = true;
        this.f366848j = Integer.MIN_VALUE;
        this.f366849k = Integer.MIN_VALUE;
        this.f366850l = Integer.MIN_VALUE;
        this.f366851m = Integer.MIN_VALUE;
    }

    public static Integer R(f6a.a r100) {
        ReadableType r101 = r100.getType();
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 == 1) goto L17;
        if (r102 == 2) goto L19;
        if (r102 == 3) goto L19;
        if (r102 == 4) goto L19;
        return null;
    L19:
        return Integer.valueOf(r100.asInt());
    L17:
        return Integer.valueOf(ColorUtils.b(r100.asString()));
    L5:
        r102 = b.f366852a[r101.ordinal()];
        goto L7
    }

    public final void O(Callback r100) {
        if (((ks9.a) this.mView).isFocused() == true) goto L7;
        if (r100 == null) goto L11;
        r100.invoke(new Object[]{0});
        return;
    L11:
        return;
    L7:
        ((ks9.a) this.mView).clearFocus();
        Object r101 = getLynxContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r101).hideSoftInputFromWindow(((ks9.a) this.mView).getWindowToken(), 0);
        if (r100 == null) goto L12;
        r100.invoke(new Object[]{0});
        return;
    }

    public final void P(Callback r100) {
        if (((ks9.a) this.mView).requestFocus() == true) goto L7;
        if (r100 == null) goto L20;
        r100.invoke(new Object[]{1, "fail to focus"});
        return;
    L20:
        return;
    L7:
        Object r101 = getLynxContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r102 = (InputMethodManager) r101;
        if (this.f366847i == true) goto L14;
        r102.hideSoftInputFromWindow(((ks9.a) this.mView).getWindowToken(), 0);
        if (r100 == null) goto L21;
        r100.invoke(new Object[]{0});
        return;
    L21:
        return;
    L14:
        if (r102.showSoftInput(this.mView, 1) == false) goto L17;
        if (r100 == null) goto L22;
        r100.invoke(new Object[]{0});
        return;
    L22:
        return;
    L17:
        if (r100 == null) goto L24;
        r100.invoke(new Object[]{1, "fail to show keyboard"});
        return;
    }

    public final void Q(String r100) {
        EventEmitter r101 = getLynxContext().getEventEmitter();
        m7a.a r102 = new m7a.a(getSign(), r100);
        Editable r103 = ((ks9.a) this.mView).getText();
        if (r103 == null) goto L5;
        String r104 = r103.toString();
    L6:
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r102.a("value", r104);
        r101.sendCustomEvent(r102);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void S(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        Editable r101 = ((ks9.a) this.mView).getText();
        if (r101 != null) goto L7;
        ((ks9.a) this.mView).setText(r100);
        return;
    L7:
        r101.replace(0, r101.length(), r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(x0 r100) {
        super.afterPropsUpdated(r100);
        float r101 = ((ks9.a) this.mView).getTextSize();
        float r102 = this.mFontSize;
        if (r101 != r102) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        ((ks9.a) this.mView).setTextSize(0, r102);
        return;
    L9:
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        if (r100 == null) goto L7;
        ks9.a r101 = new ks9.a(new ContextThemeWrapper(r100, R.style.LynxSingleLineInputEditTextTheme));
        r101.setLines(1);
        r101.setSingleLine(true);
        r101.setHorizontallyScrolling(true);
        r101.setEllipsize(TextUtils.TruncateAt.END);
        r101.setGravity(16);
        r101.setPadding(0, 0, 0, 0);
        r101.setImeOptions(1);
        r101.setFocusableInTouchMode(true);
        r101.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        r101.addTextChangedListener(new i(this));
        r101.setOnFocusChangeListener(new d(this));
        r101.setOnSelectionChangedListener(new e(this));
        r101.setOnEditorActionListener(new f(this));
        return r101;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setCaretColor(String r100) {
        if (Build.VERSION.SDK_INT < 29) goto L10;
        if (r100 == null) goto L12;
        Drawable r101 = ((ks9.a) this.mView).getTextCursorDrawable();
        if (r101 == null) goto L11;
        r101.setTint(ColorUtils.b(r100));
        ((ks9.a) this.mView).setTextCursorDrawable(r101);
        return;
    L11:
        return;
    L12:
        return;
    }

    @LynxProp(name = "confirm-type")
    public final void setConfirmType(String r100) {
        ks9.a r101 = (ks9.a) this.mView;
        if (r100 != null) goto L5;
        r100 = "done";
    L5:
        int r102 = r100.hashCode();
        if (r102 == (-906336856)) goto L27;
        if (r102 == 3304) goto L23;
        if (r102 == 3377907) goto L19;
        if (r102 == 3526536) goto L15;
    L28:
        int r103 = 6;
    L30:
        r101.setImeOptions(r103);
        return;
    L15:
        if (r100.equals("send") == false) goto L28;
        r103 = 4;
        goto L30
    L19:
        if (r100.equals(TeaEventTrack.ACTION_DRAMA_NEXT) == false) goto L28;
        r103 = 5;
        goto L30
    L23:
        if (r100.equals("go") == false) goto L28;
        r103 = 2;
        goto L30
    L27:
        if (r100.equals("search") == false) goto L28;
        r103 = 3;
        goto L30
    }

    @LynxProp(name = "default-value")
    public final void setDefaultValue(String r100) {
        if (this.f366840b == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        Editable r101 = ((ks9.a) this.mView).getText();
        if (r101 == null) goto L10;
        String r102 = r101.toString();
    L12:
        if (Intrinsics.areEqual(r102, r100) == false) goto L14;
        return;
    L14:
        this.f366839a = true;
        S(r100);     // Catch: Throwable -> L18
        this.f366839a = false;
        return;
    L18:
        th = move-exception;
        this.f366839a = false;
        throw th;
    L10:
        r102 = null;
        goto L12
    }

    @LynxProp(defaultBoolean = false, name = "disabled")
    public final void setDisabled(boolean r100) {
        this.f366842d = r100;
        ((ks9.a) this.mView).setEnabled(!r100);
        ((ks9.a) this.mView).setFocusable(!this.f366842d);
        ((ks9.a) this.mView).setFocusableInTouchMode(!this.f366842d);
        this.userInteractionEnabled = !this.f366842d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [ks9.h] */
    @LynxProp(name = "input-filter")
    public final void setInputFilter(String r100) {
        h r101 = 0;
        if (r100 != null) goto L5;
    L20:
        final Regex r102 = null;
    L21:
        if (r102 == null) goto L23;
        r101 = new h(r102);
    L23:
        this.f366845g = r101;
        N();
        return;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L20;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L14
        Object r105 = Result.m9449constructorimpl(new Regex(r100));     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r105) == false) goto L19;
        r105 = null;
    L19:
        r102 = (Regex) r105;
    L14:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L7:
        r103 = false;
        goto L8
    }

    @LynxProp(name = "type")
    public final void setInputType(String r100) {
        int r101 = RangesKt.coerceAtLeast(((ks9.a) this.mView).getSelectionStart(), 0);
        this.f366839a = true;
        if (r100 != null) goto L39;
        r100 = "text";
    L39:
    L36:
        th = move-exception;
        this.f366839a = false;
        throw th;
    L6:
        switch(r100.hashCode()) {
            case -1034364087: goto L25;
            case 114715: goto L21;
            case 95582509: goto L17;
            case 96619420: goto L13;
            case 1216985755: goto L9;
            default: goto L28;
        };     // Catch: Throwable -> L36
    L28:
        ((ks9.a) this.mView).setInputType(524289);     // Catch: Throwable -> L36
        ((ks9.a) this.mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());     // Catch: Throwable -> L36
    L29:
        T r102 = this.mView;     // Catch: Throwable -> L36
        ks9.a r103 = (ks9.a) r102;     // Catch: Throwable -> L36
        Editable r104 = ((ks9.a) r102).getText();     // Catch: Throwable -> L36
        if (r104 == null) goto L32;
        int r105 = r104.length();     // Catch: Throwable -> L36
    L33:
        r103.setSelection(RangesKt.coerceAtMost(r101, r105));     // Catch: Throwable -> L36
        this.f366839a = false;
        return;
    L32:
        r105 = 0;
        goto L33
    L9:
        if (r100.equals("password") == false) goto L28;
        ((ks9.a) this.mView).setInputType(129);     // Catch: Throwable -> L36
        ((ks9.a) this.mView).setTransformationMethod(PasswordTransformationMethod.getInstance());     // Catch: Throwable -> L36
        goto L29
    L13:
        if (r100.equals("email") == false) goto L28;
        ((ks9.a) this.mView).setInputType(33);     // Catch: Throwable -> L36
        ((ks9.a) this.mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());     // Catch: Throwable -> L36
        goto L29
    L17:
        if (r100.equals("digit") == false) goto L28;
        ((ks9.a) this.mView).setInputType(8194);     // Catch: Throwable -> L36
        ((ks9.a) this.mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());     // Catch: Throwable -> L36
        goto L29
    L21:
        if (r100.equals("tel") == false) goto L28;
        ((ks9.a) this.mView).setInputType(3);     // Catch: Throwable -> L36
        ((ks9.a) this.mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());     // Catch: Throwable -> L36
        goto L29
    L25:
        if (r100.equals("number") == false) goto L28;
        ((ks9.a) this.mView).setInputType(2);     // Catch: Throwable -> L36
        ((ks9.a) this.mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());     // Catch: Throwable -> L36
        goto L29
    }

    @LynxProp(name = "maxlength")
    public final void setMaxLength(f6a.a r100) {
        int r101 = Integer.MAX_VALUE;
        if (r100 != null) goto L5;
        int r102 = Integer.MAX_VALUE;
    L22:
        if (r102 < 0) goto L26;
        r101 = r102;
    L26:
        if (r101 != this.f366843e) goto L28;
        return;
    L28:
        this.f366843e = r101;
        this.f366844f = new InputFilter.LengthFilter(r101);
        N();
        return;
    L5:
        ReadableType r103 = r100.getType();
        if (r103 != null) goto L8;
        int r104 = -1;
    L10:
        if (r104 != 1) goto L12;
        Integer r105 = StringsKt.toIntOrNull(r100.asString());
    L20:
        if (r105 == null) goto L30;
        r102 = r105.intValue();
        goto L22
    L30:
        return;
    L12:
        if (r104 != 2) goto L14;
    L18:
        r105 = Integer.valueOf(r100.asInt());
        goto L20
    L14:
        if (r104 == 3) goto L18;
        if (r104 == 4) goto L18;
        r105 = null;
        goto L20
    L8:
        r104 = b.f366852a[r103.ordinal()];
        goto L10
    }

    @LynxProp(name = GXTemplateKey.GAIAX_PLACEHOLDER)
    public final void setPlaceholder(String r100) {
        ks9.a r101 = (ks9.a) this.mView;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.setHint(r100);
    }

    @LynxProp(name = "placeholder-color")
    public final void setPlaceholderColor(f6a.a r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Integer r101 = R(r100);
        if (r101 == null) goto L6;
        ((ks9.a) this.mView).setHintTextColor(r101.intValue());
        return;
    }

    @LynxProp(defaultBoolean = false, name = "readonly")
    public final void setReadOnly(boolean r100) {
        this.f366841c = r100;
        N();
    }

    @LynxProp(defaultBoolean = true, name = "show-soft-input-on-focus")
    public final void setShowSoftInputOnFocus(boolean r100) {
        this.f366847i = r100;
        ((ks9.a) this.mView).setShowSoftInputOnFocus(r100);
    }

    @LynxProp(defaultInt = 0, name = GXTemplateKey.STYLE_FONT_TEXT_ALIGN)
    public final void setTextAlign(int r100) {
        ks9.a r101 = (ks9.a) this.mView;
        if (r100 != 1) goto L5;
        int r102 = 17;
    L9:
        r101.setGravity(r102);
        return;
    L5:
        if (r100 == 2) goto L7;
        r102 = 8388627;
        goto L9
    L7:
        r102 = 8388629;
        goto L9
    }

    @LynxProp(defaultInt = -16777216, name = "color")
    public final void setTextColor(f6a.a r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Integer r101 = R(r100);
        if (r101 == null) goto L6;
        ((ks9.a) this.mView).setTextColor(r101.intValue());
        return;
    }

    public static final void M(LynxUIInputLit r100, Editable r101) {
        r100.getClass();
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        boolean r103 = ((ks9.a) r100.mView).isFocused();
        EventEmitter r104 = r100.getLynxContext().getEventEmitter();
        m7a.a r105 = new m7a.a(r100.getSign(), "input");
        r105.a("value", r102);
        int r106 = -1;
        if (r103 == false) goto L11;
        int r107 = ((ks9.a) r100.mView).getSelectionStart();
    L12:
        r105.a("selectionStart", Integer.valueOf(r107));
        if (r103 == false) goto L15;
        r106 = ((ks9.a) r100.mView).getSelectionEnd();
    L15:
        r105.a("selectionEnd", Integer.valueOf(r106));
        if (r101 != null) goto L18;
    L22:
        boolean r108 = false;
    L23:
        r105.a("isComposing", Boolean.valueOf(r108));
        r104.sendCustomEvent(r105);
        return;
    L18:
        if (BaseInputConnection.getComposingSpanStart(r101) < 0) goto L22;
        if (BaseInputConnection.getComposingSpanEnd(r101) < 0) goto L22;
        r108 = true;
        goto L23
    L11:
        r107 = -1;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @LynxUIMethod
    public final void blur(ReadableMap r100, final Callback r101) {
        if (((ks9.a) this.mView).getHasDrawn() == false) goto L5;
        O(r101);
        return;
    L5:
        ((ks9.a) this.mView).post(new ks9.b(this, r101));
    }

    @LynxUIMethod
    public final void focus(ReadableMap r100, final Callback r101) {
        if (((ks9.a) this.mView).getHasDrawn() == false) goto L5;
        P(r101);
        return;
    L5:
        ((ks9.a) this.mView).post(new g(this, r101));
    }

    @LynxUIMethod
    public final void getValue(ReadableMap r100, Callback r101) {
        Editable r102 = ((ks9.a) this.mView).getText();
        boolean r103 = ((ks9.a) this.mView).isFocused();
        if (r101 == null) goto L26;
        Object[] r104 = new Object[2];
        boolean r105 = false;
        r104[0] = 0;
        JavaOnlyMap r106 = new JavaOnlyMap();
        if (r102 == null) goto L7;
        String r107 = r102.toString();
    L8:
        if (r107 != null) goto L10;
        r107 = "";
    L10:
        r106.putString("value", r107);
        int r108 = -1;
        if (r103 == false) goto L13;
        int r109 = ((ks9.a) this.mView).getSelectionStart();
    L14:
        r106.putInt("selectionStart", r109);
        if (r103 == false) goto L17;
        r108 = ((ks9.a) this.mView).getSelectionEnd();
    L17:
        r106.putInt("selectionEnd", r108);
        if (r102 != null) goto L20;
    L24:
        r106.putBoolean("isComposing", r105);
        Unit r110 = Unit.INSTANCE;
        r104[1] = r106;
        r101.invoke(r104);
        return;
    L20:
        if (BaseInputConnection.getComposingSpanStart(r102) < 0) goto L24;
        if (BaseInputConnection.getComposingSpanEnd(r102) < 0) goto L24;
        r105 = true;
        goto L24
    L13:
        r109 = -1;
        goto L14
    L7:
        r107 = null;
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void onFocusChanged(boolean r100, boolean r101) {
        if (r101 == false) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        P(null);
        return;
    L7:
        O(null);
    }

    @LynxUIMethod
    public final void setSelectionRange(ReadableMap r100, Callback r101) {
        if (r100 != null) goto L5;
    L31:
        if (r101 == null) goto L36;
        r101.invoke(new Object[]{4, "Range is missing."});
        return;
    L36:
        return;
    L5:
        if (r100.hasKey("selectionStart") == false) goto L31;
        if (r100.hasKey("selectionEnd") == false) goto L31;
        int r102 = r100.getInt("selectionStart");
        int r103 = r100.getInt("selectionEnd");
        Editable r104 = ((ks9.a) this.mView).getText();
        if (r104 == null) goto L12;
        int r105 = r104.length();
    L13:
        if (r102 < 0) goto L16;
        if (r102 > r105) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L28;
        if (r103 < 0) goto L21;
        if (r103 > r105) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L28;
        ((ks9.a) this.mView).setSelection(r102, r103);
        if (r101 == null) goto L34;
        r101.invoke(new Object[]{0});
        return;
    L34:
        return;
    L21:
        r107 = false;
    L28:
        if (r101 == null) goto L35;
        r101.invoke(new Object[]{4, "Range does not meet expectations."});
        return;
    L35:
        return;
    L16:
        r106 = false;
        goto L17
    L12:
        r105 = 0;
        goto L13
    }

    @LynxUIMethod
    public final void setValue(ReadableMap r100, Callback r101) {
        if (r100 != null) goto L7;
        if (r101 == null) goto L40;
        r101.invoke(new Object[]{4, "Param is not a map."});
        return;
    L40:
        return;
    L7:
        this.f366839a = true;
    L35:
        th = move-exception;
        this.f366839a = false;
        throw th;
    L9:
        if (r100.hasKey("value") == false) goto L11;
        String r102 = r100.getString("value");     // Catch: Throwable -> L35
    L12:
        S(r102);     // Catch: Throwable -> L35
        this.f366839a = false;
        String r103 = EffectConfiguration.KEY_CURSOR;
        if (r100.hasKey(EffectConfiguration.KEY_CURSOR) == true) goto L20;
        r103 = "index";
        if (r100.hasKey("index") == true) goto L20;
        r103 = null;
    L20:
        if (r103 == null) goto L32;
        int r104 = r100.getInt(r103);
        if (r104 < 0) goto L29;
        Editable r105 = ((ks9.a) this.mView).getText();
        if (r105 == null) goto L26;
        int r106 = r105.length();
    L27:
        if (r104 > r106) goto L29;
        boolean r107 = true;
    L30:
        if (r107 == false) goto L32;
        ((ks9.a) this.mView).setSelection(r104);
        goto L32
    L26:
        r106 = 0;
    L29:
        r107 = false;
    L32:
        if (r101 == null) goto L41;
        r101.invoke(new Object[]{0});
        return;
    L41:
        return;
    L11:
        r102 = "";
        goto L12
    }
}
