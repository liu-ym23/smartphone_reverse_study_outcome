package com.larksuite.component.card.resources;

import com.larksuite.component.card.protocol.CardData;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements e {
    public d() {
    }

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
    }

    @Override // com.larksuite.component.card.resources.e
    public final void g(CardData r100) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
    }

    @Override // com.larksuite.component.card.resources.e
    public final CardResource i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fileKey");
        return null;
    }

    @Override // com.larksuite.component.card.resources.e
    public final Object b(b r100, Continuation<? super CardResource> r101) {
        return new CardResource(CardResource.ResourceType.AUDIO, "", "");
    }
}
