package cz3;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.ManagerContext;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.apps.framework.utils.y;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j extends com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a<Object> implements i {
    @Override // az3.a
    public final void C() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void E() {
    }

    @Override // cz3.i
    public final void i() {
        this.f194421d.b();
        Context r100 = this.f194421d.getContext();
        int r101 = h.f466024a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // cz3.i
    public final boolean k() {
        if (com.bytedance.awemeopen.infra.util.h.a(this.f194421d.getContext()) == true) goto L6;
        Context r100 = this.f194421d.getContext();
        n0.b(r100, 0, r100.getString(R.string.aos_network_unavailable), 0, 17);
        return false;
    L6:
        return true;
    }

    @Override // cz3.i
    public final void u() {
        this.f194421d.b();
        Context r100 = this.f194421d.getContext();
        int r101 = h.f466024a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // cz3.i
    public final boolean w(MentionEditText r100) {
        if (y.a(r100) == true) goto L5;
        this.f194421d.b();
        Context r101 = this.f194421d.getContext();
        int r102 = h.f466024a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return true;
    L5:
        return false;
    }

    public j(ManagerContext r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "managerContext");
        Intrinsics.checkNotNullParameter(r101, "tag");
        super(r100, r101);
        H(i.class, this);
        r100.f194416n = this;
    }
}
