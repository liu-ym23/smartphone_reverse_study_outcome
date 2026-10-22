package com.larus.camera.impl.ui.viewmodel;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class d implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CameraCaptureViewModel f322639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f322640b;

    public /* synthetic */ d(CameraCaptureViewModel r100, String r101) {
        this.f322639a = r100;
        this.f322640b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        return CameraCaptureViewModel.No(this.f322639a, this.f322640b, (String) r100);
    }
}
