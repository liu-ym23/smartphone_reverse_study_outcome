package com.ss.android.lark.flow.chat.message.image;

import com.bytedance.ee.bear.drive.loader.download.model.drive.DriveImagePreviewResponse;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements h75.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<String> f422592a;

    public j(kotlinx.coroutines.j r100) {
        this.f422592a = r100;
    }

    @Override // h75.c
    public final void a(DriveImagePreviewResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        kotlinx.coroutines.i<String> r101 = this.f422592a;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(r100.getUrl()));
    }

    @Override // h75.c
    public final void b(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r101, "url");
        Log.e("FlowYunPanFileUtils", "fetchDriveImagePreview onError, " + r100.getMessage());
        this.f422592a.resumeWith(Result.m9449constructorimpl(r101));
    }
}
