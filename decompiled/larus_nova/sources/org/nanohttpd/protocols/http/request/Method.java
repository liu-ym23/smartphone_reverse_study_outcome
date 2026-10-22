package org.nanohttpd.protocols.http.request;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum Method extends Enum<Method> {
    public static final Method CONNECT = null;
    public static final Method COPY = null;
    public static final Method DELETE = null;
    public static final Method GET = null;
    public static final Method HEAD = null;
    public static final Method LOCK = null;
    public static final Method MKCOL = null;
    public static final Method MOVE = null;
    public static final Method NOTIFY = null;
    public static final Method OPTIONS = null;
    public static final Method PATCH = null;
    public static final Method POST = null;
    public static final Method PROPFIND = null;
    public static final Method PROPPATCH = null;
    public static final Method PUT = null;
    public static final Method SUBSCRIBE = null;
    public static final Method TRACE = null;
    public static final Method UNLOCK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Method[] f526200a = null;

    static {
        Method r100 = new Method("GET", 0);
        GET = r100;
        Method r101 = new Method("PUT", 1);
        PUT = r101;
        Method r102 = new Method("POST", 2);
        POST = r102;
        Method r103 = new Method("DELETE", 3);
        DELETE = r103;
        Method r104 = new Method("HEAD", 4);
        HEAD = r104;
        Method r105 = new Method("OPTIONS", 5);
        OPTIONS = r105;
        Method r110 = new Method("TRACE", 6);
        TRACE = r110;
        Method r111 = new Method(OpenNetMethod.CONNECT, 7);
        CONNECT = r111;
        Method r112 = new Method("PATCH", 8);
        PATCH = r112;
        Method r113 = new Method(OpenNetMethod.PROPFIND, 9);
        PROPFIND = r113;
        Method r114 = new Method(OpenNetMethod.PROPPATCH, 10);
        PROPPATCH = r114;
        Method r115 = new Method(OpenNetMethod.MKCOL, 11);
        MKCOL = r115;
        Method r106 = new Method("MOVE", 12);
        MOVE = r106;
        Method r107 = new Method("COPY", 13);
        COPY = r107;
        Method r108 = new Method(OpenNetMethod.LOCK, 14);
        LOCK = r108;
        Method r109 = new Method("UNLOCK", 15);
        UNLOCK = r109;
        Method r116 = new Method(HTTP.NOTIFY, 16);
        NOTIFY = r116;
        Method r117 = new Method("SUBSCRIBE", 17);
        SUBSCRIBE = r117;
        f526200a = new Method[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
    }

    public static Method[] values() {
        return (Method[]) f526200a.clone();
    }

    public static Method lookup(String r100) {
        if (r100 != null) goto L8;
        return null;
    L8:
        return valueOf(r100);
    L7:
        return null;
    }

    public static Method valueOf(String r100) {
        return (Method) a.a(Method.class, r100);
    }

    public Method(String r100, int r101) {
        super(r100, r101);
    }
}
