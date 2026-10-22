package ge5;

import com.bytedance.ee.bear.lynx.impl.lynxview.refresh.CCMLynxPullRefreshView;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements gqa.b {
    public final /* synthetic */ CCMLynxPullRefreshView a;

    public b(CCMLynxPullRefreshView r1) {
        this.a = r1;
    }

    public final void O0(h r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        tt5.a.h("CCMLynxPullRefreshView", "OnLoadMoreListener -> start load more");
        LynxContext r5 = this.a.getLynxContext();
        if (r5 == null) goto L8;
        EventEmitter r6 = r5.getEventEmitter();
        if (r6 == null) goto L9;
        r6.sendCustomEvent(new com.lynx.tasm.event.a(this.a.getSign(), "startloadmore"));
        return;
    L9:
        return;
    }
}
