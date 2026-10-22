package com.obric.assistant.product.impl;

import com.obric.aiagent.product.internal.ObricProductSdkImpl;
import com.obric.assistant.product.api.IObricProduct;
import kotlin.Metadata;
import t9a.b;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/product/impl/ObricProductImpl;", "Lcom/obric/assistant/product/api/IObricProduct;", "<init>", "()V", "initProductSdk", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricProductImpl implements IObricProduct {

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    public ObricProductImpl() {
    }

    @Override // com.obric.assistant.product.api.IObricProduct
    public final void a() {
        int r100 = b.f545141a;
        t9a.a.f545139a.getClass();
        ObricProductSdkImpl.Companion.getClass();
        ObricProductSdkImpl.access$getInstance$cp().init();
    }
}
