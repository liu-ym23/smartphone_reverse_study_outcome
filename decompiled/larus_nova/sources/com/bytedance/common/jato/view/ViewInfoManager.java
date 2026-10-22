package com.bytedance.common.jato.view;

import android.os.Process;
import android.view.View;
import androidx.core.util.Pools;
import com.bytedance.common.jato.view.ViewInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes15.dex */
public class ViewInfoManager<T extends ViewInfo> implements ViewDestroyMonitor.ViewDestroyListener, ViewDestroyMonitor.InflateInfoProvider {
    static ViewInfoManager<ViewInfo> instance;
    protected final AtomicLong activeAttachedCount;
    protected final AtomicLong activeCreatedCount;
    protected final AtomicLong activeDetachedCount;
    private final ConcurrentHashMap<Long, ViewInfoManager<T>.InfoItem> allInfo;
    private final ViewInfoManager<T>.AttachStateChangeListener attachStateChangeListener;
    protected final AtomicLong attachedCount;
    protected final AtomicLong attachedOnceCount;
    protected final AtomicLong createdCount;
    private final ConcurrentHashMap<Thread, Stack<InflateInfo>> currentInflateInfo;
    private final ViewDestroyMonitor destroyManager;
    protected final AtomicLong destroyedCount;
    protected final AtomicLong destroyedOnAttachedCount;
    protected final AtomicLong destroyedOnAttachedOnceCount;
    protected final AtomicLong destroyedOnCreateCount;
    protected final AtomicLong destroyedOnDetachedCount;
    protected final AtomicLong destroyedOnDetachedOnceCount;
    protected final AtomicLong detachedCount;
    protected final AtomicLong detachedOnceCount;
    private volatile boolean enable;
    private final Pools.SynchronizedPool<Stack<InflateInfo>> inflateInfoStackPool;
    private final MergedViewInfoListener<T> infoListener;
    private final Pools.SynchronizedPool<T> viewInfoPool;

    /* JADX INFO: renamed from: com.bytedance.common.jato.view.ViewInfoManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$common$jato$view$ViewState = null;

        static {
            int[] r100 = new int[ViewState.values().length];
            $SwitchMap$com$bytedance$common$jato$view$ViewState = r100;
            r100[ViewState.Created.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$common$jato$view$ViewState[ViewState.Detached.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$common$jato$view$ViewState[ViewState.Attached.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class AttachStateChangeListener implements View.OnAttachStateChangeListener {
        final /* synthetic */ ViewInfoManager this$0;

        private AttachStateChangeListener(ViewInfoManager r100) {
            this.this$0 = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r100) {
            long r101 = ViewUtils.getRenderNodePtr(r100);
            if (r101 == 0) goto L8;
            InfoItem r102 = (InfoItem) ViewInfoManager.access$100(this.this$0).get(Long.valueOf(r101));
            if (r102 == null) goto L9;
            this.this$0.notifyViewAttached(r100, r102.viewInfo, TimeUtils.getNow());
            return;
        L9:
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r100) {
            long r101 = ViewUtils.getRenderNodePtr(r100);
            if (r101 == 0) goto L8;
            InfoItem r102 = (InfoItem) ViewInfoManager.access$100(this.this$0).get(Long.valueOf(r101));
            if (r102 == null) goto L9;
            this.this$0.notifyViewDetached(r100, r102.getViewInfo(), TimeUtils.getNow());
            return;
        L9:
            return;
        }

