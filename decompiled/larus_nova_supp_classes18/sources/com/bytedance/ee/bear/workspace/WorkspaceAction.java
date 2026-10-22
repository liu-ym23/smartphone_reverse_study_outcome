package com.bytedance.ee.bear.workspace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/workspace/WorkspaceAction;", "", "<init>", "(Ljava/lang/String;I)V", "Select", "MoveIn", "MoveOut", "MoveBetween", "NewTo", "docs-bitable-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WorkspaceAction extends Enum<WorkspaceAction> {
    public static final WorkspaceAction MoveBetween = null;
    public static final WorkspaceAction MoveIn = null;
    public static final WorkspaceAction MoveOut = null;
    public static final WorkspaceAction NewTo = null;
    public static final WorkspaceAction Select = null;
    public static final /* synthetic */ WorkspaceAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WorkspaceAction> getEntries() {
        return b;
    }

    static {
        WorkspaceAction r0 = new WorkspaceAction("Select", 0);
        Select = r0;
        WorkspaceAction r1 = new WorkspaceAction("MoveIn", 1);
        MoveIn = r1;
        WorkspaceAction r3 = new WorkspaceAction("MoveOut", 2);
        MoveOut = r3;
        WorkspaceAction r5 = new WorkspaceAction("MoveBetween", 3);
        MoveBetween = r5;
        WorkspaceAction r7 = new WorkspaceAction("NewTo", 4);
        NewTo = r7;
        WorkspaceAction[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static WorkspaceAction[] values() {
        return (WorkspaceAction[]) a.clone();
    }

    public static WorkspaceAction valueOf(String r1) {
        return (WorkspaceAction) a.a(WorkspaceAction.class, r1);
    }

    public WorkspaceAction(String r1, int r2) {
        super(r1, r2);
    }
}
