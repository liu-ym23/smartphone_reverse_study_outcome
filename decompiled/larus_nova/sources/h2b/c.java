package h2b;

import com.ss.android.lark.export.entity.PreviewHangPoint;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, PreviewHangPoint> f483636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f483637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, xcb.b> f483638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f483639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f483640e;

    @Override // h2b.a
    public int getType() {
        return this.f483637b;
    }

    public c(Map r100, Map r101, List r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "renderMap");
        Intrinsics.checkNotNullParameter(r102, "elementIds");
        this.f483636a = r100;
        this.f483637b = 4;
        this.f483638c = r101;
        this.f483639d = r102;
        this.f483640e = r103;
    }
}
