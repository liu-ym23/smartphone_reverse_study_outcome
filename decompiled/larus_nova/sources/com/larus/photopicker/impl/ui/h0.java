package com.larus.photopicker.impl.ui;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class h0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoPickerFragment f364118a;

    public /* synthetic */ h0(PhotoPickerFragment r100) {
        this.f364118a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        PhotoPickerFragment r101 = this.f364118a;
        ((Boolean) r100).booleanValue();
        int r102 = PhotoPickerFragment.f364051p0;
        FragmentActivity r103 = r101.aa0();
        if (r103 == null) goto L6;
        r103.finish();
    L6:
        return Unit.INSTANCE;
    }
}
