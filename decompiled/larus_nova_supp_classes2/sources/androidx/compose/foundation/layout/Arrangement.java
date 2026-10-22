package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005FGHIJB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&J\u001f\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0007¢\u0006\u0004\b)\u0010*J\u001f\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020+H\u0007¢\u0006\u0004\b)\u0010,J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010-\u001a\u00020\r2\u0006\u0010'\u001a\u00020+H\u0007J-\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7J%\u00108\u001a\u00020/2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b9J-\u0010:\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b;J-\u0010<\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b=J-\u0010>\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b?J-\u0010@\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\bAJ/\u0010B\u001a\u00020/*\u0002032\u0006\u0010C\u001a\u0002062\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020/0EH\u0082\bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\u0018¨\u0006K"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement;", "", "<init>", "()V", "Start", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getStart$annotations", "getStart", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "End", "getEnd$annotations", "getEnd", "Top", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTop$annotations", "getTop", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Bottom", "getBottom$annotations", "getBottom", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "spacedBy", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "aligned", "placeRightOrBottom", "", "totalSize", "", "size", "", "outPosition", "reverseInput", "", "placeRightOrBottom$foundation_layout", "placeLeftOrTop", "placeLeftOrTop$foundation_layout", "placeCenter", "placeCenter$foundation_layout", "placeSpaceEvenly", "placeSpaceEvenly$foundation_layout", "placeSpaceBetween", "placeSpaceBetween$foundation_layout", "placeSpaceAround", "placeSpaceAround$foundation_layout", "forEachIndexed", "reversed", "action", "Lkotlin/Function2;", "Horizontal", "Vertical", "HorizontalOrVertical", "Absolute", "SpacedAligned", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Arrangement {
    public static final int $stable = 0;
    private static final Vertical Bottom = null;
    private static final HorizontalOrVertical Center = null;
    private static final Horizontal End = null;
    public static final Arrangement INSTANCE = null;
    private static final HorizontalOrVertical SpaceAround = null;
    private static final HorizontalOrVertical SpaceBetween = null;
    private static final HorizontalOrVertical SpaceEvenly = null;
    private static final Horizontal Start = null;
    private static final Vertical Top = null;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0004\b \u0010!J\u001f\u0010\u0018\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020#H\u0007¢\u0006\u0004\b \u0010$J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0007R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\b¨\u0006&"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Absolute;", "", "<init>", "()V", "Left", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getLeft$annotations", "getLeft", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Center", "getCenter$annotations", "getCenter", "Right", "getRight$annotations", "getRight", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "spacedBy", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "aligned", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Absolute {
        public static final int $stable = 0;
        private static final Horizontal Center = null;
        public static final Absolute INSTANCE = null;
        private static final Horizontal Left = null;
        private static final Horizontal Right = null;
        private static final Horizontal SpaceAround = null;
        private static final Horizontal SpaceBetween = null;
        private static final Horizontal SpaceEvenly = null;

        private Absolute() {
        }

        public static /* synthetic */ int a(Alignment.Horizontal r0, int r1, LayoutDirection r2) {
            return aligned$lambda$2(r0, r1, r2);
        }

        public static /* synthetic */ int b(Alignment.Horizontal r0, int r1, LayoutDirection r2) {
            return spacedBy_D5KLDUw$lambda$0(r0, r1, r2);
        }

        public static /* synthetic */ int c(Alignment.Vertical r0, int r1, LayoutDirection r2) {
            return spacedBy_D5KLDUw$lambda$1(r0, r1, r2);
        }

        public static /* synthetic */ void getCenter$annotations() {
        }

        public static /* synthetic */ void getLeft$annotations() {
        }

        public static /* synthetic */ void getRight$annotations() {
        }

        public static /* synthetic */ void getSpaceAround$annotations() {
        }

        public static /* synthetic */ void getSpaceBetween$annotations() {
        }

        public static /* synthetic */ void getSpaceEvenly$annotations() {
        }

        static {
            INSTANCE = new Absolute();
            Left = new Arrangement$Absolute$Left$1();
            Center = new Arrangement$Absolute$Center$1();
            Right = new Arrangement$Absolute$Right$1();
            SpaceBetween = new Arrangement$Absolute$SpaceBetween$1();
            SpaceEvenly = new Arrangement$Absolute$SpaceEvenly$1();
            SpaceAround = new Arrangement$Absolute$SpaceAround$1();
        }

        public final Horizontal getCenter() {
            return Center;
        }

        public final Horizontal getLeft() {
            return Left;
        }

        public final Horizontal getRight() {
            return Right;
        }

        public final Horizontal getSpaceAround() {
            return SpaceAround;
        }

        public final Horizontal getSpaceBetween() {
            return SpaceBetween;
        }

        public final Horizontal getSpaceEvenly() {
            return SpaceEvenly;
        }

        public final Horizontal aligned(final Alignment.Horizontal r5) {
            return new SpacedAligned(Dp.constructor-impl(0), false, new g(r5), null);
        }

        /* JADX INFO: renamed from: spacedBy-0680j_4, reason: not valid java name */
        public final HorizontalOrVertical m809spacedBy0680j_4(float r4) {
            Function2 r2 = null;
            return new SpacedAligned(r4, false, r2, r2);
        }

        /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
        public final Horizontal m810spacedByD5KLDUw(float r4, final Alignment.Horizontal r5) {
            boolean r2 = false;
            return new SpacedAligned(r4, r2, new i(r5), null);
        }

        /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
        public final Vertical m811spacedByD5KLDUw(float r4, final Alignment.Vertical r5) {
            boolean r2 = false;
            return new SpacedAligned(r4, r2, new h(r5), null);
        }

        private static final int aligned$lambda$2(Alignment.Horizontal r1, int r2, LayoutDirection r3) {
            return r1.align(0, r2, r3);
        }

        private static final int spacedBy_D5KLDUw$lambda$0(Alignment.Horizontal r1, int r2, LayoutDirection r3) {
            return r1.align(0, r2, r3);
        }

        private static final int spacedBy_D5KLDUw$lambda$1(Alignment.Vertical r0, int r1, LayoutDirection r2) {
            return r0.align(0, r1);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Horizontal {

        /* JADX INFO: renamed from: androidx.compose.foundation.layout.Arrangement$Horizontal$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            /* JADX INFO: renamed from: $default$getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m813$default$getSpacingD9Ej5fM(Horizontal r0) {
                return Dp.constructor-impl(0);
            }

            /* JADX INFO: renamed from: access$getSpacing-D9Ej5fM$jd, reason: not valid java name */
            public static /* synthetic */ float m814access$getSpacingD9Ej5fM$jd(Horizontal r0) {
                return m813$default$getSpacingD9Ej5fM(r0);
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m815getSpacingD9Ej5fM(Horizontal r0) {
                return CC.m814access$getSpacingD9Ej5fM$jd(r0);
            }
        }

        void arrange(Density r1, int r2, int[] r3, LayoutDirection r4, int[] r5);

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo812getSpacingD9Ej5fM();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface HorizontalOrVertical extends Horizontal, Vertical {

        /* JADX INFO: renamed from: androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            /* JADX INFO: renamed from: $default$getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m816$default$getSpacingD9Ej5fM(HorizontalOrVertical r0) {
                return Dp.constructor-impl(0);
            }

            /* JADX INFO: renamed from: access$getSpacing-D9Ej5fM$jd, reason: not valid java name */
            public static /* synthetic */ float m817access$getSpacingD9Ej5fM$jd(HorizontalOrVertical r0) {
                return m816$default$getSpacingD9Ej5fM(r0);
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m818getSpacingD9Ej5fM(HorizontalOrVertical r0) {
                return CC.m817access$getSpacingD9Ej5fM$jd(r0);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo812getSpacingD9Ej5fM();
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J$\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b \u0010\rJ\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JB\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006*"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "rtlMirror", "", "alignment", "Lkotlin/Function2;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "<init>", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSpace-D9Ej5fM", "()F", "F", "getRtlMirror", "()Z", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "spacing", "getSpacing-D9Ej5fM", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "sizes", "", "layoutDirection", "outPositions", "toString", "", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FZLkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "equals", "other", "", "hashCode", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SpacedAligned implements HorizontalOrVertical {
        public static final int $stable = 0;
        private final Function2<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        public /* synthetic */ SpacedAligned(float r1, boolean r2, Function2 r3, DefaultConstructorMarker r4) {
            this(r1, r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: copy-8Feqmps$default, reason: not valid java name */
        public static /* synthetic */ SpacedAligned m819copy8Feqmps$default(SpacedAligned r0, float r1, boolean r2, Function2 r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.space;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.rtlMirror;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.alignment;
        L12:
            return r0.m821copy8Feqmps(r1, r2, r3);
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
        public final float m820component1D9Ej5fM() {
            return this.space;
        }

        public final boolean component2() {
            return this.rtlMirror;
        }

        public final Function2<Integer, LayoutDirection, Integer> component3() {
            return this.alignment;
        }

        /* JADX INFO: renamed from: copy-8Feqmps, reason: not valid java name */
        public final SpacedAligned m821copy8Feqmps(float r3, boolean r4, Function2<? super Integer, ? super LayoutDirection, Integer> r5) {
            return new SpacedAligned(r3, r4, r5, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SpacedAligned) == true) goto L8;
            return false;
        L8:
            SpacedAligned r6 = (SpacedAligned) r5;
            if (Dp.equals-impl0(this.space, r6.space) == true) goto L12;
            return false;
        L12:
            if (this.rtlMirror == r6.rtlMirror) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.alignment, r6.alignment) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = Dp.hashCode-impl(this.space) * 31;
            if (this.rtlMirror == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (r0 + r1) * 31;
            Function2<Integer, LayoutDirection, Integer> r3 = this.alignment;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (this.rtlMirror == false) goto L5;
            String r1 = "";
        L6:
            r0.append(r1);
            r0.append("Arrangement#spacedAligned(");
            r0.append(Dp.toString-impl(this.space));
            r0.append(", ");
            r0.append(this.alignment);
            r0.append(')');
            return r0.toString();
        L5:
            r1 = "Absolute";
            goto L6
        }

        public final Function2<Integer, LayoutDirection, Integer> getAlignment() {
            return this.alignment;
        }

        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        /* JADX INFO: renamed from: getSpace-D9Ej5fM, reason: not valid java name */
        public final float m822getSpaceD9Ej5fM() {
            return this.space;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical, androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        public float mo812getSpacingD9Ej5fM() {
            return this.spacing;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private SpacedAligned(float r1, boolean r2, Function2<? super Integer, ? super LayoutDirection, Integer> r3) {
            this.space = r1;
            this.rtlMirror = r2;
            this.alignment = r3;
            this.spacing = r1;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density r7, int r8, int[] r9, int[] r10) {
            arrange(r7, r8, r9, LayoutDirection.Ltr, r10);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density r10, int r11, int[] r12, LayoutDirection r13, int[] r14) {
            int r2 = 0;
            if (r12.length != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            return;
        L8:
            int r15 = r10.roundToPx-0680j_4(this.space);
            if (this.rtlMirror == true) goto L11;
        L13:
            boolean r1 = false;
        L14:
            Arrangement r3 = Arrangement.INSTANCE;
            if (r1 == true) goto L19;
            int r4 = r12.length;
            int r5 = 0;
            int r6 = 0;
            int r7 = 0;
            int r8 = 0;
        L17:
            if (r5 >= r4) goto L23;
            int r9 = r12[r5];
            int r16 = Math.min(r6, r11 - r9);
            r14[r8] = r16;
            int r17 = Math.min(r15, (r11 - r16) - r9);
            int r18 = (r14[r8] + r9) + r17;
            r5 = r5 + 1;
            r8 = r8 + 1;
            r7 = r17;
            r6 = r18;
        L23:
            int r19 = r6 - r7;
            Function2<Integer, LayoutDirection, Integer> r110 = this.alignment;
            if (r110 == null) goto L29;
            if (r19 >= r11) goto L33;
            int r111 = ((Number) r110.invoke(Integer.valueOf(r11 - r19), r13)).intValue();
            int r112 = r14.length;
        L27:
            if (r2 >= r112) goto L34;
            r14[r2] = r14[r2] + r111;
            r2 = r2 + 1;
            goto L27
        L34:
            return;
        L33:
            return;
        L29:
            return;
        L19:
            int r20 = r12.length - 1;
            r6 = 0;
            r7 = 0;
        L21:
            if ((-1) >= r20) goto L23;
            int r21 = r12[r20];
            int r22 = Math.min(r6, r11 - r21);
            r14[r20] = r22;
            r7 = Math.min(r15, (r11 - r22) - r21);
            r6 = (r14[r20] + r21) + r7;
            r20 = r20 - 1;
            goto L21
        L11:
            if (r13 != LayoutDirection.Rtl) goto L13;
            r1 = true;
            goto L14
        L5:
            r0 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Vertical {

        /* JADX INFO: renamed from: androidx.compose.foundation.layout.Arrangement$Vertical$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            /* JADX INFO: renamed from: $default$getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m823$default$getSpacingD9Ej5fM(Vertical r0) {
                return Dp.constructor-impl(0);
            }

            /* JADX INFO: renamed from: access$getSpacing-D9Ej5fM$jd, reason: not valid java name */
            public static /* synthetic */ float m824access$getSpacingD9Ej5fM$jd(Vertical r0) {
                return m823$default$getSpacingD9Ej5fM(r0);
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public static float m825getSpacingD9Ej5fM(Vertical r0) {
                return CC.m824access$getSpacingD9Ej5fM$jd(r0);
            }
        }

        void arrange(Density r1, int r2, int[] r3, int[] r4);

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
        float mo812getSpacingD9Ej5fM();
    }

    private Arrangement() {
    }

    public static /* synthetic */ int a(Alignment.Vertical r0, int r1, LayoutDirection r2) {
        return aligned$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ int b(int r0, LayoutDirection r1) {
        return spacedBy_0680j_4$lambda$0(r0, r1);
    }

    public static /* synthetic */ int c(Alignment.Vertical r0, int r1, LayoutDirection r2) {
        return spacedBy_D5KLDUw$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ int d(Alignment.Horizontal r0, int r1, LayoutDirection r2) {
        return spacedBy_D5KLDUw$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ int e(Alignment.Horizontal r0, int r1, LayoutDirection r2) {
        return aligned$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ void getBottom$annotations() {
    }

    public static /* synthetic */ void getCenter$annotations() {
    }

    public static /* synthetic */ void getEnd$annotations() {
    }

    public static /* synthetic */ void getSpaceAround$annotations() {
    }

    public static /* synthetic */ void getSpaceBetween$annotations() {
    }

    public static /* synthetic */ void getSpaceEvenly$annotations() {
    }

    public static /* synthetic */ void getStart$annotations() {
    }

    public static /* synthetic */ void getTop$annotations() {
    }

    static {
        INSTANCE = new Arrangement();
        Start = new Arrangement$Start$1();
        End = new Arrangement$End$1();
        Top = new Arrangement$Top$1();
        Bottom = new Arrangement$Bottom$1();
        Center = new Arrangement$Center$1();
        SpaceEvenly = new Arrangement$SpaceEvenly$1();
        SpaceBetween = new Arrangement$SpaceBetween$1();
        SpaceAround = new Arrangement$SpaceAround$1();
    }

    public final Vertical getBottom() {
        return Bottom;
    }

    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    public final Horizontal getEnd() {
        return End;
    }

    public final HorizontalOrVertical getSpaceAround() {
        return SpaceAround;
    }

    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    public final HorizontalOrVertical getSpaceEvenly() {
        return SpaceEvenly;
    }

    public final Horizontal getStart() {
        return Start;
    }

    public final Vertical getTop() {
        return Top;
    }

    public final Horizontal aligned(final Alignment.Horizontal r5) {
        return new SpacedAligned(Dp.constructor-impl(0), true, new c(r5), null);
    }

    /* JADX INFO: renamed from: spacedBy-0680j_4, reason: not valid java name */
    public final HorizontalOrVertical m806spacedBy0680j_4(float r5) {
        boolean r3 = true;
        return new SpacedAligned(r5, r3, new b(), null);
    }

    public final Vertical aligned(final Alignment.Vertical r5) {
        return new SpacedAligned(Dp.constructor-impl(0), false, new e(r5), null);
    }

    private static final int spacedBy_0680j_4$lambda$0(int r2, LayoutDirection r3) {
        return Alignment.Companion.getStart().align(0, r2, r3);
    }

    /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Horizontal m807spacedByD5KLDUw(float r4, final Alignment.Horizontal r5) {
        boolean r2 = true;
        return new SpacedAligned(r4, r2, new d(r5), null);
    }

    /* JADX INFO: renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Vertical m808spacedByD5KLDUw(float r4, final Alignment.Vertical r5) {
        boolean r2 = false;
        return new SpacedAligned(r4, r2, new f(r5), null);
    }

    private static final int aligned$lambda$3(Alignment.Horizontal r1, int r2, LayoutDirection r3) {
        return r1.align(0, r2, r3);
    }

    private static final int aligned$lambda$4(Alignment.Vertical r0, int r1, LayoutDirection r2) {
        return r0.align(0, r1);
    }

    private final void forEachIndexed(int[] r5, boolean r6, Function2<? super Integer, ? super Integer, Unit> r7) {
        if (r6 == true) goto L6;
        int r8 = r5.length;
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r8) goto L10;
        r7.invoke(Integer.valueOf(r1), Integer.valueOf(r5[r0]));
        r0 = r0 + 1;
        r1 = r1 + 1;
        goto L4
    L10:
        return;
    L6:
        int r9 = r5.length;
    L7:
        r9 = r9 - 1;
        if ((-1) >= r9) goto L13;
        r7.invoke(Integer.valueOf(r9), Integer.valueOf(r5[r9]));
        goto L7
    }

    private static final int spacedBy_D5KLDUw$lambda$1(Alignment.Horizontal r1, int r2, LayoutDirection r3) {
        return r1.align(0, r2, r3);
    }

    private static final int spacedBy_D5KLDUw$lambda$2(Alignment.Vertical r0, int r1, LayoutDirection r2) {
        return r0.align(0, r1);
    }

    public final void placeLeftOrTop$foundation_layout(int[] r6, int[] r7, boolean r8) {
        int r0 = 0;
        if (r8 == true) goto L7;
        int r9 = r6.length;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r0 >= r9) goto L11;
        int r3 = r6[r0];
        r7[r1] = r2;
        r2 = r2 + r3;
        r0 = r0 + 1;
        r1 = r1 + 1;
        goto L5
    L11:
        return;
    L7:
        int r10 = r6.length;
    L8:
        r10 = r10 - 1;
        if ((-1) >= r10) goto L14;
        int r4 = r6[r10];
        r7[r10] = r0;
        r0 = r0 + r4;
        goto L8
    }

    public final void placeCenter$foundation_layout(int r6, int[] r7, int[] r8, boolean r9) {
        int r0 = r7.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r7[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        float r10 = (r6 - r3) / 2;
        if (r9 == true) goto L10;
        int r11 = r7.length;
        int r4 = 0;
    L8:
        if (r1 >= r11) goto L14;
        int r5 = r7[r1];
        r8[r4] = Math.round(r10);
        r10 = r10 + r5;
        r1 = r1 + 1;
        r4 = r4 + 1;
        goto L8
    L14:
        return;
    L10:
        int r12 = r7.length;
    L11:
        r12 = r12 - 1;
        if ((-1) >= r12) goto L18;
        int r13 = r7[r12];
        r8[r12] = Math.round(r10);
        r10 = r10 + r13;
        goto L11
    }

    public final void placeRightOrBottom$foundation_layout(int r6, int[] r7, int[] r8, boolean r9) {
        int r0 = r7.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r7[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        int r10 = r6 - r3;
        if (r9 == true) goto L10;
        int r11 = r7.length;
        int r4 = 0;
    L8:
        if (r1 >= r11) goto L14;
        int r5 = r7[r1];
        r8[r4] = r10;
        r10 = r10 + r5;
        r1 = r1 + 1;
        r4 = r4 + 1;
        goto L8
    L14:
        return;
    L10:
        int r12 = r7.length;
    L11:
        r12 = r12 - 1;
        if ((-1) >= r12) goto L18;
        int r13 = r7[r12];
        r8[r12] = r10;
        r10 = r10 + r13;
        goto L11
    }

    public final void placeSpaceAround$foundation_layout(int r7, int[] r8, int[] r9, boolean r10) {
        int r0 = r8.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r3 = r3 + r8[r2];
        r2 = r2 + 1;
        goto L3
    L6:
        if (r8.length != 0) goto L8;
        boolean r4 = true;
    L10:
        if ((!r4) == false) goto L12;
        float r11 = (r7 - r3) / r8.length;
    L13:
        float r5 = r11 / 2;
        if (r10 == true) goto L18;
        int r12 = r8.length;
        int r6 = 0;
    L16:
        if (r1 >= r12) goto L22;
        int r13 = r8[r1];
        r9[r6] = Math.round(r5);
        r5 = r5 + (r13 + r11);
        r1 = r1 + 1;
        r6 = r6 + 1;
        goto L16
    L22:
        return;
    L18:
        int r14 = r8.length - 1;
    L20:
        if ((-1) >= r14) goto L26;
        int r15 = r8[r14];
        r9[r14] = Math.round(r5);
        r5 = r5 + (r15 + r11);
        r14 = r14 - 1;
        goto L20
    L26:
        return;
    L12:
        r11 = MenuKt.ClosedAlphaTarget;
        goto L13
    L8:
        r4 = false;
        goto L10
    }

    public final void placeSpaceBetween$foundation_layout(int r7, int[] r8, int[] r9, boolean r10) {
        int r1 = 0;
        if (r8.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        int r2 = r8.length;
        int r3 = 0;
        int r4 = 0;
    L9:
        if (r3 >= r2) goto L11;
        r4 = r4 + r8[r3];
        r3 = r3 + 1;
        goto L9
    L11:
        float r11 = (r7 - r4) / Math.max(ArraysKt.getLastIndex(r8), 1);
        if (r10 == true) goto L14;
    L16:
        float r5 = MenuKt.ClosedAlphaTarget;
    L17:
        if (r10 == true) goto L21;
        int r12 = r8.length;
        int r6 = 0;
    L19:
        if (r1 >= r12) goto L25;
        int r13 = r8[r1];
        r9[r6] = Math.round(r5);
        r5 = r5 + (r13 + r11);
        r1 = r1 + 1;
        r6 = r6 + 1;
        goto L19
    L25:
        return;
    L21:
        int r14 = r8.length - 1;
    L23:
        if ((-1) >= r14) goto L29;
        int r15 = r8[r14];
        r9[r14] = Math.round(r5);
        r5 = r5 + (r15 + r11);
        r14 = r14 - 1;
        goto L23
    L29:
        return;
    L14:
        if (r8.length != 1) goto L16;
        r5 = r11;
        goto L17
    L5:
        r0 = false;
        goto L6
    }

    public final void placeSpaceEvenly$foundation_layout(int r7, int[] r8, int[] r9, boolean r10) {
        int r0 = r8.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r8[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        float r11 = (r7 - r3) / (r8.length + 1);
        if (r10 == true) goto L10;
        int r12 = r8.length;
        float r4 = r11;
        int r5 = 0;
    L8:
        if (r1 >= r12) goto L14;
        int r6 = r8[r1];
        r9[r5] = Math.round(r4);
        r4 = r4 + (r6 + r11);
        r1 = r1 + 1;
        r5 = r5 + 1;
        goto L8
    L14:
        return;
    L10:
        int r13 = r8.length - 1;
        float r14 = r11;
    L12:
        if ((-1) >= r13) goto L18;
        int r15 = r8[r13];
        r9[r13] = Math.round(r14);
        r14 = r14 + (r15 + r11);
        r13 = r13 - 1;
        goto L12
    }
}
