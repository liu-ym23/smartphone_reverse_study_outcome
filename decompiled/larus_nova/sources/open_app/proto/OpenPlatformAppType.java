package open_app.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum OpenPlatformAppType extends Enum<OpenPlatformAppType> implements WireEnum {
    private static final /* synthetic */ OpenPlatformAppType[] $VALUES = null;
    public static final ProtoAdapter<OpenPlatformAppType> ADAPTER = null;
    public static final OpenPlatformAppType VAR_OPEN_PLATFORM_APP_TYPE_GADGET_APP = null;
    public static final OpenPlatformAppType VAR_OPEN_PLATFORM_APP_TYPE_WEB_APP = null;
    private final int value;

    static {
        OpenPlatformAppType r100 = new OpenPlatformAppType("VAR_OPEN_PLATFORM_APP_TYPE_GADGET_APP", 0, 0);
        VAR_OPEN_PLATFORM_APP_TYPE_GADGET_APP = r100;
        OpenPlatformAppType r101 = new OpenPlatformAppType("VAR_OPEN_PLATFORM_APP_TYPE_WEB_APP", 1, 1);
        VAR_OPEN_PLATFORM_APP_TYPE_WEB_APP = r101;
        $VALUES = new OpenPlatformAppType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(OpenPlatformAppType.class);
    }

    public static OpenPlatformAppType[] values() {
        return (OpenPlatformAppType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static OpenPlatformAppType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return VAR_OPEN_PLATFORM_APP_TYPE_WEB_APP;
    L10:
        return VAR_OPEN_PLATFORM_APP_TYPE_GADGET_APP;
    }

    public static OpenPlatformAppType valueOf(String r100) {
        return (OpenPlatformAppType) a.a(OpenPlatformAppType.class, r100);
    }

    private OpenPlatformAppType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
