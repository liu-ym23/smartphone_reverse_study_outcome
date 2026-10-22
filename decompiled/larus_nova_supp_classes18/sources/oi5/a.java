package oi5;

import android.view.View;
import com.bytedance.ee.bear.share.export.ShareParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ShareParams a;
    public final /* synthetic */ b b;

    public a(ShareParams r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (Intrinsics.areEqual(this.a.isFa(), Boolean.TRUE) == false) goto L10;
        com.bytedance.ee.bear.document.share.a.a r3 = this.b.c;
        if (r3 == null) goto L7;
        r3.a();
    L7:
        com.bytedance.ee.bear.share.newshare.b r4 = this.b.c();
        if (r4 == null) goto L10;
        r4.a();
    L10:
        com.bytedance.ee.bear.middleground.permission.c.V("bitable_premium_permission_go_check", "ccm_bitable_premium_permission_setting_view");
    }
}
