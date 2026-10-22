package com.bytedance.bdlocation.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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

        public Builder addVertice(PointF r2) {
            this.vertices.add(r2);
            return this;
        }
    }

    public static Builder Builder() {
        return new Builder();
    }

    public Path getPolygonPath() {
        Path r0 = new Path();
        Iterator<PointF> r1 = this.vertices.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L10;
        PointF r3 = r1.next();
        if (r2 != 0) goto L8;
        r0.moveTo(r3.x, r3.y);
    L9:
        r2 = r2 + 1;
        goto L4
    L8:
        r0.lineTo(r3.x, r3.y);
        goto L9
    L10:
        r0.close();
        return r0;
    }

    public PolygonUtil() {
        this.vertices = new ArrayList();
    }

    public List<PointF> getVertices() {
        return this.vertices;
    }

    public PolygonUtil(List<PointF> r1) {
        this.vertices = r1;
    }

    public boolean contains(List<PointF> r2) {
        Iterator<PointF> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (contains(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public void setVertices(List<PointF> r1) {
        this.vertices = r1;
    }

    public boolean contains(PointF r2) {
        return isPointInPolygon(r2, this.vertices);
    }

    public static boolean isPointInPolygon(PointF r10, List<PointF> r11) {
        int r3 = r11.size() - 1;
        int r0 = 0;
        boolean r4 = false;
    L4:
        if (r0 >= r11.size()) goto L18;
        if (((PointF) ListProtector.get(r11, r0)).y < r10.y) goto L8;
        boolean r5 = true;
    L10:
        if (((PointF) ListProtector.get(r11, r3)).y < r10.y) goto L12;
        boolean r6 = true;
    L13:
        if (r5 == r6) goto L17;
        if (r10.x > ((((((PointF) ListProtector.get(r11, r3)).x - ((PointF) ListProtector.get(r11, r0)).x) * (r10.y - ((PointF) ListProtector.get(r11, r0)).y)) / (((PointF) ListProtector.get(r11, r3)).y - ((PointF) ListProtector.get(r11, r0)).y)) + ((PointF) ListProtector.get(r11, r0)).x)) goto L17;
        r4 = !r4;
    L17:
        r3 = r0;
        r0 = r0 + 1;
        goto L4
    L12:
        r6 = false;
        goto L13
    L8:
        r5 = false;
        goto L10
    L18:
        return r4;
    }
}
