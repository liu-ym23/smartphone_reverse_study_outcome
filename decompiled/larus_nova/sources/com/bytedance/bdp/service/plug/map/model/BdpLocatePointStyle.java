package com.bytedance.bdp.service.plug.map.model;

import android.graphics.Bitmap;
import java.util.Arrays;
import java.util.HashSet;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public class BdpLocatePointStyle {
    public Bitmap locationIcon;
    public int radiusFillColor;
    public boolean showMyLocation;
    public int strokeColor;
    public float strokeWidth;
    private HashSet<Param> updateSet;

    public static final enum Param extends Enum<Param> {
        private static final /* synthetic */ Param[] $VALUES = null;
        public static final Param ICON = null;
        public static final Param RADIUS_FILL_COLOR = null;
        public static final Param SHOW_LOCATION = null;
        public static final Param STROKE_COLOR = null;
        public static final Param STROKE_WIDTH = null;

        static {
            Param r100 = new Param("ICON", 0);
            ICON = r100;
            Param r101 = new Param("STROKE_COLOR", 1);
            STROKE_COLOR = r101;
            Param r102 = new Param("STROKE_WIDTH", 2);
            STROKE_WIDTH = r102;
            Param r103 = new Param("RADIUS_FILL_COLOR", 3);
            RADIUS_FILL_COLOR = r103;
            Param r104 = new Param("SHOW_LOCATION", 4);
            SHOW_LOCATION = r104;
            $VALUES = new Param[]{r100, r101, r102, r103, r104};
        }

        public static Param[] values() {
            return (Param[]) $VALUES.clone();
        }

        public static Param valueOf(String r100) {
            return (Param) a.a(Param.class, r100);
        }

        private Param(String r100, int r101) {
            super(r100, r101);
        }
    }

    public BdpLocatePointStyle() {
        this.updateSet = new HashSet();
    }

    public int getRadiusFillColor() {
        return this.radiusFillColor;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public Bitmap getlocationIcon() {
        return this.locationIcon;
    }

    public boolean isShowMyLocation() {
        return this.showMyLocation;
    }

    public boolean isUpdate(Param r100) {
        return this.updateSet.contains(r100);
    }

    public BdpLocatePointStyle locationIcon(Bitmap r100) {
        this.locationIcon = r100;
        this.updateSet.add(Param.ICON);
        return this;
    }

    public BdpLocatePointStyle radiusFillColor(int r100) {
        this.radiusFillColor = r100;
        this.updateSet.add(Param.RADIUS_FILL_COLOR);
        return this;
    }

    public BdpLocatePointStyle showMyLocation(boolean r100) {
        this.showMyLocation = r100;
        this.updateSet.add(Param.SHOW_LOCATION);
        return this;
    }

    public BdpLocatePointStyle strokeColor(int r100) {
        this.strokeColor = r100;
        this.updateSet.add(Param.STROKE_COLOR);
        return this;
    }

    public BdpLocatePointStyle strokeWidth(float r100) {
        this.strokeWidth = r100;
        this.updateSet.add(Param.STROKE_WIDTH);
        return this;
    }

    public BdpLocatePointStyle(Bitmap r100, int r101, float r102, int r103, boolean r104) {
        HashSet<Param> r105 = new HashSet();
        this.updateSet = r105;
        this.locationIcon = r100;
        this.strokeColor = r101;
        this.strokeWidth = r102;
        this.radiusFillColor = r103;
        this.showMyLocation = r104;
        r105.addAll(Arrays.asList(Param.values()));
    }
}
