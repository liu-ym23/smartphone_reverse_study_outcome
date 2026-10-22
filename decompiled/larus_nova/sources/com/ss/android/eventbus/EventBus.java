package com.ss.android.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.eventbus.collector.CollectorProvider;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class EventBus {
    private static ExecutorService DEFAULT_EXECUTOR_SERVICE = null;
    private static final int MESSAGE_EXCEPTION = 1;
    public static final String TAG = "EventBusHelper";
    private final int CPU_NUM;
    private final int MIN_BACKGROUD_THREAD_NUM;
    private ExecutorService mExecutorService;
    private final Handler mMainHandler;
    private final Map<Object, Map<Class<? extends BaseEvent>, ListenerWithType>> mReceiver2ListenerMap;

    /* JADX INFO: renamed from: com.ss.android.eventbus.EventBus$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$eventbus$ThreadMode = null;

        static {
            int[] r100 = new int[ThreadMode.values().length];
            $SwitchMap$com$ss$android$eventbus$ThreadMode = r100;
            r100[ThreadMode.POSTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$android$eventbus$ThreadMode[ThreadMode.MAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$android$eventbus$ThreadMode[ThreadMode.BACKGROUDN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class ExceptionHandler extends Handler {
        public ExceptionHandler(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            super.handleMessage(r100);
            if (r100.what != 1) goto L10;
            Object r101 = r100.obj;
            if ((r101 instanceof Throwable) == true) goto L8;
            return;
        L8:
            RuntimeException r102 = new RuntimeException();
            r102.initCause((Throwable) r101);
            throw r102;
        }
    }

    public static class ListenerWithType {
        BaseEventListener mBaseEventListener;
        Class<? extends BaseEvent> mClass;

        public BaseEventListener getBaseEventListener() {
            return this.mBaseEventListener;
        }

        public Class<? extends BaseEvent> getTypeClass() {
            return this.mClass;
        }

        public ListenerWithType(Class<? extends BaseEvent> r100, BaseEventListener r101) {
            this.mClass = r100;
            this.mBaseEventListener = r101;
        }
    }

    public static class SingleInstanceHolder {
        public static final EventBus sInstance = null;

        public SingleInstanceHolder() {
        }

        static {
            sInstance = new EventBus(null);
        }
    }

    public static class WeakRunnable implements Runnable {
        private BaseEvent mBaseEvent;
        private IEventListener mEventListener;
        private Handler mMainHandler;
        private WeakReference<Object> mReceiverWeakReference;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_android_eventbus_EventBus$WeakRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_android_eventbus_EventBus$WeakRunnable__run$___twin___() {
        L6:
            th = move-exception;
            Message r100 = new Message();
            r100.obj = th;
            r100.what = 1;
            this.mMainHandler.sendMessage(r100);
            return;
        L3:
            if (this.mReceiverWeakReference.get() == null) goto L11;
            this.mEventListener.onEvent(this.mBaseEvent);     // Catch: Throwable -> L6
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_android_eventbus_EventBus$WeakRunnable_com_larus_apm_impl_protector_RunnableLancet_run(WeakRunnable r100) {
            r100.com_ss_android_eventbus_EventBus$WeakRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public WeakRunnable(Object r100, IEventListener r101, BaseEvent r102, Handler r103) {
            this.mReceiverWeakReference = new WeakReference(r100);
            this.mEventListener = r101;
            this.mBaseEvent = r102;
            this.mMainHandler = r103;
        }
    }

    private EventBus() {
        int r100 = Runtime.getRuntime().availableProcessors();
        this.CPU_NUM = r100;
        this.MIN_BACKGROUD_THREAD_NUM = 3;
        this.mReceiver2ListenerMap = new ConcurrentHashMap();
        this.mMainHandler = new ExceptionHandler(Looper.getMainLooper());
        ExecutorService r101 = PThreadExecutorsUtils.newFixedThreadPool(Math.max(3, r100 + 1), new AnonymousClass1(this));
        DEFAULT_EXECUTOR_SERVICE = r101;
        this.mExecutorService = r101;
    }

    public static EventBus getDefault() {
        return SingleInstanceHolder.sInstance;
    }

    public /* synthetic */ EventBus(AnonymousClass1 r100) {
        this();
    }

    public void register(Object r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        CollectorProvider.getDefaultCollector().register(r100);
    }

    public void setExecutorService(ExecutorService r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ExecutorService r101 = this.mExecutorService;
        ExecutorService r102 = DEFAULT_EXECUTOR_SERVICE;
        if (r101 != r102) goto L7;
        r102.shutdown();
        DEFAULT_EXECUTOR_SERVICE = null;
    L7:
        this.mExecutorService = r100;
    }

    public <T extends BaseEvent> void trigger(T r100) {
        EventBusInternal.getDefault().trigger(r100);
    }

    public void unregister(Object r100) {
        Map<Class<? extends BaseEvent>, ListenerWithType> r101 = this.mReceiver2ListenerMap.get(r100);
        if (r101 == null) goto L14;
        Iterator<ListenerWithType> r102 = r101.values().iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        ListenerWithType r103 = r102.next();
        if (r103 == null) goto L6;
        if (r103.getTypeClass() == null) goto L6;
        if (r103.getBaseEventListener() == null) goto L6;
        EventBusInternal.getDefault().unregister(r103.getTypeClass(), r103.getBaseEventListener());
    L14:
        this.mReceiver2ListenerMap.remove(r100);
    }

    private Runnable getMethodCallRunnable(Object r100, IEventListener r101, BaseEvent r102, Handler r103) {
        return new WeakRunnable(r100, r101, r102, r103);
    }

    public void invokeEventHandler(Object r100, IEventListener r101, BaseEvent r102, ThreadMode r103) {
        Runnable r104 = getMethodCallRunnable(r100, r101, r102, this.mMainHandler);
        int r105 = AnonymousClass3.$SwitchMap$com$ss$android$eventbus$ThreadMode[r103.ordinal()];
        if (r105 != 1) goto L5;
        r104.run();
        return;
    L5:
        if (r105 != 2) goto L7;
        this.mMainHandler.post(r104);
        return;
    L7:
        if (r105 != 3) goto L15;
        this.mExecutorService.execute(r104);
        return;
    }

    public void register(final Object r100, Class<? extends BaseEvent> r101, final BaseEventListener r102, final ThreadMode r103) {
        if (r101 != null) goto L4;
        return;
    L4:
        Map<Class<? extends BaseEvent>, ListenerWithType> r104 = this.mReceiver2ListenerMap.get(r100);
        if (r104 != null) goto L7;
        r104 = new ConcurrentHashMap();
    L7:
        BaseEventListener r105 = new AnonymousClass2(this, r100, r102, r103);
        if (r104.containsKey(r101) == true) goto L12;
        EventBusInternal.getDefault().register(r101, r105);
        r104.put(r101, new ListenerWithType(r101, r105));
        this.mReceiver2ListenerMap.put(r100, r104);
        return;
    L12:
        throw new RuntimeException("同一个类里面，同种事件类型只能注册一个, 不要重复添加，类:" + r100.getClass() + "，事件: " + r101);
    }
}
