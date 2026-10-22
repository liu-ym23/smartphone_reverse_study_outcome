package com.bytedance.android.livesdk.log.filter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0 extends a<am2.o> implements r<am2.o> {
    public am2.o c;

    public b0() {
    }

    public final void J(long r4) {
        am2.o r0 = this.c;
        if (r0 != null) goto L5;
    L6:
        this.b.clear();
        return;
    L5:
        if (r0.a != r4) goto L6;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r1) {
        this.c = (am2.o) r1;
    }
}
