package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements Runnable {
    public static final w a = null;

    static {
        a = new w();
    }

    public w() {
    }

    public static void a() {
        KtvRoomContext.Companion.getClass();
        KtvRoomContext r0 = KtvRoomContext.a.a();
        if (r0 == null) goto L22;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r1 = r0.getPreviewViewModel();
        if (r1 == null) goto L23;
        KtvPreviewSongsViewModel r2 = (KtvPreviewSongsViewModel) r1.getValue();
        if (r2 == null) goto L24;
        com.bytedance.live.datacontext.m<Boolean> r3 = r2.getNeedDelayToShow();
        if (r3 != null) goto L11;
        return;
    L11:
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L26;
        ALogger.i("ktv_preview_song_log", "observeSingEndedFeedbackSei ; backup  need to resume needDelayToShow value");
        KtvRoomContext r4 = KtvRoomContext.a.a();
        if (r4 == null) goto L27;
        com.bytedance.live.datacontext.n<KtvPreviewSongsViewModel> r5 = r4.getPreviewViewModel();
        if (r5 == null) goto L28;
        KtvPreviewSongsViewModel r6 = (KtvPreviewSongsViewModel) r5.getValue();
        if (r6 == null) goto L29;
        com.bytedance.live.datacontext.m<Boolean> r7 = r6.getNeedDelayToShow();
        if (r7 == null) goto L30;
        r7.setValue(Boolean.FALSE);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
