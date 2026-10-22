package com.ss.ugc.live.sdk.message.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/live/sdk/message/data/PayloadItemType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "PAYLOAD_TYPE_CLOSE", "PAYLOAD_TYPE_ACK", "PAYLOAD_TYPE_MSG", "PAYLOAD_TYPE_HEARTBEAT", "PAYLOAD_TYPE_HOST_ACK", "PAYLOAD_TYPE_UPLINK", "PAYLOAD_TYPE_UMGW", "PAYLOAD_TYPE_RECONNECT", "PAYLOAD_TYPE_UNKNOW", "message_release"}, k = 1, mv = {1, 4, 0})
public final enum PayloadItemType extends Enum<PayloadItemType> {
    public static final PayloadItemType PAYLOAD_TYPE_ACK = null;
    public static final PayloadItemType PAYLOAD_TYPE_CLOSE = null;
    public static final PayloadItemType PAYLOAD_TYPE_HEARTBEAT = null;
    public static final PayloadItemType PAYLOAD_TYPE_HOST_ACK = null;
    public static final PayloadItemType PAYLOAD_TYPE_MSG = null;
    public static final PayloadItemType PAYLOAD_TYPE_RECONNECT = null;
    public static final PayloadItemType PAYLOAD_TYPE_UMGW = null;
    public static final PayloadItemType PAYLOAD_TYPE_UNKNOW = null;
    public static final PayloadItemType PAYLOAD_TYPE_UPLINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PayloadItemType[] f458178a = null;
    private final String type;

    public static PayloadItemType valueOf(String r100) {
        return (PayloadItemType) a.a(PayloadItemType.class, r100);
    }

    public static PayloadItemType[] values() {
        return (PayloadItemType[]) f458178a.clone();
    }

    static {
        PayloadItemType r100 = new PayloadItemType("PAYLOAD_TYPE_CLOSE", 0, "close");
        PAYLOAD_TYPE_CLOSE = r100;
        PayloadItemType r101 = new PayloadItemType("PAYLOAD_TYPE_ACK", 1, "ack");
        PAYLOAD_TYPE_ACK = r101;
        PayloadItemType r102 = new PayloadItemType("PAYLOAD_TYPE_MSG", 2, "msg");
        PAYLOAD_TYPE_MSG = r102;
        PayloadItemType r103 = new PayloadItemType("PAYLOAD_TYPE_HEARTBEAT", 3, "hb");
        PAYLOAD_TYPE_HEARTBEAT = r103;
        PayloadItemType r104 = new PayloadItemType("PAYLOAD_TYPE_HOST_ACK", 4, "frontier_ack");
        PAYLOAD_TYPE_HOST_ACK = r104;
        PayloadItemType r105 = new PayloadItemType("PAYLOAD_TYPE_UPLINK", 5, "uplink_im_gateway");
        PAYLOAD_TYPE_UPLINK = r105;
        PayloadItemType r106 = new PayloadItemType("PAYLOAD_TYPE_UMGW", 6, "umgw");
        PAYLOAD_TYPE_UMGW = r106;
        PayloadItemType r107 = new PayloadItemType("PAYLOAD_TYPE_RECONNECT", 7, "reconnect");
        PAYLOAD_TYPE_RECONNECT = r107;
        PayloadItemType r108 = new PayloadItemType("PAYLOAD_TYPE_UNKNOW", 8, "unknow");
        PAYLOAD_TYPE_UNKNOW = r108;
        f458178a = new PayloadItemType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final String getType() {
        return this.type;
    }

    public PayloadItemType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
