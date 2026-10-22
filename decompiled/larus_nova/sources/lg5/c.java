package lg5;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.BatchAuthorizeActivity;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BatchAuthorizeActivity f509144a;

    public c(BatchAuthorizeActivity r100) {
        this.f509144a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f509144a.f233116i.getEmbededDocumentInfo();
        this.f509144a.D1(true, false);
    }
}
