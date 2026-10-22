package us7;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.dtf.face.api.IDTUIListener;
import com.dtf.face.log.RecordService;
import com.dtf.face.ui.PermissionToastView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.List;
import ws7.p;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IDTUIListener {

    /* JADX INFO: renamed from: us7.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes22.dex */
    public class RunnableC7928a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PermissionToastView f551530a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f551530a.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC7928a(PermissionToastView r100) {
            this.f551530a = r100;
        }
    }

    @Override // com.dtf.face.api.IDTUIListener
    public final String onAlertCancelButton(String r100) {
        return r100;
    }

    @Override // com.dtf.face.api.IDTUIListener
    public final String onAlertMessage(String r100) {
        return r100;
    }

    @Override // com.dtf.face.api.IDTUIListener
    public final String onAlertOKButton(String r100) {
        return r100;
    }

    @Override // com.dtf.face.api.IDTUIListener
    public final String onAlertTitle(String r100) {
        return r100;
    }

    @Override // com.dtf.face.api.IDTUIListener
    public final boolean onIsPageScanCloseImageLeft() {
        return false;
    }

    @Override // com.dtf.face.api.IDTUIListener
    public final int onPageScanCloseImage() {
        return 0;
    }

    public a() {
    }

    @Override // com.dtf.face.api.IDTUIListener
    public final boolean onPermissionRequest(Activity r110, List<String> r111, String r112) {
        if (r110 != null) goto L5;
    L36:
        return false;
    L5:
        if (g.f551541d == false) goto L36;
        Context r100 = hs7.a.h().getContext();
        PackageManager r101 = r100.getPackageManager();     // Catch: Throwable -> L11
        if (r101 == null) goto L13;
        String r102 = r101.getApplicationLabel(r101.getApplicationInfo(r100.getPackageName(), 0)).toString();     // Catch: Throwable -> L11
    L14:
        String r103 = p.h(r110, -1, "authPermissionAPPName");
        if (TextUtils.isEmpty(r103) == false) goto L17;
    L19:
        StringBuilder r104 = new StringBuilder();
        if (r111.contains("android.permission.RECORD_AUDIO") == false) goto L23;
        r104.append(p.h(r110, R.string.dtf_permission_audio, "authPermissionAudio"));
        r104.append("、");
    L23:
        if (r111.contains("android.permission.CAMERA") == false) goto L26;
        r104.append(p.h(r110, R.string.dtf_permission_camera, "authPermissionCamera"));
        r104.append("、");
    L26:
        if (r111.contains("media_projection") == false) goto L28;
        r104.append(p.h(r110, R.string.dtf_permission_screen_record, "authPermissionScreenEvidence"));
        r104.append("、");
    L28:
        String r113 = p.h(r110, -1, "authPermissionToastTitle");
        if (TextUtils.isEmpty(r113) == false) goto L31;
        r113 = String.format(r110.getString(R.string.dtf_permission_title), new Object[]{r104.substring(0, r104.length() - 1)});
    L31:
        String r105 = p.h(r110, -1, "authPermissionToastMsg");
        if (TextUtils.isEmpty(r105) == false) goto L34;
        String r106 = p.h(r110, R.string.dtf_permission_sdk_name, "authPermissionSDKName");
        r105 = String.format(r110.getString(R.string.dtf_permission_content), new Object[]{r106, r102, r104.substring(0, r104.length() - 1)});
    L34:
        PermissionToastView r107 = new PermissionToastView(r110, r113, r105);
        r110.getWindow().addContentView(r107, new ViewGroup.LayoutParams(-1, -2));
        r107.postDelayed(new RunnableC7928a(r107), g.f551542e);
        RecordService.getInstance().recordEvent(2, "showPermission", new String[]{"title", r113, "msg", r105});
        return true;
    L17:
        if (r103.length() > 10) goto L19;
        r102 = r103;
    L13:
        r102 = "";
    L11:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L13
    }
}
