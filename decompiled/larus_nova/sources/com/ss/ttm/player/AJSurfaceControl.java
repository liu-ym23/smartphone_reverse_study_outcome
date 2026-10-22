package com.ss.ttm.player;

import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.HardwareBuffer;
import android.hardware.SyncFence;
import android.view.SurfaceControl;
import com.ss.ttm.utils.AVLogger;
import java.util.Locale;

/* JADX INFO: loaded from: classes40.dex */
public class AJSurfaceControl {
    private static final String TAG = "AJSurfaceControl";
    private int mBufferTransform;
    private Region mDamageRegion;
    private long mNativeHandler;
    private Rect mSourceCrop;
    private SurfaceControl mSurfaceControl;
    private SurfaceControl.Transaction mTransaction;

    private native void _onBufferRelease(long r100, long r101, SyncFence r102);

    public static /* synthetic */ void a(AJSurfaceControl r100, long r101, HardwareBuffer r102, SyncFence r103) {
        r100.lambda$draw$0(r101, r102, r103);
    }

    public void release() {
        AVLogger.Info(TAG, this, "release transaction = " + this.mTransaction);
        SurfaceControl.Transaction r100 = this.mTransaction;
        if (r100 == null) goto L5;
        r100.close();
        this.mTransaction = null;
    L5:
        this.mNativeHandler = 0;
    }

    public AJSurfaceControl() {
        this.mSourceCrop = new Rect(0, 0, 0, 0);
        this.mDamageRegion = new Region(0, 0, 0, 0);
        this.mBufferTransform = 0;
        this.mTransaction = new SurfaceControl.Transaction();
        AVLogger.Info(TAG, this, "init transaction = " + this.mTransaction);
    }

    public void setCallback(long r100) {
        AVLogger.Info(TAG, this, "set callback = " + String.format(Locale.US, "%x", new Object[]{Long.valueOf(r100)}));
        this.mNativeHandler = r100;
    }

    public void update(SurfaceControl r100) {
        AVLogger.Info(TAG, this, "update surface control = " + r100);
        SurfaceControl r101 = this.mSurfaceControl;
        if (r101 == null) goto L5;
        this.mTransaction.reparent(r101, null).apply();
        this.mSourceCrop.setEmpty();
        this.mDamageRegion.setEmpty();
        this.mBufferTransform = 0;
    L5:
        this.mSurfaceControl = r100;
    }

    private /* synthetic */ void lambda$draw$0(long r110, HardwareBuffer r111, SyncFence r112) {
        if (r112 != null) goto L4;
    L6:
        _onBufferRelease(this.mNativeHandler, r110, null);
    L7:
        if (r111 == null) goto L10;
        r111.close();
        return;
    L10:
        return;
    L4:
        if (r112.isValid() == false) goto L6;
        _onBufferRelease(this.mNativeHandler, r110, r112);
        goto L7
    }

    public void draw(final long r100, final HardwareBuffer r110, Rect r111, Rect r112, int r113) {
        if (this.mSurfaceControl != null) goto L5;
    L40:
        AVLogger.Error(TAG, this, "draw failed, invalid surface control or transaction");
        _onBufferRelease(this.mNativeHandler, r100, null);
        if (r110 == null) goto L44;
        r110.close();
        return;
    L44:
        return;
    L5:
        if (this.mTransaction == null) goto L40;
        if (r111 != null) goto L9;
    L10:
        if (r112 == null) goto L14;
        if (this.mDamageRegion.quickContains(r112) == true) goto L14;
    L16:
        if (r111 != null) goto L18;
    L27:
        Rect r101 = new Rect(0, 0, r110.getWidth(), r110.getHeight());
        int r102 = this.mBufferTransform;
        if (r102 == 4) goto L31;
        if (r102 == 7) goto L31;
    L32:
        AVLogger.Info(TAG, this, "set crop = " + r101);
        this.mTransaction.setCrop(this.mSurfaceControl, r101);
        this.mSourceCrop = new Rect(r111);
        if (r112 != null) goto L35;
    L37:
        AVLogger.Info(TAG, this, "set buffer transform = " + r113);
        this.mTransaction.setBufferTransform(this.mSurfaceControl, r113);
        this.mBufferTransform = r113;
    L38:
        this.mTransaction.setBuffer(this.mSurfaceControl, r110, null, new a(this, r100, r110)).apply();
        return;
    L35:
        if (r112.isEmpty() == true) goto L37;
        float r114 = (r112.width() * 1.0f) / r101.width();
        float r103 = (r112.height() * 1.0f) / r101.height();
        AVLogger.Info(TAG, this, "set scale = [" + r114 + "," + r103 + "]");
        this.mTransaction.setScale(this.mSurfaceControl, r114, r103);
        float r115 = r114 * ((float) r101.left);
        float r104 = r103 * ((float) r101.top);
        AVLogger.Info(TAG, this, "set position = [" + r115 + "," + r104 + "]");
        this.mTransaction.setPosition(this.mSurfaceControl, ((float) r112.left) - r115, ((float) r112.top) - r104);
        StringBuilder r116 = new StringBuilder("set damage region = ");
        r116.append(r112);
        AVLogger.Info(TAG, this, r116.toString());
        this.mTransaction.setDamageRegion(this.mSurfaceControl, new Region(r112));
        this.mDamageRegion = new Region(r112);
    L31:
        r101.right = r110.getHeight();
        r101.bottom = r110.getWidth();
        goto L32
    L18:
        if (r111.isEmpty() == true) goto L27;
        r101 = new Rect(r111);
        if (r113 == 3) goto L26;
        if (r113 == 4) goto L25;
        if (r113 != 7) goto L32;
        r101.left = r111.top;
        r101.top = r110.getWidth() - r111.right;
        r101.right = r101.left + r111.height();
        r101.bottom = r101.top + r111.width();
        goto L32
    L25:
        int r105 = r110.getHeight() - r111.bottom;
        r101.left = r105;
        r101.top = r111.left;
        r101.right = r105 + r111.height();
        r101.bottom = r101.top + r111.width();
        goto L32
    L26:
        r101.left = r110.getWidth() - r111.right;
        r101.top = r110.getHeight() - r111.bottom;
        r101.right = r101.left + r111.width();
        r101.bottom = r101.top + r111.height();
    L14:
        if (this.mBufferTransform == r113) goto L38;
    L9:
        if (this.mSourceCrop.equals(r111) == false) goto L16;
        goto L10
    }
}
