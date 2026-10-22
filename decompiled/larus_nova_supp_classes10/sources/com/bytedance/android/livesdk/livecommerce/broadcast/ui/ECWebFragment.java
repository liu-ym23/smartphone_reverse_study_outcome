package com.bytedance.android.livesdk.livecommerce.broadcast.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECWebFragment extends ECBaseDialogFragment<ECWebViewModel> {
    public ImageView i;
    public TextView j;
    public WebView k;
    public String l;
    public String m;

    public class a extends WebChromeClient {
        public final /* synthetic */ ECWebFragment a;

        public a(ECWebFragment r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView r1, String r2) {
            ECWebFragment r3 = this.a;
            r3.l = r2;
            r3.j.setText(r2);
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int Y90() {
        return 3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void da0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void ea0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void fa0() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final int getLayoutId() {
        return 2131560725;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final boolean ha0() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ViewGroup.MarginLayoutParams ba0() {
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, (int) (ECDisplayUtils.a(getContext()) * 0.73f));
        r1.gravity = 80;
        return r1;
    }

    public ECWebFragment() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final ViewModel V90(Fragment r2) {
        return (ECWebViewModel) ViewModelProviders.of(this).get(ECWebViewModel.class);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void aa0(Bundle r2) {
        if (r2 == null) goto L5;
        this.l = r2.getString("title");
        this.m = r2.getString("url");
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment
    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        ((ECWebViewModel) this.g).init();
        View r3 = getView();
        if (r3 == null) goto L6;
        this.i = (ImageView) r3.findViewById(2131376031);
        this.j = (TextView) r3.findViewById(2131391606);
        this.k = (WebView) r3.findViewById(2131393361);
        this.j.setText(this.l);
        this.k.setWebViewClient(new WebViewClient());
        this.k.setWebChromeClient(new a(this));
        WebSettings r4 = this.k.getSettings();
        r4.setJavaScriptEnabled(false);
        r4.setLoadsImagesAutomatically(true);
        this.k.loadUrl(this.m);
        this.i.setOnClickListener(this);
    L6:
        ((ECWebViewModel) this.g).start();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.base.ECBaseDialogFragment, android.view.View.OnClickListener
    public final void onClick(View r2) {
        super.onClick(r2);
        if (r2 != this.i) goto L13;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L14;
        d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }
}
