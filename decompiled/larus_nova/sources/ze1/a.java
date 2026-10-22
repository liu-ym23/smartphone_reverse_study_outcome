package ze1;

import com.bytedance.android.livesdk.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f571505d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f571506e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f571507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f571508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f571509c;

    /* JADX INFO: renamed from: ze1.a$a, reason: collision with other inner class name */
    public static final class C8448a {
    }

    public interface b {
        void c(boolean r100);
    }

    static {
        y r100 = y.f162543a;
        f571505d = r100.getValue().getCdnSeiInvalidIntervalMS();
        f571506e = r100.getValue().getReceiveBackupSeiThreshold();
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f571509c = r100;
    }
}
