package vv3;

import com.bytedance.applet.impl.a1;
import com.bytedance.applet.impl.b1;
import com.bytedance.applet.impl.y0;
import com.larus.platform.api.MusicOperateResult;
import com.larus.platform.api.c0;
import com.larus.platform.api.i4;
import com.larus.platform.api.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements c0 {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void b(y0 r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        r3.invoke(Boolean.FALSE, "music service unavailable");
    }

    public final void a(m r2, b1 r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "callback");
        r3.invoke(MusicOperateResult.CANCEL);
    }

    public final void c(i4 r2, a1 r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "callback");
        r3.invoke(MusicOperateResult.CANCEL);
    }
}
