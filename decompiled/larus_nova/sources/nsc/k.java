package nsc;

import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.ListMarginInfo;
import io.noties.markwon.core.spans.r;
import lsc.t;
import lsc.u;
import lsc.x;
import msc.s;

/* JADX INFO: loaded from: classes5.dex */
public class k implements x {
    public k() {
    }

    @Override // lsc.x
    public Object a(lsc.h r100, t r101) {
        int r102 = b(r100, r101, null);
        boolean r103 = CoreProps.f492263e.b(r101).booleanValue();
        if (CoreProps.ListItemType.BULLET != CoreProps.f492259a.b(r101)) goto L11;
        s r104 = r100.f510591a;
        u r105 = (u) r101;
        int r106 = ((Integer) r105.b(CoreProps.f492261c, -1)).intValue();
        if (r106 == 0) goto L8;
        if (r106 == (-1)) goto L8;
    L12:
        return new io.noties.markwon.core.spans.d(r104, r106, r102, r103);
    L8:
        r106 = CoreProps.f492260b.b(r105).intValue();
        goto L12
    L11:
        return new r(r100.f510591a, null, CoreProps.f492262d.b(r101) + ". ", r102, r103);
    }

    public static int b(lsc.h r100, t r101, ListMarginInfo r102) {
        u r103 = (u) r101;     // Catch: Exception -> L14
        int r104 = ((Integer) r103.b(CoreProps.f492260b, -1)).intValue();     // Catch: Exception -> L14
        int r105 = ((Integer) r103.b(CoreProps.f492261c, -1)).intValue();     // Catch: Exception -> L14
        if (r104 == (-1)) goto L12;
        if (r105 == (-1)) goto L12;
        if (r102 == null) goto L8;
        int r106 = r102.getListMargin();     // Catch: Exception -> L14
    L9:
        if (r104 != 0) goto L12;
        if (r105 == 0) goto L12;
        return r105 * r106;
    L8:
        r106 = r100.f510591a.f515543c;     // Catch: Exception -> L14
    L12:
        return 0;
    }
}
