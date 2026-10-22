package com.lynx.debugrouter;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.lynx.debugrouter.base.MessageTransceiver;
import com.lynx.debugrouter.base.NativeMessageTransceiver;
import com.lynx.debugrouter.base.report.DebugRouterReportServiceUtil;
import com.lynx.debugrouter.log.LLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class DebugRouterReport {
    private static final String TAG = "DebugRouterReport";

    public DebugRouterReport() {
    }

    private static String getTransceiverType(MessageTransceiver r100) {
        if ((r100 instanceof WebSocketClient) == false) goto L7;
        return "OKHttp";
    L7:
        if ((r100 instanceof NativeMessageTransceiver) == false) goto L10;
        return "NativeMessageTransceiver";
    L10:
        return "null";
    }

    public static void reportHandleSchema(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("schema", r100);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("handleSchema", r101, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportHandleSchema:" + e.toString());
        goto L7
    }

    public static void reportInitServerOK(int r100) {
        JSONObject r101 = new JSONObject();
        r101.put("port", r100);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("USBServerInitOK", r101, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportInitServerOK:" + e.toString());
        goto L7
    }

    public static void reportNewSocketClient(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("client", r100);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("new_socket_client", r101, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportNewSocketClient:" + e.toString());
        goto L7
    }

    public static void reportNewUSBClient(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("client", r100);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("new_usb_client", r101, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportNewUSBClient:" + e.toString());
        goto L7
    }

    public static void reportOnOpen(MessageTransceiver r100) {
        JSONObject r101 = new JSONObject();
        r101.put(MonitorConstants.CONNECT_TYPE, getTransceiverType(r100));     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("onOpen", r101, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportOnOpen:" + e.toString());
        goto L7
    }

    public static void reportOnOpenWarning(MessageTransceiver r100) {
        JSONObject r101 = new JSONObject();
        r101.put(MonitorConstants.CONNECT_TYPE, getTransceiverType(r100));     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("similar_trans_open", r101, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportOnOpenWarning:" + e.toString());
        goto L7
    }

    public static void reportSendMessage(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("msg", r100.substring(0, Math.min(512, r100.length())));     // Catch: JSONException -> L6
        DebugRouterReportServiceUtil.report("SendMessage", r101, null, null);
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void reportDurTimeError(MessageTransceiver r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("Transceiver", getTransceiverType(r100));     // Catch: JSONException -> L5
        r102.put("reason", r101);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("TransceiverTimeError", r102, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportDurTimeError:" + e.toString());
        goto L7
    }

    public static void reportInValidClient(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("address", r100);     // Catch: JSONException -> L5
        r102.put("header", r101);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("invalid_client", r102, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportInValidClient:" + e.toString());
        goto L7
    }

    public static void reportOnError(MessageTransceiver r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put(MonitorConstants.CONNECT_TYPE, getTransceiverType(r100));     // Catch: JSONException -> L5
        r102.put("error_msg", r101);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report(LynxVideoManagerLite.EVENT_ON_ERROR, r102, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportOnError:" + e.toString());
        goto L7
    }

    public static void reportReceiveMessage(String r100, MessageTransceiver r101) {
        JSONObject r102 = new JSONObject();
        r102.put("msg", r100.substring(0, Math.min(512, r100.length())));     // Catch: JSONException -> L5
        r102.put(MonitorConstants.CONNECT_TYPE, getTransceiverType(r101));     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("receive_message", r102, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportReceiveMessage:" + e.toString());
        goto L7
    }

    public static void reportConnect(String r100, String r101, boolean r102) {
        JSONObject r103 = new JSONObject();
        r103.put("url", r100);     // Catch: JSONException -> L5
        r103.put("room", r101);     // Catch: JSONException -> L5
    L8:
        if (r102 == false) goto L10;
        DebugRouterReportServiceUtil.report("reconnect", r103, null, null);
        return;
    L10:
        DebugRouterReportServiceUtil.report("connect", r103, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportConnect:" + e.toString());
        goto L8
    }

    public static void reportDurTime(MessageTransceiver r100, long r101, String r102) {
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        r103.put("duration", r101);     // Catch: JSONException -> L5
        r104.put("Transceiver", getTransceiverType(r100));     // Catch: JSONException -> L5
        r104.put("reason", r102);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("TransceiverTime", r104, r103, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportDurTime:" + e.toString());
        goto L7
    }

    public static void reportOnClose(MessageTransceiver r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put(MonitorConstants.CONNECT_TYPE, getTransceiverType(r100));     // Catch: JSONException -> L5
        r103.put("code", String.valueOf(r101));     // Catch: JSONException -> L5
        r103.put("message", r102);     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("onClose", r103, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportOnClose:" + e.toString());
        goto L7
    }

    public static void reportOnCloseWarning(MessageTransceiver r100, MessageTransceiver r101, ConnectionState r102) {
        JSONObject r103 = new JSONObject();
        if (r100 == r101) goto L6;
        String r104 = "different transceiver when close";
    L15:
        r103.put(MonitorConstants.CONNECT_TYPE, getTransceiverType(r101));     // Catch: JSONException -> L11
        r103.put("warning_msg", r104);     // Catch: JSONException -> L11
    L13:
        DebugRouterReportServiceUtil.report("OnCloseWarning", r103, null, null);
        return;
    L11:
        e = move-exception;
        LLog.e(TAG, "reportOnCloseWarning:" + e.toString());
        goto L13
    L6:
        if (r102 != ConnectionState.DISCONNECTED) goto L8;
        r104 = "ConnectionState is DISCONNECTED when close";
        goto L15
    L8:
        r104 = "";
        goto L15
    }

    public static void reportOnMessageWarning(MessageTransceiver r100, MessageTransceiver r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("msg", r102.substring(0, Math.min(512, r102.length())));     // Catch: JSONException -> L5
        r103.put("CurrentTransceiver", getTransceiverType(r101));     // Catch: JSONException -> L5
        r103.put("Transceiver", getTransceiverType(r100));     // Catch: JSONException -> L5
    L7:
        DebugRouterReportServiceUtil.report("OnMessageWarning", r103, null, null);
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "reportOnMessageWarning:" + e.toString());
        goto L7
    }
}
