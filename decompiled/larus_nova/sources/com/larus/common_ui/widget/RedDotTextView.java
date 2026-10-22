package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002/0B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nJ\u0015\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010$J\"\u0010%\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010'\u001a\u00020\nH\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\f\u0010.\u001a\u00020\u0015*\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018¨\u00061"}, d2 = {"Lcom/larus/common_ui/widget/RedDotTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastRedDotCount", "lastRedDotType", "Lcom/larus/common_ui/widget/RedDotTextView$RedDotType;", "redDotStyleType", "Lcom/larus/common_ui/widget/RedDotTextView$RedDotStyleType;", "style", "forceCircleDiameterPx", "Ljava/lang/Integer;", "isDotInvisible", "", "()Z", "setDotInvisible", "(Z)V", "isDotGone", "setDotGone", "setRedDotText", "count", "setRedDotTextInImmersive", "getRedDotCount", "setRedDotBG", "", "bgType", "setForceCircleBadgeDiameter", "diameterPx", "(Ljava/lang/Integer;)V", "initAttrs", "setRedDotBackground", "getRedDotTextColor", "setRedDotCircleBackground", "diameter", "setRedDotBackgroundMedium", "getRedDotText", "", "checkRedDotCountType", "isMainTabUnreadStyle", "RedDotType", "RedDotStyleType", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RedDotTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f328484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RedDotType f328485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RedDotStyleType f328486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f328487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f328488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f328489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f328490g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/common_ui/widget/RedDotTextView$RedDotStyleType;", "", "index", "", "<init>", "(Ljava/lang/String;II)V", "getIndex", "()I", "RED", "GREY", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RedDotStyleType extends Enum<RedDotStyleType> {
        public static final a Companion = null;
        public static final RedDotStyleType GREY = null;
        public static final RedDotStyleType RED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RedDotStyleType[] f328491a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f328492b = null;
        private final int index;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<RedDotStyleType> getEntries() {
            return f328492b;
        }

        static {
            RedDotStyleType r100 = new RedDotStyleType("RED", 0, 1);
            RED = r100;
            RedDotStyleType r101 = new RedDotStyleType("GREY", 1, 2);
            GREY = r101;
            RedDotStyleType[] r102 = {r100, r101};
            f328491a = r102;
            f328492b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static RedDotStyleType[] values() {
            return (RedDotStyleType[]) f328491a.clone();
        }

        public final int getIndex() {
            return this.index;
        }

        public static RedDotStyleType valueOf(String r100) {
            return (RedDotStyleType) r27.a.a(RedDotStyleType.class, r100);
        }

        public RedDotStyleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.index = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/common_ui/widget/RedDotTextView$RedDotType;", "", "<init>", "(Ljava/lang/String;I)V", "ZERO", "SINGLE_DIGIT", "TWO_DIGITS", "HUNDREDS", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RedDotType extends Enum<RedDotType> {
        public static final RedDotType HUNDREDS = null;
        public static final RedDotType SINGLE_DIGIT = null;
        public static final RedDotType TWO_DIGITS = null;
        public static final RedDotType ZERO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RedDotType[] f328493a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f328494b = null;

        public static EnumEntries<RedDotType> getEntries() {
            return f328494b;
        }

        static {
            RedDotType r100 = new RedDotType("ZERO", 0);
            ZERO = r100;
            RedDotType r101 = new RedDotType("SINGLE_DIGIT", 1);
            SINGLE_DIGIT = r101;
            RedDotType r102 = new RedDotType("TWO_DIGITS", 2);
            TWO_DIGITS = r102;
            RedDotType r103 = new RedDotType("HUNDREDS", 3);
            HUNDREDS = r103;
            RedDotType[] r104 = {r100, r101, r102, r103};
            f328493a = r104;
            f328494b = EnumEntriesKt.enumEntries(r104);
        }

        public static RedDotType[] values() {
            return (RedDotType[]) f328493a.clone();
        }

        public static RedDotType valueOf(String r100) {
            return (RedDotType) r27.a.a(RedDotType.class, r100);
        }

        public RedDotType(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328495a = null;

        static {
            int[] r100 = new int[RedDotStyleType.values().length];
            r100[RedDotStyleType.RED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[RedDotStyleType.GREY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f328495a = r100;
        }
    }

    private final int getRedDotTextColor() {
        RedDotStyleType r100 = this.f328486c;
        int r101 = a.f328495a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return R.color.larus_static_white;
    L5:
        if (r101 != 2) goto L8;
        return c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100);
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final int getRedDotCount() {
        return this.f328484a;
    }

    public RedDotTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f328485b = RedDotType.ZERO;
        this.f328486c = RedDotStyleType.RED;
        y(r100, null, 0);
    }

    private final void setRedDotBackground(int r100) {
        Integer r101 = this.f328488e;
        if (r101 == null) goto L7;
        setRedDotCircleBackground(r101.intValue());
        return;
    L7:
        if (1 <= r100) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L15;
        setRedDotCircleBackground(i5.v());
        return;
    L15:
        if (e2.f365734a.isPad() == false) goto L17;
        int r103 = i5.C();
    L18:
        int r104 = a.f328495a[this.f328486c.ordinal()];
        if (r104 != 1) goto L21;
        Intrinsics.checkNotNullParameter(this, "<this>");
        setBackground(e1.f(r103, i5.v(), r103, ContextCompat.getColor(getContext(), R.color.larus_danger_50)));
        return;
    L21:
        if (r104 != 2) goto L24;
        int r105 = c.b(R.attr.larus_press, getContext(), R.color.larus_press);
        Intrinsics.checkNotNullParameter(this, "<this>");
        setBackground(e1.f(r103, i5.v(), r103, ContextCompat.getColor(getContext(), r105)));
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    L17:
        r103 = i5.E();
        goto L18
    L9:
        if (r100 >= 10) goto L11;
        r102 = true;
        goto L12
    }

    private final void setRedDotCircleBackground(int r100) {
        RedDotStyleType r101 = this.f328486c;
        int r102 = a.f328495a[r101.ordinal()];
        if (r102 != 1) goto L5;
        e1.w(this, r100, r100, R.color.larus_danger_50);
        return;
    L5:
        if (r102 != 2) goto L8;
        e1.w(this, r100, r100, c.b(R.attr.larus_press, getContext(), R.color.larus_press));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static RedDotType x(int r100) {
        if (r100 == 0) goto L21;
        boolean r101 = false;
        if (1 > r100) goto L8;
        if (r100 >= 10) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return RedDotType.SINGLE_DIGIT;
    L12:
        if (10 > r100) goto L15;
        if (r100 >= 100) goto L15;
        r101 = true;
    L15:
        if (r101 == true) goto L23;
        if (r100 < 100) goto L20;
        return RedDotType.HUNDREDS;
    L20:
        return RedDotType.ZERO;
    L23:
        return RedDotType.TWO_DIGITS;
    L8:
        r102 = false;
        goto L9
    L21:
        return RedDotType.ZERO;
    }

    public final void A(int r100) {
        this.f328484a = r100;
        RedDotType r101 = x(r100);
        if (r101 != RedDotType.ZERO) goto L5;
        int r102 = 8;
    L6:
        setVisibility(r102);
        if (r100 >= 0) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L14;
        String r104 = String.valueOf(r100);
    L15:
        setText(r104);
        setRedDotBackground(r100);
        setTextColor(ContextCompat.getColor(getContext(), getRedDotTextColor()));
        if (this.f328485b != r101) goto L18;
        invalidate();
    L19:
        getVisibility();
        return;
    L18:
        this.f328485b = r101;
        requestLayout();
        goto L19
    L14:
        r104 = "99";
        goto L15
    L9:
        if (r100 >= 100) goto L11;
        r103 = true;
        goto L12
    L5:
        r102 = 4;
        goto L6
    }

    public final void setDotGone(boolean r100) {
        this.f328490g = r100;
    }

    public final void setDotInvisible(boolean r100) {
        this.f328489f = r100;
    }

    public final void setForceCircleBadgeDiameter(Integer r100) {
        this.f328488e = r100;
        if (this.f328484a <= 0) goto L5;
    L6:
        setRedDotBackground(this.f328484a);
        setTextColor(ContextCompat.getColor(getContext(), getRedDotTextColor()));
        invalidate();
        return;
    L5:
        if (getVisibility() != 8) goto L6;
    }

    public final void setRedDotBG(int r100) {
        RedDotStyleType.a r101 = RedDotStyleType.Companion;
        Integer r102 = Integer.valueOf(r100);
        r101.getClass();
        RedDotStyleType r103 = RedDotStyleType.RED;
        int r104 = r103.getIndex();
        if (r102 != null) goto L6;
    L8:
        r103 = RedDotStyleType.GREY;
        int r105 = r103.getIndex();
        if (r102 != null) goto L12;
    L14:
        r103 = null;
    L15:
        if (r103 == null) goto L18;
        this.f328486c = r103;
        return;
    L18:
        return;
    L12:
        if (r102.intValue() != r105) goto L14;
    L6:
        if (r102.intValue() != r104) goto L8;
        goto L8
    }

    public final void z(int r100) {
        RedDotType r101 = x(r100);
        boolean r102 = false;
        if (this.f328490g == false) goto L6;
    L7:
        int r103 = 8;
    L13:
        if (r103 == getVisibility()) goto L15;
    L18:
        this.f328484a = r100;
        setVisibility(r103);
        if (r100 >= 0) goto L21;
    L23:
        if (r102 == false) goto L25;
        String r104 = String.valueOf(r100);
    L26:
        setText(r104);
        setRedDotBackground(r100);
        setTextColor(ContextCompat.getColor(getContext(), getRedDotTextColor()));
        if (this.f328485b != r101) goto L29;
        invalidate();
    L30:
        if (r103 != 4) goto L32;
        getVisibility();
        return;
    L32:
        getVisibility();
        return;
    L29:
        this.f328485b = r101;
        requestLayout();
        goto L30
    L25:
        r104 = "99";
        goto L26
    L21:
        if (r100 >= 100) goto L23;
        r102 = true;
        goto L23
    L15:
        if (r100 != this.f328484a) goto L18;
        getVisibility();
        return;
    L6:
        if (r101 == RedDotType.ZERO) goto L7;
        if (this.f328489f == false) goto L11;
        r103 = 4;
        goto L13
    L11:
        r103 = 0;
        goto L13
    }

    public RedDotTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f328485b = RedDotType.ZERO;
        this.f328486c = RedDotStyleType.RED;
        y(r100, r101, 0);
    }

    public RedDotTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f328485b = RedDotType.ZERO;
        this.f328486c = RedDotStyleType.RED;
        y(r100, r101, r102);
    }

    public final void y(Context r100, AttributeSet r101, int r102) {
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_dimension_style}, r102, r102);
        this.f328487d = r103.getInt(0, this.f328487d);
        r103.recycle();
    }
}
