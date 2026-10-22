package com.bytedance.android.shopping.deepfeed.slice.view.comment;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.deepfeed.ui.view.CommentItemView;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import he3.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedSlcCommentItemManager extends com.bytedance.android.ecom.arch.slice.render.elements.b<CommentItemView> {
    public final Lazy H3;
    public String I3;
    public Map<String, ? extends Object> J3;
    public String K3;
    public Map<String, ? extends Object> L3;
    public String M3;
    public Map<String, ? extends Object> N3;

    public DeepFeedSlcCommentItemManager(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateCtx");
        super(r2);
        this.H3 = LazyKt.lazy(DeepFeedSlcCommentItemManager$imageCallerContext$2.INSTANCE);
        this.I3 = "";
        this.K3 = "";
        this.M3 = "";
    }

    public final void H0(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "props");
        Object r0 = r10.get("content");
        Map<String, ? extends Object> r2 = null;
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map<String, ? extends Object> r1 = (Map) r0;
        if (r1 != null) goto L8;
        r1 = r10;
    L8:
        Object r3 = r1.get("comment_id");
        if ((r3 instanceof String) == true) goto L11;
        r3 = null;
    L11:
        String r4 = (String) r3;
        Object r5 = r1.get("text");
        if ((r5 instanceof String) == true) goto L14;
        r5 = null;
    L14:
        String r6 = (String) r5;
        Object r7 = r1.get("user_name");
        if ((r7 instanceof String) == true) goto L17;
        r7 = null;
    L17:
        String r8 = (String) r7;
        Object r9 = r1.get("user_avatar");
        if ((r9 instanceof Map) == true) goto L20;
        r9 = null;
    L20:
        ImageURL r11 = q1((Map) r9);
        Object r12 = r1.get("user_icon");
        if ((r12 instanceof Map) == true) goto L23;
        r12 = null;
    L23:
        f r13 = new f(r4, r6, r8, r11, q1((Map) r12));
        Object r14 = r10.get("showMore");
        boolean r15 = true;
        if ((r14 instanceof Boolean) == false) goto L27;
        boolean r16 = ((Boolean) r14).booleanValue();
    L41:
        Pair<String, Map<String, Object>> r17 = p1(r10.get("avatarAction"));
        String r18 = "";
        if (r17 == null) goto L45;
        String r19 = (String) r17.getFirst();
        if (r19 == null) goto L45;
    L46:
        this.I3 = r19;
        if (r17 == null) goto L49;
        Map<String, ? extends Object> r20 = (Map) r17.getSecond();
    L50:
        this.J3 = r20;
        Pair<String, Map<String, Object>> r21 = p1(r10.get("textAction"));
        if (r21 == null) goto L54;
        String r22 = (String) r21.getFirst();
        if (r22 == null) goto L54;
    L55:
        this.K3 = r22;
        if (r21 == null) goto L58;
        Map<String, ? extends Object> r23 = (Map) r21.getSecond();
    L59:
        this.L3 = r23;
        Pair<String, Map<String, Object>> r110 = p1(r10.get("moreAction"));
        if (r110 == null) goto L65;
        String r24 = (String) r110.getFirst();
        if (r24 == null) goto L65;
        r18 = r24;
    L65:
        this.M3 = r18;
        if (r110 == null) goto L68;
        r2 = (Map) r110.getSecond();
    L68:
        this.N3 = r2;
        CommentItemView r111 = (CommentItemView) k1();
        if (r111 == null) goto L84;
        r111.a(r13, (r) this.H3.getValue(), r16);
        if (this.I3.length() <= 0) goto L73;
        boolean r25 = true;
    L75:
        if (this.K3.length() <= 0) goto L77;
        boolean r26 = true;
    L79:
        if (this.M3.length() > 0) goto L82;
        r15 = false;
    L82:
        r111.setClickable(false);
        r111.a.setClickable(r25);
        r111.h.setClickable(r26);
        r111.g.setClickable(r15);
        return;
    L77:
        r26 = false;
        goto L79
    L73:
        r25 = false;
        goto L75
    L84:
        return;
    L58:
        r23 = null;
    L54:
        r22 = "";
        goto L55
    L49:
        r20 = null;
    L45:
        r19 = "";
        goto L46
    L27:
        if ((r14 instanceof Integer) == false) goto L30;
        r16 = Intrinsics.areEqual(r14, 1);
        goto L41
    L30:
        if ((r14 instanceof Long) == false) goto L33;
        r16 = Intrinsics.areEqual(r14, 1L);
        goto L41
    L33:
        if ((r14 instanceof String) == true) goto L35;
    L40:
        r16 = true;
        goto L41
    L35:
        if (Intrinsics.areEqual(r14, "1") == true) goto L40;
        if (StringsKt.equals((String) r14, "true", true) == true) goto L40;
        r16 = false;
        goto L41
    }

    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        final CommentItemView r0 = new CommentItemView(r5, null, 6, 0);
        r0.setCommentAreaClickEnabled(false);
        r0.setOnCommentAreaClickListener(new DeepFeedSlcCommentItemManager$onCreateContentView$$inlined$apply$lambda$1(r0, this));
        return r0;
    }

    public final Pair<String, Map<String, Object>> p1(Object r4) {
        Object r1 = null;
        if ((r4 instanceof Map) == true) goto L5;
        r4 = null;
    L5:
        Map r5 = (Map) r4;
        if (r5 != null) goto L8;
        return null;
    L8:
        Object r0 = r5.get("type");
        if ((r0 instanceof String) == true) goto L11;
        r0 = null;
    L11:
        String r2 = (String) r0;
        if (r2 != null) goto L14;
        return null;
    L14:
        Object r6 = r5.get("fields");
        if ((r6 instanceof Map) == false) goto L19;
        r1 = r6;
    L19:
        return TuplesKt.to(r2, (Map) r1);
    }

    public final ImageURL q1(Map<String, ? extends Object> r8) {
        ArrayList r0 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        Object r2 = r8.get("uri");
        if ((r2 instanceof String) == true) goto L8;
        r2 = null;
    L8:
        String r3 = (String) r2;
        Object r4 = r8.get("url_list");
        if ((r4 instanceof List) == true) goto L11;
        r4 = null;
    L11:
        List r5 = (List) r4;
        if (r5 == null) goto L24;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L22;
        Object r9 = r7.next();
        if ((r9 instanceof String) == true) goto L19;
        r9 = null;
    L19:
        String r10 = (String) r9;
        if (r10 == null) goto L15;
        r6.add(r10);
        goto L15
    L22:
        r0 = r6;
    L24:
        return new ImageURL(r3, r0, r1(r8, "width"), r1(r8, "height"));
    }

    public static Integer r1(Map r0, String r1) {
        Object r2 = r0.get(r1);
        if ((r2 instanceof Integer) == false) goto L6;
        return (Integer) r2;
    L6:
        if ((r2 instanceof Long) == false) goto L9;
        return Integer.valueOf((int) ((Number) r2).longValue());
    L9:
        if ((r2 instanceof Float) == false) goto L12;
        return Integer.valueOf((int) ((Number) r2).floatValue());
    L12:
        if ((r2 instanceof Double) == false) goto L15;
        return Integer.valueOf((int) ((Number) r2).doubleValue());
    L15:
        if ((r2 instanceof String) == true) goto L23;
        return null;
    L23:
        return StringsKt.toIntOrNull((String) r2);
    }

    public static final void o1(DeepFeedSlcCommentItemManager r1, String r2, Map r3, CommentItemView r4) {
        r1.getClass();
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L16;
        Object r5 = ((BaseSlcViewManager) r1).a.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r5 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == true) goto L11;
        r5 = null;
    L11:
        com.bytedance.android.shopping.deepfeed.slice.service.b r6 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r5;
        if (r6 == null) goto L15;
        r6.O(r2, r3, r4);
        return;
    L15:
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
