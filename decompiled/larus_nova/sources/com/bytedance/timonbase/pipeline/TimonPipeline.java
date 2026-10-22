package com.bytedance.timonbase.pipeline;

import com.bytedance.timon.TimonException;
import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonSystem;
import com.bytedance.timonbase.TMEnv;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.camera_export.CameraParam;
import dh7.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 %2\u00020\u0001:\u0002&'B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0002J4\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bJ:\u0010\r\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u0016\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0014H\u0004J\b\u0010\u0017\u001a\u00020\u0007H\u0016R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001b0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u001d8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010\u0017\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\"¨\u0006("}, d2 = {"Lcom/bytedance/timonbase/pipeline/TimonPipeline;", "Lcom/bytedance/timon/pipeline/TimonSystem;", "Ldh7/c;", "entity", CameraParam.TYPE_SYSTEM_CAMERA, "", "validSystemAnnotation", "", "parent", "", "reverse", "Lkotlin/Function0;", "condition", "addSystem", "", "systems", "markInitialed", "isInitialed", "preInvoke", "postInvoke", "Lkotlin/Function1;", "block", "traverseSystem", "name", "", "systemsWithName", "Ljava/util/Map;", "", "systemTree", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialed", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "timonbase_release"}, k = 1, mv = {1, 4, 0})
public class TimonPipeline implements TimonSystem {
    public static final a Companion = null;
    private final AtomicBoolean initialed;
    private final String name;
    private final Map<String, List<TimonSystem>> systemTree;
    private final Map<String, TimonSystem> systemsWithName;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/timonbase/pipeline/TimonPipeline$b;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "preInvoke", "Z", "getPreInvoke", "()Z", "postInvoke", "getPostInvoke", "", "children", "Ljava/util/List;", "getChildren", "()Ljava/util/List;", "timonbase_release"}, k = 1, mv = {1, 4, 0})
    public static final class b {

        @SerializedName("children")
        private final List<b> children;

        @SerializedName("name")
        private final String name;

        @SerializedName("postInvoke")
        private final boolean postInvoke;

        @SerializedName("preInvoke")
        private final boolean preInvoke;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
            return false;
        L8:
            if (this.preInvoke == r101.preInvoke) goto L10;
            return false;
        L10:
            if (this.postInvoke == r101.postInvoke) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.children, r101.children) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public final int hashCode() {
            String r100 = this.name;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            boolean r104 = this.preInvoke;
            ?? r105 = 1;
            ?? r106 = r104;
            if (r104 == false) goto L9;
            r106 = 1;
        L9:
            int r107 = (r103 + r106) * 31;
            boolean r108 = this.postInvoke;
            if (r108 == true) goto L13;
            r105 = r108;
        L13:
            int r109 = (r107 + r105) * 31;
            List<b> r110 = this.children;
            if (r110 == null) goto L17;
            r101 = r110.hashCode();
        L17:
            return r109 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "GraphNode(name=" + this.name + ", preInvoke=" + this.preInvoke + ", postInvoke=" + this.postInvoke + ", children=" + this.children + ")";
        }

        public b() {
            List<b> r100 = CollectionsKt.emptyList();
            this.name = "";
            this.preInvoke = false;
            this.postInvoke = false;
            this.children = r100;
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isInitialed() {
        return this.initialed.get();
    }

    public final void markInitialed() {
        this.initialed.set(true);
    }

    public final AtomicBoolean getInitialed() {
        return this.initialed;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public String name() {
        return this.name;
    }

    public TimonPipeline(String r100) {
        this.name = r100;
        this.systemsWithName = new LinkedHashMap();
        this.systemTree = new LinkedHashMap();
        this.initialed = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [T, dh7.a, dh7.b] */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, dh7.a] */
    @Override // com.bytedance.timon.pipeline.TimonSystem
    public boolean postInvoke(final c r100) {
        if (this.initialed.get() == true) goto L24;
        return false;
    L24:
        long r101 = System.nanoTime();     // Catch: Exception -> L17
        final Ref.ObjectRef r102 = new Ref.ObjectRef();     // Catch: Exception -> L17
        ReentrantReadWriteLock.ReadLock r103 = r100.f468622b.readLock();     // Catch: Exception -> L17
        r103.lock();     // Catch: Exception -> L17
        Map<KClass<? extends dh7.b>, dh7.b> r104 = r100.f468621a;     // Catch: Throwable -> L14
        LinkedHashMap r105 = (LinkedHashMap) r104;     // Catch: Throwable -> L14
        Object r106 = r105.get(Reflection.getOrCreateKotlinClass(dh7.a.class));     // Catch: Throwable -> L14
        if ((r106 instanceof dh7.a) == true) goto L9;
        r106 = null;
    L9:
        ?? r107 = (dh7.a) r106;     // Catch: Throwable -> L14
        r103.unlock();     // Catch: Exception -> L17
        r102.element = r107;     // Catch: Exception -> L17
        if (r107 != 0) goto L13;
        int r108 = com.bytedance.timonbase.pipeline.a.f270820a;     // Catch: Exception -> L17
        ?? r109 = new dh7.a();     // Catch: Exception -> L17
        r102.element = r109;     // Catch: Exception -> L17
        r100.a(r109);     // Catch: Exception -> L17
    L13:
        ((dh7.a) r102.element).put("pipeline_post_start_time", r101);     // Catch: Exception -> L17
        ((dh7.a) r102.element).put("source", this.name);     // Catch: Exception -> L17
        traverseSystem("pipeline_root", new AnonymousClass1(this, r100, r102));     // Catch: Exception -> L17
    L21:
        return false;
    L14:
        th = move-exception;
        r103.unlock();     // Catch: Exception -> L17
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        if (TMEnv.f270767a == true) goto L23;
        vg7.a.a().monitorThrowable(e, "TimonException-Pipeline", MapsKt.emptyMap());
        goto L21
    L23:
        throw new Error(e);
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public boolean preInvoke(final c r100) {
        if (this.initialed.get() == true) goto L14;
        return false;
    L14:
        long r101 = System.nanoTime();     // Catch: Exception -> L7
        int r102 = com.bytedance.timonbase.pipeline.a.f270820a;     // Catch: Exception -> L7
        final dh7.a r103 = new dh7.a();     // Catch: Exception -> L7
        r100.a(r103);     // Catch: Exception -> L7
        r103.put("pipeline_pre_start_time", r101);     // Catch: Exception -> L7
        r103.put("source", this.name);     // Catch: Exception -> L7
        traverseSystem("pipeline_root", new C106611(this, r100, r103));     // Catch: Exception -> L7
    L11:
        return false;
    L7:
        e = move-exception;
        if (TMEnv.f270767a == true) goto L13;
        vg7.a.a().monitorThrowable(e, "TimonException-Pipeline", MapsKt.emptyMap());
        goto L11
    L13:
        throw new Error(e);
    }

    private final void validSystemAnnotation(c r100, final TimonSystem r101) throws TimonException {
        boolean r102 = TMEnv.f270767a;
        if (TMEnv.f270767a == true) goto L5;
        return;
    L5:
        ComponentDeps r103 = (ComponentDeps) ((Class) new TimonPipeline$validSystemAnnotation$componentDeps$1(r101).get()).getAnnotation(ComponentDeps.class);
        if (r103 == null) goto L21;
        KClass[] r104 = Reflection.getOrCreateKotlinClasses(r103.required());
        if (r104 == null) goto L26;
        int r105 = r104.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L27;
        KClass r107 = r104[r106];
        ReentrantReadWriteLock.ReadLock r108 = r100.f468622b.readLock();
        r108.lock();
        boolean r109 = r100.f468621a.containsKey(r107);     // Catch: Throwable -> L18
        r108.unlock();
        if (r109 == false) goto L17;
        r106 = r106 + 1;
        goto L10
    L17:
        throw new TimonException("system " + r101 + " required " + r107.getSimpleName() + ", but target component not found.");
    L18:
        th = move-exception;
        r108.unlock();
        throw th;
    L27:
        return;
    L26:
        return;
    }

    public final void traverseSystem(String r100, Function1<? super TimonSystem, Boolean> r101) {
        Stack r102 = new Stack();
        List<TimonSystem> r103 = this.systemTree.get(r100);
        if (r103 == null) goto L11;
        List r104 = CollectionsKt.asReversedMutable(r103);
        if (r104 == null) goto L11;
        Iterator r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L11;
        r102.push((TimonSystem) r105.next());
    L11:
        if ((!r102.isEmpty()) == false) goto L22;
        TimonSystem r106 = (TimonSystem) r102.pop();
        if (r101.invoke(r106).booleanValue() == false) goto L11;
        List<TimonSystem> r107 = this.systemTree.get(r106.name());
        if (r107 == null) goto L11;
        List r108 = CollectionsKt.asReversedMutable(r107);
        if (r108 == null) goto L11;
        Iterator r109 = r108.iterator();
    L20:
        if (r109.hasNext() == false) goto L11;
        r102.push((TimonSystem) r109.next());
        goto L20
    }

    public static final /* synthetic */ void access$validSystemAnnotation(TimonPipeline r100, c r101, TimonSystem r102) {
        r100.validSystemAnnotation(r101, r102);
    }

    public final void addSystem(List<? extends TimonSystem> r100, String r101, boolean r102, Function0<Boolean> r103) {
        List<? extends TimonSystem> r104 = r100;
        if ((r104 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        if (this.systemsWithName.containsKey(((TimonSystem) r105.next()).name()) == false) goto L9;
        boolean r106 = true;
    L14:
        if (r106 == true) goto L16;
        Iterator<T> r107 = r104.iterator();
    L26:
        if (r107.hasNext() == false) goto L28;
        TimonSystem r108 = (TimonSystem) r107.next();
        this.systemsWithName.put(r108.name(), r108);
        goto L26
    L28:
        if (r103 == null) goto L31;
        String r109 = "condition_before_" + ((TimonSystem) CollectionsKt.first(r100)).name();
        com.bytedance.timonbase.pipeline.b r110 = new com.bytedance.timonbase.pipeline.b(r109, r103, r103);
        this.systemsWithName.put(r109, r110);
        this.systemTree.put(r109, CollectionsKt.toMutableList(r100));
        r100 = CollectionsKt.listOf(r110);
    L31:
        if (Intrinsics.areEqual(r101, "pipeline_root") == false) goto L33;
        TimonSystem r111 = this;
    L34:
        if (r111 != null) goto L37;
        vg7.a.c().e("TimonPipeline", "parent system(" + r101 + ") not exist. please check.", null);
        return;
    L37:
        List<TimonSystem> r112 = this.systemTree.get(r101);
        if (r112 != null) goto L40;
        this.systemTree.put(r101, CollectionsKt.toMutableList(r100));
        return;
    L40:
        if (r102 == false) goto L42;
        r112.addAll(0, r100);
        return;
    L42:
        r112.addAll(r100);
        return;
    L33:
        r111 = this.systemsWithName.get(r101);
        goto L34
    L16:
        if (TMEnv.f270767a == false) goto L23;
        StringBuilder r113 = new StringBuilder("duplicate system added, please check ");
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r115 = r104.iterator();
    L19:
        if (r115.hasNext() == false) goto L21;
        r114.add(((TimonSystem) r115.next()).name());
        goto L19
    L21:
        r113.append(r114);
        throw new IllegalArgumentException(r113.toString());
    L23:
        return;
    L13:
        r106 = false;
        goto L14
    L5:
        if (r104.isEmpty() == false) goto L7;
        goto L7
    }

    public final void addSystem(TimonSystem r100, String r101, boolean r102, Function0<Boolean> r103) {
        addSystem(CollectionsKt.listOf(r100), r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addSystem$default(TimonPipeline r100, TimonSystem r101, String r102, boolean r103, Function0 r104, int r105, Object r106) {
        if (r106 != null) goto L15;
        if ((r105 & 2) == 0) goto L7;
        r102 = "pipeline_root";
    L7:
        if ((r105 & 4) == 0) goto L10;
        r103 = false;
    L10:
        if ((r105 & 8) == 0) goto L12;
        r104 = null;
    L12:
        r100.addSystem(r101, r102, r103, r104);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSystem");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addSystem$default(TimonPipeline r100, List r101, String r102, boolean r103, Function0 r104, int r105, Object r106) {
        if (r106 != null) goto L15;
        if ((r105 & 2) == 0) goto L7;
        r102 = "pipeline_root";
    L7:
        if ((r105 & 4) == 0) goto L10;
        r103 = false;
    L10:
        if ((r105 & 8) == 0) goto L12;
        r104 = null;
    L12:
        r100.addSystem(r101, r102, r103, r104);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSystem");
    }
}
