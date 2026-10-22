package com.bytedance.bdp.bdpplatform.service.permission.request;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaPermissionService;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import g06.a;
import ga4.c;
import ga4.d;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdp/bdpplatform/service/permission/request/BdpPermissionProxy;", "Landroid/app/Fragment;", "Lga4/d;", "<init>", "()V", "bdp-service_release"}, k = 1, mv = {1, 4, 0})
public final class BdpPermissionProxy extends Fragment implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.a f201395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f201396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f201397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f201398d;

    @Override // android.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    public final void b() {
        Activity r100 = getActivity();     // Catch: Exception -> L7
        if (r100 != null) goto L5;
        return;
    L5:
        r100.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();     // Catch: Exception -> L7
        return;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        String[] r100 = this.f201396b;
        if (r100 == null) goto L10;
        c.a r101 = this.f201395a;
        if (r101 == null) goto L10;
        int r102 = r100.length;
        int[] r103 = new int[r102];
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L9;
        r103[r104] = -1;
        r104 = r104 + 1;
        goto L7
    L9:
        r101.a(r100, r103);
    L10:
        CopyOnWriteArrayList<d> r105 = c.f480553a;
        c.f480553a.remove(this);
        b();
    }

    public BdpPermissionProxy() {
    }

    @Override // android.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        if (this.f201396b == null) goto L11;
        BdpBpeaPermissionService r101 = (BdpBpeaPermissionService) BdpManager.getInst().getService(BdpBpeaPermissionService.class);
        String[] r102 = this.f201396b;
        if (r102 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        String[] r103 = (String[]) ArraysKt.toHashSet(r102).toArray(new String[0]);
        Integer r104 = this.f201397c;
        if (r104 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        r101.requestPermissions(this, r103, r104.intValue(), this.f201398d);
        return;
    L11:
        b();
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setRetainInstance(true);
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r210, String[] r211, int[] r212) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {Integer.valueOf(r210), r211, r212};
        b r112 = new b();
        a r100 = ApiHookConfig.f245611b.get(102612);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r113 = r104;
        int r114 = r103;
        f06.a[] r213 = r102;
        f06.d r106 = r105.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r111, "void", r112);     // Catch: Exception -> L25
        if (r106.f474982a == true) goto L12;
        r110.add(r105);     // Catch: Exception -> L25
        goto L14
    L12:
        String[] r107 = null;
    L17:
        if (r106.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r210, r211, r212);
    L20:
        c.a r108 = this.f201395a;
        if (r108 == null) goto L23;
        r108.a(r211, r212);
    L23:
        this.f201396b = r107;
        CopyOnWriteArrayList<d> r109 = c.f480553a;
        c.f480553a.remove(this);
        b();
        return;
    L14:
        r104 = r113 + 1;
        r103 = r114;
        r102 = r213;
        goto L8
    L15:
        r107 = null;
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // ga4.d
    public final void a(Activity r100, String[] r101, c.a r102, String r103) {
        if (r100.isFinishing() == false) goto L5;
        return;
    L5:
        this.f201395a = r102;
        this.f201396b = r101;
        this.f201397c = 32765;
        this.f201398d = r103;
        r100.getFragmentManager().beginTransaction().add(0, this).commitAllowingStateLoss();     // Catch: Exception -> L8
        return;
    }
}
