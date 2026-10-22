package com.larus.business.floatchat.impl.component;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class m implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AIChatInputConfigComponent f320381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f320382b;

    public /* synthetic */ m(AIChatInputConfigComponent r100, View r101) {
        this.f320381a = r100;
        this.f320382b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AIChatInputConfigComponent r100 = this.f320381a;
        View r101 = this.f320382b;
        if (r100.f320166x == false) goto L6;
        r101.setVisibility(0);
        r100.C3(r101);
    L6:
        return Unit.INSTANCE;
    }
}
