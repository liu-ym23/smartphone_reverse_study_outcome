package com.bytedance.sysoptimizer.anr;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.java.ReflectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class QueuedWorkOptimizer {
    private static final String TAG = "QueuedWorkOptimizer";
    private static IAsyncWorker sAsyncWorker;
    private static IErrorListener sErrorListener;

    /* JADX INFO: renamed from: com.bytedance.sysoptimizer.anr.QueuedWorkOptimizer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface IAsyncWorker {
        void run(Runnable r100);
    }

    public interface IErrorListener {
        void onError(Throwable r100);
    }

    public interface IQueuedWorkOptimizerHandler {
        void optimize();
    }

    public static class ProxyConcurrentLinkedQueue<T> extends ConcurrentLinkedQueue<T> {
        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
        public boolean add(T r100) {
            return true;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r100) {
            return true;
        }

        public ProxyConcurrentLinkedQueue() {
        }
    }

    public static class QueuedWorkCallback implements Handler.Callback {
        private static final int MSG_RUN = 1;
        private static LinkedList<Runnable> sWork;
        private Handler.Callback originCallBack;
        private Handler queuedWorkHandler;

        private void processPendingWork() {
            if (this.queuedWorkHandler == null) goto L13;
            LinkedList<Runnable> r100 = sWork;
            if (r100 == null) goto L16;
            LinkedList r101 = (LinkedList) r100.clone();
            sWork.clear();
            this.queuedWorkHandler.removeMessages(1);
            if (r101.size() <= 0) goto L15;
            Iterator r102 = r101.iterator();
        L11:
            if (r102.hasNext() == false) goto L17;
            ((Runnable) r102.next()).run();
            goto L11
        L17:
            return;
        L15:
            return;
        L16:
            return;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r100) {
            if (r100.what != 1) goto L5;
            processPendingWork();
        L5:
            Handler.Callback r101 = this.originCallBack;
            if (r101 == null) goto L8;
            r101.handleMessage(r100);
        L8:
            return true;
        }

        public QueuedWorkCallback(Handler r100, Handler.Callback r101, LinkedList<Runnable> r102) {
            this.queuedWorkHandler = r100;
            this.originCallBack = r101;
            sWork = r102;
        }
    }

    public static class QueuedWorkOptimizerAboveO implements IQueuedWorkOptimizerHandler {

        public static class EmptyLinkedList<T> extends LinkedList<T> {
            @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
            public boolean add(T r100) {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean isEmpty() {
                return true;
            }

            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public boolean remove(Object r100) {
                return true;
            }

            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public int size() {
                return 0;
            }

            private EmptyLinkedList() {
            }

            @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public void clear() {
                super.clear();
            }

            public /* synthetic */ EmptyLinkedList(AnonymousClass1 r100) {
                this();
            }
        }

        public static class MyLinkedList extends LinkedList<Runnable> {
            private MyLinkedList() {
            }

            public /* synthetic */ MyLinkedList(AnonymousClass1 r100) {
                this();
            }

            public boolean add(Runnable r100) {
                return super.add(new MyRunnable(r100));
            }

            @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
            public /* bridge */ /* synthetic */ boolean add(Object r100) {
                return add((Runnable) r100);
            }
        }

        public static class MyRunnable implements Runnable {
            private final Runnable run;

            @Override // java.lang.Runnable
            public void run() {
                com_bytedance_sysoptimizer_anr_QueuedWorkOptimizer$QueuedWorkOptimizerAboveO$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_bytedance_sysoptimizer_anr_QueuedWorkOptimizer$QueuedWorkOptimizerAboveO$MyRunnable__run$___twin___() {
                if (QueuedWorkOptimizer.access$400() == null) goto L6;
                QueuedWorkOptimizer.access$400().run(this.run);
                return;
            }

            public MyRunnable(Runnable r100) {
                this.run = r100;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_bytedance_sysoptimizer_anr_QueuedWorkOptimizer$QueuedWorkOptimizerAboveO$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(MyRunnable r100) {
                r100.com_bytedance_sysoptimizer_anr_QueuedWorkOptimizer$QueuedWorkOptimizerAboveO$MyRunnable__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        private QueuedWorkOptimizerAboveO() {
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Override // com.bytedance.sysoptimizer.anr.QueuedWorkOptimizer.IQueuedWorkOptimizerHandler
        public void optimize() {
            Class r100 = INVOKESTATIC_com_bytedance_sysoptimizer_anr_QueuedWorkOptimizer$QueuedWorkOptimizerAboveO_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.QueuedWork");     // Catch: Throwable -> L6
            Field r101 = r100.getDeclaredField("sFinishers");     // Catch: Throwable -> L6
            ReflectionUtils.removeFinal(r101);     // Catch: Throwable -> L6
            r101.setAccessible(true);     // Catch: Throwable -> L6
            AnonymousClass1 r102 = null;
            r101.set(null, new EmptyLinkedList(r102));     // Catch: Throwable -> L6
            if (QueuedWorkOptimizer.access$400() == null) goto L13;
            Field r103 = r100.getDeclaredField("sWork");     // Catch: Throwable -> L6
            ReflectionUtils.removeFinal(r103);     // Catch: Throwable -> L6
            r103.setAccessible(true);     // Catch: Throwable -> L6
            r103.set(null, new MyLinkedList(r102));     // Catch: Throwable -> L6
            return;
        L13:
            return;
        L6:
            th = move-exception;
            if (QueuedWorkOptimizer.access$200() == null) goto L14;
            QueuedWorkOptimizer.access$200().onError(th);
            return;
        }

        public /* synthetic */ QueuedWorkOptimizerAboveO(AnonymousClass1 r100) {
            this();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_bytedance_sysoptimizer_anr_QueuedWorkOptimizer$QueuedWorkOptimizerAboveO_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
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
    }

    public static class QueuedWorkOptimizerBelowO implements IQueuedWorkOptimizerHandler {
        private QueuedWorkOptimizerBelowO() {
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Override // com.bytedance.sysoptimizer.anr.QueuedWorkOptimizer.IQueuedWorkOptimizerHandler
        public void optimize() {
            Field r100 = INVOKESTATIC_com_bytedance_sysoptimizer_anr_QueuedWorkOptimizer$QueuedWorkOptimizerBelowO_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.QueuedWork").getDeclaredField("sPendingWorkFinishers");     // Catch: Throwable -> L4
            r100.setAccessible(true);     // Catch: Throwable -> L4
            ReflectionUtils.removeFinal(r100);     // Catch: Throwable -> L4
            r100.set(null, new ProxyConcurrentLinkedQueue());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (QueuedWorkOptimizer.access$200() == null) goto L11;
            QueuedWorkOptimizer.access$200().onError(th);
            return;
        }

        public /* synthetic */ QueuedWorkOptimizerBelowO(AnonymousClass1 r100) {
            this();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_bytedance_sysoptimizer_anr_QueuedWorkOptimizer$QueuedWorkOptimizerBelowO_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
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
    }

    public QueuedWorkOptimizer() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static IQueuedWorkOptimizerHandler getOptimizer() {
        AnonymousClass1 r100 = null;
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return new QueuedWorkOptimizerBelowO(r100);
    L7:
        return new QueuedWorkOptimizerAboveO(r100);
    }

    public static void optimize() {
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        IQueuedWorkOptimizerHandler r100 = getOptimizer();
        if (r100 == null) goto L9;
        r100.optimize();
        return;
    L9:
        return;
    L7:
        takeOverQueuedWorkHandler();
    }

    private static void takeOverQueuedWorkHandler() {
        Class r100 = INVOKESTATIC_com_bytedance_sysoptimizer_anr_QueuedWorkOptimizer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.QueuedWork");     // Catch: Throwable -> L10
        Handler r101 = (Handler) ReflectionUtils.invokeStaticMethod(r100, "getHandler");     // Catch: Throwable -> L10
        LinkedList r102 = (LinkedList) ReflectionUtils.getStaticFieldObject("sWork", r100);     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        if (r102 == null) goto L17;
        ReflectionUtils.setFieldObject(r101, "mCallback", new QueuedWorkCallback(r101, (Handler.Callback) ReflectionUtils.getFieldObject("android.os.Handler", "mCallback", r101), r102));     // Catch: Throwable -> L10
        return;
    L17:
        return;
    L9:
        return;
    L10:
        th = move-exception;
        IErrorListener r103 = sErrorListener;
        if (r103 == null) goto L18;
        r103.onError(th);
        return;
    }

    public static /* synthetic */ IErrorListener access$200() {
        return sErrorListener;
    }

    public static /* synthetic */ IAsyncWorker access$400() {
        return sAsyncWorker;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sysoptimizer_anr_QueuedWorkOptimizer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static void injectAsyncWorker(IAsyncWorker r100) {
        sAsyncWorker = r100;
    }

    public static void setErrorListener(IErrorListener r100) {
        sErrorListener = r100;
    }
}
