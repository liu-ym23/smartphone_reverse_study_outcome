package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0004\u001a#\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a'\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\n\u001a'\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\n\u001a;\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001b\u0010\u001b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001c\u0010\u0004\u001a\u001b\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u0004\u001a\u001b\u0010\u001f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b \u0010\u0004\u001a#\u0010\u001f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b!\u0010\n\u001a\u001b\u0010\u001f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\"\u0010\r\u001a'\u0010#\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b$\u0010\n\u001a'\u0010%\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b&\u0010\n\u001a;\u0010'\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0002H\u0007¢\u0006\u0004\b(\u0010\u001a\u001a\u0016\u0010)\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010*\u001a\u00020+H\u0007\u001a\u0016\u0010.\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010*\u001a\u00020+H\u0007\u001a\u0016\u00100\u001a\u00020\u0001*\u00020\u00012\b\b\u0003\u0010*\u001a\u00020+H\u0007\u001a \u00102\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000206H\u0007\u001a \u0010:\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u00103\u001a\u00020;2\b\b\u0002\u00105\u001a\u000206H\u0007\u001a \u0010>\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u00103\u001a\u00020?2\b\b\u0002\u00105\u001a\u000206H\u0007\u001a'\u0010B\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0002H\u0007¢\u0006\u0004\bC\u0010\n\"\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010@\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010A\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"width", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "width-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "height", "height-3ABfNKs", "size", "size-3ABfNKs", "size-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/DpSize;", "size-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "widthIn", "min", "max", "widthIn-VpY3zN4", "heightIn", "heightIn-VpY3zN4", "sizeIn", "minWidth", "minHeight", "maxWidth", "maxHeight", "sizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredHeight", "requiredHeight-3ABfNKs", "requiredSize", "requiredSize-3ABfNKs", "requiredSize-VpY3zN4", "requiredSize-6HolHcs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSizeIn", "requiredSizeIn-qDBjuR0", "fillMaxWidth", "fraction", "", "FillWholeMaxWidth", "Landroidx/compose/foundation/layout/FillElement;", "fillMaxHeight", "FillWholeMaxHeight", "fillMaxSize", "FillWholeMaxSize", "wrapContentWidth", "align", "Landroidx/compose/ui/Alignment$Horizontal;", "unbounded", "", "WrapContentWidthCenter", "Landroidx/compose/foundation/layout/WrapContentElement;", "WrapContentWidthStart", "wrapContentHeight", "Landroidx/compose/ui/Alignment$Vertical;", "WrapContentHeightCenter", "WrapContentHeightTop", "wrapContentSize", "Landroidx/compose/ui/Alignment;", "WrapContentSizeCenter", "WrapContentSizeTopStart", "defaultMinSize", "defaultMinSize-VpY3zN4", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SizeKt {
    private static final FillElement FillWholeMaxHeight = null;
    private static final FillElement FillWholeMaxSize = null;
    private static final FillElement FillWholeMaxWidth = null;
    private static final WrapContentElement WrapContentHeightCenter = null;
    private static final WrapContentElement WrapContentHeightTop = null;
    private static final WrapContentElement WrapContentSizeCenter = null;
    private static final WrapContentElement WrapContentSizeTopStart = null;
    private static final WrapContentElement WrapContentWidthCenter = null;
    private static final WrapContentElement WrapContentWidthStart = null;

    static {
        FillElement.Companion r0 = FillElement.Companion;
        FillWholeMaxWidth = r0.width(1.0f);
        FillWholeMaxHeight = r0.height(1.0f);
        FillWholeMaxSize = r0.size(1.0f);
        WrapContentElement.Companion r1 = WrapContentElement.Companion;
        Alignment.Companion r2 = Alignment.Companion;
        WrapContentWidthCenter = r1.width(r2.getCenterHorizontally(), false);
        WrapContentWidthStart = r1.width(r2.getStart(), false);
        WrapContentHeightCenter = r1.height(r2.getCenterVertically(), false);
        WrapContentHeightTop = r1.height(r2.getTop(), false);
        WrapContentSizeCenter = r1.size(r2.getCenter(), false);
        WrapContentSizeTopStart = r1.size(r2.getTopStart(), false);
    }

    public static final Modifier fillMaxHeight(Modifier r1, float r2) {
        if (r2 != 1.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        FillElement r3 = FillWholeMaxHeight;
    L10:
        return r1.then(r3);
    L8:
        r3 = FillElement.Companion.height(r2);
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static final Modifier fillMaxSize(Modifier r1, float r2) {
        if (r2 != 1.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        FillElement r3 = FillWholeMaxSize;
    L10:
        return r1.then(r3);
    L8:
        r3 = FillElement.Companion.size(r2);
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static final Modifier fillMaxWidth(Modifier r1, float r2) {
        if (r2 != 1.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        FillElement r3 = FillWholeMaxWidth;
    L10:
        return r1.then(r3);
    L8:
        r3 = FillElement.Companion.width(r2);
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: height-3ABfNKs, reason: not valid java name */
    public static final Modifier m1000height3ABfNKs(Modifier r10, final float r11) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$height3ABfNKs$$inlined$debugInspectorInfo$1(r11);
    L7:
        return r10.then(new SizeElement(MenuKt.ClosedAlphaTarget, r11, MenuKt.ClosedAlphaTarget, r11, true, r0, 5, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: requiredHeight-3ABfNKs, reason: not valid java name */
    public static final Modifier m1003requiredHeight3ABfNKs(Modifier r10, final float r11) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$requiredHeight3ABfNKs$$inlined$debugInspectorInfo$1(r11);
    L7:
        return r10.then(new SizeElement(MenuKt.ClosedAlphaTarget, r11, MenuKt.ClosedAlphaTarget, r11, false, r0, 5, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: requiredSize-3ABfNKs, reason: not valid java name */
    public static final Modifier m1006requiredSize3ABfNKs(Modifier r9, final float r10) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$requiredSize3ABfNKs$$inlined$debugInspectorInfo$1(r10);
    L7:
        return r9.then(new SizeElement(r10, r10, r10, r10, false, r0, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: requiredSize-6HolHcs, reason: not valid java name */
    public static final Modifier m1007requiredSize6HolHcs(Modifier r1, long r2) {
        return m1008requiredSizeVpY3zN4(r1, DpSize.getWidth-D9Ej5fM(r2), DpSize.getHeight-D9Ej5fM(r2));
    }

    /* JADX INFO: renamed from: requiredWidth-3ABfNKs, reason: not valid java name */
    public static final Modifier m1011requiredWidth3ABfNKs(Modifier r10, final float r11) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$requiredWidth3ABfNKs$$inlined$debugInspectorInfo$1(r11);
    L7:
        return r10.then(new SizeElement(r11, MenuKt.ClosedAlphaTarget, r11, MenuKt.ClosedAlphaTarget, false, r0, 10, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: size-3ABfNKs, reason: not valid java name */
    public static final Modifier m1014size3ABfNKs(Modifier r9, final float r10) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$size3ABfNKs$$inlined$debugInspectorInfo$1(r10);
    L7:
        return r9.then(new SizeElement(r10, r10, r10, r10, true, r0, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: size-6HolHcs, reason: not valid java name */
    public static final Modifier m1015size6HolHcs(Modifier r1, long r2) {
        return m1016sizeVpY3zN4(r1, DpSize.getWidth-D9Ej5fM(r2), DpSize.getHeight-D9Ej5fM(r2));
    }

    /* JADX INFO: renamed from: width-3ABfNKs, reason: not valid java name */
    public static final Modifier m1019width3ABfNKs(Modifier r10, final float r11) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$width3ABfNKs$$inlined$debugInspectorInfo$1(r11);
    L7:
        return r10.then(new SizeElement(r11, MenuKt.ClosedAlphaTarget, r11, MenuKt.ClosedAlphaTarget, true, r0, 10, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m998defaultMinSizeVpY3zN4(Modifier r2, float r3, float r4) {
        return r2.then(new UnspecifiedConstraintsElement(r3, r4, null));
    }

    /* JADX INFO: renamed from: heightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m1001heightInVpY3zN4(Modifier r10, final float r11, final float r12) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$heightInVpY3zN4$$inlined$debugInspectorInfo$1(r11, r12);
    L7:
        return r10.then(new SizeElement(MenuKt.ClosedAlphaTarget, r11, MenuKt.ClosedAlphaTarget, r12, true, r0, 5, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: requiredHeightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m1004requiredHeightInVpY3zN4(Modifier r10, final float r11, final float r12) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$requiredHeightInVpY3zN4$$inlined$debugInspectorInfo$1(r11, r12);
    L7:
        return r10.then(new SizeElement(MenuKt.ClosedAlphaTarget, r11, MenuKt.ClosedAlphaTarget, r12, false, r0, 5, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: requiredSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m1008requiredSizeVpY3zN4(Modifier r9, final float r10, final float r11) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$requiredSizeVpY3zN4$$inlined$debugInspectorInfo$1(r10, r11);
    L7:
        return r9.then(new SizeElement(r10, r11, r10, r11, false, r0, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: requiredWidthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m1012requiredWidthInVpY3zN4(Modifier r10, final float r11, final float r12) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$requiredWidthInVpY3zN4$$inlined$debugInspectorInfo$1(r11, r12);
    L7:
        return r10.then(new SizeElement(r11, MenuKt.ClosedAlphaTarget, r12, MenuKt.ClosedAlphaTarget, false, r0, 10, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: size-VpY3zN4, reason: not valid java name */
    public static final Modifier m1016sizeVpY3zN4(Modifier r9, final float r10, final float r11) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$sizeVpY3zN4$$inlined$debugInspectorInfo$1(r10, r11);
    L7:
        return r9.then(new SizeElement(r10, r11, r10, r11, true, r0, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: widthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m1020widthInVpY3zN4(Modifier r10, final float r11, final float r12) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$widthInVpY3zN4$$inlined$debugInspectorInfo$1(r11, r12);
    L7:
        return r10.then(new SizeElement(r11, MenuKt.ClosedAlphaTarget, r12, MenuKt.ClosedAlphaTarget, true, r0, 10, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier wrapContentHeight(Modifier r2, Alignment.Vertical r3, boolean r4) {
        Alignment.Companion r0 = Alignment.Companion;
        if (Intrinsics.areEqual(r3, r0.getCenterVertically()) == false) goto L7;
        if (r4 == true) goto L7;
        WrapContentElement r5 = WrapContentHeightCenter;
    L12:
        return r2.then(r5);
    L7:
        if (Intrinsics.areEqual(r3, r0.getTop()) == false) goto L10;
        if (r4 == true) goto L10;
        r5 = WrapContentHeightTop;
    L10:
        r5 = WrapContentElement.Companion.height(r3, r4);
        goto L12
    }

    public static final Modifier wrapContentSize(Modifier r2, Alignment r3, boolean r4) {
        Alignment.Companion r0 = Alignment.Companion;
        if (Intrinsics.areEqual(r3, r0.getCenter()) == false) goto L7;
        if (r4 == true) goto L7;
        WrapContentElement r5 = WrapContentSizeCenter;
    L12:
        return r2.then(r5);
    L7:
        if (Intrinsics.areEqual(r3, r0.getTopStart()) == false) goto L10;
        if (r4 == true) goto L10;
        r5 = WrapContentSizeTopStart;
    L10:
        r5 = WrapContentElement.Companion.size(r3, r4);
        goto L12
    }

    public static final Modifier wrapContentWidth(Modifier r2, Alignment.Horizontal r3, boolean r4) {
        Alignment.Companion r0 = Alignment.Companion;
        if (Intrinsics.areEqual(r3, r0.getCenterHorizontally()) == false) goto L7;
        if (r4 == true) goto L7;
        WrapContentElement r5 = WrapContentWidthCenter;
    L12:
        return r2.then(r5);
    L7:
        if (Intrinsics.areEqual(r3, r0.getStart()) == false) goto L10;
        if (r4 == true) goto L10;
        r5 = WrapContentWidthStart;
    L10:
        r5 = WrapContentElement.Companion.width(r3, r4);
        goto L12
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier r0, float r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 1.0f;
    L6:
        return fillMaxHeight(r0, r1);
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier r0, float r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 1.0f;
    L6:
        return fillMaxSize(r0, r1);
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier r0, float r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 1.0f;
    L6:
        return fillMaxWidth(r0, r1);
    }

    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m999defaultMinSizeVpY3zN4$default(Modifier r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        return m998defaultMinSizeVpY3zN4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: heightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1002heightInVpY3zN4$default(Modifier r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        return m1001heightInVpY3zN4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: requiredHeightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1005requiredHeightInVpY3zN4$default(Modifier r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        return m1004requiredHeightInVpY3zN4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: requiredSizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m1009requiredSizeInqDBjuR0(Modifier r9, final float r10, final float r11, final float r12, final float r13) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$requiredSizeInqDBjuR0$$inlined$debugInspectorInfo$1(r10, r11, r12, r13);
    L7:
        return r9.then(new SizeElement(r10, r11, r12, r13, false, r0, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: requiredWidthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1013requiredWidthInVpY3zN4$default(Modifier r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        return m1012requiredWidthInVpY3zN4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: sizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m1017sizeInqDBjuR0(Modifier r9, final float r10, final float r11, final float r12, final float r13) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SizeKt$sizeInqDBjuR0$$inlined$debugInspectorInfo$1(r10, r11, r12, r13);
    L7:
        return r9.then(new SizeElement(r10, r11, r12, r13, true, r0, null));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: widthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1021widthInVpY3zN4$default(Modifier r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        return m1020widthInVpY3zN4(r0, r1, r2);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier r0, Alignment.Vertical r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Alignment.Companion.getCenterVertically();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = false;
    L9:
        return wrapContentHeight(r0, r1, r2);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier r0, Alignment r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Alignment.Companion.getCenter();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = false;
    L9:
        return wrapContentSize(r0, r1, r2);
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier r0, Alignment.Horizontal r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Alignment.Companion.getCenterHorizontally();
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = false;
    L9:
        return wrapContentWidth(r0, r1, r2);
    }

    /* JADX INFO: renamed from: requiredSizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1010requiredSizeInqDBjuR0$default(Modifier r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = Dp.Companion.getUnspecified-D9Ej5fM();
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = Dp.Companion.getUnspecified-D9Ej5fM();
    L15:
        return m1009requiredSizeInqDBjuR0(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: sizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1018sizeInqDBjuR0$default(Modifier r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = Dp.Companion.getUnspecified-D9Ej5fM();
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = Dp.Companion.getUnspecified-D9Ej5fM();
    L15:
        return m1017sizeInqDBjuR0(r0, r1, r2, r3, r4);
    }
}
