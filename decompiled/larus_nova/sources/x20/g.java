package x20;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.updateByteLinkListener", owner = "JiangXZ")
public final class g extends b implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f562176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f562177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Integer> f562178f;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        ALogger.i(this.f562176d, "release Jsb ListenMap:" + this.f562178f);
        f r100 = this.f562177e;
        if (r100 == null) goto L8;
        Iterator r101 = ((LinkedHashMap) this.f562178f).entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        com.ss.ugc.live.sdk.platform.a.f458524f.m((String) ((Map.Entry) r101.next()).getKey(), r100);
    L8:
        ((LinkedHashMap) this.f562178f).clear();
        this.f562177e = null;
    }

    public g() {
        this.f562176d = "LiveUpdateByteLinkListenerMethod";
        this.f562178f = new LinkedHashMap();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        b.InterfaceC8185b r113 = (b.InterfaceC8185b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        List<String> r100 = r113.getMessageMethod();
        ALogger.i(this.f562176d, "invoke JSB(" + hashCode() + ") Param ActionType:" + r113.getActionType() + ", Method: " + r113.getMessageMethod() + '}');
        if (r100 != null) goto L5;
        r112.onFailure(0, "Message List isEmpty", (XBaseResultModel) ne7.e.b(b.c.class));
        return;
    L5:
        Number r114 = r113.getActionType();
        if (Intrinsics.areEqual(r114, 1) == false) goto L26;
        Iterator<T> r115 = r100.iterator();
    L9:
        if (r115.hasNext() == false) goto L24;
        String r101 = (String) r115.next();
        if (this.f562177e != null) goto L13;
        ALogger.i(this.f562176d, "Create Payload Listener");
        this.f562177e = new f(this, r101, r110);
    L13:
        Integer r102 = (Integer) ((LinkedHashMap) this.f562178f).get(r101);
        if (r102 == null) goto L16;
        int r103 = r102.intValue();
    L17:
        ALogger.i(this.f562176d, "Method(" + r101 + ") methodListenCount:" + r103);
        if (r103 == 0) goto L19;
        this.f562178f.put(r101, Integer.valueOf(r103 + 1));
        goto L9
    L19:
        f r104 = this.f562177e;
        if (r104 == null) goto L22;
        com.ss.ugc.live.sdk.platform.a.f458524f.d(r101, r104);
    L22:
        this.f562178f.put(r101, 1);
        goto L9
    L16:
        r103 = 0;
        goto L17
    L24:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(b.c.class), null, 2, null);
        return;
    L26:
        if (Intrinsics.areEqual(r114, 2) == false) goto L44;
        Iterator<T> r116 = r100.iterator();
    L29:
        if (r116.hasNext() == false) goto L43;
        String r117 = (String) r116.next();
        f r105 = this.f562177e;
        if (r105 == null) goto L29;
        Integer r106 = (Integer) ((LinkedHashMap) this.f562178f).get(r117);
        if (r106 == null) goto L36;
        int r107 = r106.intValue();
    L37:
        ALogger.i(this.f562176d, "Method(" + r117 + ") methodListenCount:" + r107);
        if (r107 > 1) goto L39;
        this.f562178f.remove(r117);
        if (r107 != 1) goto L29;
        com.ss.ugc.live.sdk.platform.a.f458524f.m(r117, r105);
        goto L29
    L39:
        this.f562178f.put(r117, Integer.valueOf(r107 - 1));
        goto L29
    L36:
        r107 = 0;
        goto L37
    L43:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(b.c.class), null, 2, null);
        return;
    L44:
        r112.onFailure(0, "Action Type isNot Support", (XBaseResultModel) ne7.e.b(b.c.class));
    }
}
