package inject_request.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum RequestMethod extends Enum<RequestMethod> implements WireEnum {
    private static final /* synthetic */ RequestMethod[] $VALUES = null;
    public static final ProtoAdapter<RequestMethod> ADAPTER = null;
    public static final RequestMethod VAR_REQUEST_METHOD_CONNECT = null;
    public static final RequestMethod VAR_REQUEST_METHOD_DELETE = null;
    public static final RequestMethod VAR_REQUEST_METHOD_GET = null;
    public static final RequestMethod VAR_REQUEST_METHOD_HEAD = null;
    public static final RequestMethod VAR_REQUEST_METHOD_OPTIONS = null;
    public static final RequestMethod VAR_REQUEST_METHOD_PATCH = null;
    public static final RequestMethod VAR_REQUEST_METHOD_POST = null;
    public static final RequestMethod VAR_REQUEST_METHOD_PUT = null;
    public static final RequestMethod VAR_REQUEST_METHOD_TRACE = null;
    private final int value;

    static {
        RequestMethod r100 = new RequestMethod("VAR_REQUEST_METHOD_GET", 0, 0);
        VAR_REQUEST_METHOD_GET = r100;
        RequestMethod r101 = new RequestMethod("VAR_REQUEST_METHOD_POST", 1, 1);
        VAR_REQUEST_METHOD_POST = r101;
        RequestMethod r102 = new RequestMethod("VAR_REQUEST_METHOD_DELETE", 2, 2);
        VAR_REQUEST_METHOD_DELETE = r102;
        RequestMethod r103 = new RequestMethod("VAR_REQUEST_METHOD_PUT", 3, 3);
        VAR_REQUEST_METHOD_PUT = r103;
        RequestMethod r104 = new RequestMethod("VAR_REQUEST_METHOD_PATCH", 4, 4);
        VAR_REQUEST_METHOD_PATCH = r104;
        RequestMethod r105 = new RequestMethod("VAR_REQUEST_METHOD_HEAD", 5, 5);
        VAR_REQUEST_METHOD_HEAD = r105;
        RequestMethod r110 = new RequestMethod("VAR_REQUEST_METHOD_CONNECT", 6, 6);
        VAR_REQUEST_METHOD_CONNECT = r110;
        RequestMethod r111 = new RequestMethod("VAR_REQUEST_METHOD_OPTIONS", 7, 7);
        VAR_REQUEST_METHOD_OPTIONS = r111;
        RequestMethod r112 = new RequestMethod("VAR_REQUEST_METHOD_TRACE", 8, 8);
        VAR_REQUEST_METHOD_TRACE = r112;
        $VALUES = new RequestMethod[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        ADAPTER = ProtoAdapter.newEnumAdapter(RequestMethod.class);
    }

    public static RequestMethod[] values() {
        return (RequestMethod[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static RequestMethod fromValue(int r100) {
        switch(r100) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return VAR_REQUEST_METHOD_TRACE;
    L8:
        return VAR_REQUEST_METHOD_OPTIONS;
    L10:
        return VAR_REQUEST_METHOD_CONNECT;
    L12:
        return VAR_REQUEST_METHOD_HEAD;
    L14:
        return VAR_REQUEST_METHOD_PATCH;
    L16:
        return VAR_REQUEST_METHOD_PUT;
    L18:
        return VAR_REQUEST_METHOD_DELETE;
    L20:
        return VAR_REQUEST_METHOD_POST;
    L22:
        return VAR_REQUEST_METHOD_GET;
    }

    public static RequestMethod valueOf(String r100) {
        return (RequestMethod) a.a(RequestMethod.class, r100);
    }

    private RequestMethod(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
