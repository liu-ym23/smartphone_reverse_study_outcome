package com.larus.doc.sdk.impl.v2.plugins.video;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.ss.android.lark.appcontext.applifecycle.q;
import com.ss.android.lark.appcontext.applifecycle.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/video/FullVideoChromeClient;", "Landroid/webkit/WebChromeClient;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/doc/sdk/impl/v2/plugins/video/FullVideoChromeClient$IVideoWebViewContext;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/video/FullVideoChromeClient$IVideoWebViewContext;)V", "mCallBack", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "mContext", "videoView", "Landroid/view/View;", "configurationChangedListener", "Lcom/ss/android/lark/appcontext/applifecycle/IConfigurationChangedListener;", "onShowCustomView", "", "view", "callback", "updateLayoutParams", "onHideCustomView", "IVideoWebViewContext", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullVideoChromeClient extends WebChromeClient {
    private final v configurationChangedListener;
    private WebChromeClient.CustomViewCallback mCallBack;
    private final IVideoWebViewContext mContext;
    private View videoView;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/video/FullVideoChromeClient$IVideoWebViewContext;", "", "getWebView", "Landroid/webkit/WebView;", "getContext", "Landroid/content/Context;", "getVideoContainer", "Landroid/view/ViewGroup;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface IVideoWebViewContext {
        Context getContext();

        ViewGroup getVideoContainer();

        WebView getWebView();
    }

    public static /* synthetic */ void a(FullVideoChromeClient r100, Configuration r101) {
        configurationChangedListener$lambda$0(r100, r101);
    }

    private final void updateLayoutParams() {
        View r100 = this.videoView;
        if (r100 == null) goto L8;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L9;
        r101.height = -1;
        r101.width = -1;
        return;
    L9:
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        WebChromeClient.CustomViewCallback r100 = this.mCallBack;
        if (r100 == null) goto L6;
        r100.onCustomViewHidden();
    L6:
        if (this.videoView == null) goto L11;
        ViewGroup r101 = this.mContext.getVideoContainer();
        if (r101 == null) goto L10;
        r101.removeView(this.videoView);
    L10:
        this.videoView = null;
    L11:
        Object r102 = q.f408854c;
        q.a.f408857a.b(this.configurationChangedListener);
        super.onHideCustomView();
        WebView r103 = this.mContext.getWebView();
        if (r103 == null) goto L15;
        r103.clearFocus();
        return;
    }

    public FullVideoChromeClient(IVideoWebViewContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.mContext = r100;
        this.configurationChangedListener = new a(this);
    }

    private static final void configurationChangedListener$lambda$0(FullVideoChromeClient r100, Configuration r101) {
        r100.updateLayoutParams();
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        this.videoView = r100;
        this.mCallBack = r101;
        Object r102 = q.f408854c;
        q.a.f408857a.a(this.configurationChangedListener);
        ViewGroup r103 = this.mContext.getVideoContainer();
        if (r103 == null) goto L5;
        r103.addView(this.videoView, -1, -1);
    L5:
        super.onShowCustomView(r100, r101);
    }
}
