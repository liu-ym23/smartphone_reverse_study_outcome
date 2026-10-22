package com.oplus.ocs.base.common.api;

import android.content.Context;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.CapabilityListener;
import com.oplus.ocs.base.internal.ClientSettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class CapabilityApiClient {
    private static final String TAG = null;
    private static volatile Map<Api, CapabilityInfo> sApis;

    public CapabilityApiClient() {
    }

    static {
        TAG = "CapabilityApiClient";
        sApis = new HashMap();
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ Map access$200() {
        return sApis;
    }

    public static boolean checkCapability(Api r100) {
        if (sApis.containsKey(r100) == false) goto L12;
        CapabilityInfo r101 = sApis.get(r100);
        if (r101 == null) goto L12;
        if (r101.getAuthResult() == null) goto L12;
        if (r101.getAuthResult().getErrrorCode() != 1001) goto L12;
        return true;
    L12:
        return false;
    }

    public static CapabilityInfo getCapabilityInfo(Api r100) {
        return sApis.get(r100);
    }

    public static /* synthetic */ CapabilityInfo access$100(Context r100, int r101) {
        return buildCapabilityInfo(r100, r101);
    }

    private static CapabilityInfo buildCapabilityInfo(Context r100, int r101) {
        AuthResult r102 = new AuthResult(r100.getPackageName(), 0, 0, r101, new byte[4]);
        return new CapabilityInfo(new ArrayList(), 100011, r102);
    }

    public static /* synthetic */ void access$300(Api[] r100, int[] r101, CapabilityListener r102) {
        callback(r100, r101, r102);
    }

    private static synchronized void callback(Api[] r100, int[] r101, CapabilityListener r102) {
        monitor-enter(CapabilityApiClient.class);
        int r103 = r101.length;     // Catch: Throwable -> L15
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L11;
        if (r101[r104] == 0) goto L8;
        r104 = r104 + 1;
        goto L5
    L8:
        monitor-exit(CapabilityApiClient.class);
        return;
    L11:
        if (r102 == null) goto L13;
        r102.onResult(r100, r101);     // Catch: Throwable -> L15
    L13:
        monitor-exit(CapabilityApiClient.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static void checkSelfCapabilities(final Context r110, final Api[] r111, final CapabilityListener r112) {
        int r100 = 0;
        if (r111 != null) goto L5;
    L27:
        if (r112 == null) goto L29;
        r112.onResult(new Api[0], new int[0]);
    L29:
        com.oplus.ocs.base.utils.a.a(TAG, "capa apis is empty");
        return;
    L5:
        if (r111.length == 0) goto L27;
        final int[] r101 = new int[r111.length];
    L9:
        if (r100 >= r111.length) goto L26;
        final Api r102 = r111[r100];
        if (sApis.containsKey(r102) == false) goto L20;
        CapabilityInfo r103 = sApis.get(r102);
        if (r103 != null) goto L15;
    L17:
        com.oplus.ocs.base.utils.a.a(TAG, r102.getName() + "sapis none");
        r101[r100] = 7;
    L18:
        callback(r111, r101, r112);
    L25:
        r100 = r100 + 1;
        goto L9
    L15:
        if (r103.getAuthResult() == null) goto L17;
        r101[r100] = r103.getAuthResult().getErrrorCode();
        goto L18
    L20:
        if (r102.isAuth() == false) goto L24;
        final l r113 = l.a(r110);
        ClientSettings r114 = new ClientSettings(r110.getPackageName());
        final int r104 = r100;
        i r115 = new AnonymousClass1(r101, r104, r102, r110, r111, r112);
        com.oplus.ocs.base.utils.d.a(r102, "api not be null");
        com.oplus.ocs.base.utils.d.a(r114, "clientsettings not be null");
        if (l.f404234c.containsKey(r102.getClientKey()) == true) goto L25;
        m r105 = new m(r113.f404237a, r102, null, r114);
        r105.setOnClearListener(new l.AnonymousClass3(r113, r102));
        r105.setOnCapabilityAuthListener(r115);
        l.f404234c.put(r102.getClientKey(), r105);
        r113.a(r102);
        goto L25
    L24:
        com.oplus.ocs.base.utils.a.a(TAG, "current capa doesn't need to authenticate.");
        r101[r100] = 1001;
        sApis.put(r102, buildCapabilityInfo(r110, 1001));
        callback(r111, r101, r112);
        goto L25
    }
}
