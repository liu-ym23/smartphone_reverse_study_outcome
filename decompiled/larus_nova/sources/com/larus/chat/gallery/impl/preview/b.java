package com.larus.chat.gallery.impl.preview;

import com.facebook.datasource.DataSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataSource<Void> f324217a;

    public b(DataSource<Void> r100) {
        this.f324217a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        this.f324217a.close();
        return Unit.INSTANCE;
    }
}
