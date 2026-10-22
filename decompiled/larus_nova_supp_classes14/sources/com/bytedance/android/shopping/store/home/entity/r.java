package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object, java.util.List<? extends com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO>] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.util.ArrayList] */
    public static uj3.j a(com.bytedance.android.shopping.store.tabkit.model.k r12, Integer r13) {
        Intrinsics.checkNotNullParameter(r12, "tab");
        ECShopABSettings.k.getClass();
        Object r1 = null;
        if (ECShopABSettings.f() == false) goto L5;
        b r0 = ((a0) r12).y();
    L12:
        uj3.j r2 = new uj3.j();
        Integer r3 = r12.n();
        boolean r4 = false;
        if (r3 == null) goto L15;
        int r5 = r3.intValue();
    L16:
        r2.d = r5;
        com.bytedance.android.shopping.store.tabkit.model.x r6 = r12.o();
        String r7 = "";
        if (r6 == null) goto L22;
        com.bytedance.android.shopping.store.tabkit.model.w r8 = r6.b();
        if (r8 == null) goto L22;
        String r9 = r8.e();
        if (r9 == null) goto L22;
    L23:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r2.e = r9;
        r2.f = Intrinsics.areEqual(r12.r(), Boolean.FALSE);
        com.bytedance.android.shopping.store.tabkit.model.s r10 = r12.f();
        if (r10 == null) goto L26;
        String r11 = r10.b();
    L27:
        r2.u = r11;
        if (r0 == null) goto L32;
        t r14 = r0.d();
        if (r14 == null) goto L32;
        String r15 = r14.e();
    L33:
        r2.v = r15;
        if (r0 == null) goto L38;
        t r16 = r0.d();
        if (r16 == null) goto L38;
        ECStoreDynamicTabData r17 = r16.b();
    L39:
        r2.w = r17;
        ECStoreDynamicTabConfig r18 = new ECStoreDynamicTabConfig();
        com.bytedance.android.shopping.store.tabkit.model.s r19 = r12.f();
        if (r19 == null) goto L44;
        com.bytedance.android.shopping.store.tabkit.model.a r20 = r19.a();
        if (r20 == null) goto L44;
        String r21 = r20.b();
    L45:
        r18.setApiPath(r21);
        com.bytedance.android.shopping.store.tabkit.model.s r22 = r12.f();
        if (r22 == null) goto L50;
        com.bytedance.android.shopping.store.tabkit.model.a r23 = r22.a();
        if (r23 == null) goto L50;
        String r24 = r23.a();
    L51:
        r18.setApiExtraParams(r24);
        r18.setNeedDynamicData(com.bytedance.android.shopping.extensions.k.c(r18.getApiPath()));
        if (r0 == null) goto L56;
        t r25 = r0.d();
        if (r25 == null) goto L56;
        String r26 = r25.c();
    L57:
        r18.setEventExtraParams(r26);
        if (r0 == null) goto L62;
        t r27 = r0.d();
        if (r27 == null) goto L62;
        String r28 = r27.d();
    L63:
        r18.setEventName(r28);
        Unit r29 = Unit.INSTANCE;
        r2.x = r18;
        if (r0 == null) goto L68;
        List<ECShopHeadInfoBlock> r30 = r0.c();
        if (r30 == null) goto L68;
        ECShopHeadInfoBlock r31 = (ECShopHeadInfoBlock) CollectionsKt.firstOrNull(r30);
    L68:
        if (r0 == null) goto L70;
        String r32 = r0.i();
    L71:
        r2.l = r32;
        if (r0 == null) goto L74;
        String r33 = r0.h();
    L75:
        r2.m = r33;
        Intrinsics.checkNotNullParameter(r12, "$this$isProductTab");
        com.bytedance.android.shopping.store.tabkit.model.s r34 = r12.f();
        if (r34 == null) goto L78;
        Integer r35 = r34.c();
    L79:
        boolean r36 = true;
        if (r35 != null) goto L83;
    L95:
        boolean r37 = false;
    L97:
        if (r37 == true) goto L109;
        Intrinsics.checkNotNullParameter(r12, "$this$isProductHybridTab");
        com.bytedance.android.shopping.store.tabkit.model.s r38 = r12.f();
        if (r38 == null) goto L101;
        Integer r39 = r38.c();
    L102:
        if (r39 != null) goto L105;
    L107:
        r36 = false;
    L108:
        if (r36 == true) goto L109;
    L202:
        LinkedHashMap r40 = new LinkedHashMap();
        Map<String, String> r41 = r12.h();
        if (r41 != null) goto L205;
        r41 = MapsKt.emptyMap();
    L205:
        r40.putAll(r41);
        if (r12.q() == false) goto L217;
        if (r0 == null) goto L210;
        String r42 = r0.b();
        if (r42 == null) goto L210;
    L211:
        r40.put("benefit_type", r42);
        if (r0 == null) goto L215;
        String r43 = r0.a();
        if (r43 == null) goto L215;
    L216:
        r40.put("benefit_desc", r43);
    L215:
        r43 = "";
    L210:
        r42 = "";
    L217:
        r2.n = r40;
        if (r0 == null) goto L225;
        t r44 = r0.d();
        if (r44 == null) goto L225;
        String r45 = r44.a();
        if (r45 == null) goto L225;
        r7 = r45;
    L225:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r2.q = r7;
        com.bytedance.android.shopping.store.tabkit.model.s r46 = r12.f();
        if (r46 == null) goto L228;
        Integer r47 = r46.c();
    L229:
        r2.t = r47;
        if (r0 == null) goto L232;
        String r48 = r0.g();
    L233:
        r2.y = r48;
        if (r0 == null) goto L238;
        Integer r49 = r0.f();
        if (r49 == null) goto L238;
        Long r50 = Long.valueOf(r49.intValue());
    L239:
        r2.z = r50;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r51 = r12.m();
        if (r51 == null) goto L245;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r52 = r51;
        ArrayList r53 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r52, 10));
        Iterator r54 = r52.iterator();
    L243:
        if (r54.hasNext() == false) goto L246;
        r53.add(a((com.bytedance.android.shopping.store.tabkit.model.k) r54.next(), r13));
    L246:
        r2.b = r53;
        List<com.bytedance.android.shopping.store.tabkit.model.k> r110 = r12.m();
        if (r110 == null) goto L255;
        Iterator r111 = r110.iterator();
    L250:
        if (r111.hasNext() == false) goto L254;
        Object r55 = r111.next();
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.store.tabkit.model.k) r55).n(), r13) == false) goto L250;
        r1 = r55;
    L254:
        r1 = (com.bytedance.android.shopping.store.tabkit.model.k) r1;
    L255:
        if (r1 == null) goto L257;
        r2.c = r13;
    L257:
        return r2;
    L245:
        r53 = null;
    L238:
        r50 = null;
        goto L239
    L232:
        r48 = null;
        goto L233
    L228:
        r47 = null;
        goto L229
    L105:
        if (r39.intValue() != 5) goto L107;
    L101:
        r39 = null;
    L109:
        if (r0 == null) goto L111;
        ECStoreProductTabDTO r56 = r0.e();
    L112:
        if (r56 == null) goto L119;
        List<com.bytedance.android.ec.store.repository.dto.k> r57 = r56.getGoodTypes();
        if (r57 == null) goto L119;
        List<com.bytedance.android.ec.store.repository.dto.k> r58 = r57;
        ArrayList r59 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r58, 10));
        Iterator r60 = r58.iterator();
    L117:
        if (r60.hasNext() == false) goto L120;
        com.bytedance.android.ec.store.repository.dto.k r112 = (com.bytedance.android.ec.store.repository.dto.k) r60.next();
        int r113 = com.bytedance.android.ec.store.repository.vo.q.c;
        r59.add(com.bytedance.android.ec.store.repository.vo.q.a.a(r112));
    L120:
        r2.h = r59;
        if (r56 == null) goto L128;
        List<com.bytedance.android.ec.store.repository.dto.m> r61 = r56.getSortTypes();
        if (r61 == null) goto L128;
        List<com.bytedance.android.ec.store.repository.dto.m> r62 = r61;
        ArrayList r63 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r62, 10));
        Iterator r64 = r62.iterator();
    L126:
        if (r64.hasNext() == false) goto L129;
        com.bytedance.android.ec.store.repository.dto.m r114 = (com.bytedance.android.ec.store.repository.dto.m) r64.next();
        int r115 = com.bytedance.android.ec.store.repository.vo.r.t;
        r63.add(com.bytedance.android.ec.store.repository.vo.r.a.a(r114));
    L129:
        r2.i = r63;
        if (r56 == null) goto L137;
        List<com.bytedance.android.ec.store.repository.dto.l> r65 = r56.getProducts();
        if (r65 == null) goto L137;
        List<com.bytedance.android.ec.store.repository.dto.l> r66 = r65;
        ?? r67 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r66, 10));
        Iterator r68 = r66.iterator();
    L135:
        if (r68.hasNext() == false) goto L138;
        com.bytedance.android.ec.store.repository.dto.l r116 = (com.bytedance.android.ec.store.repository.dto.l) r68.next();
        StoreV2ProductItemVO.Q.getClass();
        r67.add(StoreV2ProductItemVO.a.b(r116));
    L138:
        Intrinsics.checkNotNullParameter(r67, "<set-?>");
        r2.j = r67;
        if (r56 == null) goto L141;
        r4 = r56.getHasMore();
    L141:
        r2.k = r4;
        if (r56 == null) goto L144;
        long r69 = r56.getCursor();
    L145:
        r2.r = r69;
        if (r56 == null) goto L148;
        Integer r70 = r56.getStyleType();
    L149:
        r2.s = r70;
        if (r56 == null) goto L152;
        Integer r71 = r56.getLayout();
    L153:
        r2.g = r71;
        if (r56 != null) goto L156;
    L158:
        if (r56 == null) goto L160;
        Integer r72 = r56.getRecommendModuleType();
    L161:
        r2.o = r72;
        if (r56 == null) goto L164;
        String r73 = r56.getBottomModuleParams();
    L165:
        r2.p = r73;
        if (r56 == null) goto L168;
        Integer r74 = r56.getForceProductLayout();
    L169:
        r2.C = r74;
        int r75 = com.bytedance.android.ec.store.repository.vo.n.b;
        if (r56 == null) goto L172;
        List<com.bytedance.android.ec.store.repository.dto.c> r76 = r56.getSelectButtons();
    L173:
        com.bytedance.android.ec.store.repository.vo.n r77 = new com.bytedance.android.ec.store.repository.vo.n();
        r77.a = r76;
        r2.B = r77;
        if (r56 == null) goto L176;
        List<com.bytedance.android.ec.store.repository.dto.g> r78 = r56.getPickTypes();
    L177:
        r2.F = r78;
        if (r56 == null) goto L180;
        Map<String, String> r79 = r56.getBizExtra();
    L181:
        r2.G = r79;
        if (r56 == null) goto L184;
        Map<String, ? extends Object> r80 = r56.getProductVideoComponent();
    L185:
        r2.D = r80;
        if (r56 == null) goto L188;
        ECShopHeadInfoBlock r81 = r56.getProductTabComponent();
    L189:
        r2.E = r81;
        if (r56 == null) goto L192;
        ECHybridListDTO r82 = r56.getHybridList();
    L193:
        r2.H = r82;
        if (r56 == null) goto L196;
        String r83 = r56.getPaginationParams();
    L197:
        r2.J = r83;
        if (r56 == null) goto L200;
        String r84 = r56.getHybridParams();
    L201:
        r2.K = r84;
        goto L202
    L200:
        r84 = null;
        goto L201
    L196:
        r83 = null;
        goto L197
    L192:
        r82 = null;
        goto L193
    L188:
        r81 = null;
        goto L189
    L184:
        r80 = null;
        goto L185
    L180:
        r79 = null;
        goto L181
    L176:
        r78 = null;
        goto L177
    L172:
        r76 = null;
        goto L173
    L168:
        r74 = null;
        goto L169
    L164:
        r73 = null;
        goto L165
    L160:
        r72 = null;
        goto L161
    L156:
        if (r56.getPromotion() == null) goto L158;
        goto L158
    L152:
        r71 = null;
        goto L153
    L148:
        r70 = null;
        goto L149
    L144:
        r69 = 0;
    L137:
        r67 = CollectionsKt.emptyList();
    L128:
        r63 = null;
    L119:
        r59 = null;
        goto L120
    L111:
        r56 = null;
        goto L112
    L83:
        if (r35.intValue() != 1) goto L95;
        Integer r85 = r12.n();
        int r86 = TabEnum.PRODUCT_TAB.getType();
        if (r85 != null) goto L88;
    L89:
        Integer r87 = r12.n();
        int r88 = TabEnum.PRODUCT_NESTED_TAB.getType();
        if (r87 == null) goto L95;
        if (r87.intValue() != r88) goto L95;
    L94:
        r37 = true;
        goto L97
    L88:
        if (r85.intValue() == r86) goto L94;
    L78:
        r35 = null;
        goto L79
    L74:
        r33 = null;
        goto L75
    L70:
        r32 = null;
    L62:
        r28 = null;
    L56:
        r26 = null;
    L50:
        r24 = null;
    L44:
        r21 = null;
    L38:
        r17 = null;
    L32:
        r15 = null;
        goto L33
    L26:
        r11 = null;
    L22:
        r9 = "";
        goto L23
    L15:
        r5 = 0;
        goto L16
    L5:
        String r89 = r12.b();
        if (r89 != null) goto L258;
        r0 = null;
        goto L12
    L258:
        Object r90 = new Gson().fromJson(r89, b.class);     // Catch: Exception -> L9
    L10:
        r0 = (b) r90;
    L9:
        r90 = null;
        goto L10
    }
}
