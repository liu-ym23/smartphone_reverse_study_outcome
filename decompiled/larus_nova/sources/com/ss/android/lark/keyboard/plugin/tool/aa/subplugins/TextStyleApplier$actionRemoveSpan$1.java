package com.ss.android.lark.keyboard.plugin.tool.aa.subplugins;

import android.text.Editable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class TextStyleApplier$actionRemoveSpan$1 extends FunctionReferenceImpl implements Function3<Editable, Integer, Integer, Unit> {
    public TextStyleApplier$actionRemoveSpan$1(Object r100) {
        super(3, r100, TextStyleApplier.class, "removeSpanInner", "removeSpanInner(Landroid/text/Editable;II)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Editable r100, Integer r101, Integer r102) {
        invoke(r100, r101.intValue(), r102.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Editable r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        TextStyleApplier r103 = (TextStyleApplier) this.receiver;
        int r104 = TextStyleApplier.f429577m;
        r103.d(r100, r101, r102);
    }
}
