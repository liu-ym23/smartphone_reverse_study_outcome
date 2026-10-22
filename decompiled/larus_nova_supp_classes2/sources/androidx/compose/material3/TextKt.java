package androidx.compose.material3;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.tokens.TypographyTokensKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b$\u0010%\u001aï\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b*\u0010+\u001aÏ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b,\u0010-\u001aã\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b.\u0010/\u001aÃ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b0\u00101\u001aÙ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b,\u00102\u001a(\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020#2\u0011\u00109\u001a\r\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010<\u001a\u0018\u0010=\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020&2\u0006\u0010>\u001a\u00020?H\u0002\u001a\r\u0010@\u001a\u00020?H\u0003¢\u0006\u0002\u0010A\"\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020#04¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006B"}, d2 = {"Text", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Landroidx/compose/ui/text/TextStyle;", "Text-Nvy7gAk", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/text/TextAutoSize;JLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "Text-Z58ophY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/text/TextAutoSize;JLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createTextWithLinkStyles", "linkStyles", "Landroidx/compose/ui/text/TextLinkStyles;", "rememberTextLinkStyles", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextLinkStyles;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = null;

    private static final Unit ProvideTextStyle$lambda$20(TextStyle r0, Function2 r1, int r2, Composer r3, int r4) {
        ProvideTextStyle(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Text_IbK3jfQ$lambda$12(AnnotatedString r26, Modifier r27, long r28, long r30, FontStyle r32, FontWeight r33, FontFamily r34, long r35, TextDecoration r37, TextAlign r38, long r39, int r41, boolean r42, int r43, int r44, Map r45, Function1 r46, TextStyle r47, int r48, int r49, int r50, Composer r51, int r52) {
        m3362TextIbK3jfQ(r26, r27, r28, r30, r32, r33, r34, r35, r37, r38, r39, r41, r42, r43, r44, r45, r46, r47, r51, RecomposeScopeImplKt.updateChangedFlags(r48 | 1), RecomposeScopeImplKt.updateChangedFlags(r49), r50);
        return Unit.INSTANCE;
    }

    private static final Unit Text_Nvy7gAk$lambda$2(String r26, Modifier r27, long r28, TextAutoSize r30, long r31, FontStyle r33, FontWeight r34, FontFamily r35, long r36, TextDecoration r38, TextAlign r39, long r40, int r42, boolean r43, int r44, int r45, Function1 r46, TextStyle r47, int r48, int r49, int r50, Composer r51, int r52) {
        m3363TextNvy7gAk(r26, r27, r28, r30, r31, r33, r34, r35, r36, r38, r39, r40, r42, r43, r44, r45, r46, r47, r51, RecomposeScopeImplKt.updateChangedFlags(r48 | 1), RecomposeScopeImplKt.updateChangedFlags(r49), r50);
        return Unit.INSTANCE;
    }

    private static final Unit Text_Z58ophY$lambda$8(AnnotatedString r27, Modifier r28, long r29, TextAutoSize r31, long r32, FontStyle r34, FontWeight r35, FontFamily r36, long r37, TextDecoration r39, TextAlign r40, long r41, int r43, boolean r44, int r45, int r46, Map r47, Function1 r48, TextStyle r49, int r50, int r51, int r52, Composer r53, int r54) {
        m3364TextZ58ophY(r27, r28, r29, r31, r32, r34, r35, r36, r37, r39, r40, r41, r43, r44, r45, r46, r47, r48, r49, r53, RecomposeScopeImplKt.updateChangedFlags(r50 | 1), RecomposeScopeImplKt.updateChangedFlags(r51), r52);
        return Unit.INSTANCE;
    }

    private static final Unit Text__4IGK_g$lambda$18(AnnotatedString r25, Modifier r26, long r27, long r29, FontStyle r31, FontWeight r32, FontFamily r33, long r34, TextDecoration r36, TextAlign r37, long r38, int r40, boolean r41, int r42, Map r43, Function1 r44, TextStyle r45, int r46, int r47, int r48, Composer r49, int r50) {
        m3360Text4IGK_g(r25, r26, r27, r29, r31, r32, r33, r34, r36, r37, r38, r40, r41, r42, r43, r44, r45, r49, RecomposeScopeImplKt.updateChangedFlags(r46 | 1), RecomposeScopeImplKt.updateChangedFlags(r47), r48);
        return Unit.INSTANCE;
    }

    private static final Unit Text__4IGK_g$lambda$9(String r25, Modifier r26, long r27, long r29, FontStyle r31, FontWeight r32, FontFamily r33, long r34, TextDecoration r36, TextAlign r37, long r38, int r40, boolean r41, int r42, int r43, Function1 r44, TextStyle r45, int r46, int r47, int r48, Composer r49, int r50) {
        m3361Text4IGK_g(r25, r26, r27, r29, r31, r32, r33, r34, r36, r37, r38, r40, r41, r42, r43, r44, r45, r49, RecomposeScopeImplKt.updateChangedFlags(r46 | 1), RecomposeScopeImplKt.updateChangedFlags(r47), r48);
        return Unit.INSTANCE;
    }

    private static final Unit Text_fLXpl1I$lambda$15(String r24, Modifier r25, long r26, long r28, FontStyle r30, FontWeight r31, FontFamily r32, long r33, TextDecoration r35, TextAlign r36, long r37, int r39, boolean r40, int r41, Function1 r42, TextStyle r43, int r44, int r45, int r46, Composer r47, int r48) {
        m3365TextfLXpl1I(r24, r25, r26, r28, r30, r31, r32, r33, r35, r36, r37, r39, r40, r41, r42, r43, r47, RecomposeScopeImplKt.updateChangedFlags(r44 | 1), RecomposeScopeImplKt.updateChangedFlags(r45), r46);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(AnnotatedString r1, Modifier r2, long r3, TextAutoSize r5, long r6, FontStyle r8, FontWeight r9, FontFamily r10, long r11, TextDecoration r13, TextAlign r14, long r15, int r17, boolean r18, int r19, int r20, Map r21, Function1 r22, TextStyle r23, int r24, int r25, int r26, Composer r27, int r28) {
        return Text_Z58ophY$lambda$8(r1, r2, r3, r5, r6, r8, r9, r10, r11, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public static /* synthetic */ Unit b(TextStyle r0, Function2 r1, int r2, Composer r3, int r4) {
        return ProvideTextStyle$lambda$20(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit c(TextLayoutResult r0) {
        return Text_fLXpl1I$lambda$14$lambda$13(r0);
    }

    public static /* synthetic */ Unit d(TextLayoutResult r0) {
        return Text_Z58ophY$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ Unit e(String r1, Modifier r2, long r3, TextAutoSize r5, long r6, FontStyle r8, FontWeight r9, FontFamily r10, long r11, TextDecoration r13, TextAlign r14, long r15, int r17, boolean r18, int r19, int r20, Function1 r21, TextStyle r22, int r23, int r24, int r25, Composer r26, int r27) {
        return Text_Nvy7gAk$lambda$2(r1, r2, r3, r5, r6, r8, r9, r10, r11, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    }

    public static /* synthetic */ Unit f(String r1, Modifier r2, long r3, long r5, FontStyle r7, FontWeight r8, FontFamily r9, long r10, TextDecoration r12, TextAlign r13, long r14, int r16, boolean r17, int r18, int r19, Function1 r20, TextStyle r21, int r22, int r23, int r24, Composer r25, int r26) {
        return Text__4IGK_g$lambda$9(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public static /* synthetic */ TextStyle g() {
        return LocalTextStyle$lambda$19();
    }

    public static /* synthetic */ Unit h(AnnotatedString r1, Modifier r2, long r3, long r5, FontStyle r7, FontWeight r8, FontFamily r9, long r10, TextDecoration r12, TextAlign r13, long r14, int r16, boolean r17, int r18, Map r19, Function1 r20, TextStyle r21, int r22, int r23, int r24, Composer r25, int r26) {
        return Text__4IGK_g$lambda$18(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public static /* synthetic */ AnnotatedString.Range i(TextLinkStyles r0, AnnotatedString.Range r1) {
        return createTextWithLinkStyles$lambda$21(r0, r1);
    }

    public static /* synthetic */ Unit j(AnnotatedString r1, Modifier r2, long r3, long r5, FontStyle r7, FontWeight r8, FontFamily r9, long r10, TextDecoration r12, TextAlign r13, long r14, int r16, boolean r17, int r18, int r19, Map r20, Function1 r21, TextStyle r22, int r23, int r24, int r25, Composer r26, int r27) {
        return Text_IbK3jfQ$lambda$12(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    }

    public static /* synthetic */ Unit k(TextLayoutResult r0) {
        return Text__4IGK_g$lambda$17$lambda$16(r0);
    }

    public static /* synthetic */ Unit l(String r1, Modifier r2, long r3, long r5, FontStyle r7, FontWeight r8, FontFamily r9, long r10, TextDecoration r12, TextAlign r13, long r14, int r16, boolean r17, int r18, Function1 r19, TextStyle r20, int r21, int r22, int r23, Composer r24, int r25) {
        return Text_fLXpl1I$lambda$15(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ Unit m(TextLayoutResult r0) {
        return Text_IbK3jfQ$lambda$11$lambda$10(r0);
    }

    static {
        LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new ut());
    }

    private static final TextStyle LocalTextStyle$lambda$19() {
        return TypographyTokensKt.getDefaultTextStyle();
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    private static final Unit Text_IbK3jfQ$lambda$11$lambda$10(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final Unit Text_Z58ophY$lambda$4$lambda$3(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final Unit Text__4IGK_g$lambda$17$lambda$16(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final Unit Text_fLXpl1I$lambda$14$lambda$13(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final AnnotatedString createTextWithLinkStyles(AnnotatedString r1, final TextLinkStyles r2) {
        return r1.mapAnnotations(new bu(r2));
    }

    private static final AnnotatedString.Range createTextWithLinkStyles$lambda$21(TextLinkStyles r9, AnnotatedString.Range r10) {
        LinkAnnotation.Url r1 = (AnnotatedString.Annotation) r10.getItem();
        if ((r1 instanceof LinkAnnotation.Url) == false) goto L8;
        LinkAnnotation.Url r3 = r1;
        if (r3.getStyles() != null) goto L8;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation.Url>");
        return AnnotatedString.Range.copy$default(r10, LinkAnnotation.Url.copy$default(r3, null, r9, null, 5, null), 0, 0, null, 14, null);
    L8:
        if ((r1 instanceof LinkAnnotation.Clickable) == false) goto L13;
        LinkAnnotation.Clickable r4 = (LinkAnnotation.Clickable) r1;
        if (r4.getStyles() != null) goto L13;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation.Clickable>");
        return AnnotatedString.Range.copy$default(r10, LinkAnnotation.Clickable.copy$default(r4, null, r9, null, 5, null), 0, 0, null, 14, null);
    L13:
        return r10;
    }

    private static final TextLinkStyles rememberTextLinkStyles(Composer r26, int r27) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1113329403, r27, -1, "androidx.compose.material3.rememberTextLinkStyles (Text.kt:481)");
    L5:
        long r3 = MaterialTheme.INSTANCE.getColorScheme(r26, 6).m2471getPrimary0d7_KjU();
        boolean r1 = r26.changed(r3);
        Object r2 = r26.rememberedValue();
        if (r1 == false) goto L8;
    L9:
        TextLinkStyles r4 = new TextLinkStyles(new SpanStyle(r3, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getUnderline(), null, null, null, 61438, null), null, null, null, 14, null);
        r26.updateRememberedValue(r4);
        r2 = r4;
    L10:
        TextLinkStyles r5 = (TextLinkStyles) r2;
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r5;
    L8:
        if (r2 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public static final void ProvideTextStyle(final TextStyle r4, final Function2<? super Composer, ? super Integer, Unit> r5, Composer r6, final int r7) {
        Composer r8 = r6.startRestartGroup(15327438);
        if ((r7 & 6) == 0) goto L5;
        int r1 = r7;
    L11:
        if ((r7 & 48) != 0) goto L18;
        if (r8.changedInstance(r5) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r8.shouldExecute(r3, r1 & 1) == true) goto L24;
        r8.skipToGroupEnd();
    L30:
        ScopeUpdateScope r9 = r8.endRestartGroup();
        if (r9 == null) goto L34;
        r9.updateScope(new xt(r4, r5, r7));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(15327438, r1, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:459)");
    L26:
        ProvidableCompositionLocal<TextStyle> r0 = LocalTextStyle;
        int r10 = r1 & 112;
        CompositionLocalKt.CompositionLocalProvider(r0.provides(((TextStyle) r8.consume(r0)).merge(r4)), r5, r8, r10 | ProvidedValue.$stable);
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r3 = false;
        goto L22
    L5:
        if (r8.changed(r4) == false) goto L7;
        int r11 = 4;
    L8:
        r1 = r11 | r7;
        goto L11
    L7:
        r11 = 2;
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* JADX INFO: renamed from: Text-fLXpl1I, reason: not valid java name */
    public static final /* synthetic */ void m3365TextfLXpl1I(final String r55, Modifier r56, long r57, long r59, FontStyle r61, FontWeight r62, FontFamily r63, long r64, TextDecoration r66, TextAlign r67, long r68, int r70, boolean r71, int r72, Function1 r73, TextStyle r74, Composer r75, final int r76, final int r77, final int r78) {
        Composer r1 = r75.startRestartGroup(1968784669);
        if ((r78 & 1) == 0) goto L6;
        int r5 = r76 | 6;
    L13:
        int r6 = r78 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r10 = r78 & 4;
        if (r10 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        int r17 = r78 & 8;
        int r18 = 2048;
        if (r17 == 0) goto L38;
        r5 = r5 | 3072;
    L44:
        int r22 = r78 & 16;
        int r23 = 16384;
        if (r22 == 0) goto L48;
        r5 = r5 | 24576;
    L55:
        int r26 = r78 & 32;
        int r27 = 65536;
        if (r26 == 0) goto L59;
        r5 = r5 | 196608;
    L65:
        int r30 = r78 & 64;
        if (r30 == 0) goto L69;
        r5 = r5 | 1572864;
    L75:
        int r0 = r78 & 128;
        if (r0 == 0) goto L79;
        r5 = r5 | 12582912;
    L85:
        int r2 = r78 & 256;
        if (r2 == 0) goto L89;
        r5 = r5 | 100663296;
    L96:
        int r3 = r78 & 512;
        if (r3 == 0) goto L100;
        r5 = r5 | 805306368;
    L106:
        int r4 = r78 & 1024;
        if (r4 == 0) goto L110;
        int r29 = r77 | 6;
    L117:
        int r7 = r78 & 2048;
        if (r7 == 0) goto L121;
        r29 = r29 | 48;
    L128:
        int r8 = r29;
        int r9 = r78 & 4096;
        if (r9 == 0) goto L132;
        r8 = r8 | 384;
    L139:
        int r12 = r78 & 8192;
        if (r12 == 0) goto L143;
        r8 = r8 | 3072;
    L150:
        int r11 = r78 & 16384;
        if (r11 == 0) goto L153;
        r8 = r8 | 24576;
        int r16 = r11;
    L162:
        if ((r77 & 196608) != 0) goto L170;
        if ((r78 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L166;
    L168:
        r8 = r8 | r27;
        goto L170
    L166:
        if (r1.changed(r74) == false) goto L168;
        r27 = 131072;
    L170:
        boolean r19 = true;
        if ((r5 & 306783379) == 306783378) goto L173;
    L176:
        boolean r13 = true;
    L178:
        if (r1.shouldExecute(r13, r5 & 1) == false) goto L246;
        r1.startDefaults();
        if ((r76 & 1) != 0) goto L182;
    L188:
        if (r6 == 0) goto L190;
        Modifier r14 = Modifier.Companion;
    L191:
        if (r10 == 0) goto L193;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L194:
        if (r17 == 0) goto L196;
        long r20 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L197:
        TextAlign r110 = null;
        if (r22 == 0) goto L200;
        FontStyle r111 = null;
    L201:
        if (r26 == 0) goto L203;
        FontWeight r24 = null;
    L204:
        if (r30 == 0) goto L206;
        FontFamily r25 = null;
    L207:
        if (r0 == 0) goto L209;
        long r28 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L210:
        if (r2 == 0) goto L212;
        TextDecoration r21 = null;
    L213:
        if (r3 != 0) goto L216;
        r110 = r67;
    L216:
        if (r4 == 0) goto L218;
        long r31 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L219:
        if (r7 == 0) goto L221;
        int r32 = TextOverflow.Companion.getClip-gIe3tQ8();
    L222:
        if (r9 != 0) goto L225;
        r19 = r71;
    L225:
        if (r12 == 0) goto L227;
        int r33 = Integer.MAX_VALUE;
    L228:
        if (r16 == 0) goto L233;
        Object r34 = r1.rememberedValue();
        if (r34 != Composer.Companion.getEmpty()) goto L232;
        r34 = new fu();
        r1.updateRememberedValue(r34);
    L232:
        Function1 r35 = (Function1) r34;
    L235:
        if ((r78 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L237;
        long r42 = r31;
        int r44 = r32;
        int r46 = r33;
        int r112 = r8 & (-458753);
        Function1 r47 = r35;
        TextStyle r48 = (TextStyle) r1.consume(LocalTextStyle);
        boolean r45 = r19;
        long r36 = r20;
        FontWeight r37 = r24;
        FontFamily r38 = r25;
        long r39 = r28;
        final TextDecoration r113 = r21;
        FontStyle r40 = r111;
    L238:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L242;
        ComposerKt.traceEventStart(1968784669, r5, r112, "androidx.compose.material3.Text (Text.kt:373)");
    L242:
        int r114 = r5 << 3;
        int r310 = ((((((((r5 & 14) | (r5 & 112)) | (r5 & 896)) | (r114 & 57344)) | (r114 & 458752)) | (r114 & 3670016)) | (r114 & 29360128)) | (r114 & 234881024)) | (r114 & 1879048192);
        int r41 = ((r5 >> 27) & 14) | 196608;
        int r43 = r112 << 3;
        int r49 = (((r41 | (r43 & 112)) | (r43 & 896)) | (r43 & 7168)) | (r43 & 57344);
        int r50 = r112 << 6;
        m3363TextNvy7gAk(r55, r14, r15, null, r36, r40, r37, r38, r39, r113, r110, r42, r44, r45, r46, 1, r47, r48, r1, r310, (r49 | (3670016 & r50)) | (r50 & 29360128), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L245;
        ComposerKt.traceEventEnd();
    L245:
        final TextAlign r115 = r110;
        final long r116 = r42;
        final int r117 = r44;
        final boolean r118 = r45;
        final int r119 = r46;
        final Function1 r120 = r47;
        final TextStyle r210 = r48;
        FontFamily r51 = r38;
        final FontStyle r52 = r40;
        long r53 = r39;
        final FontWeight r54 = r37;
        final FontFamily r58 = r51;
        long r510 = r36;
        final Modifier r60 = r14;
        final long r65 = r510;
        final long r69 = r15;
        final long r121 = r53;
    L247:
        ScopeUpdateScope r79 = r1.endRestartGroup();
        if (r79 == null) goto L251;
        r79.updateScope(new gu(r55, r60, r69, r65, r52, r54, r58, r121, r113, r115, r116, r117, r118, r119, r120, r210, r76, r77, r78));
        return;
    L251:
        return;
    L237:
        r48 = r74;
        r113 = r21;
        r42 = r31;
        r44 = r32;
        r46 = r33;
        r112 = r8;
        r47 = r35;
        r40 = r111;
        r45 = r19;
        r36 = r20;
        r37 = r24;
        r38 = r25;
        r39 = r28;
        goto L238
    L233:
        r35 = r73;
        goto L235
    L227:
        r33 = r72;
        goto L228
    L221:
        r32 = r70;
        goto L222
    L218:
        r31 = r68;
        goto L219
    L212:
        r21 = r66;
        goto L213
    L209:
        r28 = r64;
        goto L210
    L206:
        r25 = r63;
        goto L207
    L203:
        r24 = r62;
        goto L204
    L200:
        r111 = r61;
        goto L201
    L196:
        r20 = r59;
        goto L197
    L193:
        r15 = r57;
        goto L194
    L190:
        r14 = r56;
        goto L191
    L182:
        if (r1.getDefaultsInvalid() == true) goto L188;
        r1.skipToGroupEnd();
        if ((r78 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L187;
        r8 = r8 & (-458753);
    L187:
        r14 = r56;
        r15 = r57;
        r36 = r59;
        r40 = r61;
        r37 = r62;
        r38 = r63;
        r113 = r66;
        r110 = r67;
        r42 = r68;
        r44 = r70;
        r45 = r71;
        r46 = r72;
        r47 = r73;
        r48 = r74;
        r112 = r8;
        r39 = r64;
        goto L238
    L246:
        r1 = r1;
        r1.skipToGroupEnd();
        r60 = r56;
        r69 = r57;
        r65 = r59;
        r52 = r61;
        r54 = r62;
        r58 = r63;
        r121 = r64;
        r113 = r66;
        r115 = r67;
        r116 = r68;
        r117 = r70;
        r118 = r71;
        r119 = r72;
        r120 = r73;
        r210 = r74;
        goto L247
    L173:
        if ((74899 & r8) != 74898) goto L176;
        r13 = false;
        goto L178
    L153:
        r16 = r11;
        if ((r77 & 24576) != 0) goto L162;
        if (r1.changedInstance(r73) == true) goto L159;
        r23 = 8192;
    L159:
        r8 = r8 | r23;
        goto L162
    L143:
        if ((r77 & 3072) != 0) goto L150;
        if (r1.changed(r72) == true) goto L148;
        r18 = 1024;
    L148:
        r8 = r8 | r18;
        goto L150
    L132:
        if ((r77 & 384) != 0) goto L139;
        if (r1.changed(r71) == false) goto L136;
        int r211 = 256;
    L137:
        r8 = r8 | r211;
        goto L139
    L136:
        r211 = 128;
        goto L137
    L121:
        if ((r77 & 48) != 0) goto L128;
        if (r1.changed(r70) == false) goto L125;
        int r122 = 32;
    L126:
        r29 = r29 | r122;
        goto L128
    L125:
        r122 = 16;
        goto L126
    L110:
        if ((r77 & 6) == 0) goto L112;
        r29 = r77;
        goto L117
    L112:
        if (r1.changed(r68) == false) goto L114;
        int r212 = 4;
    L115:
        r29 = r77 | r212;
        goto L117
    L114:
        r212 = 2;
        goto L115
    L100:
        if ((r76 & 805306368) != 0) goto L106;
        if (r1.changed(r67) == false) goto L104;
        int r311 = 536870912;
    L105:
        r5 = r5 | r311;
        goto L106
    L104:
        r311 = 268435456;
        goto L105
    L89:
        if ((100663296 & r76) != 0) goto L96;
        if (r1.changed(r66) == false) goto L93;
        int r312 = 67108864;
    L94:
        r5 = r5 | r312;
        goto L96
    L93:
        r312 = 33554432;
        goto L94
    L79:
        if ((r76 & 12582912) != 0) goto L85;
        if (r1.changed(r64) == false) goto L83;
        int r313 = 8388608;
    L84:
        r5 = r5 | r313;
        goto L85
    L83:
        r313 = 4194304;
        goto L84
    L69:
        if ((r76 & 1572864) != 0) goto L75;
        if (r1.changed(r63) == false) goto L73;
        int r314 = 1048576;
    L74:
        r5 = r5 | r314;
        goto L75
    L73:
        r314 = 524288;
        goto L74
    L59:
        if ((r76 & 196608) != 0) goto L65;
        if (r1.changed(r62) == false) goto L63;
        int r315 = 131072;
    L64:
        r5 = r5 | r315;
        goto L65
    L63:
        r315 = 65536;
        goto L64
    L48:
        if ((r76 & 24576) != 0) goto L55;
        if (r1.changed(r61) == false) goto L52;
        int r213 = 16384;
    L53:
        r5 = r5 | r213;
        goto L55
    L52:
        r213 = 8192;
        goto L53
    L38:
        if ((r76 & 3072) != 0) goto L44;
        if (r1.changed(r59) == false) goto L42;
        int r214 = 2048;
    L43:
        r5 = r5 | r214;
        goto L44
    L42:
        r214 = 1024;
        goto L43
    L28:
        if ((r76 & 384) != 0) goto L34;
        if (r1.changed(r57) == false) goto L32;
        int r123 = 256;
    L33:
        r5 = r5 | r123;
        goto L34
    L32:
        r123 = 128;
        goto L33
    L17:
        if ((r76 & 48) != 0) goto L24;
        if (r1.changed(r56) == false) goto L21;
        int r124 = 32;
    L22:
        r5 = r5 | r124;
        goto L24
    L21:
        r124 = 16;
        goto L22
    L6:
        if ((r76 & 6) == 0) goto L8;
        r5 = r76;
        goto L13
    L8:
        if (r1.changed(r55) == false) goto L10;
        int r80 = 4;
    L11:
        r5 = r80 | r76;
        goto L13
    L10:
        r80 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    public static final /* synthetic */ void m3360Text4IGK_g(final AnnotatedString r57, Modifier r58, long r59, long r61, FontStyle r63, FontWeight r64, FontFamily r65, long r66, TextDecoration r68, TextAlign r69, long r70, int r72, boolean r73, int r74, Map r75, Function1 r76, TextStyle r77, Composer r78, final int r79, final int r80, final int r81) {
        Composer r1 = r78.startRestartGroup(224529679);
        if ((r81 & 1) == 0) goto L6;
        int r5 = r79 | 6;
    L13:
        int r6 = r81 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r10 = r81 & 4;
        if (r10 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        int r17 = r81 & 8;
        int r18 = 2048;
        if (r17 == 0) goto L38;
        r5 = r5 | 3072;
    L44:
        int r22 = r81 & 16;
        int r23 = 16384;
        if (r22 == 0) goto L48;
        r5 = r5 | 24576;
    L55:
        int r26 = r81 & 32;
        int r27 = 131072;
        if (r26 == 0) goto L59;
        r5 = r5 | 196608;
    L65:
        int r31 = r81 & 64;
        if (r31 == 0) goto L69;
        r5 = r5 | 1572864;
    L75:
        int r0 = r81 & 128;
        if (r0 == 0) goto L79;
        r5 = r5 | 12582912;
    L85:
        int r2 = r81 & 256;
        if (r2 == 0) goto L89;
        r5 = r5 | 100663296;
    L96:
        int r3 = r81 & 512;
        if (r3 == 0) goto L100;
        r5 = r5 | 805306368;
    L106:
        int r4 = r81 & 1024;
        if (r4 == 0) goto L110;
        int r30 = r80 | 6;
    L117:
        int r7 = r81 & 2048;
        if (r7 == 0) goto L121;
        r30 = r30 | 48;
    L128:
        int r8 = r30;
        int r9 = r81 & 4096;
        if (r9 == 0) goto L132;
        r8 = r8 | 384;
    L139:
        int r12 = r81 & 8192;
        if (r12 == 0) goto L143;
        r8 = r8 | 3072;
    L150:
        int r11 = r81 & 16384;
        if (r11 == 0) goto L153;
        r8 = r8 | 24576;
        int r16 = r11;
    L161:
        int r19 = r81 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r19 == 0) goto L165;
        r8 = r8 | 196608;
    L172:
        if ((r80 & 1572864) != 0) goto L181;
        if ((r81 & 65536) == 0) goto L176;
    L178:
        int r110 = 524288;
    L179:
        r8 = r8 | r110;
        goto L181
    L176:
        if (r1.changed(r77) == false) goto L178;
        r110 = 1048576;
    L181:
        boolean r111 = true;
        if ((r5 & 306783379) == 306783378) goto L184;
    L187:
        boolean r13 = true;
    L189:
        if (r1.shouldExecute(r13, r5 & 1) == false) goto L260;
        r1.startDefaults();
        if ((r79 & 1) != 0) goto L193;
    L199:
        if (r6 == 0) goto L201;
        Modifier r14 = Modifier.Companion;
    L202:
        if (r10 == 0) goto L204;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L205:
        if (r17 == 0) goto L207;
        long r20 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L208:
        TextAlign r112 = null;
        if (r22 == 0) goto L211;
        FontStyle r113 = null;
    L212:
        if (r26 == 0) goto L214;
        FontWeight r24 = null;
    L215:
        if (r31 == 0) goto L217;
        FontFamily r25 = null;
    L218:
        if (r0 == 0) goto L220;
        long r28 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L221:
        if (r2 == 0) goto L223;
        TextDecoration r21 = null;
    L224:
        if (r3 != 0) goto L227;
        r112 = r69;
    L227:
        if (r4 == 0) goto L229;
        long r29 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L230:
        if (r7 == 0) goto L232;
        int r32 = TextOverflow.Companion.getClip-gIe3tQ8();
    L233:
        if (r9 != 0) goto L236;
        r111 = r73;
    L236:
        if (r12 == 0) goto L238;
        int r33 = Integer.MAX_VALUE;
    L239:
        if (r16 == 0) goto L241;
        Map r34 = MapsKt.emptyMap();
    L242:
        if (r19 == 0) goto L247;
        Object r114 = r1.rememberedValue();
        if (r114 != Composer.Companion.getEmpty()) goto L246;
        r114 = new vt();
        r1.updateRememberedValue(r114);
    L246:
        Function1 r35 = (Function1) r114;
    L249:
        if ((r81 & 65536) == 0) goto L251;
        Function1 r49 = r35;
        long r43 = r29;
        int r45 = r32;
        int r47 = r33;
        int r115 = r8 & (-3670017);
        Map r48 = r34;
        TextStyle r50 = (TextStyle) r1.consume(LocalTextStyle);
        FontStyle r36 = r113;
        boolean r46 = r111;
        long r37 = r20;
        FontWeight r38 = r24;
        FontFamily r39 = r25;
        long r40 = r28;
        final TextDecoration r116 = r21;
    L252:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L256;
        ComposerKt.traceEventStart(224529679, r5, r115, "androidx.compose.material3.Text (Text.kt:418)");
    L256:
        int r117 = r5 << 3;
        int r41 = ((((((((r5 & 14) | (r5 & 112)) | (r5 & 896)) | (r117 & 57344)) | (r117 & 458752)) | (r117 & 3670016)) | (r117 & 29360128)) | (r117 & 234881024)) | (r117 & 1879048192);
        int r42 = ((r5 >> 27) & 14) | 196608;
        int r44 = r115 << 3;
        int r51 = (((r42 | (r44 & 112)) | (r44 & 896)) | (r44 & 7168)) | (r44 & 57344);
        int r52 = r115 << 6;
        m3364TextZ58ophY(r57, r14, r15, null, r37, r36, r38, r39, r40, r116, r112, r43, r45, r46, r47, 1, r48, r49, r50, r1, r41, ((r51 | (3670016 & r52)) | (29360128 & r52)) | (r52 & 234881024), 8);
        if (ComposerKt.isTraceInProgress() == false) goto L259;
        ComposerKt.traceEventEnd();
    L259:
        final TextAlign r118 = r112;
        final long r119 = r43;
        final int r120 = r45;
        final boolean r121 = r46;
        final int r122 = r47;
        final Map r123 = r48;
        final Function1 r210 = r49;
        final TextStyle r211 = r50;
        FontFamily r53 = r39;
        final FontStyle r54 = r36;
        long r55 = r40;
        final FontWeight r56 = r38;
        final FontFamily r60 = r53;
        long r510 = r37;
        final Modifier r62 = r14;
        final long r67 = r510;
        final long r71 = r15;
        final long r124 = r55;
    L261:
        ScopeUpdateScope r82 = r1.endRestartGroup();
        if (r82 == null) goto L265;
        r82.updateScope(new wt(r57, r62, r71, r67, r54, r56, r60, r124, r116, r118, r119, r120, r121, r122, r123, r210, r211, r79, r80, r81));
        return;
    L265:
        return;
    L251:
        r116 = r21;
        r50 = r77;
        r49 = r35;
        r43 = r29;
        r45 = r32;
        r47 = r33;
        r115 = r8;
        r48 = r34;
        r36 = r113;
        r46 = r111;
        r37 = r20;
        r38 = r24;
        r39 = r25;
        r40 = r28;
        goto L252
    L247:
        r35 = r76;
        goto L249
    L241:
        r34 = r75;
        goto L242
    L238:
        r33 = r74;
        goto L239
    L232:
        r32 = r72;
        goto L233
    L229:
        r29 = r70;
        goto L230
    L223:
        r21 = r68;
        goto L224
    L220:
        r28 = r66;
        goto L221
    L217:
        r25 = r65;
        goto L218
    L214:
        r24 = r64;
        goto L215
    L211:
        r113 = r63;
        goto L212
    L207:
        r20 = r61;
        goto L208
    L204:
        r15 = r59;
        goto L205
    L201:
        r14 = r58;
        goto L202
    L193:
        if (r1.getDefaultsInvalid() == true) goto L199;
        r1.skipToGroupEnd();
        if ((r81 & 65536) == 0) goto L198;
        r8 = r8 & (-3670017);
    L198:
        r14 = r58;
        r15 = r59;
        r37 = r61;
        r36 = r63;
        r38 = r64;
        r39 = r65;
        r116 = r68;
        r112 = r69;
        r43 = r70;
        r45 = r72;
        r46 = r73;
        r47 = r74;
        r48 = r75;
        r49 = r76;
        r50 = r77;
        r115 = r8;
        r40 = r66;
        goto L252
    L260:
        r1 = r1;
        r1.skipToGroupEnd();
        r62 = r58;
        r71 = r59;
        r67 = r61;
        r54 = r63;
        r56 = r64;
        r60 = r65;
        r124 = r66;
        r116 = r68;
        r118 = r69;
        r119 = r70;
        r120 = r72;
        r121 = r73;
        r122 = r74;
        r123 = r75;
        r210 = r76;
        r211 = r77;
        goto L261
    L184:
        if ((599187 & r8) != 599186) goto L187;
        r13 = false;
        goto L189
    L165:
        if ((r80 & 196608) != 0) goto L172;
        if (r1.changedInstance(r76) == true) goto L170;
        r27 = 65536;
    L170:
        r8 = r8 | r27;
        goto L172
    L153:
        r16 = r11;
        if ((r80 & 24576) != 0) goto L161;
        if (r1.changedInstance(r75) == true) goto L159;
        r23 = 8192;
    L159:
        r8 = r8 | r23;
        goto L161
    L143:
        if ((r80 & 3072) != 0) goto L150;
        if (r1.changed(r74) == true) goto L148;
        r18 = 1024;
    L148:
        r8 = r8 | r18;
        goto L150
    L132:
        if ((r80 & 384) != 0) goto L139;
        if (r1.changed(r73) == false) goto L136;
        int r212 = 256;
    L137:
        r8 = r8 | r212;
        goto L139
    L136:
        r212 = 128;
        goto L137
    L121:
        if ((r80 & 48) != 0) goto L128;
        if (r1.changed(r72) == false) goto L125;
        int r125 = 32;
    L126:
        r30 = r30 | r125;
        goto L128
    L125:
        r125 = 16;
        goto L126
    L110:
        if ((r80 & 6) == 0) goto L112;
        r30 = r80;
        goto L117
    L112:
        if (r1.changed(r70) == false) goto L114;
        int r310 = 4;
    L115:
        r30 = r80 | r310;
        goto L117
    L114:
        r310 = 2;
        goto L115
    L100:
        if ((r79 & 805306368) != 0) goto L106;
        if (r1.changed(r69) == false) goto L104;
        int r311 = 536870912;
    L105:
        r5 = r5 | r311;
        goto L106
    L104:
        r311 = 268435456;
        goto L105
    L89:
        if ((100663296 & r79) != 0) goto L96;
        if (r1.changed(r68) == false) goto L93;
        int r312 = 67108864;
    L94:
        r5 = r5 | r312;
        goto L96
    L93:
        r312 = 33554432;
        goto L94
    L79:
        if ((r79 & 12582912) != 0) goto L85;
        if (r1.changed(r66) == false) goto L83;
        int r313 = 8388608;
    L84:
        r5 = r5 | r313;
        goto L85
    L83:
        r313 = 4194304;
        goto L84
    L69:
        if ((r79 & 1572864) != 0) goto L75;
        if (r1.changed(r65) == false) goto L73;
        int r314 = 1048576;
    L74:
        r5 = r5 | r314;
        goto L75
    L73:
        r314 = 524288;
        goto L74
    L59:
        if ((r79 & 196608) != 0) goto L65;
        if (r1.changed(r64) == false) goto L63;
        int r315 = 131072;
    L64:
        r5 = r5 | r315;
        goto L65
    L63:
        r315 = 65536;
        goto L64
    L48:
        if ((r79 & 24576) != 0) goto L55;
        if (r1.changed(r63) == false) goto L52;
        int r213 = 16384;
    L53:
        r5 = r5 | r213;
        goto L55
    L52:
        r213 = 8192;
        goto L53
    L38:
        if ((r79 & 3072) != 0) goto L44;
        if (r1.changed(r61) == false) goto L42;
        int r214 = 2048;
    L43:
        r5 = r5 | r214;
        goto L44
    L42:
        r214 = 1024;
        goto L43
    L28:
        if ((r79 & 384) != 0) goto L34;
        if (r1.changed(r59) == false) goto L32;
        int r126 = 256;
    L33:
        r5 = r5 | r126;
        goto L34
    L32:
        r126 = 128;
        goto L33
    L17:
        if ((r79 & 48) != 0) goto L24;
        if (r1.changed(r58) == false) goto L21;
        int r127 = 32;
    L22:
        r5 = r5 | r127;
        goto L24
    L21:
        r127 = 16;
        goto L22
    L6:
        if ((r79 & 6) == 0) goto L8;
        r5 = r79;
        goto L13
    L8:
        if (r1.changed(r57) == false) goto L10;
        int r83 = 4;
    L11:
        r5 = r83 | r79;
        goto L13
    L10:
        r83 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with autoSize instead")
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    public static final /* synthetic */ void m3361Text4IGK_g(final String r56, Modifier r57, long r58, long r60, FontStyle r62, FontWeight r63, FontFamily r64, long r65, TextDecoration r67, TextAlign r68, long r69, int r71, boolean r72, int r73, int r74, Function1 r75, TextStyle r76, Composer r77, final int r78, final int r79, final int r80) {
        Composer r1 = r77.startRestartGroup(-2055108902);
        if ((r80 & 1) == 0) goto L6;
        int r5 = r78 | 6;
    L13:
        int r6 = r80 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r10 = r80 & 4;
        if (r10 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        int r17 = r80 & 8;
        int r18 = 2048;
        if (r17 == 0) goto L38;
        r5 = r5 | 3072;
    L44:
        int r22 = r80 & 16;
        int r23 = 16384;
        if (r22 == 0) goto L48;
        r5 = r5 | 24576;
    L55:
        int r26 = r80 & 32;
        int r27 = 131072;
        if (r26 == 0) goto L59;
        r5 = r5 | 196608;
    L65:
        int r31 = r80 & 64;
        if (r31 == 0) goto L69;
        r5 = r5 | 1572864;
    L75:
        int r0 = r80 & 128;
        if (r0 == 0) goto L79;
        r5 = r5 | 12582912;
    L85:
        int r2 = r80 & 256;
        if (r2 == 0) goto L89;
        r5 = r5 | 100663296;
    L96:
        int r3 = r80 & 512;
        if (r3 == 0) goto L100;
        r5 = r5 | 805306368;
    L106:
        int r4 = r80 & 1024;
        if (r4 == 0) goto L110;
        int r30 = r79 | 6;
    L117:
        int r7 = r80 & 2048;
        if (r7 == 0) goto L121;
        r30 = r30 | 48;
    L128:
        int r8 = r30;
        int r9 = r80 & 4096;
        if (r9 == 0) goto L132;
        r8 = r8 | 384;
    L139:
        int r12 = r80 & 8192;
        if (r12 == 0) goto L143;
        r8 = r8 | 3072;
    L150:
        int r11 = r80 & 16384;
        if (r11 == 0) goto L153;
        r8 = r8 | 24576;
        int r16 = r11;
    L161:
        int r19 = r80 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r19 == 0) goto L165;
        r8 = r8 | 196608;
    L172:
        if ((r79 & 1572864) != 0) goto L181;
        if ((r80 & 65536) == 0) goto L176;
    L178:
        int r110 = 524288;
    L179:
        r8 = r8 | r110;
        goto L181
    L176:
        if (r1.changed(r76) == false) goto L178;
        r110 = 1048576;
    L181:
        int r111 = 1;
        if ((r5 & 306783379) == 306783378) goto L184;
    L187:
        boolean r13 = true;
    L189:
        if (r1.shouldExecute(r13, r5 & 1) == false) goto L258;
        r1.startDefaults();
        if ((r78 & 1) != 0) goto L193;
    L199:
        if (r6 == 0) goto L201;
        Modifier r14 = Modifier.Companion;
    L202:
        if (r10 == 0) goto L204;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L205:
        if (r17 == 0) goto L207;
        long r20 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L208:
        Function1 r112 = null;
        if (r22 == 0) goto L211;
        FontStyle r113 = null;
    L212:
        if (r26 == 0) goto L214;
        FontWeight r24 = null;
    L215:
        if (r31 == 0) goto L217;
        FontFamily r25 = null;
    L218:
        if (r0 == 0) goto L220;
        long r28 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L221:
        if (r2 == 0) goto L223;
        TextDecoration r21 = null;
    L224:
        if (r3 == 0) goto L226;
        TextAlign r29 = null;
    L227:
        if (r4 == 0) goto L229;
        long r32 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L230:
        if (r7 == 0) goto L232;
        int r33 = TextOverflow.Companion.getClip-gIe3tQ8();
    L233:
        if (r9 == 0) goto L235;
        boolean r34 = true;
    L236:
        if (r12 == 0) goto L238;
        int r114 = Integer.MAX_VALUE;
    L239:
        if (r16 != 0) goto L242;
        r111 = r74;
    L242:
        if (r19 != 0) goto L245;
        r112 = r75;
    L245:
        TextDecoration r59 = r21;
        if ((r80 & 65536) == 0) goto L248;
        r8 = r8 & (-3670017);
        TextStyle r49 = (TextStyle) r1.consume(LocalTextStyle);
    L249:
        long r42 = r32;
        int r44 = r33;
        int r115 = r8;
        boolean r45 = r34;
        int r46 = r114;
        Function1 r48 = r112;
        FontStyle r35 = r113;
        int r47 = r111;
        FontWeight r36 = r24;
        FontFamily r37 = r25;
        long r38 = r28;
        final TextDecoration r116 = r59;
        TextAlign r117 = r29;
        long r39 = r20;
    L250:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L254;
        ComposerKt.traceEventStart(-2055108902, r5, r115, "androidx.compose.material3.Text (Text.kt:283)");
    L254:
        int r118 = r5 << 3;
        int r310 = (((((((((r5 & 14) | 3072) | (r5 & 112)) | (r5 & 896)) | (r118 & 57344)) | (r118 & 458752)) | (r118 & 3670016)) | (r118 & 29360128)) | (r118 & 234881024)) | (r118 & 1879048192);
        int r40 = (r5 >> 27) & 14;
        int r41 = r115 << 3;
        m3363TextNvy7gAk(r56, r14, r15, null, r39, r35, r36, r37, r38, r116, r117, r42, r44, r45, r46, r47, r48, r49, r1, r310, ((((((r40 | (r41 & 112)) | (r41 & 896)) | (r41 & 7168)) | (57344 & r41)) | (458752 & r41)) | (3670016 & r41)) | (r41 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L257;
        ComposerKt.traceEventEnd();
    L257:
        final TextAlign r119 = r117;
        final long r120 = r42;
        final int r121 = r44;
        final boolean r122 = r45;
        final int r123 = r46;
        final int r124 = r47;
        final Function1 r210 = r48;
        final TextStyle r211 = r49;
        FontFamily r51 = r37;
        final FontStyle r43 = r35;
        long r52 = r38;
        final FontWeight r50 = r36;
        final FontFamily r53 = r51;
        long r54 = r39;
        final Modifier r55 = r14;
        final long r61 = r54;
        final long r66 = r15;
        final long r125 = r52;
    L259:
        ScopeUpdateScope r70 = r1.endRestartGroup();
        if (r70 == null) goto L263;
        r70.updateScope(new cu(r56, r55, r66, r61, r43, r50, r53, r125, r116, r119, r120, r121, r122, r123, r124, r210, r211, r78, r79, r80));
        return;
    L263:
        return;
    L248:
        r49 = r76;
        goto L249
    L238:
        r114 = r73;
        goto L239
    L235:
        r34 = r72;
        goto L236
    L232:
        r33 = r71;
        goto L233
    L229:
        r32 = r69;
        goto L230
    L226:
        r29 = r68;
        goto L227
    L223:
        r21 = r67;
        goto L224
    L220:
        r28 = r65;
        goto L221
    L217:
        r25 = r64;
        goto L218
    L214:
        r24 = r63;
        goto L215
    L211:
        r113 = r62;
        goto L212
    L207:
        r20 = r60;
        goto L208
    L204:
        r15 = r58;
        goto L205
    L201:
        r14 = r57;
        goto L202
    L193:
        if (r1.getDefaultsInvalid() == true) goto L199;
        r1.skipToGroupEnd();
        if ((r80 & 65536) == 0) goto L198;
        r8 = r8 & (-3670017);
    L198:
        r14 = r57;
        r15 = r58;
        r39 = r60;
        r35 = r62;
        r36 = r63;
        r37 = r64;
        r116 = r67;
        r117 = r68;
        r42 = r69;
        r44 = r71;
        r45 = r72;
        r46 = r73;
        r47 = r74;
        r48 = r75;
        r49 = r76;
        r115 = r8;
        r38 = r65;
        goto L250
    L258:
        r1 = r1;
        r1.skipToGroupEnd();
        r55 = r57;
        r66 = r58;
        r61 = r60;
        r43 = r62;
        r50 = r63;
        r53 = r64;
        r125 = r65;
        r116 = r67;
        r119 = r68;
        r120 = r69;
        r121 = r71;
        r122 = r72;
        r123 = r73;
        r124 = r74;
        r210 = r75;
        r211 = r76;
        goto L259
    L184:
        if ((599187 & r8) != 599186) goto L187;
        r13 = false;
        goto L189
    L165:
        if ((r79 & 196608) != 0) goto L172;
        if (r1.changedInstance(r75) == true) goto L170;
        r27 = 65536;
    L170:
        r8 = r8 | r27;
        goto L172
    L153:
        r16 = r11;
        if ((r79 & 24576) != 0) goto L161;
        if (r1.changed(r74) == true) goto L159;
        r23 = 8192;
    L159:
        r8 = r8 | r23;
        goto L161
    L143:
        if ((r79 & 3072) != 0) goto L150;
        if (r1.changed(r73) == true) goto L148;
        r18 = 1024;
    L148:
        r8 = r8 | r18;
        goto L150
    L132:
        if ((r79 & 384) != 0) goto L139;
        if (r1.changed(r72) == false) goto L136;
        int r212 = 256;
    L137:
        r8 = r8 | r212;
        goto L139
    L136:
        r212 = 128;
        goto L137
    L121:
        if ((r79 & 48) != 0) goto L128;
        if (r1.changed(r71) == false) goto L125;
        int r126 = 32;
    L126:
        r30 = r30 | r126;
        goto L128
    L125:
        r126 = 16;
        goto L126
    L110:
        if ((r79 & 6) == 0) goto L112;
        r30 = r79;
        goto L117
    L112:
        if (r1.changed(r69) == false) goto L114;
        int r311 = 4;
    L115:
        r30 = r79 | r311;
        goto L117
    L114:
        r311 = 2;
        goto L115
    L100:
        if ((r78 & 805306368) != 0) goto L106;
        if (r1.changed(r68) == false) goto L104;
        int r312 = 536870912;
    L105:
        r5 = r5 | r312;
        goto L106
    L104:
        r312 = 268435456;
        goto L105
    L89:
        if ((100663296 & r78) != 0) goto L96;
        if (r1.changed(r67) == false) goto L93;
        int r313 = 67108864;
    L94:
        r5 = r5 | r313;
        goto L96
    L93:
        r313 = 33554432;
        goto L94
    L79:
        if ((r78 & 12582912) != 0) goto L85;
        if (r1.changed(r65) == false) goto L83;
        int r314 = 8388608;
    L84:
        r5 = r5 | r314;
        goto L85
    L83:
        r314 = 4194304;
        goto L84
    L69:
        if ((r78 & 1572864) != 0) goto L75;
        if (r1.changed(r64) == false) goto L73;
        int r315 = 1048576;
    L74:
        r5 = r5 | r315;
        goto L75
    L73:
        r315 = 524288;
        goto L74
    L59:
        if ((r78 & 196608) != 0) goto L65;
        if (r1.changed(r63) == false) goto L63;
        int r316 = 131072;
    L64:
        r5 = r5 | r316;
        goto L65
    L63:
        r316 = 65536;
        goto L64
    L48:
        if ((r78 & 24576) != 0) goto L55;
        if (r1.changed(r62) == false) goto L52;
        int r213 = 16384;
    L53:
        r5 = r5 | r213;
        goto L55
    L52:
        r213 = 8192;
        goto L53
    L38:
        if ((r78 & 3072) != 0) goto L44;
        if (r1.changed(r60) == false) goto L42;
        int r214 = 2048;
    L43:
        r5 = r5 | r214;
        goto L44
    L42:
        r214 = 1024;
        goto L43
    L28:
        if ((r78 & 384) != 0) goto L34;
        if (r1.changed(r58) == false) goto L32;
        int r127 = 256;
    L33:
        r5 = r5 | r127;
        goto L34
    L32:
        r127 = 128;
        goto L33
    L17:
        if ((r78 & 48) != 0) goto L24;
        if (r1.changed(r57) == false) goto L21;
        int r128 = 32;
    L22:
        r5 = r5 | r128;
        goto L24
    L21:
        r128 = 16;
        goto L22
    L6:
        if ((r78 & 6) == 0) goto L8;
        r5 = r78;
        goto L13
    L8:
        if (r1.changed(r56) == false) goto L10;
        int r81 = 4;
    L11:
        r5 = r81 | r78;
        goto L13
    L10:
        r81 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with autoSize instead")
    /* JADX INFO: renamed from: Text-IbK3jfQ, reason: not valid java name */
    public static final /* synthetic */ void m3362TextIbK3jfQ(final AnnotatedString r54, Modifier r55, long r56, long r58, FontStyle r60, FontWeight r61, FontFamily r62, long r63, TextDecoration r65, TextAlign r66, long r67, int r69, boolean r70, int r71, int r72, Map r73, Function1 r74, TextStyle r75, Composer r76, final int r77, final int r78, final int r79) {
        Composer r0 = r76.startRestartGroup(2027001676);
        if ((r79 & 1) == 0) goto L6;
        int r4 = r77 | 6;
    L13:
        int r5 = r79 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r79 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        int r16 = r79 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L38;
        r4 = r4 | 3072;
    L44:
        int r20 = r79 & 16;
        int r21 = 16384;
        if (r20 == 0) goto L48;
        r4 = r4 | 24576;
    L55:
        int r24 = r79 & 32;
        if (r24 == 0) goto L59;
        r4 = r4 | 196608;
    L65:
        int r29 = r79 & 64;
        if (r29 == 0) goto L69;
        r4 = r4 | 1572864;
    L75:
        int r12 = r79 & 128;
        if (r12 == 0) goto L79;
        r4 = r4 | 12582912;
    L85:
        int r3 = r79 & 256;
        if (r3 == 0) goto L89;
        r4 = r4 | 100663296;
    L95:
        int r2 = r79 & 512;
        if (r2 == 0) goto L99;
        r4 = r4 | 805306368;
    L105:
        int r1 = r79 & 1024;
        if (r1 == 0) goto L109;
        int r32 = r78 | 6;
    L116:
        int r8 = r79 & 2048;
        if (r8 == 0) goto L120;
        r32 = r32 | 48;
    L126:
        int r7 = r32;
        int r6 = r79 & 4096;
        if (r6 == 0) goto L130;
        r7 = r7 | 384;
    L137:
        int r10 = r79 & 8192;
        if (r10 == 0) goto L141;
        r7 = r7 | 3072;
    L148:
        int r11 = r79 & 16384;
        if (r11 == 0) goto L151;
        r7 = r7 | 24576;
        int r18 = r11;
    L159:
        int r19 = r79 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r19 == 0) goto L163;
        r7 = r7 | 196608;
    L169:
        int r110 = r79 & 65536;
        if (r110 == 0) goto L173;
        r7 = r7 | 1572864;
    L180:
        if ((r78 & 12582912) != 0) goto L189;
        if ((r79 & 131072) == 0) goto L184;
    L186:
        int r22 = 4194304;
    L187:
        r7 = r7 | r22;
        goto L189
    L184:
        if (r0.changed(r75) == false) goto L186;
        r22 = 8388608;
    L189:
        int r23 = 1;
        if ((r4 & 306783379) == 306783378) goto L192;
    L195:
        boolean r13 = true;
    L197:
        if (r0.shouldExecute(r13, r4 & 1) == false) goto L273;
        r0.startDefaults();
        if ((r77 & 1) != 0) goto L201;
    L207:
        if (r5 == 0) goto L209;
        Modifier r14 = Modifier.Companion;
    L210:
        if (r9 == 0) goto L212;
        long r25 = Color.Companion.getUnspecified-0d7_KjU();
    L213:
        if (r16 == 0) goto L215;
        long r15 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L216:
        TextAlign r26 = null;
        if (r20 == 0) goto L219;
        FontStyle r111 = null;
    L220:
        if (r24 == 0) goto L222;
        FontWeight r27 = null;
    L223:
        if (r29 == 0) goto L225;
        FontFamily r28 = null;
    L226:
        if (r12 == 0) goto L228;
        long r210 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L229:
        if (r3 == 0) goto L231;
        TextDecoration r30 = null;
    L232:
        if (r2 != 0) goto L235;
        r26 = r66;
    L235:
        if (r1 == 0) goto L237;
        long r31 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L238:
        if (r8 == 0) goto L240;
        int r33 = TextOverflow.Companion.getClip-gIe3tQ8();
    L241:
        if (r6 == 0) goto L243;
        boolean r34 = true;
    L244:
        if (r10 == 0) goto L246;
        int r112 = Integer.MAX_VALUE;
    L247:
        if (r18 != 0) goto L250;
        r23 = r72;
    L250:
        if (r19 == 0) goto L252;
        Map r113 = MapsKt.emptyMap();
    L253:
        long r57 = r31;
        if (r110 == 0) goto L259;
        Object r35 = r0.rememberedValue();
        if (r35 != Composer.Companion.getEmpty()) goto L258;
        r35 = new du();
        r0.updateRememberedValue(r35);
    L258:
        Function1 r36 = (Function1) r35;
    L261:
        if ((r79 & 131072) == 0) goto L263;
        r7 = r7 & (-29360129);
        TextStyle r51 = (TextStyle) r0.consume(LocalTextStyle);
    L264:
        boolean r46 = r34;
        int r114 = r7;
        int r45 = r33;
        int r47 = r112;
        Map r49 = r113;
        long r37 = r15;
        int r48 = r23;
        long r38 = r25;
        FontFamily r39 = r28;
        final TextDecoration r115 = r30;
        TextAlign r116 = r26;
        FontWeight r40 = r27;
        long r41 = r210;
    L265:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L269;
        ComposerKt.traceEventStart(2027001676, r4, r114, "androidx.compose.material3.Text (Text.kt:329)");
    L269:
        int r117 = r4 << 3;
        int r42 = (((((((((r4 & 14) | 3072) | (r4 & 112)) | (r4 & 896)) | (r117 & 57344)) | (r117 & 458752)) | (r117 & 3670016)) | (r117 & 29360128)) | (r117 & 234881024)) | (r117 & 1879048192);
        int r43 = (r4 >> 27) & 14;
        int r44 = r114 << 3;
        m3364TextZ58ophY(r54, r14, r38, null, r37, r111, r40, r39, r41, r115, r116, r57, r45, r46, r47, r48, r49, r36, r51, r0, r42, (((((((r43 | (r44 & 112)) | (r44 & 896)) | (r44 & 7168)) | (57344 & r44)) | (458752 & r44)) | (3670016 & r44)) | (29360128 & r44)) | (r44 & 234881024), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L272;
        ComposerKt.traceEventEnd();
    L272:
        final TextAlign r118 = r116;
        final long r119 = r57;
        final int r120 = r45;
        final boolean r121 = r46;
        final int r122 = r47;
        final int r123 = r48;
        final Map r211 = r49;
        final Function1 r212 = r36;
        final TextStyle r213 = r51;
        FontFamily r53 = r39;
        final FontWeight r50 = r40;
        final long r52 = r38;
        final Modifier r59 = r14;
        final long r64 = r37;
        final FontStyle r68 = r111;
        final long r124 = r41;
        final FontFamily r80 = r53;
    L274:
        ScopeUpdateScope r81 = r0.endRestartGroup();
        if (r81 == null) goto L278;
        r81.updateScope(new eu(r54, r59, r52, r64, r68, r50, r80, r124, r115, r118, r119, r120, r121, r122, r123, r211, r212, r213, r77, r78, r79));
        return;
    L278:
        return;
    L263:
        r51 = r75;
        goto L264
    L259:
        r36 = r74;
        goto L261
    L252:
        r113 = r73;
        goto L253
    L246:
        r112 = r71;
        goto L247
    L243:
        r34 = r70;
        goto L244
    L240:
        r33 = r69;
        goto L241
    L237:
        r31 = r67;
        goto L238
    L231:
        r30 = r65;
        goto L232
    L228:
        r210 = r63;
        goto L229
    L225:
        r28 = r62;
        goto L226
    L222:
        r27 = r61;
        goto L223
    L219:
        r111 = r60;
        goto L220
    L215:
        r15 = r58;
        goto L216
    L212:
        r25 = r56;
        goto L213
    L209:
        r14 = r55;
        goto L210
    L201:
        if (r0.getDefaultsInvalid() == true) goto L207;
        r0.skipToGroupEnd();
        if ((r79 & 131072) == 0) goto L206;
        r7 = r7 & (-29360129);
    L206:
        r14 = r55;
        r38 = r56;
        r111 = r60;
        r40 = r61;
        r39 = r62;
        r41 = r63;
        r115 = r65;
        r116 = r66;
        r57 = r67;
        r45 = r69;
        r46 = r70;
        r47 = r71;
        r48 = r72;
        r49 = r73;
        r36 = r74;
        r51 = r75;
        r114 = r7;
        r37 = r58;
        goto L265
    L273:
        r0 = r0;
        r0.skipToGroupEnd();
        r59 = r55;
        r52 = r56;
        r64 = r58;
        r68 = r60;
        r50 = r61;
        r80 = r62;
        r124 = r63;
        r115 = r65;
        r118 = r66;
        r119 = r67;
        r120 = r69;
        r121 = r70;
        r122 = r71;
        r123 = r72;
        r211 = r73;
        r212 = r74;
        r213 = r75;
        goto L274
    L192:
        if ((4793491 & r7) != 4793490) goto L195;
        r13 = false;
        goto L197
    L173:
        if ((r78 & 1572864) != 0) goto L180;
        if (r0.changedInstance(r74) == false) goto L177;
        int r214 = 1048576;
    L178:
        r7 = r7 | r214;
        goto L180
    L177:
        r214 = 524288;
        goto L178
    L163:
        if ((r78 & 196608) != 0) goto L169;
        if (r0.changedInstance(r73) == false) goto L167;
        int r125 = 131072;
    L168:
        r7 = r7 | r125;
        goto L169
    L167:
        r125 = 65536;
        goto L168
    L151:
        r18 = r11;
        if ((r78 & 24576) != 0) goto L159;
        if (r0.changed(r72) == true) goto L157;
        r21 = 8192;
    L157:
        r7 = r7 | r21;
        goto L159
    L141:
        if ((r78 & 3072) != 0) goto L148;
        if (r0.changed(r71) == true) goto L146;
        r17 = 1024;
    L146:
        r7 = r7 | r17;
        goto L148
    L130:
        if ((r78 & 384) != 0) goto L137;
        if (r0.changed(r70) == false) goto L134;
        int r215 = 256;
    L135:
        r7 = r7 | r215;
        goto L137
    L134:
        r215 = 128;
        goto L135
    L120:
        if ((r78 & 48) != 0) goto L126;
        if (r0.changed(r69) == false) goto L124;
        int r216 = 32;
    L125:
        r32 = r32 | r216;
        goto L126
    L124:
        r216 = 16;
        goto L125
    L109:
        if ((r78 & 6) == 0) goto L111;
        r32 = r78;
        goto L116
    L111:
        if (r0.changed(r67) == false) goto L113;
        int r310 = 4;
    L114:
        r32 = r78 | r310;
        goto L116
    L113:
        r310 = 2;
        goto L114
    L99:
        if ((r77 & 805306368) != 0) goto L105;
        if (r0.changed(r66) == false) goto L103;
        int r311 = 536870912;
    L104:
        r4 = r4 | r311;
        goto L105
    L103:
        r311 = 268435456;
        goto L104
    L89:
        if ((r77 & 100663296) != 0) goto L95;
        if (r0.changed(r65) == false) goto L93;
        int r82 = 67108864;
    L94:
        r4 = r4 | r82;
        goto L95
    L93:
        r82 = 33554432;
        goto L94
    L79:
        if ((r77 & 12582912) != 0) goto L85;
        if (r0.changed(r63) == false) goto L83;
        int r83 = 8388608;
    L84:
        r4 = r4 | r83;
        goto L85
    L83:
        r83 = 4194304;
        goto L84
    L69:
        if ((r77 & 1572864) != 0) goto L75;
        if (r0.changed(r62) == false) goto L73;
        int r312 = 1048576;
    L74:
        r4 = r4 | r312;
        goto L75
    L73:
        r312 = 524288;
        goto L74
    L59:
        if ((r77 & 196608) != 0) goto L65;
        if (r0.changed(r61) == false) goto L63;
        int r217 = 131072;
    L64:
        r4 = r4 | r217;
        goto L65
    L63:
        r217 = 65536;
        goto L64
    L48:
        if ((r77 & 24576) != 0) goto L55;
        if (r0.changed(r60) == false) goto L52;
        int r218 = 16384;
    L53:
        r4 = r4 | r218;
        goto L55
    L52:
        r218 = 8192;
        goto L53
    L38:
        if ((r77 & 3072) != 0) goto L44;
        if (r0.changed(r58) == false) goto L42;
        int r219 = 2048;
    L43:
        r4 = r4 | r219;
        goto L44
    L42:
        r219 = 1024;
        goto L43
    L28:
        if ((r77 & 384) != 0) goto L34;
        if (r0.changed(r56) == false) goto L32;
        int r126 = 256;
    L33:
        r4 = r4 | r126;
        goto L34
    L32:
        r126 = 128;
        goto L33
    L17:
        if ((r77 & 48) != 0) goto L24;
        if (r0.changed(r55) == false) goto L21;
        int r84 = 32;
    L22:
        r4 = r4 | r84;
        goto L24
    L21:
        r84 = 16;
        goto L22
    L6:
        if ((r77 & 6) == 0) goto L8;
        r4 = r77;
        goto L13
    L8:
        if (r0.changed(r54) == false) goto L10;
        int r85 = 4;
    L11:
        r4 = r85 | r77;
        goto L13
    L10:
        r85 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Text-Nvy7gAk, reason: not valid java name */
    public static final void m3363TextNvy7gAk(final String r59, Modifier r60, long r61, TextAutoSize r63, long r64, FontStyle r66, FontWeight r67, FontFamily r68, long r69, TextDecoration r71, TextAlign r72, long r73, int r75, boolean r76, int r77, int r78, Function1<? super TextLayoutResult, Unit> r79, TextStyle r80, Composer r81, final int r82, final int r83, final int r84) {
        Composer r0 = r81.startRestartGroup(1809465675);
        if ((r84 & 1) == 0) goto L6;
        int r4 = r82 | 6;
    L13:
        int r5 = r84 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r9 = r84 & 4;
        if (r9 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        int r16 = r84 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L38;
        r4 = r4 | 3072;
    L45:
        int r20 = r84 & 16;
        int r21 = 16384;
        if (r20 == 0) goto L49;
        r4 = r4 | 24576;
    L55:
        int r25 = r84 & 32;
        if (r25 == 0) goto L59;
        r4 = r4 | 196608;
    L65:
        int r30 = r84 & 64;
        if (r30 == 0) goto L69;
        r4 = r4 | 1572864;
    L75:
        int r1 = r84 & 128;
        if (r1 == 0) goto L79;
        r4 = r4 | 12582912;
    L85:
        int r3 = r84 & 256;
        if (r3 == 0) goto L89;
        r4 = r4 | 100663296;
    L95:
        int r2 = r84 & 512;
        if (r2 == 0) goto L99;
        r4 = r4 | 805306368;
    L105:
        int r7 = r84 & 1024;
        if (r7 == 0) goto L109;
        int r32 = r83 | 6;
    L116:
        int r6 = r84 & 2048;
        if (r6 == 0) goto L120;
        r32 = r32 | 48;
    L126:
        int r8 = r32;
        int r10 = r84 & 4096;
        if (r10 == 0) goto L130;
        r8 = r8 | 384;
    L137:
        int r11 = r84 & 8192;
        if (r11 == 0) goto L141;
        r8 = r8 | 3072;
    L148:
        int r12 = r84 & 16384;
        if (r12 == 0) goto L151;
        r8 = r8 | 24576;
        int r18 = r12;
    L159:
        int r19 = r84 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r19 == 0) goto L163;
        r8 = r8 | 196608;
    L169:
        int r110 = r84 & 65536;
        if (r110 == 0) goto L173;
        r8 = r8 | 1572864;
    L180:
        if ((r83 & 12582912) != 0) goto L189;
        if ((r84 & 131072) == 0) goto L184;
    L186:
        int r22 = 4194304;
    L187:
        r8 = r8 | r22;
        goto L189
    L184:
        if (r0.changed(r80) == false) goto L186;
        r22 = 8388608;
    L189:
        boolean r23 = true;
        if ((r4 & 306783379) == 306783378) goto L192;
    L195:
        boolean r13 = true;
    L197:
        if (r0.shouldExecute(r13, r4 & 1) == false) goto L287;
        r0.startDefaults();
        if ((r82 & 1) != 0) goto L201;
    L207:
        if (r5 == 0) goto L209;
        Modifier r14 = Modifier.Companion;
    L210:
        if (r9 == 0) goto L212;
        long r24 = Color.Companion.getUnspecified-0d7_KjU();
    L213:
        Function1<? super TextLayoutResult, Unit> r15 = null;
        if (r16 == 0) goto L216;
        TextAutoSize r111 = null;
    L217:
        if (r20 == 0) goto L219;
        long r26 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L220:
        if (r25 == 0) goto L222;
        FontStyle r112 = null;
    L223:
        if (r30 == 0) goto L225;
        FontWeight r113 = null;
    L226:
        if (r1 == 0) goto L228;
        FontFamily r27 = null;
    L229:
        if (r3 == 0) goto L231;
        long r28 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L232:
        if (r2 == 0) goto L234;
        TextDecoration r29 = null;
    L235:
        if (r7 == 0) goto L237;
        TextAlign r31 = null;
    L238:
        if (r6 == 0) goto L240;
        long r33 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L241:
        if (r10 == 0) goto L243;
        int r114 = TextOverflow.Companion.getClip-gIe3tQ8();
    L244:
        if (r11 == 0) goto L246;
        boolean r115 = true;
    L247:
        if (r18 == 0) goto L249;
        int r116 = Integer.MAX_VALUE;
    L250:
        if (r19 == 0) goto L252;
        int r117 = 1;
    L253:
        if (r110 != 0) goto L256;
        r15 = r79;
    L256:
        FontFamily r62 = r27;
        if ((r84 & 131072) == 0) goto L259;
        r8 = r8 & (-29360129);
        TextStyle r57 = (TextStyle) r0.consume(LocalTextStyle);
    L260:
        int r118 = r8;
        Function1<? super TextLayoutResult, Unit> r56 = r15;
        final int r119 = r116;
        final int r210 = r117;
        TextDecoration r34 = r29;
        TextAlign r35 = r31;
        final int r120 = r114;
        final boolean r121 = r115;
        long r36 = r26;
        FontFamily r37 = r62;
        long r122 = r33;
        long r38 = r28;
    L261:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L265;
        ComposerKt.traceEventStart(1809465675, r4, r118, "androidx.compose.material3.Text (Text.kt:120)");
    L265:
        r0.startReplaceGroup(-565217106);
        if (r24 == 16) goto L268;
        boolean r123 = true;
    L269:
        if (r123 == false) goto L271;
        long r211 = r24;
    L279:
        r0.endReplaceGroup();
        if (r35 == null) goto L282;
        int r124 = r35.unbox-impl();
    L283:
        int r125 = ((r4 & 14) | (r4 & 112)) | ((r118 >> 9) & 7168);
        int r126 = r118 << 6;
        int r39 = (r4 << 18) & 1879048192;
        Modifier r65 = r14;
        Function1<? super TextLayoutResult, Unit> r610 = r56;
        int r611 = r120;
        boolean r612 = r121;
        int r613 = r119;
        int r614 = r210;
        TextAutoSize r615 = r111;
        BasicTextKt.m1356BasicTextRWo7tUw(r59, r65, TextStyle.merge-dA7vx0o$default(r57, r211, r36, r113, r112, null, r37, null, r38, null, null, null, 0, r34, null, null, r124, 0, r122, null, null, 0, 0, null, null, 16609104, null), r610, r611, r612, r613, r614, null, r615, r0, r39 | ((r126 & 29360128) | (((r125 | (r126 & 57344)) | (r126 & 458752)) | (r126 & 3670016))), 256);
        if (ComposerKt.isTraceInProgress() == false) goto L286;
        ComposerKt.traceEventEnd();
    L286:
        final TextDecoration r127 = r34;
        final FontStyle r40 = r112;
        final Function1<? super TextLayoutResult, Unit> r212 = r56;
        final TextAlign r128 = r35;
        final FontWeight r41 = r113;
        final long r129 = r122;
        final FontFamily r130 = r37;
        final long r131 = r38;
        final long r42 = r24;
        final TextStyle r213 = r57;
        final long r43 = r36;
        final Modifier r44 = r14;
        final TextAutoSize r45 = r111;
    L288:
        ScopeUpdateScope r46 = r0.endRestartGroup();
        if (r46 == null) goto L292;
        r46.updateScope(new yt(r59, r44, r42, r45, r43, r40, r41, r130, r131, r127, r128, r129, r120, r121, r119, r210, r212, r213, r82, r83, r84));
        return;
    L292:
        return;
    L282:
        r124 = TextAlign.Companion.getUnspecified-e0LSkKk();
        goto L283
    L271:
        r0.startReplaceGroup(-565216333);
        long r214 = r57.getColor-0d7_KjU();
        if (r214 != 16) goto L275;
        r23 = false;
    L275:
        if (r23 == true) goto L278;
        r214 = ((Color) r0.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L278:
        r0.endReplaceGroup();
        r211 = r214;
        goto L279
    L268:
        r123 = false;
        goto L269
    L259:
        r57 = r80;
        goto L260
    L252:
        r117 = r78;
        goto L253
    L249:
        r116 = r77;
        goto L250
    L246:
        r115 = r76;
        goto L247
    L243:
        r114 = r75;
        goto L244
    L240:
        r33 = r73;
        goto L241
    L237:
        r31 = r72;
        goto L238
    L234:
        r29 = r71;
        goto L235
    L231:
        r28 = r69;
        goto L232
    L228:
        r27 = r68;
        goto L229
    L225:
        r113 = r67;
        goto L226
    L222:
        r112 = r66;
        goto L223
    L219:
        r26 = r64;
        goto L220
    L216:
        r111 = r63;
        goto L217
    L212:
        r24 = r61;
        goto L213
    L209:
        r14 = r60;
        goto L210
    L201:
        if (r0.getDefaultsInvalid() == true) goto L207;
        r0.skipToGroupEnd();
        if ((r84 & 131072) == 0) goto L206;
        r8 = r8 & (-29360129);
    L206:
        r14 = r60;
        r24 = r61;
        r111 = r63;
        r36 = r64;
        r112 = r66;
        r113 = r67;
        r37 = r68;
        r38 = r69;
        r35 = r72;
        r122 = r73;
        r120 = r75;
        r121 = r76;
        r119 = r77;
        r210 = r78;
        r56 = r79;
        r57 = r80;
        r118 = r8;
        r34 = r71;
        goto L261
    L287:
        r0.skipToGroupEnd();
        r44 = r60;
        r42 = r61;
        r45 = r63;
        r43 = r64;
        r40 = r66;
        r41 = r67;
        r130 = r68;
        r131 = r69;
        r127 = r71;
        r128 = r72;
        r129 = r73;
        r120 = r75;
        r121 = r76;
        r119 = r77;
        r210 = r78;
        r212 = r79;
        r213 = r80;
        goto L288
    L192:
        if ((4793491 & r8) != 4793490) goto L195;
        r13 = false;
        goto L197
    L173:
        if ((r83 & 1572864) != 0) goto L180;
        if (r0.changedInstance(r79) == false) goto L177;
        int r215 = 1048576;
    L178:
        r8 = r8 | r215;
        goto L180
    L177:
        r215 = 524288;
        goto L178
    L163:
        if ((r83 & 196608) != 0) goto L169;
        if (r0.changed(r78) == false) goto L167;
        int r132 = 131072;
    L168:
        r8 = r8 | r132;
        goto L169
    L167:
        r132 = 65536;
        goto L168
    L151:
        r18 = r12;
        if ((r83 & 24576) != 0) goto L159;
        if (r0.changed(r77) == true) goto L157;
        r21 = 8192;
    L157:
        r8 = r8 | r21;
        goto L159
    L141:
        if ((r83 & 3072) != 0) goto L148;
        if (r0.changed(r76) == true) goto L146;
        r17 = 1024;
    L146:
        r8 = r8 | r17;
        goto L148
    L130:
        if ((r83 & 384) != 0) goto L137;
        if (r0.changed(r75) == false) goto L134;
        int r216 = 256;
    L135:
        r8 = r8 | r216;
        goto L137
    L134:
        r216 = 128;
        goto L135
    L120:
        if ((r83 & 48) != 0) goto L126;
        if (r0.changed(r73) == false) goto L124;
        int r217 = 32;
    L125:
        r32 = r32 | r217;
        goto L126
    L124:
        r217 = 16;
        goto L125
    L109:
        if ((r83 & 6) == 0) goto L111;
        r32 = r83;
        goto L116
    L111:
        if (r0.changed(r72) == false) goto L113;
        int r310 = 4;
    L114:
        r32 = r83 | r310;
        goto L116
    L113:
        r310 = 2;
        goto L114
    L99:
        if ((r82 & 805306368) != 0) goto L105;
        if (r0.changed(r71) == false) goto L103;
        int r47 = 536870912;
    L104:
        r4 = r4 | r47;
        goto L105
    L103:
        r47 = 268435456;
        goto L104
    L89:
        if ((r82 & 100663296) != 0) goto L95;
        if (r0.changed(r69) == false) goto L93;
        int r311 = 67108864;
    L94:
        r4 = r4 | r311;
        goto L95
    L93:
        r311 = 33554432;
        goto L94
    L79:
        if ((r82 & 12582912) != 0) goto L85;
        if (r0.changed(r68) == false) goto L83;
        int r48 = 8388608;
    L84:
        r4 = r4 | r48;
        goto L85
    L83:
        r48 = 4194304;
        goto L84
    L69:
        if ((r82 & 1572864) != 0) goto L75;
        if (r0.changed(r67) == false) goto L73;
        int r312 = 1048576;
    L74:
        r4 = r4 | r312;
        goto L75
    L73:
        r312 = 524288;
        goto L74
    L59:
        if ((r82 & 196608) != 0) goto L65;
        if (r0.changed(r66) == false) goto L63;
        int r313 = 131072;
    L64:
        r4 = r4 | r313;
        goto L65
    L63:
        r313 = 65536;
        goto L64
    L49:
        if ((r82 & 24576) != 0) goto L55;
        if (r0.changed(r64) == false) goto L53;
        int r218 = 16384;
    L54:
        r4 = r4 | r218;
        goto L55
    L53:
        r218 = 8192;
        goto L54
    L38:
        if ((r82 & 3072) != 0) goto L45;
        if (r0.changedInstance(r63) == false) goto L42;
        int r219 = 2048;
    L43:
        r4 = r4 | r219;
        goto L45
    L42:
        r219 = 1024;
        goto L43
    L28:
        if ((r82 & 384) != 0) goto L34;
        if (r0.changed(r61) == false) goto L32;
        int r133 = 256;
    L33:
        r4 = r4 | r133;
        goto L34
    L32:
        r133 = 128;
        goto L33
    L17:
        if ((r82 & 48) != 0) goto L24;
        if (r0.changed(r60) == false) goto L21;
        int r49 = 32;
    L22:
        r4 = r4 | r49;
        goto L24
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r82 & 6) == 0) goto L8;
        r4 = r82;
        goto L13
    L8:
        if (r0.changed(r59) == false) goto L10;
        int r50 = 4;
    L11:
        r4 = r50 | r82;
        goto L13
    L10:
        r50 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Text-Z58ophY, reason: not valid java name */
    public static final void m3364TextZ58ophY(final AnnotatedString r70, Modifier r71, long r72, TextAutoSize r74, long r75, FontStyle r77, FontWeight r78, FontFamily r79, long r80, TextDecoration r82, TextAlign r83, long r84, int r86, boolean r87, int r88, int r89, Map<String, InlineTextContent> r90, Function1<? super TextLayoutResult, Unit> r91, TextStyle r92, Composer r93, final int r94, final int r95, final int r96) {
        Composer r0 = r93.startRestartGroup(292247417);
        if ((r96 & 1) == 0) goto L6;
        int r2 = r94 | 6;
    L13:
        int r5 = r96 & 2;
        if (r5 == 0) goto L17;
        r2 = r2 | 48;
    L24:
        int r9 = r96 & 4;
        if (r9 == 0) goto L28;
        r2 = r2 | 384;
    L34:
        int r16 = r96 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L38;
        r2 = r2 | 3072;
    L45:
        int r20 = r96 & 16;
        int r21 = 16384;
        if (r20 == 0) goto L49;
        r2 = r2 | 24576;
    L55:
        int r25 = r96 & 32;
        if (r25 == 0) goto L59;
        r2 = r2 | 196608;
    L65:
        int r29 = r96 & 64;
        if (r29 == 0) goto L69;
        r2 = r2 | 1572864;
    L75:
        int r3 = r96 & 128;
        if (r3 == 0) goto L79;
        r2 = r2 | 12582912;
    L85:
        int r4 = r96 & 256;
        if (r4 == 0) goto L89;
        r2 = r2 | 100663296;
    L95:
        int r6 = r96 & 512;
        if (r6 == 0) goto L99;
        r2 = r2 | 805306368;
    L106:
        int r7 = r96 & 1024;
        if (r7 == 0) goto L110;
        int r19 = r95 | 6;
    L117:
        int r8 = r96 & 2048;
        if (r8 == 0) goto L121;
        r19 = r19 | 48;
    L127:
        int r12 = r19;
        int r10 = r96 & 4096;
        if (r10 == 0) goto L131;
        r12 = r12 | 384;
    L138:
        int r11 = r96 & 8192;
        if (r11 == 0) goto L142;
        r12 = r12 | 3072;
    L149:
        int r1 = r96 & 16384;
        if (r1 == 0) goto L152;
        r12 = r12 | 24576;
        int r18 = r1;
    L160:
        int r110 = r96 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r110 == 0) goto L164;
        r12 = r12 | 196608;
    L170:
        int r111 = r96 & 65536;
        if (r111 == 0) goto L174;
        r12 = r12 | 1572864;
    L180:
        int r22 = r96 & 131072;
        if (r22 == 0) goto L184;
        r12 = r12 | 12582912;
    L191:
        if ((r95 & 100663296) != 0) goto L200;
        if ((r96 & 262144) == 0) goto L195;
    L197:
        int r23 = 33554432;
    L198:
        r12 = r12 | r23;
        goto L200
    L195:
        if (r0.changed(r92) == false) goto L197;
        r23 = 67108864;
    L200:
        boolean r24 = true;
        if ((r2 & 306783379) == 306783378) goto L203;
    L206:
        boolean r13 = true;
    L208:
        if (r0.shouldExecute(r13, r2 & 1) == false) goto L315;
        r0.startDefaults();
        if ((r94 & 1) != 0) goto L212;
    L218:
        if (r5 == 0) goto L220;
        Modifier r14 = Modifier.Companion;
    L221:
        if (r9 == 0) goto L223;
        long r26 = Color.Companion.getUnspecified-0d7_KjU();
    L224:
        TextAlign r15 = null;
        if (r16 == 0) goto L227;
        TextAutoSize r27 = null;
    L228:
        if (r20 == 0) goto L230;
        long r32 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L231:
        if (r25 == 0) goto L233;
        FontStyle r112 = null;
    L234:
        if (r29 == 0) goto L236;
        FontWeight r113 = null;
    L237:
        if (r3 == 0) goto L239;
        FontFamily r28 = null;
    L240:
        if (r4 == 0) goto L242;
        long r210 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L243:
        if (r6 == 0) goto L245;
        TextDecoration r30 = null;
    L246:
        if (r7 != 0) goto L249;
        r15 = r83;
    L249:
        if (r8 == 0) goto L251;
        long r31 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L252:
        if (r10 == 0) goto L254;
        int r33 = TextOverflow.Companion.getClip-gIe3tQ8();
    L255:
        if (r11 == 0) goto L257;
        boolean r114 = true;
    L258:
        if (r18 == 0) goto L260;
        int r115 = Integer.MAX_VALUE;
    L261:
        if (r110 == 0) goto L263;
        int r116 = 1;
    L264:
        if (r111 == 0) goto L266;
        Map<String, InlineTextContent> r117 = MapsKt.emptyMap();
    L267:
        if (r22 == 0) goto L272;
        Object r118 = r0.rememberedValue();
        if (r118 != Composer.Companion.getEmpty()) goto L271;
        r118 = new zt();
        r0.updateRememberedValue(r118);
    L271:
        Function1<? super TextLayoutResult, Unit> r34 = (Function1) r118;
    L274:
        if ((262144 & r96) == 0) goto L276;
        r12 = r12 & (-234881025);
        TextStyle r211 = (TextStyle) r0.consume(LocalTextStyle);
    L277:
        int r119 = r12;
        Modifier r35 = r14;
        boolean r120 = r114;
        long r121 = r31;
        TextDecoration r36 = r30;
        TextAlign r37 = r15;
        FontFamily r38 = r28;
        long r39 = r32;
    L278:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L282;
        ComposerKt.traceEventStart(292247417, r2, r119, "androidx.compose.material3.Text (Text.kt:228)");
    L282:
        r0.startReplaceGroup(1676919644);
        if (r26 == 16) goto L285;
        boolean r40 = true;
    L286:
        if (r40 == false) goto L288;
        long r310 = r26;
    L296:
        r0.endReplaceGroup();
        TextLinkStyles r122 = rememberTextLinkStyles(r0, 0);
        boolean r810 = r120;
        if ((r2 & 14) == 4) goto L300;
        r24 = false;
    L300:
        boolean r41 = r24 | r0.changed(r122);
        Object r123 = r0.rememberedValue();
        if (r41 == false) goto L303;
    L306:
        r123 = createTextWithLinkStyles(r70, r122);
        r0.updateRememberedValue(r123);
    L307:
        AnnotatedString r124 = (AnnotatedString) r123;
        if (r37 == null) goto L310;
        int r125 = r37.unbox-impl();
    L311:
        long r811 = r39;
        int r42 = r119 << 6;
        Modifier r73 = r35;
        Function1<? super TextLayoutResult, Unit> r76 = r34;
        int r710 = r33;
        int r711 = r115;
        int r712 = r116;
        Map<String, InlineTextContent> r713 = r117;
        TextAutoSize r81 = r27;
        BasicTextKt.m1354BasicTextCL7eQgs(r124, r73, TextStyle.merge-dA7vx0o$default(r211, r310, r39, r113, r112, null, r38, null, r210, null, null, null, 0, r36, null, null, r125, 0, r121, null, null, 0, 0, null, null, 16609104, null), r76, r710, r810, r711, r712, r713, null, r81, r0, ((((((r2 & 112) | ((r119 >> 12) & 7168)) | (57344 & r42)) | (458752 & r42)) | (3670016 & r42)) | (29360128 & r42)) | (r42 & 234881024), (r2 >> 9) & 14, 512);
        if (ComposerKt.isTraceInProgress() == false) goto L314;
        ComposerKt.traceEventEnd();
    L314:
        final Modifier r43 = r35;
        final TextDecoration r126 = r36;
        int r212 = r116;
        Map<String, InlineTextContent> r213 = r117;
        final long r44 = r26;
        int r127 = r33;
        final FontStyle r45 = r112;
        final TextAlign r128 = r37;
        final long r46 = r811;
        FontFamily r66 = r38;
        final TextAutoSize r47 = r27;
        Function1<? super TextLayoutResult, Unit> r67 = r34;
        boolean r214 = r810;
        long r68 = r121;
        final FontFamily r129 = r66;
        final long r130 = r210;
        Function1<? super TextLayoutResult, Unit> r215 = r67;
        TextStyle r216 = r211;
        int r217 = r115;
        long r131 = r68;
    L316:
        ScopeUpdateScope r132 = r0.endRestartGroup();
        if (r132 == null) goto L320;
        final FontWeight r48 = r113;
        final long r133 = r131;
        final int r134 = r127;
        final boolean r135 = r214;
        final int r136 = r217;
        final int r218 = r212;
        final Map<String, InlineTextContent> r219 = r213;
        final Function1<? super TextLayoutResult, Unit> r220 = r215;
        final TextStyle r221 = r216;
        r132.updateScope(new au(r70, r43, r44, r47, r46, r45, r48, r129, r130, r126, r128, r133, r134, r135, r136, r218, r219, r220, r221, r94, r95, r96));
        return;
    L320:
        return;
    L310:
        r125 = TextAlign.Companion.getUnspecified-e0LSkKk();
        goto L311
    L303:
        if (r123 != Composer.Companion.getEmpty()) goto L307;
    L288:
        r0.startReplaceGroup(1676920417);
        long r222 = r211.getColor-0d7_KjU();
        if (r222 == 16) goto L291;
        boolean r49 = true;
    L292:
        if (r49 == true) goto L295;
        r222 = ((Color) r0.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
    L295:
        r0.endReplaceGroup();
        r310 = r222;
        goto L296
    L291:
        r49 = false;
        goto L292
    L285:
        r40 = false;
        goto L286
    L276:
        r211 = r92;
        goto L277
    L272:
        r34 = r91;
        goto L274
    L266:
        r117 = r90;
        goto L267
    L263:
        r116 = r89;
        goto L264
    L260:
        r115 = r88;
        goto L261
    L257:
        r114 = r87;
        goto L258
    L254:
        r33 = r86;
        goto L255
    L251:
        r31 = r84;
        goto L252
    L245:
        r30 = r82;
        goto L246
    L242:
        r210 = r80;
        goto L243
    L239:
        r28 = r79;
        goto L240
    L236:
        r113 = r78;
        goto L237
    L233:
        r112 = r77;
        goto L234
    L230:
        r32 = r75;
        goto L231
    L227:
        r27 = r74;
        goto L228
    L223:
        r26 = r72;
        goto L224
    L220:
        r14 = r71;
        goto L221
    L212:
        if (r0.getDefaultsInvalid() == true) goto L218;
        r0.skipToGroupEnd();
        if ((262144 & r96) == 0) goto L217;
        r12 = r12 & (-234881025);
    L217:
        r35 = r71;
        r26 = r72;
        r27 = r74;
        r39 = r75;
        r112 = r77;
        r113 = r78;
        r38 = r79;
        r210 = r80;
        r36 = r82;
        r37 = r83;
        r121 = r84;
        r33 = r86;
        r115 = r88;
        r116 = r89;
        r117 = r90;
        r34 = r91;
        r211 = r92;
        r119 = r12;
        r120 = r87;
        goto L278
    L315:
        r0.skipToGroupEnd();
        r43 = r71;
        r44 = r72;
        r47 = r74;
        r46 = r75;
        r45 = r77;
        r113 = r78;
        r129 = r79;
        r130 = r80;
        r126 = r82;
        r128 = r83;
        r131 = r84;
        r127 = r86;
        r214 = r87;
        r217 = r88;
        r212 = r89;
        r213 = r90;
        r215 = r91;
        r216 = r92;
        goto L316
    L203:
        if ((38347923 & r12) != 38347922) goto L206;
        r13 = false;
        goto L208
    L184:
        if ((r95 & 12582912) != 0) goto L191;
        if (r0.changedInstance(r91) == false) goto L188;
        int r223 = 8388608;
    L189:
        r12 = r12 | r223;
        goto L191
    L188:
        r223 = 4194304;
        goto L189
    L174:
        if ((r95 & 1572864) != 0) goto L180;
        if (r0.changedInstance(r90) == false) goto L178;
        int r224 = 1048576;
    L179:
        r12 = r12 | r224;
        goto L180
    L178:
        r224 = 524288;
        goto L179
    L164:
        if ((r95 & 196608) != 0) goto L170;
        if (r0.changed(r89) == false) goto L168;
        int r137 = 131072;
    L169:
        r12 = r12 | r137;
        goto L170
    L168:
        r137 = 65536;
        goto L169
    L152:
        r18 = r1;
        if ((r95 & 24576) != 0) goto L160;
        if (r0.changed(r88) == true) goto L158;
        r21 = 8192;
    L158:
        r12 = r12 | r21;
        goto L160
    L142:
        if ((r95 & 3072) != 0) goto L149;
        if (r0.changed(r87) == true) goto L147;
        r17 = 1024;
    L147:
        r12 = r12 | r17;
        goto L149
    L131:
        if ((r95 & 384) != 0) goto L138;
        if (r0.changed(r86) == false) goto L135;
        int r225 = 256;
    L136:
        r12 = r12 | r225;
        goto L138
    L135:
        r225 = 128;
        goto L136
    L121:
        if ((r95 & 48) != 0) goto L127;
        if (r0.changed(r84) == false) goto L125;
        int r226 = 32;
    L126:
        r19 = r19 | r226;
        goto L127
    L125:
        r226 = 16;
        goto L126
    L110:
        if ((r95 & 6) == 0) goto L112;
        r19 = r95;
        goto L117
    L112:
        if (r0.changed(r83) == false) goto L114;
        int r138 = 4;
    L115:
        r19 = r95 | r138;
        goto L117
    L114:
        r138 = 2;
        goto L115
    L99:
        if ((805306368 & r94) != 0) goto L106;
        if (r0.changed(r82) == false) goto L103;
        int r311 = 536870912;
    L104:
        r2 = r2 | r311;
        goto L106
    L103:
        r311 = 268435456;
        goto L104
    L89:
        if ((r94 & 100663296) != 0) goto L95;
        if (r0.changed(r80) == false) goto L93;
        int r312 = 67108864;
    L94:
        r2 = r2 | r312;
        goto L95
    L93:
        r312 = 33554432;
        goto L94
    L79:
        if ((r94 & 12582912) != 0) goto L85;
        if (r0.changed(r79) == false) goto L83;
        int r313 = 8388608;
    L84:
        r2 = r2 | r313;
        goto L85
    L83:
        r313 = 4194304;
        goto L84
    L69:
        if ((r94 & 1572864) != 0) goto L75;
        if (r0.changed(r78) == false) goto L73;
        int r314 = 1048576;
    L74:
        r2 = r2 | r314;
        goto L75
    L73:
        r314 = 524288;
        goto L74
    L59:
        if ((r94 & 196608) != 0) goto L65;
        if (r0.changed(r77) == false) goto L63;
        int r227 = 131072;
    L64:
        r2 = r2 | r227;
        goto L65
    L63:
        r227 = 65536;
        goto L64
    L49:
        if ((r94 & 24576) != 0) goto L55;
        if (r0.changed(r75) == false) goto L53;
        int r228 = 16384;
    L54:
        r2 = r2 | r228;
        goto L55
    L53:
        r228 = 8192;
        goto L54
    L38:
        if ((r94 & 3072) != 0) goto L45;
        if (r0.changedInstance(r74) == false) goto L42;
        int r229 = 2048;
    L43:
        r2 = r2 | r229;
        goto L45
    L42:
        r229 = 1024;
        goto L43
    L28:
        if ((r94 & 384) != 0) goto L34;
        if (r0.changed(r72) == false) goto L32;
        int r139 = 256;
    L33:
        r2 = r2 | r139;
        goto L34
    L32:
        r139 = 128;
        goto L33
    L17:
        if ((r94 & 48) != 0) goto L24;
        if (r0.changed(r71) == false) goto L21;
        int r50 = 32;
    L22:
        r2 = r2 | r50;
        goto L24
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r94 & 6) == 0) goto L8;
        r2 = r94;
        goto L13
    L8:
        if (r0.changed(r70) == false) goto L10;
        int r51 = 4;
    L11:
        r2 = r51 | r94;
        goto L13
    L10:
        r51 = 2;
        goto L11
    }
}