        public /* synthetic */ AttachStateChangeListener(ViewInfoManager r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public class InfoItem extends WeakReference<View> {
        final /* synthetic */ ViewInfoManager this$0;
        T viewInfo;

        public String toString() {
            return "InfoItem{referent=" + get() + "viewInfo=" + this.viewInfo + '}';
        }

        public T getViewInfo() {
            return this.viewInfo;
        }

        public InfoItem(ViewInfoManager r100, View r101, T r102) {
            this.this$0 = r100;
            super(r101);
            this.viewInfo = r102;
        }
    }

    public interface ViewInfoStatistics<T extends ViewInfo> {
        void onViewInfo(T r100);
    }

    private Stack<InflateInfo> getInflateInfoStack() {
        Stack<InflateInfo> r100 = this.inflateInfoStackPool.acquire();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new Stack();
    }

    public static ViewInfoManager<ViewInfo> getInstance() {
        if (instance != null) goto L15;
        monitor-enter(ViewInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new ViewInfoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ViewInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private T newViewInfo() {
        T r100 = this.viewInfoPool.acquire();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return (T) newViewInfoInner();
    }

    public InflateInfo createInflateInfo() {
        return new InflateInfo();
    }

    public long getActiveAttachedViewCount() {
        return this.activeAttachedCount.get();
    }

    public long getActiveDetachedViewCount() {
        return this.activeDetachedCount.get();
    }

    public long getActiveNotAttachedViewCount() {
        return this.activeCreatedCount.get();
    }

    public long getActiveViewCount() {
        return this.createdCount.get() - this.destroyedCount.get();
    }

    public long getAttachedHistoryViewCount() {
        return this.attachedCount.get();
    }

    public long getAttachedOnceHistoryViewCount() {
        return this.attachedOnceCount.get();
    }

    public long getAttachedViewCount() {
        return (this.attachedCount.get() - this.detachedCount.get()) - this.destroyedOnAttachedCount.get();
    }

    public long getCreatedHistoryViewCount() {
        return this.createdCount.get();
    }

    public long getDestroyedHistoryViewCount() {
        return this.destroyedCount.get();
    }

    public long getDetachedHistoryViewCount() {
        return this.detachedCount.get();
    }

    public long getDetachedOnceHistoryViewCount() {
        return this.detachedOnceCount.get();
    }

    public T newViewInfoInner() {
        return (T) new ViewInfo();
    }

    public boolean startMonitor() {
        if (this.enable == false) goto L6;
        return true;
    L6:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.enable == true) goto L12;
        this.destroyManager.addViewDestroyListener(this);     // Catch: Throwable -> L15
        this.destroyManager.setProvider(this);     // Catch: Throwable -> L15
        this.destroyManager.enableMonitor();     // Catch: Throwable -> L15
        this.enable = this.destroyManager.checkInit();     // Catch: Throwable -> L15
        boolean r100 = this.enable;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r100;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L15
        return this.enable;
    }

    public ViewInfoManager() {
        this.infoListener = new MergedViewInfoListener();
        this.allInfo = new ConcurrentHashMap();
        this.viewInfoPool = new Pools.SynchronizedPool(1000);
        this.inflateInfoStackPool = new Pools.SynchronizedPool(10);
        this.currentInflateInfo = new ConcurrentHashMap();
        this.enable = false;
        this.activeCreatedCount = new AtomicLong();
        this.activeAttachedCount = new AtomicLong();
        this.activeDetachedCount = new AtomicLong();
        this.createdCount = new AtomicLong();
        this.destroyedCount = new AtomicLong();
        this.destroyedOnAttachedCount = new AtomicLong();
        this.destroyedOnDetachedCount = new AtomicLong();
        this.destroyedOnCreateCount = new AtomicLong();
        this.destroyedOnDetachedOnceCount = new AtomicLong();
        this.destroyedOnAttachedOnceCount = new AtomicLong();
        this.attachedCount = new AtomicLong();
        this.detachedCount = new AtomicLong();
        this.attachedOnceCount = new AtomicLong();
        this.detachedOnceCount = new AtomicLong();
        this.attachStateChangeListener = new AttachStateChangeListener(this, null);
        this.destroyManager = ViewDestroyMonitor.getInstance();
    }

    public long getActiveRenderNodeCount() {
        return ViewNative.nativeGetRenderNodeCreatedCount() - ViewNative.nativeGetRenderNodeDestroyedCount();
    }

    public long getCreatedRenderNodeCountCurrentThread() {
        return ViewNative.nativeGetCurrentThreadRenderNodeCount();
    }

    @Override // com.bytedance.common.jato.view.ViewDestroyMonitor.InflateInfoProvider
    public InflateInfo getInflateInfo() {
        return getCurrentInflateInfo(ThreadMethodProxy.currentThread());
    }

    public long getLeakedViewCount() {
        return (getCreatedHistoryViewCount() - getDestroyedHistoryViewCount()) - getAttachedViewCount();
    }

    public long getMainThreadCreatedRenderNodeCount() {
        return ViewNative.nativeGetMainThreadRenderNodeCount();
    }

    public long getRenderNodeCreatedCount() {
        return ViewNative.nativeGetRenderNodeCreatedCount();
    }

    public long getRenderNodeDestroyedCount() {
        return ViewNative.nativeGetRenderNodeDestroyedCount();
    }

    public void markInflateEnd() {
        Thread r100 = ThreadMethodProxy.currentThread();
        Stack<InflateInfo> r101 = this.currentInflateInfo.get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L11;
        r101.pop().setEnd(TimeUtils.getNow());
        if (r101.isEmpty() == false) goto L12;
        this.currentInflateInfo.remove(r100, r101);
        releaseInflateInfoStack(r101);
        return;
    L12:
        return;
    }

    public static /* synthetic */ ConcurrentHashMap access$100(ViewInfoManager r100) {
        return r100.allInfo;
    }

    private void releaseInflateInfoStack(Stack<InflateInfo> r100) {
        if (r100 == null) goto L5;
        r100.clear();
        this.inflateInfoStackPool.release(r100);
        return;
    }

    public void addInfoListener(ViewInfoListener<T> r100) {
        this.infoListener.add(r100);
    }

    public InflateInfo getCurrentInflateInfo(Thread r100) {
        Stack<InflateInfo> r101 = this.currentInflateInfo.get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return null;
    L7:
        return r101.peek();
    }

    public void markInflateStart(InflateInfo r100) {
        Thread r101 = ThreadMethodProxy.currentThread();
        r100.setThreadName(r101.getName());
        Stack<InflateInfo> r102 = this.currentInflateInfo.get(r101);
        if (r102 != null) goto L7;
        r102 = getInflateInfoStack();
        Stack<InflateInfo> r103 = this.currentInflateInfo.putIfAbsent(r101, r102);
        if (r103 == null) goto L7;
        releaseInflateInfoStack(r102);
        r102 = r103;
    L7:
        r100.setStart(TimeUtils.getNow());
        r102.push(r100);
    }

    public void removeInfoListener(ViewInfoListener<T> r100) {
        this.infoListener.remove(r100);
    }

    public void setSampleRate(int r100) {
        if (this.destroyManager.checkInit() == false) goto L6;
        this.destroyManager.setSampleRate(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void statistics(ViewInfoStatistics r100) {
        if (r100 != 0) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Long, ViewInfoManager<T>.InfoItem>> r101 = this.allInfo.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r100.onViewInfo(r101.next().getValue().getViewInfo());
        goto L6
    }

    public void addView(View r100, T r101) {
        addView(r100, r101, ThreadMethodProxy.currentThread().getName(), Process.myTid(), getCurrentInflateInfo(ThreadMethodProxy.currentThread()));
    }

    public ViewInfoManager<T>.InfoItem createInfoItem(View r100, T r101) {
        return new InfoItem(this, r100, r101);
    }

    public ViewInfo getViewInfo(View r100, long r101) {
        if (r101 != 0) goto L6;
        r101 = ViewUtils.getRenderNodePtr(r100);
    L6:
        if (r101 != 0) goto L8;
        return null;
    L8:
        ViewInfoManager<T>.InfoItem r102 = this.allInfo.get(Long.valueOf(r101));
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.viewInfo;
    }

    public void notifyViewDestroyed(T r100, long r101) {
        ViewState r102 = r100.getState();
        if (r100.setState(ViewState.Destroyed, r101) == false) goto L22;
        this.destroyedCount.incrementAndGet();
        int r103 = AnonymousClass1.$SwitchMap$com$bytedance$common$jato$view$ViewState[r102.ordinal()];
        if (r103 != 1) goto L7;
        this.activeCreatedCount.decrementAndGet();
        this.destroyedOnCreateCount.incrementAndGet();
    L15:
        if (r100.isNotified(ViewState.Detached) == false) goto L18;
        this.destroyedOnDetachedOnceCount.incrementAndGet();
    L18:
        if (r100.isNotified(ViewState.Attached) == false) goto L20;
        this.destroyedOnAttachedOnceCount.incrementAndGet();
    L20:
        this.infoListener.onViewDestroy(r100);
        return;
    L7:
        if (r103 != 2) goto L9;
        this.activeDetachedCount.decrementAndGet();
        this.destroyedOnDetachedCount.incrementAndGet();
        goto L15
    L9:
        if (r103 != 3) goto L15;
        this.activeAttachedCount.decrementAndGet();
        this.destroyedOnAttachedCount.incrementAndGet();
        goto L15
    }

    @Override // com.bytedance.common.jato.view.ViewDestroyMonitor.ViewDestroyListener
    public void onViewDestroy(long r100, long r101) {
        Long r102 = Long.valueOf(r100);
        ViewInfoManager<T>.InfoItem r103 = this.allInfo.remove(r102);
        if (r103 == null) goto L6;
        notifyViewDestroyed(r103.viewInfo, r101);
        r103.viewInfo.release();
        this.viewInfoPool.release(r103.viewInfo);
        return;
    }

    public ViewInfo newViewInfo(View r100, long r101, long r102) {
        ViewInfo r103 = newViewInfo();
        if (r101 != 0) goto L5;
        r101 = ViewUtils.getRenderNodePtr(r100);
    L5:
        r103.setPtr(r101);
        r103.setName(r100.getClass().getName());
        if (r102 != 0) goto L8;
        r102 = TimeUtils.getNow();
    L8:
        r103.setId(r100.getId());
        r103.setCreateTime(r102);
        return r103;
    }

    public void notifyViewAttached(View r100, T r101, long r102) {
        this.attachedCount.incrementAndGet();
        ViewState r103 = r101.getState();
        ViewState r104 = ViewState.Attached;
        if (r101.setState(r104, r102) == false) goto L5;
        this.attachedOnceCount.incrementAndGet();
        this.infoListener.onViewAttached(r100, r101);
    L5:
        if (r103 == r104) goto L15;
        int r105 = AnonymousClass1.$SwitchMap$com$bytedance$common$jato$view$ViewState[r103.ordinal()];
        if (r105 != 1) goto L9;
        this.activeCreatedCount.decrementAndGet();
    L13:
        this.activeAttachedCount.incrementAndGet();
        return;
    L9:
        if (r105 != 2) goto L13;
        this.activeDetachedCount.decrementAndGet();
        goto L13
    }

    public void notifyViewCreated(View r100, T r101, long r102) {
        if (r101.setState(ViewState.Created, r102) == false) goto L6;
        this.createdCount.incrementAndGet();
        this.activeCreatedCount.incrementAndGet();
        this.infoListener.onViewCreated(r100, r101);
        return;
    }

    public void notifyViewDetached(View r100, T r101, long r102) {
        this.detachedCount.incrementAndGet();
        ViewState r103 = r101.getState();
        ViewState r104 = ViewState.Detached;
        if (r101.setState(r104, r102) == false) goto L5;
        this.detachedOnceCount.incrementAndGet();
        this.infoListener.onViewDetached(r100, r101);
    L5:
        if (r103 == r104) goto L15;
        int r105 = AnonymousClass1.$SwitchMap$com$bytedance$common$jato$view$ViewState[r103.ordinal()];
        if (r105 != 1) goto L9;
        this.activeCreatedCount.decrementAndGet();
    L13:
        this.activeDetachedCount.incrementAndGet();
        return;
    L9:
        if (r105 != 3) goto L13;
        this.activeAttachedCount.decrementAndGet();
        goto L13
    }

    public void addView(View r100, T r101, String r102, int r103, InflateInfo r110) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (this.enable == true) goto L7;
        return;
    L7:
        if (r101.getPtr() == 0) goto L9;
        long r104 = r101.getPtr();
    L11:
        if (r104 == 0) goto L29;
        Long r105 = Long.valueOf(r104);
        r101.setPtr(r104);
        r101.setThreadName(r102);
        r101.setThreadId(r103);
        ViewInfoManager<T>.InfoItem r106 = createInfoItem(r100, r101);
        if (this.allInfo.putIfAbsent(r105, r106) == null) goto L15;
        return;
    L15:
        r101.setViewRef(r106);
        if (r110 == null) goto L19;
        r101.setInflateInfo(r110);
        r110.addViewRef(r106);
    L19:
        if (r101.getCreateTime() != 0) goto L21;
        long r107 = TimeUtils.getNow();
    L22:
        notifyViewCreated(r100, r101, r107);
        if (r100 == null) goto L30;
        r100.removeOnAttachStateChangeListener(this.attachStateChangeListener);
        r100.addOnAttachStateChangeListener(this.attachStateChangeListener);
        if (r100.isAttachedToWindow() == false) goto L31;
        notifyViewAttached(r100, r101, TimeUtils.getNow());
        return;
    L31:
        return;
    L30:
        return;
    L21:
        r107 = r101.getCreateTime();
        goto L22
    L29:
        return;
    L9:
        r104 = ViewUtils.getRenderNodePtr(r100);
        goto L11
    }

    public void markInflateStart(String r100, String r101, String r102, InflateType r103, int r104, Object r105) {
        InflateInfo r106 = createInflateInfo();
        r106.setScene(r100);
        r106.setName(r102);
        r106.setActivityName(r101);
        r106.setType(r103);
        r106.setId(r104);
        r106.setThreadId(Process.myTid());
        r106.setThreadName(ThreadMethodProxy.currentThread().getName());
        r106.setExtraInfo(r105);
        markInflateStart(r106);
    }

    @Override // com.bytedance.common.jato.view.ViewDestroyMonitor.ViewDestroyListener
    public void onViewCreated(View r100, long r101, long r110, String r111, int r112, InflateInfo r113) {
        addView(r100, newViewInfo(r100, r101, r110), r111, r112, r113);
    }
}
