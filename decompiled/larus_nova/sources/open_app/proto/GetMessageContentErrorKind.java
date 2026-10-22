package open_app.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum GetMessageContentErrorKind extends Enum<GetMessageContentErrorKind> implements WireEnum {
    private static final /* synthetic */ GetMessageContentErrorKind[] $VALUES = null;
    public static final ProtoAdapter<GetMessageContentErrorKind> ADAPTER = null;
    public static final GetMessageContentErrorKind VAR_GET_MESSAGE_CONTENT_ERROR_KIND_GATEWAY_ERROR = null;
    public static final GetMessageContentErrorKind VAR_GET_MESSAGE_CONTENT_ERROR_KIND_INTERNAL_ERROR = null;
    public static final GetMessageContentErrorKind VAR_GET_MESSAGE_CONTENT_ERROR_KIND_MESSAGE_NOT_FOUND = null;
    public static final GetMessageContentErrorKind VAR_GET_MESSAGE_CONTENT_ERROR_KIND_SERVER_ERROR = null;
    private final int value;

    static {
        GetMessageContentErrorKind r100 = new GetMessageContentErrorKind("VAR_GET_MESSAGE_CONTENT_ERROR_KIND_INTERNAL_ERROR", 0, 0);
        VAR_GET_MESSAGE_CONTENT_ERROR_KIND_INTERNAL_ERROR = r100;
        GetMessageContentErrorKind r101 = new GetMessageContentErrorKind("VAR_GET_MESSAGE_CONTENT_ERROR_KIND_MESSAGE_NOT_FOUND", 1, 1);
        VAR_GET_MESSAGE_CONTENT_ERROR_KIND_MESSAGE_NOT_FOUND = r101;
        GetMessageContentErrorKind r102 = new GetMessageContentErrorKind("VAR_GET_MESSAGE_CONTENT_ERROR_KIND_GATEWAY_ERROR", 2, 2);
        VAR_GET_MESSAGE_CONTENT_ERROR_KIND_GATEWAY_ERROR = r102;
        GetMessageContentErrorKind r103 = new GetMessageContentErrorKind("VAR_GET_MESSAGE_CONTENT_ERROR_KIND_SERVER_ERROR", 3, 3);
        VAR_GET_MESSAGE_CONTENT_ERROR_KIND_SERVER_ERROR = r103;
        $VALUES = new GetMessageContentErrorKind[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(GetMessageContentErrorKind.class);
    }

    public static GetMessageContentErrorKind[] values() {
        return (GetMessageContentErrorKind[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static GetMessageContentErrorKind fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return VAR_GET_MESSAGE_CONTENT_ERROR_KIND_SERVER_ERROR;
    L14:
        return VAR_GET_MESSAGE_CONTENT_ERROR_KIND_GATEWAY_ERROR;
    L16:
        return VAR_GET_MESSAGE_CONTENT_ERROR_KIND_MESSAGE_NOT_FOUND;
    L18:
        return VAR_GET_MESSAGE_CONTENT_ERROR_KIND_INTERNAL_ERROR;
    }

    public static GetMessageContentErrorKind valueOf(String r100) {
        return (GetMessageContentErrorKind) a.a(GetMessageContentErrorKind.class, r100);
    }

    private GetMessageContentErrorKind(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
