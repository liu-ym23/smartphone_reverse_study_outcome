package com.larus.drive.biz.impl.database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import l79.c;
import l79.h;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/larus/drive/biz/impl/database/DriveDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "recentDao", "Lcom/larus/drive/biz/impl/database/DriveRecentFileDao;", "mineDao", "Lcom/larus/drive/biz/impl/database/DriveMineFileDao;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DriveDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f341094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, DriveDatabase> f341095b = null;

    public static final class a {
        public final DriveDatabase a() {
            String r100 = AccountService.f365697a.getUserId();
            if (r100.length() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            r100 = "default";
        L8:
            ConcurrentHashMap<String, DriveDatabase> r102 = DriveDatabase.f341095b;
            DriveDatabase r103 = r102.get(r100);
            if (r103 != null) goto L18;
            monitor-enter(this);
            r103 = r102.get(r100);     // Catch: Throwable -> L19
            if (r103 == null) goto L16;
            monitor-exit(this);
            goto L18
        L16:
            String r104 = "nova_drive_".concat(r100);     // Catch: Throwable -> L19
            r103 = (DriveDatabase) Room.databaseBuilder(AppHost.f326268a.getApplication(), DriveDatabase.class, r104).build();     // Catch: Throwable -> L19
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

    public abstract c c();

    public abstract h d();

    static {
        f341094a = new a();
        f341095b = new ConcurrentHashMap();
    }

    public DriveDatabase() {
    }
}
