package com.ss.android.lark.message.universalcard.datachannel;

import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.CardRenderData;
import com.ss.android.lark.message.lynxcard.message.p;

/* JADX INFO: loaded from: classes36.dex */
public interface a {
    void b(String r100, String r101, p r102);

    void c(String r100, CardData r101, CardContext r102, CardConfig r103, boolean r104);

    CardRenderData d(String r100);

    void e(String r100, String r101, p r102);

    void onDestroy();
}
