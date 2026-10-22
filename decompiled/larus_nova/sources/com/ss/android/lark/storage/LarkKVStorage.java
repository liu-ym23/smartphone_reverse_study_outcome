package com.ss.android.lark.storage;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.storage.kv.migration.CleanupMigrationProxy;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.storage.kv.repo.KVRepoConfig;
import com.ss.android.lark.storage.kv.repo.g;
import com.ss.android.lark.storage.transformer.EncryptTransformer;
import com.ss.android.lark.util.share_preference.UserSP;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.component.protocol.Biz;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class LarkKVStorage extends BaseKVStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LarkKVStorage f440926a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/storage/LarkKVStorage$CipherMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, "ONLY_VALUE", AccountType.ALL, "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CipherMode extends Enum<CipherMode> {
        public static final CipherMode ALL = null;
        public static final CipherMode NONE = null;
        public static final CipherMode ONLY_VALUE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CipherMode[] f440927a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440928b = null;
        private final int value;

        public static EnumEntries<CipherMode> getEntries() {
            return f440928b;
        }

        static {
            CipherMode r100 = new CipherMode(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            CipherMode r101 = new CipherMode("ONLY_VALUE", 1, 1);
            ONLY_VALUE = r101;
            CipherMode r102 = new CipherMode(AccountType.ALL, 2, 2);
            ALL = r102;
            CipherMode[] r103 = {r100, r101, r102};
            f440927a = r103;
            f440928b = EnumEntriesKt.enumEntries(r103);
        }

        public static CipherMode[] values() {
            return (CipherMode[]) f440927a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CipherMode valueOf(String r100) {
            return (CipherMode) r27.a.a(CipherMode.class, r100);
        }

        public CipherMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class KVStorageBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f440929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f440930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<g> f440931c;

        public final com.ss.android.lark.storage.kv.storage.a b() {
            Context r100 = this.f440929a;
            String r101 = this.f440930b;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("spaceName");
            r101 = null;
        L6:
            return com.ss.android.lark.storage.kv.storage.b.a(r100, r101, new LarkKVStorage$KVStorageBuilder$build$1(this));
        }

        public final Context getContext() {
            return this.f440929a;
        }

        public KVStorageBuilder(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f440929a = r100;
            KVRepoConfig.Mode r101 = KVRepoConfig.Mode.SINGLE_PROCESS;
            this.f440931c = new ArrayList();
        }

        public final void a(CipherMode r100) {
            if (r100 != CipherMode.NONE) goto L5;
            return;
        L5:
            if (r100 != CipherMode.ALL) goto L7;
            boolean r101 = true;
        L8:
            EncryptTransformer.b r102 = new EncryptTransformer.b(r101);
            if (this.f440931c.contains(r102) == true) goto L13;
            this.f440931c.add(r102);
            return;
        L13:
            return;
        L7:
            r101 = false;
            goto L8
        }

        public static void c(KVStorageBuilder r100, String r101) {
            CipherMode r102 = CipherMode.ONLY_VALUE;
            Intrinsics.checkNotNullParameter(r102, "cipherMode");
            LarkKVStorage.f440926a.getClass();
            r100.f440930b = BaseKVStorage.a(r101);
            r100.a(r102);
        }
    }

    public interface a {
        String getCurrentUserId();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.storage.kv.storage.a f440932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.ss.android.lark.storage.a f440933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f440934c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList<g> f440935d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f440936e;

        public final com.ss.android.lark.storage.kv.repo.a a() {
            com.ss.android.lark.storage.kv.storage.a r100 = this.f440932a;
            com.ss.android.lark.storage.a r101 = this.f440933b;
            if (r101 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("domain");
            r101 = null;
        L6:
            return r100.a(r101, this.f440934c, new LarkKVStorage$KVRepoBuilder$build$1(this));
        }

        public b(com.ss.android.lark.storage.kv.storage.a r100) {
            Intrinsics.checkNotNullParameter(r100, "kvStorage");
            this.f440932a = r100;
            this.f440935d = new ArrayList();
        }

        public final void b(KVRepo r100, boolean r101) {
            if (this.f440936e == true) goto L11;
            if (r101 == false) goto L7;
            CleanupMigrationProxy.b r102 = new CleanupMigrationProxy.b(r100);
            Intrinsics.checkNotNullParameter(r102, "proxyProvider");
            this.f440935d.add(r102);
        L8:
            this.f440936e = true;
            return;
        L7:
            com.ss.android.lark.storage.kv.migration.a.C5309a r103 = new com.ss.android.lark.storage.kv.migration.a.C5309a(r100, true);
            Intrinsics.checkNotNullParameter(r103, "proxyProvider");
            this.f440935d.add(r103);
            goto L8
        L11:
            throw new IllegalStateException("migration source cannot set duplicate");
        }
    }

    static {
        f440926a = new LarkKVStorage();
        new ConcurrentHashMap(10);
    }

    public static String m() {
        com.ss.android.lark.g.a r100 = com.ss.android.lark.g.f425765a;
        if (r100 == null) goto L7;
        return BaseKVStorage.a(r100.getUserId());
    L7:
        throw new IllegalStateException("sp not init exactly");
    }

    public LarkKVStorage() {
    }

    @JvmStatic
    public static final b r(com.ss.android.lark.storage.kv.storage.a r100) {
        Intrinsics.checkNotNullParameter(r100, "kvStorage");
        return new b(r100);
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.storage.a e(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spaceName");
        f440926a.getClass();
        return BaseKVStorage.b(r100, r101);
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a h(com.ss.android.lark.storage.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        return g(r100, null, r101);
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a j(Biz r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        return g(j6c.a.a(r100), null, r101);
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a q(com.ss.android.lark.storage.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        return p(r100, null, r101);
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a f(com.ss.android.lark.storage.a r100, String r101, KVRepo r102) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Context r103 = com.ss.android.lark.g.getContext();
        f440926a.getClass();
        return BaseKVStorage.c(r103, "lark", r100, r101, r102, true);
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a g(com.ss.android.lark.storage.a r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        if (r102 == false) goto L6;
        return f(r100, r101, new n6c.a(eac.a.a()));
    L6:
        return f(r100, r101, null);
    }

    public static com.ss.android.lark.storage.kv.repo.a i(Biz r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        com.ss.android.lark.storage.a r103 = j6c.a.a(r100);
        if (r102 == false) goto L5;
        n6c.a r104 = new n6c.a(eac.a.a());
    L7:
        return f(r103, r101, r104);
    L5:
        r104 = null;
        goto L7
    }

    public static com.ss.android.lark.storage.kv.repo.a k(com.ss.android.lark.storage.kv.storage.a r100, com.ss.android.lark.storage.a r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "domain");
        return r100.a(r101, r102, LarkKVStorage$getMigrateGlobalSPKVRepo$1.INSTANCE);
    }

    public static com.ss.android.lark.storage.kv.repo.a l(final com.ss.android.lark.storage.kv.storage.a r100, com.ss.android.lark.storage.a r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "domain");
        return r100.a(r101, r102, new LarkKVStorage$getMigrateUserSPKVRepo$1(r100));
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a o(com.ss.android.lark.storage.a r100, String r101, KVRepo r102) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Context r103 = com.ss.android.lark.g.getContext();
        f440926a.getClass();
        return n(r103, m(), r100, r101, r102);
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a p(com.ss.android.lark.storage.a r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        f440926a.getClass();
        String r103 = BaseKVStorage.a(m());
        Context r104 = com.ss.android.lark.g.getContext();
        Intrinsics.checkNotNullParameter(r103, "userId");
        if (r102 == false) goto L5;
        n6c.a r105 = new n6c.a(UserSP.getUserSPById(r103));
    L7:
        return n(r104, r103, r100, r101, r105);
    L5:
        r105 = null;
        goto L7
    }

    public static com.ss.android.lark.storage.kv.repo.a d(LarkKVStorage r100, com.ss.android.lark.storage.kv.storage.a r101, com.ss.android.lark.storage.a r102, String r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r102, "domain");
        final KVRepo r104 = null;
        return r101.a(r102, r103, new LarkKVStorage$getKVRepo$1(r104));
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a n(Context r100, String r101, com.ss.android.lark.storage.a r102, String r110, KVRepo r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "domain");
        f440926a.getClass();
        return c.d(r100, BaseKVStorage.a(r101), r102, r110, r111, 32);
    }
}
