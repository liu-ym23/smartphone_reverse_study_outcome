package com.bytedance.android.shopping.store.slicecard;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class d implements com.bytedance.android.ecom.arch.slice.render.b {
    public final Set<String> a;
    public final com.bytedance.android.ec.core.event.c b;

    public void c(IAction r1, View r2) {
        throw null;
    }

    public IAction d(IAction r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return r2;
    }

    public d(com.bytedance.android.ec.core.event.c r2) {
        Intrinsics.checkNotNullParameter(r2, "eventAction");
        this.b = r2;
        this.a = new LinkedHashSet();
    }

    public final void a(r r2) {
        Intrinsics.checkNotNullParameter(r2, "actionInfo");
        b(r2.a, r2.d);
    }

    public final void b(IAction r14, View r15) {
        Intrinsics.checkNotNullParameter(r14, "action");
        Intrinsics.checkNotNullParameter(r15, "targetView");
        dm.a.a("ShopBaseSlcActionHandler").a("action type: " + r14.getType() + ", param: " + r14.getParams());
        IAction r16 = d(r14);
        String r1 = r16.getType();
        SliceActionType r2 = SliceActionType.GROUP;
        if (Intrinsics.areEqual(r1, r2.getType()) == true) goto L5;
        SliceActionType r3 = SliceActionType.TOAST;
        if (Intrinsics.areEqual(r1, r3.getType()) == true) goto L29;
        SliceActionType r4 = SliceActionType.TRACK;
        String r6 = "";
        if (Intrinsics.areEqual(r1, r4.getType()) == true) goto L35;
        SliceActionType r5 = SliceActionType.OPEN_SCHEMA;
        if (Intrinsics.areEqual(r1, r5.getType()) == true) goto L59;
        c(r16, r15);
        return;
    L59:
        if ((!Intrinsics.areEqual(r16.getType(), r5.getType())) == true) goto L84;
        Map r17 = r16.getParams();
        int r7 = f.a;
        Intrinsics.checkNotNullParameter(r15, "targetView");
        String r0 = f.d(r15, r17, "schema");
        String r8 = f.d(r15, r17, "btm_id");
        Intrinsics.checkNotNullParameter("", CommentConstants$CmtLongPanelStrategy.DEFAULT);
        if (r8 == null) goto L65;
        r6 = r8;
    L65:
        String r18 = f.a(r15, r0, r6, f.c(r15, r17, "bcmParams"));
        if (r18 == null) goto L85;
        p.a.openSchema(r15.getContext(), r18);
        return;
    L85:
        return;
    L84:
        return;
    L35:
        if ((!Intrinsics.areEqual(r16.getType(), r4.getType())) == true) goto L82;
        Map r19 = r16.getParams();
        String r9 = f.d(r15, r19, "once_key");
        String r10 = f.d(r15, r19, "event_name");
        if (r10 != null) goto L40;
        String r11 = "";
    L41:
        Map r12 = f.c(r15, r19, "event_params");
        if (r12 != null) goto L44;
        r12 = new LinkedHashMap();
    L44:
        Map r13 = r12;
        String r110 = f.d(r15, r19, "btm_id");
        if (r110 != null) goto L47;
        String r20 = "";
    L49:
        if (cg4.a.a(r9) == true) goto L51;
    L55:
        this.b.doAnyEventActionWithBtm(r20, PageFinder.via(r15), r11, r13, new Pair[0]);
        return;
    L51:
        if (CollectionsKt.contains(this.a, r9) == true) goto L83;
        if (r9 == null) goto L55;
        this.a.add(r9);
        goto L55
    L83:
        return;
    L47:
        r20 = r110;
        goto L49
    L40:
        r11 = r10;
        goto L41
    L82:
        return;
    L29:
        if ((!Intrinsics.areEqual(r16.getType(), r3.getType())) == true) goto L81;
        ECToast.showToast$default(ECToast.INSTANCE, r15.getContext(), com.bytedance.android.ecom.arch.slice.render.util.b.v(r16.getParams(), "message", null), null, 4, null);
        return;
    L81:
        return;
    L5:
        if ((!Intrinsics.areEqual(r16.getType(), r2.getType())) == true) goto L80;
        List r111 = r16.getActions();
        if (r111 == null) goto L76;
        Iterator r112 = r111.iterator();
    L11:
        if (r112.hasNext() == false) goto L86;
        SlcCommonAction r21 = (IAction) r112.next();
        int r22 = f.a;
        if ((r21 instanceof SlcCommonAction) == true) goto L15;
        SlcCommonAction r23 = null;
    L16:
        SlcCommonAction r24 = r23;
        if (r24 == null) goto L19;
        Map r25 = r24.getData();
    L20:
        Intrinsics.checkNotNullParameter(r15, "targetView");
        Intrinsics.checkNotNullParameter("disable", "key");
        Boolean r26 = Boolean.valueOf(mq.b.a(f.b(r15, r25, "disable")));
        if (r26 == null) goto L23;
        boolean r27 = r26.booleanValue();
    L24:
        if (r27 == true) goto L11;
        b(r21, r15);
        goto L11
    L23:
        r27 = r21.getDisable();
        goto L24
    L19:
        r25 = null;
        goto L20
    L15:
        r23 = r21;
        goto L16
    L86:
        return;
    L76:
        return;
    }
}
