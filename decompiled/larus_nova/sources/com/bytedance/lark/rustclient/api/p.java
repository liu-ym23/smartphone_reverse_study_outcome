package com.bytedance.lark.rustclient.api;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Exception f253921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarkError f253922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Command f253923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.pb.improto.Command f253924d;

    public final String c() {
        StringBuilder r100 = new StringBuilder("Error encountered while processing ");
        com.ss.android.lark.pb.improto.Command r101 = this.f253924d;
        if (r101 == null) goto L6;
        String r102 = "Server Command " + r101.getName();
        if (r102 == null) goto L6;
    L7:
        r100.append(r102);
        r100.append('.');
        String r103 = r100.toString();
        if (this.f253922b == null) goto L22;
        StringBuilder r104 = new StringBuilder();
        r104.append(r103);
        r104.append("\nRust error: code=");
        r104.append(this.f253922b.code);
        r104.append(", status=");
        r104.append(this.f253922b.status);
        r104.append(", dbg=");
        LarkError.ErrorDetails r105 = this.f253922b.details;
        String r106 = "";
        if (r105 == null) goto L13;
        String r107 = r105.debug_message;
        if (r107 == null) goto L13;
    L14:
        r104.append(r107);
        r104.append(", display=");
        r104.append(this.f253922b.display_message);
        r104.append(", reqId=");
        LarkError.ErrorDetails r108 = this.f253922b.details;
        if (r108 == null) goto L20;
        String r109 = r108.server_request_id;
        if (r109 == null) goto L20;
        r106 = r109;
    L20:
        r104.append(r106);
        r104.append('.');
        r103 = r104.toString();
    L13:
        r107 = "";
    L22:
        if (this.f253921a != null) goto L24;
        return r103;
    L24:
        return r103 + "\nAndroid error: " + this.f253921a.getMessage();
    L6:
        r102 = "Command " + this.f253923c.getName();
        goto L7
    }

    public final RustClientException b() {
        String r100 = c();
        Exception r101 = this.f253921a;
        if (r101 == null) goto L6;
        return new RustClientException(r100, r101);
    L6:
        return new RustClientException(r100, this.f253922b);
    }

    public static ErrorResult a(p r110) {
        r110.getClass();
        new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        LarkError r100 = r110.f253922b;
        byte[] r101 = null;
        byte[] r102 = null;
        String r103 = null;
        String r104 = "";
        if (r100 == null) goto L33;
        LarkError.ErrorDetails r105 = r100.details;
        if (r105 == null) goto L8;
        String r106 = r105.debug_message;
        if (r106 == null) goto L8;
    L9:
        String r107 = r106.concat("");
        LarkError r108 = r110.f253922b;
        LarkError.ErrorDetails r109 = r108.details;
        if (r109 == null) goto L13;
        String r111 = r109.server_request_id;
        if (r111 == null) goto L13;
    L14:
        if (r109 == null) goto L19;
        String r112 = r109.x_tt_logid;
        if (r112 == null) goto L19;
        r104 = r112;
    L19:
        Integer r113 = r108.status;
        if (r113 == null) goto L22;
        int r114 = r113.intValue();
    L23:
        int r115 = r110.f253922b.code.intValue();
        LarkError r116 = r110.f253922b;
        String r117 = r116.display_message;
        String r118 = r116.display_title;
        ByteString r119 = r116.extra;
        if (r119 != null) goto L40;
        byte[] r120 = null;
    L32:
        int r121 = r114;
        String r122 = r107;
        String r123 = r103;
        r101 = r120;
        int r124 = r115;
        int r125 = r121;
    L34:
        Exception r126 = r110.f253921a;
        if (r126 != null) goto L37;
        r126 = new RuntimeException("result with exception, command=" + r110.f253923c + ", passThrough=" + r110.f253924d);
    L37:
        ErrorResult r127 = new ErrorResult(0);
        ErrorResult.access$002(r127, r124);
        ErrorResult.access$102(r127, -9999);
        ErrorResult.access$202(r127, r125);
        ErrorResult.access$302(r127, r126);
        ErrorResult.access$402(r127, r118);
        ErrorResult.access$502(r127, r122);
        ErrorResult.access$602(r127, r117);
        ErrorResult.access$702(r127, r111);
        ErrorResult.access$802(r127, 0);
        ErrorResult.access$902(r127, r104);
        ErrorResult.access$1002(r127, r123);
        ErrorResult.access$1102(r127, r101);
        return r127;
    L40:
        String r128 = new String(r119.toByteArray(), Charsets.UTF_8);     // Catch: UnsupportedOperationException -> L28
        r102 = r110.f253922b.extra.toByteArray();     // Catch: UnsupportedOperationException -> L39
    L30:
        r120 = r102;
        r103 = r128;
    L29:
        Log.e("RustSDK", "error extra decode failed, errorCode: " + r110.f253922b.code);
    L28:
        r128 = null;
        goto L29
    L22:
        r114 = 0;
    L13:
        r111 = "";
    L8:
        r106 = "";
        goto L9
    L33:
        r123 = null;
        r122 = "";
        r111 = r122;
        r117 = r111;
        r118 = r117;
        r125 = 0;
        r124 = -1;
        r104 = null;
        goto L34
    }

    public p(Exception r100, LarkError r101, Command r102, com.ss.android.lark.pb.improto.Command r103) {
        Intrinsics.checkNotNullParameter(r102, "command");
        this.f253921a = r100;
        this.f253922b = r101;
        this.f253923c = r102;
        this.f253924d = r103;
    }
}
