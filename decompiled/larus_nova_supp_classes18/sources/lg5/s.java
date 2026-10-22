package lg5;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.DocumentAuthAdapter;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.BatchAuthorizeViewModel;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ EmbededDocumentInfo.NodeInfo c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ DocumentAuthAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r14) {
        t r15 = this.e.b;
        if (r15 == null) goto L12;
        EmbededDocumentInfo.NodeInfo r0 = this.c;
        d r16 = (d) r15;
        if ((!this.d) == false) goto L7;
        BatchAuthorizeViewModel r17 = r16.a.i;
        ArrayList<EmbededDocumentInfo.NodeInfo> r1 = new ArrayList();
        r1.add(r0);
        r17.batchAuthorize(r1, Boolean.FALSE);
        goto L12
    L7:
        BatchAuthorizeViewModel r18 = r16.a.i;
        ArrayList<EmbededDocumentInfo.NodeInfo> r2 = new ArrayList();
        r2.add(r0);
        r18.cancelBatchAuthorize(r2, Boolean.FALSE);
        String r19 = r0.getObject_token();
        String r3 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r19, ResourceData.KEY_TOKEN);
        JSONObject r4 = new JSONObject();
        int r5 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L10;
        String r6 = ThumbGlideUrl.SOURCE_VC;
    L11:
        com.bytedance.ee.bear.middleground.permission.c.a(r4, r19, r5, r6, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r4.put("object_id", r19);
        r4.put("click", "cancel_authorize");
        r4.put("target", "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_cited_doc_authorize_click", r4);
        goto L12
    L10:
        r6 = "none";
    L12:
        this.e.getClass();
        if (SwipeMenuLayout.getViewCache() == null) goto L16;
        SwipeMenuLayout.getViewCache().f();
        return;
    }

    public s(DocumentAuthAdapter r1, int r2, EmbededDocumentInfo.NodeInfo r3, boolean r4) {
        this.e = r1;
        this.c = r3;
        this.d = r4;
    }
}
