package com.obric.assistant.guide.ui;

import android.content.Intent;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.net.MailTo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricActivityRecordAudioRuleWebviewBinding;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class y extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricRecordAudioRuleWebViewActivity f389402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ObricActivityRecordAudioRuleWebviewBinding f389403b;

    public y(ObricRecordAudioRuleWebViewActivity r100, ObricActivityRecordAudioRuleWebviewBinding r101) {
        this.f389402a = r100;
        this.f389403b = r101;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        this.f389403b.f389452c.setVisibility(4);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        if (Build.VERSION.SDK_INT < 26) goto L12;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L11;
        String r103 = "crashed";
    L13:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("Render process ");
        r105.append(r103);
        r105.append(". WebView URL: ");
        if (r100 == null) goto L16;
        String r106 = r100.getUrl();
    L17:
        r105.append(r106);
        r104.e("ObricRecordAudioRuleWebViewActivity", r105.toString());
        return true;
    L16:
        r106 = null;
        goto L17
    L11:
        r103 = "killed by system";
        goto L13
    L7:
        if (r101.didCrash() != true) goto L9;
        r102 = true;
        goto L9
    L12:
        r103 = "unknown reason";
        goto L13
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "request");
        String r102 = r101.getUrl().toString();
        if (StringsKt.startsWith$default(r102, MailTo.MAILTO_SCHEME, false, 2, null) == false) goto L8;
        Intent r103 = new Intent("android.intent.action.SENDTO", UriProtector.parse(r102));
        if (r103.resolveActivity(this.f389402a.getPackageManager()) == null) goto L7;
        this.f389402a.startActivity(r103);
    L7:
        return true;
    L8:
        r100.loadUrl(r102);
        return true;
    }
}
