package oj6;

import com.bytedance.live.livelink.kmp.impl.extend.ExtendContext;
import com.bytedance.live.livelink.kmp.impl.extend.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExtendContext f523581a;

    @Override // com.bytedance.live.livelink.kmp.impl.extend.b
    public final ExtendContext c() {
        return this.f523581a;
    }

    public a(ExtendContext r100) {
        Intrinsics.checkNotNullParameter(r100, "extendContext");
        this.f523581a = r100;
    }
}
