package y7a;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.performance.PerformanceController;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Long> f566645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f566646c;

    public final JavaOnlyMap c() {
        JavaOnlyMap r100 = new JavaOnlyMap();
        if (this.f566646c == false) goto L5;
        return r100;
    L5:
        r100.putString("pipelineOrigin", this.f566644a);
        r100.putMap("timestampMap", JavaOnlyMap.from(this.f566645b));
        return r100;
    }

    public h(String r100) {
        this.f566646c = false;
        this.f566644a = r100;
        this.f566645b = new HashMap();
    }

    public final void b(String r100) {
        if (this.f566646c == false) goto L5;
        return;
    L5:
        long r101 = PerformanceController.j();
        this.f566645b.put(r100, Long.valueOf(r101));
    }

    public static h a(String r100, String r101, boolean r102) {
        h r103 = new h(r100);
        r103.f566646c = r102;
        if (r102 == false) goto L5;
        return r103;
    L5:
        long r104 = PerformanceController.j();
        if (r103.f566646c == true) goto L10;
        r103.f566645b.put("pipelineStart", Long.valueOf(r104));
    L10:
        if (r103.f566646c == true) goto L13;
        r103.f566645b.put(r101, Long.valueOf(r104));
    L13:
        return r103;
    }
}
