package com.bytedance.awemeopen.infra.plugs.applog;

import android.accounts.NetworkErrorException;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkService;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdinstall.g0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class NetworkClientForApplog implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetworkClientForApplog f198824a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f198825b = null;

    public NetworkClientForApplog() {
    }

    static {
        f198824a = new NetworkClientForApplog();
        f198825b = LazyKt.lazy(NetworkClientForApplog$netService$2.INSTANCE);
    }

    @Override // com.bytedance.bdinstall.g0
    public final String get(String r210, Map<String, String> r211) throws RangersHttpException {
        Intrinsics.checkNotNullParameter(r210, "url");
        Intrinsics.checkNotNullParameter(r211, "requestHeaders");
        AoNetworkService r110 = (AoNetworkService) f198825b.getValue();     // Catch: Exception -> L22
        ArrayList r100 = new ArrayList();     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r211, "map");     // Catch: Exception -> L22
        Iterator r101 = ((HashMap) r211).entrySet().iterator();     // Catch: Exception -> L22
    L5:
        if (r101.hasNext() == false) goto L7;
        Map.Entry r102 = (Map.Entry) r101.next();     // Catch: Exception -> L22
        r100.add(new q64.c.C7284c((String) r102.getKey(), (String) r102.getValue()));     // Catch: Exception -> L22
        goto L5
    L7:
        q64.b r103 = r110.s2(new q64.a(r210, "GET", false, true, false, new q64.c(r100), null, 60000, 60000, 60000)).execute();     // Catch: Exception -> L22
        int r104 = r103.f531783a;     // Catch: Exception -> L22
        if (200 <= r104) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L20;
        q64.e r106 = r103.f531787e;     // Catch: Exception -> L22
        if (r106 == null) goto L18;
        String r107 = r106.f();     // Catch: Exception -> L22
        if (r107 == null) goto L18;
        return r107;
    L18:
        return "";
    L20:
        f.a("NetworkClientForApplog", "get failed ".concat(r210));     // Catch: Exception -> L22
        throw new NetworkErrorException("event network error");     // Catch: Exception -> L22
    L10:
        if (r104 >= 300) goto L12;
        r105 = true;
    L22:
        e = move-exception;
        throw e;
    }

    @Override // com.bytedance.bdinstall.g0
    public final String post(String r210, byte[] r211, Map<String, String> r212) throws RangersHttpException {
        Intrinsics.checkNotNullParameter(r210, "url");
        Intrinsics.checkNotNullParameter(r211, "data");
        Intrinsics.checkNotNullParameter(r212, "requestHeaders");
        AoNetworkService r110 = (AoNetworkService) f198825b.getValue();     // Catch: Exception -> L22
        ArrayList r100 = new ArrayList();     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r212, "map");     // Catch: Exception -> L22
        Iterator r101 = ((HashMap) r212).entrySet().iterator();     // Catch: Exception -> L22
    L5:
        if (r101.hasNext() == false) goto L7;
        Map.Entry r102 = (Map.Entry) r101.next();     // Catch: Exception -> L22
        r100.add(new q64.c.C7284c((String) r102.getKey(), (String) r102.getValue()));     // Catch: Exception -> L22
        goto L5
    L7:
        q64.b r103 = r110.s2(new q64.a(r210, "POST", false, true, false, new q64.c(r100), new b(r211), 60000, 60000, 60000)).execute();     // Catch: Exception -> L22
        int r104 = r103.f531783a;     // Catch: Exception -> L22
        if (200 <= r104) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L20;
        q64.e r106 = r103.f531787e;     // Catch: Exception -> L22
        if (r106 == null) goto L18;
        String r107 = r106.f();     // Catch: Exception -> L22
        if (r107 == null) goto L18;
        return r107;
    L18:
        return "";
    L20:
        f.a("NetworkClientForApplog", "post failed ".concat(r210));     // Catch: Exception -> L22
        throw new NetworkErrorException("event network error");     // Catch: Exception -> L22
    L10:
        if (r104 >= 300) goto L12;
        r105 = true;
    L22:
        e = move-exception;
        throw e;
    }

    @Override // com.bytedance.bdinstall.g0
    public final byte[] postStream(String r210, byte[] r211, Map<String, String> r212) throws RangersHttpException {
        Intrinsics.checkNotNullParameter(r210, "url");
        Intrinsics.checkNotNullParameter(r211, "data");
        Intrinsics.checkNotNullParameter(r212, "requestHeaders");
        AoNetworkService r110 = (AoNetworkService) f198825b.getValue();     // Catch: Exception -> L22
        ArrayList r100 = new ArrayList();     // Catch: Exception -> L22
        Intrinsics.checkNotNullParameter(r212, "map");     // Catch: Exception -> L22
        Iterator r101 = ((HashMap) r212).entrySet().iterator();     // Catch: Exception -> L22
    L5:
        if (r101.hasNext() == false) goto L7;
        Map.Entry r102 = (Map.Entry) r101.next();     // Catch: Exception -> L22
        r100.add(new q64.c.C7284c((String) r102.getKey(), (String) r102.getValue()));     // Catch: Exception -> L22
        goto L5
    L7:
        q64.b r103 = r110.s2(new q64.a(r210, "POST", false, true, false, new q64.c(r100), new b(r211), 60000, 60000, 60000)).execute();     // Catch: Exception -> L22
        int r104 = r103.f531783a;     // Catch: Exception -> L22
        if (200 <= r104) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L20;
        q64.e r106 = r103.f531787e;     // Catch: Exception -> L22
        if (r106 == null) goto L19;
        byte[] r107 = r106.a();     // Catch: Exception -> L22
        if (r107 == null) goto L19;
        return r107;
    L19:
        return new byte[0];
    L20:
        f.a("NetworkClientForApplog", "post failed ".concat(r210));     // Catch: Exception -> L22
        throw new NetworkErrorException("event network error");     // Catch: Exception -> L22
    L10:
        if (r104 >= 300) goto L12;
        r105 = true;
    L22:
        e = move-exception;
        throw e;
    }
}
