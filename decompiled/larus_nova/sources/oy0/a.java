package oy0;

import com.bytedance.platform.aio.Severity;
import com.bytedance.platform.aio.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f527122b = null;

    public a() {
    }

    @Override // com.bytedance.platform.aio.b
    public final void a(Severity r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "severity");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "message");
    }

    @Override // com.bytedance.platform.aio.b
    public final boolean b(Severity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "severity");
        Intrinsics.checkNotNullParameter(r101, "tag");
        return false;
    }

    static {
        f527122b = new a();
    }
}
