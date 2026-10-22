package com.bytedance.manager;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.flow_audio.api.foundation.player.AudioPlayerStatus;
import com.bytedance.flow_audio.api.player.KmpAudioPlayerErrorEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements uw5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lp7.c<uw5.b> f265477a;

    @Override // uw5.b
    public final int c() {
        return 0;
    }

    @Override // uw5.b
    public final void a() {
        Iterator<T> r100 = this.f265477a.a().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((uw5.b) r100.next()).a();
        goto L4
    }

    public a(uw5.b... r100) {
        Intrinsics.checkNotNullParameter(r100, "listeners");
        lp7.c<uw5.b> r101 = new lp7.c();
        this.f265477a = r101;
        List r102 = ArraysKt.toList(r100);
        Intrinsics.checkNotNullParameter(r102, SlcElement.KEY_ELEMENTS);
        ReentrantLock r103 = r101.f510235b;
        r103.lock();
        ((ArrayList) r101.f510234a).addAll(r102);     // Catch: Throwable -> L6
        r103.unlock();
        return;
    L6:
        th = move-exception;
        r103.unlock();
        throw th;
    }

    @Override // uw5.b
    public final void b(AudioPlayerStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator<T> r101 = this.f265477a.a().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((uw5.b) r101.next()).b(r100);
        goto L4
    }

    @Override // uw5.b
    public final void d(KmpAudioPlayerErrorEnum r100, uw5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Iterator<T> r102 = this.f265477a.a().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((uw5.b) r102.next()).d(r100, r101);
        goto L4
    }
}
