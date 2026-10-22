package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/tasks/AsyncTaskExecutor;", ExifInterface.GPS_DIRECTION_TRUE, "", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AsyncTaskExecutor<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f450729e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<Future<TaskResult<T>>>> f450730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Boolean> f450731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Boolean> f450732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f450733d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/tasks/AsyncTaskExecutor$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "Config", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/tasks/AsyncTaskExecutor$Companion$Config;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Config {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Function4<Integer, Integer, Integer, Boolean, Boolean> f450734a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ExecutorService f450735b;

            public /* synthetic */ Config(ExecutorService r100) {
                this(AnonymousClass1.INSTANCE, r100, "async create");
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Config(Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Boolean> r100, ExecutorService r101, String r102) {
                Intrinsics.checkNotNullParameter(r100, "rejectAddTask");
                Intrinsics.checkNotNullParameter(r101, "executor");
                Intrinsics.checkNotNullParameter(r102, "name");
                this.f450734a = r100;
                this.f450735b = r101;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public final void c() {
        Iterator<T> r100 = this.f450730a.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        CopyOnWriteArrayList r101 = (CopyOnWriteArrayList) r100.next();
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((Future) r102.next()).cancel(true);
        goto L7
    L9:
        r101.clear();
        goto L4
    L10:
        this.f450730a.clear();
        this.f450731b.clear();
    }

    public AsyncTaskExecutor(Companion.Config r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f450730a = new ConcurrentHashMap();
        this.f450731b = new ConcurrentHashMap();
        this.f450732c = r100.f450734a;
        this.f450733d = r100.f450735b;
    }

    public final CopyOnWriteArrayList<Future<TaskResult<T>>> d(int r100) {
        CopyOnWriteArrayList<Future<TaskResult<T>>> r101 = this.f450730a.get(Integer.valueOf(r100));
        if (r101 != null) goto L6;
        CopyOnWriteArrayList<Future<TaskResult<T>>> r102 = new CopyOnWriteArrayList();
        this.f450730a.put(Integer.valueOf(r100), r102);
        return r102;
    L6:
        return r101;
    }

    public final int e(int r100) {
        CopyOnWriteArrayList<Future<TaskResult<T>>> r101 = this.f450730a.get(Integer.valueOf(r100));
        if (r101 == null) goto L22;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L16;
        T r104 = r103.next();
        Future r105 = (Future) r104;
        if (r105.isCancelled() == false) goto L10;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == false) goto L6;
        r102.add(r104);
        goto L6
    L10:
        if (r105.isDone() == true) goto L12;
        r106 = true;
        goto L13
    L16:
        return r102.size();
    L22:
        return 0;
    }

    public final void b(int r100, Future<TaskResult<T>> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.isDone() == false) goto L6;
    L8:
        CopyOnWriteArrayList<Future<TaskResult<T>>> r102 = d(r100);
        r102.remove(r101);
        r102.size();
        return;
    L6:
        if (r101.isCancelled() == true) goto L8;
        r101.cancel(true);
        goto L8
    }

    public final Future<TaskResult<T>> a(AsyncTask<T> r100, int r101, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "task");
    L18:
        return null;
    L4:
        if (this.f450733d.isShutdown() == false) goto L7;
        r100.c(new RuntimeException("executor is shutdown"));     // Catch: Throwable -> L18
        return null;
    L7:
        CopyOnWriteArrayList<Future<TaskResult<T>>> r102 = d(r101);     // Catch: Throwable -> L18
        int r103 = r102.size();     // Catch: Throwable -> L18
        int r104 = e(r101);     // Catch: Throwable -> L18
        if (r110 == false) goto L10;
    L13:
        String r105 = String.valueOf(r101);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r105, "<set-?>");     // Catch: Throwable -> L18
        r100.f450728a = r105;     // Catch: Throwable -> L18
        Future<TaskResult<T>> r106 = this.f450733d.submit(r100);     // Catch: Throwable -> L18
        if (r111 == false) goto L16;
        r102.add(new NoWaitFuture(r106));     // Catch: Throwable -> L18
    L17:
        return r106;
    L16:
        r102.add(r106);     // Catch: Throwable -> L18
        goto L17
    L10:
        if (this.f450732c.invoke(Integer.valueOf(r101), Integer.valueOf(r103), Integer.valueOf(r104), Boolean.valueOf(Intrinsics.areEqual(this.f450731b.get(Integer.valueOf(r101)), Boolean.TRUE))).booleanValue() == false) goto L13;
        r100.c(new RuntimeException("task rejected"));     // Catch: Throwable -> L18
        return null;
    }
}
