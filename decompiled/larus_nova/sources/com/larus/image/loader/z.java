package com.larus.image.loader;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public final class z implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataSource<CloseableReference<CloseableImage>> f350993a;

    public z(DataSource<CloseableReference<CloseableImage>> r100) {
        this.f350993a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        this.f350993a.close();
        return Unit.INSTANCE;
    }
}
