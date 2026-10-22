package jz2;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f501101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f501102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f501103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f501104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f501105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f501106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f501107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f501108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f501109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f501110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f501111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.monitorV2.webview.b f501112l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f501113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f501114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f501115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f501116d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public JSONObject f501117e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public JSONObject f501118f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public JSONObject f501119g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public JSONObject f501120h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f501121i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f501122j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f501123k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public com.bytedance.android.monitorV2.webview.b f501124l;

        public final d a() {
            d r100 = new d();
            r100.f501103c = this.f501115c;
            String r101 = this.f501113a;
            String r102 = "";
            if (r101 != null) goto L6;
            r101 = "";
        L6:
            r100.f501101a = r101;
            String r103 = this.f501114b;
            if (r103 == null) goto L9;
            r102 = r103;
        L9:
            r100.f501102b = r102;
            JSONObject r104 = this.f501116d;
            if (r104 != null) goto L13;
            r104 = new JSONObject();
        L13:
            r100.f501104d = r104;
            JSONObject r105 = this.f501117e;
            if (r105 != null) goto L17;
            r105 = new JSONObject();
        L17:
            r100.f501105e = r105;
            JSONObject r106 = this.f501118f;
            if (r106 != null) goto L21;
            r106 = new JSONObject();
        L21:
            r100.f501106f = r106;
            r100.f501111k = this.f501123k;
            JSONObject r107 = this.f501119g;
            if (r107 != null) goto L25;
            r107 = new JSONObject();
        L25:
            this.f501119g = r107;
            r100.f501107g = r107;
            JSONObject r108 = this.f501120h;
            if (r108 != null) goto L29;
            r108 = new JSONObject();
        L29:
            r100.f501108h = r108;
            r100.f501110j = this.f501122j;
            r100.f501109i = this.f501121i;
            com.bytedance.android.monitorV2.webview.b r109 = this.f501124l;
            if (r109 != null) goto L33;
            r109 = com.bytedance.android.monitorV2.g.e().f163046g.f162987a;
        L33:
            r100.f501112l = r109;
            return r100;
        }

        public a(String r100) {
            this.f501115c = r100;
        }

        public final void b(int r100) {
            if (r100 < 0) goto L5;
            if (r100 > 8) goto L5;
        L6:
            this.f501123k = r100;
            return;
        L5:
            r100 = 8;
            goto L6
        }
    }

    public final String toString() {
        return "CustomInfo{url='" + this.f501101a + "', bid='" + this.f501102b + "', eventName='" + this.f501103c + "', vid='" + this.f501110j + "', canSample=" + this.f501111k + ", monitorId=" + this.f501109i + '}';
    }

    public d() {
        new HashMap();
    }
}
