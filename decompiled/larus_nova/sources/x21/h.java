package x21;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f562216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f562217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f562218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f562219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IBaseBattleSetting f562220e;

    public h(long r100, long r101, int r102, IBaseBattleSetting r103) {
        Intrinsics.checkNotNullParameter(r103, "setting");
        this.f562217b = r100;
        this.f562218c = r101;
        this.f562219d = r102;
        this.f562220e = r103;
        this.f562216a = true;
    }
}
