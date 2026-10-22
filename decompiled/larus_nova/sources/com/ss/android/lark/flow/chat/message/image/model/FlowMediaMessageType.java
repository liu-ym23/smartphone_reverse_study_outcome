package com.ss.android.lark.flow.chat.message.image.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/image/model/FlowMediaMessageType;", "", "<init>", "(Ljava/lang/String;I)V", "Lark", "Doubao", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowMediaMessageType extends Enum<FlowMediaMessageType> {
    public static final FlowMediaMessageType Doubao = null;
    public static final FlowMediaMessageType Lark = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowMediaMessageType[] f422593a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f422594b = null;

    public static EnumEntries<FlowMediaMessageType> getEntries() {
        return f422594b;
    }

    static {
        FlowMediaMessageType r100 = new FlowMediaMessageType("Lark", 0);
        Lark = r100;
        FlowMediaMessageType r101 = new FlowMediaMessageType("Doubao", 1);
        Doubao = r101;
        FlowMediaMessageType[] r102 = {r100, r101};
        f422593a = r102;
        f422594b = EnumEntriesKt.enumEntries(r102);
    }

    public static FlowMediaMessageType[] values() {
        return (FlowMediaMessageType[]) f422593a.clone();
    }

    public static FlowMediaMessageType valueOf(String r100) {
        return (FlowMediaMessageType) a.a(FlowMediaMessageType.class, r100);
    }

    public FlowMediaMessageType(String r100, int r101) {
        super(r100, r101);
    }
}
