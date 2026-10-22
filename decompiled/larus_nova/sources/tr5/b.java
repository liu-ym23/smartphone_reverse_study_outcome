package tr5;

import as5.c;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f547307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f547308b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f547309a = null;

        static {
            f547309a = new b();
        }
    }

    public b() {
        this.f547308b = true;
        this.f547307a = new c();
    }

    public static bs5.a a(pxb.a r100) {
        txb.b r101 = r100.getServiceManager();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (((bs5.a) r101.getService(bs5.a.class)) != null) goto L8;
        r101.b(bs5.b.class);
    L8:
        return (bs5.a) r101.getService(bs5.a.class);
    }

    public static void b(pxb.a r100) {
        if (r100.getSettings() != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        Log.i("NativeRenderManager", "inject LarkNativeComponentConfig, enable = " + r101);
        r100.b(new wr5.a());
        return;
    L5:
        if (r100.getSettings().a() == false) goto L7;
        r101 = true;
        goto L8
    }
}
