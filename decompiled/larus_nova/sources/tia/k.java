package tia;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k implements com.larus.audio.call.record.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hga.c f546311a;

    @Override // com.larus.audio.call.record.j
    public final int a() {
        return this.f546311a.a();
    }

    @Override // com.larus.audio.call.record.j
    public final void release() {
        this.f546311a.release();
    }

    @Override // com.larus.audio.call.record.j
    public final boolean start() {
        this.f546311a.start();
        return true;
    }

    @Override // com.larus.audio.call.record.j
    public final void stop() {
        this.f546311a.stop();
    }

    public k(e r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f546311a = r100;
    }

    @Override // com.larus.audio.call.record.j
    public final int read(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        return this.f546311a.read(r100);
    }
}
