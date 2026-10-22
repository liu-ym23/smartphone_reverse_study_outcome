package com.larus.dorag.widget;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements b98.d {
    public d() {
    }

    @Override // b98.d
    public final void a(int r100, int r101) {
        FLogger r102 = FLogger.f375446a;
        r102.i("DoraWidgetCenter", "onStateChange, scene: " + r100 + ", state: " + r101);
        if (r100 != 1) goto L5;
        int r103 = 1;
    L15:
        if (r103 != (-1)) goto L18;
        r102.i("DoraWidgetCenter", "onStateChange, uncare scene: " + r100);
        return;
    L18:
        if (r101 == 1) goto L26;
        if (r101 == 2) goto L22;
        r102.i("DoraWidgetCenter", "onStateChange: scene " + r100 + ", unknown state " + r101);
        return;
    L22:
        if (f.f341001d != r103) goto L24;
        r102.i("DoraWidgetCenter", "onStateChange, preScene exit, preScene: " + f.f341001d);
        f.f341001d = 0;
        String r104 = f.f340998a;
        f.a();
        return;
    L24:
        r102.i("DoraWidgetCenter", "onStateChange, exiting scene not match, preScene: " + f.f341001d + ", exitScene: " + r103);
        return;
    L26:
        if (r103 == f.f341001d) goto L32;
        r102.i("DoraWidgetCenter", "onStateChange, newScene enter, preScene: " + f.f341001d + ", newScene: " + r103);
        f.f341001d = r103;
        String r105 = f.f340998a;
        f.a();
        return;
    L32:
        return;
    L5:
        if (r100 != 6) goto L7;
        r103 = 3;
        goto L15
    L7:
        if (r100 != 7) goto L9;
        r103 = 2;
        goto L15
    L9:
        if (r100 == 8) goto L11;
        r103 = -1;
        goto L15
    L11:
        r103 = 4;
        goto L15
    }
}
