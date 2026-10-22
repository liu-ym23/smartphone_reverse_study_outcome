package com.ss.android.ttvecamera.focusmanager;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Build;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFocusSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class TEFocusManager {
    public static final List<String> FOCUS_BLOCK_LIST = null;
    protected final float FOCUS_AREA_DELTA;
    protected final int FOCUS_RADIUS;
    protected final float METERING_AREA_DELTA;
    int mCameraFacing;
    private int mCameraType;
    private List<Camera.Area> mFocusAreas;
    private List<Camera.Area> mMeteringAreas;

    static {
        ArrayList r100 = new ArrayList();
        FOCUS_BLOCK_LIST = r100;
        r100.add("multilaser");
        r100.add("ms40");
    }

    public TEFocusManager(int r100) {
        this.FOCUS_RADIUS = 90;
        this.FOCUS_AREA_DELTA = 1.0f;
        this.METERING_AREA_DELTA = 2.0f;
        this.mCameraType = r100;
        this.mFocusAreas = new ArrayList();
        this.mMeteringAreas = new ArrayList();
    }

    public boolean isSupportedFocus(Camera.Parameters r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (FOCUS_BLOCK_LIST.contains(Build.BRAND.toLowerCase()) == true) goto L8;
        if (r100.getMaxNumFocusAreas() <= 0) goto L8;
        return true;
    }

    public boolean isSupportedFocus(Camera.Parameters r100, String r101) {
        if (isSupportedFocus(r100) == true) goto L7;
        return false;
    L7:
        return r100.getSupportedFocusModes().contains(r101);
    }

    public boolean isSupportedMetering(int r100, Camera.Parameters r101) {
        if (r101 != null) goto L4;
    L6:
        return false;
    L4:
        if (r101.getMaxNumMeteringAreas() <= 0) goto L6;
        return true;
    }

    public String selectFocusMode(int r100, Camera.Parameters r101, boolean r102) {
        if (r101 != null) goto L5;
        return "";
    L5:
        this.mCameraFacing = r100;
        List<String> r103 = r101.getSupportedFocusModes();
        if (r100 != 1) goto L18;
        if (r102 == true) goto L9;
    L11:
        String r104 = "macro";
        if (r103.contains("macro") == true) goto L29;
        if (r103.contains("auto") == true) goto L26;
        return "";
    L26:
        return "auto";
    L29:
        return r104;
    L9:
        if (r103.contains("continuous-video") == false) goto L11;
        return "continuous-video";
    L18:
        if (r103.contains("continuous-video") == true) goto L28;
        r104 = "continuous-picture";
        if (r103.contains("continuous-picture") == true) goto L29;
        if (r103.contains("auto") == true) goto L26;
        return "";
    L28:
        return "continuous-video";
    }

    public List<Camera.Area> calculateFocusArea(int r110, int r111, float r112, int r113, int r114, int r115, TEFocusSettings.CoordinatesMode r116) {
        Rect r100 = calculateTapArea(r110, r111, r112, 90.0f, r113, r114, r115, r116);
        if (this.mFocusAreas.size() <= 0) goto L5;
        this.mFocusAreas.clear();
    L5:
        this.mFocusAreas.add(new Camera.Area(r100, 1000));
        return this.mFocusAreas;
    }

    public List<Camera.Area> calculateMeteringArea(int r110, int r111, float r112, int r113, int r114, int r115, TEFocusSettings.CoordinatesMode r116) {
        Rect r100 = calculateTapArea(r110, r111, r112, 180.0f, r113, r114, r115, r116);
        if (this.mMeteringAreas.size() <= 0) goto L5;
        this.mMeteringAreas.clear();
    L5:
        this.mMeteringAreas.add(new Camera.Area(r100, 1000));
        return this.mMeteringAreas;
    }

    public Rect calculateTapArea(int r100, int r101, float r102, float r103, int r104, int r105, int r110, TEFocusSettings.CoordinatesMode r111) {
        int r106 = Float.valueOf((r102 * r103) + 0.5f).intValue();
        int r107 = ((int) (((r104 * 2000) * 1.0f) / r100)) - 1000;
        int r108 = ((int) (((r105 * 2000) * 1.0f) / r101)) - 1000;
        if (this.mCameraFacing == 1) goto L5;
    L7:
        int r109 = r106 / 2;
        int r112 = TECameraUtils.clamp(r107 - r109, -1000, 1000);
        int r113 = TECameraUtils.clamp(r108 - r109, -1000, 1000);
        Rect r114 = new Rect();
        RectF r115 = new RectF(r112, r113, TECameraUtils.clamp(r112 + r106), TECameraUtils.clamp(r113 + r106));
        Rect r116 = new Rect(Math.round(r115.left), Math.round(r115.top), Math.round(r115.right), Math.round(r115.bottom));
        Rect r117 = new Rect(-1000, -1000, 1000, 1000);
        if (r111 != TEFocusSettings.CoordinatesMode.VIEW) goto L11;
        TECameraUtils.rotateRectForOrientation(r110, r117, r116);
        r114 = new Rect(r116.left - 1000, r116.top - 1000, r116.right - 1000, r116.bottom - 1000);
    L13:
        r114.left = TECameraUtils.clamp(r114.left);
        r114.right = TECameraUtils.clamp(r114.right);
        r114.top = TECameraUtils.clamp(r114.top);
        r114.bottom = TECameraUtils.clamp(r114.bottom);
        return r114;
    L11:
        if (r111 != TEFocusSettings.CoordinatesMode.ORIGINAL_FRAME) goto L13;
        r114 = new Rect(r116.left, r116.top, r116.right, r116.bottom);
        goto L13
    L5:
        if (r111 != TEFocusSettings.CoordinatesMode.VIEW) goto L7;
        r107 = -r107;
        goto L7
    }
}
