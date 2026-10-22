package cx;

import com.bytedance.android.latch.LatchOptions;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements LatchOptions.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f465672a = null;

    static {
        f465672a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.android.latch.LatchOptions.a
    public final void a(String r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "pageUrl");
    }

    @Override // com.bytedance.android.latch.LatchOptions.a
    public final void b(String r100, int r101, String r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "pageUrl");
        Intrinsics.checkNotNullParameter(r102, "message");
        Intrinsics.checkNotNullParameter(r103, "extra");
    }
}
