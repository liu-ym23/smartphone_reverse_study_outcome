package com.bytedance.push.notification;

import android.text.TextUtils;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushSupporter;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PushBody f266956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushBody f266957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f266958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f266959d;

    public final void a() {
        zfc.a.b r100 = (zfc.a.b) rgc.b.a(zfc.a.b.class);
        IAccountService r101 = (IAccountService) rgc.b.a(IAccountService.class);
        if (r100 == null) goto L38;
        JSONObject r102 = new JSONObject();
        PushBody r103 = this.f266956a;     // Catch: JSONException -> L32
        if (r103 == null) goto L8;
        long r104 = r103.f266713b;     // Catch: JSONException -> L32
    L12:
        r102.put("from_rule_id", r104);     // Catch: JSONException -> L32
        r102.put("to_rule_id", "");     // Catch: JSONException -> L32
        r102.put("from_push_channel", this.f266958c);     // Catch: JSONException -> L32
        r102.put("to_push_channel", this.f266959d);     // Catch: JSONException -> L32
        r102.put("withdraw_type", 1);     // Catch: JSONException -> L32
        PushBody r105 = this.f266956a;     // Catch: JSONException -> L32
        if (r105 == null) goto L15;
        Object r106 = r105.f266715d;     // Catch: JSONException -> L32
    L16:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID, r106);     // Catch: JSONException -> L32
        r102.put("user_id", r101.getSecUid());     // Catch: JSONException -> L32
        PushBody r107 = this.f266956a;     // Catch: JSONException -> L32
        String r108 = "0";
        if (r107 == null) goto L20;
        String r109 = r107.f266717f;     // Catch: JSONException -> L32
    L23:
        if (PushMsgHandler.e(r109) == false) goto L25;
        Object r110 = "1";
    L26:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_IS_SELF, r110);     // Catch: JSONException -> L32
        if (TextUtils.isEmpty(r101.getSecUid()) == true) goto L30;
        r108 = "1";
    L30:
        r102.put("is_login", r108);     // Catch: JSONException -> L32
        PushSupporter.get().getConfiguration().getClass();     // Catch: JSONException -> L32
    L34:
        r100.onEventV3("push_withdraw", r102);
        return;
    L25:
        r110 = "0";
        goto L26
    L20:
        r109 = "0";
        goto L23
    L15:
        r106 = 0;     // Catch: JSONException -> L32
        goto L16
    L8:
        PushBody r111 = this.f266957b;     // Catch: JSONException -> L32
        if (r111 == null) goto L11;
        r104 = r111.f266734w;     // Catch: JSONException -> L32
        goto L12
    L11:
        r104 = 0;
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L34
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(PushBody r100, PushBody r101, int r102, int r103) {
        this.f266956a = r100;
        this.f266957b = r101;
        this.f266958c = r102;
        this.f266959d = r103;
    }
}
