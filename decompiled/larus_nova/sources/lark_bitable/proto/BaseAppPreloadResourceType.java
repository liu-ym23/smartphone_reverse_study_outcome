package lark_bitable.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum BaseAppPreloadResourceType extends Enum<BaseAppPreloadResourceType> implements WireEnum {
    private static final /* synthetic */ BaseAppPreloadResourceType[] $VALUES = null;
    public static final ProtoAdapter<BaseAppPreloadResourceType> ADAPTER = null;
    public static final BaseAppPreloadResourceType VAR_BASE_APP_PRELOAD_RESOURCE_TYPE_CLIENT_VARS = null;
    private final int value;

    static {
        BaseAppPreloadResourceType r100 = new BaseAppPreloadResourceType("VAR_BASE_APP_PRELOAD_RESOURCE_TYPE_CLIENT_VARS", 0, 0);
        VAR_BASE_APP_PRELOAD_RESOURCE_TYPE_CLIENT_VARS = r100;
        $VALUES = new BaseAppPreloadResourceType[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(BaseAppPreloadResourceType.class);
    }

    public static BaseAppPreloadResourceType[] values() {
        return (BaseAppPreloadResourceType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static BaseAppPreloadResourceType fromValue(int r100) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        return VAR_BASE_APP_PRELOAD_RESOURCE_TYPE_CLIENT_VARS;
    }

    public static BaseAppPreloadResourceType valueOf(String r100) {
        return (BaseAppPreloadResourceType) a.a(BaseAppPreloadResourceType.class, r100);
    }

    private BaseAppPreloadResourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
