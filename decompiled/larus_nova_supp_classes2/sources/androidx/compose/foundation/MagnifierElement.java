package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0099\u0001\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\u001b\b\u0002\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0013\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016J\f\u0010#\u001a\u00020\u000b*\u00020$H\u0016R\u001f\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/foundation/MagnifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MagnifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", "zoom", "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "F", "create", "update", "node", "equals", "other", "", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MagnifierElement extends ModifierNodeElement<MagnifierNode> {
    public static final int $stable = 0;
    private final boolean clippingEnabled;
    private final float cornerRadius;
    private final float elevation;
    private final Function1<Density, Offset> magnifierCenter;
    private final Function1<DpSize, Unit> onSizeChanged;
    private final PlatformMagnifierFactory platformMagnifierFactory;
    private final long size;
    private final Function1<Density, Offset> sourceCenter;
    private final boolean useTextDefault;
    private final float zoom;

    public /* synthetic */ MagnifierElement(Function1 r1, Function1 r2, Function1 r3, float r4, boolean r5, long r6, float r8, float r9, boolean r10, PlatformMagnifierFactory r11, DefaultConstructorMarker r12) {
        this(r1, r2, r3, r4, r5, r6, r8, r9, r10, r11);
    }

    public MagnifierNode create() {
        Function1<Density, Offset> r1 = this.sourceCenter;
        Function1<Density, Offset> r2 = this.magnifierCenter;
        float r4 = this.zoom;
        boolean r5 = this.useTextDefault;
        long r6 = this.size;
        float r8 = this.cornerRadius;
        float r9 = this.elevation;
        boolean r10 = this.clippingEnabled;
        return new MagnifierNode(r1, r2, this.onSizeChanged, r4, r5, r6, r8, r9, r10, this.platformMagnifierFactory, null);
    }

    public int hashCode() {
        int r0 = this.sourceCenter.hashCode() * 31;
        Function1<Density, Offset> r1 = this.magnifierCenter;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((r0 + r3) * 31) + Float.floatToIntBits(this.zoom)) * 31;
        int r5 = 1231;
        if (this.useTextDefault == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (((((((r4 + r6) * 31) + DpSize.hashCode-impl(this.size)) * 31) + Dp.hashCode-impl(this.cornerRadius)) * 31) + Dp.hashCode-impl(this.elevation)) * 31;
        if (this.clippingEnabled == true) goto L14;
        r5 = 1237;
    L14:
        int r8 = (r7 + r5) * 31;
        Function1<DpSize, Unit> r9 = this.onSizeChanged;
        if (r9 == null) goto L18;
        r2 = r9.hashCode();
    L18:
        return ((r8 + r2) * 31) + this.platformMagnifierFactory.hashCode();
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m413create() {
        return create();
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MagnifierElement) == true) goto L8;
        return false;
    L8:
        MagnifierElement r9 = (MagnifierElement) r8;
        if (this.sourceCenter == r9.sourceCenter) goto L12;
        return false;
    L12:
        if (this.magnifierCenter == r9.magnifierCenter) goto L15;
        return false;
    L15:
        if (this.zoom != r9.zoom) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == true) goto L21;
        return false;
    L21:
        if (this.useTextDefault == r9.useTextDefault) goto L24;
        return false;
    L24:
        if (DpSize.equals-impl0(this.size, r9.size) == true) goto L27;
        return false;
    L27:
        if (Dp.equals-impl0(this.cornerRadius, r9.cornerRadius) == true) goto L30;
        return false;
    L30:
        if (Dp.equals-impl0(this.elevation, r9.elevation) == true) goto L33;
        return false;
    L33:
        if (this.clippingEnabled == r9.clippingEnabled) goto L36;
        return false;
    L36:
        if (this.onSizeChanged == r9.onSizeChanged) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.platformMagnifierFactory, r9.platformMagnifierFactory) == true) goto L41;
        return false;
    L41:
        return true;
    L17:
        r1 = false;
        goto L18
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("magnifier");
        r4.getProperties().set("sourceCenter", this.sourceCenter);
        r4.getProperties().set("magnifierCenter", this.magnifierCenter);
        r4.getProperties().set("zoom", Float.valueOf(this.zoom));
        r4.getProperties().set("size", DpSize.box-impl(this.size));
        r4.getProperties().set("cornerRadius", Dp.box-impl(this.cornerRadius));
        r4.getProperties().set("elevation", Dp.box-impl(this.elevation));
        r4.getProperties().set("clippingEnabled", Boolean.valueOf(this.clippingEnabled));
    }

    public void update(MagnifierNode r13) {
        r13.m421update5F03MCQ(this.sourceCenter, this.magnifierCenter, this.zoom, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, this.onSizeChanged, this.platformMagnifierFactory);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((MagnifierNode) r1);
    }

    private MagnifierElement(Function1<? super Density, Offset> r1, Function1<? super Density, Offset> r2, Function1<? super DpSize, Unit> r3, float r4, boolean r5, long r6, float r8, float r9, boolean r10, PlatformMagnifierFactory r11) {
        this.sourceCenter = r1;
        this.magnifierCenter = r2;
        this.onSizeChanged = r3;
        this.zoom = r4;
        this.useTextDefault = r5;
        this.size = r6;
        this.cornerRadius = r8;
        this.elevation = r9;
        this.clippingEnabled = r10;
        this.platformMagnifierFactory = r11;
    }

    public /* synthetic */ MagnifierElement(Function1 r17, Function1 r18, Function1 r19, float r20, boolean r21, long r22, float r24, float r25, boolean r26, PlatformMagnifierFactory r27, int r28, DefaultConstructorMarker r29) {
        if ((r28 & 2) == 0) goto L5;
        Function1 r5 = null;
    L7:
        if ((r28 & 4) == 0) goto L9;
        Function1 r6 = null;
    L11:
        if ((r28 & 8) == 0) goto L13;
        float r7 = Float.NaN;
    L15:
        if ((r28 & 16) == 0) goto L17;
        boolean r8 = false;
    L19:
        if ((r28 & 32) == 0) goto L21;
        long r9 = DpSize.Companion.getUnspecified-MYxV2XQ();
    L23:
        if ((r28 & 64) == 0) goto L25;
        float r11 = Dp.Companion.getUnspecified-D9Ej5fM();
    L27:
        if ((r28 & 128) == 0) goto L29;
        float r12 = Dp.Companion.getUnspecified-D9Ej5fM();
    L31:
        if ((r28 & 256) == 0) goto L33;
        boolean r13 = true;
    L34:
        this(r17, r5, r6, r7, r8, r9, r11, r12, r13, r27, null);
        return;
    L33:
        r13 = r26;
        goto L34
    L29:
        r12 = r25;
        goto L31
    L25:
        r11 = r24;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r8 = r21;
        goto L19
    L13:
        r7 = r20;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r5 = r18;
        goto L7
    }
}
