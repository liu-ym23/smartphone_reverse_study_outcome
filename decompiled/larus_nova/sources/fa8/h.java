package fa8;

import android.media.AudioTrack;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.avlink.n1;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h implements AudioTrack.OnPlaybackPositionUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f476064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f476065b;

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onPeriodicNotification(AudioTrack r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
    }

    public h(f r100) {
        this.f476064a = r100;
        this.f476065b = "reply end with empty buffers";
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onMarkerReached(AudioTrack r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        f r101 = this.f476064a;
        ReentrantLock r102 = r101.f476054h;
        String r103 = this.f476065b;
        r102.lock();
    L16:
        th = move-exception;
        r102.unlock();
        throw th;
    L4:
        if (r101.f476053g == true) goto L6;
    L10:
        boolean r104 = false;
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r102.unlock();
        if (r104 == false) goto L21;
        n1.d("StereoAudioPlayer", "[" + this.f476065b + "]:onMarkerReached play end.");
        u68.a.b.C7839a.a(this.f476064a.f476056j);
        return;
    L21:
        return;
    L6:
        if (r101.f476057k == false) goto L10;
        if (r101.f476059m == false) goto L10;
        r104 = r101.c(r103);     // Catch: Throwable -> L16
        goto L11
    }
}
