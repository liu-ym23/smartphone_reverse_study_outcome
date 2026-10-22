package com.larus.photopicker.impl.ui;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class f implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomPhotoPickerFragment f364108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f364109b;

    public /* synthetic */ f(BottomPhotoPickerFragment r100, Function1 r101) {
        this.f364108a = r100;
        this.f364109b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        BottomPhotoPickerFragment r100 = this.f364108a;
        r100.D = (View) this.f364109b.invoke(r100.f364018t);
        return Unit.INSTANCE;
    }
}
