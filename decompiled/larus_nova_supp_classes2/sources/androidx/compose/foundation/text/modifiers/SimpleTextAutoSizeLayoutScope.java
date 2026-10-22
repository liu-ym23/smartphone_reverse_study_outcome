package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/text/modifiers/SimpleTextAutoSizeLayoutScope;", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "<init>", "()V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class SimpleTextAutoSizeLayoutScope implements TextAutoSizeLayoutScope {
    public static final int $stable = 0;

    public SimpleTextAutoSizeLayoutScope() {
    }

    /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public final /* synthetic */ int m1805roundToPxR2X_6o(long r1) {
        return Density.-CC.$default$roundToPx--R2X_6o(this, r1);
    }

    /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
    public final /* synthetic */ int m1806roundToPx0680j_4(float r1) {
        return Density.-CC.$default$roundToPx-0680j_4(this, r1);
    }

    /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
    public final /* synthetic */ float m1807toDpGaN1DYA(long r1) {
        return FontScaling.-CC.$default$toDp-GaN1DYA(this, r1);
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public final /* synthetic */ float m1808toDpu2uoSUM(float r1) {
        return Density.-CC.$default$toDp-u2uoSUM(this, r1);
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
    public final /* synthetic */ float m1809toDpu2uoSUM(int r1) {
        return Density.-CC.$default$toDp-u2uoSUM(this, r1);
    }

    /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public final /* synthetic */ long m1810toDpSizekrfVVM(long r1) {
        return Density.-CC.$default$toDpSize-k-rfVVM(this, r1);
    }

    /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
    public final /* synthetic */ float m1811toPxR2X_6o(long r1) {
        return Density.-CC.$default$toPx--R2X_6o(this, r1);
    }

    /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
    public final /* synthetic */ float m1812toPx0680j_4(float r1) {
        return Density.-CC.$default$toPx-0680j_4(this, r1);
    }

    public final /* synthetic */ Rect toRect(DpRect r1) {
        return Density.-CC.$default$toRect(this, r1);
    }

    /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public final /* synthetic */ long m1813toSizeXkaWNTQ(long r1) {
        return Density.-CC.$default$toSize-XkaWNTQ(this, r1);
    }

    /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
    public final /* synthetic */ long m1814toSp0xMU5do(float r3) {
        return FontScaling.-CC.$default$toSp-0xMU5do(this, r3);
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public final /* synthetic */ long m1815toSpkPz2Gy4(float r3) {
        return Density.-CC.$default$toSp-kPz2Gy4(this, r3);
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public final /* synthetic */ long m1816toSpkPz2Gy4(int r3) {
        return Density.-CC.$default$toSp-kPz2Gy4(this, r3);
    }
}
