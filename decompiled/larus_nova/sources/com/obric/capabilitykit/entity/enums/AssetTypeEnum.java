package com.obric.capabilitykit.entity.enums;

import com.larus.bmhome.chat.bean.SuggestActionType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, SuggestActionType.PHOTO, "VIDEO", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final enum AssetTypeEnum extends Enum<AssetTypeEnum> {
    private static final /* synthetic */ AssetTypeEnum[] $VALUES = null;
    public static final a Companion = null;
    public static final AssetTypeEnum PHOTO = null;
    public static final AssetTypeEnum VIDEO = null;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ AssetTypeEnum[] $values() {
        return new AssetTypeEnum[]{PHOTO, VIDEO};
    }

    static {
        PHOTO = new AssetTypeEnum(SuggestActionType.PHOTO, 0);
        VIDEO = new AssetTypeEnum("VIDEO", 1);
        $VALUES = $values();
        Companion = new a();
    }

    private AssetTypeEnum(String r100, int r101) {
        super(r100, r101);
    }

    public static AssetTypeEnum valueOf(String r100) {
        return (AssetTypeEnum) r27.a.a(AssetTypeEnum.class, r100);
    }

    public static AssetTypeEnum[] values() {
        return (AssetTypeEnum[]) $VALUES.clone();
    }
}
