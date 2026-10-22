package androidx.compose.material3;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.material3.tokens.TypographyTokens;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bµ\u0002\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"B\u009f\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b!\u0010#J¹\u0002\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u0003H\u0000¢\u0006\u0002\bDJ\u009c\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003J\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020KH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0014\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0014\u0010\u0013\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0014\u0010\u0014\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0014\u0010\u0015\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0014\u0010\u0016\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0014\u0010\u0017\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0014\u0010\u0018\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0014\u0010\u0019\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0014\u0010\u001a\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0014\u0010\u001b\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010%R\u0014\u0010\u001c\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010%R\u0014\u0010\u001d\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0014\u0010\u001e\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0014\u0010\u001f\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010%R\u0014\u0010 \u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010%¨\u0006L"}, d2 = {"Landroidx/compose/material3/Typography;", "", "displayLarge", "Landroidx/compose/ui/text/TextStyle;", "displayMedium", "displaySmall", "headlineLarge", "headlineMedium", "headlineSmall", "titleLarge", "titleMedium", "titleSmall", "bodyLarge", "bodyMedium", "bodySmall", "labelLarge", "labelMedium", "labelSmall", "displayLargeEmphasized", "displayMediumEmphasized", "displaySmallEmphasized", "headlineLargeEmphasized", "headlineMediumEmphasized", "headlineSmallEmphasized", "titleLargeEmphasized", "titleMediumEmphasized", "titleSmallEmphasized", "bodyLargeEmphasized", "bodyMediumEmphasized", "bodySmallEmphasized", "labelLargeEmphasized", "labelMediumEmphasized", "labelSmallEmphasized", "<init>", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getDisplayLarge", "()Landroidx/compose/ui/text/TextStyle;", "getDisplayMedium", "getDisplaySmall", "getHeadlineLarge", "getHeadlineMedium", "getHeadlineSmall", "getTitleLarge", "getTitleMedium", "getTitleSmall", "getBodyLarge", "getBodyMedium", "getBodySmall", "getLabelLarge", "getLabelMedium", "getLabelSmall", "getDisplayLargeEmphasized$material3", "getDisplayMediumEmphasized$material3", "getDisplaySmallEmphasized$material3", "getHeadlineLargeEmphasized$material3", "getHeadlineMediumEmphasized$material3", "getHeadlineSmallEmphasized$material3", "getTitleLargeEmphasized$material3", "getTitleMediumEmphasized$material3", "getTitleSmallEmphasized$material3", "getBodyLargeEmphasized$material3", "getBodyMediumEmphasized$material3", "getBodySmallEmphasized$material3", "getLabelLargeEmphasized$material3", "getLabelMediumEmphasized$material3", "getLabelSmallEmphasized$material3", "copy", "copy$material3", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Typography {
    public static final int $stable = 0;
    private final TextStyle bodyLarge;
    private final TextStyle bodyLargeEmphasized;
    private final TextStyle bodyMedium;
    private final TextStyle bodyMediumEmphasized;
    private final TextStyle bodySmall;
    private final TextStyle bodySmallEmphasized;
    private final TextStyle displayLarge;
    private final TextStyle displayLargeEmphasized;
    private final TextStyle displayMedium;
    private final TextStyle displayMediumEmphasized;
    private final TextStyle displaySmall;
    private final TextStyle displaySmallEmphasized;
    private final TextStyle headlineLarge;
    private final TextStyle headlineLargeEmphasized;
    private final TextStyle headlineMedium;
    private final TextStyle headlineMediumEmphasized;
    private final TextStyle headlineSmall;
    private final TextStyle headlineSmallEmphasized;
    private final TextStyle labelLarge;
    private final TextStyle labelLargeEmphasized;
    private final TextStyle labelMedium;
    private final TextStyle labelMediumEmphasized;
    private final TextStyle labelSmall;
    private final TextStyle labelSmallEmphasized;
    private final TextStyle titleLarge;
    private final TextStyle titleLargeEmphasized;
    private final TextStyle titleMedium;
    private final TextStyle titleMediumEmphasized;
    private final TextStyle titleSmall;
    private final TextStyle titleSmallEmphasized;

    public Typography() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073741823, null);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.displayLarge.hashCode() * 31) + this.displayMedium.hashCode()) * 31) + this.displaySmall.hashCode()) * 31) + this.headlineLarge.hashCode()) * 31) + this.headlineMedium.hashCode()) * 31) + this.headlineSmall.hashCode()) * 31) + this.titleLarge.hashCode()) * 31) + this.titleMedium.hashCode()) * 31) + this.titleSmall.hashCode()) * 31) + this.bodyLarge.hashCode()) * 31) + this.bodyMedium.hashCode()) * 31) + this.bodySmall.hashCode()) * 31) + this.labelLarge.hashCode()) * 31) + this.labelMedium.hashCode()) * 31) + this.labelSmall.hashCode()) * 31) + this.displayLargeEmphasized.hashCode()) * 31) + this.displayMediumEmphasized.hashCode()) * 31) + this.displaySmallEmphasized.hashCode()) * 31) + this.headlineLargeEmphasized.hashCode()) * 31) + this.headlineMediumEmphasized.hashCode()) * 31) + this.headlineSmallEmphasized.hashCode()) * 31) + this.titleLargeEmphasized.hashCode()) * 31) + this.titleMediumEmphasized.hashCode()) * 31) + this.titleSmallEmphasized.hashCode()) * 31) + this.bodyLargeEmphasized.hashCode()) * 31) + this.bodyMediumEmphasized.hashCode()) * 31) + this.bodySmallEmphasized.hashCode()) * 31) + this.labelLargeEmphasized.hashCode()) * 31) + this.labelMediumEmphasized.hashCode()) * 31) + this.labelSmallEmphasized.hashCode();
    }

    public String toString() {
        return "Typography(displayLarge=" + this.displayLarge + ", displayMedium=" + this.displayMedium + ",displaySmall=" + this.displaySmall + ", headlineLarge=" + this.headlineLarge + ", headlineMedium=" + this.headlineMedium + ", headlineSmall=" + this.headlineSmall + ", titleLarge=" + this.titleLarge + ", titleMedium=" + this.titleMedium + ", titleSmall=" + this.titleSmall + ", bodyLarge=" + this.bodyLarge + ", bodyMedium=" + this.bodyMedium + ", bodySmall=" + this.bodySmall + ", labelLarge=" + this.labelLarge + ", labelMedium=" + this.labelMedium + ", labelSmall=" + this.labelSmall + ", displayLargeEmphasized=" + this.displayLargeEmphasized + ", displayMediumEmphasized=" + this.displayMediumEmphasized + ", displaySmallEmphasized=" + this.displaySmallEmphasized + ", headlineLargeEmphasized=" + this.headlineLargeEmphasized + ", headlineMediumEmphasized=" + this.headlineMediumEmphasized + ", headlineSmallEmphasized=" + this.headlineSmallEmphasized + ", titleLargeEmphasized=" + this.titleLargeEmphasized + ", titleMediumEmphasized=" + this.titleMediumEmphasized + ", titleSmallEmphasized=" + this.titleSmallEmphasized + ", bodyLargeEmphasized=" + this.bodyLargeEmphasized + ", bodyMediumEmphasized=" + this.bodyMediumEmphasized + ", bodySmallEmphasized=" + this.bodySmallEmphasized + ", labelLargeEmphasized=" + this.labelLargeEmphasized + ", labelMediumEmphasized=" + this.labelMediumEmphasized + ", labelSmallEmphasized=" + this.labelSmallEmphasized + ')';
    }

    public final TextStyle getBodyLarge() {
        return this.bodyLarge;
    }

    public final TextStyle getBodyLargeEmphasized$material3() {
        return this.bodyLargeEmphasized;
    }

    public final TextStyle getBodyMedium() {
        return this.bodyMedium;
    }

    public final TextStyle getBodyMediumEmphasized$material3() {
        return this.bodyMediumEmphasized;
    }

    public final TextStyle getBodySmall() {
        return this.bodySmall;
    }

    public final TextStyle getBodySmallEmphasized$material3() {
        return this.bodySmallEmphasized;
    }

    public final TextStyle getDisplayLarge() {
        return this.displayLarge;
    }

    public final TextStyle getDisplayLargeEmphasized$material3() {
        return this.displayLargeEmphasized;
    }

    public final TextStyle getDisplayMedium() {
        return this.displayMedium;
    }

    public final TextStyle getDisplayMediumEmphasized$material3() {
        return this.displayMediumEmphasized;
    }

    public final TextStyle getDisplaySmall() {
        return this.displaySmall;
    }

    public final TextStyle getDisplaySmallEmphasized$material3() {
        return this.displaySmallEmphasized;
    }

    public final TextStyle getHeadlineLarge() {
        return this.headlineLarge;
    }

    public final TextStyle getHeadlineLargeEmphasized$material3() {
        return this.headlineLargeEmphasized;
    }

    public final TextStyle getHeadlineMedium() {
        return this.headlineMedium;
    }

    public final TextStyle getHeadlineMediumEmphasized$material3() {
        return this.headlineMediumEmphasized;
    }

    public final TextStyle getHeadlineSmall() {
        return this.headlineSmall;
    }

    public final TextStyle getHeadlineSmallEmphasized$material3() {
        return this.headlineSmallEmphasized;
    }

    public final TextStyle getLabelLarge() {
        return this.labelLarge;
    }

    public final TextStyle getLabelLargeEmphasized$material3() {
        return this.labelLargeEmphasized;
    }

    public final TextStyle getLabelMedium() {
        return this.labelMedium;
    }

    public final TextStyle getLabelMediumEmphasized$material3() {
        return this.labelMediumEmphasized;
    }

    public final TextStyle getLabelSmall() {
        return this.labelSmall;
    }

    public final TextStyle getLabelSmallEmphasized$material3() {
        return this.labelSmallEmphasized;
    }

    public final TextStyle getTitleLarge() {
        return this.titleLarge;
    }

    public final TextStyle getTitleLargeEmphasized$material3() {
        return this.titleLargeEmphasized;
    }

    public final TextStyle getTitleMedium() {
        return this.titleMedium;
    }

    public final TextStyle getTitleMediumEmphasized$material3() {
        return this.titleMediumEmphasized;
    }

    public final TextStyle getTitleSmall() {
        return this.titleSmall;
    }

    public final TextStyle getTitleSmallEmphasized$material3() {
        return this.titleSmallEmphasized;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Typography) == true) goto L8;
        return false;
    L8:
        Typography r6 = (Typography) r5;
        if (Intrinsics.areEqual(this.displayLarge, r6.displayLarge) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayMedium, r6.displayMedium) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displaySmall, r6.displaySmall) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.headlineLarge, r6.headlineLarge) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.headlineMedium, r6.headlineMedium) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headlineSmall, r6.headlineSmall) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.titleLarge, r6.titleLarge) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.titleMedium, r6.titleMedium) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.titleSmall, r6.titleSmall) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bodyLarge, r6.bodyLarge) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.bodyMedium, r6.bodyMedium) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.bodySmall, r6.bodySmall) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.labelLarge, r6.labelLarge) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.labelMedium, r6.labelMedium) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.labelSmall, r6.labelSmall) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.displayLargeEmphasized, r6.displayLargeEmphasized) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.displayMediumEmphasized, r6.displayMediumEmphasized) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.displaySmallEmphasized, r6.displaySmallEmphasized) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.headlineLargeEmphasized, r6.headlineLargeEmphasized) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.headlineMediumEmphasized, r6.headlineMediumEmphasized) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.headlineSmallEmphasized, r6.headlineSmallEmphasized) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.titleLargeEmphasized, r6.titleLargeEmphasized) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.titleMediumEmphasized, r6.titleMediumEmphasized) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.titleSmallEmphasized, r6.titleSmallEmphasized) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.bodyLargeEmphasized, r6.bodyLargeEmphasized) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.bodyMediumEmphasized, r6.bodyMediumEmphasized) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.bodySmallEmphasized, r6.bodySmallEmphasized) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.labelLargeEmphasized, r6.labelLargeEmphasized) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.labelMediumEmphasized, r6.labelMediumEmphasized) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.labelSmallEmphasized, r6.labelSmallEmphasized) == true) goto L98;
        return false;
    L98:
        return true;
    }

    public Typography(TextStyle r32, TextStyle r33, TextStyle r34, TextStyle r35, TextStyle r36, TextStyle r37, TextStyle r38, TextStyle r39, TextStyle r40, TextStyle r41, TextStyle r42, TextStyle r43, TextStyle r44, TextStyle r45, TextStyle r46) {
        this(r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46);
    }

    public final Typography copy(TextStyle r33, TextStyle r34, TextStyle r35, TextStyle r36, TextStyle r37, TextStyle r38, TextStyle r39, TextStyle r40, TextStyle r41, TextStyle r42, TextStyle r43, TextStyle r44, TextStyle r45, TextStyle r46, TextStyle r47) {
        return copy$material3(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, this.displayLargeEmphasized, this.displayMediumEmphasized, this.displaySmallEmphasized, this.headlineLargeEmphasized, this.headlineMediumEmphasized, this.headlineSmallEmphasized, this.titleLargeEmphasized, this.titleMediumEmphasized, this.titleSmallEmphasized, this.bodyLargeEmphasized, this.bodyMediumEmphasized, this.bodySmallEmphasized, this.labelLargeEmphasized, this.labelMediumEmphasized, this.labelSmallEmphasized);
    }

    public /* synthetic */ Typography(TextStyle r16, TextStyle r17, TextStyle r18, TextStyle r19, TextStyle r20, TextStyle r21, TextStyle r22, TextStyle r23, TextStyle r24, TextStyle r25, TextStyle r26, TextStyle r27, TextStyle r28, TextStyle r29, TextStyle r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 1) == 0) goto L5;
        TextStyle r1 = TypographyTokens.INSTANCE.getDisplayLarge();
    L7:
        if ((r31 & 2) == 0) goto L9;
        TextStyle r2 = TypographyTokens.INSTANCE.getDisplayMedium();
    L11:
        if ((r31 & 4) == 0) goto L13;
        TextStyle r3 = TypographyTokens.INSTANCE.getDisplaySmall();
    L15:
        if ((r31 & 8) == 0) goto L17;
        TextStyle r4 = TypographyTokens.INSTANCE.getHeadlineLarge();
    L19:
        if ((r31 & 16) == 0) goto L21;
        TextStyle r5 = TypographyTokens.INSTANCE.getHeadlineMedium();
    L23:
        if ((r31 & 32) == 0) goto L25;
        TextStyle r6 = TypographyTokens.INSTANCE.getHeadlineSmall();
    L27:
        if ((r31 & 64) == 0) goto L29;
        TextStyle r7 = TypographyTokens.INSTANCE.getTitleLarge();
    L31:
        if ((r31 & 128) == 0) goto L33;
        TextStyle r8 = TypographyTokens.INSTANCE.getTitleMedium();
    L35:
        if ((r31 & 256) == 0) goto L37;
        TextStyle r9 = TypographyTokens.INSTANCE.getTitleSmall();
    L39:
        if ((r31 & 512) == 0) goto L41;
        TextStyle r10 = TypographyTokens.INSTANCE.getBodyLarge();
    L43:
        if ((r31 & 1024) == 0) goto L45;
        TextStyle r11 = TypographyTokens.INSTANCE.getBodyMedium();
    L47:
        if ((r31 & 2048) == 0) goto L49;
        TextStyle r12 = TypographyTokens.INSTANCE.getBodySmall();
    L51:
        if ((r31 & 4096) == 0) goto L53;
        TextStyle r13 = TypographyTokens.INSTANCE.getLabelLarge();
    L55:
        if ((r31 & 8192) == 0) goto L57;
        TextStyle r14 = TypographyTokens.INSTANCE.getLabelMedium();
    L59:
        if ((r31 & 16384) == 0) goto L61;
        TextStyle r0 = TypographyTokens.INSTANCE.getLabelSmall();
    L62:
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r0);
        return;
    L61:
        r0 = r30;
        goto L62
    L57:
        r14 = r29;
        goto L59
    L53:
        r13 = r28;
        goto L55
    L49:
        r12 = r27;
        goto L51
    L45:
        r11 = r26;
        goto L47
    L41:
        r10 = r25;
        goto L43
    L37:
        r9 = r24;
        goto L39
    L33:
        r8 = r23;
        goto L35
    L29:
        r7 = r22;
        goto L31
    L25:
        r6 = r21;
        goto L27
    L21:
        r5 = r20;
        goto L23
    L17:
        r4 = r19;
        goto L19
    L13:
        r3 = r18;
        goto L15
    L9:
        r2 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }

    public static /* synthetic */ Typography copy$default(Typography r16, TextStyle r17, TextStyle r18, TextStyle r19, TextStyle r20, TextStyle r21, TextStyle r22, TextStyle r23, TextStyle r24, TextStyle r25, TextStyle r26, TextStyle r27, TextStyle r28, TextStyle r29, TextStyle r30, TextStyle r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        TextStyle r2 = r16.displayLarge;
    L7:
        if ((r32 & 2) == 0) goto L9;
        TextStyle r3 = r16.displayMedium;
    L11:
        if ((r32 & 4) == 0) goto L13;
        TextStyle r4 = r16.displaySmall;
    L15:
        if ((r32 & 8) == 0) goto L17;
        TextStyle r5 = r16.headlineLarge;
    L19:
        if ((r32 & 16) == 0) goto L21;
        TextStyle r6 = r16.headlineMedium;
    L23:
        if ((r32 & 32) == 0) goto L25;
        TextStyle r7 = r16.headlineSmall;
    L27:
        if ((r32 & 64) == 0) goto L29;
        TextStyle r8 = r16.titleLarge;
    L31:
        if ((r32 & 128) == 0) goto L33;
        TextStyle r9 = r16.titleMedium;
    L35:
        if ((r32 & 256) == 0) goto L37;
        TextStyle r10 = r16.titleSmall;
    L39:
        if ((r32 & 512) == 0) goto L41;
        TextStyle r11 = r16.bodyLarge;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        TextStyle r12 = r16.bodyMedium;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        TextStyle r13 = r16.bodySmall;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        TextStyle r14 = r16.labelLarge;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        TextStyle r15 = r16.labelMedium;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        TextStyle r1 = r16.labelSmall;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L61:
        r1 = r31;
        goto L63
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public Typography(TextStyle r3, TextStyle r4, TextStyle r5, TextStyle r6, TextStyle r7, TextStyle r8, TextStyle r9, TextStyle r10, TextStyle r11, TextStyle r12, TextStyle r13, TextStyle r14, TextStyle r15, TextStyle r16, TextStyle r17, TextStyle r18, TextStyle r19, TextStyle r20, TextStyle r21, TextStyle r22, TextStyle r23, TextStyle r24, TextStyle r25, TextStyle r26, TextStyle r27, TextStyle r28, TextStyle r29, TextStyle r30, TextStyle r31, TextStyle r32) {
        this.displayLarge = r3;
        this.displayMedium = r4;
        this.displaySmall = r5;
        this.headlineLarge = r6;
        this.headlineMedium = r7;
        this.headlineSmall = r8;
        this.titleLarge = r9;
        this.titleMedium = r10;
        this.titleSmall = r11;
        this.bodyLarge = r12;
        this.bodyMedium = r13;
        this.bodySmall = r14;
        this.labelLarge = r15;
        this.labelMedium = r16;
        this.labelSmall = r17;
        this.displayLargeEmphasized = r18;
        this.displayMediumEmphasized = r19;
        this.displaySmallEmphasized = r20;
        this.headlineLargeEmphasized = r21;
        this.headlineMediumEmphasized = r22;
        this.headlineSmallEmphasized = r23;
        this.titleLargeEmphasized = r24;
        this.titleMediumEmphasized = r25;
        this.titleSmallEmphasized = r26;
        this.bodyLargeEmphasized = r27;
        this.bodyMediumEmphasized = r28;
        this.bodySmallEmphasized = r29;
        this.labelLargeEmphasized = r30;
        this.labelMediumEmphasized = r31;
        this.labelSmallEmphasized = r32;
    }

    public final Typography copy$material3(TextStyle r33, TextStyle r34, TextStyle r35, TextStyle r36, TextStyle r37, TextStyle r38, TextStyle r39, TextStyle r40, TextStyle r41, TextStyle r42, TextStyle r43, TextStyle r44, TextStyle r45, TextStyle r46, TextStyle r47, TextStyle r48, TextStyle r49, TextStyle r50, TextStyle r51, TextStyle r52, TextStyle r53, TextStyle r54, TextStyle r55, TextStyle r56, TextStyle r57, TextStyle r58, TextStyle r59, TextStyle r60, TextStyle r61, TextStyle r62) {
        return new Typography(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
    }

    public /* synthetic */ Typography(TextStyle r32, TextStyle r33, TextStyle r34, TextStyle r35, TextStyle r36, TextStyle r37, TextStyle r38, TextStyle r39, TextStyle r40, TextStyle r41, TextStyle r42, TextStyle r43, TextStyle r44, TextStyle r45, TextStyle r46, TextStyle r47, TextStyle r48, TextStyle r49, TextStyle r50, TextStyle r51, TextStyle r52, TextStyle r53, TextStyle r54, TextStyle r55, TextStyle r56, TextStyle r57, TextStyle r58, TextStyle r59, TextStyle r60, TextStyle r61, int r62, DefaultConstructorMarker r63) {
        if ((r62 & 1) == 0) goto L5;
        TextStyle r1 = TypographyTokens.INSTANCE.getDisplayLarge();
    L7:
        if ((r62 & 2) == 0) goto L9;
        TextStyle r2 = TypographyTokens.INSTANCE.getDisplayMedium();
    L11:
        if ((r62 & 4) == 0) goto L13;
        TextStyle r3 = TypographyTokens.INSTANCE.getDisplaySmall();
    L15:
        if ((r62 & 8) == 0) goto L17;
        TextStyle r4 = TypographyTokens.INSTANCE.getHeadlineLarge();
    L19:
        if ((r62 & 16) == 0) goto L21;
        TextStyle r5 = TypographyTokens.INSTANCE.getHeadlineMedium();
    L23:
        if ((r62 & 32) == 0) goto L25;
        TextStyle r6 = TypographyTokens.INSTANCE.getHeadlineSmall();
    L27:
        if ((r62 & 64) == 0) goto L29;
        TextStyle r7 = TypographyTokens.INSTANCE.getTitleLarge();
    L31:
        if ((r62 & 128) == 0) goto L33;
        TextStyle r8 = TypographyTokens.INSTANCE.getTitleMedium();
    L35:
        if ((r62 & 256) == 0) goto L37;
        TextStyle r9 = TypographyTokens.INSTANCE.getTitleSmall();
    L39:
        if ((r62 & 512) == 0) goto L41;
        TextStyle r10 = TypographyTokens.INSTANCE.getBodyLarge();
    L43:
        if ((r62 & 1024) == 0) goto L45;
        TextStyle r11 = TypographyTokens.INSTANCE.getBodyMedium();
    L47:
        if ((r62 & 2048) == 0) goto L49;
        TextStyle r12 = TypographyTokens.INSTANCE.getBodySmall();
    L51:
        if ((r62 & 4096) == 0) goto L53;
        TextStyle r13 = TypographyTokens.INSTANCE.getLabelLarge();
    L55:
        if ((r62 & 8192) == 0) goto L57;
        TextStyle r14 = TypographyTokens.INSTANCE.getLabelMedium();
    L59:
        if ((r62 & 16384) == 0) goto L61;
        TextStyle r15 = TypographyTokens.INSTANCE.getLabelSmall();
    L63:
        if ((r62 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        TextStyle r16 = TypographyTokens.INSTANCE.getDisplayLargeEmphasized();
    L67:
        if ((r62 & 65536) == 0) goto L69;
        TextStyle r17 = TypographyTokens.INSTANCE.getDisplayMediumEmphasized();
    L71:
        if ((r62 & 131072) == 0) goto L73;
        TextStyle r18 = TypographyTokens.INSTANCE.getDisplaySmallEmphasized();
    L75:
        if ((r62 & 262144) == 0) goto L77;
        TextStyle r19 = TypographyTokens.INSTANCE.getHeadlineLargeEmphasized();
    L79:
        if ((r62 & 524288) == 0) goto L81;
        TextStyle r20 = TypographyTokens.INSTANCE.getHeadlineMediumEmphasized();
    L83:
        if ((r62 & 1048576) == 0) goto L85;
        TextStyle r21 = TypographyTokens.INSTANCE.getHeadlineSmallEmphasized();
    L87:
        if ((r62 & 2097152) == 0) goto L89;
        TextStyle r22 = TypographyTokens.INSTANCE.getTitleLargeEmphasized();
    L91:
        if ((r62 & 4194304) == 0) goto L93;
        TextStyle r23 = TypographyTokens.INSTANCE.getTitleMediumEmphasized();
    L95:
        if ((r62 & 8388608) == 0) goto L97;
        TextStyle r24 = TypographyTokens.INSTANCE.getTitleSmallEmphasized();
    L99:
        if ((r62 & 16777216) == 0) goto L101;
        TextStyle r25 = TypographyTokens.INSTANCE.getBodyLargeEmphasized();
    L103:
        if ((r62 & 33554432) == 0) goto L105;
        TextStyle r26 = TypographyTokens.INSTANCE.getBodyMediumEmphasized();
    L107:
        if ((r62 & 67108864) == 0) goto L109;
        TextStyle r27 = TypographyTokens.INSTANCE.getBodySmallEmphasized();
    L111:
        if ((r62 & 134217728) == 0) goto L113;
        TextStyle r28 = TypographyTokens.INSTANCE.getLabelLargeEmphasized();
    L115:
        if ((r62 & 268435456) == 0) goto L117;
        TextStyle r29 = TypographyTokens.INSTANCE.getLabelMediumEmphasized();
    L119:
        if ((r62 & 536870912) == 0) goto L121;
        TextStyle r0 = TypographyTokens.INSTANCE.getLabelSmallEmphasized();
    L122:
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r0);
        return;
    L121:
        r0 = r61;
        goto L122
    L117:
        r29 = r60;
        goto L119
    L113:
        r28 = r59;
        goto L115
    L109:
        r27 = r58;
        goto L111
    L105:
        r26 = r57;
        goto L107
    L101:
        r25 = r56;
        goto L103
    L97:
        r24 = r55;
        goto L99
    L93:
        r23 = r54;
        goto L95
    L89:
        r22 = r53;
        goto L91
    L85:
        r21 = r52;
        goto L87
    L81:
        r20 = r51;
        goto L83
    L77:
        r19 = r50;
        goto L79
    L73:
        r18 = r49;
        goto L75
    L69:
        r17 = r48;
        goto L71
    L65:
        r16 = r47;
        goto L67
    L61:
        r15 = r46;
        goto L63
    L57:
        r14 = r45;
        goto L59
    L53:
        r13 = r44;
        goto L55
    L49:
        r12 = r43;
        goto L51
    L45:
        r11 = r42;
        goto L47
    L41:
        r10 = r41;
        goto L43
    L37:
        r9 = r40;
        goto L39
    L33:
        r8 = r39;
        goto L35
    L29:
        r7 = r38;
        goto L31
    L25:
        r6 = r37;
        goto L27
    L21:
        r5 = r36;
        goto L23
    L17:
        r4 = r35;
        goto L19
    L13:
        r3 = r34;
        goto L15
    L9:
        r2 = r33;
        goto L11
    L5:
        r1 = r32;
        goto L7
    }

    public static /* synthetic */ Typography copy$material3$default(Typography r17, TextStyle r18, TextStyle r19, TextStyle r20, TextStyle r21, TextStyle r22, TextStyle r23, TextStyle r24, TextStyle r25, TextStyle r26, TextStyle r27, TextStyle r28, TextStyle r29, TextStyle r30, TextStyle r31, TextStyle r32, TextStyle r33, TextStyle r34, TextStyle r35, TextStyle r36, TextStyle r37, TextStyle r38, TextStyle r39, TextStyle r40, TextStyle r41, TextStyle r42, TextStyle r43, TextStyle r44, TextStyle r45, TextStyle r46, TextStyle r47, int r48, Object r49) {
        if ((r48 & 1) == 0) goto L5;
        TextStyle r2 = r17.displayLarge;
    L7:
        if ((r48 & 2) == 0) goto L9;
        TextStyle r3 = r17.displayMedium;
    L11:
        if ((r48 & 4) == 0) goto L13;
        TextStyle r4 = r17.displaySmall;
    L15:
        if ((r48 & 8) == 0) goto L17;
        TextStyle r5 = r17.headlineLarge;
    L19:
        if ((r48 & 16) == 0) goto L21;
        TextStyle r6 = r17.headlineMedium;
    L23:
        if ((r48 & 32) == 0) goto L25;
        TextStyle r7 = r17.headlineSmall;
    L27:
        if ((r48 & 64) == 0) goto L29;
        TextStyle r8 = r17.titleLarge;
    L31:
        if ((r48 & 128) == 0) goto L33;
        TextStyle r9 = r17.titleMedium;
    L35:
        if ((r48 & 256) == 0) goto L37;
        TextStyle r10 = r17.titleSmall;
    L39:
        if ((r48 & 512) == 0) goto L41;
        TextStyle r11 = r17.bodyLarge;
    L43:
        if ((r48 & 1024) == 0) goto L45;
        TextStyle r12 = r17.bodyMedium;
    L47:
        if ((r48 & 2048) == 0) goto L49;
        TextStyle r13 = r17.bodySmall;
    L51:
        if ((r48 & 4096) == 0) goto L53;
        TextStyle r14 = r17.labelLarge;
    L55:
        if ((r48 & 8192) == 0) goto L57;
        TextStyle r15 = r17.labelMedium;
    L58:
        TextStyle r310 = r15;
        if ((r48 & 16384) == 0) goto L61;
        TextStyle r16 = r17.labelSmall;
    L62:
        TextStyle r311 = r16;
        if ((r48 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L65;
        TextStyle r110 = r17.displayLargeEmphasized;
    L66:
        TextStyle r312 = r110;
        if ((r48 & 65536) == 0) goto L69;
        TextStyle r111 = r17.displayMediumEmphasized;
    L70:
        TextStyle r313 = r111;
        if ((r48 & 131072) == 0) goto L73;
        TextStyle r112 = r17.displaySmallEmphasized;
    L74:
        TextStyle r314 = r112;
        if ((r48 & 262144) == 0) goto L77;
        TextStyle r113 = r17.headlineLargeEmphasized;
    L78:
        TextStyle r315 = r113;
        if ((r48 & 524288) == 0) goto L81;
        TextStyle r114 = r17.headlineMediumEmphasized;
    L82:
        TextStyle r316 = r114;
        if ((r48 & 1048576) == 0) goto L85;
        TextStyle r115 = r17.headlineSmallEmphasized;
    L86:
        TextStyle r317 = r115;
        if ((r48 & 2097152) == 0) goto L89;
        TextStyle r116 = r17.titleLargeEmphasized;
    L90:
        TextStyle r318 = r116;
        if ((r48 & 4194304) == 0) goto L93;
        TextStyle r117 = r17.titleMediumEmphasized;
    L94:
        TextStyle r410 = r117;
        if ((r48 & 8388608) == 0) goto L97;
        TextStyle r118 = r17.titleSmallEmphasized;
    L98:
        TextStyle r411 = r118;
        if ((r48 & 16777216) == 0) goto L101;
        TextStyle r119 = r17.bodyLargeEmphasized;
    L102:
        TextStyle r412 = r119;
        if ((r48 & 33554432) == 0) goto L105;
        TextStyle r120 = r17.bodyMediumEmphasized;
    L106:
        TextStyle r413 = r120;
        if ((r48 & 67108864) == 0) goto L109;
        TextStyle r121 = r17.bodySmallEmphasized;
    L110:
        TextStyle r414 = r121;
        if ((r48 & 134217728) == 0) goto L113;
        TextStyle r122 = r17.labelLargeEmphasized;
    L114:
        TextStyle r415 = r122;
        if ((r48 & 268435456) == 0) goto L117;
        TextStyle r123 = r17.labelMediumEmphasized;
    L119:
        if ((r48 & 536870912) == 0) goto L121;
        TextStyle r1 = r17.labelSmallEmphasized;
    L123:
        return r17.copy$material3(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r123, r1);
    L121:
        r1 = r47;
        goto L123
    L117:
        r123 = r46;
        goto L119
    L113:
        r122 = r45;
        goto L114
    L109:
        r121 = r44;
        goto L110
    L105:
        r120 = r43;
        goto L106
    L101:
        r119 = r42;
        goto L102
    L97:
        r118 = r41;
        goto L98
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
