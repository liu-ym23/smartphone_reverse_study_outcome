package fa8;

import android.media.AudioTrack;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.avlink.n1;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements AudioTrack.OnPlaybackPositionUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f476062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f476063b;

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onPeriodicNotification(AudioTrack r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
    }

    public g(f r100) {
        this.f476062a = r100;
        this.f476063b = "simultaneous_interpret";
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onMarkerReached(AudioTrack r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        f r101 = this.f476062a;
        ReentrantLock r102 = r101.f476054h;
        r102.lock();
    L16:
        th = move-exception;
        r102.unlock();
        throw th;
    L4:
        if (r101.f476053g == true) goto L6;
    L10:
        boolean r103 = false;
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r102.unlock();
        if (r103 == false) goto L21;
        n1.d("StereoAudioPlayer", "[" + this.f476063b + "]:onMarkerReached first frame.");
        this.f476062a.f476056j.c();
        return;
    L21:
        return;
    L6:
        if (r101.f476057k == false) goto L10;
        if (r101.f476058l == false) goto L10;
        r103 = true;
        goto L11
    }
}
