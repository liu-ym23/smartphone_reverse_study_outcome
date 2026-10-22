package ti5;

import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyFragment;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements gp5.a.b {
    public final /* synthetic */ TransferApplyFragment a;

    public q(TransferApplyFragment r1) {
        this.a = r1;
    }

    @Override // gp5.a.b
    public final void a(CharSequence r1, SpaceEditText r2) {
        TransferApplyFragment r3 = this.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r3.p = r1;
    }
}
