package com.larus.flowskill.impl.actionbar;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/larus/flowskill/impl/actionbar/TaskModeActionBarAction;", "", "action", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "OPEN", "FOLDER", FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID, "CANCEL", "CONNECTOR", "MERGED_DEVICE_FOLDER", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskModeActionBarAction extends Enum<TaskModeActionBarAction> {
    public static final TaskModeActionBarAction CANCEL = null;
    public static final TaskModeActionBarAction CONNECTOR = null;
    public static final a Companion = null;
    public static final TaskModeActionBarAction DEVICE = null;
    public static final TaskModeActionBarAction FOLDER = null;
    public static final TaskModeActionBarAction MERGED_DEVICE_FOLDER = null;
    public static final TaskModeActionBarAction OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskModeActionBarAction[] f343473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f343474b = null;
    private final String action;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<TaskModeActionBarAction> getEntries() {
        return f343474b;
    }

    static {
        TaskModeActionBarAction r100 = new TaskModeActionBarAction("OPEN", 0, "open");
        OPEN = r100;
        TaskModeActionBarAction r101 = new TaskModeActionBarAction("FOLDER", 1, DocumentType.FOLDER_NAME);
        FOLDER = r101;
        TaskModeActionBarAction r102 = new TaskModeActionBarAction(FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID, 2, "device");
        DEVICE = r102;
        TaskModeActionBarAction r103 = new TaskModeActionBarAction("CANCEL", 3, "cancel");
        CANCEL = r103;
        TaskModeActionBarAction r104 = new TaskModeActionBarAction("CONNECTOR", 4, "connector");
        CONNECTOR = r104;
        TaskModeActionBarAction r105 = new TaskModeActionBarAction("MERGED_DEVICE_FOLDER", 5, "merged_device_folder");
        MERGED_DEVICE_FOLDER = r105;
        TaskModeActionBarAction[] r110 = {r100, r101, r102, r103, r104, r105};
        f343473a = r110;
        f343474b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static TaskModeActionBarAction[] values() {
        return (TaskModeActionBarAction[]) f343473a.clone();
    }

    public final String getAction() {
        return this.action;
    }

    public static TaskModeActionBarAction valueOf(String r100) {
        return (TaskModeActionBarAction) r27.a.a(TaskModeActionBarAction.class, r100);
    }

    public TaskModeActionBarAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.action = r102;
    }
}
