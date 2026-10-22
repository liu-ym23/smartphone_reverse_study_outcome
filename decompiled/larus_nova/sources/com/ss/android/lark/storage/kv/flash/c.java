package com.ss.android.lark.storage.kv.flash;

import android.content.Context;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f441037b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KVRepo f441038a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f441039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f441040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f441041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f441042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.ss.android.lark.storage.kv.flash.a f441043e;

        public final c a() {
            return new c(com.ss.android.lark.storage.kv.storage.a.b(com.ss.android.lark.storage.kv.storage.b.b(this.f441039a, this.f441041c), new com.ss.android.lark.storage.a(this.f441042d), null, new FlashKV$Builder$build$1(this), 2));
        }

        public final Context getContext() {
            return this.f441039a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f441039a = r100;
            this.f441040b = "lark";
            this.f441041c = "lark";
            this.f441042d = "nano";
            this.f441043e = new com.ss.android.lark.storage.kv.flash.a();
        }
    }

    public static final class b {
        @JvmStatic
        public static d a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            d r101 = c.f441037b;
            if (r101 != null) goto L5;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            r101 = new a(r100).a();
        L5:
            c.f441037b = r101;
            return r101;
        }
    }

    static {
    }

    public c(com.ss.android.lark.storage.kv.repo.a r100) {
        this.f441038a = r100;
    }

    @Override // com.ss.android.lark.storage.kv.flash.d
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter("sdk_log_encryption", "key");
        this.f441038a.putString("sdk_log_encryption", r100);
    }

    @Override // com.ss.android.lark.storage.kv.flash.d
    public final String getString(String r100) {
        Intrinsics.checkNotNullParameter("sdk_log_encryption", "key");
        return this.f441038a.getString("sdk_log_encryption", r100);
    }

    public final boolean a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f441038a.getBoolean(r100, r101);
    }
}
