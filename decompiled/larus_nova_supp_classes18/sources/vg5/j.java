package vg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ UserInfo b;

    public j(g r1, UserInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        g r5 = this.a;
        UserInfo r0 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "userInfo");
        tt5.a.h("DocInviteMemberManagerView", "onClickSetFullAccess()...pos = " + r5.n);
        r0.setPermission(DocUserPermission.USER_PERM_FULL_ACCESS);
        r5.L().notifyItemChanged(r5.n);
        vi5.a r6 = r5.o;
        if (r6 == null) goto L6;
        r6.b();
        return;
    }
}
