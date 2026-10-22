package com.bytedance.iesgurd.core;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/iesgurd/core/ReqType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", UserProfileEvent.POSITION_NONE, "REGISTER_LATE", EffectConstants.NORMAL, "POLLING", "BYTESYNC", "LAZY", "QUEUE", "CUSTOM_REQUEST", "UPDATE_BY_ACCESS", "UPDATE_BY_PRE_ACCESS", "PROBE", "CUSTOM_DOWNLOAD", "NEW_REQUEST_CUSTOM", "NEW_REQUEST_CONFIG", "NEW_PRE_UPDATE", "WAIT_UPDATE", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final enum ReqType extends Enum<ReqType> {
    private static final /* synthetic */ ReqType[] $VALUES = null;
    public static final ReqType BYTESYNC = null;
    public static final ReqType CUSTOM_DOWNLOAD = null;
    public static final ReqType CUSTOM_REQUEST = null;
    public static final ReqType LAZY = null;
    public static final ReqType NEW_PRE_UPDATE = null;
    public static final ReqType NEW_REQUEST_CONFIG = null;
    public static final ReqType NEW_REQUEST_CUSTOM = null;
    public static final ReqType NONE = null;
    public static final ReqType NORMAL = null;
    public static final ReqType POLLING = null;
    public static final ReqType PROBE = null;
    public static final ReqType QUEUE = null;
    public static final ReqType REGISTER_LATE = null;
    public static final ReqType UPDATE_BY_ACCESS = null;
    public static final ReqType UPDATE_BY_PRE_ACCESS = null;
    public static final ReqType WAIT_UPDATE = null;
    private final int type;

    public static ReqType valueOf(String r100) {
        return (ReqType) r27.a.a(ReqType.class, r100);
    }

    public static ReqType[] values() {
        return (ReqType[]) $VALUES.clone();
    }

    static {
        ReqType r100 = new ReqType(UserProfileEvent.POSITION_NONE, 0, -1);
        NONE = r100;
        ReqType r101 = new ReqType("REGISTER_LATE", 1, 0);
        REGISTER_LATE = r101;
        ReqType r102 = new ReqType(EffectConstants.NORMAL, 2, 1);
        NORMAL = r102;
        ReqType r103 = new ReqType("POLLING", 3, 3);
        POLLING = r103;
        ReqType r104 = new ReqType("BYTESYNC", 4, 4);
        BYTESYNC = r104;
        ReqType r105 = new ReqType("LAZY", 5, 5);
        LAZY = r105;
        ReqType r106 = new ReqType("QUEUE", 6, 6);
        QUEUE = r106;
        ReqType r107 = new ReqType("CUSTOM_REQUEST", 7, 7);
        CUSTOM_REQUEST = r107;
        ReqType r108 = new ReqType("UPDATE_BY_ACCESS", 8, 8);
        UPDATE_BY_ACCESS = r108;
        ReqType r109 = new ReqType("UPDATE_BY_PRE_ACCESS", 9, 9);
        UPDATE_BY_PRE_ACCESS = r109;
        ReqType r110 = new ReqType("PROBE", 10, 10);
        PROBE = r110;
        ReqType r111 = new ReqType("CUSTOM_DOWNLOAD", 11, 11);
        CUSTOM_DOWNLOAD = r111;
        ReqType r112 = new ReqType("NEW_REQUEST_CUSTOM", 12, 20);
        NEW_REQUEST_CUSTOM = r112;
        ReqType r113 = new ReqType("NEW_REQUEST_CONFIG", 13, 21);
        NEW_REQUEST_CONFIG = r113;
        ReqType r114 = new ReqType("NEW_PRE_UPDATE", 14, 22);
        NEW_PRE_UPDATE = r114;
        ReqType r115 = new ReqType("WAIT_UPDATE", 15, 23);
        WAIT_UPDATE = r115;
        $VALUES = new ReqType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115};
    }

    public final int getType() {
        return this.type;
    }

    private ReqType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
