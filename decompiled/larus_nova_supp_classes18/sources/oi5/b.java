package oi5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.middleground.permission.setting.bitable.BitableProView;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.checker.BizChecker;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.z;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends z {
    public final com.bytedance.ee.bear.share.export.h c;
    public BitableProView d;
    public a e;

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
        Intrinsics.checkNotNullParameter(r2, "params");
        if (this.e != null) goto L12;
        this.e = new a(r2, this);
    L12:
        return z.g(this, b0.a.b, null, CollectionsKt.listOf(new BizChecker(!r0.j)), null, this.e, this.d, 10);
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        return this.d;
    }

    public b(com.bytedance.ee.bear.share.export.h r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final void f(c0 r2, ShareParams r3) {
        Intrinsics.checkNotNullParameter(r2, "shareProvider");
        Intrinsics.checkNotNullParameter(r3, "shareParams");
        super.f(r2, r3);
        Context r4 = getContext();
        if (r4 == null) goto L5;
        BitableProView r0 = new BitableProView(r4);
    L6:
        this.d = r0;
        if (r0 == null) goto L14;
        Boolean r5 = r3.isFa();
        if (r5 == null) goto L11;
        boolean r6 = r5.booleanValue();
    L12:
        r0.setIsFa(r6);
        return;
    L11:
        r6 = false;
        goto L12
    L14:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
