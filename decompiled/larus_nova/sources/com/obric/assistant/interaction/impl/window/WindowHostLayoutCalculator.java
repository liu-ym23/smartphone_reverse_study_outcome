package com.obric.assistant.interaction.impl.window;

import android.graphics.Rect;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJE\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007¢\u0006\u0002\u0010\u0018J'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bJ3\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010#J.\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*JH\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\b\b\u0002\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\u0007J\f\u00104\u001a\u000205*\u00020\u001aH\u0002J\f\u00106\u001a\u00020\u001a*\u000205H\u0002¨\u00067"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowHostLayoutCalculator;", "", "<init>", "()V", "resolveLayoutSpec", "Lcom/obric/assistant/interaction/impl/window/WindowHostLayoutSpec;", "orientation", "", "displayWidth", "displayHeight", "cutoutInsets", "Lcom/obric/assistant/interaction/impl/window/HorizontalCutoutInsets;", "landscapeRightMarginPx", "landscapeVerticalMarginPx", "consumedNavigationBarInsets", "Lcom/obric/assistant/interaction/impl/window/ConsumedNavigationBarInsets;", "resolveConsumedNavigationBarInsets", "navigationMode", "navigationBarsVisible", "", "navigationBarLeft", "navigationBarTop", "navigationBarRight", "navigationBarBottom", "(ILjava/lang/Integer;ZIIII)Lcom/obric/assistant/interaction/impl/window/ConsumedNavigationBarInsets;", "snapshot", "Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;", "(ILjava/lang/Integer;Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;)Lcom/obric/assistant/interaction/impl/window/ConsumedNavigationBarInsets;", "resolveStableNavigationBarInsetsSnapshot", "currentSnapshot", "previousSnapshot", "(ILjava/lang/Integer;Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;)Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;", "resolveNavigationMode", "secureNavigationMode", "resourceNavigationMode", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;", "resolveLegacyNavigationBarInsetsSnapshot", "systemWindowInsetLeft", "systemWindowInsetTop", "systemWindowInsetRight", "systemWindowInsetBottom", "source", "", "resolveHorizontalCutoutInsets", "sdkInt", "safeInsetLeft", "safeInsetRight", "boundingRects", "", "Landroid/graphics/Rect;", "boundsLeftInset", "boundsRightInset", "toSharedSnapshot", "Lcom/obric/assistant/activation/presentation/runtime/window/ObricNavigationBarInsetsSnapshot;", "toWindowHostSnapshot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHostLayoutCalculator {
    public static final WindowHostLayoutCalculator INSTANCE = null;

    static {
        INSTANCE = new WindowHostLayoutCalculator();
    }

    private WindowHostLayoutCalculator() {
    }

    public final Integer resolveNavigationMode(Integer r100, Integer r101) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        return r101;
    }

    private final jba.f toSharedSnapshot(NavigationBarInsetsSnapshot r100) {
        return new jba.f(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom(), r100.getVisible(), r100.getSource());
    }

    private final NavigationBarInsetsSnapshot toWindowHostSnapshot(jba.f r100) {
        return new NavigationBarInsetsSnapshot(r100.f498057a, r100.f498058b, r100.f498059c, r100.f498060d, r100.f498061e, r100.f498062f);
    }

    public final ConsumedNavigationBarInsets resolveConsumedNavigationBarInsets(int r100, Integer r101, NavigationBarInsetsSnapshot r102) {
        int r103 = jba.d.f498050a;
        if (r102 == null) goto L5;
        jba.f r104 = toSharedSnapshot(r102);
    L6:
        jba.a r105 = jba.d.a(r100, r101, r104);
        return new ConsumedNavigationBarInsets(r105.f498042a, r105.f498043b);
    L5:
        r104 = null;
        goto L6
    }

    public final NavigationBarInsetsSnapshot resolveStableNavigationBarInsetsSnapshot(int r100, Integer r101, NavigationBarInsetsSnapshot r102, NavigationBarInsetsSnapshot r103) {
        int r104 = jba.d.f498050a;
        if (r102 == null) goto L5;
        jba.f r105 = toSharedSnapshot(r102);
    L6:
        if (r103 == null) goto L8;
        jba.f r106 = toSharedSnapshot(r103);
    L9:
        jba.f r107 = jba.d.e(r100, r101, r105, r106);
        if (r107 != null) goto L12;
        return null;
    L12:
        return toWindowHostSnapshot(r107);
    L8:
        r106 = null;
        goto L9
    L5:
        r105 = null;
        goto L6
    }

    public final NavigationBarInsetsSnapshot resolveLegacyNavigationBarInsetsSnapshot(int r100, int r101, int r110, int r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "source");
        int r102 = RangesKt.coerceAtLeast(r110, 0);
        int r103 = RangesKt.coerceAtLeast(r100, 0);
        int r104 = RangesKt.coerceAtLeast(r101, 0);
        if (r102 <= 0) goto L5;
        boolean r105 = true;
    L7:
        return new NavigationBarInsetsSnapshot(r103, r104, r102, 0, r105, r112);
    L5:
        r105 = false;
        goto L7
    }

    public final ConsumedNavigationBarInsets resolveConsumedNavigationBarInsets(int r100, Integer r110, boolean r111, int r112, int r113, int r114, int r115) {
        return resolveConsumedNavigationBarInsets(r100, r110, new NavigationBarInsetsSnapshot(RangesKt.coerceAtLeast(r112, 0), RangesKt.coerceAtLeast(r113, 0), RangesKt.coerceAtLeast(r114, 0), RangesKt.coerceAtLeast(r115, 0), r111, TemplateNodeType.RAW));
    }

    public final HorizontalCutoutInsets resolveHorizontalCutoutInsets(int r100, int r101, int r102, int r103, List<Rect> r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r104, "boundingRects");
        jba.b r107 = jba.d.c(r100, r101, r102, r103, r104, r105, r106);
        return new HorizontalCutoutInsets(r107.f498044a, r107.f498045b);
    }

    public final WindowHostLayoutSpec resolveLayoutSpec(int r100, int r110, int r111, HorizontalCutoutInsets r112, int r113, int r114, ConsumedNavigationBarInsets r115) {
        Intrinsics.checkNotNullParameter(r112, "cutoutInsets");
        Intrinsics.checkNotNullParameter(r115, "consumedNavigationBarInsets");
        int r101 = jba.d.f498050a;
        jba.e r102 = jba.d.d(r100, r110, r111, new jba.b(r112.getLeft(), r112.getRight()), r113, r114, new jba.a(r115.getRight(), r115.getBottom()));
        return new WindowHostLayoutSpec(r102.f498051a, r102.f498052b, r102.f498053c, r102.f498054d, r102.f498055e, r102.f498056f);
    }

    public static /* synthetic */ HorizontalCutoutInsets resolveHorizontalCutoutInsets$default(WindowHostLayoutCalculator r110, int r111, int r112, int r113, int r114, List r115, int r116, int r117, int r118, Object r119) {
        if ((r118 & 32) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r118 & 64) == 0) goto L9;
        int r101 = 0;
    L11:
        return r110.resolveHorizontalCutoutInsets(r111, r112, r113, r114, r115, r100, r101);
    L9:
        r101 = r117;
        goto L11
    L5:
        r100 = r116;
        goto L7
    }

    public static /* synthetic */ WindowHostLayoutSpec resolveLayoutSpec$default(WindowHostLayoutCalculator r110, int r111, int r112, int r113, HorizontalCutoutInsets r114, int r115, int r116, ConsumedNavigationBarInsets r117, int r118, Object r119) {
        if ((r118 & 16) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r118 & 32) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r118 & 64) == 0) goto L13;
        ConsumedNavigationBarInsets r102 = new ConsumedNavigationBarInsets(0, 0, 3, null);
    L15:
        return r110.resolveLayoutSpec(r111, r112, r113, r114, r100, r101, r102);
    L13:
        r102 = r117;
        goto L15
    L9:
        r101 = r116;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }
}
