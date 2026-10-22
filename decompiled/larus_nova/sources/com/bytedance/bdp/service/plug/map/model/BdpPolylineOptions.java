package com.bytedance.bdp.service.plug.map.model;

import android.graphics.Bitmap;
import androidx.camera.video.AudioStats;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class BdpPolylineOptions {
    public final Bitmap arrowIcon;
    public final boolean arrowLine;
    public final int borderColor;
    public final double borderWidth;
    public final int color;
    public final List<Integer> colorList;
    public final boolean dottedLine;
    public final List<BdpLatLng> points;
    public final double width;

    public static final class Builder {
        public Bitmap arrowIcon;
        public boolean arrowLine;
        public int borderColor;
        public double borderWidth;
        private int color;
        private List<Integer> colorList;
        private boolean dottedLine;
        private List<BdpLatLng> points;
        private double width;

        public static Builder builder() {
            return new Builder();
        }

        public BdpPolylineOptions build() {
            return new BdpPolylineOptions(this.points, this.color, this.width, this.dottedLine, this.borderWidth, this.borderColor, this.colorList, this.arrowLine, this.arrowIcon);
        }

        public Builder() {
            this.borderWidth = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.borderColor = -16777216;
            this.arrowIcon = null;
        }

        public Builder arrowIcon(Bitmap r100) {
            this.arrowIcon = r100;
            return this;
        }

        public Builder arrowLine(boolean r100) {
            this.arrowLine = r100;
            return this;
        }

        public Builder borderColor(int r100) {
            this.borderColor = r100;
            return this;
        }

        public Builder borderWidth(double r100) {
            this.borderWidth = r100;
            return this;
        }

        public Builder color(int r100) {
            this.color = r100;
            return this;
        }

        public Builder colorList(List<Integer> r100) {
            this.colorList = r100;
            return this;
        }

        public Builder dottedLine(boolean r100) {
            this.dottedLine = r100;
            return this;
        }

        public Builder points(List<BdpLatLng> r100) {
            this.points = r100;
            return this;
        }

        public Builder width(double r100) {
            this.width = r100;
            return this;
        }
    }

    public boolean hasColorList() {
        List<Integer> r100 = this.colorList;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L7;
        return true;
    }

    public BdpPolylineOptions(List<BdpLatLng> r100, int r101, double r102, boolean r103, double r104, int r105, List<Integer> r106, boolean r110, Bitmap r111) {
        this.points = r100;
        this.color = r101;
        this.width = r102;
        this.dottedLine = r103;
        this.borderWidth = r104;
        this.borderColor = r105;
        this.colorList = r106;
        this.arrowLine = r110;
        this.arrowIcon = r111;
    }
}
