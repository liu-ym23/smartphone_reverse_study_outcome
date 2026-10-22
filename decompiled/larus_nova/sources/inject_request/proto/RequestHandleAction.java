package inject_request.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum RequestHandleAction extends Enum<RequestHandleAction> implements WireEnum {
    private static final /* synthetic */ RequestHandleAction[] $VALUES = null;
    public static final ProtoAdapter<RequestHandleAction> ADAPTER = null;
    public static final RequestHandleAction VAR_REQUEST_HANDLE_ACTION_ADD = null;
    public static final RequestHandleAction VAR_REQUEST_HANDLE_ACTION_REDIRECT_POLICY = null;
    public static final RequestHandleAction VAR_REQUEST_HANDLE_ACTION_REPLACE = null;
    private final int value;

    static {
        RequestHandleAction r100 = new RequestHandleAction("VAR_REQUEST_HANDLE_ACTION_ADD", 0, 0);
        VAR_REQUEST_HANDLE_ACTION_ADD = r100;
        RequestHandleAction r101 = new RequestHandleAction("VAR_REQUEST_HANDLE_ACTION_REPLACE", 1, 1);
        VAR_REQUEST_HANDLE_ACTION_REPLACE = r101;
        RequestHandleAction r102 = new RequestHandleAction("VAR_REQUEST_HANDLE_ACTION_REDIRECT_POLICY", 2, 2);
        VAR_REQUEST_HANDLE_ACTION_REDIRECT_POLICY = r102;
        $VALUES = new RequestHandleAction[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(RequestHandleAction.class);
    }

    public static RequestHandleAction[] values() {
        return (RequestHandleAction[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static RequestHandleAction fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return VAR_REQUEST_HANDLE_ACTION_REDIRECT_POLICY;
    L12:
        return VAR_REQUEST_HANDLE_ACTION_REPLACE;
    L14:
        return VAR_REQUEST_HANDLE_ACTION_ADD;
    }

    public static RequestHandleAction valueOf(String r100) {
        return (RequestHandleAction) a.a(RequestHandleAction.class, r100);
    }

    private RequestHandleAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
