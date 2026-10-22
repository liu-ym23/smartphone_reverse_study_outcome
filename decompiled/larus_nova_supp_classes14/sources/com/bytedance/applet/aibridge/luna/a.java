package com.bytedance.applet.aibridge.luna;

import com.larus.common_ui.dialog.p0;
import e3.d;
import f3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements p0 {
    public final /* synthetic */ JumpToLunaMethod a;
    public final /* synthetic */ d b;
    public final /* synthetic */ AbsJumpToLunaMethodIDL.a c;
    public final /* synthetic */ h<AbsJumpToLunaMethodIDL.b> d;

    public final void confirm() {
        final JumpToLunaMethod r0 = this.a;
        final d r1 = this.b;
        final AbsJumpToLunaMethodIDL.a r2 = this.c;
        final h<AbsJumpToLunaMethodIDL.b> r3 = this.d;
        com.obric.assistant.spi.keyguard.a.a(new qv3.a(r0, r1, r2, r3), new qv3.b(r3), null, false, 28);
    }

    public a(JumpToLunaMethod r1, d r2, AbsJumpToLunaMethodIDL.a r3, h<AbsJumpToLunaMethodIDL.b> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
