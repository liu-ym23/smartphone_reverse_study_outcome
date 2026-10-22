package com.larksuite.component.card.resources;

import com.larksuite.component.card.protocol.CardData;
import com.larksuite.framework.callback.Entity.ErrorResult;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes24.dex */
public interface e extends com.larksuite.component.card.service.c {
    Object b(b r100, Continuation<? super CardResource> r101) throws CancellationException, ErrorResult, Throwable;

    void g(CardData r100);

    CardResource i(String r100);
}
