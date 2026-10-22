package com.bytedance.ies.bullet.service.base.init;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/init/TaskStyle;", "", "Async", "Sync", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum TaskStyle extends Enum<TaskStyle> {
    public static final TaskStyle Async = null;
    public static final TaskStyle Sync = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskStyle[] f247894a = null;

    public static TaskStyle valueOf(String r100) {
        return (TaskStyle) a.a(TaskStyle.class, r100);
    }

    public static TaskStyle[] values() {
        return (TaskStyle[]) f247894a.clone();
    }

    static {
        TaskStyle r100 = new TaskStyle("Async", 0);
        Async = r100;
        TaskStyle r101 = new TaskStyle("Sync", 1);
        Sync = r101;
        f247894a = new TaskStyle[]{r100, r101};
    }

    public TaskStyle(String r100, int r101) {
        super(r100, r101);
    }
}
