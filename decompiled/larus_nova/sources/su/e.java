package su;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, d> f543580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f543581b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f543582a = null;

        static {
            f543582a = new e();
        }
    }

    public e() {
        HashMap r100 = new HashMap();
        this.f543580a = r100;
        r100.put("android.permission.CAMERA", new b());
        Map<String, d> r101 = this.f543580a;
        HashMap r102 = (HashMap) r101;
        r102.put("android.permission.RECORD_AUDIO", new su.a());
        this.f543581b = new c();
    }

    @Override // su.d
    public final boolean a(Context r100, String r101) {
        if (((HashMap) this.f543580a).containsKey(r101) == false) goto L6;
        return ((d) ((HashMap) this.f543580a).get(r101)).a(r100, r101);
    L6:
        return this.f543581b.a(r100, r101);
    }
}
