package com.larus.settings.coldboot;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class EarlyFileSettingsStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f368526a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/settings/coldboot/EarlyFileSettingsStore$Key;", "", "<init>", "(Ljava/lang/String;I)V", "KEVA_INIT_REPO_MAIN_ONLY_OPT", "KEVA_GET_REPO_LOCK_OPT", "KEVA_EXECUTOR_OPT", "KEVA_INDEPENDENT_EXECUTOR_OPT", "KEVA_EXECUTOR_CORE_POOL_SIZE", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Key extends Enum<Key> {
        public static final Key KEVA_EXECUTOR_CORE_POOL_SIZE = null;
        public static final Key KEVA_EXECUTOR_OPT = null;
        public static final Key KEVA_GET_REPO_LOCK_OPT = null;
        public static final Key KEVA_INDEPENDENT_EXECUTOR_OPT = null;
        public static final Key KEVA_INIT_REPO_MAIN_ONLY_OPT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Key[] f368527a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f368528b = null;

        public static EnumEntries<Key> getEntries() {
            return f368528b;
        }

        static {
            Key r100 = new Key("KEVA_INIT_REPO_MAIN_ONLY_OPT", 0);
            KEVA_INIT_REPO_MAIN_ONLY_OPT = r100;
            Key r101 = new Key("KEVA_GET_REPO_LOCK_OPT", 1);
            KEVA_GET_REPO_LOCK_OPT = r101;
            Key r102 = new Key("KEVA_EXECUTOR_OPT", 2);
            KEVA_EXECUTOR_OPT = r102;
            Key r103 = new Key("KEVA_INDEPENDENT_EXECUTOR_OPT", 3);
            KEVA_INDEPENDENT_EXECUTOR_OPT = r103;
            Key r104 = new Key("KEVA_EXECUTOR_CORE_POOL_SIZE", 4);
            KEVA_EXECUTOR_CORE_POOL_SIZE = r104;
            Key[] r105 = {r100, r101, r102, r103, r104};
            f368527a = r105;
            f368528b = EnumEntriesKt.enumEntries(r105);
        }

        public static Key[] values() {
            return (Key[]) f368527a.clone();
        }

        public static Key valueOf(String r100) {
            return (Key) r27.a.a(Key.class, r100);
        }

        public Key(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f368529a = null;

        static {
            int[] r100 = new int[Key.values().length];
            r100[Key.KEVA_INIT_REPO_MAIN_ONLY_OPT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[Key.KEVA_GET_REPO_LOCK_OPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[Key.KEVA_EXECUTOR_OPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[Key.KEVA_INDEPENDENT_EXECUTOR_OPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[Key.KEVA_EXECUTOR_CORE_POOL_SIZE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f368529a = r100;
        }
    }

    static {
    }

    public static boolean a(Context r100, Key r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "key");
        PolarisFileWrapper r102 = c(new PolarisFileWrapper(r100.getFilesDir(), "early_settings"), r101);     // Catch: Throwable -> L12
        if (r102.exists() == true) goto L6;
    L9:
        boolean r103 = true;
    L10:
        Objects.toString(r101);     // Catch: Throwable -> L12
        return r103;
    L6:
        if (r102.delete() == true) goto L9;
        r103 = false;
    L12:
        Objects.toString(r101);
        return false;
    }

    public static boolean b(Context r100, Key r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "key");
        boolean r102 = c(new PolarisFileWrapper(r100.getFilesDir(), "early_settings"), r101).exists();     // Catch: Throwable -> L5
        Objects.toString(r101);     // Catch: Throwable -> L5
        return r102;
    L5:
        Objects.toString(r101);
        return false;
    }

    public static PolarisFileWrapper c(PolarisFileWrapper r100, Key r101) {
        int r102 = a.f368529a[r101.ordinal()];
        if (r102 == 1) goto L19;
        if (r102 == 2) goto L23;
        if (r102 == 3) goto L22;
        if (r102 == 4) goto L21;
        if (r102 != 5) goto L14;
        return new PolarisFileWrapper(r100, "keva_executor_core_pool_size_v1");
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return new PolarisFileWrapper(r100, "keva_independent_executor_opt_v1");
    L22:
        return new PolarisFileWrapper(r100, "keva_executor_opt_v1");
    L23:
        return new PolarisFileWrapper(r100, "keva_get_repo_lock_opt_v1");
    L19:
        return new PolarisFileWrapper(r100, "keva_init_repo_main_only_opt_v1");
    }

    public static boolean d(Context r100, Key r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 == false) goto L21;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100.getFilesDir(), "early_settings");     // Catch: Throwable -> L19
        if (r103.exists() == false) goto L8;
    L10:
        PolarisFileWrapper r104 = c(r103, r101);     // Catch: Throwable -> L19
        if (r104.exists() == false) goto L13;
    L16:
        boolean r105 = true;
    L17:
        r101.toString();     // Catch: Throwable -> L19
        return r105;
    L13:
        if (r104.createNewFile() == true) goto L16;
        r105 = false;
        goto L17
    L8:
        if (r103.mkdirs() == true) goto L10;
        Objects.toString(r101);     // Catch: Throwable -> L19
        return false;
    L19:
        Objects.toString(r101);
        return false;
    L21:
        return a(r100, r101);
    }
}
