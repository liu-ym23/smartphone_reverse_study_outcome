package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/cocreationreview/MainView;", "", "title", "", "dockLabel", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getDockLabel", "OVERVIEW", "REVIEW", "TASK_CENTER", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MainView extends Enum<MainView> {
    public static final MainView OVERVIEW = null;
    public static final MainView REVIEW = null;
    public static final MainView TASK_CENTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MainView[] f387146a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387147b = null;
    private final String dockLabel;
    private final String title;

    public static EnumEntries<MainView> getEntries() {
        return f387147b;
    }

    static {
        MainView r100 = new MainView("OVERVIEW", 0, "数据总览", "总览");
        OVERVIEW = r100;
        MainView r101 = new MainView("REVIEW", 1, "共创评测", "评测");
        REVIEW = r101;
        MainView r102 = new MainView("TASK_CENTER", 2, "任务中心", "任务");
        TASK_CENTER = r102;
        MainView[] r103 = {r100, r101, r102};
        f387146a = r103;
        f387147b = EnumEntriesKt.enumEntries(r103);
    }

    public static MainView[] values() {
        return (MainView[]) f387146a.clone();
    }

    public final String getDockLabel() {
        return this.dockLabel;
    }

    public final String getTitle() {
        return this.title;
    }

    public static MainView valueOf(String r100) {
        return (MainView) r27.a.a(MainView.class, r100);
    }

    public MainView(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.title = r102;
        this.dockLabel = r103;
    }
}
