package com.larksuite.component.card.plugin.audio;

import com.larksuite.component.card.component.audio.service.b;
import com.larksuite.component.card.plugin.OPPlugin;
import com.larksuite.component.card.service.c;
import com.larksuite.component.card.service.d;
import com.larksuite.framework.apiplugin.LKEvent;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0004¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/card/plugin/audio/BaseCardAudioPlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "getAudioService", "Lcom/larksuite/component/card/component/audio/service/ICardAudioService;", "Lcom/larksuite/framework/apiplugin/LKEvent;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseCardAudioPlugin extends OPPlugin {
    public BaseCardAudioPlugin() {
    }

    public final b getAudioService(LKEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.f285495h;
        c r102 = null;
        if ((r101 instanceof ILynxBridgeContext) == false) goto L5;
        ILynxBridgeContext r103 = (ILynxBridgeContext) r101;
    L6:
        if (r103 == null) goto L12;
        ILynxContainerContext r104 = r103.getContainerContext();
        if (r104 == null) goto L12;
        Map<String, Object> r105 = r104.getBizExtra();
        if (r105 == null) goto L12;
        Object r106 = r105.get("card_service");
    L14:
        if ((r106 instanceof d) == true) goto L16;
        r106 = null;
    L16:
        d r107 = (d) r106;
        if (r107 == null) goto L21;
        r102 = r107.getService(b.class);
    L21:
        return (b) r102;
    L12:
        r106 = null;
        goto L14
    L5:
        r103 = null;
        goto L6
    }
}
