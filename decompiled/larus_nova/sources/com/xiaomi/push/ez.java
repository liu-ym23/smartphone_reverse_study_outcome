package com.xiaomi.push;

import android.os.SystemClock;
import android.util.Pair;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.xiaomi.push.service.XMPushService;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ez {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f463514a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected int f548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected long f549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected fa f550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected fi f551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected XMPushService f552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected String f553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Collection<fc> f554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected final Map<fe, a> f556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f463515b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected volatile long f557b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected String f558b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected final Map<fe, a> f559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f463516c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    protected volatile long f560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f463517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f463518e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private fe f463519a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private fj f561a;

        public void a(fn r100) {
            fj r101 = this.f561a;
            if (r101 != null) goto L5;
        L6:
            this.f463519a.a(r100);
            return;
        L5:
            if (r101.mo8908a(r100) == true) goto L6;
        }

        public void a(eq r100) {
            this.f463519a.a(r100);
        }

        public a(fe r100, fj r101) {
            this.f463519a = r100;
            this.f561a = r101;
        }
    }

    private String a(int r100) {
        if (r100 != 1) goto L6;
        return PTYSocketStateCallback.CONNECTED;
    L6:
        if (r100 != 0) goto L10;
        return PTYSocketStateCallback.CONNECTING;
    L10:
        if (r100 != 2) goto L13;
        return "disconnected";
    L13:
        return "unknown";
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public abstract void a(fn r100);

    public abstract void a(com.xiaomi.push.service.am.b r100);

    public abstract void a(String r100, String r101);

    public abstract void a(eq[] r100);

    /* JADX INFO: renamed from: a */
    public boolean mo9075a() {
        return false;
    }

    public abstract void b(int r100, Exception r101);

    public abstract void b(eq r100);

    public abstract void b(boolean r100);

    public synchronized void c() {
        monitor-enter(this);
        this.f463518e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f463514a = new AtomicInteger(0);
        f547a = false;
        f547a = Boolean.getBoolean("smack.debugEnabled");     // Catch: Exception -> L6
    L4:
        ff.m9091a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo9082a() {
        return this.f550a.c();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m9085b() {
        if (this.f550a.m9089a() == true) goto L5;
        return;
    L5:
        if (this.f551a != null) goto L30;
        Class r100 = null;
        String r101 = System.getProperty("smack.debuggerClass");     // Catch: Throwable -> L9
    L10:
        if (r101 != null) goto L26;
    L15:
        if (r100 != null) goto L24;
        this.f551a = new ey(this);
        return;
    L24:
        this.f551a = (fi) r100.getConstructor(new Class[]{ez.class, Writer.class, Reader.class}).newInstance(new Object[]{this});     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        throw new IllegalArgumentException("Can't initialize the configured debugger!", e);
    L26:
        r100 = INVOKESTATIC_com_xiaomi_push_ez_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L9:
        r101 = null;
        goto L10
    }

    public void d() {
        LinkedList<Pair<Integer, Long>> r100 = this.f555a;
        monitor-enter(r100);
        this.f555a.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int a() {
        return this.f548a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9086b() {
        if (this.f463516c != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9087c() {
        if (this.f463516c == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m9080a() {
        return this.f560c;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m9084b() {
        return this.f550a.b();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public fa m9081a() {
        return this.f550a;
    }

    public int b() {
        return this.f463516c;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<fe, a> m9083a() {
        return this.f556a;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_xiaomi_push_ez_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m9079a(int r100) {
        LinkedList<Pair<Integer, Long>> r101 = this.f555a;
        monitor-enter(r101);
        if (r100 != 1) goto L7;
        this.f555a.clear();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L7:
        this.f555a.add(new Pair(Integer.valueOf(r100), Long.valueOf(System.currentTimeMillis())));     // Catch: Throwable -> L12
        if (this.f555a.size() <= 6) goto L10;
        this.f555a.remove(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void b(fc r100) {
        this.f554a.remove(r100);
    }

    public synchronized void a(String r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f463516c != 0) goto L7;
        com.xiaomi.channel.commonutils.logger.b.m8718a("setChallenge hash = " + az.a(r100).substring(0, 8));     // Catch: Throwable -> L10
        this.f553a = r100;     // Catch: Throwable -> L10
        a(1, 0, null);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L7:
        com.xiaomi.channel.commonutils.logger.b.m8718a("ignore setChallenge because connection was disconnected");     // Catch: Throwable -> L10
        goto L8
    }

    public void b(fe r100) {
        this.f559b.remove(r100);
    }

    public void a(fc r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f554a.contains(r100) == true) goto L8;
        this.f554a.add(r100);
        return;
    }

    public synchronized boolean a(long r100) {
        monitor-enter(this);
        if (this.f463518e < r100) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public void a(fe r100) {
        this.f556a.remove(r100);
    }

    public ez(XMPushService r100, fa r101) {
        this.f548a = 0;
        this.f549a = -1;
        this.f557b = 0;
        this.f560c = 0;
        this.f555a = new LinkedList();
        this.f554a = new CopyOnWriteArrayList();
        this.f556a = new ConcurrentHashMap();
        this.f559b = new ConcurrentHashMap();
        this.f551a = null;
        this.f553a = "";
        this.f558b = "";
        this.f463516c = 2;
        this.f463515b = f463514a.getAndIncrement();
        this.f463518e = 0;
        this.f463517d = 0;
        this.f550a = r101;
        this.f552a = r100;
        m9085b();
    }

    public void a(fe r100, fj r101) {
        if (r100 == null) goto L6;
        a r102 = new a(r100, r101);
        this.f556a.put(r100, r102);
        return;
    L6:
        throw new NullPointerException("Packet listener is null.");
    }

    public void b(fe r100, fj r101) {
        if (r100 == null) goto L6;
        a r102 = new a(r100, r101);
        this.f559b.put(r100, r102);
        return;
    L6:
        throw new NullPointerException("Packet listener is null.");
    }

    public void a(int r100, int r101, Exception r102) {
        int r103 = this.f463516c;
        if (r100 == r103) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a(String.format("update the connection status. %1$s -> %2$s : %3$s ", new Object[]{a(r103), a(r100), com.xiaomi.push.service.an.a(r101)}));
    L6:
        if (at.m8819a(this.f552a) == false) goto L9;
        m9079a(r100);
    L9:
        if (r100 != 1) goto L17;
        this.f552a.a(10);
        if (this.f463516c == 0) goto L13;
        com.xiaomi.channel.commonutils.logger.b.m8718a("try set connected while not connecting.");
    L13:
        this.f463516c = r100;
        Iterator<fc> r104 = this.f554a.iterator();
    L15:
        if (r104.hasNext() == false) goto L50;
        r104.next().b(this);
        goto L15
    L50:
        return;
    L17:
        if (r100 == 0) goto L19;
        if (r100 != 2) goto L49;
        this.f552a.a(10);
        int r105 = this.f463516c;
        if (r105 != 0) goto L36;
        Iterator<fc> r106 = this.f554a.iterator();
    L30:
        if (r106.hasNext() == false) goto L41;
        fc r107 = r106.next();
        if (r102 != null) goto L34;
        Exception r108 = new CancellationException("disconnect while connecting");
    L35:
        r107.a(this, r108);
        goto L30
    L34:
        r108 = r102;
    L41:
        this.f463516c = r100;
        return;
    L36:
        if (r105 != 1) goto L41;
        Iterator<fc> r109 = this.f554a.iterator();
    L39:
        if (r109.hasNext() == false) goto L41;
        r109.next().a(this, r101, r102);
        goto L39
    L49:
        return;
    L19:
        if (this.f463516c == 2) goto L21;
        com.xiaomi.channel.commonutils.logger.b.m8718a("try set connecting while not disconnected.");
    L21:
        this.f463516c = r100;
        Iterator<fc> r110 = this.f554a.iterator();
    L23:
        if (r110.hasNext() == false) goto L51;
        r110.next().a(this);
        goto L23
    }
}
