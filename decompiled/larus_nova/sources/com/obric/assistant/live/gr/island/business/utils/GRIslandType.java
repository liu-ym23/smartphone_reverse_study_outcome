package com.obric.assistant.live.gr.island.business.utils;

import com.larus.platform.model.NotificationBusiness;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/live/gr/island/business/utils/GRIslandType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COMPLEX_TASK", "REALTIME_CALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GRIslandType extends Enum<GRIslandType> {
    public static final GRIslandType COMPLEX_TASK = null;
    public static final GRIslandType REALTIME_CALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GRIslandType[] f390073a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f390074b = null;
    private final String value;

    public static EnumEntries<GRIslandType> getEntries() {
        return f390074b;
    }

    static {
        GRIslandType r100 = new GRIslandType("COMPLEX_TASK", 0, "complex_task");
        COMPLEX_TASK = r100;
        GRIslandType r101 = new GRIslandType("REALTIME_CALL", 1, NotificationBusiness.REALTIME_CALL);
        REALTIME_CALL = r101;
        GRIslandType[] r102 = {r100, r101};
        f390073a = r102;
        f390074b = EnumEntriesKt.enumEntries(r102);
    }

    public static GRIslandType[] values() {
        return (GRIslandType[]) f390073a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static GRIslandType valueOf(String r100) {
        return (GRIslandType) a.a(GRIslandType.class, r100);
    }

    public GRIslandType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
