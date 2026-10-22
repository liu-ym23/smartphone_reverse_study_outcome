package msc;

import kotlin.text.Typography;
import lsc.y;
import org.commonmark.node.Code;

/* JADX INFO: loaded from: classes5.dex */
public final class k implements lsc.m.c<Code> {
    public k() {
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        Code r102 = (Code) r101;
        int r103 = r100.length();
        y r104 = r100.builder();
        r104.f510625a.append(Typography.nbsp);
        String r105 = r102.f525760h;
        r104.f510625a.append(r105);
        r104.a(Typography.nbsp);
        r100.G(r102, r103);
    }
}
