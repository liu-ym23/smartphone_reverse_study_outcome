package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class fr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<fk> f591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f463594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f463595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f463596d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f463597a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f463598b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f463599c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f463600d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f463601e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f463602f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f463603g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f463604h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f463605i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f463606j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f463607k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f463608l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f463609m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f463610n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f463611o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f463612p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f463613q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f463614r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f463615s = null;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f463616t = null;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f463617u = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f463618v = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f463619w = null;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f463620x = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f592a;

        static {
            f463597a = new a("internal-server-error");
            f463598b = new a("forbidden");
            f463599c = new a("bad-request");
            f463600d = new a("conflict");
            f463601e = new a("feature-not-implemented");
            f463602f = new a("gone");
            f463603g = new a("item-not-found");
            f463604h = new a("jid-malformed");
            f463605i = new a("not-acceptable");
            f463606j = new a("not-allowed");
            f463607k = new a("not-authorized");
            f463608l = new a("payment-required");
            f463609m = new a("recipient-unavailable");
            f463610n = new a("redirect");
            f463611o = new a("registration-required");
            f463612p = new a("remote-server-error");
            f463613q = new a("remote-server-not-found");
            f463614r = new a("remote-server-timeout");
            f463615s = new a("resource-constraint");
            f463616t = new a("service-unavailable");
            f463617u = new a("subscription-required");
            f463618v = new a("undefined-condition");
            f463619w = new a("unexpected-request");
            f463620x = new a("request-timeout");
        }

        public String toString() {
            return this.f592a;
        }

        public a(String r100) {
            this.f592a = r100;
        }

        public static /* synthetic */ String a(a r100) {
            return r100.f592a;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9103a() {
        StringBuilder r100 = new StringBuilder("<error code=\"");
        r100.append(this.f463593a);
        r100.append("\"");
        if (this.f590a == null) goto L6;
        r100.append(" type=\"");
        r100.append(this.f590a);
        r100.append("\"");
    L6:
        if (this.f463595c == null) goto L8;
        r100.append(" reason=\"");
        r100.append(this.f463595c);
        r100.append("\"");
    L8:
        r100.append(">");
        if (this.f463594b == null) goto L12;
        r100.append("<");
        r100.append(this.f463594b);
        r100.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
    L12:
        if (this.f463596d == null) goto L14;
        r100.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
        r100.append(this.f463596d);
        r100.append("</text>");
    L14:
        Iterator<fk> r101 = m9104a().iterator();
    L16:
        if (r101.hasNext() == false) goto L18;
        r100.append(r101.next().d());
        goto L16
    L18:
        r100.append("</error>");
        return r100.toString();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        String r101 = this.f463594b;
        if (r101 == null) goto L5;
        r100.append(r101);
    L5:
        r100.append("(");
        r100.append(this.f463593a);
        r100.append(")");
        if (this.f463596d == null) goto L9;
        r100.append(" ");
        r100.append(this.f463596d);
    L9:
        return r100.toString();
    }

    public Bundle a() {
        Bundle r100 = new Bundle();
        String r101 = this.f590a;
        if (r101 == null) goto L5;
        r100.putString("ext_err_type", r101);
    L5:
        r100.putInt("ext_err_code", this.f463593a);
        String r102 = this.f463595c;
        if (r102 == null) goto L8;
        r100.putString("ext_err_reason", r102);
    L8:
        String r103 = this.f463594b;
        if (r103 == null) goto L11;
        r100.putString("ext_err_cond", r103);
    L11:
        String r104 = this.f463596d;
        if (r104 == null) goto L14;
        r100.putString("ext_err_msg", r104);
    L14:
        List<fk> r105 = this.f591a;
        if (r105 == null) goto L23;
        Bundle[] r106 = new Bundle[r105.size()];
        Iterator<fk> r107 = this.f591a.iterator();
        int r108 = 0;
    L18:
        if (r107.hasNext() == false) goto L22;
        Bundle r109 = r107.next().a();
        if (r109 == null) goto L18;
        r106[r108] = r109;
        r108 = r108 + 1;
        goto L18
    L22:
        r100.putParcelableArray("ext_exts", r106);
    L23:
        return r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized List<fk> m9104a() {
        monitor-enter(this);
        List<fk> r100 = this.f591a;     // Catch: Throwable -> L11
        if (r100 != null) goto L8;
        List<fk> r101 = Collections.emptyList();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        List<fk> r102 = Collections.unmodifiableList(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    public fr(Bundle r100) {
        this.f591a = null;
        this.f463593a = r100.getInt("ext_err_code");
        if (r100.containsKey("ext_err_type") == false) goto L5;
        this.f590a = r100.getString("ext_err_type");
    L5:
        this.f463594b = r100.getString("ext_err_cond");
        this.f463595c = r100.getString("ext_err_reason");
        this.f463596d = r100.getString("ext_err_msg");
        Parcelable[] r101 = r100.getParcelableArray("ext_exts");
        if (r101 == null) goto L13;
        this.f591a = new ArrayList(r101.length);
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L17;
        fk r104 = fk.a((Bundle) r101[r103]);
        if (r104 == null) goto L12;
        this.f591a.add(r104);
    L12:
        r103 = r103 + 1;
        goto L8
    L17:
        return;
    }

    private void a(a r100) {
        this.f463594b = a.a(r100);
    }

    public fr(a r100) {
        this.f591a = null;
        a(r100);
        this.f463596d = null;
    }

    public fr(int r100, String r101, String r102, String r103, String r104, List<fk> r105) {
        this.f463593a = r100;
        this.f590a = r101;
        this.f463595c = r102;
        this.f463594b = r103;
        this.f463596d = r104;
        this.f591a = r105;
    }
}
