package com.bytedance.locallife.dito.core.manager;

import android.os.Looper;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.locallife.dito.data.DitoPage;
import com.bytedance.locallife.dito.data.i;
import com.bytedance.locallife.dito.data.m;
import com.bytedance.locallife.dito.data.v;
import com.bytedance.locallife.dito.log.error.DATA_CONTAINER_UPDATE_CONTAINER_ERROR;
import com.bytedance.locallife.dito.log.error.DATA_CONTAINER_UPDATE_TREE_NODE_NULL;
import com.bytedance.locallife.dito.log.error.DATA_CONTAINER_UPDATE_TYPE_ERROR;
import com.bytedance.locallife.dito.log.error.DATA_NODE_NOT_COMPONENT_TYPE;
import com.bytedance.locallife.dito.log.error.DATA_NODE_UPDATE_TREE_NODE_NULL;
import com.bytedance.locallife.dito.log.error.DATA_NODE_UPDATE_TYPE_ERROR;
import com.bytedance.locallife.dito.log.error.DATA_PROVIDER_NOT_REGISTER;
import com.bytedance.locallife.dito.log.error.DATA_REFRESH_CONTAINER_TYPE_ERROR;
import com.bytedance.locallife.dito.log.error.DATA_REFRESH_LAYOUT_EMPTY;
import com.bytedance.locallife.dito.log.error.DATA_REFRESH_NODES_EMPTY;
import com.bytedance.locallife.dito.log.error.DATA_REFRESH_TREE_MAP_EMPTY;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.locallife.dito.provider.f;
import com.bytedance.locallife.dito.provider.h;
import com.bytedance.locallife.dito.utils.j;
import com.bytedance.locallife.dito.utils.l;
import com.bytedance.locallife.dito.view.VisibleState;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class DitoDataManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DitoViewModel f257939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f257940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f257941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f257942d;

    public DitoDataManager(DitoViewModel r100) {
        ArrayList r101 = new ArrayList();
        Intrinsics.checkNotNullParameter(r100, "ditoViewModel");
        Intrinsics.checkNotNullParameter(r101, "ditoEventBusProviderList");
        this.f257939a = r100;
        this.f257940b = r101;
        this.f257941c = LazyKt.lazy(DitoDataManager$ditoNodeMerger$2.INSTANCE);
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((f) r102.next()).a(this.f257939a);
        goto L4
    L6:
        Dito r103 = Dito.f257280a;
        this.f257942d = l.k().getUseDitoNodeMerge();
    }

    public static List a(List r110, List r111) {
        Intrinsics.checkNotNullParameter(r110, "oldModelList");
        Intrinsics.checkNotNullParameter(r111, "newModelList");
        ArrayList r100 = new ArrayList();
        if (r110.size() <= r111.size()) goto L6;
        String r101 = "remove";
        List r102 = r111;
    L9:
        int r103 = r102.size();
        int r104 = 0;
        int r105 = -1;
    L11:
        if (r104 >= r103) goto L19;
        if (Intrinsics.areEqual(ListProtector.get(r110, r104), ListProtector.get(r111, r104)) == true) goto L16;
        if (r105 != (-1)) goto L18;
        r105 = r104;
    L18:
        r104 = r104 + 1;
        goto L11
    L16:
        if (r105 == (-1)) goto L18;
        DitoUpdateData r112 = new DitoUpdateData(ContainerPosition.BODY, "update", r105, r104 - r105);
        r100.add(r112);
        rq6.a.f538927a.a("dito_log", "getFinalUpdateData: " + r112);
        r105 = -1;
        goto L18
    L19:
        if (r105 == (-1)) goto L22;
        DitoUpdateData r106 = new DitoUpdateData(ContainerPosition.BODY, "update", r105, r102.size() - r105);
        r100.add(r106);
        rq6.a.f538927a.a("dito_log", "getFinalUpdateData: " + r106);
    L22:
        if (Intrinsics.areEqual(r101, DitoNode.LOAD_MORE) == false) goto L24;
        DitoUpdateData r107 = new DitoUpdateData(ContainerPosition.BODY, r101, r102.size(), Math.abs(r110.size() - r111.size()));
        rq6.a.f538927a.a("dito_log", "getFinalUpdateData: " + r107);
        r100.add(r107);
    L24:
        return r100;
    L6:
        if (r110.size() >= r111.size()) goto L8;
        r102 = r110;
        r101 = DitoNode.LOAD_MORE;
        goto L9
    L8:
        r102 = r110;
        r101 = "update";
        goto L9
    }

    public final BaseDitoModel<?> d(m r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "treeNode");
        boolean r100 = true;
        if (r111 == false) goto L22;
        DitoNode r112 = r110.f258221a;
        if (r112 != null) goto L7;
    L9:
        boolean r113 = false;
    L10:
        if (r113 == false) goto L22;
        DitoNode r114 = r110.f258221a;
        if (r114 != null) goto L14;
    L16:
        r100 = false;
    L17:
        if (r100 == false) goto L19;
    L20:
        rq6.a.f538927a.a("dito_log", "getModelFromProviders return null cause viewStub: " + r110.f258222b);
    L21:
        return null;
    L19:
        if (this.f257939a.f258041g.k0().getValue() != null) goto L21;
    L14:
        if (r114.isInflateViewStubAfterFmp() == true) goto L16;
    L7:
        if (r112.isViewStubAndNotInflated(j.h(this.f257939a)) != true) goto L9;
        r113 = true;
    L22:
        Iterator r115 = ((List) this.f257939a.f258042h.f257949b.f257961c.getValue()).iterator();
    L24:
        if (r115.hasNext() == false) goto L35;
        final BaseDitoModel<?> r101 = ((h) r115.next()).c(this.f257939a, r110);
        if (r101 == null) goto L24;
        if (Intrinsics.areEqual(this.f257939a.r(), "goods_detail_page") == true) goto L30;
        this.f257939a.f258042h.e(r101);
    L34:
        return r101;
    L30:
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L32;
        this.f257939a.f258042h.e(r101);
        goto L34
    L32:
        j.o(this.f257939a, new DitoDataManager$getModelFromProviders$1(this, r101));
        goto L34
    L35:
        DitoViewModel r102 = this.f257939a;
        DATA_PROVIDER_NOT_REGISTER r103 = DATA_PROVIDER_NOT_REGISTER.f258463a;
        StringBuilder r116 = new StringBuilder();
        DitoNode r104 = r110.f258221a;
        if (r104 == null) goto L38;
        String r105 = r104.getSubType();
    L39:
        r116.append(r105);
        r116.append("未注册");
        String r106 = r116.toString();
        Pair[] r117 = new Pair[2];
        DitoNode r107 = r110.f258221a;
        if (r107 == null) goto L42;
        String r108 = r107.getSubType();
    L43:
        r117[0] = TuplesKt.to("node_sub_type", r108);
        r117[1] = TuplesKt.to("node_tag", r110.f258222b);
        j.k(r102, r103, r106, MapsKt.mutableMapOf(r117), null, null, 24);
        return null;
    L42:
        r108 = null;
        goto L43
    L38:
        r105 = null;
        goto L39
    }

    public final List f(m r100, boolean r101) {
        ArrayList r102 = new ArrayList();
        if (r101 == false) goto L13;
        DitoNode r103 = r100.f258221a;
        if (r103 == null) goto L9;
        boolean r104 = true;
        if (r103.isViewStubAndNotInflated(j.h(this.f257939a)) != true) goto L9;
    L10:
        if (r104 == false) goto L13;
        return r102;
    L9:
        r104 = false;
    L13:
        if (r100.f258225e != VisibleState.GONE) goto L15;
        return r102;
    L15:
        DitoNode r105 = r100.f258221a;
        if (r105 != null) goto L19;
        return r102;
    L19:
        if (Intrinsics.areEqual(r105.getType(), "component") == false) goto L21;
        r102.add(r100);
    L25:
        return r102;
    L21:
        Iterator<m> r106 = r100.f258224d.iterator();
    L23:
        if (r106.hasNext() == false) goto L25;
        m r107 = r106.next();
        String r108 = r107.f258222b;
        r102.addAll(f(r107, r101));
        goto L23
    }

    public static IndexedValue c(DitoDataManager r100, m r101, List r102) {
        Dito r103 = Dito.f257280a;
        boolean r104 = l.k().getFixDitoTreeNodeInsertBug();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "oldTreeNode");
        Intrinsics.checkNotNullParameter(r102, "modelList");
        if (r104 == false) goto L21;
        IndexedValue r105 = null;
    L5:
        if (r105 != null) goto L37;
        m r106 = m.e(r101, null, true, 3);
        if (r106 == null) goto L8;
        Iterator r107 = CollectionsKt.withIndex(r102).iterator();
    L13:
        if (r107.hasNext() == false) goto L17;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((BaseDitoModel) ((IndexedValue) r108).getValue()).f258493b, r106) == false) goto L13;
    L18:
        r105 = (IndexedValue) r108;
        r101 = m.o(r106, null, 3);
        if (r101 != null) goto L5;
    L17:
        r108 = null;
        goto L18
    L8:
        r101 = m.o(r101, null, 3);
        if (r101 != null) goto L5;
    L37:
        return r105;
    L21:
        r105 = null;
    L22:
        if (r105 != null) goto L37;
        m r109 = m.e(r101, null, false, 7);
        if (r109 == null) goto L25;
        Iterator r110 = CollectionsKt.withIndex(r102).iterator();
    L30:
        if (r110.hasNext() == false) goto L34;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((BaseDitoModel) ((IndexedValue) r111).getValue()).f258493b, r109) == false) goto L30;
    L35:
        r105 = (IndexedValue) r111;
        r101 = m.n(r109);
        if (r101 != null) goto L22;
    L34:
        r111 = null;
        goto L35
    L25:
        r101 = m.o(r101, null, 3);
        if (r101 != null) goto L22;
        goto L37
    }

    public final synchronized i b(DitoPage r100, Map<String, m> r101, Map<String, CopyOnWriteArrayList<BaseDitoModel<?>>> r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "ditoNode");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r101, "treeMap");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r102, "containerModelMap");     // Catch: Throwable -> L10
        List<DitoUpdateData> r103 = CollectionsKt.emptyList();     // Catch: Throwable -> L10
        if (r100.hasRoot() == false) goto L6;
        g(r100, r101, r102);     // Catch: Throwable -> L10
        boolean r104 = true;
    L7:
        i r105 = new i(r100, r104, r103);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r105;
    L6:
        r103 = i(r100.getLayout(), r100.getNodes(), r101, r102);     // Catch: Throwable -> L10
        r104 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final void g(DitoPage r110, Map<String, m> r111, Map<String, CopyOnWriteArrayList<BaseDitoModel<?>>> r210) {
        Intrinsics.checkNotNullParameter(r111, "treeMap");
        Intrinsics.checkNotNullParameter(r210, "containerModelMap");
        if (r110 != null) goto L5;
        return;
    L5:
        Map<String, List<String>> r100 = r110.getLayout();
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L15;
        j.k(this.f257939a, DATA_REFRESH_LAYOUT_EMPTY.f258465a, null, null, null, null, 30);
        return;
    L15:
        Map<String, DitoNode> r102 = r110.getNodes();
        if (r102 != null) goto L18;
    L21:
        boolean r103 = true;
    L22:
        if (r103 == false) goto L25;
        j.k(this.f257939a, DATA_REFRESH_NODES_EMPTY.f258466a, null, null, null, null, 30);
        return;
    L25:
        LinkedHashMap r104 = new LinkedHashMap();
        LinkedHashMap r105 = (LinkedHashMap) r111;
        r105.clear();
        this.f257939a.f258041g.D().setValue(new v());
        Map r106 = m.a.a(new m(null, RootDescription.ROOT_ELEMENT, null, 8), r110.getLayout(), r110.getNodes(), r104);
        this.f257939a.f258041g.D().setValue(new v(false, null, null));
        this.f257939a.f258041g.E().setValue(new v());
        if (r106.isEmpty() == false) goto L28;
        j.k(this.f257939a, DATA_REFRESH_TREE_MAP_EMPTY.f258467a, null, null, null, null, 30);
    L28:
        r105.putAll(r106);
        LinkedHashMap r107 = (LinkedHashMap) r210;
        Iterator r108 = r107.values().iterator();
    L30:
        if (r108.hasNext() == false) goto L36;
        CopyOnWriteArrayList r109 = (CopyOnWriteArrayList) r108.next();
        Iterator r112 = r109.iterator();
    L33:
        if (r112.hasNext() == false) goto L35;
        ((BaseDitoModel) r112.next()).h();
        goto L33
    L35:
        r109.clear();
        goto L30
    L36:
        Iterator r113 = r104.entrySet().iterator();
    L38:
        if (r113.hasNext() == false) goto L43;
        Map.Entry r114 = (Map.Entry) r113.next();
        CopyOnWriteArrayList r115 = (CopyOnWriteArrayList) r107.get(r114.getKey());
        if (r115 == null) goto L41;
        m r116 = (m) r114.getValue();
        String r117 = (String) r114.getKey();
        r115.addAll(e(this, r116, false, 24));
        goto L38
    L41:
        j.k(this.f257939a, DATA_REFRESH_CONTAINER_TYPE_ERROR.f258464a, ((String) r114.getKey()) + " 不是内置容器key", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r114.getKey())}), null, null, 24);
        goto L38
    L43:
        this.f257939a.f258041g.E().setValue(new v(false, null, null));
        return;
    L18:
        if (r102.isEmpty() == true) goto L21;
        r103 = false;
        goto L22
    L8:
        if (r100.isEmpty() == true) goto L11;
        r101 = false;
        goto L12
    }

    public static List e(DitoDataManager r100, m r101, boolean r102, int r103) {
        if ((r103 & 16) == 0) goto L5;
        r102 = true;
    L5:
        r100.getClass();
        ArrayList r104 = new ArrayList();
        if (r102 == false) goto L16;
        DitoNode r105 = r101.f258221a;
        if (r105 != null) goto L10;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == false) goto L16;
    L30:
        return r104;
    L10:
        if (r105.isViewStubAndNotInflated(j.h(r100.f257939a)) != true) goto L12;
        r106 = true;
    L16:
        if (r101.f258225e == VisibleState.GONE) goto L30;
        DitoNode r107 = r101.f258221a;
        if (r107 == null) goto L30;
        if (Intrinsics.areEqual(r107.getType(), "component") == false) goto L26;
        BaseDitoModel<?> r108 = r100.d(r101, true);
        if (r108 == null) goto L30;
        r104.add(r108);
        goto L30
    L26:
        Iterator<m> r109 = r101.f258224d.iterator();
    L28:
        if (r109.hasNext() == false) goto L30;
        m r110 = r109.next();
        String r111 = r110.f258222b;
        r104.addAll(e(r100, r110, r102, 8));
        goto L28
    }

    public static DitoUpdateData h(DitoDataManager r100, List r101, m r102, Map r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "modelList");
        Intrinsics.checkNotNullParameter(r102, "oldTreeNode");
        Intrinsics.checkNotNullParameter(r103, "treeMap");
        Iterator r104 = CollectionsKt.withIndex(r101).iterator();
    L3:
        Object r105 = null;
        if (r104.hasNext() == false) goto L8;
        Object r106 = r104.next();
        if (((BaseDitoModel) ((IndexedValue) r106).getValue()).f258493b.a(r102) == false) goto L3;
    L9:
        IndexedValue r107 = (IndexedValue) r106;
        int r108 = -1;
        if (r107 == null) goto L12;
        int r109 = r107.getIndex();
    L13:
        if (r109 != (-1)) goto L16;
        return null;
    L16:
        if (r102.r() == false) goto L18;
        r108 = r109;
    L27:
        m.b(r103, r102);
        if (r109 > r108) goto L33;
        int r110 = r108;
    L30:
        ((BaseDitoModel) ListProtector.remove(r101, r110)).h();
        if (r110 == r109) goto L33;
        r110 = r110 - 1;
    L33:
        DitoUpdateData r111 = new DitoUpdateData(m.i(r102), "remove", r109, (r108 - r109) + 1);
        rq6.a.f538927a.a("dito_log", "updateData: " + r111);
        return r111;
    L18:
        Iterator r112 = CollectionsKt.withIndex(r101).iterator();
    L20:
        if (r112.hasNext() == false) goto L24;
        Object r113 = r112.next();
        if (((BaseDitoModel) ((IndexedValue) r113).getValue()).f258493b.a(r102) == false) goto L20;
        r105 = r113;
        goto L20
    L24:
        IndexedValue r114 = (IndexedValue) r105;
        if (r114 == null) goto L27;
        r108 = r114.getIndex();
        goto L27
    L12:
        r109 = -1;
        goto L13
    L8:
        r106 = null;
        goto L9
    }

    public final List<DitoUpdateData> i(Map<String, ? extends List<String>> r310, Map<String, DitoNode> r311, Map<String, m> r312, Map<String, CopyOnWriteArrayList<BaseDitoModel<?>>> r410) {
        r312 = r312;
        Map<String, CopyOnWriteArrayList<BaseDitoModel<?>>> r100 = r410;
        Intrinsics.checkNotNullParameter(r312, "treeMap");
        Intrinsics.checkNotNullParameter(r100, "containerModelMap");
        String r101 = "dito_log";
        rq6.a.f538927a.a("dito_log", "--------------------------------- 开始处理数据 ---------------------------------");
        ArrayList r110 = new ArrayList();
        if (r311 != null) goto L5;
        return r110;
    L5:
        LinkedHashSet r111 = new LinkedHashSet();
        String r102 = DitoNode.LOAD_MORE;
        String r103 = "refresh";
        String r104 = "remove";
        String r105 = "node_sub_type";
        String r106 = ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE;
        String r107 = "node_tag";
        if (r310 == null) goto L77;
        ArrayList r112 = new ArrayList();
        Iterator<Map.Entry<String, ? extends List<String>>> r113 = r310.entrySet().iterator();
    L9:
        if (r113.hasNext() == false) goto L14;
        Iterator<String> r114 = r113.next().getValue().iterator();
    L12:
        if (r114.hasNext() == false) goto L9;
        r111.add(r114.next());
        goto L12
    L14:
        Iterator<Map.Entry<String, ? extends List<String>>> r115 = r310.entrySet().iterator();
    L16:
        if (r115.hasNext() == false) goto L20;
        Map.Entry<String, ? extends List<String>> r116 = r115.next();
        if (r111.contains(r116.getKey()) == true) goto L16;
        r112.add(r116.getKey());
        r111.add(r116.getKey());
        goto L16
    L20:
        Iterator r117 = r112.iterator();
    L21:
        Map<String, DitoNode> r118 = r311;
    L23:
        if (r117.hasNext() == false) goto L77;
        String r119 = (String) r117.next();
        LinkedHashMap r120 = (LinkedHashMap) r312;
        String r121 = r105;
        m r108 = (m) r120.get(r119);
        if (r108 == null) goto L26;
        String r122 = r104;
        String r109 = m.i(r108);
        String r210 = r107;
        List<BaseDitoModel<?>> r123 = (CopyOnWriteArrayList) ((LinkedHashMap) r100).get(r109);
        if (r123 == null) goto L29;
        DitoNode r124 = r118.get(r119);
        if (r124 == null) goto L32;
        String r211 = r103;
        String r212 = r106;
        Iterator r213 = r117;
        m r125 = new m(r124, r108.f258222b, r108.f258223c, 8);
        String r126 = r124.getUpdateType();
        if (r126 == null) goto L75;
        switch(r126.hashCode()) {
            case -934610812: goto L61;
            case 94746189: goto L54;
            case 1085444827: goto L42;
            case 1845399899: goto L39;
            default: goto L75;
        };
    L42:
        String r214 = r102;
        String r127 = r122;
        String r128 = r210;
        String r129 = r212;
        String r130 = r101;
        String r131 = r121;
        if (r126.equals(r211) == false) goto L44;
        DitoUpdateData r132 = h(this, r123, r108, r120);
        if (r132 == null) goto L48;
        r110.add(r132);
    L48:
        m r133 = r108.f258223c;
        if (r133 == null) goto L53;
        List<m> r134 = r133.f258224d;
        if (r134 == null) goto L53;
        int r135 = r134.indexOf(r108);
        ListProtector.remove(r134, r135);
        ListProtector.add(r134, r135, r125);
    L53:
        r110.add(j(r123, r125, r120, r310, r311));
        r103 = r211;
    L73:
        Map<String, DitoNode> r136 = r311;
    L74:
        r106 = r129;
        r105 = r131;
        r107 = r128;
        r104 = r127;
        r101 = r130;
        r118 = r136;
        r117 = r213;
        r102 = r214;
        r100 = r410;
        goto L23
    L44:
        r103 = r211;
    L76:
        j.k(this.f257939a, DATA_CONTAINER_UPDATE_TYPE_ERROR.f258457a, "错误的updateType" + r124.getUpdateType(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r129, r109), TuplesKt.to(r128, r108.f258222b), TuplesKt.to(r131, r124.getSubType())}), null, null, 24);
        r106 = r129;
        r105 = r131;
        r107 = r128;
        r104 = r127;
        r101 = r130;
        r117 = r213;
        r102 = r214;
        r100 = r410;
        goto L21
    L54:
        r214 = r102;
        r127 = r122;
        r128 = r210;
        r103 = r211;
        r129 = r212;
        r130 = r101;
        r131 = r121;
        if (r126.equals("clear") == false) goto L76;
        DitoUpdateData r137 = h(this, r123, r108, r120);
        if (r137 == null) goto L60;
        r110.add(r137);
    L60:
        r108.f258224d.clear();
        goto L73
    L61:
        r214 = r102;
        r127 = r122;
        r128 = r210;
        r103 = r211;
        r129 = r212;
        r130 = r101;
        r131 = r121;
        if (r126.equals(r127) == false) goto L76;
        DitoUpdateData r138 = h(this, r123, r108, r120);
        if (r138 == null) goto L67;
        r110.add(r138);
    L67:
        m r139 = r108.f258223c;
        if (r139 == null) goto L72;
        List<m> r140 = r139.f258224d;
        if (r140 == null) goto L72;
        r140.remove(r108);
    L72:
        r120.remove(r108.f258222b);
        goto L73
    L39:
        if (r126.equals(r102) == false) goto L75;
        r108.f258221a = r124;
        r128 = r210;
        r136 = r118;
        r127 = r122;
        r130 = r101;
        r131 = r121;
        r214 = r102;
        r110.add(j(r123, r108, r120, r310, r311));
        r129 = r212;
        r103 = r211;
    L75:
        r214 = r102;
        r127 = r122;
        r128 = r210;
        r103 = r211;
        r129 = r212;
        r130 = r101;
        r131 = r121;
    L32:
        r104 = r122;
        r105 = r121;
        r107 = r210;
        goto L23
    L29:
        j.k(this.f257939a, DATA_CONTAINER_UPDATE_CONTAINER_ERROR.f258455a, r109 + " 不是内置容器key", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r106, r109)}), null, null, 24);
        goto L32
    L26:
        r122 = r104;
        j.k(this.f257939a, DATA_CONTAINER_UPDATE_TREE_NODE_NULL.f258456a, "在原组件树中未找到" + r119 + "对应的组件存在", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r107, r119)}), null, null, 24);
        r210 = r107;
    L77:
        String r141 = r107;
        String r142 = r106;
        String r143 = r104;
        String r215 = r102;
        String r144 = r101;
        String r145 = r105;
        ArrayList r146 = new ArrayList();
        Iterator<Map.Entry<String, DitoNode>> r147 = r311.entrySet().iterator();
    L79:
        if (r147.hasNext() == false) goto L201;
        Map.Entry<String, DitoNode> r148 = r147.next();
        if (r111.contains(r148.getKey()) == true) goto L82;
        if (r148.getValue().isComponentNode() == false) goto L86;
        Iterator<Map.Entry<String, DitoNode>> r313 = r147;
        LinkedHashMap r149 = (LinkedHashMap) r312;
        m r150 = (m) r149.get(r148.getKey());
        if (r150 == null) goto L89;
        DitoNode r151 = r148.getValue();
        if (Intrinsics.areEqual(r151.getUpdateType(), "update") == false) goto L103;
        Intrinsics.checkNotNullParameter(r151, "<this>");
        com.bytedance.locallife.dito.data.c r152 = r151.getConfig();
        if (r152 == null) goto L97;
        String r216 = r142;
        if (r152.d() != true) goto L98;
        boolean r153 = true;
    L99:
        if (r153 == false) goto L101;
    L104:
        boolean r154 = false;
    L105:
        if (r154 == false) goto L115;
        c r155 = (c) this.f257941c.getValue();
        if (r155 == null) goto L109;
        d r156 = r155.a(r151);
    L110:
        if (r156 == null) goto L115;
        c r157 = (c) this.f257941c.getValue();
        if (r157 == null) goto L115;
        r157.b(r150.f258221a, r151, r156);
        goto L115
    L109:
        r156 = null;
    L115:
        r150.f258221a = r151;
        String r158 = m.i(r150);
        if (r158 == null) goto L117;
        String r159 = r216;
        CopyOnWriteArrayList r160 = (CopyOnWriteArrayList) ((LinkedHashMap) r410).get(r158);
        if (r160 == null) goto L120;
        String r161 = r148.getValue().getUpdateType();
        if (r161 == null) goto L189;
        ArrayList r217 = r110;
        int r162 = r161.hashCode();
        Object r218 = "node_type";
        String r219 = r145;
        if (r162 != (-934610812)) goto L126;
        String r163 = r144;
        String r164 = r215;
        if (r161.equals(r143) == false) goto L191;
        Iterator r165 = CollectionsKt.withIndex(r160).iterator();
    L173:
        if (r165.hasNext() == false) goto L177;
        Object r166 = r165.next();
        if (Intrinsics.areEqual(((BaseDitoModel) ((IndexedValue) r166).getValue()).f258493b, r150) == false) goto L173;
        Object r167 = r166;
    L178:
        IndexedValue r168 = (IndexedValue) r167;
        if (r168 == null) goto L181;
        int r169 = r168.getIndex();
    L182:
        r160.remove(r169);
        r149.remove(r150.f258222b);
        m r170 = r150.f258223c;
        if (r170 == null) goto L187;
        List<m> r171 = r170.f258224d;
        if (r171 == null) goto L187;
        r171.remove(r150);
    L187:
        DitoUpdateData r172 = new DitoUpdateData(r158, r143, r169, 1);
        rq6.a.f538927a.a(r163, "叶子节点更新信息: " + r172);
        r146.add(r172);
    L188:
        r219 = r219;
    L200:
        r147 = r313;
        r145 = r219;
        r142 = r159;
        r215 = r164;
        r111 = r111;
        r110 = r217;
        r144 = r163;
        goto L79
    L181:
        r169 = -1;
        goto L182
    L177:
        r167 = null;
    L191:
        DitoViewModel r173 = this.f257939a;
        DATA_NODE_UPDATE_TYPE_ERROR r220 = DATA_NODE_UPDATE_TYPE_ERROR.f258461a;
        String r221 = "错误的节点updateType" + r148.getValue().getUpdateType();
        Pair[] r174 = new Pair[4];
        r174[0] = TuplesKt.to(r159, r158);
        r174[1] = TuplesKt.to(r141, r150.f258222b);
        DitoNode r175 = r150.f258221a;
        if (r175 == null) goto L194;
        String r176 = r175.getSubType();
    L195:
        r174[2] = TuplesKt.to(r219, r176);
        DitoNode r177 = r150.f258221a;
        if (r177 == null) goto L198;
        String r178 = r177.getType();
    L199:
        r174[3] = TuplesKt.to(r218, r178);
        j.k(r173, r220, r221, MapsKt.mutableMapOf(r174), null, null, 24);
        goto L200
    L198:
        r178 = null;
        goto L199
    L194:
        r176 = null;
        goto L195
    L126:
        if (r162 != (-838846263)) goto L128;
        r163 = r144;
        r164 = r215;
        if (r161.equals("update") == false) goto L191;
        Iterator r179 = CollectionsKt.withIndex(r160).iterator();
    L145:
        if (r179.hasNext() == false) goto L150;
        Object r180 = r179.next();
        if (Intrinsics.areEqual(((BaseDitoModel) ((IndexedValue) r180).getValue()).f258493b, r150) == false) goto L145;
    L151:
        IndexedValue r181 = (IndexedValue) r180;
        if (r181 == null) goto L154;
        int r182 = r181.getIndex();
    L155:
        if (r182 < 0) goto L188;
        if (r182 >= r160.size()) goto L188;
        BaseDitoModel r183 = (BaseDitoModel) r160.remove(r182);
        if (r183 == null) goto L162;
        r183.h();
    L162:
        m r184 = (m) r149.get(r148.getKey());
        if (r184 != null) goto L165;
        int r185 = 1;
        BaseDitoModel<?> r186 = null;
    L166:
        if (r186 == null) goto L188;
        r160.add(r182, r186);
        DitoUpdateData r187 = new DitoUpdateData(r158, "update", r182, r185);
        rq6.a.f538927a.a(r163, "叶子节点更新信息: " + r187);
        r146.add(r187);
        goto L188
    L165:
        r185 = 1;
        r186 = d(r184, true);
        goto L166
    L154:
        r182 = -1;
        goto L155
    L150:
        r180 = null;
        goto L151
    L128:
        if (r162 == 1085444827) goto L131;
    L190:
        r163 = r144;
        r164 = r215;
        goto L191
    L131:
        if (r161.equals(r103) == false) goto L190;
        Ref.ObjectRef r188 = new Ref.ObjectRef();
        com.bytedance.locallife.dito.a.a(null, new DitoDataManager$leftFirstAvailableModel$1(r188, this, r150, r160));
        int r189 = r160.indexOf((BaseDitoModel) r188.element) + 1;
        m r190 = (m) r149.get(r150.f258222b);
        if (r190 != null) goto L136;
        BaseDitoModel<?> r191 = null;
    L137:
        if (r191 != null) goto L139;
        r163 = r144;
        r164 = r215;
        goto L188
    L139:
        r160.add(r189, r191);
        String r192 = r215;
        DitoUpdateData r193 = new DitoUpdateData(r158, r192, r189, 1);
        String r194 = r144;
        rq6.a.f538927a.a(r194, "叶子节点增加信息: " + r193);
        r146.add(r193);
        r164 = r192;
        r163 = r194;
        goto L188
    L136:
        r191 = d(r190, true);
        goto L137
    L189:
        r218 = "node_type";
        r219 = r145;
        r217 = r110;
    L120:
        r147 = r313;
        r142 = r159;
        r111 = r111;
        goto L79
    L117:
        r159 = r216;
        goto L120
    L101:
        if (this.f257942d == false) goto L104;
        r154 = true;
    L98:
        r153 = false;
        goto L99
    L97:
        r216 = r142;
        goto L98
    L103:
        r216 = r142;
        goto L104
    L89:
        j.k(this.f257939a, DATA_NODE_UPDATE_TREE_NODE_NULL.f258460a, "未能在原组件树中找到" + r148.getKey() + "对应的节点", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r141, r148.getKey()), TuplesKt.to(r145, r148.getValue().getSubType())}), null, null, 24);
    L83:
        r111 = r111;
        r159 = r142;
        goto L120
    L86:
        DitoViewModel r195 = this.f257939a;
        DATA_NODE_NOT_COMPONENT_TYPE r222 = DATA_NODE_NOT_COMPONENT_TYPE.f258459a;
        StringBuilder r196 = new StringBuilder("节点");
        r196.append(r148.getKey());
        r196.append("非组件节点走到了组件更新流程, nodeSet: ");
        r196.append(GsonProtectorUtils.toJson(this.f257939a.f258047m, r111));
        r196.append(", updateNodes:");
        r313 = r147;
        r196.append(GsonProtectorUtils.toJson(this.f257939a.f258047m, r311.keySet()));
        j.k(r195, r222, r196.toString(), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r141, r148.getKey()), TuplesKt.to(r145, r148.getValue().getSubType()), TuplesKt.to("node_type", r148.getValue().getType())}), null, null, 24);
        goto L83
    L82:
        r313 = r147;
        goto L83
    L201:
        ArrayList r197 = r110;
        r197.addAll(r146);
        rq6.a.f538927a.a(r144, "--------------------------------- 处理数据结束 ---------------------------------");
        return r197;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DitoUpdateData j(List<BaseDitoModel<?>> r100, m r101, Map<String, m> r102, Map<String, ? extends List<String>> r103, Map<String, DitoNode> r110) {
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        m r105 = null;
        com.bytedance.locallife.dito.a.a(null, new DitoDataManager$leftFirstAvailableModel$1(r104, this, r101, r100));
        BaseDitoModel r106 = (BaseDitoModel) r104.element;
        int r107 = CollectionsKt.indexOf(r100, r106) + 1;
        int r108 = m.f258220f;
        r102.putAll(m.a.a(r101, r103, r110, null));
        if (r106 == null) goto L5;
        r105 = r106.f258493b;
    L5:
        List r109 = f(r101, true);
        ArrayList r111 = new ArrayList();
        ArrayList r112 = (ArrayList) r109;
        if (r112.isEmpty() == true) goto L19;
        if (r105 == null) goto L12;
        int r113 = r112.indexOf(r105);
        if (r113 < 0) goto L12;
        int r114 = r113 + 1;
    L13:
        int r115 = r112.size();
    L14:
        if (r114 >= r115) goto L19;
        BaseDitoModel<?> r116 = d((m) ListProtector.get(r109, r114), true);
        if (r116 == null) goto L18;
        r111.add(r116);
    L18:
        r114 = r114 + 1;
    L12:
        r114 = 0;
    L19:
        r100.addAll(r107, r111);
        DitoUpdateData r117 = new DitoUpdateData(m.i(r101), DitoNode.LOAD_MORE, r107, r111.size());
        rq6.a.f538927a.a("dito_log", "列表加载更多信息: " + r117);
        return r117;
    }
}
