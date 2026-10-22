package com.ss.android.bytedcert.view.camera;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.ICertCompliance;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.event.EventLogUtils;
import org.json.JSONObject;
import wsa.b;

/* JADX INFO: loaded from: classes34.dex */
public class MyPreview extends SurfaceView implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f407806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wsa.a f407807b;

    public class a implements Camera.PictureCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f407808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MyPreview f407809b;

        public a(MyPreview r100, b r101) {
            this.f407809b = r100;
            this.f407808a = r101;
        }

        @Override // android.hardware.Camera.PictureCallback
        public final void onPictureTaken(byte[] r100, Camera r101) {
            CertLog.d("TakePicture", "in byted_take picture callback");
            wsa.a r102 = this.f407809b.f407807b;
            r102.getClass();
            Camera r103 = r102.f561110a;     // Catch: Exception -> L7
            if (r103 == null) goto L9;
            r103.stopPreview();     // Catch: Exception -> L7
        L9:
            MyPreview r104 = this.f407809b;
            r104.f407806a = false;
            b r105 = this.f407808a;
            if (r105 == null) goto L15;
            r105.l1(r100, r104.f407807b.f561111b.orientation);
            return;
        L15:
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L9
        }
    }

    public int getCamId() {
        this.f407807b.getClass();
        return wsa.a.f561109e;
    }

    public MyPreview(Context r100) {
        this(r100, null, 0);
    }

    public final void a(b r100) {
        wsa.a r101 = this.f407807b;
        a r102 = new a(this, r100);
        r101.getClass();
        EventLogUtils.onEvent(EventConstant.Event.ID_CARD_PHOTO_UPLOAD_CAMERA_BUTTON, new JSONObject());     // Catch: Exception -> L7
        Camera r103 = r101.f561110a;     // Catch: Exception -> L7
        if (r103 == null) goto L12;
        wsa.a.a(r103, r102);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        CertLog.d("MyPreview", "surfaceCreated");
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        CertLog.d("MyPreview", "surfaceDestroyed");
        wsa.a r101 = this.f407807b;
        r101.getClass();
        Camera r102 = r101.f561110a;     // Catch: Exception -> L10
        if (r102 == null) goto L12;
        r102.setPreviewCallback(null);     // Catch: Exception -> L10
        r101.f561110a.stopPreview();     // Catch: Exception -> L10
        ICertCompliance r103 = CertManager.getInstance().getCertCompliance();     // Catch: Exception -> L10
        if (r103 == null) goto L9;
        r103.releaseCamera(r101.f561110a);     // Catch: Exception -> L10
        r101.f561110a = null;     // Catch: Exception -> L10
        goto L12
    L9:
        throw new NullPointerException("cert compliance is null");     // Catch: Exception -> L10
    L12:
        this.f407806a = false;
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public MyPreview(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public MyPreview(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f407806a = false;
        this.f407807b = wsa.a.f561108d;
        SurfaceHolder r103 = getHolder();
        r103.addCallback(this);
        r103.setType(3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        CertLog.d("MyPreview", "surfaceChanged my preview w:" + r102 + " h:" + r103);
        if (this.f407806a == false) goto L12;
        wsa.a r104 = this.f407807b;
        r104.getClass();
        Camera r105 = r104.f561110a;     // Catch: Exception -> L9
        if (r105 == null) goto L11;
        r105.stopPreview();     // Catch: Exception -> L9
    L11:
        this.f407806a = false;
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        this.f407807b.b(r102, r103);
        wsa.a r106 = this.f407807b;
        r106.getClass();
        Camera r107 = r106.f561110a;     // Catch: Throwable -> L17
        if (r107 == null) goto L19;
        r107.setPreviewDisplay(r100);     // Catch: Throwable -> L17
        r106.f561110a.startPreview();     // Catch: Throwable -> L17
    L19:
        this.f407806a = true;
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        goto L19
    }
}
