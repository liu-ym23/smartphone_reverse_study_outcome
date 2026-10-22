package p18;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import j18.d;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OPTrace f527326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f527327b;

    public static class a implements hyb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OPTrace f527328a;

        public a(OPTrace r100) {
            this.f527328a = r100;
        }

        @Override // hyb.a
        public final void d(String r100, Object... r101) {
            this.f527328a.d("OpenAPI_".concat(r100), r101);
        }

        @Override // hyb.a
        public final void e(String r100, Object... r101) {
            this.f527328a.e("OpenAPI_".concat(r100), r101);
        }

        @Override // hyb.a
        public final void i(String r100, Object... r101) {
            this.f527328a.i("OpenAPI_".concat(r100), r101);
        }

        @Override // hyb.a
        public final void w(String r100, Object... r101) {
            this.f527328a.w("OpenAPI_LKPluginManagerImpl", r101);
        }
    }

    public b() {
        this.f527326a = null;
        OPTrace r100 = gyb.a.a().subTrace();
        this.f527326a = r100;
        Log.e("LKEventContextImpl", "opTrace is null");
        if (this.f527327b != null) goto L6;
        this.f527327b = new a(r100);
        return;
    }
}
