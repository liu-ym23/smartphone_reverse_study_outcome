package l84;

import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LightLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.notification.SubmitNotification;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ long e;
    public final /* synthetic */ k f;

    public class a implements LightLocationCallback {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // com.bytedance.bdlocation.callback.LightLocationCallback
        public final void onError(String r3, String r4) {
            Logger.i("getLightLocation parseLocInfoRsp:" + r4 + "--code:" + r3);
            if (BDLocationException.ERROR_LIGHT_LOCATION_WIFI_LIST_ALREADY_UPLOAD.equals(r3) == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            LocationMonitor.doLightLocationError(r3, r4, this.a.d, r0);
            return;
        L5:
            if (BDLocationConfig.enableLightLocationNewPolicy() == false) goto L7;
            SubmitNotification.getInstance().executeLightLocationSubmitNotification();
            r0 = true;
            goto L8
        }

        @Override // com.bytedance.bdlocation.callback.LightLocationCallback
        public final void onSuccess(LocationResp r19, LocationUploadExtra r20) {
            if (r19 != null) goto L6;
            LocationMonitor.doLightLocationError(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO, "LocationResp is null", this.a.d, false);
            Logger.i("getLightLocation parseLocInfoRsp error : result is null");
            return;
        L6:
            int r3 = r19.resultCode;
            if (r3 == 0) goto L10;
            LocationMonitor.doLightLocationError(String.valueOf(r3), r19.resultMsg, this.a.d, false);
            Logger.i("getLightLocation parseLocInfoRsp error:" + r19.toString());
            return;
        L10:
            SubmitNotification.getInstance().executeLightLocationSubmitNotification();
            long r7 = System.currentTimeMillis() - this.a.c;
            Logger.i("getLightLocation total Duration：" + r7 + "--geCellDuration:" + r20.getCurrentStationDuration() + "--submitDuration:" + r20.getLightSubmitDuration() + "--appColdBootToStartLocationDuration:" + this.a.e);
            LocationMonitor.doLightLocation(this.a.e, r7, r20.getCurrentStationDuration(), r20.getLightSubmitDuration(), true, BDLocationException.SUCCESS, "", this.a.d, true);
        }
    }

    public final void a() {
        LocationUtil.checkBpeaCertNull("getLightLocation", this.a);     // Catch: BDLocationException -> L9
        LocationUploadExtra r1 = new LocationUploadExtra();     // Catch: BDLocationException -> L9
        if (this.f.e(this.a) == false) goto L6;
        this.f.k.checkAndTranslateCert(this.a, "getLightLocation");     // Catch: BDLocationException -> L9
        r1.setUploadSource(this.f.k.getBpeaToken(this.a));     // Catch: BDLocationException -> L9
    L7:
        r1.setStartLocationTime(this.c);     // Catch: BDLocationException -> L9
        LocationUtil.startLightLocationUpload(this.d, r1, this.a, new a(this));     // Catch: BDLocationException -> L9
        return;
    L6:
        r1.setUploadSource(this.b);     // Catch: BDLocationException -> L9
    L9:
        e = move-exception;
        LocationMonitor.doLightLocationError(e.getCode(), e.getMessage(), this.d, false);
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

    public j(k r1, Object r2, String r3, long r4, boolean r6, long r7) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
    }
}
