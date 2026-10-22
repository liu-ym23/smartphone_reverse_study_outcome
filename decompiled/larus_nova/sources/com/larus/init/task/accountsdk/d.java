package com.larus.init.task.accountsdk;

import com.bytedance.keva.Keva;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d implements d48.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f351138b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, d48.f.b> f351139c = null;

    public static final class a implements d48.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Keva f351140a;

        public a(Keva r100) {
            Intrinsics.checkNotNullParameter(r100, "keva");
            this.f351140a = r100;
        }

        @Override // d48.f.b
        public final long getLong(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            return this.f351140a.getLong(r100, 0);
        }

        @Override // d48.f.b
        public final String getString(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter("", "defValue");
            return this.f351140a.getString(r100, "");
        }

        @Override // d48.f.b
        public final void remove(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f351140a.erase(r100);
        }

        @Override // d48.f.b
        public final void putLong(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f351140a.storeLong(r100, r101);
        }

        @Override // d48.f.b
        public final void putString(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            this.f351140a.storeString(r100, r101);
        }
    }

    public d() {
    }

    static {
        f351138b = new d();
        f351139c = new ConcurrentHashMap();
    }

    public final d48.f.b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "repoName");
        ConcurrentHashMap<String, d48.f.b> r101 = f351139c;
        d48.f.b r102 = r101.get(r100);
        if (r102 != null) goto L9;
        r102 = new a(Keva.getRepo(r100, 0));
        d48.f.b r103 = r101.putIfAbsent(r100, r102);
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        return r102;
    }
}
