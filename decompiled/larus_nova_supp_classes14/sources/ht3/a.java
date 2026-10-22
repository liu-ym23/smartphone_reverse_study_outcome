package ht3;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Map<String, Map<String, Integer>> a = null;

    static {
        a = new HashMap();
    }

    public static int a(Throwable r8) {
        int r0 = -1;
        if (r8 != null) goto L5;
        return -1;
    L5:
        Map<String, Map<String, Integer>> r1 = a;
        HashMap r2 = (HashMap) r1;
        if (r2.isEmpty() == false) goto L8;
        HashMap r3 = new HashMap();
        r3.put(" Bad Request", 101);
        r3.put(" Connection timed out", 102);
        r3.put(" Forbidden", 103);
        r3.put(" Gateway Time-out", 104);
        r3.put(" Internal Server Error", 105);
        r3.put(" Not Found", 106);
        r3.put(" Request Time-out", 107);
        r3.put(" Request-URI Too Large", 108);
        r2.put("HttpResponseException", r3);
        HashMap r4 = new HashMap();
        r4.put("ERR_ABORTED", 301);
        r4.put("ERR_ADDRESS_UNREACHABLE", 302);
        r4.put("ERR_CERT_AUTHORITY_INVALID", 303);
        r4.put("ERR_CERT_COMMON_NAME_INVALID", 304);
        r4.put("ERR_CERT_DATE_INVALID", 305);
        r4.put("ERR_CONNECTION_ABORTED", 306);
        r4.put("ERR_CONNECTION_CLOSED", 307);
        r4.put("ERR_CONNECTION_REFUSED", 308);
        r4.put("ERR_CONNECTION_RESET", 309);
        r4.put("ERR_CONNECTION_TIMED_OUT", 310);
        r4.put("ERR_EMPTY_RESPONSE", 311);
        r4.put("ERR_HTTP2_PING_FAILED", 312);
        r4.put("ERR_INCOMPLETE_CHUNKED_ENCODING", 313);
        r4.put("ERR_INTERNET_DISCONNECTED", 314);
        r4.put("ERR_NAME_NOT_RESOLVED", 315);
        r4.put("ERR_NETWORK_ACCESS_DENIED", 316);
        r4.put("ERR_PROXY_CONNECTION_FAILED", 317);
        r4.put("ERR_SOCKET_NOT_CONNECTED", 318);
        r4.put("ERR_SSL_BAD_RECORD_MAC_ALERT", 319);
        r4.put("ERR_SSL_PROTOCOL_ERROR", 320);
        r4.put("ERR_TIMED_OUT", 321);
        r4.put("ERR_TTNET_APP_TIMED_OUT", 322);
        r4.put("ERR_TTNET_APP_UPLOAD_EXCEPTION", 323);
        r4.put("ERR_TUNNEL_CONNECTION_FAILED", 324);
        r2.put("NetworkExceptionImpl", r4);
        HashMap r5 = new HashMap();
        r5.put("ERR_NETWORK_CHANGED", 401);
        r2.put("QuicExceptionImpl", r5);
        HashMap r6 = new HashMap();
        r6.put(" Unexpected end of ZLIB input stream", 501);
        r2.put(EOFException.class.getSimpleName(), r6);
        HashMap r7 = new HashMap();
        r7.put(" unexpected end of stream on Connection", 601);
        r7.put(" Unexpected request usage", 602);
        r2.put(IOException.class.getSimpleName(), r7);
        HashMap r9 = new HashMap();
        r9.put("Cronet internal request fail", 701);
        r2.put(Exception.class.getSimpleName(), r9);
        HashMap r10 = new HashMap();
        r10.put(" Content received is less than Content-Length", 801);
        r10.put(" expected bytes but received", 802);
        r10.put(" unexpected end of stream", 803);
        r2.put(ProtocolException.class.getSimpleName(), r10);
        HashMap r11 = new HashMap();
        r11.put(" Connection closed by peer", 901);
        r11.put(" Read error", 902);
        r11.put(" SSL handshake aborted", 903);
        r2.put(SSLException.class.getSimpleName(), r11);
        HashMap r12 = new HashMap();
        r12.put(" Connection closed by peer", 1001);
        r12.put(" Handshake failed", 1002);
        r12.put(" SSL handshake aborted", 1003);
        r2.put(SSLHandshakeException.class.getSimpleName(), r12);
        HashMap r13 = new HashMap();
        r13.put(" Hostname not verified", 1101);
        r2.put(SSLPeerUnverifiedException.class.getSimpleName(), r13);
        HashMap r14 = new HashMap();
        r14.put(" Read error", 1201);
        r2.put(SSLProtocolException.class.getSimpleName(), r14);
    L8:
        String r15 = r8.getMessage();
        if (TextUtils.isEmpty(r15) == false) goto L11;
        return -1;
    L11:
        int r16 = r15.indexOf(44);
        if (r16 <= 0) goto L14;
        r15 = r15.substring(0, r16);
    L14:
        HashMap r17 = (HashMap) r1;
        Map r18 = (Map) r17.get(r8.getClass().getSimpleName());
        if (r18 != null) goto L17;
    L26:
        if (r0 < 0) goto L28;
        return r0;
    L28:
        if ((r8 instanceof HttpResponseException) == false) goto L31;
        return 199;
    L31:
        if ((r8 instanceof EOFException) == false) goto L34;
        return 599;
    L34:
        if ((r8 instanceof IOException) == false) goto L43;
        return 699;
    L43:
        return r0;
    L17:
        if (r18.isEmpty() == true) goto L26;
        Iterator r19 = r18.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L26;
        Map.Entry r20 = (Map.Entry) r19.next();
        if (r15.contains((CharSequence) r20.getKey()) == false) goto L20;
        Integer r21 = (Integer) r20.getValue();
        if (r21 == null) goto L26;
        r0 = r21.intValue();
        goto L26
    }
}
