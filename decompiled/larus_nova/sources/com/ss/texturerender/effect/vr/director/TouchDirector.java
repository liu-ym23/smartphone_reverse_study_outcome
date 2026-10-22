package com.ss.texturerender.effect.vr.director;

import android.opengl.Matrix;
import android.os.Bundle;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class TouchDirector extends GestureDetector.SimpleOnGestureListener implements IDirector {
    private DeviceOrientation mDeviceOriToScreenOri;
    private DeviceOrientation mDeviceOrientation;
    private float mDiffX;
    private float mDiffY;
    private Display mDisplay;
    private float mRadius;
    private float[] mRotationMatrix;
    private boolean mSensorEnabled;

    /* JADX INFO: renamed from: com.ss.texturerender.effect.vr.director.TouchDirector$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation = null;

        static {
            int[] r100 = new int[DeviceOrientation.values().length];
            $SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation = r100;
            r100[DeviceOrientation.PORTRAIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation[DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation[DeviceOrientation.UPSIDE_DOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation[DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum DeviceOrientation extends Enum<DeviceOrientation> {
        private static final /* synthetic */ DeviceOrientation[] $VALUES = null;
        public static final DeviceOrientation LANDSCAPE_LEFT = null;
        public static final DeviceOrientation LANDSCAPE_RIGHT = null;
        public static final DeviceOrientation PORTRAIT = null;
        public static final DeviceOrientation UPSIDE_DOWN = null;

        static {
            DeviceOrientation r100 = new DeviceOrientation("PORTRAIT", 0);
            PORTRAIT = r100;
            DeviceOrientation r101 = new DeviceOrientation("LANDSCAPE_LEFT", 1);
            LANDSCAPE_LEFT = r101;
            DeviceOrientation r102 = new DeviceOrientation("UPSIDE_DOWN", 2);
            UPSIDE_DOWN = r102;
            DeviceOrientation r103 = new DeviceOrientation("LANDSCAPE_RIGHT", 3);
            LANDSCAPE_RIGHT = r103;
            $VALUES = new DeviceOrientation[]{r100, r101, r102, r103};
        }

        public static DeviceOrientation[] values() {
            return (DeviceOrientation[]) $VALUES.clone();
        }

        public static DeviceOrientation valueOf(String r100) {
            return (DeviceOrientation) a.a(DeviceOrientation.class, r100);
        }

        private DeviceOrientation(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void reset() {
        this.mDiffX = 0.0f;
        this.mDiffY = 0.0f;
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void setParam(Bundle r100) {
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void stop() {
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void start() {
        float[] r100 = new float[16];
        this.mRotationMatrix = r100;
        Matrix.setIdentityM(r100, 0);
    }

    public float getDiffX() {
        return this.mDiffX;
    }

    public float getDiffY() {
        return this.mDiffY;
    }

    public TouchDirector(Display r100) {
        this.mDiffX = 0.0f;
        this.mDiffY = 0.0f;
        this.mSensorEnabled = true;
        DeviceOrientation r101 = DeviceOrientation.PORTRAIT;
        this.mDeviceOrientation = r101;
        this.mDeviceOriToScreenOri = r101;
        this.mDisplay = r100;
    }

    public void setRadius(float r100) {
        this.mRadius = r100;
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void getView(float[] r100, int r101) {
        System.arraycopy(this.mRotationMatrix, 0, r100, r101, r100.length - r101);
    }

    public void updateDeviceOrientation(int r100, boolean r101) {
        this.mSensorEnabled = r101;
        if (r100 < 315) goto L7;
        if (r100 >= 360) goto L7;
    L9:
        this.mDeviceOrientation = DeviceOrientation.PORTRAIT;
    L22:
        if (this.mDisplay == null) goto L28;
        int r102 = this.mDeviceOrientation.ordinal() - this.mDisplay.getRotation();
        if (r102 >= 0) goto L26;
        r102 = r102 + DeviceOrientation.values().length;
    L26:
        this.mDeviceOriToScreenOri = DeviceOrientation.values()[r102];
        return;
    L28:
        return;
    L7:
        if (r100 < 0) goto L11;
        if (r100 < 45) goto L9;
    L11:
        if (r100 < 45) goto L15;
        if (r100 >= 135) goto L15;
        this.mDeviceOrientation = DeviceOrientation.LANDSCAPE_RIGHT;
    L15:
        if (r100 < 135) goto L18;
        if (r100 >= 225) goto L18;
        this.mDeviceOrientation = DeviceOrientation.UPSIDE_DOWN;
    L18:
        if (r100 < 225) goto L22;
        if (r100 >= 315) goto L22;
        this.mDeviceOrientation = DeviceOrientation.LANDSCAPE_LEFT;
        goto L22
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        float r104 = this.mRadius;
        float r105 = (float) ((((double) (r102 / r104)) / 3.141592653589793d) * 180.0d);
        float r106 = (float) ((((double) (r103 / r104)) / 3.141592653589793d) * 180.0d);
        if (this.mSensorEnabled == true) goto L6;
        this.mDiffX += r106;
        this.mDiffY += r105;
        return true;
    L6:
        int r107 = AnonymousClass1.$SwitchMap$com$ss$texturerender$effect$vr$director$TouchDirector$DeviceOrientation[this.mDeviceOriToScreenOri.ordinal()];
        if (r107 != 1) goto L9;
        this.mDiffX += r106;
        this.mDiffY += r105;
    L19:
        return true;
    L9:
        if (r107 != 2) goto L11;
        this.mDiffX += r105;
        this.mDiffY -= r106;
        goto L19
    L11:
        if (r107 != 3) goto L13;
        this.mDiffX -= r106;
        this.mDiffY -= r105;
        goto L19
    L13:
        if (r107 != 4) goto L19;
        this.mDiffX -= r105;
        this.mDiffY += r106;
        goto L19
    }
}
