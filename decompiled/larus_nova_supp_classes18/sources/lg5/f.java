package lg5;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata.SingeAuthorizeNode;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Observer<SingeAuthorizeNode> {
    public final /* synthetic */ BatchAuthorizeActivity a;

    public f(BatchAuthorizeActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        SingeAuthorizeNode r7 = (SingeAuthorizeNode) r6;
        Toast.cancelLoading();
        if (r7 == null) goto L27;
        ArrayList r0 = (ArrayList) this.a.h.getData();
        if (r0 != null) goto L8;
    L17:
        int r2 = -1;
    L18:
        if (r2 < 0) goto L23;
        EmbededDocumentInfo.NodeInfo r1 = (EmbededDocumentInfo.NodeInfo) this.a.h.getItem(r2);
        r1.setChat_has_permission(r7.isHasPermission());
        if (r7.getErrorCode() != 4) goto L22;
        r1.setSender_has_share_permission(false);
        this.a.h.notifyDataSetChanged();
        goto L23
    L22:
        this.a.h.notifyItemChanged(r2);
    L23:
        this.a.i.updatePermissionAndNoCount();
        return;
    L8:
        if (r0.size() <= 0) goto L17;
        Iterator r3 = r0.iterator();
        r2 = 0;
    L12:
        if (r3.hasNext() == false) goto L17;
        if (((EmbededDocumentInfo.NodeInfo) r3.next()).getObject_token().equals(r7.getToken()) == true) goto L18;
        r2 = r2 + 1;
        goto L12
    }
}
