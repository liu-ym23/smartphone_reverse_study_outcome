package com.larus.mirabridge.api.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/mirabridge/api/bean/PluginDialogEvent;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW", "CLOSE", "SUCCESS", "FAILED", "RETRY", "BACKGROUND", "INTERNAL_FAILED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PluginDialogEvent extends Enum<PluginDialogEvent> {
    public static final PluginDialogEvent BACKGROUND = null;
    public static final PluginDialogEvent CLOSE = null;
    public static final PluginDialogEvent FAILED = null;
    public static final PluginDialogEvent INTERNAL_FAILED = null;
    public static final PluginDialogEvent RETRY = null;
    public static final PluginDialogEvent SHOW = null;
    public static final PluginDialogEvent SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginDialogEvent[] f359292a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359293b = null;

    public static EnumEntries<PluginDialogEvent> getEntries() {
        return f359293b;
    }

    static {
        PluginDialogEvent r100 = new PluginDialogEvent("SHOW", 0);
        SHOW = r100;
        PluginDialogEvent r101 = new PluginDialogEvent("CLOSE", 1);
        CLOSE = r101;
        PluginDialogEvent r102 = new PluginDialogEvent("SUCCESS", 2);
        SUCCESS = r102;
        PluginDialogEvent r103 = new PluginDialogEvent("FAILED", 3);
        FAILED = r103;
        PluginDialogEvent r104 = new PluginDialogEvent("RETRY", 4);
        RETRY = r104;
        PluginDialogEvent r105 = new PluginDialogEvent("BACKGROUND", 5);
        BACKGROUND = r105;
        PluginDialogEvent r110 = new PluginDialogEvent("INTERNAL_FAILED", 6);
        INTERNAL_FAILED = r110;
        PluginDialogEvent[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f359292a = r111;
        f359293b = EnumEntriesKt.enumEntries(r111);
    }

    public static PluginDialogEvent[] values() {
        return (PluginDialogEvent[]) f359292a.clone();
    }

    public static PluginDialogEvent valueOf(String r100) {
        return (PluginDialogEvent) a.a(PluginDialogEvent.class, r100);
    }

    public PluginDialogEvent(String r100, int r101) {
        super(r100, r101);
    }
}
