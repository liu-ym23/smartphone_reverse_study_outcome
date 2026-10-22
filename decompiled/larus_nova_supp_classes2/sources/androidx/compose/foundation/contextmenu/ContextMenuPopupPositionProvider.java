package androidx.compose.foundation.contextmenu;

import androidx.autofill.HintConstants;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eBM\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u0010J/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuPopupPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "anchorPositionBlock", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "onPositionCalculated", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "position", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "anchorPosition", "(JLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "calculatePosition", "anchorBounds", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuPopupPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final Function0<IntOffset> anchorPositionBlock;
    private final Function2<IntOffset, IntRect, Unit> onPositionCalculated;

    public /* synthetic */ ContextMenuPopupPositionProvider(long r1, Function2 r3, DefaultConstructorMarker r4) {
        this(r1, r3);
    }

    public static /* synthetic */ IntOffset a(long r0) {
        return _init_$lambda$0(r0);
    }

    private static final IntOffset _init_$lambda$0(long r0) {
        return IntOffset.box-impl(r0);
    }

    private ContextMenuPopupPositionProvider(final long r2, Function2<? super IntOffset, ? super IntRect, Unit> r4) {
        this(new g(r2), r4);
    }

    public ContextMenuPopupPositionProvider(Function0<IntOffset> r1, Function2<? super IntOffset, ? super IntRect, Unit> r2) {
        this.anchorPositionBlock = r1;
        this.onPositionCalculated = r2;
    }

    public /* synthetic */ ContextMenuPopupPositionProvider(long r1, Function2 r3, int r4, DefaultConstructorMarker r5) {
        DefaultConstructorMarker r6 = null;
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r3, r6);
    }

    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long m473calculatePositionllwVHH4(IntRect r16, long r17, LayoutDirection r19, long r20) {
        long r3 = ((IntOffset) this.anchorPositionBlock.invoke()).unbox-impl();
        int r5 = r16.getLeft() + IntOffset.getX-impl(r3);
        int r8 = (int) (r20 >> 32);
        int r7 = (int) (r17 >> 32);
        if (r19 != LayoutDirection.Ltr) goto L5;
        boolean r9 = true;
    L6:
        int r6 = ContextMenuPopupPositionProviderKt.alignPopupAxis(r5, r8, r7, r9);
        int r10 = ContextMenuPopupPositionProviderKt.alignPopupAxis$default(r16.getTop() + IntOffset.getY-impl(r3), (int) (r20 & 4294967295L), (int) (r17 & 4294967295L), false, 8, null);
        long r11 = IntOffset.constructor-impl((((long) r6) << 32) | (4294967295L & ((long) r10)));
        Function2<IntOffset, IntRect, Unit> r12 = this.onPositionCalculated;
        if (r12 == null) goto L9;
        r12.invoke(IntOffset.box-impl(r3), IntRectKt.IntRect-VbeCjmY(r11, r20));
    L9:
        return r11;
    L5:
        r9 = false;
        goto L6
    }

    public /* synthetic */ ContextMenuPopupPositionProvider(Function0 r1, Function2 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
