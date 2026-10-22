package ug5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.BitableProInviteMemberManagerAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import kotlin.jvm.internal.Intrinsics;
import tg5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends tg5.b {
    public final View k;

    public static final class a {
    }

    public static final class b implements BaseInviteCollaboratorManageAdapter.a {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter.a
        public final void a(UserInfo r3, int r4) {
            tt5.a.h("BitableShareInviteMemberManagerView", "onClickRemovePermission()...pos = " + r4);
            p.a r0 = this.a.d;
            if (r0 == null) goto L5;
            Intrinsics.checkNotNull(r3);
            r0.W(r3);
        L5:
            this.a.L().notifyItemRemoved(r4);
        }
    }

    static {
    }

    @Override // tg5.b
    public final boolean x0() {
        return false;
    }

    @Override // tg5.b
    public final BaseInviteCollaboratorManageAdapter p() {
        BitableProInviteMemberManagerAdapter r2 = new BitableProInviteMemberManagerAdapter(((i0) org.koin.java.a.c(i0.class, null, null, 6)).c(), ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2());
        r2.c = new b(this);
        return r2;
    }

    @Override // tg5.b, tg5.p
    public final void A8() {
        T();
        Y();
        a0();
    }

    @Override // tg5.b
    public final void create() {
        super.create();
        ((TextView) this.k.findViewById(2131381038)).setVisibility(4);
        this.k.findViewById(2131381033).setVisibility(4);
        ((SpaceEditText) this.k.findViewById(2131381012)).setVisibility(8);
    }

    @Override // tg5.b
    public final void o0(boolean r1) {
        super.o0(false);
    }

    public c(Context r2, View r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r5, "creatorTenantId");
        super(r2, r3, r4, r5);
        this.k = r3;
    }
}
