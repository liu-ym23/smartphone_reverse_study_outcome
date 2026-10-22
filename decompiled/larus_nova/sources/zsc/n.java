package zsc;

import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public class n extends i {
    @Override // zsc.i
    public final char d() {
        return '[';
    }

    @Override // zsc.i
    public uvc.b b() {
        int r100 = this.f573521d;
        this.f573521d = r100 + 1;
        Text r101 = f("[");
        k r102 = this.f573518a;
        org.commonmark.internal.e r103 = new org.commonmark.internal.e(r101, r100, ((j) r102).f573536j, ((j) r102).f573535i, false);
        j r104 = (j) r102;
        org.commonmark.internal.e r105 = r104.f573536j;
        if (r105 == null) goto L5;
        r105.f525678g = true;
    L5:
        r104.f573536j = r103;
        return r101;
    }

    public n() {
    }
}
