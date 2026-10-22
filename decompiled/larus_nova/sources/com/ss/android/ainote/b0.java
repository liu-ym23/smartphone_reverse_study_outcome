package com.ss.android.ainote;

import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b0 implements AINoteImageUploadCoordinator.e {
    public b0() {
    }

    @Override // com.ss.android.ainote.AINoteImageUploadCoordinator.e
    public final void a(AINoteImageUploadCoordinator.d r100, AINoteImageUploadCoordinator$startPendingUploads$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.ss.android.lark.image.uploader.entity.b.a r102 = new com.ss.android.lark.image.uploader.entity.b.a();
        r102.c(r100.f406518d);
        r102.f426407g = false;
        r102.f426408h = true;
        com.ss.android.lark.image.uploader.entity.b r103 = r102.b();
        int r104 = ykb.a.f568290b;
        ykb.a r105 = ykb.a.C8350a.a(LarkContext.getApplication());
        r105.b(r103);
        r105.f568291a.f426381g = new com.ss.android.lark.image.uploader.upload.d(true);
        r105.a(new a0(r101));
        r105.c();
    }
}
