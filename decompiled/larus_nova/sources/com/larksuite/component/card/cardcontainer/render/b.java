package com.larksuite.component.card.cardcontainer.render;

import com.larksuite.component.card.cardcontainer.UniversalCardLynxRender;
import com.larksuite.component.card.protocol.CardConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f283249b;

    @Override // com.larksuite.component.card.cardcontainer.render.a
    public final void a() {
    }

    public b(UniversalCardLynxRender r100, CardConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxRender");
        Intrinsics.checkNotNullParameter(r101, "cardConfig");
        super(r100, r101);
        this.f283249b = "";
    }
}
