package zsc;

import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public class d extends i {
    @Override // zsc.i
    public final char d() {
        return '!';
    }

    @Override // zsc.i
    public uvc.b b() {
        int r100 = this.f573521d + 1;
        this.f573521d = r100;
        if (c() != '[') goto L9;
        this.f573521d++;
        Text r101 = f("![");
        k r102 = this.f573518a;
        org.commonmark.internal.e r103 = new org.commonmark.internal.e(r101, r100, ((j) r102).f573536j, ((j) r102).f573535i, true);
        j r104 = (j) r102;
        org.commonmark.internal.e r105 = r104.f573536j;
        if (r105 == null) goto L7;
        r105.f525678g = true;
    L7:
        r104.f573536j = r103;
        return r101;
    L9:
        return null;
    }

    public d() {
    }
}
