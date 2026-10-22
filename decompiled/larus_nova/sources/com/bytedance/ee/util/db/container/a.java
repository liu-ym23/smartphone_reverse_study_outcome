package com.bytedance.ee.util.db.container;

import android.content.Context;
import android.text.TextUtils;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import ay4.d;
import c0c.c;
import com.bytedance.ee.util.db.DBController;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.h;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import eu5.g;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.SQLException;

/* JADX INFO: loaded from: classes19.dex */
@UserScope
public final class a extends c implements com.bytedance.ee.util.db.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f243113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, HashMap<String, RoomDatabase>> f243114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, DBController.a> f243115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<WeakReference<DBController.b>> f243116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f243117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReadWriteLock f243118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f243119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f243120i;

    /* JADX INFO: renamed from: com.bytedance.ee.util.db.container.a$a, reason: collision with other inner class name */
    public static final class C3486a {
    }

    static {
    }

    @Override // com.bytedance.ee.util.db.a
    public final void M0(boolean r100) {
    }

    @Override // c0c.c
    public final void c() {
        tt5.a.h("UserDBControllerImpl", "destroy thread=" + ThreadMethodProxy.currentThread());
        s.b(this);
    }

    @Override // c0c.c
    public final void e() {
        tt5.a.h("UserDBControllerImpl", "onPrepared uid=" + p() + " thread=" + ThreadMethodProxy.currentThread());
    }

    @Override // c0c.c
    public final void k() {
        tt5.a.h("UserDBControllerImpl", "preparing uid=" + p() + " thread=" + ThreadMethodProxy.currentThread() + " mKeyListeners size=" + this.f243116e.size());
        init(p());
    }

    public final String p() {
        String r100 = this.f243113b.getUser().userId;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "default";
    L5:
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.ee.util.db.a
    public final String getKey() {
        return this.f243120i;
    }

    @Inject
    public a(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passportUserService");
        super(r100);
        this.f243114c = new ConcurrentHashMap();
        this.f243115d = new ConcurrentHashMap();
        this.f243116e = new CopyOnWriteArrayList();
        this.f243117f = true;
        this.f243118g = new ReentrantReadWriteLock();
        this.f243119h = new AtomicBoolean();
        tt5.a.h("UserDBControllerImpl", "UserDBControllerImpl dwarf user instance");
        this.f243113b = r100;
        if (eu5.c.c() == false) goto L5;
        this.f243117f = ((Boolean) new ml5.b("debug_config").a("database_encrypt", Boolean.TRUE)).booleanValue();
    L5:
        s.a(this);
    }

    @Override // com.bytedance.ee.util.db.a
    public final void e2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("offlineData.db", "sourceName");
        init(p());
        if (this.f243117f == false) goto L11;
        File r101 = r100.getDatabasePath(p() + '_' + g.a("offlineData.db"));     // Catch: Exception -> L6
        h r102 = d.a();     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L6
        FileUtils.m(r102.t(r101));     // Catch: Exception -> L6
        File r103 = r100.getDatabasePath(p() + "_encrypt_" + g.a("offlineData.db"));     // Catch: Exception -> L6
        h r104 = d.a();     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L6
        FileUtils.m(r104.t(r103));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        tt5.a.f("UserDBControllerImpl", e, false);
        return;
    }

    @Override // com.bytedance.ee.util.db.a
    public final void init(String r100) {
        if (this.f243119h.get() == false) goto L5;
        return;
    L5:
        String r101 = p();
        ((ReentrantReadWriteLock) this.f243118g).writeLock().lock();
    L30:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f243118g).writeLock().unlock();
        throw th;
    L7:
        if (this.f243119h.get() == false) goto L11;
        tt5.a.d("UserDBControllerImpl", "user id already inited.");     // Catch: Throwable -> L30
        ((ReentrantReadWriteLock) this.f243118g).writeLock().unlock();
        return;
    L11:
        tt5.a.h("UserDBControllerImpl", "init userID : " + r101);     // Catch: Throwable -> L30
        n(r101);     // Catch: Throwable -> L30
        this.f243119h.set(true);     // Catch: Throwable -> L30
        ((ReentrantReadWriteLock) this.f243118g).writeLock().unlock();
        monitor-enter(this);
        String r102 = this.f243120i;     // Catch: Throwable -> L27
        CopyOnWriteArrayList<WeakReference<DBController.b>> r103 = this.f243116e;     // Catch: Throwable -> L27
        if (r103 != null) goto L17;
    L25:
        monitor-exit(this);
        return;
    L17:
        if (r103.size() <= 0) goto L25;
        Iterator<WeakReference<DBController.b>> r104 = this.f243116e.iterator();     // Catch: Throwable -> L27
    L20:
        if (r104.hasNext() == false) goto L25;
        DBController.b r105 = r104.next().get();     // Catch: Throwable -> L27
        if (r105 == null) goto L20;
        r105.a(r102);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public final void n(String r100) {
        String r101 = du5.d.a(r100 + "_a1p2c95");
        if (TextUtils.isEmpty(r101) == true) goto L5;
        Intrinsics.checkNotNull(r101);
        this.f243120i = r101.substring(0, 8);
    L5:
        tt5.a.h("UserDBControllerImpl", "DBController  rebuildKey mKey : " + du5.b.g(this.f243120i));
    }

    @Override // com.bytedance.ee.util.db.a
    @Deprecated(message = "")
    public final <T extends RoomDatabase> T r1(String r100) {
        init(p());
        HashMap<Integer, String> r101 = ju5.a.f500491a;
        return (T) m(r100, 0);
    }

    @Override // com.bytedance.ee.util.db.a
    public final synchronized void x7(DBController.b r100) {
        monitor-enter(this);
        init(p());     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        this.f243116e.add(new WeakReference(r100));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.util.db.a
    public final String Aa(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sourceName");
        init(p());
        if (this.f243117f == false) goto L6;
        return p() + "_encrypted_" + g.a(r101);
    L6:
        return p() + '_' + g.a(r101);
    }

    @Override // com.bytedance.ee.util.db.a
    public final void W3(String r100, DBController.a r101) {
        Intrinsics.checkNotNullParameter(r101, "wrapper");
        ConcurrentHashMap<String, DBController.a> r102 = this.f243115d;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.put(r100, r101);
    }

    public final <T extends RoomDatabase> T m(String r110, int r111) {
        init(p());
        DBController.a r100 = this.f243115d.get(r110);
        if (r100 == null) goto L48;
        ((ReentrantReadWriteLock) this.f243118g).readLock().lock();
        String r101 = p();
        String r102 = this.f243120i;
        ((ReentrantReadWriteLock) this.f243118g).readLock().unlock();
        if (TextUtils.isEmpty(r101) == true) goto L45;
        HashMap<String, RoomDatabase> r103 = this.f243114c.get(r101);
        if (r103 != null) goto L9;
        r103 = new HashMap();
        this.f243114c.put(r101, r103);
    L9:
        T r104 = (T) r103.get(r110);
        if (r104 == null) goto L49;
    L44:
        return (T) r104;
    L49:
        RoomDatabase.Builder r105 = Room.databaseBuilder(r100.getContext(), r100.f243100b, Aa(r100.getContext(), r100.f243099a));     // Catch: Exception -> L26 SQLException -> L28
        List<Migration> r106 = r100.f243103e;     // Catch: Exception -> L26 SQLException -> L28
        if (r106 == null) goto L18;
        Iterator r107 = ((ArrayList) r106).iterator();     // Catch: Exception -> L26 SQLException -> L28
    L16:
        if (r107.hasNext() == false) goto L18;
        r105.addMigrations(new Migration[]{(Migration) r107.next()});     // Catch: Exception -> L26 SQLException -> L28
    L18:
        RoomDatabase.Callback r108 = r100.f243102d;     // Catch: Exception -> L26 SQLException -> L28
        if (r108 == null) goto L22;
        r105.addCallback(r108);     // Catch: Exception -> L26 SQLException -> L28
    L22:
        if (r100.f243104f == false) goto L24;
        ju5.a.a(r105, r102, r111);     // Catch: Exception -> L26 SQLException -> L28
    L24:
        r104 = (T) r105.setJournalMode(r100.f243105g).fallbackToDestructiveMigration().build();
        tt5.a.h("UserDBControllerImpl", "DBController  get db, type = " + r110 + ", userID = " + r101 + ", key = " + du5.b.g(r102) + ", cipher config = " + r111);     // Catch: Exception -> L26 SQLException -> L28
        r104.getOpenHelper().getWritableDatabase();     // Catch: Exception -> L26 SQLException -> L28
    L43:
        r103.put(r110, r104);
        goto L44
    L28:
        e = move-exception;
        tt5.a.d("UserDBControllerImpl", "catches SQLException");
        HashMap<Integer, String> r109 = ju5.a.f500491a;
        if (e.getMessage() != null) goto L32;
    L37:
        int r112 = -2;
    L38:
        if (r112 != (-2)) goto L40;
        tt5.a.d("UserDBControllerImpl", "this excp is not relates to cipher config");
        iu5.d.c(e);
        goto L43
    L40:
        if (r112 != (-1)) goto L42;
        tt5.a.d("UserDBControllerImpl", "there is no other fallback cipher configs for usage");
        iu5.d.c(e);
        goto L43
    L42:
        tt5.a.h("UserDBControllerImpl", "find available fallback configs = " + r112);
        r104 = m(r110, r112);
        goto L43
    L32:
        if (e.getMessage().contains("file is not a database") == false) goto L37;
        tt5.a.h("CipherDBUtils", "tryGetFallBackConfig... detect file is not db error, this is due to the wrong settings of cipher config, current config = " + r111);
        r112 = r111 + 1;
        if (ju5.a.f500491a.containsKey(Integer.valueOf(r112)) == false) goto L36;
        tt5.a.h("CipherDBUtils", "tryGetFallBackConfig... ready to fallback with config" + r112);
        goto L38
    L36:
        r112 = -1;
    L26:
        e = move-exception;
        iu5.d.c(e);
        goto L43
    L45:
        tt5.a.d("UserDBControllerImpl", "getDB... get db with empty userId with type : ".concat(r110));
        throw new DBController.GetDBException("You can`t getDB when db is not init. Please check your method sequence with DBController.init(). type = ".concat(r110));
    L48:
        throw new RuntimeException("DBBuildWrapper is null.You must register it before use DB");
    }
}
