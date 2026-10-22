package g30;

import com.bytedance.android.live.browser.jsbridge.base.CreateChatGroupResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.h0;
import w20.n8;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "createChatGroup")
public final class b extends h0<n8, CreateChatGroupResultModel> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        n8 r102 = (n8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i("LiveCreateChatGroupMethod", AbsMethodDelegate.TAG_INVOKE);
        Integer r103 = r102.a();
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.intValue() != 1) goto L40;
        ALogger.i("LiveCreateChatGroupMethod", "invoke ktv group,type=" + r102.getType());
        Integer r104 = r102.getType();
        if (r104 != null) goto L11;
    L13:
        Integer r105 = r102.getType();
        if (r105 != null) goto L17;
        return;
    L17:
        if (r105.intValue() != 2) goto L42;
        List<? extends y> r106 = IInteractService.linkMicSettings.getValue();
        Integer r107 = null;
        if (r106 == null) goto L33;
        Iterator<T> r108 = r106.iterator();
    L22:
        if (r108.hasNext() == false) goto L29;
        Object r109 = r108.next();
        if (((y) r109).getKey() != 56) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == false) goto L22;
    L30:
        y r111 = (y) r109;
        if (r111 == null) goto L33;
        r107 = Integer.valueOf(r111.getValue());
        goto L33
    L26:
        r110 = false;
        goto L27
    L29:
        r109 = null;
    L33:
        CreateChatGroupResultModel r112 = new CreateChatGroupResultModel();
        r112.a(String.valueOf(r107));
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r112);
        return;
    L42:
        return;
    L11:
        if (r104.intValue() != 1) goto L13;
        ((IKtvService) k.n(IKtvService.class)).createKtvGroup(r101.getContext());
        return;
    }
}
