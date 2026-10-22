package com.bytedance;

import android.media.AudioTrack;
import com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends AudioTrack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f199013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f199014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f199015c;

    public static final class a {
    }

    static {
    }

    @Override // android.media.AudioTrack
    public final void release() {
        if (this.f199013a == false) goto L12;
        Object r100 = this.f199015c;
        monitor-enter(r100);
        this.f199014b = true;     // Catch: Throwable -> L9
        super.release();     // Catch: Throwable -> L9
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r100);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        this.f199014b = true;
        super.release();
    }

    @Override // android.media.AudioTrack
    public final int write(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "audioData");
        boolean r103 = this.f199013a;
        if (r103 == false) goto L20;
        Object r104 = this.f199015c;
        monitor-enter(r104);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (this.f199013a == false) goto L9;
        boolean r105 = this.f199014b;     // Catch: Throwable -> L17
    L10:
        if (r105 == false) goto L14;
        lp7.a.b("SafeAudioTrack", "write() called after release()");     // Catch: Throwable -> L17
        monitor-exit(r104);
        return 0;
    L14:
        int r106 = super.write(r100, r101, r102);     // Catch: Throwable -> L17
        monitor-exit(r104);
        return r106;
    L9:
        r105 = false;
        goto L10
    L20:
        if (r103 == false) goto L22;
        boolean r107 = this.f199014b;
    L23:
        if (r107 == false) goto L27;
        lp7.a.b("SafeAudioTrack", "write() called after release()");
        return 0;
    L27:
        return super.write(r100, r101, r102);
    L22:
        r107 = false;
        goto L23
    }

    public b(int r100, int r101, int r110, int r111) {
        super(3, r100, r101, r110, r111, 1);
        IKMPAppInfoProvider r102 = xw5.a.f565227a;
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.useSafeAudioTrackEnable() != true) goto L7;
    L8:
        this.f199013a = r103;
        this.f199015c = new Object();
        return;
    L7:
        r103 = false;
        goto L8
    }
}
