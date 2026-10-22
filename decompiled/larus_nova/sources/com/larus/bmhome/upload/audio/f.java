package com.larus.bmhome.upload.audio;

import com.larus.network.http.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final class f implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f314750a;

    public f(e r100) {
        this.f314750a = r100;
    }

    @Override // com.larus.network.http.v
    public final void G0(float r100) {
        this.f314750a.invoke(Float.valueOf(r100));
    }
}
