package lg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.DocumentAuthAdapter;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ EmbededDocumentInfo.NodeInfo a;
    public final /* synthetic */ DocumentAuthAdapter b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        DocumentAuthAdapter r6 = this.b;
        EmbededDocumentInfo.NodeInfo r0 = this.a;
        int r1 = DocumentAuthAdapter.d;
        r6.getClass();
        int r7 = r0.getObject_type();
        String r2 = r0.getObject_token();
        if (r0.isWiki() == false) goto L5;
        r2 = r0.getToken();
        r7 = 16;
    L5:
        String r8 = sbb.e.f(r7);
        if (r0.getObject_type() != 28) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        HashMap r9 = new HashMap();
        r9.put("tab_type", "1");
        String r10 = s45.p.a().Le(sbb.e.o.getType(), r0.getToken(), r9);
    L12:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(r10);
        return;
    L11:
        r10 = s45.p.a().ua(r8, r2, null);
        goto L12
    L8:
        r3 = false;
        goto L9
    }

    public q(DocumentAuthAdapter r1, EmbededDocumentInfo.NodeInfo r2) {
        this.b = r1;
        this.a = r2;
    }
}
