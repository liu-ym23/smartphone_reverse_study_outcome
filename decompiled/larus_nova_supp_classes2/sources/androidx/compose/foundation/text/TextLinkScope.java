package androidx.compose.foundation.text;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u001f\u001a\u00020 *\u00020 2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001e\u0010%\u001a\u00020 *\u00020 2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001c\u0010&\u001a\u0004\u0018\u00010'2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J\u001c\u0010(\u001a\u0004\u0018\u00010)2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0002J0\u0010*\u001a\u0010\u0012\u0004\u0012\u00020#\u0018\u00010\"j\u0004\u0018\u0001`$2\u0010\u0010!\u001a\f\u0012\u0004\u0012\u00020#0\"j\u0002`$2\u0006\u0010\n\u001a\u00020\tH\u0002J\r\u0010+\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010,J\u001a\u0010-\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002J\u0018\u00100\u001a\u00020\u00182\u0006\u0010!\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0002J\r\u00103\u001a\u00020\u0003H\u0000¢\u0006\u0002\b4J>\u00105\u001a\u00020\u00182\u0016\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000107\"\u0004\u0018\u00010\u00012\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u00109R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R/\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\u0005R%\u0010\u0014\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0002\b\u00190\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006:"}, d2 = {"Landroidx/compose/foundation/text/TextLinkScope;", "", "initialText", "Landroidx/compose/ui/text/AnnotatedString;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;)V", "getInitialText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "<set-?>", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "text", "getText$foundation_release", "setText$foundation_release", "annotators", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "Lkotlin/ExtensionFunctionType;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "getShouldMeasureLinks", "()Lkotlin/jvm/functions/Function0;", "textRange", "Landroidx/compose/ui/Modifier;", "link", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/foundation/text/LinkRange;", "clipLink", "shapeForRange", "Landroidx/compose/ui/graphics/Shape;", "pathForRangeInRangeCoordinates", "Landroidx/compose/ui/graphics/Path;", "calculateVisibleLinkRange", "LinksComposables", "(Landroidx/compose/runtime/Composer;I)V", "mergeOrUse", "Landroidx/compose/ui/text/SpanStyle;", "other", "handleLink", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "applyAnnotators", "applyAnnotators$foundation_release", "StyleAnnotation", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextLinkScope {
    public static final int $stable = 8;
    private final SnapshotStateList<Function1<TextAnnotatorScope, Unit>> annotators;
    private final AnnotatedString initialText;
    private AnnotatedString text;
    private final MutableState textLayoutResult$delegate;

    private static final Unit LinksComposables$lambda$20(TextLinkScope r0, int r1, Composer r2, int r3) {
        r0.LinksComposables(r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit StyleAnnotation$lambda$25(TextLinkScope r0, Object[] r1, Function1 r2, int r3, Composer r4, int r5) {
        r0.StyleAnnotation(r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ List a(AnnotatedString.Range r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ IntOffset b(IntRect r0) {
        return textRange$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ Unit c(TextLinkScope r0, AnnotatedString.Range r1, GraphicsLayerScope r2) {
        return clipLink$lambda$7(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(TextLinkScope r0, AnnotatedString.Range r1, UriHandler r2) {
        return LinksComposables$lambda$19$lambda$14$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ Unit e(SemanticsPropertyReceiver r0) {
        return LinksComposables$lambda$19$lambda$12$lambda$11(r0);
    }

    public static /* synthetic */ IntOffset f() {
        return textRange$lambda$5$lambda$2();
    }

    public static /* synthetic */ Unit g(TextLinkScope r0, AnnotatedString.Range r1, LinkStateInteractionSourceObserver r2, TextAnnotatorScope r3) {
        return LinksComposables$lambda$19$lambda$18$lambda$17(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean h(TextLinkScope r0) {
        return _get_shouldMeasureLinks_$lambda$1(r0);
    }

    public static /* synthetic */ DisposableEffectResult i(TextLinkScope r0, Function1 r1, DisposableEffectScope r2) {
        return StyleAnnotation$lambda$24$lambda$23(r0, r1, r2);
    }

    public static /* synthetic */ Unit j(TextLinkScope r0, Object[] r1, Function1 r2, int r3, Composer r4, int r5) {
        return StyleAnnotation$lambda$25(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ IntOffset k() {
        return textRange$lambda$5$lambda$3();
    }

    public static /* synthetic */ Unit l(TextLinkScope r0, int r1, Composer r2, int r3) {
        return LinksComposables$lambda$20(r0, r1, r2, r3);
    }

    public static /* synthetic */ TextRangeLayoutMeasureResult m(TextLinkScope r0, AnnotatedString.Range r1, TextRangeLayoutMeasureScope r2) {
        return textRange$lambda$5(r0, r1, r2);
    }

    private static final IntOffset textRange$lambda$5$lambda$2() {
        return IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac());
    }

    private static final IntOffset textRange$lambda$5$lambda$3() {
        return IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac());
    }

    public final AnnotatedString applyAnnotators$foundation_release() {
        if (this.annotators.isEmpty() == false) goto L5;
        AnnotatedString r0 = this.text;
    L9:
        this.text = r0;
        return r0;
    L5:
        TextAnnotatorScope r1 = new TextAnnotatorScope(this.text);
        SnapshotStateList<Function1<TextAnnotatorScope, Unit>> r2 = this.annotators;
        int r3 = r2.size();
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L8;
        ((Function1) ListProtector.get(r2, r4)).invoke(r1);
        r4 = r4 + 1;
        goto L6
    L8:
        r0 = r1.getStyledText();
        goto L9
    }

    public final Function0<Boolean> getShouldMeasureLinks() {
        return new r4(this);
    }

    public final TextLayoutResult getTextLayoutResult() {
        return (TextLayoutResult) this.textLayoutResult$delegate.getValue();
    }

    public final AnnotatedString getInitialText$foundation_release() {
        return this.initialText;
    }

    public final AnnotatedString getText$foundation_release() {
        return this.text;
    }

    public TextLinkScope(AnnotatedString r3) {
        this.initialText = r3;
        this.textLayoutResult$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.text = r3.flatMapAnnotations(new q4());
        this.annotators = SnapshotStateKt.mutableStateListOf();
    }

    private static final Unit LinksComposables$lambda$19$lambda$12$lambda$11(SemanticsPropertyReceiver r2) {
        SemanticsPropertyKey r0 = SemanticsProperties.INSTANCE.getLinkTestMarker();
        Unit r1 = Unit.INSTANCE;
        r2.set(r0, r1);
        return r1;
    }

    private static final boolean _get_shouldMeasureLinks_$lambda$1(TextLinkScope r1) {
        AnnotatedString r0 = r1.text;
        TextLayoutResult r2 = r1.getTextLayoutResult();
        if (r2 == null) goto L7;
        TextLayoutInput r3 = r2.getLayoutInput();
        if (r3 == null) goto L7;
        AnnotatedString r4 = r3.getText();
    L9:
        return Intrinsics.areEqual(r0, r4);
    L7:
        r4 = null;
        goto L9
    }

    private static final List _init_$lambda$0(AnnotatedString.Range r27) {
        if ((r27.getItem() instanceof LinkAnnotation) == false) goto L13;
        Object r0 = r27.getItem();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation");
        if (TextLinkScopeKt.access$isNullOrEmpty(((LinkAnnotation) r0).getStyles()) == true) goto L13;
        AnnotatedString.Range[] r1 = new AnnotatedString.Range[2];
        r1[0] = r27;
        Object r4 = r27.getItem();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation");
        TextLinkStyles r3 = ((LinkAnnotation) r4).getStyles();
        if (r3 == null) goto L10;
        SpanStyle r5 = r3.getStyle();
        if (r5 == null) goto L10;
    L11:
        r1[1] = new AnnotatedString.Range(r5, r27.getStart(), r27.getEnd());
        return CollectionsKt.arrayListOf(r1);
    L10:
        r5 = new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, 65535, null);
    L13:
        return CollectionsKt.arrayListOf(new AnnotatedString.Range[]{r27});
    }

    public static final /* synthetic */ SnapshotStateList access$getAnnotators$p(TextLinkScope r0) {
        return r0.annotators;
    }

    private final Path pathForRangeInRangeCoordinates(AnnotatedString.Range<LinkAnnotation> r9) {
        Path r1 = null;
        if (((Boolean) getShouldMeasureLinks().invoke()).booleanValue() == false) goto L15;
        TextLayoutResult r0 = getTextLayoutResult();
        if (r0 == null) goto L15;
        AnnotatedString.Range<LinkAnnotation> r10 = calculateVisibleLinkRange(r9, r0);
        if (r10 != null) goto L10;
        return null;
    L10:
        r1 = r0.getPathForRange(r10.getStart(), r10.getEnd());
        Rect r2 = r0.getBoundingBox(r10.getStart());
        Rect r3 = r0.getBoundingBox(r10.getEnd() - 1);
        if (r0.getLineForOffset(r10.getStart()) != r0.getLineForOffset(r10.getEnd() - 1)) goto L13;
        float r11 = Math.min(r3.getLeft(), r2.getLeft());
    L14:
        float r4 = r2.getTop();
        r1.translate-k-4lQ0M(Offset.constructor-impl(Offset.constructor-impl((Float.floatToRawIntBits(r11) << 32) | (((long) Float.floatToRawIntBits(r4)) & 4294967295L)) ^ (-9223372034707292160L)));
        goto L15
    L13:
        r11 = MenuKt.ClosedAlphaTarget;
    L15:
        return r1;
    }

    private final Shape shapeForRange(AnnotatedString.Range<LinkAnnotation> r2) {
        final Path r3 = pathForRangeInRangeCoordinates(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new TextLinkScope$shapeForRange$1$1(r3);
    }

    private static final IntOffset textRange$lambda$5$lambda$4(IntRect r2) {
        return IntOffset.box-impl(r2.getTopLeft-nOcc-ac());
    }

    public final void setText$foundation_release(AnnotatedString r1) {
        this.text = r1;
    }

    public final void setTextLayoutResult(TextLayoutResult r2) {
        this.textLayoutResult$delegate.setValue(r2);
    }

    private final AnnotatedString.Range<LinkAnnotation> calculateVisibleLinkRange(AnnotatedString.Range<LinkAnnotation> r12, TextLayoutResult r13) {
        int r14 = TextLayoutResult.getLineEnd$default(r13, r13.getLineCount() - 1, false, 2, null);
        if (r12.getStart() < r14) goto L5;
        return null;
    L5:
        return AnnotatedString.Range.copy$default(r12, null, 0, Math.min(r12.getEnd(), r14), null, 11, null);
    }

    private final Modifier clipLink(Modifier r2, final AnnotatedString.Range<LinkAnnotation> r3) {
        return GraphicsLayerModifierKt.graphicsLayer(r2, new l4(this, r3));
    }

    private final void handleLink(LinkAnnotation r2, UriHandler r3) {
        if ((r2 instanceof LinkAnnotation.Url) == false) goto L10;
        LinkInteractionListener r0 = ((LinkAnnotation.Url) r2).getLinkInteractionListener();
        if (r0 == null) goto L16;
        r0.onClick(r2);
        return;
    L16:
        r3.openUri(((LinkAnnotation.Url) r2).getUrl());     // Catch: IllegalArgumentException -> L15
        return;
    L22:
        return;
    L10:
        if ((r2 instanceof LinkAnnotation.Clickable) == false) goto L19;
        LinkInteractionListener r4 = ((LinkAnnotation.Clickable) r2).getLinkInteractionListener();
        if (r4 == null) goto L20;
        r4.onClick(r2);
        return;
    L20:
        return;
    }

    private final SpanStyle mergeOrUse(SpanStyle r1, SpanStyle r2) {
        if (r1 == null) goto L8;
        SpanStyle r3 = r1.merge(r2);
        if (r3 != null) goto L7;
        return r2;
    L7:
        return r3;
    L8:
        return r2;
    }

    private final Modifier textRange(Modifier r3, final AnnotatedString.Range<LinkAnnotation> r4) {
        return r3.then(new TextRangeLayoutModifier(new f4(this, r4)));
    }

    public final void LinksComposables(Composer r29, final int r30) {
        Composer r3 = r29.startRestartGroup(1154651354);
        if ((r30 & 6) == 0) goto L5;
        int r4 = r30;
    L10:
        int r8 = 1;
        if ((r4 & 3) == 2) goto L13;
        boolean r7 = true;
    L15:
        if (r3.shouldExecute(r7, r4 & 1) == true) goto L17;
        r3.skipToGroupEnd();
    L71:
        ScopeUpdateScope r2 = r3.endRestartGroup();
        if (r2 == null) goto L78;
        r2.updateScope(new p4(this, r30));
        return;
    L78:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1154651354, r4, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:214)");
    L19:
        final UriHandler r5 = (UriHandler) r3.consume(CompositionLocalsKt.getLocalUriHandler());
        AnnotatedString r9 = this.text;
        List r10 = r9.getLinkAnnotations(0, r9.length());
        int r11 = r10.size();
        int r12 = 0;
    L20:
        if (r12 >= r11) goto L68;
        final AnnotatedString.Range<LinkAnnotation> r13 = (AnnotatedString.Range) ListProtector.get(r10, r12);
        if (r13.getStart() == r13.getEnd()) goto L65;
        r3.startReplaceGroup(725478935);
        Object r14 = r3.rememberedValue();
        Composer.Companion r15 = Composer.Companion;
        if (r14 != r15.getEmpty()) goto L26;
        r14 = InteractionSourceKt.MutableInteractionSource();
        r3.updateRememberedValue(r14);
    L26:
        MutableInteractionSource r16 = (MutableInteractionSource) r14;
        Modifier r17 = clipLink(Modifier.Companion, r13);
        Object r6 = r3.rememberedValue();
        if (r6 != r15.getEmpty()) goto L29;
        r6 = new m4();
        r3.updateRememberedValue(r6);
    L29:
        SpanStyle r18 = null;
        Modifier r19 = PointerIconKt.pointerHoverIcon$default(HoverableKt.hoverable$default(textRange(SemanticsModifierKt.semantics$default(r17, false, (Function1) r6, r8, null), r13), r16, false, 2, null), PointerIcon.Companion.getHand(), false, 2, null);
        boolean r20 = (r3.changedInstance(this) | r3.changed(r13)) | r3.changedInstance(r5);
        Object r110 = r3.rememberedValue();
        if (r20 == false) goto L32;
    L33:
        r110 = new n4(this, r13, r5);
        r3.updateRememberedValue(r110);
    L34:
        BoxKt.Box(ClickableKt.m383combinedClickableauXiCPI$default(r19, r16, null, false, null, null, null, null, null, false, (Function0) r110, 508, null), r3, 0);
        if (TextLinkScopeKt.access$isNullOrEmpty(((LinkAnnotation) r13.getItem()).getStyles()) == true) goto L63;
        r3.startReplaceGroup(726303039);
        Object r21 = r3.rememberedValue();
        if (r21 != r15.getEmpty()) goto L39;
        r21 = new LinkStateInteractionSourceObserver(r16);
        r3.updateRememberedValue(r21);
    L39:
        final LinkStateInteractionSourceObserver r22 = (LinkStateInteractionSourceObserver) r21;
        Unit r23 = Unit.INSTANCE;
        Object r111 = r3.rememberedValue();
        if (r111 != r15.getEmpty()) goto L42;
        r111 = new TextLinkScope$LinksComposables$1$3$1(r22, null);
        r3.updateRememberedValue(r111);
    L42:
        EffectsKt.LaunchedEffect(r23, (Function2) r111, r3, 6);
        Object[] r24 = new Object[7];
        r24[0] = Boolean.valueOf(r22.isHovered());
        r24[1] = Boolean.valueOf(r22.isFocused());
        r24[2] = Boolean.valueOf(r22.isPressed());
        TextLinkStyles r112 = ((LinkAnnotation) r13.getItem()).getStyles();
        if (r112 == null) goto L45;
        SpanStyle r113 = r112.getStyle();
    L46:
        r24[3] = r113;
        TextLinkStyles r114 = ((LinkAnnotation) r13.getItem()).getStyles();
        if (r114 == null) goto L49;
        SpanStyle r115 = r114.getFocusedStyle();
    L50:
        r24[4] = r115;
        TextLinkStyles r116 = ((LinkAnnotation) r13.getItem()).getStyles();
        if (r116 == null) goto L53;
        SpanStyle r117 = r116.getHoveredStyle();
    L54:
        r24[5] = r117;
        TextLinkStyles r118 = ((LinkAnnotation) r13.getItem()).getStyles();
        if (r118 == null) goto L57;
        r18 = r118.getPressedStyle();
    L57:
        r24[6] = r18;
        boolean r25 = r3.changedInstance(this) | r3.changed(r13);
        Object r119 = r3.rememberedValue();
        if (r25 == false) goto L60;
    L61:
        r119 = new o4(this, r13, r22);
        r3.updateRememberedValue(r119);
    L62:
        StyleAnnotation(r24, (Function1) r119, r3, (r4 << 6) & 896);
        r3.endReplaceGroup();
    L64:
        r3.endReplaceGroup();
    L66:
        r12 = r12 + 1;
        r8 = 1;
        goto L20
    L60:
        if (r119 != r15.getEmpty()) goto L62;
    L53:
        r117 = null;
        goto L54
    L49:
        r115 = null;
        goto L50
    L45:
        r113 = null;
        goto L46
    L63:
        r3.startReplaceGroup(728331710);
        r3.endReplaceGroup();
        goto L64
    L32:
        if (r110 != r15.getEmpty()) goto L34;
    L65:
        r3.startReplaceGroup(728345598);
        r3.endReplaceGroup();
        goto L66
    L68:
        if (ComposerKt.isTraceInProgress() == false) goto L71;
        ComposerKt.traceEventEnd();
        goto L71
    L13:
        r7 = false;
        goto L15
    L5:
        if (r3.changedInstance(this) == false) goto L7;
        int r26 = 4;
    L8:
        r4 = r26 | r30;
        goto L10
    L7:
        r26 = 2;
        goto L8
    }

    private static final Unit LinksComposables$lambda$19$lambda$14$lambda$13(TextLinkScope r0, AnnotatedString.Range r1, UriHandler r2) {
        r0.handleLink((LinkAnnotation) r1.getItem(), r2);
        return Unit.INSTANCE;
    }

    private static final DisposableEffectResult StyleAnnotation$lambda$24$lambda$23(final TextLinkScope r0, final Function1 r1, DisposableEffectScope r2) {
        r0.annotators.add(r1);
        return new TextLinkScope$StyleAnnotation$lambda$24$lambda$23$$inlined$onDispose$1(r0, r1);
    }

    private static final Unit clipLink$lambda$7(TextLinkScope r0, AnnotatedString.Range r1, GraphicsLayerScope r2) {
        Shape r3 = r0.shapeForRange(r1);
        if (r3 == null) goto L6;
        r2.setShape(r3);
        r2.setClip(true);
    L6:
        return Unit.INSTANCE;
    }

    private static final TextRangeLayoutMeasureResult textRange$lambda$5(TextLinkScope r2, AnnotatedString.Range r3, TextRangeLayoutMeasureScope r4) {
        TextLayoutResult r0 = r2.getTextLayoutResult();
        if (r0 == null) goto L5;
        AnnotatedString.Range<LinkAnnotation> r5 = r2.calculateVisibleLinkRange(r3, r0);
        if (r5 == null) goto L9;
        final IntRect r6 = IntRectKt.roundToIntRect(r0.getPathForRange(r5.getStart(), r5.getEnd()).getBounds());
        return r4.layout(r6.getWidth(), r6.getHeight(), new i4(r6));
    L9:
        return r4.layout(0, 0, new h4());
    L5:
        return r4.layout(0, 0, new g4());
    }

    private static final Unit LinksComposables$lambda$19$lambda$18$lambda$17(TextLinkScope r3, AnnotatedString.Range r4, LinkStateInteractionSourceObserver r5, TextAnnotatorScope r6) {
        TextLinkStyles r0 = ((LinkAnnotation) r4.getItem()).getStyles();
        SpanStyle r1 = null;
        if (r0 == null) goto L5;
        SpanStyle r2 = r0.getStyle();
    L7:
        if (r5.isFocused() == false) goto L11;
        TextLinkStyles r7 = ((LinkAnnotation) r4.getItem()).getStyles();
        if (r7 == null) goto L11;
        SpanStyle r8 = r7.getFocusedStyle();
    L12:
        SpanStyle r9 = r3.mergeOrUse(r2, r8);
        if (r5.isHovered() == false) goto L17;
        TextLinkStyles r10 = ((LinkAnnotation) r4.getItem()).getStyles();
        if (r10 == null) goto L17;
        SpanStyle r11 = r10.getHoveredStyle();
    L18:
        SpanStyle r12 = r3.mergeOrUse(r9, r11);
        if (r5.isPressed() == false) goto L23;
        TextLinkStyles r13 = ((LinkAnnotation) r4.getItem()).getStyles();
        if (r13 == null) goto L23;
        r1 = r13.getPressedStyle();
    L23:
        r6.replaceStyle(r4, r3.mergeOrUse(r12, r1));
        return Unit.INSTANCE;
    L17:
        r11 = null;
    L11:
        r8 = null;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    private final void StyleAnnotation(final Object[] r9, final Function1<? super TextAnnotatorScope, Unit> r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(-2083052099);
        if ((r12 & 48) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 384) == 0) goto L13;
    L17:
        r13.startMovableGroup(-358305778, Integer.valueOf(r9.length));
        if (r13.changed(r9.length) == false) goto L20;
        int r3 = 4;
    L21:
        int r2 = r1 | r3;
        int r4 = r9.length;
        int r6 = 0;
    L22:
        if (r6 >= r4) goto L28;
        if (r13.changedInstance(r9[r6]) == false) goto L26;
        int r7 = 4;
    L27:
        r2 = r2 | r7;
        r6 = r6 + 1;
        goto L22
    L26:
        r7 = 0;
        goto L27
    L28:
        r13.endMovableGroup();
        if ((r2 & 14) != 0) goto L31;
        r2 = r2 | 2;
    L31:
        boolean r8 = true;
        if ((r2 & 147) == 146) goto L34;
        boolean r5 = true;
    L36:
        if (r13.shouldExecute(r5, r2 & 1) == true) goto L38;
        r13.skipToGroupEnd();
    L53:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L60;
        r14.updateScope(new k4(this, r9, r10, r12));
        return;
    L60:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-2083052099, r2, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:315)");
    L40:
        SpreadBuilder r0 = new SpreadBuilder(2);
        r0.add(r10);
        r0.addSpread(r9);
        Object[] r15 = r0.toArray(new Object[r0.size()]);
        boolean r16 = r13.changedInstance(this);
        if ((r2 & 112) == 32) goto L44;
        r8 = false;
    L44:
        boolean r17 = r16 | r8;
        Object r18 = r13.rememberedValue();
        if (r17 == false) goto L47;
    L48:
        r18 = new j4(this, r10);
        r13.updateRememberedValue(r18);
    L49:
        EffectsKt.DisposableEffect(r15, (Function1) r18, r13, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L53;
        ComposerKt.traceEventEnd();
        goto L53
    L47:
        if (r18 != Composer.Companion.getEmpty()) goto L49;
    L34:
        r5 = false;
        goto L36
    L20:
        r3 = 0;
        goto L21
    L13:
        if (r13.changedInstance(this) == false) goto L15;
        int r19 = 256;
    L16:
        r1 = r1 | r19;
        goto L17
    L15:
        r19 = 128;
        goto L16
    L5:
        if (r13.changedInstance(r10) == false) goto L7;
        int r20 = 32;
    L8:
        r1 = r20 | r12;
        goto L11
    L7:
        r20 = 16;
        goto L8
    }
}
