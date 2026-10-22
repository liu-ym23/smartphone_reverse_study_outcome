package com.ss.android.lark.chameleonv2.container.webcontainer.plugin;

import android.webkit.WebView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: classes35.dex */
public final class UIThreadCallbackAdapter implements IChameleonLoader.LoadingCallback, IChameleonLoader.IChameleonTitleBarCallback, k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<IChameleonLoader.LoadingCallback> f411178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<IChameleonLoader.IChameleonTitleBarCallback> f411179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<k.a> f411180c;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIThreadCallbackAdapter f411181a;

        public b(UIThreadCallbackAdapter r100) {
            this.f411181a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLeftBackAndCloseChange execute");     // Catch: Throwable -> L11
            Iterator<IChameleonLoader.IChameleonTitleBarCallback> r100 = this.f411181a.f411179b.iterator();     // Catch: Throwable -> L8
        L5:
            if (r100.hasNext() == false) goto L22;
            r100.next().onLeftBackAndCloseChange();     // Catch: Throwable -> L8
        L22:
            return;
        L8:
            th = move-exception;
            j.d(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, th);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f411182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f411183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UIThreadCallbackAdapter f411184c;

        public c(int r100, Throwable r101, UIThreadCallbackAdapter r102) {
            this.f411182a = r100;
            this.f411183b = r101;
            this.f411184c = r102;
        }

        public final void a() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadFail execute code=" + this.f411182a + ", e=" + this.f411183b);
            Iterator<IChameleonLoader.LoadingCallback> r100 = this.f411184c.f411178a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().onLoadFail(this.f411182a, this.f411183b);
            goto L4
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIThreadCallbackAdapter f411185a;

        public d(UIThreadCallbackAdapter r100) {
            this.f411185a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadFailByJS execute");     // Catch: Throwable -> L7
            Iterator<IChameleonLoader.LoadingCallback> r100 = this.f411185a.f411178a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            r100.next().onLoadSuccessByJS();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIThreadCallbackAdapter f411186a;

        public e(UIThreadCallbackAdapter r100) {
            this.f411186a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadStart execute");     // Catch: Throwable -> L7
            Iterator<IChameleonLoader.LoadingCallback> r100 = this.f411186a.f411178a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            r100.next().onLoadStart();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIThreadCallbackAdapter f411187a;

        public f(UIThreadCallbackAdapter r100) {
            this.f411187a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadSuccess execute");     // Catch: Throwable -> L7
            Iterator<IChameleonLoader.LoadingCallback> r100 = this.f411187a.f411178a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            r100.next().onLoadSuccess();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIThreadCallbackAdapter f411188a;

        public g(UIThreadCallbackAdapter r100) {
            this.f411188a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadSuccess execute");     // Catch: Throwable -> L7
            Iterator<IChameleonLoader.LoadingCallback> r100 = this.f411188a.f411178a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            r100.next().onLoadSuccessByJS();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIThreadCallbackAdapter f411189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f411190b;

        public h(UIThreadCallbackAdapter r100, String r101) {
            this.f411189a = r100;
            this.f411190b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onPageStart execute");     // Catch: Throwable -> L7
            Iterator<IChameleonLoader.LoadingCallback> r100 = this.f411189a.f411178a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            r100.next().onPageStarted(this.f411190b);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UIThreadCallbackAdapter f411191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WebView f411192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f411193c;

        public i(UIThreadCallbackAdapter r100, WebView r101, String r102) {
            this.f411191a = r100;
            this.f411192b = r101;
            this.f411193c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onReceivedTitle execute");     // Catch: Throwable -> L11
            Iterator<IChameleonLoader.LoadingCallback> r100 = this.f411191a.f411178a.iterator();     // Catch: Throwable -> L8
        L5:
            if (r100.hasNext() == false) goto L23;
            r100.next().onReceivedTitle(this.f411192b, this.f411193c);     // Catch: Throwable -> L8
        L23:
            return;
        L8:
            th = move-exception;
            j.d(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, th);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    static {
    }

    @Override // vv4.k.a
    public final /* synthetic */ void a(boolean r100, int r101) {
    }

    public final void b() {
        Iterator<k.a> r100 = this.f411180c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        k.a r101 = r100.next();
        CopyOnWriteArrayList<k.a> r102 = RenderGoneHelper.f411285a;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "cb");
        RenderGoneHelper.f411285a.remove(r101);
        goto L4
    L6:
        CollectionsKt.removeAll(this.f411178a, UIThreadCallbackAdapter$release$1.INSTANCE);
        this.f411179b.clear();
        this.f411180c.clear();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.IChameleonTitleBarCallback
    public final void onLeftBackAndCloseChange() {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLeftBackAndCloseChange");
        UICallbackExecutor.execute(new b(this));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadStart() {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadStart");
        UICallbackExecutor.execute(new e(this));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadSuccess() {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadSuccess");
        UICallbackExecutor.execute(new f(this));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadSuccessByJS() {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadSuccess");
        UICallbackExecutor.execute(new g(this));
    }

    public UIThreadCallbackAdapter() {
        this.f411178a = new CopyOnWriteArrayList();
        this.f411179b = new CopyOnWriteArrayList();
        this.f411180c = new CopyOnWriteArrayList();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final boolean getKeepOnRelease() {
        return IChameleonLoader.LoadingCallback.DefaultImpls.getKeepOnRelease(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    @Deprecated(message = "已废弃，使用IRenderGoneListener")
    public final void onRenderProcessGone() {
        IChameleonLoader.LoadingCallback.DefaultImpls.onRenderProcessGone(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onPageStarted(String r100) {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onPageStart");
        UICallbackExecutor.execute(new h(this, r100));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadFail(int r100, Throwable r101) {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadFail code=" + r100 + ", e=" + r101);
        UICallbackExecutor.execute(new c(r100, r101, this));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadFailByJS(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadFailByJS type=" + r100 + ", code=" + r101);
        UICallbackExecutor.execute(new d(this));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onReceivedTitle(WebView r100, String r101) {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onReceivedTitle");
        UICallbackExecutor.execute(new i(this, r100, r101));
    }
}
