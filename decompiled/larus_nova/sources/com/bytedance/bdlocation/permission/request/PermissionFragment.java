package com.bytedance.bdlocation.permission.request;

import android.app.Fragment;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class PermissionFragment extends Fragment {
    Permissions.Callback mCallback;

    public PermissionFragment() {
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        requestPermissions(getArguments().getStringArray(ComplianceResult.JsonKey.PERMISSIONS), 1);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
        com_bytedance_bdlocation_permission_request_PermissionFragment_android_app_Fragment_onRequestPermissionsResult_super(this, r100, r101, r102);
        Permissions.Callback r103 = this.mCallback;
        if (r103 == null) goto L5;
        r103.onRequestPermissionResult(r101, r102);
    L5:
        getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    private static void com_bytedance_bdlocation_permission_request_PermissionFragment_android_app_Fragment_onRequestPermissionsResult_super(Fragment r110, int r111, String[] r210, int[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111), r210, r211};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(102612);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        super.onRequestPermissionsResult(r111, r210, r211);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
