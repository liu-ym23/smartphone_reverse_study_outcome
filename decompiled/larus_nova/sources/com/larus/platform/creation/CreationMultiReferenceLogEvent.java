package com.larus.platform.creation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/creation/CreationMultiReferenceLogEvent;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RULE_PARSED", "ATTACHMENT_CHANGED", "RULE_CHECKED", "SWITCH_CHECKED", "UPLINK_BUILT", "FEED_DECODED", "DO_SAME_RESTORED", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationMultiReferenceLogEvent extends Enum<CreationMultiReferenceLogEvent> {
    public static final CreationMultiReferenceLogEvent ATTACHMENT_CHANGED = null;
    public static final CreationMultiReferenceLogEvent DO_SAME_RESTORED = null;
    public static final CreationMultiReferenceLogEvent FEED_DECODED = null;
    public static final CreationMultiReferenceLogEvent RULE_CHECKED = null;
    public static final CreationMultiReferenceLogEvent RULE_PARSED = null;
    public static final CreationMultiReferenceLogEvent SWITCH_CHECKED = null;
    public static final CreationMultiReferenceLogEvent UPLINK_BUILT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationMultiReferenceLogEvent[] f365334a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365335b = null;
    private final String value;

    public static EnumEntries<CreationMultiReferenceLogEvent> getEntries() {
        return f365335b;
    }

    static {
        CreationMultiReferenceLogEvent r100 = new CreationMultiReferenceLogEvent("RULE_PARSED", 0, "rule_parsed");
        RULE_PARSED = r100;
        CreationMultiReferenceLogEvent r101 = new CreationMultiReferenceLogEvent("ATTACHMENT_CHANGED", 1, "attachment_changed");
        ATTACHMENT_CHANGED = r101;
        CreationMultiReferenceLogEvent r102 = new CreationMultiReferenceLogEvent("RULE_CHECKED", 2, "rule_checked");
        RULE_CHECKED = r102;
        CreationMultiReferenceLogEvent r103 = new CreationMultiReferenceLogEvent("SWITCH_CHECKED", 3, "switch_checked");
        SWITCH_CHECKED = r103;
        CreationMultiReferenceLogEvent r104 = new CreationMultiReferenceLogEvent("UPLINK_BUILT", 4, "uplink_built");
        UPLINK_BUILT = r104;
        CreationMultiReferenceLogEvent r105 = new CreationMultiReferenceLogEvent("FEED_DECODED", 5, "feed_decoded");
        FEED_DECODED = r105;
        CreationMultiReferenceLogEvent r110 = new CreationMultiReferenceLogEvent("DO_SAME_RESTORED", 6, "do_same_restored");
        DO_SAME_RESTORED = r110;
        CreationMultiReferenceLogEvent[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f365334a = r111;
        f365335b = EnumEntriesKt.enumEntries(r111);
    }

    public static CreationMultiReferenceLogEvent[] values() {
        return (CreationMultiReferenceLogEvent[]) f365334a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationMultiReferenceLogEvent valueOf(String r100) {
        return (CreationMultiReferenceLogEvent) a.a(CreationMultiReferenceLogEvent.class, r100);
    }

    public CreationMultiReferenceLogEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
