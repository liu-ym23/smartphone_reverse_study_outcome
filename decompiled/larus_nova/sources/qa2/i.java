package qa2;

import com.bytedance.android.live.base.model.message.g3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f532236a;

    public i(k r100) {
        this.f532236a = r100;
    }

    @Override // qa2.a
    public final void a(f52.j<g3> r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f532236a.f532239b = r100;
    }

    @Override // qa2.a
    public final void b(f52.j<g3> r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        k r101 = this.f532236a;
        r101.f532243f = System.currentTimeMillis();
        this.f532236a.f532239b = null;
    }
}
