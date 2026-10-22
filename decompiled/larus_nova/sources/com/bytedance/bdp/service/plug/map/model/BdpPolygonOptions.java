package com.bytedance.bdp.service.plug.map.model;

import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class BdpPolygonOptions {
    public int fillColor;
    public List<BdpLatLng> points;
    public int strokeColor;
    public float strokeWidth;
    public float zIndex;

    /* JADX INFO: renamed from: com.bytedance.bdp.service.plug.map.model.BdpPolygonOptions$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private int fillColor;
        private List<BdpLatLng> points;
        private int strokeColor;
        private float strokeWidth;
        private float zIndex;

        public Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public BdpPolygonOptions build() {
            return new BdpPolygonOptions(this.points, this.strokeWidth, this.strokeColor, this.fillColor, this.zIndex, null);
        }

        public Builder fillColor(int r100) {
            this.fillColor = r100;
            return this;
        }

        public Builder points(List<BdpLatLng> r100) {
            this.points = r100;
            return this;
        }

        public Builder strokeColor(int r100) {
            this.strokeColor = r100;
            return this;
        }

        public Builder strokeWidth(float r100) {
            this.strokeWidth = r100;
            return this;
        }

        public Builder zIndex(float r100) {
            this.zIndex = r100;
            return this;
        }
    }

    private BdpPolygonOptions(List<BdpLatLng> r100, float r101, int r102, int r103, float r104) {
        this.points = r100;
        this.strokeWidth = r101;
        this.strokeColor = r102;
        this.fillColor = r103;
        this.zIndex = r104;
    }

    public /* synthetic */ BdpPolygonOptions(List r100, float r101, int r102, int r103, float r104, AnonymousClass1 r105) {
        this(r100, r101, r102, r103, r104);
    }
}
