package cz4;

import com.bytedance.ee.bear.doc.resupdate.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements f0 {
    public final f0 a;
    public int b;

    @Override // com.bytedance.ee.bear.doc.resupdate.f0
    public final void onFail() {
        f0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFail();
        return;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.f0
    public final void onReady() {
        f0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.onReady();
        return;
    }

    public d(f0 r1) {
        this.a = r1;
    }
}
