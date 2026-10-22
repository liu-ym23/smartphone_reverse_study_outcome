package com.bytedance.ee.bear.document.sharewords.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailRequest;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lark.dependency.t;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f221840b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t35.a f221841a;

    public static final class a {
    }

    static {
    }

    public i() {
    }

    public static t b() {
        return (t) e0c.k.a(LarkContext.getApplication(), t.class);
    }

    public static final void a(i r100, Context r101, Bundle r110, ShareWordsThumbnailRequest r111, com.bytedance.ee.bear.document.sharewords.b r112, HashMap r113, RichText r114) {
        r100.getClass();
        tt5.a.h("ShareWordsForwardComponent", "trySendComment()... showCommentEntry: " + r111.f221791e + ", COMMENT_CHECK: " + r110.getString("COMMENT_CHECK") + ", targetSuccess.size: " + r113.size());
        t35.a r102 = r100.f221841a;
        if (r102 == null) goto L12;
        if (TextUtils.equals("1", r110.getString("COMMENT_CHECK")) == true) goto L7;
    L9:
        boolean r103 = false;
    L10:
        HashMap r104 = new HashMap();
        r104.put("click", "click_send");
        r104.put(PickerReporterConstants.KEY.TARGET, "none");
        r104.put("is_select_support_msg_comment_option", Boolean.valueOf(r103));
        r102.a("ccm_doc_block_share_to_chat_select_click", r104);
        tt5.a.h("ShareWordsAnalytic", "reportForwardClick " + r103);
        goto L12
    L7:
        if (r111.f221791e == false) goto L9;
        r103 = true;
    L12:
        if (TextUtils.equals("1", r110.getString("COMMENT_CHECK")) == true) goto L14;
    L25:
        Toast.cancelLoading();
        if (r113.size() <= 0) goto L31;
        int r115 = r113.size();
        ForwardTarget r116 = (ForwardTarget) CollectionsKt.firstOrNull(r113.values());
        if (r115 != 1) goto L30;
        com.bytedance.ee.util.ui.j.f(new j(r101, r115, r116, r100));
        return;
    L30:
        com.bytedance.ee.util.ui.j.f(new j(r101, r115, null, r100));
        return;
    L31:
        com.bytedance.ee.util.ui.j.f(new k(r101));
        return;
    L14:
        if (r111.f221791e == false) goto L25;
        if (r113.isEmpty() == true) goto L24;
        ForwardTarget r117 = (ForwardTarget) CollectionsKt.firstOrNull(r113.values());
        if (r117 == null) goto L22;
        String r118 = r117.f424780a;
        if (r118 == null) goto L22;
    L23:
        r112.a(r118, CollectionsKt.toList(r113.values()), r114).subscribe(new l(r100, r101, r113), m.f221853a);
        return;
    L22:
        r118 = "";
        goto L23
    L24:
        Toast.cancelLoading();
        UDToast.show(r101, R.string.LarkCCM_Docs_FwdSection_Failed_Toast);
    }
}
