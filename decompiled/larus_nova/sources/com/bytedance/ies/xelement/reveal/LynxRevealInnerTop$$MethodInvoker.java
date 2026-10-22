package com.bytedance.ies.xelement.reveal;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;

/* JADX INFO: loaded from: classes19.dex */
public class LynxRevealInnerTop$$MethodInvoker implements a<LynxRevealInnerTop> {
    public LynxRevealInnerTop$$MethodInvoker() {
    }

    public void invoke(LynxRevealInnerTop r100, String r101, ReadableMap r102, Callback r103) {
        int r104 = r101.hashCode();     // Catch: Exception -> L20
        if (r104 == (-357431021)) goto L11;
        if (r104 == 1908871954) goto L8;
    L13:
        byte r105 = -1;
    L14:
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        r103.invoke(new Object[]{3});     // Catch: Exception -> L20
        return;
    L17:
        r100.scrollIntoView(r102);     // Catch: Exception -> L20
        return;
    L18:
        r100.boundingClientRect(r102, r103);     // Catch: Exception -> L20
        return;
    L8:
        if (r101.equals("scrollIntoView") == false) goto L13;
        r105 = 1;
        goto L14
    L11:
        if (r101.equals("boundingClientRect") == false) goto L13;
        r105 = 0;
    L20:
        e = move-exception;
        e.printStackTrace();
        throw new RuntimeException("invokeMethod error: " + r101 + "\n" + e.toString());
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r100, String r101, ReadableMap r102, Callback r103) {
        invoke((LynxRevealInnerTop) r100, r101, r102, r103);
    }
}
