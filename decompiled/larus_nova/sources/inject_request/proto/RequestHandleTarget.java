package inject_request.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum RequestHandleTarget extends Enum<RequestHandleTarget> implements WireEnum {
    private static final /* synthetic */ RequestHandleTarget[] $VALUES = null;
    public static final ProtoAdapter<RequestHandleTarget> ADAPTER = null;
    public static final RequestHandleTarget VAR_REQUEST_HANDLE_TARGET_HEADER = null;
    public static final RequestHandleTarget VAR_REQUEST_HANDLE_TARGET_HOST = null;
    private final int value;

    static {
        RequestHandleTarget r100 = new RequestHandleTarget("VAR_REQUEST_HANDLE_TARGET_HEADER", 0, 0);
        VAR_REQUEST_HANDLE_TARGET_HEADER = r100;
        RequestHandleTarget r101 = new RequestHandleTarget("VAR_REQUEST_HANDLE_TARGET_HOST", 1, 1);
        VAR_REQUEST_HANDLE_TARGET_HOST = r101;
        $VALUES = new RequestHandleTarget[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(RequestHandleTarget.class);
    }

    public static RequestHandleTarget[] values() {
        return (RequestHandleTarget[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static RequestHandleTarget fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return VAR_REQUEST_HANDLE_TARGET_HOST;
    L10:
        return VAR_REQUEST_HANDLE_TARGET_HEADER;
    }

    public static RequestHandleTarget valueOf(String r100) {
        return (RequestHandleTarget) a.a(RequestHandleTarget.class, r100);
    }

    private RequestHandleTarget(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
