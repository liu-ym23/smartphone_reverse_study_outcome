package i73;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import hl.p;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends AbsCommonChainEventImpl<Map<String, ? extends Object>> {
    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final com.bytedance.android.shopping.anchorv4.event_chain.b<Map<String, ? extends Object>> c(Map<String, ? extends Object> r100) {
        int r101 = com.bytedance.android.shopping.anchorv4.event_chain.b.f166546d;
        return com.bytedance.android.shopping.anchorv4.event_chain.b.a.b(r100);
    }

    public c(v r100, Context r101) {
        Intrinsics.checkNotNullParameter("PdpAddCartSuccessPopup", "name");
        Intrinsics.checkNotNullParameter(r100, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super("PdpAddCartSuccessPopup", r100, r101);
    }

    @Override // com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl
    public final void e(EventContext r100, Map<String, ? extends Object> r101, Function1 r102) {
        Map<String, ? extends Object> r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "completion");
        if (r103 == null) goto L5;
        Object r104 = r103.get("url");
    L7:
        if ((r104 instanceof String) == true) goto L9;
        r104 = null;
    L9:
        String r105 = (String) r104;
        if (r105 == null) goto L12;
        EventBus.getDefault().post(new p(r105));
    L12:
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r102.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L5:
        r104 = null;
        goto L7
    }
}
