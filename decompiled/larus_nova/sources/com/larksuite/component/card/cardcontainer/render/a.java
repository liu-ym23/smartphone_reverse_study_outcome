package com.larksuite.component.card.cardcontainer.render;

import com.larksuite.component.card.cardcontainer.UniversalCardLynxRender;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UniversalCardLynxRender f283248a;

    public void a() {
    }

    public a(UniversalCardLynxRender r100, CardConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxRender");
        Intrinsics.checkNotNullParameter(r101, "cardConfig");
        this.f283248a = r100;
    }

    public final void b(CardData r100, CardContext r101, CardConfig r110) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
        Intrinsics.checkNotNullParameter(r101, "cardContext");
        Intrinsics.checkNotNullParameter(r110, "cardConfig");
        com.larksuite.component.card.cardcontainer.b r102 = this.f283248a.f283210c;
        String r103 = r100.getCardID();
        String r104 = r100.getUniversalCardID();
        long r105 = System.currentTimeMillis();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "cardId");
        Intrinsics.checkNotNullParameter(r101, "cardContext");
        r102.f283226a = r101;
        r102.f283231f = r103;
        r102.f283232g = r104;
        r102.f283227b = r105;
        this.f283248a.c(r100, r101, r110, r110.getMaxWidth());
    }
}
