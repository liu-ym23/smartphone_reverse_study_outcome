package com.larus.music.qq;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class n0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f359561a;

    public /* synthetic */ n0(Function2 r100) {
        this.f359561a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        final Function2 r101 = this.f359561a;
        ((Float) r100).floatValue();
        QQMusicApiUtils.f359493a.c("playMusic", QQMusicManager.f359501d.getValue(), null, new p0(r101));
        return Unit.INSTANCE;
    }
}
