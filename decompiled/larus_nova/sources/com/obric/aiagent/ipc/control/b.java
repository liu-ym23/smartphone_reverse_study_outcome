package com.obric.aiagent.ipc.control;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import com.obric.aiagent.ipc.utils.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import n9a.i;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b<P, S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b<Intent, IBinder>> f384694b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f384695a;

    public interface a<S> {
        void a();

        void b(S r100);

        void onDestroy();
    }

    /* JADX INFO: renamed from: com.obric.aiagent.ipc.control.b$b, reason: collision with other inner class name */
    public static final class C4585b {
        public static Intent a(Context r100, Intent r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "intent");
            if (r101.getComponent() == null) goto L6;
            return r101;
        L6:
            if (r101.getPackage() == null) goto L8;
            return r101;
        L8:
            List<ResolveInfo> r102 = r100.getPackageManager().queryIntentServices(r101, 0);
            if (r102.isEmpty() == false) goto L12;
            return null;
        L12:
            Intent r103 = new Intent(r101);
            r103.setPackage(((ResolveInfo) CollectionsKt.first(r102)).serviceInfo.packageName);
            return r103;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [com.obric.aiagent.ipc.control.c] */
        public static b b(final Context r110, final Intent r111, com.obric.aiagent.ipc.control.a r112) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "intent");
            Intent r100 = a(r110, r111);
            if (r100 == null) goto L6;
            r111 = r100;
        L6:
            ComponentName r101 = r111.getComponent();
            if (r101 == null) goto L9;
            String r102 = "cmp:" + r101.flattenToString();
        L17:
            Context r103 = r110.getApplicationContext();
            if (r103 == null) goto L21;
            r110 = r103;
        L21:
            ConcurrentHashMap<String, b<Intent, IBinder>> r104 = b.f384694b;
            final ?? r105 = new com.obric.aiagent.ipc.control.c(r110, r111);
            b<Intent, IBinder> r113 = r104.computeIfAbsent(r102, new d(r105));
            if (r112 != null) goto L24;
        L36:
            return r113;
        L24:
            if ((r113 instanceof BinderControl) == false) goto L26;
            BinderControl r114 = (BinderControl) r113;
        L27:
            if (r114 == null) goto L36;
            Intrinsics.checkNotNullParameter(r112, "newConfig");
            monitor-enter(r114);
            long r106 = RangesKt.coerceAtLeast(r112.f384691a, 1);     // Catch: Throwable -> L33
            long r107 = RangesKt.coerceAtLeast(r112.f384692b, 1000);     // Catch: Throwable -> L33
            long r108 = RangesKt.coerceAtLeast(r112.f384693c, 200);     // Catch: Throwable -> L33
            r114.f384687o = new com.obric.aiagent.ipc.control.a(r106, r107, r108);     // Catch: Throwable -> L33
            r114.f384685m = RangesKt.coerceAtMost(r114.f384685m, r108);     // Catch: Throwable -> L33
            r114.f384686n = RangesKt.coerceAtMost(r114.f384686n, r114.f384687o.f384692b);     // Catch: Throwable -> L33
            int r115 = e.f384738a;     // Catch: Throwable -> L33
            e.a("IPCControl", "updateConfig: " + r114.f384687o);     // Catch: Throwable -> L33
            Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L33
            monitor-exit(r114);
        L33:
            th = move-exception;
            throw th;
        L26:
            r114 = null;
            goto L27
        L9:
            StringBuilder r109 = new StringBuilder("act:");
            String r117 = r111.getAction();
            String r118 = "";
            if (r117 != null) goto L12;
            r117 = "";
        L12:
            r109.append(r117);
            r109.append("|pkg:");
            String r119 = r111.getPackage();
            if (r119 == null) goto L16;
            r118 = r119;
        L16:
            r109.append(r118);
            r102 = r109.toString();
            goto L17
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f384696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f384697b;

        public /* synthetic */ c() {
            this(true, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f384696a == r101.f384696a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f384697b, r101.f384697b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f384696a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f384697b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "CreateResult(isSuccess=" + this.f384696a + ", errMsg=" + this.f384697b + ')';
        }

        public c(boolean r100, String r101) {
            this.f384696a = r100;
            this.f384697b = r101;
        }
    }

    public abstract c a(boolean r100);

    public abstract c b(i.a r100);

    public abstract c c();

    static {
        f384694b = new ConcurrentHashMap();
    }

    public final Context getContext() {
        return this.f384695a;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f384695a = r100;
    }
}
