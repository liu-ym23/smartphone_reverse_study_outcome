package qa2;

import com.bytedance.android.live.base.model.message.g3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f532237a;

    public j(k r100) {
        this.f532237a = r100;
    }

    @Override // qa2.a
    public final void a(f52.j<g3> r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        k r101 = this.f532237a;
        r101.f532240c = r100;
        r101.f532245h = r100.f475631m.getTriggerTimestamp();
    }

    @Override // qa2.a
    public final void b(f52.j<g3> r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f532237a.f532240c = null;
    }
}
