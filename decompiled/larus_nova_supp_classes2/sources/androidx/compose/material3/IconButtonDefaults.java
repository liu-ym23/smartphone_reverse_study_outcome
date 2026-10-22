package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.StandardIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001_B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\rJ\u0011\u0010\u0015\u001a\u00020\u0005*\u00020\u000fH\u0000¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u0018*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b\"\u0010\u001dJ\u0011\u0010#\u001a\u00020\u0018*\u00020\u000fH\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010%\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b&\u0010\rJ\r\u0010*\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010*\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b+\u0010\u001dJ\r\u0010/\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010/\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b0\u0010\rJ\r\u00103\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u00103\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b4\u0010\u001dJ\r\u00107\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u00107\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b8\u0010\rJ\u001b\u00109\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b:\u0010\u0012J\r\u0010;\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010;\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b<\u0010\rJ\u0011\u0010=\u001a\u00020\u0005*\u00020\u000fH\u0000¢\u0006\u0002\b>J\r\u0010?\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010?\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b@\u0010\u001dJ\u001b\u0010A\u001a\u00020\u0018*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\bB\u0010 J\r\u0010C\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010C\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\bD\u0010\u001dJ\u0011\u0010E\u001a\u00020\u0018*\u00020\u000fH\u0000¢\u0006\u0002\bFJ\u001f\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0002\u0010LJ\u001f\u0010M\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0002\u0010LJ\u0015\u0010N\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0007¢\u0006\u0002\u0010OJ\u0015\u0010P\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0007¢\u0006\u0002\u0010OJ\u0019\u0010Y\u001a\u00020Z2\b\b\u0002\u0010[\u001a\u00020\\H\u0000¢\u0006\u0004\b]\u0010^R\u0018\u0010'\u001a\u00020\u0005*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0018\u0010,\u001a\u00020\u0018*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0018\u00101\u001a\u00020\u0005*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)R\u0018\u00105\u001a\u00020\u0018*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010.R\u0011\u0010Q\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0011\u0010W\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bX\u0010T¨\u0006`"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "<init>", "()V", "iconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "iconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "defaultIconButtonColors", "Landroidx/compose/material3/ColorScheme;", "localContentColor", "defaultIconButtonColors-4WTKRHQ$material3", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconButtonColors;", "iconButtonVibrantColors", "iconButtonVibrantColors-ro_MJ88", "defaultIconButtonVibrantColors", "defaultIconButtonVibrantColors$material3", "iconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "iconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "defaultIconToggleButtonColors", "defaultIconToggleButtonColors-4WTKRHQ$material3", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconToggleButtonColors;", "iconToggleButtonVibrantColors", "iconToggleButtonVibrantColors-5tl4gsc", "defaultIconToggleButtonVibrantColors", "defaultIconToggleButtonVibrantColors$material3", "filledIconButtonColors", "filledIconButtonColors-ro_MJ88", "defaultFilledIconButtonColors", "getDefaultFilledIconButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "filledIconToggleButtonColors-5tl4gsc", "defaultFilledIconToggleButtonColors", "getDefaultFilledIconToggleButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "defaultFilledTonalIconButtonColors", "getDefaultFilledTonalIconButtonColors$material3", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "defaultFilledTonalIconToggleButtonColors", "getDefaultFilledTonalIconToggleButtonColors$material3", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "defaultOutlinedIconButtonColors", "defaultOutlinedIconButtonColors-4WTKRHQ$material3", "outlinedIconButtonVibrantColors", "outlinedIconButtonVibrantColors-ro_MJ88", "defaultOutlinedIconButtonVibrantColors", "defaultOutlinedIconButtonVibrantColors$material3", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "defaultOutlinedIconToggleButtonColors", "defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3", "outlinedIconToggleButtonVibrantColors", "outlinedIconToggleButtonVibrantColors-5tl4gsc", "defaultOutlinedIconToggleButtonVibrantColors", "defaultOutlinedIconToggleButtonVibrantColors$material3", "outlinedIconToggleButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonVibrantBorder", "outlinedIconButtonBorder", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonVibrantBorder", "standardShape", "Landroidx/compose/ui/graphics/Shape;", "getStandardShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledShape", "getFilledShape", "outlinedShape", "getOutlinedShape", "smallContainerSize", "Landroidx/compose/ui/unit/DpSize;", "widthOption", "Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "smallContainerSize-N-wlBFI$material3", "(I)J", "IconButtonWidthOption", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IconButtonDefaults {
    public static final int $stable = 0;
    public static final IconButtonDefaults INSTANCE = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class IconButtonWidthOption {
        public static final Companion Companion = null;
        private static final int Narrow = 0;
        private static final int Uniform = 0;
        private static final int Wide = 0;
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption$Companion;", "", "<init>", "()V", "Narrow", "Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "getNarrow-rc6NtMs", "()I", "I", "Uniform", "getUniform-rc6NtMs", "Wide", "getWide-rc6NtMs", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            /* JADX INFO: renamed from: getNarrow-rc6NtMs, reason: not valid java name */
            public final int m2770getNarrowrc6NtMs() {
                return IconButtonWidthOption.access$getNarrow$cp();
            }

            /* JADX INFO: renamed from: getUniform-rc6NtMs, reason: not valid java name */
            public final int m2771getUniformrc6NtMs() {
                return IconButtonWidthOption.access$getUniform$cp();
            }

            /* JADX INFO: renamed from: getWide-rc6NtMs, reason: not valid java name */
            public final int m2772getWiderc6NtMs() {
                return IconButtonWidthOption.access$getWide$cp();
            }
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ IconButtonWidthOption m2763boximpl(int r1) {
            return new IconButtonWidthOption(r1);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m2764constructorimpl(int r0) {
            return r0;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m2765equalsimpl(int r2, Object r3) {
            if ((r3 instanceof IconButtonWidthOption) == true) goto L6;
            return false;
        L6:
            if (r2 == ((IconButtonWidthOption) r3).m2769unboximpl()) goto L8;
            return false;
        L8:
            return true;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2766equalsimpl0(int r0, int r1) {
            if (r0 != r1) goto L4;
            return true;
        L4:
            return false;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m2767hashCodeimpl(int r0) {
            return r0;
        }

        public boolean equals(Object r2) {
            return m2765equalsimpl(this.value, r2);
        }

        public int hashCode() {
            return m2767hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m2769unboximpl() {
            return this.value;
        }

        static {
            Companion = new Companion(null);
            Narrow = m2764constructorimpl(0);
            Uniform = m2764constructorimpl(1);
            Wide = m2764constructorimpl(2);
        }

        public String toString() {
            return m2768toStringimpl(this.value);
        }

        public static final /* synthetic */ int access$getNarrow$cp() {
            return Narrow;
        }

        public static final /* synthetic */ int access$getUniform$cp() {
            return Uniform;
        }

        public static final /* synthetic */ int access$getWide$cp() {
            return Wide;
        }

        private /* synthetic */ IconButtonWidthOption(int r1) {
            this.value = r1;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2768toStringimpl(int r1) {
            if (m2766equalsimpl0(r1, Narrow) == false) goto L6;
            return "Narrow";
        L6:
            if (m2766equalsimpl0(r1, Uniform) == false) goto L9;
            return "Uniform";
        L9:
            if (m2766equalsimpl0(r1, Wide) == false) goto L11;
            return "Wide";
        L11:
            return "Unknown";
        }
    }

    static {
        INSTANCE = new IconButtonDefaults();
    }

    private IconButtonDefaults() {
    }

    public final IconButtonColors defaultIconButtonVibrantColors$material3(ColorScheme r19) {
        IconButtonColors r1 = r19.getDefaultIconButtonVibrantColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r2 = Color.Companion;
        long r3 = r2.getTransparent-0d7_KjU();
        StandardIconButtonTokens r5 = StandardIconButtonTokens.INSTANCE;
        IconButtonColors r4 = new IconButtonColors(r3, ColorSchemeKt.fromToken(r19, r5.getColor()), r2.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r5.getDisabledColor()), r5.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r19.setDefaultIconButtonVibrantColorsCached$material3(r4);
        return r4;
    L6:
        return r1;
    }

    public final IconToggleButtonColors defaultIconToggleButtonVibrantColors$material3(ColorScheme r20) {
        IconToggleButtonColors r1 = r20.getDefaultIconToggleButtonVibrantColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r2 = Color.Companion;
        long r3 = r2.getTransparent-0d7_KjU();
        StandardIconButtonTokens r5 = StandardIconButtonTokens.INSTANCE;
        IconToggleButtonColors r4 = new IconToggleButtonColors(r3, ColorSchemeKt.fromToken(r20, r5.getUnselectedColor()), r2.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r20, r5.getDisabledColor()), r5.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r2.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(r20, r5.getSelectedColor()), null);
        r20.setDefaultIconToggleButtonVibrantColorsCached$material3(r4);
        return r4;
    L6:
        return r1;
    }

    public final IconButtonColors defaultOutlinedIconButtonVibrantColors$material3(ColorScheme r19) {
        IconButtonColors r1 = r19.getDefaultOutlinedIconButtonVibrantColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r2 = Color.Companion;
        long r3 = r2.getTransparent-0d7_KjU();
        OutlinedIconButtonTokens r5 = OutlinedIconButtonTokens.INSTANCE;
        IconButtonColors r4 = new IconButtonColors(r3, ColorSchemeKt.fromToken(r19, r5.getColor()), r2.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r5.getDisabledColor()), r5.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r19.setDefaultOutlinedIconButtonVibrantColorsCached$material3(r4);
        return r4;
    L6:
        return r1;
    }

    public final IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColors$material3(ColorScheme r19) {
        IconToggleButtonColors r1 = r19.getDefaultOutlinedIconToggleButtonVibrantColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r2 = Color.Companion;
        long r3 = r2.getTransparent-0d7_KjU();
        OutlinedIconButtonTokens r5 = OutlinedIconButtonTokens.INSTANCE;
        IconToggleButtonColors r4 = new IconToggleButtonColors(r3, ColorSchemeKt.fromToken(r19, r5.getUnselectedColor()), r2.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r5.getDisabledColor()), r5.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r19, r5.getSelectedContainerColor()), ColorSchemeKt.fromToken(r19, r5.getSelectedColor()), null);
        r19.setDefaultOutlinedIconToggleButtonColorsCached$material3(r4);
        return r4;
    L6:
        return r1;
    }

    public final IconButtonColors getDefaultFilledIconButtonColors$material3(ColorScheme r19) {
        IconButtonColors r1 = r19.getDefaultFilledIconButtonColorsCached$material3();
        if (r1 != null) goto L6;
        FilledIconButtonTokens r2 = FilledIconButtonTokens.INSTANCE;
        IconButtonColors r3 = new IconButtonColors(ColorSchemeKt.fromToken(r19, r2.getContainerColor()), ColorSchemeKt.fromToken(r19, r2.getColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledContainerColor()), r2.getDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledColor()), r2.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r19.setDefaultFilledIconButtonColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColors$material3(ColorScheme r19) {
        IconToggleButtonColors r1 = r19.getDefaultFilledIconToggleButtonColorsCached$material3();
        if (r1 != null) goto L6;
        FilledIconButtonTokens r2 = FilledIconButtonTokens.INSTANCE;
        IconToggleButtonColors r3 = new IconToggleButtonColors(ColorSchemeKt.fromToken(r19, r2.getUnselectedContainerColor()), ColorSchemeKt.fromToken(r19, r2.getUnselectedColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledContainerColor()), r2.getDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledColor()), r2.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r19, r2.getSelectedContainerColor()), ColorSchemeKt.fromToken(r19, r2.getSelectedColor()), null);
        r19.setDefaultFilledIconToggleButtonColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final IconButtonColors getDefaultFilledTonalIconButtonColors$material3(ColorScheme r19) {
        IconButtonColors r1 = r19.getDefaultFilledTonalIconButtonColorsCached$material3();
        if (r1 != null) goto L6;
        FilledTonalIconButtonTokens r2 = FilledTonalIconButtonTokens.INSTANCE;
        IconButtonColors r3 = new IconButtonColors(ColorSchemeKt.fromToken(r19, r2.getContainerColor()), ColorSchemeKt.fromToken(r19, r2.getColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledContainerColor()), r2.getDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledColor()), r2.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r19.setDefaultFilledTonalIconButtonColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColors$material3(ColorScheme r19) {
        IconToggleButtonColors r1 = r19.getDefaultFilledTonalIconToggleButtonColorsCached$material3();
        if (r1 != null) goto L6;
        FilledTonalIconButtonTokens r2 = FilledTonalIconButtonTokens.INSTANCE;
        IconToggleButtonColors r3 = new IconToggleButtonColors(ColorSchemeKt.fromToken(r19, r2.getUnselectedContainerColor()), ColorSchemeKt.fromToken(r19, r2.getUnselectedColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledContainerColor()), r2.getDisabledContainerOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r19, r2.getDisabledColor()), r2.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r19, r2.getSelectedContainerColor()), ColorSchemeKt.fromToken(r19, r2.getSelectedColor()), null);
        r19.setDefaultFilledTonalIconToggleButtonColorsCached$material3(r3);
        return r3;
    L6:
        return r1;
    }

    /* JADX INFO: renamed from: smallContainerSize-N-wlBFI$material3, reason: not valid java name */
    public final long m2762smallContainerSizeNwlBFI$material3(int r3) {
        IconButtonWidthOption.Companion r0 = IconButtonWidthOption.Companion;
        if (IconButtonWidthOption.m2766equalsimpl0(r3, r0.m2770getNarrowrc6NtMs()) == false) goto L6;
        SmallIconButtonTokens r4 = SmallIconButtonTokens.INSTANCE;
        float r5 = Dp.constructor-impl(r4.getNarrowLeadingSpace-D9Ej5fM() + r4.getNarrowTrailingSpace-D9Ej5fM());
    L12:
        SmallIconButtonTokens r1 = SmallIconButtonTokens.INSTANCE;
        return DpKt.DpSize-YgX7TsA(Dp.constructor-impl(r1.getIconSize-D9Ej5fM() + r5), r1.getContainerHeight-D9Ej5fM());
    L6:
        if (IconButtonWidthOption.m2766equalsimpl0(r3, r0.m2771getUniformrc6NtMs()) == false) goto L9;
        SmallIconButtonTokens r6 = SmallIconButtonTokens.INSTANCE;
        r5 = Dp.constructor-impl(r6.getDefaultLeadingSpace-D9Ej5fM() + r6.getDefaultLeadingSpace-D9Ej5fM());
        goto L12
    L9:
        if (IconButtonWidthOption.m2766equalsimpl0(r3, r0.m2772getWiderc6NtMs()) == false) goto L11;
        SmallIconButtonTokens r7 = SmallIconButtonTokens.INSTANCE;
        r5 = Dp.constructor-impl(r7.getWideLeadingSpace-D9Ej5fM() + r7.getWideTrailingSpace-D9Ej5fM());
        goto L12
    L11:
        r5 = Dp.constructor-impl(0);
        goto L12
    }

    /* JADX INFO: renamed from: defaultIconButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconButtonColors m2746defaultIconButtonColors4WTKRHQ$material3(ColorScheme r17, long r18) {
        IconButtonColors r0 = r17.getDefaultIconButtonColorsCached$material3();
        if (r0 != null) goto L6;
        Color.Companion r1 = Color.Companion;
        IconButtonColors r2 = new IconButtonColors(r1.getTransparent-0d7_KjU(), r18, r1.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(r18, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r17.setDefaultIconButtonColorsCached$material3(r2);
        return r2;
    L6:
        return r0;
    }

    /* JADX INFO: renamed from: defaultIconToggleButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconToggleButtonColors m2747defaultIconToggleButtonColors4WTKRHQ$material3(ColorScheme r18, long r19) {
        IconToggleButtonColors r1 = r18.getDefaultIconToggleButtonColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r2 = Color.Companion;
        long r3 = r2.getTransparent-0d7_KjU();
        long r7 = r2.getTransparent-0d7_KjU();
        StandardIconButtonTokens r5 = StandardIconButtonTokens.INSTANCE;
        IconToggleButtonColors r4 = new IconToggleButtonColors(r3, r19, r7, Color.copy-wmQWz5c$default(r19, r5.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r2.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(r18, r5.getSelectedColor()), null);
        r18.setDefaultIconToggleButtonColorsCached$material3(r4);
        return r4;
    L6:
        return r1;
    }

    /* JADX INFO: renamed from: defaultOutlinedIconButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconButtonColors m2748defaultOutlinedIconButtonColors4WTKRHQ$material3(ColorScheme r17, long r18) {
        IconButtonColors r0 = r17.getDefaultOutlinedIconButtonColorsCached$material3();
        if (r0 != null) goto L6;
        Color.Companion r1 = Color.Companion;
        IconButtonColors r2 = new IconButtonColors(r1.getTransparent-0d7_KjU(), r18, r1.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(r18, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r17.setDefaultOutlinedIconButtonColorsCached$material3(r2);
        return r2;
    L6:
        return r0;
    }

    /* JADX INFO: renamed from: defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconToggleButtonColors m2749defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(ColorScheme r18, long r19) {
        IconToggleButtonColors r1 = r18.getDefaultIconToggleButtonColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r2 = Color.Companion;
        long r3 = r2.getTransparent-0d7_KjU();
        long r7 = r2.getTransparent-0d7_KjU();
        OutlinedIconButtonTokens r4 = OutlinedIconButtonTokens.INSTANCE;
        IconToggleButtonColors r5 = new IconToggleButtonColors(r3, r19, r7, Color.copy-wmQWz5c$default(r19, r4.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), ColorSchemeKt.fromToken(r18, r4.getSelectedContainerColor()), ColorSchemeKt.m2495contentColorFor4WTKRHQ(r18, ColorSchemeKt.fromToken(r18, r4.getSelectedContainerColor())), null);
        r18.setDefaultOutlinedIconToggleButtonColorsCached$material3(r5);
        return r5;
    L6:
        return r1;
    }

    public final IconButtonColors filledIconButtonColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-958304265, r5, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButtonDefaults.kt:300)");
    L5:
        IconButtonColors r6 = getDefaultFilledIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final IconToggleButtonColors filledIconToggleButtonColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1455160689, r5, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButtonDefaults.kt:346)");
    L5:
        IconToggleButtonColors r6 = getDefaultFilledIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final IconButtonColors filledTonalIconButtonColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1145002745, r5, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButtonDefaults.kt:407)");
    L5:
        IconButtonColors r6 = getDefaultFilledTonalIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final IconToggleButtonColors filledTonalIconToggleButtonColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(656374417, r5, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButtonDefaults.kt:454)");
    L5:
        IconToggleButtonColors r6 = getDefaultFilledTonalIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getFilledShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1542796069, r5, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButtonDefaults.kt:853)");
    L5:
        Shape r6 = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getOutlinedShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1706356635, r5, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButtonDefaults.kt:857)");
    L5:
        Shape r6 = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getStandardShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-377108005, r5, -1, "androidx.compose.material3.IconButtonDefaults.<get-standardShape> (IconButtonDefaults.kt:849)");
    L5:
        Shape r6 = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final IconButtonColors iconButtonColors(Composer r21, int r22) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1037266503, r22, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButtonDefaults.kt:42)");
    L5:
        long r10 = ((Color) r21.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        IconButtonColors r0 = m2746defaultIconButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(r21, 6), r10);
        if (Color.equals-impl0(r0.m2742getContentColor0d7_KjU(), r10) == true) goto L10;
        r0 = IconButtonColors.m2737copyjRlVdoo$default(r0, 0, r10, 0, Color.copy-wmQWz5c$default(r10, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), 5, null);
    L10:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        return r0;
    }

    public final IconButtonColors iconButtonVibrantColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(111454247, r5, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonVibrantColors (IconButtonDefaults.kt:110)");
    L5:
        IconButtonColors r6 = defaultIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final IconToggleButtonColors iconToggleButtonColors(Composer r27, int r28) {
        r27.startReplaceGroup(-1355771567);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1355771567, r28, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButtonDefaults.kt:164)");
    L5:
        long r10 = ((Color) r27.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        IconToggleButtonColors r1 = m2747defaultIconToggleButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(r27, 6), r10);
        if (Color.equals-impl0(r1.m2782getContentColor0d7_KjU(), r10) == true) goto L8;
        IconToggleButtonColors r2 = IconToggleButtonColors.m2777copytNS2XkQ$default(r1, 0, r10, 0, Color.copy-wmQWz5c$default(r10, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), 0, 0, 53, null);
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        r27.endReplaceGroup();
        return r2;
    L8:
        if (ComposerKt.isTraceInProgress() == false) goto L10;
        ComposerKt.traceEventEnd();
    L10:
        r27.endReplaceGroup();
        return r1;
    }

    public final IconToggleButtonColors iconToggleButtonVibrantColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1755001127, r5, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonVibrantColors (IconButtonDefaults.kt:241)");
    L5:
        IconToggleButtonColors r6 = defaultIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final IconButtonColors outlinedIconButtonColors(Composer r22, int r23) {
        r22.startReplaceGroup(1591384183);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1591384183, r23, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButtonDefaults.kt:513)");
    L5:
        long r10 = ((Color) r22.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        IconButtonColors r1 = m2748defaultOutlinedIconButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(r22, 6), r10);
        if (Color.equals-impl0(r1.m2742getContentColor0d7_KjU(), r10) == true) goto L8;
        IconButtonColors r2 = IconButtonColors.m2737copyjRlVdoo$default(r1, 0, r10, 0, Color.copy-wmQWz5c$default(r10, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), 5, null);
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        r22.endReplaceGroup();
        return r2;
    L8:
        if (ComposerKt.isTraceInProgress() == false) goto L10;
        ComposerKt.traceEventEnd();
    L10:
        r22.endReplaceGroup();
        return r1;
    }

    public final IconButtonColors outlinedIconButtonVibrantColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-899469399, r5, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantColors (IconButtonDefaults.kt:581)");
    L5:
        IconButtonColors r6 = defaultOutlinedIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonColors(Composer r27, int r28) {
        r27.startReplaceGroup(-834376945);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-834376945, r28, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButtonDefaults.kt:636)");
    L5:
        long r10 = ((Color) r27.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        IconToggleButtonColors r1 = m2749defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(r27, 6), r10);
        if (Color.equals-impl0(r1.m2782getContentColor0d7_KjU(), r10) == true) goto L8;
        IconToggleButtonColors r2 = IconToggleButtonColors.m2777copytNS2XkQ$default(r1, 0, r10, 0, Color.copy-wmQWz5c$default(r10, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), 0, 0, 53, null);
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        r27.endReplaceGroup();
        return r2;
    L8:
        if (ComposerKt.isTraceInProgress() == false) goto L10;
        ComposerKt.traceEventEnd();
    L10:
        r27.endReplaceGroup();
        return r1;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonVibrantColors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1236236887, r5, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantColors (IconButtonDefaults.kt:719)");
    L5:
        IconToggleButtonColors r6 = defaultOutlinedIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final BorderStroke outlinedIconButtonBorder(boolean r9, Composer r10, int r11) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1270640488, r11, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButtonDefaults.kt:818)");
    L5:
        long r0 = ((Color) r10.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        if (r9 == true) goto L9;
        r0 = Color.copy-wmQWz5c$default(r0, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L9:
        boolean r12 = r10.changed(r0);
        Object r13 = r10.rememberedValue();
        if (r12 == false) goto L12;
    L13:
        r13 = BorderStrokeKt.m369BorderStrokecXLIe8U(SmallIconButtonTokens.INSTANCE.getOutlinedOutlineWidth-D9Ej5fM(), r0);
        r10.updateRememberedValue(r13);
    L14:
        BorderStroke r14 = (BorderStroke) r13;
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        return r14;
    L12:
        if (r13 != Composer.Companion.getEmpty()) goto L14;
        goto L13
    }

    public final BorderStroke outlinedIconButtonVibrantBorder(boolean r11, Composer r12, int r13) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2139728858, r13, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantBorder (IconButtonDefaults.kt:836)");
    L5:
        OutlinedIconButtonTokens r14 = OutlinedIconButtonTokens.INSTANCE;
        long r2 = ColorSchemeKt.getValue(r14.getOutlineColor(), r12, 6);
        if (r11 == true) goto L9;
        r2 = Color.copy-wmQWz5c$default(r2, r14.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L9:
        boolean r15 = r12.changed(r2);
        Object r16 = r12.rememberedValue();
        if (r15 == false) goto L12;
    L13:
        r16 = BorderStrokeKt.m369BorderStrokecXLIe8U(SmallIconButtonTokens.INSTANCE.getOutlinedOutlineWidth-D9Ej5fM(), r2);
        r12.updateRememberedValue(r16);
    L14:
        BorderStroke r17 = (BorderStroke) r16;
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        return r17;
    L12:
        if (r16 != Composer.Companion.getEmpty()) goto L14;
        goto L13
    }

    /* JADX INFO: renamed from: smallContainerSize-N-wlBFI$material3$default, reason: not valid java name */
    public static /* synthetic */ long m2745smallContainerSizeNwlBFI$material3$default(IconButtonDefaults r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = IconButtonWidthOption.Companion.m2771getUniformrc6NtMs();
    L6:
        return r0.m2762smallContainerSizeNwlBFI$material3(r1);
    }

    public final BorderStroke outlinedIconToggleButtonBorder(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(1933433512);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1933433512, r7, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButtonDefaults.kt:786)");
    L5:
        if (r5 == true) goto L7;
        BorderStroke r8 = outlinedIconButtonBorder(r4, r6, (r7 & 14) | ((r7 >> 3) & 112));
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        r6.endReplaceGroup();
        return r8;
    L7:
        if (ComposerKt.isTraceInProgress() == false) goto L9;
        ComposerKt.traceEventEnd();
    L9:
        r6.endReplaceGroup();
        return null;
    }

    public final BorderStroke outlinedIconToggleButtonVibrantBorder(boolean r4, boolean r5, Composer r6, int r7) {
        r6.startReplaceGroup(394022990);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(394022990, r7, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantBorder (IconButtonDefaults.kt:801)");
    L5:
        if (r5 == true) goto L7;
        BorderStroke r8 = outlinedIconButtonVibrantBorder(r4, r6, (r7 & 14) | ((r7 >> 3) & 112));
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        r6.endReplaceGroup();
        return r8;
    L7:
        if (ComposerKt.isTraceInProgress() == false) goto L9;
        ComposerKt.traceEventEnd();
    L9:
        r6.endReplaceGroup();
        return null;
    }

    /* JADX INFO: renamed from: filledIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2750filledIconButtonColorsro_MJ88(long r14, long r16, long r18, long r20, Composer r22, int r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r4 = ColorSchemeKt.m2496contentColorForek8zF_U(r2, r22, r23 & 14);
    L11:
        if ((r24 & 4) == 0) goto L13;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r24 & 8) == 0) goto L17;
        long r8 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-245481051, r23, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButtonDefaults.kt:317)");
    L21:
        IconButtonColors r0 = getDefaultFilledIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r22, 6)).m2740copyjRlVdoo(r2, r4, r6, r8);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r0;
    L17:
        r8 = r20;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    /* JADX INFO: renamed from: filledTonalIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2752filledTonalIconButtonColorsro_MJ88(long r14, long r16, long r18, long r20, Composer r22, int r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r4 = ColorSchemeKt.m2496contentColorForek8zF_U(r2, r22, r23 & 14);
    L11:
        if ((r24 & 4) == 0) goto L13;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r24 & 8) == 0) goto L17;
        long r8 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(562762851, r23, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButtonDefaults.kt:425)");
    L21:
        IconButtonColors r0 = getDefaultFilledTonalIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r22, 6)).m2740copyjRlVdoo(r2, r4, r6, r8);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r0;
    L17:
        r8 = r20;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    /* JADX INFO: renamed from: iconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2754iconButtonColorsro_MJ88(long r14, long r16, long r18, long r20, Composer r22, int r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r3 = ((Color) r22.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L11:
        if ((r24 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r24 & 8) == 0) goto L17;
        long r15 = r3;
        long r7 = Color.copy-wmQWz5c$default(r15, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-1639168605, r23, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButtonDefaults.kt:78)");
    L21:
        IconButtonColors r2 = m2746defaultIconButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(r22, 6), ((Color) r22.consume(ContentColorKt.getLocalContentColor())).unbox-impl()).m2740copyjRlVdoo(r1, r3, r5, r7);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r2;
    L17:
        r7 = r20;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }

    /* JADX INFO: renamed from: iconButtonVibrantColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2755iconButtonVibrantColorsro_MJ88(long r13, long r15, long r17, long r19, Composer r21, int r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r23 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r14 = r2;
        long r6 = Color.copy-wmQWz5c$default(r14, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(1036440437, r22, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonVibrantColors (IconButtonDefaults.kt:132)");
    L21:
        IconButtonColors r1 = defaultIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(r21, 6)).m2740copyjRlVdoo(r0, r2, r4, r6);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r1;
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: outlinedIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2758outlinedIconButtonColorsro_MJ88(long r14, long r16, long r18, long r20, Composer r22, int r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r3 = ((Color) r22.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L11:
        if ((r24 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r24 & 8) == 0) goto L17;
        long r15 = r3;
        long r7 = Color.copy-wmQWz5c$default(r15, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-1335916251, r23, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButtonDefaults.kt:547)");
    L21:
        IconButtonColors r2 = m2748defaultOutlinedIconButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(r22, 6), ((Color) r22.consume(ContentColorKt.getLocalContentColor())).unbox-impl()).m2740copyjRlVdoo(r1, r3, r5, r7);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r2;
    L17:
        r7 = r20;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }

    /* JADX INFO: renamed from: outlinedIconButtonVibrantColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m2759outlinedIconButtonVibrantColorsro_MJ88(long r13, long r15, long r17, long r19, Composer r21, int r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r23 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r14 = r2;
        long r6 = Color.copy-wmQWz5c$default(r14, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(-278201933, r22, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantColors (IconButtonDefaults.kt:603)");
    L21:
        IconButtonColors r1 = defaultOutlinedIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(r21, 6)).m2740copyjRlVdoo(r0, r2, r4, r6);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r1;
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r15;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }

    /* JADX INFO: renamed from: filledIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2751filledIconToggleButtonColors5tl4gsc(long r19, long r21, long r23, long r25, long r27, long r29, Composer r31, int r32, int r33) {
        if ((r33 & 1) == 0) goto L5;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r8 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r33 & 16) == 0) goto L21;
        long r10 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r33 & 32) == 0) goto L25;
        long r12 = ColorSchemeKt.m2496contentColorForek8zF_U(r10, r31, (r32 >> 12) & 14);
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventStart(1473292947, r32, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButtonDefaults.kt:370)");
    L30:
        IconToggleButtonColors r0 = getDefaultFilledIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r31, 6)).m2778copytNS2XkQ(r2, r4, r6, r8, r10, r12);
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
    L33:
        return r0;
    L25:
        r12 = r29;
        goto L27
    L21:
        r10 = r27;
        goto L23
    L17:
        r8 = r25;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r4 = r21;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }

    /* JADX INFO: renamed from: filledTonalIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2753filledTonalIconToggleButtonColors5tl4gsc(long r19, long r21, long r23, long r25, long r27, long r29, Composer r31, int r32, int r33) {
        if ((r33 & 1) == 0) goto L5;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r4 = ColorSchemeKt.m2496contentColorForek8zF_U(r2, r31, r32 & 14);
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r8 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r33 & 16) == 0) goto L21;
        long r10 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r33 & 32) == 0) goto L25;
        long r12 = ColorSchemeKt.m2496contentColorForek8zF_U(r10, r31, (r32 >> 12) & 14);
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventStart(2130748241, r32, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButtonDefaults.kt:476)");
    L30:
        IconToggleButtonColors r0 = getDefaultFilledTonalIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(r31, 6)).m2778copytNS2XkQ(r2, r4, r6, r8, r10, r12);
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
    L33:
        return r0;
    L25:
        r12 = r29;
        goto L27
    L21:
        r10 = r27;
        goto L23
    L17:
        r8 = r25;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r4 = r21;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }

    /* JADX INFO: renamed from: iconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2756iconToggleButtonColors5tl4gsc(long r19, long r21, long r23, long r25, long r27, long r29, Composer r31, int r32, int r33) {
        if ((r33 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r3 = ((Color) r31.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r110 = r3;
        long r7 = Color.copy-wmQWz5c$default(r110, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if ((r33 & 16) == 0) goto L21;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r33 & 32) == 0) goto L25;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventStart(1402082449, r32, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButtonDefaults.kt:203)");
    L30:
        IconToggleButtonColors r2 = m2747defaultIconToggleButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(r31, 6), ((Color) r31.consume(ContentColorKt.getLocalContentColor())).unbox-impl()).m2778copytNS2XkQ(r1, r3, r5, r7, r9, r11);
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
    L33:
        return r2;
    L25:
        r11 = r29;
        goto L27
    L21:
        r9 = r27;
        goto L23
    L17:
        r7 = r25;
        goto L19
    L13:
        r5 = r23;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }

    /* JADX INFO: renamed from: iconToggleButtonVibrantColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2757iconToggleButtonVibrantColors5tl4gsc(long r17, long r19, long r21, long r23, long r25, long r27, Composer r29, int r30, int r31) {
        if ((r31 & 1) == 0) goto L5;
        long r0 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r31 & 2) == 0) goto L9;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r31 & 4) == 0) goto L13;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r31 & 8) == 0) goto L17;
        long r18 = r2;
        long r6 = Color.copy-wmQWz5c$default(r18, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if ((r31 & 16) == 0) goto L21;
        long r8 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r31 & 32) == 0) goto L25;
        long r10 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(-1027328773, r30, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonVibrantColors (IconButtonDefaults.kt:267)");
    L29:
        IconToggleButtonColors r1 = defaultIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(r29, 6)).m2778copytNS2XkQ(r0, r2, r4, r6, r8, r10);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
    L32:
        return r1;
    L25:
        r10 = r27;
        goto L27
    L21:
        r8 = r25;
        goto L23
    L17:
        r6 = r23;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r2 = r19;
        goto L11
    L5:
        r0 = r17;
        goto L7
    }

    /* JADX INFO: renamed from: outlinedIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2760outlinedIconToggleButtonColors5tl4gsc(long r19, long r21, long r23, long r25, long r27, long r29, Composer r31, int r32, int r33) {
        if ((r33 & 1) == 0) goto L5;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r4 = ((Color) r31.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r110 = r4;
        long r8 = Color.copy-wmQWz5c$default(r110, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if ((r33 & 16) == 0) goto L21;
        long r10 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r33 & 32) == 0) goto L25;
        long r12 = ColorSchemeKt.m2496contentColorForek8zF_U(r10, r31, (r32 >> 12) & 14);
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventStart(-514625005, r32, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButtonDefaults.kt:675)");
    L30:
        IconToggleButtonColors r1 = m2749defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(r31, 6), ((Color) r31.consume(ContentColorKt.getLocalContentColor())).unbox-impl()).m2778copytNS2XkQ(r2, r4, r6, r8, r10, r12);
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
    L33:
        return r1;
    L25:
        r12 = r29;
        goto L27
    L21:
        r10 = r27;
        goto L23
    L17:
        r8 = r25;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r4 = r21;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }

    /* JADX INFO: renamed from: outlinedIconToggleButtonVibrantColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m2761outlinedIconToggleButtonVibrantColors5tl4gsc(long r19, long r21, long r23, long r25, long r27, long r29, Composer r31, int r32, int r33) {
        if ((r33 & 1) == 0) goto L5;
        long r2 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r4 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r6 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r110 = r4;
        long r8 = Color.copy-wmQWz5c$default(r110, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L19:
        if ((r33 & 16) == 0) goto L21;
        long r10 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r33 & 32) == 0) goto L25;
        long r12 = ColorSchemeKt.m2496contentColorForek8zF_U(r10, r31, (r32 >> 12) & 14);
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventStart(-142016199, r32, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantColors (IconButtonDefaults.kt:745)");
    L30:
        IconToggleButtonColors r0 = defaultOutlinedIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(r31, 6)).m2778copytNS2XkQ(r2, r4, r6, r8, r10, r12);
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
    L33:
        return r0;
    L25:
        r12 = r29;
        goto L27
    L21:
        r10 = r27;
        goto L23
    L17:
        r8 = r25;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r4 = r21;
        goto L11
    L5:
        r2 = r19;
        goto L7
    }
}
