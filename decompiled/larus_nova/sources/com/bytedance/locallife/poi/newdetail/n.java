package com.bytedance.locallife.poi.newdetail;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<String> f263289a;

    public n(List<String> r100) {
        this.f263289a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<List<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.onSuccess(this.f263289a);
    }
}
