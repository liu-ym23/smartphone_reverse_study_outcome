package v2;

import com.bytedance.ai.applet.base.log.b;
import com.bytedance.ai.applet.base.log.h;
import com.bytedance.applet.base.e;
import g2.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f552660a;

    public a() {
        e r100 = e.f191459a;
        Intrinsics.checkNotNullParameter(r100, "logger");
        this.f552660a = r100;
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f552660a.d(r100, h.a(r101));
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f552660a.i(r100, h.a(r101));
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f552660a.e(r100, h.a(r101), r102);
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f552660a.w(r100, h.a(r101), r102);
    }
}
