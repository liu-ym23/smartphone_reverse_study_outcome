package com.bytedance.ee.bear.document;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k5 {
    public static boolean a(String r8, WebPluginHost r9) {
        String r0 = r9.getContext().getString(2131887671);
        e4 r1 = (e4) r9.getHostAbilityOrNull(e4.class);
        if (r1 != null) goto L6;
        tt5.a.e("JumpUrlHelper", "EditorAbility is null !", new IllegalStateException(), false);
        return false;
    L6:
        if (s45.p.a().na(r8, sbb.e.n.getType()) == false) goto L8;
        String r4 = r1.getDocumentMetadata().getOriginUrl();
    L10:
        if (r1.getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L12;
        boolean r2 = true;
    L13:
        Context r5 = r9.getContext();
        WebView r10 = r9.getWeb().getWebView();
        if (TextUtils.isEmpty(r8) == false) goto L17;
        tt5.a.e("JumpUrlHelper", "Empty url !", new IllegalStateException(), false);
    L27:
        boolean r3 = false;
    L29:
        if (r3 == false) goto L48;
        Uri r11 = UriProtector.parse(r8);
        String r6 = r11.getFragment();
        if (TextUtils.isEmpty(r6) == false) goto L38;
        String r7 = UriProtector.getQueryParameter(r11, "comment_anchor");
        String r12 = UriProtector.getQueryParameter(r11, "comment_id");
        if ("true".equalsIgnoreCase(r7) == true) goto L35;
    L37:
        Toast.showWarningText(r5, r0, 0);
    L45:
        return true;
    L35:
        if (TextUtils.isEmpty(r12) == true) goto L37;
        tt5.a.h("JumpUrlHelper", "jump to comment: " + r12);
        JSONObject r13 = new JSONObject();
        r13.put("commentId", r12);
        r13.put(DocRedirectToDocxPlugin.FROM, "anchor");
        ap5.a.a(r10, "javascript:lark.biz.comment.activate", r13, null);
        goto L45
    L38:
        tt5.a.h("JumpUrlHelper", "checkJumpDocIsSame()");
        if (r6.contains("?") == false) goto L42;
        r6 = r6.substring(0, r6.indexOf("?"));
    L42:
        if (r6.equals("appeal") == true) goto L49;
        JSONObject r14 = new JSONObject();
        r14.put("hash", r6);
        ap5.a.a(r10, "javascript:window.lark.biz.navigation.jump", r14, null);
        goto L45
    L49:
        return false;
    L48:
        return false;
    L17:
        if (s45.p.a().Ha(r4, r8) == false) goto L27;
        if (r2 == true) goto L28;
        boolean r16 = s45.p.a().L5(r4);
        if (r16 != s45.p.a().L5(r8)) goto L27;
        boolean r17 = s45.p.a().H3(r4, r8);
        if (r16 == false) goto L28;
        if (r17 == false) goto L27;
    L28:
        r3 = true;
        goto L29
    L12:
        r2 = false;
        goto L13
    L8:
        r4 = r1.getDocumentMetadata().getUrl();
        goto L10
    }
}
