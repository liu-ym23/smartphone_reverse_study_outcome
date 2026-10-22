package com.larus.settings.coldboot;

import android.content.Context;
import android.util.EventsUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class EarlyFileSettingsStore {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/settings/coldboot/EarlyFileSettingsStore$Key;", XmlPullParser.NO_NAMESPACE, "<init>", "(Ljava/lang/String;I)V", "KEVA_INIT_REPO_MAIN_ONLY_OPT", "KEVA_GET_REPO_LOCK_OPT", "KEVA_EXECUTOR_OPT", "KEVA_INDEPENDENT_EXECUTOR_OPT", "KEVA_EXECUTOR_CORE_POOL_SIZE", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final enum Key extends Enum<Key> {
        public static final Key KEVA_EXECUTOR_CORE_POOL_SIZE = null;
        public static final Key KEVA_EXECUTOR_OPT = null;
        public static final Key KEVA_GET_REPO_LOCK_OPT = null;
        public static final Key KEVA_INDEPENDENT_EXECUTOR_OPT = null;
        public static final Key KEVA_INIT_REPO_MAIN_ONLY_OPT = null;
        public static final /* synthetic */ Key[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Key> getEntries() {
            return b;
        }

        static {
            Key r0 = new Key("KEVA_INIT_REPO_MAIN_ONLY_OPT", 0);
            KEVA_INIT_REPO_MAIN_ONLY_OPT = r0;
            Key r1 = new Key("KEVA_GET_REPO_LOCK_OPT", 1);
            KEVA_GET_REPO_LOCK_OPT = r1;
            Key r3 = new Key("KEVA_EXECUTOR_OPT", 2);
            KEVA_EXECUTOR_OPT = r3;
            Key r5 = new Key("KEVA_INDEPENDENT_EXECUTOR_OPT", 3);
            KEVA_INDEPENDENT_EXECUTOR_OPT = r5;
            Key r7 = new Key("KEVA_EXECUTOR_CORE_POOL_SIZE", 4);
            KEVA_EXECUTOR_CORE_POOL_SIZE = r7;
            Key[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static Key[] values() {
            return (Key[]) a.clone();
        }

        public static Key valueOf(String r1) {
            return (Key) r27.a.a(Key.class, r1);
        }

        public Key(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Key.values().length];
            r0[Key.KEVA_INIT_REPO_MAIN_ONLY_OPT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[Key.KEVA_GET_REPO_LOCK_OPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[Key.KEVA_EXECUTOR_OPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[Key.KEVA_INDEPENDENT_EXECUTOR_OPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[Key.KEVA_EXECUTOR_CORE_POOL_SIZE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public static boolean a(Context r3, Key r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "key");
        PolarisFileWrapper r5 = c(new PolarisFileWrapper(r3.getFilesDir(), "early_settings"), r4);     // Catch: Throwable -> L12
        if (r5.exists() == true) goto L6;
    L9:
        boolean r6 = true;
    L10:
        Objects.toString(r4);     // Catch: Throwable -> L12
        return r6;
    L6:
        if (r5.delete() == true) goto L9;
        r6 = false;
    L12:
        Objects.toString(r4);
        return false;
    }

    public static boolean b(Context r2, Key r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        boolean r4 = c(new PolarisFileWrapper(r2.getFilesDir(), "early_settings"), r3).exists();     // Catch: Throwable -> L5
        Objects.toString(r3);     // Catch: Throwable -> L5
        return r4;
    L5:
        Objects.toString(r3);
        return false;
    }

    public static PolarisFileWrapper c(PolarisFileWrapper r1, Key r2) {
        int r3 = a.a[r2.ordinal()];
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L23;
        if (r3 == 3) goto L22;
        if (r3 == 4) goto L21;
        if (r3 != 5) goto L14;
        return new PolarisFileWrapper(r1, "keva_executor_core_pool_size_v1");
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return new PolarisFileWrapper(r1, "keva_independent_executor_opt_v1");
    L22:
        return new PolarisFileWrapper(r1, "keva_executor_opt_v1");
    L23:
        return new PolarisFileWrapper(r1, "keva_get_repo_lock_opt_v1");
    L19:
        return new PolarisFileWrapper(r1, "keva_init_repo_main_only_opt_v1");
    }

    public static boolean d(Context r2, Key r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        if (r4 == false) goto L21;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r2.getFilesDir(), "early_settings");     // Catch: Throwable -> L19
        if (r0.exists() == false) goto L8;
    L10:
        PolarisFileWrapper r5 = c(r0, r3);     // Catch: Throwable -> L19
        if (r5.exists() == false) goto L13;
    L16:
        boolean r6 = true;
    L17:
        r3.toString();     // Catch: Throwable -> L19
        return r6;
    L13:
        if (r5.createNewFile() == true) goto L16;
        r6 = false;
        goto L17
    L8:
        if (r0.mkdirs() == true) goto L10;
        Objects.toString(r3);     // Catch: Throwable -> L19
        return false;
    L19:
        Objects.toString(r3);
        return false;
    L21:
        return a(r2, r3);
    }
}
