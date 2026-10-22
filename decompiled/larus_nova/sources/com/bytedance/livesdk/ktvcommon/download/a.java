package com.bytedance.livesdk.ktvcommon.download;

import com.bytedance.livesdk.ktvcommon.download.model.DownloadPriority;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;
import com.bytedance.livesdk.ktvcommon.download.model.MusicType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import defpackage.o;
import defpackage.p;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import yk6.g;

/* JADX INFO: loaded from: classes20.dex */
public final class a extends com.bytedance.livesdk.ktvcommon.download.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f255929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f255930b;

    public a(p r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "batchManager");
        Intrinsics.checkNotNullParameter(r101, "callbackManager");
        this.f255929a = r100;
        this.f255930b = r101;
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.a
    public final void a(String r100, String r110, DownloadState r111, com.bytedance.livesdk.ktvcommon.download.model.d r112) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r110, "songId");
        Intrinsics.checkNotNullParameter(r111, "state");
        Intrinsics.checkNotNullParameter(r112, "result");
        com.bytedance.livesdk.ktvcommon.download.model.b r101 = this.f255929a.a(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        p r102 = this.f255929a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r111, "state");
        Intrinsics.checkNotNullParameter(r112, "result");
        com.bytedance.livesdk.ktvcommon.download.model.b r103 = r102.a(r100);
        if (r103 == null) goto L17;
        int r104 = o.f521565a[r111.ordinal()];
        if (r104 != 1) goto L11;
        r103.f255950g.add(r112);
    L15:
        int r113 = g.f568232a;
        g.a("KTV-Download-Batch", "updateBatchCompletionStatus: batchId=" + r100 + ", state=" + r111);
        goto L17
    L11:
        if (r104 != 2) goto L17;
        r103.f255951h.add(r112);
    L17:
        if (this.f255929a.c(r100) == false) goto L24;
        r101.f255952i = true;
        p r114 = this.f255929a;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r101, "batchInfo");
        r114.f527242a.put(r101.f255944a, r101);
        b r115 = this.f255930b;
        List<com.bytedance.livesdk.ktvcommon.download.model.d> r116 = r101.f255950g;
        List<com.bytedance.livesdk.ktvcommon.download.model.d> r105 = r101.f255951h;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r110, "songId");
        Intrinsics.checkNotNullParameter(r116, "success");
        Intrinsics.checkNotNullParameter(r105, "failed");
        int r106 = g.f568232a;
        g.a("KTV-Download-Batch", "notifyBatchCompleted: batchId=" + r100 + ", success=" + r116.size() + ", failed=" + r105.size());
        CopyOnWriteArrayList r117 = (CopyOnWriteArrayList) ((LinkedHashMap) r115.f255933a).get(r100);
        if (r117 == null) goto L26;
        Iterator r118 = r117.iterator();
    L22:
        if (r118.hasNext() == false) goto L27;
        ((com.bytedance.livesdk.ktvcommon.download.api.a) r118.next()).d(r100, r110, r116, r105);
        goto L22
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.a
    public final void b(String r100, String r101, String r102, MusicType r110, int r111, DownloadPriority r112) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r101, "songId");
        Intrinsics.checkNotNullParameter(r102, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r110, "resourceType");
        Intrinsics.checkNotNullParameter(r112, "priority");
        com.bytedance.livesdk.ktvcommon.download.model.b r103 = this.f255929a.a(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        p r113 = this.f255929a;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r100, "batchId");
        com.bytedance.livesdk.ktvcommon.download.model.b r114 = r113.a(r100);
        if (r114 != null) goto L8;
        float r104 = 0.0f;
    L20:
        int r105 = (int) r104;
        r103.f255949f = r105;
        p r115 = this.f255929a;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r103, "batchInfo");
        r115.f527242a.put(r103.f255944a, r103);
        b r106 = this.f255930b;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r100, "batchId");
        CopyOnWriteArrayList r107 = (CopyOnWriteArrayList) ((LinkedHashMap) r106.f255933a).get(r100);
        if (r107 == null) goto L26;
        Iterator r108 = r107.iterator();
    L24:
        if (r108.hasNext() == false) goto L31;
        ((com.bytedance.livesdk.ktvcommon.download.api.a) r108.next()).e(r100, r105);
        goto L24
    L31:
        return;
    L26:
        return;
    L8:
        int r116 = r114.f255948e.size();
        if (r116 != 0) goto L11;
        r104 = 100.0f;
        goto L20
    L11:
        Iterator<T> r109 = r113.b(r100).iterator();
        int r117 = 0;
    L13:
        if (r109.hasNext() == false) goto L19;
        String r118 = (String) r109.next();
        d r119 = r113.f527243b;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r118, DBDefinition.TASK_ID);
        com.bytedance.livesdk.ktvcommon.download.model.e r120 = (com.bytedance.livesdk.ktvcommon.download.model.e) ((LinkedHashMap) r119.f255935a).get(r118);
        if (r120 == null) goto L17;
        int r121 = r120.f255972j;
    L18:
        r117 = r117 + RangesKt.coerceAtMost(r121, 100);
        goto L13
    L17:
        r121 = 0;
        goto L18
    L19:
        r104 = RangesKt.coerceAtMost(r117 / r116, 100.0f);
        goto L20
    }
}
