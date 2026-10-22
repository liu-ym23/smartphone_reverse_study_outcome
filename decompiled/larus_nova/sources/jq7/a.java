package jq7;

import android.net.Uri;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, C6475a> f500068a;

    /* JADX INFO: renamed from: jq7.a$a, reason: collision with other inner class name */
    public static class C6475a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f500069a;

        public C6475a(String r100, String r101) {
            this.f500069a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile List<C6476a> f500070a;

        /* JADX INFO: renamed from: jq7.a$b$a, reason: collision with other inner class name */
        public static class C6476a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Pattern f500071a;

            public C6476a() {
                throw null;
            }
        }

        public final String a(Uri r100) {
            if (this.f500070a != null) goto L14;
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L6:
            if (this.f500070a == null) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L11
            goto L14
        L9:
            this.f500070a = new ArrayList();     // Catch: Throwable -> L11
            throw null;     // Catch: Throwable -> L11
        L14:
            Iterator r101 = ((ArrayList) this.f500070a).iterator();
        L32:
            if (r101.hasNext() == true) goto L17;
        L29:
            if (r101.hasNext() == true) goto L32;
            return null;
        L17:
            C6476a r102 = (C6476a) r101.next();     // Catch: Exception -> L26
            if (r102.f500071a != null) goto L20;
            r102.f500071a = PatternProtector.compile(null);     // Catch: Exception -> L26
        L20:
            Matcher r103 = r102.f500071a.matcher(r100.toString());     // Catch: Exception -> L26
        L22:
            if (r103.find() == false) goto L32;
            r103.group();     // Catch: Exception -> L26
            r103.start();     // Catch: Exception -> L26
            kq7.a.a("AddressParam");     // Catch: Exception -> L26
            if (r103.start() != 0) goto L22;
            return null;
        L26:
            e = move-exception;
            e.toString();
            kq7.a.a("AddressParam");
            goto L29
        }
    }

    public a() {
        this.f500068a = new HashMap();
    }

    public static List<C6475a> a(int r100, String r101) {
        ArrayList r102 = new ArrayList();
        if (r101 != null) goto L27;
        return r102;
    L27:
        JSONObject r103 = new JSONObject(r101);     // Catch: Exception -> L25
        if (r100 != 0) goto L9;
        JSONObject r104 = r103.optJSONObject("bdwk_create");     // Catch: Exception -> L25
        if (r104 == null) goto L26;
        Iterator<String> r105 = r104.keys();     // Catch: Exception -> L25
    L22:
        if (r105.hasNext() == false) goto L26;
        String r106 = r105.next();     // Catch: Exception -> L25
        r102.add(new C6475a(r106, r104.optString(r106)));     // Catch: Exception -> L25
    L26:
        return r102;
    L9:
        if (r100 != 1) goto L26;
        Iterator<String> r107 = r103.keys();     // Catch: Exception -> L25
    L13:
        if (r107.hasNext() == false) goto L26;
        String r108 = r107.next();     // Catch: Exception -> L25
        if (r108.equals("bdwk_create") == true) goto L13;
        r102.add(new C6475a(r108, r103.optString(r108)));     // Catch: Exception -> L25
    L25:
        kq7.a.a("AddressParam");
        goto L26
    }
}
