package kc;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.crash.dumper.Scraps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<C6534a> f502353a;

    /* JADX INFO: renamed from: kc.a$a, reason: collision with other inner class name */
    public static class C6534a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f502354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f502355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f502356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f502357d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f502358e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f502359f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public C6535a f502360g;

        /* JADX INFO: renamed from: kc.a$a$a, reason: collision with other inner class name */
        public static final class C6535a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public BcmParams f502361a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public BcmParams f502362b;

            public C6535a() {
            }
        }

        public C6534a() {
        }

        public JSONObject a() {
            JSONObject r100 = new JSONObject();
            r100.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, this.f502355b);     // Catch: Throwable -> L19
            r100.put("btm", this.f502356c);     // Catch: Throwable -> L19
            r100.put("btm_show_id", this.f502358e);     // Catch: Throwable -> L19
            JSONObject r101 = new JSONObject();     // Catch: Throwable -> L19
            C6535a r102 = this.f502360g;     // Catch: Throwable -> L18
            JSONObject r103 = null;
            if (r102 == null) goto L9;
            BcmParams r104 = r102.f502361a;     // Catch: Throwable -> L18
            if (r104 == null) goto L9;
            JSONObject r105 = r104.toJSONObject();     // Catch: Throwable -> L18
        L10:
            r101.put("page", r105);     // Catch: Throwable -> L18
            C6535a r106 = this.f502360g;     // Catch: Throwable -> L18
            if (r106 == null) goto L15;
            BcmParams r107 = r106.f502362b;     // Catch: Throwable -> L18
            if (r107 == null) goto L15;
            r103 = r107.toJSONObject();     // Catch: Throwable -> L18
        L15:
            r101.put(Scraps.INNER_UNIT, r103);     // Catch: Throwable -> L18
        L9:
            r105 = null;
        L16:
            r100.put("content", r101);     // Catch: Throwable -> L19
            r100.put("jump_with_token", this.f502359f);     // Catch: Throwable -> L19
        L17:
            return r100;
        }
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L12
        Iterator<T> r102 = this.f502353a.iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L9;
        r101.put(((C6534a) r102.next()).a());     // Catch: Throwable -> L11
    L9:
        r100.put("chain", r101);     // Catch: Throwable -> L12
        r100.put("bcm_chain_id", UUID.randomUUID().toString());     // Catch: Throwable -> L12
    L10:
        return r100;
    }

    public a() {
        this.f502353a = new ArrayList();
    }
}
