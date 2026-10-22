package com.bytedance.lark.pb.tool.v1;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum HttpMethod extends Enum<HttpMethod> implements WireEnum {
    private static final /* synthetic */ HttpMethod[] $VALUES = null;
    public static final ProtoAdapter<HttpMethod> ADAPTER = null;
    public static final HttpMethod CONNECT = null;
    public static final HttpMethod DELETE = null;
    public static final HttpMethod GET = null;
    public static final HttpMethod HEAD = null;
    public static final HttpMethod OPTIONS = null;
    public static final HttpMethod PATCH = null;
    public static final HttpMethod POST = null;
    public static final HttpMethod PUT = null;
    public static final HttpMethod TRACE = null;
    private final int value;

    static {
        HttpMethod r100 = new HttpMethod("GET", 0, 1);
        GET = r100;
        HttpMethod r101 = new HttpMethod("POST", 1, 2);
        POST = r101;
        HttpMethod r102 = new HttpMethod("DELETE", 2, 3);
        DELETE = r102;
        HttpMethod r103 = new HttpMethod("PUT", 3, 4);
        PUT = r103;
        HttpMethod r104 = new HttpMethod("PATCH", 4, 5);
        PATCH = r104;
        HttpMethod r110 = new HttpMethod("HEAD", 5, 6);
        HEAD = r110;
        HttpMethod r111 = new HttpMethod(OpenNetMethod.CONNECT, 6, 7);
        CONNECT = r111;
        HttpMethod r112 = new HttpMethod("OPTIONS", 7, 8);
        OPTIONS = r112;
        HttpMethod r113 = new HttpMethod("TRACE", 8, 9);
        TRACE = r113;
        $VALUES = new HttpMethod[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
        ADAPTER = ProtoAdapter.newEnumAdapter(HttpMethod.class);
    }

    public static HttpMethod[] values() {
        return (HttpMethod[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static HttpMethod fromValue(int r100) {
        switch(r100) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return TRACE;
    L8:
        return OPTIONS;
    L10:
        return CONNECT;
    L12:
        return HEAD;
    L14:
        return PATCH;
    L16:
        return PUT;
    L18:
        return DELETE;
    L20:
        return POST;
    L22:
        return GET;
    }

    public static HttpMethod valueOf(String r100) {
        return (HttpMethod) a.a(HttpMethod.class, r100);
    }

    private HttpMethod(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
