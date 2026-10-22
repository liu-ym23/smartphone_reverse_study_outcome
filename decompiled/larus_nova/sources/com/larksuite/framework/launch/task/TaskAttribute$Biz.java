package com.larksuite.framework.launch.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/larksuite/framework/launch/task/TaskAttribute$Biz;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Messenger", "Search", "Calendar", "Docs", "Driver", "Mail", "OpenPlatform", "UserGrowth", "VideoConference", "Moments", "Core", "Todo", "launch-scheduler_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TaskAttribute$Biz extends Enum<TaskAttribute$Biz> {
    public static final TaskAttribute$Biz Calendar = null;
    public static final TaskAttribute$Biz Core = null;
    public static final TaskAttribute$Biz Docs = null;
    public static final TaskAttribute$Biz Driver = null;
    public static final TaskAttribute$Biz Mail = null;
    public static final TaskAttribute$Biz Messenger = null;
    public static final TaskAttribute$Biz Moments = null;
    public static final TaskAttribute$Biz OpenPlatform = null;
    public static final TaskAttribute$Biz Search = null;
    public static final TaskAttribute$Biz Todo = null;
    public static final TaskAttribute$Biz Unknown = null;
    public static final TaskAttribute$Biz UserGrowth = null;
    public static final TaskAttribute$Biz VideoConference = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskAttribute$Biz[] f285673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285674b = null;
    private final int value;

    public static EnumEntries<TaskAttribute$Biz> getEntries() {
        return f285674b;
    }

    static {
        TaskAttribute$Biz r100 = new TaskAttribute$Biz("Unknown", 0, 0);
        Unknown = r100;
        TaskAttribute$Biz r101 = new TaskAttribute$Biz("Messenger", 1, 1);
        Messenger = r101;
        TaskAttribute$Biz r102 = new TaskAttribute$Biz("Search", 2, 2);
        Search = r102;
        TaskAttribute$Biz r103 = new TaskAttribute$Biz("Calendar", 3, 3);
        Calendar = r103;
        TaskAttribute$Biz r104 = new TaskAttribute$Biz("Docs", 4, 4);
        Docs = r104;
        TaskAttribute$Biz r105 = new TaskAttribute$Biz("Driver", 5, 5);
        Driver = r105;
        TaskAttribute$Biz r110 = new TaskAttribute$Biz("Mail", 6, 6);
        Mail = r110;
        TaskAttribute$Biz r111 = new TaskAttribute$Biz("OpenPlatform", 7, 7);
        OpenPlatform = r111;
        TaskAttribute$Biz r112 = new TaskAttribute$Biz("UserGrowth", 8, 8);
        UserGrowth = r112;
        TaskAttribute$Biz r113 = new TaskAttribute$Biz("VideoConference", 9, 9);
        VideoConference = r113;
        TaskAttribute$Biz r114 = new TaskAttribute$Biz("Moments", 10, 10);
        Moments = r114;
        TaskAttribute$Biz r115 = new TaskAttribute$Biz("Core", 11, 11);
        Core = r115;
        TaskAttribute$Biz r106 = new TaskAttribute$Biz("Todo", 12, 12);
        Todo = r106;
        TaskAttribute$Biz[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        f285673a = r107;
        f285674b = EnumEntriesKt.enumEntries(r107);
    }

    public static TaskAttribute$Biz[] values() {
        return (TaskAttribute$Biz[]) f285673a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TaskAttribute$Biz valueOf(String r100) {
        return (TaskAttribute$Biz) a.a(TaskAttribute$Biz.class, r100);
    }

    public TaskAttribute$Biz(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
