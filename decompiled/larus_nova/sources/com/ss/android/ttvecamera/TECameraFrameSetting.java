package com.ss.android.ttvecamera;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraFrameSetting {
    private float fovX;
    private float fovY;
    private boolean isDependSurfaceTimestamp;
    private boolean isFromMockFixedFrameCapture;
    private boolean isMatchFrameHandleFps;
    private int mAeState;
    private int mAfState;
    private Bitmap mBitmap;
    private byte[] mBufferData;
    private int mBufferSize;
    private int mCameraFacing;
    private int mCameraFormat;
    private int mCameraFrameHeight;
    private int mCameraFrameWidth;
    private int mCameraOutputMode;
    private int mCameraRotation;
    private int mCameraTextureID;
    private float mCurrentZoom;
    private Bitmap mDirectBitmap;
    private int mExposureTime;
    private int mExtRotate;
    private int mFlashState;
    private int[] mIntBufferData;
    private int mIso;
    private float[] mMVPMatrix;
    private int mMaxIso;
    private HashMap<String, Object> mMetadataMap;
    private int mMinIso;
    private String mTextureDesc;
    private ByteBuffer mUBuf;
    private int[] mUParams;
    private ByteBuffer mVBuf;
    private int[] mVParams;
    private ByteBuffer mYBuf;
    private int[] mYParams;
    private long timestampInNS;

    public float[] getFov() {
        return new float[]{this.fovX, this.fovY};
    }

    public void release() {
        Bitmap r100 = this.mBitmap;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRecycled() == true) goto L9;
        this.mBitmap.recycle();
        return;
    }

    public int getAeState() {
        return this.mAeState;
    }

    public int getAfState() {
        return this.mAfState;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public byte[] getBufferData() {
        return this.mBufferData;
    }

    public int getBufferDataSize() {
        return this.mBufferSize;
    }

    public int getCameraFacing() {
        return this.mCameraFacing;
    }

    public int getCameraFormat() {
        return this.mCameraFormat;
    }

    public int getCameraFrameHeight() {
        return this.mCameraFrameHeight;
    }

    public int getCameraFrameWidth() {
        return this.mCameraFrameWidth;
    }

    public int getCameraOutPutMode() {
        return this.mCameraOutputMode;
    }

    public int getCameraRotation() {
        return this.mCameraRotation;
    }

    public int getCameraTextureID() {
        return this.mCameraTextureID;
    }

    public float getCurrentZoom() {
        return this.mCurrentZoom;
    }

    public Bitmap getDirectBitmap() {
        return this.mDirectBitmap;
    }

    public int getExposureTime() {
        return this.mExposureTime;
    }

    public int getExtRotate() {
        return this.mExtRotate;
    }

    public int getFlashState() {
        return this.mFlashState;
    }

    public int[] getIntBufferData() {
        return this.mIntBufferData;
    }

    public boolean getIsFromMockFixedFrameCapture() {
        return this.isFromMockFixedFrameCapture;
    }

    public int getIso() {
        return this.mIso;
    }

    public float[] getMVPMatrix() {
        return this.mMVPMatrix;
    }

    public int getMaxIso() {
        return this.mMaxIso;
    }

    public HashMap<String, Object> getMetadata() {
        return this.mMetadataMap;
    }

    public int getMinIso() {
        return this.mMinIso;
    }

    public String getTextureDesc() {
        return this.mTextureDesc;
    }

    public long getTimestampInNS() {
        return this.timestampInNS;
    }

    public ByteBuffer getUBuffer() {
        return this.mUBuf;
    }

    public int[] getUParams() {
        return this.mUParams;
    }

    public ByteBuffer getVBuffer() {
        return this.mVBuf;
    }

    public int[] getVParams() {
        return this.mVParams;
    }

    public ByteBuffer getYBuffer() {
        return this.mYBuf;
    }

    public int[] getYParams() {
        return this.mYParams;
    }

    public boolean isDependSurfaceTimestamp() {
        return this.isDependSurfaceTimestamp;
    }

    public boolean isMatchFrameHandleFps() {
        return this.isMatchFrameHandleFps;
    }

    public void setCameraFrameWidth(int r100) {
        this.mCameraFrameWidth = r100;
    }

    public void setCameraOutPutMode(int r100) {
        this.mCameraOutputMode = r100;
    }

    public void setCameraRotation(int r100) {
        this.mCameraRotation = r100;
    }

    public void setCameraTextureID(int r100) {
        this.mCameraTextureID = r100;
    }

    public void setDependSurfaceTimestamp(boolean r100) {
        this.isDependSurfaceTimestamp = r100;
    }

    public void setDirectBitmap(Bitmap r100) {
        this.mDirectBitmap = r100;
    }

    public void setEnableMatchFrameHandleFps(boolean r100) {
        this.isMatchFrameHandleFps = r100;
    }

    public void setIsFromMockFixedFrameCapture(boolean r100) {
        this.isFromMockFixedFrameCapture = r100;
    }

    public void setMVPMatrix(float[] r100) {
        this.mMVPMatrix = r100;
    }

    public void setMetadata(HashMap<String, Object> r100) {
        this.mMetadataMap = r100;
        this.mAeState = ((Integer) r100.get("aeState")).intValue();
        this.mAfState = ((Integer) r100.get("afState")).intValue();
        this.mFlashState = ((Integer) r100.get("flashState")).intValue();
        this.mCurrentZoom = ((Float) r100.get("currentZoom")).floatValue();
        this.fovX = ((Float) r100.get("fovX")).floatValue();
        this.fovY = ((Float) r100.get("fovY")).floatValue();
    }

    public void setTimestampInNS(long r100) {
        this.timestampInNS = r100;
    }

    public void setmCameraFacing(int r100) {
        this.mCameraFacing = r100;
    }

    public void setmCameraFrameHeight(int r100) {
        this.mCameraFrameHeight = r100;
    }

    public TECameraFrameSetting(Bitmap r100, int r101, int r102, int r103, int r104) {
        this.mExposureTime = 0;
        this.mMaxIso = 0;
        this.mMinIso = 0;
        this.mIso = 0;
        this.mAeState = -1;
        this.mAfState = -1;
        this.mFlashState = -1;
        this.mCurrentZoom = 1.0f;
        this.fovX = -1.0f;
        this.fovY = -1.0f;
        this.mDirectBitmap = null;
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.timestampInNS = 0;
        this.isFromMockFixedFrameCapture = false;
        this.mBitmap = r100;
        this.mBufferData = null;
        this.mIntBufferData = null;
        this.mBufferSize = r100.getByteCount();
        this.mCameraFrameWidth = r101;
        this.mCameraFrameHeight = r102;
        this.mCameraRotation = r103;
        this.mCameraFormat = r104;
    }

    public TECameraFrameSetting(String r100, int r101, int r102, int r103, int r104) {
        this.mExposureTime = 0;
        this.mMaxIso = 0;
        this.mMinIso = 0;
        this.mIso = 0;
        this.mAeState = -1;
        this.mAfState = -1;
        this.mFlashState = -1;
        this.mCurrentZoom = 1.0f;
        this.fovX = -1.0f;
        this.fovY = -1.0f;
        this.mDirectBitmap = null;
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.timestampInNS = 0;
        this.isFromMockFixedFrameCapture = false;
        this.mTextureDesc = r100;
        this.mCameraFrameWidth = r101;
        this.mCameraFrameHeight = r102;
        this.mCameraRotation = r103;
        this.mCameraFormat = r104;
    }

    public TECameraFrameSetting(byte[] r100, int r101, int r102, int r103, int r104, int r110) {
        this.mExposureTime = 0;
        this.mMaxIso = 0;
        this.mMinIso = 0;
        this.mIso = 0;
        this.mAeState = -1;
        this.mAfState = -1;
        this.mFlashState = -1;
        this.mCurrentZoom = 1.0f;
        this.fovX = -1.0f;
        this.fovY = -1.0f;
        this.mDirectBitmap = null;
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.timestampInNS = 0;
        this.isFromMockFixedFrameCapture = false;
        this.mBitmap = null;
        this.mBufferData = r100;
        this.mIntBufferData = null;
        this.mBufferSize = r101;
        this.mCameraFrameWidth = r102;
        this.mCameraFrameHeight = r103;
        this.mCameraRotation = r104;
        this.mCameraFormat = r110;
    }

    public TECameraFrameSetting(int[] r100, int r101, int r102, int r103, int r104, int r110) {
        this.mExposureTime = 0;
        this.mMaxIso = 0;
        this.mMinIso = 0;
        this.mIso = 0;
        this.mAeState = -1;
        this.mAfState = -1;
        this.mFlashState = -1;
        this.mCurrentZoom = 1.0f;
        this.fovX = -1.0f;
        this.fovY = -1.0f;
        this.mDirectBitmap = null;
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.timestampInNS = 0;
        this.isFromMockFixedFrameCapture = false;
        this.mBitmap = null;
        this.mBufferData = null;
        this.mIntBufferData = r100;
        this.mBufferSize = r101;
        this.mCameraFrameWidth = r102;
        this.mCameraFrameHeight = r103;
        this.mCameraRotation = r104;
        this.mCameraFormat = r110;
    }

    public TECameraFrameSetting(int r100, int r101, int r102, int r103, int r104, byte[] r105, int r110, int r111) {
        this.mExposureTime = 0;
        this.mMaxIso = 0;
        this.mMinIso = 0;
        this.mIso = 0;
        this.mAeState = -1;
        this.mAfState = -1;
        this.mFlashState = -1;
        this.mCurrentZoom = 1.0f;
        this.fovX = -1.0f;
        this.fovY = -1.0f;
        this.mDirectBitmap = null;
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.timestampInNS = 0;
        this.isFromMockFixedFrameCapture = false;
        this.mCameraOutputMode = r100;
        this.mCameraFrameWidth = r101;
        this.mCameraFrameHeight = r102;
        this.mCameraRotation = r103;
        this.mCameraFacing = r104;
        this.mBufferData = r105;
        this.mCameraFormat = r110;
        this.mBufferSize = r111;
    }

    public TECameraFrameSetting(int r100, int r101, int r102, int r103, int r104, float[] r105, int r110, int r111, int r112) {
        this.mExposureTime = 0;
        this.mMaxIso = 0;
        this.mMinIso = 0;
        this.mIso = 0;
        this.mAeState = -1;
        this.mAfState = -1;
        this.mFlashState = -1;
        this.mCurrentZoom = 1.0f;
        this.fovX = -1.0f;
        this.fovY = -1.0f;
        this.mDirectBitmap = null;
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.timestampInNS = 0;
        this.isFromMockFixedFrameCapture = false;
        this.mCameraTextureID = r100;
        this.mCameraOutputMode = r101;
        this.mCameraFrameWidth = r102;
        this.mCameraFrameHeight = r103;
        this.mCameraRotation = r104;
        this.mMVPMatrix = r105;
        this.mCameraFacing = r110;
        this.mCameraFormat = r111;
        this.mExtRotate = r112;
    }

    public TECameraFrameSetting(int r100, int r101, int r102, int r103, int r104, float[] r105, int r110, byte[] r111, int r112) {
        this.mExposureTime = 0;
        this.mMaxIso = 0;
        this.mMinIso = 0;
        this.mIso = 0;
        this.mAeState = -1;
        this.mAfState = -1;
        this.mFlashState = -1;
        this.mCurrentZoom = 1.0f;
        this.fovX = -1.0f;
        this.fovY = -1.0f;
        this.mDirectBitmap = null;
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.timestampInNS = 0;
        this.isFromMockFixedFrameCapture = false;
        this.mCameraTextureID = r100;
        this.mCameraOutputMode = r101;
        this.mCameraFrameWidth = r102;
        this.mCameraFrameHeight = r103;
        this.mCameraRotation = r104;
        this.mMVPMatrix = r105;
        this.mCameraFacing = r110;
        this.mBufferData = r111;
        this.mCameraFormat = r112;
    }

    public TECameraFrameSetting(ByteBuffer r100, int[] r101, ByteBuffer r102, int[] r103, ByteBuffer r104, int[] r105, int r110, int r111, int r112, int r113) {
        this.mExposureTime = 0;
        this.mMaxIso = 0;
        this.mMinIso = 0;
        this.mIso = 0;
        this.mAeState = -1;
        this.mAfState = -1;
        this.mFlashState = -1;
        this.mCurrentZoom = 1.0f;
        this.fovX = -1.0f;
        this.fovY = -1.0f;
        this.mDirectBitmap = null;
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.timestampInNS = 0;
        this.isFromMockFixedFrameCapture = false;
        this.mYBuf = r100;
        this.mUBuf = r102;
        this.mVBuf = r104;
        this.mYParams = r101;
        this.mUParams = r103;
        this.mVParams = r105;
        this.mCameraFrameWidth = r110;
        this.mCameraFrameHeight = r111;
        this.mCameraRotation = r112;
        this.mCameraFormat = r113;
    }

    public TECameraFrameSetting(int r100, int r101, int r102, int r103, int r104, ByteBuffer r105, int[] r110, ByteBuffer r111, int[] r112, ByteBuffer r113, int[] r114, int r115) {
        this.mExposureTime = 0;
        this.mMaxIso = 0;
        this.mMinIso = 0;
        this.mIso = 0;
        this.mAeState = -1;
        this.mAfState = -1;
        this.mFlashState = -1;
        this.mCurrentZoom = 1.0f;
        this.fovX = -1.0f;
        this.fovY = -1.0f;
        this.mDirectBitmap = null;
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.timestampInNS = 0;
        this.isFromMockFixedFrameCapture = false;
        this.mCameraOutputMode = r100;
        this.mCameraFrameWidth = r101;
        this.mCameraFrameHeight = r102;
        this.mCameraRotation = r103;
        this.mCameraFacing = r104;
        this.mYBuf = r105;
        this.mUBuf = r111;
        this.mVBuf = r113;
        this.mYParams = r110;
        this.mUParams = r112;
        this.mVParams = r114;
        this.mCameraFormat = r115;
    }

    public TECameraFrameSetting(int r100, int r101, int r102, int r103, int r104, float[] r110, int r111, ByteBuffer r112, int[] r113, ByteBuffer r114, int[] r115, ByteBuffer r116, int[] r117, int r118) {
        this.mExposureTime = 0;
        this.mMaxIso = 0;
        this.mMinIso = 0;
        this.mIso = 0;
        this.mAeState = -1;
        this.mAfState = -1;
        this.mFlashState = -1;
        this.mCurrentZoom = 1.0f;
        this.fovX = -1.0f;
        this.fovY = -1.0f;
        this.mDirectBitmap = null;
        this.isDependSurfaceTimestamp = true;
        this.isMatchFrameHandleFps = false;
        this.timestampInNS = 0;
        this.isFromMockFixedFrameCapture = false;
        this.mCameraTextureID = r100;
        this.mCameraOutputMode = r101;
        this.mCameraFrameWidth = r102;
        this.mCameraFrameHeight = r103;
        this.mCameraRotation = r104;
        this.mMVPMatrix = r110;
        this.mCameraFacing = r111;
        this.mYBuf = r112;
        this.mUBuf = r114;
        this.mVBuf = r116;
        this.mYParams = r113;
        this.mUParams = r115;
        this.mVParams = r117;
        this.mCameraFormat = r118;
    }
}
