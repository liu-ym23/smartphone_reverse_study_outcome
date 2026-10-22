package lg5;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata.SingeAuthorizeNode;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements Observer<ArrayList<SingeAuthorizeNode>> {
    public final /* synthetic */ BatchAuthorizeActivity a;

    public h(BatchAuthorizeActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        ArrayList r8 = (ArrayList) r7;
        Toast.cancelLoading();
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.size() <= 0) goto L42;
        ArrayList r0 = (ArrayList) this.a.h.getData();
        if (r0 != null) goto L10;
    L28:
        this.a.h.notifyDataSetChanged();
        this.a.i.updatePermissionAndNoCount();
        return;
    L10:
        if (r0.size() <= 0) goto L28;
        if (r8.size() <= 0) goto L28;
        Iterator r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L27;
        SingeAuthorizeNode r1 = (SingeAuthorizeNode) r9.next();
        String r2 = r1.getToken();
        Iterator r3 = r0.iterator();
    L19:
        if (r3.hasNext() == false) goto L16;
        EmbededDocumentInfo.NodeInfo r4 = (EmbededDocumentInfo.NodeInfo) r3.next();
        if (TextUtils.isEmpty(r2) == true) goto L19;
        if (r2.equals(r4.getObject_token()) == false) goto L19;
        r4.setChat_has_permission(r1.isHasPermission());
        if (r1.getErrorCode() != 4) goto L16;
        r4.setSender_has_share_permission(false);
        goto L16
    L27:
        tt5.a.b("", "handleBatchCancelData finish");
        goto L28
    }
}
