package com.larus.common_ui.dbx.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.CastMonitor;
import com.bytedance.ee.bear.mindnote.toolbar.MindNoteTitleMenuConfigPlugin;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 M2\u00020\u0001:\u0004JKLMB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010,\u001a\u00020-2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0017\u0010.\u001a\u00020-2\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010%J\u0010\u00100\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000102J\u0017\u00103\u001a\u00020-2\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010%J\u0010\u00104\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000102J\b\u00105\u001a\u00020-H\u0002J\b\u00106\u001a\u00020-H\u0002J\b\u00107\u001a\u00020-H\u0002J0\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007H\u0014J\b\u0010>\u001a\u00020-H\u0002J\b\u0010?\u001a\u00020-H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020'H\u0016J\u0010\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020'H\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0012\u0010F\u001a\u00020\u00072\b\b\u0001\u0010G\u001a\u00020\u0007H\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR,\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010(\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020'@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006N"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "style", "Lcom/larus/common_ui/dbx/component/DbxButton$Style;", "size", "Lcom/larus/common_ui/dbx/component/DbxButton$Size;", "contentRow", "Landroid/widget/LinearLayout;", "leadingIconView", "Landroid/widget/ImageView;", "labelView", "Landroid/widget/TextView;", "trailingIconView", "loadingRing", "Lcom/larus/common_ui/dbx/component/DbxLoadingRingView;", "value", "", "title", "getTitle", "()Ljava/lang/CharSequence;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/CharSequence;)V", "accessibleLabel", "getAccessibleLabel", "setAccessibleLabel", "contentColor", "getContentColor", "()Ljava/lang/Integer;", "setContentColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "", "isLoading", "()Z", "setLoading", "(Z)V", "configure", "", "setLeadingIcon", "resId", "setLeadingIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setTrailingIcon", "setTrailingIconDrawable", "rebuildForSize", "updateContentLayout", "updateAccessibility", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "updateLoadingState", "applyStyle", "pressedColor", "setPressed", "pressed", "setEnabled", "enabled", "dp", "color", "attrId", "paletteFor", "Lcom/larus/common_ui/dbx/component/DbxButton$Palette;", "Style", "Size", "Palette", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DbxButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Style f326898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Size f326899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f326900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f326901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f326902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f326903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.common_ui.dbx.component.b f326904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f326905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f326906i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f326907j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f326908k;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxButton$Size;", "", "heightDp", "", "cornerRadiusDp", "iconSideDp", "contentInsetDp", "fontSizeSp", "<init>", "(Ljava/lang/String;IIIIII)V", "getHeightDp", "()I", "getCornerRadiusDp", "getIconSideDp", "getContentInsetDp", "getFontSizeSp", "XL", "L", "MD", ExifInterface.LATITUDE_SOUTH, "XS", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Size extends Enum<Size> {
        public static final Size L = null;
        public static final Size MD = null;
        public static final Size S = null;
        public static final Size XL = null;
        public static final Size XS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Size[] f326909a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f326910b = null;
        private final int contentInsetDp;
        private final int cornerRadiusDp;
        private final int fontSizeSp;
        private final int heightDp;
        private final int iconSideDp;

        public static EnumEntries<Size> getEntries() {
            return f326910b;
        }

        static {
            Size r100 = new Size("XL", 0, 56, 16, 24, 16, 17);
            XL = r100;
            Size r101 = new Size("L", 1, 44, 12, 22, 11, 16);
            L = r101;
            Size r102 = new Size("MD", 2, 36, 8, 20, 8, 14);
            MD = r102;
            Size r103 = new Size(ExifInterface.LATITUDE_SOUTH, 3, 32, 8, 16, 8, 13);
            S = r103;
            Size r104 = new Size("XS", 4, 28, 8, 14, 7, 12);
            XS = r104;
            Size[] r105 = {r100, r101, r102, r103, r104};
            f326909a = r105;
            f326910b = EnumEntriesKt.enumEntries(r105);
        }

        public static Size[] values() {
            return (Size[]) f326909a.clone();
        }

        public final int getContentInsetDp() {
            return this.contentInsetDp;
        }

        public final int getCornerRadiusDp() {
            return this.cornerRadiusDp;
        }

        public final int getFontSizeSp() {
            return this.fontSizeSp;
        }

        public final int getHeightDp() {
            return this.heightDp;
        }

        public final int getIconSideDp() {
            return this.iconSideDp;
        }

        public static Size valueOf(String r100) {
            return (Size) r27.a.a(Size.class, r100);
        }

        public Size(String r100, int r101, int r102, int r103, int r104, int r105, int r106) {
            super(r100, r101);
            this.heightDp = r102;
            this.cornerRadiusDp = r103;
            this.iconSideDp = r104;
            this.contentInsetDp = r105;
            this.fontSizeSp = r106;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxButton$Style;", "", "<init>", "(Ljava/lang/String;I)V", "SOLID", "GRAY", MindNoteTitleMenuConfigPlugin.MENU_ID_OUTLINE, "WHITE", "PLAIN", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style GRAY = null;
        public static final Style OUTLINE = null;
        public static final Style PLAIN = null;
        public static final Style SOLID = null;
        public static final Style WHITE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f326911a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f326912b = null;

        public static EnumEntries<Style> getEntries() {
            return f326912b;
        }

        static {
            Style r100 = new Style("SOLID", 0);
            SOLID = r100;
            Style r101 = new Style("GRAY", 1);
            GRAY = r101;
            Style r102 = new Style(MindNoteTitleMenuConfigPlugin.MENU_ID_OUTLINE, 2);
            OUTLINE = r102;
            Style r103 = new Style("WHITE", 3);
            WHITE = r103;
            Style r104 = new Style("PLAIN", 4);
            PLAIN = r104;
            Style[] r105 = {r100, r101, r102, r103, r104};
            f326911a = r105;
            f326912b = EnumEntriesKt.enumEntries(r105);
        }

        public static Style[] values() {
            return (Style[]) f326911a.clone();
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

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f326913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f326914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f326915c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f326913a, r101.f326913a) == true) goto L12;
            return false;
        L12:
            if (this.f326914b == r101.f326914b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f326915c, r101.f326915c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f326913a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f326914b) * 31;
            Integer r104 = this.f326915c;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Palette(backgroundColorAttr=" + this.f326913a + ", foregroundColorAttr=" + this.f326914b + ", borderColorAttr=" + this.f326915c + ')';
        }

        public b(Integer r100, int r101, Integer r102) {
            this.f326913a = r100;
            this.f326914b = r101;
            this.f326915c = r102;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f326916a = null;

        static {
            int[] r100 = new int[Style.values().length];
            r100[Style.SOLID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[Style.GRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[Style.WHITE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[Style.OUTLINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[Style.PLAIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f326916a = r100;
        }
    }

    static {
    }

    public DbxButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DbxButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        Style r100 = this.f326898a;
        int[] r101 = c.f326916a;
        int r102 = r101[r100.ordinal()];
        if (r102 == 1) goto L14;
        if (r102 == 2) goto L13;
        if (r102 == 3) goto L12;
        if (r102 == 4) goto L11;
        if (r102 != 5) goto L10;
        b r103 = new b(null, R.attr.larus_dbx_text_100, null);
    L16:
        if (isPressed() == true) goto L18;
    L22:
        boolean r104 = false;
    L23:
        GradientDrawable r110 = new GradientDrawable();
        r110.setCornerRadius(c(this.f326899b.getCornerRadiusDp()));
        if (r104 == false) goto L39;
        int r105 = r101[this.f326898a.ordinal()];
        if (r105 == 1) goto L37;
        if (r105 == 2) goto L36;
        if (r105 == 3) goto L35;
        if (r105 == 4) goto L34;
        if (r105 == 5) goto L34;
        throw new NoWhenBranchMatchedException();
    L34:
        int r106 = ColorUtils.setAlphaComponent(com.larus.common_ui.dbx.theme.a.b(getContext(), R.attr.larus_dbx_text_100), 20);
    L38:
        r110.setColor(r106);
    L43:
        Integer r107 = r103.f326915c;
        if (r107 == null) goto L46;
        r110.setStroke(c(1), com.larus.common_ui.dbx.theme.a.b(getContext(), r107.intValue()));
    L46:
        setBackground(r110);
        Integer r108 = this.f326907j;
        if (r108 == null) goto L49;
        int r109 = r108.intValue();
    L50:
        this.f326902e.setTextColor(r109);
        this.f326901d.setColorFilter(r109);
        this.f326903f.setColorFilter(r109);
        this.f326904g.setRingColor(r109);
        if (this.f326908k == false) goto L54;
    L56:
        float r111 = 1.0f;
    L57:
        setAlpha(r111);
        return;
    L54:
        if (isEnabled() == true) goto L56;
        r111 = 0.3f;
        goto L57
    L49:
        r109 = com.larus.common_ui.dbx.theme.a.b(getContext(), r103.f326914b);
        goto L50
    L35:
        r106 = -1315861;
        goto L38
    L36:
        r106 = -1842205;
        goto L38
    L37:
        r106 = -16752917;
        goto L38
    L39:
        Integer r112 = r103.f326913a;
        if (r112 == null) goto L42;
        r110.setColor(com.larus.common_ui.dbx.theme.a.b(getContext(), r112.intValue()));
        goto L43
    L42:
        r110.setColor(0);
        goto L43
    L18:
        if (isEnabled() == false) goto L22;
        if (this.f326908k == true) goto L22;
        r104 = true;
        goto L23
    L10:
        throw new NoWhenBranchMatchedException();
    L11:
        r103 = new b(null, R.attr.larus_dbx_text_100, Integer.valueOf(R.attr.larus_dbx_line_default));
        goto L16
    L12:
        r103 = new b(Integer.valueOf(R.attr.larus_dbx_bg_base_1), R.attr.larus_dbx_text_100, null);
        goto L16
    L13:
        r103 = new b(Integer.valueOf(R.attr.larus_dbx_bg_subtle_3), R.attr.larus_dbx_text_100, null);
        goto L16
    L14:
        r103 = new b(Integer.valueOf(R.attr.larus_dbx_theme_action_bg), R.attr.larus_dbx_theme_action_text, null);
        goto L16
    }

    public final void d() {
        CharSequence r100 = this.f326905h;
        int r101 = 0;
        if (r100 != null) goto L5;
        boolean r102 = true;
    L6:
        this.f326902e.setText(r100);
        TextView r103 = this.f326902e;
        int r104 = 8;
        if (r102 == false) goto L9;
        int r105 = 8;
    L10:
        r103.setVisibility(r105);
        ImageView r106 = this.f326903f;
        if (r102 == true) goto L14;
        r104 = r106.getVisibility();
    L14:
        r106.setVisibility(r104);
        ViewGroup.LayoutParams r107 = this.f326902e.getLayoutParams();
        LinearLayout.LayoutParams r108 = null;
        if ((r107 instanceof LinearLayout.LayoutParams) == false) goto L17;
        LinearLayout.LayoutParams r109 = (LinearLayout.LayoutParams) r107;
    L19:
        if (r109 == null) goto L26;
        if (r102 == false) goto L22;
    L24:
        int r110 = 0;
    L25:
        r109.setMarginStart(r110);
        this.f326902e.setLayoutParams(r109);
        goto L26
    L22:
        if (this.f326901d.getVisibility() != 0) goto L24;
        r110 = c(4);
    L26:
        ViewGroup.LayoutParams r111 = this.f326903f.getLayoutParams();
        if ((r111 instanceof LinearLayout.LayoutParams) == false) goto L29;
        r108 = (LinearLayout.LayoutParams) r111;
    L29:
        if (r108 == null) goto L35;
        if (r102 == false) goto L32;
    L34:
        r108.setMarginStart(r101);
        this.f326903f.setLayoutParams(r108);
        goto L35
    L32:
        if (this.f326903f.getVisibility() != 0) goto L34;
        r101 = c(4);
    L35:
        int r112 = c(this.f326899b.getContentInsetDp());
        setPadding(r112, r112, r112, r112);
        CharSequence r113 = this.f326905h;
        if (r113 != null) goto L38;
        r113 = this.f326906i;
    L38:
        setContentDescription(r113);
        return;
    L17:
        r109 = null;
        goto L19
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final CharSequence getAccessibleLabel() {
        return this.f326906i;
    }

    public final Integer getContentColor() {
        return this.f326907j;
    }

    public final CharSequence getTitle() {
        return this.f326905h;
    }

    public final int c(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void setAccessibleLabel(CharSequence r100) {
        this.f326906i = r100;
        CharSequence r101 = this.f326905h;
        if (r101 == null) goto L6;
        r100 = r101;
    L6:
        setContentDescription(r100);
    }

    public final void setContentColor(Integer r100) {
        this.f326907j = r100;
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        a();
    }

    public final void setLeadingIcon(Integer r100) {
        ImageView r101 = this.f326901d;
        int r102 = 0;
        if (r100 == null) goto L5;
        int r103 = r100.intValue();
    L6:
        r101.setImageResource(r103);
        ImageView r104 = this.f326901d;
        if (r100 != null) goto L9;
        r102 = 8;
    L9:
        r104.setVisibility(r102);
        d();
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void setLeadingIconDrawable(Drawable r100) {
        this.f326901d.setImageDrawable(r100);
        ImageView r101 = this.f326901d;
        if (r100 != null) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        d();
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void setLoading(boolean r100) {
        if (this.f326908k != r100) goto L5;
        return;
    L5:
        this.f326908k = r100;
        setEnabled(!r100);
        LinearLayout r101 = this.f326900c;
        if (this.f326908k == false) goto L8;
        int r102 = 4;
    L9:
        r101.setVisibility(r102);
        com.larus.common_ui.dbx.component.b r103 = this.f326904g;
        if (this.f326908k == false) goto L12;
        int r104 = 0;
    L13:
        r103.setVisibility(r104);
        if (this.f326908k == false) goto L16;
        com.larus.common_ui.dbx.component.b r105 = this.f326904g;
        r105.f327024d = true;
        r105.a();
    L20:
        a();
        return;
    L16:
        com.larus.common_ui.dbx.component.b r106 = this.f326904g;
        r106.f327024d = false;
        ValueAnimator r107 = r106.f327023c;
        if (r107 == null) goto L19;
        r107.cancel();
    L19:
        r106.f327023c = null;
        goto L20
    L12:
        r104 = 8;
        goto L13
    L8:
        r102 = 0;
        goto L9
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        super.setPressed(r100);
        a();
    }

    public final void setTitle(CharSequence r100) {
        this.f326905h = r100;
        d();
        a();
    }

    public final void setTrailingIcon(Integer r100) {
        ImageView r101 = this.f326903f;
        int r102 = 0;
        if (r100 == null) goto L5;
        int r103 = r100.intValue();
    L6:
        r101.setImageResource(r103);
        ImageView r104 = this.f326903f;
        if (r100 != null) goto L9;
        r102 = 8;
    L9:
        r104.setVisibility(r102);
        d();
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void setTrailingIconDrawable(Drawable r100) {
        this.f326903f.setImageDrawable(r100);
        ImageView r101 = this.f326903f;
        if (r100 != null) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        d();
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void b(Style r100, Size r101) {
        Intrinsics.checkNotNullParameter(r100, "style");
        Intrinsics.checkNotNullParameter(r101, "size");
        this.f326898a = r100;
        this.f326899b = r101;
        setMinimumHeight(c(r101.getHeightDp()));
        int r102 = c(this.f326899b.getIconSideDp());
        this.f326901d.setLayoutParams(new LinearLayout.LayoutParams(r102, r102));
        this.f326903f.setLayoutParams(new LinearLayout.LayoutParams(r102, r102));
        this.f326902e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f326902e.setTextSize(2, this.f326899b.getFontSizeSp());
        this.f326902e.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.f326904g.setLayoutParams(new FrameLayout.LayoutParams(r102, r102, 17));
        a();
        d();
    }

    public DbxButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f326898a = Style.SOLID;
        this.f326899b = Size.MD;
        LinearLayout r103 = new LinearLayout(r100);
        this.f326900c = r103;
        ImageView r104 = new ImageView(r100);
        this.f326901d = r104;
        TextView r105 = new TextView(r100);
        this.f326902e = r105;
        ImageView r106 = new ImageView(r100);
        this.f326903f = r106;
        com.larus.common_ui.dbx.component.b r107 = new com.larus.common_ui.dbx.component.b(r100);
        this.f326904g = r107;
        r103.setOrientation(0);
        r103.setGravity(17);
        r104.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r106.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r105.setGravity(17);
        r105.setMaxLines(1);
        r105.setEllipsize(TextUtils.TruncateAt.END);
        r103.addView(r104);
        r103.addView(r105);
        r103.addView(r106);
        addView(r103, new FrameLayout.LayoutParams(-2, -2, 17));
        r107.setVisibility(8);
        addView(r107, new FrameLayout.LayoutParams(c(this.f326899b.getIconSideDp()), c(this.f326899b.getIconSideDp()), 17));
        setClickable(true);
        setFocusable(true);
    }

    public /* synthetic */ DbxButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
