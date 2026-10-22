package com.sun.jna.internal;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class Cleaner {
    private static final Cleaner INSTANCE = null;
    private Thread cleanerThread;
    private CleanerRef firstCleanable;
    private final ReferenceQueue<Object> referenceQueue;

    public interface Cleanable {
        void clean();
    }

    public static class CleanerRef extends PhantomReference<Object> implements Cleanable {
        private final Cleaner cleaner;
        private final Runnable cleanupTask;
        private CleanerRef next;
        private CleanerRef previous;

        @Override // com.sun.jna.internal.Cleaner.Cleanable
        public void clean() {
            if (Cleaner.access$000(this.cleaner, this) == false) goto L6;
            this.cleanupTask.run();
            return;
        }

        public CleanerRef getNext() {
            return this.next;
        }

        public CleanerRef getPrevious() {
            return this.previous;
        }

        public static /* synthetic */ CleanerRef access$400(CleanerRef r100) {
            return r100.next;
        }

        public static /* synthetic */ Runnable access$500(CleanerRef r100) {
            return r100.cleanupTask;
        }

        public void setNext(CleanerRef r100) {
            this.next = r100;
        }

        public void setPrevious(CleanerRef r100) {
            this.previous = r100;
        }

        public CleanerRef(Cleaner r100, Object r101, ReferenceQueue<? super Object> r102, Runnable r103) {
            super(r101, r102);
            this.cleaner = r100;
            this.cleanupTask = r103;
        }
    }

    public class CleanerThread extends PthreadThreadV2 {
        private static final long CLEANER_LINGER_TIME = 30000;
        final /* synthetic */ Cleaner this$0;

        public void com_sun_jna_internal_Cleaner$CleanerThread__run$___twin___() {
        L34:
            Reference r100 = Cleaner.access$100(this.this$0).remove(30000);     // Catch: Exception -> L28 InterruptedException -> L31
            if ((r100 instanceof CleanerRef) == true) goto L5;
            if (r100 != null) goto L34;
            ReferenceQueue r101 = Cleaner.access$100(this.this$0);     // Catch: Exception -> L28 InterruptedException -> L31
            monitor-enter(r101);     // Catch: Exception -> L28 InterruptedException -> L31
            Logger r102 = Logger.getLogger(Cleaner.class.getName());     // Catch: Throwable -> L25
            if (Cleaner.access$200(this.this$0) != null) goto L15;
            Cleaner.access$302(this.this$0, null);     // Catch: Throwable -> L25
            r102.log(Level.FINE, "Shutting down CleanerThread");     // Catch: Throwable -> L25
            monitor-exit(r101);     // Catch: Throwable -> L25
            goto L51
        L30:
            return;
        L15:
            if (r102.isLoggable(Level.FINER) == false) goto L23;
            StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L25
            CleanerRef r104 = Cleaner.access$200(this.this$0);     // Catch: Throwable -> L25
        L17:
            if (r104 == null) goto L22;
            if (r103.length() == 0) goto L21;
            r103.append(", ");     // Catch: Throwable -> L25
        L21:
            r103.append(CleanerRef.access$500(r104).toString());     // Catch: Throwable -> L25
            r104 = CleanerRef.access$400(r104);     // Catch: Throwable -> L25
            goto L17
        L22:
            r102.log(Level.FINER, "Registered Cleaners: {0}", r103.toString());     // Catch: Throwable -> L25
        L23:
            monitor-exit(r101);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;     // Catch: Exception -> L28 InterruptedException -> L31
            goto L51
        L5:
            ((CleanerRef) r100).clean();     // Catch: Exception -> L28 InterruptedException -> L31
        L28:
            e = move-exception;
            Logger.getLogger(Cleaner.class.getName()).log(Level.SEVERE, null, e);
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_sun_jna_internal_Cleaner$CleanerThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public CleanerThread(Cleaner r100) {
            this.this$0 = r100;
            super("JNA Cleaner");
            setDaemon(true);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_sun_jna_internal_Cleaner$CleanerThread_com_larus_apm_impl_protector_RunnableLancet_run(CleanerThread r100) {
            r100.com_sun_jna_internal_Cleaner$CleanerThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        INSTANCE = new Cleaner();
    }

    private Cleaner() {
        this.referenceQueue = new ReferenceQueue();
    }

    public static Cleaner getCleaner() {
        return INSTANCE;
    }

    public static /* synthetic */ ReferenceQueue access$100(Cleaner r100) {
        return r100.referenceQueue;
    }

    public static /* synthetic */ CleanerRef access$200(Cleaner r100) {
        return r100.firstCleanable;
    }

    private synchronized CleanerRef add(CleanerRef r100) {
        monitor-enter(this);
        ReferenceQueue<Object> r101 = this.referenceQueue;     // Catch: Throwable -> L18
        monitor-enter(r101);     // Catch: Throwable -> L18
        CleanerRef r102 = this.firstCleanable;     // Catch: Throwable -> L15
        if (r102 != null) goto L8;
        this.firstCleanable = r100;     // Catch: Throwable -> L15
    L10:
        if (this.cleanerThread != null) goto L12;
        Logger.getLogger(Cleaner.class.getName()).log(Level.FINE, "Starting CleanerThread");     // Catch: Throwable -> L15
        CleanerThread r103 = new CleanerThread(this);     // Catch: Throwable -> L15
        this.cleanerThread = r103;     // Catch: Throwable -> L15
        ThreadMethodProxy.start(r103);     // Catch: Throwable -> L15
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r100;
    L8:
        r100.setNext(r102);     // Catch: Throwable -> L15
        this.firstCleanable.setPrevious(r100);     // Catch: Throwable -> L15
        this.firstCleanable = r100;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private synchronized boolean remove(CleanerRef r100) {
        monitor-enter(this);
        ReferenceQueue<Object> r101 = this.referenceQueue;     // Catch: Throwable -> L28
        monitor-enter(r101);     // Catch: Throwable -> L28
        boolean r102 = true;
        if (r100 != this.firstCleanable) goto L8;
        this.firstCleanable = r100.getNext();     // Catch: Throwable -> L25
        boolean r103 = true;
    L10:
        if (r100.getPrevious() == null) goto L13;
        r100.getPrevious().setNext(r100.getNext());     // Catch: Throwable -> L25
    L13:
        if (r100.getNext() == null) goto L16;
        r100.getNext().setPrevious(r100.getPrevious());     // Catch: Throwable -> L25
    L16:
        if (r100.getPrevious() == null) goto L18;
    L21:
        r100.setNext(null);     // Catch: Throwable -> L25
        r100.setPrevious(null);     // Catch: Throwable -> L25
        monitor-exit(r101);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r102;
    L18:
        if (r100.getNext() != null) goto L21;
        r102 = r103;
        goto L21
    L8:
        r103 = false;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean access$000(Cleaner r100, CleanerRef r101) {
        return r100.remove(r101);
    }

    public static /* synthetic */ Thread access$302(Cleaner r100, Thread r101) {
        r100.cleanerThread = r101;
        return r101;
    }

    public synchronized Cleanable register(Object r100, Runnable r101) {
        monitor-enter(this);
        CleanerRef r102 = add(new CleanerRef(this, r100, this.referenceQueue, r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }
}
