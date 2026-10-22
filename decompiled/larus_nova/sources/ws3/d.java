package ws3;

import android.text.TextUtils;
import com.bytedance.apm.util.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f560952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f560953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, a> f560954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, a> f560955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, a> f560956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, a> f560957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, a> f560958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, a> f560959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public v<m> f560960i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f560961j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, Map<String, a>> f560962k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f560963l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f560964m;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f560965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Long> f560966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f560967c;

        public final JSONObject b() {
            JSONObject r100 = new JSONObject();
            r100.put("biz", this.f560965a);     // Catch: JSONException -> L13
            r100.put("usage", this.f560967c);     // Catch: JSONException -> L13
            JSONArray r101 = new JSONArray();     // Catch: JSONException -> L13
            Map<String, Long> r102 = this.f560966b;     // Catch: JSONException -> L13
            if (r102 != null) goto L6;
        L11:
            r100.put("detail", r101);     // Catch: JSONException -> L13
            goto L12
        L6:
            if (((HashMap) r102).size() <= 0) goto L11;
            Iterator r103 = ((HashMap) this.f560966b).entrySet().iterator();     // Catch: JSONException -> L13
        L9:
            if (r103.hasNext() == false) goto L11;
            Map.Entry r104 = (Map.Entry) r103.next();     // Catch: JSONException -> L13
            JSONObject r105 = new JSONObject();     // Catch: JSONException -> L13
            r105.put("source_id", r104.getKey());     // Catch: JSONException -> L13
            r105.put("usage", r104.getValue());     // Catch: JSONException -> L13
            r101.put(r105);     // Catch: JSONException -> L13
        L12:
            return r100;
        }

        public a(String r100) {
            this.f560967c = 0;
            this.f560965a = r100;
            this.f560966b = new HashMap();
        }

        public final JSONObject c(long r100) {
            JSONObject r101 = new JSONObject();
            r101.put("biz", this.f560965a);     // Catch: JSONException -> L15
            r101.put("usage", this.f560967c);     // Catch: JSONException -> L15
            JSONArray r102 = new JSONArray();     // Catch: JSONException -> L15
            Map<String, Long> r103 = this.f560966b;     // Catch: JSONException -> L15
            if (r103 != null) goto L6;
        L13:
            r101.put("detail", r102);     // Catch: JSONException -> L15
            goto L14
        L6:
            if (((HashMap) r103).size() <= 0) goto L13;
            Iterator r104 = ((HashMap) this.f560966b).entrySet().iterator();     // Catch: JSONException -> L15
        L9:
            if (r104.hasNext() == false) goto L13;
            Map.Entry r105 = (Map.Entry) r104.next();     // Catch: JSONException -> L15
            if (((Long) r105.getValue()).longValue() < r100) goto L9;
            JSONObject r106 = new JSONObject();     // Catch: JSONException -> L15
            r106.put("source_id", r105.getKey());     // Catch: JSONException -> L15
            r106.put("usage", r105.getValue());     // Catch: JSONException -> L15
            r102.put(r106);     // Catch: JSONException -> L15
        L14:
            return r101;
        }

        public final void a(String r100, long r101) {
            if (((HashMap) this.f560966b).containsKey(r100) == false) goto L5;
            Map<String, Long> r102 = this.f560966b;
            ((HashMap) r102).put(r100, Long.valueOf(((Long) ((HashMap) r102).get(r100)).longValue() + r101));
        L6:
            this.f560967c += r101;
            return;
        L5:
            ((HashMap) this.f560966b).put(r100, Long.valueOf(r101));
            goto L6
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f560968a = null;

        static {
            f560968a = new d();
        }
    }

    public d() {
        this.f560961j = 0;
        this.f560963l = 102400.0d;
        this.f560964m = 102400.0d;
    }

    public final void a(String r100, long r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        boolean r103 = com.bytedance.apm.util.m.c(com.bytedance.apm.d.getContext());
        uu3.a r104 = (uu3.a) qu3.c.a(uu3.a.class);
        if (r104 == null) goto L8;
        boolean r105 = r104.isForeground();
    L10:
        if (this.f560954c != null) goto L13;
        this.f560954c = new HashMap();
    L13:
        if (this.f560955d != null) goto L16;
        this.f560955d = new HashMap();
    L16:
        if (this.f560956e != null) goto L19;
        this.f560956e = new HashMap();
    L19:
        if (this.f560957f != null) goto L22;
        this.f560957f = new HashMap();
    L22:
        if (this.f560958g != null) goto L25;
        this.f560958g = new HashMap();
    L25:
        if (((HashMap) this.f560954c).containsKey(r100) == false) goto L27;
        ((a) ((HashMap) this.f560954c).get(r100)).a(r102, r101);
    L28:
        if (r103 == false) goto L34;
        if (r105 == true) goto L34;
        if (((HashMap) this.f560955d).containsKey(r100) == false) goto L33;
        ((a) ((HashMap) this.f560955d).get(r100)).a(r102, r101);
        goto L34
    L33:
        a r106 = new a(r100);
        r106.a(r102, r101);
        ((HashMap) this.f560955d).put(r100, r106);
    L34:
        if (r103 == false) goto L40;
        if (r105 == false) goto L40;
        if (((HashMap) this.f560956e).containsKey(r100) == false) goto L39;
        ((a) ((HashMap) this.f560956e).get(r100)).a(r102, r101);
        goto L40
    L39:
        a r107 = new a(r100);
        r107.a(r102, r101);
        ((HashMap) this.f560956e).put(r100, r107);
    L40:
        if (r103 == true) goto L46;
        if (r105 == true) goto L46;
        if (((HashMap) this.f560957f).containsKey(r100) == false) goto L45;
        ((a) ((HashMap) this.f560957f).get(r100)).a(r102, r101);
        goto L46
    L45:
        a r108 = new a(r100);
        r108.a(r102, r101);
        ((HashMap) this.f560957f).put(r100, r108);
    L46:
        if (r103 == true) goto L53;
        if (r105 == false) goto L53;
        if (((HashMap) this.f560958g).containsKey(r100) == false) goto L51;
        ((a) ((HashMap) this.f560958g).get(r100)).a(r102, r101);
        goto L53
    L51:
        a r109 = new a(r100);
        r109.a(r102, r101);
        ((HashMap) this.f560958g).put(r100, r109);
    L53:
        if (this.f560959h != null) goto L56;
        this.f560959h = new HashMap();
    L56:
        if (((HashMap) this.f560959h).containsKey(r100) == false) goto L58;
        ((a) ((HashMap) this.f560959h).get(r100)).a(r102, r101);
    L59:
        Map<String, Map<String, a>> r110 = this.f560962k;
        if (r110 == null) goto L68;
        Iterator r111 = ((HashMap) r110).entrySet().iterator();
    L63:
        if (r111.hasNext() == false) goto L75;
        Map r112 = (Map) ((Map.Entry) r111.next()).getValue();
        if (r112.containsKey(r100) == true) goto L66;
        a r113 = new a(r100);
        r113.a(r102, r101);
        r112.put(r100, r113);
        goto L63
    L66:
        ((a) r112.get(r100)).a(r102, r101);
        goto L63
    L75:
        return;
    L68:
        return;
    L58:
        a r114 = new a(r100);
        r114.a(r102, r101);
        ((HashMap) this.f560959h).put(r100, r114);
        goto L59
    L27:
        a r115 = new a(r100);
        r115.a(r102, r101);
        ((HashMap) this.f560954c).put(r100, r115);
        goto L28
    L8:
        r105 = false;
        goto L10
    }
}
