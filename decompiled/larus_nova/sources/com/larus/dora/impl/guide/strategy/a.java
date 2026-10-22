package com.larus.dora.impl.guide.strategy;

import android.app.Application;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: com.larus.dora.impl.guide.strategy.a$a, reason: collision with other inner class name */
    public static final class C4267a {
    }

    static {
    }

    public a() {
    }

    public static List a() {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        return CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"});
    L6:
        return CollectionsKt.listOf(new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION"});
    }

    public static Map b() {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        int r100 = j0.f375426a;
        return MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", j0.d(R.string.larus_dora_bt_auth_cn)));
    L5:
        int r101 = j0.f375426a;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", j0.d(R.string.larus_dora_bt_auth_cn)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(R.string.larus_dora_poi_auth_cn))});
    }

    public static Object c() {
        List r100 = a();
        Application r101 = AppHost.f326268a.getApplication();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L3:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L11;
        Object r105 = r103.next();
        if (ContextCompat.checkSelfPermission(r101, (String) r105) == 0) goto L8;
        r104 = true;
    L8:
        if (r104 == false) goto L3;
        r102.add(r105);
        goto L3
    L11:
        if ((!r102.isEmpty()) == false) goto L13;
        g49.d.d("BtPermissionStrategy", "Bluetooth runtime permissions missing: " + r102);
    L15:
        return Boxing.boxBoolean(r104);
    L13:
        r104 = true;
        goto L15
    }
}
