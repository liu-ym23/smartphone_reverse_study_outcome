package com.bytedance.livesdk.ktvcommon.download.api;

import com.bytedance.livesdk.ktvcommon.download.model.MusicType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public class b implements a {
    public b() {
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.a
    public final void c(String r100, String r101, MusicType r102) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "resourceType");
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.a
    public final void d(String r100, String r101, List<com.bytedance.livesdk.ktvcommon.download.model.d> r102, List<com.bytedance.livesdk.ktvcommon.download.model.d> r103) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        Intrinsics.checkNotNullParameter(r101, "songId");
        Intrinsics.checkNotNullParameter(r102, "successResults");
        Intrinsics.checkNotNullParameter(r103, "failedResults");
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.a
    public final void e(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
    }
}
