package com.bytedance.android.shopping.feed.resourcecard.viewholder;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.innerflow.jedi.JediBaseFragment;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.resourcecard.view.f;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rd3.a;
import yd3.i;
import yd3.j;
import yd3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/viewholder/LynxCardVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lrd3/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxCardVH extends JediSimpleViewHolder<ProductFeedAdapter.b<a>> {
    public final Fragment l;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a4(Object r19) {
        ProductFeedAdapter.b r2 = (ProductFeedAdapter.b) r19;
        Intrinsics.checkNotNullParameter(r2, "item");
        dm.a.a("lgz_log_debug").a("LynxCardVH bind");
        a r3 = (a) r2.b;
        int r4 = 0;
        if (r3 == null) goto L168;
        View r5 = ((RecyclerView.ViewHolder) this).itemView;
        String r7 = null;
        if ((r5 instanceof f) == true) goto L7;
        r5 = null;
    L7:
        f r6 = (f) r5;
        if (r6 == null) goto L168;
        Fragment r8 = this.l;
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r8, "fragment");
        r6.b = r3;
        p r0 = r3.i();
        if (r0 == null) goto L28;
        i r1 = r0.j();
        if (r1 == null) goto L28;
        j r9 = r1.a();
        if (r9 == null) goto L28;
        Integer r10 = r9.b();
        if (r10 == null) goto L28;
        if (r10.intValue() <= 0) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == true) goto L24;
        r10 = null;
    L24:
        if (r10 == null) goto L28;
        int r12 = r10.intValue();
        ViewGroup.LayoutParams r13 = r6.getLayoutParams();
        if (r13 == null) goto L28;
        r13.width = -1;
        r13.height = b.b(Integer.valueOf(r12));
        r6.setLayoutParams(r13);
        goto L28
    L20:
        r11 = false;
    L28:
        p r14 = r3.i();
        if (r14 == null) goto L35;
        i r15 = r14.j();
        if (r15 == null) goto L35;
        j r16 = r15.a();
        if (r16 == null) goto L35;
        String r17 = r16.a();
    L36:
        String r18 = "";
        String r110 = "default";
        if (r17 != null) goto L178;
    L53:
        r6.a = r110;
        p r20 = r3.i();
        if (r20 == null) goto L58;
        i r21 = r20.j();
        if (r21 == null) goto L58;
        String r22 = r21.b();
    L59:
        if (r17 != null) goto L61;
    L64:
        boolean r111 = true;
    L65:
        if (r111 == true) goto L168;
        if (r22 != null) goto L68;
    L71:
        boolean r112 = true;
    L72:
        if (r112 == true) goto L168;
        ProductFeedViewModel r113 = r3.c;
        if (r113 == null) goto L76;
        AnchorV3Param r114 = r113.m907getAnchorV3Param();
    L77:
        LinkedHashMap r115 = new LinkedHashMap();
        r115.put(PdpOpenThirdParam.KEY_PAGE_NAME, "product_flow_page");
        if (r114 == null) goto L81;
        String r116 = r114.getAuthorId();
        if (r116 == null) goto L81;
    L82:
        r115.put("author_id", r116);
        if (r3.e == false) goto L85;
        String r117 = "guess_you_like";
    L91:
        r115.put("ecom_entrance_form", r117);
        if (r114 == null) goto L97;
        AnchorV3PromotionRequestParam r118 = r114.getRequestParam();
        if (r118 == null) goto L97;
        String r119 = r118.getSourcePage();
        if (r119 == null) goto L97;
    L98:
        r115.put(PdpOpenThirdParam.KEY_SOURCE_PAGE, r119);
        if (r114 == null) goto L104;
        ECLogExtraData r120 = r114.getLogExtraData();
        if (r120 == null) goto L104;
        String r121 = r120.getEnterFrom();
        if (r121 == null) goto L104;
    L105:
        r115.put("previous_page", r121);
        if (r114 == null) goto L109;
        String r122 = r114.getVideoId();
        if (r122 == null) goto L109;
    L110:
        r115.put("group_id", r122);
        String r123 = r3.d;
        if (r123 != null) goto L113;
        r123 = "";
    L113:
        r115.put("request_id", r123);
        if (r114 == null) goto L119;
        ECLogExtraData r124 = r114.getLogExtraData();
        if (r124 == null) goto L119;
        String r125 = r124.getEnterFrom();
        if (r125 == null) goto L119;
    L120:
        r115.put(SimilarProductParam.ENTER_FROM, r125);
        if (r3.e == false) goto L123;
        String r23 = "guess_you_like_product";
    L124:
        r115.put("module_label", r23);
        if (r114 == null) goto L132;
        ECLogExtraData r24 = r114.getLogExtraData();
        if (r24 == null) goto L132;
        String r25 = r24.getEnterFrom();
        if (r25 == null) goto L132;
        r18 = r25;
    L132:
        r115.put("chnid", r18);
        if (r114 == null) goto L137;
        ECAdLogExtra r26 = r114.getAdLogExtra();
        if (r26 == null) goto L137;
        String r27 = r26.getCreativeId();
    L138:
        if (r27 != null) goto L140;
    L143:
        boolean r126 = true;
    L145:
        if ((!r126) == true) goto L148;
        r27 = null;
    L148:
        if (r27 == null) goto L150;
        String r28 = (String) r115.put("cid", r27);
    L150:
        if (r114 == null) goto L152;
        String r29 = r114.getAdType();
    L153:
        if (r29 != null) goto L155;
    L158:
        boolean r127 = true;
    L160:
        if ((true ^ r127) == false) goto L163;
        r7 = r29;
    L163:
        if (r7 != null) goto L165;
    L166:
        String r30 = (String) r115.put("ad_type", "0");
    L167:
        ECLynxCard r31 = new ECLynxCard();
        ECLynxLoadParam.a r32 = new ECLynxLoadParam.a(r6.getContext(), r8.getLifecycle(), r6, r17);
        r32.j(2000);
        r32.j = r22;
        r32.f(r6.c);
        Intrinsics.checkNotNullParameter(r115, "ecGlobalProps");
        r32.p = r115;
        r31.j(new ECLynxLoadParam(r32));
        goto L168
    L165:
        if (((String) r115.put("ad_type", r7)) != null) goto L167;
    L155:
        if (r29.length() == 0) goto L158;
        r127 = false;
        goto L160
    L152:
        r29 = null;
        goto L153
    L140:
        if (r27.length() == 0) goto L143;
        r126 = false;
    L137:
        r27 = null;
        goto L138
    L123:
        r23 = "";
    L119:
        r125 = "";
    L109:
        r122 = "";
    L104:
        r121 = "";
    L97:
        r119 = "";
        goto L98
    L85:
        if (r114 == null) goto L90;
        ECLogExtraData r128 = r114.getLogExtraData();
        if (r128 == null) goto L90;
        r117 = r128.getEComEntranceForm();
        if (r117 != null) goto L91;
    L90:
        r117 = "";
    L81:
        r116 = "";
        goto L82
    L76:
        r114 = null;
        goto L77
    L68:
        if (r22.length() == 0) goto L71;
        r112 = false;
        goto L72
    L61:
        if (r17.length() == 0) goto L64;
        r111 = false;
    L58:
        r22 = null;
        goto L59
    L178:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L51
        String r129 = UriProtector.parse(UriProtector.getQueryParameter(UriProtector.parse(Uri.decode(r17)), "url")).getPath();     // Catch: Throwable -> L51
        if (r129 == null) goto L48;
        List r34 = StringsKt.split$default(r129, new String[]{"/"}, false, 0, 6, null);     // Catch: Throwable -> L51
        if (r34 == null) goto L48;
        String r35 = (String) CollectionsKt.getOrNull(r34, r34.size() - 2);     // Catch: Throwable -> L51
        if (r35 != null) goto L46;
        r110 = "";
    L47:
        Unit r36 = Unit.INSTANCE;     // Catch: Throwable -> L51
    L49:
        Result.constructor-impl(r36);     // Catch: Throwable -> L51
        goto L53
    L46:
        r110 = r35;
    L48:
        r36 = null;
    L51:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L35:
        r17 = null;
    L168:
        a r37 = (a) r2.b;
        if (r37 == null) goto L173;
        p r38 = r37.i();
        if (r38 == null) goto L173;
        r4 = r38.a();
    L173:
        if (r4 <= 0) goto L180;
        a r39 = (a) r2.b;
        if (r39 == null) goto L181;
        r39.f = getAdapterPosition();
        return;
    L181:
        return;
    }

    public LynxCardVH(JediBaseFragment r4, Context r5, ProductFeedAdapter r6) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "adapter");
        int r2 = f.d;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "adapter");
        f r0 = new f(r5, r6);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        wg.a.f(r0, b.b(12), 0, b.b(12), 0);
        super(r0);
        this.l = r4;
    }
}
