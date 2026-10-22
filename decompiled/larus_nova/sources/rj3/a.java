package rj3;

import android.content.Context;
import androidx.room.Room;
import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f537990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C7490a f537991c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile StoreSearchHistoryDatabase f537992a;

    /* JADX INFO: renamed from: rj3.a$a, reason: collision with other inner class name */
    public static final class C7490a {
        public final synchronized a a() {
            monitor-enter(this);
            a r100 = a.f537990b;     // Catch: Throwable -> L16
            if (r100 != null) goto L14;
            monitor-enter(this);     // Catch: Throwable -> L16
            r100 = a.f537990b;     // Catch: Throwable -> L11
            if (r100 != null) goto L9;
            r100 = new a();     // Catch: Throwable -> L11
            a.f537990b = r100;     // Catch: Throwable -> L11
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

        public C7490a() {
        }
    }

    static {
        f537991c = new C7490a();
    }

    public a() {
    }

    public final synchronized void a(Context r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L10
        if (this.f537992a == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.f537992a = (StoreSearchHistoryDatabase) Room.databaseBuilder(r100, StoreSearchHistoryDatabase.class, "search_history").build();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
