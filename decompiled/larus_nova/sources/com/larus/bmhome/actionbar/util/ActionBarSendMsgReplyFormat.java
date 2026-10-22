package com.larus.bmhome.actionbar.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/actionbar/util/ActionBarSendMsgReplyFormat;", "", "<init>", "(Ljava/lang/String;I)V", "REPLICA_REPLY", "REPLICA_GENERATING", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarSendMsgReplyFormat extends Enum<ActionBarSendMsgReplyFormat> {
    public static final ActionBarSendMsgReplyFormat REPLICA_GENERATING = null;
    public static final ActionBarSendMsgReplyFormat REPLICA_REPLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionBarSendMsgReplyFormat[] f295656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f295657b = null;

    public static EnumEntries<ActionBarSendMsgReplyFormat> getEntries() {
        return f295657b;
    }

    static {
        ActionBarSendMsgReplyFormat r100 = new ActionBarSendMsgReplyFormat("REPLICA_REPLY", 0);
        REPLICA_REPLY = r100;
        ActionBarSendMsgReplyFormat r101 = new ActionBarSendMsgReplyFormat("REPLICA_GENERATING", 1);
        REPLICA_GENERATING = r101;
        ActionBarSendMsgReplyFormat[] r102 = {r100, r101};
        f295656a = r102;
        f295657b = EnumEntriesKt.enumEntries(r102);
    }

    public static ActionBarSendMsgReplyFormat[] values() {
        return (ActionBarSendMsgReplyFormat[]) f295656a.clone();
    }

    public static ActionBarSendMsgReplyFormat valueOf(String r100) {
        return (ActionBarSendMsgReplyFormat) r27.a.a(ActionBarSendMsgReplyFormat.class, r100);
    }

    public ActionBarSendMsgReplyFormat(String r100, int r101) {
        super(r100, r101);
    }
}
