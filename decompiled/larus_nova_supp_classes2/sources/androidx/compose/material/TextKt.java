package androidx.compose.material;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.InlineTextContent;
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
import androidx.compose.ui.graphics.ColorProducer;
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
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÏ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#\u001aÃ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b$\u0010%\u001aã\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b*\u0010+\u001aÙ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010,\u001a(\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020!2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u000104¢\u0006\u0002\b5H\u0007¢\u0006\u0002\u00106\u001a\u0018\u00107\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0002\u001a\r\u0010:\u001a\u000209H\u0003¢\u0006\u0002\u0010;\"\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020!0.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006<"}, d2 = {"Text", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Landroidx/compose/ui/text/TextStyle;", "Text--4IGK_g", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createTextWithLinkStyles", "linkStyles", "Landroidx/compose/ui/text/TextLinkStyles;", "rememberTextLinkStyles", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextLinkStyles;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = null;

    private static final Unit ProvideTextStyle$lambda$14(TextStyle r0, Function2 r1, int r2, Composer r3, int r4) {
        ProvideTextStyle(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Text_IbK3jfQ$lambda$9(AnnotatedString r26, Modifier r27, long r28, long r30, FontStyle r32, FontWeight r33, FontFamily r34, long r35, TextDecoration r37, TextAlign r38, long r39, int r41, boolean r42, int r43, int r44, Map r45, Function1 r46, TextStyle r47, int r48, int r49, int r50, Composer r51, int r52) {
        m2235TextIbK3jfQ(r26, r27, r28, r30, r32, r33, r34, r35, r37, r38, r39, r41, r42, r43, r44, r45, r46, r47, r51, RecomposeScopeImplKt.updateChangedFlags(r48 | 1), RecomposeScopeImplKt.updateChangedFlags(r49), r50);
        return Unit.INSTANCE;
    }

    private static final Unit Text__4IGK_g$lambda$1(String r25, Modifier r26, long r27, long r29, FontStyle r31, FontWeight r32, FontFamily r33, long r34, TextDecoration r36, TextAlign r37, long r38, int r40, boolean r41, int r42, int r43, Function1 r44, TextStyle r45, int r46, int r47, int r48, Composer r49, int r50) {
        m2234Text4IGK_g(r25, r26, r27, r29, r31, r32, r33, r34, r36, r37, r38, r40, r41, r42, r43, r44, r45, r49, RecomposeScopeImplKt.updateChangedFlags(r46 | 1), RecomposeScopeImplKt.updateChangedFlags(r47), r48);
        return Unit.INSTANCE;
    }

    private static final Unit Text__4IGK_g$lambda$12(AnnotatedString r25, Modifier r26, long r27, long r29, FontStyle r31, FontWeight r32, FontFamily r33, long r34, TextDecoration r36, TextAlign r37, long r38, int r40, boolean r41, int r42, Map r43, Function1 r44, TextStyle r45, int r46, int r47, int r48, Composer r49, int r50) {
        m2233Text4IGK_g(r25, r26, r27, r29, r31, r32, r33, r34, r36, r37, r38, r40, r41, r42, r43, r44, r45, r49, RecomposeScopeImplKt.updateChangedFlags(r46 | 1), RecomposeScopeImplKt.updateChangedFlags(r47), r48);
        return Unit.INSTANCE;
    }

    private static final Unit Text_fLXpl1I$lambda$4(String r24, Modifier r25, long r26, long r28, FontStyle r30, FontWeight r31, FontFamily r32, long r33, TextDecoration r35, TextAlign r36, long r37, int r39, boolean r40, int r41, Function1 r42, TextStyle r43, int r44, int r45, int r46, Composer r47, int r48) {
        m2236TextfLXpl1I(r24, r25, r26, r28, r30, r31, r32, r33, r35, r36, r37, r39, r40, r41, r42, r43, r47, RecomposeScopeImplKt.updateChangedFlags(r44 | 1), RecomposeScopeImplKt.updateChangedFlags(r45), r46);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TextLayoutResult r0) {
        return Text_fLXpl1I$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ Unit b(TextLayoutResult r0) {
        return Text_IbK3jfQ$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit c(String r1, Modifier r2, long r3, long r5, FontStyle r7, FontWeight r8, FontFamily r9, long r10, TextDecoration r12, TextAlign r13, long r14, int r16, boolean r17, int r18, int r19, Function1 r20, TextStyle r21, int r22, int r23, int r24, Composer r25, int r26) {
        return Text__4IGK_g$lambda$1(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public static /* synthetic */ AnnotatedString.Range d(TextLinkStyles r0, AnnotatedString.Range r1) {
        return createTextWithLinkStyles$lambda$15(r0, r1);
    }

    public static /* synthetic */ Unit e(AnnotatedString r1, Modifier r2, long r3, long r5, FontStyle r7, FontWeight r8, FontFamily r9, long r10, TextDecoration r12, TextAlign r13, long r14, int r16, boolean r17, int r18, Map r19, Function1 r20, TextStyle r21, int r22, int r23, int r24, Composer r25, int r26) {
        return Text__4IGK_g$lambda$12(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public static /* synthetic */ Unit f(AnnotatedString r1, Modifier r2, long r3, long r5, FontStyle r7, FontWeight r8, FontFamily r9, long r10, TextDecoration r12, TextAlign r13, long r14, int r16, boolean r17, int r18, int r19, Map r20, Function1 r21, TextStyle r22, int r23, int r24, int r25, Composer r26, int r27) {
        return Text_IbK3jfQ$lambda$9(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    }

    public static /* synthetic */ Unit g(String r1, Modifier r2, long r3, long r5, FontStyle r7, FontWeight r8, FontFamily r9, long r10, TextDecoration r12, TextAlign r13, long r14, int r16, boolean r17, int r18, Function1 r19, TextStyle r20, int r21, int r22, int r23, Composer r24, int r25) {
        return Text_fLXpl1I$lambda$4(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ Unit h(TextStyle r0, Function2 r1, int r2, Composer r3, int r4) {
        return ProvideTextStyle$lambda$14(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ TextStyle i() {
        return LocalTextStyle$lambda$13();
    }

    public static /* synthetic */ Unit j(TextLayoutResult r0) {
        return Text__4IGK_g$lambda$11$lambda$10(r0);
    }

    static {
        LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new sd());
    }

    private static final TextStyle LocalTextStyle$lambda$13() {
        return TypographyKt.getDefaultTextStyle();
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    private static final Unit Text_IbK3jfQ$lambda$6$lambda$5(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final Unit Text__4IGK_g$lambda$11$lambda$10(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final Unit Text_fLXpl1I$lambda$3$lambda$2(TextLayoutResult r0) {
        return Unit.INSTANCE;
    }

    private static final AnnotatedString createTextWithLinkStyles(AnnotatedString r1, final TextLinkStyles r2) {
        return r1.mapAnnotations(new qd(r2));
    }

    private static final AnnotatedString.Range createTextWithLinkStyles$lambda$15(TextLinkStyles r9, AnnotatedString.Range r10) {
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
        ComposerKt.traceEventStart(853203714, r27, -1, "androidx.compose.material.rememberTextLinkStyles (Text.kt:431)");
    L5:
        long r3 = MaterialTheme.INSTANCE.getColors(r26, 6).m1999getPrimary0d7_KjU();
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
        Composer r8 = r6.startRestartGroup(-13499697);
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
        r9.updateScope(new nd(r4, r5, r7));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-13499697, r1, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:409)");
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
    public static final /* synthetic */ void m2236TextfLXpl1I(final String r54, Modifier r55, long r56, long r58, FontStyle r60, FontWeight r61, FontFamily r62, long r63, TextDecoration r65, TextAlign r66, long r67, int r69, boolean r70, int r71, Function1 r72, TextStyle r73, Composer r74, final int r75, final int r76, final int r77) {
        Composer r1 = r74.startRestartGroup(-366126944);
        if ((r77 & 1) == 0) goto L6;
        int r5 = r75 | 6;
    L13:
        int r6 = r77 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r10 = r77 & 4;
        if (r10 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        int r17 = r77 & 8;
        int r18 = 2048;
        if (r17 == 0) goto L38;
        r5 = r5 | 3072;
    L44:
        int r22 = r77 & 16;
        int r23 = 16384;
        if (r22 == 0) goto L48;
        r5 = r5 | 24576;
    L55:
        int r26 = r77 & 32;
        int r27 = 65536;
        if (r26 == 0) goto L59;
        r5 = r5 | 196608;
    L65:
        int r30 = r77 & 64;
        if (r30 == 0) goto L69;
        r5 = r5 | 1572864;
    L75:
        int r0 = r77 & 128;
        if (r0 == 0) goto L79;
        r5 = r5 | 12582912;
    L85:
        int r2 = r77 & 256;
        if (r2 == 0) goto L89;
        r5 = r5 | 100663296;
    L96:
        int r3 = r77 & 512;
        if (r3 == 0) goto L100;
        r5 = r5 | 805306368;
    L106:
        int r4 = r77 & 1024;
        if (r4 == 0) goto L110;
        int r29 = r76 | 6;
    L117:
        int r7 = r77 & 2048;
        if (r7 == 0) goto L121;
        r29 = r29 | 48;
    L128:
        int r8 = r29;
        int r9 = r77 & 4096;
        if (r9 == 0) goto L132;
        r8 = r8 | 384;
    L139:
        int r12 = r77 & 8192;
        if (r12 == 0) goto L143;
        r8 = r8 | 3072;
    L150:
        int r11 = r77 & 16384;
        if (r11 == 0) goto L153;
        r8 = r8 | 24576;
        int r16 = r11;
    L162:
        if ((r76 & 196608) != 0) goto L170;
        if ((r77 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L166;
    L168:
        r8 = r8 | r27;
        goto L170
    L166:
        if (r1.changed(r73) == false) goto L168;
        r27 = 131072;
    L170:
        boolean r19 = true;
        if ((r5 & 306783379) == 306783378) goto L173;
    L176:
        boolean r13 = true;
    L178:
        if (r1.shouldExecute(r13, r5 & 1) == false) goto L246;
        r1.startDefaults();
        if ((r75 & 1) != 0) goto L182;
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
        r110 = r66;
    L216:
        if (r4 == 0) goto L218;
        long r31 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L219:
        if (r7 == 0) goto L221;
        int r32 = TextOverflow.Companion.getClip-gIe3tQ8();
    L222:
        if (r9 != 0) goto L225;
        r19 = r70;
    L225:
        if (r12 == 0) goto L227;
        int r33 = Integer.MAX_VALUE;
    L228:
        if (r16 == 0) goto L233;
        Object r34 = r1.rememberedValue();
        if (r34 != Composer.Companion.getEmpty()) goto L232;
        r34 = new td();
        r1.updateRememberedValue(r34);
    L232:
        Function1 r35 = (Function1) r34;
    L235:
        if ((r77 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L237;
        long r41 = r31;
        int r43 = r32;
        int r45 = r33;
        int r112 = r8 & (-458753);
        Function1 r46 = r35;
        TextStyle r47 = (TextStyle) r1.consume(LocalTextStyle);
        boolean r44 = r19;
        long r36 = r20;
        FontWeight r37 = r24;
        FontFamily r38 = r25;
        long r39 = r28;
        final TextDecoration r113 = r21;
        FontStyle r40 = r111;
    L238:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L242;
        ComposerKt.traceEventStart(-366126944, r5, r112, "androidx.compose.material.Text (Text.kt:189)");
    L242:
        int r42 = r112 << 3;
        Modifier r114 = r14;
        long r115 = r15;
        long r210 = r36;
        FontStyle r211 = r40;
        FontWeight r212 = r37;
        FontFamily r213 = r38;
        long r214 = r39;
        TextDecoration r215 = r113;
        TextAlign r216 = r110;
        long r217 = r41;
        int r310 = r43;
        boolean r311 = r44;
        int r312 = r45;
        Function1 r313 = r46;
        TextStyle r314 = r47;
        m2234Text4IGK_g(r54, r114, r115, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, 1, r313, r314, r1, (((((((((r5 & 14) | (r5 & 112)) | (r5 & 896)) | (r5 & 7168)) | (57344 & r5)) | (458752 & r5)) | (3670016 & r5)) | (29360128 & r5)) | (234881024 & r5)) | (r5 & 1879048192), ((((((r112 & 14) | 24576) | (r112 & 112)) | (r112 & 896)) | (r112 & 7168)) | (458752 & r42)) | (r42 & 3670016), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L245;
        ComposerKt.traceEventEnd();
    L245:
        final TextAlign r116 = r110;
        final long r117 = r41;
        final int r118 = r43;
        final boolean r119 = r44;
        final int r120 = r45;
        final Function1 r121 = r46;
        final TextStyle r218 = r47;
        FontFamily r49 = r38;
        final FontStyle r48 = r40;
        long r50 = r39;
        final FontWeight r51 = r37;
        final FontFamily r52 = r49;
        long r53 = r36;
        final Modifier r57 = r14;
        final long r59 = r53;
        final long r64 = r15;
        final long r122 = r50;
    L247:
        ScopeUpdateScope r68 = r1.endRestartGroup();
        if (r68 == null) goto L251;
        r68.updateScope(new ud(r54, r57, r64, r59, r48, r51, r52, r122, r113, r116, r117, r118, r119, r120, r121, r218, r75, r76, r77));
        return;
    L251:
        return;
    L237:
        r47 = r73;
        r113 = r21;
        r41 = r31;
        r43 = r32;
        r45 = r33;
        r112 = r8;
        r46 = r35;
        r40 = r111;
        r44 = r19;
        r36 = r20;
        r37 = r24;
        r38 = r25;
        r39 = r28;
        goto L238
    L233:
        r35 = r72;
        goto L235
    L227:
        r33 = r71;
        goto L228
    L221:
        r32 = r69;
        goto L222
    L218:
        r31 = r67;
        goto L219
    L212:
        r21 = r65;
        goto L213
    L209:
        r28 = r63;
        goto L210
    L206:
        r25 = r62;
        goto L207
    L203:
        r24 = r61;
        goto L204
    L200:
        r111 = r60;
        goto L201
    L196:
        r20 = r58;
        goto L197
    L193:
        r15 = r56;
        goto L194
    L190:
        r14 = r55;
        goto L191
    L182:
        if (r1.getDefaultsInvalid() == true) goto L188;
        r1.skipToGroupEnd();
        if ((r77 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L187;
        r8 = r8 & (-458753);
    L187:
        r14 = r55;
        r15 = r56;
        r36 = r58;
        r40 = r60;
        r37 = r61;
        r38 = r62;
        r113 = r65;
        r110 = r66;
        r41 = r67;
        r43 = r69;
        r44 = r70;
        r45 = r71;
        r46 = r72;
        r47 = r73;
        r112 = r8;
        r39 = r63;
        goto L238
    L246:
        r1 = r1;
        r1.skipToGroupEnd();
        r57 = r55;
        r64 = r56;
        r59 = r58;
        r48 = r60;
        r51 = r61;
        r52 = r62;
        r122 = r63;
        r113 = r65;
        r116 = r66;
        r117 = r67;
        r118 = r69;
        r119 = r70;
        r120 = r71;
        r121 = r72;
        r218 = r73;
        goto L247
    L173:
        if ((74899 & r8) != 74898) goto L176;
        r13 = false;
        goto L178
    L153:
        r16 = r11;
        if ((r76 & 24576) != 0) goto L162;
        if (r1.changedInstance(r72) == true) goto L159;
        r23 = 8192;
    L159:
        r8 = r8 | r23;
        goto L162
    L143:
        if ((r76 & 3072) != 0) goto L150;
        if (r1.changed(r71) == true) goto L148;
        r18 = 1024;
    L148:
        r8 = r8 | r18;
        goto L150
    L132:
        if ((r76 & 384) != 0) goto L139;
        if (r1.changed(r70) == false) goto L136;
        int r219 = 256;
    L137:
        r8 = r8 | r219;
        goto L139
    L136:
        r219 = 128;
        goto L137
    L121:
        if ((r76 & 48) != 0) goto L128;
        if (r1.changed(r69) == false) goto L125;
        int r123 = 32;
    L126:
        r29 = r29 | r123;
        goto L128
    L125:
        r123 = 16;
        goto L126
    L110:
        if ((r76 & 6) == 0) goto L112;
        r29 = r76;
        goto L117
    L112:
        if (r1.changed(r67) == false) goto L114;
        int r220 = 4;
    L115:
        r29 = r76 | r220;
        goto L117
    L114:
        r220 = 2;
        goto L115
    L100:
        if ((r75 & 805306368) != 0) goto L106;
        if (r1.changed(r66) == false) goto L104;
        int r315 = 536870912;
    L105:
        r5 = r5 | r315;
        goto L106
    L104:
        r315 = 268435456;
        goto L105
    L89:
        if ((100663296 & r75) != 0) goto L96;
        if (r1.changed(r65) == false) goto L93;
        int r316 = 67108864;
    L94:
        r5 = r5 | r316;
        goto L96
    L93:
        r316 = 33554432;
        goto L94
    L79:
        if ((r75 & 12582912) != 0) goto L85;
        if (r1.changed(r63) == false) goto L83;
        int r317 = 8388608;
    L84:
        r5 = r5 | r317;
        goto L85
    L83:
        r317 = 4194304;
        goto L84
    L69:
        if ((r75 & 1572864) != 0) goto L75;
        if (r1.changed(r62) == false) goto L73;
        int r318 = 1048576;
    L74:
        r5 = r5 | r318;
        goto L75
    L73:
        r318 = 524288;
        goto L74
    L59:
        if ((r75 & 196608) != 0) goto L65;
        if (r1.changed(r61) == false) goto L63;
        int r319 = 131072;
    L64:
        r5 = r5 | r319;
        goto L65
    L63:
        r319 = 65536;
        goto L64
    L48:
        if ((r75 & 24576) != 0) goto L55;
        if (r1.changed(r60) == false) goto L52;
        int r221 = 16384;
    L53:
        r5 = r5 | r221;
        goto L55
    L52:
        r221 = 8192;
        goto L53
    L38:
        if ((r75 & 3072) != 0) goto L44;
        if (r1.changed(r58) == false) goto L42;
        int r222 = 2048;
    L43:
        r5 = r5 | r222;
        goto L44
    L42:
        r222 = 1024;
        goto L43
    L28:
        if ((r75 & 384) != 0) goto L34;
        if (r1.changed(r56) == false) goto L32;
        int r124 = 256;
    L33:
        r5 = r5 | r124;
        goto L34
    L32:
        r124 = 128;
        goto L33
    L17:
        if ((r75 & 48) != 0) goto L24;
        if (r1.changed(r55) == false) goto L21;
        int r125 = 32;
    L22:
        r5 = r5 | r125;
        goto L24
    L21:
        r125 = 16;
        goto L22
    L6:
        if ((r75 & 6) == 0) goto L8;
        r5 = r75;
        goto L13
    L8:
        if (r1.changed(r54) == false) goto L10;
        int r78 = 4;
    L11:
        r5 = r78 | r75;
        goto L13
    L10:
        r78 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    public static final void m2234Text4IGK_g(final String r67, Modifier r68, long r69, long r71, FontStyle r73, FontWeight r74, FontFamily r75, long r76, TextDecoration r78, TextAlign r79, long r80, int r82, boolean r83, int r84, int r85, Function1<? super TextLayoutResult, Unit> r86, TextStyle r87, Composer r88, final int r89, final int r90, final int r91) {
        Composer r1 = r88.startRestartGroup(1028090691);
        if ((r91 & 1) == 0) goto L6;
        int r5 = r89 | 6;
    L13:
        int r6 = r91 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r10 = r91 & 4;
        if (r10 == 0) goto L28;
        r5 = r5 | 384;
    L34:
        int r17 = r91 & 8;
        int r18 = 2048;
        if (r17 == 0) goto L38;
        r5 = r5 | 3072;
    L44:
        int r22 = r91 & 16;
        int r23 = 16384;
        if (r22 == 0) goto L48;
        r5 = r5 | 24576;
    L55:
        int r26 = r91 & 32;
        if (r26 == 0) goto L59;
        r5 = r5 | 196608;
    L65:
        int r30 = r91 & 64;
        if (r30 == 0) goto L69;
        r5 = r5 | 1572864;
    L75:
        int r0 = r91 & 128;
        if (r0 == 0) goto L79;
        r5 = r5 | 12582912;
    L85:
        int r2 = r91 & 256;
        if (r2 == 0) goto L89;
        r5 = r5 | 100663296;
    L96:
        int r3 = r91 & 512;
        if (r3 == 0) goto L100;
        r5 = r5 | 805306368;
    L106:
        int r4 = r91 & 1024;
        if (r4 == 0) goto L110;
        int r29 = r90 | 6;
    L117:
        int r7 = r91 & 2048;
        if (r7 == 0) goto L121;
        r29 = r29 | 48;
    L128:
        int r8 = r29;
        int r9 = r91 & 4096;
        if (r9 == 0) goto L132;
        r8 = r8 | 384;
    L139:
        int r12 = r91 & 8192;
        if (r12 == 0) goto L143;
        r8 = r8 | 3072;
    L150:
        int r11 = r91 & 16384;
        if (r11 == 0) goto L153;
        r8 = r8 | 24576;
        int r16 = r11;
    L161:
        int r19 = r91 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r19 == 0) goto L165;
        r8 = r8 | 196608;
    L172:
        if ((r90 & 1572864) != 0) goto L181;
        if ((r91 & 65536) == 0) goto L176;
    L178:
        int r110 = 524288;
    L179:
        r8 = r8 | r110;
        goto L181
    L176:
        if (r1.changed(r87) == false) goto L178;
        r110 = 1048576;
    L181:
        boolean r111 = false;
        if ((r5 & 306783379) == 306783378) goto L184;
    L187:
        boolean r13 = true;
    L189:
        if (r1.shouldExecute(r13, r5 & 1) == false) goto L278;
        r1.startDefaults();
        if ((r89 & 1) != 0) goto L193;
    L200:
        if (r6 == 0) goto L202;
        Modifier r14 = Modifier.Companion;
    L203:
        if (r10 == 0) goto L205;
        final long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L206:
        if (r17 == 0) goto L208;
        long r24 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L209:
        Function1<? super TextLayoutResult, Unit> r112 = null;
        if (r22 == 0) goto L212;
        FontStyle r113 = null;
    L213:
        if (r26 == 0) goto L215;
        FontWeight r21 = null;
    L216:
        if (r30 == 0) goto L218;
        FontFamily r25 = null;
    L219:
        if (r0 == 0) goto L221;
        long r27 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L222:
        if (r2 == 0) goto L224;
        TextDecoration r20 = null;
    L225:
        if (r3 == 0) goto L227;
        TextAlign r28 = null;
    L228:
        if (r4 == 0) goto L230;
        long r31 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L231:
        if (r7 == 0) goto L233;
        int r32 = TextOverflow.Companion.getClip-gIe3tQ8();
    L234:
        if (r9 == 0) goto L236;
        boolean r33 = true;
    L237:
        if (r12 == 0) goto L239;
        int r114 = Integer.MAX_VALUE;
    L240:
        if (r16 == 0) goto L242;
        int r115 = 1;
    L243:
        if (r19 != 0) goto L246;
        r112 = r86;
    L246:
        TextDecoration r610 = r20;
        if ((r91 & 65536) != 0) goto L248;
    L199:
        int r116 = r8;
        TextStyle r34 = r87;
    L249:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L253;
        ComposerKt.traceEventStart(1028090691, r5, r116, "androidx.compose.material.Text (Text.kt:115)");
    L253:
        long r210 = ((Color) r1.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        float r117 = ((Number) r1.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
        if (r15 == 16) goto L256;
        boolean r118 = true;
    L257:
        if (r118 == false) goto L260;
    L266:
        if (r28 == null) goto L268;
        int r119 = r28.unbox-impl();
    L269:
        TextStyle r120 = TextStyle.merge-dA7vx0o$default(r34, 0, r24, r21, r113, null, r25, null, r27, null, null, null, 0, r20, null, null, r119, 0, r31, null, null, 0, 0, null, null, 16609105, null);
        boolean r121 = r1.changed(r15);
        TextDecoration r810 = r20;
        Object r35 = r1.rememberedValue();
        if (r121 == false) goto L272;
    L273:
        r35 = new TextKt$Text$1$1(r15);
        r1.updateRememberedValue(r35);
    L274:
        int r36 = ((r5 & 112) | (r5 & 14)) | ((r116 >> 6) & 7168);
        int r122 = r116 << 9;
        BasicTextKt.m1356BasicTextRWo7tUw(r67, r14, r120, r112, r32, r33, r114, r115, (ColorProducer) r35, null, r1, (((r36 | (57344 & r122)) | (458752 & r122)) | (3670016 & r122)) | (r122 & 29360128), 512);
        if (ComposerKt.isTraceInProgress() == false) goto L277;
        ComposerKt.traceEventEnd();
    L277:
        final int r123 = r114;
        final TextDecoration r124 = r810;
        final TextAlign r125 = r28;
        final Modifier r37 = r14;
        final Function1<? super TextLayoutResult, Unit> r211 = r112;
        final int r126 = r115;
        final long r38 = r24;
        final long r127 = r27;
        final long r128 = r31;
        final int r129 = r32;
        final FontStyle r39 = r113;
        final long r40 = r15;
        final boolean r130 = r33;
        final FontFamily r41 = r25;
        FontWeight r66 = r21;
        final TextStyle r212 = r34;
        final FontWeight r42 = r66;
    L279:
        ScopeUpdateScope r43 = r1.endRestartGroup();
        if (r43 == null) goto L283;
        r43.updateScope(new rd(r67, r37, r40, r38, r39, r42, r41, r127, r124, r125, r128, r129, r130, r123, r126, r211, r212, r89, r90, r91));
        return;
    L283:
        return;
    L272:
        if (r35 != Composer.Companion.getEmpty()) goto L274;
    L268:
        r119 = TextAlign.Companion.getUnspecified-e0LSkKk();
        goto L269
    L260:
        if (r34.getColor-0d7_KjU() == 16) goto L262;
        r111 = true;
    L262:
        if (r111 == false) goto L264;
        long r131 = r34.getColor-0d7_KjU();
    L265:
        r15 = r131;
        goto L266
    L264:
        r131 = Color.copy-wmQWz5c$default(r210, r117, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        goto L265
    L256:
        r118 = false;
        goto L257
    L248:
        r116 = r8 & (-3670017);
        r34 = (TextStyle) r1.consume(LocalTextStyle);
        r20 = r610;
        goto L249
    L242:
        r115 = r85;
        goto L243
    L239:
        r114 = r84;
        goto L240
    L236:
        r33 = r83;
        goto L237
    L233:
        r32 = r82;
        goto L234
    L230:
        r31 = r80;
        goto L231
    L227:
        r28 = r79;
        goto L228
    L224:
        r20 = r78;
        goto L225
    L221:
        r27 = r76;
        goto L222
    L218:
        r25 = r75;
        goto L219
    L215:
        r21 = r74;
        goto L216
    L212:
        r113 = r73;
        goto L213
    L208:
        r24 = r71;
        goto L209
    L205:
        r15 = r69;
        goto L206
    L202:
        r14 = r68;
        goto L203
    L193:
        if (r1.getDefaultsInvalid() == true) goto L200;
        r1.skipToGroupEnd();
        if ((r91 & 65536) == 0) goto L198;
        r8 = r8 & (-3670017);
    L198:
        r14 = r68;
        r15 = r69;
        r24 = r71;
        r113 = r73;
        r21 = r74;
        r25 = r75;
        r27 = r76;
        r20 = r78;
        r28 = r79;
        r31 = r80;
        r32 = r82;
        r33 = r83;
        r114 = r84;
        r115 = r85;
        r112 = r86;
        goto L199
    L278:
        r1.skipToGroupEnd();
        r37 = r68;
        r40 = r69;
        r38 = r71;
        r39 = r73;
        r42 = r74;
        r41 = r75;
        r127 = r76;
        r124 = r78;
        r125 = r79;
        r128 = r80;
        r129 = r82;
        r130 = r83;
        r123 = r84;
        r126 = r85;
        r211 = r86;
        r212 = r87;
        goto L279
    L184:
        if ((599187 & r8) != 599186) goto L187;
        r13 = false;
        goto L189
    L165:
        if ((r90 & 196608) != 0) goto L172;
        if (r1.changedInstance(r86) == false) goto L169;
        int r132 = 131072;
    L170:
        r8 = r8 | r132;
        goto L172
    L169:
        r132 = 65536;
        goto L170
    L153:
        r16 = r11;
        if ((r90 & 24576) != 0) goto L161;
        if (r1.changed(r85) == true) goto L159;
        r23 = 8192;
    L159:
        r8 = r8 | r23;
        goto L161
    L143:
        if ((r90 & 3072) != 0) goto L150;
        if (r1.changed(r84) == true) goto L148;
        r18 = 1024;
    L148:
        r8 = r8 | r18;
        goto L150
    L132:
        if ((r90 & 384) != 0) goto L139;
        if (r1.changed(r83) == false) goto L136;
        int r213 = 256;
    L137:
        r8 = r8 | r213;
        goto L139
    L136:
        r213 = 128;
        goto L137
    L121:
        if ((r90 & 48) != 0) goto L128;
        if (r1.changed(r82) == false) goto L125;
        int r133 = 32;
    L126:
        r29 = r29 | r133;
        goto L128
    L125:
        r133 = 16;
        goto L126
    L110:
        if ((r90 & 6) == 0) goto L112;
        r29 = r90;
        goto L117
    L112:
        if (r1.changed(r80) == false) goto L114;
        int r214 = 4;
    L115:
        r29 = r90 | r214;
        goto L117
    L114:
        r214 = 2;
        goto L115
    L100:
        if ((r89 & 805306368) != 0) goto L106;
        if (r1.changed(r79) == false) goto L104;
        int r310 = 536870912;
    L105:
        r5 = r5 | r310;
        goto L106
    L104:
        r310 = 268435456;
        goto L105
    L89:
        if ((100663296 & r89) != 0) goto L96;
        if (r1.changed(r78) == false) goto L93;
        int r311 = 67108864;
    L94:
        r5 = r5 | r311;
        goto L96
    L93:
        r311 = 33554432;
        goto L94
    L79:
        if ((r89 & 12582912) != 0) goto L85;
        if (r1.changed(r76) == false) goto L83;
        int r312 = 8388608;
    L84:
        r5 = r5 | r312;
        goto L85
    L83:
        r312 = 4194304;
        goto L84
    L69:
        if ((r89 & 1572864) != 0) goto L75;
        if (r1.changed(r75) == false) goto L73;
        int r313 = 1048576;
    L74:
        r5 = r5 | r313;
        goto L75
    L73:
        r313 = 524288;
        goto L74
    L59:
        if ((r89 & 196608) != 0) goto L65;
        if (r1.changed(r74) == false) goto L63;
        int r314 = 131072;
    L64:
        r5 = r5 | r314;
        goto L65
    L63:
        r314 = 65536;
        goto L64
    L48:
        if ((r89 & 24576) != 0) goto L55;
        if (r1.changed(r73) == false) goto L52;
        int r215 = 16384;
    L53:
        r5 = r5 | r215;
        goto L55
    L52:
        r215 = 8192;
        goto L53
    L38:
        if ((r89 & 3072) != 0) goto L44;
        if (r1.changed(r71) == false) goto L42;
        int r216 = 2048;
    L43:
        r5 = r5 | r216;
        goto L44
    L42:
        r216 = 1024;
        goto L43
    L28:
        if ((r89 & 384) != 0) goto L34;
        if (r1.changed(r69) == false) goto L32;
        int r134 = 256;
    L33:
        r5 = r5 | r134;
        goto L34
    L32:
        r134 = 128;
        goto L33
    L17:
        if ((r89 & 48) != 0) goto L24;
        if (r1.changed(r68) == false) goto L21;
        int r135 = 32;
    L22:
        r5 = r5 | r135;
        goto L24
    L21:
        r135 = 16;
        goto L22
    L6:
        if ((r89 & 6) == 0) goto L8;
        r5 = r89;
        goto L13
    L8:
        if (r1.changed(r67) == false) goto L10;
        int r44 = 4;
    L11:
        r5 = r44 | r89;
        goto L13
    L10:
        r44 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    public static final /* synthetic */ void m2233Text4IGK_g(final AnnotatedString r56, Modifier r57, long r58, long r60, FontStyle r62, FontWeight r63, FontFamily r64, long r65, TextDecoration r67, TextAlign r68, long r69, int r71, boolean r72, int r73, Map r74, Function1 r75, TextStyle r76, Composer r77, final int r78, final int r79, final int r80) {
        Composer r1 = r77.startRestartGroup(-422393234);
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
        boolean r111 = true;
        if ((r5 & 306783379) == 306783378) goto L184;
    L187:
        boolean r13 = true;
    L189:
        if (r1.shouldExecute(r13, r5 & 1) == false) goto L260;
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
        r112 = r68;
    L227:
        if (r4 == 0) goto L229;
        long r29 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L230:
        if (r7 == 0) goto L232;
        int r32 = TextOverflow.Companion.getClip-gIe3tQ8();
    L233:
        if (r9 != 0) goto L236;
        r111 = r72;
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
        r114 = new vd();
        r1.updateRememberedValue(r114);
    L246:
        Function1 r35 = (Function1) r114;
    L249:
        if ((r80 & 65536) == 0) goto L251;
        Function1 r48 = r35;
        long r42 = r29;
        int r44 = r32;
        int r46 = r33;
        int r115 = r8 & (-3670017);
        Map r47 = r34;
        TextStyle r49 = (TextStyle) r1.consume(LocalTextStyle);
        FontStyle r36 = r113;
        boolean r45 = r111;
        long r37 = r20;
        FontWeight r38 = r24;
        FontFamily r39 = r25;
        long r40 = r28;
        final TextDecoration r116 = r21;
    L252:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L256;
        ComposerKt.traceEventStart(-422393234, r5, r115, "androidx.compose.material.Text (Text.kt:368)");
    L256:
        int r41 = r115 << 3;
        Modifier r117 = r14;
        long r118 = r15;
        long r210 = r37;
        FontStyle r211 = r36;
        FontWeight r212 = r38;
        FontFamily r213 = r39;
        long r214 = r40;
        TextDecoration r215 = r116;
        TextAlign r216 = r112;
        long r217 = r42;
        int r310 = r44;
        boolean r311 = r45;
        int r312 = r46;
        Map r313 = r47;
        Function1 r314 = r48;
        TextStyle r315 = r49;
        m2235TextIbK3jfQ(r56, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, 1, r313, r314, r315, r1, (((((((((r5 & 14) | (r5 & 112)) | (r5 & 896)) | (r5 & 7168)) | (57344 & r5)) | (458752 & r5)) | (3670016 & r5)) | (29360128 & r5)) | (234881024 & r5)) | (r5 & 1879048192), (((((((r115 & 14) | 24576) | (r115 & 112)) | (r115 & 896)) | (r115 & 7168)) | (458752 & r41)) | (3670016 & r41)) | (r41 & 29360128), 0);
        if (ComposerKt.isTraceInProgress() == false) goto L259;
        ComposerKt.traceEventEnd();
    L259:
        final TextAlign r119 = r112;
        final long r120 = r42;
        final int r121 = r44;
        final boolean r122 = r45;
        final int r123 = r46;
        final Map r124 = r47;
        final Function1 r218 = r48;
        final TextStyle r219 = r49;
        FontFamily r51 = r39;
        final FontStyle r43 = r36;
        long r52 = r40;
        final FontWeight r50 = r38;
        final FontFamily r53 = r51;
        long r54 = r37;
        final Modifier r55 = r14;
        final long r59 = r54;
        final long r61 = r15;
        final long r125 = r52;
    L261:
        ScopeUpdateScope r66 = r1.endRestartGroup();
        if (r66 == null) goto L265;
        r66.updateScope(new wd(r56, r55, r61, r59, r43, r50, r53, r125, r116, r119, r120, r121, r122, r123, r124, r218, r219, r78, r79, r80));
        return;
    L265:
        return;
    L251:
        r116 = r21;
        r49 = r76;
        r48 = r35;
        r42 = r29;
        r44 = r32;
        r46 = r33;
        r115 = r8;
        r47 = r34;
        r36 = r113;
        r45 = r111;
        r37 = r20;
        r38 = r24;
        r39 = r25;
        r40 = r28;
        goto L252
    L247:
        r35 = r75;
        goto L249
    L241:
        r34 = r74;
        goto L242
    L238:
        r33 = r73;
        goto L239
    L232:
        r32 = r71;
        goto L233
    L229:
        r29 = r69;
        goto L230
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
        r37 = r60;
        r36 = r62;
        r38 = r63;
        r39 = r64;
        r116 = r67;
        r112 = r68;
        r42 = r69;
        r44 = r71;
        r45 = r72;
        r46 = r73;
        r47 = r74;
        r48 = r75;
        r49 = r76;
        r115 = r8;
        r40 = r65;
        goto L252
    L260:
        r1 = r1;
        r1.skipToGroupEnd();
        r55 = r57;
        r61 = r58;
        r59 = r60;
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
        r218 = r75;
        r219 = r76;
        goto L261
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
        if (r1.changedInstance(r74) == true) goto L159;
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
        int r220 = 256;
    L137:
        r8 = r8 | r220;
        goto L139
    L136:
        r220 = 128;
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
        int r316 = 4;
    L115:
        r30 = r79 | r316;
        goto L117
    L114:
        r316 = 2;
        goto L115
    L100:
        if ((r78 & 805306368) != 0) goto L106;
        if (r1.changed(r68) == false) goto L104;
        int r317 = 536870912;
    L105:
        r5 = r5 | r317;
        goto L106
    L104:
        r317 = 268435456;
        goto L105
    L89:
        if ((100663296 & r78) != 0) goto L96;
        if (r1.changed(r67) == false) goto L93;
        int r318 = 67108864;
    L94:
        r5 = r5 | r318;
        goto L96
    L93:
        r318 = 33554432;
        goto L94
    L79:
        if ((r78 & 12582912) != 0) goto L85;
        if (r1.changed(r65) == false) goto L83;
        int r319 = 8388608;
    L84:
        r5 = r5 | r319;
        goto L85
    L83:
        r319 = 4194304;
        goto L84
    L69:
        if ((r78 & 1572864) != 0) goto L75;
        if (r1.changed(r64) == false) goto L73;
        int r320 = 1048576;
    L74:
        r5 = r5 | r320;
        goto L75
    L73:
        r320 = 524288;
        goto L74
    L59:
        if ((r78 & 196608) != 0) goto L65;
        if (r1.changed(r63) == false) goto L63;
        int r321 = 131072;
    L64:
        r5 = r5 | r321;
        goto L65
    L63:
        r321 = 65536;
        goto L64
    L48:
        if ((r78 & 24576) != 0) goto L55;
        if (r1.changed(r62) == false) goto L52;
        int r221 = 16384;
    L53:
        r5 = r5 | r221;
        goto L55
    L52:
        r221 = 8192;
        goto L53
    L38:
        if ((r78 & 3072) != 0) goto L44;
        if (r1.changed(r60) == false) goto L42;
        int r222 = 2048;
    L43:
        r5 = r5 | r222;
        goto L44
    L42:
        r222 = 1024;
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
        int r70 = 4;
    L11:
        r5 = r70 | r78;
        goto L13
    L10:
        r70 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Text-IbK3jfQ, reason: not valid java name */
    public static final void m2235TextIbK3jfQ(final AnnotatedString r68, Modifier r69, long r70, long r72, FontStyle r74, FontWeight r75, FontFamily r76, long r77, TextDecoration r79, TextAlign r80, long r81, int r83, boolean r84, int r85, int r86, Map<String, InlineTextContent> r87, Function1<? super TextLayoutResult, Unit> r88, TextStyle r89, Composer r90, final int r91, final int r92, final int r93) {
        Composer r0 = r90.startRestartGroup(744129681);
        if ((r93 & 1) == 0) goto L6;
        int r2 = r91 | 6;
    L13:
        int r5 = r93 & 2;
        if (r5 == 0) goto L17;
        r2 = r2 | 48;
    L24:
        int r9 = r93 & 4;
        if (r9 == 0) goto L28;
        r2 = r2 | 384;
    L34:
        int r16 = r93 & 8;
        int r17 = 2048;
        if (r16 == 0) goto L38;
        r2 = r2 | 3072;
    L44:
        int r21 = r93 & 16;
        int r22 = 16384;
        if (r21 == 0) goto L48;
        r2 = r2 | 24576;
    L55:
        int r25 = r93 & 32;
        if (r25 == 0) goto L59;
        r2 = r2 | 196608;
    L65:
        int r30 = r93 & 64;
        if (r30 == 0) goto L69;
        r2 = r2 | 1572864;
    L75:
        int r3 = r93 & 128;
        if (r3 == 0) goto L79;
        r2 = r2 | 12582912;
    L85:
        int r4 = r93 & 256;
        if (r4 == 0) goto L89;
        r2 = r2 | 100663296;
    L95:
        int r7 = r93 & 512;
        if (r7 == 0) goto L99;
        r2 = r2 | 805306368;
    L105:
        int r6 = r93 & 1024;
        if (r6 == 0) goto L109;
        int r19 = r92 | 6;
    L116:
        int r8 = r93 & 2048;
        if (r8 == 0) goto L120;
        r19 = r19 | 48;
    L126:
        int r11 = r19;
        int r10 = r93 & 4096;
        if (r10 == 0) goto L130;
        r11 = r11 | 384;
    L137:
        int r12 = r93 & 8192;
        if (r12 == 0) goto L141;
        r11 = r11 | 3072;
    L148:
        int r1 = r93 & 16384;
        if (r1 == 0) goto L151;
        r11 = r11 | 24576;
        int r18 = r1;
    L159:
        int r110 = r93 & BiometricManager$Authenticators.DEVICE_CREDENTIAL;
        if (r110 == 0) goto L163;
        r11 = r11 | 196608;
    L169:
        int r111 = r93 & 65536;
        if (r111 == 0) goto L173;
        r11 = r11 | 1572864;
    L180:
        if ((r92 & 12582912) != 0) goto L189;
        if ((r93 & 131072) == 0) goto L184;
    L186:
        int r20 = 4194304;
    L187:
        r11 = r11 | r20;
        goto L189
    L184:
        if (r0.changed(r89) == false) goto L186;
        r20 = 8388608;
    L189:
        boolean r23 = true;
        if ((r2 & 306783379) == 306783378) goto L192;
    L195:
        boolean r13 = true;
    L197:
        if (r0.shouldExecute(r13, r2 & 1) == false) goto L307;
        r0.startDefaults();
        if ((r91 & 1) != 0) goto L201;
    L207:
        if (r5 == 0) goto L209;
        Modifier r14 = Modifier.Companion;
    L210:
        if (r9 == 0) goto L212;
        long r24 = Color.Companion.getUnspecified-0d7_KjU();
    L213:
        if (r16 == 0) goto L215;
        long r15 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L216:
        TextAlign r26 = null;
        if (r21 == 0) goto L219;
        FontStyle r27 = null;
    L220:
        if (r25 == 0) goto L222;
        FontWeight r28 = null;
    L223:
        if (r30 == 0) goto L225;
        FontFamily r29 = null;
    L226:
        if (r3 == 0) goto L228;
        long r210 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L229:
        if (r4 == 0) goto L231;
        TextDecoration r31 = null;
    L232:
        if (r7 != 0) goto L235;
        r26 = r80;
    L235:
        if (r6 == 0) goto L237;
        long r32 = TextUnit.Companion.getUnspecified-XSAIIZE();
    L238:
        if (r8 == 0) goto L240;
        int r33 = TextOverflow.Companion.getClip-gIe3tQ8();
    L241:
        if (r10 == 0) goto L243;
        boolean r34 = true;
    L244:
        if (r12 == 0) goto L246;
        int r112 = Integer.MAX_VALUE;
    L247:
        if (r18 == 0) goto L249;
        int r113 = 1;
    L250:
        if (r110 == 0) goto L252;
        Map<String, InlineTextContent> r114 = MapsKt.emptyMap();
    L253:
        if (r111 == 0) goto L258;
        Object r115 = r0.rememberedValue();
        if (r115 != Composer.Companion.getEmpty()) goto L257;
        r115 = new od();
        r0.updateRememberedValue(r115);
    L257:
        Function1<? super TextLayoutResult, Unit> r35 = (Function1) r115;
    L260:
        if ((r93 & 131072) == 0) goto L262;
        TextStyle r116 = (TextStyle) r0.consume(LocalTextStyle);
        r11 = r11 & (-29360129);
    L263:
        int r117 = r11;
        Function1<? super TextLayoutResult, Unit> r118 = r35;
        Modifier r36 = r14;
    L264:
        r0.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L268;
        ComposerKt.traceEventStart(744129681, r2, r117, "androidx.compose.material.Text (Text.kt:288)");
    L268:
        long r119 = ((Color) r0.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        float r120 = ((Number) r0.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
        if (r24 == 16) goto L271;
        boolean r121 = true;
    L272:
        if (r121 == false) goto L276;
        final long r122 = r24;
    L283:
        TextLinkStyles r37 = rememberTextLinkStyles(r0, 0);
        int r810 = r33;
        if ((r2 & 14) == 4) goto L287;
        r23 = false;
    L287:
        boolean r38 = r23 | r0.changed(r37);
        Object r123 = r0.rememberedValue();
        if (r38 == false) goto L290;
    L293:
        r123 = createTextWithLinkStyles(r68, r37);
        r0.updateRememberedValue(r123);
    L294:
        AnnotatedString r39 = (AnnotatedString) r123;
        if (r26 == null) goto L297;
        int r124 = r26.unbox-impl();
    L298:
        TextStyle r125 = TextStyle.merge-dA7vx0o$default(r116, 0, r15, r28, r27, null, r29, null, r210, null, null, null, 0, r31, null, null, r124, 0, r32, null, null, 0, 0, null, null, 16609105, null);
        boolean r126 = r0.changed(r122);
        TextDecoration r811 = r31;
        Object r40 = r0.rememberedValue();
        if (r126 == false) goto L301;
    L302:
        r40 = new TextKt$Text$6$1(r122);
        r0.updateRememberedValue(r40);
    L303:
        int r127 = r117 << 9;
        Modifier r71 = r36;
        Function1 r73 = r118;
        boolean r78 = r34;
        int r710 = r112;
        int r711 = r113;
        Map<String, InlineTextContent> r712 = r114;
        BasicTextKt.m1354BasicTextCL7eQgs(r39, r71, r125, r73, r810, r78, r710, r711, r712, (ColorProducer) r40, null, r0, ((((((r2 & 112) | ((r117 >> 9) & 7168)) | (57344 & r127)) | (458752 & r127)) | (3670016 & r127)) | (29360128 & r127)) | (r127 & 234881024), 0, 1024);
        if (ComposerKt.isTraceInProgress() == false) goto L306;
        ComposerKt.traceEventEnd();
    L306:
        final Modifier r41 = r36;
        final TextAlign r128 = r26;
        final TextStyle r211 = r116;
        final int r129 = r113;
        final Map<String, InlineTextContent> r212 = r114;
        final FontWeight r42 = r28;
        final long r43 = r24;
        final long r130 = r210;
        final int r131 = r112;
        final Function1<? super TextLayoutResult, Unit> r213 = r118;
        final boolean r132 = r34;
        final TextDecoration r133 = r811;
        final int r134 = r810;
        final long r135 = r32;
        final FontStyle r44 = r27;
        final long r45 = r15;
        final FontFamily r46 = r29;
    L308:
        ScopeUpdateScope r47 = r0.endRestartGroup();
        if (r47 == null) goto L312;
        r47.updateScope(new pd(r68, r41, r43, r45, r44, r42, r46, r130, r133, r128, r135, r134, r132, r131, r129, r212, r213, r211, r91, r92, r93));
        return;
    L312:
        return;
    L301:
        if (r40 != Composer.Companion.getEmpty()) goto L303;
    L297:
        r124 = TextAlign.Companion.getUnspecified-e0LSkKk();
        goto L298
    L290:
        if (r123 != Composer.Companion.getEmpty()) goto L294;
    L276:
        if (r116.getColor-0d7_KjU() == 16) goto L278;
        boolean r136 = true;
    L279:
        if (r136 == false) goto L281;
        long r137 = r116.getColor-0d7_KjU();
    L282:
        r122 = r137;
        goto L283
    L281:
        r137 = Color.copy-wmQWz5c$default(r119, r120, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        goto L282
    L278:
        r136 = false;
        goto L279
    L271:
        r121 = false;
        goto L272
    L262:
        r116 = r89;
        goto L263
    L258:
        r35 = r88;
        goto L260
    L252:
        r114 = r87;
        goto L253
    L249:
        r113 = r86;
        goto L250
    L246:
        r112 = r85;
        goto L247
    L243:
        r34 = r84;
        goto L244
    L240:
        r33 = r83;
        goto L241
    L237:
        r32 = r81;
        goto L238
    L231:
        r31 = r79;
        goto L232
    L228:
        r210 = r77;
        goto L229
    L225:
        r29 = r76;
        goto L226
    L222:
        r28 = r75;
        goto L223
    L219:
        r27 = r74;
        goto L220
    L215:
        r15 = r72;
        goto L216
    L212:
        r24 = r70;
        goto L213
    L209:
        r14 = r69;
        goto L210
    L201:
        if (r0.getDefaultsInvalid() == true) goto L207;
        r0.skipToGroupEnd();
        if ((r93 & 131072) == 0) goto L206;
        r11 = r11 & (-29360129);
    L206:
        r36 = r69;
        r24 = r70;
        r15 = r72;
        r27 = r74;
        r28 = r75;
        r29 = r76;
        r210 = r77;
        r31 = r79;
        r26 = r80;
        r32 = r81;
        r33 = r83;
        r34 = r84;
        r112 = r85;
        r113 = r86;
        r114 = r87;
        r116 = r89;
        r117 = r11;
        r118 = r88;
        goto L264
    L307:
        r0.skipToGroupEnd();
        r41 = r69;
        r43 = r70;
        r45 = r72;
        r44 = r74;
        r42 = r75;
        r46 = r76;
        r130 = r77;
        r133 = r79;
        r128 = r80;
        r135 = r81;
        r134 = r83;
        r132 = r84;
        r131 = r85;
        r129 = r86;
        r212 = r87;
        r213 = r88;
        r211 = r89;
        goto L308
    L192:
        if ((4793491 & r11) != 4793490) goto L195;
        r13 = false;
        goto L197
    L173:
        if ((r92 & 1572864) != 0) goto L180;
        if (r0.changedInstance(r88) == false) goto L177;
        int r214 = 1048576;
    L178:
        r11 = r11 | r214;
        goto L180
    L177:
        r214 = 524288;
        goto L178
    L163:
        if ((r92 & 196608) != 0) goto L169;
        if (r0.changedInstance(r87) == false) goto L167;
        int r138 = 131072;
    L168:
        r11 = r11 | r138;
        goto L169
    L167:
        r138 = 65536;
        goto L168
    L151:
        r18 = r1;
        if ((r92 & 24576) != 0) goto L159;
        if (r0.changed(r86) == true) goto L157;
        r22 = 8192;
    L157:
        r11 = r11 | r22;
        goto L159
    L141:
        if ((r92 & 3072) != 0) goto L148;
        if (r0.changed(r85) == true) goto L146;
        r17 = 1024;
    L146:
        r11 = r11 | r17;
        goto L148
    L130:
        if ((r92 & 384) != 0) goto L137;
        if (r0.changed(r84) == false) goto L134;
        int r215 = 256;
    L135:
        r11 = r11 | r215;
        goto L137
    L134:
        r215 = 128;
        goto L135
    L120:
        if ((r92 & 48) != 0) goto L126;
        if (r0.changed(r83) == false) goto L124;
        int r216 = 32;
    L125:
        r19 = r19 | r216;
        goto L126
    L124:
        r216 = 16;
        goto L125
    L109:
        if ((r92 & 6) == 0) goto L111;
        r19 = r92;
        goto L116
    L111:
        if (r0.changed(r81) == false) goto L113;
        int r139 = 4;
    L114:
        r19 = r92 | r139;
        goto L116
    L113:
        r139 = 2;
        goto L114
    L99:
        if ((r91 & 805306368) != 0) goto L105;
        if (r0.changed(r80) == false) goto L103;
        int r310 = 536870912;
    L104:
        r2 = r2 | r310;
        goto L105
    L103:
        r310 = 268435456;
        goto L104
    L89:
        if ((r91 & 100663296) != 0) goto L95;
        if (r0.changed(r79) == false) goto L93;
        int r48 = 67108864;
    L94:
        r2 = r2 | r48;
        goto L95
    L93:
        r48 = 33554432;
        goto L94
    L79:
        if ((r91 & 12582912) != 0) goto L85;
        if (r0.changed(r77) == false) goto L83;
        int r311 = 8388608;
    L84:
        r2 = r2 | r311;
        goto L85
    L83:
        r311 = 4194304;
        goto L84
    L69:
        if ((r91 & 1572864) != 0) goto L75;
        if (r0.changed(r76) == false) goto L73;
        int r312 = 1048576;
    L74:
        r2 = r2 | r312;
        goto L75
    L73:
        r312 = 524288;
        goto L74
    L59:
        if ((r91 & 196608) != 0) goto L65;
        if (r0.changed(r75) == false) goto L63;
        int r313 = 131072;
    L64:
        r2 = r2 | r313;
        goto L65
    L63:
        r313 = 65536;
        goto L64
    L48:
        if ((r91 & 24576) != 0) goto L55;
        if (r0.changed(r74) == false) goto L52;
        int r217 = 16384;
    L53:
        r2 = r2 | r217;
        goto L55
    L52:
        r217 = 8192;
        goto L53
    L38:
        if ((r91 & 3072) != 0) goto L44;
        if (r0.changed(r72) == false) goto L42;
        int r218 = 2048;
    L43:
        r2 = r2 | r218;
        goto L44
    L42:
        r218 = 1024;
        goto L43
    L28:
        if ((r91 & 384) != 0) goto L34;
        if (r0.changed(r70) == false) goto L32;
        int r140 = 256;
    L33:
        r2 = r2 | r140;
        goto L34
    L32:
        r140 = 128;
        goto L33
    L17:
        if ((r91 & 48) != 0) goto L24;
        if (r0.changed(r69) == false) goto L21;
        int r49 = 32;
    L22:
        r2 = r2 | r49;
        goto L24
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r91 & 6) == 0) goto L8;
        r2 = r91;
        goto L13
    L8:
        if (r0.changed(r68) == false) goto L10;
        int r50 = 4;
    L11:
        r2 = r50 | r91;
        goto L13
    L10:
        r50 = 2;
        goto L11
    }
}
