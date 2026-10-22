package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PressGestureScope extends Density {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: access$roundToPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ int m617access$roundToPxR2X_6o$jd(PressGestureScope r0, long r1) {
            return Density.-CC.$default$roundToPx--R2X_6o(r0, r1);
        }

        /* JADX INFO: renamed from: access$roundToPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ int m618access$roundToPx0680j_4$jd(PressGestureScope r0, float r1) {
            return Density.-CC.$default$roundToPx-0680j_4(r0, r1);
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m619access$toDpGaN1DYA$jd(PressGestureScope r0, long r1) {
            return FontScaling.-CC.$default$toDp-GaN1DYA(r0, r1);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m620access$toDpu2uoSUM$jd(PressGestureScope r0, float r1) {
            return Density.-CC.$default$toDp-u2uoSUM(r0, r1);
        }

        /* JADX INFO: renamed from: access$toDpSize-k-rfVVM$jd, reason: not valid java name */
        public static /* synthetic */ long m622access$toDpSizekrfVVM$jd(PressGestureScope r0, long r1) {
            return Density.-CC.$default$toDpSize-k-rfVVM(r0, r1);
        }

        /* JADX INFO: renamed from: access$toPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ float m623access$toPxR2X_6o$jd(PressGestureScope r0, long r1) {
            return Density.-CC.$default$toPx--R2X_6o(r0, r1);
        }

        /* JADX INFO: renamed from: access$toPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ float m624access$toPx0680j_4$jd(PressGestureScope r0, float r1) {
            return Density.-CC.$default$toPx-0680j_4(r0, r1);
        }

        public static /* synthetic */ Rect access$toRect$jd(PressGestureScope r0, DpRect r1) {
            return Density.-CC.$default$toRect(r0, r1);
        }

        /* JADX INFO: renamed from: access$toSize-XkaWNTQ$jd, reason: not valid java name */
        public static /* synthetic */ long m625access$toSizeXkaWNTQ$jd(PressGestureScope r0, long r1) {
            return Density.-CC.$default$toSize-XkaWNTQ(r0, r1);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m626access$toSp0xMU5do$jd(PressGestureScope r0, float r1) {
            return FontScaling.-CC.$default$toSp-0xMU5do(r0, r1);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m627access$toSpkPz2Gy4$jd(PressGestureScope r0, float r1) {
            return Density.-CC.$default$toSp-kPz2Gy4(r0, r1);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m621access$toDpu2uoSUM$jd(PressGestureScope r0, int r1) {
            return Density.-CC.$default$toDp-u2uoSUM(r0, r1);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m628access$toSpkPz2Gy4$jd(PressGestureScope r0, int r1) {
            return Density.-CC.$default$toSp-kPz2Gy4(r0, r1);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m629roundToPxR2X_6o(PressGestureScope r0, long r1) {
            return CC.m617access$roundToPxR2X_6o$jd(r0, r1);
        }

        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m630roundToPx0680j_4(PressGestureScope r0, float r1) {
            return CC.m618access$roundToPx0680j_4$jd(r0, r1);
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m631toDpGaN1DYA(PressGestureScope r0, long r1) {
            return CC.m619access$toDpGaN1DYA$jd(r0, r1);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m632toDpu2uoSUM(PressGestureScope r0, float r1) {
            return CC.m620access$toDpu2uoSUM$jd(r0, r1);
        }

        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m634toDpSizekrfVVM(PressGestureScope r0, long r1) {
            return CC.m622access$toDpSizekrfVVM$jd(r0, r1);
        }

        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m635toPxR2X_6o(PressGestureScope r0, long r1) {
            return CC.m623access$toPxR2X_6o$jd(r0, r1);
        }

        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m636toPx0680j_4(PressGestureScope r0, float r1) {
            return CC.m624access$toPx0680j_4$jd(r0, r1);
        }

        public static Rect toRect(PressGestureScope r0, DpRect r1) {
            return CC.access$toRect$jd(r0, r1);
        }

        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m637toSizeXkaWNTQ(PressGestureScope r0, long r1) {
            return CC.m625access$toSizeXkaWNTQ$jd(r0, r1);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m638toSp0xMU5do(PressGestureScope r0, float r1) {
            return CC.m626access$toSp0xMU5do$jd(r0, r1);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m639toSpkPz2Gy4(PressGestureScope r0, float r1) {
            return CC.m627access$toSpkPz2Gy4$jd(r0, r1);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m633toDpu2uoSUM(PressGestureScope r0, int r1) {
            return CC.m621access$toDpu2uoSUM$jd(r0, r1);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m640toSpkPz2Gy4(PressGestureScope r0, int r1) {
            return CC.m628access$toSpkPz2Gy4$jd(r0, r1);
        }
    }

    Object awaitRelease(Continuation<? super Unit> r1);

    Object tryAwaitRelease(Continuation<? super Boolean> r1);
}
