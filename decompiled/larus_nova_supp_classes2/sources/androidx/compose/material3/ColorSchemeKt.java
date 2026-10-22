package androidx.compose.material3;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aí\u0003\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\b3\u00104\u001aí\u0003\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\b6\u00104\u001a\u001b\u00107\u001a\u00020\u0003*\u00020\u00012\u0006\u00108\u001a\u00020\u0003H\u0007¢\u0006\u0004\b9\u0010:\u001a\u0017\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0007¢\u0006\u0004\b;\u0010<\u001a\u001b\u0010=\u001a\u00020\u0003*\u00020\u00012\u0006\u0010>\u001a\u00020?H\u0007¢\u0006\u0004\b@\u0010A\u001a\b\u0010B\u001a\u00020\u0001H\u0000\u001a÷\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bC\u0010D\u001a±\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bE\u0010F\u001a÷\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bG\u0010D\u001a±\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bH\u0010F\u001a\u0019\u0010I\u001a\u00020\u0003*\u00020\u00012\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001a#\u0010U\u001a\u00020\u0003*\u00020\u00012\u0006\u00108\u001a\u00020\u00032\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0004\bV\u0010W\"\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010NX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P\"\u000e\u0010Q\u001a\u00020RX\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010J\u001a\u00020\u0003*\u00020K8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T\"\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0N¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010P¨\u0006["}, d2 = {"lightColorScheme", "Landroidx/compose/material3/ColorScheme;", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "primaryFixed", "primaryFixedDim", "onPrimaryFixed", "onPrimaryFixedVariant", "secondaryFixed", "secondaryFixedDim", "onSecondaryFixed", "onSecondaryFixedVariant", "tertiaryFixed", "tertiaryFixedDim", "onTertiaryFixed", "onTertiaryFixedVariant", "lightColorScheme-_VG5OTI", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme", "darkColorScheme-_VG5OTI", "contentColorFor", "backgroundColor", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "surfaceColorAtElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "expressiveLightColorScheme", "lightColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme-C-Xl9yA", "darkColorScheme-G1PFc-w", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DisabledAlpha", "", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "applyTonalElevation", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "LocalTonalElevationEnabled", "", "getLocalTonalElevationEnabled", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = null;
    private static final ProvidableCompositionLocal<Boolean> LocalTonalElevationEnabled = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ColorSchemeKeyTokens.values().length];
            r0[ColorSchemeKeyTokens.Background.ordinal()] = 1;     // Catch: NoSuchFieldError -> L53
        L131:
            r0[ColorSchemeKeyTokens.Error.ordinal()] = 2;     // Catch: NoSuchFieldError -> L54
        L149:
            r0[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;     // Catch: NoSuchFieldError -> L55
        L161:
            r0[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;     // Catch: NoSuchFieldError -> L56
        L165:
            r0[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;     // Catch: NoSuchFieldError -> L57
        L175:
            r0[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;     // Catch: NoSuchFieldError -> L58
        L189:
            r0[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;     // Catch: NoSuchFieldError -> L59
        L119:
            r0[ColorSchemeKeyTokens.OnError.ordinal()] = 8;     // Catch: NoSuchFieldError -> L60
        L135:
            r0[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;     // Catch: NoSuchFieldError -> L61
        L139:
            r0[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;     // Catch: NoSuchFieldError -> L62
        L155:
            r0[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;     // Catch: NoSuchFieldError -> L63
        L181:
            r0[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;     // Catch: NoSuchFieldError -> L64
        L195:
            r0[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;     // Catch: NoSuchFieldError -> L65
        L103:
            r0[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;     // Catch: NoSuchFieldError -> L66
        L115:
            r0[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;     // Catch: NoSuchFieldError -> L67
        L145:
            r0[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;     // Catch: NoSuchFieldError -> L68
        L159:
            r0[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;     // Catch: NoSuchFieldError -> L69
        L163:
            r0[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;     // Catch: NoSuchFieldError -> L70
        L177:
            r0[ColorSchemeKeyTokens.Outline.ordinal()] = 19;     // Catch: NoSuchFieldError -> L71
        L107:
            r0[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;     // Catch: NoSuchFieldError -> L72
        L123:
            r0[ColorSchemeKeyTokens.Primary.ordinal()] = 21;     // Catch: NoSuchFieldError -> L73
        L125:
            r0[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;     // Catch: NoSuchFieldError -> L74
        L141:
            r0[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;     // Catch: NoSuchFieldError -> L75
        L169:
            r0[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;     // Catch: NoSuchFieldError -> L76
        L183:
            r0[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;     // Catch: NoSuchFieldError -> L77
        L185:
            r0[ColorSchemeKeyTokens.Surface.ordinal()] = 26;     // Catch: NoSuchFieldError -> L78
        L105:
            r0[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;     // Catch: NoSuchFieldError -> L79
        L129:
            r0[ColorSchemeKeyTokens.SurfaceBright.ordinal()] = 28;     // Catch: NoSuchFieldError -> L80
        L147:
            r0[ColorSchemeKeyTokens.SurfaceContainer.ordinal()] = 29;     // Catch: NoSuchFieldError -> L81
        L151:
            r0[ColorSchemeKeyTokens.SurfaceContainerHigh.ordinal()] = 30;     // Catch: NoSuchFieldError -> L82
        L167:
            r0[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 31;     // Catch: NoSuchFieldError -> L83
        L191:
            r0[ColorSchemeKeyTokens.SurfaceContainerLow.ordinal()] = 32;     // Catch: NoSuchFieldError -> L84
        L109:
            r0[ColorSchemeKeyTokens.SurfaceContainerLowest.ordinal()] = 33;     // Catch: NoSuchFieldError -> L85
        L111:
            r0[ColorSchemeKeyTokens.SurfaceDim.ordinal()] = 34;     // Catch: NoSuchFieldError -> L86
        L127:
            r0[ColorSchemeKeyTokens.Tertiary.ordinal()] = 35;     // Catch: NoSuchFieldError -> L87
        L157:
            r0[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 36;     // Catch: NoSuchFieldError -> L88
        L171:
            r0[ColorSchemeKeyTokens.PrimaryFixed.ordinal()] = 37;     // Catch: NoSuchFieldError -> L89
        L173:
            r0[ColorSchemeKeyTokens.PrimaryFixedDim.ordinal()] = 38;     // Catch: NoSuchFieldError -> L90
        L187:
            r0[ColorSchemeKeyTokens.OnPrimaryFixed.ordinal()] = 39;     // Catch: NoSuchFieldError -> L91
        L117:
            r0[ColorSchemeKeyTokens.OnPrimaryFixedVariant.ordinal()] = 40;     // Catch: NoSuchFieldError -> L92
        L133:
            r0[ColorSchemeKeyTokens.SecondaryFixed.ordinal()] = 41;     // Catch: NoSuchFieldError -> L93
        L137:
            r0[ColorSchemeKeyTokens.SecondaryFixedDim.ordinal()] = 42;     // Catch: NoSuchFieldError -> L94
        L153:
            r0[ColorSchemeKeyTokens.OnSecondaryFixed.ordinal()] = 43;     // Catch: NoSuchFieldError -> L95
        L179:
            r0[ColorSchemeKeyTokens.OnSecondaryFixedVariant.ordinal()] = 44;     // Catch: NoSuchFieldError -> L96
        L193:
            r0[ColorSchemeKeyTokens.TertiaryFixed.ordinal()] = 45;     // Catch: NoSuchFieldError -> L97
        L101:
            r0[ColorSchemeKeyTokens.TertiaryFixedDim.ordinal()] = 46;     // Catch: NoSuchFieldError -> L98
        L113:
            r0[ColorSchemeKeyTokens.OnTertiaryFixed.ordinal()] = 47;     // Catch: NoSuchFieldError -> L99
        L143:
            r0[ColorSchemeKeyTokens.OnTertiaryFixedVariant.ordinal()] = 48;     // Catch: NoSuchFieldError -> L100
        L51:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private static final boolean LocalTonalElevationEnabled$lambda$2() {
        return true;
    }

    public static /* synthetic */ boolean a() {
        return LocalTonalElevationEnabled$lambda$2();
    }

    public static /* synthetic */ ColorScheme b() {
        return LocalColorScheme$lambda$1();
    }

    static {
        LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new g4());
        LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf(new h4());
    }

    private static final ColorScheme LocalColorScheme$lambda$1() {
        return m2508lightColorScheme_VG5OTI$default(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 65535, null);
    }

    public static final ColorScheme expressiveLightColorScheme() {
        PaletteTokens r50 = PaletteTokens.INSTANCE;
        return m2508lightColorScheme_VG5OTI$default(0, 0, 0, r50.getPrimary30-0d7_KjU(), 0, 0, 0, 0, r50.getSecondary30-0d7_KjU(), 0, 0, 0, r50.getTertiary30-0d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r50.getError30-0d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -33558793, 65535, null);
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalTonalElevationEnabled() {
        return LocalTonalElevationEnabled;
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m2495contentColorFor4WTKRHQ(ColorScheme r2, long r3) {
        if (Color.equals-impl0(r3, r2.m2471getPrimary0d7_KjU()) == false) goto L6;
        return r2.m2455getOnPrimary0d7_KjU();
    L6:
        if (Color.equals-impl0(r3, r2.m2476getSecondary0d7_KjU()) == false) goto L9;
        return r2.m2459getOnSecondary0d7_KjU();
    L9:
        if (Color.equals-impl0(r3, r2.m2490getTertiary0d7_KjU()) == false) goto L12;
        return r2.m2465getOnTertiary0d7_KjU();
    L12:
        if (Color.equals-impl0(r3, r2.m2446getBackground0d7_KjU()) == false) goto L15;
        return r2.m2452getOnBackground0d7_KjU();
    L15:
        if (Color.equals-impl0(r3, r2.m2447getError0d7_KjU()) == false) goto L18;
        return r2.m2453getOnError0d7_KjU();
    L18:
        if (Color.equals-impl0(r3, r2.m2472getPrimaryContainer0d7_KjU()) == false) goto L21;
        return r2.m2456getOnPrimaryContainer0d7_KjU();
    L21:
        if (Color.equals-impl0(r3, r2.m2477getSecondaryContainer0d7_KjU()) == false) goto L24;
        return r2.m2460getOnSecondaryContainer0d7_KjU();
    L24:
        if (Color.equals-impl0(r3, r2.m2491getTertiaryContainer0d7_KjU()) == false) goto L27;
        return r2.m2466getOnTertiaryContainer0d7_KjU();
    L27:
        if (Color.equals-impl0(r3, r2.m2448getErrorContainer0d7_KjU()) == false) goto L30;
        return r2.m2454getOnErrorContainer0d7_KjU();
    L30:
        if (Color.equals-impl0(r3, r2.m2451getInverseSurface0d7_KjU()) == false) goto L33;
        return r2.m2449getInverseOnSurface0d7_KjU();
    L33:
        if (Color.equals-impl0(r3, r2.m2480getSurface0d7_KjU()) == false) goto L36;
        return r2.m2463getOnSurface0d7_KjU();
    L36:
        if (Color.equals-impl0(r3, r2.m2489getSurfaceVariant0d7_KjU()) == false) goto L39;
        return r2.m2464getOnSurfaceVariant0d7_KjU();
    L39:
        if (Color.equals-impl0(r3, r2.m2481getSurfaceBright0d7_KjU()) == false) goto L42;
        return r2.m2463getOnSurface0d7_KjU();
    L42:
        if (Color.equals-impl0(r3, r2.m2482getSurfaceContainer0d7_KjU()) == false) goto L45;
        return r2.m2463getOnSurface0d7_KjU();
    L45:
        if (Color.equals-impl0(r3, r2.m2483getSurfaceContainerHigh0d7_KjU()) == false) goto L48;
        return r2.m2463getOnSurface0d7_KjU();
    L48:
        if (Color.equals-impl0(r3, r2.m2484getSurfaceContainerHighest0d7_KjU()) == false) goto L51;
        return r2.m2463getOnSurface0d7_KjU();
    L51:
        if (Color.equals-impl0(r3, r2.m2485getSurfaceContainerLow0d7_KjU()) == false) goto L54;
        return r2.m2463getOnSurface0d7_KjU();
    L54:
        if (Color.equals-impl0(r3, r2.m2486getSurfaceContainerLowest0d7_KjU()) == false) goto L57;
        return r2.m2463getOnSurface0d7_KjU();
    L57:
        if (Color.equals-impl0(r3, r2.m2487getSurfaceDim0d7_KjU()) == false) goto L60;
        return r2.m2463getOnSurface0d7_KjU();
    L60:
        if (Color.equals-impl0(r3, r2.m2473getPrimaryFixed0d7_KjU()) == false) goto L63;
        return r2.m2457getOnPrimaryFixed0d7_KjU();
    L63:
        if (Color.equals-impl0(r3, r2.m2474getPrimaryFixedDim0d7_KjU()) == false) goto L66;
        return r2.m2457getOnPrimaryFixed0d7_KjU();
    L66:
        if (Color.equals-impl0(r3, r2.m2478getSecondaryFixed0d7_KjU()) == false) goto L69;
        return r2.m2461getOnSecondaryFixed0d7_KjU();
    L69:
        if (Color.equals-impl0(r3, r2.m2479getSecondaryFixedDim0d7_KjU()) == false) goto L72;
        return r2.m2461getOnSecondaryFixed0d7_KjU();
    L72:
        if (Color.equals-impl0(r3, r2.m2492getTertiaryFixed0d7_KjU()) == false) goto L75;
        return r2.m2467getOnTertiaryFixed0d7_KjU();
    L75:
        if (Color.equals-impl0(r3, r2.m2493getTertiaryFixedDim0d7_KjU()) == false) goto L78;
        return r2.m2467getOnTertiaryFixed0d7_KjU();
    L78:
        return Color.Companion.getUnspecified-0d7_KjU();
    }

    public static final long fromToken(ColorScheme r1, ColorSchemeKeyTokens r2) {
        switch(WhenMappings.$EnumSwitchMapping$0[r2.ordinal()]) {
            case 1: goto L54;
            case 2: goto L101;
            case 3: goto L100;
            case 4: goto L99;
            case 5: goto L98;
            case 6: goto L97;
            case 7: goto L96;
            case 8: goto L95;
            case 9: goto L94;
            case 10: goto L93;
            case 11: goto L92;
            case 12: goto L91;
            case 13: goto L90;
            case 14: goto L89;
            case 15: goto L88;
            case 16: goto L87;
            case 17: goto L86;
            case 18: goto L85;
            case 19: goto L84;
            case 20: goto L83;
            case 21: goto L82;
            case 22: goto L81;
            case 23: goto L80;
            case 24: goto L79;
            case 25: goto L78;
            case 26: goto L77;
            case 27: goto L76;
            case 28: goto L75;
            case 29: goto L74;
            case 30: goto L73;
            case 31: goto L72;
            case 32: goto L71;
            case 33: goto L70;
            case 34: goto L69;
            case 35: goto L68;
            case 36: goto L67;
            case 37: goto L66;
            case 38: goto L65;
            case 39: goto L64;
            case 40: goto L63;
            case 41: goto L62;
            case 42: goto L61;
            case 43: goto L60;
            case 44: goto L59;
            case 45: goto L58;
            case 46: goto L57;
            case 47: goto L56;
            case 48: goto L55;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L55:
        return r1.m2468getOnTertiaryFixedVariant0d7_KjU();
    L56:
        return r1.m2467getOnTertiaryFixed0d7_KjU();
    L57:
        return r1.m2493getTertiaryFixedDim0d7_KjU();
    L58:
        return r1.m2492getTertiaryFixed0d7_KjU();
    L59:
        return r1.m2462getOnSecondaryFixedVariant0d7_KjU();
    L60:
        return r1.m2461getOnSecondaryFixed0d7_KjU();
    L61:
        return r1.m2479getSecondaryFixedDim0d7_KjU();
    L62:
        return r1.m2478getSecondaryFixed0d7_KjU();
    L63:
        return r1.m2458getOnPrimaryFixedVariant0d7_KjU();
    L64:
        return r1.m2457getOnPrimaryFixed0d7_KjU();
    L65:
        return r1.m2474getPrimaryFixedDim0d7_KjU();
    L66:
        return r1.m2473getPrimaryFixed0d7_KjU();
    L67:
        return r1.m2491getTertiaryContainer0d7_KjU();
    L68:
        return r1.m2490getTertiary0d7_KjU();
    L69:
        return r1.m2487getSurfaceDim0d7_KjU();
    L70:
        return r1.m2486getSurfaceContainerLowest0d7_KjU();
    L71:
        return r1.m2485getSurfaceContainerLow0d7_KjU();
    L72:
        return r1.m2484getSurfaceContainerHighest0d7_KjU();
    L73:
        return r1.m2483getSurfaceContainerHigh0d7_KjU();
    L74:
        return r1.m2482getSurfaceContainer0d7_KjU();
    L75:
        return r1.m2481getSurfaceBright0d7_KjU();
    L76:
        return r1.m2489getSurfaceVariant0d7_KjU();
    L77:
        return r1.m2480getSurface0d7_KjU();
    L78:
        return r1.m2477getSecondaryContainer0d7_KjU();
    L79:
        return r1.m2476getSecondary0d7_KjU();
    L80:
        return r1.m2475getScrim0d7_KjU();
    L81:
        return r1.m2472getPrimaryContainer0d7_KjU();
    L82:
        return r1.m2471getPrimary0d7_KjU();
    L83:
        return r1.m2470getOutlineVariant0d7_KjU();
    L84:
        return r1.m2469getOutline0d7_KjU();
    L85:
        return r1.m2466getOnTertiaryContainer0d7_KjU();
    L86:
        return r1.m2465getOnTertiary0d7_KjU();
    L87:
        return r1.m2488getSurfaceTint0d7_KjU();
    L88:
        return r1.m2464getOnSurfaceVariant0d7_KjU();
    L89:
        return r1.m2463getOnSurface0d7_KjU();
    L90:
        return r1.m2460getOnSecondaryContainer0d7_KjU();
    L91:
        return r1.m2459getOnSecondary0d7_KjU();
    L92:
        return r1.m2456getOnPrimaryContainer0d7_KjU();
    L93:
        return r1.m2455getOnPrimary0d7_KjU();
    L94:
        return r1.m2454getOnErrorContainer0d7_KjU();
    L95:
        return r1.m2453getOnError0d7_KjU();
    L96:
        return r1.m2452getOnBackground0d7_KjU();
    L97:
        return r1.m2451getInverseSurface0d7_KjU();
    L98:
        return r1.m2450getInversePrimary0d7_KjU();
    L99:
        return r1.m2449getInverseOnSurface0d7_KjU();
    L100:
        return r1.m2448getErrorContainer0d7_KjU();
    L101:
        return r1.m2447getError0d7_KjU();
    L54:
        return r1.m2446getBackground0d7_KjU();
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m2509surfaceColorAtElevation3ABfNKs(ColorScheme r9, float r10) {
        if (Dp.equals-impl0(r10, Dp.constructor-impl(0)) == false) goto L7;
        return r9.m2480getSurface0d7_KjU();
    L7:
        return ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(r9.m2488getSurfaceTint0d7_KjU(), ((((float) Math.log(r10 + 1)) * 4.5f) + 2.0f) / 100.0f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r9.m2480getSurface0d7_KjU());
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m2496contentColorForek8zF_U(long r3, Composer r5, int r6) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(509589638, r6, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:1112)");
    L5:
        r5.startReplaceGroup(89374938);
        long r4 = m2495contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(r5, 6), r3);
        if (r4 == 16) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == true) goto L12;
        r4 = ((Color) r5.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L12:
        r5.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        return r4;
    L8:
        r7 = false;
        goto L9
    }

    public static final long getValue(ColorSchemeKeyTokens r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-810780884, r5, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1524)");
    L5:
        long r6 = fromToken(MaterialTheme.INSTANCE.getColorScheme(r4, 6), r3);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: applyTonalElevation-RFCenO8, reason: not valid java name */
    public static final long m2494applyTonalElevationRFCenO8(ColorScheme r3, long r4, float r6, Composer r7, int r8) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1610977682, r8, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:1539)");
    L5:
        boolean r9 = ((Boolean) r7.consume(LocalTonalElevationEnabled)).booleanValue();
        if (Color.equals-impl0(r4, r3.m2480getSurface0d7_KjU()) == false) goto L10;
        if (r9 == false) goto L10;
        r4 = m2509surfaceColorAtElevation3ABfNKs(r3, r6);
    L10:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        return r4;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m2499darkColorSchemeG1PFcw(long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155) {
        return m2502darkColorScheme_VG5OTI$default(r99, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -536870912, 65535, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m2505lightColorSchemeG1PFcw(long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155) {
        return m2508lightColorScheme_VG5OTI$default(r99, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -536870912, 65535, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2500darkColorSchemeG1PFcw$default(long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        long r1 = ColorDarkTokens.INSTANCE.getPrimary-0d7_KjU();
    L7:
        if ((r103 & 2) == 0) goto L9;
        long r3 = ColorDarkTokens.INSTANCE.getOnPrimary-0d7_KjU();
    L11:
        if ((r103 & 4) == 0) goto L13;
        long r5 = ColorDarkTokens.INSTANCE.getPrimaryContainer-0d7_KjU();
    L15:
        if ((r103 & 8) == 0) goto L17;
        long r7 = ColorDarkTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU();
    L19:
        if ((r103 & 16) == 0) goto L21;
        long r9 = ColorDarkTokens.INSTANCE.getInversePrimary-0d7_KjU();
    L23:
        if ((r103 & 32) == 0) goto L25;
        long r11 = ColorDarkTokens.INSTANCE.getSecondary-0d7_KjU();
    L27:
        if ((r103 & 64) == 0) goto L29;
        long r13 = ColorDarkTokens.INSTANCE.getOnSecondary-0d7_KjU();
    L31:
        if ((r103 & 128) == 0) goto L33;
        long r15 = ColorDarkTokens.INSTANCE.getSecondaryContainer-0d7_KjU();
    L34:
        long r510 = r15;
        if ((r103 & 256) == 0) goto L37;
        long r16 = ColorDarkTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU();
    L38:
        long r62 = r16;
        if ((r103 & 512) == 0) goto L41;
        long r17 = ColorDarkTokens.INSTANCE.getTertiary-0d7_KjU();
    L42:
        long r64 = r17;
        if ((r103 & 1024) == 0) goto L45;
        long r18 = ColorDarkTokens.INSTANCE.getOnTertiary-0d7_KjU();
    L46:
        long r66 = r18;
        if ((r103 & 2048) == 0) goto L49;
        long r19 = ColorDarkTokens.INSTANCE.getTertiaryContainer-0d7_KjU();
    L50:
        long r68 = r19;
        if ((r103 & 4096) == 0) goto L53;
        long r110 = ColorDarkTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU();
    L54:
        long r610 = r110;
        if ((r103 & 8192) == 0) goto L57;
        long r111 = ColorDarkTokens.INSTANCE.getBackground-0d7_KjU();
    L58:
        long r72 = r111;
        if ((r103 & 16384) == 0) goto L61;
        long r112 = ColorDarkTokens.INSTANCE.getOnBackground-0d7_KjU();
    L63:
        if ((r103 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r113 = ColorDarkTokens.INSTANCE.getSurface-0d7_KjU();
    L67:
        if ((r103 & 65536) == 0) goto L69;
        long r114 = ColorDarkTokens.INSTANCE.getOnSurface-0d7_KjU();
    L71:
        if ((r103 & 131072) == 0) goto L73;
        long r21 = ColorDarkTokens.INSTANCE.getSurfaceVariant-0d7_KjU();
    L75:
        if ((r103 & 262144) == 0) goto L77;
        long r23 = ColorDarkTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU();
    L79:
        if ((r103 & 524288) == 0) goto L81;
        long r25 = r1;
    L83:
        if ((r103 & 1048576) == 0) goto L85;
        long r27 = ColorDarkTokens.INSTANCE.getInverseSurface-0d7_KjU();
    L87:
        if ((r103 & 2097152) == 0) goto L89;
        long r29 = ColorDarkTokens.INSTANCE.getInverseOnSurface-0d7_KjU();
    L91:
        if ((r103 & 4194304) == 0) goto L93;
        long r31 = ColorDarkTokens.INSTANCE.getError-0d7_KjU();
    L95:
        if ((r103 & 8388608) == 0) goto L97;
        long r33 = ColorDarkTokens.INSTANCE.getOnError-0d7_KjU();
    L99:
        if ((r103 & 16777216) == 0) goto L101;
        long r35 = ColorDarkTokens.INSTANCE.getErrorContainer-0d7_KjU();
    L103:
        if ((r103 & 33554432) == 0) goto L105;
        long r37 = ColorDarkTokens.INSTANCE.getOnErrorContainer-0d7_KjU();
    L107:
        if ((r103 & 67108864) == 0) goto L109;
        long r39 = ColorDarkTokens.INSTANCE.getOutline-0d7_KjU();
    L111:
        if ((r103 & 134217728) == 0) goto L113;
        long r41 = ColorDarkTokens.INSTANCE.getOutlineVariant-0d7_KjU();
    L115:
        if ((r103 & 268435456) == 0) goto L117;
        long r43 = ColorDarkTokens.INSTANCE.getScrim-0d7_KjU();
    L119:
        return m2499darkColorSchemeG1PFcw(r1, r3, r5, r7, r9, r11, r13, r510, r62, r64, r66, r68, r610, r72, r112, r113, r114, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43);
    L117:
        r43 = r101;
        goto L119
    L113:
        r41 = r99;
        goto L115
    L109:
        r39 = r97;
        goto L111
    L105:
        r37 = r95;
        goto L107
    L101:
        r35 = r93;
        goto L103
    L97:
        r33 = r91;
        goto L99
    L93:
        r31 = r89;
        goto L95
    L89:
        r29 = r87;
        goto L91
    L85:
        r27 = r85;
        goto L87
    L81:
        r25 = r83;
        goto L83
    L77:
        r23 = r81;
        goto L79
    L73:
        r21 = r79;
        goto L75
    L69:
        r114 = r77;
        goto L71
    L65:
        r113 = r75;
        goto L67
    L61:
        r112 = r73;
        goto L63
    L57:
        r111 = r71;
        goto L58
    L53:
        r110 = r69;
        goto L54
    L49:
        r19 = r67;
        goto L50
    L45:
        r18 = r65;
        goto L46
    L41:
        r17 = r63;
        goto L42
    L37:
        r16 = r61;
        goto L38
    L33:
        r15 = r59;
        goto L34
    L29:
        r13 = r57;
        goto L31
    L25:
        r11 = r55;
        goto L27
    L21:
        r9 = r53;
        goto L23
    L17:
        r7 = r51;
        goto L19
    L13:
        r5 = r49;
        goto L15
    L9:
        r3 = r47;
        goto L11
    L5:
        r1 = r45;
        goto L7
    }

    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2506lightColorSchemeG1PFcw$default(long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        long r1 = ColorLightTokens.INSTANCE.getPrimary-0d7_KjU();
    L7:
        if ((r103 & 2) == 0) goto L9;
        long r3 = ColorLightTokens.INSTANCE.getOnPrimary-0d7_KjU();
    L11:
        if ((r103 & 4) == 0) goto L13;
        long r5 = ColorLightTokens.INSTANCE.getPrimaryContainer-0d7_KjU();
    L15:
        if ((r103 & 8) == 0) goto L17;
        long r7 = ColorLightTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU();
    L19:
        if ((r103 & 16) == 0) goto L21;
        long r9 = ColorLightTokens.INSTANCE.getInversePrimary-0d7_KjU();
    L23:
        if ((r103 & 32) == 0) goto L25;
        long r11 = ColorLightTokens.INSTANCE.getSecondary-0d7_KjU();
    L27:
        if ((r103 & 64) == 0) goto L29;
        long r13 = ColorLightTokens.INSTANCE.getOnSecondary-0d7_KjU();
    L31:
        if ((r103 & 128) == 0) goto L33;
        long r15 = ColorLightTokens.INSTANCE.getSecondaryContainer-0d7_KjU();
    L34:
        long r510 = r15;
        if ((r103 & 256) == 0) goto L37;
        long r16 = ColorLightTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU();
    L38:
        long r62 = r16;
        if ((r103 & 512) == 0) goto L41;
        long r17 = ColorLightTokens.INSTANCE.getTertiary-0d7_KjU();
    L42:
        long r64 = r17;
        if ((r103 & 1024) == 0) goto L45;
        long r18 = ColorLightTokens.INSTANCE.getOnTertiary-0d7_KjU();
    L46:
        long r66 = r18;
        if ((r103 & 2048) == 0) goto L49;
        long r19 = ColorLightTokens.INSTANCE.getTertiaryContainer-0d7_KjU();
    L50:
        long r68 = r19;
        if ((r103 & 4096) == 0) goto L53;
        long r110 = ColorLightTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU();
    L54:
        long r610 = r110;
        if ((r103 & 8192) == 0) goto L57;
        long r111 = ColorLightTokens.INSTANCE.getBackground-0d7_KjU();
    L58:
        long r72 = r111;
        if ((r103 & 16384) == 0) goto L61;
        long r112 = ColorLightTokens.INSTANCE.getOnBackground-0d7_KjU();
    L63:
        if ((r103 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r113 = ColorLightTokens.INSTANCE.getSurface-0d7_KjU();
    L67:
        if ((r103 & 65536) == 0) goto L69;
        long r114 = ColorLightTokens.INSTANCE.getOnSurface-0d7_KjU();
    L71:
        if ((r103 & 131072) == 0) goto L73;
        long r21 = ColorLightTokens.INSTANCE.getSurfaceVariant-0d7_KjU();
    L75:
        if ((r103 & 262144) == 0) goto L77;
        long r23 = ColorLightTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU();
    L79:
        if ((r103 & 524288) == 0) goto L81;
        long r25 = r1;
    L83:
        if ((r103 & 1048576) == 0) goto L85;
        long r27 = ColorLightTokens.INSTANCE.getInverseSurface-0d7_KjU();
    L87:
        if ((r103 & 2097152) == 0) goto L89;
        long r29 = ColorLightTokens.INSTANCE.getInverseOnSurface-0d7_KjU();
    L91:
        if ((r103 & 4194304) == 0) goto L93;
        long r31 = ColorLightTokens.INSTANCE.getError-0d7_KjU();
    L95:
        if ((r103 & 8388608) == 0) goto L97;
        long r33 = ColorLightTokens.INSTANCE.getOnError-0d7_KjU();
    L99:
        if ((r103 & 16777216) == 0) goto L101;
        long r35 = ColorLightTokens.INSTANCE.getErrorContainer-0d7_KjU();
    L103:
        if ((r103 & 33554432) == 0) goto L105;
        long r37 = ColorLightTokens.INSTANCE.getOnErrorContainer-0d7_KjU();
    L107:
        if ((r103 & 67108864) == 0) goto L109;
        long r39 = ColorLightTokens.INSTANCE.getOutline-0d7_KjU();
    L111:
        if ((r103 & 134217728) == 0) goto L113;
        long r41 = ColorLightTokens.INSTANCE.getOutlineVariant-0d7_KjU();
    L115:
        if ((r103 & 268435456) == 0) goto L117;
        long r43 = ColorLightTokens.INSTANCE.getScrim-0d7_KjU();
    L119:
        return m2505lightColorSchemeG1PFcw(r1, r3, r5, r7, r9, r11, r13, r510, r62, r64, r66, r68, r610, r72, r112, r113, r114, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43);
    L117:
        r43 = r101;
        goto L119
    L113:
        r41 = r99;
        goto L115
    L109:
        r39 = r97;
        goto L111
    L105:
        r37 = r95;
        goto L107
    L101:
        r35 = r93;
        goto L103
    L97:
        r33 = r91;
        goto L99
    L93:
        r31 = r89;
        goto L95
    L89:
        r29 = r87;
        goto L91
    L85:
        r27 = r85;
        goto L87
    L81:
        r25 = r83;
        goto L83
    L77:
        r23 = r81;
        goto L79
    L73:
        r21 = r79;
        goto L75
    L69:
        r114 = r77;
        goto L71
    L65:
        r113 = r75;
        goto L67
    L61:
        r112 = r73;
        goto L63
    L57:
        r111 = r71;
        goto L58
    L53:
        r110 = r69;
        goto L54
    L49:
        r19 = r67;
        goto L50
    L45:
        r18 = r65;
        goto L46
    L41:
        r17 = r63;
        goto L42
    L37:
        r16 = r61;
        goto L38
    L33:
        r15 = r59;
        goto L34
    L29:
        r13 = r57;
        goto L31
    L25:
        r11 = r55;
        goto L27
    L21:
        r9 = r53;
        goto L23
    L17:
        r7 = r51;
        goto L19
    L13:
        r5 = r49;
        goto L15
    L9:
        r3 = r47;
        goto L11
    L5:
        r1 = r45;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    /* JADX INFO: renamed from: darkColorScheme-C-Xl9yA, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m2497darkColorSchemeCXl9yA(long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169) {
        return m2502darkColorScheme_VG5OTI$default(r99, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r159, r161, r163, r165, r167, r169, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65520, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional Fixed roles instead")
    /* JADX INFO: renamed from: lightColorScheme-C-Xl9yA, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m2503lightColorSchemeCXl9yA(long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169) {
        return m2508lightColorScheme_VG5OTI$default(r99, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r159, r161, r163, r165, r167, r169, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65520, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2498darkColorSchemeCXl9yA$default(long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, int r131, int r132, Object r133) {
        if ((r131 & 1) == 0) goto L5;
        long r1 = ColorDarkTokens.INSTANCE.getPrimary-0d7_KjU();
    L7:
        if ((r131 & 2) == 0) goto L9;
        long r3 = ColorDarkTokens.INSTANCE.getOnPrimary-0d7_KjU();
    L11:
        if ((r131 & 4) == 0) goto L13;
        long r5 = ColorDarkTokens.INSTANCE.getPrimaryContainer-0d7_KjU();
    L15:
        if ((r131 & 8) == 0) goto L17;
        long r7 = ColorDarkTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU();
    L19:
        if ((r131 & 16) == 0) goto L21;
        long r9 = ColorDarkTokens.INSTANCE.getInversePrimary-0d7_KjU();
    L23:
        if ((r131 & 32) == 0) goto L25;
        long r11 = ColorDarkTokens.INSTANCE.getSecondary-0d7_KjU();
    L27:
        if ((r131 & 64) == 0) goto L29;
        long r13 = ColorDarkTokens.INSTANCE.getOnSecondary-0d7_KjU();
    L31:
        if ((r131 & 128) == 0) goto L33;
        long r15 = ColorDarkTokens.INSTANCE.getSecondaryContainer-0d7_KjU();
    L34:
        long r74 = r15;
        if ((r131 & 256) == 0) goto L37;
        long r16 = ColorDarkTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU();
    L38:
        long r76 = r16;
        if ((r131 & 512) == 0) goto L41;
        long r17 = ColorDarkTokens.INSTANCE.getTertiary-0d7_KjU();
    L42:
        long r78 = r17;
        if ((r131 & 1024) == 0) goto L45;
        long r18 = ColorDarkTokens.INSTANCE.getOnTertiary-0d7_KjU();
    L46:
        long r710 = r18;
        if ((r131 & 2048) == 0) goto L49;
        long r19 = ColorDarkTokens.INSTANCE.getTertiaryContainer-0d7_KjU();
    L50:
        long r82 = r19;
        if ((r131 & 4096) == 0) goto L53;
        long r110 = ColorDarkTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU();
    L54:
        long r84 = r110;
        if ((r131 & 8192) == 0) goto L57;
        long r112 = ColorDarkTokens.INSTANCE.getBackground-0d7_KjU();
    L58:
        long r86 = r112;
        if ((r131 & 16384) == 0) goto L61;
        long r114 = ColorDarkTokens.INSTANCE.getOnBackground-0d7_KjU();
    L63:
        if ((r131 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r116 = ColorDarkTokens.INSTANCE.getSurface-0d7_KjU();
    L67:
        if ((r131 & 65536) == 0) goto L69;
        long r118 = ColorDarkTokens.INSTANCE.getOnSurface-0d7_KjU();
    L71:
        if ((r131 & 131072) == 0) goto L73;
        long r21 = ColorDarkTokens.INSTANCE.getSurfaceVariant-0d7_KjU();
    L75:
        if ((r131 & 262144) == 0) goto L77;
        long r23 = ColorDarkTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU();
    L79:
        if ((r131 & 524288) == 0) goto L81;
        long r25 = r1;
    L83:
        if ((r131 & 1048576) == 0) goto L85;
        long r27 = ColorDarkTokens.INSTANCE.getInverseSurface-0d7_KjU();
    L87:
        if ((r131 & 2097152) == 0) goto L89;
        long r29 = ColorDarkTokens.INSTANCE.getInverseOnSurface-0d7_KjU();
    L91:
        if ((r131 & 4194304) == 0) goto L93;
        long r31 = ColorDarkTokens.INSTANCE.getError-0d7_KjU();
    L95:
        if ((r131 & 8388608) == 0) goto L97;
        long r33 = ColorDarkTokens.INSTANCE.getOnError-0d7_KjU();
    L99:
        if ((r131 & 16777216) == 0) goto L101;
        long r35 = ColorDarkTokens.INSTANCE.getErrorContainer-0d7_KjU();
    L103:
        if ((r131 & 33554432) == 0) goto L105;
        long r37 = ColorDarkTokens.INSTANCE.getOnErrorContainer-0d7_KjU();
    L107:
        if ((r131 & 67108864) == 0) goto L109;
        long r39 = ColorDarkTokens.INSTANCE.getOutline-0d7_KjU();
    L111:
        if ((r131 & 134217728) == 0) goto L113;
        long r41 = ColorDarkTokens.INSTANCE.getOutlineVariant-0d7_KjU();
    L115:
        if ((r131 & 268435456) == 0) goto L117;
        long r43 = ColorDarkTokens.INSTANCE.getScrim-0d7_KjU();
    L119:
        if ((r131 & 536870912) == 0) goto L121;
        long r45 = ColorDarkTokens.INSTANCE.getSurfaceBright-0d7_KjU();
    L123:
        if ((r131 & 1073741824) == 0) goto L125;
        long r47 = ColorDarkTokens.INSTANCE.getSurfaceContainer-0d7_KjU();
    L127:
        if ((r131 & RtlSpacingHelper.UNDEFINED) == 0) goto L129;
        long r49 = ColorDarkTokens.INSTANCE.getSurfaceContainerHigh-0d7_KjU();
    L131:
        if ((r132 & 1) == 0) goto L133;
        long r51 = ColorDarkTokens.INSTANCE.getSurfaceContainerHighest-0d7_KjU();
    L135:
        if ((r132 & 2) == 0) goto L137;
        long r53 = ColorDarkTokens.INSTANCE.getSurfaceContainerLow-0d7_KjU();
    L139:
        if ((r132 & 4) == 0) goto L141;
        long r55 = ColorDarkTokens.INSTANCE.getSurfaceContainerLowest-0d7_KjU();
    L143:
        if ((r132 & 8) == 0) goto L145;
        long r57 = ColorDarkTokens.INSTANCE.getSurfaceDim-0d7_KjU();
    L147:
        return m2497darkColorSchemeCXl9yA(r1, r3, r5, r7, r9, r11, r13, r74, r76, r78, r710, r82, r84, r86, r114, r116, r118, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57);
    L145:
        r57 = r129;
        goto L147
    L141:
        r55 = r127;
        goto L143
    L137:
        r53 = r125;
        goto L139
    L133:
        r51 = r123;
        goto L135
    L129:
        r49 = r121;
        goto L131
    L125:
        r47 = r119;
        goto L127
    L121:
        r45 = r117;
        goto L123
    L117:
        r43 = r115;
        goto L119
    L113:
        r41 = r113;
        goto L115
    L109:
        r39 = r111;
        goto L111
    L105:
        r37 = r109;
        goto L107
    L101:
        r35 = r107;
        goto L103
    L97:
        r33 = r105;
        goto L99
    L93:
        r31 = r103;
        goto L95
    L89:
        r29 = r101;
        goto L91
    L85:
        r27 = r99;
        goto L87
    L81:
        r25 = r97;
        goto L83
    L77:
        r23 = r95;
        goto L79
    L73:
        r21 = r93;
        goto L75
    L69:
        r118 = r91;
        goto L71
    L65:
        r116 = r89;
        goto L67
    L61:
        r114 = r87;
        goto L63
    L57:
        r112 = r85;
        goto L58
    L53:
        r110 = r83;
        goto L54
    L49:
        r19 = r81;
        goto L50
    L45:
        r18 = r79;
        goto L46
    L41:
        r17 = r77;
        goto L42
    L37:
        r16 = r75;
        goto L38
    L33:
        r15 = r73;
        goto L34
    L29:
        r13 = r71;
        goto L31
    L25:
        r11 = r69;
        goto L27
    L21:
        r9 = r67;
        goto L23
    L17:
        r7 = r65;
        goto L19
    L13:
        r5 = r63;
        goto L15
    L9:
        r3 = r61;
        goto L11
    L5:
        r1 = r59;
        goto L7
    }

    /* JADX INFO: renamed from: lightColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2504lightColorSchemeCXl9yA$default(long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, int r131, int r132, Object r133) {
        if ((r131 & 1) == 0) goto L5;
        long r1 = ColorLightTokens.INSTANCE.getPrimary-0d7_KjU();
    L7:
        if ((r131 & 2) == 0) goto L9;
        long r3 = ColorLightTokens.INSTANCE.getOnPrimary-0d7_KjU();
    L11:
        if ((r131 & 4) == 0) goto L13;
        long r5 = ColorLightTokens.INSTANCE.getPrimaryContainer-0d7_KjU();
    L15:
        if ((r131 & 8) == 0) goto L17;
        long r7 = ColorLightTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU();
    L19:
        if ((r131 & 16) == 0) goto L21;
        long r9 = ColorLightTokens.INSTANCE.getInversePrimary-0d7_KjU();
    L23:
        if ((r131 & 32) == 0) goto L25;
        long r11 = ColorLightTokens.INSTANCE.getSecondary-0d7_KjU();
    L27:
        if ((r131 & 64) == 0) goto L29;
        long r13 = ColorLightTokens.INSTANCE.getOnSecondary-0d7_KjU();
    L31:
        if ((r131 & 128) == 0) goto L33;
        long r15 = ColorLightTokens.INSTANCE.getSecondaryContainer-0d7_KjU();
    L34:
        long r74 = r15;
        if ((r131 & 256) == 0) goto L37;
        long r16 = ColorLightTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU();
    L38:
        long r76 = r16;
        if ((r131 & 512) == 0) goto L41;
        long r17 = ColorLightTokens.INSTANCE.getTertiary-0d7_KjU();
    L42:
        long r78 = r17;
        if ((r131 & 1024) == 0) goto L45;
        long r18 = ColorLightTokens.INSTANCE.getOnTertiary-0d7_KjU();
    L46:
        long r710 = r18;
        if ((r131 & 2048) == 0) goto L49;
        long r19 = ColorLightTokens.INSTANCE.getTertiaryContainer-0d7_KjU();
    L50:
        long r82 = r19;
        if ((r131 & 4096) == 0) goto L53;
        long r110 = ColorLightTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU();
    L54:
        long r84 = r110;
        if ((r131 & 8192) == 0) goto L57;
        long r112 = ColorLightTokens.INSTANCE.getBackground-0d7_KjU();
    L58:
        long r86 = r112;
        if ((r131 & 16384) == 0) goto L61;
        long r114 = ColorLightTokens.INSTANCE.getOnBackground-0d7_KjU();
    L63:
        if ((r131 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r116 = ColorLightTokens.INSTANCE.getSurface-0d7_KjU();
    L67:
        if ((r131 & 65536) == 0) goto L69;
        long r118 = ColorLightTokens.INSTANCE.getOnSurface-0d7_KjU();
    L71:
        if ((r131 & 131072) == 0) goto L73;
        long r21 = ColorLightTokens.INSTANCE.getSurfaceVariant-0d7_KjU();
    L75:
        if ((r131 & 262144) == 0) goto L77;
        long r23 = ColorLightTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU();
    L79:
        if ((r131 & 524288) == 0) goto L81;
        long r25 = r1;
    L83:
        if ((r131 & 1048576) == 0) goto L85;
        long r27 = ColorLightTokens.INSTANCE.getInverseSurface-0d7_KjU();
    L87:
        if ((r131 & 2097152) == 0) goto L89;
        long r29 = ColorLightTokens.INSTANCE.getInverseOnSurface-0d7_KjU();
    L91:
        if ((r131 & 4194304) == 0) goto L93;
        long r31 = ColorLightTokens.INSTANCE.getError-0d7_KjU();
    L95:
        if ((r131 & 8388608) == 0) goto L97;
        long r33 = ColorLightTokens.INSTANCE.getOnError-0d7_KjU();
    L99:
        if ((r131 & 16777216) == 0) goto L101;
        long r35 = ColorLightTokens.INSTANCE.getErrorContainer-0d7_KjU();
    L103:
        if ((r131 & 33554432) == 0) goto L105;
        long r37 = ColorLightTokens.INSTANCE.getOnErrorContainer-0d7_KjU();
    L107:
        if ((r131 & 67108864) == 0) goto L109;
        long r39 = ColorLightTokens.INSTANCE.getOutline-0d7_KjU();
    L111:
        if ((r131 & 134217728) == 0) goto L113;
        long r41 = ColorLightTokens.INSTANCE.getOutlineVariant-0d7_KjU();
    L115:
        if ((r131 & 268435456) == 0) goto L117;
        long r43 = ColorLightTokens.INSTANCE.getScrim-0d7_KjU();
    L119:
        if ((r131 & 536870912) == 0) goto L121;
        long r45 = ColorLightTokens.INSTANCE.getSurfaceBright-0d7_KjU();
    L123:
        if ((r131 & 1073741824) == 0) goto L125;
        long r47 = ColorLightTokens.INSTANCE.getSurfaceContainer-0d7_KjU();
    L127:
        if ((r131 & RtlSpacingHelper.UNDEFINED) == 0) goto L129;
        long r49 = ColorLightTokens.INSTANCE.getSurfaceContainerHigh-0d7_KjU();
    L131:
        if ((r132 & 1) == 0) goto L133;
        long r51 = ColorLightTokens.INSTANCE.getSurfaceContainerHighest-0d7_KjU();
    L135:
        if ((r132 & 2) == 0) goto L137;
        long r53 = ColorLightTokens.INSTANCE.getSurfaceContainerLow-0d7_KjU();
    L139:
        if ((r132 & 4) == 0) goto L141;
        long r55 = ColorLightTokens.INSTANCE.getSurfaceContainerLowest-0d7_KjU();
    L143:
        if ((r132 & 8) == 0) goto L145;
        long r57 = ColorLightTokens.INSTANCE.getSurfaceDim-0d7_KjU();
    L147:
        return m2503lightColorSchemeCXl9yA(r1, r3, r5, r7, r9, r11, r13, r74, r76, r78, r710, r82, r84, r86, r114, r116, r118, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57);
    L145:
        r57 = r129;
        goto L147
    L141:
        r55 = r127;
        goto L143
    L137:
        r53 = r125;
        goto L139
    L133:
        r51 = r123;
        goto L135
    L129:
        r49 = r121;
        goto L131
    L125:
        r47 = r119;
        goto L127
    L121:
        r45 = r117;
        goto L123
    L117:
        r43 = r115;
        goto L119
    L113:
        r41 = r113;
        goto L115
    L109:
        r39 = r111;
        goto L111
    L105:
        r37 = r109;
        goto L107
    L101:
        r35 = r107;
        goto L103
    L97:
        r33 = r105;
        goto L99
    L93:
        r31 = r103;
        goto L95
    L89:
        r29 = r101;
        goto L91
    L85:
        r27 = r99;
        goto L87
    L81:
        r25 = r97;
        goto L83
    L77:
        r23 = r95;
        goto L79
    L73:
        r21 = r93;
        goto L75
    L69:
        r118 = r91;
        goto L71
    L65:
        r116 = r89;
        goto L67
    L61:
        r114 = r87;
        goto L63
    L57:
        r112 = r85;
        goto L58
    L53:
        r110 = r83;
        goto L54
    L49:
        r19 = r81;
        goto L50
    L45:
        r18 = r79;
        goto L46
    L41:
        r17 = r77;
        goto L42
    L37:
        r16 = r75;
        goto L38
    L33:
        r15 = r73;
        goto L34
    L29:
        r13 = r71;
        goto L31
    L25:
        r11 = r69;
        goto L27
    L21:
        r9 = r67;
        goto L23
    L17:
        r7 = r65;
        goto L19
    L13:
        r5 = r63;
        goto L15
    L9:
        r3 = r61;
        goto L11
    L5:
        r1 = r59;
        goto L7
    }

    /* JADX INFO: renamed from: darkColorScheme-_VG5OTI, reason: not valid java name */
    public static final ColorScheme m2501darkColorScheme_VG5OTI(long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, long r175, long r177, long r179, long r181, long r183, long r185, long r187, long r189, long r191, long r193) {
        return new ColorScheme(r99, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r169, r159, r161, r163, r165, r167, r171, r173, r175, r177, r179, r181, r183, r185, r187, r189, r191, r193, null);
    }

    /* JADX INFO: renamed from: lightColorScheme-_VG5OTI, reason: not valid java name */
    public static final ColorScheme m2507lightColorScheme_VG5OTI(long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, long r175, long r177, long r179, long r181, long r183, long r185, long r187, long r189, long r191, long r193) {
        return new ColorScheme(r99, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r169, r159, r161, r163, r165, r167, r171, r173, r175, r177, r179, r181, r183, r185, r187, r189, r191, r193, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-_VG5OTI$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2502darkColorScheme_VG5OTI$default(long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, long r175, int r177, int r178, Object r179) {
        if ((r177 & 1) == 0) goto L5;
        long r2 = ColorDarkTokens.INSTANCE.getPrimary-0d7_KjU();
    L7:
        if ((r177 & 2) == 0) goto L9;
        long r4 = ColorDarkTokens.INSTANCE.getOnPrimary-0d7_KjU();
    L11:
        if ((r177 & 4) == 0) goto L13;
        long r6 = ColorDarkTokens.INSTANCE.getPrimaryContainer-0d7_KjU();
    L15:
        if ((r177 & 8) == 0) goto L17;
        long r8 = ColorDarkTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU();
    L19:
        if ((r177 & 16) == 0) goto L21;
        long r10 = ColorDarkTokens.INSTANCE.getInversePrimary-0d7_KjU();
    L23:
        if ((r177 & 32) == 0) goto L25;
        long r12 = ColorDarkTokens.INSTANCE.getSecondary-0d7_KjU();
    L27:
        if ((r177 & 64) == 0) goto L29;
        long r14 = ColorDarkTokens.INSTANCE.getOnSecondary-0d7_KjU();
    L30:
        long r94 = r14;
        if ((r177 & 128) == 0) goto L33;
        long r15 = ColorDarkTokens.INSTANCE.getSecondaryContainer-0d7_KjU();
    L34:
        long r96 = r15;
        if ((r177 & 256) == 0) goto L37;
        long r16 = ColorDarkTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU();
    L38:
        long r98 = r16;
        if ((r177 & 512) == 0) goto L41;
        long r17 = ColorDarkTokens.INSTANCE.getTertiary-0d7_KjU();
    L42:
        long r910 = r17;
        if ((r177 & 1024) == 0) goto L45;
        long r18 = ColorDarkTokens.INSTANCE.getOnTertiary-0d7_KjU();
    L46:
        long r102 = r18;
        if ((r177 & 2048) == 0) goto L49;
        long r19 = ColorDarkTokens.INSTANCE.getTertiaryContainer-0d7_KjU();
    L50:
        long r104 = r19;
        if ((r177 & 4096) == 0) goto L53;
        long r110 = ColorDarkTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU();
    L54:
        long r106 = r110;
        if ((r177 & 8192) == 0) goto L57;
        long r112 = ColorDarkTokens.INSTANCE.getBackground-0d7_KjU();
    L58:
        long r108 = r112;
        if ((r177 & 16384) == 0) goto L61;
        long r114 = ColorDarkTokens.INSTANCE.getOnBackground-0d7_KjU();
    L63:
        if ((r177 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r116 = ColorDarkTokens.INSTANCE.getSurface-0d7_KjU();
    L67:
        if ((r177 & 65536) == 0) goto L69;
        long r118 = ColorDarkTokens.INSTANCE.getOnSurface-0d7_KjU();
    L71:
        if ((r177 & 131072) == 0) goto L73;
        long r21 = ColorDarkTokens.INSTANCE.getSurfaceVariant-0d7_KjU();
    L75:
        if ((r177 & 262144) == 0) goto L77;
        long r23 = ColorDarkTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU();
    L79:
        if ((r177 & 524288) == 0) goto L81;
        long r25 = r2;
    L83:
        if ((r177 & 1048576) == 0) goto L85;
        long r27 = ColorDarkTokens.INSTANCE.getInverseSurface-0d7_KjU();
    L87:
        if ((r177 & 2097152) == 0) goto L89;
        long r29 = ColorDarkTokens.INSTANCE.getInverseOnSurface-0d7_KjU();
    L91:
        if ((r177 & 4194304) == 0) goto L93;
        long r31 = ColorDarkTokens.INSTANCE.getError-0d7_KjU();
    L95:
        if ((r177 & 8388608) == 0) goto L97;
        long r33 = ColorDarkTokens.INSTANCE.getOnError-0d7_KjU();
    L99:
        if ((r177 & 16777216) == 0) goto L101;
        long r35 = ColorDarkTokens.INSTANCE.getErrorContainer-0d7_KjU();
    L103:
        if ((r177 & 33554432) == 0) goto L105;
        long r37 = ColorDarkTokens.INSTANCE.getOnErrorContainer-0d7_KjU();
    L107:
        if ((r177 & 67108864) == 0) goto L109;
        long r39 = ColorDarkTokens.INSTANCE.getOutline-0d7_KjU();
    L111:
        if ((r177 & 134217728) == 0) goto L113;
        long r41 = ColorDarkTokens.INSTANCE.getOutlineVariant-0d7_KjU();
    L115:
        if ((r177 & 268435456) == 0) goto L117;
        long r43 = ColorDarkTokens.INSTANCE.getScrim-0d7_KjU();
    L119:
        if ((r177 & 536870912) == 0) goto L121;
        long r45 = ColorDarkTokens.INSTANCE.getSurfaceBright-0d7_KjU();
    L123:
        if ((r177 & 1073741824) == 0) goto L125;
        long r47 = ColorDarkTokens.INSTANCE.getSurfaceContainer-0d7_KjU();
    L127:
        if ((r177 & RtlSpacingHelper.UNDEFINED) == 0) goto L129;
        long r49 = ColorDarkTokens.INSTANCE.getSurfaceContainerHigh-0d7_KjU();
    L131:
        if ((r178 & 1) == 0) goto L133;
        long r51 = ColorDarkTokens.INSTANCE.getSurfaceContainerHighest-0d7_KjU();
    L135:
        if ((r178 & 2) == 0) goto L137;
        long r53 = ColorDarkTokens.INSTANCE.getSurfaceContainerLow-0d7_KjU();
    L139:
        if ((r178 & 4) == 0) goto L141;
        long r55 = ColorDarkTokens.INSTANCE.getSurfaceContainerLowest-0d7_KjU();
    L143:
        if ((r178 & 8) == 0) goto L145;
        long r57 = ColorDarkTokens.INSTANCE.getSurfaceDim-0d7_KjU();
    L147:
        if ((r178 & 16) == 0) goto L149;
        long r59 = ColorDarkTokens.INSTANCE.getPrimaryFixed-0d7_KjU();
    L151:
        if ((r178 & 32) == 0) goto L153;
        long r61 = ColorDarkTokens.INSTANCE.getPrimaryFixedDim-0d7_KjU();
    L155:
        if ((r178 & 64) == 0) goto L157;
        long r63 = ColorDarkTokens.INSTANCE.getOnPrimaryFixed-0d7_KjU();
    L159:
        if ((r178 & 128) == 0) goto L161;
        long r65 = ColorDarkTokens.INSTANCE.getOnPrimaryFixedVariant-0d7_KjU();
    L163:
        if ((r178 & 256) == 0) goto L165;
        long r67 = ColorDarkTokens.INSTANCE.getSecondaryFixed-0d7_KjU();
    L167:
        if ((r178 & 512) == 0) goto L169;
        long r69 = ColorDarkTokens.INSTANCE.getSecondaryFixedDim-0d7_KjU();
    L171:
        if ((r178 & 1024) == 0) goto L173;
        long r71 = ColorDarkTokens.INSTANCE.getOnSecondaryFixed-0d7_KjU();
    L175:
        if ((r178 & 2048) == 0) goto L177;
        long r73 = ColorDarkTokens.INSTANCE.getOnSecondaryFixedVariant-0d7_KjU();
    L179:
        if ((r178 & 4096) == 0) goto L181;
        long r75 = ColorDarkTokens.INSTANCE.getTertiaryFixed-0d7_KjU();
    L183:
        if ((r178 & 8192) == 0) goto L185;
        long r77 = ColorDarkTokens.INSTANCE.getTertiaryFixedDim-0d7_KjU();
    L187:
        if ((r178 & 16384) == 0) goto L189;
        long r79 = ColorDarkTokens.INSTANCE.getOnTertiaryFixed-0d7_KjU();
    L191:
        if ((r178 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L193;
        long r0 = ColorDarkTokens.INSTANCE.getOnTertiaryFixedVariant-0d7_KjU();
    L195:
        return m2501darkColorScheme_VG5OTI(r2, r4, r6, r8, r10, r12, r94, r96, r98, r910, r102, r104, r106, r108, r114, r116, r118, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r0);
    L193:
        r0 = r175;
        goto L195
    L189:
        r79 = r173;
        goto L191
    L185:
        r77 = r171;
        goto L187
    L181:
        r75 = r169;
        goto L183
    L177:
        r73 = r167;
        goto L179
    L173:
        r71 = r165;
        goto L175
    L169:
        r69 = r163;
        goto L171
    L165:
        r67 = r161;
        goto L167
    L161:
        r65 = r159;
        goto L163
    L157:
        r63 = r157;
        goto L159
    L153:
        r61 = r155;
        goto L155
    L149:
        r59 = r153;
        goto L151
    L145:
        r57 = r151;
        goto L147
    L141:
        r55 = r149;
        goto L143
    L137:
        r53 = r147;
        goto L139
    L133:
        r51 = r145;
        goto L135
    L129:
        r49 = r143;
        goto L131
    L125:
        r47 = r141;
        goto L127
    L121:
        r45 = r139;
        goto L123
    L117:
        r43 = r137;
        goto L119
    L113:
        r41 = r135;
        goto L115
    L109:
        r39 = r133;
        goto L111
    L105:
        r37 = r131;
        goto L107
    L101:
        r35 = r129;
        goto L103
    L97:
        r33 = r127;
        goto L99
    L93:
        r31 = r125;
        goto L95
    L89:
        r29 = r123;
        goto L91
    L85:
        r27 = r121;
        goto L87
    L81:
        r25 = r119;
        goto L83
    L77:
        r23 = r117;
        goto L79
    L73:
        r21 = r115;
        goto L75
    L69:
        r118 = r113;
        goto L71
    L65:
        r116 = r111;
        goto L67
    L61:
        r114 = r109;
        goto L63
    L57:
        r112 = r107;
        goto L58
    L53:
        r110 = r105;
        goto L54
    L49:
        r19 = r103;
        goto L50
    L45:
        r18 = r101;
        goto L46
    L41:
        r17 = r99;
        goto L42
    L37:
        r16 = r97;
        goto L38
    L33:
        r15 = r95;
        goto L34
    L29:
        r14 = r93;
        goto L30
    L25:
        r12 = r91;
        goto L27
    L21:
        r10 = r89;
        goto L23
    L17:
        r8 = r87;
        goto L19
    L13:
        r6 = r85;
        goto L15
    L9:
        r4 = r83;
        goto L11
    L5:
        r2 = r81;
        goto L7
    }

    /* JADX INFO: renamed from: lightColorScheme-_VG5OTI$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2508lightColorScheme_VG5OTI$default(long r81, long r83, long r85, long r87, long r89, long r91, long r93, long r95, long r97, long r99, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, long r175, int r177, int r178, Object r179) {
        if ((r177 & 1) == 0) goto L5;
        long r2 = ColorLightTokens.INSTANCE.getPrimary-0d7_KjU();
    L7:
        if ((r177 & 2) == 0) goto L9;
        long r4 = ColorLightTokens.INSTANCE.getOnPrimary-0d7_KjU();
    L11:
        if ((r177 & 4) == 0) goto L13;
        long r6 = ColorLightTokens.INSTANCE.getPrimaryContainer-0d7_KjU();
    L15:
        if ((r177 & 8) == 0) goto L17;
        long r8 = ColorLightTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU();
    L19:
        if ((r177 & 16) == 0) goto L21;
        long r10 = ColorLightTokens.INSTANCE.getInversePrimary-0d7_KjU();
    L23:
        if ((r177 & 32) == 0) goto L25;
        long r12 = ColorLightTokens.INSTANCE.getSecondary-0d7_KjU();
    L27:
        if ((r177 & 64) == 0) goto L29;
        long r14 = ColorLightTokens.INSTANCE.getOnSecondary-0d7_KjU();
    L30:
        long r94 = r14;
        if ((r177 & 128) == 0) goto L33;
        long r15 = ColorLightTokens.INSTANCE.getSecondaryContainer-0d7_KjU();
    L34:
        long r96 = r15;
        if ((r177 & 256) == 0) goto L37;
        long r16 = ColorLightTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU();
    L38:
        long r98 = r16;
        if ((r177 & 512) == 0) goto L41;
        long r17 = ColorLightTokens.INSTANCE.getTertiary-0d7_KjU();
    L42:
        long r910 = r17;
        if ((r177 & 1024) == 0) goto L45;
        long r18 = ColorLightTokens.INSTANCE.getOnTertiary-0d7_KjU();
    L46:
        long r102 = r18;
        if ((r177 & 2048) == 0) goto L49;
        long r19 = ColorLightTokens.INSTANCE.getTertiaryContainer-0d7_KjU();
    L50:
        long r104 = r19;
        if ((r177 & 4096) == 0) goto L53;
        long r110 = ColorLightTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU();
    L54:
        long r106 = r110;
        if ((r177 & 8192) == 0) goto L57;
        long r112 = ColorLightTokens.INSTANCE.getBackground-0d7_KjU();
    L58:
        long r108 = r112;
        if ((r177 & 16384) == 0) goto L61;
        long r114 = ColorLightTokens.INSTANCE.getOnBackground-0d7_KjU();
    L63:
        if ((r177 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        long r116 = ColorLightTokens.INSTANCE.getSurface-0d7_KjU();
    L67:
        if ((r177 & 65536) == 0) goto L69;
        long r118 = ColorLightTokens.INSTANCE.getOnSurface-0d7_KjU();
    L71:
        if ((r177 & 131072) == 0) goto L73;
        long r21 = ColorLightTokens.INSTANCE.getSurfaceVariant-0d7_KjU();
    L75:
        if ((r177 & 262144) == 0) goto L77;
        long r23 = ColorLightTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU();
    L79:
        if ((r177 & 524288) == 0) goto L81;
        long r25 = r2;
    L83:
        if ((r177 & 1048576) == 0) goto L85;
        long r27 = ColorLightTokens.INSTANCE.getInverseSurface-0d7_KjU();
    L87:
        if ((r177 & 2097152) == 0) goto L89;
        long r29 = ColorLightTokens.INSTANCE.getInverseOnSurface-0d7_KjU();
    L91:
        if ((r177 & 4194304) == 0) goto L93;
        long r31 = ColorLightTokens.INSTANCE.getError-0d7_KjU();
    L95:
        if ((r177 & 8388608) == 0) goto L97;
        long r33 = ColorLightTokens.INSTANCE.getOnError-0d7_KjU();
    L99:
        if ((r177 & 16777216) == 0) goto L101;
        long r35 = ColorLightTokens.INSTANCE.getErrorContainer-0d7_KjU();
    L103:
        if ((r177 & 33554432) == 0) goto L105;
        long r37 = ColorLightTokens.INSTANCE.getOnErrorContainer-0d7_KjU();
    L107:
        if ((r177 & 67108864) == 0) goto L109;
        long r39 = ColorLightTokens.INSTANCE.getOutline-0d7_KjU();
    L111:
        if ((r177 & 134217728) == 0) goto L113;
        long r41 = ColorLightTokens.INSTANCE.getOutlineVariant-0d7_KjU();
    L115:
        if ((r177 & 268435456) == 0) goto L117;
        long r43 = ColorLightTokens.INSTANCE.getScrim-0d7_KjU();
    L119:
        if ((r177 & 536870912) == 0) goto L121;
        long r45 = ColorLightTokens.INSTANCE.getSurfaceBright-0d7_KjU();
    L123:
        if ((r177 & 1073741824) == 0) goto L125;
        long r47 = ColorLightTokens.INSTANCE.getSurfaceContainer-0d7_KjU();
    L127:
        if ((r177 & RtlSpacingHelper.UNDEFINED) == 0) goto L129;
        long r49 = ColorLightTokens.INSTANCE.getSurfaceContainerHigh-0d7_KjU();
    L131:
        if ((r178 & 1) == 0) goto L133;
        long r51 = ColorLightTokens.INSTANCE.getSurfaceContainerHighest-0d7_KjU();
    L135:
        if ((r178 & 2) == 0) goto L137;
        long r53 = ColorLightTokens.INSTANCE.getSurfaceContainerLow-0d7_KjU();
    L139:
        if ((r178 & 4) == 0) goto L141;
        long r55 = ColorLightTokens.INSTANCE.getSurfaceContainerLowest-0d7_KjU();
    L143:
        if ((r178 & 8) == 0) goto L145;
        long r57 = ColorLightTokens.INSTANCE.getSurfaceDim-0d7_KjU();
    L147:
        if ((r178 & 16) == 0) goto L149;
        long r59 = ColorLightTokens.INSTANCE.getPrimaryFixed-0d7_KjU();
    L151:
        if ((r178 & 32) == 0) goto L153;
        long r61 = ColorLightTokens.INSTANCE.getPrimaryFixedDim-0d7_KjU();
    L155:
        if ((r178 & 64) == 0) goto L157;
        long r63 = ColorLightTokens.INSTANCE.getOnPrimaryFixed-0d7_KjU();
    L159:
        if ((r178 & 128) == 0) goto L161;
        long r65 = ColorLightTokens.INSTANCE.getOnPrimaryFixedVariant-0d7_KjU();
    L163:
        if ((r178 & 256) == 0) goto L165;
        long r67 = ColorLightTokens.INSTANCE.getSecondaryFixed-0d7_KjU();
    L167:
        if ((r178 & 512) == 0) goto L169;
        long r69 = ColorLightTokens.INSTANCE.getSecondaryFixedDim-0d7_KjU();
    L171:
        if ((r178 & 1024) == 0) goto L173;
        long r71 = ColorLightTokens.INSTANCE.getOnSecondaryFixed-0d7_KjU();
    L175:
        if ((r178 & 2048) == 0) goto L177;
        long r73 = ColorLightTokens.INSTANCE.getOnSecondaryFixedVariant-0d7_KjU();
    L179:
        if ((r178 & 4096) == 0) goto L181;
        long r75 = ColorLightTokens.INSTANCE.getTertiaryFixed-0d7_KjU();
    L183:
        if ((r178 & 8192) == 0) goto L185;
        long r77 = ColorLightTokens.INSTANCE.getTertiaryFixedDim-0d7_KjU();
    L187:
        if ((r178 & 16384) == 0) goto L189;
        long r79 = ColorLightTokens.INSTANCE.getOnTertiaryFixed-0d7_KjU();
    L191:
        if ((r178 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L193;
        long r0 = ColorLightTokens.INSTANCE.getOnTertiaryFixedVariant-0d7_KjU();
    L195:
        return m2507lightColorScheme_VG5OTI(r2, r4, r6, r8, r10, r12, r94, r96, r98, r910, r102, r104, r106, r108, r114, r116, r118, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r0);
    L193:
        r0 = r175;
        goto L195
    L189:
        r79 = r173;
        goto L191
    L185:
        r77 = r171;
        goto L187
    L181:
        r75 = r169;
        goto L183
    L177:
        r73 = r167;
        goto L179
    L173:
        r71 = r165;
        goto L175
    L169:
        r69 = r163;
        goto L171
    L165:
        r67 = r161;
        goto L167
    L161:
        r65 = r159;
        goto L163
    L157:
        r63 = r157;
        goto L159
    L153:
        r61 = r155;
        goto L155
    L149:
        r59 = r153;
        goto L151
    L145:
        r57 = r151;
        goto L147
    L141:
        r55 = r149;
        goto L143
    L137:
        r53 = r147;
        goto L139
    L133:
        r51 = r145;
        goto L135
    L129:
        r49 = r143;
        goto L131
    L125:
        r47 = r141;
        goto L127
    L121:
        r45 = r139;
        goto L123
    L117:
        r43 = r137;
        goto L119
    L113:
        r41 = r135;
        goto L115
    L109:
        r39 = r133;
        goto L111
    L105:
        r37 = r131;
        goto L107
    L101:
        r35 = r129;
        goto L103
    L97:
        r33 = r127;
        goto L99
    L93:
        r31 = r125;
        goto L95
    L89:
        r29 = r123;
        goto L91
    L85:
        r27 = r121;
        goto L87
    L81:
        r25 = r119;
        goto L83
    L77:
        r23 = r117;
        goto L79
    L73:
        r21 = r115;
        goto L75
    L69:
        r118 = r113;
        goto L71
    L65:
        r116 = r111;
        goto L67
    L61:
        r114 = r109;
        goto L63
    L57:
        r112 = r107;
        goto L58
    L53:
        r110 = r105;
        goto L54
    L49:
        r19 = r103;
        goto L50
    L45:
        r18 = r101;
        goto L46
    L41:
        r17 = r99;
        goto L42
    L37:
        r16 = r97;
        goto L38
    L33:
        r15 = r95;
        goto L34
    L29:
        r14 = r93;
        goto L30
    L25:
        r12 = r91;
        goto L27
    L21:
        r10 = r89;
        goto L23
    L17:
        r8 = r87;
        goto L19
    L13:
        r6 = r85;
        goto L15
    L9:
        r4 = r83;
        goto L11
    L5:
        r2 = r81;
        goto L7
    }
}
