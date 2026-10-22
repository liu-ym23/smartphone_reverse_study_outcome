package com.larus.bmhome.chat.block.base.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/ToolBlockInitStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Fold", "Default", "Expand", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToolBlockInitStatus extends Enum<ToolBlockInitStatus> {
    public static final ToolBlockInitStatus Default = null;
    public static final ToolBlockInitStatus Expand = null;
    public static final ToolBlockInitStatus Fold = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolBlockInitStatus[] f297458a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297459b = null;

    public static EnumEntries<ToolBlockInitStatus> getEntries() {
        return f297459b;
    }

    static {
        ToolBlockInitStatus r100 = new ToolBlockInitStatus("Fold", 0);
        Fold = r100;
        ToolBlockInitStatus r101 = new ToolBlockInitStatus("Default", 1);
        Default = r101;
        ToolBlockInitStatus r102 = new ToolBlockInitStatus("Expand", 2);
        Expand = r102;
        ToolBlockInitStatus[] r103 = {r100, r101, r102};
        f297458a = r103;
        f297459b = EnumEntriesKt.enumEntries(r103);
    }

    public static ToolBlockInitStatus[] values() {
        return (ToolBlockInitStatus[]) f297458a.clone();
    }

    public static ToolBlockInitStatus valueOf(String r100) {
        return (ToolBlockInitStatus) a.a(ToolBlockInitStatus.class, r100);
    }

    public ToolBlockInitStatus(String r100, int r101) {
        super(r100, r101);
    }
}
