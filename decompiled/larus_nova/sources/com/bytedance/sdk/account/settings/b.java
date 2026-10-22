package com.bytedance.sdk.account.settings;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f269325f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile JSONObject f269326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile JSONObject f269327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f269328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final lc7.b f269329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f269330e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.account.settings.b$b, reason: collision with other inner class name */
    public static final class C3766b<T> extends c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Object f269331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile JSONObject f269332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<JSONObject, T> f269333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f269334d;

        /* JADX INFO: renamed from: com.bytedance.sdk.account.settings.b$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f269335a = null;

            public a() {
            }

            static {
                f269335a = new a();
            }
        }

        @Override // com.bytedance.sdk.account.settings.b.c
        public final boolean a() {
            return this.f269334d;
        }

        public C3766b(Function1 r100) {
            this.f269333c = r100;
            this.f269334d = false;
            this.f269331a = a.f269335a;
        }

        @Override // com.bytedance.sdk.account.settings.b.c
        public final T b(JSONObject r100) {
            if (this.f269334d == true) goto L7;
            if (this.f269332b == r100) goto L7;
        L10:
            monitor-enter(this);
        L23:
            th = move-exception;
            throw th;
        L12:
            if (this.f269334d == true) goto L16;
            if (this.f269332b == r100) goto L16;
        L20:
            T r101 = this.f269333c.invoke(r100);     // Catch: Throwable -> L23
            this.f269331a = r101;     // Catch: Throwable -> L23
            this.f269332b = r100;     // Catch: Throwable -> L23
            monitor-exit(this);
            return r101;
        L16:
            if (this.f269331a == a.f269335a) goto L20;
            T r102 = (T) this.f269331a;
            monitor-exit(this);
            return r102;
        L7:
            if (this.f269331a == a.f269335a) goto L10;
            return (T) this.f269331a;
        }
    }

    public static abstract class c<T> implements ReadOnlyProperty<b, T> {
        public c() {
        }

        public abstract boolean a();

        public abstract T b(JSONObject r100);

        public final Object c(b r100) {
            if (a() == false) goto L5;
            JSONObject r101 = r100.f269327b;
            if (r101 == null) goto L11;
            T r102 = b(r101);
            if (r102 == null) goto L11;
        L27:
            return r102;
        L11:
            monitor-enter(this);
            JSONObject r103 = r100.f269327b;     // Catch: Throwable -> L28
            if (r103 == null) goto L17;
            r102 = b(r103);     // Catch: Throwable -> L28
            if (r102 == null) goto L17;
        L26:
            monitor-exit(this);
        L17:
            JSONObject r104 = b.a(r100);     // Catch: Throwable -> L28
            T r105 = b(r104);     // Catch: Throwable -> L28
            if (r104 == null) goto L23;
            JSONObject r106 = new JSONObject();     // Catch: Throwable -> L28
            Iterator<String> r107 = r104.keys();     // Catch: Throwable -> L28
        L21:
            if (r107.hasNext() == false) goto L24;
            String r108 = r107.next();     // Catch: Throwable -> L28
            r106.put(r108, r104.get(r108));     // Catch: Throwable -> L28
        L24:
            r100.f269327b = r106;     // Catch: Throwable -> L28
            r102 = r105;
            goto L26
        L23:
            r106 = null;
        L28:
            th = move-exception;
            throw th;
        L5:
            return b(b.a(r100));
        }

        @Override // kotlin.properties.ReadOnlyProperty
        public final /* bridge */ /* synthetic */ Object getValue(b r100, KProperty r101) {
            return c(r100);
        }
    }

    static {
        f269325f = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(b.class), "settingGetterService", "getSettingGetterService()Lcom/bytedance/sdk/account/settings/ISettingsGetter;"))};
    }

    public abstract void b();

    public b() {
        this.f269328c = 1000;
        this.f269329d = new lc7.b(ISettingsGetter.class);
    }

    public static JSONObject a(b r110) {
        boolean r100 = false;
        ISettingsGetter r101 = (ISettingsGetter) r110.f269329d.getValue(r110, f269325f[0]);
        r110.b();
        JSONObject r102 = r101.getSettings("account_monitor_config");
        long r103 = System.currentTimeMillis();
        if (r102 == r110.f269326a) goto L16;
        long r104 = r110.f269328c;
        if (r104 <= 0) goto L12;
        long r105 = r110.f269330e;
        if (r103 < r105) goto L12;
        if (r105 <= 0) goto L12;
        if ((r103 - r105) > r104) goto L12;
    L13:
        if (r100 == false) goto L16;
        r110.f269326a = r102;
        r110.f269330e = r103;
    L12:
        r100 = true;
    L16:
        return r110.f269326a;
    }
}
