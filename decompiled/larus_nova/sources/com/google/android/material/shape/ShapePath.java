package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class ShapePath {
    public float endX;
    public float endY;
    private final List<PathOperation> operations;
    public float startX;
    public float startY;

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = null;
        public float bottom;
        public float left;
        public float right;
        public float startAngle;
        public float sweepAngle;
        public float top;

        static {
            rectF = new RectF();
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix r100, Path r101) {
            Matrix r102 = this.matrix;
            r100.invert(r102);
            r101.transform(r102);
            RectF r103 = rectF;
            r103.set(this.left, this.top, this.right, this.bottom);
            r101.arcTo(r103, this.startAngle, this.sweepAngle, false);
            r101.transform(r100);
        }

        public PathArcOperation(float r100, float r101, float r102, float r103) {
            this.left = r100;
            this.top = r101;
            this.right = r102;
            this.bottom = r103;
        }
    }

    public static class PathLineOperation extends PathOperation {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private float f274676x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private float f274677y;

        public PathLineOperation() {
        }

        public static /* synthetic */ float access$002(PathLineOperation r100, float r101) {
            r100.f274676x = r101;
            return r101;
        }

        public static /* synthetic */ float access$102(PathLineOperation r100, float r101) {
            r100.f274677y = r101;
            return r101;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix r100, Path r101) {
            Matrix r102 = this.matrix;
            r100.invert(r102);
            r101.transform(r102);
            r101.lineTo(this.f274676x, this.f274677y);
            r101.transform(r100);
        }
    }

    public static abstract class PathOperation {
        protected final Matrix matrix;

        public abstract void applyToPath(Matrix r100, Path r101);

        public PathOperation() {
            this.matrix = new Matrix();
        }
    }

    public static class PathQuadOperation extends PathOperation {
        public float controlX;
        public float controlY;
        public float endX;
        public float endY;

        public PathQuadOperation() {
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix r100, Path r101) {
            Matrix r102 = this.matrix;
            r100.invert(r102);
            r101.transform(r102);
            r101.quadTo(this.controlX, this.controlY, this.endX, this.endY);
            r101.transform(r100);
        }
    }

    public ShapePath() {
        this.operations = new ArrayList();
        reset(0.0f, 0.0f);
    }

    public ShapePath(float r100, float r101) {
        this.operations = new ArrayList();
        reset(r100, r101);
    }

    public void applyToPath(Matrix r100, Path r101) {
        int r102 = this.operations.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((PathOperation) ListProtector.get(this.operations, r103)).applyToPath(r100, r101);
        r103 = r103 + 1;
        goto L3
    }

    public void lineTo(float r100, float r101) {
        PathLineOperation r102 = new PathLineOperation();
        PathLineOperation.access$002(r102, r100);
        PathLineOperation.access$102(r102, r101);
        this.operations.add(r102);
        this.endX = r100;
        this.endY = r101;
    }

    public void reset(float r100, float r101) {
        this.startX = r100;
        this.startY = r101;
        this.endX = r100;
        this.endY = r101;
        this.operations.clear();
    }

    public void quadToPoint(float r100, float r101, float r102, float r103) {
        PathQuadOperation r104 = new PathQuadOperation();
        r104.controlX = r100;
        r104.controlY = r101;
        r104.endX = r102;
        r104.endY = r103;
        this.operations.add(r104);
        this.endX = r102;
        this.endY = r103;
    }

    public void addArc(float r100, float r101, float r102, float r103, float r104, float r110) {
        PathArcOperation r105 = new PathArcOperation(r100, r101, r102, r103);
        r105.startAngle = r104;
        r105.sweepAngle = r110;
        this.operations.add(r105);
        double r106 = r104 + r110;
        this.endX = ((r100 + r102) * 0.5f) + (((r102 - r100) / 2.0f) * ((float) Math.cos(Math.toRadians(r106))));
        this.endY = ((r101 + r103) * 0.5f) + (((r103 - r101) / 2.0f) * ((float) Math.sin(Math.toRadians(r106))));
    }
}
