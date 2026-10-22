package com.bytedance.locallife.adapter.impl.host.sp;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class LifeSpService implements du6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f256486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f256487b;

    public static final class a {
    }

    static {
    }

    public final Keva j() {
        return (Keva) this.f256487b.getValue();
    }

    public LifeSpService() {
        this.f256486a = Keva.getRepo("local-life-saas", 0);
        this.f256487b = LazyKt.lazy(LifeSpService$feKeva$2.INSTANCE);
    }

    @Override // du6.a
    public final Object i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
    L9:
        return "";
    L4:
        if (("" instanceof Boolean) == false) goto L8;
        return Boolean.valueOf(j().getBoolean(r100, ((Boolean) "").booleanValue()));
    L8:
        return j().getString(r100, "");
    }

    @Override // du6.a
    public final void setString(String r100) {
        Intrinsics.checkNotNullParameter("poi_warmup_opt_config", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        e("local-life-saas", "poi_warmup_opt_config", r100);
    }

    @Override // du6.a
    public final boolean b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Intrinsics.checkNotNullParameter("local-life-saas", "repoName");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if ((r101 instanceof Boolean) == false) goto L7;
        d("local-life-saas", r100, ((Boolean) r101).booleanValue());     // Catch: Exception -> L20
    L18:
        return true;
    L7:
        if ((r101 instanceof String) == false) goto L10;
        e("local-life-saas", r100, (String) r101);     // Catch: Exception -> L20
        goto L18
    L10:
        if ((r101 instanceof Long) == false) goto L13;
        f("local-life-saas", r100, ((Number) r101).longValue());     // Catch: Exception -> L20
        goto L18
    L13:
        if ((r101 instanceof Integer) == false) goto L22;
        int r102 = ((Number) r101).intValue();     // Catch: Exception -> L20
        Intrinsics.checkNotNullParameter("local-life-saas", "repoName");     // Catch: Exception -> L20
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Exception -> L20
        if (Intrinsics.areEqual("local-life-saas", "local-life-saas") == true) goto L17;
        Keva.getRepo("local-life-saas", 0).storeInt(r100, r102);     // Catch: Exception -> L20
        goto L18
    L17:
        this.f256486a.storeInt(r100, r102);     // Catch: Exception -> L20
        goto L18
    L22:
        return false;
    L23:
        return false;
    }

    @Override // du6.a
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return g("local-life-saas", r100, r101);
    }

    @Override // du6.a
    public final int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter("local-life-saas", "repoName");
        Intrinsics.checkNotNullParameter(r100, "key");
        if (Intrinsics.areEqual("local-life-saas", "local-life-saas") == true) goto L6;
        return Keva.getRepo("local-life-saas", 0).getInt(r100, r101);
    L6:
        return this.f256486a.getInt(r100, r101);
    }

    @Override // du6.a
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return c("local-life-saas", r100, r101);
    }

    @Override // du6.a
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return a("local-life-saas", r100, r101);
    }

    @Override // du6.a
    public final boolean h(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if ((r101 instanceof Boolean) == false) goto L8;
        j().storeBoolean(r100, ((Boolean) r101).booleanValue());     // Catch: Throwable -> L21
        return true;
    L8:
        if ((r101 instanceof String) == false) goto L12;
        j().storeString(r100, (String) r101);     // Catch: Throwable -> L21
        return true;
    L12:
        if ((r101 instanceof Long) == false) goto L16;
        j().storeLong(r100, ((Number) r101).longValue());     // Catch: Throwable -> L21
        return true;
    L16:
        if ((r101 instanceof Integer) == false) goto L19;
        j().storeInt(r100, ((Number) r101).intValue());     // Catch: Throwable -> L21
        return true;
    L19:
        return false;
    L23:
        return false;
    }

    @Override // du6.a
    public final String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "repoName");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (Intrinsics.areEqual(r100, "local-life-saas") == true) goto L6;
        return Keva.getRepo(r100, 0).getString(r101, r102);
    L6:
        return this.f256486a.getString(r101, r102);
    }

    @Override // du6.a
    public final long c(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "repoName");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (Intrinsics.areEqual(r100, "local-life-saas") == true) goto L6;
        return Keva.getRepo(r100, 0).getLong(r101, r102);
    L6:
        return this.f256486a.getLong(r101, r102);
    }

    @Override // du6.a
    public final void d(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "repoName");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (Intrinsics.areEqual(r100, "local-life-saas") == true) goto L5;
        Keva.getRepo(r100, 0).storeBoolean(r101, r102);
        return;
    L5:
        this.f256486a.storeBoolean(r101, r102);
    }

    @Override // du6.a
    public final void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "repoName");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (Intrinsics.areEqual(r100, "local-life-saas") == true) goto L5;
        Keva.getRepo(r100, 0).storeString(r101, r102);
        return;
    L5:
        this.f256486a.storeString(r101, r102);
    }

    @Override // du6.a
    public final void f(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "repoName");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (Intrinsics.areEqual(r100, "local-life-saas") == true) goto L5;
        Keva.getRepo(r100, 0).storeLong(r101, r102);
        return;
    L5:
        this.f256486a.storeLong(r101, r102);
    }

    @Override // du6.a
    public final boolean g(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "repoName");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (Intrinsics.areEqual(r100, "local-life-saas") == true) goto L6;
        return Keva.getRepo(r100, 0).getBoolean(r101, r102);
    L6:
        return this.f256486a.getBoolean(r101, r102);
    }
}
