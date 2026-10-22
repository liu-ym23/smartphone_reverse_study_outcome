package qo9;

import android.os.Handler;
import com.larus.utils.t0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class d implements dw8.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f534270a;

    public d(c r100) {
        this.f534270a = r100;
    }

    @Override // dw8.o
    public final void l2(int r100) {
        c r101 = this.f534270a;
        r101.f534264g = RangesKt.coerceAtLeast(r100, 0);
        c r102 = this.f534270a;
        r102.getClass();
        Handler r103 = t0.f375468a;
        r103.removeCallbacks(r102.f534268k);
        r103.postDelayed(r102.f534268k, 80);
    }
}
