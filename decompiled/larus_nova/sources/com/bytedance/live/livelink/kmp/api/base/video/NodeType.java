package com.bytedance.live.livelink.kmp.api.base.video;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/video/NodeType;", "", UserProfileEvent.POSITION_NONE, "PROVIDER", "PROCESSOR", "CONSUMER", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NodeType extends Enum<NodeType> {
    public static final NodeType CONSUMER = null;
    public static final NodeType NONE = null;
    public static final NodeType PROCESSOR = null;
    public static final NodeType PROVIDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NodeType[] f255226a = null;

    static {
        NodeType r100 = new NodeType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        NodeType r101 = new NodeType("PROVIDER", 1);
        PROVIDER = r101;
        NodeType r102 = new NodeType("PROCESSOR", 2);
        PROCESSOR = r102;
        NodeType r103 = new NodeType("CONSUMER", 3);
        CONSUMER = r103;
        f255226a = new NodeType[]{r100, r101, r102, r103};
    }

    public static NodeType valueOf(String r100) {
        return (NodeType) a.a(NodeType.class, r100);
    }

    public static NodeType[] values() {
        return (NodeType[]) f255226a.clone();
    }

    public NodeType(String r100, int r101) {
        super(r100, r101);
    }
}
