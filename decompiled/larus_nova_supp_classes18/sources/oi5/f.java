package oi5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground.permission.share.item.view.SharePermissionView;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.checker.BizChecker;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.z;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends z {
    public SharePermissionView c;
    public g d;

    public final class a extends com.bytedance.ee.bear.share.newshare.c {
        public final /* synthetic */ f a;

        @Override // com.bytedance.ee.bear.share.newshare.c, com.bytedance.ee.bear.share.newshare.a
        public final String b() {
            Context r0 = this.a.getContext();
            if (r0 == null) goto L6;
            String r1 = r0.getString(2131889300);
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        @Override // com.bytedance.ee.bear.share.newshare.c
        public final boolean c() {
            ShareParams r0 = this.a.b;
            boolean r2 = false;
            if (r0 == null) goto L8;
            if (r0.getType() != 44) goto L8;
            r2 = true;
        L8:
            return !r2;
        }

        public a(f r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        ShareDocInfo r0 = (ShareDocInfo) d(ShareDocInfo.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        ShareParams r2 = this.b;
        if (r2 != null) goto L8;
        return null;
    L8:
        Intrinsics.checkNotNullParameter(r0, "shareInfo");
        Intrinsics.checkNotNullParameter(r2, "shareParams");
        Context r1 = getContext();
        if (r1 != null) goto L12;
    L14:
        SharePermissionView r3 = this.c;
        boolean r4 = true;
        if (r3 != null) goto L17;
    L30:
        b0.d r6 = b0.d.b;
        com.bytedance.ee.bear.share.newshare.c[] r5 = new com.bytedance.ee.bear.share.newshare.c[2];
        if (r0.i == true) goto L33;
    L35:
        boolean r7 = false;
    L36:
        r5[0] = new BizChecker(r7);
        r5[1] = new a(this);
        List r8 = CollectionsKt.listOf(r5);
        if (r0.isOwner() == false) goto L39;
    L42:
        List r9 = CollectionsKt.listOf(new BizChecker(r4));
        SharePermissionView r11 = this.c;
        return z.g(this, r6, null, r8, r9, this.d, r11, 2);
    L39:
        if (r0.f.canManagePermissionMeta() == true) goto L42;
        r4 = false;
        goto L42
    L33:
        if (r0.h == false) goto L35;
        r7 = true;
        goto L36
    L17:
        if (r0.isOwner() == true) goto L21;
        if (r0.f.canManagePermissionMeta() == true) goto L21;
    L23:
        boolean r10 = false;
    L24:
        ImageView r12 = r3.a;
        if (r12 == null) goto L30;
        if (r10 == false) goto L28;
        int r13 = 0;
    L29:
        r12.setVisibility(r13);
        goto L30
    L28:
        r13 = 8;
    L21:
        if (r2.getType() == 44) goto L23;
        r10 = true;
        goto L24
    L12:
        if (this.d != null) goto L14;
        this.d = new g(r2, r1, r0, this);
        goto L14
    }

    public f() {
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
        if (r4 == null) goto L5;
        SharePermissionView r5 = new SharePermissionView(r4);
    L6:
        this.c = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }
}
