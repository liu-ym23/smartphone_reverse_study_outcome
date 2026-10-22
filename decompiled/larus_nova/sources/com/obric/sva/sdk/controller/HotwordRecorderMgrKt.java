package com.obric.sva.sdk.controller;

import android.media.AudioRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"releaseLocked", "", "Landroid/media/AudioRecord;", "libs_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HotwordRecorderMgrKt {
    private static void com_obric_sva_sdk_controller_HotwordRecorderMgrKt_android_media_AudioRecord_release(AudioRecord r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100403, "android/media/AudioRecord", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100403, "android/media/AudioRecord", "release", r110, r101, null, r111, true);
    }

    public static final void releaseLocked(AudioRecord r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        monitor-enter(r100);
        com_obric_sva_sdk_controller_HotwordRecorderMgrKt_android_media_AudioRecord_release(r100);     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
