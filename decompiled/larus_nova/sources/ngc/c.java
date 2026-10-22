package ngc;

import com.ss.android.vesdk.VEAudioCaptureSettings;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Callable<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VEAudioCaptureSettings f519088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f519089b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() throws Exception {
        return Integer.valueOf(this.f519089b.f519095b.init(this.f519088a));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Integer call() throws Exception {
        return call();
    }

    public c(f r100, VEAudioCaptureSettings r101) {
        this.f519089b = r100;
        this.f519088a = r101;
    }
}
