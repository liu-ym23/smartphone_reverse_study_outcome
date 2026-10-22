package com.ss.android.lark.api.bean;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/api/bean/NodePieceCustomState;", "", "<init>", "(Ljava/lang/String;I)V", "COVERED_BY_FORSETI", EffectConstants.NORMAL, "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NodePieceCustomState extends Enum<NodePieceCustomState> {
    public static final NodePieceCustomState COVERED_BY_FORSETI = null;
    public static final NodePieceCustomState NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NodePieceCustomState[] f408659a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408660b = null;

    public static EnumEntries<NodePieceCustomState> getEntries() {
        return f408660b;
    }

    static {
        NodePieceCustomState r100 = new NodePieceCustomState("COVERED_BY_FORSETI", 0);
        COVERED_BY_FORSETI = r100;
        NodePieceCustomState r101 = new NodePieceCustomState(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        NodePieceCustomState[] r102 = {r100, r101};
        f408659a = r102;
        f408660b = EnumEntriesKt.enumEntries(r102);
    }

    public static NodePieceCustomState[] values() {
        return (NodePieceCustomState[]) f408659a.clone();
    }

    public static NodePieceCustomState valueOf(String r100) {
        return (NodePieceCustomState) a.a(NodePieceCustomState.class, r100);
    }

    public NodePieceCustomState(String r100, int r101) {
        super(r100, r101);
    }
}
