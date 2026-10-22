package inject_request.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum FetchInfoType extends Enum<FetchInfoType> implements WireEnum {
    private static final /* synthetic */ FetchInfoType[] $VALUES = null;
    public static final ProtoAdapter<FetchInfoType> ADAPTER = null;
    public static final FetchInfoType VAR_FETCH_INFO_TYPE_COOKIE = null;
    private final int value;

    static {
        FetchInfoType r100 = new FetchInfoType("VAR_FETCH_INFO_TYPE_COOKIE", 0, 0);
        VAR_FETCH_INFO_TYPE_COOKIE = r100;
        $VALUES = new FetchInfoType[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(FetchInfoType.class);
    }

    public static FetchInfoType[] values() {
        return (FetchInfoType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FetchInfoType fromValue(int r100) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        return VAR_FETCH_INFO_TYPE_COOKIE;
    }

    public static FetchInfoType valueOf(String r100) {
        return (FetchInfoType) a.a(FetchInfoType.class, r100);
    }

    private FetchInfoType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
