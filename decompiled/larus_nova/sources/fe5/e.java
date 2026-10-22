package fe5;

import com.lynx.tasm.q1;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f476593a;

    @Override // com.lynx.tasm.q1
    public final void onFirstScreen() {
        super.onFirstScreen();
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "onFirstScreen");
    }

    @Override // com.lynx.tasm.q1
    public final void onLoadSuccess() {
        super.onLoadSuccess();
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "onLoadSuccess");
        a r100 = this.f476593a;
        r100.f476575d = true;
        a.d r101 = r100.f476576e;
        if (r101 == null) goto L6;
        r101.run();
        return;
    }

    public e(a r100) {
        this.f476593a = r100;
    }

    @Override // com.lynx.tasm.q1
    public final void onPageStart(String r100) {
        super.onPageStart(r100);
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "onPageStart");
    }
}
