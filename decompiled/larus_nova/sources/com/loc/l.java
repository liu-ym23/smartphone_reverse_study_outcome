package com.loc;

import com.amap.api.services.core.AMapException;
import com.byted.cast.common.source.ISendResultListener;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class l extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f380150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f380151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f380152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f380153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f380154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f380155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f380156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f380157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f380158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, List<String>> f380159j;

    public l(String r110) {
        super(r110);
        this.f380150a = "未知的错误";
        this.f380151b = "";
        this.f380152c = "";
        this.f380153d = "1900";
        this.f380154e = "UnknownError";
        this.f380155f = -1;
        this.f380156g = -1;
        this.f380157h = false;
        this.f380150a = r110;
        if (AMapException.AMAP_CLIENT_IO_EXCEPTION.equals(r110) == false) goto L7;
        this.f380155f = 21;
        this.f380153d = "1902";
        String r100 = "IOException";
    L5:
        this.f380154e = r100;
    L79:
        if (AMapException.AMAP_CLIENT_IO_EXCEPTION.equals(r110) == false) goto L83;
        this.f380156g = 7;
        return;
    L83:
        if ("socket 连接异常 - SocketException".equals(r110) == false) goto L87;
        this.f380156g = 6;
        return;
    L87:
        if (AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION.equals(r110) == false) goto L91;
        this.f380156g = 2;
        return;
    L91:
        if (AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION.equals(r110) == false) goto L93;
    L102:
        this.f380156g = 9;
        return;
    L93:
        if ("http连接失败 - ConnectionException".equals(r110) == false) goto L97;
        this.f380156g = 6;
        return;
    L97:
        if ("未知的错误".equals(r110) == true) goto L102;
        if ("DNS解析失败".equals(r110) == false) goto L102;
        this.f380156g = 3;
        return;
    L7:
        if ("socket 连接异常 - SocketException".equals(r110) == false) goto L11;
        int r101 = 22;
    L9:
        this.f380155f = r101;
        goto L79
    L11:
        if (AMapException.AMAP_CLIENT_SOCKET_TIMEOUT_EXCEPTION.equals(r110) == false) goto L14;
        this.f380155f = 23;
        this.f380153d = "1802";
        r100 = "SocketTimeoutException";
        goto L5
    L14:
        if (AMapException.AMAP_CLIENT_INVALID_PARAMETER.equals(r110) == false) goto L17;
        this.f380155f = 24;
        this.f380153d = "1901";
        r100 = "IllegalArgumentException";
        goto L5
    L17:
        if (AMapException.AMAP_CLIENT_NULLPOINT_EXCEPTION.equals(r110) == false) goto L20;
        this.f380155f = 25;
        this.f380153d = "1903";
        r100 = "NullPointException";
        goto L5
    L20:
        if (AMapException.AMAP_CLIENT_URL_EXCEPTION.equals(r110) == false) goto L23;
        this.f380155f = 26;
        this.f380153d = "1803";
        r100 = "MalformedURLException";
        goto L5
    L23:
        if (AMapException.AMAP_CLIENT_UNKNOWHOST_EXCEPTION.equals(r110) == false) goto L26;
        this.f380155f = 27;
        this.f380153d = "1804";
        r100 = "UnknownHostException";
        goto L5
    L26:
        if ("服务器连接失败 - UnknownServiceException".equals(r110) == false) goto L29;
        this.f380155f = 28;
        this.f380153d = "1805";
        r100 = "CannotConnectToHostException";
        goto L5
    L29:
        if (AMapException.AMAP_CLIENT_ERROR_PROTOCOL.equals(r110) == false) goto L32;
        this.f380155f = 29;
        this.f380153d = "1801";
        r100 = "ProtocolException";
        goto L5
    L32:
        if ("http连接失败 - ConnectionException".equals(r110) == false) goto L36;
        this.f380155f = 30;
        String r102 = "1806";
    L34:
        this.f380153d = r102;
        this.f380154e = "ConnectionException";
        goto L79
    L36:
        if ("服务QPS超限".equalsIgnoreCase(r110) == false) goto L39;
        this.f380155f = 30;
        r102 = AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
        goto L34
    L39:
        if ("未知的错误".equals(r110) == false) goto L42;
        r101 = 31;
        goto L9
    L42:
        if ("key鉴权失败".equals(r110) == false) goto L45;
        r101 = 32;
        goto L9
    L45:
        if ("限制访问的接口".equals(r110) == false) goto L48;
        r101 = 33;
        goto L9
    L48:
        if ("requeust is null".equals(r110) == false) goto L51;
        r101 = 1;
        goto L9
    L51:
        if ("request url is empty".equals(r110) == false) goto L54;
        this.f380155f = 2;
        goto L79
    L54:
        if (ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL.equals(r110) == false) goto L57;
    L55:
        this.f380155f = 3;
        goto L79
    L57:
        if ("thread pool has exception".equals(r110) == false) goto L60;
        r101 = 4;
        goto L9
    L60:
        if ("sdk name is invalid".equals(r110) == false) goto L63;
        r101 = 5;
        goto L9
    L63:
        if ("sdk info is null".equals(r110) == false) goto L66;
        this.f380155f = 6;
        goto L79
    L66:
        if ("sdk packages is null".equals(r110) == false) goto L69;
        this.f380155f = 7;
        goto L79
    L69:
        if ("线程池为空".equals(r110) == false) goto L72;
        r101 = 8;
        goto L9
    L72:
        if ("获取对象错误".equals(r110) == false) goto L75;
        r101 = 101;
        goto L9
    L75:
        if ("DNS解析失败".equals(r110) == true) goto L55;
        r101 = -1;
        goto L9
    }

    public l(String r100, String r101, String r102) {
        this(r100);
        this.f380151b = r101;
        this.f380152c = r102;
    }

    public final String a() {
        return this.f380150a;
    }

    public final void a(String r100) {
        this.f380158i = r100;
    }

    public final void a(Map<String, List<String>> r100) {
        this.f380159j = r100;
    }

    public final String b() {
        return this.f380153d;
    }

    public final String c() {
        return this.f380154e;
    }

    public final String d() {
        return this.f380151b;
    }

    public final String e() {
        return this.f380152c;
    }

    public final int f() {
        return this.f380155f;
    }

    public final int g() {
        return this.f380156g;
    }

    public final int h() {
        this.f380156g = 10;
        return 10;
    }

    public final boolean i() {
        return this.f380157h;
    }

    public final void j() {
        this.f380157h = true;
    }
}
