package ht3;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.larksuite.component.card.plugin.FetchCardPlugin;
import com.ss.ttm.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, Integer>> f487117a = null;

    static {
        f487117a = new HashMap();
    }

    public static int a(Throwable r100) {
        int r101 = -1;
        if (r100 != null) goto L5;
        return -1;
    L5:
        Map<String, Map<String, Integer>> r102 = f487117a;
        HashMap r103 = (HashMap) r102;
        if (r103.isEmpty() == false) goto L8;
        HashMap r104 = new HashMap();
        r104.put(" Bad Request", 101);
        r104.put(" Connection timed out", 102);
        r104.put(" Forbidden", 103);
        r104.put(" Gateway Time-out", 104);
        r104.put(" Internal Server Error", 105);
        r104.put(" Not Found", 106);
        r104.put(" Request Time-out", 107);
        r104.put(" Request-URI Too Large", 108);
        r103.put("HttpResponseException", r104);
        HashMap r105 = new HashMap();
        r105.put("ERR_ABORTED", 301);
        r105.put("ERR_ADDRESS_UNREACHABLE", 302);
        r105.put("ERR_CERT_AUTHORITY_INVALID", 303);
        r105.put("ERR_CERT_COMMON_NAME_INVALID", 304);
        r105.put("ERR_CERT_DATE_INVALID", 305);
        r105.put("ERR_CONNECTION_ABORTED", 306);
        r105.put("ERR_CONNECTION_CLOSED", 307);
        r105.put("ERR_CONNECTION_REFUSED", 308);
        r105.put("ERR_CONNECTION_RESET", 309);
        r105.put("ERR_CONNECTION_TIMED_OUT", 310);
        r105.put("ERR_EMPTY_RESPONSE", 311);
        r105.put("ERR_HTTP2_PING_FAILED", 312);
        r105.put("ERR_INCOMPLETE_CHUNKED_ENCODING", 313);
        r105.put("ERR_INTERNET_DISCONNECTED", 314);
        r105.put("ERR_NAME_NOT_RESOLVED", 315);
        r105.put("ERR_NETWORK_ACCESS_DENIED", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN));
        r105.put("ERR_PROXY_CONNECTION_FAILED", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT));
        r105.put("ERR_SOCKET_NOT_CONNECTED", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME));
        r105.put("ERR_SSL_BAD_RECORD_MAC_ALERT", Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME));
        r105.put("ERR_SSL_PROTOCOL_ERROR", 320);
        r105.put("ERR_TIMED_OUT", 321);
        r105.put("ERR_TTNET_APP_TIMED_OUT", 322);
        r105.put("ERR_TTNET_APP_UPLOAD_EXCEPTION", 323);
        r105.put("ERR_TUNNEL_CONNECTION_FAILED", 324);
        r103.put("NetworkExceptionImpl", r105);
        HashMap r106 = new HashMap();
        r106.put("ERR_NETWORK_CHANGED", 401);
        r103.put("QuicExceptionImpl", r106);
        HashMap r107 = new HashMap();
        r107.put(" Unexpected end of ZLIB input stream", 501);
        r103.put(EOFException.class.getSimpleName(), r107);
        HashMap r108 = new HashMap();
        r108.put(" unexpected end of stream on Connection", 601);
        r108.put(" Unexpected request usage", 602);
        r103.put(IOException.class.getSimpleName(), r108);
        HashMap r109 = new HashMap();
        r109.put("Cronet internal request fail", 701);
        r103.put(Exception.class.getSimpleName(), r109);
        HashMap r110 = new HashMap();
        r110.put(" Content received is less than Content-Length", 801);
        r110.put(" expected bytes but received", 802);
        r110.put(" unexpected end of stream", 803);
        r103.put(ProtocolException.class.getSimpleName(), r110);
        HashMap r111 = new HashMap();
        r111.put(" Connection closed by peer", 901);
        r111.put(" Read error", 902);
        r111.put(" SSL handshake aborted", 903);
        r103.put(SSLException.class.getSimpleName(), r111);
        HashMap r112 = new HashMap();
        r112.put(" Connection closed by peer", 1001);
        r112.put(" Handshake failed", 1002);
        r112.put(" SSL handshake aborted", 1003);
        r103.put(SSLHandshakeException.class.getSimpleName(), r112);
        HashMap r113 = new HashMap();
        r113.put(" Hostname not verified", 1101);
        r103.put(SSLPeerUnverifiedException.class.getSimpleName(), r113);
        HashMap r114 = new HashMap();
        r114.put(" Read error", 1201);
        r103.put(SSLProtocolException.class.getSimpleName(), r114);
    L8:
        String r115 = r100.getMessage();
        if (TextUtils.isEmpty(r115) == false) goto L11;
        return -1;
    L11:
        int r116 = r115.indexOf(44);
        if (r116 <= 0) goto L14;
        r115 = r115.substring(0, r116);
    L14:
        HashMap r117 = (HashMap) r102;
        Map r118 = (Map) r117.get(r100.getClass().getSimpleName());
        if (r118 != null) goto L17;
    L26:
        if (r101 < 0) goto L28;
        return r101;
    L28:
        if ((r100 instanceof HttpResponseException) == false) goto L31;
        return 199;
    L31:
        if ((r100 instanceof EOFException) == false) goto L34;
        return FetchCardPlugin.SERVER_ERROR;
    L34:
        if ((r100 instanceof IOException) == false) goto L43;
        return MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_LIVE_FRAME_RENDER_TIME;
    L43:
        return r101;
    L17:
        if (r118.isEmpty() == true) goto L26;
        Iterator r119 = r118.entrySet().iterator();
    L20:
        if (r119.hasNext() == false) goto L26;
        Map.Entry r120 = (Map.Entry) r119.next();
        if (r115.contains((CharSequence) r120.getKey()) == false) goto L20;
        Integer r121 = (Integer) r120.getValue();
        if (r121 == null) goto L26;
        r101 = r121.intValue();
        goto L26
    }
}
