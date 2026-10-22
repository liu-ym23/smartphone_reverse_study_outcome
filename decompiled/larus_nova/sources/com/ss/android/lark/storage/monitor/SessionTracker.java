package com.ss.android.lark.storage.monitor;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.storage.file.statistics.FileMonitor;
import com.ss.android.lark.storage.monitor.SessionTracker.Session;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class SessionTracker<T extends Session> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<a<T>> f441098a;

    public static abstract class Session {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f441099a;

        public abstract void a();

        public final String toString() {
            return (String) this.f441099a.getValue();
        }

        public Session() {
            this.f441099a = LazyKt.lazy(new SessionTracker$Session$key$2(this));
        }
    }

    public static final class a<T extends Session> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f441100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a<T> f441101b;

        public a(FileMonitor.a r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f441100a = r100;
        }
    }

    public SessionTracker() {
        this.f441098a = new ThreadLocal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String b(FileMonitor.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newSession");
        a<T> r101 = this.f441098a.get();
        if (r101 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        final Ref.IntRef r103 = new Ref.IntRef();
        Function1<a<Session>, Unit> r104 = new SessionTracker$SessionNode$getLastNode$1(r102, r103);
        r104.invoke(r101);
    L5:
        r101 = r101.f441101b;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNull(r101);
        r104.invoke(r101);
        goto L5
    L9:
        if (r103.element <= 3) goto L11;
        b.a.b("UniStoreMonitor", "session node too depp, maybe something wrong!", null, 12);
    L11:
        T r105 = r102.element;
        Intrinsics.checkNotNull(r105);
        a<T> r106 = new a(r100);
        ((a) r105).f441101b = r106;
    L14:
        return (String) r100.f441099a.getValue();
    L12:
        this.f441098a.set(new a(r100));
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final String r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "block");
        a<T> r102 = this.f441098a.get();
        if (r102 == null) goto L23;
        Intrinsics.checkNotNullParameter(r100, "key");
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        Function1<a<Session>, Unit> r104 = new SessionTracker$SessionNode$getNodeByKey$1(r100, r103);
        r104.invoke(r102);
        a<T> r105 = r102;
    L5:
        r105 = r105.f441101b;
        if (r105 == null) goto L8;
        Intrinsics.checkNotNull(r105);
        r104.invoke(r105);
        goto L5
    L8:
        final a r106 = (a) r103.element;
        if (Intrinsics.areEqual(r106, r102) == false) goto L11;
        this.f441098a.set(null);
        r101.invoke(r106.f441100a);
        return;
    L11:
        if (r106 == null) goto L22;
        Intrinsics.checkNotNullParameter(r106, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        final Ref.BooleanRef r107 = new Ref.BooleanRef();
        Function1<a<Session>, Unit> r108 = new SessionTracker$SessionNode$closeChild$1(r106, r107);
        r108.invoke(r102);
    L13:
        r102 = r102.f441101b;
        if (r102 == null) goto L17;
        Intrinsics.checkNotNull(r102);
        r108.invoke(r102);
        goto L13
    L17:
        if (r107.element == true) goto L27;
        r106.f441100a.a();
        throw new IllegalStateException("close childe failed, node name: FileEventSession");
    L27:
        return;
    L22:
        throw new IllegalStateException("session not found of key ".concat(r100));
    }
}
