package com.ss.android.lark.storage.file.migration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
public interface IFileMigration {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/storage/file/migration/IFileMigration$MigrationPriority;", "", "<init>", "(Ljava/lang/String;I)V", "LAUNCHER", "WHEN_IDLE", "WHEN_WRITE", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MigrationPriority extends Enum<MigrationPriority> {
        public static final MigrationPriority LAUNCHER = null;
        public static final MigrationPriority WHEN_IDLE = null;
        public static final MigrationPriority WHEN_WRITE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MigrationPriority[] f440981a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440982b = null;

        public static EnumEntries<MigrationPriority> getEntries() {
            return f440982b;
        }

        static {
            MigrationPriority r100 = new MigrationPriority("LAUNCHER", 0);
            LAUNCHER = r100;
            MigrationPriority r101 = new MigrationPriority("WHEN_IDLE", 1);
            WHEN_IDLE = r101;
            MigrationPriority r102 = new MigrationPriority("WHEN_WRITE", 2);
            WHEN_WRITE = r102;
            MigrationPriority[] r103 = {r100, r101, r102};
            f440981a = r103;
            f440982b = EnumEntriesKt.enumEntries(r103);
        }

        public static MigrationPriority[] values() {
            return (MigrationPriority[]) f440981a.clone();
        }

        public static MigrationPriority valueOf(String r100) {
            return (MigrationPriority) r27.a.a(MigrationPriority.class, r100);
        }

        public MigrationPriority(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/storage/file/migration/IFileMigration$MigrationStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "PATH_MAPPING", "AUTO", "DELETE", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MigrationStrategy extends Enum<MigrationStrategy> {
        public static final MigrationStrategy AUTO = null;
        public static final MigrationStrategy DELETE = null;
        public static final MigrationStrategy PATH_MAPPING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MigrationStrategy[] f440983a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440984b = null;

        public static EnumEntries<MigrationStrategy> getEntries() {
            return f440984b;
        }

        static {
            MigrationStrategy r100 = new MigrationStrategy("PATH_MAPPING", 0);
            PATH_MAPPING = r100;
            MigrationStrategy r101 = new MigrationStrategy("AUTO", 1);
            AUTO = r101;
            MigrationStrategy r102 = new MigrationStrategy("DELETE", 2);
            DELETE = r102;
            MigrationStrategy[] r103 = {r100, r101, r102};
            f440983a = r103;
            f440984b = EnumEntriesKt.enumEntries(r103);
        }

        public static MigrationStrategy[] values() {
            return (MigrationStrategy[]) f440983a.clone();
        }

        public static MigrationStrategy valueOf(String r100) {
            return (MigrationStrategy) r27.a.a(MigrationStrategy.class, r100);
        }

        public MigrationStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    String[] a();

    String b();

    MigrationStrategy getStrategy();
}
