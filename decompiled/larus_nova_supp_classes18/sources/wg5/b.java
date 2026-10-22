package wg5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.isv.template.TemplateInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import kotlin.jvm.internal.Intrinsics;
import vg5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends g {
    public final Context p;

    @Override // tg5.b
    public final int D() {
        return 2131887832;
    }

    @Override // tg5.b
    public final boolean x0() {
        return false;
    }

    @Override // tg5.b, tg5.p
    public final void o6() {
        String r0 = this.p.getString(2131887976);
        Toast.showSuccessText(this.p, r0);
    }

    @Override // vg5.g, tg5.b
    public final BaseInviteCollaboratorManageAdapter p() {
        return new TemplateInviteCollaboratorManageAdapter(((i0) org.koin.java.a.c(i0.class, null, null, 6)).c(), ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2());
    }

    @Override // tg5.b, tg5.p
    public final void A8() {
        T();
        Y();
        a0();
    }

    public final Context getContext() {
        return this.p;
    }

    @Override // tg5.b
    public final void o0(boolean r1) {
        super.o0(false);
    }

    public b(Context r2, View r3, DocPermSetInfo r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "permSetInfo");
        super(r2, r3, r4);
        this.p = r2;
        ((TextView) r3.findViewById(2131388793)).setText(r2.getText(2131887979));
    }
}
