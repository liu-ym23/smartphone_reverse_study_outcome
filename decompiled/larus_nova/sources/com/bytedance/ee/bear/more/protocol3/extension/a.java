package com.bytedance.ee.bear.more.protocol3.extension;

import android.os.Parcelable;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.retention.RetentionSettingVisible;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import io.reactivex.Flowable;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Deprecated(message = "Use @DocMoreInfoBehavior instead!")
public final class a extends u<oj5.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oj5.a f234819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BearUrl f234820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BearUrl f234821e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.protocol3.extension.a$a, reason: collision with other inner class name */
    public static final class C3366a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.u
    public final void a() {
        tt5.a.h("DefMoreInfoBehavior", "create.");
        e(this.f234819c);
        String r100 = this.f234821e.f222561b;
        Parcelable.Creator<Document> r101 = Document.CREATOR;
        if (lbb.a.a(r100) == false) goto L5;
        BearUrl r102 = this.f234820d;
    L6:
        String r103 = r102.f222561b;
        int r104 = sbb.e.g(r102.f222560a);
        BearUrl r105 = this.f234820d;
        String r106 = r105.f222561b;
        Flowable<DocMetaInfo> r107 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).b(r106, sbb.e.g(r105.f222560a));
        Flowable<DocObjInfo> r108 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).e(r103, r104);
        if ((this.f234819c instanceof oj5.f) == true) goto L9;
    L11:
        Flowable r110 = null;
    L12:
        Flowable<DocPermission> r111 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r103, r104);
        Flowable<DocVersion> r112 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).f(r103, r104);
        if (r104 != 16) goto L15;
        boolean r113 = true;
    L16:
        Flowable<RetentionSettingVisible> r114 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().d(r104, r103);
        rc5.a r115 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
        if (r113 == false) goto L19;
        String r109 = r103;
    L20:
        Flowable<Boolean> r116 = r115.S(r109);
        Flowable<Boolean> r117 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).i(r102.f222564e);
        boolean r118 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("admin_security_retention");
        b(r107.subscribe(new j(this), k.f234835a));
        if (r104 == 12) goto L23;
    L24:
        if (r110 != null) goto L26;
        b(r108.subscribe(new l(this), m.f234837a));
    L27:
        b(r111.subscribe(new q(this), r.f234842a));
        b(r112.subscribe(new b(this), c.f234823a));
        b(r116.observeOn(fo5.d.d()).subscribe(new d(this, r113, r103, r106, r104), e.f234829a));
        tt5.a.h("DefMoreInfoBehavior", "retentionFlow .hasRetentionLabelBenefit = " + r118 + ' ');
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("suite.admin.vault.retention_new") == true) goto L31;
        if (r118 == true) goto L31;
    L33:
        b(r117.observeOn(fo5.d.d()).subscribe(new h(this), i.f234833a));
        return;
    L31:
        if (r104 == 16) goto L33;
        b(r114.subscribe(new f(this), g.f234831a));
        goto L33
    L26:
        b(Flowable.zip(r108, r110, n.f234838a).subscribe(new o(this), p.f234840a));
        goto L27
    L23:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.workspace.wiki_to_quickaccess_enabled") == false) goto L27;
    L19:
        r109 = r106;
        goto L20
    L15:
        r113 = false;
        goto L16
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.workspace.wiki_to_quickaccess_enabled") == false) goto L11;
        int r119 = s.f234843a;
        r110 = s.a(((oj5.f) this.f234819c).O);
        goto L12
    L5:
        r102 = this.f234821e;
        goto L6
    }

    public a(String r100, String r101, oj5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "originUrl");
        Intrinsics.checkNotNullParameter(r102, "initState");
        this.f234819c = r102;
        this.f234820d = s45.p.a().Z(r100);
        this.f234821e = s45.p.a().Z(r101);
    }
}
