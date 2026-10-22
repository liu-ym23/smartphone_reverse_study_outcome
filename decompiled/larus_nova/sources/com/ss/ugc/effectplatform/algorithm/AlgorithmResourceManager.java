package com.ss.ugc.effectplatform.algorithm;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.EffectPlatform;
import com.ss.ugc.effectplatform.cache.j;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.repository.AlgorithmRepository;
import com.ss.ugc.effectplatform.task.BaseTask;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.task.x0;
import com.ss.ugc.effectplatform.util.k;
import com.ss.ugc.effectplatform.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u0001:\u0001=B\u0011\b\u0002\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ*\u0010\u0016\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0014\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0014\u0018\u00010\u0013JE\u0010\u001a\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00172\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010JC\u0010\"\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\b\u0010!\u001a\u0004\u0018\u00010 2\u0014\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0014\u0018\u00010\u0013¢\u0006\u0004\b\"\u0010#J\u0016\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010'\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$2\u0006\u0010\r\u001a\u00020\fR\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u00105R\u0017\u00107\u001a\u0002068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceManager;", "", "Lcom/ss/ugc/effectplatform/algorithm/a;", "getEffectFetcherInternal", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmModelResourceFinder;", "getResourceFinder", "Lcom/ss/ugc/effectplatform/algorithm/g;", "customResourceFinder", "", "setCustomResourceFinder", "getCustomResourceFinder", "getEffectFetcher", "Lcom/ss/ugc/effectplatform/model/Effect;", "effect", "", "areRequirementsReady", "", "", "requirements", "Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;", "", "listener", "fetchResourcesNeededByRequirements", "", "modelNames", "", "fetchResourcesByRequirementsAndModelNames", "([Ljava/lang/String;Ljava/util/Map;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;)V", "Lcom/ss/ugc/effectplatform/model/d;", "fetchLocalModelInfo", "", "businessId", "Lcom/ss/ugc/effectplatform/a;", "abTest", "fetchResourcesWithModelNames", "(I[Ljava/lang/String;Lcom/ss/ugc/effectplatform/a;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;)V", "Lcom/ss/ugc/effectplatform/EffectPlatform;", "effectPlatform", "isEffectReady", "isEffectReadyLite", "Lcom/ss/ugc/effectplatform/cache/a;", "algorithmModelCache", "Lcom/ss/ugc/effectplatform/cache/a;", "Lcom/ss/ugc/effectplatform/algorithm/d;", "buildInAssetsManager", "Lcom/ss/ugc/effectplatform/algorithm/d;", "resourceFinder", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmModelResourceFinder;", "effectFetcher", "Lcom/ss/ugc/effectplatform/algorithm/a;", "Lcom/ss/ugc/effectplatform/repository/AlgorithmRepository;", "algorithmRepository", "Lcom/ss/ugc/effectplatform/repository/AlgorithmRepository;", "Lcom/ss/ugc/effectplatform/algorithm/g;", "Lcom/ss/ugc/effectplatform/EffectConfig;", "effectConfig", "Lcom/ss/ugc/effectplatform/EffectConfig;", "getEffectConfig", "()Lcom/ss/ugc/effectplatform/EffectConfig;", "<init>", "(Lcom/ss/ugc/effectplatform/EffectConfig;)V", "Companion", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class AlgorithmResourceManager {
    public static final Companion Companion = null;
    private static AlgorithmResourceManager INSTANCE;
    private static f libraryLoader;
    private final com.ss.ugc.effectplatform.cache.a algorithmModelCache;
    private final AlgorithmRepository algorithmRepository;
    private d buildInAssetsManager;
    private g customResourceFinder;
    private final EffectConfig effectConfig;
    private a effectFetcher;
    private AlgorithmModelResourceFinder resourceFinder;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007R*\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceManager$Companion;", "", "Lcom/ss/ugc/effectplatform/EffectConfig;", "config", "", "initialize", "", "bussinessId", "fetchModelList", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceManager;", "getInstance", "", "isInitialized", "Lcom/ss/ugc/effectplatform/algorithm/f;", "value", "libraryLoader", "Lcom/ss/ugc/effectplatform/algorithm/f;", "getLibraryLoader", "()Lcom/ss/ugc/effectplatform/algorithm/f;", "setLibraryLoader", "(Lcom/ss/ugc/effectplatform/algorithm/f;)V", "INSTANCE", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceManager;", "<init>", "()V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {

        /* JADX INFO: loaded from: classes36.dex */
        public static final class a extends BaseTask {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ int f457232g;

            @Override // com.ss.ugc.effectplatform.task.BaseTask
            public final void b() {
            }

            @Override // com.ss.ugc.effectplatform.task.BaseTask
            public final void a() {
                x0.a r100 = x0.f457978k;     // Catch: Exception -> L4
                EffectConfig r101 = AlgorithmResourceManager.Companion.getInstance().getEffectConfig();     // Catch: Exception -> L4
                r100.getClass();     // Catch: Exception -> L4
                x0.a.b(r101).a(this.f457232g, false);     // Catch: Exception -> L4
                return;
            }

            public a(int r100, String r101) {
                this.f457232g = r100;
                super(r101, null);
            }
        }

        private Companion() {
        }

        @JvmStatic
        public final AlgorithmResourceManager getInstance() {
            AlgorithmResourceManager r100 = AlgorithmResourceManager.access$getINSTANCE$cp();
            if (r100 == null) goto L6;
            return r100;
        L6:
            throw new IllegalStateException("AlgorithmManager has not initialized,call AlgorithmManager#initialize first!");
        }

        public final f getLibraryLoader() {
            return AlgorithmResourceManager.access$getLibraryLoader$cp();
        }

        @JvmStatic
        public final boolean isInitialized() {
            if (AlgorithmResourceManager.access$getINSTANCE$cp() == null) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final void fetchModelList(int r100) {
            x0.f457978k.getClass();
            if (x0.f457975h.get("biz_" + r100) != null) goto L8;
            q1 r101 = getInstance().getEffectConfig().D;
            if (r101 == null) goto L9;
            r101.a(new a(r100, q.a()));
            return;
        L9:
            return;
        }

        @JvmStatic
        public final synchronized void initialize(EffectConfig r100) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (AlgorithmResourceManager.access$getINSTANCE$cp() != null) goto L9;
            AlgorithmResourceManager.access$setINSTANCE$cp(new AlgorithmResourceManager(r100, null));     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L9:
            throw new IllegalStateException("Duplicate initialization");     // Catch: Throwable -> L10
        }

        public final void setLibraryLoader(f r100) {
            AlgorithmResourceManager.access$setLibraryLoader$cp(r100);
            f r101 = b.f457239a;
            b.f457239a = r100;
        }

        public static /* synthetic */ void fetchModelList$default(Companion r100, int r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L5;
            r101 = 0;
        L5:
            r100.fetchModelList(r101);
        }
    }

    @JvmStatic
    public static final void fetchModelList(int r100) {
        Companion.fetchModelList(r100);
    }

    @JvmStatic
    public static final AlgorithmResourceManager getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final synchronized void initialize(EffectConfig r100) {
        monitor-enter(AlgorithmResourceManager.class);
        Companion.initialize(r100);     // Catch: Throwable -> L7
        monitor-exit(AlgorithmResourceManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return Companion.isInitialized();
    }

    public final g getCustomResourceFinder() {
        return null;
    }

    static {
        Companion = new Companion(null);
        libraryLoader = f.a.f457253a;
    }

    private final a getEffectFetcherInternal() {
        a r100 = this.effectFetcher;
        if (r100 != null) goto L7;
        EffectConfig r101 = this.effectConfig;
        x0.f457978k.getClass();
        a r102 = new a(r101, x0.a.b(r101), this.buildInAssetsManager, this.algorithmModelCache);
        this.effectFetcher = r102;
        return r102;
    L7:
        return r100;
    }

    public final AlgorithmModelResourceFinder getResourceFinder() {
        AlgorithmModelResourceFinder r100 = this.resourceFinder;
        if (r100 != null) goto L7;
        com.ss.ugc.effectplatform.cache.a r101 = this.algorithmModelCache;
        d r102 = this.buildInAssetsManager;
        this.effectConfig.getClass();
        AlgorithmModelResourceFinder r103 = new AlgorithmModelResourceFinder(r101, r102, null, this.effectConfig);
        this.resourceFinder = r103;
        return r103;
    L7:
        return r100;
    }

    public final a getEffectFetcher() {
        return getEffectFetcherInternal();
    }

    public static final /* synthetic */ AlgorithmResourceManager access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ f access$getLibraryLoader$cp() {
        return libraryLoader;
    }

    public final EffectConfig getEffectConfig() {
        return this.effectConfig;
    }

    private AlgorithmResourceManager(EffectConfig r100) {
        this.effectConfig = r100;
        this.buildInAssetsManager = new d(r100.G, r100.I, r100.f457157c0);
        z.b<String, j> r101 = com.ss.ugc.effectplatform.cache.h.f457336a;
        j r102 = com.ss.ugc.effectplatform.cache.h.a(r100.K);
        if (r102 != null) goto L5;
    L8:
        com.ss.ugc.effectplatform.cache.a r103 = new com.ss.ugc.effectplatform.cache.a(r100, r100.K, r100.f457164j, r100.Q.hashCode(), this.buildInAssetsManager);
        this.algorithmModelCache = r103;
        String r104 = r100.K;
        com.ss.ugc.effectplatform.cache.h.f457336a.put(r104, r103);
    L10:
        if (AlgorithmRepository.f457471g == null) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L16;
        AlgorithmRepository.f457471g = new AlgorithmRepository(r100);
    L16:
        if (r100.T == false) goto L20;
        Object r106 = r100.G;
        if (r106 == null) goto L20;
        com.ss.ugc.effectplatform.preload.b.f457436d.getClass();
        com.ss.ugc.effectplatform.preload.b.a.a(r106);
    L20:
        this.algorithmRepository = AlgorithmRepository.a.a();
        return;
    L12:
        r105 = false;
        goto L13
    L5:
        if ((r102 instanceof com.ss.ugc.effectplatform.cache.a) == false) goto L8;
        this.algorithmModelCache = (com.ss.ugc.effectplatform.cache.a) r102;
        goto L10
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(AlgorithmResourceManager r100) {
        INSTANCE = r100;
    }

    public static final /* synthetic */ void access$setLibraryLoader$cp(f r100) {
        libraryLoader = r100;
    }

    public final boolean areRequirementsReady(Effect r100) {
        return this.algorithmRepository.a(r100);
    }

    public final List<com.ss.ugc.effectplatform.model.d> fetchLocalModelInfo(List<String> r110) {
        AlgorithmRepository r100 = this.algorithmRepository;
        r100.getClass();
        List<String> r111 = r110;
        int r101 = 0;
        boolean r102 = true;
        if (r111 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L43;
        Object[] r112 = r111.toArray(new String[0]);
        if (r112 == null) goto L38;
        EffectConfig r104 = r100.f457477f;
        String[] r113 = i.d((String[]) r112, r104.f457174t, r104.G);
        com.ss.ugc.effectplatform.task.algorithm.c r105 = r100.d().f457233a;
        EffectConfig r106 = r105.f457721l;
        d r107 = r105.f457719j;
        com.ss.ugc.effectplatform.cache.a r108 = r105.f457720k;
        hlc.a r109 = r106.N;
        new AtomicInteger(0);
        new AtomicInteger(0);
        Collections.synchronizedList(new ArrayList());
        if (r113 != null) goto L16;
    L22:
        if (r102 == true) goto L44;
        ArrayList r114 = new ArrayList();
        int r115 = r113.length;
    L25:
        if (r101 >= r115) goto L36;
        String r116 = r113[r101];
        com.ss.ugc.effectplatform.model.d r117 = r108.i(k.d(r116));
        if (r117 == null) goto L29;
        r114.add(r117);
    L34:
        r101 = r101 + 1;
        goto L25
    L29:
        boolean r118 = r107.b(r116);
        if (r118 == false) goto L32;
        Logger.INSTANCE.d("effect_platform", "model: " + r116 + " is built in resource");
    L32:
        if (r118 == false) goto L34;
        int r119 = com.ss.ugc.effectplatform.model.d.f457416g;
        StringBuilder r120 = new StringBuilder("file:///android_");
        r120.append("asset://model/" + r107.a(r116));
        com.ss.ugc.effectplatform.model.d r121 = new com.ss.ugc.effectplatform.model.d(r120.toString());
        String r122 = k.f(r116);
        int r123 = k.e(r116);
        r121.f457418b = r122;
        r121.f457420d = r123;
        r114.add(r121);
        goto L34
    L36:
        return r114;
    L44:
        return new ArrayList();
    L16:
        if (r113.length != 0) goto L18;
        boolean r124 = true;
    L19:
        if (r124 == true) goto L22;
        r102 = false;
        goto L22
    L18:
        r124 = false;
        goto L19
    L38:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L43:
        return new ArrayList();
    L5:
        if (r111.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public final void setCustomResourceFinder(g r100) {
        monitor-enter(this);
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ AlgorithmResourceManager(EffectConfig r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public final void fetchResourcesNeededByRequirements(List<String> r100, IEffectPlatformBaseListener<String[]> r101) {
        AlgorithmRepository r102 = this.algorithmRepository;
        q1 r103 = r102.f457477f.D;
        if (r103 == null) goto L6;
        r103.a(new com.ss.ugc.effectplatform.repository.b(r102, r100, r101, q.a()));
        return;
    }

    public final boolean isEffectReady(EffectPlatform r100, Effect r101) {
        return r100.isEffectReady(r101);
    }

    public final boolean isEffectReadyLite(EffectPlatform r100, Effect r101) {
        return r100.isEffectReadyLite(r101);
    }

    public final void fetchResourcesByRequirementsAndModelNames(String[] r100, Map<String, ? extends List<String>> r110, IEffectPlatformBaseListener<Long> r111) {
        AlgorithmRepository r101 = this.algorithmRepository;
        q1 r102 = r101.f457477f.D;
        if (r102 == null) goto L6;
        r102.a(new com.ss.ugc.effectplatform.repository.a(r101, r100, r110, r111, q.a()));
        return;
    }

    public final void fetchResourcesWithModelNames(int r100, String[] r101, com.ss.ugc.effectplatform.a r102, IEffectPlatformBaseListener<String[]> r103) {
        this.algorithmRepository.c(r100, r101, r102, r103);
    }
}
