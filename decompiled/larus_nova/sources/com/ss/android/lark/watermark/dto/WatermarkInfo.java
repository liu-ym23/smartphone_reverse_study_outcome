package com.ss.android.lark.watermark.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.nova.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class WatermarkInfo implements Parcelable {
    public static final Parcelable.Creator<WatermarkInfo> CREATOR = null;
    private float alpha;
    private int bgColor;
    private String content;
    private float dark_opacity;
    private int density;
    private int font_size;
    private boolean globalWatermark;
    private float opacity;
    private int rotate_angle;
    private String watermarkContent;
    private String watermarkTag;

    public static class Builder {
        private float alpha;
        private int bgColor;
        private String content;
        private float dark_opacity;
        private int density;
        private int font_size;
        private boolean globalWatermark;
        private float opacity;
        private int rotate_angle;
        private String watermarkContent;
        private String watermarkTag;

        public WatermarkInfo build() {
            return new WatermarkInfo(this.watermarkContent, this.watermarkTag, this.bgColor, this.alpha, this.globalWatermark, this.opacity, this.dark_opacity, this.font_size, this.rotate_angle, this.density, this.content, null);
        }

        public Builder(String r100) {
            this.bgColor = R.color.lkui_transparent;
            this.alpha = 0.1f;
            this.globalWatermark = false;
            this.dark_opacity = 0.08f;
            this.opacity = 0.12f;
            this.font_size = 14;
            this.rotate_angle = -15;
            this.density = 1;
            this.watermarkContent = r100;
            this.watermarkTag = r100;
        }

        public Builder alpha(float r100) {
            this.alpha = r100;
            return this;
        }

        public Builder alphaDarkMode(float r100) {
            this.dark_opacity = this.dark_opacity;
            return this;
        }

        public Builder bgColor(int r100) {
            this.bgColor = r100;
            return this;
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder density(int r100) {
            this.density = r100;
            return this;
        }

        public Builder fontSize(int r100) {
            this.font_size = r100;
            return this;
        }

        public Builder opacity(float r100) {
            this.opacity = r100;
            return this;
        }

        public Builder rotateAngle(int r100) {
            this.rotate_angle = r100;
            return this;
        }

        public Builder tag(String r100) {
            this.watermarkTag = r100;
            return this;
        }

        public Builder watermarkStrategy(boolean r100) {
            this.globalWatermark = r100;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String getInfo() {
        return "WatermarkInfo{watermarkContent='" + this.watermarkContent + ", watermarkTag='" + this.watermarkTag + ", bgColor=" + this.bgColor + ", alpha=" + this.alpha + ", globalWatermark=" + this.globalWatermark + ", opacity=" + this.opacity + ", opacityDarkMode=" + this.dark_opacity + ", fontSize=" + this.font_size + ", rotateAngle=" + this.rotate_angle + ", density=" + this.density + ", content=" + this.content + '}';
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.watermarkContent, this.watermarkTag, Integer.valueOf(this.bgColor), Float.valueOf(this.alpha), Float.valueOf(this.opacity), Float.valueOf(this.dark_opacity), Integer.valueOf(this.font_size), Integer.valueOf(this.rotate_angle), Integer.valueOf(this.density), this.content});
    }

    public String toString() {
        return "WatermarkInfo{bgColor=" + this.bgColor + ", alpha=" + this.alpha + ", globalWatermark=" + this.globalWatermark + ", opacity=" + this.opacity + ", opacityDarkMode=" + this.dark_opacity + ", fontSize=" + this.font_size + ", rotateAngle=" + this.rotate_angle + ", density=" + this.density + '}';
    }

    public WatermarkInfo() {
        this.bgColor = R.color.lkui_transparent;
        this.alpha = 0.1f;
        this.globalWatermark = false;
        this.opacity = 0.12f;
        this.dark_opacity = 0.08f;
        this.font_size = 14;
        this.rotate_angle = -15;
        this.density = 1;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public String getContent() {
        return this.content;
    }

    public float getDark_opacity() {
        return this.dark_opacity;
    }

    public int getDensity() {
        return this.density;
    }

    public int getFont_size() {
        return this.font_size;
    }

    public float getOpacity() {
        return this.opacity;
    }

    public int getRotate_angle() {
        return this.rotate_angle;
    }

    public String getWatermarkContent() {
        return this.watermarkContent;
    }

    public String getWatermarkTag() {
        return this.watermarkTag;
    }

    public boolean isGlobalWatermark() {
        return this.globalWatermark;
    }

    public WatermarkInfo(Parcel r100) {
        this.bgColor = R.color.lkui_transparent;
        this.alpha = 0.1f;
        boolean r101 = false;
        this.globalWatermark = false;
        this.opacity = 0.12f;
        this.dark_opacity = 0.08f;
        this.font_size = 14;
        this.rotate_angle = -15;
        this.density = 1;
        this.watermarkContent = r100.readString();
        this.watermarkTag = r100.readString();
        this.bgColor = r100.readInt();
        this.alpha = r100.readFloat();
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.globalWatermark = r101;
        this.opacity = r100.readFloat();
        this.dark_opacity = r100.readFloat();
        this.font_size = r100.readInt();
        this.rotate_angle = r100.readInt();
        this.density = r100.readInt();
        this.content = r100.readString();
    }

    public void setAlpha(float r100) {
        this.alpha = r100;
    }

    public void setBgColor(int r100) {
        this.bgColor = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setDark_opacity(float r100) {
        this.dark_opacity = r100;
    }

    public void setDensity(int r100) {
        this.density = r100;
    }

    public void setFont_size(int r100) {
        this.font_size = r100;
    }

    public void setGlobalWatermark(boolean r100) {
        this.globalWatermark = r100;
    }

    public void setOpacity(float r100) {
        this.opacity = r100;
    }

    public void setRotate_angle(int r100) {
        this.rotate_angle = r100;
    }

    public void setWatermarkContent(String r100) {
        this.watermarkContent = r100;
    }

    public void setWatermarkTag(String r100) {
        this.watermarkTag = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.watermarkContent);
        r100.writeString(this.watermarkTag);
        r100.writeInt(this.bgColor);
        r100.writeFloat(this.alpha);
        r100.writeByte(this.globalWatermark ? 1 : 0);
        r100.writeFloat(this.opacity);
        r100.writeFloat(this.dark_opacity);
        r100.writeInt(this.font_size);
        r100.writeInt(this.rotate_angle);
        r100.writeInt(this.density);
        r100.writeString(this.content);
    }

    private WatermarkInfo(String r100, String r101, int r102, float r103, boolean r104, float r105, float r106, int r107, int r108, int r110, String r111) {
        this.watermarkContent = r100;
        this.watermarkTag = r101;
        this.bgColor = r102;
        this.alpha = r103;
        this.globalWatermark = r104;
        this.opacity = r105;
        this.dark_opacity = r106;
        this.font_size = r107;
        this.rotate_angle = r108;
        this.density = r110;
        this.content = r111;
    }

    public /* synthetic */ WatermarkInfo(String r100, String r101, int r102, float r103, boolean r104, float r105, float r106, int r107, int r108, int r110, String r111, AnonymousClass1 r112) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
    }
}
