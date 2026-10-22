package com.bytedance.livesdk.ktvimpl.base.midi;

import com.bytedance.livesdk.ktvcommon.download.model.DownloadPriority;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;
import com.bytedance.livesdk.ktvcommon.download.model.MusicType;
import com.bytedance.livesdk.ktvcommon.midi.controller.MidiControllerImpl;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements com.bytedance.livesdk.ktvcommon.download.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.livesdk.ktvcommon.midi.controller.c f256375a;

    public a(MidiControllerImpl.a r100) {
        this.f256375a = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.a
    public final void e(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        dl6.a.c(new String[]{"Batch progress: batchId=" + r100 + ", progress=" + r101});
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.a
    public final void c(String r100, String r101, MusicType r102) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "resourceType");
        dl6.a.c(new String[]{"Task cancelled: taskId=" + r101 + ", type=" + r102});
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.a
    public final void a(String r100, String r101, DownloadState r102, com.bytedance.livesdk.ktvcommon.download.model.d r103) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r101, "songId");
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r103, "result");
        dl6.a.c(new String[]{"Task completed: songId=" + r101 + ", type=" + r103.f255958c + ", state=" + r102});
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.a
    public final void d(String r100, String r101, List<com.bytedance.livesdk.ktvcommon.download.model.d> r102, List<com.bytedance.livesdk.ktvcommon.download.model.d> r110) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r101, "songId");
        Intrinsics.checkNotNullParameter(r102, "successResults");
        Intrinsics.checkNotNullParameter(r110, "failedResults");
        boolean r103 = true;
        dl6.a.c(new String[]{"Batch completed: batchId=" + r100 + ", songId=" + r101 + ", success=" + r102.size() + ", failed=" + r110.size()});
        List<com.bytedance.livesdk.ktvcommon.download.model.d> r104 = r102;
        Iterator<T> r105 = r104.iterator();
    L3:
        Object r106 = null;
        if (r105.hasNext() == false) goto L11;
        Object r107 = r105.next();
        if (((com.bytedance.livesdk.ktvcommon.download.model.d) r107).f255958c != MusicType.MIDI) goto L8;
        boolean r108 = true;
    L9:
        if (r108 == false) goto L3;
    L12:
        com.bytedance.livesdk.ktvcommon.download.model.d r109 = (com.bytedance.livesdk.ktvcommon.download.model.d) r107;
        String r111 = "";
        if (r109 == null) goto L16;
        String r112 = r109.f255960e;
        if (r112 == null) goto L16;
    L17:
        Iterator<T> r113 = r104.iterator();
    L19:
        if (r113.hasNext() == false) goto L26;
        Object r114 = r113.next();
        if (((com.bytedance.livesdk.ktvcommon.download.model.d) r114).f255958c != MusicType.LYRIC) goto L23;
        boolean r115 = true;
    L24:
        if (r115 == false) goto L19;
        r106 = r114;
        goto L26
    L23:
        r115 = false;
    L26:
        com.bytedance.livesdk.ktvcommon.download.model.d r116 = (com.bytedance.livesdk.ktvcommon.download.model.d) r106;
        if (r116 == null) goto L32;
        String r117 = r116.f255960e;
        if (r117 == null) goto L32;
        r111 = r117;
    L32:
        com.bytedance.livesdk.ktvcommon.midi.controller.c r118 = this.f256375a;
        if (r112.length() <= 0) goto L35;
        boolean r119 = true;
    L36:
        if (r119 == true) goto L38;
    L43:
        r103 = false;
    L44:
        r118.a(new com.bytedance.livesdk.ktvcommon.midi.controller.b(r101, r112, r111, r103));
        return;
    L38:
        if (r111.length() <= 0) goto L40;
        boolean r120 = true;
    L41:
        if (r120 == false) goto L43;
    L40:
        r120 = false;
        goto L41
    L35:
        r119 = false;
    L16:
        r112 = "";
        goto L17
    L8:
        r108 = false;
        goto L9
    L11:
        r107 = null;
        goto L12
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.a
    public final void b(String r100, String r101, String r102, MusicType r103, int r104, DownloadPriority r105) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r101, "songId");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r103, "resourceType");
        Intrinsics.checkNotNullParameter(r105, "priority");
        dl6.a.c(new String[]{"Task progress: songId=" + r101 + ", type=" + r103 + ", progress=" + r104});
    }
}
