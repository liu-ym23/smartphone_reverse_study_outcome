package ps7;

import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Camera f530441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f530442b;

    public final void a() {
        if (this.f530442b.f530456l == null) goto L11;
        JSONObject r100 = new JSONObject();
        r100.put2(com.heytap.mcssdk.constant.b.C, "2.3.43");
        r100.put2("device-name", Build.MODEL);
        r100.put2("data-source", "antfincloud-production-android-2");
        d r101 = this.f530442b;
        r101.f530454j = r100.toJSONString();
        d r102 = this.f530442b;
        r102.f530456l.onSuccess(r102.f530454j);
    L11:
        this.f530441a.startPreview();     // Catch: Throwable -> L7
    L9:
        this.f530442b.f530456l = null;
        return;
    L7:
        th = move-exception;
        this.f530442b.f530456l.onError("", Log.getStackTraceString(th), "stopPreviewError");
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(d r100, Camera r101) {
        this.f530442b = r100;
        this.f530441a = r101;
    }
}
