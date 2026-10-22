package com.bytedance.ies.android.base.runtime.permission;

import android.app.Fragment;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.permission.IAdPermissionDepend", imports = {}))
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/permission/PermissionFragment;", "Landroid/app/Fragment;", "<init>", "()V", "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public final class PermissionFragment extends Fragment {
    @Override // android.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    public PermissionFragment() {
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r110, String[] r210, int[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r110), r210, r211};
        b r111 = new b();
        a r102 = ApiHookConfig.f245611b.get(102612);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r112 = r103;
        int r104 = r112.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r112[r105];
        int r113 = r105;
        int r114 = r104;
        d r107 = r106.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r101, "void", r111);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == true) goto L27;
        super.onRequestPermissionsResult(r110, r210, r211);
        return;
    L27:
        return;
    L14:
        r105 = r113 + 1;
        r104 = r114;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
