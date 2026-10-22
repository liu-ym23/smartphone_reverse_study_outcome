package com.bytedance.livesdk.ktvcommon.download;

import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;
import com.bytedance.livesdk.ktvcommon.download.model.f;
import defpackage.p;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import yk6.g;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<com.bytedance.livesdk.ktvcommon.download.api.a>> f255933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f255934b;

    public b(p r100) {
        Intrinsics.checkNotNullParameter(r100, "batchManager");
        this.f255934b = r100;
        this.f255933a = new LinkedHashMap();
    }

    public final void a(com.bytedance.livesdk.ktvcommon.download.model.e r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        int r101 = g.f568232a;
        String r102 = "notifyTaskCancelled: batchId=" + r100.f255964b + ", taskId=" + r100.f255963a;
        Intrinsics.checkNotNullParameter("KTV-Download-Task", "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
        jy0.b.f("KTV-Download-Task", r102, null, 4);
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) ((LinkedHashMap) this.f255933a).get(r100.f255964b);
        if (r103 == null) goto L8;
        Iterator r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        ((com.bytedance.livesdk.ktvcommon.download.api.a) r104.next()).c(r100.f255964b, r100.f255963a, r100.f255966d.f255976c);
        goto L6
    L10:
        return;
    }

    public final void b(String r100, com.bytedance.livesdk.ktvcommon.download.api.a r101) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        LinkedHashMap r102 = (LinkedHashMap) this.f255933a;
        Object r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new CopyOnWriteArrayList();
        r102.put(r100, r103);
    L5:
        ((CopyOnWriteArrayList) r103).add(r101);
        com.bytedance.livesdk.ktvcommon.download.model.b r104 = this.f255934b.a(r100);
        if (r104 == null) goto L32;
        int r105 = r104.f255949f;
        if (r105 <= 0) goto L11;
        r101.e(r100, r105);
    L11:
        Iterator<T> r106 = r104.f255950g.iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        com.bytedance.livesdk.ktvcommon.download.model.d r107 = (com.bytedance.livesdk.ktvcommon.download.model.d) r106.next();
        r101.a(r100, r104.f255945b, DownloadState.SUCCESS, r107);
        goto L13
    L15:
        Iterator<T> r108 = r104.f255951h.iterator();
    L17:
        if (r108.hasNext() == false) goto L20;
        com.bytedance.livesdk.ktvcommon.download.model.d r109 = (com.bytedance.livesdk.ktvcommon.download.model.d) r108.next();
        r101.a(r100, r104.f255945b, DownloadState.FAILED, r109);
        goto L17
    L20:
        if (r104.f255952i == false) goto L23;
        r101.d(r100, r104.f255945b, r104.f255950g, r104.f255951h);
    L23:
        if (r104.f255953j == false) goto L28;
        Iterator<T> r110 = r104.f255948e.iterator();
    L26:
        if (r110.hasNext() == false) goto L33;
        f r111 = (f) r110.next();
        r101.c(r100, r111.f255975b, r111.f255976c);
        goto L26
    L33:
        return;
    L28:
        return;
    }
}
