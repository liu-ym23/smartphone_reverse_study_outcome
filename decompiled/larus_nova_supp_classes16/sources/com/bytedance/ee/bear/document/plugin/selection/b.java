package com.bytedance.ee.bear.document.plugin.selection;

import android.content.ClipData;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.supervisor.token.Token;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends WebChromeClient {
    public b() {
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView r4, String r5, String r6, String r7, JsPromptResult r8) {
        if ("lark.biz.clipboard.getClipboard".equals(r6) == false) goto L27;
        JSONObject r9 = new JSONObject();
        ClipData r10 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).k(r7, new Token("LARK-PSDA-ccm_android_web_get_clipboard_sync"));     // Catch: Exception -> L22
        if (r10 != null) goto L8;
    L24:
        r8.confirm(r9.toString());
        return true;
    L8:
        if (r10.getItemCount() <= 0) goto L24;
        ClipData.Item r11 = r10.getItemAt(0);     // Catch: Exception -> L22
        if (r11 == null) goto L24;
        String r2 = "";
        if (r11.getText() != null) goto L15;
        String r1 = "";
    L16:
        r9.put("public.utf8-plain-text", r1);     // Catch: Exception -> L22
        if (r11.getHtmlText() == null) goto L20;
        r2 = r11.getHtmlText();     // Catch: Exception -> L22
    L20:
        r9.put("public.html", r2);     // Catch: Exception -> L22
        goto L24
    L15:
        r1 = String.valueOf(r11.getText());     // Catch: Exception -> L22
    L22:
        e = move-exception;
        tt5.a.e("ClipboardWebChromeClient", "lark.biz.clipboard.getClipboard", e, false);
        goto L24
    L27:
        return super.onJsPrompt(r4, r5, r6, r7, r8);
    }
}
