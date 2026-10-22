package com.bytedance.android.shopping.sameproduct.viewholder;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.feed.utils.CommerceButtonUtil;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.sameproduct.model.SameProductPageParams;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rd3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewholder/BaseSimilarProductCardVH;", "T", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseSimilarProductCardVH<T> extends JediSimpleViewHolder<T> {
    public rd3.a l;
    public final Lazy m;
    public final Function3<rd3.a, Integer, View, Unit> n;
    public final Function2<Integer, View, Unit> o;
    public final Fragment p;
    public final View q;

    public void c4(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
    }

    public final SameProductViewModel d4() {
        return (SameProductViewModel) this.m.getValue();
    }

    public void f4(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
    }

    public final void e4(rd3.a r27) {
        if (r27 != null) goto L5;
        return;
    L5:
        Promotion r1 = r27.f();
        if (r1 == null) goto L91;
        String r2 = r1.getLink();
        if (r2 == null) goto L92;
        p r3 = p.a;
        Context r4 = this.q.getContext();
        int r5 = com.bytedance.android.shopping.sameproduct.helper.b.a;
        SameProductViewModel r6 = d4();
        String r7 = d4().getEcomSceneId();
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        Intrinsics.checkNotNullParameter(r27, "anchorInflowFeedItem");
        Promotion r8 = r27.f();
        if (r8 == null) goto L85;
        PromotionProductStruct r9 = r8.getPromotionInfo();
        if (r9 == null) goto L85;
        Uri r10 = UriProtector.parse(r2);
        String r11 = UriProtector.getQueryParameter(r10, "meta_params");
        if (r11 == null) goto L19;
        JSONObject r12 = z1.g(r11);
        if (r12 == null) goto L19;
    L20:
        JSONObject r14 = r12;
        String r13 = r14.optString("entrance_info");
        if (r13 == null) goto L24;
        JSONObject r15 = z1.g(r13);
        if (r15 == null) goto L24;
    L25:
        JSONObject r16 = r15;
        SameProductPageParams r17 = r6.getPageParams();
        ArrayList r18 = new ArrayList();
        if (a2.b(r7) == false) goto L35;
        if (r7 == null) goto L35;
        List r19 = StringsKt.split$default(r7, new String[]{","}, false, 0, 6, null);
        if (r19 == null) goto L34;
        Iterator<T> r20 = r19.iterator();
    L32:
        if (r20.hasNext() == false) goto L34;
        r18.add((String) r20.next());
    L34:
        ArrayList r21 = r18;
    L36:
        r21.add("1061");
        r16.put("button_status", CommerceButtonUtil.a(r9).getType());
        r16.put("display_rank", r27.f);
        if (r17 == null) goto L39;
        String r22 = r17.getVideoId();
    L40:
        r16.put(PdpOpenThirdParam.KEY_ITEM_ID, r22);
        r16.put("module_label", "guess_you_like_product");
        if (r17 != null) goto L43;
    L45:
        r16.put("inflow_landing_page_type", "product_inflow_similar_tab");
        r16.put("ecom_group_type", "product_card");
        r16.put("ecom_scene_id", CollectionsKt.joinToString$default(r21, ",", null, null, 0, null, null, 62, null));
        r14.put("entrance_info", r16.toString());
        Set r23 = j1.b(r10);
        Uri.Builder r24 = r10.buildUpon().clearQuery();
        ArrayList r110 = new ArrayList();
        r110.add("meta_params");
        r110.add("request_additions");
        r110.add(PdpOpenThirdParam.KEY_SOURCE_PAGE);
        if (r23 == null) goto L55;
        Iterator<T> r25 = r23.iterator();
    L49:
        if (r25.hasNext() == false) goto L55;
        Iterator<T> r111 = r25;
        String r26 = (String) r25.next();
        if (CollectionsKt.contains(r110, r26) == true) goto L54;
        r24.appendQueryParameter(r26, UriProtector.getQueryParameter(r10, r26));
    L54:
        r110 = r110;
        r25 = r111;
    L55:
        JSONObject r28 = new JSONObject();
        r28.put("request_id", r27.d);
        g r0 = r27.d();
        if (r0 == null) goto L58;
        String r29 = r0.a();
    L59:
        r28.put("recommend_info", r29);
        String r30 = UriProtector.getQueryParameter(r10, "request_additions");
        if (r30 == null) goto L63;
        JSONObject r31 = z1.g(r30);
        if (r31 == null) goto L63;
    L64:
        r31.put("same_product_scene", 2);
        if (r17 == null) goto L67;
        String r32 = r17.getSecAuthorId();
    L68:
        r31.put(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, r32);
        r31.put("ecom_scene_id", CollectionsKt.joinToString$default(r21, ",", null, null, 0, null, null, 62, null));
        r31.put(SimilarProductParam.ENTER_FROM, "same_product_flow_page");
        if (r17 == null) goto L71;
        String r33 = r17.getEnterFrom();
    L72:
        Uri.Builder r34 = r24.appendQueryParameter(PdpOpenThirdParam.KEY_SOURCE_PAGE, r33);
        if (r17 == null) goto L75;
        String r35 = r17.getVideoId();
    L76:
        Uri.Builder r36 = r34.appendQueryParameter(PdpOpenThirdParam.KEY_ITEM_ID, r35).appendQueryParameter("v3_events_additions", r28.toString()).appendQueryParameter("request_additions", r31.toString()).appendQueryParameter("meta_params", r14.toString());
        if (r17 == null) goto L79;
        String r37 = r17.getEcomEntranceForm();
    L80:
        Uri.Builder r38 = r36.appendQueryParameter("ecom_entrance_form", r37);
        PromotionProductBaseStruct r39 = r9.getBaseInfo();
        if (r39 == null) goto L83;
        Integer r40 = r39.getPromotionSource();
    L84:
        r2 = r38.appendQueryParameter(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, String.valueOf(r40)).build().toString();
        goto L85
    L83:
        r40 = null;
        goto L84
    L79:
        r37 = null;
        goto L80
    L75:
        r35 = null;
        goto L76
    L71:
        r33 = null;
        goto L72
    L67:
        r32 = null;
    L63:
        r31 = new JSONObject();
        goto L64
    L58:
        r29 = null;
        goto L59
    L43:
        if (r17.isFromFlowGuessULike() != true) goto L45;
        r16.put("from_product_module_label", "guess_you_like_product");
        goto L45
    L39:
        r22 = null;
    L35:
        r21 = r18;
    L24:
        r15 = new JSONObject();
    L19:
        r12 = new JSONObject();
    L85:
        r3.openSchema(r4, r2);
        return;
    L92:
        return;
    }

    public BaseSimilarProductCardVH(Fragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        super(r3);
        this.p = r2;
        this.q = r3;
        final KClass r4 = Reflection.getOrCreateKotlinClass(SameProductViewModel.class);
        this.m = LazyKt.lazy(new BaseSimilarProductCardVH$$special$$inlined$hostViewModel$1(this, r4, r4));
        this.n = new BaseSimilarProductCardVH$buyButtonOnClickListener$1(this);
        this.o = new BaseSimilarProductCardVH$enterProductDetailClickListener$1(this);
    }
}
