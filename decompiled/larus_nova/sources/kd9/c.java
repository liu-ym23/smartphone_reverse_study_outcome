package kd9;

import com.larus.audio.call.play.AVInnerPlayerAdapter$linkPlayerCallback$1;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c implements com.larus.im.service.audio.r, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f502864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<com.larus.im.service.audio.p> f502865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.im.service.audio.r f502866c;

    @Override // com.larus.im.service.audio.r
    public final boolean a() {
        ReentrantLock r100 = this.f502864a;
        r100.lock();
        com.larus.im.service.audio.r r101 = this.f502866c;     // Catch: Throwable -> L10
        r100.unlock();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.a() != true) goto L16;
        return true;
    L16:
        return false;
    L10:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // com.larus.im.service.audio.r
    public final boolean isPlaying() {
        ReentrantLock r100 = this.f502864a;
        r100.lock();
        com.larus.im.service.audio.r r101 = this.f502866c;     // Catch: Throwable -> L10
        r100.unlock();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.isPlaying() != true) goto L16;
        return true;
    L16:
        return false;
    L10:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public c() {
        this.f502864a = new ReentrantLock();
        this.f502865b = new LinkedHashSet();
    }

    @Override // kd9.r
    public final void j(s r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        ReentrantLock r101 = this.f502864a;
        r101.lock();
        com.larus.im.service.audio.r r102 = this.f502866c;     // Catch: Throwable -> L12
        if ((r102 instanceof r) == false) goto L7;
        r r103 = (r) r102;     // Catch: Throwable -> L12
    L8:
        r101.unlock();
        if (r103 == null) goto L17;
        r103.j(r100);
        return;
    L17:
        return;
    L7:
        r103 = null;
    L12:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // com.larus.im.service.audio.r
    public final void l(com.larus.im.service.audio.p r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ReentrantLock r101 = this.f502864a;
        r101.lock();
        this.f502865b.add(r100);     // Catch: Throwable -> L8
        com.larus.im.service.audio.r r102 = this.f502866c;     // Catch: Throwable -> L8
        r101.unlock();
        if (r102 == null) goto L13;
        r102.l(r100);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // com.larus.im.service.audio.r
    public final void q(AVInnerPlayerAdapter$linkPlayerCallback$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ReentrantLock r101 = this.f502864a;
        r101.lock();
        this.f502865b.remove(r100);     // Catch: Throwable -> L8
        com.larus.im.service.audio.r r102 = this.f502866c;     // Catch: Throwable -> L8
        r101.unlock();
        if (r102 == null) goto L13;
        r102.q(r100);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // kd9.r
    public final void s(s r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        ReentrantLock r101 = this.f502864a;
        r101.lock();
        com.larus.im.service.audio.r r102 = this.f502866c;     // Catch: Throwable -> L12
        if ((r102 instanceof r) == false) goto L7;
        r r103 = (r) r102;     // Catch: Throwable -> L12
    L8:
        r101.unlock();
        if (r103 == null) goto L17;
        r103.s(r100);
        return;
    L17:
        return;
    L7:
        r103 = null;
    L12:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
