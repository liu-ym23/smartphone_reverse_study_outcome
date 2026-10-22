package mm5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.k;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.export.h;
import com.bytedance.ee.bear.share.externalshare.external.DocShareExternalPresenter;
import com.bytedance.ee.bear.share.externalshare.external.FolderShareExternalPresenter;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends z {
    public final h c;
    public ExternalShareView d;
    public com.bytedance.ee.bear.share.externalshare.external.a e;

    /* JADX INFO: renamed from: mm5.a$a, reason: collision with other inner class name */
    public static final class C0269a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        c0 r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.ee.bear.share.export.f r1 = r0.g;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        com.bytedance.ee.bear.share.externalshare.external.a r2 = this.e;
        if (r2 == null) goto L11;
        r2.i(r1);
    L11:
        ShareParams r3 = this.b;
        if (r3 != null) goto L15;
    L23:
        km5.a r7 = null;
    L36:
        ExternalShareView r4 = this.d;
        if ((r4 instanceof ExternalShareView) == false) goto L39;
        ExternalShareView r5 = r4;
    L40:
        if (r7 == null) goto L66;
        if (r5 == null) goto L66;
        List<ShareItemModel> r6 = ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).getProvider().a(r7);     // Catch: Throwable -> L45
    L47:
        ShareParams r8 = this.b;
        if (r8 != null) goto L50;
    L52:
        boolean r9 = false;
    L53:
        if (r9 == false) goto L64;
        Intrinsics.checkNotNull(r6);
        ArrayList r10 = new ArrayList();
        Iterator r11 = r6.iterator();
    L56:
        if (r11.hasNext() == false) goto L63;
        Object r12 = r11.next();
        if (((ShareItemModel) r12).getType() != ShareType.PasswordLink) goto L60;
        boolean r13 = true;
    L61:
        if (r13 == true) goto L56;
        r10.add(r12);
        goto L56
    L60:
        r13 = false;
        goto L61
    L63:
        r6 = r10;
    L64:
        r5.b(r6);
        goto L66
    L50:
        if (r8.getPasswordSharingEnable() == true) goto L52;
        r9 = true;
    L45:
        th = move-exception;
        tt5.a.e("DocThirdPartyExternalItem", "updateShareItems failed", th, false);
        r6 = CollectionsKt.emptyList();
    L66:
        return z.g(this, b0.h.b, null, null, null, null, this.d, 30);
    L39:
        r5 = null;
        goto L40
    L15:
        if (r3.getType() != 0) goto L21;
        ShareFolderInfo r14 = (ShareFolderInfo) d(ShareFolderInfo.class);
        if (r14 == null) goto L19;
        boolean r15 = r14.j;
    L20:
        r7 = new km5.a(r3.getSource(), r3.getType(), r3.getToken(), r3.isWiki(), false, r3.getMindnoteViewType(), r3.getDisabledShareTypes(), r3.getBadgeShareTypes(), r3.isAtVC(), r3.getAdminPerceiveControl(), !r15, false, null, null, false, r3.getShowExportImage(), null, 81920);
        r7.r = r14;
        goto L36
    L19:
        r15 = true;
        goto L20
    L21:
        ShareDocInfo r16 = (ShareDocInfo) d(ShareDocInfo.class);
        if (r16 == null) goto L23;
        if (r3.isAtVC() == false) goto L27;
        boolean r25 = false;
    L28:
        int r17 = r3.getSource();
        int r18 = r3.getType();
        String r19 = r3.getToken();
        boolean r110 = r3.isWiki();
        boolean r111 = r16.f.canExport();
        String r112 = r3.getMindnoteViewType();
        boolean r113 = r3.isAtVC();
        if (r3.getAdminPerceiveControl() == false) goto L31;
    L34:
        boolean r20 = true;
    L35:
        r7 = new km5.a(r17, r18, r19, r110, r111, r112, null, null, r113, r20, !r16.j, r16.i(), r16.g, r16.f, r25, r3.getShowExportImage(), null, 65536);
        goto L36
    L31:
        if (r16.f.matchPerceiveControl() == true) goto L34;
        r20 = false;
        goto L35
    L27:
        r25 = ((k) org.koin.java.a.c(k.class, null, null, 6)).p(r3.getToken(), r3.getEditionId(), r3.isAtVC());
        goto L28
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final void h() {
        com.bytedance.ee.bear.share.externalshare.external.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final void i() {
        com.bytedance.ee.bear.share.externalshare.external.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        return this.d;
    }

    public a(h r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final void f(c0 r17, ShareParams r18) {
        Intrinsics.checkNotNullParameter(r17, "shareProvider");
        Intrinsics.checkNotNullParameter(r18, "shareParams");
        super.f(r17, r18);
        Context r3 = getContext();
        if (r3 != null) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.share.newshare.b r4 = c();
        if (r4 != null) goto L8;
        return;
    L8:
        this.d = new ExternalShareView(getContext());
        if (r18.getType() != 0) goto L11;
        com.bytedance.ee.bear.share.externalshare.external.a r5 = new FolderShareExternalPresenter(r18, r3, r4, new ShareFolderInfo(0, null, null, null, null, null, null, null, null, 1023));
    L12:
        this.e = r5;
        ExternalShareView r1 = this.d;
        if (r1 == null) goto L16;
        r1.setOnShareItemClickListener(r5);
        return;
    L16:
        return;
    L11:
        r5 = new DocShareExternalPresenter(r18, r3, r4, new ShareDocInfo(0, null, null, null, null, null, 1023), this.c);
        goto L12
    }
}
