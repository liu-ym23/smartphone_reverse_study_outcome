package com.bytedance.ies.xelement.audiott.transform;

import com.bytedance.ies.xelement.audiott.bean.XAudioSrc;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public class a {
    public a() {
    }

    public void a(XAudioSrc r100, Function1<? super g76.a, Unit> r110) {
        if (r100 != null) goto L4;
        g76.a r101 = null;
    L5:
        r110.invoke(r101);
        return;
    L4:
        r101 = new g76.a(r100.getPlayUrl(), null, null, null, r100.getPlayModel(), 14);
        goto L5
    }
}
