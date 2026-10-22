package n25;

import android.content.Context;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import vv4.m;
import vv4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends g {
    public final n F;

    @Override // n25.g
    public final void s() {
        super.s();
        f25.j r0 = (f25.j) this.F.a(f25.j.class);
        if (r0 == null) goto L8;
        tt5.a.h(this.b, "Fetch check key: " + this.a);
        this.e = this.e.replace("{{ iframeJsbCheck }}", this.a);
        String r2 = this.a;
        f25.f r1 = r0.a;
        if (r1 == null) goto L7;
        r1.h = r2;
        tt5.a.h(r1.a, "==openDocs==fetch== mFetchCheckKey is " + r1.h);
    L9:
        n r3 = this.F;
        r3.getClass();
        ArrayList r4 = new ArrayList();
        Iterator r5 = ((ArrayList) r3.b).iterator();
    L11:
        if (r5.hasNext() == false) goto L16;
        m r6 = (m) r5.next();
        if ((r6 instanceof vv4.e) == false) goto L11;
        r4.add((vv4.e) r6);
        goto L11
    L16:
        if (CollectionUtils.isEmpty(r4) == false) goto L18;
        return;
    L18:
        this.e = this.e.replace("{{ iframeJsbCheck }}", this.a);
        Iterator r7 = r4.iterator();
    L20:
        if (r7.hasNext() == false) goto L22;
        vv4.e r8 = (vv4.e) r7.next();
        tt5.a.h(this.b, r8 + " IframeJsbCheck key: " + this.a);
        r8.a(this.a);
        goto L20
    L22:
        return;
    L7:
        tt5.a.h("FetchWebService", "Fetch Handler is null and fetch check key " + r2);
        goto L9
    L8:
        tt5.a.h(this.b, "Fetch check key is null because of empty webservice");
        goto L9
    }

    public a(Context r2, String r3, n r4, boolean r5) {
        super(r2, r3, r5, "mobile_index.html");
        this.F = r4;
    }
}
