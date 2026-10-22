package com.bytedance.ee.bear.document.sharewords.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailRequest;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lark.dependency.t;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public static final /* synthetic */ int b = 0;
    public t35.a a;

    public static final class a {
    }

    static {
    }

    public i() {
    }

    public static t b() {
        return (t) e0c.k.a(LarkContext.getApplication(), t.class);
    }

    public static final void a(i r8, Context r9, Bundle r10, ShareWordsThumbnailRequest r11, com.bytedance.ee.bear.document.sharewords.b r12, HashMap r13, RichText r14) {
        r8.getClass();
        tt5.a.h("ShareWordsForwardComponent", "trySendComment()... showCommentEntry: " + r11.e + ", COMMENT_CHECK: " + r10.getString("COMMENT_CHECK") + ", targetSuccess.size: " + r13.size());
        t35.a r0 = r8.a;
        if (r0 == null) goto L12;
        if (TextUtils.equals(DiagramData$RESULT.SUCCESS, r10.getString("COMMENT_CHECK")) == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        HashMap r5 = new HashMap();
        r5.put("click", "click_send");
        r5.put("target", "none");
        r5.put("is_select_support_msg_comment_option", Boolean.valueOf(r4));
        r0.a("ccm_doc_block_share_to_chat_select_click", r5);
        tt5.a.h("ShareWordsAnalytic", "reportForwardClick " + r4);
        goto L12
    L7:
        if (r11.e == false) goto L9;
        r4 = true;
    L12:
        if (TextUtils.equals(DiagramData$RESULT.SUCCESS, r10.getString("COMMENT_CHECK")) == true) goto L14;
    L25:
        Toast.cancelLoading();
        if (r13.size() <= 0) goto L31;
        int r16 = r13.size();
        ForwardTarget r17 = (ForwardTarget) CollectionsKt.firstOrNull(r13.values());
        if (r16 != 1) goto L30;
        com.bytedance.ee.util.ui.j.f(new j(r9, r16, r17, r8));
        return;
    L30:
        com.bytedance.ee.util.ui.j.f(new j(r9, r16, null, r8));
        return;
    L31:
        com.bytedance.ee.util.ui.j.f(new k(r9));
        return;
    L14:
        if (r11.e == false) goto L25;
        if (r13.isEmpty() == true) goto L24;
        ForwardTarget r18 = (ForwardTarget) CollectionsKt.firstOrNull(r13.values());
        if (r18 == null) goto L22;
        String r19 = r18.a;
        if (r19 == null) goto L22;
    L23:
        r12.a(r19, CollectionsKt.toList(r13.values()), r14).subscribe(new l(r8, r9, r13), m.a);
        return;
    L22:
        r19 = "";
        goto L23
    L24:
        Toast.cancelLoading();
        UDToast.show(r9, 2131889076);
    }
}
