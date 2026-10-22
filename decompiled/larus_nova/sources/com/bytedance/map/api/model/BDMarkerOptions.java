package com.bytedance.map.api.model;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes21.dex */
public class BDMarkerOptions {
    private float mAlpha;
    private float mAnchorX;
    private float mAnchorY;
    private boolean mClickable;
    private boolean mCollideWithPoi;
    private Object mData;
    private boolean mDraggable;
    private boolean mEnableCustomView;
    private Bitmap mIcon;
    private String mId;
    private boolean mInfoWindowEnable;
    private BDLatLng mLatLng;
    private int mOffSetY;
    private int mOffsetX;
    private float mRotateAngle;
    private Point mScreenPoint;
    private boolean mShowInfoWindow;
    private String mSnippet;
    private String mTitle;
    private View mView;
    private float mZIndex;

    public BDMarkerOptions() {
        this.mAnchorX = 0.5f;
        this.mAnchorY = 0.5f;
        this.mRotateAngle = 0.0f;
        this.mAlpha = 1.0f;
        this.mDraggable = false;
        this.mZIndex = 0.0f;
        this.mClickable = true;
        this.mInfoWindowEnable = false;
        this.mShowInfoWindow = false;
        this.mCollideWithPoi = false;
        this.mTitle = "";
        this.mSnippet = "";
        this.mOffsetX = 0;
        this.mOffSetY = 0;
        this.mEnableCustomView = false;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorX() {
        return this.mAnchorX;
    }

    public float getAnchorY() {
        return this.mAnchorY;
    }

    public Object getData() {
        return this.mData;
    }

    public Bitmap getIcon() {
        return this.mIcon;
    }

    public String getId() {
        return this.mId;
    }

    public BDLatLng getLatLng() {
        return this.mLatLng;
    }

    public int getOffSetY() {
        return this.mOffSetY;
    }

    public int getOffsetX() {
        return this.mOffsetX;
    }

    public float getRotateAngle() {
        return this.mRotateAngle;
    }

    public Point getScreenPoint() {
        return this.mScreenPoint;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public View getView() {
        return this.mView;
    }

    public float getZIndex() {
        return this.mZIndex;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public boolean isCollideWithPoi() {
        return this.mCollideWithPoi;
    }

    public boolean isDraggable() {
        return this.mDraggable;
    }

    public boolean isEnableCustomView() {
        return this.mEnableCustomView;
    }

    public boolean isInfoWindowEnable() {
        return this.mInfoWindowEnable;
    }

    public boolean isShowInfoWindow() {
        return this.mShowInfoWindow;
    }

    public void setAlpha(float r100) {
        this.mAlpha = r100;
    }

    public void setAnchorX(float r100) {
        this.mAnchorX = r100;
    }

    public void setAnchorY(float r100) {
        this.mAnchorY = r100;
    }

    public void setClickable(boolean r100) {
        this.mClickable = r100;
    }

    public void setCollideWithPoi(boolean r100) {
        this.mCollideWithPoi = r100;
    }

    public void setData(Object r100) {
        this.mData = r100;
    }

    public void setDraggable(boolean r100) {
        this.mDraggable = r100;
    }

    public void setEnableCustomView(boolean r100) {
        this.mEnableCustomView = r100;
    }

    public void setIcon(Bitmap r100) {
        this.mIcon = r100;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public void setInfoWindowEnable(boolean r100) {
        this.mInfoWindowEnable = r100;
    }

    public void setLatLng(BDLatLng r100) {
        this.mLatLng = r100;
    }

    public void setOffSetY(int r100) {
        this.mOffSetY = r100;
    }

    public void setOffsetX(int r100) {
        this.mOffsetX = r100;
    }

    public void setRotateAngle(float r100) {
        this.mRotateAngle = r100;
    }

    public void setScreenPoint(Point r100) {
        this.mScreenPoint = r100;
    }

    public void setShowInfoWindow(boolean r100) {
        this.mShowInfoWindow = r100;
    }

    public void setSnippet(String r100) {
        this.mSnippet = r100;
    }

    public void setTitle(String r100) {
        this.mTitle = r100;
    }

    public void setView(View r100) {
        this.mView = r100;
    }

    public void setZIndex(float r100) {
        this.mZIndex = r100;
    }

    public BDMarkerOptions(BDLatLng r100, Bitmap r101, View r102, float r103, float r104, boolean r105, float r106, float r110, float r111, boolean r112, String r113) {
        this.mInfoWindowEnable = false;
        this.mShowInfoWindow = false;
        this.mCollideWithPoi = false;
        this.mTitle = "";
        this.mSnippet = "";
        this.mOffsetX = 0;
        this.mOffSetY = 0;
        this.mEnableCustomView = false;
        this.mLatLng = r100;
        this.mIcon = r101;
        this.mView = r102;
        this.mRotateAngle = r103;
        this.mAlpha = r104;
        this.mDraggable = r105;
        this.mAnchorX = r106;
        this.mAnchorY = r110;
        this.mZIndex = r111;
        this.mClickable = r112;
        this.mId = r113;
    }

    public BDMarkerOptions(Point r110, Bitmap r111, View r112, float r113, float r114, boolean r115, float r210, float r211, float r212, boolean r213, String r214, boolean r215) {
        this(new BDLatLng(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE), r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, r215);
        this.mScreenPoint = r110;
    }

    public BDMarkerOptions(BDLatLng r100, Bitmap r101, View r102, float r103, float r104, boolean r105, float r106, float r107, float r108, boolean r110, String r111, boolean r112) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
        this.mEnableCustomView = r112;
    }
}
