package com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Ref;
import zh5.c;
import zh5.d;
import zh5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final LruCache<String, String> a;
    public final AtomicBoolean b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a$a, reason: collision with other inner class name */
    public static final class C0111a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public b(a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r5) {
            String r6 = (String) r5;
            a r7 = this.a;
            monitor-enter(r7);
            String r0 = ay4.b.d("permission_offline", 6).getString("cache_data", "");     // Catch: Throwable -> L22
            if (r0 != null) goto L7;
            r0 = "";
        L7:
            String r1 = du5.b.d(r0);     // Catch: Throwable -> L22
            OfflinePermissionModel r2 = (OfflinePermissionModel) GsonProtectorUtils.fromJson(new Gson(), r1, OfflinePermissionModel.class);     // Catch: Throwable -> L22
            r7.b.set(true);     // Catch: Throwable -> L22
            if (r2 != null) goto L12;
            tt5.a.h("PermissionOfflineCache", "empty offline data");     // Catch: Throwable -> L22
            monitor-exit(r7);
        L18:
            a r8 = this.a;
            String r3 = this.b;
            String r9 = r8.a.get(r3);
            if (r9 != null) goto L27;
            return "";
        L27:
            return r9;
        L12:
            Iterator<OfflinePermissionModel.PermissionData> r4 = r2.getData().iterator();     // Catch: Throwable -> L22
        L14:
            if (r4.hasNext() == false) goto L16;
            OfflinePermissionModel.PermissionData r10 = r4.next();     // Catch: Throwable -> L22
            r7.a.put(r10.getToken(), r10.getPermission());     // Catch: Throwable -> L22
            goto L14
        L16:
            tt5.a.b("PermissionOfflineCache", "loadSpData success");     // Catch: Throwable -> L22
            monitor-exit(r7);
        L22:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public a() {
        this.a = new LruCache(50);
        this.b = new AtomicBoolean(false);
        tt5.a.h("PermissionOfflineCache", "doInit");
        b("").subscribe(d.a, e.a);
    }

    public final Flowable<String> b(String r3) {
        tt5.a.h("PermissionOfflineCache", "loadSpDataFlowable start");
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new b(this, r3));
    }

    public final void a(String r5, String r6) {
        boolean r1 = true;
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L21:
        StringBuilder r7 = new StringBuilder("invalidateCache ");
        if (r5 == null) goto L25;
        r1 = false;
    L25:
        r7.append(r1);
        tt5.a.d("PermissionOfflineCache", r7.toString());
        return;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L21;
        this.a.put(r5, r6);
        tt5.a.h("PermissionOfflineCache", "asyncSaveData start");
        Map<String, String> r8 = this.a.snapshot();
        if (r8 != null) goto L10;
        return;
    L10:
        if ((!r8.isEmpty()) == false) goto L29;
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = new OfflinePermissionModel();
        CopyOnWriteArrayList<OfflinePermissionModel.PermissionData> r0 = new CopyOnWriteArrayList();
        Iterator<Map.Entry<String, String>> r10 = r8.entrySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L15;
        Map.Entry<String, String> r2 = r10.next();
        OfflinePermissionModel.PermissionData r3 = new OfflinePermissionModel.PermissionData();
        r3.setToken(r2.getKey());
        r3.setPermission(r2.getValue());
        r0.add(r3);
        goto L13
    L15:
        ((OfflinePermissionModel) r9.element).setData(r0);
        if (this.b.get() == false) goto L18;
        long r4 = 0;
    L19:
        Flowable.just("").subscribeOn(fo5.d.b()).delay(r4, TimeUnit.SECONDS).map(new zh5.a(this, r9)).subscribe(zh5.b.a, c.a);
        return;
    L18:
        r4 = 3;
        goto L19
    }
}
