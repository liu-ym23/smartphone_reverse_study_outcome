package com.larksuite.component.universe_design.checkbox;

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
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0005OPQRSB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\"\u0010%\u001a\u00020&2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0014J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020&H\u0014J\b\u0010.\u001a\u00020\u0016H\u0016J\b\u0010/\u001a\u00020&H\u0016J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\u0006\u00103\u001a\u00020\u0010J\u000e\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\u0010J\u000e\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020\u0012J\u0006\u00108\u001a\u00020\u0012J\u0010\u00109\u001a\u00020&2\b\b\u0001\u0010:\u001a\u00020\u000bJ\b\u0010;\u001a\u00020\u000bH\u0007J\u0010\u0010<\u001a\u00020&2\b\b\u0001\u0010:\u001a\u00020\u000bJ\u0010\u0010=\u001a\u00020&2\b\b\u0001\u0010:\u001a\u00020\u000bJ\u000e\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020\u0016J\u0006\u0010@\u001a\u00020\u0016J\u0010\u0010A\u001a\u00020&2\b\u0010B\u001a\u0004\u0018\u00010#J\b\u0010C\u001a\u00020&H\u0002J\b\u0010D\u001a\u00020&H\u0002J\u0010\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020FH\u0002J\f\u0010G\u001a\u00020F*\u00020\u0010H\u0002J\u0012\u0010;\u001a\u00020\u000b2\b\b\u0001\u0010H\u001a\u00020\u000bH\u0003J\b\u0010I\u001a\u00020\u0016H\u0002J(\u0010J\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010K\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u000bH\u0002J\u001e\u0010M\u001a\u0004\u0018\u00010\u001f2\b\b\u0001\u0010N\u001a\u00020\u000b2\b\b\u0001\u0010:\u001a\u00020\u000bH\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "Landroid/view/View;", "Landroid/widget/Checkable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mType", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox$CheckBoxType;", "mSize", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox$CheckBoxSize;", "mColor", "uncheckedBackgroundColor", "hasUncheckedBackgroundColorSet", "", "uncheckedBorderColor", "hasUncheckedBorderColorSet", "mIndetermined", "mIsChecked", "mDrawableSize", "mMarkSize", "mMarkOffset", "mMarkDrawable", "Landroid/graphics/drawable/Drawable;", "mBorderDrawable", "mBackgroundDrawable", "mOnCheckedChangeListener", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox$OnCheckedChangeListener;", "mNeedSetupDrawable", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawableStateChanged", "isChecked", "toggle", "setChecked", "checked", "performClick", "getType", "setType", "value", "setSize", "size", "getSize", "setColor", "color", "getColor", "setUncheckedBackgroundColor", "setUncheckedBorderColor", "setIndetermined", "indetermined", "isIndetermined", "setOnCheckedChangeListener", "listener", "setupSize", "setupCurrDrawable", "res", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox$ICheckBoxRes;", "getCheckBoxRes", "colorRes", "useCustomColor", "doDrawDrawable", "drawable", "offset", "getDrawable", "resId", "OnCheckedChangeListener", "CheckBoxType", "CheckBoxSize", "ICheckBoxRes", "Companion", "universe-ui-checkbox_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDCheckBox extends View implements Checkable {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final h18.c f284625r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy<UDCheckBox$Companion$checkboxRes$2.a> f284626s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Lazy<UDCheckBox$Companion$indeterminedCheckBoxRes$2.a> f284627t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy<UDCheckBox$Companion$radioRes$2.a> f284628u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Lazy<UDCheckBox$Companion$checkMarkRes$2.a> f284629v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CheckBoxType f284630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CheckBoxSize f284631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f284634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f284635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f284636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f284637h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f284638i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f284639j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f284640k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f284641l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f284642m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f284643n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f284644o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f284645p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f284646q;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/checkbox/UDCheckBox$CheckBoxSize;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL_SIZE", "SMALL_SIZE", "universe-ui-checkbox_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CheckBoxSize extends Enum<CheckBoxSize> {
        public static final CheckBoxSize NORMAL_SIZE = null;
        public static final CheckBoxSize SMALL_SIZE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CheckBoxSize[] f284647a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284648b = null;

        public static EnumEntries<CheckBoxSize> getEntries() {
            return f284648b;
        }

        static {
            CheckBoxSize r100 = new CheckBoxSize("NORMAL_SIZE", 0);
            NORMAL_SIZE = r100;
            CheckBoxSize r101 = new CheckBoxSize("SMALL_SIZE", 1);
            SMALL_SIZE = r101;
            CheckBoxSize[] r102 = {r100, r101};
            f284647a = r102;
            f284648b = EnumEntriesKt.enumEntries(r102);
        }

        public static CheckBoxSize[] values() {
            return (CheckBoxSize[]) f284647a.clone();
        }

        public static CheckBoxSize valueOf(String r100) {
            return (CheckBoxSize) r27.a.a(CheckBoxSize.class, r100);
        }

        public CheckBoxSize(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/checkbox/UDCheckBox$CheckBoxType;", "", "<init>", "(Ljava/lang/String;I)V", "CHECK_BOX", "RADIO", "CHECK_MARK", "universe-ui-checkbox_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CheckBoxType extends Enum<CheckBoxType> {
        public static final CheckBoxType CHECK_BOX = null;
        public static final CheckBoxType CHECK_MARK = null;
        public static final CheckBoxType RADIO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CheckBoxType[] f284649a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284650b = null;

        public static EnumEntries<CheckBoxType> getEntries() {
            return f284650b;
        }

        static {
            CheckBoxType r100 = new CheckBoxType("CHECK_BOX", 0);
            CHECK_BOX = r100;
            CheckBoxType r101 = new CheckBoxType("RADIO", 1);
            RADIO = r101;
            CheckBoxType r102 = new CheckBoxType("CHECK_MARK", 2);
            CHECK_MARK = r102;
            CheckBoxType[] r103 = {r100, r101, r102};
            f284649a = r103;
            f284650b = EnumEntriesKt.enumEntries(r103);
        }

        public static CheckBoxType[] values() {
            return (CheckBoxType[]) f284649a.clone();
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
            h18.c r100 = UDCheckBox.f284625r;
            return UDCheckBox.f284626s.getValue();
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
        void a(UDCheckBox r100, boolean r101);
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284651a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f284652b = null;

        static {
            int[] r100 = new int[CheckBoxSize.values().length];
            r100[CheckBoxSize.SMALL_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[CheckBoxSize.NORMAL_SIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            f284651a = r100;
            int[] r101 = new int[CheckBoxType.values().length];
            r101[CheckBoxType.CHECK_BOX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r101[CheckBoxType.RADIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r101[CheckBoxType.CHECK_MARK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f284652b = r101;
        }
    }

    static {
        new a();
        f284625r = new h18.c();
        f284626s = LazyKt.lazy(UDCheckBox$Companion$checkboxRes$2.INSTANCE);
        f284627t = LazyKt.lazy(UDCheckBox$Companion$indeterminedCheckBoxRes$2.INSTANCE);
        f284628u = LazyKt.lazy(UDCheckBox$Companion$radioRes$2.INSTANCE);
        f284629v = LazyKt.lazy(UDCheckBox$Companion$checkMarkRes$2.INSTANCE);
    }

    public final void d() {
        int r100 = d.f284651a[this.f284631b.ordinal()];
        if (r100 == 1) goto L8;
        if (r100 != 2) goto L7;
        int r101 = h18.d.d(getContext(), R.dimen.ud_checkbox_size_normal);
    L9:
        this.f284639j = r101;
        int r102 = (int) (r101 * b(this.f284630a).f());
        this.f284640k = r102;
        this.f284641l = (this.f284639j - r102) / 2;
        invalidate();
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r101 = h18.d.d(getContext(), R.dimen.ud_checkbox_size_small);
        goto L9
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f284638i);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.f284646q = true;
        invalidate();
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        return super.performClick();
    }

    public final int getColor() {
        return this.f284632c;
    }

    public final CheckBoxSize getSize() {
        return this.f284631b;
    }

    public final CheckBoxType getType() {
        return this.f284630a;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f284638i;
    }

    public UDCheckBox(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setupCurrDrawable(b r100) {
        int r101 = r100.d(this.f284638i, isEnabled());
        int r102 = 0;
        if (r101 != 0) goto L5;
        int r103 = 0;
    L6:
        boolean r104 = true;
        if (this.f284632c != 0) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L17;
        if (isEnabled() == false) goto L17;
        int r106 = this.f284632c;
    L28:
        if (this.f284632c != 0) goto L30;
    L32:
        r104 = false;
    L33:
        if (r104 == false) goto L40;
        if (this.f284638i == false) goto L40;
        if (isEnabled() == false) goto L40;
        r102 = this.f284632c;
    L50:
        boolean r107 = this.f284638i;
        isEnabled();
        this.f284642m = c(r100.a(r107), r103);
        this.f284643n = c(r100.e(this.f284638i, isEnabled()), r106);
        this.f284644o = c(r100.g(this.f284638i, isEnabled()), r102);
        return;
    L40:
        if (this.f284634e == true) goto L42;
    L46:
        int r108 = r100.b(this.f284638i, isEnabled());
        if (r108 == 0) goto L50;
        r102 = UDColorUtils.getColor(getContext(), r108);
        goto L50
    L42:
        if (this.f284630a == CheckBoxType.CHECK_MARK) goto L46;
        if (this.f284638i == true) goto L46;
        r102 = this.f284633d;
        goto L50
    L30:
        if (this.f284630a == CheckBoxType.CHECK_MARK) goto L32;
    L17:
        if (this.f284636g == true) goto L19;
    L23:
        int r109 = r100.c(this.f284638i, isEnabled());
        if (r109 != 0) goto L26;
        r106 = 0;
        goto L28
    L26:
        r106 = UDColorUtils.getColor(getContext(), r109);
        goto L28
    L19:
        if (this.f284630a == CheckBoxType.CHECK_MARK) goto L23;
        if (this.f284638i == true) goto L23;
        r106 = this.f284635f;
        goto L28
    L9:
        if (this.f284630a == CheckBoxType.CHECK_MARK) goto L11;
        r105 = true;
        goto L12
    L5:
        r103 = UDColorUtils.getColor(getContext(), r101);
        goto L6
    }

    public final b b(CheckBoxType r100) {
        int r101 = d.f284652b[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L18;
        if (r101 != 3) goto L10;
        return f284629v.getValue();
    L10:
        throw new NoWhenBranchMatchedException();
    L18:
        return f284628u.getValue();
    L13:
        if (this.f284637h == false) goto L16;
        return f284627t.getValue();
    L16:
        return a.a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f284646q == false) goto L5;
        setupCurrDrawable(b(this.f284630a));
        invalidate();
        this.f284646q = false;
    L5:
        Drawable r101 = this.f284644o;
        if (r101 == null) goto L8;
        a(r100, r101, this.f284639j, 0);
    L8:
        Drawable r102 = this.f284643n;
        if (r102 == null) goto L11;
        a(r100, r102, this.f284639j, 0);
    L11:
        Drawable r103 = this.f284642m;
        if (r103 == null) goto L14;
        a(r100, r103, this.f284640k, this.f284641l);
    L14:
        CheckBoxType r104 = CheckBoxType.CHECK_BOX;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.f284638i != r100) goto L5;
        return;
    L5:
        this.f284638i = r100;
        c r101 = this.f284645p;
        if (r101 == null) goto L8;
        r101.a(this, r100);
    L8:
        refreshDrawableState();
    }

    public final void setColor(int r100) {
        this.f284632c = r100;
        this.f284646q = true;
        invalidate();
    }

    public final void setIndetermined(boolean r100) {
        if (this.f284630a == CheckBoxType.CHECK_BOX) goto L5;
        return;
    L5:
        this.f284637h = r100;
        this.f284646q = true;
        invalidate();
    }

    public final void setOnCheckedChangeListener(c r100) {
        this.f284645p = r100;
    }

    public final void setSize(CheckBoxSize r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        if (r100 != this.f284631b) goto L5;
        return;
    L5:
        this.f284631b = r100;
        if (this.f284630a != CheckBoxType.CHECK_MARK) goto L8;
        this.f284631b = CheckBoxSize.NORMAL_SIZE;
    L8:
        d();
    }

    public final void setType(CheckBoxType r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (this.f284630a != r100) goto L5;
        return;
    L5:
        this.f284630a = r100;
        if (r100 != CheckBoxType.CHECK_MARK) goto L8;
        setSize(CheckBoxSize.NORMAL_SIZE);
    L8:
        this.f284646q = true;
    }

    public final void setUncheckedBackgroundColor(int r100) {
        this.f284634e = true;
        this.f284633d = r100;
        invalidate();
    }

    public final void setUncheckedBorderColor(int r100) {
        this.f284636g = true;
        this.f284635f = r100;
        invalidate();
    }

    public UDCheckBox(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public final Drawable c(int r100, int r101) {
        if (r100 != 0) goto L5;
        return null;
    L5:
        h18.c r102 = f284625r;
        Context r103 = getContext();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Pair r104 = new Pair(Integer.valueOf(r100), Integer.valueOf(r101));
        Drawable r105 = (Drawable) ((HashMap) r102.f483539a).get(r104);
        if (r105 != null) goto L11;
        if (r101 != 0) goto L9;
        Drawable r106 = UDIconUtils.getIconDrawable(r103, r100);
    L10:
        r105 = r106;
        goto L11
    L9:
        r106 = UDIconUtils.getIconDrawable(r103, r100, r101);
    L11:
        ((HashMap) r102.f483539a).put(r104, r105);
        return r105;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 == null) goto L10;
        int r103 = this.f284639j;
        if (r102.width != (-2)) goto L8;
        r100 = View.MeasureSpec.makeMeasureSpec((getPaddingLeft() + r103) + getPaddingRight(), 1073741824);
    L8:
        if (r102.height != (-2)) goto L10;
        r101 = View.MeasureSpec.makeMeasureSpec((r103 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L10:
        super.onMeasure(r100, r101);
    }

    public UDCheckBox(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, R.style.UDCheckBox);
        this.f284630a = CheckBoxType.CHECK_BOX;
        this.f284631b = CheckBoxSize.NORMAL_SIZE;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{android.R.attr.enabled, android.R.attr.clickable, android.R.attr.checked, R.attr.ud_checkbox_color, R.attr.ud_checkbox_indetermined, R.attr.ud_checkbox_size, R.attr.ud_checkbox_type, R.attr.ud_checkbox_uncheckedBackgroundColor, R.attr.ud_checkbox_uncheckedBorderColor}, r102, R.style.UDCheckBox);
        setClickable(r103.getBoolean(1, true));
        setChecked(r103.getBoolean(2, this.f284638i));
        setEnabled(r103.getBoolean(0, isEnabled()));
        int r104 = r103.getInt(6, 0);
        this.f284630a = CheckBoxType.values()[r104];
        this.f284632c = r103.getColor(3, this.f284632c);
        setIndetermined(r103.getBoolean(4, this.f284637h));
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
