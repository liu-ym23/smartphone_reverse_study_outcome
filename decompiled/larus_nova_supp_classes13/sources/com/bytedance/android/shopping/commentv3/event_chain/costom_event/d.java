package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.comment.view.MeaningLessCommentActivity;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.action.handler.tracker.EventName;
import com.bytedance.android.shopping.commentv3.data.InteractionTypeEnum;
import com.bytedance.android.shopping.commentv3.utils.InteractionPerfMonitor;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public final Context d;
    public final com.bytedance.android.shopping.commentv3.data.b e;

    public d(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.ENTER_MEANINGLESS.getType());
        this.d = r2;
        this.e = r3;
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r21, fc3.a r22, fc3.c r23, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r24) {
        Intrinsics.checkNotNullParameter(r21, "eventContext");
        Intrinsics.checkNotNullParameter(r22, "actionContext");
        Intrinsics.checkNotNullParameter(r23, "handleActionParams");
        Intrinsics.checkNotNullParameter(r24, "completion");
        Map r0 = r21.k;
        if (r0 == null) goto L5;
        Object r1 = r0.get("params");
    L7:
        if ((r1 instanceof Map) == true) goto L9;
        r1 = null;
    L9:
        Map r4 = (Map) r1;
        if (r4 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        int r3 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        com.bytedance.kmp.ec.yata.chain.event.b r5 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "params is null", null, null, 57);
    L99:
        r24.invoke(r5);
        return;
    L18:
        String r6 = "meaningless-" + System.currentTimeMillis();
        InteractionPerfMonitor.j.getClass();
        InteractionPerfMonitor r7 = InteractionPerfMonitor.a.a(r6);
        String r8 = InteractionTypeEnum.CLICK_MEANINGLESS.getType();
        Intrinsics.checkNotNullParameter(r8, "interactionType");
        String r10 = "";
        Intrinsics.checkNotNullParameter("", "interactionContent");
        r7.c = System.currentTimeMillis();
        r7.a = r8;
        r7.b = "";
        Object r9 = r4.get("sku_spec_name");
        ArrayList r11 = new ArrayList();
        if ((r9 instanceof List) == false) goto L26;
        Iterator r12 = ((Iterable) r9).iterator();
    L22:
        if (r12.hasNext() == false) goto L26;
        Object r13 = r12.next();
        if ((r13 instanceof String) == false) goto L22;
        r11.add(r13);
    L26:
        long r14 = this.e.e.b.f();
        boolean r15 = this.e.e.b.c();
        if (o53.b.a() == false) goto L29;
        String r16 = "goods";
    L30:
        String r17 = r16;
        Intent r18 = new Intent(this.d, MeaningLessCommentActivity.class);
        Bundle r19 = new Bundle();
        CommentParams r110 = this.e.a;
        if (r110 == null) goto L37;
        String r111 = r110.getProductId();
        if (r111 == null) goto L37;
        Long r112 = StringsKt.toLongOrNull(r111);
        if (r112 == null) goto L37;
        long r20 = r112.longValue();
    L38:
        r19.putLong(PdpOpenThirdParam.KEY_PRODUCT_ID, r20);
        if (r15 == false) goto L41;
        long r25 = r14;
    L42:
        r19.putLong("stat_id", r25);
        if (r15 == false) goto L45;
        r14 = -1;
    L45:
        r19.putLong("tag_id", r14);
        r19.putString("sku_request_param", CollectionsKt.joinToString$default(r11, "/", null, null, 0, null, null, 62, null));
        r19.putBoolean("is_shop", !o53.b.a());
        CommentParams r26 = this.e.a;
        if (r26 == null) goto L52;
        String r27 = r26.getShopId();
        if (r27 == null) goto L52;
        Long r28 = StringsKt.toLongOrNull(r27);
        if (r28 == null) goto L52;
        long r113 = r28.longValue();
    L53:
        r19.putLong("shop_id", r113);
        r19.putBoolean("need_adapt_addr", true);
        r19.putString("first_filter", this.e.e.b.a());
        r19.putString("second_filter", this.e.e.b.d());
        r18.putExtras(r19);
        r18.putExtra("perf_mob_key", r6);
        r18.putExtra("from_bff", true);
        r18.putExtra("data_type", this.e.a());
        r18.putExtra("type", r17);
        r18.putExtra("sku_spec_name", r11);
        CommentParams r29 = this.e.a;
        if (r29 == null) goto L56;
        Map r30 = r29.getPassedAbParams();
    L57:
        CommentParams r31 = this.e.a;
        if (r31 == null) goto L60;
        Map r32 = r31.getPassedCommentCommonAb();
    L61:
        CommentParams r33 = this.e.a;
        if (r33 == null) goto L65;
        String r34 = CommentParams.getExtraStr$default(r33, null, 1, null);
        if (r34 == null) goto L65;
    L66:
        if (r30 != null) goto L68;
    L71:
        boolean r35 = true;
    L72:
        if (r35 == true) goto L97;
        if (r32 != null) goto L75;
    L78:
        boolean r36 = true;
    L79:
        if (r36 == true) goto L97;
        LinkedHashMap r37 = new LinkedHashMap();
        Iterator r38 = r32.entrySet().iterator();
    L83:
        if (r38.hasNext() == false) goto L87;
        Map.Entry r39 = (Map.Entry) r38.next();
        if ((!Intrinsics.areEqual(r39.getKey(), "bff_ab_value")) == false) goto L83;
        r37.put(r39.getKey(), r39.getValue());
        goto L83
    L87:
        Map r40 = MapsKt.toMutableMap(r37);
        LinkedHashMap r41 = new LinkedHashMap();     // Catch: JSONException -> L95
        r41.putAll(r30);     // Catch: JSONException -> L95
        if (r40.isEmpty() == false) goto L92;
        r41.remove("comment_common_ab");     // Catch: JSONException -> L95
    L93:
        LinkedHashMap r42 = new LinkedHashMap();     // Catch: JSONException -> L95
        r42.put("data_type", Integer.valueOf(this.e.a()));     // Catch: JSONException -> L95
        r42.put("ab_params", com.bytedance.android.ec.hybrid.list.util.k.d(r41));     // Catch: JSONException -> L95
        r10 = com.bytedance.android.ec.hybrid.list.util.k.d(r42);     // Catch: JSONException -> L95
    L98:
        r18.putExtra("extra", r10);
        r18.putExtra("tag_version", nc3.a.c(r4, "tag_version", 0));
        this.d.startActivity(r18);
        int r43 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r5 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L99
    L92:
        r41.put("comment_common_ab", r40);     // Catch: JSONException -> L95
    L95:
        e = move-exception;
        ECExceptionMonitor.e(e);
        dm.a.a("EnterMeaninglessHandler").b("getExtraStr", e);
        int r44 = ic3.e.a;
        ic3.e.a.a(this.c, EventName.ERROR.getEvent(), "", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message", "class: EnterMeaninglessHandler, method: getExtraStr, exception: " + e.getMessage())}), null, null, 240);
        goto L98
    L75:
        if (r32.isEmpty() == true) goto L78;
        r36 = false;
    L97:
        r10 = r34;
        goto L98
    L68:
        if (r30.isEmpty() == true) goto L71;
        r35 = false;
    L65:
        r34 = "";
        goto L66
    L60:
        r32 = null;
        goto L61
    L56:
        r30 = null;
    L52:
        r113 = 0;
        goto L53
    L41:
        r25 = -1;
    L37:
        r20 = 0;
        goto L38
    L29:
        r16 = "shop";
        goto L30
    L12:
        if (r4.isEmpty() == true) goto L15;
        r2 = false;
        goto L16
    L5:
        r1 = null;
        goto L7
    }
}
