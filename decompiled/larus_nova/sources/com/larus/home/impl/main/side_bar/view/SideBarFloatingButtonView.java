package com.larus.home.impl.main.side_bar.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\u0002GHB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u001b\u001a\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0018J\u0006\u0010\u001e\u001a\u00020\u001aJ\u0018\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020!J\u0010\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0018J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020\u001aH\u0002J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0002J,\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u00020\u0018H\u0002J9\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u00010\u00072\u0006\u00108\u001a\u0002092\b\b\u0002\u00103\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\u001aH\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0018H\u0002J\b\u0010?\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u000202H\u0002J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0002J\u0018\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0002J\b\u0010F\u001a\u000209H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/SideBarFloatingButtonView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shadowLayout", "Lcom/larus/common_ui/widget/ShadowLayout;", "backgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "contentView", "Landroid/widget/LinearLayout;", "iconContainer", "iconView", "Lcom/larus/bmhome/view/RoundAvatarImageView;", "textView", "Landroid/widget/TextView;", "presentation", "Lcom/larus/home/impl/main/side_bar/view/SideBarFloatingButtonView$Presentation;", "shouldInvertThemeColors", "", "bindNewConversation", "", "iconRes", "textRes", "invertThemeColors", "showLegacyStyle", "setLegacyAvatar", "url", "", "bizTag", "setLegacyText", "text", "", "refreshColors", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "applyPresentation", "applyLegacyLayout", "iconSizeDp", "applyNewConversationLayout", "applyControlGroupShadow", "updateIconLayout", "slotSizeDp", "marginEndDp", "", "useFixedDp", "updateTextLayout", "marginStartDp", "textSizeDp", "heightDp", "typeface", "Landroid/graphics/Typeface;", "(IILjava/lang/Integer;Landroid/graphics/Typeface;Z)V", "applyColors", "newConversationColors", "Lcom/larus/home/impl/main/side_bar/view/SideBarFloatingButtonView$Colors;", "isDarkMode", "cornerRadius", "fixedDp", "value", "dimensionByDp", "dimension", "attrId", "dimenId", "semiboldTypeface", "Presentation", "Colors", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SideBarFloatingButtonView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f344826i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShadowLayout f344827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientDrawable f344828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f344829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f344830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RoundAvatarImageView f344831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f344832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Presentation f344833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f344834h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/SideBarFloatingButtonView$Presentation;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY", "NEW_CONVERSATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Presentation extends Enum<Presentation> {
        public static final Presentation LEGACY = null;
        public static final Presentation NEW_CONVERSATION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Presentation[] f344835a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f344836b = null;

        public static EnumEntries<Presentation> getEntries() {
            return f344836b;
        }

        static {
            Presentation r100 = new Presentation("LEGACY", 0);
            LEGACY = r100;
            Presentation r101 = new Presentation("NEW_CONVERSATION", 1);
            NEW_CONVERSATION = r101;
            Presentation[] r102 = {r100, r101};
            f344835a = r102;
            f344836b = EnumEntriesKt.enumEntries(r102);
        }

        public static Presentation[] values() {
            return (Presentation[]) f344835a.clone();
        }

        public static Presentation valueOf(String r100) {
            return (Presentation) r27.a.a(Presentation.class, r100);
        }

        public Presentation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f344837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f344838b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f344837a == r101.f344837a) goto L12;
            return false;
        L12:
            if (this.f344838b == r101.f344838b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f344837a * 31) + this.f344838b;
        }

        public final String toString() {
            return "Colors(background=" + this.f344837a + ", content=" + this.f344838b + ')';
        }

        public a(int r100, int r101) {
            this.f344837a = r100;
            this.f344838b = r101;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f344839a = null;

        static {
            int[] r100 = new int[Presentation.values().length];
            r100[Presentation.LEGACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Presentation.NEW_CONVERSATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f344839a = r100;
        }
    }

    public SideBarFloatingButtonView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SideBarFloatingButtonView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void b() {
        this.f344827a.setShadowSize(e(8));
        this.f344827a.setShadowOffset(new Point(0, e(2)));
        this.f344827a.setShadowColor(Color.argb(31, 0, 0, 0));
        this.f344827a.setShadowRadius(d(R.attr.larus_dp_100, R.dimen.larus_dp_100));
    }

    public final void c() {
        Presentation r100 = this.f344833g;
        int r101 = b.f344839a[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.f344829c.getLayoutParams().height = -2;
        this.f344829c.setPaddingRelative(d(R.attr.larus_dp_10, R.dimen.larus_dp_10), d(R.attr.larus_dp_8, R.dimen.larus_dp_8), d(R.attr.larus_dp_18, R.dimen.larus_dp_18), d(R.attr.larus_dp_8, R.dimen.larus_dp_8));
        g(28, 28, 0.0f, false);
        h(6, 15, null, Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 1), false);
        b();
    L14:
        a();
        return;
    L5:
        if (r101 != 2) goto L12;
        ViewGroup.LayoutParams r102 = this.f344829c.getLayoutParams();
        r102.height = f(46.0f);
        this.f344829c.setPaddingRelative(f(17.5f), 0, f(17.5f), 0);
        g(21, 21, 6.5f, true);
        if (Build.VERSION.SDK_INT < 28) goto L9;
        Typeface r103 = Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 600, false);
        Intrinsics.checkNotNull(r103);
    L10:
        h(0, 16, 24, r103, true);
        b();
        goto L14
    L9:
        r103 = Typeface.create("sans-serif-medium", 0);
        Intrinsics.checkNotNull(r103);
        goto L10
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final void a() {
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r100 = true;
    L6:
        int r101 = b.f344839a[this.f344833g.ordinal()];
        if (r101 != 1) goto L9;
        a r102 = new a(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_base_3, getContext(), R.color.larus_base_3)), ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
    L22:
        this.f344828b.setColor(r102.f344837a);
        GradientDrawable r103 = this.f344828b;
        if (this.f344833g != Presentation.NEW_CONVERSATION) goto L25;
        int r104 = f(95.0f);
    L26:
        r103.setCornerRadius(r104);
        this.f344832f.setTextColor(r102.f344838b);
        GenericDraweeHierarchy r105 = this.f344831e.getHierarchy();
        if (this.f344833g != Presentation.LEGACY) goto L29;
        PorterDuffColorFilter r106 = null;
    L30:
        r105.setActualImageColorFilter(r106);
        return;
    L29:
        r106 = new PorterDuffColorFilter(r102.f344838b, PorterDuff.Mode.SRC_IN);
        goto L30
    L25:
        r104 = d(R.attr.larus_dp_100, R.dimen.larus_dp_100);
        goto L26
    L9:
        if (r101 != 2) goto L20;
        boolean r107 = this.f344834h;
        if (r107 == false) goto L14;
        if (r100 == false) goto L14;
        r102 = new a(com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_text_100), com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_black_static_100));
    L14:
        if (r107 == false) goto L16;
        r102 = new a(com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_black_static_100), com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_white_static_100));
        goto L22
    L16:
        if (r100 == false) goto L18;
        r102 = new a(com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_bg_base_4), com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_text_100));
        goto L22
    L18:
        r102 = new a(com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_bg_base_1), com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_black_static_100));
        goto L22
    L20:
        throw new NoWhenBranchMatchedException();
    L5:
        r100 = false;
        goto L6
    }

    public final int e(int r100) {
        if (r100 != 2) goto L5;
        Pair r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_2), Integer.valueOf(R.dimen.larus_dp_2));
    L43:
        if (r101 != null) goto L45;
        Resources r102 = getResources();
        return (int) TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    L45:
        return d(((Number) r101.getFirst()).intValue(), ((Number) r101.getSecond()).intValue());
    L5:
        if (r100 != 4) goto L7;
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_4), Integer.valueOf(R.dimen.larus_dp_4));
        goto L43
    L7:
        if (r100 != 6) goto L9;
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_6), Integer.valueOf(R.dimen.larus_dp_6));
        goto L43
    L9:
        if (r100 != 8) goto L11;
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_8), Integer.valueOf(R.dimen.larus_dp_8));
        goto L43
    L11:
        if (r100 != 10) goto L13;
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_10), Integer.valueOf(R.dimen.larus_dp_10));
        goto L43
    L13:
        if (r100 != 18) goto L15;
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_18), Integer.valueOf(R.dimen.larus_dp_18));
        goto L43
    L15:
        if (r100 != 26) goto L17;
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_26), Integer.valueOf(R.dimen.larus_dp_26));
        goto L43
    L17:
        if (r100 != 28) goto L19;
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_28), Integer.valueOf(R.dimen.larus_dp_28));
        goto L43
    L19:
        if (r100 != 30) goto L21;
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_30), Integer.valueOf(R.dimen.larus_dp_30));
        goto L43
    L21:
        if (r100 != 48) goto L23;
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_48), Integer.valueOf(R.dimen.larus_dp_48));
        goto L43
    L23:
        if (r100 != 15) goto L25;
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_15), Integer.valueOf(R.dimen.larus_dp_15));
        goto L43
    L25:
        if (r100 == 16) goto L31;
        switch(r100) {
            case 20: goto L30;
            case 21: goto L29;
            case 22: goto L28;
            default: goto L27;
        };
    L27:
        r101 = null;
        goto L43
    L28:
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_22), Integer.valueOf(R.dimen.larus_dp_22));
        goto L43
    L29:
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_21), Integer.valueOf(R.dimen.larus_dp_21));
        goto L43
    L30:
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_20), Integer.valueOf(R.dimen.larus_dp_20));
        goto L43
    L31:
        r101 = TuplesKt.to(Integer.valueOf(R.attr.larus_dp_16), Integer.valueOf(R.dimen.larus_dp_16));
        goto L43
    }

    public final int f(float r100) {
        Resources r101 = getResources();
        return MathKt.roundToInt(TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        a();
    }

    public final void setLegacyText(CharSequence r100) {
        TextView r101 = this.f344832f;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.setText(r100);
    }

    public final int d(int r100, int r101) {
        return getResources().getDimensionPixelSize(v19.c.b(r100, getContext(), r101));
    }

    public SideBarFloatingButtonView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShadowLayout r103 = new ShadowLayout(r100);
        this.f344827a = r103;
        GradientDrawable r104 = new GradientDrawable();
        r104.setShape(0);
        this.f344828b = r104;
        LinearLayout r105 = new LinearLayout(r100);
        r105.setBackground(r104);
        r105.setGravity(16);
        r105.setOrientation(0);
        this.f344829c = r105;
        FrameLayout r106 = new FrameLayout(r100);
        this.f344830d = r106;
        RoundAvatarImageView r107 = new RoundAvatarImageView(r100);
        this.f344831e = r107;
        TextView r108 = new TextView(r100);
        r108.setIncludeFontPadding(false);
        r108.setMaxLines(1);
        this.f344832f = r108;
        this.f344833g = Presentation.LEGACY;
        r106.addView(r107, new FrameLayout.LayoutParams(-1, -1, 17));
        r105.addView(r106);
        r105.addView(r108);
        r103.addView(r105, new ShadowLayout.LayoutParams(-2, -2));
        addView(r103, new FrameLayout.LayoutParams(-2, -2));
        c();
    }

    public /* synthetic */ SideBarFloatingButtonView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void g(int r100, int r101, float r102, boolean r103) {
        if (r103 == false) goto L4;
        Function1 r104 = new x1(this);
    L5:
        int r105 = ((Number) r104.invoke(Integer.valueOf(r100))).intValue();
        FrameLayout r106 = this.f344830d;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(r105, r105);
        if (r103 == false) goto L8;
        int r108 = f(r102);
    L9:
        r107.setMarginEnd(r108);
        r106.setLayoutParams(r107);
        int r109 = ((Number) r104.invoke(Integer.valueOf(r101))).intValue();
        this.f344831e.setLayoutParams(new FrameLayout.LayoutParams(r109, r109, 17));
        return;
    L8:
        r108 = e(MathKt.roundToInt(r102));
        goto L9
    L4:
        r104 = new SideBarFloatingButtonView$updateIconLayout$resolveSize$2(this);
        goto L5
    }

    public final void h(int r100, int r101, Integer r102, Typeface r103, boolean r104) {
        if (r104 == false) goto L4;
        Function1 r105 = new y1(this);
    L5:
        TextView r106 = this.f344832f;
        if (r102 == null) goto L8;
        int r107 = ((Number) r105.invoke(r102)).intValue();
    L9:
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, r107);
        r108.setMarginStart(((Number) r105.invoke(Integer.valueOf(r100))).intValue());
        r106.setLayoutParams(r108);
        this.f344832f.setGravity(16);
        this.f344832f.setTextSize(0, ((Number) r105.invoke(Integer.valueOf(r101))).intValue());
        this.f344832f.setTypeface(r103);
        return;
    L8:
        r107 = -2;
        goto L9
    L4:
        r105 = new SideBarFloatingButtonView$updateTextLayout$resolveSize$2(this);
        goto L5
    }
}
