package com.ss.android.lark.keyboard.base;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ChatAttachmentUploadProgressStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChatAttachmentUploadProgressStore f428213a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f428214b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ChatAttachmentUploadProgressStore$progresses$1 f428215c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Set<Function1<a, Unit>>> f428216d = null;

    public static final class a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            ((a) r100).getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "UploadProgress(progress=0, state=null)";
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<Function1<a, Unit>> f428217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f428218b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends Function1<? super a, Unit>> r100, a r101) {
            this.f428217a = r100;
            this.f428218b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<Function1<a, Unit>> r100 = this.f428217a;     // Catch: Throwable -> L7
            a r101 = this.f428218b;     // Catch: Throwable -> L7
            Iterator<T> r102 = r100.iterator();     // Catch: Throwable -> L7
        L4:
            if (r102.hasNext() == false) goto L16;
            ((Function1) r102.next()).invoke(r101);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public ChatAttachmentUploadProgressStore() {
    }

    static {
        f428213a = new ChatAttachmentUploadProgressStore();
        f428214b = new Handler(Looper.getMainLooper());
        f428215c = new ChatAttachmentUploadProgressStore$progresses$1();
        f428216d = new LinkedHashMap();
    }

    @JvmStatic
    public static final synchronized a a(String r100) {
        monitor-enter(ChatAttachmentUploadProgressStore.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        monitor-exit(ChatAttachmentUploadProgressStore.class);
        return null;
    L12:
        a r102 = (a) f428215c.get(r100);     // Catch: Throwable -> L15
        monitor-exit(ChatAttachmentUploadProgressStore.class);
        return r102;
    L7:
        r101 = false;
        goto L8
    }

    @JvmStatic
    public static final Function0<Unit> c(final String r100, final Function1<? super a, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "observer");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        r101.invoke(null);
        return ChatAttachmentUploadProgressStore$observe$1.INSTANCE;
    L9:
        ChatAttachmentUploadProgressStore r103 = f428213a;
        monitor-enter(r103);
        LinkedHashMap r104 = (LinkedHashMap) f428216d;     // Catch: Throwable -> L18
        Object r105 = r104.get(r100);     // Catch: Throwable -> L18
        if (r105 != null) goto L14;
        r105 = new LinkedHashSet();     // Catch: Throwable -> L18
        r104.put(r100, r105);     // Catch: Throwable -> L18
    L14:
        ((Set) r105).add(r101);     // Catch: Throwable -> L18
        monitor-exit(r103);
        r101.invoke(a(r100));
        return new ChatAttachmentUploadProgressStore$observe$3(r100, r101);
    L18:
        th = move-exception;
        throw th;
    L5:
        r102 = false;
        goto L6
    }

    private final synchronized void update(String r100, a r101) {
        monitor-enter(this);
        if (r100 != null) goto L19;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        f428215c.put(r100, r101);     // Catch: Throwable -> L8
        b(r100, r101);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    L19:
        if (r100.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    public final void b(String r100, a r101) {
        monitor-enter(this);
        Set r102 = (Set) ((LinkedHashMap) f428216d).get(r100);     // Catch: Throwable -> L15
        if (r102 == null) goto L6;
        List r103 = CollectionsKt.toList(r102);     // Catch: Throwable -> L15
    L7:
        if (r103 != null) goto L9;
        r103 = CollectionsKt.emptyList();     // Catch: Throwable -> L15
    L9:
        monitor-exit(this);
        if (r103.isEmpty() == false) goto L13;
        return;
    L13:
        f428214b.post(new b(r103, r101));
        return;
    L6:
        r103 = null;
    L15:
        th = move-exception;
        throw th;
    }
}
