package n95;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements n95.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<g>> f518406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Map<String, String> f518407b;

    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Map<String, List<g>> f518408e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f518409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, List<g>> f518410b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f518411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f518412d;

        static {
            String r100 = System.getProperty("http.agent");
            HashMap r101 = new HashMap(2);
            if (TextUtils.isEmpty(r100) == true) goto L5;
            r101.put("User-Agent", Collections.singletonList(new b(r100)));
        L5:
            r101.put("Accept-Encoding", Collections.singletonList(new b(DownloadHelper.IDENTITY)));
            f518408e = Collections.unmodifiableMap(r101);
        }

        public a() {
            this.f518409a = true;
            this.f518410b = f518408e;
            this.f518411c = true;
            this.f518412d = true;
        }

        public final void a(String r100, String r101) {
            if (r101 != null) goto L4;
            b r102 = null;
        L6:
            if (this.f518409a == false) goto L12;
            this.f518409a = false;
            HashMap r103 = new HashMap(this.f518410b.size());
            Iterator<Map.Entry<String, List<g>>> r104 = this.f518410b.entrySet().iterator();
        L9:
            if (r104.hasNext() == false) goto L11;
            Map.Entry<String, List<g>> r105 = r104.next();
            r103.put(r105.getKey(), new ArrayList(r105.getValue()));
            goto L9
        L11:
            this.f518410b = r103;
        L12:
            if (r102 != null) goto L14;
            this.f518410b.remove(r100);
        L19:
            if (this.f518411c == false) goto L24;
            if ("Accept-Encoding".equalsIgnoreCase(r100) == false) goto L24;
            this.f518411c = false;
        L24:
            if (this.f518412d == true) goto L26;
            return;
        L26:
            if ("User-Agent".equalsIgnoreCase(r100) == false) goto L31;
            this.f518412d = false;
            return;
        L31:
            return;
        L14:
            List<g> r106 = this.f518410b.get(r100);
            if (r106 != null) goto L17;
            r106 = new ArrayList();
            this.f518410b.put(r100, r106);
        L17:
            r106.clear();
            r106.add(r102);
            goto L19
        L4:
            r102 = new b(r101);
            goto L6
        }
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f518413a;

        public final int hashCode() {
            return this.f518413a.hashCode();
        }

        public final String toString() {
            return "StringHeaderFactory{value='" + this.f518413a + "'}";
        }

        @Override // n95.g
        public final String buildHeader() {
            return this.f518413a;
        }

        public b(String r100) {
            this.f518413a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof b) == true) goto L5;
            return false;
        L5:
            return this.f518413a.equals(((b) r100).f518413a);
        }
    }

    public final Map<String, String> a() {
        HashMap r100 = new HashMap();
        Iterator<Map.Entry<String, List<g>>> r101 = this.f518406a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<String, List<g>> r102 = r101.next();
        StringBuilder r103 = new StringBuilder();
        List<g> r104 = r102.getValue();
        int r105 = 0;
    L7:
        if (r105 >= r104.size()) goto L12;
        r103.append(((g) ListProtector.get(r104, r105)).buildHeader());
        if (r105 == (r104.size() - 1)) goto L11;
        r103.append(',');
    L11:
        r105 = r105 + 1;
        goto L7
    L12:
        r100.put(r102.getKey(), r103.toString());
        goto L4
    L13:
        return r100;
    }

    public final int hashCode() {
        return this.f518406a.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f518406a + '}';
    }

    public h(Map<String, List<g>> r100) {
        this.f518406a = Collections.unmodifiableMap(r100);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof h) == true) goto L5;
        return false;
    L5:
        return this.f518406a.equals(((h) r100).f518406a);
    }
}
