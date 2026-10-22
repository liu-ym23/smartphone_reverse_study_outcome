package com.larus.drive.biz.impl.viewmodel;

import android.content.Context;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class a0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f341516a;

    public /* synthetic */ a0(Context r100) {
        this.f341516a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        return DriveMoveViewModel.yo(this.f341516a, (String) r100);
    }
}
