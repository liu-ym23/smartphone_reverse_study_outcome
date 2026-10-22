package rj6;

import com.bytedance.live.livelink.kmp.impl.extend.ExtendContext;
import com.bytedance.live.livelink.kmp.impl.extend.b;
import com.bytedance.live.livelink.kmp.impl.extend.c;
import dg2.i;
import kotlin.jvm.internal.Intrinsics;
import zi6.d;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements d, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExtendContext f538123a;

    /* JADX INFO: renamed from: rj6.a$a, reason: collision with other inner class name */
    public static final class C7492a {
    }

    static {
    }

    @Override // zi6.d
    public final int b() {
        ej6.a.a("SubtitleManager", "stopSubtitle");
        mi6.b r100 = c.d(this);
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.b();
    }

    @Override // com.bytedance.live.livelink.kmp.impl.extend.b
    public final ExtendContext c() {
        return this.f538123a;
    }

    public a(ExtendContext r100) {
        Intrinsics.checkNotNullParameter(r100, "extendContext");
        this.f538123a = r100;
    }

    @Override // zi6.d
    public final int a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "subtitleConfig");
        int r101 = ej6.a.f472874a;
        ej6.a.a("SubtitleManager", "startSubtitle with config: " + r100);
        mi6.b r102 = c.d(this);
        if (r102 != null) goto L7;
        return -1;
    L7:
        return r102.a(r100);
    }
}
