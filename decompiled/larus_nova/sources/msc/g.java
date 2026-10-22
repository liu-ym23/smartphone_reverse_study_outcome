package msc;

import java.util.ArrayList;
import java.util.Iterator;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public final class g implements lsc.m.c<Text> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f515534a;

    public g(o r100) {
        this.f515534a = r100;
    }

    @Override // lsc.m.c
    public final void a(lsc.m r100, uvc.b r101) {
        Text r102 = (Text) r101;
        String r103 = r102.f525783h;
        r100.builder().c(r103);
        if (((ArrayList) this.f515534a.f515535a).isEmpty() == true) goto L9;
        int r104 = r100.length() - r103.length();
        Iterator r105 = ((ArrayList) this.f515534a.f515535a).iterator();
    L6:
        if (r105.hasNext() == false) goto L9;
        ((o.b) r105.next()).a(r100, r103, r104, r102);
    L9:
        if (((ArrayList) this.f515534a.f515537c).isEmpty() == true) goto L14;
        int r106 = r100.length() - r103.length();
        Iterator r107 = ((ArrayList) this.f515534a.f515537c).iterator();
    L12:
        if (r107.hasNext() == false) goto L17;
        ((o.a) r107.next()).a(r100, r102, r106);
        goto L12
    L17:
        return;
    }
}
