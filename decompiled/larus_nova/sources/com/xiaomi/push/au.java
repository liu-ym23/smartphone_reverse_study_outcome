package com.xiaomi.push;

import android.net.NetworkInfo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
public class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkInfo f463157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ConcurrentHashMap<String, Object> f252a;

    public int a() {
        return ((Integer) a("getType")).intValue();
    }

    public int b() {
        return ((Integer) a("getSubtype")).intValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8823a() {
        return ((Boolean) a("isConnected")).booleanValue();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m8824b() {
        return (String) a("getSubtypeName");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NetworkInfo.DetailedState m8820a() {
        return (NetworkInfo.DetailedState) a("getDetailedState");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NetworkInfo.State m8821a() {
        return (NetworkInfo.State) a("getState");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m8822a() {
        return (String) a("getTypeName");
    }

    public au(NetworkInfo r100) {
        this.f252a = new ConcurrentHashMap();
        this.f463157a = r100;
    }

    private <T> T a(String r100) {
        if (this.f252a.containsKey(r100) == true) goto L49;
        monitor-enter(r100);
    L45:
        th = move-exception;
        throw th;
    L6:
        if (this.f252a.contains(r100) == false) goto L8;
    L43:
        monitor-exit(r100);     // Catch: Throwable -> L45
        goto L49
    L8:
        switch(r100.hashCode()) {
            case -830707388: goto L29;
            case -75106384: goto L26;
            case -66906641: goto L23;
            case 599209215: goto L20;
            case 711698955: goto L17;
            case 1401392731: goto L14;
            case 1965583067: goto L11;
            default: goto L31;
        };     // Catch: Throwable -> L45
    L31:
        byte r101 = -1;
    L32:
        switch(r101) {
            case 0: goto L40;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            default: goto L33;
        };     // Catch: Throwable -> L45
    L33:
        Object r102 = null;
    L41:
        if (r102 == null) goto L43;
        this.f252a.put(r100, r102);     // Catch: Throwable -> L45
        goto L43
    L34:
        r102 = this.f463157a.getDetailedState();     // Catch: Throwable -> L45
        goto L41
    L35:
        r102 = this.f463157a.getState();     // Catch: Throwable -> L45
        goto L41
    L36:
        r102 = Boolean.valueOf(this.f463157a.isConnected());     // Catch: Throwable -> L45
        goto L41
    L37:
        r102 = this.f463157a.getSubtypeName();     // Catch: Throwable -> L45
        goto L41
    L38:
        r102 = Integer.valueOf(this.f463157a.getSubtype());     // Catch: Throwable -> L45
        goto L41
    L39:
        r102 = this.f463157a.getTypeName();     // Catch: Throwable -> L45
        goto L41
    L40:
        r102 = Integer.valueOf(this.f463157a.getType());     // Catch: Throwable -> L45
        goto L41
    L11:
        if (r100.equals("getState") == false) goto L31;
        r101 = 5;
        goto L32
    L14:
        if (r100.equals("getTypeName") == false) goto L31;
        r101 = 1;
        goto L32
    L17:
        if (r100.equals("getDetailedState") == false) goto L31;
        r101 = 6;
        goto L32
    L20:
        if (r100.equals("isConnected") == false) goto L31;
        r101 = 4;
        goto L32
    L23:
        if (r100.equals("getSubtypeName") == false) goto L31;
        r101 = 3;
        goto L32
    L26:
        if (r100.equals("getType") == false) goto L31;
        r101 = 0;
        goto L32
    L29:
        if (r100.equals("getSubtype") == false) goto L31;
        r101 = 2;
    L49:
        return (T) this.f252a.get(r100);
    }
}
