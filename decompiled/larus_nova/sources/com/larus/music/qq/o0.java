package com.larus.music.qq;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class o0 implements Function1 {
    public /* synthetic */ o0() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        FLogger.f375446a.i("QQMusicManager", "requiring audio focus failed");
        return Unit.INSTANCE;
    }
}
