package b88;

import com.larus.platform.api.l0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements b {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // b88.b
    public final void c(float r1) {
    }

    @Override // b88.b
    public final void d(float r1) {
    }

    @Override // b88.b
    public final float e() {
        return 1.0f;
    }

    @Override // b88.b
    public final int f() {
        return 0;
    }

    @Override // b88.b
    public final int getAudioDuration() {
        return 0;
    }

    @Override // b88.b
    public final void h(boolean r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "pausedReason");
    }

    @Override // b88.b
    public final void i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    @Override // b88.b
    public final boolean isWorking() {
        return false;
    }

    @Override // b88.b
    public final boolean j(int r1, l0 r2) {
        return false;
    }

    @Override // b88.b
    public final int k() {
        return 0;
    }

    @Override // b88.b
    public final void release() {
    }

    @Override // b88.b
    public final void setLooping(boolean r1) {
    }

    @Override // b88.b
    public final void g(Function0<Unit> r1) {
        if (r1 == null) goto L5;
        r1.invoke();
        return;
    }
}
