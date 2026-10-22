package id1;

import com.bytedance.android.live.xplay.basic.api.XplayBasicMessageType;
import com.bytedance.android.live.xplay.basic.log.XplayLog;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements IXplayMessageInterface.ReceiveMsgListener, gd1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IXplayMessageInterface f489298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<XplayBasicMessageType, gd1.b.a> f489299b;

    public static final class a implements IXplayMessageInterface.SendMsgListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gd1.b.InterfaceC6009b f489300a;

        public a(gd1.b.InterfaceC6009b r100) {
            this.f489300a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface.SendMsgListener
        public final void onSendResult(boolean r100, int r101, String r102, String r103) {
            gd1.b.InterfaceC6009b r104 = this.f489300a;
            if (r104 == null) goto L6;
            r104.onSendResult(r100, r101, r102, r103);
            return;
        }
    }

    @Override // com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface.ReceiveMsgListener
    public final void onReceiveExitGameRequest() {
        XplayLog.a("XplayMessageManager", "onReceiveExitGameRequest");
    }

    public b() {
        this.f489299b = new HashMap();
    }

    @Override // gd1.b
    public final void c(XplayBasicMessageType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f489299b.remove(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.xplay.IXplayMessageInterface.ReceiveMsgListener
    public final void onReceiveCustomMsg(String r100) {
        int r101 = XplayLog.f102848a;
        XplayLog.c("XplayMessageManager", "onReceiveCustomMsg: " + r100);
        if (r100 == null) goto L8;
        Iterator<Map.Entry<XplayBasicMessageType, gd1.b.a>> r102 = this.f489299b.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        r102.next().getValue().Ln(r100);
        goto L6
    L10:
        return;
    }

    @Override // gd1.b
    public final void a(XplayBasicMessageType r100, gd1.b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f489299b.put(r100, r101);
    }

    @Override // gd1.b
    public final void d(String r100, gd1.b.InterfaceC6009b r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        IXplayMessageInterface r102 = this.f489298a;
        if (r102 == null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L10;
        if (r101 == null) goto L14;
        r101.onSendResult(false, -1, "message manager not initialized", null);
        return;
    L14:
        return;
    L10:
        a r104 = new a(r101);
        if (r102 == null) goto L15;
        r102.sendMsgWithListener(r100, r104);
        return;
    L15:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
