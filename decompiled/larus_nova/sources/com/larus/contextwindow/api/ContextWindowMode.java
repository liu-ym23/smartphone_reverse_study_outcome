package com.larus.contextwindow.api;

import com.bytedance.ee.bear.bitable.plugin.more.BitableTitleMorePlugin;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/contextwindow/api/ContextWindowMode;", "", "<init>", "(Ljava/lang/String;I)V", "SUPPORTED", "CLOSE", BitableTitleMorePlugin.MENU_ID_BASE_MORE_PRO, "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextWindowMode extends Enum<ContextWindowMode> {
    public static final ContextWindowMode CLOSE = null;
    public static final ContextWindowMode PRO = null;
    public static final ContextWindowMode SUPPORTED = null;
    public static final ContextWindowMode UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContextWindowMode[] f330252a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330253b = null;

    public static EnumEntries<ContextWindowMode> getEntries() {
        return f330253b;
    }

    static {
        ContextWindowMode r100 = new ContextWindowMode("SUPPORTED", 0);
        SUPPORTED = r100;
        ContextWindowMode r101 = new ContextWindowMode("CLOSE", 1);
        CLOSE = r101;
        ContextWindowMode r102 = new ContextWindowMode(BitableTitleMorePlugin.MENU_ID_BASE_MORE_PRO, 2);
        PRO = r102;
        ContextWindowMode r103 = new ContextWindowMode("UNKNOWN", 3);
        UNKNOWN = r103;
        ContextWindowMode[] r104 = {r100, r101, r102, r103};
        f330252a = r104;
        f330253b = EnumEntriesKt.enumEntries(r104);
    }

    public static ContextWindowMode[] values() {
        return (ContextWindowMode[]) f330252a.clone();
    }

    public static ContextWindowMode valueOf(String r100) {
        return (ContextWindowMode) r27.a.a(ContextWindowMode.class, r100);
    }

    public ContextWindowMode(String r100, int r101) {
        super(r100, r101);
    }
}
