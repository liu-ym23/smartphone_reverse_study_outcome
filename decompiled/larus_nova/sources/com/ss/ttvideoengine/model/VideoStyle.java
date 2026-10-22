package com.ss.ttvideoengine.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class VideoStyle {
    public static final int DIMENSION_2D = 0;
    public static final int DIMENSION_3D_SIDE_BY_SIDE = 2;
    public static final int DIMENSION_3D_TOP_AND_BUTTOM = 1;
    private static final String KEY_DIMENSION = "dimension";
    private static final String KEY_PROJECTION_MODEL = "projection_model";
    private static final String KEY_VIDEO_STYLE = "vstyle";
    private static final String KEY_VIEW_SIZE = "view_size";
    public static final int PROJECTION_MODEL_CUBEMAP = 2;
    public static final int PROJECTION_MODEL_ERP = 1;
    public static final int PROJECTION_MODEL_NORMAL = 0;
    public static final int PROJECTION_MODEL_OFFSET_CUBEMAP = 3;
    public static final int VALUE_DIMENSION = 1;
    public static final int VALUE_PROJECTION_MODEL = 2;
    public static final int VALUE_VIDEO_STYLE = 0;
    public static final int VALUE_VIEW_SIZE = 3;
    public static final int VIDEO_STYLE_NORMAL = 0;
    public static final int VIDEO_STYLE_VR = 1;
    private int mDimension;
    private int mProjectionModel;
    private int mVideoStyle;
    private int mViewSize;

    public VideoStyle() {
        this.mVideoStyle = 0;
        this.mDimension = 0;
        this.mProjectionModel = 0;
        this.mViewSize = 0;
    }

    public void extractFields(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mVideoStyle = r100.optInt(KEY_VIDEO_STYLE, 0);
        this.mDimension = r100.optInt(KEY_DIMENSION, 0);
        this.mProjectionModel = r100.optInt(KEY_PROJECTION_MODEL, 0);
        this.mViewSize = r100.optInt("view_size", 0);
    }

    public int getValueInt(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return -1;
    L12:
        return this.mViewSize;
    L14:
        return this.mProjectionModel;
    L16:
        return this.mDimension;
    L18:
        return this.mVideoStyle;
    }
}
