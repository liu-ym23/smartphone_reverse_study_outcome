package com.bytedance.ee.bear.demo;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.ee.bear.drive.loader.download.model.drive.DriveImagePreviewResponse;
import com.bytedance.ee.bear.list.cover.CoverLoader;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements h75.c {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public k(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    @Override // h75.c
    public final void a(DriveImagePreviewResponse r13) {
        Intrinsics.checkNotNullParameter(r13, "info");
        this.a.C1("fetchImagePreview success\n\n");
        CCMFolderDemoActivity r0 = this.a;
        CoverLoader r1 = r0.h;
        ImageView r2 = r0.j;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("coverView");
        r2 = null;
    L5:
        Context r4 = r2.getContext();
        ImageView r3 = this.a.j;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("coverView");
        ImageView r5 = null;
    L9:
        String r6 = r13.getUrl();
        Lazy r14 = CoverLoader.a;
        r1.getClass();
        CoverLoader.d(r4, r5, r6, 0, null, null, null, null);
        return;
    L8:
        r5 = r3;
        goto L9
    }

    @Override // h75.c
    public final void b(Throwable r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "e");
        Intrinsics.checkNotNullParameter(r5, "url");
        this.a.C1("fetchImagePreview error: " + r4.getLocalizedMessage() + ", url=" + r5 + '\n');
    }
}
