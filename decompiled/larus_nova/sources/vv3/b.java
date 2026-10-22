package vv3;

import com.bytedance.applet.impl.a1;
import com.bytedance.applet.impl.b1;
import com.bytedance.applet.impl.y0;
import com.larus.platform.api.MusicOperateResult;
import com.larus.platform.api.c0;
import com.larus.platform.api.i4;
import com.larus.platform.api.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f557383a = null;

    static {
        f557383a = new b();
    }

    public b() {
    }

    @Override // com.larus.platform.api.c0
    public final void b(y0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        r100.invoke(Boolean.FALSE, "music service unavailable");
    }

    @Override // com.larus.platform.api.c0
    public final void a(m r100, b1 r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.invoke(MusicOperateResult.CANCEL);
    }

    @Override // com.larus.platform.api.c0
    public final void c(i4 r100, a1 r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.invoke(MusicOperateResult.CANCEL);
    }
}
