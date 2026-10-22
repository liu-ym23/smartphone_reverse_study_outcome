package com.larus.doc.sdk.impl.v2.plugins.audio;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n39.r;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\nJ\u001a\u0010\f\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\nJ\u001a\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/audio/DocVoiceInputManager;", "", "<init>", "()V", "service", "Lcom/larus/doc/sdk/api/IVoiceInputService;", "setService", "", "startVoiceInput", "callback", "Lkotlin/Function1;", "", "stopVoiceInput", "", "displayAsrText", "sentence", "Lkotlin/Pair;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocVoiceInputManager {
    public static final DocVoiceInputManager INSTANCE = null;
    private static r service;

    static {
        INSTANCE = new DocVoiceInputManager();
    }

    private DocVoiceInputManager() {
    }

    public final void displayAsrText(Pair<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "sentence");
        r r101 = service;
        if (r101 == null) goto L6;
        r101.displayAsrText(r100);
        return;
    }

    public final void setService(r r100) {
        service = r100;
    }

    public final void startVoiceInput(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        r r101 = service;
        if (r101 == null) goto L6;
        r101.startVoiceInput(r100);
        return;
    }

    public final void stopVoiceInput(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        r r101 = service;
        if (r101 == null) goto L6;
        r101.stopVoiceInput(r100);
        return;
    }
}
