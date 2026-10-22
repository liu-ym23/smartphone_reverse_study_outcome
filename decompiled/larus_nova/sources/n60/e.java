package n60;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, d> f518096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f518097b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f518098a = null;

        static {
            f518098a = new e();
        }
    }

    public e() {
        HashMap r100 = new HashMap();
        this.f518096a = r100;
        r100.put("android.permission.CAMERA", new b());
        Map<String, d> r101 = this.f518096a;
        HashMap r102 = (HashMap) r101;
        r102.put("android.permission.RECORD_AUDIO", new n60.a());
        this.f518097b = new c();
    }

    @Override // n60.d
    public final boolean a(Context r100, String r101) {
        if (((HashMap) this.f518096a).containsKey(r101) == false) goto L6;
        return ((d) ((HashMap) this.f518096a).get(r101)).a(r100, r101);
    L6:
        return this.f518097b.a(r100, r101);
    }

    public final boolean b(Context r100, String[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (a(r100, r101[r103]) == false) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }
}
