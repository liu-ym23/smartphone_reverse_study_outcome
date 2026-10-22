package g42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PinType f479950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f479951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f479952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f479953d;

    public /* synthetic */ h(PinType r100, Object r101, long r102) {
        this(r100, r101, r102, String.valueOf(r102));
    }

    public h(PinType r100, T r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "pinType");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f479950a = r100;
        this.f479951b = r101;
        this.f479952c = r102;
        this.f479953d = r103;
    }
}
