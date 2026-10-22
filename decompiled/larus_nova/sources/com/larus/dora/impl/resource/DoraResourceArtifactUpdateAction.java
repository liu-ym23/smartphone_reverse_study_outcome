package com.larus.dora.impl.resource;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/resource/DoraResourceArtifactUpdateAction;", "", "<init>", "(Ljava/lang/String;I)V", "INSTALL", "UNCHANGED", "KEEP_ACTIVE", "INVALID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraResourceArtifactUpdateAction extends Enum<DoraResourceArtifactUpdateAction> {
    public static final DoraResourceArtifactUpdateAction INSTALL = null;
    public static final DoraResourceArtifactUpdateAction INVALID = null;
    public static final DoraResourceArtifactUpdateAction KEEP_ACTIVE = null;
    public static final DoraResourceArtifactUpdateAction UNCHANGED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraResourceArtifactUpdateAction[] f337815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f337816b = null;

    public static EnumEntries<DoraResourceArtifactUpdateAction> getEntries() {
        return f337816b;
    }

    static {
        DoraResourceArtifactUpdateAction r100 = new DoraResourceArtifactUpdateAction("INSTALL", 0);
        INSTALL = r100;
        DoraResourceArtifactUpdateAction r101 = new DoraResourceArtifactUpdateAction("UNCHANGED", 1);
        UNCHANGED = r101;
        DoraResourceArtifactUpdateAction r102 = new DoraResourceArtifactUpdateAction("KEEP_ACTIVE", 2);
        KEEP_ACTIVE = r102;
        DoraResourceArtifactUpdateAction r103 = new DoraResourceArtifactUpdateAction("INVALID", 3);
        INVALID = r103;
        DoraResourceArtifactUpdateAction[] r104 = {r100, r101, r102, r103};
        f337815a = r104;
        f337816b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraResourceArtifactUpdateAction[] values() {
        return (DoraResourceArtifactUpdateAction[]) f337815a.clone();
    }

    public static DoraResourceArtifactUpdateAction valueOf(String r100) {
        return (DoraResourceArtifactUpdateAction) r27.a.a(DoraResourceArtifactUpdateAction.class, r100);
    }

    public DoraResourceArtifactUpdateAction(String r100, int r101) {
        super(r100, r101);
    }
}
