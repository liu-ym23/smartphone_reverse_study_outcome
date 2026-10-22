package com.ss.android.lark.image.uploader.upload;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class j implements e {
    public j() {
    }

    @Override // com.ss.android.lark.image.uploader.upload.e
    public final boolean b() {
        return false;
    }

    @Override // com.ss.android.lark.image.uploader.upload.e
    public final void c(List r100, ImageUploadManager$batchUpload$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "image");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }
}
