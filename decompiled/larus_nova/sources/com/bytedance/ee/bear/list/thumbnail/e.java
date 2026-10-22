package com.bytedance.ee.bear.list.thumbnail;

import com.lynx.tasm.LynxError;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<OfficeThumbnailUrlRepository.i> f229792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeThumbnailUrlRepository f229793b;

    public e(List<OfficeThumbnailUrlRepository.i> r100, OfficeThumbnailUrlRepository r101) {
        this.f229792a = r100;
        this.f229793b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        tt5.a.l("OfficeThumbnailUrlRepo", "batch drive cdn thumbnail failed, fallback cover, count=" + this.f229792a.size(), r101);
        return this.f229793b.a(this.f229792a, MapsKt.emptyMap());
    }
}
