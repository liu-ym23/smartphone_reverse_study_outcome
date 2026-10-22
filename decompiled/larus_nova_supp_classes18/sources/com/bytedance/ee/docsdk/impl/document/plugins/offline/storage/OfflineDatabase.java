package com.bytedance.ee.docsdk.impl.document.plugins.offline.storage;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/storage/OfflineDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getResourceDataDao", "Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/storage/ResourceDataDao;", "Companion", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class OfflineDatabase extends RoomDatabase {
    public static final Companion Companion = null;
    private static volatile OfflineDatabase INSTANCE = null;
    private static final String OFFLINE_DB_NAME = "offlineData.db";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/storage/OfflineDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/storage/OfflineDatabase;", "OFFLINE_DB_NAME", "", "getDataBase", "context", "Landroid/content/Context;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final OfflineDatabase getDataBase(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            OfflineDatabase r0 = OfflineDatabase.access$getINSTANCE$cp();
            if (r0 != null) goto L11;
            monitor-enter(this);
            r0 = (OfflineDatabase) Room.databaseBuilder(r3.getApplicationContext(), OfflineDatabase.class, OfflineDatabase.OFFLINE_DB_NAME).build();     // Catch: Throwable -> L8
            OfflineDatabase.access$setINSTANCE$cp(r0);     // Catch: Throwable -> L8
            monitor-exit(this);
        L8:
            th = move-exception;
            throw th;
        L11:
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract ResourceDataDao getResourceDataDao();

    public OfflineDatabase() {
    }

    public static final /* synthetic */ OfflineDatabase access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(OfflineDatabase r0) {
        INSTANCE = r0;
    }
}
