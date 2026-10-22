package com.bytedance.android.shopping.yata.frontier;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.common.wschannel.ChannelInfo;
import com.bytedance.common.wschannel.WsChannelSdk2;
import com.bytedance.common.wschannel.event.ConnectionState;
import io.reactivex.functions.Action;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class YataFrontierManager$createConnectAction$1 implements Action {
    public final /* synthetic */ YataFrontierManager a;

    public final void run() {
        ECAppInfoService r0 = ECAppInfoService.e;
        String r1 = r0.getAppVersion();
        if (r1 == null) goto L14;
        Integer r2 = StringsKt.toIntOrNull(r1);
        if (r2 == null) goto L15;
        int r3 = r2.intValue();
        Context r4 = r0.getApplicationContext();
        if (r4 != null) goto L9;
        return;
    L9:
        HashMap r5 = new HashMap();
        r5.put("ttnet_ignore_offline", CommentScene.COMMENTSCENE_NO_AWEME);
        String r6 = r0.getSessionKey();
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        r5.put("sid", r6);
        YataFrontierManager.a(this.a, ConnectionState.CONNECTING);
        ChannelInfo r7 = ChannelInfo.Builder.create(this.a.c.e).setAid(this.a.c.b).setAppKey(this.a.c.c).setFPID(this.a.c.d).setAppVersion(r3).setDeviceId(r0.getServerDeviceId()).setInstallId(r0.getInstallId()).urls(CollectionsKt.listOf("wss://frontier.snssdk.com/ws/v2")).extras(r5).builder();
        YataFrontierManager r8 = this.a;
        WsChannelSdk2.registerChannel(r4, r7, new YataFrontierManager$createConnectAction$1$run$1(this));
        r8.getClass();
        return;
    L15:
        return;
    }

    public YataFrontierManager$createConnectAction$1(YataFrontierManager r1) {
        this.a = r1;
    }
}
