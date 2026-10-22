package com.ss.android.common.app.permission.callback;

import android.app.Fragment;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/common/app/permission/callback/AssistFragment;", "Landroid/app/Fragment;", "<init>", "()V", "permissions_release"}, k = 1, mv = {1, 4, 0})
public final class AssistFragment extends Fragment {
    @Override // android.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    public AssistFragment() {
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r110, String[] r210, int[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r110), r210, r211};
        b r111 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(102612);
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
        d r107 = r106.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r101, "void", r111);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L12;
        r100.add(r106);     // Catch: Exception -> L22
        goto L14
    L12:
        Throwable r108 = null;
    L17:
        if (r107.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r110, r210, r211);
    L20:
        Intrinsics.throwUninitializedPropertyAccessException("onRequestPermissionsResult");
        throw r108;
    L14:
        r105 = r113 + 1;
        r104 = r114;
        goto L8
    L15:
        r108 = null;
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
