package com.bytedance.ee.bear.list.thumbnail;

import com.bytedance.ee.bear.list.dto.Document;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Function;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeThumbnailUrlRepository f229797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Document f229798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f229799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f229800d;

    public i(OfficeThumbnailUrlRepository r100, Document r101, int r102, int r103) {
        this.f229797a = r100;
        this.f229798b = r101;
        this.f229799c = r102;
        this.f229800d = r103;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        StringBuilder r102 = new StringBuilder("drive cdn thumbnail failed, fallback cover, tokenHash=");
        OfficeThumbnailUrlRepository r103 = this.f229797a;
        Document r104 = this.f229798b;
        r103.getClass();
        Set<String> r105 = OfficeThumbnailUrlRepository.f229772c;
        r102.append(OfficeThumbnailUrlRepository.c.b(r104).hashCode());
        tt5.a.l("OfficeThumbnailUrlRepo", r102.toString(), r101);
        return this.f229797a.b(this.f229798b, this.f229799c, this.f229800d);
    }
}
