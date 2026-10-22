package lg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.DocumentAuthAdapter;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmbededDocumentInfo.NodeInfo f509167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DocumentAuthAdapter f509168b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DocumentAuthAdapter r101 = this.f509168b;
        EmbededDocumentInfo.NodeInfo r102 = this.f509167a;
        int r103 = DocumentAuthAdapter.f233124d;
        r101.getClass();
        int r104 = r102.getObject_type();
        String r105 = r102.getObject_token();
        if (r102.isWiki() == false) goto L5;
        r105 = r102.getToken();
        r104 = 16;
    L5:
        String r106 = sbb.e.f(r104);
        if (r102.getObject_type() != 28) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L11;
        HashMap r108 = new HashMap();
        r108.put("tab_type", "1");
        String r109 = s45.p.a().Le(sbb.e.f541304o.getType(), r102.getToken(), r108);
    L12:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(r109);
        return;
    L11:
        r109 = s45.p.a().ua(r106, r105, null);
        goto L12
    L8:
        r107 = false;
        goto L9
    }

    public q(DocumentAuthAdapter r100, EmbededDocumentInfo.NodeInfo r101) {
        this.f509168b = r100;
        this.f509167a = r101;
    }
}
