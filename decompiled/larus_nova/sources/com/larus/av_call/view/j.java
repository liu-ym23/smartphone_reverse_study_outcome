package com.larus.av_call.view;

import android.os.Handler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class j implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f290674a;

    public /* synthetic */ j(Handler r100) {
        this.f290674a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f290674a.removeCallbacksAndMessages(null);
        return Unit.INSTANCE;
    }
}
