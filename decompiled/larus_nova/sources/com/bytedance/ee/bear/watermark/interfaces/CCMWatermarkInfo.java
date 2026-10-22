package com.bytedance.ee.bear.watermark.interfaces;

import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes18.dex */
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
        this.bgColor = String.valueOf(R.color.lkui_transparent);
        this.alpha = "0.1";
        this.globalWatermark = Boolean.FALSE.toString();
        this.dark_opacity = "0.08";
        this.font_size = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
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

    public static CCMWatermarkInfo build(WatermarkInfo r100) {
        CCMWatermarkInfo r101 = new CCMWatermarkInfo();
        if (r100 == null) goto L5;
        r101.alpha = String.valueOf(r100.getAlpha());
        r101.bgColor = String.valueOf(r100.getBgColor());
        r101.dark_opacity = String.valueOf(r100.getDark_opacity());
        r101.density = String.valueOf(r100.getDensity());
        r101.watermarkTag = r100.getWatermarkTag();
        r101.font_size = String.valueOf(r100.getFont_size());
        r101.rotate_angle = String.valueOf(r100.getRotate_angle());
        r101.watermarkContent = r100.getWatermarkContent();
        r101.content = r100.getContent();
    L5:
        return r101;
    }

    public void setAlpha(String r100) {
        this.alpha = r100;
    }

    public void setBgColor(String r100) {
        this.bgColor = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setDark_opacity(String r100) {
        this.dark_opacity = r100;
    }

    public void setDensity(String r100) {
        this.density = r100;
    }

    public void setFont_size(String r100) {
        this.font_size = r100;
    }

    public void setGlobalWatermark(String r100) {
        this.globalWatermark = r100;
    }

    public void setRotate_angle(String r100) {
        this.rotate_angle = r100;
    }

    public void setWatermarkContent(String r100) {
        this.watermarkContent = r100;
    }

    public void setWatermarkTag(String r100) {
        this.watermarkTag = r100;
    }
}
