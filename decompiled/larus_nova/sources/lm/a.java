package lm;

import android.content.Context;
import androidx.room.Room;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.db.StoreDatabase;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static StoreDatabase f509821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f509822b = null;

    public a() {
    }

    public final synchronized StoreDatabase a() {
        monitor-enter(this);
        StoreDatabase r100 = f509821a;     // Catch: Throwable -> L22
        if (r100 == null) goto L7;
        monitor-exit(this);
        return r100;
    L7:
        int r101 = ECSdk.f48106a;     // Catch: Throwable -> L22
        IECHostService r102 = (IECHostService) ECSdk.a(IECHostService.class);     // Catch: Throwable -> L22
        if (r102 == null) goto L11;
        vi.a r103 = r102.getIECHostAppInfo();     // Catch: Throwable -> L22
    L12:
        if (r103 != null) goto L15;
        monitor-exit(this);
        return null;
    L15:
        Context r104 = r103.getApplicationContext();     // Catch: Throwable -> L22
        if (r104 != null) goto L19;
        monitor-exit(this);
        return null;
    L19:
        StoreDatabase r105 = (StoreDatabase) Room.databaseBuilder(r104, StoreDatabase.class, "store_db").fallbackToDestructiveMigration().build();     // Catch: Throwable -> L22
        f509821a = r105;     // Catch: Throwable -> L22
        monitor-exit(this);
        return r105;
    L11:
        r103 = null;
    L22:
        th = move-exception;
        throw th;
    }

    static {
        f509822b = new a();
    }
}
