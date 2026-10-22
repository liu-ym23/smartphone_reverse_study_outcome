package com.ttnetuploader.uploader.api;

import java.util.function.Function;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class a implements Function {
    public /* synthetic */ a() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r100) {
        return Long.valueOf(((Parameters) r100).getUploadId());
    }
}
