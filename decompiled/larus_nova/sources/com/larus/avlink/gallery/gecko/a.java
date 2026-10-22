package com.larus.avlink.gallery.gecko;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements Function1<String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MorphoGeckoFileHelper f292582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i<String> f292583b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(MorphoGeckoFileHelper r100, i<? super String> r101) {
        this.f292582a = r100;
        this.f292583b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String r100) {
        String r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "filePath");
        MorphoGeckoFileHelper r102 = this.f292582a;
        MorphoGeckoFileHelper r103 = MorphoGeckoFileHelper.f292575a;
        r102.getClass();
        MorphoGeckoFileHelper.h("[download] getResPath: filePath=" + r101);
        if (this.f292583b.isActive() == false) goto L6;
        this.f292583b.resumeWith(Result.m9449constructorimpl(r101));
    L6:
        return Unit.INSTANCE;
    }
}
