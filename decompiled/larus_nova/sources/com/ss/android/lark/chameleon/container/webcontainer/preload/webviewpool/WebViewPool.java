package com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool;

import com.bytedance.common.utility.collection.CollectionUtils;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes35.dex */
public class WebViewPool implements IWebViewPool {
    private static final String TAG = "CML_TAG_WebViewPool";
    private final Deque<WebViewItem> list;
    private IWebViewPool.WebViewLifecycleListener listener;

    public static class WebViewItem {
        private Object tag;
        private ChameleonWebView webView;

        public WebViewItem() {
        }

        public Object getTag() {
            return this.tag;
        }

        public ChameleonWebView getWebView() {
            return this.webView;
        }

        public static /* synthetic */ Object access$000(WebViewItem r100) {
            return r100.tag;
        }

        public static /* synthetic */ ChameleonWebView access$100(WebViewItem r100) {
            return r100.webView;
        }

        public void setTag(Object r100) {
            this.tag = r100;
        }

        public static /* synthetic */ Object access$002(WebViewItem r100, Object r101) {
            r100.tag = r101;
            return r101;
        }

        public static /* synthetic */ ChameleonWebView access$102(WebViewItem r100, ChameleonWebView r101) {
            r100.webView = r101;
            return r101;
        }
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized void destroyAll() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (CollectionUtils.isEmpty(this.list) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        ArrayList r100 = new ArrayList(this.list);     // Catch: Throwable -> L16
        this.list.clear();     // Catch: Throwable -> L16
        Iterator r101 = r100.iterator();     // Catch: Throwable -> L16
    L9:
        if (r101.hasNext() == false) goto L14;
        WebViewItem r102 = (WebViewItem) r101.next();     // Catch: Throwable -> L16
        IWebViewPool.WebViewLifecycleListener r103 = this.listener;     // Catch: Throwable -> L16
        if (r103 == null) goto L9;
        r103.onWebViewDestroyed(WebViewItem.access$100(r102));     // Catch: Throwable -> L16
        goto L9
    L14:
        monitor-exit(this);
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public int occupiedSize() {
        Iterator<WebViewItem> r100 = this.list.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L8;
        if (WebViewItem.access$000(r100.next()) == null) goto L4;
        r101 = r101 + 1;
        goto L4
    L8:
        return r101;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public int poolSize() {
        return this.list.size();
    }

    public WebViewPool() {
        this.list = new LinkedList();
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized ChameleonWebView createWebView(ChameleonConfig r100) {
        monitor-enter(this);
        WebViewItem r101 = new WebViewItem();     // Catch: Throwable -> L9
        WebViewItem.access$102(r101, new ChameleonWebView(Env.getApplication(), r100));     // Catch: Throwable -> L9
        this.list.addLast(r101);     // Catch: Throwable -> L9
        IWebViewPool.WebViewLifecycleListener r102 = this.listener;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.onWebViewCreated(WebViewItem.access$100(r101));     // Catch: Throwable -> L9
    L6:
        ChameleonWebView r103 = WebViewItem.access$100(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r103;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized void destroyWebView(ChameleonWebView r100) {
        monitor-enter(this);
        if (r100 != null) goto L24;
        monitor-exit(this);
        return;
    L24:
        IWebViewPool.WebViewLifecycleListener r101 = this.listener;     // Catch: Throwable -> L21
        if (r101 == null) goto L10;
        r101.onWebViewDestroyed(r100);     // Catch: Throwable -> L21
    L10:
        if (CollectionUtils.isEmpty(this.list) == false) goto L13;
        monitor-exit(this);
        return;
    L13:
        Iterator<WebViewItem> r102 = this.list.iterator();     // Catch: Throwable -> L21
    L15:
        if (r102.hasNext() == false) goto L19;
        if (WebViewItem.access$100(r102.next()) != r100) goto L15;
        r102.remove();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized ChameleonWebView detachWebView(Object r100) {
        monitor-enter(this);
        ChameleonWebView r101 = null;
        if (r100 != null) goto L23;
        monitor-exit(this);
        return null;
    L23:
        Iterator<WebViewItem> r102 = this.list.iterator();     // Catch: Throwable -> L20
    L9:
        if (r102.hasNext() == false) goto L13;
        WebViewItem r103 = r102.next();     // Catch: Throwable -> L20
        if (r100.equals(WebViewItem.access$000(r103)) == false) goto L9;
        r102.remove();     // Catch: Throwable -> L20
    L14:
        if (r103 == null) goto L16;
        WebViewItem.access$002(r103, null);     // Catch: Throwable -> L20
        this.list.addLast(r103);     // Catch: Throwable -> L20
    L16:
        if (r103 == null) goto L18;
        r101 = WebViewItem.access$100(r103);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return r101;
    L13:
        r103 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public ChameleonWebView getOverMaxUsedWebView(int r100) {
        if (CollectionUtils.isEmpty(this.list) == false) goto L6;
        Log.e(TAG, "getOverMaxUsedChameleonWebView without initializing pool!");
        return null;
    L6:
        Iterator<WebViewItem> r101 = this.list.descendingIterator();
    L8:
        if (r101.hasNext() == false) goto L12;
        WebViewItem r102 = r101.next();
        if (WebViewItem.access$100(r102).getUsedCount() <= r100) goto L8;
    L13:
        if (r102 != null) goto L16;
        return null;
    L16:
        return WebViewItem.access$100(r102);
    L12:
        r102 = null;
        goto L13
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public void setWebViewLifeCycleListener(IWebViewPool.WebViewLifecycleListener r100) {
        this.listener = r100;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized void traversePool(IWebViewPool.TraverseAction r100) {
        monitor-enter(this);
        Iterator r101 = new ArrayList(this.list).iterator();     // Catch: Throwable -> L10
    L5:
        if (r101.hasNext() == false) goto L8;
        if (r100.onWebViewTraverse(WebViewItem.access$100((WebViewItem) r101.next())) == false) goto L5;
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized ChameleonWebView getCurWebView(Object r100, boolean r101) {
        monitor-enter(this);
        WebViewItem r102 = getCurWebViewItem(r100, r101);     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        ChameleonWebView r103 = WebViewItem.access$100(r102);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r103;
    L7:
        r103 = null;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public WebViewItem getCurWebViewItem(Object r100, boolean r101) {
        WebViewItem r102 = null;
        if (CollectionUtils.isEmpty(this.list) == true) goto L16;
        if (r100 == null) goto L16;
        Iterator<WebViewItem> r103 = this.list.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        WebViewItem r104 = r103.next();
        if (r100.equals(WebViewItem.access$000(r104)) == false) goto L8;
        r102 = r104;
    L12:
        if (r102 == null) goto L16;
        WebViewItem.access$002(r102, r100);
        if (r101 == false) goto L16;
        this.list.remove(r102);
        this.list.addFirst(r102);
    L16:
        return r102;
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool
    public synchronized ChameleonWebView provideWebView(Object r100, boolean r101) {
        monitor-enter(this);
        WebViewItem r102 = null;
        if (CollectionUtils.isEmpty(this.list) == false) goto L8;
        Log.e(TAG, "call provideChameleonWebView without initializing pool!");     // Catch: Throwable -> L28
        monitor-exit(this);
        return null;
    L8:
        Iterator<WebViewItem> r103 = this.list.descendingIterator();     // Catch: Throwable -> L28
        WebViewItem r104 = null;
    L10:
        if (r103.hasNext() == false) goto L20;
        WebViewItem r105 = r103.next();     // Catch: Throwable -> L28
        if (WebViewItem.access$000(r105) != null) goto L10;
        if (WebViewItem.access$100(r105).isReady() == r101) goto L15;
        if (r104 == null) goto L19;
        if (WebViewItem.access$100(r105).getUsedCount() <= WebViewItem.access$100(r104).getUsedCount()) goto L10;
    L19:
        r104 = r105;
        goto L10
    L15:
        r102 = r105;
    L20:
        if (r102 == null) goto L23;
        r104 = r102;
    L23:
        if (r104 != null) goto L25;
        r104 = this.list.getLast();     // Catch: Throwable -> L28
    L25:
        this.list.remove(r104);     // Catch: Throwable -> L28
        this.list.addFirst(r104);     // Catch: Throwable -> L28
        WebViewItem.access$002(r104, r100);     // Catch: Throwable -> L28
        ChameleonWebView r106 = WebViewItem.access$100(r104);     // Catch: Throwable -> L28
        monitor-exit(this);
        return r106;
    L28:
        th = move-exception;
        throw th;
    }
}
