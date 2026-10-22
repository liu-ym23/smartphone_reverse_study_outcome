package com.bytedance.ee.bear.attachment.filereader;

import android.net.Uri;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileReaderActivity f206403a;

    public k(FileReaderActivity r100) {
        this.f206403a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Uri r101 = (Uri) r100;
        Intrinsics.checkNotNullParameter(r101, "uri");
        return Boolean.valueOf(com.larksuite.framework.utils.i.a(this.f206403a.getApplicationContext(), this.f206403a.f206378q, r101));
    }
}
