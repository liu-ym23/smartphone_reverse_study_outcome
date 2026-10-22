package com.larksuite.component.card.plugin;

import com.larksuite.framework.apiplugin.LKEvent;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class h {
    public static final com.larksuite.component.card.cardcontainer.c a(LKEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.f285495h;
        Object r102 = null;
        if ((r101 instanceof ILynxBridgeContext) == false) goto L5;
        ILynxBridgeContext r103 = (ILynxBridgeContext) r101;
    L6:
        if (r103 == null) goto L12;
        ILynxContainerContext r104 = r103.getContainerContext();
        if (r104 == null) goto L12;
        Map<String, Object> r105 = r104.getBizExtra();
        if (r105 == null) goto L12;
        Object r106 = r105.get("card_share_data");
    L14:
        if ((r106 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L18;
        r102 = r106;
    L18:
        return (com.larksuite.component.card.cardcontainer.c) r102;
    L12:
        r106 = null;
        goto L14
    L5:
        r103 = null;
        goto L6
    }
}
