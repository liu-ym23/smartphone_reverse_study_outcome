package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u00128\b\u0002\u0010\n\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010&\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016RA\u0010\n\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "density", "Landroidx/compose/ui/unit/Density;", "topWindowInsets", "", "keyboardSignalState", "Landroidx/compose/runtime/State;", "", "verticalMargin", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "anchorBounds", "menuBounds", "<init>", "(Landroidx/compose/ui/unit/Density;ILandroidx/compose/runtime/State;ILkotlin/jvm/functions/Function2;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getTopWindowInsets", "()I", "getKeyboardSignalState", "()Landroidx/compose/runtime/State;", "getVerticalMargin", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "endToAnchorEnd", "leftToWindowLeft", "rightToWindowRight", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuPositionProvider implements PopupPositionProvider {
    public static final int $stable = 0;
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final State<Unit> keyboardSignalState;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int topWindowInsets;
    private final int verticalMargin;

    public static /* synthetic */ Unit a(IntRect r0, IntRect r1) {
        return _init_$lambda$1(r0, r1);
    }

    public final Density getDensity() {
        return this.density;
    }

    public final State<Unit> getKeyboardSignalState() {
        return this.keyboardSignalState;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    public final int getTopWindowInsets() {
        return this.topWindowInsets;
    }

    public final int getVerticalMargin() {
        return this.verticalMargin;
    }

    private static final Unit _init_$lambda$1(IntRect r0, IntRect r1) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long m2698calculatePositionllwVHH4(IntRect r21, long r22, LayoutDirection r24, long r25) {
        State<Unit> r1 = this.keyboardSignalState;
        if (r1 == null) goto L5;
        r1.getValue();
    L5:
        char r10 = ' ';
        int r2 = (int) (r22 >> 32);
        long r13 = IntSize.constructor-impl((((long) r2) << 32) | (((long) (((int) (r22 & 4294967295L)) + this.topWindowInsets)) & 4294967295L));
        MenuPosition.Horizontal[] r3 = new MenuPosition.Horizontal[3];
        r3[0] = this.startToAnchorStart;
        r3[1] = this.endToAnchorEnd;
        int r6 = (int) (r13 >> 32);
        if (IntOffset.getX-impl(r21.getCenter-nOcc-ac()) >= (r6 / 2)) goto L8;
        MenuPosition.Horizontal r4 = this.leftToWindowLeft;
    L9:
        r3[2] = r4;
        List r5 = CollectionsKt.listOf(r3);
        int r7 = r5.size();
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L18;
        int r12 = (int) (r25 >> r10);
        int r11 = r7;
        int r14 = r8;
        List r19 = r5;
        int r15 = r6;
        int r9 = ((MenuPosition.Horizontal) ListProtector.get(r5, r8)).position-95KtPRI(r21, r13, r12, r24);
        if (r14 == CollectionsKt.getLastIndex(r19)) goto L19;
        if (r9 < 0) goto L17;
        if ((r12 + r9) <= r15) goto L19;
    L17:
        r8 = r14 + 1;
        r7 = r11;
        r6 = r15;
        r5 = r19;
        r10 = ' ';
    L19:
        MenuPosition.Vertical[] r16 = new MenuPosition.Vertical[3];
        r16[0] = this.topToAnchorBottom;
        r16[1] = this.bottomToAnchorTop;
        int r17 = (int) (r13 & 4294967295L);
        if (IntOffset.getY-impl(r21.getCenter-nOcc-ac()) >= (r17 / 2)) goto L22;
        MenuPosition.Vertical r18 = this.topToWindowTop;
    L23:
        r16[2] = r18;
        List r20 = CollectionsKt.listOf(r16);
        int r23 = r20.size();
        int r26 = 0;
    L24:
        if (r26 >= r23) goto L33;
        int r110 = r9;
        int r27 = (int) (r25 & 4294967295L);
        int r0 = ((MenuPosition.Vertical) ListProtector.get(r20, r26)).position-JVtK1S4(r21, r13, r27);
        if (r26 == CollectionsKt.getLastIndex(r20)) goto L32;
        if (r0 < 0) goto L31;
        if ((r27 + r0) <= r17) goto L32;
    L31:
        r26 = r26 + 1;
        r9 = r110;
    L32:
        r9 = r110;
    L34:
        long r28 = IntOffset.constructor-impl((((long) r9) << 32) | (((long) r0) & 4294967295L));
        this.onPositionCalculated.invoke(r21, IntRectKt.IntRect-VbeCjmY(r28, r25));
        return r28;
    L33:
        r0 = 0;
        goto L34
    L22:
        r18 = this.bottomToWindowBottom;
        goto L23
    L18:
        r9 = 0;
        goto L19
    L8:
        r4 = this.rightToWindowRight;
        goto L9
    }

    public ExposedDropdownMenuPositionProvider(Density r2, int r3, State<Unit> r4, int r5, Function2<? super IntRect, ? super IntRect, Unit> r6) {
        this.density = r2;
        this.topWindowInsets = r3;
        this.keyboardSignalState = r4;
        this.verticalMargin = r5;
        this.onPositionCalculated = r6;
        MenuPosition r7 = MenuPosition.INSTANCE;
        this.startToAnchorStart = MenuPosition.startToAnchorStart$default(r7, 0, 1, null);
        this.endToAnchorEnd = MenuPosition.endToAnchorEnd$default(r7, 0, 1, null);
        this.leftToWindowLeft = MenuPosition.leftToWindowLeft$default(r7, 0, 1, null);
        this.rightToWindowRight = MenuPosition.rightToWindowRight$default(r7, 0, 1, null);
        this.topToAnchorBottom = MenuPosition.topToAnchorBottom$default(r7, 0, 1, null);
        this.bottomToAnchorTop = MenuPosition.bottomToAnchorTop$default(r7, 0, 1, null);
        this.topToWindowTop = r7.topToWindowTop(r5);
        this.bottomToWindowBottom = r7.bottomToWindowBottom(r5);
    }

    public /* synthetic */ ExposedDropdownMenuPositionProvider(Density r7, int r8, State r9, int r10, Function2 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = null;
    L5:
        State r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = r7.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
    L8:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r11 = new eb();
    L11:
        this(r7, r8, r3, r4, r11);
    }
}
