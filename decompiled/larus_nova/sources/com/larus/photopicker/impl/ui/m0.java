package com.larus.photopicker.impl.ui;

import com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaSelectListView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class m0 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kq9.m f364134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f364135b;

    public /* synthetic */ m0(kq9.m r100, boolean r101) {
        this.f364134a = r100;
        this.f364135b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        kq9.m r101 = this.f364134a;
        boolean r102 = this.f364135b;
        BaseMediaSelectListView.b r103 = (BaseMediaSelectListView.b) r100;
        int r104 = PhotoPickerFragment.f364051p0;
        Intrinsics.checkNotNullParameter(r103, "it");
        if (Intrinsics.areEqual(r101.f505648q, Boolean.TRUE) == false) goto L6;
        if (r102 == false) goto L6;
        boolean r105 = true;
    L7:
        r103.P = r105;
        return Unit.INSTANCE;
    L6:
        r105 = false;
        goto L7
    }
}
