package com.ss.android.lark.chameleon.container.webcontainer.plugin.core;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J$\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/UIThreadCallbackAdapter;", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader$LoadingCallback;", "()V", "callbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addLoadCallback", "", "cb", "onLoadFail", "code", "", "message", "", "e", "", "onLoadStart", "onLoadSuccess", "onPageStarted", "url", "onReceivedTitle", "view", "Landroid/webkit/WebView;", "title", "onRenderProcessGone", "release", "removeLoadCallback", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UIThreadCallbackAdapter implements IChameleonLoader.LoadingCallback {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_UIThreadCallbackAdapter";
    private final CopyOnWriteArrayList<IChameleonLoader.LoadingCallback> callbacks;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/plugin/core/UIThreadCallbackAdapter$Companion;", "", "()V", "TAG", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(UIThreadCallbackAdapter r100, WebView r101, String r102) {
        onReceivedTitle$lambda$4(r100, r101, r102);
    }

    public static /* synthetic */ void b(int r100, Throwable r101, UIThreadCallbackAdapter r102, String r103) {
        onLoadFail$lambda$3(r100, r101, r102, r103);
    }

    public static /* synthetic */ void c(UIThreadCallbackAdapter r100) {
        onLoadSuccess$lambda$2(r100);
    }

    public static /* synthetic */ void d(UIThreadCallbackAdapter r100) {
        onLoadStart$lambda$0(r100);
    }

    public static /* synthetic */ void e(UIThreadCallbackAdapter r100) {
        onRenderProcessGone$lambda$5(r100);
    }

    public static /* synthetic */ void f(UIThreadCallbackAdapter r100, String r101) {
        onPageStarted$lambda$1(r100, r101);
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onLoadStart() {
        Log.i(TAG, "onLoadStart");
        MainLooper.post(new f(this));
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onLoadSuccess() {
        Log.i(TAG, "onLoadSuccess");
        MainLooper.post(new c(this));
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onRenderProcessGone() {
        Log.i(TAG, "onRenderProcessGone");
        MainLooper.post(new b(this));
    }

    public final void release() {
        this.callbacks.clear();
    }

    public UIThreadCallbackAdapter() {
        this.callbacks = new CopyOnWriteArrayList();
    }

    private static final void onLoadStart$lambda$0(UIThreadCallbackAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Log.i(TAG, "onLoadStart execute");
        Iterator<IChameleonLoader.LoadingCallback> r101 = r100.callbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onLoadStart();
        goto L4
    }

    private static final void onLoadSuccess$lambda$2(UIThreadCallbackAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Log.i(TAG, "onLoadSuccess execute");
        Iterator<IChameleonLoader.LoadingCallback> r101 = r100.callbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onLoadSuccess();
        goto L4
    }

    private static final void onRenderProcessGone$lambda$5(UIThreadCallbackAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Log.i(TAG, "onRenderProcessGone execute");
        Iterator<IChameleonLoader.LoadingCallback> r101 = r100.callbacks.iterator();     // Catch: Throwable -> L8
    L5:
        if (r101.hasNext() == false) goto L15;
        r101.next().onRenderProcessGone();     // Catch: Throwable -> L8
        goto L5
    L15:
        return;
    L8:
        th = move-exception;
        Log.e(TAG, th.toString());
    }

    public final void addLoadCallback(IChameleonLoader.LoadingCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.callbacks.add(r100);
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onPageStarted(final String r100) {
        Log.i(TAG, "onPageStart");
        MainLooper.post(new a(this, r100));
    }

    public final void removeLoadCallback(IChameleonLoader.LoadingCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.callbacks.remove(r100);
    }

    private static final void onPageStarted$lambda$1(UIThreadCallbackAdapter r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Log.i(TAG, "onPageStart execute");
        Iterator<IChameleonLoader.LoadingCallback> r102 = r100.callbacks.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onPageStarted(r101);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onReceivedTitle(final WebView r100, final String r101) {
        Log.i(TAG, "onReceivedTitle");
        MainLooper.post(new d(this, r100, r101));
    }

    private static final void onReceivedTitle$lambda$4(UIThreadCallbackAdapter r100, WebView r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Log.i(TAG, "onReceivedTitle execute");
        Iterator<IChameleonLoader.LoadingCallback> r103 = r100.callbacks.iterator();     // Catch: Throwable -> L8
    L5:
        if (r103.hasNext() == false) goto L15;
        r103.next().onReceivedTitle(r101, r102);     // Catch: Throwable -> L8
        goto L5
    L15:
        return;
    L8:
        th = move-exception;
        Log.e(TAG, th.toString());
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader.LoadingCallback
    public void onLoadFail(final int r100, final String r101, final Throwable r102) {
        Log.i(TAG, "onLoadFail code=" + r100 + ", e=" + r102);
        MainLooper.post(new e(r100, r102, this, r101));
    }

    private static final void onLoadFail$lambda$3(int r100, Throwable r101, UIThreadCallbackAdapter r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "this$0");
        Log.i(TAG, "onLoadFail execute code=" + r100 + ", e=" + r101);
        Iterator<IChameleonLoader.LoadingCallback> r104 = r102.callbacks.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().onLoadFail(r100, r103, r101);
        goto L4
    }
}
