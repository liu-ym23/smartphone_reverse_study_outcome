package com.bytedance.android.livesdk.ktvimpl.base.controlnode;

import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.model.bean.f;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadPriority;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;
import com.bytedance.livesdk.ktvcommon.download.model.MusicType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yk6.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements com.bytedance.livesdk.ktvcommon.download.api.a {
    public final /* synthetic */ AddMusicControlNode a;
    public final /* synthetic */ MusicPanel b;
    public final /* synthetic */ p.a c;

    public final void e(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "batchId");
        Integer r0 = h.a(r5);
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        dl6.a.b(new String[]{"AddMusicControlNode", "onBatchProgress for batchId=" + r5 + ", progress=" + r6});
        return;
    L11:
        if (r0.intValue() != 1) goto L13;
        this.b.s = 100;
        goto L13
    L6:
        if (r0.intValue() != 0) goto L8;
        MusicPanel r1 = this.b;
        r1.s = r6;
        this.c.c(r1, r6);
        goto L13
    }

    public b(AddMusicControlNode r1, MusicPanel r2, AddMusicControlNode.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void c(String r4, String r5, MusicType r6) {
        Intrinsics.checkNotNullParameter(r4, "batchId");
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Intrinsics.checkNotNullParameter(r6, "resourceType");
        dl6.a.b(new String[]{"AddMusicControlNode", "onTaskCancelled for batchId=" + r4 + ", taskId=" + r5 + ", resourceType=" + r6});
    }

    public final void a(String r5, String r6, DownloadState r7, com.bytedance.livesdk.ktvcommon.download.model.d r8) {
        Intrinsics.checkNotNullParameter(r5, "batchId");
        Intrinsics.checkNotNullParameter(r6, "songId");
        Intrinsics.checkNotNullParameter(r7, BaseCoreViewModel.CORE_TAG_STATE);
        Intrinsics.checkNotNullParameter(r8, "result");
        dl6.a.b(new String[]{"AddMusicControlNode", "onTaskCompleted for batchId=" + r5 + ", songId=" + r6 + ", state=" + r7 + ", result=" + r8});
        int r9 = a.a[r8.c.ordinal()];
        if (r9 == 1) goto L13;
        if (r9 != 2) goto L6;
        this.b.j(r8.e);
        return;
    L6:
        if (r9 != 3) goto L8;
        this.b.i(r8.e);
        return;
    L8:
        if (r9 != 4) goto L18;
        MusicPanel r10 = this.b;
        String r11 = r8.e;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r10.o = r11;
        return;
    L18:
        return;
    L13:
        MusicPanel r12 = this.b;
        String r13 = r8.e;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.n = r13;
    }

    public final void d(String r22, String r23, List<com.bytedance.livesdk.ktvcommon.download.model.d> r24, List<com.bytedance.livesdk.ktvcommon.download.model.d> r25) {
        Intrinsics.checkNotNullParameter(r22, "batchId");
        Intrinsics.checkNotNullParameter(r23, "songId");
        Intrinsics.checkNotNullParameter(r24, "successResults");
        Intrinsics.checkNotNullParameter(r25, "failedResults");
        Integer r5 = h.a(r22);
        if (r5 != null) goto L6;
    L15:
        if (r5 != null) goto L18;
    L20:
        dl6.a.b(new String[]{"AddMusicControlNode", "onBatchCompleted for batchId=" + r22 + ", sequence=" + r5 + ", songId=" + r23 + ", successResults=" + CollectionsKt.joinToString$default(r24, "==", null, null, 0, null, null, 62, null) + ", failedResults=" + CollectionsKt.joinToString$default(r25, "==", null, null, 0, null, null, 62, null)});
        return;
    L18:
        if (r5.intValue() != 1) goto L20;
        AddMusicControlNode r8 = this.a;
        MusicPanel r9 = this.b;
        f r10 = new f(DownloadResourceType.OTHER_RESOURCE, false);
        r8.getClass();
        AddMusicControlNode.n(r9, r10);
        goto L20
    L6:
        if (r5.intValue() != 0) goto L15;
        if ((!r25.isEmpty()) == false) goto L10;
        this.c.b(this.b, ((com.bytedance.livesdk.ktvcommon.download.model.d) ListProtector.get(r25, 0)).f, ((com.bytedance.livesdk.ktvcommon.download.model.d) ListProtector.get(r25, 0)).g);
    L11:
        AddMusicControlNode r11 = this.a;
        MusicPanel r12 = this.b;
        f r13 = new f(DownloadResourceType.MAIN_RESOURCE, false);
        r11.getClass();
        AddMusicControlNode.n(r12, r13);
        if (KtvUtilsKt.E(this.b) == true) goto L14;
        AddMusicControlNode r14 = this.a;
        MusicPanel r15 = this.b;
        f r16 = new f(DownloadResourceType.OTHER_RESOURCE, false);
        r14.getClass();
        AddMusicControlNode.n(r15, r16);
        goto L20
    L14:
        AddMusicControlNode r17 = this.a;
        MusicPanel r18 = this.b;
        f r19 = new f(DownloadResourceType.OTHER_RESOURCE, true);
        r17.getClass();
        AddMusicControlNode.n(r18, r19);
        goto L20
    L10:
        this.c.a(this.b, null, null);
        goto L11
    }

    public final void b(String r4, String r5, String r6, MusicType r7, int r8, DownloadPriority r9) {
        Intrinsics.checkNotNullParameter(r4, "batchId");
        Intrinsics.checkNotNullParameter(r5, "songId");
        Intrinsics.checkNotNullParameter(r6, "taskId");
        Intrinsics.checkNotNullParameter(r7, "resourceType");
        Intrinsics.checkNotNullParameter(r9, "priority");
        dl6.a.b(new String[]{"AddMusicControlNode", "onTaskProgress for batchId=" + r4 + ", songId=" + r5 + ", taskId=" + r6 + ", resourceType=" + r7 + ", progress=" + r8 + ", priority=" + r9});
    }
}
