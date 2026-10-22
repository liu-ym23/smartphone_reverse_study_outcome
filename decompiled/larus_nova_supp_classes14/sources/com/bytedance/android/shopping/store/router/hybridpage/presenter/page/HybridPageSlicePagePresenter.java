package com.bytedance.android.shopping.store.router.hybridpage.presenter.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridDataTransformer;
import com.bytedance.android.shopping.store.hybridproduct.extension.p;
import com.bytedance.android.shopping.store.router.hybridpage.event.PageCardEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.event.SliceEventManager;
import com.bytedance.android.shopping.store.router.hybridpage.holder.HybridPageSliceBaseProductCardHolder;
import com.bytedance.android.shopping.store.router.hybridpage.hybridList.HybridHolderFactory;
import com.bytedance.android.shopping.store.router.hybridpage.slice.HybridPageSlcTemplateManager;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.InitializeErrorType;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class HybridPageSlicePagePresenter extends QFragmentPresenter {
    public r f;
    public final Lazy g;
    public final Map<String, Object> h;
    public final Map<String, Object> i;
    public final a j;

    public static final class a implements com.bytedance.android.shopping.store.router.hybridpage.event.b {
        public final /* synthetic */ HybridPageSlicePagePresenter a;

        public a(HybridPageSlicePagePresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.router.hybridpage.event.b
        public final void a(Map<String, ? extends Object> r2) {
            this.a.d0(r2);
        }

        @Override // com.bytedance.android.shopping.store.router.hybridpage.event.b
        public final ECHybridListDTO b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "hybridListId");
            return this.a.i0().getHybridListDTO();
        }
    }

    public abstract wj3.a e0();

    public abstract String h0();

    public final HybridPageViewModel i0() {
        return (HybridPageViewModel) this.g.getValue();
    }

    public final void c0() {
        r r0 = this.f;
        if (r0 == null) goto L7;
        SlcTemplateContext r1 = r0.b;
        if (r1 == null) goto L7;
        r1.u(h0());
    L7:
        ReentrantReadWriteLock r2 = SliceEventManager.a;
        String r3 = i0().getSceneId();
        a r4 = this.j;
        Intrinsics.checkNotNullParameter(r3, "sceneId");
        Intrinsics.checkNotNullParameter(r4, "listener");
        ReentrantReadWriteLock r5 = SliceEventManager.a;
        ReentrantReadWriteLock.ReadLock r6 = r5.readLock();
        int r7 = 0;
        if (r5.getWriteHoldCount() != 0) goto L10;
        int r8 = r5.getReadHoldCount();
    L11:
        int r9 = 0;
    L12:
        if (r9 >= r8) goto L14;
        r6.unlock();
        r9 = r9 + 1;
        goto L12
    L14:
        ReentrantReadWriteLock.WriteLock r10 = r5.writeLock();
        r10.lock();
        Lazy r11 = SliceEventManager.b;     // Catch: Throwable -> L21
        Set r12 = (Set) ((Map) r11.getValue()).get(r3);     // Catch: Throwable -> L21
        if (r12 == null) goto L23;
        r12.remove(r4);     // Catch: Throwable -> L21
        if (r12.isEmpty() == false) goto L23;
        ((Map) r11.getValue()).remove(r3);     // Catch: Throwable -> L21
    L23:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L24:
        if (r7 >= r8) goto L26;
        r6.lock();
        r7 = r7 + 1;
        goto L24
    L26:
        r10.unlock();
        return;
    L21:
        th = move-exception;
    L28:
        if (r7 >= r8) goto L30;
        r6.lock();
        r7 = r7 + 1;
        goto L28
    L30:
        r10.unlock();
        throw th;
    L10:
        r8 = 0;
        goto L11
    }

    public HybridPageSlicePagePresenter(final Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.g = LazyKt.lazy(new HybridPageSlicePagePresenter$viewModel$2(this, r2));
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
        this.j = new a(this);
    }

    public void b0(QModel r15) {
        com.bytedance.android.shopping.store.router.hybridpage.slice.b r16 = i0().getSlcCardFactory();
        String r0 = h0();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r0, "name");
        Intrinsics.checkNotNullParameter("", "version");
        int r1 = 0;
        SliceTemplate r3 = HybridPageSlcTemplateManager.a(r0, 0);
        if (r3 == null) goto L5;
        String r4 = r3.getUrl();
    L7:
        if (r4 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        dm.a.a("HybridPageSlcProductCardFactory").b("createHybridPageViewInfo templateConfig is null,name:".concat(r0), null);
        r r17 = null;
    L16:
        this.f = r17;
        ReentrantReadWriteLock r18 = PageCardEventManager.a;
        String r19 = i0().getSceneId();
        if (this.f == null) goto L19;
        boolean r2 = true;
    L20:
        PageCardEventManager.i(r19, r2);
        if (this.f != null) goto L23;
        i0().getLoadStatus().g(LoadStatus.InitializeError);
        HybridPageViewModel r110 = i0();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("slice_template_name", h0());
        r5.put("initialize_error_type", InitializeErrorType.SLICED_ERROR.getType());
        r5.put("error_msg", "createSearchSlicePageViewInfo return null");
        Unit r7 = Unit.INSTANCE;
        r110.reportInitializeError(r5);
        PageCardEventManager.j(i0().getSceneId());
    L23:
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-1, -2);
        r r8 = this.f;
        if (r8 == null) goto L33;
        View r9 = r8.c;
        if (r9 == null) goto L33;
        View r10 = a0();
        if ((r10 instanceof ViewGroup) == true) goto L30;
        r10 = null;
    L30:
        ViewGroup r11 = (ViewGroup) r10;
        if (r11 == null) goto L33;
        r11.addView(r9, r111);
    L33:
        r r112 = this.f;
        if (r112 == null) goto L38;
        SlcTemplateContext r113 = r112.b;
        if (r113 == null) goto L38;
        r113.s(h0(), e0());
    L38:
        d0(new LinkedHashMap());
        int r114 = com.bytedance.android.shopping.store.router.hybridpage.hybridList.b.a;
        Fragment r115 = ((QFragmentPresenter) this).e;
        km.b r12 = new km.b();
        HybridPageViewModel r13 = i0();
        String r14 = i0().getSceneId();
        Intrinsics.checkNotNullParameter(r115, "fragment");
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r13, "viewModel");
        Intrinsics.checkNotNullParameter(r14, "sceneId");
        Map<Integer, Function4<Fragment, ViewGroup, km.b, HybridPageViewModel, HybridPageSliceBaseProductCardHolder>> r20 = HybridHolderFactory.a;
        ArrayList r21 = new ArrayList();
        Iterator<Map.Entry<Integer, Function4<Fragment, ViewGroup, km.b, HybridPageViewModel, HybridPageSliceBaseProductCardHolder>>> r22 = r20.entrySet().iterator();
    L40:
        if (r22.hasNext() == false) goto L47;
        Map.Entry<Integer, Function4<Fragment, ViewGroup, km.b, HybridPageViewModel, HybridPageSliceBaseProductCardHolder>> r23 = r22.next();
        int r116 = r23.getKey().intValue();
        Function4<Fragment, ViewGroup, km.b, HybridPageViewModel, HybridPageSliceBaseProductCardHolder> r24 = r23.getValue();
        p r117 = ShopHybridDataTransformer.a.get(Integer.valueOf(r116));
        if (r117 != null) goto L44;
        com.bytedance.android.shopping.store.router.hybridpage.hybridList.b.a r118 = null;
    L45:
        if (r118 == null) goto L40;
        r21.add(r118);
        goto L40
    L44:
        r118 = new com.bytedance.android.shopping.store.router.hybridpage.hybridList.b.a(r116, r117.a, r117.b, r24);
        goto L45
    L47:
        Iterator r25 = r21.iterator();
    L49:
        if (r25.hasNext() == false) goto L63;
        com.bytedance.android.shopping.store.router.hybridpage.hybridList.b.a r26 = (com.bytedance.android.shopping.store.router.hybridpage.hybridList.b.a) r25.next();
        com.bytedance.android.shopping.store.router.hybridpage.hybridList.c r27 = new com.bytedance.android.shopping.store.router.hybridpage.hybridList.c(r26.d, r115, r12, r13);
        Function2<DTO, String, VO> r28 = r26.c;
        if (r28 == 0) goto L62;
        com.bytedance.android.shopping.store.router.hybridpage.hybridList.d r119 = new com.bytedance.android.shopping.store.router.hybridpage.hybridList.d(r26.b, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r28, 2));
        int r29 = r26.getType();
        List r30 = CollectionsKt.listOf(new Boolean[]{Boolean.TRUE, Boolean.FALSE});
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
        Iterator r31 = r30.iterator();
    L54:
        if (r31.hasNext() == false) goto L56;
        ((Boolean) r31.next()).booleanValue();
        r120.add(Integer.valueOf(r29));
        goto L54
    L56:
        LinkedHashMap r32 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r120, 10)), 16));
        Iterator r121 = r120.iterator();
    L58:
        if (r121.hasNext() == false) goto L60;
        Object r122 = r121.next();
        ((Number) r122).intValue();
        r32.put(r122, r27);
        goto L58
    L60:
        ECHybridListEngine.Companion r33 = ECHybridListEngine.x;
        Pair r34 = TuplesKt.to(Integer.valueOf(r29), r119);
        r33.getClass();
        ECHybridListEngine.Companion.d(r14, r115, r34, r32);
        goto L49
    L62:
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Any, kotlin.String?) -> com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridItemVO");
    L63:
        ReentrantReadWriteLock r123 = SliceEventManager.a;
        String r124 = i0().getSceneId();
        a r35 = this.j;
        Intrinsics.checkNotNullParameter(r124, "sceneId");
        Intrinsics.checkNotNullParameter(r35, "listener");
        ReentrantReadWriteLock r36 = SliceEventManager.a;
        ReentrantReadWriteLock.ReadLock r37 = r36.readLock();
        if (r36.getWriteHoldCount() != 0) goto L66;
        int r38 = r36.getReadHoldCount();
    L67:
        int r39 = 0;
    L68:
        if (r39 >= r38) goto L70;
        r37.unlock();
        r39 = r39 + 1;
        goto L68
    L70:
        ReentrantReadWriteLock.WriteLock r40 = r36.writeLock();
        r40.lock();
        Map r41 = (Map) SliceEventManager.b.getValue();     // Catch: Throwable -> L79
        Object r42 = r41.get(r124);     // Catch: Throwable -> L79
        if (r42 != null) goto L74;
        r42 = new LinkedHashSet();     // Catch: Throwable -> L79
        r41.put(r124, r42);     // Catch: Throwable -> L79
    L74:
        ((Set) r42).add(r35);     // Catch: Throwable -> L79
    L75:
        if (r1 >= r38) goto L77;
        r37.lock();
        r1 = r1 + 1;
        goto L75
    L77:
        r40.unlock();
        return;
    L79:
        th = move-exception;
    L80:
        if (r1 >= r38) goto L82;
        r37.lock();
        r1 = r1 + 1;
        goto L80
    L82:
        r40.unlock();
        throw th;
    L66:
        r38 = 0;
        goto L67
    L19:
        r2 = false;
        goto L20
    L15:
        r17 = r16.h(r4, r0, "");
        goto L16
    L9:
        if (r4.length() == 0) goto L12;
        r6 = false;
        goto L13
    L5:
        r4 = null;
        goto L7
    }

    public final void d0(Map<String, ? extends Object> r7) {
        Object r0 = null;
        if (r7 == null) goto L5;
        Object r1 = r7.get("merge_origin");
    L7:
        if ((r1 instanceof Boolean) == true) goto L9;
        r1 = null;
    L9:
        Boolean r2 = (Boolean) r1;
        if (r2 == null) goto L12;
        boolean r3 = r2.booleanValue();
    L13:
        LinkedHashMap r4 = new LinkedHashMap();
        LinkedHashMap r5 = new LinkedHashMap();
        if (r3 == false) goto L37;
        r4.putAll(this.h);
        if (r7 == null) goto L18;
        Object r6 = r7.get("item_states");
    L20:
        if ((r6 instanceof Map) == true) goto L22;
        r6 = null;
    L22:
        Map r8 = (Map) r6;
        if (r8 != null) goto L25;
        r8 = MapsKt.emptyMap();
    L25:
        r4.putAll(r8);
        r5.putAll(this.i);
        if (r7 == null) goto L28;
        Object r9 = r7.get("data_source");
    L30:
        if ((r9 instanceof Map) == false) goto L33;
        r0 = r9;
    L33:
        Map r10 = (Map) r0;
        if (r10 != null) goto L36;
        r10 = MapsKt.emptyMap();
    L36:
        r5.putAll(r10);
    L58:
        ((LinkedHashMap) this.h).clear();
        this.h.putAll(r4);
        ((LinkedHashMap) this.i).clear();
        this.i.putAll(r5);
        LinkedHashMap r11 = new LinkedHashMap();
        r11.putAll(r5);
        r11.put("slice_item_states", r4);
        Unit r12 = Unit.INSTANCE;
        Map r13 = MapsKt.mapOf(TuplesKt.to("data", r11));
        r r14 = this.f;
        if (r14 == null) goto L62;
        r14.a(r13, h0());
        return;
    L62:
        return;
    L28:
        r9 = null;
        goto L30
    L18:
        r6 = null;
        goto L20
    L37:
        if (r7 == null) goto L39;
        Object r15 = r7.get("item_states");
    L41:
        if ((r15 instanceof Map) == true) goto L43;
        r15 = null;
    L43:
        Map r16 = (Map) r15;
        if (r16 != null) goto L46;
        r16 = MapsKt.emptyMap();
    L46:
        r4.putAll(r16);
        if (r7 == null) goto L49;
        Object r17 = r7.get("data_source");
    L51:
        if ((r17 instanceof Map) == false) goto L54;
        r0 = r17;
    L54:
        Map r18 = (Map) r0;
        if (r18 != null) goto L57;
        r18 = MapsKt.emptyMap();
    L57:
        r5.putAll(r18);
        goto L58
    L49:
        r17 = null;
        goto L51
    L39:
        r15 = null;
        goto L41
    L12:
        r3 = true;
        goto L13
    L5:
        r1 = null;
        goto L7
    }
}
