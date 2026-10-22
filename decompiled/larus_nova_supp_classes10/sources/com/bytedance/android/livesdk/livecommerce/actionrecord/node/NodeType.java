package com.bytedance.android.livesdk.livecommerce.actionrecord.node;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/actionrecord/node/NodeType;", "", "START", "INFO", "SINGLE_NODE", "ERROR", "FAILURE", "SUCCESS", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NodeType extends Enum<NodeType> {
    public static final NodeType ERROR = null;
    public static final NodeType FAILURE = null;
    public static final NodeType INFO = null;
    public static final NodeType SINGLE_NODE = null;
    public static final NodeType START = null;
    public static final NodeType SUCCESS = null;
    public static final /* synthetic */ NodeType[] a = null;

    static {
        NodeType r1 = new NodeType("START", 0);
        START = r1;
        NodeType r2 = new NodeType("INFO", 1);
        INFO = r2;
        NodeType r3 = new NodeType("SINGLE_NODE", 2);
        SINGLE_NODE = r3;
        NodeType r4 = new NodeType("ERROR", 3);
        ERROR = r4;
        NodeType r5 = new NodeType("FAILURE", 4);
        FAILURE = r5;
        NodeType r6 = new NodeType("SUCCESS", 5);
        SUCCESS = r6;
        a = new NodeType[]{r1, r2, r3, r4, r5, r6};
    }

    public static NodeType valueOf(String r1) {
        return (NodeType) a.a(NodeType.class, r1);
    }

    public static NodeType[] values() {
        return (NodeType[]) a.clone();
    }

    public NodeType(String r1, int r2) {
        super(r1, r2);
    }
}
