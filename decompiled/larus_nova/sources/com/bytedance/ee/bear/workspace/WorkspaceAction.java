package com.bytedance.ee.bear.workspace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/workspace/WorkspaceAction;", "", "<init>", "(Ljava/lang/String;I)V", "Select", "MoveIn", "MoveOut", "MoveBetween", "NewTo", "docs-bitable-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WorkspaceAction extends Enum<WorkspaceAction> {
    public static final WorkspaceAction MoveBetween = null;
    public static final WorkspaceAction MoveIn = null;
    public static final WorkspaceAction MoveOut = null;
    public static final WorkspaceAction NewTo = null;
    public static final WorkspaceAction Select = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WorkspaceAction[] f242623a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242624b = null;

    public static EnumEntries<WorkspaceAction> getEntries() {
        return f242624b;
    }

    static {
        WorkspaceAction r100 = new WorkspaceAction("Select", 0);
        Select = r100;
        WorkspaceAction r101 = new WorkspaceAction("MoveIn", 1);
        MoveIn = r101;
        WorkspaceAction r102 = new WorkspaceAction("MoveOut", 2);
        MoveOut = r102;
        WorkspaceAction r103 = new WorkspaceAction("MoveBetween", 3);
        MoveBetween = r103;
        WorkspaceAction r104 = new WorkspaceAction("NewTo", 4);
        NewTo = r104;
        WorkspaceAction[] r105 = {r100, r101, r102, r103, r104};
        f242623a = r105;
        f242624b = EnumEntriesKt.enumEntries(r105);
    }

    public static WorkspaceAction[] values() {
        return (WorkspaceAction[]) f242623a.clone();
    }

    public static WorkspaceAction valueOf(String r100) {
        return (WorkspaceAction) a.a(WorkspaceAction.class, r100);
    }

    public WorkspaceAction(String r100, int r101) {
        super(r100, r101);
    }
}
