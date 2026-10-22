package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.UploadTypeInf;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import com.larus.utils.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import z19.u;
import z19.v;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 s2\u00020\u0001:\u0002rsB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020<2\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010=\u001a\u00020<2\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020<2\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010?\u001a\u00020<2\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010@\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010A\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020\u001bJ\u000e\u0010D\u001a\u00020<2\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010E\u001a\u00020<2\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010F\u001a\u00020<2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010G\u001a\u00020<2\u0006\u0010 \u001a\u00020\u0007J\u000e\u0010H\u001a\u00020<2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010I\u001a\u00020<2\u0006\u0010&\u001a\u00020\u0007J\u0010\u0010J\u001a\u00020<2\u0006\u0010)\u001a\u00020\u0007H\u0016J\u000e\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020\u0007J\u000e\u0010M\u001a\u00020<2\u0006\u0010L\u001a\u00020\u0007J\u0006\u00108\u001a\u00020<J\u000e\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020\u0007J\b\u0010P\u001a\u00020<H\u0002J(\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0014J\b\u0010V\u001a\u00020<H\u0002J\u0010\u0010W\u001a\u00020<2\u0006\u0010X\u001a\u00020YH\u0014J\u0010\u0010Z\u001a\u00020<2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010[\u001a\u00020<2\u0006\u0010X\u001a\u00020YH\u0002J(\u0010\\\u001a\u00020<2\u0006\u0010]\u001a\u00020/2\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u0007H\u0014J\b\u0010a\u001a\u00020<H\u0014J\b\u0010b\u001a\u00020<H\u0014J\u0010\u0010c\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020\u0007H\u0016J\u0018\u0010e\u001a\u00020<2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u0007H\u0014J\u0018\u0010h\u001a\u00020<2\u0006\u0010X\u001a\u00020Y2\u0006\u0010i\u001a\u00020/H\u0002J\u0010\u0010j\u001a\u00020<2\b\u0010k\u001a\u0004\u0018\u000101J\u0006\u0010l\u001a\u00020<J)\u0010m\u001a\u0002Hn\"\u0004\b\u0000\u0010n*\u0004\u0018\u00010\u001b2\u0006\u0010o\u001a\u0002Hn2\u0006\u0010p\u001a\u0002HnH\u0002¢\u0006\u0002\u0010qR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/larus/common_ui/widget/SeparatedEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderPaint", "Landroid/graphics/Paint;", "blockPaint", "textPaint", "cursorPaint", "borderRectF", "Landroid/graphics/RectF;", "boxRectF", "mWidth", "mHeight", "boxWidth", "boxHeight", "spacing", "corner", "maxLength", "borderWidth", "password", "", "showCursor", "cursorDuration", "cursorWidth", "cursorColor", "type", "separateEqual", "highLightEnable", "highLightStyle", "showKeyboard", "borderColor", "blockColor", "textSize", "", "textColor", "highLightColor", "errorColor", "highLightBefore", "isCursorShowing", RXScreenCaptureService.KEY_CONTENT_TEXT, "", "textChangedListener", "Lcom/larus/common_ui/widget/SeparatedEditText$TextChangedListener;", UploadTypeInf.TIMER, "Ljava/util/Timer;", "timerTask", "Ljava/util/TimerTask;", "isCancel", "forceUseLtr", "showError", "getCurrentText", "", "setSpacing", "", "setCorner", "setMaxLength", "setBorderWidth", "setPassword", "setShowCursor", "setHighLightEnable", "enable", "setCursorDuration", "setCursorWidth", "setCursorColor", "setType", "setBorderColor", "setBlockColor", "setTextColor", "setHighLightColor", "color", "setErrorColor", "setHighlightStyle", "style", "init", "onSizeChanged", "w", "h", "oldw", "oldh", "initBox", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawCursor", "drawRect", "onTextChanged", "text", "start", "lengthBefore", "lengthAfter", "onAttachedToWindow", "onDetachedFromWindow", "onTextContextMenuItem", "id", "onSelectionChanged", "selStart", "selEnd", "drawText", "charSequence", "setTextChangedListener", "listener", "clearText", "matchValue", ExifInterface.GPS_DIRECTION_TRUE, "valueTrue", "valueFalse", "(Ljava/lang/Boolean;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "TextChangedListener", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SeparatedEditText extends AppCompatEditText {
    public static final /* synthetic */ int K = 0;
    public int A;
    public int B;
    public final boolean C;
    public boolean D;
    public CharSequence E;
    public b F;
    public PthreadTimer G;
    public TimerTask H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f328496J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f328497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f328498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f328499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f328500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f328501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f328502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f328503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f328504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f328505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f328506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f328507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f328508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f328509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f328510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f328511o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f328512p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f328513q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f328514r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f328515s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f328516t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f328517u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f328518v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f328519w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f328520x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f328521y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f328522z;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/common_ui/widget/SeparatedEditText$Companion$StyleDef;", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface StyleDef {
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/common_ui/widget/SeparatedEditText$Companion$TypeDef;", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface TypeDef {
        }
    }

    public static final class a implements ActionMode.Callback {
        public a() {
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            Intrinsics.checkNotNullParameter(r100, "actionMode");
            Intrinsics.checkNotNullParameter(r101, "menuItem");
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r100, "actionMode");
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r100) {
            Intrinsics.checkNotNullParameter(r100, "actionMode");
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            Intrinsics.checkNotNullParameter(r100, "actionMode");
            Intrinsics.checkNotNullParameter(r101, TplType.MENU);
            return false;
        }
    }

    public interface b {
        void a(CharSequence r100);

        void b(CharSequence r100);
    }

    public static final class c extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeparatedEditText f328523a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            SeparatedEditText r100 = this.f328523a;     // Catch: Throwable -> L4
            r100.D = !r100.D;     // Catch: Throwable -> L4
            r100.postInvalidate();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(SeparatedEditText r100) {
            this.f328523a = r100;
        }
    }

    static {
    }

    public SeparatedEditText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SeparatedEditText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        return true;
    }

    public final void c() {
        setText("");
    }

    public final void d() {
        int r100 = this.f328509m;
        if (r100 == 6) goto L5;
    L7:
        int r101 = (this.f328503g - (this.f328507k * (r100 - 1))) / r100;
    L8:
        this.f328505i = r101;
        this.f328506j = this.f328504h;
        RectF r102 = this.f328501e;
        Paint r103 = null;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("borderRectF");
        r102 = null;
    L11:
        r102.set(0.0f, 0.0f, this.f328503g, this.f328504h);
        Paint r104 = this.f328499c;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
    L15:
        float r105 = this.f328522z;
        if (r105 != 0.0f) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L21;
        r105 = this.f328505i * 0.4f;
    L21:
        r103.setTextSize(r105);
        return;
    L18:
        r106 = false;
        goto L19
    L14:
        r103 = r104;
        goto L15
    L5:
        if (this.f328517u == true) goto L7;
        int r107 = this.f328503g;
        int r108 = this.f328507k;
        r101 = ((r107 - ((r100 - 1) * r108)) - (r108 * 3)) / r100;
        goto L8
    }

    public final String getCurrentText() {
        return this.E.toString();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.H = new c(this);
        PthreadTimer r100 = new PthreadTimer("SeparatedEditText");
        this.G = r100;
        TimerTask r101 = this.H;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("timerTask");
        r101 = null;
    L5:
        r100.scheduleAtFixedRate(r101, 0, this.f328513q);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.I == true) goto L9;
        PthreadTimer r100 = this.G;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(UploadTypeInf.TIMER);
        r100 = null;
    L7:
        r100.cancel();
        this.I = true;
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = this.E.length();
        int r101 = this.f328509m;
        int r111 = 0;
    L3:
        boolean r102 = true;
        if (r111 >= r101) goto L167;
        if (this.f328509m != 6) goto L16;
        if (r111 < 3) goto L12;
        RectF r103 = this.f328502f;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r103 = null;
    L11:
        int r104 = 5 - r111;
        float r112 = this.f328503g - (this.f328507k * r104);
        float r113 = this.f328505i;
        r103.set(r112 - ((6 - r111) * r113), 0.0f, r112 - (r113 * r104), this.f328506j);
    L20:
        Boolean r105 = Boolean.valueOf(this.C);
        if (r100 < r111) goto L23;
        boolean r106 = true;
    L24:
        Boolean r107 = Boolean.valueOf(r106);
        if (r100 != r111) goto L27;
        boolean r108 = true;
    L28:
        Boolean r109 = Boolean.valueOf(r108);
        Boolean r114 = Boolean.TRUE;
        if (Intrinsics.areEqual(r105, r114) == true) goto L32;
        r107 = r109;
    L32:
        boolean r115 = r107.booleanValue();
        int r116 = this.f328516t;
        if (r116 == 1) goto L144;
        if (r116 == 2) goto L67;
        if (r116 != 3) goto L165;
        RectF r117 = this.f328502f;
        if (r117 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r117 = null;
    L41:
        float r118 = r117.left;
        RectF r119 = this.f328502f;
        if (r119 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r119 = null;
    L44:
        float r120 = r119.bottom;
        RectF r121 = this.f328502f;
        if (r121 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r121 = null;
    L47:
        float r122 = r121.right;
        RectF r123 = this.f328502f;
        if (r123 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r123 = null;
    L50:
        float r124 = r123.bottom;
        Paint r125 = this.f328497a;
        if (r125 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        Paint r126 = null;
    L55:
        if (this.f328518v == true) goto L57;
    L60:
        r102 = false;
    L61:
        Boolean r127 = Boolean.valueOf(r102);
        Integer r128 = Integer.valueOf(this.B);
        Integer r129 = Integer.valueOf(this.f328520x);
        if (Intrinsics.areEqual(r127, r114) == true) goto L65;
        r128 = r129;
    L65:
        r126.setColor(r128.intValue());
        Unit r130 = Unit.INSTANCE;
        r110.drawLine(r118, r120, r122, r124, r126);
        goto L165
    L57:
        if (hasFocus() == false) goto L60;
        if (r115 == false) goto L60;
    L53:
        r126 = r125;
    L165:
        r111 = r111 + 1;
        goto L3
    L67:
        if (this.f328518v == true) goto L69;
    L119:
        RectF r131 = this.f328502f;
        if (r131 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r131 = null;
    L122:
        float r132 = this.f328508l;
        Paint r133 = this.f328498b;
        if (r133 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("blockPaint");
        r133 = null;
    L125:
        r133.setColor(this.f328521y);
        Unit r134 = Unit.INSTANCE;
        r110.drawRoundRect(r131, r132, r132, r133);
        if (this.f328519w != 2) goto L165;
        RectF r135 = this.f328502f;
        if (r135 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r135 = null;
    L130:
        float r136 = r135.left + (this.f328510n / 2);
        RectF r137 = this.f328502f;
        if (r137 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r137 = null;
    L133:
        float r138 = r137.top + (this.f328510n / 2);
        RectF r139 = this.f328502f;
        if (r139 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r139 = null;
    L136:
        float r140 = r139.right - (this.f328510n / 2);
        RectF r141 = this.f328502f;
        if (r141 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r141 = null;
    L139:
        RectF r142 = new RectF(r136, r138, r140, r141.bottom - (this.f328510n / 2));
        float r143 = this.f328508l;
        Paint r144 = this.f328497a;
        if (r144 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        Paint r145 = null;
    L143:
        r145.setColor(this.f328520x);
        r110.drawRoundRect(r142, r143, r143, r145);
        goto L165
    L142:
        r145 = r144;
        goto L143
    L69:
        if (hasFocus() == false) goto L119;
        if (r115 == false) goto L119;
        if (this.f328519w != 1) goto L96;
        RectF r146 = this.f328502f;
        if (r146 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r146 = null;
    L76:
        float r147 = this.f328508l;
        Paint r148 = this.f328498b;
        if (r148 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("blockPaint");
        r148 = null;
    L79:
        r148.setColor(this.f328521y);
        Unit r149 = Unit.INSTANCE;
        r110.drawRoundRect(r146, r147, r147, r148);
        RectF r150 = this.f328502f;
        if (r150 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r150 = null;
    L82:
        float r151 = r150.left + (this.f328510n / 2);
        RectF r152 = this.f328502f;
        if (r152 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r152 = null;
    L85:
        float r153 = r152.top + (this.f328510n / 2);
        RectF r154 = this.f328502f;
        if (r154 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r154 = null;
    L88:
        float r155 = r154.right - (this.f328510n / 2);
        RectF r156 = this.f328502f;
        if (r156 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r156 = null;
    L91:
        RectF r157 = new RectF(r151, r153, r155, r156.bottom - (this.f328510n / 2));
        float r158 = this.f328508l;
        Paint r159 = this.f328497a;
        if (r159 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        Paint r160 = null;
    L95:
        r160.setColor(this.f328520x);
        r110.drawRoundRect(r157, r158, r158, r160);
        goto L165
    L94:
        r160 = r159;
        goto L95
    L96:
        RectF r161 = this.f328502f;
        if (r161 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r161 = null;
    L99:
        float r162 = this.f328508l;
        Paint r163 = this.f328498b;
        if (r163 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("blockPaint");
        r163 = null;
    L102:
        r163.setColor(this.f328521y);
        Unit r164 = Unit.INSTANCE;
        r110.drawRoundRect(r161, r162, r162, r163);
        RectF r165 = this.f328502f;
        if (r165 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r165 = null;
    L105:
        float r166 = r165.left + (this.f328510n / 2);
        RectF r167 = this.f328502f;
        if (r167 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r167 = null;
    L108:
        float r168 = r167.top + (this.f328510n / 2);
        RectF r169 = this.f328502f;
        if (r169 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r169 = null;
    L111:
        float r170 = r169.right - (this.f328510n / 2);
        RectF r171 = this.f328502f;
        if (r171 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r171 = null;
    L114:
        RectF r172 = new RectF(r166, r168, r170, r171.bottom - (this.f328510n / 2));
        float r173 = this.f328508l;
        Paint r174 = this.f328497a;
        if (r174 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        Paint r175 = null;
    L118:
        r175.setColor(this.B);
        r110.drawRoundRect(r172, r173, r173, r175);
        goto L165
    L117:
        r175 = r174;
        goto L118
    L144:
        if (r111 == 0) goto L165;
        if (r111 == this.f328509m) goto L165;
        RectF r176 = this.f328502f;
        if (r176 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r176 = null;
    L151:
        float r177 = r176.left;
        RectF r178 = this.f328502f;
        if (r178 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r178 = null;
    L154:
        float r179 = r178.top;
        RectF r180 = this.f328502f;
        if (r180 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r180 = null;
    L157:
        float r181 = r180.left;
        RectF r182 = this.f328502f;
        if (r182 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r182 = null;
    L160:
        float r183 = r182.bottom;
        Paint r184 = this.f328497a;
        if (r184 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        Paint r185 = null;
    L164:
        r185.setColor(this.f328520x);
        Unit r186 = Unit.INSTANCE;
        r110.drawLine(r177, r179, r181, r183, r185);
        goto L165
    L163:
        r185 = r184;
        goto L164
    L27:
        r108 = false;
        goto L28
    L23:
        r106 = false;
        goto L24
    L12:
        RectF r187 = this.f328502f;
        if (r187 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r187 = null;
    L15:
        int r188 = this.f328507k * r111;
        int r189 = this.f328505i;
        float r190 = r189;
        r187.set(r188 + (r111 * r190), 0.0f, (r188 + (r189 * r111)) + r190, this.f328506j);
        goto L20
    L16:
        RectF r191 = this.f328502f;
        if (r191 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r191 = null;
    L19:
        int r192 = this.f328507k * r111;
        int r193 = this.f328505i;
        float r194 = r193;
        r191.set(r192 + (r111 * r194), 0.0f, (r192 + (r193 * r111)) + r194, this.f328506j);
        goto L20
    L167:
        if (this.f328516t != 1) goto L175;
        RectF r195 = this.f328501e;
        if (r195 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("borderRectF");
        r195 = null;
    L171:
        float r196 = this.f328508l;
        Paint r197 = this.f328497a;
        if (r197 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        r197 = null;
    L174:
        r110.drawRoundRect(r195, r196, r196, r197);
    L175:
        CharSequence r198 = this.E;
        int r199 = r198.length();
        int r200 = 0;
    L176:
        if (r200 >= r199) goto L211;
        if (i.h(getContext()) == false) goto L183;
        if (this.f328496J == true) goto L183;
        int r201 = getWidth();
        int r202 = this.f328507k * r200;
        int r1100 = this.f328505i;
        int r203 = (r201 - (r202 + (r1100 * r200))) - r1100;
    L190:
        float r204 = (this.f328505i / 2) + r203;
        Paint r1101 = this.f328499c;
        if (r1101 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        r1101 = null;
    L193:
        float r1102 = 2;
        int r205 = (int) (r204 - (r1101.measureText(String.valueOf(r198.charAt(r200))) / r1102));
        float r1103 = (this.f328506j / 2) + 0;
        Paint r1104 = this.f328499c;
        if (r1104 != null) goto L196;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        r1104 = null;
    L196:
        float r1105 = r1104.descent();
        Paint r1106 = this.f328499c;
        if (r1106 != null) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        r1106 = null;
    L199:
        int r1107 = (int) (r1103 - ((r1105 + r1106.ascent()) / r1102));
        int r1108 = this.f328505i;
        int r206 = r203 + (r1108 / 2);
        int r1109 = this.f328506j;
        int r1110 = (r1109 / 2) + 0;
        int r1111 = Math.min(r1108, r1109) / 6;
        if (this.f328511o == false) goto L205;
        float r207 = r206;
        float r208 = r1110;
        float r1112 = r1111;
        Paint r1113 = this.f328499c;
        if (r1113 != null) goto L204;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        r1113 = null;
    L204:
        r110.drawCircle(r207, r208, r1112, r1113);
    L209:
        r200 = r200 + 1;
        goto L176
    L205:
        String r209 = String.valueOf(r198.charAt(r200));
        float r210 = r205;
        float r1114 = r1107;
        Paint r1115 = this.f328499c;
        if (r1115 != null) goto L208;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        r1115 = null;
    L208:
        r110.drawText(r209, r210, r1114, r1115);
    L183:
        if (this.f328509m == 6) goto L185;
        int r211 = this.f328507k * r200;
        int r212 = this.f328505i;
    L189:
        r203 = r211 + (r212 * r200);
        goto L190
    L185:
        if (r200 >= 3) goto L187;
        r211 = this.f328507k * r200;
        r212 = this.f328505i;
        goto L189
    L187:
        r203 = (this.f328503g - (this.f328507k * (5 - r200))) - (this.f328505i * (6 - r200));
        goto L190
    L211:
        if (this.D == false) goto L213;
        return;
    L213:
        if (this.f328512p == true) goto L215;
        return;
    L215:
        if (this.E.length() < this.f328509m) goto L217;
        return;
    L217:
        if (hasFocus() == false) goto L253;
        int r213 = this.E.length() + 1;
        if (i.h(getContext()) == false) goto L224;
        if (this.f328496J == true) goto L224;
        int r214 = getWidth();
        int r215 = r213 - 1;
        int r216 = this.f328507k * r215;
        int r217 = this.f328505i;
        int r218 = r214 - ((r216 + (r215 * r217)) + (r217 / 2));
    L231:
        int r219 = this.f328506j;
        int r220 = r219 / 4;
        int r221 = r219 - r220;
        float r222 = r218;
        float r223 = r220;
        float r224 = r221;
        Paint r225 = this.f328500d;
        if (r225 != null) goto L234;
        Intrinsics.throwUninitializedPropertyAccessException("cursorPaint");
        Paint r226 = null;
    L235:
        r110.drawLine(r222, r223, r222, r224, r226);
        return;
    L234:
        r226 = r225;
    L224:
        if (this.f328509m == 6) goto L226;
        int r227 = r213 - 1;
        int r228 = this.f328507k * r227;
        int r229 = this.f328505i;
        int r230 = r228 + (r227 * r229);
        int r231 = r229 / 2;
    L230:
        r218 = r230 + r231;
        goto L231
    L226:
        if (r213 > 3) goto L228;
        int r232 = r213 - 1;
        int r233 = this.f328507k * r232;
        int r234 = this.f328505i;
        r230 = r233 + (r232 * r234);
        r231 = r234 / 2;
        goto L230
    L228:
        int r235 = 6 - r213;
        int r236 = this.f328503g - (this.f328507k * r235);
        int r237 = this.f328505i;
        r218 = (r236 - (r235 * r237)) - (r237 / 2);
        goto L231
    }

    public final void setBlockColor(int r100) {
        this.f328521y = r100;
        postInvalidate();
    }

    public final void setBorderColor(int r100) {
        this.f328520x = r100;
        postInvalidate();
    }

    public final void setBorderWidth(int r100) {
        this.f328510n = r100;
        postInvalidate();
    }

    public final void setCorner(int r100) {
        this.f328508l = r100;
        postInvalidate();
    }

    public final void setCursorColor(int r100) {
        this.f328515s = r100;
        postInvalidate();
    }

    public final void setCursorDuration(int r100) {
        this.f328513q = r100;
        postInvalidate();
    }

    public final void setCursorWidth(int r100) {
        this.f328514r = r100;
        postInvalidate();
    }

    public final void setErrorColor(int r100) {
        postInvalidate();
    }

    public final void setHighLightColor(int r100) {
        this.B = r100;
        postInvalidate();
    }

    public final void setHighLightEnable(boolean r100) {
        this.f328518v = r100;
        postInvalidate();
    }

    public final void setHighlightStyle(int r100) {
        this.f328519w = r100;
        postInvalidate();
    }

    public final void setMaxLength(int r100) {
        this.f328509m = r100;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(r100)});
        d();
        c();
    }

    public final void setPassword(boolean r100) {
        this.f328511o = r100;
        postInvalidate();
    }

    public final void setShowCursor(boolean r100) {
        this.f328512p = r100;
        postInvalidate();
    }

    public final void setSpacing(int r100) {
        this.f328507k = r100;
        postInvalidate();
    }

    public final void setTextChangedListener(b r100) {
        this.F = r100;
    }

    @Override // android.widget.TextView
    public void setTextColor(int r100) {
        this.A = r100;
        postInvalidate();
    }

    public final void setType(int r100) {
        this.f328516t = r100;
        postInvalidate();
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        Editable r102 = getText();
        if (r102 != null) goto L5;
    L10:
        super.onSelectionChanged(r100, r101);
        return;
    L5:
        if (r100 == r102.length()) goto L7;
    L8:
        setSelection(r102.length(), r102.length());
        return;
    L7:
        if (r101 == r102.length()) goto L10;
        goto L8
    }

    public SeparatedEditText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.E = "";
        setLayoutDirection(0);
        setTextIsSelectable(false);
        setCustomSelectionActionModeCallback(new a());
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_blockColor, R.attr.larus_blockSpacing, R.attr.larus_borderColor, R.attr.larus_borderWidth, R.attr.larus_corner, R.attr.larus_cursorColor, R.attr.larus_cursorDuration, R.attr.larus_cursorWidth, R.attr.larus_errorColor, R.attr.larus_forceUseLtr, R.attr.larus_highLightBefore, R.attr.larus_highLightEnable, R.attr.larus_highlightColor, R.attr.larus_highlightStyle, R.attr.larus_maxLength, R.attr.larus_password, R.attr.larus_separateEqual, R.attr.larus_separateType, R.attr.larus_showCursor, R.attr.larus_showKeyboard, R.attr.larus_textColor, R.attr.larus_textSize});
        this.f328511o = r103.getBoolean(15, false);
        this.f328512p = r103.getBoolean(18, true);
        this.f328518v = r103.getBoolean(11, false);
        this.f328520x = r103.getColor(2, ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
        this.f328521y = r103.getColor(0, ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_base_2_overlay, getContext(), R.color.larus_base_2_overlay)));
        this.f328522z = r103.getDimension(21, 0.0f);
        this.A = r103.getColor(20, ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
        this.B = r103.getColor(12, ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
        this.C = r103.getBoolean(10, false);
        this.f328515s = r103.getColor(5, ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)));
        this.f328508l = (int) r103.getDimension(4, 0.0f);
        this.f328507k = (int) r103.getDimension(1, 0.0f);
        this.f328516t = r103.getInt(17, 1);
        this.f328517u = r103.getBoolean(16, true);
        this.f328519w = r103.getInt(13, 1);
        this.f328509m = r103.getInt(14, 6);
        this.f328513q = r103.getInt(6, 500);
        this.f328514r = (int) r103.getDimension(7, 2.0f);
        this.f328510n = (int) r103.getDimension(3, 5.0f);
        boolean r104 = r103.getBoolean(19, true);
        this.f328496J = r103.getBoolean(9, false);
        r103.getColor(8, ContextCompat.getColor(getContext(), R.color.larus_danger_50));
        r103.recycle();
        setFocusableInTouchMode(true);
        setFocusable(true);
        requestFocus();
        setCursorVisible(false);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f328509m)});
        if (r104 == false) goto L5;
        new Handler().postDelayed(new u(this), 500);
    L5:
        Paint r105 = new Paint();
        r105.setAntiAlias(true);
        r105.setColor(this.f328521y);
        r105.setStyle(Paint.Style.FILL);
        r105.setStrokeWidth(1.0f);
        this.f328498b = r105;
        Paint r106 = new Paint();
        r106.setAntiAlias(true);
        r106.setColor(this.A);
        r106.setStyle(Paint.Style.FILL_AND_STROKE);
        r106.setStrokeWidth(1.0f);
        this.f328499c = r106;
        Paint r107 = new Paint();
        r107.setAntiAlias(true);
        r107.setColor(this.f328520x);
        r107.setStyle(Paint.Style.STROKE);
        r107.setStrokeWidth(this.f328510n);
        this.f328497a = r107;
        Paint r108 = new Paint();
        r108.setAntiAlias(true);
        r108.setColor(this.f328515s);
        r108.setStyle(Paint.Style.FILL_AND_STROKE);
        r108.setStrokeWidth(this.f328514r);
        this.f328500d = r108;
        this.f328501e = new RectF();
        this.f328502f = new RectF();
        if (this.f328516t != 1) goto L8;
        this.f328507k = 0;
    L8:
        this.H = new v(this);
        this.G = new PthreadTimer("SeparatedEditText");
    }

    public /* synthetic */ SeparatedEditText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f328503g = r100;
        this.f328504h = r101;
        d();
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "text");
        super.onTextChanged(r100, r101, r102, r103);
        this.E = r100;
        invalidate();
        b r104 = this.F;
        if (r104 != null) goto L5;
        return;
    L5:
        if (r100.length() != this.f328509m) goto L7;
        r104.b(r100);
        return;
    L7:
        r104.a(r100);
    }
}
