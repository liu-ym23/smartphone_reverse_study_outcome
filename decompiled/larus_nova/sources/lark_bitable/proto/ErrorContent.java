package lark_bitable.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum ErrorContent extends Enum<ErrorContent> implements WireEnum {
    private static final /* synthetic */ ErrorContent[] $VALUES = null;
    public static final ProtoAdapter<ErrorContent> ADAPTER = null;
    public static final ErrorContent VAR_ERROR_CONTENT_NO_CONTENT = null;
    public static final ErrorContent VAR_ERROR_CONTENT_NO_PERMISSION = null;
    private final int value;

    static {
        ErrorContent r100 = new ErrorContent("VAR_ERROR_CONTENT_NO_PERMISSION", 0, 0);
        VAR_ERROR_CONTENT_NO_PERMISSION = r100;
        ErrorContent r101 = new ErrorContent("VAR_ERROR_CONTENT_NO_CONTENT", 1, 1);
        VAR_ERROR_CONTENT_NO_CONTENT = r101;
        $VALUES = new ErrorContent[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(ErrorContent.class);
    }

    public static ErrorContent[] values() {
        return (ErrorContent[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ErrorContent fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return VAR_ERROR_CONTENT_NO_CONTENT;
    L10:
        return VAR_ERROR_CONTENT_NO_PERMISSION;
    }

    public static ErrorContent valueOf(String r100) {
        return (ErrorContent) a.a(ErrorContent.class, r100);
    }

    private ErrorContent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
