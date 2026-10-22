package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeUploadStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f235310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<Function1<List<u>, Unit>> f235311b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap<String, h0> f235312c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f235313d = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f235314a;

        public a(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f235314a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f235314a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f235315a = null;

        static {
            f235315a = new b();
        }

        public b() {
        }

        public static void a() {
            Handler r100 = OfficeUploadStore.f235310a;
            Collection<h0> r101 = OfficeUploadStore.f235312c.values();
            boolean r102 = true;
            if (r101.isEmpty() == true) goto L14;
            Iterator<T> r103 = r101.iterator();
        L7:
            if (r103.hasNext() == false) goto L14;
            if (((h0) r103.next()).f235383k != OfficeUploadStatus.FINISH) goto L11;
            boolean r104 = true;
        L12:
            if (r104 == true) goto L7;
            r102 = false;
            goto L14
        L11:
            r104 = false;
        L14:
            if (r102 == false) goto L22;
            OfficeUploadStore.f235312c.clear();
            OfficeUploadStore.d();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public OfficeUploadStore() {
    }

    static {
        f235310a = new Handler(Looper.getMainLooper());
        f235311b = new CopyOnWriteArraySet();
        f235312c = new LinkedHashMap();
        f235313d = b.f235315a;
    }

    public static final void a() {
        f235310a.removeCallbacks(f235313d);
        LinkedHashMap<String, h0> r100 = f235312c;
        boolean r101 = true;
        if ((!r100.isEmpty()) == false) goto L24;
        Collection<h0> r102 = r100.values();
        if (r102.isEmpty() == true) goto L16;
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L16;
        if (((h0) r103.next()).f235383k != OfficeUploadStatus.FINISH) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L9;
        r101 = false;
        goto L16
    L13:
        r104 = false;
    L16:
        if (r101 == false) goto L25;
        f235310a.postDelayed(f235313d, 2000);
        return;
    L25:
        return;
    }

    public static List c() {
        Collection<h0> r100 = f235312c.values();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        h0 r103 = (h0) r102.next();
        r103.getClass();
        String r104 = r103.f235373a;
        String r105 = r103.f235377e;
        OfficeUploadFileType.Companion.getClass();
        r101.add(new u(r104, r105, OfficeUploadFileType.a.a(r105), r103.f235383k, r103.f235385m, r103.f235379g, r103.f235380h));
        goto L4
    L6:
        return r101;
    }

    public static void d() {
        List<u> r100 = c();
        Iterator<Function1<List<u>, Unit>> r101 = f235311b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().invoke(r100);
        goto L4
    }

    public static final String b(Collection r100) {
        return CollectionsKt.joinToString$default(r100, null, "[", "]", 4, null, OfficeUploadStore$toTraceSummary$1.INSTANCE, 17, null);
    }

    public static void e(Function0 r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        f235310a.post(new a(r100));
    }

    public static void f(final String r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "localId");
        Intrinsics.checkNotNullParameter(r101, "reducer");
        e(new OfficeUploadStore$updateTask$1(r100, r101));
    }

    public static void g(final String r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "driveKey");
        Intrinsics.checkNotNullParameter(r101, "reducer");
        e(new OfficeUploadStore$updateTaskByDriveKey$1(r101, r100));
    }
}
