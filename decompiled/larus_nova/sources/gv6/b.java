package gv6;

import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesLynxDSLResponse;
import com.bytedance.locallife.live.msgcenter.interfaces.ReleaseScene;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import qv6.f;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements pv6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveGoodsShelvesLynxDSLResponse f482829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f482830b;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // pv6.a
    public final void a(ReleaseScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // pv6.a
    public final void b(String r100, com.bytedance.locallife.live.msgcenter.b r101) {
        Intrinsics.checkNotNullParameter(r101, "subscriber");
    }

    @Override // pv6.a
    public final void d(String r100, com.bytedance.locallife.live.msgcenter.b r101) {
        Intrinsics.checkNotNullParameter(r101, "subscriber");
    }

    @Override // pv6.a
    public final Object l8(String r100) {
        LiveGoodsShelvesLynxDSLResponse r101 = this.f482829a;
        if (r101 == null) goto L9;
        Map<String, Object> r102 = r101.f259573g;
        if (r102 == null) goto L9;
        Object r103 = r102.get(r100);
        if (r103 == null) goto L9;
        return r103;
    L9:
        return null;
    }

    @Override // pv6.a
    public final void c(String r100, Object r101, Boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "dataName");
        Intrinsics.checkNotNullParameter(r101, "updateData");
        LiveGoodsShelvesLynxDSLResponse r111 = this.f482829a;
        if (r111 == null) goto L8;
        r111.g(r100, r101);
        f r102 = this.f482830b;
        if (r102 == null) goto L9;
        r102.d(this.f482829a, false, null, null, null, null);
        return;
    L9:
        return;
    }
}
