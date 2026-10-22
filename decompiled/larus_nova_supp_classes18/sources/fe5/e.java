package fe5;

import com.lynx.tasm.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends q1 {
    public final /* synthetic */ a a;

    public final void onFirstScreen() {
        super.onFirstScreen();
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "onFirstScreen");
    }

    public final void onLoadSuccess() {
        super.onLoadSuccess();
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "onLoadSuccess");
        a r0 = this.a;
        r0.d = true;
        a.d r1 = r0.e;
        if (r1 == null) goto L6;
        r1.run();
        return;
    }

    public e(a r1) {
        this.a = r1;
    }

    public final void onPageStart(String r2) {
        super.onPageStart(r2);
        tt5.a.h("ccm-lynx: CCMLynxCardViewImpl", "onPageStart");
    }
}
