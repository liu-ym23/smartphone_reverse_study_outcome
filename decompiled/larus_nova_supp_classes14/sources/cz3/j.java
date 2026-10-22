package cz3;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.ManagerContext;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.apps.framework.utils.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a<Object> implements i {
    @Override // az3.a
    public final void C() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void E() {
    }

    @Override // cz3.i
    public final void i() {
        this.d.b();
        Context r0 = this.d.getContext();
        int r1 = h.a;
        Intrinsics.checkNotNullParameter(r0, "context");
    }

    @Override // cz3.i
    public final boolean k() {
        if (com.bytedance.awemeopen.infra.util.h.a(this.d.getContext()) == true) goto L6;
        Context r0 = this.d.getContext();
        n0.b(r0, 0, r0.getString(2131894241), 0, 17);
        return false;
    L6:
        return true;
    }

    @Override // cz3.i
    public final void u() {
        this.d.b();
        Context r0 = this.d.getContext();
        int r1 = h.a;
        Intrinsics.checkNotNullParameter(r0, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cz3.i
    public final boolean w(MentionEditText r2) {
        if (y.a(r2) == true) goto L5;
        this.d.b();
        Context r3 = this.d.getContext();
        int r0 = h.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        return true;
    L5:
        return false;
    }

    public j(ManagerContext r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "managerContext");
        Intrinsics.checkNotNullParameter(r3, "tag");
        super(r2, r3);
        H(i.class, this);
        r2.n = this;
    }
}
