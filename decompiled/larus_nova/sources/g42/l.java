package g42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PinType f479964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f479965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f479966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f479967d;

    public l() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(PinType r100, Object r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "pinType");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f479964a = r100;
        this.f479965b = r101;
        this.f479966c = r102;
        this.f479967d = false;
    }
}
