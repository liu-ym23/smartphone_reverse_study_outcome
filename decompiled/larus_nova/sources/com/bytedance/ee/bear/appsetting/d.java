package com.bytedance.ee.bear.appsetting;

import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f206238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jdb.g f206239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KVRepo f206240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<List<String>, Unit> f206241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference<c> f206242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f206243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f206244g;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f206245a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AtomicReference<a> f206246b = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f206247a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f206248b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Boolean f206249c;

            public a() {
                this(null, null, null);
            }

            public final String toString() {
                return "ConfMeta(confId=" + this.f206247a + ", rebootTimes=" + this.f206248b + ", didClean=" + this.f206249c + ')';
            }

            public a(String r100, Integer r101, Boolean r102) {
                this.f206247a = r100;
                this.f206248b = r101;
                this.f206249c = r102;
            }
        }

        public b() {
        }

        static {
            f206245a = new b();
            f206246b = new AtomicReference();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f206250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Boolean> f206251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f206252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Object> f206253d;

        public c(String r100, Map<String, Boolean> r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "confId");
            Intrinsics.checkNotNullParameter(r101, "fixFGs");
            Intrinsics.checkNotNullParameter(r102, "fixSettingsData");
            this.f206250a = r100;
            this.f206251b = r101;
            this.f206252c = r102;
            this.f206253d = new LinkedHashMap();
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.appsetting.n
    public final String c() {
        c r100 = this.f206242e.get();
        if (r100 == null) goto L9;
        Map<String, String> r101 = r100.f206252c;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.get("app_config");
    L9:
        return null;
    }

    @Override // com.bytedance.ee.bear.appsetting.n
    public final Map<String, Boolean> d() {
        c r100 = this.f206242e.get();
        if (r100 == null) goto L12;
        Map<String, Boolean> r101 = r100.f206251b;
        if (r101 != null) goto L8;
        return null;
    L8:
        if (r101.isEmpty() == false) goto L10;
        return null;
    L10:
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(r101);
        return r102;
    L12:
        return null;
    }

    @Override // com.bytedance.ee.bear.appsetting.n
    public final Boolean a(String r100) {
        c r101 = this.f206242e.get();
        Boolean r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r100 != null) goto L8;
        return null;
    L8:
        if (r100.length() != 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
    L20:
        return r102;
    L13:
        if (Intrinsics.areEqual(r100, "base.mobile.instanfix_enable") == true) goto L20;
        if (Intrinsics.areEqual(r100, EmergencyFixConfig.SETTING_FG) == true) goto L20;
        r102 = r101.f206251b.get(r100);
        if (r102 == null) goto L20;
        tt5.a.h("EmergencySettingFGManager", "getFixFGValue, confId: " + r101.f206250a + ", key: " + r100 + ", value: " + r102);
        goto L20
    L10:
        r103 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.appsetting.n
    public final <T> T b(Class<T> r110) {
        c r100 = this.f206242e.get();
        if (r100 != null) goto L5;
        return null;
    L5:
        AppConfig r101 = com.ss.android.lark.appsetting.api.e.a.f408951a.b(r110);
        if (r101 != null) goto L8;
        return null;
    L8:
        String r102 = r101.key();
        String r103 = r101.parse();
        boolean r104 = false;
        if (r102.length() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
    L30:
        return null;
    L14:
        if (Intrinsics.areEqual(r102, "app_config") == true) goto L30;
        T r106 = (T) ((LinkedHashMap) r100.f206253d).get(r102);
        if (r106 == null) goto L20;
        tt5.a.h("EmergencySettingFGManager", "getFixSettingObj, confId: " + r100.f206250a + ", key: " + r102);
        return r106;
    L20:
        String r107 = r100.f206252c.get(r102);
        if (r107 != null) goto L23;
    L24:
        r104 = true;
    L25:
        if (r104 == true) goto L30;
        T r111 = (T) com.ss.android.lark.appsetting.api.f.a(r110, r107, r103);
        if (r111 == null) goto L30;
        r100.f206253d.put(r102, r111);
        tt5.a.h("EmergencySettingFGManager", "getFixSettingValue, confId: " + r100.f206250a + ", key: " + r102);
        return r111;
    L23:
        if (r107.length() != 0) goto L25;
    L11:
        r105 = false;
        goto L12
    }

    public d(String r100, jdb.g r101, KVRepo r102, com.bytedance.ee.bear.bitable.preload.h r103) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "userFg");
        Intrinsics.checkNotNullParameter(r102, "userKv");
        this.f206238a = r100;
        this.f206239b = r101;
        this.f206240c = r102;
        this.f206241d = r103;
        this.f206242e = new AtomicReference();
        this.f206243f = LazyKt.lazy(new EmergencySettingFGManager$userFixConfigHandler$2(this));
        this.f206244g = new CompositeDisposable();
    }
}
