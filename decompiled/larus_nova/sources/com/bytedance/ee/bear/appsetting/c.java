package com.bytedance.ee.bear.appsetting;

import com.alibaba.fastjson.JSON;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<m> f206235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cn4.a f206236b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f206237a = null;

        static {
            f206237a = new c();
        }
    }

    public final void b() {
        tt5.a.h("AppSetting", "fetch app setting");
        Iterator r100 = ((ConcurrentSkipListSet) this.f206235a).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((m) r100.next()).c();
        goto L4
    }

    public c() {
        ConcurrentSkipListSet r100 = new ConcurrentSkipListSet(new com.bytedance.ee.bear.appsetting.a());
        this.f206235a = r100;
        this.f206236b = new cn4.a(r100);
    }

    public final void a(m r100) {
        ((ConcurrentSkipListSet) this.f206235a).add(r100);
    }

    public final boolean f(String r100) {
        return ((Boolean) this.f206236b.a(r100, Boolean.FALSE, false, true)).booleanValue();
    }

    public final boolean g(String r100) {
        return ((Boolean) this.f206236b.a(r100, Boolean.FALSE, false, true)).booleanValue();
    }

    public final boolean h(String r100) {
        return ((Boolean) this.f206236b.a(r100, Boolean.FALSE, true, true)).booleanValue();
    }

    public final boolean j(String r100) {
        return ((Boolean) this.f206236b.a(r100, Boolean.FALSE, false, false)).booleanValue();
    }

    public final <T> T d(String r100, T r101) {
        if (r101 != null) goto L6;
        tt5.a.k("AppSetting", "getValue, defValue is null");
        return null;
    L6:
        return (T) this.f206236b.a(r100, r101, true, true);
    }

    public final boolean i(String r100, boolean r101) {
        return ((Boolean) this.f206236b.a(r100, Boolean.valueOf(r101), true, true)).booleanValue();
    }

    public final <T extends NonProguard> T c(String r100, Class<T> r101, T r102) {
        cn4.a r103 = this.f206236b;
        r103.getClass();
        cn4.a.C0469a r104 = new cn4.a.C0469a(r100, r101, false);
        Object r105 = ((ConcurrentHashMap) r103.f24510c).get(r104);
        if (r105 == null) goto L6;
        return (T) r105;
    L6:
        if (r102 != null) goto L21;
    L11:
        String r106 = SliceInitService.DEFAULT_SWITCH;
    L23:
        T r107 = (T) JSON.parseObject((String) r103.a(r100, r106, true, true), r101);     // Catch: Throwable -> L18
        if (r107 == null) goto L16;
        ((ConcurrentHashMap) r103.f24510c).put(r104, r107);     // Catch: Throwable -> L18
    L16:
        if (r107 != null) goto L27;
        return r102;
    L27:
        return r107;
    L18:
        th = move-exception;
        tt5.a.e("AppSettingDataManager", "getValue, fastJson parseObject fail", th, false);
        return r102;
    L21:
        r106 = JSON.toJSONString(r102);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        tt5.a.e("AppSettingDataManager", "getValue, fastJson toJsonString fail", th, false);
        goto L11
    }

    public final <T> List<T> e(String r100, Class<T> r101, List<T> r110) {
        cn4.a r102 = this.f206236b;
        r102.getClass();
        cn4.a.C0469a r103 = new cn4.a.C0469a(r100, r101, true);
        Object r104 = ((ConcurrentHashMap) r102.f24510c).get(r103);
        if (r104 == null) goto L6;
        return (List) r104;
    L6:
        if (r110 != null) goto L22;
    L11:
        String r105 = "[]";
    L24:
        List<T> r106 = JSON.parseArray((String) r102.a(r100, r105, true, true), r101);     // Catch: Throwable -> L19
        if (r106 == null) goto L15;
        ((ConcurrentHashMap) r102.f24510c).put(r103, r106);     // Catch: Throwable -> L19
    L15:
        if (hu5.a.d(r106) == false) goto L27;
        return r110;
    L27:
        return r106;
    L19:
        th = move-exception;
        tt5.a.e("AppSettingDataManager", "getValue, fastJson parseObject fail", th, false);
        return r110;
    L22:
        r105 = JSON.toJSONString(r110);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        tt5.a.e("AppSettingDataManager", "getValueArray, fastJson toJsonString fail", th, false);
        goto L11
    }
}
