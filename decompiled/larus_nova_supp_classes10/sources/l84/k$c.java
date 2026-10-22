package l84;

import android.text.TextUtils;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class k$c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ k d;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0079 -> B:55:0x0083). Please report as a decompilation issue!!! */
    public final void a() {
        if (TextUtils.isEmpty(this.a) == false) goto L6;
        Logger.w("BDLocationService.updatingNavigationLocationConfig ignored, businessId is null or empty");
        return;
    L6:
        Integer r0 = (Integer) ((HashMap) this.d.i).get(this.a);
        if (r0 != null) goto L10;
        Logger.w("BDLocationService.updatingNavigationLocationConfig ignored, businessId locate type not found: " + this.a);
        return;
    L10:
        LocationOption r1 = (LocationOption) ((HashMap) this.d.j).get(this.a);
        if (r1 != null) goto L14;
        Logger.w("BDLocationService.updatingNavigationLocationConfig ignored, option not found: " + this.a);
        return;
    L14:
        k r2 = this.d;
        String r3 = this.b;
        boolean r4 = this.c;
        r2.getClass();
        r1.setUpload(r4);
        String r5 = r1.getExtra();
    L20:
        th = move-exception;
        Logger.e("BDLocationService.updateNavigationIdInExtra parse extra failed", th);
        JSONObject r6 = new JSONObject();
    L55:
        if (TextUtils.isEmpty(r3) == false) goto L26;
        r6.remove("navigation_id");     // Catch: Throwable -> L29
    L27:
        r5 = r6.toString();     // Catch: Throwable -> L29
    L31:
        r1.setExtra(r5);
        Logger.i("BDLocationService.updateNavigationLocationOption: businessId=" + r1.getBusinessId() + ", navigationIdEmpty=" + TextUtils.isEmpty(r3) + ", needUpload=" + r4);
        k r7 = this.d;
        int r8 = r0.intValue();
        r7.getClass();
        if (k.r(r8) == false) goto L34;
        BaseLocate r9 = this.d.h;
    L36:
        if (r9 != null) goto L38;
    L53:
        this.d.x(this.a);
        Logger.w("BDLocationService.updatingNavigationLocationConfig ignored, location instance not running: " + this.a + ", locateType=" + r0);
        return;
    L38:
        if (r9.isLocationRunningForBusiness(this.a) == false) goto L53;
        if (this.c == true) goto L43;
    L47:
        boolean r10 = false;
    L48:
        Logger.i("BDLocationService.updatingNavigationLocationConfig decision: businessId=" + this.a + ", locateType=" + r0 + ", shouldRegisterSensors=" + r10 + ", sensorCollectionEnabled=" + BDLocationConfig.isSensorContinuousCollectEnabled());
        if (r10 == false) goto L51;
        k.c(this.d, r1);
        return;
    L51:
        this.d.x(this.a);
        return;
    L43:
        if (TextUtils.isEmpty(this.b) == true) goto L47;
        if (LocationUtil.isNavigationByteContinuousLocation(r1) == false) goto L47;
        r10 = true;
        goto L48
    L34:
        r9 = this.d.f;
        goto L36
    L26:
        r6.put("navigation_id", r3);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Logger.e("BDLocationService.updateNavigationIdInExtra update navigation_id failed", th);
        goto L31
    L16:
        if (TextUtils.isEmpty(r5) == false) goto L18;
        r6 = new JSONObject();     // Catch: Throwable -> L20
        goto L55
    L18:
        r6 = new JSONObject(r5);     // Catch: Throwable -> L20
        goto L55
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

    public k$c(k r1, String r2, String r3, boolean r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
