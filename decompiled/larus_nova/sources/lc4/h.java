package lc4;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f508424a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f508425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f508426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f508427c;

        public final h a() {
            if (this.f508427c.isEmpty() == true) goto L14;
            if (((HashMap) this.f508426b).containsKey("host") == true) goto L7;
        L12:
            return null;
        L7:
            if (((HashMap) this.f508426b).containsKey("accessKey") == false) goto L12;
            if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f508426b).get("host")) == true) goto L12;
            if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f508426b).get("accessKey")) == true) goto L12;
        L14:
            if (this.f508427c.isEmpty() == true) goto L21;
            int r100 = this.f508425a;
            if (r100 >= 0) goto L18;
        L19:
            return null;
        L18:
            if ((r100 & 15) == 0) goto L19;
        L21:
            return new h(this.f508426b);
        }

        public a() {
            this.f508425a = -1;
            this.f508426b = new HashMap();
            this.f508427c = "";
        }

        public final void b(String r100, String r101) {
            ((HashMap) this.f508426b).put("host", r100);
            ((HashMap) this.f508426b).put("accessKey", r101);
        }
    }

    public h(Map r100) {
        this.f508424a = r100;
    }
}
