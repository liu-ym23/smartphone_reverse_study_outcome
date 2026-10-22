package lg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ BatchAuthorizeActivity a;

    public c(BatchAuthorizeActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.i.getEmbededDocumentInfo();
        this.a.D1(true, false);
    }
}
