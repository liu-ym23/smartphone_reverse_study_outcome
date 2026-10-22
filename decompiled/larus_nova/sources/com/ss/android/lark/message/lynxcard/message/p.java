package com.ss.android.lark.message.lynxcard.message;

import com.larksuite.component.card.protocol.CardRenderData;

/* JADX INFO: loaded from: classes36.dex */
public final class p implements com.ss.android.lark.message.universalcard.datachannel.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f432218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxCardViewHolder f432219b;

    @Override // com.ss.android.lark.message.universalcard.datachannel.b
    public final void a(CardRenderData r100) {
        this.f432218a.h(this.f432219b, r100);
    }

    public p(b r100, LynxCardViewHolder r101) {
        this.f432218a = r100;
        this.f432219b = r101;
    }
}
