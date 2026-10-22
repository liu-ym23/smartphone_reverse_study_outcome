package ha9;

import com.larus.flowsdk.common.experiment.FlowABValueType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f484424a = null;

    static {
        f484424a = new g();
    }

    public g() {
    }

    @Override // ha9.b
    public final void a(String r100, ga9.f<?> r101, ga9.f<?> r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "existing");
        Intrinsics.checkNotNullParameter(r102, "incoming");
    }

    @Override // ha9.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
    }

    @Override // ha9.b
    public final void c(String r100, FlowABValueType r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "expected");
    }
}
