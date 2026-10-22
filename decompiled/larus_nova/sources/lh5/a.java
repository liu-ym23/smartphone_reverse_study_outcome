package lh5;

import com.bytedance.ee.bear.middleground.permission.dlp.cache.DlpCacheModel;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements h.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.d.a f509239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f509240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f509241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f509242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b f509243e;

    @Override // lh5.h.b
    public final void a(DlpPolicyModel r100) {
        if (r100 != null) goto L4;
    L8:
        b r101 = this.f509243e;
        com.bytedance.ee.bear.middleground_permission_export.model.d.a r102 = this.f509239a;
        r101.getClass();
        b.e(r102, 0);
        return;
    L4:
        if (r100.getPolicy() == null) goto L8;
        com.bytedance.ee.bear.middleground.permission.dlp.cache.a r103 = this.f509243e.f509244a;
        r103.d(r100, this.f509240b, this.f509241c);
        r103.a();
        DlpCacheModel.NodeData r104 = this.f509243e.f509244a.c(this.f509240b);
        b r105 = this.f509243e;
        String r106 = this.f509242d;
        com.bytedance.ee.bear.middleground_permission_export.model.d.a r107 = this.f509239a;
        r105.getClass();
        b.c(r104, r106, r107);
    }

    public a(b r100, com.bytedance.ee.bear.middleground_permission_export.model.d.a r101, String r102, String r103, String r104) {
        this.f509243e = r100;
        this.f509239a = r101;
        this.f509240b = r102;
        this.f509241c = r103;
        this.f509242d = r104;
    }
}
