package lh5;

import com.bytedance.ee.bear.middleground.permission.dlp.cache.DlpCacheModel;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements h.b {
    public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.d.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ b e;

    @Override // lh5.h.b
    public final void a(DlpPolicyModel r4) {
        if (r4 != null) goto L4;
    L8:
        b r5 = this.e;
        com.bytedance.ee.bear.middleground_permission_export.model.d.a r0 = this.a;
        r5.getClass();
        b.e(r0, 0);
        return;
    L4:
        if (r4.getPolicy() == null) goto L8;
        com.bytedance.ee.bear.middleground.permission.dlp.cache.a r1 = this.e.a;
        r1.d(r4, this.b, this.c);
        r1.a();
        DlpCacheModel.NodeData r6 = this.e.a.c(this.b);
        b r2 = this.e;
        String r3 = this.d;
        com.bytedance.ee.bear.middleground_permission_export.model.d.a r7 = this.a;
        r2.getClass();
        b.c(r6, r3, r7);
    }

    public a(b r1, com.bytedance.ee.bear.middleground_permission_export.model.d.a r2, String r3, String r4, String r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
