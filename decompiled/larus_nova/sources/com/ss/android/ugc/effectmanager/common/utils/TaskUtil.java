package com.ss.android.ugc.effectmanager.common.utils;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/utils/TaskUtil;", "", "()V", "id", "Ljava/util/concurrent/atomic/AtomicLong;", "generateTaskId", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class TaskUtil {
    public static final TaskUtil INSTANCE = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private static final AtomicLong f454371id = null;

    private TaskUtil() {
    }

    static {
        INSTANCE = new TaskUtil();
        f454371id = new AtomicLong(0);
    }

    public final String generateTaskId() {
        return String.valueOf(f454371id.incrementAndGet());
    }
}
