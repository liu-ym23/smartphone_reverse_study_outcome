package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.e;
import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.badger.utils.C10462c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.heytap.mcssdk.constant.MessageConstant;
import com.ss.bytertc.engine.aigc.AIGCSessionErrorCode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u008a\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0001j\u0002`\u0011B¯\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0095\u0001\b\u0002\u0010\"\u001a\u008e\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0001j\u0004\u0018\u0001`\u0011¢\u0006\u0004\b&\u0010'J#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J@\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R¤\u0001\u0010\"\u001a\u008e\u0001\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0001j\u0004\u0018\u0001`\u00118\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/badger/network/BadgerRetryReportCallback;", "Lkotlin/Function6;", "", "Lkotlin/ParameterName;", "name", "success", "", CronetDataStorageAccess.LOGID, "Lcom/bytedance/badger/network/a0;", "requestBundle", "Lcom/bytedance/badger/network/b0;", "responseBundle", "Lcom/bytedance/badger/network/l0;", "retryInfo", "Lcom/bytedance/badger/C/a;", "compensateType", "", "Lcom/bytedance/badger/network/BadgerNetworkRetryCallback;", "Lkotlin/Pair;", "", "parseResponse", "(Lcom/bytedance/badger/network/b0;)Lkotlin/Pair;", AbsMethodDelegate.TAG_INVOKE, "(ZLjava/lang/String;Lcom/bytedance/badger/network/a0;Lcom/bytedance/badger/network/b0;Lcom/bytedance/badger/network/l0;Lcom/bytedance/badger/C/a;)V", "Lz64/b;", "report", "Lz64/b;", "getReport", "()Lz64/b;", "Lcom/bytedance/badger/network/n0;", "reportContext", "Lcom/bytedance/badger/network/n0;", "getReportContext", "()Lcom/bytedance/badger/network/n0;", "extraCallback", "Lkotlin/jvm/functions/Function6;", "getExtraCallback", "()Lkotlin/jvm/functions/Function6;", "<init>", "(Lz64/b;Lcom/bytedance/badger/network/n0;Lkotlin/jvm/functions/Function6;)V", "badger-core_release"}, k = 1, mv = {1, 4, 0})
public final class BadgerRetryReportCallback implements Function6 {
    private final Function6 extraCallback;
    private final z64.b report;
    private final n0 reportContext;

    public BadgerRetryReportCallback(z64.b r100, n0 r101, Function6 r102) {
        this.report = r100;
        this.reportContext = r101;
        this.extraCallback = r102;
    }

    public /* synthetic */ BadgerRetryReportCallback(z64.b r100, n0 r101, Function6 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }

    public final Function6 getExtraCallback() {
        return this.extraCallback;
    }

    public final z64.b getReport() {
        return this.report;
    }

    public final n0 getReportContext() {
        return this.reportContext;
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r110, Object r111, Object r112, Object r113) {
        invoke(((Boolean) r100).booleanValue(), (String) r101, (a0) r110, (b0) r111, (l0) r112, (com.bytedance.badger.C.a) r113);
        return Unit.INSTANCE;
    }

    private final Pair parseResponse(b0 r100) {
        int r101 = 0;
        if (r100.f199085d.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        int r103 = -1;
        if (r102 == true) goto L9;
        JSONObject r104 = new JSONObject(r100.f199085d).optJSONObject("data");     // Catch: JSONException -> L24
        if (r104 == null) goto L13;
        r101 = r104.optInt("error_code");     // Catch: JSONException -> L24
    L13:
        if (r104 != null) goto L33;
    L19:
        String r105 = "";
    L29:
        e.b("BadgerNetwork", "response code=" + r101 + ", message=" + r105);     // Catch: JSONException -> L22
    L28:
        return new Pair(Integer.valueOf(r101), r105);
    L22:
        JSONException e100 = e;
    L26:
        e.c("BadgerNetwork", "parse response body failed", e100);
        goto L28
    L33:
        r105 = r104.optString("description");     // Catch: JSONException -> L17
        if (r105 == null) goto L19;
    L17:
        e = e;
        r103 = r101;
    L25:
        r101 = r103;
        e100 = e;
        r105 = "Invalid response";
    L24:
        e = e;
        goto L25
    L9:
        return new Pair(-1, "Empty response body");
    L5:
        r102 = false;
        goto L6
    }

    public void invoke(boolean r210, String r211, a0 r310, b0 r311, l0 r312, com.bytedance.badger.C.a r313) {
        e.f("BadgerNetwork", "report retry success: " + r210 + ", logid: " + r211 + ", requestBundle: " + r310 + ", responseBundle: " + r311 + ", retryInfo: " + r312 + ", compensateType " + r313);
        n0 r100 = this.reportContext;
        long r101 = r100.f199129g;
        long r102 = r100.f199128f;
        TriggerStage r110 = r100.f199126d;
        z64.c r111 = r100.f199123a;
        boolean r103 = r100.f199127e;
        Pair r112 = parseResponse(r311);
        int r113 = ((Number) r112.component1()).intValue();
        String r114 = (String) r112.component2();
        if (r210 == false) goto L7;
        if (r113 != 0) goto L7;
        com.bytedance.badger.monitor.c.a(com.bytedance.badger.monitor.c.f199044c, r110, CollectStage.report_finished, r111, this.report, 0, SystemClock.elapsedRealtime() - r102, SystemClock.uptimeMillis() - r101, r211, r312, r103, this.reportContext.f199130h.get(), r313, 0, null, MessageConstant.CommandId.COMMAND_CLEAR_NOTIFICATION);
    L11:
        Function6 r104 = this.extraCallback;
        if (r104 == null) goto L15;
        Unit r105 = (Unit) r104.invoke(Boolean.valueOf(r210), r211, r310, r311, r312, r313);
        return;
    L15:
        return;
    L7:
        if (r312.a() == false) goto L9;
        com.bytedance.badger.monitor.c r115 = com.bytedance.badger.monitor.c.f199044c;
        C10462c r116 = new C10462c("network failure,retry limit", AIGCSessionErrorCode.AIGC_SESSION_ERROR_TIMEOUT_NO_BOT_JOIN_ROOM, CollectStage.report_finished, null, 8);
        long r117 = SystemClock.elapsedRealtime() - r102;
        long r212 = SystemClock.uptimeMillis() - r101;
        long r213 = this.reportContext.f199130h.get();
        int r118 = 0;
        z64.h r214 = null;
        int r215 = 4112;
        com.bytedance.badger.monitor.c r106 = r115;
        C10462c r107 = r116;
    L10:
        com.bytedance.badger.monitor.c.b(r106, r110, r107, r113, r114, r118, r117, r212, r111, r312, r103, r213, r313, r214, r215);
        goto L11
    L9:
        com.bytedance.badger.monitor.c r119 = com.bytedance.badger.monitor.c.f199044c;
        C10462c r120 = new C10462c("network failure", -1202, CollectStage.report_finished, null, 8);
        r117 = SystemClock.elapsedRealtime() - r102;
        r212 = SystemClock.uptimeMillis() - r101;
        r213 = this.reportContext.f199130h.get();
        r118 = 0;
        r214 = null;
        r215 = 4112;
        r106 = r119;
        r107 = r120;
        goto L10
    }
}
