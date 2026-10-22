package com.bytedance.ee.bear.document.plugin.selection;

import android.content.ClipData;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.supervisor.token.Token;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends WebChromeClient {
    public b() {
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView r100, String r101, String r102, String r103, JsPromptResult r104) {
        if ("lark.biz.clipboard.getClipboard".equals(r102) == false) goto L27;
        JSONObject r105 = new JSONObject();
        ClipData r106 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).k(r103, new Token("LARK-PSDA-ccm_android_web_get_clipboard_sync"));     // Catch: Exception -> L22
        if (r106 != null) goto L8;
    L24:
        r104.confirm(r105.toString());
        return true;
    L8:
        if (r106.getItemCount() <= 0) goto L24;
        ClipData.Item r107 = r106.getItemAt(0);     // Catch: Exception -> L22
        if (r107 == null) goto L24;
        String r108 = "";
        if (r107.getText() != null) goto L15;
        String r109 = "";
    L16:
        r105.put("public.utf8-plain-text", r109);     // Catch: Exception -> L22
        if (r107.getHtmlText() == null) goto L20;
        r108 = r107.getHtmlText();     // Catch: Exception -> L22
    L20:
        r105.put("public.html", r108);     // Catch: Exception -> L22
        goto L24
    L15:
        r109 = String.valueOf(r107.getText());     // Catch: Exception -> L22
    L22:
        e = move-exception;
        tt5.a.e("ClipboardWebChromeClient", "lark.biz.clipboard.getClipboard", e, false);
        goto L24
    L27:
        return super.onJsPrompt(r100, r101, r102, r103, r104);
    }
}
