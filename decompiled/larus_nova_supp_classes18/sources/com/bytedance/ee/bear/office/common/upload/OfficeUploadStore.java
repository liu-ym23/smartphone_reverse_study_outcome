package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeUploadStore {
    public static final Handler a = null;
    public static final CopyOnWriteArraySet<Function1<List<u>, Unit>> b = null;
    public static final LinkedHashMap<String, h0> c = null;
    public static final b d = null;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
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
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public static void a() {
            Handler r0 = OfficeUploadStore.a;
            Collection<h0> r1 = OfficeUploadStore.c.values();
            boolean r2 = true;
            if (r1.isEmpty() == true) goto L14;
            Iterator<T> r3 = r1.iterator();
        L7:
            if (r3.hasNext() == false) goto L14;
            if (((h0) r3.next()).k != OfficeUploadStatus.FINISH) goto L11;
            boolean r4 = true;
        L12:
            if (r4 == true) goto L7;
            r2 = false;
            goto L14
        L11:
            r4 = false;
        L14:
            if (r2 == false) goto L22;
            OfficeUploadStore.c.clear();
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
        a = new Handler(Looper.getMainLooper());
        b = new CopyOnWriteArraySet();
        c = new LinkedHashMap();
        d = b.a;
    }

    public static final void a() {
        a.removeCallbacks(d);
        LinkedHashMap<String, h0> r0 = c;
        boolean r2 = true;
        if ((!r0.isEmpty()) == false) goto L24;
        Collection<h0> r1 = r0.values();
        if (r1.isEmpty() == true) goto L16;
        Iterator<T> r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L16;
        if (((h0) r3.next()).k != OfficeUploadStatus.FINISH) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L9;
        r2 = false;
        goto L16
    L13:
        r4 = false;
    L16:
        if (r2 == false) goto L25;
        a.postDelayed(d, BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL);
        return;
    L25:
        return;
    }

    public static List c() {
        Collection<h0> r0 = c.values();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        h0 r3 = (h0) r2.next();
        r3.getClass();
        String r4 = r3.a;
        String r5 = r3.e;
        OfficeUploadFileType.Companion.getClass();
        r1.add(new u(r4, r5, OfficeUploadFileType.a.a(r5), r3.k, r3.m, r3.g, r3.h));
        goto L4
    L6:
        return r1;
    }

    public static void d() {
        List r0 = c();
        Iterator<Function1<List<u>, Unit>> r1 = b.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().invoke(r0);
        goto L4
    }

    public static final String b(Collection r9) {
        return CollectionsKt.joinToString$default(r9, null, "[", "]", 4, null, OfficeUploadStore$toTraceSummary$1.INSTANCE, 17, null);
    }

    public static void e(Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        a.post(new a(r2));
    }

    public static void f(final String r1, final Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "localId");
        Intrinsics.checkNotNullParameter(r2, "reducer");
        e(new OfficeUploadStore$updateTask$1(r1, r2));
    }

    public static void g(final String r1, final Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "driveKey");
        Intrinsics.checkNotNullParameter(r2, "reducer");
        e(new OfficeUploadStore$updateTaskByDriveKey$1(r2, r1));
    }
}
