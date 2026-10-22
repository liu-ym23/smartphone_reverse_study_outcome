package com.larus.avlink.gallery.database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/larus/avlink/gallery/database/AlbumDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "mediaDataDao", "Lcom/larus/avlink/gallery/database/MediaDataDao;", "thumbnailDataDao", "Lcom/larus/avlink/gallery/database/ThumbnailDataDao;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AlbumDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f292395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, AlbumDatabase> f292396b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AlbumDatabase$Companion$MIGRATION_1_2$1 f292397c = null;

    public static final class a {
        public final AlbumDatabase a() {
            String r100 = AccountService.f365697a.getUserId();
            if (r100.length() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            r100 = "default";
        L8:
            ConcurrentHashMap<String, AlbumDatabase> r102 = AlbumDatabase.f292396b;
            AlbumDatabase r103 = r102.get(r100);
            if (r103 != null) goto L18;
            monitor-enter(this);
            r103 = r102.get(r100);     // Catch: Throwable -> L19
            if (r103 == null) goto L16;
            monitor-exit(this);
            goto L18
        L16:
            r103 = (AlbumDatabase) Room.databaseBuilder(AppHost.f326268a.getApplication(), AlbumDatabase.class, "dora_album_".concat(r100)).addMigrations(new Migration[]{AlbumDatabase.f292397c}).build();     // Catch: Throwable -> L19
            r102.put(r100, r103);     // Catch: Throwable -> L19
            monitor-exit(this);
        L19:
            th = move-exception;
            throw th;
        L18:
            return r103;
        L5:
            r101 = false;
            goto L6
        }

        public a() {
        }
    }

    public abstract b c();

    public abstract j d();

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.avlink.gallery.database.AlbumDatabase$Companion$MIGRATION_1_2$1] */
    static {
        f292395a = new a();
        f292396b = new ConcurrentHashMap();
        f292397c = new AlbumDatabase$Companion$MIGRATION_1_2$1();
    }

    public AlbumDatabase() {
    }
}
