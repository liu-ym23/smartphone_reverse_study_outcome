package com.bytedance.android.shopping.store.hybridproduct;

import android.graphics.drawable.GradientDrawable;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.entity.dto.InteractiveControl;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopProductListBffResponseDTO;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ECShopProductListBffResponseDTO c;

    public w(ECShopHybridProductListPresenter r1, String r2, ECShopProductListBffResponseDTO r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r18) {
        com.bytedance.android.ec.hybrid.list.entity.k r0 = (com.bytedance.android.ec.hybrid.list.entity.k) r18;
        ECShopHybridProductListPresenter r3 = this.a;
        String r4 = this.b;
        int r5 = ECShopHybridProductListPresenter.O;
        r3.getClass();
        boolean r6 = true;
        if ((!Intrinsics.areEqual(r4, "0")) == true) goto L9;
        ECHybridListContainer r7 = r3.m;
        if (r7 == null) goto L9;
        GradientDrawable r8 = ECShopHybridProductListPresenter.a.a(12);
        Intrinsics.checkNotNullParameter(r7, "$this$setBackgroundCompat");
        r7.setBackground(r8);
    L9:
        Object r9 = null;
        if (this.c.isDynamicInsert() == false) goto L127;
        ECShopHybridProductListPresenter r13 = this.a;
        ECShopProductListBffResponseDTO r14 = this.c;
        r13.getClass();
        ECHybridListDTO r1 = r14.getHybridList();
        if (r1 == null) goto L251;
        List r2 = r1.getSections();
        if (r2 == null) goto L251;
        Iterator<T> r10 = r2.iterator();
    L17:
        if (r10.hasNext() == false) goto L21;
        T r11 = r10.next();
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r11).getSectionId(), "__PRODUCTS_SECTION__") == false) goto L17;
    L22:
        ECHybridListSectionDTO r12 = (ECHybridListSectionDTO) r11;
        if (r12 == null) goto L251;
        ArrayList r15 = r12.getItems();
        if (r15 != null) goto L27;
    L30:
        boolean r16 = true;
    L31:
        if (r16 == true) goto L251;
        ECHybridListItemDTO r17 = (ECHybridListItemDTO) CollectionsKt.firstOrNull(r15);
        if (r17 == null) goto L251;
        ECHybridListEngine r19 = r13.n;
        if (r19 == null) goto L251;
        com.bytedance.android.ec.hybrid.list.entity.k r20 = r19.c.g;
        if (r20 == null) goto L251;
        ArrayList r21 = r20.c;
        if (r21 == null) goto L251;
        Iterator<T> r22 = r21.iterator();
    L44:
        if (r22.hasNext() == false) goto L48;
        T r23 = r22.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r23).a, "__PRODUCTS_SECTION__") == false) goto L44;
    L49:
        com.bytedance.android.ec.hybrid.list.entity.i r110 = (com.bytedance.android.ec.hybrid.list.entity.i) r23;
        if (r110 == null) goto L251;
        ECHybridListDTO.a r24 = ECHybridListDTO.Companion;
        ECHybridListDTO r25 = r14.getHybridList();
        Intrinsics.checkNotNull(r25);
        Map<String, com.bytedance.android.ec.hybrid.list.entity.k.a> r26 = ECHybridListDTO.a.e(r24, r25).b;
        if (r26 != null) goto L56;
        r26 = MapsKt.emptyMap();
    L56:
        Map<String, com.bytedance.android.ec.hybrid.list.entity.k.a> r111 = r26;
        ECNAMallCardExtra r27 = r17.getExtra();
        String r28 = "";
        if (r27 == null) goto L62;
        String r29 = r27.getProductIds();
        if (r29 == null) goto L62;
        String r112 = r29;
    L253:
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L71
        Gson r31 = new Gson();     // Catch: Throwable -> L71
        ECNAMallCardExtra r32 = r17.getExtra();     // Catch: Throwable -> L71
        if (r32 == null) goto L69;
        String r33 = r32.getInteractiveControl();     // Catch: Throwable -> L71
        if (r33 == null) goto L69;
        r28 = r33;
    L69:
        Object r34 = Result.constructor-impl((InteractiveControl) r31.fromJson(r28, InteractiveControl.class));     // Catch: Throwable -> L71
    L74:
        if (Result.isFailure-impl(r34) == true) goto L77;
        r9 = r34;
    L77:
        InteractiveControl r35 = (InteractiveControl) r9;
        if (r35 == null) goto L251;
        List r36 = r35.getRetreatItems();
        if (r36 == null) goto L124;
        if ((!r36.isEmpty()) != true) goto L124;
        int r37 = r13.j0(r110);
        ArrayList r38 = r110.i;
        if (r38 == null) goto L93;
        Iterator r39 = r38.iterator();
        int r40 = 0;
    L88:
        if (r39.hasNext() == false) goto L93;
        if (Intrinsics.areEqual(((ECHybridListItemVO) r39.next()).d, r13.m0().getCurrentProductId()) == true) goto L94;
        r40 = r40 + 1;
    L94:
        dm.a.a("product_list_presenter").i("checkRetreat , clickIndex=" + r40 + ", insetIndex" + r37 + ", ");
        if (r37 >= 0) goto L97;
        dm.a.a("product_list_presenter").i("checkRetreat failed, insertIndex is invalid");
    L119:
        r6 = false;
    L121:
        if (r6 == true) goto L124;
        r13.m0().getAllIdRecords().add(r112);
        dm.a.a("product_list_presenter").i("insert card failed, reason: checkRetreat failed");
        goto L251
    L97:
        ArrayList r41 = r110.i;
        if (r41 == null) goto L119;
        Integer r42 = r35.getRetreatDistance();
        if (r42 == null) goto L103;
        int r43 = r42.intValue();
    L104:
        List r44 = r35.getRetreatItems();
        if (r43 <= 0) goto L121;
        int r113 = RangesKt.coerceAtLeast(r37 - r43, 0);
        int r45 = r37 + r43;
        ArrayList r46 = r110.i;
        if (r46 == null) goto L109;
        int r47 = CollectionsKt.getLastIndex(r46);
    L110:
        int r48 = RangesKt.coerceAtMost(r45, r47);
    L111:
        if (r113 >= r48) goto L121;
        if (r44 != null) goto L114;
    L115:
        if (r44 == null) goto L120;
        if (CollectionsKt.contains(r44, ((ECHybridListItemVO) ListProtector.get(r41, r113)).b) != true) goto L120;
    L118:
        dm.a.a("product_list_presenter").i("checkRetreat failed, conflict index is " + r113);
    L120:
        r113 = r113 + 1;
        goto L111
    L114:
        if (CollectionsKt.contains(r44, ((ECHybridListItemVO) ListProtector.get(r41, r113)).c) == true) goto L118;
    L109:
        r47 = 0;
        goto L110
    L103:
        r43 = 0;
    L93:
        r40 = -1;
    L124:
        if (r35.getClientAiDecideShow() == false) goto L126;
        b2.a(new ECShopHybridProductListPresenter$handleDynamicInsert$$inlined$apply$lambda$1(r35, r15, r110, r111, r112, r13, r14));
        goto L251
    L126:
        r13.n0(r35, r15, r110, r111);
    L71:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
    L62:
        r112 = "";
        goto L253
    L48:
        r23 = null;
        goto L49
    L27:
        if (r15.isEmpty() == true) goto L30;
        r16 = false;
        goto L31
    L21:
        r11 = null;
    L251:
        this.a.m0().getLoadStatus().g(LoadStatus.InitializeSuccess);
        this.a.a0().post(v.a);
        return;
    L127:
        Runnable r50 = this.a.I;
        if (r50 == null) goto L130;
        r50.run();
    L130:
        ECShopHybridProductListPresenter r51 = this.a;
        r51.I = null;
        if (r51.s == false) goto L141;
        ECHybridListEngine r52 = r51.n;
        if (r52 == null) goto L139;
        ECHybridRecyclerView r53 = r52.b;
        if (r53 == null) goto L139;
        VirtualLayoutManager r54 = r53.getLayoutManager();
        if (r54 == null) goto L139;
        boolean r55 = false;
        r54.scrollToPositionWithOffset(0, 0);
    L140:
        this.a.s = r55;
    L139:
        r55 = false;
    L141:
        ArrayList r56 = r0.c;
        if (r56 == null) goto L284;
        ArrayList r57 = new ArrayList();
        Iterator<T> r58 = r56.iterator();
    L145:
        if (r58.hasNext() == false) goto L156;
        T r59 = r58.next();
        com.bytedance.android.ec.hybrid.list.entity.i r60 = (com.bytedance.android.ec.hybrid.list.entity.i) r59;
        if (CollectionsKt.contains(this.a.y, r60.a) == true) goto L153;
        ArrayList r61 = r60.i;
        if (r61 == null) goto L153;
        if ((!r61.isEmpty()) != true) goto L153;
        boolean r62 = true;
    L154:
        if (r62 == false) goto L145;
        r57.add(r59);
    L153:
        r62 = false;
        goto L154
    L156:
        ArrayList r63 = new ArrayList(r57);
        r0.c = r63;
        if (r63.isEmpty() == true) goto L285;
        ArrayList r64 = r0.c;     // Catch: Exception -> L173
        if (r64 == null) goto L169;
        Iterator<T> r65 = r64.iterator();     // Catch: Exception -> L173
    L163:
        if (r65.hasNext() == false) goto L169;
        com.bytedance.android.ec.hybrid.list.entity.i r66 = (com.bytedance.android.ec.hybrid.list.entity.i) r65.next();     // Catch: Exception -> L173
        dm.a.b r67 = dm.a.a("查询数据");     // Catch: Exception -> L173
        StringBuilder r68 = new StringBuilder();     // Catch: Exception -> L173
        r68.append("renderResultAsync:");     // Catch: Exception -> L173
        r68.append(r66.a);     // Catch: Exception -> L173
        r68.append(",size:");     // Catch: Exception -> L173
        ArrayList r69 = r66.i;     // Catch: Exception -> L173
        if (r69 == null) goto L167;
        Integer r70 = Integer.valueOf(r69.size());     // Catch: Exception -> L173
    L168:
        r68.append(r70);     // Catch: Exception -> L173
        r67.a(r68.toString());     // Catch: Exception -> L173
        goto L163
    L167:
        r70 = null;
    L169:
        ECHybridListEngine r71 = this.a.n;     // Catch: Exception -> L173
        if (r71 == null) goto L175;
        r71.c(r0);     // Catch: Exception -> L173
    L175:
        ECShopHybridProductListPresenter r72 = this.a;
        Intrinsics.checkNotNullParameter(r72, "$this$logCommon");
        ECHybridListEngine r73 = r72.n;
        if (r73 == null) goto L251;
        dm.a.b r74 = dm.a.a("LGHP");
        StringBuilder r75 = new StringBuilder("sections个数=");
        com.bytedance.android.ec.hybrid.list.entity.k r76 = r73.c.g;
        if (r76 == null) goto L183;
        ArrayList r77 = r76.c;
        if (r77 == null) goto L183;
        Integer r78 = Integer.valueOf(r77.size());
    L184:
        r75.append(r78);
        r75.append(" layouthelpers个数:");
        VirtualLayoutManager r79 = r73.b.getLayoutManager();
        if (r79 == null) goto L189;
        List r80 = r79.R();
        if (r80 == null) goto L189;
        Integer r81 = Integer.valueOf(((LinkedList) r80).size());
    L190:
        r75.append(r81);
        r75.append(",对应的id依次为:");
        r74.a(r75.toString());
        com.bytedance.android.ec.hybrid.list.entity.k r82 = r73.c.g;
        if (r82 == null) goto L211;
        ArrayList r83 = r82.c;
        if (r83 == null) goto L211;
        Iterator<T> r84 = r83.iterator();
        int r85 = 0;
    L196:
        if (r84.hasNext() == false) goto L211;
        com.bytedance.android.ec.hybrid.list.entity.i r86 = (com.bytedance.android.ec.hybrid.list.entity.i) r84.next();
        dm.a.b r87 = dm.a.a("LGHP");
        StringBuilder r88 = new StringBuilder("对应的id=");
        r88.append(r86.a);
        r88.append(",对应的item个数为:");
        ArrayList r89 = r86.i;
        if (r89 == null) goto L200;
        Integer r90 = Integer.valueOf(r89.size());
    L201:
        r88.append(r90);
        r88.append(",对应的layouthelper:");
        VirtualLayoutManager r91 = r73.b.getLayoutManager();
        if (r91 == null) goto L209;
        List r92 = r91.R();
        if (r92 == null) goto L209;
        int r93 = r85 + 1;
        com.bytedance.android.ec.vlayout.a r94 = (com.bytedance.android.ec.vlayout.a) CollectionsKt.getOrNull(r92, r85);
        if (r94 == null) goto L208;
        un.f r95 = r94.a;
    L210:
        r88.append(r95);
        r87.a(r88.toString());
        r85 = r93;
        goto L196
    L208:
        r85 = r93;
    L209:
        r93 = r85;
        r95 = null;
        goto L210
    L200:
        r90 = null;
    L211:
        VirtualLayoutManager r96 = r73.b.getLayoutManager();
        if (r96 == null) goto L251;
        List r97 = r96.R();
        if (r97 == null) goto L251;
        Iterator<T> r98 = r97.iterator();
        int r99 = 0;
    L217:
        if (r98.hasNext() == false) goto L251;
        com.bytedance.android.ec.vlayout.a r100 = (com.bytedance.android.ec.vlayout.a) r98.next();
        dm.a.b r101 = dm.a.a("LGHP");
        StringBuilder r102 = new StringBuilder("对应的layouthelper_ranger:");
        VirtualLayoutManager r103 = r73.b.getLayoutManager();
        if (r103 == null) goto L225;
        List r104 = r103.R();
        if (r104 == null) goto L225;
        com.bytedance.android.ec.vlayout.a r105 = (com.bytedance.android.ec.vlayout.a) CollectionsKt.getOrNull(r104, r99);
        if (r105 == null) goto L225;
        un.f r106 = r105.a;
    L226:
        r102.append(r106);
        r102.append("对应的layouthelper_zIndex:");
        VirtualLayoutManager r107 = r73.b.getLayoutManager();
        if (r107 == null) goto L233;
        List r108 = r107.R();
        if (r108 == null) goto L233;
        if (((com.bytedance.android.ec.vlayout.a) CollectionsKt.getOrNull(r108, r99)) == null) goto L233;
        Integer r109 = 0;
    L234:
        r102.append(r109);
        r102.append("对应的layouthelper_offFlowViews:");
        VirtualLayoutManager r114 = r73.b.getLayoutManager();
        if (r114 == null) goto L243;
        List r115 = r114.R();
        if (r115 == null) goto L243;
        com.bytedance.android.ec.vlayout.a r116 = (com.bytedance.android.ec.vlayout.a) CollectionsKt.getOrNull(r115, r99);
        if (r116 == null) goto L243;
        List r117 = r116.b;
        if (r117 == null) goto L243;
        Integer r118 = Integer.valueOf(((LinkedList) r117).size());
    L244:
        r102.append(r118);
        r102.append("对应的layouthelper_issticky:");
        VirtualLayoutManager r119 = r73.b.getLayoutManager();
        if (r119 == null) goto L249;
        List r120 = r119.R();
        if (r120 == null) goto L249;
        com.bytedance.android.ec.vlayout.a r121 = (com.bytedance.android.ec.vlayout.a) CollectionsKt.getOrNull(r120, r99);
    L250:
        r102.append(r121 instanceof vn.m);
        r101.a(r102.toString());
        r99 = r99 + 1;
    L249:
        r121 = null;
    L243:
        r118 = null;
    L233:
        r109 = null;
    L225:
        r106 = null;
    L189:
        r81 = null;
    L183:
        r78 = null;
    L173:
        e = move-exception;
        dm.a.a("查询数据").a("renderResultAsync出错:" + e);
        EnsureManager.ensureNotReachHere("shop_hybrid_product_error:" + e);
        goto L175
    L285:
        return;
    }
}
