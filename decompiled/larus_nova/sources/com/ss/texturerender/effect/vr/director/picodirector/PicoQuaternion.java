package com.ss.texturerender.effect.vr.director.picodirector;

import com.ss.texturerender.math.Quaternion;
import com.ss.texturerender.math.Vector3d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class PicoQuaternion {
    private static Vector3d mCameraForward;
    private static float mFieldView;
    private static ArrayList<Integer> mSubIndexArray;
    private static Quaternion mVRQuaternion;

    public PicoQuaternion() {
    }

    static {
        mSubIndexArray = new ArrayList();
    }

    public static Vector3d getCameraForward() {
        return mCameraForward;
    }

    public static float getFieldView() {
        return mFieldView;
    }

    public static ArrayList<Integer> getSubIndexArray() {
        return mSubIndexArray;
    }

    public static Quaternion getVRQuaternion() {
        return mVRQuaternion;
    }

    public static void updateVRSubIndex(int[] r100, int r101) {
        mSubIndexArray.clear();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        mSubIndexArray.add(Integer.valueOf(r100[r102]));
        r102 = r102 + 1;
        goto L3
    }

    public static void updateVRCameraForaward(float r100, float r101, float r110, float r111) {
        mCameraForward = new Vector3d(r100, r101, r110);
        mFieldView = r111;
    }

    public static void updateVRQuaternion(float r110, float r111, float r112, float r113, int r114) {
        double r100 = r110;
        double r101 = r111;
        if (r114 != 1) goto L5;
        double r115 = r112;
    L6:
        mVRQuaternion = new Quaternion(r100, r101, r115, r113);
        return;
    L5:
        r115 = -r112;
        goto L6
    }
}
