package com.larus.chat.gallery.impl.preview.provider;

import com.larus.chat.gallery.impl.preview.input.PreviewInputCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PreviewBottomProvider$onAttach$10 extends FunctionReferenceImpl implements Function0<Unit> {
    public PreviewBottomProvider$onAttach$10(Object r100) {
        super(0, r100, PreviewInputCallback.class, "onCameraEntranceClick", "onCameraEntranceClick()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((PreviewInputCallback) this.receiver).c();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
