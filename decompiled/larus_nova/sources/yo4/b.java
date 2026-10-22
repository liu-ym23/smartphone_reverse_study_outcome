package yo4;

import com.bytedance.ee.bear.bitable.baserecord.view.BitableLynxRecordView;
import com.lynx.tasm.q1;
import no4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableLynxRecordView f568666a;

    @Override // com.lynx.tasm.q1
    public final void onLoadSuccess() {
        super.onLoadSuccess();
        tu4.b.f(this.f568666a.f207071b, "SHARE_RECORD_TEMPLATE_END", System.currentTimeMillis());
        tt5.a.h("BitableLynxRecordView", "onLoadSuccess");
        BitableLynxRecordView r100 = this.f568666a;
        r100.f207074e.observeForever(r100.f207077h);
    }

    public b(BitableLynxRecordView r100) {
        this.f568666a = r100;
    }

    @Override // com.lynx.tasm.q1
    public final void onLoadFailed(String r100) {
        super.onLoadFailed(r100);
        tu4.b.f(this.f568666a.f207071b, "SHARE_RECORD_TEMPLATE_END", System.currentTimeMillis());
        tt5.a.h("BitableLynxRecordView", "onLoadFailed: " + r100);
        d r101 = this.f568666a.f207076g;
        if (r101 == null) goto L6;
        r101.a(0, "loadTemplateFailed: " + r100);
        return;
    }
}
