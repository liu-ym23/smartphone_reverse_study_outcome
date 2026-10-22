package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/im/bean/message/block/ArtifactAction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "CREATE", "STR_REPLACE", "REFINE", "READ", "DELETE", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ArtifactAction extends Enum<ArtifactAction> {
    public static final ArtifactAction CREATE = null;
    public static final ArtifactAction DELETE = null;
    public static final ArtifactAction READ = null;
    public static final ArtifactAction REFINE = null;
    public static final ArtifactAction STR_REPLACE = null;
    public static final ArtifactAction UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArtifactAction[] f346773a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346774b = null;
    private final int value;

    public static EnumEntries<ArtifactAction> getEntries() {
        return f346774b;
    }

    static {
        ArtifactAction r100 = new ArtifactAction("UNDEFINED", 0, 0);
        UNDEFINED = r100;
        ArtifactAction r101 = new ArtifactAction("CREATE", 1, 1);
        CREATE = r101;
        ArtifactAction r102 = new ArtifactAction("STR_REPLACE", 2, 2);
        STR_REPLACE = r102;
        ArtifactAction r103 = new ArtifactAction("REFINE", 3, 3);
        REFINE = r103;
        ArtifactAction r104 = new ArtifactAction("READ", 4, 4);
        READ = r104;
        ArtifactAction r105 = new ArtifactAction("DELETE", 5, 5);
        DELETE = r105;
        ArtifactAction[] r110 = {r100, r101, r102, r103, r104, r105};
        f346773a = r110;
        f346774b = EnumEntriesKt.enumEntries(r110);
    }

    public static ArtifactAction[] values() {
        return (ArtifactAction[]) f346773a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ArtifactAction valueOf(String r100) {
        return (ArtifactAction) a.a(ArtifactAction.class, r100);
    }

    public ArtifactAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
