package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.data.FindSameSource;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.FindSameGoodsStruct;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.feed.repository.dto.SearchSuggestRequestParams;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/shopping/prepurchase/arch/container/ability/l;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataFetchService$actionAfterPack$1", f = "PdpDataFetchService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PdpDataFetchService$actionAfterPack$1 extends SuspendLambda implements Function3<CoroutineScope, com.bytedance.android.shopping.prepurchase.arch.container.ability.l, Continuation<? super Unit>, Object> {
    final /* synthetic */ Control $control;
    final /* synthetic */ boolean $justPack;
    final /* synthetic */ PackResponseDTO $packDTO;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PdpDataFetchService this$0;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
        public final /* synthetic */ PdpDataFetchService$actionAfterPack$1 c;

        @Override // java.lang.Runnable
        public final void run() {
            Control r1 = this.c.$control;
            String r5 = null;
            if (r1 != null) goto L5;
        L63:
            PdpDataFetchService r2 = this.c.this$0;
            int r6 = PdpDataFetchService.E;
            CommonMeta r3 = r2.b2();
            if (r3 == null) goto L68;
            FindSameGoodsStruct r4 = r3.getFullScreenFindSame();
            if (r4 == null) goto L68;
            PdpDataFetchService r7 = this.c.this$0;
            FindSameSource r8 = FindSameSource.DIALOG;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r4, "req");
            Intrinsics.checkNotNullParameter(r8, "source");
            String r9 = r7.c2();
            com.bytedance.android.shopping.anchorv4.data.k r10 = AnchorV4DataManager.a;
            AnchorV4DataManager.b(r9, r4, r8);
        L68:
            PdpDataFetchService$actionAfterPack$1 r11 = this.c;
            if (r11.$justPack == true) goto L233;
            PackResponseDTO r12 = r11.$packDTO;
            if (r12 != null) goto L73;
        L75:
            Control r13 = this.c.$control;
            if (r13 != null) goto L78;
        L120:
            Control r14 = this.c.$control;
            if (r14 != null) goto L123;
        L159:
            PageMeta r15 = this.c.this$0.d2().b.a;
            if (r15 == null) goto L162;
            CommonMeta r16 = r15.getCommonMeta();
        L163:
            int r17 = com.bytedance.android.shopping.anchorv3.utils.m.a;
            if (r16 == null) goto L166;
            String r18 = r16.getPromotionId();
        L167:
            if (r16 == null) goto L169;
            String r19 = r16.getProductId();
        L170:
            if (r16 == null) goto L172;
            String r20 = r16.getProductBizIdentifier();
        L173:
            if (r16 == null) goto L175;
            String r21 = r16.getChannelId();
        L176:
            if (r16 == null) goto L178;
            Integer r110 = r16.getChannelType();
        L179:
            if (r16 == null) goto L181;
            String r111 = r16.getAuthorId();
        L182:
            if (r16 == null) goto L184;
            String r112 = r16.getLiveRoomId();
        L185:
            if (r16 == null) goto L187;
            String r113 = r16.getItemId();
        L188:
            if (r16 == null) goto L192;
            ECAdLogExtra r22 = r16.getAdLogExtra();
            if (r22 == null) goto L192;
            String r23 = r22.getCreativeId();
        L193:
            String r24 = a2.d(r23);
            if (r24 != null) goto L202;
            if (r16 == null) goto L197;
            String r25 = r16.getEntranceInfo();
        L198:
            JSONObject r26 = com.bytedance.android.shopping.extensions.k.w(r25);
            if (r26 == null) goto L201;
            r24 = r26.optString("creative_id");
            goto L202
        L201:
            String r114 = null;
        L203:
            if (r16 == null) goto L205;
            String r115 = r16.getCpsTrack();
        L206:
            if (r16 == null) goto L208;
            String r116 = r16.getCBizCombo();
        L209:
            if (r16 == null) goto L211;
            String r117 = r16.getBuyinTrack();
        L212:
            if (r16 == null) goto L214;
            String r27 = r16.getRequestAdditions();
        L215:
            JSONObject r28 = com.bytedance.android.shopping.extensions.k.w(r27);
            if (r28 == null) goto L219;
            String r29 = r28.optString(SimilarProductParam.ENTER_FROM);
            if (r29 == null) goto L219;
        L221:
            String r118 = r29;
        L223:
            if (r16 == null) goto L225;
            String r119 = r16.getEntranceInfo();
        L226:
            if (r16 == null) goto L228;
            String r210 = r16.getEcomSceneId();
        L229:
            if (r16 == null) goto L231;
            r5 = r16.getFootPrint();
        L231:
            com.bytedance.android.shopping.anchorv3.utils.m.a(r18, r19, r20, r21, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r5);
            PdpDataFetchService r30 = this.c.this$0;
            r30.getClass();
            com.bytedance.android.shopping.anchorv4.data.k r31 = AnchorV4DataManager.a;
            AnchorV4DataManager.d(r30.c2());
            return;
        L228:
            r210 = null;
            goto L229
        L225:
            r119 = null;
        L219:
            if (r16 == null) goto L222;
            r29 = r16.getSourcePage();
            goto L221
        L222:
            r118 = null;
            goto L223
        L214:
            r27 = null;
            goto L215
        L211:
            r117 = null;
            goto L212
        L208:
            r116 = null;
            goto L209
        L205:
            r115 = null;
            goto L206
        L197:
            r25 = null;
        L202:
            r114 = r24;
        L192:
            r23 = null;
            goto L193
        L187:
            r113 = null;
            goto L188
        L184:
            r112 = null;
            goto L185
        L181:
            r111 = null;
            goto L182
        L178:
            r110 = null;
            goto L179
        L175:
            r21 = null;
            goto L176
        L172:
            r20 = null;
            goto L173
        L169:
            r19 = null;
            goto L170
        L166:
            r18 = null;
            goto L167
        L162:
            r16 = null;
            goto L163
        L123:
            if (r14.getDetailControl() != true) goto L159;
            PdpDataFetchService r32 = this.c.this$0;
            PageMeta r33 = r32.d2().b.a;
            if (r33 == null) goto L127;
            CommonMeta r34 = r33.getCommonMeta();
        L128:
            com.bytedance.android.shopping.anchorv4.data.k r35 = AnchorV4DataManager.a;
            String r36 = r32.c2();
            if (r34 == null) goto L131;
            String r37 = r34.getPromotionId();
        L132:
            if (r37 != null) goto L134;
            String r38 = "";
        L135:
            if (r34 == null) goto L137;
            String r39 = r34.getSourcePage();
        L138:
            if (r34 == null) goto L140;
            String r40 = r34.getMetaParam();
        L141:
            String r120 = com.bytedance.android.shopping.extensions.k.j(r40);
            Map r121 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r32.O1())).a.getNativeParams().getDetailApiImagesConstraint();
            if (r34 == null) goto L144;
            String r41 = r34.getTagGuaranteeHeader();
        L145:
            if (r41 != null) goto L147;
            String r122 = "";
        L148:
            if (r34 == null) goto L150;
            Boolean r42 = Boolean.valueOf(r34.getEnablePDPOptimize());
        L151:
            boolean r123 = com.bytedance.android.shopping.extensions.k.i(r42);
            if (r34 == null) goto L154;
            String r124 = r34.getChannelId();
        L155:
            if (r34 == null) goto L157;
            Integer r125 = r34.getChannelType();
        L158:
            AnchorV4DataManager.a(r36, r38, r39, r120, r121, r122, r123 ? 1 : 0, r124, r125);
            goto L159
        L157:
            r125 = null;
            goto L158
        L154:
            r124 = null;
            goto L155
        L150:
            r42 = null;
            goto L151
        L147:
            r122 = r41;
            goto L148
        L144:
            r41 = null;
            goto L145
        L140:
            r40 = null;
            goto L141
        L137:
            r39 = null;
            goto L138
        L134:
            r38 = r37;
            goto L135
        L131:
            r37 = null;
            goto L132
        L127:
            r34 = null;
            goto L128
        L78:
            if (r13.getShopRecommendsControl() != true) goto L120;
            PdpDataFetchService r43 = this.c.this$0;
            String r44 = r43.c2();
            com.bytedance.android.shopping.anchorv4.data.k r45 = AnchorV4DataManager.a;
            CommonMeta r46 = r43.b2();
            if (r46 == null) goto L82;
            String r47 = r46.getProductId();
        L83:
            if (r47 != null) goto L85;
            r47 = "";
        L85:
            StringBuilder r48 = new StringBuilder();
            CommonMeta r49 = r43.b2();
            if (r49 == null) goto L88;
            String r50 = r49.getCarrierSource();
        L89:
            if (r50 != null) goto L91;
            r50 = "";
        L91:
            r48.append(r50);
            r48.append("-");
            CommonMeta r51 = r43.b2();
            if (r51 == null) goto L94;
            String r52 = r51.getSourceMethod();
        L95:
            if (r52 != null) goto L97;
            r52 = "";
        L97:
            r48.append(r52);
            String r53 = r48.toString();
            PageMeta r54 = r43.d2().b.a;
            if (r54 == null) goto L100;
            LinkedTreeMap r55 = r54.getTrackMeta();
        L101:
            if (r55 == null) goto L106;
            Object r56 = r55.get("ecom_group_type");
            if (r56 == null) goto L106;
            String r57 = r56.toString();
            if (r57 == null) goto L106;
        L107:
            CommonMeta r126 = r43.b2();
            if (r126 == null) goto L110;
            String r127 = r126.getLiveRoomId();
        L111:
            if (r127 != null) goto L113;
            r127 = "";
        L113:
            CommonMeta r128 = r43.b2();
            if (r128 == null) goto L116;
            String r129 = r128.getItemId();
        L117:
            if (r129 != null) goto L119;
            r129 = "";
        L119:
            AnchorV4DataManager.j(r44, r47, r53, r57, r127, r129, ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r43.O1())).a.getNativeParams().getStoreRecommendApiImageConstraints());
            goto L120
        L116:
            r129 = null;
            goto L117
        L110:
            r127 = null;
        L106:
            r57 = "";
            goto L107
        L100:
            r55 = null;
            goto L101
        L94:
            r52 = null;
            goto L95
        L88:
            r50 = null;
            goto L89
        L82:
            r47 = null;
            goto L83
        L73:
            if (r12.getFromCache() != true) goto L75;
            return;
        L233:
            return;
        L5:
            if (r1.getSearchWordsControl() != true) goto L63;
            PdpDataFetchService r58 = this.c.this$0;
            int r59 = PdpDataFetchService.E;
            PageMeta r60 = r58.d2().b.a;
            if (r60 == null) goto L9;
            CommonMeta r61 = r60.getCommonMeta();
        L10:
            if (r61 == null) goto L17;
            String r62 = r61.getRequestAdditions();
            if (r62 == null) goto L17;
            JSONObject r63 = com.bytedance.android.shopping.extensions.k.w(r62);
            if (r63 == null) goto L17;
            String r64 = r63.optString(SimilarProductParam.ENTER_FROM);
            if (r64 == null) goto L17;
        L20:
            String r65 = r58.c2();
            com.bytedance.android.shopping.anchorv4.data.k r66 = AnchorV4DataManager.a;
            if (r61 == null) goto L23;
            String r67 = r61.getProductId();
        L24:
            if (r67 != null) goto L26;
            r67 = "";
        L26:
            if (r64 != null) goto L28;
            r64 = "";
        L28:
            PageMeta r68 = r58.d2().b.a;
            if (r68 == null) goto L31;
            CommonMeta r69 = r68.getCommonMeta();
        L32:
            AnchorV4HeadV2VO r130 = r58.d2().b.t;
            boolean r131 = false;
            if (r130 == null) goto L35;
            int r132 = r130.getChangeKeyPosition();
        L36:
            if (r132 > 0) goto L38;
        L40:
            boolean r133 = false;
        L41:
            V4NativeParams r70 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r58.O1())).a.getNativeParams();
            if (r133 == false) goto L44;
        L59:
            if (r131 == false) goto L61;
            String r71 = "90118";
        L62:
            AnchorV4DataManager.i(r65, r67, r64, r71);
            goto L63
        L61:
            r71 = SearchSuggestRequestParams.BUSINESS_ID;
            goto L62
        L44:
            if (r70.getFromLive() == false) goto L59;
            if (r70.getFullMode() == true) goto L59;
            if (com.bytedance.android.ec.core.opt.ab.c.b() == false) goto L59;
            if (r69 == null) goto L59;
            String r72 = r69.getEntranceInfo();
            if (r72 == null) goto L59;
            JSONObject r73 = com.bytedance.android.shopping.extensions.k.w(r72);
            if (r73 == null) goto L59;
            String r74 = r73.optString("ecom_scene_id");
            if (r74 == null) goto L59;
            if (StringsKt.endsWith$default(r74, "1001", false, 2, null) != true) goto L59;
            r131 = true;
            goto L59
        L38:
            if (((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r58.O1())).a.getNativeParams().getFullMode() == true) goto L40;
            r133 = true;
            goto L41
        L35:
            r132 = 0;
            goto L36
        L31:
            r69 = null;
            goto L32
        L23:
            r67 = null;
        L17:
            if (r61 == null) goto L19;
            r64 = r61.getSourcePage();
            goto L20
        L19:
            r64 = null;
            goto L20
        L9:
            r61 = null;
            goto L10
        }

        public a(PdpDataFetchService$actionAfterPack$1 r1) {
            this.c = r1;
            super("actionAfterPack");
        }
    }

    public PdpDataFetchService$actionAfterPack$1(PdpDataFetchService r1, Control r2, boolean r3, PackResponseDTO r4, Continuation r5) {
        this.this$0 = r1;
        this.$control = r2;
        this.$justPack = r3;
        this.$packDTO = r4;
        super(3, r5);
    }

    public final Continuation<Unit> create(CoroutineScope r7, com.bytedance.android.shopping.prepurchase.arch.container.ability.l r8, Continuation<? super Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "$this$create");
        Intrinsics.checkNotNullParameter(r8, "it");
        Intrinsics.checkNotNullParameter(r9, "continuation");
        PdpDataFetchService$actionAfterPack$1 r10 = new PdpDataFetchService$actionAfterPack$1(this.this$0, this.$control, this.$justPack, this.$packDTO, r9);
        r10.L$0 = r8;
        return r10;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (com.bytedance.android.shopping.prepurchase.arch.container.ability.l) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        ((com.bytedance.android.shopping.prepurchase.arch.container.ability.l) this.L$0).e1(new a(this));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
