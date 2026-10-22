package com.bytedance.ee.bear.watermark.interfaces;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.watermark.dto.WatermarkInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CCMWatermarkInfo implements NonProguard {
    private String alpha;
    private String bgColor;
    private String content;
    private String dark_opacity;
    private String density;
    private String font_size;
    private String globalWatermark;
    private String rotate_angle;
    private String watermarkContent;
    private String watermarkTag;

    public CCMWatermarkInfo() {
        this.bgColor = String.valueOf(2131103546);
        this.alpha = "0.1";
        this.globalWatermark = Boolean.FALSE.toString();
        this.dark_opacity = "0.08";
        this.font_size = "14";
        this.rotate_angle = "-15";
        this.density = "1";
    }

    public String getAlpha() {
        return this.alpha;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public String getContent() {
        return this.content;
    }

    public String getDark_opacity() {
        return this.dark_opacity;
    }

    public String getDensity() {
        return this.density;
    }

    public String getFont_size() {
        return this.font_size;
    }

    public String getGlobalWatermark() {
        return this.globalWatermark;
    }

    public String getRotate_angle() {
        return this.rotate_angle;
    }

    public String getWatermarkContent() {
        return this.watermarkContent;
    }

    public String getWatermarkTag() {
        return this.watermarkTag;
    }

    public static CCMWatermarkInfo build(WatermarkInfo r2) {
        CCMWatermarkInfo r0 = new CCMWatermarkInfo();
        if (r2 == null) goto L5;
        r0.alpha = String.valueOf(r2.getAlpha());
        r0.bgColor = String.valueOf(r2.getBgColor());
        r0.dark_opacity = String.valueOf(r2.getDark_opacity());
        r0.density = String.valueOf(r2.getDensity());
        r0.watermarkTag = r2.getWatermarkTag();
        r0.font_size = String.valueOf(r2.getFont_size());
        r0.rotate_angle = String.valueOf(r2.getRotate_angle());
        r0.watermarkContent = r2.getWatermarkContent();
        r0.content = r2.getContent();
    L5:
        return r0;
    }

    public void setAlpha(String r1) {
        this.alpha = r1;
    }

    public void setBgColor(String r1) {
        this.bgColor = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setDark_opacity(String r1) {
        this.dark_opacity = r1;
    }

    public void setDensity(String r1) {
        this.density = r1;
    }

    public void setFont_size(String r1) {
        this.font_size = r1;
    }

    public void setGlobalWatermark(String r1) {
        this.globalWatermark = r1;
    }

    public void setRotate_angle(String r1) {
        this.rotate_angle = r1;
    }

    public void setWatermarkContent(String r1) {
        this.watermarkContent = r1;
    }

    public void setWatermarkTag(String r1) {
        this.watermarkTag = r1;
    }
}
