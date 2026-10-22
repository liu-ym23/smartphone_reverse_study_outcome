package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.widget.title.TitleRightIconView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x1 implements Function1<TitleRightIconView, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f322472a = null;

    static {
        f322472a = new x1();
    }

    public x1() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(TitleRightIconView r100) {
        TitleRightIconView r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$updateRightIcon");
        r101.setAlpha(0.5f);
        r101.setEnabled(false);
        return Unit.INSTANCE;
    }
}
