package com.larus.bmhome.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/ability/FloatChatWindowState;", "", "<init>", "(Ljava/lang/String;I)V", "Collapsed", "Preview", "Expanded", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FloatChatWindowState extends Enum<FloatChatWindowState> {
    public static final FloatChatWindowState Collapsed = null;
    public static final FloatChatWindowState Expanded = null;
    public static final FloatChatWindowState Preview = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FloatChatWindowState[] f294926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294927b = null;

    public static EnumEntries<FloatChatWindowState> getEntries() {
        return f294927b;
    }

    static {
        FloatChatWindowState r100 = new FloatChatWindowState("Collapsed", 0);
        Collapsed = r100;
        FloatChatWindowState r101 = new FloatChatWindowState("Preview", 1);
        Preview = r101;
        FloatChatWindowState r102 = new FloatChatWindowState("Expanded", 2);
        Expanded = r102;
        FloatChatWindowState[] r103 = {r100, r101, r102};
        f294926a = r103;
        f294927b = EnumEntriesKt.enumEntries(r103);
    }

    public static FloatChatWindowState[] values() {
        return (FloatChatWindowState[]) f294926a.clone();
    }

    public static FloatChatWindowState valueOf(String r100) {
        return (FloatChatWindowState) a.a(FloatChatWindowState.class, r100);
    }

    public FloatChatWindowState(String r100, int r101) {
        super(r100, r101);
    }
}
