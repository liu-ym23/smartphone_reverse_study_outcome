package uz0;

import com.bytedance.android.live.revenue.platform.network.api.dsl.RequestDSL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@RequestDSL
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f552160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f552161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<String>> f552162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.revenue.network.a> f552163d;

    public a() {
        this.f552160a = new LinkedHashMap();
        this.f552161b = new LinkedHashMap();
        this.f552162c = new LinkedHashMap();
        this.f552163d = new ArrayList();
    }

    @RequestDSL
    public final void a(com.bytedance.android.livesdk.revenue.network.a r100) {
        Intrinsics.checkNotNullParameter(r100, "middleware");
        ((ArrayList) this.f552163d).add(r100);
    }

    @RequestDSL
    public final void query(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f552161b.put(r100, r101);
    }

    @RequestDSL
    public final void query(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "values");
        this.f552162c.put(r100, r101);
    }
}
