package com.obric.assistant.guide.ui;

import android.os.Build;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import com.obric.assistant.impl.databinding.ObricActivityRecordAudioRuleWebviewBinding;

/* JADX INFO: loaded from: classes33.dex */
public final class z extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricActivityRecordAudioRuleWebviewBinding f389404a;

    public z(ObricActivityRecordAudioRuleWebviewBinding r100) {
        this.f389404a = r100;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r101) {
        if (r101 != 100) goto L5;
        this.f389404a.f389452c.setVisibility(4);
        this.f389404a.f389452c.setProgress(0);
        return;
    L5:
        this.f389404a.f389452c.setVisibility(0);
        if (Build.VERSION.SDK_INT < 24) goto L8;
        this.f389404a.f389452c.setProgress(r101, true);
        return;
    L8:
        this.f389404a.f389452c.setProgress(r101);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        TextView r102 = this.f389404a.f389453d;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.setText(r101);
    }
}
