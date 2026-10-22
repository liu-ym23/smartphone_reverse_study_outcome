package com.obric.matrix.sdk.push.cross_process;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import kka.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/sdk/push/cross_process/MessageReceiver;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/matrix/sdk/push/a;", "<init>", "()V", "sdk_push_release"}, k = 1, mv = {1, 6, 0})
public abstract class MessageReceiver extends BroadcastReceiver implements com.obric.matrix.sdk.push.a {
    public MessageReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r110) {
        if (r110 == null) goto L32;
        int r101 = r110.getIntExtra(SeiMessageConst.MSG_TYPE, 1);
        String r102 = r110.getStringExtra("msg_id");
        Integer r103 = Integer.valueOf(r101);
        String r104 = null;
        if (r100 != null) goto L27;
        Context r105 = null;
    L7:
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L12
        r106.put(SeiMessageConst.MSG_TYPE, r103);     // Catch: Throwable -> L12
        r106.put("msg_id", r102);     // Catch: Throwable -> L12
        if (r105 == null) goto L10;
        r104 = r105.getPackageName();     // Catch: Throwable -> L12
    L10:
        r106.put("package_name", r104);     // Catch: Throwable -> L12
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L12
        r107.add("push_sdk_receive");     // Catch: Throwable -> L12
        r107.add(r106.toString());     // Catch: Throwable -> L12
        ika.a r108 = ika.a.f490286a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L12
        ((com.obric.matrix.push.common.cross_process.CrossProcessService) r108.a(r105)).b("sdk_event", r107, new a());     // Catch: Throwable -> L12
    L30:
        if (r101 != 1) goto L17;
        String r111 = r110.getStringExtra("pass_though_data");
        if (TextUtils.isEmpty(r111) == true) goto L33;
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.MSGID);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r111, "data");     // Catch: Throwable -> L26
        b();     // Catch: Throwable -> L26
    L29:
        return;
    L33:
        return;
    L17:
        if (r101 != 2) goto L34;
        String r109 = r110.getStringExtra("revoke_id");
        r110.getStringExtra("revoke_data");
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.MSGID);     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r109, "revokeId");     // Catch: Throwable -> L26
        a();     // Catch: Throwable -> L26
        goto L29
    L34:
        return;
    L35:
        return;
    L12:
        th = move-exception;
        b.b("onEvent error: " + th);
        goto L30
    L27:
        r105 = r100.getApplicationContext();     // Catch: Throwable -> L12
        goto L7
    }
}
