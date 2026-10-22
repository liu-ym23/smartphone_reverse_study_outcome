package com.lynx.clay.embedding.engine.plugins.audio.soundpool;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.FileDescriptor;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements GenericSoundPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<com.lynx.clay.embedding.engine.plugins.audio.soundpool.b> f380783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerC4549a f380784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f380785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PThreadPoolExecutor f380786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f380787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Queue<com.lynx.clay.embedding.engine.plugins.audio.soundpool.b.a> f380788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Queue<com.lynx.clay.embedding.engine.plugins.audio.soundpool.b> f380789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f380790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GenericSoundPool.b f380791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f380792j;

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.audio.soundpool.a$a, reason: collision with other inner class name */
    public final class HandlerC4549a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f380793a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            boolean r101 = true;
            if (r100.what != 1) goto L12;
            GenericSoundPool.b r102 = this.f380793a.f380791i;
            if (r102 == null) goto L13;
            int r103 = r100.arg1;
            if (r100.arg2 == 1) goto L10;
            r101 = false;
        L10:
            String r104 = (String) r100.obj;
            ((com.lynx.clay.embedding.engine.plugins.audio.a.C4547a) r102).a(r103, r101);
            return;
        L13:
            return;
        }

        public HandlerC4549a(a r100, Looper r101) {
            this.f380793a = r100;
            super(r101);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f380794a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r4v6, types: [android.os.Handler, com.lynx.clay.embedding.engine.plugins.audio.soundpool.a$a] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            if (this.f380794a.f380788f.isEmpty() == true) goto L5;
        L7:
            Thread r100 = ThreadMethodProxy.currentThread();
            if (r100.getPriority() == 5) goto L10;
            ThreadMethodProxy.setPriority(r100, 5);
        L10:
            com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r101 = (com.lynx.clay.embedding.engine.plugins.audio.soundpool.b) ((LinkedBlockingQueue) this.f380794a.f380789g).poll();
            ?? r102 = 0;
            r102 = 0;
            if (r101 != null) goto L54;
            boolean r103 = false;
        L18:
            if (r103 == true) goto L43;
            com.lynx.clay.embedding.engine.plugins.audio.soundpool.b.a r104 = (com.lynx.clay.embedding.engine.plugins.audio.soundpool.b.a) ((LinkedBlockingQueue) this.f380794a.f380788f).poll();
            if (r104 == null) goto L43;
            com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r105 = this.f380794a.f380783a.get(r104.f380818a);
            String r110 = null;
            if (r105 == null) goto L37;
            Context r106 = this.f380794a.f380790h;     // Catch: Exception -> L34
            if (r104.f380819b == 0) goto L27;
            AssetFileDescriptor r107 = r106.getResources().openRawResourceFd(r104.f380819b);     // Catch: Exception -> L34
            long r108 = r107.getStartOffset();     // Catch: Exception -> L34
            long r109 = r107.getLength();     // Catch: Exception -> L34
            FileDescriptor r111 = r107.getFileDescriptor();     // Catch: Exception -> L34
        L30:
            long r112 = r109;
            long r113 = r108;
            FileDescriptor r114 = r111;
        L32:
            r102 = r105.a(r114, r113, r112);     // Catch: Exception -> L34
            goto L37
        L27:
            r108 = 0;
            if (TextUtils.isEmpty(r104.f380820c) == true) goto L31;
            PolarisFileWrapper r115 = new PolarisFileWrapper(r104.f380820c);     // Catch: Exception -> L34
            ParcelFileDescriptor r116 = ParcelFileDescriptor.open(r115, 268435456);     // Catch: Exception -> L34
            long r117 = r115.length();     // Catch: Exception -> L34
            r111 = r116.getFileDescriptor();     // Catch: Exception -> L34
            r109 = r117;
            goto L30
        L31:
            r112 = 0;
            r113 = 0;
            r114 = null;
        L34:
            e = move-exception;
            e.printStackTrace();
            r110 = e.getMessage();
        L37:
            if (this.f380794a.f380784b == null) goto L43;
            if (r105 == null) goto L43;
            if (r105.f380816r == true) goto L43;
            ?? r118 = this.f380794a.f380784b;
            r118.sendMessage(r118.obtainMessage(1, r104.f380818a, r102, r110));
        L43:
            if (r100.isInterrupted() == false) goto L45;
            return;
        L45:
            if (this.f380794a.f380789g.isEmpty() == true) goto L47;
        L50:
            a r119 = this.f380794a;
            r119.f380785c.post(r119.f380787e);
            return;
        L47:
            if (this.f380794a.f380788f.isEmpty() == false) goto L50;
            ThreadMethodProxy.setPriority(r100, 1);
            return;
        L54:
            r101.close();     // Catch: Exception -> L15
        L17:
            r103 = true;
        L15:
            e = move-exception;
            e.printStackTrace();
            goto L17
        L5:
            if (this.f380794a.f380789g.isEmpty() == false) goto L7;
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

        public b(a r100) {
            this.f380794a = r100;
        }
    }

    public static class c implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f380795d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f380796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f380797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f380798c;

        static {
            f380795d = new AtomicInteger(1);
        }

        public c() {
            this.f380797b = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.f380796a = r101;
            this.f380798c = "pool-" + f380795d.getAndIncrement() + "-thread-sound-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.f380796a, r100, this.f380798c + this.f380797b.getAndIncrement(), 0);
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 10) goto L8;
            ThreadMethodProxy.setPriority(r101, 10);
        L8:
            return r101;
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void a() {
        int r100 = this.f380783a.size();
    L3:
        r100 = r100 - 1;
        if (r100 < 0) goto L11;
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r101 = this.f380783a.valueAt(r100);
        PThreadPoolExecutor r102 = this.f380786d;
        r101.getClass();
        c5a.c.c("SoundSample", "resume");
        AudioTrack r103 = r101.f380802d;
        if (r103 == null) goto L3;
        if (r103.getPlayState() != 2) goto L3;
        r102.execute(r101.f380800b);
        goto L3
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void f() {
        int r100 = this.f380783a.size() - 1;
    L3:
        if (r100 < 0) goto L5;
        this.f380783a.valueAt(r100).c();
        r100 = r100 - 1;
        goto L3
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void release() {
        this.f380785c.removeCallbacksAndMessages(null);
        ThreadMethodProxy.quit(this.f380785c.getLooper());
        ((LinkedBlockingQueue) this.f380789g).clear();
        int r100 = this.f380783a.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L11;
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r102 = this.f380783a.valueAt(r101);     // Catch: Exception -> L8
        if (r102 == null) goto L10;
        r102.h();     // Catch: Exception -> L8
        r102.close();     // Catch: Exception -> L8
    L10:
        r101 = r101 + 1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L11:
        this.f380783a.clear();
        ((LinkedBlockingQueue) this.f380789g).clear();
        this.f380786d.shutdown();
        this.f380792j = 0;
    }

    public a(Context r110) {
        this.f380790h = r110;
        this.f380783a = new SparseArray(1);
        PthreadHandlerThreadV2 r111 = new PthreadHandlerThreadV2("SoundLoadWorker", 10);
        ThreadMethodProxy.start(r111);
        this.f380785c = new Handler(r111.getLooper());
        this.f380786d = new PThreadPoolExecutor(4, 8, 2, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c());
        this.f380787e = new b(this);
        this.f380788f = new LinkedBlockingQueue();
        this.f380789g = new LinkedBlockingQueue();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void b(com.lynx.clay.embedding.engine.plugins.audio.a.C4547a r100) {
        this.f380784b = new HandlerC4549a(this, Looper.getMainLooper());
        this.f380791i = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final int load(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L8:
        return -1;
    L5:
        if (this.f380783a.size() == 1) goto L8;
        int r101 = this.f380792j + 1;
        this.f380792j = r101;
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r102 = new com.lynx.clay.embedding.engine.plugins.audio.soundpool.b();
        this.f380783a.append(r101, r102);
        this.f380788f.add(new com.lynx.clay.embedding.engine.plugins.audio.soundpool.b.a(r101, r100));
        this.f380785c.post(this.f380787e);
        return r101;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void pause(int r100) {
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r101 = this.f380783a.get(r100);
        if (r101 == null) goto L6;
        r101.c();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void resume(int r100) {
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r101 = this.f380783a.get(r100);
        if (r101 == null) goto L11;
        PThreadPoolExecutor r102 = this.f380786d;
        c5a.c.c("SoundSample", "resume");
        AudioTrack r103 = r101.f380802d;
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.getPlayState() != 2) goto L13;
        r102.execute(r101.f380800b);
        return;
    L13:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void stop(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r101 = this.f380783a.get(r100);
        if (r101 == null) goto L8;
        r101.h();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void c(int r100, int r101) {
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r102 = this.f380783a.get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f380802d != null) goto L8;
        return;
    L8:
        if (r101 < (-1)) goto L17;
        if (r101 != (-1)) goto L12;
        int r103 = Integer.MAX_VALUE;
    L13:
        r102.f380810l = r103;
        return;
    L12:
        r103 = r101 + 1;
        goto L13
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final void e(int r100, float r101, float r102) {
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r103 = this.f380783a.get(r100);
        if (r103 == null) goto L6;
        r103.f(r101, r102);
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.soundpool.GenericSoundPool
    public final int d(int r100, float r101, float r102, int r103) {
        com.lynx.clay.embedding.engine.plugins.audio.soundpool.b r104 = this.f380783a.get(r100);
        if (r104 != null) goto L5;
        return -1;
    L5:
        PThreadPoolExecutor r105 = this.f380786d;
        c5a.c.c("SoundSample", "play");
        AudioTrack r106 = r104.f380802d;
        if (r106 != null) goto L8;
    L25:
        return r100;
    L8:
        if (r106.getPlayState() == 3) goto L25;
        r104.f(r101, r102);
        AudioTrack r107 = r104.f380802d;
        if (r107 == null) goto L16;
        if (r104.f380815q == 1.0f) goto L16;
        r104.f380815q = 1.0f;
        r107.setPlaybackRate((int) (1.0f * r107.getSampleRate()));
    L16:
        if (r104.f380802d == null) goto L24;
        if (r103 < (-1)) goto L24;
        if (r103 != (-1)) goto L22;
        int r108 = Integer.MAX_VALUE;
    L23:
        r104.f380810l = r108;
        goto L24
    L22:
        r108 = r103 + 1;
    L24:
        r105.execute(r104.f380800b);
        goto L25
    }
}
