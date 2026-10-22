package com.bytedance.bdp.serviceapi.hostimpl.aweme.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public final class AwemeAccountInfo {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/aweme/model/AwemeAccountInfo$VerifyType;", "", UserProfileEvent.POSITION_NONE, "PERSONAL", "ORGANIZATION", "MERCHANT", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
    public static final enum VerifyType extends Enum<VerifyType> {
        public static final VerifyType MERCHANT = null;
        public static final VerifyType NONE = null;
        public static final VerifyType ORGANIZATION = null;
        public static final VerifyType PERSONAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VerifyType[] f201600a = null;

        static {
            VerifyType r100 = new VerifyType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            VerifyType r101 = new VerifyType("PERSONAL", 1);
            PERSONAL = r101;
            VerifyType r102 = new VerifyType("ORGANIZATION", 2);
            ORGANIZATION = r102;
            VerifyType r103 = new VerifyType("MERCHANT", 3);
            MERCHANT = r103;
            f201600a = new VerifyType[]{r100, r101, r102, r103};
        }

        public static VerifyType valueOf(String r100) {
            return (VerifyType) a.a(VerifyType.class, r100);
        }

        public static VerifyType[] values() {
            return (VerifyType[]) f201600a.clone();
        }

        public VerifyType(String r100, int r101) {
            super(r100, r101);
        }
    }
}
