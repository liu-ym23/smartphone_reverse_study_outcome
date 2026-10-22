package com.larus.bmhome.chat.block.base.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/ToolBlockInteractType;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "DisableHeaderInteract", "OpenFloatingPage", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToolBlockInteractType extends Enum<ToolBlockInteractType> {
    public static final ToolBlockInteractType Default = null;
    public static final ToolBlockInteractType DisableHeaderInteract = null;
    public static final ToolBlockInteractType OpenFloatingPage = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolBlockInteractType[] f297460a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297461b = null;

    public static EnumEntries<ToolBlockInteractType> getEntries() {
        return f297461b;
    }

    static {
        ToolBlockInteractType r100 = new ToolBlockInteractType("Default", 0);
        Default = r100;
        ToolBlockInteractType r101 = new ToolBlockInteractType("DisableHeaderInteract", 1);
        DisableHeaderInteract = r101;
        ToolBlockInteractType r102 = new ToolBlockInteractType("OpenFloatingPage", 2);
        OpenFloatingPage = r102;
        ToolBlockInteractType[] r103 = {r100, r101, r102};
        f297460a = r103;
        f297461b = EnumEntriesKt.enumEntries(r103);
    }

    public static ToolBlockInteractType[] values() {
        return (ToolBlockInteractType[]) f297460a.clone();
    }

    public static ToolBlockInteractType valueOf(String r100) {
        return (ToolBlockInteractType) a.a(ToolBlockInteractType.class, r100);
    }

    public ToolBlockInteractType(String r100, int r101) {
        super(r100, r101);
    }
}
