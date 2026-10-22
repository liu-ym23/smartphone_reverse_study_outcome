package com.bytedance.ee.bear.rn.middleground.business.base;

import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.rn.f;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yl5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BaseSDK implements f {

    public static final class a {
    }

    static {
    }

    public BaseSDK() {
    }

    public static void e(@ConnectionService.NetworkState.NetworkType int r4) {
        BaseProtocol.SetNetworkState r0 = new BaseProtocol.SetNetworkState();
        r0.setBody(new BaseProtocol.Body.SetNetworkState(new BaseProtocol.Body.SetNetworkState.Data(Integer.valueOf(r4)), null, 2, null));
        final String r5 = r0.getJsonString();
        Flowable<String> r6 = b.b(new BaseSDK$setNetworkState$1(r5));
        if (r6 == null) goto L6;
        r6.subscribe();
        return;
    }

    public static void f(int r2) {
        BaseProtocol.TurnOnOffWebSocket r0 = new BaseProtocol.TurnOnOffWebSocket();
        r0.setBody(new BaseProtocol.Body.TurnOnOffWebSocket(Integer.valueOf(r2)));
        final String r3 = r0.getJsonString();
        Flowable<String> r4 = b.b(new BaseSDK$turnOnWebSocket$1(r3));
        if (r4 == null) goto L6;
        r4.subscribe();
        return;
    }

    @Override // com.bytedance.ee.bear.rn.f
    public final void a(List<? extends OfflineDoc> r3) {
        Intrinsics.checkNotNullParameter(r3, "offlineDoc");
        BaseProtocol.EnterInSuite r0 = new BaseProtocol.EnterInSuite();
        r0.setBody(new BaseProtocol.Body.Watch(r3));
        final String r4 = r0.getJsonString();
        Flowable<String> r5 = b.b(new BaseSDK$enterInSuite$1(r4));
        if (r5 == null) goto L6;
        r5.subscribe();
        return;
    }

    @Override // com.bytedance.ee.bear.rn.f
    public final void c(List r3) {
        Intrinsics.checkNotNullParameter(r3, "offlineDoc");
        Intrinsics.checkNotNullParameter("OFFLINE", ResourceData.KEY_TYPE);
        BaseProtocol.WatchDocs r0 = new BaseProtocol.WatchDocs("OFFLINE");
        r0.setBody(new BaseProtocol.Body.Watch(r3));
        final String r4 = r0.getJsonString();
        Flowable<String> r5 = b.b(new BaseSDK$watchDocs$1(r4));
        if (r5 == null) goto L6;
        r5.subscribe();
        return;
    }

    @Override // com.bytedance.ee.bear.rn.f
    public final void d(List<? extends OfflineDoc> r3) {
        Intrinsics.checkNotNullParameter(r3, "offlineDoc");
        BaseProtocol.ExitFromSuite r0 = new BaseProtocol.ExitFromSuite();
        r0.setBody(new BaseProtocol.Body.Watch(r3));
        final String r4 = r0.getJsonString();
        Flowable<String> r5 = b.b(new BaseSDK$exitFromSuite$1(r4));
        if (r5 == null) goto L6;
        r5.subscribe();
        return;
    }

    @Override // com.bytedance.ee.bear.rn.f
    public final void h(List r3) {
        Intrinsics.checkNotNullParameter(r3, "offlineDoc");
        Intrinsics.checkNotNullParameter("OFFLINE", ResourceData.KEY_TYPE);
        BaseProtocol.UnWatchDocs r0 = new BaseProtocol.UnWatchDocs("OFFLINE");
        r0.setBody(new BaseProtocol.Body.Watch(r3));
        final String r4 = r0.getJsonString();
        Flowable<String> r5 = b.b(new BaseSDK$unWatchDocs$1(r4));
        if (r5 == null) goto L6;
        r5.subscribe();
        return;
    }

    @Override // com.bytedance.ee.bear.rn.f
    public final void b(String r3, String r4, List<String> r5, String r6) {
        BaseProtocol.PreloadSubBlock r0 = new BaseProtocol.PreloadSubBlock();
        r0.setBody(new BaseProtocol.Body.PreloadSubBlock(r3, r4, r5, r6));
        final String r7 = r0.getJsonString();
        Flowable<String> r8 = b.b(new BaseSDK$preloadSubBlock$1(r7));
        if (r8 == null) goto L6;
        r8.subscribe();
        return;
    }
}
