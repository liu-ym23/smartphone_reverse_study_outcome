package com.bytedance.bdp.appbase.service.protocol.aweme;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/bdp/appbase/service/protocol/aweme/AwemeUserInfoModel$VerifyType", "", "Lcom/bytedance/bdp/appbase/service/protocol/aweme/AwemeUserInfoModel$VerifyType;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, UserProfileEvent.POSITION_NONE, "PERSONAL", "ORGANIZATION", "MERCHANT", "bdp-appbase-ext_release"}, k = 1, mv = {1, 4, 0})
public final enum AwemeUserInfoModel$VerifyType extends Enum<AwemeUserInfoModel$VerifyType> {
    public static final a Companion = null;
    public static final AwemeUserInfoModel$VerifyType MERCHANT = null;
    public static final AwemeUserInfoModel$VerifyType NONE = null;
    public static final AwemeUserInfoModel$VerifyType ORGANIZATION = null;
    public static final AwemeUserInfoModel$VerifyType PERSONAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AwemeUserInfoModel$VerifyType[] f200961a = null;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.bdp.appbase.service.protocol.aweme.AwemeUserInfoModel$VerifyType$a] */
    static {
        AwemeUserInfoModel$VerifyType r100 = new AwemeUserInfoModel$VerifyType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        AwemeUserInfoModel$VerifyType r101 = new AwemeUserInfoModel$VerifyType("PERSONAL", 1);
        PERSONAL = r101;
        AwemeUserInfoModel$VerifyType r102 = new AwemeUserInfoModel$VerifyType("ORGANIZATION", 2);
        ORGANIZATION = r102;
        AwemeUserInfoModel$VerifyType r103 = new AwemeUserInfoModel$VerifyType("MERCHANT", 3);
        MERCHANT = r103;
        f200961a = new AwemeUserInfoModel$VerifyType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static AwemeUserInfoModel$VerifyType valueOf(String r100) {
        return (AwemeUserInfoModel$VerifyType) r27.a.a(AwemeUserInfoModel$VerifyType.class, r100);
    }

    public static AwemeUserInfoModel$VerifyType[] values() {
        return (AwemeUserInfoModel$VerifyType[]) f200961a.clone();
    }

    public AwemeUserInfoModel$VerifyType(String r100, int r101) {
        super(r100, r101);
    }
}
