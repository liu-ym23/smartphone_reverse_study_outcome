package com.edu.onetex.latex.graphic;

import android.graphics.PathMeasure;
import com.edu.onetex.latex.LaTeXEngine;
import com.edu.onetex.latex.OneTexConfiguration;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012J\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012J\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012J&\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/edu/onetex/latex/graphic/Path;", "", "()V", "opList", "Ljava/util/ArrayList;", "Lcom/edu/onetex/latex/graphic/Path$Op;", "Lkotlin/collections/ArrayList;", "getOpList", "()Ljava/util/ArrayList;", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", DBDefinition.SEGMENT_TABLE_NAME, "", "startX", "", "startY", "cubicTo", "", "x1", "y1", "x2", "y2", "x3", "y3", "lineTo", "x", "y", "moveTo", "quadTo", "Op", "onetex_release"}, k = 1, mv = {1, 4, 2})
public final class Path {
    private final ArrayList<Op> opList;
    private android.graphics.Path path;
    private final int segments;
    private double startX;
    private double startY;

    /* JADX INFO: loaded from: classes22.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/edu/onetex/latex/graphic/Path$Op;", "", "startX", "", "startY", "endX", "endY", "(DDDD)V", "getEndX", "()D", "getEndY", "getStartX", "getStartY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "onetex_release"}, k = 1, mv = {1, 4, 2})
    public static final class Op {
        private final double endX;
        private final double endY;
        private final double startX;
        private final double startY;

        public static /* synthetic */ Op copy$default(Op r100, double r110, double r111, double r112, double r113, int r114, Object r115) {
            if ((r114 & 1) == 0) goto L5;
            double r101 = r100.startX;
        L7:
            if ((r114 & 2) == 0) goto L9;
            double r102 = r100.startY;
        L11:
            if ((r114 & 4) == 0) goto L13;
            double r103 = r100.endX;
        L15:
            if ((r114 & 8) == 0) goto L17;
            double r104 = r100.endY;
        L19:
            return r100.copy(r101, r102, r103, r104);
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }

        public final double component1() {
            return this.startX;
        }

        public final double component2() {
            return this.startY;
        }

        public final double component3() {
            return this.endX;
        }

        public final double component4() {
            return this.endY;
        }

