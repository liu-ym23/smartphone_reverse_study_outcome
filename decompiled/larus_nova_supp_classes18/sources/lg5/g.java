package lg5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.DocumentAuthAdapter;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements Observer<EmbededDocumentInfo.EmbededData> {
    public final /* synthetic */ BatchAuthorizeActivity a;

    public g(BatchAuthorizeActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        EmbededDocumentInfo.EmbededData r6 = (EmbededDocumentInfo.EmbededData) r5;
        boolean r1 = true;
        if (r6.getResult() != null) goto L5;
    L8:
        BatchAuthorizeActivity r0 = this.a;
        if (r6.isDataSuccess() == true) goto L19;
        DocumentAuthAdapter r7 = this.a.h;
        if (r7.getData() != null) goto L13;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == false) goto L19;
        r1 = false;
        goto L19
    L13:
        if (r7.getData().size() <= 0) goto L15;
        r8 = false;
    L19:
        int r9 = BatchAuthorizeActivity.p;
        r0.D1(false, r1);
        return;
    L5:
        if (r6.getResult().size() <= 0) goto L8;
        this.a.e.setVisibility(0);
        this.a.D1(false, true);
        this.a.h.getData().addAll(r6.getResult());
        this.a.h.notifyDataSetChanged();
        this.a.i.updatePermissionAndNoCount();
    }
}
