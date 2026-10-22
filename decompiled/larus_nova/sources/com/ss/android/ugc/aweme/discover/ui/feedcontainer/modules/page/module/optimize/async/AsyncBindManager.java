package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.crash.d;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.BindManagerConfig;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.BindManagerEx;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.CardPreloadConfig;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.Mode;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.PreloadConfigHandler;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core.AsyncCacheExtension;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core.CacheInfo;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core.IDataProvider;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core.IPreloadResultListener;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core.OffScreenPreRenderCache;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncPreloadViewHolderTask;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.AsyncTaskExecutor;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.tasks.TaskResult;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.trigger.PreloadTriggerManager;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.utils.RecyclerViewExKt;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.utils.ReflectUtil;
import com.ss.android.ugc.aweme.search.optimize.PreBindResult;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ugc.android.cachalot.api.Trigger;
import com.ss.ugc.android.cachalot.common.async.controller.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import zkc.b;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/async/AsyncBindManager;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/config/BindManagerEx;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsyncBindManager<T> implements BindManagerEx {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f450607n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f450608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f450609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function4<RecyclerView.ViewHolder, Integer, T, Boolean, Unit> f450610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IAsyncLoad f450611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PreloadConfigHandler<T> f450612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AsyncCacheExtension<T> f450613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IPreloadResultListener f450614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f450615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PreloadTriggerManager f450616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AsyncTaskExecutor<RecyclerView.ViewHolder> f450617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f450618k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f450619l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AsyncCreateManager f450620m;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/async/AsyncBindManager$Companion;", "", "", "LOG_TYPE", "Ljava/lang/String;", "TAG", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        @JvmStatic
        public static Integer a(RecyclerView r100) {
            if (r100 == null) goto L18;
            RecyclerView.LayoutManager r101 = r100.getLayoutManager();
            if (r101 != null) goto L7;
            return null;
        L7:
            if ((r101 instanceof LinearLayoutManager) == false) goto L11;
            Integer r102 = Integer.valueOf(((LinearLayoutManager) r101).findFirstVisibleItemPosition());
        L20:
            return r102;
        L11:
            if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L16;
            int[] r103 = ((StaggeredGridLayoutManager) r101).findFirstVisibleItemPositions(null);
            if (r103 != null) goto L22;
            return null;
        L22:
            return ArraysKt.minOrNull(r103);
        L16:
            if ((r101 instanceof GridLayoutManager) == false) goto L23;
            r102 = Integer.valueOf(((GridLayoutManager) r101).findFirstVisibleItemPosition());
            goto L20
        L23:
            return null;
        L18:
            return null;
        }

        @JvmStatic
        public static Integer b(RecyclerView r100) {
            if (r100 == null) goto L18;
            RecyclerView.LayoutManager r101 = r100.getLayoutManager();
            if (r101 != null) goto L7;
            return null;
        L7:
            if ((r101 instanceof LinearLayoutManager) == false) goto L11;
            Integer r102 = Integer.valueOf(((LinearLayoutManager) r101).findLastVisibleItemPosition());
        L20:
            return r102;
        L11:
            if ((r101 instanceof StaggeredGridLayoutManager) == false) goto L16;
            int[] r103 = ((StaggeredGridLayoutManager) r101).findLastVisibleItemPositions(null);
            if (r103 != null) goto L22;
            return null;
        L22:
            return ArraysKt.maxOrNull(r103);
        L16:
            if ((r101 instanceof GridLayoutManager) == false) goto L23;
            r102 = Integer.valueOf(((GridLayoutManager) r101).findLastVisibleItemPosition());
            goto L20
        L23:
            return null;
        L18:
            return null;
        }

        public static void c(Throwable r100) {
            StringBuilder r101 = new StringBuilder("AsyncBindException: ");
            if (r100 == null) goto L5;
            String r102 = r100.getMessage();
        L6:
            r101.append(r102);
            d.f("AsyncBindException", r100, r101.toString());
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
        f450607n = new Companion(0);
    }

    public AsyncBindManager(BindManagerConfig<T> r100, AsyncCreateManager r110) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f450620m = r110;
        RecyclerView r111 = r100.f450659b;
        this.f450608a = r111;
        ExecutorService r101 = r100.f450660c;
        this.f450609b = r101;
        this.f450610c = r100.f450661d;
        IAsyncLoad<T> r102 = r100.f450662e;
        this.f450611d = r102;
        this.f450612e = new PreloadConfigHandler(r100.f450663f);
        IAsyncPrefetchStrategy r103 = r100.f450665h;
        AsyncCacheExtension<T> r104 = new AsyncCacheExtension(r111, r102, new AsyncBindManager$cacheExtension$1(this), r103, new AsyncBindManager$cacheExtension$2(this));
        this.f450613f = r104;
        IPreloadResultListener r105 = r100.f450666i;
        this.f450614g = r105;
        this.f450615h = true;
        PreloadTriggerManager r106 = new PreloadTriggerManager(r111, this, r104, r100);
        this.f450616i = r106;
        this.f450617j = new AsyncTaskExecutor(new AsyncTaskExecutor.Companion.Config(r100.f450664g, r101, "async bind"));
        this.f450618k = LazyKt.lazy(AsyncBindManager$testTaskExecutor$2.INSTANCE);
        this.f450619l = r100.f450667j;
        r111.setViewCacheExtension(r104);
        int r107 = AsyncUtils.f450643a;
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r104, "cache");
        r111.setTag(2147483395, r104);
        r111.addOnScrollListener(r106);
        r104.f450699c = r105;
    }

    @Override // com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.config.BindManagerEx
    public final PreBindResult a(final int r210, final a r211, Trigger r212) {
        Intrinsics.checkNotNullParameter(r211, "config");
        Intrinsics.checkNotNullParameter(r212, "trigger");
        if (this.f450615h == false) goto L5;
        AsyncViewHolderHelper r100 = AsyncViewHolderHelper.f450657d;
        RecyclerView r101 = this.f450608a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        HashMap r102 = AsyncViewHolderHelper.a(r101);
        b r103 = (b) r102.get(Integer.valueOf(r210));
        if (r103 != null) goto L9;
        r103 = new b(0);
        r102.put(Integer.valueOf(r210), r103);
    L9:
        final b r110 = r103;
        r110.f572745f = r212;
        if (d(r210, r211, r110, true, true) == false) goto L12;
        r110.f572749j = null;
        RecyclerView.Adapter r104 = this.f450608a.getAdapter();
        if (r104 == null) goto L16;
        Integer r105 = Integer.valueOf(r104.getItemViewType(r210));
    L17:
        if (r105 != null) goto L20;
        r110.f572749j = "[preBind] itemType == null";
        r211.f457136f.invoke();
        return new PreBindResult(false, r110.f572749j);
    L20:
        final SearchAggregateCommodity r106 = this.f450611d.getData(r210);
        if (r106 != null) goto L24;
        r110.f572749j = "[preBind] data == null";
        r211.f457136f.invoke();
        return new PreBindResult(false, r110.f572749j);
    L24:
        final String r107 = String.valueOf(r105.intValue());
        PreloadConfigHandler<T> r108 = this.f450612e;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r107, "cardType");
        Intrinsics.checkNotNullParameter(r211, "config");
        Intrinsics.checkNotNullParameter(r110, "taskInfo");
        CardPreloadConfig r109 = r108.f450687a.invoke(r107, Integer.valueOf(r210), r106);
        if (r109 == null) goto L27;
    L30:
        if (r109 == null) goto L32;
        Mode r111 = r109.f450685b;
    L33:
        Mode r112 = Mode.ON_ASYNC_THREAD;
        if (r111 == r112) goto L36;
        if (r109 == null) goto L44;
        Mode r113 = r109.f450685b;
    L45:
        Mode r114 = Mode.ON_MAIN_THREAD;
        if (r113 == r114) goto L48;
        r110.f572749j = "[preBind] not in preload config";
        Mode r115 = Mode.NO_PRELOAD;
    L52:
        if (r115 == r112) goto L61;
        Mode r116 = Mode.ON_MAIN_THREAD;
        if (r115 == r116) goto L68;
        if (r109 == null) goto L59;
        Mode r117 = r109.f450684a;
    L60:
        if (r117 == r112) goto L61;
        if (r109 == null) goto L64;
        Mode r118 = r109.f450684a;
    L65:
        if (r118 == r116) goto L67;
    L69:
        Mode r119 = Mode.NO_PRELOAD;
    L70:
        Mode r213 = r115;
        Mode r120 = r119;
        Mode r121 = r213;
    L71:
        Pair r122 = new Pair(r121, r120);
        Mode r123 = (Mode) r122.getFirst();
        Mode r124 = (Mode) r122.getSecond();
        Mode r125 = Mode.NO_PRELOAD;
        if (r123 != r125) goto L79;
        if (r124 != r125) goto L79;
        if (r110.f572749j != null) goto L77;
        r110.f572749j = "[preBind] disallow async bind";
    L77:
        r211.f457136f.invoke();
        return new PreBindResult(false, r110.f572749j);
    L79:
        this.f450608a.getRecycledViewPool().setMaxRecycledViews(r105.intValue(), 8);
        Mode r126 = Mode.ON_ASYNC_THREAD;
        if (r124 != r126) goto L92;
        if (r123 != r125) goto L92;
        r110.f572749j = "[preBind] preload ViewHolder";
        AsyncCreateManager r127 = this.f450620m;
        if (r127 == null) goto L91;
        int r128 = r105.intValue();
        Function0<Boolean> r129 = r211.f457135e;
        Function0<Unit> r130 = r211.f457136f;
        Intrinsics.checkNotNullParameter(r129, "canContinue");
        Intrinsics.checkNotNullParameter(r130, "onComplete");
        if (r127.f450633e.getRecycledViewPool().getRecycledViewCount(r128) <= 0) goto L88;
        r130.invoke();
        goto L91
    L88:
        if (r127.f450635g.e(r128) >= 1) goto L91;
        AsyncPreloadViewHolderTask r131 = new AsyncPreloadViewHolderTask(r127.f450630b, r128, r127.f450633e, r129, r130, r127.f450635g, r127.f450634f);
        r131.f450719b = r127.f450635g.a(r131, r128, false, true);
    L91:
        return new PreBindResult(true, "[preBind] preload ViewHolder");
    L92:
        final int r132 = r105.intValue();
        final RecyclerView.Adapter r133 = this.f450608a.getAdapter();
        AsyncCacheExtension<T> r134 = this.f450613f;
        Long r135 = r211.f457139i;
        r134.getClass();
        final CacheInfo<T> r136 = new CacheInfo(r210, r132, r106, r135, r110);
        if (r211.f457140j == false) goto L95;
        r136.f450712f.set(true);
    L95:
        r110.f572741b = Long.valueOf(SystemClock.uptimeMillis());
        r110.f572750k = Integer.valueOf(this.f450613f.f450698b.values().size());
        if (r123 == r126) goto L98;
        SearchAggregateCommodity r214 = r106;
        Mode r137 = Mode.ON_MAIN_THREAD;
        if (r123 != r137) goto L122;
        final AsyncBindManager$doPreBindOnMainThread$doBindTask$1 r138 = new AsyncBindManager$doPreBindOnMainThread$doBindTask$1(this, r211, r210, r110, r107, r133, r136, r214);
        final Function0<Unit> r139 = new AsyncBindManager$doPreBindOnMainThread$preloadTask$1(this, r136, r110, r132, r133, r211, r138, r210);
        if (r124 != r137) goto L116;
    L121:
        AsyncBindManager<T> r140 = this;
        r139.invoke();
    L123:
        AsyncCacheExtension<T> r141 = r140.f450613f;
        r141.getClass();
        Intrinsics.checkNotNullParameter(r136, "cacheInfo");
        if (r136.f450712f.get() == false) goto L126;
        OffScreenPreRenderCache r142 = r141.f450700d;
        r142.getClass();
        Intrinsics.checkNotNullParameter(r136, "cacheInfo");
        r142.f450718a.put(r214, r136);
    L141:
        return new PreBindResult(true, "");
    L126:
        SearchAggregateCommodity r143 = r214;
        CacheInfo<T> r144 = r141.b(r210);
        if (r144 != null) goto L129;
    L137:
        r136.toString();
        T r145 = r136.f450715i;
        if (r145 == null) goto L141;
        r141.f450698b.put(r145, r136);
        goto L141
    L129:
        if (r141.f450703g.h(r144.f450715i, r143) == false) goto L136;
        new Exception(r136.toString());
        Future<TaskResult<RecyclerView.ViewHolder>> r146 = r144.f450708b;     // Catch: Exception -> L135
        if (r146 == null) goto L137;
        r146.cancel(true);     // Catch: Exception -> L135
        goto L137
    L136:
        r144.toString();
        goto L137
    L116:
        if (r211.f457133c == true) goto L121;
        r140 = this;
        if (r124 != r126) goto L123;
        r140.f450609b.submit(new AsyncBindManager$doPreBindOnMainThread$1(r139));
    L122:
        r140 = this;
        goto L123
    L98:
        if (r211.f457140j == false) goto L100;
    L102:
        r214 = r106;
        com.ss.ugc.android.cachalot.common.async.tasks.a r147 = new com.ss.ugc.android.cachalot.common.async.tasks.a(new AsyncBindManager$doPreBindOnAsyncThread$task$1(this, r211, r210, r110, r136, r132, r133, r107, r106), r211.f457136f);
        ExecutorService r148 = r211.f457138h;
        if (r148 == null) goto L105;
        Future<TaskResult<RecyclerView.ViewHolder>> r149 = r148.submit(r147);
        boolean r150 = false;
    L106:
        if (r149 != null) goto L108;
        r110.f572748i = "future is null, append task failed";
        r211.f457136f.invoke();
        PreBindResult r151 = new PreBindResult(r150, r110.f572748i);
    L109:
        if (r151 == null) goto L122;
        return r151;
    L108:
        r136.f450708b = r149;
        r151 = null;
        goto L109
    L105:
        AsyncTaskExecutor<RecyclerView.ViewHolder> r152 = this.f450617j;
        int r153 = System.identityHashCode(r214);
        int r154 = AsyncTaskExecutor.f450729e;
        r150 = false;
        r149 = r152.a(r147, r153, false, false);
        goto L106
    L100:
        if (d(r210, r211, r110, false, false) == true) goto L102;
        r151 = new PreBindResult(false, "task is unnecessary, Mode.ON_ASYNC_THREAD doBindTask return");
        r214 = r106;
        goto L109
    L67:
        if (r211.f457132b == true) goto L69;
    L64:
        r118 = null;
        goto L65
    L59:
        r117 = null;
    L68:
        r119 = r116;
    L61:
        r119 = r112;
        goto L70
    L48:
        if (r211.f457132b == true) goto L50;
        r115 = r114;
        goto L52
    L50:
        r110.f572749j = "[preBind] not allow preload on main thread";
        r115 = Mode.NO_PRELOAD;
        goto L52
    L44:
        r113 = null;
        goto L45
    L36:
        if (r211.f457131a == true) goto L39;
        r115 = r112;
        goto L52
    L39:
        if (r211.f457132b == true) goto L41;
        r115 = Mode.ON_MAIN_THREAD;
        goto L52
    L41:
        r110.f572749j = "[preBind] force bind on main thread && not allow preload on main thread";
        r115 = Mode.NO_PRELOAD;
        goto L52
    L32:
        r111 = null;
        goto L33
    L27:
        if (r211.f457134d == true) goto L30;
        r110.f572749j = "[preBind] not in preload config";
        r121 = Mode.NO_PRELOAD;
        r120 = r121;
        goto L71
    L16:
        r105 = null;
        goto L17
    L12:
        return new PreBindResult(false, "Task is InValid.");
    L5:
        return new PreBindResult(false, "AsyncBindManager is not Enable.");
    }

    public static final RecyclerView.ViewHolder b(AsyncBindManager r100, int r101, b r102, RecyclerView.Adapter r103, a r104) {
        RecyclerView.ViewHolder r105 = r100.f450608a.getRecycledViewPool().getRecycledView(r101);
        if (r105 == null) goto L5;
        boolean r106 = true;
    L6:
        r102.f572747h = Boolean.valueOf(r106);
        if (r105 != null) goto L12;
        if (r103 == null) goto L10;
        RecyclerView.ViewHolder r107 = r103.createViewHolder(r100.f450608a, r101);
    L11:
        r105 = r107;
        goto L12
    L10:
        r107 = null;
    L12:
        if (r105 == null) goto L15;
        r104.f457137g.invoke(r105);
        return r105;
    L15:
        Exception r108 = new Exception("[createVhTask] holder is null");
        r102.f572748i = r108.getMessage();
        throw r108;
    L5:
        r106 = false;
        goto L6
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
    public final boolean d(int r100, a r101, b r102, boolean r110, boolean r111) {
        if (r110 == true) goto L5;
    L8:
        Companion r103 = f450607n;
        RecyclerView r112 = this.f450608a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r112, "recyclerView");
        RecyclerView.LayoutManager r104 = r112.getLayoutManager();
        if (r104 == null) goto L21;
        int r105 = r104.getChildCount();
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L21;
        View r107 = r104.getChildAt(r106);     // Catch: Exception -> L83
        if (r107 == null) goto L20;
        RecyclerView.ViewHolder r108 = r112.getChildViewHolder(r107);     // Catch: Exception -> L83
        if (r108.getLayoutPosition() != r100) goto L20;
        if (RecyclerViewExKt.c(r108) == true) goto L20;
        boolean r109 = true;
    L22:
        if (r109 == false) goto L25;
        r101.f457136f.invoke();
        return false;
    L25:
        if (r111 == false) goto L82;
        AsyncCacheExtension<T> r113 = this.f450613f;
        CacheInfo r114 = r113.b(r100);
        Object r115 = null;
        if (r114 == null) goto L49;
        IDataProvider<T> r116 = r113.f450703g;
        if (r116.h(r114.f450715i, r116.getData(r100)) == false) goto L49;
        Future<TaskResult<RecyclerView.ViewHolder>> r117 = r114.f450708b;
        if (r117 != null) goto L33;
    L34:
        Future<TaskResult<RecyclerView.ViewHolder>> r118 = r114.f450708b;
        if (r118 == null) goto L77;
        if (r118.isDone() != true) goto L77;
        Future<TaskResult<RecyclerView.ViewHolder>> r119 = r114.f450708b;
        if (r119 == null) goto L41;
        TaskResult<RecyclerView.ViewHolder> r120 = r119.get(0, TimeUnit.MILLISECONDS);
    L42:
        if (r120 != null) goto L77;
    L43:
        SearchAggregateCommodity r121 = r113.f450703g.getData(r100);
        if (r121 == null) goto L46;
        r115 = (CacheInfo) ((CacheInfo<T>) r113.f450698b.remove(r121));
    L46:
        r113.c(r115, true);
    L78:
        boolean r122 = false;
    L79:
        if (r122 == false) goto L82;
        r101.f457136f.invoke();
        return false;
    L41:
        r120 = null;
    L77:
        r122 = true;
        goto L79
    L33:
        if (r117.isCancelled() == true) goto L43;
    L49:
        if (r113.f450701e == null) goto L88;
    L62:
        RecyclerView.Recycler r123 = r113.f450701e;
        if (r123 == null) goto L75;
        Intrinsics.checkNotNullParameter(r123, "$this$getScrapOrHiddenOrCachedHolderForPosition");
        if (RecyclerViewExKt.f450783i == null) goto L84;
    L71:
        Method r124 = RecyclerViewExKt.f450783i;
        if (r124 == null) goto L75;
        Intrinsics.checkNotNull(r124);     // Catch: Exception -> L70
        r115 = (RecyclerView.ViewHolder) r124.invoke(r123, new Object[]{Integer.valueOf(r100), Boolean.TRUE});     // Catch: Exception -> L70
        goto L75
    L84:
        Method r125 = RecyclerView.Recycler.class.getDeclaredMethod("getScrapOrHiddenOrCachedHolderForPosition", new Class[]{Integer.TYPE, Boolean.TYPE});     // Catch: Exception -> L70
        RecyclerViewExKt.f450783i = r125;     // Catch: Exception -> L70
        if (r125 == null) goto L71;
        r125.setAccessible(true);     // Catch: Exception -> L70
    L75:
        if (r115 == null) goto L78;
    L88:
        RecyclerView r126 = r113.f450702f;     // Catch: Exception -> L53
        Intrinsics.checkNotNullParameter(r126, "$this$getRecycler");     // Catch: Exception -> L53
        if (RecyclerViewExKt.f450782h != null) goto L54;
        ReflectUtil.f450784a.getClass();     // Catch: Exception -> L53
        RecyclerViewExKt.f450782h = ReflectUtil.a(r126, "mRecycler");     // Catch: Exception -> L53
    L54:
        Field r127 = RecyclerViewExKt.f450782h;     // Catch: Exception -> L53
        if (r127 == null) goto L57;
        Object r128 = r127.get(r126);     // Catch: Exception -> L53
    L59:
        if ((r128 instanceof RecyclerView.Recycler) == true) goto L61;
        r128 = null;
    L61:
        r113.f450701e = (RecyclerView.Recycler) r128;     // Catch: Exception -> L53
        goto L62
    L57:
        r128 = null;
    L82:
        return true;
    L20:
        r106 = r106 + 1;
    L21:
        r109 = false;
        goto L22
    L5:
        if (this.f450611d.c(r100) == true) goto L8;
        r102.f572749j = "[preBind] position invalid";
        r101.f457136f.invoke();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final RecyclerView.ViewHolder c(AsyncBindManager r100, RecyclerView.ViewHolder r101, b r102, int r103, a r104, RecyclerView.Adapter r110, CacheInfo r111, Object r112) {
        r100.getClass();
        r102.f572743d = Long.valueOf(SystemClock.uptimeMillis());
        boolean r105 = Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));
        r102.f572746g = Boolean.valueOf(r105);
        if (r101 != 0) goto L6;
        new Throwable();
        r102.f572749j = "[bindTask] VH is null";
    L67:
        return null;
    L6:
        if (r104.f457140j == true) goto L18;
        int r106 = r101.getItemViewType();
        if (r110 != null) goto L10;
    L12:
        boolean r107 = false;
    L13:
        if (r107 == true) goto L18;
        r101.getItemViewType();
        if (r110 == null) goto L67;
        r110.getItemViewType(r103);
        goto L67
    L10:
        if (r106 != r110.getItemViewType(r103)) goto L12;
        r107 = true;
    L18:
        if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L20;
    L66:
        r100.f450613f.c(r111, true);
        r102.f572749j = "[bindTask] interrupted before bind";
        goto L67
    L20:
        if (r104.f457135e.invoke().booleanValue() == false) goto L66;
        if (r104.f457140j == true) goto L26;
        RecyclerViewExKt.d(r101, r103);
    L26:
        if (r104.f457140j == false) goto L28;
    L35:
        if (r105 == true) goto L71;
    L40:
        AsyncViewHolderHelper r108 = AsyncViewHolderHelper.f450657d;     // Catch: Exception -> L63
        int r113 = r101.itemView.hashCode();     // Catch: Exception -> L63
        r108.getClass();     // Catch: Exception -> L63
        Map<Integer, Boolean> r109 = AsyncViewHolderHelper.f450654a;     // Catch: Exception -> L63
        ConcurrentHashMap r114 = (ConcurrentHashMap) r109;     // Catch: Exception -> L63
        r114.put(Integer.valueOf(r113), Boolean.TRUE);     // Catch: Exception -> L63
    L42:
        if ((r101 instanceof zkc.a) == false) goto L69;
        ((zkc.a) r101).l1(r102.f572745f);     // Catch: Exception -> L63
    L69:
        r111.f450710d.set(true);     // Catch: Throwable -> L58
        r100.f450610c.invoke(r101, Integer.valueOf(r103), r112, Boolean.TRUE);     // Catch: Throwable -> L58
        r111.f450711e.set(true);     // Catch: Throwable -> L58
    L47:
        if ((r101 instanceof zkc.a) == false) goto L50;
        ((zkc.a) r101).n1();     // Catch: Exception -> L63
    L50:
        if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L57;
        r100.f450613f.c(r111, true);
        if (r100.f450619l == true) goto L54;
    L56:
        r102.f572749j = "[bindTask] interrupted after bind";
        goto L67
    L54:
        if (r111.f450707a != null) goto L56;
        r100.f450608a.getRecycledViewPool().putRecycledView(r101);
        goto L56
    L57:
        r102.f572744e = Long.valueOf(SystemClock.uptimeMillis());
        r111.f450707a = r101;
        return r101;
    L58:
        th = move-exception;
        if ((r101 instanceof zkc.a) == false) goto L62;
        ((zkc.a) r101).n1();     // Catch: Exception -> L63
    L62:
        throw th;     // Catch: Exception -> L63
    L63:
        e = move-exception;
        r100.f450613f.c(r111, false);
        f450607n.getClass();
        Companion.c(e);
        throw e;
    L71:
        if (r104.f457134d == false) goto L42;
        if (r104.f457133c == false) goto L42;
    L28:
        if (r100.f450611d.c(r103) == true) goto L35;
        r100.f450613f.c(r111, true);
        if (r100.f450619l == true) goto L32;
    L34:
        r102.f572749j = "[bindTask] position invalid";
        goto L67
    L32:
        if (r111.f450707a != null) goto L34;
        r100.f450608a.getRecycledViewPool().putRecycledView(r101);
        goto L34
    }
}
