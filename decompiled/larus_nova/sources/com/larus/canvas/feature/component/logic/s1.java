package com.larus.canvas.feature.component.logic;

import com.larus.bmhome.upload.ResourceUploader;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final class s1 implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f323489a;

    public s1(String r100) {
        this.f323489a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        ResourceUploader r101 = ResourceUploader.f314736a;
        ResourceUploader.c(this.f323489a);
        return Unit.INSTANCE;
    }
}
