package com.xiaomi.push;

import android.os.Bundle;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class fl extends fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f463550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Map<String, String> f577a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f463551a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f463552b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f463553c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f463554d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f463555e = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f578a;

        static {
            f463551a = new a(MonitorConstants.CONNECT_TYPE_GET);
            f463552b = new a("set");
            f463553c = new a("result");
            f463554d = new a("error");
            f463555e = new a("command");
        }

        public String toString() {
            return this.f578a;
        }

        private a(String r100) {
            this.f578a = r100;
        }

        public static a a(String r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            String r101 = r100.toLowerCase();
            a r102 = f463551a;
            if (r102.toString().equals(r101) == false) goto L8;
            return r102;
        L8:
            a r103 = f463552b;
            if (r103.toString().equals(r101) == false) goto L11;
            return r103;
        L11:
            a r104 = f463554d;
            if (r104.toString().equals(r101) == false) goto L14;
            return r104;
        L14:
            a r105 = f463553c;
            if (r105.toString().equals(r101) == false) goto L17;
            return r105;
        L17:
            a r106 = f463555e;
            if (r106.toString().equals(r101) == false) goto L20;
            return r106;
        L20:
            return null;
        }
    }

    public String b() {
        return null;
    }

    @Override // com.xiaomi.push.fn
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo9099a() {
        StringBuilder r100 = new StringBuilder("<iq ");
        if (j() == null) goto L6;
        r100.append("id=\"" + j() + "\" ");
    L6:
        if (l() == null) goto L9;
        r100.append("to=\"");
        r100.append(fw.a(l()));
        r100.append("\" ");
    L9:
        if (m() == null) goto L12;
        r100.append("from=\"");
        r100.append(fw.a(m()));
        r100.append("\" ");
    L12:
        if (k() == null) goto L14;
        r100.append("chid=\"");
        r100.append(fw.a(k()));
        r100.append("\" ");
    L14:
        Iterator<Map.Entry<String, String>> r101 = this.f577a.entrySet().iterator();
    L16:
        if (r101.hasNext() == false) goto L19;
        Map.Entry<String, String> r102 = r101.next();
        r100.append(fw.a(r102.getKey()));
        r100.append("=\"");
        r100.append(fw.a(r102.getValue()));
        r100.append("\" ");
        goto L16
    L19:
        if (this.f463550a != null) goto L21;
        r100.append("type=\"get\">");
    L22:
        String r103 = b();
        if (r103 == null) goto L25;
        r100.append(r103);
    L25:
        r100.append(o());
        fr r104 = m9100a();
        if (r104 == null) goto L28;
        r100.append(r104.m9103a());
    L28:
        r100.append("</iq>");
        return r100.toString();
    L21:
        r100.append("type=\"");
        r100.append(m9098a());
        r100.append("\">");
        goto L22
    }

    public fl() {
        this.f463550a = a.f463551a;
        this.f577a = new HashMap();
    }

    @Override // com.xiaomi.push.fn
    public Bundle a() {
        Bundle r100 = super.a();
        a r101 = this.f463550a;
        if (r101 == null) goto L5;
        r100.putString("ext_iq_type", r101.toString());
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public a m9098a() {
        return this.f463550a;
    }

    public fl(Bundle r100) {
        super(r100);
        this.f463550a = a.f463551a;
        this.f577a = new HashMap();
        if (r100.containsKey("ext_iq_type") == false) goto L6;
        this.f463550a = a.a(r100.getString("ext_iq_type"));
        return;
    }

    public synchronized void a(Map<String, String> r100) {
        monitor-enter(this);
        this.f577a.putAll(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void a(a r100) {
        if (r100 != null) goto L4;
        this.f463550a = a.f463551a;
        return;
    L4:
        this.f463550a = r100;
    }
}
