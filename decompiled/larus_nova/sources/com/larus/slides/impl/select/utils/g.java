package com.larus.slides.impl.select.utils;

import com.larus.slides.impl.select.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class g implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f369679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f369680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<a, Unit> f369681c;

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean r100) {
        if (r100.booleanValue() == false) goto L6;
        Lazy r101 = ImageSaveUtils.f369667a;
        ImageSaveUtils.a(this.f369679a, this.f369680b, this.f369681c);
    L6:
        return Unit.INSTANCE;
    }

    public g(String r100, String r101, m r102) {
        this.f369679a = r100;
        this.f369680b = r101;
        this.f369681c = r102;
    }
}
