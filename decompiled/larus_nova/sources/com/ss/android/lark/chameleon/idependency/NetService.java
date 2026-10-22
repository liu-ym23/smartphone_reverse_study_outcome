package com.ss.android.lark.chameleon.idependency;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J6\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/NetService;", "", "()V", "value", "Lcom/ss/android/lark/chameleon/idependency/INetService;", "netService", "getNetService", "()Lcom/ss/android/lark/chameleon/idependency/INetService;", "setNetService", "(Lcom/ss/android/lark/chameleon/idependency/INetService;)V", "httpGet", "", "url", "", "headers", "", "callback", "Lcom/ss/android/lark/chameleon/idependency/INetCallback;", "httpPost", ContainerPosition.BODY, "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NetService {
    public static final NetService INSTANCE = null;
    private static INetService netService;

    static {
        INSTANCE = new NetService();
    }

    private NetService() {
    }

    public final INetService getNetService() {
        return netService;
    }

    public final void setNetService(INetService r100) {
        netService = r100;
    }

    public final void httpGet(String r100, Map<String, String> r101, INetCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "callback");
        INetService r103 = netService;
        if (r103 == null) goto L6;
        r103.httpGet(r100, r101, r102);
        return;
    }

    public final void httpPost(String r100, Map<String, String> r101, String r102, INetCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r103, "callback");
        INetService r104 = netService;
        if (r104 == null) goto L6;
        r104.httpPost(r100, r101, r102, r103);
        return;
    }
}
