package cz4;

import com.bytedance.ee.bear.doc.resupdate.f0;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f466048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f466049b;

    @Override // com.bytedance.ee.bear.doc.resupdate.f0
    public final void onFail() {
        f0 r100 = this.f466048a;
        if (r100 == null) goto L6;
        r100.onFail();
        return;
    }

    @Override // com.bytedance.ee.bear.doc.resupdate.f0
    public final void onReady() {
        f0 r100 = this.f466048a;
        if (r100 == null) goto L6;
        r100.onReady();
        return;
    }

    public d(f0 r100) {
        this.f466048a = r100;
    }
}
