package com.bytedance.bdlocation.permission.request;

import android.app.Fragment;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class PermissionFragment extends Fragment {
    Permissions.Callback mCallback;

    public PermissionFragment() {
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        requestPermissions(getArguments().getStringArray("permissions"), 1);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int r1, String[] r2, int[] r3) {
        com_bytedance_bdlocation_permission_request_PermissionFragment_android_app_Fragment_onRequestPermissionsResult_super(this, r1, r2, r3);
        Permissions.Callback r4 = this.mCallback;
        if (r4 == null) goto L5;
        r4.onRequestPermissionResult(r2, r3);
    L5:
        getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    private static void com_bytedance_bdlocation_permission_request_PermissionFragment_android_app_Fragment_onRequestPermissionsResult_super(Fragment r18, int r19, String[] r20, int[] r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19), r20, r21};
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(102612);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        super.onRequestPermissionsResult(r19, r20, r21);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