        public final Op copy(double r110, double r111, double r112, double r113) {
            return new Op(r110, r111, r112, r113);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Op) == false) goto L14;
            Op r101 = (Op) r100;
            if (Double.compare(this.startX, r101.startX) == 0) goto L8;
            return false;
        L8:
            if (Double.compare(this.startY, r101.startY) == 0) goto L10;
            return false;
        L10:
            if (Double.compare(this.endX, r101.endX) == 0) goto L12;
            return false;
        L12:
            if (Double.compare(this.endY, r101.endY) == 0) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            long r100 = Double.doubleToLongBits(this.startX);
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = Double.doubleToLongBits(this.startY);
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = Double.doubleToLongBits(this.endX);
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = Double.doubleToLongBits(this.endY);
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        }

        public String toString() {
            return "Op(startX=" + this.startX + ", startY=" + this.startY + ", endX=" + this.endX + ", endY=" + this.endY + ")";
        }

        public final double getEndX() {
            return this.endX;
        }

        public final double getEndY() {
            return this.endY;
        }

        public final double getStartX() {
            return this.startX;
        }

        public final double getStartY() {
            return this.startY;
        }

        public Op(double r100, double r101, double r102, double r103) {
            this.startX = r100;
            this.startY = r101;
            this.endX = r102;
            this.endY = r103;
        }
    }

    public Path() {
        this.path = new android.graphics.Path();
        this.segments = 10;
        this.opList = new ArrayList();
    }

    public final ArrayList<Op> getOpList() {
        return this.opList;
    }

    public final android.graphics.Path getPath() {
        return this.path;
    }

    public final void setPath(android.graphics.Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.path = r100;
    }

    public final void lineTo(double r110, double r111) {
        this.path.lineTo((float) r110, (float) r111);
        OneTexConfiguration r100 = LaTeXEngine.INSTANCE.getConfiguration();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getLowVersionCompat() != true) goto L9;
        this.opList.add(new Op(this.startX, this.startY, r110, r111));
        this.startX = r110;
        this.startY = r111;
        return;
    }

    public final void moveTo(double r100, double r101) {
        this.path.moveTo((float) r100, (float) r101);
        OneTexConfiguration r102 = LaTeXEngine.INSTANCE.getConfiguration();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.getLowVersionCompat() != true) goto L9;
        this.startX = r100;
        this.startY = r101;
        return;
    }

    public final void quadTo(double r210, double r211, double r212, double r310) {
        float r100 = (float) r210;
        float r101 = (float) r211;
        float r102 = (float) r212;
        float r103 = (float) r310;
        this.path.quadTo(r100, r101, r102, r103);
        OneTexConfiguration r104 = LaTeXEngine.INSTANCE.getConfiguration();
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.getLowVersionCompat() != true) goto L19;
        android.graphics.Path r105 = new android.graphics.Path();
        r105.moveTo((float) this.startX, (float) this.startY);
        r105.quadTo(r100, r101, r102, r103);
        char r106 = 0;
        PathMeasure r107 = new PathMeasure(r105, false);
        float[] r108 = new float[2];
        double r109 = this.startX;
        double r110 = this.startY;
        int r111 = this.segments;
        if (1 > r111) goto L15;
        double r112 = r109;
        double r113 = r110;
        int r114 = 1;
    L9:
        float r115 = (r107.getLength() / this.segments) * r114;
        if (r115 >= r107.getLength()) goto L12;
        r107.getPosTan(r115, r108, null);
        int r213 = r114;
        this.opList.add(new Op(r112, r113, r108[r106], r108[1]));
        double r116 = r108[0];
        int r117 = r213;
        r112 = r116;
        r113 = r108[1];
    L13:
        if (r117 == r111) goto L15;
        r114 = r117 + 1;
        r106 = 0;
        goto L9
    L12:
        r117 = r114;
    L15:
        this.startX = r212;
        this.startY = r310;
        return;
    }

    public final void cubicTo(double r210, double r211, double r212, double r310, double r311, double r312) {
        float r100 = (float) r210;
        float r101 = (float) r211;
        float r102 = (float) r212;
        float r103 = (float) r310;
        float r110 = (float) r311;
        float r111 = (float) r312;
        this.path.cubicTo(r100, r101, r102, r103, r110, r111);
        OneTexConfiguration r104 = LaTeXEngine.INSTANCE.getConfiguration();
        if (r104 == null) goto L18;
        char r112 = 1;
        if (r104.getLowVersionCompat() != true) goto L19;
        android.graphics.Path r105 = new android.graphics.Path();
        r105.moveTo((float) this.startX, (float) this.startY);
        r105.cubicTo(r100, r101, r102, r103, r110, r111);
        char r106 = 0;
        PathMeasure r107 = new PathMeasure(r105, false);
        float[] r108 = new float[2];
        double r109 = this.startX;
        double r113 = this.startY;
        int r114 = this.segments;
        if (1 > r114) goto L15;
        double r115 = r109;
        double r116 = r113;
        int r117 = 1;
    L9:
        float r118 = (r107.getLength() / this.segments) * r117;
        if (r118 >= r107.getLength()) goto L12;
        r107.getPosTan(r118, r108, null);
        int r213 = r117;
        this.opList.add(new Op(r115, r116, r108[r106], r108[r112]));
        r106 = 0;
        double r119 = r108[0];
        int r120 = r114;
        r115 = r119;
        r116 = r108[1];
        int r121 = r213;
    L13:
        if (r121 == r120) goto L15;
        r114 = r120;
        r117 = r121 + 1;
        r112 = 1;
        goto L9
    L12:
        r121 = r117;
        r120 = r114;
    L15:
        this.startX = r311;
        this.startY = r312;
        return;
    L19:
        return;
    }
}
