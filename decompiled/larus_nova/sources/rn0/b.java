package rn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import pn0.g;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements rn0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<pn0.a> f538646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<pn0.a> f538647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, LayoutConfigModel> f538648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, HashMap<String, String>> f538649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, String> f538650e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, LayoutConfigModel> f538651f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ln0.b f538652g;

    public static final class a {
    }

    static {
    }

    @Override // rn0.a
    public final String a() {
        return this.f538652g.f509967a;
    }

    @Override // rn0.a
    public final String b() {
        return this.f538652g.f509968b;
    }

    @Override // rn0.a
    public final nn0.b c() {
        return this.f538652g.f509970d;
    }

    @Override // rn0.a
    public final pn0.b d() {
        return this.f538652g.f509969c;
    }

    public b(ln0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutCoreConfig");
        this.f538652g = r100;
        this.f538646a = new ArrayList();
        this.f538647b = new ArrayList();
        this.f538648c = new HashMap();
        this.f538649d = new HashMap();
        this.f538650e = new HashMap();
        this.f538651f = new HashMap();
    }

    public final void e(pn0.d r100, LayoutConfigModel r101, LayoutConfigModel r102, g r103, ProducerResStep r104, on0.a r105) {
        this.f538652g.f509970d.c().d(r100, r103, r101, r102);
        r105.a(r100, new pn0.e(r101, r104));
    }
}
