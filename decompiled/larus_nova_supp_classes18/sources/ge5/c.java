package ge5;

import com.bytedance.ee.bear.lynx.impl.lynxview.refresh.CCMLynxPullRefreshView;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import gqa.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends f {
    public final /* synthetic */ CCMLynxPullRefreshView a;

    public final void h() {
        tt5.a.b("CCMLynxPullRefreshView", "MultiPurposeListener -> onHeaderFinish");
    }

    public final void o() {
        tt5.a.b("CCMLynxPullRefreshView", "MultiPurposeListener -> onHeaderStartAnimator");
    }

    public final void p() {
        tt5.a.b("CCMLynxPullRefreshView", "MultiPurposeListener -> onHeaderReleased");
        LynxContext r0 = this.a.getLynxContext();
        if (r0 == null) goto L8;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L9;
        r1.sendCustomEvent(new com.lynx.tasm.event.a(this.a.getSign(), "headerreleased"));
        return;
    L9:
        return;
    }

    public c(CCMLynxPullRefreshView r1) {
        this.a = r1;
    }
}
