package ef7;

import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements com.bytedance.sdk.xbridge.cn.websocket.utils.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ue7.d f472527a;

    public c(ue7.d r100) {
        this.f472527a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.e
    public final void a(com.bytedance.sdk.xbridge.cn.websocket.utils.f r100) {
        Intrinsics.checkNotNullParameter(r100, "requestState");
        String r101 = r100.f270277a;
        switch(r101.hashCode()) {
            case -1987107780: goto L18;
            case -1357520532: goto L14;
            case -1281977283: goto L10;
            case -579210487: goto L6;
            default: goto L31;
        };
    L31:
        return;
    L6:
        if (r101.equals(PTYSocketStateCallback.CONNECTED) == false) goto L32;
        HashMap r102 = new HashMap();
        r102.put("status", PTYSocketStateCallback.CONNECTED);
        r102.put("socketTaskID", r100.f270278b);
        this.f472527a.a("x.socketStatusChanged", r102);
        return;
    L32:
        return;
    L10:
        if (r101.equals("failed") == false) goto L33;
        HashMap r103 = new HashMap();
        r103.put("status", "failed");
        r103.put("message", r100.f270279c);
        r103.put("socketTaskID", r100.f270278b);
        this.f472527a.a("x.socketStatusChanged", r103);
        return;
    L33:
        return;
    L14:
        if (r101.equals(PTYSocketStateCallback.CLOSED) == false) goto L34;
        HashMap r104 = new HashMap();
        r104.put("status", PTYSocketStateCallback.CLOSED);
        r104.put("socketTaskID", r100.f270278b);
        this.f472527a.a("x.socketStatusChanged", r104);
        return;
    L34:
        return;
    L18:
        if (r101.equals("onMessaged") == false) goto L35;
        HashMap r105 = new HashMap();
        r105.put("socketTaskID", r100.f270278b);
        String r106 = r100.f270280d;
        if (r106 == null) goto L23;
        String r107 = (String) r105.put("data", r106);
    L23:
        String r108 = r100.f270281e;
        if (r108 == null) goto L26;
        r105.put("dataType", r108);
    L26:
        this.f472527a.a("x.socketDataReceived", r105);
        return;
    }
}
