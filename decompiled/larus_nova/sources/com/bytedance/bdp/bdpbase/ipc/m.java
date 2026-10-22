package com.bytedance.bdp.bdpbase.ipc;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class m {
    @JvmStatic
    public static final String a(int r100, boolean r101) {
        if (r100 != 400) goto L5;
        return "method_illegal_access";
    L5:
        if (r100 != 401) goto L7;
        return "method_invocation_fail";
    L7:
        if (r100 == 404) goto L15;
        switch(r100) {
            case 505: goto L12;
            case 506: goto L11;
            case 507: goto L10;
            default: goto L9;
        };
    L9:
        return "unsuccessful_response";
    L10:
        return "client_transact_too_large";
    L11:
        return "server_response_too_large";
    L12:
        if (r101 == true) goto L14;
        return "server_response_null";
    L14:
        return "client_response_callback_null";
    L15:
        return "method_not_found";
    }

    static {
    }

    @JvmStatic
    public static final String b(String r100) {
        switch(r100.hashCode()) {
            case -1858745790: goto L48;
            case -1349320158: goto L45;
            case -921291357: goto L42;
            case 48248335: goto L39;
            case 280787127: goto L36;
            case 318541163: goto L33;
            case 490092813: goto L30;
            case 548240073: goto L27;
            case 1129242936: goto L24;
            case 1625540615: goto L21;
            case 1654903950: goto L18;
            case 1755772574: goto L15;
            case 1955988591: goto L12;
            case 1983305397: goto L9;
            case 2074885648: goto L6;
            default: goto L50;
        };
    L50:
        return "Phase {All Time}";
    L6:
        if (r100.equals("server_not_find_ICallback") == false) goto L50;
    L37:
        return "Phase {server callback to client}";
    L9:
        if (r100.equals("unable_to_bind") == false) goto L50;
    L49:
        return "Phase {getting transfer}";
    L12:
        if (r100.equals("client_transact_too_large") == false) goto L50;
        return "Phase {client transfer request}";
    L15:
        if (r100.equals("iTransfer_transact_error") == false) goto L50;
    L28:
        return "Phase {client transfer request} or Phase {server transfer response}";
    L18:
        if (r100.equals("server_response_too_large") == false) goto L50;
        return "Phase {server transfer response}";
    L21:
        if (r100.equals("ICallback_callback_fail") == false) goto L50;
    L24:
        if (r100.equals("method_not_found") == false) goto L50;
        return "Phase {server before method invoke}";
    L27:
        if (r100.equals("server_response_null") == false) goto L50;
    L30:
        if (r100.equals("unsuccessful_response") == false) goto L50;
        return "Phase {client receive server's response}";
    L33:
        if (r100.equals("method_illegal_access") == false) goto L50;
    L40:
        return "Phase {server method invoke}";
    L36:
        if (r100.equals("client_response_callback_null") == false) goto L50;
    L39:
        if (r100.equals("method_invocation_fail") == false) goto L50;
    L42:
        if (r100.equals("remote_call_wait_overtime") == false) goto L50;
    L45:
        if (r100.equals("null_binder_in_service_connected") == false) goto L50;
    L48:
        if (r100.equals("get_binder_in_main_thread") == false) goto L50;
        goto L49
    }
}
