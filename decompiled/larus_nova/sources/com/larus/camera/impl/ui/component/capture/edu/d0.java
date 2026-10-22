package com.larus.camera.impl.ui.component.capture.edu;

import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d0 implements Function1<ImageView, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f321910a;

    public d0(c0 r100) {
        this.f321910a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ImageView r100) {
        ImageView r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$setIcon");
        this.f321910a.v(r101, new f());
        return Unit.INSTANCE;
    }
}
