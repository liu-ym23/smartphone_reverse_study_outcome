package oi5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground.permission.share.item.view.DocumentLinkShareNewView;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.checker.BizChecker;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.z;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends z {
    public DocumentLinkShareNewView c;
    public d d;

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        ShareDocInfo r0 = (ShareDocInfo) d(ShareDocInfo.class);
        DocumentLinkShareNewView r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        ShareParams r2 = this.b;
        if (r2 != null) goto L9;
        return null;
    L9:
        if (r0.h == false) goto L17;
        DocumentLinkShareNewView r3 = this.c;
        if ((r3 instanceof ri5.a) == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L17;
        r3.setPublicPermission(r0.g);
    L17:
        if (r0.i == false) goto L23;
        DocumentLinkShareNewView r4 = this.c;
        if ((r4 instanceof ri5.a) == false) goto L21;
        r1 = r4;
    L21:
        if (r1 == null) goto L23;
        r1.setDocPermSetInfo(h.c(r0, r0.h, r2));
    L23:
        DocumentLinkShareNewView r5 = this.c;
        boolean r6 = false;
        if (r5 != null) goto L26;
    L39:
        Intrinsics.checkNotNullParameter(r0, "shareInfo");
        Intrinsics.checkNotNullParameter(r2, "params");
        if (this.d != null) goto L42;
        this.d = new d(this, r2, r0);
    L42:
        b0.e r7 = b0.e.b;
        BizChecker[] r8 = new BizChecker[2];
        r8[0] = new BizChecker(!r0.j);
        if (r0.i == true) goto L45;
    L47:
        r8[1] = new BizChecker(r6);
        return z.g(this, r7, null, CollectionsKt.listOf(r8), null, this.d, this.c, 10);
    L45:
        if (r0.h == false) goto L47;
        r6 = true;
        goto L47
    L26:
        if (r0.isOwner() == true) goto L30;
        if (r0.f.canManagePermissionMeta() == true) goto L30;
    L32:
        boolean r9 = false;
    L33:
        ImageView r10 = r5.g;
        if (r10 == null) goto L39;
        if (r9 == false) goto L37;
        int r11 = 0;
    L38:
        r10.setVisibility(r11);
        goto L39
    L37:
        r11 = 8;
    L30:
        if (r2.getType() == 44) goto L32;
        r9 = true;
        goto L33
    }

    public e() {
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final void f(c0 r2, ShareParams r3) {
        Intrinsics.checkNotNullParameter(r2, "shareProvider");
        Intrinsics.checkNotNullParameter(r3, "shareParams");
        super.f(r2, r3);
        Context r4 = getContext();
        if (r4 == null) goto L6;
        DocumentLinkShareNewView r0 = new DocumentLinkShareNewView(r4);
        this.c = r0;
        r0.setInfo(r3.getModule());
        return;
    }
}
