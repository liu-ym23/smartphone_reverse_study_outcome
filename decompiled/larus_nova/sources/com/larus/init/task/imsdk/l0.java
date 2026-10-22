package com.larus.init.task.imsdk;

import androidx.camera.video.AudioStats;
import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l0 implements gd9.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f351385a = null;

    static {
        f351385a = new l0();
    }

    public l0() {
    }

    @Override // gd9.z
    public final boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "repo");
        return Keva.getRepo(r101, 0).contains(r100);
    }

    @Override // gd9.z
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "repo");
        Keva.getRepo(r101, 0).erase(r100);
    }

    @Override // gd9.z
    public final double g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "repo");
        return Keva.getRepo(r101, 0).getDouble(r100, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    @Override // gd9.z
    public final boolean h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "repo");
        return Keva.getRepo(r101, 0).getBoolean(r100, false);
    }

    @Override // gd9.z
    public final long l(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "repo");
        return Keva.getRepo(r101, 0).getLong(r100, 0);
    }

    @Override // gd9.z
    public final String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defValue");
        Intrinsics.checkNotNullParameter(r102, "repo");
        return Keva.getRepo(r102, 0).getString(r100, r101);
    }

    @Override // gd9.z
    public final void b(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        Keva.getRepo(r102, 0).storeLong(r100, r101);
    }

    @Override // gd9.z
    public final void e(String r100, double r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        Keva.getRepo(r102, 0).storeDouble(r100, r101);
    }

    @Override // gd9.z
    public final int f(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        return Keva.getRepo(r102, 0).getInt(r100, r101);
    }

    @Override // gd9.z
    public final void i(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        Keva.getRepo(r102, 0).storeBoolean(r100, r101);
    }

    @Override // gd9.z
    public final void j(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        Keva.getRepo(r102, 0).storeInt(r100, r101);
    }

    @Override // gd9.z
    public final void k(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter(r102, "repo");
        Keva.getRepo(r102, 0).storeString(r100, r101);
    }
}
