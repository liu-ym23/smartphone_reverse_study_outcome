package l20;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.xplay.XplayMessageType;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements IXplayMessageInterface.ReceiveMsgListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IXplayMessageInterface f507090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<XplayMessageType, h10.a> f507091b;

    @Override // com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface.ReceiveMsgListener
    public final void onReceiveExitGameRequest() {
        XplayLog.a("XplayMessageManager", "onReceiveExitGameRequest");
    }

    public c() {
        this.f507091b = new HashMap();
    }

    @Override // com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface.ReceiveMsgListener
    public final void onReceiveCustomMsg(String r100) {
        int r101 = XplayLog.f61931a;
        XplayLog.c("XplayMessageManager", "onReceiveCustomMsg: " + r100);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((a10.d) GsonHelper.get().fromJson(r100, a10.d.class));     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L11;
        int r105 = XplayLog.f61931a;
        XplayLog.b("XplayMessageManager", r104.toString());
    L11:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = null;
    L13:
        a10.d r106 = (a10.d) r103;
        if (r106 != null) goto L17;
        XplayLog.b("XplayMessageManager", "message receive null!");
        return;
    L17:
        HashMap<XplayMessageType, h10.a> r107 = this.f507091b;
        XplayMessageType.a r108 = XplayMessageType.Companion;
        String r109 = r106.a();
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "messageKey");
        XplayMessageType r110 = (XplayMessageType) XplayMessageType.access$getTypeMap$cp().get(r109);
        if (r110 != null) goto L20;
        r110 = XplayMessageType.UNKNOWN;
    L20:
        h10.a r111 = r107.get(r110);
        if (r111 != null) goto L24;
        int r112 = XplayLog.f61931a;
        XplayLog.c("XplayMessageManager", "no listener, message: " + r106.a());
        return;
    L24:
        r111.a(r106);
        return;
    L5:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
