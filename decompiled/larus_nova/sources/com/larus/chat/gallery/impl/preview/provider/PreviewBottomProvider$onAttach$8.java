package com.larus.chat.gallery.impl.preview.provider;

import com.larus.chat.gallery.impl.preview.input.PreviewInputCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PreviewBottomProvider$onAttach$8 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public PreviewBottomProvider$onAttach$8(Object r100) {
        super(1, r100, PreviewInputCallback.class, "onInputTextChanged", "onInputTextChanged(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((PreviewInputCallback) this.receiver).a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
