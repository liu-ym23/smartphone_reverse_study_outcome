package ix;

import com.bytedance.android.latch.LatchOptions;
import com.bytedance.android.latch.prefetch.internal.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a extends LatchOptions {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x f496313e;

    public a(LatchOptions.ScriptContentLoader r100) {
        Intrinsics.checkNotNullParameter(r100, "scriptContentLoader");
        super(r100);
        this.f496313e = jx.a.f500744a;
    }
}
