package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.larus.apm.impl.protector.RunnableProtector;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ah f464207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected SharedPreferences f1041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashSet<a> f1042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected SharedPreferences f464208b;

    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            com_xiaomi_push_service_ah$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public final void com_xiaomi_push_service_ah$a__run$___twin___() {
            onCallback();
        }

        public int hashCode() {
            return this.mId;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_xiaomi_push_service_ah$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_xiaomi_push_service_ah$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            return false;
        L5:
            if (this.mId != ((a) r100).mId) goto L9;
            return true;
        L9:
            return false;
        }

        public a(int r100, String r101) {
            this.mId = r100;
            this.mDescription = r101;
        }
    }

    public synchronized void a() {
        monitor-enter(this);
        this.f1042a.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void b() {
        com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
        HashSet r100 = new HashSet();
        monitor-enter(this);
        r100.addAll(this.f1042a);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        Iterator r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L12;
        a r102 = (a) r101.next();
        if (r102 == null) goto L8;
        r102.run();
        goto L8
    L12:
        r100.clear();
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private ah(Context r100) {
        this.f1042a = new HashSet();
        this.f1041a = r100.getSharedPreferences("mipush_oc_normal", 0);
        this.f464208b = r100.getSharedPreferences("mipush_oc_custom", 0);
    }

    public void a(List<Pair<Integer, Object>> r100) {
        if (com.xiaomi.push.y.a(r100) == false) goto L5;
        return;
    L5:
        SharedPreferences.Editor r101 = this.f464208b.edit();
        Iterator<Pair<Integer, Object>> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L15;
        Pair<Integer, Object> r103 = r102.next();
        Object r104 = r103.first;
        if (r104 == null) goto L7;
        String r105 = a(((Integer) r104).intValue());
        if (r103.second == null) goto L13;
        a(r101, r103, r105);
        goto L7
    L13:
        r101.remove(r105);
        goto L7
    L15:
        r101.apply();
    }

    public static ah a(Context r100) {
        if (f464207a != null) goto L15;
        monitor-enter(ah.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f464207a != null) goto L9;
        f464207a = new ah(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ah.class);     // Catch: Throwable -> L11
    L15:
        return f464207a;
    }

    private String a(gk r100) {
        return "oc_version_" + r100.a();
    }

    public synchronized void a(a r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f1042a.contains(r100) == true) goto L6;
        this.f1042a.add(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    private String a(int r100) {
        return "oc_" + r100;
    }

    public void a(List<Pair<gk, Integer>> r100, List<Pair<Integer, Object>> r101) {
        if (com.xiaomi.push.y.a(r100) == false) goto L5;
    L27:
        com.xiaomi.channel.commonutils.logger.b.m8718a("not update oc, because versions or configs are empty");
        return;
    L5:
        if (com.xiaomi.push.y.a(r101) == true) goto L27;
        SharedPreferences.Editor r102 = this.f1041a.edit();
        r102.clear();
        Iterator<Pair<gk, Integer>> r103 = r100.iterator();
    L9:
        if (r103.hasNext() == false) goto L16;
        Pair<gk, Integer> r104 = r103.next();
        Object r105 = r104.first;
        if (r105 == null) goto L9;
        if (r104.second == null) goto L9;
        r102.putInt(a((gk) r105), ((Integer) r104.second).intValue());
        goto L9
    L16:
        Iterator<Pair<Integer, Object>> r106 = r101.iterator();
    L18:
        if (r106.hasNext() == false) goto L25;
        Pair<Integer, Object> r107 = r106.next();
        Object r108 = r107.first;
        if (r108 == null) goto L18;
        if (r107.second == null) goto L18;
        a(r102, r107, a(((Integer) r108).intValue()));
        goto L18
    L25:
        r102.apply();
    }

    public long a(int r100, long r101) {
        String r102 = a(r100);     // Catch: Exception -> L11
        if (this.f464208b.contains(r102) == false) goto L7;
        return this.f464208b.getLong(r102, 0);
    L7:
        if (this.f1041a.contains(r102) == true) goto L9;
        return r101;
    L9:
        return this.f1041a.getLong(r102, 0);
    L11:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a(r100 + " oc long error " + e);
        return r101;
    }

    public int a(int r100, int r101) {
        String r102 = a(r100);     // Catch: Exception -> L11
        if (this.f464208b.contains(r102) == false) goto L7;
        return this.f464208b.getInt(r102, 0);
    L7:
        if (this.f1041a.contains(r102) == true) goto L9;
        return r101;
    L9:
        return this.f1041a.getInt(r102, 0);
    L11:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a(r100 + " oc int error " + e);
        return r101;
    }

    public String a(int r100, String r101) {
        String r102 = a(r100);     // Catch: Exception -> L11
        if (this.f464208b.contains(r102) == false) goto L7;
        return this.f464208b.getString(r102, null);
    L7:
        if (this.f1041a.contains(r102) == true) goto L9;
        return r101;
    L9:
        return this.f1041a.getString(r102, null);
    L11:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a(r100 + " oc string error " + e);
        return r101;
    }

    public boolean a(int r100, boolean r101) {
        String r102 = a(r100);     // Catch: Exception -> L11
        if (this.f464208b.contains(r102) == false) goto L7;
        return this.f464208b.getBoolean(r102, false);
    L7:
        if (this.f1041a.contains(r102) == true) goto L9;
        return r101;
    L9:
        return this.f1041a.getBoolean(r102, false);
    L11:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a(r100 + " oc boolean error " + e);
        return r101;
    }

    public int a(gk r100, int r101) {
        return this.f1041a.getInt(a(r100), r101);
    L4:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a(r100 + " version error " + e);
        return r101;
    }

    private void a(SharedPreferences.Editor r100, Pair<Integer, Object> r101, String r102) {
        Object r103 = r101.second;
        if ((r103 instanceof Integer) == false) goto L6;
        r100.putInt(r102, ((Integer) r103).intValue());
        return;
    L6:
        if ((r103 instanceof Long) == false) goto L9;
        r100.putLong(r102, ((Long) r103).longValue());
        return;
    L9:
        if ((r103 instanceof String) == false) goto L15;
        String r104 = (String) r103;
        if (r102.equals(a(gj.aQ.a())) == false) goto L13;
        r100.putString(r102, com.xiaomi.push.ax.a(r104));
        return;
    L13:
        r100.putString(r102, r104);
        return;
    L15:
        if ((r103 instanceof Boolean) == false) goto L22;
        r100.putBoolean(r102, ((Boolean) r103).booleanValue());
        return;
    }
}
