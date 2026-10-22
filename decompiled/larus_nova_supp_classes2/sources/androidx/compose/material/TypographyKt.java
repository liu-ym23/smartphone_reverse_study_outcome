package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.LineHeightStyle;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"withDefaultFontFamily", "Landroidx/compose/ui/text/TextStyle;", "default", "Landroidx/compose/ui/text/font/FontFamily;", "DefaultLineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefaultLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "DefaultTextStyle", "getDefaultTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "LocalTypography", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Typography;", "getLocalTypography", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TypographyKt {
    private static final LineHeightStyle DefaultLineHeightStyle = null;
    private static final TextStyle DefaultTextStyle = null;
    private static final ProvidableCompositionLocal<Typography> LocalTypography = null;

    public static /* synthetic */ Typography a() {
        return LocalTypography$lambda$0();
    }

    static {
        LineHeightStyle r0 = new LineHeightStyle(LineHeightStyle.Alignment.Companion.getCenter-PIaL0Z0(), LineHeightStyle.Trim.Companion.getNone-EVpEnUU(), null);
        DefaultLineHeightStyle = r0;
        DefaultTextStyle = TextStyle.copy-p1EtxEg$default(TextStyle.Companion.getDefault(), 0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, DefaultPlatformTextStyle_androidKt.defaultPlatformTextStyle(), r0, 0, 0, null, 15204351, null);
        LocalTypography = CompositionLocalKt.staticCompositionLocalOf(new zd());
    }

    private static final Typography LocalTypography$lambda$0() {
        return new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public static final LineHeightStyle getDefaultLineHeightStyle() {
        return DefaultLineHeightStyle;
    }

    public static final TextStyle getDefaultTextStyle() {
        return DefaultTextStyle;
    }

    public static final ProvidableCompositionLocal<Typography> getLocalTypography() {
        return LocalTypography;
    }

    public static final /* synthetic */ TextStyle access$withDefaultFontFamily(TextStyle r0, FontFamily r1) {
        return withDefaultFontFamily(r0, r1);
    }

    private static final TextStyle withDefaultFontFamily(TextStyle r33, FontFamily r34) {
        if (r33.getFontFamily() == null) goto L6;
        return r33;
    L6:
        return TextStyle.copy-p1EtxEg$default(r33, 0, 0, null, null, null, r34, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777183, null);
    }
}
