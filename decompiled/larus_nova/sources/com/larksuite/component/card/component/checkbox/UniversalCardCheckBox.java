package com.larksuite.component.card.component.checkbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0005NOPQRB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\"\u0010%\u001a\u00020&2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0014J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020&H\u0014J\b\u0010.\u001a\u00020\u0016H\u0016J\b\u0010/\u001a\u00020&H\u0016J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u0016H\u0016J\u0006\u00102\u001a\u00020\u0010J\u000e\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u0010J\u000e\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u0012J\u0006\u00107\u001a\u00020\u0012J\u0010\u00108\u001a\u00020&2\b\b\u0001\u00109\u001a\u00020\u000bJ\b\u0010:\u001a\u00020\u000bH\u0007J\u0010\u0010;\u001a\u00020&2\b\b\u0001\u00109\u001a\u00020\u000bJ\u0010\u0010<\u001a\u00020&2\b\b\u0001\u00109\u001a\u00020\u000bJ\u000e\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020\u0016J\u0006\u0010?\u001a\u00020\u0016J\u0010\u0010@\u001a\u00020&2\b\u0010A\u001a\u0004\u0018\u00010#J\b\u0010B\u001a\u00020&H\u0002J\b\u0010C\u001a\u00020&H\u0002J\u0010\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020EH\u0002J\f\u0010F\u001a\u00020E*\u00020\u0010H\u0002J\u0012\u0010:\u001a\u00020\u000b2\b\b\u0001\u0010G\u001a\u00020\u000bH\u0003J\b\u0010H\u001a\u00020\u0016H\u0002J(\u0010I\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010J\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000bH\u0002J\u001e\u0010L\u001a\u0004\u0018\u00010\u001f2\b\b\u0001\u0010M\u001a\u00020\u000b2\b\b\u0001\u00109\u001a\u00020\u000bH\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox;", "Landroid/view/View;", "Landroid/widget/Checkable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mType", "Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$CheckBoxType;", "mSize", "Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$CheckBoxSize;", "mColor", "uncheckedBackgroundColor", "hasUncheckedBackgroundColorSet", "", "uncheckedBorderColor", "hasUncheckedBorderColorSet", "mIndetermined", "mIsChecked", "mDrawableSize", "mMarkSize", "mMarkOffset", "mMarkDrawable", "Landroid/graphics/drawable/Drawable;", "mBorderDrawable", "mBackgroundDrawable", "mOnCheckedChangeListener", "Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$OnCheckedChangeListener;", "mNeedSetupDrawable", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawableStateChanged", "isChecked", "toggle", "setChecked", "checked", "getType", "setType", "value", "setSize", "size", "getSize", "setColor", "color", "getColor", "setUncheckedBackgroundColor", "setUncheckedBorderColor", "setIndetermined", "indetermined", "isIndetermined", "setOnCheckedChangeListener", "listener", "setupSize", "setupCurrDrawable", "res", "Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$ICheckBoxRes;", "getCheckBoxRes", "colorRes", "useCustomColor", "doDrawDrawable", "drawable", "offset", "getDrawable", "resId", "OnCheckedChangeListener", "CheckBoxType", "CheckBoxSize", "ICheckBoxRes", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalCardCheckBox extends View implements Checkable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final com.larksuite.component.card.component.checkbox.a f283334q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy<UniversalCardCheckBox$Companion$checkboxRes$2.a> f283335r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy<UniversalCardCheckBox$Companion$indeterminedCheckBoxRes$2.a> f283336s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Lazy<UniversalCardCheckBox$Companion$checkboxSquareRes$2.a> f283337t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy<UniversalCardCheckBox$Companion$radioRes$2.a> f283338u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Lazy<UniversalCardCheckBox$Companion$checkMarkRes$2.a> f283339v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CheckBoxType f283340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CheckBoxSize f283341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f283342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f283343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f283344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f283345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f283346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f283347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f283348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f283349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f283350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f283351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f283352m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f283353n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f283354o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f283355p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$CheckBoxSize;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL_SIZE", "SMALL_SIZE", "SQUARE_SIZE", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CheckBoxSize extends Enum<CheckBoxSize> {
        public static final CheckBoxSize NORMAL_SIZE = null;
        public static final CheckBoxSize SMALL_SIZE = null;
        public static final CheckBoxSize SQUARE_SIZE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CheckBoxSize[] f283356a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283357b = null;

        public static EnumEntries<CheckBoxSize> getEntries() {
            return f283357b;
        }

        static {
            CheckBoxSize r100 = new CheckBoxSize("NORMAL_SIZE", 0);
            NORMAL_SIZE = r100;
            CheckBoxSize r101 = new CheckBoxSize("SMALL_SIZE", 1);
            SMALL_SIZE = r101;
            CheckBoxSize r102 = new CheckBoxSize("SQUARE_SIZE", 2);
            SQUARE_SIZE = r102;
            CheckBoxSize[] r103 = {r100, r101, r102};
            f283356a = r103;
            f283357b = EnumEntriesKt.enumEntries(r103);
        }

        public static CheckBoxSize[] values() {
            return (CheckBoxSize[]) f283356a.clone();
        }

        public static CheckBoxSize valueOf(String r100) {
            return (CheckBoxSize) r27.a.a(CheckBoxSize.class, r100);
        }

        public CheckBoxSize(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$CheckBoxType;", "", "<init>", "(Ljava/lang/String;I)V", "CHECK_BOX", "RADIO", "CHECK_BOX_SQUARE", "CHECK_MARK", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CheckBoxType extends Enum<CheckBoxType> {
        public static final CheckBoxType CHECK_BOX = null;
        public static final CheckBoxType CHECK_BOX_SQUARE = null;
        public static final CheckBoxType CHECK_MARK = null;
        public static final CheckBoxType RADIO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CheckBoxType[] f283358a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283359b = null;

        public static EnumEntries<CheckBoxType> getEntries() {
            return f283359b;
        }

        static {
            CheckBoxType r100 = new CheckBoxType("CHECK_BOX", 0);
            CHECK_BOX = r100;
            CheckBoxType r101 = new CheckBoxType("RADIO", 1);
            RADIO = r101;
            CheckBoxType r102 = new CheckBoxType("CHECK_BOX_SQUARE", 2);
            CHECK_BOX_SQUARE = r102;
            CheckBoxType r103 = new CheckBoxType("CHECK_MARK", 3);
            CHECK_MARK = r103;
            CheckBoxType[] r104 = {r100, r101, r102, r103};
            f283358a = r104;
            f283359b = EnumEntriesKt.enumEntries(r104);
        }

        public static CheckBoxType[] values() {
            return (CheckBoxType[]) f283358a.clone();
        }

        public static CheckBoxType valueOf(String r100) {
            return (CheckBoxType) r27.a.a(CheckBoxType.class, r100);
        }

        public CheckBoxType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static final b a() {
            com.larksuite.component.card.component.checkbox.a r100 = UniversalCardCheckBox.f283334q;
            return UniversalCardCheckBox.f283335r.getValue();
        }

        public a() {
        }
    }

    public interface b {
        int a(boolean r100);

        int b(boolean r100, boolean r101);

        int c(boolean r100, boolean r101);

        int d(boolean r100, boolean r101);

        int e(boolean r100, boolean r101);

        float f();

        int g(boolean r100, boolean r101);
    }

    public interface c {
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f283360a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f283361b = null;

        static {
            int[] r100 = new int[CheckBoxSize.values().length];
            r100[CheckBoxSize.SMALL_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r100[CheckBoxSize.NORMAL_SIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r100[CheckBoxSize.SQUARE_SIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            f283360a = r100;
            int[] r101 = new int[CheckBoxType.values().length];
            r101[CheckBoxType.CHECK_BOX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r101[CheckBoxType.RADIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r101[CheckBoxType.CHECK_BOX_SQUARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[CheckBoxType.CHECK_MARK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            f283361b = r101;
        }
    }

    public final void setOnCheckedChangeListener(c r100) {
    }

    static {
        new a();
        f283334q = new com.larksuite.component.card.component.checkbox.a();
        f283335r = LazyKt.lazy(UniversalCardCheckBox$Companion$checkboxRes$2.INSTANCE);
        f283336s = LazyKt.lazy(UniversalCardCheckBox$Companion$indeterminedCheckBoxRes$2.INSTANCE);
        f283337t = LazyKt.lazy(UniversalCardCheckBox$Companion$checkboxSquareRes$2.INSTANCE);
        f283338u = LazyKt.lazy(UniversalCardCheckBox$Companion$radioRes$2.INSTANCE);
        f283339v = LazyKt.lazy(UniversalCardCheckBox$Companion$checkMarkRes$2.INSTANCE);
    }

    public final void d() {
        int r100 = d.f283360a[this.f283341b.ordinal()];
        if (r100 == 1) goto L11;
        if (r100 != 2) goto L6;
        int r101 = h18.d.d(getContext(), R.dimen.ud_checkbox_size_normal);
    L12:
        this.f283349j = r101;
        int r102 = (int) (r101 * b(this.f283340a).f());
        this.f283350k = r102;
        this.f283351l = (this.f283349j - r102) / 2;
        invalidate();
        return;
    L6:
        if (r100 != 3) goto L9;
        r101 = h18.d.d(getContext(), R.dimen.dp_16);
        goto L12
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        r101 = h18.d.d(getContext(), R.dimen.ud_checkbox_size_small);
        goto L12
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f283348i);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.f283355p = true;
        invalidate();
    }

    public final int getColor() {
        return this.f283342c;
    }

    public final CheckBoxSize getSize() {
        return this.f283341b;
    }

    public final CheckBoxType getType() {
        return this.f283340a;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f283348i;
    }

    public UniversalCardCheckBox(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setupCurrDrawable(b r100) {
        int r101 = r100.d(this.f283348i, isEnabled());
        int r102 = 0;
        if (r101 != 0) goto L5;
        int r103 = 0;
    L6:
        boolean r104 = true;
        if (this.f283342c != 0) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L17;
        if (isEnabled() == false) goto L17;
        int r106 = this.f283342c;
    L28:
        if (this.f283342c != 0) goto L30;
    L32:
        r104 = false;
    L33:
        if (r104 == false) goto L40;
        if (this.f283348i == false) goto L40;
        if (isEnabled() == false) goto L40;
        r102 = this.f283342c;
    L50:
        boolean r107 = this.f283348i;
        isEnabled();
        this.f283352m = c(r100.a(r107), r103);
        this.f283353n = c(r100.e(this.f283348i, isEnabled()), r106);
        this.f283354o = c(r100.g(this.f283348i, isEnabled()), r102);
        return;
    L40:
        if (this.f283344e == true) goto L42;
    L46:
        int r108 = r100.b(this.f283348i, isEnabled());
        if (r108 == 0) goto L50;
        r102 = UDColorUtils.getColor(getContext(), r108);
        goto L50
    L42:
        if (this.f283340a == CheckBoxType.CHECK_MARK) goto L46;
        if (this.f283348i == true) goto L46;
        r102 = this.f283343d;
        goto L50
    L30:
        if (this.f283340a == CheckBoxType.CHECK_MARK) goto L32;
    L17:
        if (this.f283346g == true) goto L19;
    L23:
        int r109 = r100.c(this.f283348i, isEnabled());
        if (r109 != 0) goto L26;
        r106 = 0;
        goto L28
    L26:
        r106 = UDColorUtils.getColor(getContext(), r109);
        goto L28
    L19:
        if (this.f283340a == CheckBoxType.CHECK_MARK) goto L23;
        if (this.f283348i == true) goto L23;
        r106 = this.f283345f;
        goto L28
    L9:
        if (this.f283340a == CheckBoxType.CHECK_MARK) goto L11;
        r105 = true;
        goto L12
    L5:
        r103 = UDColorUtils.getColor(getContext(), r101);
        goto L6
    }

    public final b b(CheckBoxType r100) {
        int r101 = d.f283361b[r100.ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L22;
        if (r101 == 3) goto L21;
        if (r101 != 4) goto L12;
        return f283339v.getValue();
    L12:
        throw new NoWhenBranchMatchedException();
    L21:
        return f283337t.getValue();
    L22:
        return f283338u.getValue();
    L16:
        if (this.f283347h == false) goto L19;
        return f283336s.getValue();
    L19:
        return a.a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        TraceEvent.beginSection("UniversalCardCheckBox.onDraw");
        if (this.f283355p == false) goto L5;
        setupCurrDrawable(b(this.f283340a));
        invalidate();
        this.f283355p = false;
    L5:
        Drawable r101 = this.f283354o;
        if (r101 == null) goto L8;
        a(r100, r101, this.f283349j - 4, 2);
    L8:
        Drawable r102 = this.f283353n;
        if (r102 == null) goto L11;
        a(r100, r102, this.f283349j, 0);
    L11:
        Drawable r103 = this.f283352m;
        if (r103 == null) goto L14;
        a(r100, r103, this.f283350k, this.f283351l);
    L14:
        TraceEvent.endSection("UniversalCardCheckBox.onDraw");
        CheckBoxType r104 = CheckBoxType.CHECK_BOX;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f283348i != r100) goto L5;
        return;
    L5:
        this.f283348i = r100;
        refreshDrawableState();
    }

    public final void setColor(int r100) {
        this.f283342c = r100;
        this.f283355p = true;
        invalidate();
    }

    public final void setIndetermined(boolean r100) {
        if (this.f283340a == CheckBoxType.CHECK_BOX) goto L5;
        return;
    L5:
        this.f283347h = r100;
        this.f283355p = true;
        invalidate();
    }

    public final void setSize(CheckBoxSize r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        if (r100 != this.f283341b) goto L5;
        return;
    L5:
        this.f283341b = r100;
        if (this.f283340a != CheckBoxType.CHECK_MARK) goto L8;
        this.f283341b = CheckBoxSize.NORMAL_SIZE;
    L8:
        d();
    }

    public final void setType(CheckBoxType r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (this.f283340a != r100) goto L5;
        return;
    L5:
        this.f283340a = r100;
        if (r100 != CheckBoxType.CHECK_MARK) goto L9;
        setSize(CheckBoxSize.NORMAL_SIZE);
    L9:
        if (this.f283340a != CheckBoxType.CHECK_BOX_SQUARE) goto L11;
        setSize(CheckBoxSize.SQUARE_SIZE);
    L11:
        this.f283355p = true;
    }

    public final void setUncheckedBackgroundColor(int r100) {
        this.f283344e = true;
        this.f283343d = r100;
        invalidate();
    }

    public final void setUncheckedBorderColor(int r100) {
        this.f283346g = true;
        this.f283345f = r100;
        invalidate();
    }

    public UniversalCardCheckBox(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public final Drawable c(int r100, int r101) {
        if (r100 != 0) goto L5;
        return null;
    L5:
        com.larksuite.component.card.component.checkbox.a r102 = f283334q;
        Context r103 = getContext();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Pair r104 = new Pair(Integer.valueOf(r100), Integer.valueOf(r101));
        Drawable r105 = (Drawable) ((HashMap) r102.f283365a).get(r104);
        if (r105 != null) goto L11;
        if (r101 != 0) goto L9;
        Drawable r106 = UDIconUtils.getIconDrawable(r103, r100);
    L10:
        r105 = r106;
        goto L11
    L9:
        r106 = UDIconUtils.getIconDrawable(r103, r100, r101);
    L11:
        ((HashMap) r102.f283365a).put(r104, r105);
        return r105;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 == null) goto L10;
        int r103 = this.f283349j;
        if (r102.width != (-2)) goto L8;
        r100 = View.MeasureSpec.makeMeasureSpec((getPaddingLeft() + r103) + getPaddingRight(), 1073741824);
    L8:
        if (r102.height != (-2)) goto L10;
        r101 = View.MeasureSpec.makeMeasureSpec((r103 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L10:
        super.onMeasure(r100, r101);
    }

    public UniversalCardCheckBox(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, R.style.UDCheckBox);
        this.f283340a = CheckBoxType.CHECK_BOX;
        this.f283341b = CheckBoxSize.NORMAL_SIZE;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{android.R.attr.enabled, android.R.attr.clickable, android.R.attr.checked, R.attr.ud_checkbox_color, R.attr.ud_checkbox_indetermined, R.attr.ud_checkbox_size, R.attr.ud_checkbox_type, R.attr.ud_checkbox_uncheckedBackgroundColor, R.attr.ud_checkbox_uncheckedBorderColor}, r102, R.style.UDCheckBox);
        setClickable(r103.getBoolean(1, true));
        setChecked(r103.getBoolean(2, this.f283348i));
        setEnabled(r103.getBoolean(0, isEnabled()));
        int r104 = r103.getInt(6, 0);
        this.f283340a = CheckBoxType.values()[r104];
        this.f283342c = r103.getColor(3, this.f283342c);
        setIndetermined(r103.getBoolean(4, this.f283347h));
        int r105 = r103.getInt(5, 0);
        setSize(CheckBoxSize.values()[r105]);
        d();
        if (r103.hasValue(7) == false) goto L6;
        setUncheckedBackgroundColor(r103.getColor(7, 0));
    L6:
        if (r103.hasValue(8) == false) goto L8;
        setUncheckedBorderColor(r103.getColor(8, 0));
    L8:
        r103.recycle();
    }

    public final void a(Canvas r100, Drawable r101, int r102, int r103) {
        int r104 = getPaddingLeft() + r103;
        int r105 = getPaddingTop() + r103;
        r101.setBounds(new Rect(r104, r105, r104 + r102, r102 + r105));
        r101.draw(r100);
        r100.save();
    }
}
