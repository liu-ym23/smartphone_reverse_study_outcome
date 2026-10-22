package cp;

import android.content.Context;
import androidx.room.Room;
import com.bytedance.android.ec.window.base.repository.searchhistorydb.WindowSearchHistoryDatabase;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f464596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f464597c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile WindowSearchHistoryDatabase f464598a;

    public static final class a {
        public final synchronized b a() {
            monitor-enter(this);
            b r100 = b.f464596b;     // Catch: Throwable -> L16
            if (r100 != null) goto L14;
            monitor-enter(this);     // Catch: Throwable -> L16
            r100 = b.f464596b;     // Catch: Throwable -> L11
            if (r100 != null) goto L9;
            r100 = new b();     // Catch: Throwable -> L11
            b.f464596b = r100;     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);     // Catch: Throwable -> L16
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L14:
            monitor-exit(this);
            return r100;
        L16:
            th = move-exception;
            throw th;
        }

        public a() {
        }
    }

    static {
        f464597c = new a();
    }

    public b() {
    }

    public final synchronized void a(Context r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L10
        if (this.f464598a == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f464598a = (WindowSearchHistoryDatabase) Room.databaseBuilder(r100, WindowSearchHistoryDatabase.class, "search_history").build();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
