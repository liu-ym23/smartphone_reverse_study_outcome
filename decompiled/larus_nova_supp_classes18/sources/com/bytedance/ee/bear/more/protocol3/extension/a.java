package com.bytedance.ee.bear.more.protocol3.extension;

import android.os.Parcelable;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.retention.RetentionSettingVisible;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Deprecated(message = "Use @DocMoreInfoBehavior instead!")
public final class a extends u<oj5.a> {
    public final oj5.a c;
    public final BearUrl d;
    public final BearUrl e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.protocol3.extension.a$a, reason: collision with other inner class name */
    public static final class C0119a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.u
    public final void a() {
        tt5.a.h("DefMoreInfoBehavior", "create.");
        e(this.c);
        String r0 = this.e.b;
        Parcelable.Creator<Document> r1 = Document.CREATOR;
        if (lbb.a.a(r0) == false) goto L5;
        BearUrl r2 = this.d;
    L6:
        String r3 = r2.b;
        int r8 = sbb.e.g(r2.a);
        BearUrl r4 = this.d;
        String r5 = r4.b;
        Flowable r6 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).b(r5, sbb.e.g(r4.a));
        Flowable r7 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).e(r3, r8);
        if ((this.c instanceof oj5.f) == true) goto L9;
    L11:
        Flowable r10 = null;
    L12:
        Flowable<DocPermission> r12 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r3, r8);
        Flowable<DocVersion> r13 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).f(r3, r8);
        if (r8 != 16) goto L15;
        boolean r15 = true;
    L16:
        Flowable<RetentionSettingVisible> r14 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().d(r8, r3);
        rc5.a r16 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
        if (r15 == false) goto L19;
        String r9 = r3;
    L20:
        Flowable<Boolean> r11 = r16.S(r9);
        Flowable<Boolean> r17 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).i(r2.e);
        boolean r18 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("admin_security_retention");
        b(r6.subscribe(new j(this), k.a));
        if (r8 == 12) goto L23;
    L24:
        if (r10 != null) goto L26;
        b(r7.subscribe(new l(this), m.a));
    L27:
        b(r12.subscribe(new q(this), r.a));
        b(r13.subscribe(new b(this), c.a));
        b(r11.observeOn(fo5.d.d()).subscribe(new d(this, r15, r3, r5, r8), e.a));
        tt5.a.h("DefMoreInfoBehavior", "retentionFlow .hasRetentionLabelBenefit = " + r18 + ' ');
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("suite.admin.vault.retention_new") == true) goto L31;
        if (r18 == true) goto L31;
    L33:
        b(r17.observeOn(fo5.d.d()).subscribe(new h(this), i.a));
        return;
    L31:
        if (r8 == 16) goto L33;
        b(r14.subscribe(new f(this), g.a));
        goto L33
    L26:
        b(Flowable.zip(r7, r10, n.a).subscribe(new o(this), p.a));
        goto L27
    L23:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.wiki_to_quickaccess_enabled") == false) goto L27;
    L19:
        r9 = r5;
        goto L20
    L15:
        r15 = false;
        goto L16
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.wiki_to_quickaccess_enabled") == false) goto L11;
        int r19 = s.a;
        r10 = s.a(((oj5.f) this.c).O);
        goto L12
    L5:
        r2 = this.e;
        goto L6
    }

    public a(String r2, String r3, oj5.a r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_URL);
        Intrinsics.checkNotNullParameter(r3, "originUrl");
        Intrinsics.checkNotNullParameter(r4, "initState");
        this.c = r4;
        this.d = s45.p.a().Z(r2);
        this.e = s45.p.a().Z(r3);
    }
}
