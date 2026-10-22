package com.ss.android.lark.image.uploader.upload;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class c implements e {
    public c() {
    }

    @Override // com.ss.android.lark.image.uploader.upload.e
    public final void a(com.ss.android.lark.image.uploader.entity.b r100, ImageUploadManager$wrapUploader$1.AnonymousClass1 r101) {
        Intrinsics.checkNotNullParameter(r100, "image");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // com.ss.android.lark.image.uploader.upload.e
    public final boolean b() {
        return true;
    }
}
