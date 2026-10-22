package com.larksuite.component.card.component.audio.service;

import com.larksuite.component.card.service.ICardServiceFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements ICardServiceFactory<b> {
    public a() {
    }

    @Override // com.larksuite.component.card.service.ICardServiceFactory
    public final ICardServiceFactory.Scope a() {
        return ICardServiceFactory.Scope.LIFECYCLE;
    }

    @Override // com.larksuite.component.card.service.ICardServiceFactory
    public final com.larksuite.component.card.service.c b(com.larksuite.component.card.service.b r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceContext");
        return new CardAudioServiceImpl(r100);
    }
}
