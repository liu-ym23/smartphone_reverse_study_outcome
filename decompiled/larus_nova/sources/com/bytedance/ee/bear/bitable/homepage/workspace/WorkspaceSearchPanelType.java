package com.bytedance.ee.bear.bitable.homepage.workspace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/workspace/WorkspaceSearchPanelType;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "NewToWorkspace", "MoveInWorkspace", "ChangeWorkspace", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WorkspaceSearchPanelType extends Enum<WorkspaceSearchPanelType> {
    public static final WorkspaceSearchPanelType ChangeWorkspace = null;
    public static final WorkspaceSearchPanelType MoveInWorkspace = null;
    public static final WorkspaceSearchPanelType NewToWorkspace = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WorkspaceSearchPanelType[] f213125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f213126b = null;
    private final String scene;

    public static EnumEntries<WorkspaceSearchPanelType> getEntries() {
        return f213126b;
    }

    static {
        WorkspaceSearchPanelType r100 = new WorkspaceSearchPanelType("NewToWorkspace", 0, "new_to_workspace");
        NewToWorkspace = r100;
        WorkspaceSearchPanelType r101 = new WorkspaceSearchPanelType("MoveInWorkspace", 1, "move_in_workspace");
        MoveInWorkspace = r101;
        WorkspaceSearchPanelType r102 = new WorkspaceSearchPanelType("ChangeWorkspace", 2, "change_workspace");
        ChangeWorkspace = r102;
        WorkspaceSearchPanelType[] r103 = {r100, r101, r102};
        f213125a = r103;
        f213126b = EnumEntriesKt.enumEntries(r103);
    }

    public static WorkspaceSearchPanelType[] values() {
        return (WorkspaceSearchPanelType[]) f213125a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static WorkspaceSearchPanelType valueOf(String r100) {
        return (WorkspaceSearchPanelType) a.a(WorkspaceSearchPanelType.class, r100);
    }

    public WorkspaceSearchPanelType(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
