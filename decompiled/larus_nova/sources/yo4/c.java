package yo4;

import com.bytedance.ee.bear.bitable.baserecord.view.BitableLynxRecordView;
import no4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements zm4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableLynxRecordView f568667a;

    public c(BitableLynxRecordView r100) {
        this.f568667a = r100;
    }

    @Override // zm4.a
    public final void a(String r100) {
        tu4.b.f(this.f568667a.f207071b, "SHARE_RECORD_TEMPLATE_END", System.currentTimeMillis());
        tt5.a.h("BitableLynxRecordView", "onLoadFailed: " + r100);
        d r101 = this.f568667a.f207076g;
        if (r101 == null) goto L6;
        r101.a(0, "loadTemplateFailed: " + r100);
        return;
    }
}
