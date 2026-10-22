package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B»\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015\u0012\u001e\b\u0002\u0010\u0018\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\b\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0002H\u0016J\u0013\u0010&\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020\u0012H\u0016J\f\u0010*\u001a\u00020\f*\u00020+H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", "update", "node", "equals", "other", "", "hashCode", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectableTextAnnotatedStringElement extends ModifierNodeElement<SelectableTextAnnotatedStringNode> {
    public static final int $stable = 0;
    private final TextAutoSize autoSize;
    private final ColorProducer color;
    private final FontFamily.Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;
    private final Function1<List<Rect>, Unit> onPlaceholderLayout;
    private final Function1<TextLayoutResult, Unit> onTextLayout;
    private final int overflow;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final SelectionController selectionController;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    public /* synthetic */ SelectableTextAnnotatedStringElement(AnnotatedString r1, TextStyle r2, FontFamily.Resolver r3, Function1 r4, int r5, boolean r6, int r7, int r8, List r9, Function1 r10, SelectionController r11, ColorProducer r12, TextAutoSize r13, DefaultConstructorMarker r14) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public void inspectableProperties(InspectorInfo r1) {
    }

    public SelectableTextAnnotatedStringNode create() {
        return new SelectableTextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, this.autoSize, null, 8192, null);
    }

    public int hashCode() {
        int r0 = ((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31;
        Function1<TextLayoutResult, Unit> r1 = this.onTextLayout;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((r0 + r3) * 31) + TextOverflow.hashCode-impl(this.overflow)) * 31;
        if (this.softWrap == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((((r4 + r5) * 31) + this.maxLines) * 31) + this.minLines) * 31;
        List<AnnotatedString.Range<Placeholder>> r7 = this.placeholders;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Function1<List<Rect>, Unit> r10 = this.onPlaceholderLayout;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        SelectionController r13 = this.selectionController;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        TextAutoSize r16 = this.autoSize;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        ColorProducer r19 = this.color;
        if (r19 == null) goto L30;
        r2 = r19.hashCode();
    L30:
        return r18 + r2;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m1802create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SelectableTextAnnotatedStringElement) == true) goto L8;
        return false;
    L8:
        SelectableTextAnnotatedStringElement r6 = (SelectableTextAnnotatedStringElement) r5;
        if (Intrinsics.areEqual(this.color, r6.color) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.style, r6.style) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.placeholders, r6.placeholders) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fontFamilyResolver, r6.fontFamilyResolver) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.autoSize, r6.autoSize) == true) goto L27;
        return false;
    L27:
        if (this.onTextLayout == r6.onTextLayout) goto L30;
        return false;
    L30:
        if (TextOverflow.equals-impl0(this.overflow, r6.overflow) == true) goto L33;
        return false;
    L33:
        if (this.softWrap == r6.softWrap) goto L36;
        return false;
    L36:
        if (this.maxLines == r6.maxLines) goto L39;
        return false;
    L39:
        if (this.minLines == r6.minLines) goto L42;
        return false;
    L42:
        if (this.onPlaceholderLayout == r6.onPlaceholderLayout) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.selectionController, r6.selectionController) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public void update(SelectableTextAnnotatedStringNode r15) {
        r15.m1804update7NebLg4(this.text, this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow, this.onTextLayout, this.onPlaceholderLayout, this.selectionController, this.color, this.autoSize);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((SelectableTextAnnotatedStringNode) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SelectableTextAnnotatedStringElement(AnnotatedString r1, TextStyle r2, FontFamily.Resolver r3, Function1<? super TextLayoutResult, Unit> r4, int r5, boolean r6, int r7, int r8, List<AnnotatedString.Range<Placeholder>> r9, Function1<? super List<Rect>, Unit> r10, SelectionController r11, ColorProducer r12, TextAutoSize r13) {
        this.text = r1;
        this.style = r2;
        this.fontFamilyResolver = r3;
        this.onTextLayout = r4;
        this.overflow = r5;
        this.softWrap = r6;
        this.maxLines = r7;
        this.minLines = r8;
        this.placeholders = r9;
        this.onPlaceholderLayout = r10;
        this.selectionController = r11;
        this.color = r12;
        this.autoSize = r13;
    }

    public /* synthetic */ SelectableTextAnnotatedStringElement(AnnotatedString r19, TextStyle r20, FontFamily.Resolver r21, Function1 r22, int r23, boolean r24, int r25, int r26, List r27, Function1 r28, SelectionController r29, ColorProducer r30, TextAutoSize r31, int r32, DefaultConstructorMarker r33) {
        if ((r32 & 8) == 0) goto L5;
        Function1 r7 = null;
    L7:
        if ((r32 & 16) == 0) goto L9;
        int r8 = TextOverflow.Companion.getClip-gIe3tQ8();
    L11:
        if ((r32 & 32) == 0) goto L13;
        boolean r9 = true;
    L15:
        if ((r32 & 64) == 0) goto L17;
        int r10 = Integer.MAX_VALUE;
    L19:
        if ((r32 & 128) == 0) goto L21;
        int r11 = 1;
    L23:
        if ((r32 & 256) == 0) goto L25;
        List r12 = null;
    L27:
        if ((r32 & 512) == 0) goto L29;
        Function1 r13 = null;
    L31:
        if ((r32 & 1024) == 0) goto L33;
        SelectionController r14 = null;
    L35:
        if ((r32 & 2048) == 0) goto L37;
        ColorProducer r15 = null;
    L39:
        if ((r32 & 4096) == 0) goto L41;
        TextAutoSize r16 = null;
    L42:
        this(r19, r20, r21, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, null);
        return;
    L41:
        r16 = r31;
        goto L42
    L37:
        r15 = r30;
        goto L39
    L33:
        r14 = r29;
        goto L35
    L29:
        r13 = r28;
        goto L31
    L25:
        r12 = r27;
        goto L27
    L21:
        r11 = r26;
        goto L23
    L17:
        r10 = r25;
        goto L19
    L13:
        r9 = r24;
        goto L15
    L9:
        r8 = r23;
        goto L11
    L5:
        r7 = r22;
        goto L7
    }
}
