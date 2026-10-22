package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks;

import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/tasks/AsyncTask;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/Callable;", "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/tasks/TaskResult;", NotificationCompat.CATEGORY_CALL, "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AsyncTask<T> implements Callable<TaskResult<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f450728a;

    public void a() {
    }

    public void b() {
    }

    @Override // java.util.concurrent.Callable
    public TaskResult<T> call() {
        T r100 = null;
        SystemClock.uptimeMillis();     // Catch: Exception -> L5
        b();     // Catch: Exception -> L5
        T r101 = d();     // Catch: Exception -> L5
        a();     // Catch: Exception -> L5
        SystemClock.uptimeMillis();     // Catch: Exception -> L5
        int r102 = 0;
        e = null;
        r100 = r101;
    L8:
        return new TaskResult(r100, r102, e, this.f450728a);
    L5:
        e = e;
        c(e);
        r102 = 1;
        goto L8
    }

    public T d() {
        return null;
    }

    public AsyncTask() {
        this.f450728a = "AsyncTask";
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    public void c(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }
}
