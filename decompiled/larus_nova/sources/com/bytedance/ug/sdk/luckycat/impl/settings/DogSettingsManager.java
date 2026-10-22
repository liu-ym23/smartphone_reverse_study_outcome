package com.bytedance.ug.sdk.luckycat.impl.settings;

import android.content.Context;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.ug.sdk.luckycat.impl.utils.u;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import zl7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class DogSettingsManager implements n<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f271476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f271477b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f271478c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<n<d>> f271479d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile i f271480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DogSettingsManager f271481f = null;

    /* JADX INFO: loaded from: classes22.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f271482a;

        public a(d r100) {
            this.f271482a = r100;
        }

        public final void a() {
            u r100 = u.a();
            DogSettingsManager.f271481f.getClass();
            Lazy r101 = DogSettingsManager.f271478c;
            KProperty r102 = DogSettingsManager.f271476a[0];
            r100.g("dog_activity_settings", GsonProtectorUtils.toJson((Gson) r101.getValue(), this.f271482a));
            List<n<d>> r103 = DogSettingsManager.f271479d;
            monitor-enter(r103);
            Iterator r104 = ((ArrayList) r103).iterator();     // Catch: Throwable -> L15
        L6:
            if (r104.hasNext() == false) goto L12;
            n r105 = (n) r104.next();     // Catch: Throwable -> L15
            KProperty[] r106 = DogSettingsManager.f271476a;     // Catch: Throwable -> L15
            i r107 = DogSettingsManager.f271480e;     // Catch: Throwable -> L15
            if (r107 == null) goto L10;
            d r108 = r107.f271486a;     // Catch: Throwable -> L15
        L11:
            r105.update(r108);     // Catch: Throwable -> L15
            goto L6
        L10:
            r108 = null;
            goto L11
        L12:
            Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(r103);
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f271483a = null;

        static {
            f271483a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<n<d>> r100 = DogSettingsManager.f271479d;     // Catch: Throwable -> L14
            monitor-enter(r100);     // Catch: Throwable -> L14
            Iterator r101 = ((ArrayList) r100).iterator();     // Catch: Throwable -> L11
        L6:
            if (r101.hasNext() == false) goto L8;
            ((n) r101.next()).update();     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L14
            return;
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }
    }

    static {
        f271476a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DogSettingsManager.class), "mGson", "getMGson()Lcom/google/gson/Gson;"))};
        f271481f = new DogSettingsManager();
        f271477b = new AtomicBoolean(false);
        f271478c = LazyKt.lazy(DogSettingsManager$mGson$2.INSTANCE);
        f271479d = new ArrayList();
    }

    public DogSettingsManager() {
    }

    @Override // zl7.n
    public final /* synthetic */ void a() {
    }

    @Override // zl7.n
    public void update() {
        rj7.a.f538124a.submit(b.f271483a);
    }

    public final d b(Context r100) {
        if (f271480e != null) goto L26;
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L6:
        if (f271480e != null) goto L18;
        String r101 = u.b(r100, "luckycat_product_configs.prefs").c("dog_activity_settings", "");     // Catch: Throwable -> L23
        if (r101.length() <= 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L18;
        f271481f.getClass();     // Catch: Exception -> L15 Throwable -> L23
        Lazy r103 = f271478c;     // Catch: Exception -> L15 Throwable -> L23
        KProperty r104 = f271476a[0];     // Catch: Exception -> L15 Throwable -> L23
        f271480e = new i((d) ((Gson) r103.getValue()).fromJson(r101, d.class), r101);     // Catch: Exception -> L15 Throwable -> L23
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
        goto L18
    L11:
        r102 = false;
    L18:
        if (f271480e != null) goto L20;
        f271480e = new i(new d(), "");     // Catch: Throwable -> L23
    L20:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(this);
    L26:
        i r106 = f271480e;
        if (r106 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        return r106.f271486a;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(JSONObject r100) {
        if (r100 == null) goto L17;
        Lazy r101 = f271478c;     // Catch: Exception -> L11
        KProperty r102 = f271476a[0];     // Catch: Exception -> L11
        d r103 = (d) ((Gson) r101.getValue()).fromJson(r100.toString(), d.class);     // Catch: Exception -> L11
        monitor-enter(this);     // Catch: Exception -> L11
        f271480e = new i(r103, r100.toString());     // Catch: Throwable -> L8
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Exception -> L11
        rj7.a.f538124a.submit(new a(r103));     // Catch: Exception -> L11
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // zl7.n
    public /* bridge */ /* synthetic */ void update(JSONObject r100) {
        update2(r100);
    }
}
