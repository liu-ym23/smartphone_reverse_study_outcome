package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0015B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/ArcSpline;", "", "arcModes", "", "timePoints", "", "y", "", "<init>", "([I[F[[F)V", "arcs", "Landroidx/compose/animation/core/ArcSpline$Arc;", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "isExtrapolate", "", "getPos", "", "time", "", "v", "getSlope", "Arc", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ArcSpline {
    public static final int $stable = 8;
    private final Arc[][] arcs;
    private final boolean isExtrapolate;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BA\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005J\u0011\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0082\bJ\t\u0010&\u001a\u00020\u0005H\u0086\bJ\t\u0010'\u001a\u00020\u0005H\u0086\bJ\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J-\u0010.\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0000¢\u0006\u0002\b/R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u001e\u001a\u00020\u00058À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000eR\u0015\u0010 \u001a\u00020\u00058À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000e¨\u00060"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc;", "", "mode", "", "time1", "", "time2", "x1", "y1", "x2", "y2", "<init>", "(IFFFFFF)V", "getTime1", "()F", "getTime2", "arcDistance", "tmpSinAngle", "tmpCosAngle", "lut", "", "oneOverDeltaTime", "arcVelocity", "vertical", "ellipseA", "ellipseB", "isLinear", "", "ellipseCenterX", "ellipseCenterY", "linearDX", "getLinearDX$animation_core", "linearDY", "getLinearDY$animation_core", "setPoint", "", "time", "calcAngle", "calcX", "calcY", "calcDX", "calcDY", "getLinearX", "getLinearY", "lookup", "v", "buildTable", "buildTable$animation_core", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Arc {
        public static final int $stable = 8;
        private float arcDistance;
        private final float arcVelocity;
        public final float ellipseA;
        public final float ellipseB;
        public final float ellipseCenterX;
        public final float ellipseCenterY;
        public final boolean isLinear;
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float vertical;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        public final float calcDX() {
            float r0 = this.ellipseA * this.tmpCosAngle;
            return (r0 * this.vertical) * (this.arcVelocity / ((float) Math.hypot(r0, (-this.ellipseB) * this.tmpSinAngle)));
        }

        public final float calcDY() {
            float r0 = this.ellipseA * this.tmpCosAngle;
            float r1 = (-this.ellipseB) * this.tmpSinAngle;
            return (r1 * this.vertical) * (this.arcVelocity / ((float) Math.hypot(r0, r1)));
        }

        public final float calcX() {
            return this.ellipseCenterX + (this.ellipseA * access$getTmpSinAngle$p(this));
        }

        public final float calcY() {
            return this.ellipseCenterY + (this.ellipseB * access$getTmpCosAngle$p(this));
        }

        public final float getLinearDX$animation_core() {
            return this.ellipseCenterX;
        }

        public final float getLinearDY$animation_core() {
            return this.ellipseCenterY;
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        public static final /* synthetic */ float access$getTmpCosAngle$p(Arc r0) {
            return r0.tmpCosAngle;
        }

        public static final /* synthetic */ float access$getTmpSinAngle$p(Arc r0) {
            return r0.tmpSinAngle;
        }

        private final float calcAngle(float r3) {
            if (this.vertical != (-1.0f)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            float r1 = this.time2 - r3;
        L10:
            return lookup(r1 * this.oneOverDeltaTime) * 1.5707964f;
        L8:
            r1 = r3 - this.time1;
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        private final float lookup(float r4) {
            if (r4 > MenuKt.ClosedAlphaTarget) goto L6;
            return MenuKt.ClosedAlphaTarget;
        L6:
            if (r4 < 1.0f) goto L8;
            return 1.0f;
        L8:
            float r5 = r4 * 100;
            int r0 = (int) r5;
            float r6 = r5 - r0;
            float[] r1 = this.lut;
            float r2 = r1[r0];
            return r2 + (r6 * (r1[r0 + 1] - r2));
        }

        public final float getLinearX(float r3) {
            float r4 = (r3 - this.time1) * this.oneOverDeltaTime;
            float r0 = this.x1;
            return r0 + (r4 * (this.x2 - r0));
        }

        public final float getLinearY(float r3) {
            float r4 = (r3 - this.time1) * this.oneOverDeltaTime;
            float r0 = this.y1;
            return r0 + (r4 * (this.y2 - r0));
        }

        public final void setPoint(float r5) {
            if (this.vertical != (-1.0f)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            float r1 = this.time2 - r5;
        L9:
            double r2 = lookup(r1 * this.oneOverDeltaTime) * 1.5707964f;
            this.tmpSinAngle = (float) Math.sin(r2);
            this.tmpCosAngle = (float) Math.cos(r2);
            return;
        L8:
            r1 = r5 - this.time1;
            goto L9
        L5:
            r0 = false;
            goto L6
        }

        public final void buildTable$animation_core(float r17, float r18, float r19, float r20) {
            float r1 = r19 - r17;
            float r2 = r18 - r20;
            float[] r9 = ArcSplineKt.access$getOurPercentCache$p();
            int r3 = r9.length - 1;
            float r11 = r3;
            float[] r12 = this.lut;
            if (1 > r3) goto L8;
            float r7 = r2;
            int r4 = 1;
            float r5 = MenuKt.ClosedAlphaTarget;
            float r6 = MenuKt.ClosedAlphaTarget;
        L5:
            float r110 = r11;
            double r10 = (float) Math.toRadians((((double) r4) * 90.0d) / ((double) r3));
            float r8 = ((float) Math.sin(r10)) * r1;
            float r13 = ((float) Math.cos(r10)) * r2;
            r5 = r5 + ((float) Math.hypot(r8 - r6, r13 - r7));
            r9[r4] = r5;
            if (r4 == r3) goto L9;
            r4 = r4 + 1;
            r11 = r110;
            r6 = r8;
            r7 = r13;
        L9:
            this.arcDistance = r5;
            if (1 > r3) goto L15;
            int r14 = 1;
        L12:
            r9[r14] = r9[r14] / r5;
            if (r14 == r3) goto L15;
            r14 = r14 + 1;
        L15:
            int r15 = r12.length;
            int r16 = 0;
        L16:
            if (r16 >= r15) goto L26;
            float r111 = r16 / 100.0f;
            int r21 = ArraysKt.binarySearch$default(r9, r111, 0, 0, 6, null);
            if (r21 < 0) goto L22;
            r12[r16] = r21 / r110;
        L25:
            r16 = r16 + 1;
            goto L16
        L22:
            if (r21 != (-1)) goto L24;
            r12[r16] = 0.0f;
            goto L25
        L24:
            int r22 = -r21;
            int r23 = r22 - 2;
            float r24 = r23;
            float r25 = r9[r23];
            r12[r16] = (r24 + ((r111 - r25) / (r9[r22 - 1] - r25))) / r110;
            goto L25
        L26:
            return;
        L8:
            r110 = r11;
            r5 = MenuKt.ClosedAlphaTarget;
            goto L9
        }

        public Arc(int r8, float r9, float r10, float r11, float r12, float r13, float r14) {
            this.time1 = r9;
            this.time2 = r10;
            this.x1 = r11;
            this.y1 = r12;
            this.x2 = r13;
            this.y2 = r14;
            float r0 = r13 - r11;
            float r1 = r14 - r12;
            boolean r2 = false;
            boolean r3 = true;
            if (r8 != 1) goto L5;
        L14:
            boolean r4 = true;
        L15:
            if (r4 == false) goto L17;
            float r5 = -1.0f;
        L18:
            this.vertical = r5;
            float r6 = 1 / (r10 - r9);
            this.oneOverDeltaTime = r6;
            this.lut = new float[101];
            if (r8 != 3) goto L21;
            r2 = true;
        L21:
            if (r2 == false) goto L23;
        L36:
            float r15 = (float) Math.hypot(r1, r0);
            this.arcDistance = r15;
            this.arcVelocity = r15 * r6;
            this.ellipseCenterX = r0 * r6;
            this.ellipseCenterY = r1 * r6;
            this.ellipseA = Float.NaN;
            this.ellipseB = Float.NaN;
        L37:
            this.isLinear = r3;
            return;
        L23:
            if (Math.abs(r0) < 0.001f) goto L36;
            if (Math.abs(r1) < 0.001f) goto L36;
            this.ellipseA = r0 * r5;
            this.ellipseB = r1 * (-r5);
            if (r4 == false) goto L30;
            float r16 = r13;
        L31:
            this.ellipseCenterX = r16;
            if (r4 == false) goto L34;
            float r17 = r12;
        L35:
            this.ellipseCenterY = r17;
            buildTable$animation_core(r11, r12, r13, r14);
            this.arcVelocity = this.arcDistance * r6;
            r3 = r2;
            goto L37
        L34:
            r17 = r14;
            goto L35
        L30:
            r16 = r11;
            goto L31
        L17:
            r5 = 1.0f;
            goto L18
        L5:
            if (r8 == 4) goto L13;
            if (r8 == 5) goto L10;
        L8:
            r4 = false;
            goto L15
        L10:
            if (r1 >= MenuKt.ClosedAlphaTarget) goto L8;
        L13:
            if (r1 <= MenuKt.ClosedAlphaTarget) goto L8;
            goto L8
        }
    }

    public final void getPos(float r13, float[] r14) {
        Arc[][] r0 = this.arcs;
        int r1 = r0.length - 1;
        int r3 = 0;
        float r4 = r0[0][0].getTime1();
        float r5 = r0[r1][0].getTime2();
        int r6 = r14.length;
        if (this.isExtrapolate == true) goto L5;
        r13 = Math.min(Math.max(r13, r4), r5);
    L22:
        int r2 = r0.length;
        int r7 = 0;
        boolean r8 = false;
    L23:
        if (r7 >= r2) goto L38;
        int r9 = 0;
        int r10 = 0;
    L26:
        if (r9 >= (r6 - 1)) goto L35;
        Arc r11 = r0[r7][r10];
        if (r13 > r11.getTime2()) goto L34;
        if (r11.isLinear == false) goto L32;
        r14[r9] = r11.getLinearX(r13);
        r14[r9 + 1] = r11.getLinearY(r13);
    L33:
        r8 = true;
        goto L34
    L32:
        r11.setPoint(r13);
        r14[r9] = r11.ellipseCenterX + (r11.ellipseA * Arc.access$getTmpSinAngle$p(r11));
        r14[r9 + 1] = r11.ellipseCenterY + (r11.ellipseB * Arc.access$getTmpCosAngle$p(r11));
    L34:
        r9 = r9 + 2;
        r10 = r10 + 1;
        goto L26
    L35:
        if (r8 == true) goto L36;
        r7 = r7 + 1;
        goto L23
    L36:
        return;
    L38:
        return;
    L5:
        if (r13 < r4) goto L9;
        if (r13 <= r5) goto L22;
    L9:
        if (r13 <= r5) goto L11;
        r4 = r5;
    L12:
        float r15 = r13 - r4;
        int r12 = 0;
    L14:
        if (r3 >= (r6 - 1)) goto L20;
        Arc r16 = r0[r1][r12];
        if (r16.isLinear == false) goto L18;
        r14[r3] = r16.getLinearX(r4) + (r16.ellipseCenterX * r15);
        r14[r3 + 1] = r16.getLinearY(r4) + (r16.ellipseCenterY * r15);
    L19:
        r3 = r3 + 2;
        r12 = r12 + 1;
        goto L14
    L18:
        r16.setPoint(r4);
        r14[r3] = (r16.ellipseCenterX + (r16.ellipseA * Arc.access$getTmpSinAngle$p(r16))) + (r16.calcDX() * r15);
        r14[r3 + 1] = (r16.ellipseCenterY + (r16.ellipseB * Arc.access$getTmpCosAngle$p(r16))) + (r16.calcDY() * r15);
        goto L19
    L20:
        return;
    L11:
        r1 = 0;
        goto L12
    }

    public final void getSlope(float r12, float[] r13) {
        Arc[][] r0 = this.arcs;
        float r2 = r0[0][0].getTime1();
        float r3 = r0[r0.length - 1][0].getTime2();
        if (r12 >= r2) goto L6;
        r12 = r2;
    L6:
        if (r12 > r3) goto L9;
        r3 = r12;
    L9:
        int r14 = r13.length;
        int r4 = r0.length;
        int r5 = 0;
        boolean r6 = false;
    L10:
        if (r5 >= r4) goto L25;
        int r7 = 0;
        int r8 = 0;
    L13:
        if (r7 >= (r14 - 1)) goto L22;
        Arc r9 = r0[r5][r8];
        if (r3 > r9.getTime2()) goto L21;
        if (r9.isLinear == false) goto L19;
        r13[r7] = r9.ellipseCenterX;
        r13[r7 + 1] = r9.ellipseCenterY;
    L20:
        r6 = true;
        goto L21
    L19:
        r9.setPoint(r3);
        r13[r7] = r9.calcDX();
        r13[r7 + 1] = r9.calcDY();
    L21:
        r7 = r7 + 2;
        r8 = r8 + 1;
        goto L13
    L22:
        if (r6 == true) goto L23;
        r5 = r5 + 1;
        goto L10
    L23:
        return;
    }

    public ArcSpline(int[] r27, float[] r28, float[][] r29) {
        this.isExtrapolate = true;
        int r3 = r28.length - 1;
        Arc[][] r4 = new Arc[r3][];
        int r6 = 0;
        int r7 = 1;
        int r8 = 1;
    L3:
        if (r6 >= r3) goto L27;
        int r9 = r27[r6];
        if (r9 == 0) goto L22;
        if (r9 == 1) goto L21;
        if (r9 == 2) goto L20;
        if (r9 != 3) goto L10;
        if (r7 != 1) goto L18;
        r7 = 2;
    L19:
        r8 = r7;
    L23:
        float[] r10 = r29[r6];
        int r11 = r6 + 1;
        float[] r20 = r29[r11];
        float r21 = r28[r6];
        float r22 = r28[r11];
        int r12 = (r10.length / 2) + (r10.length % 2);
        Arc[] r15 = new Arc[r12];
        int r14 = 0;
    L24:
        if (r14 >= r12) goto L26;
        int r13 = r14 * 2;
        float r16 = r10[r13];
        int r17 = r13 + 1;
        float r18 = r10[r17];
        float r19 = r20[r13];
        float r110 = r20[r17];
        int r24 = r14;
        Arc[] r25 = r15;
        r25[r24] = new Arc(r8, r21, r22, r16, r18, r19, r110);
        r14 = r24 + 1;
        r15 = r25;
        goto L24
    L26:
        r4[r6] = r15;
        r6 = r11;
        goto L3
    L18:
        r7 = 1;
        goto L19
    L10:
        if (r9 != 4) goto L12;
        r8 = 4;
        goto L23
    L12:
        if (r9 != 5) goto L23;
        r8 = 5;
        goto L23
    L20:
        r7 = 2;
        r8 = 2;
        goto L23
    L21:
        r7 = 1;
        r8 = 1;
        goto L23
    L22:
        r8 = 3;
        goto L23
    L27:
        this.arcs = r4;
    }
}
