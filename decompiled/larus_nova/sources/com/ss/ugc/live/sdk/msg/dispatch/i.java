package com.ss.ugc.live.sdk.msg.dispatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements ulc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, String> f458274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, xlc.b> f458275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f458276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vlc.c f458277d;

    @Override // ulc.b
    public final String getName() {
        return "WRDSVersionCheck";
    }

    public static String b(tlc.d r100) {
        if ((r100 instanceof xlc.b) == true) goto L7;
        return a(r100.getMessageMethod(), null);
    L7:
        if (((xlc.b) r100).isWRDSMessage() == true) goto L11;
        return a(r100.getMessageMethod(), null);
    L11:
        return a(r100.getMessageMethod(), ((xlc.b) r100).getWRDSSubKey());
    }

    public final void d(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof xlc.b) == true) goto L6;
        return;
    L6:
        if (((xlc.b) r100).isWRDSMessage() == true) goto L8;
        return;
    L8:
        String r101 = r100.getMessageMethod();
        if (r101 == null) goto L12;
        Map<Integer, String> r102 = this.f458274a;
        HashMap r103 = (HashMap) r102;
        r103.put(Integer.valueOf(r100.getIntType()), r101);
        Map<String, xlc.b> r104 = this.f458275b;
        HashMap r105 = (HashMap) r104;
        r105.put(b(r100), r100);
        return;
    }

    @Override // vlc.b
    public final boolean onMessage(tlc.d r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((r110 instanceof xlc.b) == true) goto L6;
        return false;
    L6:
        if (((xlc.b) r110).isWRDSMessage() == true) goto L8;
        return false;
    L8:
        boolean r100 = true;
        if (r110.getRoomId() == this.f458276c) goto L26;
        Set<Long> r101 = j.f458278a;
        long r102 = r110.getRoomId();
        xlc.b r103 = (xlc.b) r110;
        Intrinsics.checkNotNullParameter(r103, "message");
        Set<Long> r104 = j.f458278a;
        CopyOnWriteArraySet r105 = (CopyOnWriteArraySet) r104;
        if (r105.contains(Long.valueOf(r102)) == false) goto L22;
        Intrinsics.checkNotNullParameter(r103, "message");
        String r106 = j.a(r103.getWRDSKey(), r103.getWRDSSubKey());
        Map<Long, Map<String, xlc.b>> r107 = j.f458279b;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;
        Map r109 = (Map) r108.get(Long.valueOf(r102));
        if (r109 != null) goto L17;
        r109 = new ConcurrentHashMap();
        r108.put(Long.valueOf(r102), r109);
    L17:
        xlc.b r111 = (xlc.b) r109.get(r106);
        if (r111 != null) goto L20;
    L23:
        r109.put(r106, r103);
    L24:
        vlc.c r112 = this.f458277d;
        StringBuilder r113 = new StringBuilder("receive preload wrds: ");
        Intrinsics.checkNotNullParameter(r103, "message");
        r113.append(j.a(r103.getWRDSKey(), r103.getWRDSSubKey()));
        r113.append('_');
        r113.append(r110.getRoomId());
        r113.append(", preload: ");
        r113.append(r100);
        com.ss.ugc.live.sdk.msg.utils.a.c(r112, r113.toString());
        return false;
    L20:
        if (r103.getWRDSVersion() > r111.getWRDSVersion()) goto L23;
    L22:
        r100 = false;
        goto L24
    L26:
        Map<String, xlc.b> r114 = this.f458275b;
        HashMap r115 = (HashMap) r114;
        xlc.b r116 = (xlc.b) r115.get(b(r110));
        if (r116 != null) goto L29;
    L31:
        return false;
    L29:
        if (((xlc.b) r110).getWRDSVersion() > r116.getWRDSVersion()) goto L31;
        return true;
    }

    public i(long r100, vlc.c r101) {
        Intrinsics.checkNotNullParameter(r101, "logger");
        this.f458276c = r100;
        this.f458277d = r101;
        this.f458274a = new HashMap();
        this.f458275b = new HashMap();
    }

    public static String a(String r100, String r101) {
        if (r100 != null) goto L5;
        r100 = "Unknown";
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L14;
        return r100;
    L14:
        return r100 + "_" + r101;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    public final tlc.d c(int r100, String r101) {
        Map<Integer, String> r102 = this.f458274a;
        HashMap r103 = (HashMap) r102;
        String r104 = (String) r103.get(Integer.valueOf(r100));
        Object r105 = null;
        if (r104 == null) goto L10;
        Map<String, xlc.b> r106 = this.f458275b;
        HashMap r107 = (HashMap) r106;
        Object r108 = r107.get(a(r104, r101));
        if ((r108 instanceof tlc.d) == false) goto L9;
        r105 = r108;
    L9:
        return (tlc.d) r105;
    L10:
        return null;
    }
}
