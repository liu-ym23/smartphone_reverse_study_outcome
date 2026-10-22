package ti5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.transfer.TransferApplyAdapter;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ TransferApplyAdapter a;
    public final /* synthetic */ d b;

    public b(TransferApplyAdapter r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Iterator r4 = this.a.getData().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((d) r4.next()).b = false;
        goto L4
    L6:
        this.b.b = true;
        this.a.notifyDataSetChanged();
        a r5 = this.a.a;
        if (r5 == null) goto L11;
        r5.b(this.b);
        return;
    }
}
