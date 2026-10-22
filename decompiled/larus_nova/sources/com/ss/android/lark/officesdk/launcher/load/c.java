package com.ss.android.lark.officesdk.launcher.load;

import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.ss.android.lark.log.Log;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Class<? extends ILaunchTask<?>>, ILaunchTask<?>> f433470a;

    public static final class a {
    }

    static {
    }

    public c() {
        this.f433470a = new LinkedHashMap();
    }

    public final void a(AbstractLaunchTask r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Log.i("OfficeLoadTaskCollector", "[office load] add task: " + r100.f());
        this.f433470a.put((Class<? extends ILaunchTask<?>>) r100.getClass(), r100);
    }
}
