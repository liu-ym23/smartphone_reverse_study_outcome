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

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, String> f233889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f233890b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a$a, reason: collision with other inner class name */
    public static final class C3358a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f233891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f233892b;

        public b(a r100, String r101) {
            this.f233891a = r100;
            this.f233892b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            a r102 = this.f233891a;
            monitor-enter(r102);
            String r103 = ay4.b.d("permission_offline", 6).getString("cache_data", "");     // Catch: Throwable -> L22
            if (r103 != null) goto L7;
            r103 = "";
        L7:
            String r104 = du5.b.d(r103);     // Catch: Throwable -> L22
            OfflinePermissionModel r105 = (OfflinePermissionModel) GsonProtectorUtils.fromJson(new Gson(), r104, OfflinePermissionModel.class);     // Catch: Throwable -> L22
            r102.f233890b.set(true);     // Catch: Throwable -> L22
            if (r105 != null) goto L12;
            tt5.a.h("PermissionOfflineCache", "empty offline data");     // Catch: Throwable -> L22
            monitor-exit(r102);
        L18:
            a r106 = this.f233891a;
            String r107 = this.f233892b;
            String r108 = r106.f233889a.get(r107);
            if (r108 != null) goto L27;
            return "";
        L27:
            return r108;
        L12:
            Iterator<OfflinePermissionModel.PermissionData> r109 = r105.getData().iterator();     // Catch: Throwable -> L22
        L14:
            if (r109.hasNext() == false) goto L16;
            OfflinePermissionModel.PermissionData r110 = r109.next();     // Catch: Throwable -> L22
            r102.f233889a.put(r110.getToken(), r110.getPermission());     // Catch: Throwable -> L22
            goto L14
        L16:
            tt5.a.b("PermissionOfflineCache", "loadSpData success");     // Catch: Throwable -> L22
            monitor-exit(r102);
        L22:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public a() {
        this.f233889a = new LruCache(50);
        this.f233890b = new AtomicBoolean(false);
        tt5.a.h("PermissionOfflineCache", "doInit");
        b("").subscribe(d.f572192a, e.f572193a);
    }

    public final Flowable<String> b(String r100) {
        tt5.a.h("PermissionOfflineCache", "loadSpDataFlowable start");
        return Flowable.just("").subscribeOn(fo5.d.b()).map(new b(this, r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.OfflinePermissionModel] */
    public final void a(String r100, String r101) {
        boolean r102 = true;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L21:
        StringBuilder r103 = new StringBuilder("invalidateCache ");
        if (r100 == null) goto L25;
        r102 = false;
    L25:
        r103.append(r102);
        tt5.a.d("PermissionOfflineCache", r103.toString());
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        this.f233889a.put(r100, r101);
        tt5.a.h("PermissionOfflineCache", "asyncSaveData start");
        Map<String, String> r104 = this.f233889a.snapshot();
        if (r104 != null) goto L10;
        return;
    L10:
        if ((!r104.isEmpty()) == false) goto L29;
        Ref.ObjectRef r105 = new Ref.ObjectRef();
        r105.element = new OfflinePermissionModel();
        CopyOnWriteArrayList<OfflinePermissionModel.PermissionData> r106 = new CopyOnWriteArrayList();
        Iterator<Map.Entry<String, String>> r107 = r104.entrySet().iterator();
    L13:
        if (r107.hasNext() == false) goto L15;
        Map.Entry<String, String> r108 = r107.next();
        OfflinePermissionModel.PermissionData r109 = new OfflinePermissionModel.PermissionData();
        r109.setToken(r108.getKey());
        r109.setPermission(r108.getValue());
        r106.add(r109);
        goto L13
    L15:
        ((OfflinePermissionModel) r105.element).setData(r106);
        if (this.f233890b.get() == false) goto L18;
        long r110 = 0;
    L19:
        Flowable.just("").subscribeOn(fo5.d.b()).delay(r110, TimeUnit.SECONDS).map(new zh5.a(this, r105)).subscribe(zh5.b.f572190a, c.f572191a);
        return;
    L18:
        r110 = 3;
        goto L19
    }
}
