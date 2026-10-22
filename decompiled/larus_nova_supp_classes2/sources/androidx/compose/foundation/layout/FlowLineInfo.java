package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\u0006X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/FlowLineInfo;", "", "lineIndex", "", "positionInLine", "maxMainAxisSize", "Landroidx/compose/ui/unit/Dp;", "maxCrossAxisSize", "<init>", "(IIFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineIndex$foundation_layout", "()I", "setLineIndex$foundation_layout", "(I)V", "getPositionInLine$foundation_layout", "setPositionInLine$foundation_layout", "getMaxMainAxisSize-D9Ej5fM$foundation_layout", "()F", "setMaxMainAxisSize-0680j_4$foundation_layout", "(F)V", "F", "getMaxCrossAxisSize-D9Ej5fM$foundation_layout", "setMaxCrossAxisSize-0680j_4$foundation_layout", "update", "", "update-4j6BHR0$foundation_layout", "(IIFF)V", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlowLineInfo {
    public static final int $stable = 8;
    private int lineIndex;
    private float maxCrossAxisSize;
    private float maxMainAxisSize;
    private int positionInLine;

    public /* synthetic */ FlowLineInfo(int r1, int r2, float r3, float r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public final int getLineIndex$foundation_layout() {
        return this.lineIndex;
    }

    /* JADX INFO: renamed from: getMaxCrossAxisSize-D9Ej5fM$foundation_layout, reason: not valid java name */
    public final float m876getMaxCrossAxisSizeD9Ej5fM$foundation_layout() {
        return this.maxCrossAxisSize;
    }

    /* JADX INFO: renamed from: getMaxMainAxisSize-D9Ej5fM$foundation_layout, reason: not valid java name */
    public final float m877getMaxMainAxisSizeD9Ej5fM$foundation_layout() {
        return this.maxMainAxisSize;
    }

    public final int getPositionInLine$foundation_layout() {
        return this.positionInLine;
    }

    public final void setLineIndex$foundation_layout(int r1) {
        this.lineIndex = r1;
    }

    /* JADX INFO: renamed from: setMaxCrossAxisSize-0680j_4$foundation_layout, reason: not valid java name */
    public final void m878setMaxCrossAxisSize0680j_4$foundation_layout(float r1) {
        this.maxCrossAxisSize = r1;
    }

    /* JADX INFO: renamed from: setMaxMainAxisSize-0680j_4$foundation_layout, reason: not valid java name */
    public final void m879setMaxMainAxisSize0680j_4$foundation_layout(float r1) {
        this.maxMainAxisSize = r1;
    }

    public final void setPositionInLine$foundation_layout(int r1) {
        this.positionInLine = r1;
    }

    private FlowLineInfo(int r1, int r2, float r3, float r4) {
        this.lineIndex = r1;
        this.positionInLine = r2;
        this.maxMainAxisSize = r3;
        this.maxCrossAxisSize = r4;
    }

    /* JADX INFO: renamed from: update-4j6BHR0$foundation_layout, reason: not valid java name */
    public final void m880update4j6BHR0$foundation_layout(int r1, int r2, float r3, float r4) {
        this.lineIndex = r1;
        this.positionInLine = r2;
        this.maxMainAxisSize = r3;
        this.maxCrossAxisSize = r4;
    }

    public /* synthetic */ FlowLineInfo(int r8, int r9, float r10, float r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        int r2 = 0;
    L7:
        if ((r12 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r12 & 4) == 0) goto L13;
        r10 = Dp.constructor-impl(0);
    L13:
        float r4 = r10;
        if ((r12 & 8) == 0) goto L16;
        r11 = Dp.constructor-impl(0);
    L16:
        this(r2, r3, r4, r11, null);
        return;
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }
}
