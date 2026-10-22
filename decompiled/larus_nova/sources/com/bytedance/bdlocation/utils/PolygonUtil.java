package com.bytedance.bdlocation.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class PolygonUtil {
    private List<PointF> vertices;

    public static class Builder {
        private List<PointF> vertices;

        public PolygonUtil build() {
            if (this.vertices.size() < 3) goto L7;
            return new PolygonUtil(this.vertices);
        L7:
            throw new RuntimeException("Polygon must have at least 3 points");
        }

        public Builder() {
            this.vertices = new ArrayList();
        }

        public Builder addVertice(PointF r100) {
            this.vertices.add(r100);
            return this;
        }
    }

    public static Builder Builder() {
        return new Builder();
    }

    public Path getPolygonPath() {
        Path r100 = new Path();
        Iterator<PointF> r101 = this.vertices.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L10;
        PointF r103 = r101.next();
        if (r102 != 0) goto L8;
        r100.moveTo(r103.x, r103.y);
    L9:
        r102 = r102 + 1;
        goto L4
    L8:
        r100.lineTo(r103.x, r103.y);
        goto L9
    L10:
        r100.close();
        return r100;
    }

    public PolygonUtil() {
        this.vertices = new ArrayList();
    }

    public List<PointF> getVertices() {
        return this.vertices;
    }

    public PolygonUtil(List<PointF> r100) {
        this.vertices = r100;
    }

    public boolean contains(List<PointF> r100) {
        Iterator<PointF> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (contains(r101.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public void setVertices(List<PointF> r100) {
        this.vertices = r100;
    }

    public boolean contains(PointF r100) {
        return isPointInPolygon(r100, this.vertices);
    }

    public static boolean isPointInPolygon(PointF r110, List<PointF> r111) {
        int r100 = r111.size() - 1;
        int r101 = 0;
        boolean r102 = false;
    L4:
        if (r101 >= r111.size()) goto L18;
        if (((PointF) ListProtector.get(r111, r101)).y < r110.y) goto L8;
        boolean r103 = true;
    L10:
        if (((PointF) ListProtector.get(r111, r100)).y < r110.y) goto L12;
        boolean r104 = true;
    L13:
        if (r103 == r104) goto L17;
        if (r110.x > ((((((PointF) ListProtector.get(r111, r100)).x - ((PointF) ListProtector.get(r111, r101)).x) * (r110.y - ((PointF) ListProtector.get(r111, r101)).y)) / (((PointF) ListProtector.get(r111, r100)).y - ((PointF) ListProtector.get(r111, r101)).y)) + ((PointF) ListProtector.get(r111, r101)).x)) goto L17;
        r102 = !r102;
    L17:
        r100 = r101;
        r101 = r101 + 1;
        goto L4
    L12:
        r104 = false;
        goto L13
    L8:
        r103 = false;
        goto L10
    L18:
        return r102;
    }
}
