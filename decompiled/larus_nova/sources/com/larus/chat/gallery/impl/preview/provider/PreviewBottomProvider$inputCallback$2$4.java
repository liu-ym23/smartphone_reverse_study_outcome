package com.larus.chat.gallery.impl.preview.provider;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PreviewBottomProvider$inputCallback$2$4 extends FunctionReferenceImpl implements Function0<Unit> {
    public PreviewBottomProvider$inputCallback$2$4(Object r100) {
        super(0, r100, com.larus.chat.gallery.impl.preview.input.d0.class, "cancelPendingResult", "cancelPendingResult()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((com.larus.chat.gallery.impl.preview.input.d0) this.receiver).g();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
