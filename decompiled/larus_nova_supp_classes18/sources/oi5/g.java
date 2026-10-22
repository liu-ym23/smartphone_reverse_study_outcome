package oi5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.view.ShareNewFragment;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ ShareParams a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ShareDocInfo c;
    public final /* synthetic */ f d;

    public g(ShareParams r1, Context r2, ShareDocInfo r3, f r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (this.a.getType() != 44) goto L7;
        Toast.showFailureText(this.b, 2131889300);
        return;
    L7:
        if (this.c.isOwner() == false) goto L9;
    L11:
        HashMap r8 = new HashMap();
        String r0 = this.c.e.getCreatorTenantId();
        int r1 = mi5.h.a;
        ShareParams r2 = this.a;
        Context r3 = this.b;
        com.bytedance.ee.bear.share.newshare.b r4 = this.d.c();
        if (r4 == null) goto L14;
        ShareNewFragment r5 = r4.getHostFragment();
    L15:
        mi5.h.a(r2, r0, r3, r5, Long.valueOf(this.c.e.getRealSubType()));
        int r6 = h.a;
        h.a(r8, this.c.f.getReportJson(), this.c.g.getReportJson(), this.a);
        return;
    L14:
        r5 = null;
        goto L15
    L9:
        if (this.c.f.canManagePermissionMeta() == true) goto L11;
    }
}
