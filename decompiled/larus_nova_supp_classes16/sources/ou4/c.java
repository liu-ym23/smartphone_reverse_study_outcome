package ou4;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.bitable.share.invitemember.manager.BitableShareInviteMemberManagerAdapter;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.export.UserInfo;
import kotlin.jvm.internal.Intrinsics;
import tg5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends tg5.b {
    public final Context k;
    public final View l;
    public final BitableSharePermSetInfo m;

    public static final class a {
    }

    public static final class b implements BaseInviteCollaboratorManageAdapter.a {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void a(UserInfo r3, int r4) {
            tt5.a.h("BitableShareInviteMemberManagerView", "onClickRemovePermission()...pos = " + r4);
            p.a r0 = ((tg5.b) this.a).d;
            if (r0 == null) goto L5;
            Intrinsics.checkNotNull(r3);
            r0.W(r3);
        L5:
            this.a.L().notifyItemRemoved(r4);
        }
    }

    static {
    }

    public final BaseInviteCollaboratorManageAdapter p() {
        BitableShareInviteMemberManagerAdapter r2 = new BitableShareInviteMemberManagerAdapter(((i0) org.koin.java.a.c(i0.class, null, null, 6)).c(), ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2());
        ((BaseInviteCollaboratorManageAdapter) r2).c = new b(this);
        return r2;
    }

    public final void A8() {
        T();
        Y();
        a0();
    }

    public final void create() {
        super.create();
        ((TextView) this.l.findViewById(2131388793)).setText(mu4.b.a(this.k, this.m.d.getShareType()));
        TextView r0 = (TextView) this.l.findViewById(2131381038);
        if (this.m.d.getShareType() != EShareType.DASHBOARD) goto L5;
    L12:
        r0.setVisibility(8);
        this.l.findViewById(2131381033).setVisibility(8);
        return;
    L5:
        if (this.m.d.getShareType() == EShareType.Record) goto L12;
        Context r1 = r0.getContext();
        EShareType r2 = this.m.d.getShareType();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "shareType");
        if (mu4.b.a.a[r2.ordinal()] != 3) goto L10;
        String r3 = r1.getString(2131888118);
    L11:
        r0.setText(r3);
        return;
    L10:
        r3 = r1.getString(2131886837);
        goto L11
    }

    public final void o0(boolean r1) {
        super.o0(false);
    }

    public c(Context r2, View r3, BitableSharePermSetInfo r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "permSetInfo");
        Intrinsics.checkNotNullParameter(r5, "creatorTenantId");
        super(r2, r3, r4.getType(), r5);
        this.k = r2;
        this.l = r3;
        this.m = r4;
    }
}
