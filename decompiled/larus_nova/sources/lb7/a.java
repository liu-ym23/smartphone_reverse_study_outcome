package lb7;

import android.text.TextUtils;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.account.k;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import wqa.i;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f508352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f508354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<i> f508355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f508356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f508358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f508359h;

    /* JADX INFO: renamed from: lb7.a$a, reason: collision with other inner class name */
    public static class C6671a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f508360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f508361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f508362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<i> f508363d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f508364e;

        public final a c() {
            if (TextUtils.isEmpty(this.f508361b) == false) goto L6;
            this.f508361b = MonitorConstants.CONNECT_TYPE_GET;
        L6:
            return new a(this.f508360a, this.f508361b, this.f508362c, this.f508363d, null, null, false, this.f508364e);
        }

        public final void d() {
            if (this.f508362c != null) goto L5;
            this.f508362c = new HashMap();
        L5:
            k.d().d();
            this.f508362c.put("multi_login", "1");
        }

        public C6671a() {
            this.f508364e = 0;
        }

        public final a h() {
            this.f508361b = UGCMonitor.TYPE_POST;
            return c();
        }

        public final void b(i r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (this.f508363d != null) goto L7;
            this.f508363d = new ArrayList();
        L7:
            this.f508363d.add(r100);
        }

        public final void f(Map r100) {
            if (this.f508362c != null) goto L5;
            this.f508362c = r100;
            return;
        L5:
            if (r100 == null) goto L12;
            Iterator r101 = r100.entrySet().iterator();
        L8:
            if (r101.hasNext() == false) goto L13;
            Map.Entry r102 = (Map.Entry) r101.next();
            Map<String, String> r103 = this.f508362c;
            Object r104 = r102.getKey();
            r103.put((String) r104, (String) r102.getValue());
            goto L8
        L13:
            return;
        }

        public final void a(String r100, String r101) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r101) == false) goto L8;
            return;
        L8:
            if (this.f508363d != null) goto L10;
            this.f508363d = new ArrayList();
        L10:
            this.f508363d.add(new i(r100, r101));
        }

        public final void e(String r100, String r101) {
            if (this.f508362c != null) goto L5;
            this.f508362c = new HashMap();
        L5:
            this.f508362c.put(r100, r101);
        }

        public final void g(Map r100, Map r101) {
            if (this.f508362c != null) goto L5;
            this.f508362c = new HashMap();
        L5:
            Iterator r102 = ((HashMap) r100).entrySet().iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            Map.Entry r103 = (Map.Entry) r102.next();
            Map<String, String> r104 = this.f508362c;
            Object r105 = r103.getKey();
            r104.put((String) r105, (String) r103.getValue());
            goto L7
        L9:
            if (r101 != null) goto L11;
            return;
        L11:
            if (r101.isEmpty() == true) goto L29;
            Iterator r106 = r101.keySet().iterator();
        L14:
            if (r106.hasNext() == false) goto L30;
            String r107 = (String) r106.next();
            if (TextUtils.isEmpty(r107) == true) goto L14;
            if (r101.get(r107) == null) goto L14;
            this.f508362c.put(r107, (String) r101.get(r107));
            goto L14
        L30:
            return;
        }
    }

    public final String a(String r100) {
        Map<String, String> r101 = this.f508354c;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    public a(String r100, String r101, Map<String, String> r102, List<i> r103, String r104, String r105, boolean r106, int r107) {
        this.f508352a = r100;
        this.f508353b = r101;
        this.f508354c = r102;
        this.f508356e = r104;
        this.f508357f = r105;
        this.f508355d = r103;
        this.f508358g = r106;
        this.f508359h = r107;
    }
}
