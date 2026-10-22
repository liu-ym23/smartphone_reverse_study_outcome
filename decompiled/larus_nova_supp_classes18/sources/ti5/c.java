package ti5;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ TransferApplyAdapter a;
    public final /* synthetic */ TextView b;

    public c(TransferApplyAdapter r1, TextView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        a r3 = this.a.a;
        if (r3 == null) goto L6;
        TextView r0 = this.b;
        Intrinsics.checkNotNull(r0);
        r3.a(r0);
        return;
    }
}
