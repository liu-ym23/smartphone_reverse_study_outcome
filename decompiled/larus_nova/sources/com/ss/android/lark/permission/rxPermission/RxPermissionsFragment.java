package com.ss.android.lark.permission.rxPermission;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.log.Log;
import f06.b;
import f06.d;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import n0c.a;

/* JADX INFO: loaded from: classes37.dex */
public class RxPermissionsFragment extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f438549b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Integer, String[]> f438550c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, PublishSubject<a>> f438551a;

    static {
        f438549b = new AtomicInteger(100000);
        f438550c = new ConcurrentHashMap();
    }

    public final void b() {
        Map<String, PublishSubject<a>> r100 = this.f438551a;
        monitor-enter(r100);
        Iterator r101 = ((ConcurrentHashMap) this.f438551a).entrySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r101.hasNext() == false) goto L12;
        Map.Entry r102 = (Map.Entry) r101.next();     // Catch: Throwable -> L14
        r101.remove();     // Catch: Throwable -> L14
        PublishSubject r103 = (PublishSubject) r102.getValue();     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r103.onNext(new a((String) r102.getKey(), false, c(this, (String) r102.getKey())));     // Catch: Throwable -> L14
    L11:
        r103.onComplete();     // Catch: Throwable -> L14
        goto L6
    L10:
        r103.onNext(new a((String) r102.getKey(), false, false));     // Catch: Throwable -> L14
        goto L11
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public RxPermissionsFragment() {
        this.f438551a = new ConcurrentHashMap();
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        b();
        super.onDestroy();
    }

    public static int a(String[] r100) {
        int r101 = f438549b.getAndIncrement();
        Map<Integer, String[]> r102 = f438550c;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(Integer.valueOf(r101), r100);
        return r101;
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setRetainInstance(true);
    }

    public void requestPermissions(String[] r100) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        requestPermissions(r100, a(r100));
        return;
    L5:
        ActivityCompat.requestPermissions(getActivity(), r100, a(r100));
    }

    public static boolean c(RxPermissionsFragment r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        b r112 = new b("auto_cert_com_ss_android_lark_permission_rxPermission_RxPermissionsFragment_com_ss_android_lark_permission_rxPermission_RxPermissionsFragment_shouldShowRequestPermissionRationale");
        g06.a r102 = ApiHookConfig.f245611b.get(102610);
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
        d r107 = r106.preInvoke(102610, "com/ss/android/lark/permission/rxPermission/RxPermissionsFragment", "shouldShowRequestPermissionRationale", r110, r101, "boolean", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Boolean) r107.f474983b).booleanValue();
    L21:
        return r110.shouldShowRequestPermissionRationale(r111);
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

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r210, String[] r211, int[] r212) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {Integer.valueOf(r210), r211, r212};
        b r112 = new b();
        g06.a r100 = ApiHookConfig.f245611b.get(102612);
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
        d r106 = r105.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r111, "void", r112);     // Catch: Exception -> L63
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L63
    L17:
        if (r106.f474982a == true) goto L21;
        super.onRequestPermissionsResult(r210, r211, r212);
    L21:
        if (r210 >= 100000) goto L23;
        return;
    L23:
        String[] r107 = (String[]) ((ConcurrentHashMap) f438550c).remove(Integer.valueOf(r210));
        Bundle r108 = getArguments();
        if (r108 != null) goto L26;
    L28:
        boolean r109 = false;
    L29:
        if (r109 == false) goto L47;
        if (r211 != null) goto L32;
    L41:
        boolean r115 = true;
    L42:
        if (r115 == false) goto L47;
        if (r107 == null) goto L45;
        int[] r116 = new int[r107.length];
        Arrays.fill(r116, -1);
    L48:
        boolean[] r117 = new boolean[r107.length];
        int r118 = 0;
    L50:
        if (r118 >= r107.length) goto L52;
        r117[r118] = c(this, r107[r118]);
        r118 = r118 + 1;
        goto L50
    L52:
        int r119 = r107.length;
        int r120 = 0;
    L53:
        if (r120 >= r119) goto L76;
        PublishSubject r121 = (PublishSubject) ((ConcurrentHashMap) this.f438551a).get(r107[r120]);
        if (r121 == null) goto L56;
        ((ConcurrentHashMap) this.f438551a).remove(r107[r120]);
        if (r116[r120] != 0) goto L60;
        boolean r122 = true;
    L61:
        r121.onNext(new a(r107[r120], r122, r117[r120]));
        r121.onComplete();
        r120 = r120 + 1;
        goto L53
    L60:
        r122 = false;
        goto L61
    L56:
        Log.e("RxPermissions", "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
        return;
    L76:
        return;
    L45:
        b();
        return;
    L32:
        if (r211.length == 0) goto L41;
        int r123 = r211.length;
        int r124 = 0;
    L35:
        if (r124 >= r123) goto L40;
        if (TextUtils.isEmpty(r211[r124]) == true) goto L41;
        r124 = r124 + 1;
        goto L35
    L40:
        r115 = false;
    L47:
        r116 = r212;
        r107 = r211;
        goto L48
    L26:
        if (r108.getBoolean("key_enable_patch", false) == false) goto L28;
        r109 = true;
    L14:
        r104 = r113 + 1;
        r103 = r114;
        r102 = r213;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }
}
