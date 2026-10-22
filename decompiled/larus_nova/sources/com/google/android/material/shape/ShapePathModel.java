package com.google.android.material.shape;

/* JADX INFO: loaded from: classes23.dex */
public class ShapePathModel {
    private static final CornerTreatment DEFAULT_CORNER_TREATMENT = null;
    private static final EdgeTreatment DEFAULT_EDGE_TREATMENT = null;
    private EdgeTreatment bottomEdge;
    private CornerTreatment bottomLeftCorner;
    private CornerTreatment bottomRightCorner;
    private EdgeTreatment leftEdge;
    private EdgeTreatment rightEdge;
    private EdgeTreatment topEdge;
    private CornerTreatment topLeftCorner;
    private CornerTreatment topRightCorner;

    static {
        DEFAULT_CORNER_TREATMENT = new CornerTreatment();
        DEFAULT_EDGE_TREATMENT = new EdgeTreatment();
    }

    public ShapePathModel() {
        CornerTreatment r100 = DEFAULT_CORNER_TREATMENT;
        this.topLeftCorner = r100;
        this.topRightCorner = r100;
        this.bottomRightCorner = r100;
        this.bottomLeftCorner = r100;
        EdgeTreatment r101 = DEFAULT_EDGE_TREATMENT;
        this.topEdge = r101;
        this.rightEdge = r101;
        this.bottomEdge = r101;
        this.leftEdge = r101;
    }

    public EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    public CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    public CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    public EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    public EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    public EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    public CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    public CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    public void setAllCorners(CornerTreatment r100) {
        this.topLeftCorner = r100;
        this.topRightCorner = r100;
        this.bottomRightCorner = r100;
        this.bottomLeftCorner = r100;
    }

    public void setAllEdges(EdgeTreatment r100) {
        this.leftEdge = r100;
        this.topEdge = r100;
        this.rightEdge = r100;
        this.bottomEdge = r100;
    }

    public void setBottomEdge(EdgeTreatment r100) {
        this.bottomEdge = r100;
    }

    public void setBottomLeftCorner(CornerTreatment r100) {
        this.bottomLeftCorner = r100;
    }

    public void setBottomRightCorner(CornerTreatment r100) {
        this.bottomRightCorner = r100;
    }

    public void setLeftEdge(EdgeTreatment r100) {
        this.leftEdge = r100;
    }

    public void setRightEdge(EdgeTreatment r100) {
        this.rightEdge = r100;
    }

    public void setTopEdge(EdgeTreatment r100) {
        this.topEdge = r100;
    }

    public void setTopLeftCorner(CornerTreatment r100) {
        this.topLeftCorner = r100;
    }

    public void setTopRightCorner(CornerTreatment r100) {
        this.topRightCorner = r100;
    }

    public void setCornerTreatments(CornerTreatment r100, CornerTreatment r101, CornerTreatment r102, CornerTreatment r103) {
        this.topLeftCorner = r100;
        this.topRightCorner = r101;
        this.bottomRightCorner = r102;
        this.bottomLeftCorner = r103;
    }

    public void setEdgeTreatments(EdgeTreatment r100, EdgeTreatment r101, EdgeTreatment r102, EdgeTreatment r103) {
        this.leftEdge = r100;
        this.topEdge = r101;
        this.rightEdge = r102;
        this.bottomEdge = r103;
    }
}
