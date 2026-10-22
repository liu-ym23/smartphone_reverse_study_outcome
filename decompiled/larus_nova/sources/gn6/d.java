package gn6;

import androidx.camera.video.AudioStats;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.etkit.TrackModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements hn6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f481812a;

    public d() {
        fn6.c r100 = fn6.b.f477930a;
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == null) goto L5;
        double r102 = r100.b();
    L7:
        if (r102 >= 0) goto L9;
    L12:
        this.f481812a = r101;
        return;
    L9:
        if (r102 > 1) goto L12;
        r101 = r102;
        goto L12
    L5:
        r102 = 0.0d;
        goto L7
    }

    @Override // hn6.e
    public final boolean a(TrackModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (Random.Default.nextDouble() <= this.f481812a) goto L5;
        return true;
    L5:
        return false;
    }
}
