package com.larus.bmhome.upload;

import com.larus.platform.api.c4;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final class k implements c4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f314783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f314784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f314785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f314786d;

    @Override // com.larus.platform.api.c4.c
    public final void onCompileDone() {
        this.f314784b.invoke(this.f314785c);
    }

    @Override // com.larus.platform.api.c4.c
    public final void onCompileProgress(float r100) {
        this.f314786d.invoke(Float.valueOf(r100));
    }

    @Override // com.larus.platform.api.c4.c
    public final void a(int r100, String r101) {
        this.f314783a.invoke(r100 + ':' + r101);
    }

    public k(com.larus.uploader.impl.f r100, com.larus.uploader.impl.e r101, String r102, com.larus.uploader.impl.d r103) {
        this.f314783a = r100;
        this.f314784b = r101;
        this.f314785c = r102;
        this.f314786d = r103;
    }
}
