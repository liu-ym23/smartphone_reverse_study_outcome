package msc;

import kotlin.text.Typography;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements lsc.m.c<ThematicBreak> {
    public a() {
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        ThematicBreak r102 = (ThematicBreak) r101;
        r100.C(r102);
        int r103 = r100.length();
        r100.builder().a(Typography.nbsp);
        r100.G(r102, r103);
        r100.q(r102);
    }
}
