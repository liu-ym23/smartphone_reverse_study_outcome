package com.larus.voicecall.impl.bean;

import com.bytedance.ee.bear.bitable.celleditor.editor.location.LocationEditorModel;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/voicecall/impl/bean/RealtimeVlmLimitStatus;", "", "keyStr", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKeyStr", "()Ljava/lang/String;", LocationEditorModel.NOT_LIMIT, "DOWNGRADE", "REACH_DAILY_LIMIT", "REACH_SINGLE_TIME_LIMIT", "MUTE_TOO_LONG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealtimeVlmLimitStatus extends Enum<RealtimeVlmLimitStatus> {
    public static final RealtimeVlmLimitStatus DOWNGRADE = null;
    public static final RealtimeVlmLimitStatus MUTE_TOO_LONG = null;
    public static final RealtimeVlmLimitStatus NOT_LIMIT = null;
    public static final RealtimeVlmLimitStatus REACH_DAILY_LIMIT = null;
    public static final RealtimeVlmLimitStatus REACH_SINGLE_TIME_LIMIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealtimeVlmLimitStatus[] f377182a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377183b = null;
    private final String keyStr;

    public static EnumEntries<RealtimeVlmLimitStatus> getEntries() {
        return f377183b;
    }

    static {
        RealtimeVlmLimitStatus r100 = new RealtimeVlmLimitStatus(LocationEditorModel.NOT_LIMIT, 0, "not_limit");
        NOT_LIMIT = r100;
        RealtimeVlmLimitStatus r101 = new RealtimeVlmLimitStatus("DOWNGRADE", 1, GearStrategyConsts.EV_DOWNGRADE_TYPE);
        DOWNGRADE = r101;
        RealtimeVlmLimitStatus r102 = new RealtimeVlmLimitStatus("REACH_DAILY_LIMIT", 2, "reach_daily_limit");
        REACH_DAILY_LIMIT = r102;
        RealtimeVlmLimitStatus r103 = new RealtimeVlmLimitStatus("REACH_SINGLE_TIME_LIMIT", 3, "reach_single_time_limit");
        REACH_SINGLE_TIME_LIMIT = r103;
        RealtimeVlmLimitStatus r104 = new RealtimeVlmLimitStatus("MUTE_TOO_LONG", 4, "mute_overtime");
        MUTE_TOO_LONG = r104;
        RealtimeVlmLimitStatus[] r105 = {r100, r101, r102, r103, r104};
        f377182a = r105;
        f377183b = EnumEntriesKt.enumEntries(r105);
    }

    public static RealtimeVlmLimitStatus[] values() {
        return (RealtimeVlmLimitStatus[]) f377182a.clone();
    }

    public final String getKeyStr() {
        return this.keyStr;
    }

    public static RealtimeVlmLimitStatus valueOf(String r100) {
        return (RealtimeVlmLimitStatus) a.a(RealtimeVlmLimitStatus.class, r100);
    }

    public RealtimeVlmLimitStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.keyStr = r102;
    }
}
