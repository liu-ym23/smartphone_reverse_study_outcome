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
public final class h5 {
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
        WebView r7 = r9.getWeb().getWebView();
        if (b(r8, r4, r2) == true) goto L16;
        return false;
    L16:
        if (((e4) r9.getHostAbility(e4.class)).getDocumentMetadata().isDocumentType(sbb.e.i) == false) goto L19;
        ((com.bytedance.ee.bear.share.b) org.koin.java.a.a(com.bytedance.ee.bear.share.b.class)).a(r5, r8);
    L18:
        return true;
    L19:
        Uri r10 = UriProtector.parse(r8);
        String r11 = r10.getFragment();
        if (TextUtils.isEmpty(r11) == false) goto L27;
        String r12 = UriProtector.getQueryParameter(r10, "comment_anchor");
        String r13 = UriProtector.getQueryParameter(r10, "comment_id");
        if ("true".equalsIgnoreCase(r12) == true) goto L24;
    L26:
        Toast.showWarningText(r5, r0, 0);
        goto L18
    L24:
        if (TextUtils.isEmpty(r13) == true) goto L26;
        tt5.a.h("JumpUrlHelper", "jump to comment: " + r13);
        JSONObject r14 = new JSONObject();
        r14.put("commentId", r13);
        r14.put(DocRedirectToDocxPlugin.FROM, "anchor");
        ap5.a.a(r7, "javascript:lark.biz.comment.activate", r14, null);
        goto L18
    L27:
        tt5.a.h("JumpUrlHelper", "checkJumpDocIsSame()");
        if (r11.contains("?") == false) goto L31;
        r11 = r11.substring(0, r11.indexOf("?"));
    L31:
        if (r11.equals("appeal") == true) goto L37;
        JSONObject r16 = new JSONObject();
        r16.put("hash", r11);
        ap5.a.a(r7, "javascript:window.lark.biz.navigation.jump", r16, null);
        goto L18
    L37:
        return false;
    L12:
        r2 = false;
        goto L13
    L8:
        r4 = r1.getDocumentMetadata().getUrl();
        goto L10
    }

    public static boolean b(String r3, String r4, boolean r5) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        tt5.a.e("JumpUrlHelper", "Empty url !", new IllegalStateException(), false);
        return false;
    L7:
        if (s45.p.a().Ha(r4, r3) == true) goto L10;
        return false;
    L10:
        if (r5 == true) goto L19;
        boolean r6 = s45.p.a().L5(r4);
        if (r6 == s45.p.a().L5(r3)) goto L14;
        return false;
    L14:
        boolean r7 = s45.p.a().H3(r4, r3);
        if (r6 == false) goto L17;
        if (r7 == true) goto L17;
        return false;
    L17:
        return true;
    L19:
        return true;
    }
}
