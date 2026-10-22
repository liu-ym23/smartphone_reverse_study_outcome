package iv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/larus/settings/provider/multitask/MultiTaskEntranceConfig;", "", "newChatNavEntry", "", "taskCenterSidebarEntry", "hideOngoingTasks", "taskSidebarPinEnabled", "sortWithPinTime", "creationDefaultPinEnabled", "<init>", "(ZZZZZZ)V", "getNewChatNavEntry", "()Z", "getTaskCenterSidebarEntry", "getHideOngoingTasks", "getTaskSidebarPinEnabled", "getSortWithPinTime", "getCreationDefaultPinEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("creation_default_pin_enabled")
    private final boolean creationDefaultPinEnabled;

    @SerializedName("hide_ongoing_tasks")
    private final boolean hideOngoingTasks;

    @SerializedName("new_chat_nav_entry")
    private final boolean newChatNavEntry;

    @SerializedName("sort_with_pin_time")
    private final boolean sortWithPinTime;

    @SerializedName("task_center_sidebar_entry")
    private final boolean taskCenterSidebarEntry;

    @SerializedName("task_sidebar_pin_enabled")
    private final boolean taskSidebarPinEnabled;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.newChatNavEntry == r101.newChatNavEntry) goto L12;
        return false;
    L12:
        if (this.taskCenterSidebarEntry == r101.taskCenterSidebarEntry) goto L15;
        return false;
    L15:
        if (this.hideOngoingTasks == r101.hideOngoingTasks) goto L18;
        return false;
    L18:
        if (this.taskSidebarPinEnabled == r101.taskSidebarPinEnabled) goto L21;
        return false;
    L21:
        if (this.sortWithPinTime == r101.sortWithPinTime) goto L24;
        return false;
    L24:
        if (this.creationDefaultPinEnabled == r101.creationDefaultPinEnabled) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.newChatNavEntry == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.taskCenterSidebarEntry == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.hideOngoingTasks == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.taskSidebarPinEnabled == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.sortWithPinTime == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.creationDefaultPinEnabled == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "MultiTaskEntranceConfig(newChatNavEntry=" + this.newChatNavEntry + ", taskCenterSidebarEntry=" + this.taskCenterSidebarEntry + ", hideOngoingTasks=" + this.hideOngoingTasks + ", taskSidebarPinEnabled=" + this.taskSidebarPinEnabled + ", sortWithPinTime=" + this.sortWithPinTime + ", creationDefaultPinEnabled=" + this.creationDefaultPinEnabled + ')';
    }

    public final boolean a() {
        return this.creationDefaultPinEnabled;
    }

    public final boolean b() {
        return this.hideOngoingTasks;
    }

    public final boolean c() {
        return this.newChatNavEntry;
    }

    public final boolean d() {
        return this.sortWithPinTime;
    }

    public final boolean e() {
        return this.taskCenterSidebarEntry;
    }

    public final boolean f() {
        return this.taskSidebarPinEnabled;
    }

    public a(int r100) {
        this.newChatNavEntry = false;
        this.taskCenterSidebarEntry = false;
        this.hideOngoingTasks = false;
        this.taskSidebarPinEnabled = false;
        this.sortWithPinTime = false;
        this.creationDefaultPinEnabled = false;
    }
}
