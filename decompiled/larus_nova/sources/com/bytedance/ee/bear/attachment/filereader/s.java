package com.bytedance.ee.bear.attachment.filereader;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class s<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileDownloadModel f206414a;

    public s(FileDownloadModel r100) {
        this.f206414a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        String r101 = x.f206422a;
        x.a.a(this.f206414a.getDownloadPath());
        return Unit.INSTANCE;
    }
}
