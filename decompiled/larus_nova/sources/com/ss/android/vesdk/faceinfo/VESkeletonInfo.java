package com.ss.android.vesdk.faceinfo;

import android.graphics.PointF;
import android.graphics.RectF;
import com.ss.android.ttve.nativePort.e;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class VESkeletonInfo {
    private VESkeleton[] info;
    private int orient;

    public String toString() {
        return "VESkeletonInfo{orient=" + this.orient + ", info=" + Arrays.toString(this.info) + '}';
    }

    public VESkeletonInfo() {
        this.orient = 0;
    }

    public VESkeleton[] getInfo() {
        return this.info;
    }

    public int getOrient() {
        return this.orient;
    }

    public static VESkeletonInfo convert(byte[][] r110) {
        VESkeleton[] r100 = null;
        if (r110 != null) goto L5;
    L21:
        return null;
    L5:
        if (r110.length <= 0) goto L21;
        e r101 = new e(r110[0]);
        VESkeletonInfo r111 = new VESkeletonInfo();
        r111.setOrient(r101.c());
        int r102 = r101.c();
        if (r102 <= 0) goto L10;
        r100 = new VESkeleton[r102];
    L10:
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L19;
        VESkeleton r104 = new VESkeleton();
        r104.setID(r101.c());
        r104.setRect(new RectF(r101.b(), r101.b(), r101.b(), r101.b()));
        int r105 = r101.c();
        if (r105 <= 0) goto L18;
        PointF[] r106 = new PointF[r105];
        int r107 = 0;
    L15:
        if (r107 >= r105) goto L17;
        r106[r107] = new PointF(r101.c(), r101.c());
        r101.a();
        r101.b();
        r107 = r107 + 1;
        goto L15
    L17:
        r104.setPoints(r106);
    L18:
        r100[r103] = r104;
        r103 = r103 + 1;
        goto L11
    L19:
        r111.setInfo(r100);
        return r111;
    }

    public void setInfo(VESkeleton[] r100) {
        this.info = r100;
    }

    public void setOrient(int r100) {
        this.orient = r100;
    }

    public static VESkeletonInfo convert(byte[] r110) {
        VESkeleton[] r100 = null;
        if (r110 != null) goto L5;
    L21:
        return null;
    L5:
        if (r110.length <= 0) goto L21;
        e r101 = new e(r110);
        VESkeletonInfo r111 = new VESkeletonInfo();
        r111.setOrient(r101.c());
        int r102 = r101.c();
        if (r102 <= 0) goto L10;
        r100 = new VESkeleton[r102];
    L10:
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L19;
        VESkeleton r104 = new VESkeleton();
        r104.setID(r101.c());
        r104.setRect(new RectF(r101.b(), r101.b(), r101.b(), r101.b()));
        int r105 = r101.c();
        if (r105 <= 0) goto L18;
        PointF[] r106 = new PointF[r105];
        int r107 = 0;
    L15:
        if (r107 >= r105) goto L17;
        r106[r107] = new PointF(r101.b(), r101.b());
        r101.c();
        r101.b();
        r107 = r107 + 1;
        goto L15
    L17:
        r104.setPoints(r106);
    L18:
        r100[r103] = r104;
        r103 = r103 + 1;
        goto L11
    L19:
        r111.setInfo(r100);
        return r111;
    }

    public static VESkeletonInfo convert(SkeletonInfo r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        VESkeletonInfo r101 = new VESkeletonInfo();
        VESkeleton[] r102 = new VESkeleton[r100.getInfo().length];
        Skeleton[] r103 = r100.getInfo();
        int r104 = r103.length;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r105 >= r104) goto L8;
        Skeleton r107 = r103[r105];
        VESkeleton r108 = new VESkeleton();
        r108.setID(r107.getID());
        r108.setRect(r107.getRect());
        r108.setPoints(r107.getPoints());
        r102[r106] = r108;
        r105 = r105 + 1;
        r106 = r106 + 1;
        goto L6
    L8:
        r101.setInfo(r102);
        return r101;
    }
}
