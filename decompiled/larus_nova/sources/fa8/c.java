package fa8;

import com.larus.audio.call.RealtimeCallParam;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c extends com.larus.audio.call.play.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicBoolean f476043x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f476044y;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.play.c, u68.c
    public final void init() {
        i(this.f476044y);
        super.init();
    }

    @Override // com.larus.audio.call.play.c, u68.a
    public final void release(boolean r100) {
        j(this.f476044y);
        super.release(r100);
    }

    public c(RealtimeCallParam r100, Integer r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "realtimeCallParam");
        super(r100, false, false, r101, r102);
        this.f476043x = new AtomicBoolean(false);
        this.f476044y = new d(this);
    }
}
