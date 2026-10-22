package jx;

import com.bytedance.android.latch.prefetch.internal.q;
import com.bytedance.android.latch.prefetch.internal.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f500744a = null;

    static {
        f500744a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.android.latch.prefetch.internal.x
    public final q a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageUrl");
        return null;
    }

    @Override // com.bytedance.android.latch.prefetch.internal.x
    public final void reload(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageUrl");
    }
}
