package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.app.Activity;
import android.content.Context;
import android.util.AndroidRuntimeException;
import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.data.ReportType;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends com.bytedance.android.shopping.commentv3.event_chain.a {
    public final t96.b d;
    public final com.bytedance.android.shopping.commentv3.data.b e;
    public final ic3.d f;

    public final t96.b a() {
        return this.d;
    }

    public n(Context r2, com.bytedance.android.shopping.commentv3.data.b r3, ic3.d r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.TRACKER.getType());
        this.e = r3;
        this.f = r4;
        this.d = new t96.b(true, CollectionsKt.listOf("params"), true);
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r22, fc3.a r23, fc3.c r24, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r25) {
        Intrinsics.checkNotNullParameter(r22, "eventContext");
        Intrinsics.checkNotNullParameter(r23, "actionContext");
        Intrinsics.checkNotNullParameter(r24, "handleActionParams");
        Intrinsics.checkNotNullParameter(r25, "completion");
        Map r1 = r22.k;
        if (r1 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        int r2 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        com.bytedance.kmp.ec.yata.chain.event.b r3 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "params invalid, fields is empty", null, null, 57);
    L168:
        r25.invoke(r3);
        return;
    L11:
        Object r7 = r1.get("event_name");
        Object r8 = null;
        if ((r7 instanceof String) == true) goto L14;
        r7 = null;
    L14:
        String r9 = (String) r7;
        Object r10 = r1.get("params");
        if ((r10 instanceof Map) == true) goto L17;
        r10 = null;
    L17:
        Map r11 = (Map) r10;
        if (r11 != null) goto L20;
        r11 = new LinkedHashMap();
    L20:
        Boolean r12 = nc3.a.a(r1, "allow_duplicate", null);
        String r13 = nc3.a.e(r1, "duplicate_key", "");
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        int r14 = nc3.a.b(r1, "report_type", 0);
        String r4 = nc3.a.e(r1, "btm_id", null);
        if (r4 != null) goto L26;
        r4 = "";
    L26:
        if (r9 != null) goto L28;
    L31:
        boolean r15 = true;
    L32:
        if (r15 == true) goto L167;
        if (r12 == null) goto L167;
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r17 = r11.entrySet().iterator();
    L37:
        if (r17.hasNext() == false) goto L55;
        Map.Entry r18 = (Map.Entry) r17.next();
        Object r19 = r18.getKey();
        if ((r19 instanceof String) == true) goto L41;
        r19 = r8;
    L41:
        String r110 = (String) r19;
        if (r110 != null) goto L44;
    L47:
        boolean r5 = true;
    L48:
        if (r5 == true) goto L37;
        Object r20 = r18.getValue();
        if ((r20 instanceof Double) == false) goto L52;
        String r21 = String.valueOf((int) ((Number) r20).doubleValue());
    L53:
        r16.put(r110, r21);
        r12 = r12;
        r8 = null;
        goto L37
    L52:
        r21 = String.valueOf(r20);
        goto L53
    L44:
        if (r110.length() == 0) goto L47;
        r5 = false;
        goto L48
    L55:
        Boolean r111 = r12;
        LinkedHashMap r26 = new LinkedHashMap();
        Map<String, String> r27 = this.e.g;
        if (r27 == null) goto L59;
        r26.putAll(r27);
    L59:
        if ((!Intrinsics.areEqual(r9, "comment_key_word_show")) == true) goto L61;
    L93:
        String r112 = "";
    L94:
        CommentParams r28 = this.e.a;
        if (r28 == null) goto L98;
        String r29 = r28.getBusinessType();
        if (r29 == null) goto L98;
    L99:
        r26.put("business_type", r29);
        if (this.e.c() == false) goto L102;
        String r30 = "pic";
    L103:
        r26.put("comment_switch_type", r30);
        List<?> r31 = this.e.h.c();
        if (r31 == null) goto L106;
        int r32 = r31.size();
    L107:
        r26.put("filter_module_item_count", String.valueOf(r32));
        r16.putAll(r26);
        ic3.d r33 = this.f;
        if (r33 == null) goto L165;
        boolean r34 = r111.booleanValue();
        View r35 = r24.b;
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r13, "duplicateKey");
        Intrinsics.checkNotNullParameter(r16, "bizTrackParams");
        Intrinsics.checkNotNullParameter(r4, "btmId");
        if (r34 == false) goto L112;
    L114:
        ((ArrayList) r33.c).add(r13);
        Lazy r36 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L117;
        TrackCatcher.c("watch_comment", r9, r112);
    L117:
        LinkedHashMap r37 = new LinkedHashMap();
        r37.putAll(r33.a);
        r37.putAll(r33.b);
        r37.put("tab_id", String.valueOf(r33.e.e.b.f()));
        r37.put("tag_type", String.valueOf(r33.e.e.b.g()));
        r37.putAll(r16);
        ReportType.Companion.getClass();
        ReportType r38 = ReportType.SHOW;
        if (r14 != r38.getType()) goto L120;
    L123:
        boolean r39 = true;
    L124:
        if (r39 == false) goto L147;
        if (r35 == null) goto L165;
        if (r14 != r38.getType()) goto L130;
        String r40 = r4;
    L131:
        ic3.b r41 = new ic3.b(r37);
        if (r4.length() != 0) goto L134;
        boolean r113 = true;
    L135:
        if (r113 == false) goto L137;
        ExtKt.b("BstItemCreate", "btm is empty!");
    L137:
        com.bytedance.android.bst.api.d r42 = new com.bytedance.android.bst.api.d(r35);
        r42.a = r4;
        if (r9 == null) goto L146;
        r42.b = r9;
        r42.c = r40;
        r42.d = "shopping";
        r42.e = -1;
        r42.f = r41;
        if (r14 != r38.getType()) goto L143;
        r35.post(new ic3.c(r42));
        goto L165
    L143:
        if (r14 != ReportType.CLICK.getType()) goto L165;
        com.bytedance.android.bst.api.f.b.getClass();
        com.bytedance.android.bst.api.f.c(r42);
        goto L165
    L146:
        throw new AndroidRuntimeException("event is empty");
    L134:
        r113 = false;
        goto L135
    L130:
        r40 = null;
        goto L131
    L147:
        if (r35 == null) goto L149;
        Context r43 = r35.getContext();
    L151:
        if ((r43 instanceof Activity) == true) goto L153;
        r43 = null;
    L153:
        Activity r44 = (Activity) r43;
        if (r4.length() <= 0) goto L156;
        boolean r45 = true;
    L157:
        if (r45 == false) goto L164;
        if (r44 == null) goto L164;
        Iterator r46 = BtmSDK.INSTANCE.createReportParams(r4, PageFinder.via(r44)).entrySet().iterator();
    L161:
        if (r46.hasNext() == false) goto L163;
        Map.Entry r47 = (Map.Entry) r46.next();
        r37.put(r47.getKey(), String.valueOf(r47.getValue()));
        goto L161
    L163:
        Map r48 = null;
        new ic3.a(r9, r37).post(null, null);
    L166:
        int r49 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r3 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, r48, r48, 7);
    L164:
        r48 = null;
        new ic3.a(r9, r37).post(null, null);
        goto L166
    L156:
        r45 = false;
        goto L157
    L149:
        r43 = null;
        goto L151
    L120:
        if (r14 == ReportType.CLICK.getType()) goto L123;
        r39 = false;
        goto L124
    L112:
        if (((ArrayList) r33.c).contains(r13) == false) goto L114;
    L165:
        r48 = null;
        goto L166
    L106:
        r32 = 0;
        goto L107
    L102:
        r30 = "list";
    L98:
        r29 = r112;
        goto L99
    L61:
        if ((!Intrinsics.areEqual(r9, "comment_key_word_click")) == false) goto L93;
        mc3.a r50 = this.e.e.b;
        if (r50.c() == false) goto L69;
        Object r51 = r50.e().get("name");
        if ((r51 instanceof String) == true) goto L67;
        r51 = null;
    L67:
        String r52 = (String) r51;
        if (r52 == null) goto L69;
    L71:
        if (r50.c() == false) goto L73;
    L72:
        String r53 = "";
    L79:
        r112 = "";
        long r114 = nc3.a.c(r50.e(), "sentiment", 1);
        if (r50.c() == false) goto L83;
    L91:
        String r54 = r112;
    L92:
        LinkedHashMap r55 = new LinkedHashMap();
        r55.put("tab_name", r52);
        r55.put("tag_name", r53);
        r55.put("if_positive", r54);
        r26.putAll(r55);
        goto L94
    L83:
        if (r114 != 1) goto L86;
        r54 = "positive";
        goto L92
    L86:
        if (r114 != 0) goto L89;
        r54 = "neutral";
        goto L92
    L89:
        if (r114 != (-1)) goto L91;
        r54 = "negative";
        goto L92
    L73:
        Object r56 = r50.e().get("name");
        if ((r56 instanceof String) == true) goto L76;
        r56 = null;
    L76:
        r53 = (String) r56;
        if (r53 != null) goto L79;
    L69:
        r52 = "";
    L167:
        dm.a.a("CommentAbsCommonChainEventImpl").i("params invalid, event: " + r9 + ", allowDuplicate: " + r12);
        int r57 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r3 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "params invalid, event: " + r9 + ", allowDuplicate: " + r12, null, null, 57);
        goto L168
    L28:
        if (r9.length() == 0) goto L31;
        r15 = false;
        goto L32
    L5:
        if (r1.isEmpty() == true) goto L8;
        r6 = false;
        goto L9
    }
}
