package android.ss.com.vboost.i;

import android.ss.com.vboost.CapabilityType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<CapabilityType, Object> f141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<CapabilityType, Object> f142b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final k f143a = null;

        static {
            f143a = new k();
        }

        public static /* synthetic */ k a() {
            return f143a;
        }
    }

    public k() {
        this.f141a = new HashMap();
        this.f142b = new HashMap();
    }

    public static k a() {
        return a.a();
    }

    public <T extends Map> T a(g r2, CapabilityType r3) {
        if (g.f130a != r2) goto L7;
        Map<CapabilityType, Object> r4 = this.f141a;
    L6:
        return (T) r4.get(r3);
    L7:
        r4 = this.f142b;
        goto L6
    }

    public <T extends Map> void a(g r2, CapabilityType r3, T r4) {
        if (g.f130a != r2) goto L5;
        Map<CapabilityType, Object> r5 = this.f141a;
    L6:
        r5.put(r3, r4);
        return;
    L5:
        r5 = this.f142b;
        goto L6
    }
}
