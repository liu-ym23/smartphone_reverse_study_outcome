package rj3;

import android.content.Context;
import androidx.room.Room;
import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static volatile a b;
    public static final C0162a c = null;
    public volatile StoreSearchHistoryDatabase a;

    /* JADX INFO: renamed from: rj3.a$a, reason: collision with other inner class name */
    public static final class C0162a {
        public final synchronized a a() {
            monitor-enter(this);
            a r0 = a.b;     // Catch: Throwable -> L16
            if (r0 != null) goto L14;
            monitor-enter(this);     // Catch: Throwable -> L16
            r0 = a.b;     // Catch: Throwable -> L11
            if (r0 != null) goto L9;
            r0 = new a();     // Catch: Throwable -> L11
            a.b = r0;     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);     // Catch: Throwable -> L16
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L14:
            monitor-exit(this);
            return r0;
        L16:
            th = move-exception;
            throw th;
        }

        public C0162a() {
        }
    }

    static {
        c = new C0162a();
    }

    public a() {
    }

    public final synchronized void a(Context r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "context");     // Catch: Throwable -> L10
        if (this.a == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.a = (StoreSearchHistoryDatabase) Room.databaseBuilder(r3, StoreSearchHistoryDatabase.class, "search_history").build();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
