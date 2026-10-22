package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.widget.title.TitleRightIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a2 implements Function1<TitleRightIconView, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f322232a = null;

    static {
        f322232a = new a2();
    }

    public a2() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(TitleRightIconView r100) {
        TitleRightIconView r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$updateRightIcon");
        r101.setAlpha(1.0f);
        r101.setEnabled(true);
        return Unit.INSTANCE;
    }
}
