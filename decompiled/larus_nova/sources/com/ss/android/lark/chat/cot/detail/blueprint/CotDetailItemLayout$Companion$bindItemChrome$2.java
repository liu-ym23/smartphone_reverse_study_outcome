package com.ss.android.lark.chat.cot.detail.blueprint;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CotDetailItemLayout$Companion$bindItemChrome$2 extends FunctionReferenceImpl implements Function1<ImageView, Unit> {
    public CotDetailItemLayout$Companion$bindItemChrome$2(Object r100) {
        super(1, r100, com.ss.android.lark.chat.cot.detail.widget.a.class, "clear", "clear(Landroid/widget/ImageView;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((com.ss.android.lark.chat.cot.detail.widget.a) this.receiver).getClass();
        com.ss.android.lark.chat.cot.detail.widget.a.g(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ImageView r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
