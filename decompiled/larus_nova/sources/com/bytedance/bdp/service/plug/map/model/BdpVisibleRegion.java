package com.bytedance.bdp.service.plug.map.model;

/* JADX INFO: loaded from: classes11.dex */
public class BdpVisibleRegion {
    public BdpLatLng leftBottom;
    public final BdpLatLng leftTop;
    public final BdpLatLng rightBottom;
    public final BdpLatLng rightTop;

    public static final class Builder {
        private BdpLatLng leftBottom;
        private BdpLatLng leftTop;
        private BdpLatLng rightBottom;
        private BdpLatLng rightTop;

        public static Builder builder() {
            return new Builder();
        }

        public BdpVisibleRegion build() {
            return new BdpVisibleRegion(this.leftTop, this.rightTop, this.rightBottom, this.leftBottom);
        }

        public Builder() {
        }

        public Builder leftBottom(BdpLatLng r100) {
            if (r100 == null) goto L6;
            this.leftBottom = r100;
            return this;
        L6:
            throw null;
        }

        public Builder leftTop(BdpLatLng r100) {
            if (r100 == null) goto L6;
            this.leftTop = r100;
            return this;
        L6:
            throw null;
        }

        public Builder rightBottom(BdpLatLng r100) {
            if (r100 == null) goto L6;
            this.rightBottom = r100;
            return this;
        L6:
            throw null;
        }

        public Builder rightTop(BdpLatLng r100) {
            if (r100 == null) goto L6;
            this.rightTop = r100;
            return this;
        L6:
            throw null;
        }
    }

    public BdpVisibleRegion(BdpLatLng r100, BdpLatLng r101, BdpLatLng r102, BdpLatLng r103) {
        this.leftTop = r100;
        this.rightTop = r101;
        this.rightBottom = r102;
        this.leftBottom = r103;
    }
}
