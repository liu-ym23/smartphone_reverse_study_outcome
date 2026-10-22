package com.bytedance.sdk.account.visitor;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class VisitorSessionServiceImpl$checkExpiredAndReLogin$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $fromHost;
    final /* synthetic */ String $fromLogid;
    final /* synthetic */ String $fromPath;
    final /* synthetic */ c this$0;

    public VisitorSessionServiceImpl$checkExpiredAndReLogin$1(c r100, String r101, String r102, String r103) {
        this.this$0 = r100;
        this.$fromHost = r101;
        this.$fromPath = r102;
        this.$fromLogid = r103;
        super(1);
    }

    public final void invoke(boolean r100) {
        c r101 = this.this$0;
        String r102 = this.$fromHost;
        String r103 = this.$fromPath;
        String r104 = this.$fromLogid;
        int r105 = c.f269558a;
        r101.getClass();
        JSONObject r106 = new JSONObject();     // Catch: JSONException -> L9
        r106.put("from_host", r102);     // Catch: JSONException -> L9
        r106.put("from_path", r103);     // Catch: JSONException -> L9
        r106.put("from_logid", r104);     // Catch: JSONException -> L9
        r101.getClass();     // Catch: JSONException -> L9
        r106.put("visitor_app_id", 0);     // Catch: JSONException -> L9
        if (r100 == false) goto L6;
        String r107 = "ignore";
    L7:
        r106.put("handle", r107);     // Catch: JSONException -> L9
        com.bytedance.sdk.account.monitor.a.a("passport_visitor_session_expired_result", r106);     // Catch: JSONException -> L9
        return;
    L6:
        r107 = "logout";
    L9:
        e = move-exception;
        int r108 = b.f269557a;
        b.a("VisitorSessionService", "report session update event error: " + e.getMessage());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }
}
