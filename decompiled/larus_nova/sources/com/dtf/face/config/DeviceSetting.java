package com.dtf.face.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceSetting {

    @JSONField(name = "algorithmAngle")
    public int algorithmAngle;

    @JSONField(name = "algorithmAuto")
    public boolean algorithmAuto;

    @JSONField(name = "cameraAuto")
    public boolean cameraAuto;

    @JSONField(name = "cameraID")
    public int cameraID;

    @JSONField(name = "displayAngle")
    public int displayAngle;

    @JSONField(name = "displayAuto")
    public boolean displayAuto;

    @JSONField(name = "height")
    public int height;

    @JSONField(name = "isp")
    public boolean isp;

    @JSONField(name = "maxApiLevel")
    public int maxApiLevel;

    @JSONField(name = "minApiLevel")
    public int minApiLevel;

    @JSONField(name = "slir")
    public boolean slir;

    @JSONField(name = "width")
    public int width;

    @JSONField(name = "widthAuto")
    public boolean widthAuto;

    @JSONField(name = GestureAction.zoom)
    public int zoom;

    public DeviceSetting() {
        this.displayAuto = true;
        this.displayAngle = 90;
        this.cameraAuto = true;
        this.cameraID = 1;
        this.algorithmAuto = true;
        this.algorithmAngle = 270;
        this.widthAuto = true;
        this.width = 640;
        this.height = 480;
        this.zoom = 0;
        this.maxApiLevel = 100;
        this.minApiLevel = 0;
        this.isp = false;
        this.slir = false;
    }

    public int getAlgorithmAngle() {
        return this.algorithmAngle;
    }

    public int getCameraID() {
        return this.cameraID;
    }

    public int getDisplayAngle() {
        return this.displayAngle;
    }

    public int getHeight() {
        return this.height;
    }

    public int getMaxApiLevel() {
        return this.maxApiLevel;
    }

    public int getMinApiLevel() {
        return this.minApiLevel;
    }

    public int getWidth() {
        return this.width;
    }

    public int getZoom() {
        return this.zoom;
    }

    public boolean isAlgorithmAuto() {
        return this.algorithmAuto;
    }

    public boolean isCameraAuto() {
        return this.cameraAuto;
    }

    public boolean isDisplayAuto() {
        return this.displayAuto;
    }

    public boolean isIsp() {
        return this.isp;
    }

    public boolean isSlir() {
        return this.slir;
    }

    public boolean isWidthAuto() {
        return this.widthAuto;
    }

    public void setAlgorithmAngle(int r100) {
        this.algorithmAngle = r100;
    }

    public void setAlgorithmAuto(boolean r100) {
        this.algorithmAuto = r100;
    }

    public void setCameraAuto(boolean r100) {
        this.cameraAuto = r100;
    }

    public void setCameraID(int r100) {
        this.cameraID = r100;
    }

    public void setDisplayAngle(int r100) {
        this.displayAngle = r100;
    }

    public void setDisplayAuto(boolean r100) {
        this.displayAuto = r100;
    }

    public DeviceSetting setHeight(int r100) {
        this.height = r100;
        return this;
    }

    public void setIsp(boolean r100) {
        this.isp = r100;
    }

    public void setMaxApiLevel(int r100) {
        this.maxApiLevel = r100;
    }

    public void setMinApiLevel(int r100) {
        this.minApiLevel = r100;
    }

    public void setSlir(boolean r100) {
        this.slir = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    public void setWidthAuto(boolean r100) {
        this.widthAuto = r100;
    }

    public void setZoom(int r100) {
        this.zoom = r100;
    }
}
