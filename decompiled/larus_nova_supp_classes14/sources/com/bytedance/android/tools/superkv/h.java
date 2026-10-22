package com.bytedance.android.tools.superkv;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements g.d {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ g b;

    @Override // com.bytedance.android.tools.superkv.g.d
    public final void a(String r3) {
        this.b.d.remove(r3);
        int[] r4 = this.a;
        r4[0] = r4[0] + 1;
    }

    public h(g r1, int[] r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // com.bytedance.android.tools.superkv.g.d
    public final void b(String r2, g.c r3) {
        this.b.d.put(r2, r3);
        int[] r4 = this.a;
        r4[0] = r4[0] + 1;
    }
}
