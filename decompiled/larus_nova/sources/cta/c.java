package cta;

import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import com.android.ttcjpaysdk.base.router.CJRouteOutMonitorUtils;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayBPEAService;
import com.ss.android.caijing.cjpay.env.permission.PermissionHandlerActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements be4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f465376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f465377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PermissionHandlerActivity f465378c;

    public class a implements ICJPayBPEAService.PermissionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f465379a;

        @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService.PermissionCallback
        public final void onRequestPermissions() {
            if (this.f465379a.f465378c.isFinishing() == false) goto L5;
            return;
        L5:
            c r100 = this.f465379a;
            ActivityCompat.requestPermissions(r100.f465378c, r100.f465376a, r100.f465377b);
            CJRouteOutMonitorUtils.INSTANCE.removeNotifiedRouteOutCertId("41489154");
        }

        public a(c r100) {
            this.f465379a = r100;
        }

        @Override // com.android.ttcjpaysdk.base.service.ICJPayBPEAService.PermissionCallback
        public final void onEzPermissionResult(boolean r100, List<String> r101, List<String> r102) {
            CJRouteOutMonitorUtils.INSTANCE.removeNotifiedRouteOutCertId("41489154");
            c r103 = this.f465379a;
            if (r103.f465377b != 0) goto L22;
            PermissionHandlerActivity r104 = r103.f465378c;
            if (r104.f407970a != null) goto L8;
            r104.A1();
            return;
        L8:
            int[] r105 = new int[r103.f465376a.length];
            int r106 = 0;
        L9:
            c r107 = this.f465379a;
            String[] r108 = r107.f465376a;
            if (r106 >= r108.length) goto L15;
            PackageManager r109 = r107.f465378c.getPackageManager();
            c r110 = this.f465379a;
            int r111 = r109.checkPermission(r110.f465376a[r106], r110.f465378c.getPackageName());
            r105[r106] = r111;
            c r112 = this.f465379a;
            cta.a r113 = r112.f465378c.f407970a;
            String r114 = r112.f465376a[r106];
            Map<String, Integer> r115 = r113.f465371d;
            if (r115 == null) goto L14;
            HashMap r116 = (HashMap) r115;
            r116.put(r114, Integer.valueOf(r111));
        L14:
            r106 = r106 + 1;
            goto L9
        L15:
            PermissionHandlerActivity r117 = r107.f465378c;
            if (r117.z1(r108, r117.f407970a.f465370c, r105) == true) goto L23;
            this.f465379a.f465378c.f407970a.a();
            this.f465379a.f465378c.A1();
            return;
        L23:
            return;
        }
    }

    @Override // be4.a
    public final void execute() {
        HashMap r100 = new HashMap();
        r100.put("scene", "request_permission");
        ICJPayBPEAService r101 = (ICJPayBPEAService) CJPayServiceManager.getInstance().getIService(ICJPayBPEAService.class);
        CJRouteOutMonitorUtils r102 = CJRouteOutMonitorUtils.INSTANCE;
        r102.notifyRouteOutCertId("41489154", r100, this.f465378c);
        if (r101 == null) goto L5;
        r101.requestEzPermission(this.f465378c, this.f465376a, "bpea-cjpay_android_native_request_permission", new a(this));
        return;
    L5:
        ActivityCompat.requestPermissions(this.f465378c, this.f465376a, this.f465377b);
        r102.removeNotifiedRouteOutCertId("41489154");
    }

    public c(PermissionHandlerActivity r100, String[] r101) {
        this.f465378c = r100;
        this.f465376a = r101;
        this.f465377b = 0;
    }
}
