package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv3.ECAnchorV3Helper;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentLogParams;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public final Context d;
    public final com.bytedance.android.shopping.commentv3.data.b e;

    public final String d(String r14) {
        JSONObject r15 = com.bytedance.android.shopping.extensions.k.w(r14);
        if (r15 != null) goto L19;
    L13:
        if (r15 == null) goto L18;
        r15.put("ecom_scene_id", "1071");     // Catch: JSONException -> L11
    L18:
        return String.valueOf(r15);
    L19:
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.a("CommentAbsCommonChainEventImpl").b("updateSceneId", e);
        int r2 = ic3.e.a;
        ic3.e.a.a(this.c, EventName.ERROR.getEvent(), "", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: CommentAbsCommonChainEventImpl, method: updateSceneId, exception: " + e.getMessage())}), null, null, 240);
        goto L18
    L5:
        if (r15.has("ecom_scene_id") != true) goto L13;
        Object r3 = r15.opt("ecom_scene_id");     // Catch: JSONException -> L11
        if (r3 == null) goto L10;
        List r4 = CollectionsKt.toMutableList(StringsKt.split$default((String) r3, new String[]{","}, false, 0, 6, null));     // Catch: JSONException -> L11
        r4.remove("1071");     // Catch: JSONException -> L11
        r4.add("1071");     // Catch: JSONException -> L11
        r15.put("ecom_scene_id", CollectionsKt.joinToString$default(r4, ",", null, null, 0, null, null, 62, null));     // Catch: JSONException -> L11
        goto L18
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: JSONException -> L11
    }

    public e(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.ENTER_PRODUCT_DETAIL.getType());
        this.d = r2;
        this.e = r3;
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r18, fc3.a r19, fc3.c r20, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r21) {
        Intrinsics.checkNotNullParameter(r18, "eventContext");
        Intrinsics.checkNotNullParameter(r19, "actionContext");
        Intrinsics.checkNotNullParameter(r20, "handleActionParams");
        Intrinsics.checkNotNullParameter(r21, "completion");
        Map r0 = r18.k;
        if (r0 == null) goto L5;
        Object r1 = r0.get("params");
    L7:
        if ((r1 instanceof Map) == true) goto L9;
        r1 = null;
    L9:
        Map r2 = (Map) r1;
        if (r2 == null) goto L12;
        String r5 = nc3.a.e(r2, PdpOpenThirdParam.KEY_PRODUCT_ID, null);
    L14:
        if (r5 != null) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
        int r3 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        com.bytedance.kmp.ec.yata.chain.event.b r4 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "product_id is empty", null, null, 57);
    L47:
        r21.invoke(r4);
        return;
    L22:
        String r8 = nc3.a.e(r2, "btm_id", null);
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        String r9 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r8, PageFinder.via(this), new BcmParams());
        Uri.Builder r10 = new Uri.Builder();
        Iterator r7 = r2.entrySet().iterator();
    L27:
        if (r7.hasNext() == false) goto L31;
        Map.Entry r11 = (Map.Entry) r7.next();
        if ((!Intrinsics.areEqual(r11.getKey(), "btm_id")) == false) goto L27;
        r10.appendQueryParameter(String.valueOf(r11.getKey()), String.valueOf(r11.getValue()));
        goto L27
    L31:
        if (r9 == null) goto L49;
        r10.appendQueryParameter("source_btm_token", r9);
    L49:
        CommentParams r12 = this.e.a;     // Catch: JSONException -> L44
        if (r12 == null) goto L41;
        CommentLogParams r13 = r12.getLogParams();     // Catch: JSONException -> L44
        if (r13 == null) goto L41;
        String r14 = r13.getEntranceInfo();     // Catch: JSONException -> L44
        if (r14 == null) goto L41;
        JSONObject r15 = com.bytedance.android.shopping.extensions.k.w(r14);     // Catch: JSONException -> L44
        if (r15 == null) goto L41;
    L42:
        r15.put(PdpOpenThirdParam.KEY_SOURCE_PAGE, "shop_comment_card");     // Catch: JSONException -> L44
        r15.put("ecom_entrance_form", "product_card");     // Catch: JSONException -> L44
        r15.put("ecom_group_type", "product_card");     // Catch: JSONException -> L44
        r15.remove("group_id");     // Catch: JSONException -> L44
        r15.remove(PdpOpenThirdParam.KEY_PROMOTION_ID);     // Catch: JSONException -> L44
        r15.remove("anchor_id");     // Catch: JSONException -> L44
        r15.remove("author_id");     // Catch: JSONException -> L44
        r15.remove("room_id");     // Catch: JSONException -> L44
        r15.remove("flash_type");     // Catch: JSONException -> L44
        r15.remove("apt_path_id");     // Catch: JSONException -> L44
        String r16 = r15.toString();     // Catch: JSONException -> L44
        JSONObject r17 = new JSONObject();     // Catch: JSONException -> L44
        r17.put("entrance_info", d(r16));     // Catch: JSONException -> L44
        r10.appendQueryParameter("meta_params", r17.toString());     // Catch: JSONException -> L44
    L46:
        ECAnchorV3Helper r22 = ECAnchorV3Helper.a;
        ECAnchorV3Helper.k(this.d, r10.toString(), false, false);
        int r23 = com.bytedance.android.ec.core.monitor.e.a;
        com.bytedance.android.ec.core.monitor.e.a(r10.build());
        int r24 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r4 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L41:
        r15 = new JSONObject();     // Catch: JSONException -> L44
    L44:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.a("CommentAbsCommonChainEventImpl").b("handleInner", e);
        int r25 = ic3.e.a;
        ic3.e.a.a(this.c, EventName.ERROR.getEvent(), "", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: CommentAbsCommonChainEventImpl, method: handleInner, exception: " + e.getMessage())}), null, null, 240);
        goto L46
    L16:
        if (r5.length() == 0) goto L19;
        r6 = false;
        goto L20
    L12:
        r5 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }
}
