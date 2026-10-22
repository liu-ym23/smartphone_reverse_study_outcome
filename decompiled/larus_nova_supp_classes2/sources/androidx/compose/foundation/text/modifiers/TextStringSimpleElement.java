package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0013\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\f\u0010\u001d\u001a\u00020\u0017*\u00020\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "create", "update", "", "node", "equals", "other", "", "hashCode", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextStringSimpleElement extends ModifierNodeElement<TextStringSimpleNode> {
    public static final int $stable = 0;
    private final ColorProducer color;
    private final FontFamily.Resolver fontFamilyResolver;
    private final int maxLines;
    private final int minLines;
    private final int overflow;
    private final boolean softWrap;
    private final TextStyle style;
    private final String text;

    public /* synthetic */ TextStringSimpleElement(String r1, TextStyle r2, FontFamily.Resolver r3, int r4, boolean r5, int r6, int r7, ColorProducer r8, DefaultConstructorMarker r9) {
        this(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public void inspectableProperties(InspectorInfo r1) {
    }

    public TextStringSimpleNode create() {
        return new TextStringSimpleNode(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.color, null);
    }

    public int hashCode() {
        int r0 = ((((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31) + TextOverflow.hashCode-impl(this.overflow)) * 31;
        if (this.softWrap == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((((r0 + r1) * 31) + this.maxLines) * 31) + this.minLines) * 31;
        ColorProducer r3 = this.color;
        if (r3 == null) goto L9;
        int r4 = r3.hashCode();
    L11:
        return r2 + r4;
    L9:
        r4 = 0;
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m1821create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextStringSimpleElement) == true) goto L8;
        return false;
    L8:
        TextStringSimpleElement r6 = (TextStringSimpleElement) r5;
        if (Intrinsics.areEqual(this.color, r6.color) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.style, r6.style) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fontFamilyResolver, r6.fontFamilyResolver) == true) goto L21;
        return false;
    L21:
        if (TextOverflow.equals-impl0(this.overflow, r6.overflow) == true) goto L24;
        return false;
    L24:
        if (this.softWrap == r6.softWrap) goto L27;
        return false;
    L27:
        if (this.maxLines == r6.maxLines) goto L30;
        return false;
    L30:
        if (this.minLines == r6.minLines) goto L32;
        return false;
    L32:
        return true;
    }

    public void update(TextStringSimpleNode r10) {
        r10.doInvalidations(r10.updateDraw(this.color, this.style), r10.updateText(this.text), r10.m1823updateLayoutRelatedArgsHuAbxIM(this.style, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow));
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((TextStringSimpleNode) r1);
    }

    private TextStringSimpleElement(String r1, TextStyle r2, FontFamily.Resolver r3, int r4, boolean r5, int r6, int r7, ColorProducer r8) {
        this.text = r1;
        this.style = r2;
        this.fontFamilyResolver = r3;
        this.overflow = r4;
        this.softWrap = r5;
        this.maxLines = r6;
        this.minLines = r7;
        this.color = r8;
    }

    public /* synthetic */ TextStringSimpleElement(String r13, TextStyle r14, FontFamily.Resolver r15, int r16, boolean r17, int r18, int r19, ColorProducer r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 8) == 0) goto L5;
        int r6 = TextOverflow.Companion.getClip-gIe3tQ8();
    L7:
        if ((r21 & 16) == 0) goto L9;
        boolean r7 = true;
    L11:
        if ((r21 & 32) == 0) goto L13;
        int r8 = Integer.MAX_VALUE;
    L15:
        if ((r21 & 64) == 0) goto L17;
        int r9 = 1;
    L19:
        if ((r21 & 128) == 0) goto L21;
        ColorProducer r10 = null;
    L22:
        this(r13, r14, r15, r6, r7, r8, r9, r10, null);
        return;
    L21:
        r10 = r20;
        goto L22
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }
}
