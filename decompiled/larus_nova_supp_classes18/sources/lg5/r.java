package lg5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.AuthDocViewHolder;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ AuthDocViewHolder c;
    public final /* synthetic */ EmbededDocumentInfo.NodeInfo d;
    public final /* synthetic */ Context e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        this.c.a.f();
        if (this.d.isChat_has_permission() == false) goto L5;
        Toast.showFailureText(this.e, 2131887203);
        return;
    L5:
        BearUDDialogBuilder r6 = new BearUDDialogBuilder(this.e);
        r6.a.title(2131889476);
        r6.f(this.e.getString(2131887205));
        r6.b(2131391777, 2131887182, 2131105548, null);
        r6.a.style(2131951622);
        r6.h();
    }

    public r(AuthDocViewHolder r1, EmbededDocumentInfo.NodeInfo r2, Context r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
