package com.larus.common_ui.dbx.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.larus.nova.R;
import com.lynx.textra.PlatformFontCaps;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Z2\u00020\u0001:\u0004WXYZB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ,\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u001a2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u000201\u0018\u000106H\u0007J\u000e\u00107\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u001aJ\u0018\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0014J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u000201H\u0002J\b\u0010@\u001a\u000201H\u0002J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\u0010\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0007H\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\u001a\u0010G\u001a\u0004\u0018\u00010\u001f2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IH\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020IH\u0002J\u0010\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u001aH\u0002J\f\u0010P\u001a\u00020**\u00020*H\u0002J\b\u0010Q\u001a\u00020RH\u0002J\u0010\u0010S\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010 \u001a\u00020IH\u0002J\u0012\u0010U\u001a\u00020\u00072\b\b\u0001\u0010V\u001a\u00020\u0007H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010'\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010 \u001a\u0004\u0018\u00010*@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006["}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxNavigationBar;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "style", "Lcom/larus/common_ui/dbx/component/DbxNavigationBar$Style;", "(Landroid/content/Context;Lcom/larus/common_ui/dbx/component/DbxNavigationBar$Style;)V", "getStyle", "()Lcom/larus/common_ui/dbx/component/DbxNavigationBar$Style;", "titleContainer", "titleStack", "Landroid/widget/LinearLayout;", "titleRow", "titleView", "Landroid/widget/TextView;", "titleIconView", "Landroid/widget/ImageView;", "subtitleView", "actionControls", "", "Lcom/larus/common_ui/dbx/component/DbxNavigationBar$ActionPosition;", "Lcom/larus/common_ui/dbx/component/DbxNavActionControl;", "leadingActionStack", "trailingActionStack", "overlapTouchTarget", "Landroid/view/View;", "value", "", "title", "getTitle", "()Ljava/lang/CharSequence;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/CharSequence;)V", "subtitle", "getSubtitle", "setSubtitle", "Landroid/graphics/drawable/Drawable;", "titleIcon", "getTitleIcon", "()Landroid/graphics/drawable/Drawable;", "setTitleIcon", "(Landroid/graphics/drawable/Drawable;)V", "setAction", "", "action", "Lcom/larus/common_ui/dbx/component/DbxNavigationBar$Action;", INotificationHitPoint.NoticeType.AT, "handler", "Lkotlin/Function0;", "actionControl", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "initialize", "setupTitleArea", "createActionControls", "setupStandardActions", "actionStack", "horizontalGravity", "setupMiniProgramActions", "updateTitleArea", "nearestOverlappingTrailingControl", "x", "", "y", "miniSurfaceBackground", "Landroid/graphics/drawable/GradientDrawable;", "radiusPx", "miniIconSide", "position", "copyForView", "semiboldTypeface", "Landroid/graphics/Typeface;", "dp", "dpF", "color", "attrId", "Style", "ActionPosition", TTVideoEngineInterface.PLAY_API_KEY_ACTION, "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DbxNavigationBar extends FrameLayout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f326923o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Style f326924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f326925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f326926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f326927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f326928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f326929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f326930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<ActionPosition, DbxNavActionControl> f326931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f326932i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f326933j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f326934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f326935l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f326936m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f326937n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxNavigationBar$ActionPosition;", "", "<init>", "(Ljava/lang/String;I)V", "LEADING_PRIMARY", "LEADING_SECONDARY", "TRAILING_SECONDARY", "TRAILING_PRIMARY", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionPosition extends Enum<ActionPosition> {
        public static final ActionPosition LEADING_PRIMARY = null;
        public static final ActionPosition LEADING_SECONDARY = null;
        public static final ActionPosition TRAILING_PRIMARY = null;
        public static final ActionPosition TRAILING_SECONDARY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionPosition[] f326938a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f326939b = null;

        public static EnumEntries<ActionPosition> getEntries() {
            return f326939b;
        }

        static {
            ActionPosition r100 = new ActionPosition("LEADING_PRIMARY", 0);
            LEADING_PRIMARY = r100;
            ActionPosition r101 = new ActionPosition("LEADING_SECONDARY", 1);
            LEADING_SECONDARY = r101;
            ActionPosition r102 = new ActionPosition("TRAILING_SECONDARY", 2);
            TRAILING_SECONDARY = r102;
            ActionPosition r103 = new ActionPosition("TRAILING_PRIMARY", 3);
            TRAILING_PRIMARY = r103;
            ActionPosition[] r104 = {r100, r101, r102, r103};
            f326938a = r104;
            f326939b = EnumEntriesKt.enumEntries(r104);
        }

        public static ActionPosition[] values() {
            return (ActionPosition[]) f326938a.clone();
        }

        public static ActionPosition valueOf(String r100) {
            return (ActionPosition) r27.a.a(ActionPosition.class, r100);
        }

        public ActionPosition(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxNavigationBar$Style;", "", "<init>", "(Ljava/lang/String;I)V", "STANDARD", "MINI_PROGRAM", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style MINI_PROGRAM = null;
        public static final Style STANDARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f326940a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f326941b = null;

        public static EnumEntries<Style> getEntries() {
            return f326941b;
        }

        static {
            Style r100 = new Style("STANDARD", 0);
            STANDARD = r100;
            Style r101 = new Style("MINI_PROGRAM", 1);
            MINI_PROGRAM = r101;
            Style[] r102 = {r100, r101};
            f326940a = r102;
            f326941b = EnumEntriesKt.enumEntries(r102);
        }

        public static Style[] values() {
            return (Style[]) f326940a.clone();
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f326942a = null;

        static {
            int[] r100 = new int[ActionPosition.values().length];
            r100[ActionPosition.LEADING_PRIMARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ActionPosition.LEADING_SECONDARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ActionPosition.TRAILING_SECONDARY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ActionPosition.TRAILING_PRIMARY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f326942a = r100;
        }
    }

    static {
    }

    public DbxNavigationBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DbxNavigationBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static Typeface d() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        Typeface r100 = Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 600, false);
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        Typeface r101 = Typeface.create("sans-serif-medium", 0);
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public final void e() {
        CharSequence r100 = this.f326936m;
        boolean r101 = true;
        int r102 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        boolean r104 = !r103;
        if (this.f326937n == null) goto L12;
        boolean r105 = true;
    L13:
        this.f326928e.setText(this.f326935l);
        TextView r106 = this.f326928e;
        CharSequence r107 = this.f326935l;
        if (r107 != null) goto L16;
    L19:
        int r108 = 8;
        if (r101 == false) goto L22;
        int r109 = 8;
    L23:
        r106.setVisibility(r109);
        this.f326928e.setTypeface(d());
        TextView r110 = this.f326928e;
        if (r104 == false) goto L26;
        float r111 = 15.0f;
    L27:
        r110.setTextSize(2, r111);
        TextView r112 = this.f326928e;
        if (r105 == false) goto L30;
        int r113 = 14;
    L31:
        r112.setMaxWidth(b(166 - r113));
        ImageView r114 = this.f326929f;
        Drawable r115 = this.f326937n;
        LinearLayout.LayoutParams r116 = null;
        if (r115 == null) goto L40;
        Drawable.ConstantState r117 = r115.getConstantState();
        if (r117 == null) goto L39;
        Drawable r118 = r117.newDrawable(getResources());
        if (r118 == null) goto L39;
        Drawable r119 = r118.mutate();
        if (r119 == null) goto L39;
    L41:
        r114.setImageDrawable(r119);
        ImageView r120 = this.f326929f;
        if (r105 == false) goto L44;
        int r121 = 0;
    L45:
        r120.setVisibility(r121);
        TextView r122 = this.f326930g;
        if (r104 == false) goto L48;
        CharSequence r123 = this.f326936m;
    L49:
        r122.setText(r123);
        TextView r124 = this.f326930g;
        if (r104 == false) goto L52;
        r108 = 0;
    L52:
        r124.setVisibility(r108);
        ViewGroup.LayoutParams r125 = this.f326930g.getLayoutParams();
        if ((r125 instanceof LinearLayout.LayoutParams) == false) goto L55;
        r116 = (LinearLayout.LayoutParams) r125;
    L55:
        if (r116 == null) goto L59;
        if (r104 == false) goto L58;
        r102 = b(2);
    L58:
        r116.topMargin = r102;
        this.f326930g.setLayoutParams(r116);
    L59:
        this.f326927d.requestLayout();
        this.f326926c.requestLayout();
        return;
    L48:
        r123 = null;
        goto L49
    L44:
        r121 = 8;
    L39:
        r119 = r115.mutate();
        goto L41
    L40:
        r119 = null;
        goto L41
    L30:
        r113 = 0;
        goto L31
    L26:
        r111 = 17.0f;
        goto L27
    L22:
        r109 = 0;
        goto L23
    L16:
        if (r107.length() == 0) goto L19;
        r101 = false;
        goto L19
    L12:
        r105 = false;
        goto L13
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final Style getStyle() {
        return this.f326924a;
    }

    public final CharSequence getSubtitle() {
        return this.f326936m;
    }

    public final CharSequence getTitle() {
        return this.f326935l;
    }

    public final Drawable getTitleIcon() {
        return this.f326937n;
    }

    public final int a(int r100) {
        return com.larus.common_ui.dbx.theme.a.b(getContext(), r100);
    }

    public final int b(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final GradientDrawable c(float r100) {
        GradientDrawable r101 = new GradientDrawable();
        r101.setColor(a(R.attr.larus_dbx_white_static_10));
        r101.setCornerRadius(r100);
        Resources r102 = getResources();
        r101.setStroke(RangesKt.coerceAtLeast((int) ((WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density * 0.5f) + 0.5f), 1), a(R.attr.larus_dbx_line_subtle));
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f326924a == Style.MINI_PROGRAM) goto L7;
        return super.dispatchTouchEvent(r110);
    L7:
        if (r110.getActionMasked() != 0) goto L50;
        float r100 = r110.getX();
        float r101 = r110.getY();
        DbxNavActionControl[] r102 = new DbxNavActionControl[2];
        Map<ActionPosition, DbxNavActionControl> r103 = this.f326931h;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r103 = null;
    L11:
        r102[0] = MapsKt.getValue(r103, ActionPosition.TRAILING_SECONDARY);
        Map<ActionPosition, DbxNavActionControl> r104 = this.f326931h;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r104 = null;
    L14:
        r102[1] = MapsKt.getValue(r104, ActionPosition.TRAILING_PRIMARY);
        List r105 = CollectionsKt.listOf(r102);
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L16:
        if (r107.hasNext() == false) goto L34;
        Object r108 = r107.next();
        DbxNavActionControl r109 = (DbxNavActionControl) r108;
        if (r109.getVisibility() == 0) goto L20;
    L30:
        boolean r111 = false;
    L31:
        if (r111 == false) goto L16;
        r106.add(r108);
        goto L16
    L20:
        if (r109.isEnabled() == false) goto L30;
        if (r100 < r109.getLeft()) goto L30;
        if (r100 >= r109.getRight()) goto L30;
        if (r101 < r109.getTop()) goto L30;
        if (r101 >= r109.getBottom()) goto L30;
        r111 = true;
        goto L31
    L34:
        if (r106.size() >= 2) goto L36;
        View r112 = null;
    L49:
        this.f326934k = r112;
        goto L50
    L36:
        Iterator r113 = r106.iterator();
        if (r113.hasNext() == true) goto L39;
        Object r114 = null;
    L48:
        r112 = (View) r114;
        goto L49
    L39:
        r114 = r113.next();
        if (r113.hasNext() == false) goto L48;
        DbxNavActionControl r115 = (DbxNavActionControl) r114;
        float r116 = r100 - ((r115.getLeft() + r115.getRight()) / 2.0f);
        float r117 = r101 - ((r115.getTop() + r115.getBottom()) / 2.0f);
        float r118 = (r116 * r116) + (r117 * r117);
    L43:
        Object r119 = r113.next();
        DbxNavActionControl r120 = (DbxNavActionControl) r119;
        float r121 = r100 - ((r120.getLeft() + r120.getRight()) / 2.0f);
        float r122 = r101 - ((r120.getTop() + r120.getBottom()) / 2.0f);
        float r123 = (r121 * r121) + (r122 * r122);
        if (Float.compare(r118, r123) <= 0) goto L47;
        r114 = r119;
        r118 = r123;
    L47:
        if (r113.hasNext() == true) goto L43;
    L50:
        View r124 = this.f326934k;
        if (r124 == null) goto L59;
        MotionEvent r125 = MotionEvent.obtain(r110);
        r125.offsetLocation(-r124.getLeft(), -r124.getTop());
        boolean r126 = r124.dispatchTouchEvent(r125);
        r125.recycle();
        if (r110.getActionMasked() != 1) goto L55;
    L56:
        this.f326934k = null;
    L57:
        return r126;
    L55:
        if (r110.getActionMasked() != 3) goto L57;
    L59:
        return super.dispatchTouchEvent(r110);
    }

    public final void setSubtitle(CharSequence r100) {
        this.f326936m = r100;
        e();
    }

    public final void setTitle(CharSequence r100) {
        this.f326935l = r100;
        e();
    }

    public final void setTitleIcon(Drawable r100) {
        this.f326937n = r100;
        e();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        if (r102 != Integer.MIN_VALUE) goto L5;
        int r103 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r100), 1073741824);
    L7:
        if (this.f326924a != Style.STANDARD) goto L19;
        if (r102 == 0) goto L19;
        int r104 = RangesKt.coerceAtLeast(((View.MeasureSpec.getSize(r100) - b(166)) / 2) - b(8), 0);
        LinearLayout r105 = this.f326932i;
        if (r105 != null) goto L12;
    L14:
        LinearLayout r106 = this.f326933j;
        if (r106 == null) goto L19;
        if (r106.getLayoutParams().width == r104) goto L19;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        r107.width = r104;
        r106.setLayoutParams(r107);
        goto L19
    L12:
        if (r105.getLayoutParams().width == r104) goto L14;
        ViewGroup.LayoutParams r108 = r105.getLayoutParams();
        r108.width = r104;
        r105.setLayoutParams(r108);
    L19:
        super.onMeasure(r103, View.MeasureSpec.makeMeasureSpec(b(44), 1073741824));
        return;
    L5:
        r103 = r100;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r15v5, types: [com.larus.common_ui.dbx.component.c] */
    public DbxNavigationBar(Context r110, AttributeSet r111, int r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r210);
        FrameLayout r100 = new FrameLayout(getContext());
        this.f326925b = r100;
        LinearLayout r101 = new LinearLayout(getContext());
        this.f326926c = r101;
        LinearLayout r102 = new LinearLayout(getContext());
        this.f326927d = r102;
        TextView r103 = new TextView(getContext());
        this.f326928e = r103;
        ImageView r104 = new ImageView(getContext());
        this.f326929f = r104;
        TextView r105 = new TextView(getContext());
        this.f326930g = r105;
        this.f326924a = Style.STANDARD;
        setMinimumHeight(b(44));
        setBackgroundColor(0);
        r103.setGravity(17);
        r103.setMaxLines(1);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        r103.setIncludeFontPadding(false);
        r103.setTypeface(d());
        r103.setTextColor(a(R.attr.larus_dbx_text_100));
        r104.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r104.setVisibility(8);
        r104.setColorFilter(a(R.attr.larus_dbx_text_100));
        r105.setGravity(17);
        r105.setMaxLines(1);
        r105.setEllipsize(TextUtils.TruncateAt.END);
        r105.setIncludeFontPadding(false);
        r105.setVisibility(8);
        r105.setTypeface(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0));
        r105.setTextColor(a(R.attr.larus_dbx_text_60));
        int r112 = 2;
        r105.setTextSize(2, 11.0f);
        r105.setLetterSpacing(0.02f);
        r105.setMaxWidth(b(166));
        r102.setOrientation(0);
        r102.setGravity(17);
        r102.addView(r103);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(b(12), b(12));
        r106.setMarginStart(b(2));
        r106.gravity = 16;
        Unit r113 = Unit.INSTANCE;
        r102.addView(r104, r106);
        r101.setOrientation(1);
        r101.setGravity(17);
        r101.addView(r102);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        r107.topMargin = b(2);
        r101.addView(r105, r107);
        r100.addView(r101, new FrameLayout.LayoutParams(-2, -2, 17));
        addView(r100, new FrameLayout.LayoutParams(b(166), b(44), 17));
        ActionPosition[] r108 = ActionPosition.values();
        LinkedHashMap r109 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r108.length), 16));
        int r114 = r108.length;
        int r115 = 0;
    L3:
        if (r115 >= r114) goto L22;
        ActionPosition r116 = r108[r115];
        Context r117 = getContext();
        if (this.f326924a != Style.STANDARD) goto L7;
        DbxNavActionControl.Appearance r118 = DbxNavActionControl.Appearance.STANDARD;
    L8:
        int r119 = b.f326942a[r116.ordinal()];
        if (r119 == 1) goto L20;
        if (r119 != r112) goto L12;
    L19:
        int r120 = 22;
    L21:
        r109.put(r116, new DbxNavActionControl(r117, r118, b(r120), new c(this)));
        r115 = r115 + 1;
        r112 = 2;
        goto L3
    L12:
        if (r119 != 3) goto L14;
        r120 = 24;
        goto L21
    L14:
        if (r119 == 4) goto L19;
        throw new NoWhenBranchMatchedException();
    L20:
        r120 = 18;
        goto L21
    L7:
        r118 = DbxNavActionControl.Appearance.MINI_PROGRAM;
        goto L8
    L22:
        this.f326931h = r109;
        Map<ActionPosition, DbxNavActionControl> r121 = null;
        if (this.f326924a != Style.STANDARD) goto L38;
        LinearLayout r122 = new LinearLayout(getContext());
        r122.setOrientation(0);
        r122.setGravity(8388627);
        r122.setClipChildren(true);
        LinearLayout r123 = new LinearLayout(getContext());
        r123.setOrientation(0);
        r123.setGravity(8388629);
        r123.setClipChildren(true);
        this.f326932i = r122;
        this.f326933j = r123;
        Map<ActionPosition, DbxNavActionControl> r124 = this.f326931h;
        if (r124 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r124 = null;
    L27:
        r122.addView((View) MapsKt.getValue(r124, ActionPosition.LEADING_PRIMARY));
        Map<ActionPosition, DbxNavActionControl> r125 = this.f326931h;
        if (r125 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r125 = null;
    L30:
        r122.addView((View) MapsKt.getValue(r125, ActionPosition.LEADING_SECONDARY));
        Map<ActionPosition, DbxNavActionControl> r126 = this.f326931h;
        if (r126 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r126 = null;
    L33:
        r123.addView((View) MapsKt.getValue(r126, ActionPosition.TRAILING_SECONDARY));
        Map<ActionPosition, DbxNavActionControl> r127 = this.f326931h;
        if (r127 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
    L37:
        r123.addView((View) MapsKt.getValue(r121, ActionPosition.TRAILING_PRIMARY));
        FrameLayout.LayoutParams r128 = new FrameLayout.LayoutParams(-2, b(44), GravityCompat.START);
        r128.setMarginStart(b(8));
        Unit r129 = Unit.INSTANCE;
        addView(r122, r128);
        FrameLayout.LayoutParams r130 = new FrameLayout.LayoutParams(-2, b(44), GravityCompat.END);
        r130.setMarginEnd(b(8));
        addView(r123, r130);
    L49:
        e();
        return;
    L36:
        r121 = r127;
        goto L37
    L38:
        View r131 = new View(getContext());
        r131.setBackground(c(b(36) / 2.0f));
        View r132 = new View(getContext());
        r132.setBackground(c(b(36) / 2.0f));
        FrameLayout.LayoutParams r133 = new FrameLayout.LayoutParams(b(36), b(36), 8388627);
        r133.setMarginStart(b(12));
        Unit r134 = Unit.INSTANCE;
        addView(r131, r133);
        FrameLayout.LayoutParams r135 = new FrameLayout.LayoutParams(b(80), b(36), 8388629);
        r135.setMarginEnd(b(12));
        addView(r132, r135);
        Map<ActionPosition, DbxNavActionControl> r136 = this.f326931h;
        if (r136 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r136 = null;
    L41:
        View r137 = (View) MapsKt.getValue(r136, ActionPosition.LEADING_PRIMARY);
        FrameLayout.LayoutParams r138 = new FrameLayout.LayoutParams(b(44), b(44), 8388627);
        r138.setMarginStart(b(8));
        addView(r137, r138);
        Map<ActionPosition, DbxNavActionControl> r139 = this.f326931h;
        if (r139 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
        r139 = null;
    L44:
        View r140 = (View) MapsKt.getValue(r139, ActionPosition.TRAILING_SECONDARY);
        FrameLayout.LayoutParams r141 = new FrameLayout.LayoutParams(b(44), b(44), 8388629);
        r141.setMarginEnd(b(48));
        addView(r140, r141);
        Map<ActionPosition, DbxNavActionControl> r142 = this.f326931h;
        if (r142 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("actionControls");
    L48:
        View r143 = (View) MapsKt.getValue(r121, ActionPosition.TRAILING_PRIMARY);
        FrameLayout.LayoutParams r144 = new FrameLayout.LayoutParams(b(44), b(44), 8388629);
        r144.setMarginEnd(b(12));
        addView(r143, r144);
        goto L49
    L47:
        r121 = r142;
        goto L48
    }

    public /* synthetic */ DbxNavigationBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
