package com.bytedance.ee.bear.doc.history;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import sa5.d;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class HistoryPlugin extends DocumentPlugin implements d {
    private static final String TAG = "HistoryPlugin";
    private static final String TITLE = "title";
    private m mJsCallback;
    private a mOnShowHistory;

    public interface a {
    }

    public class b implements i<String> {
        public final /* synthetic */ HistoryPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(HistoryPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            HistoryPlugin.access$102(this.a, r2);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public void setOnShowHistoryListener(a r1) {
    }

    private void touchWebViewIfNeeded() {
        if (getWeb().getWebView().getScrollY() != 0) goto L6;
        MotionEvent r0 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
        MotionEvent r1 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0);
        getWeb().getWebView().dispatchTouchEvent(r0);
        getWeb().getWebView().dispatchTouchEvent(r1);
        r0.recycle();
        r1.recycle();
        return;
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        getDocViewModel().isShowingHistory().setValue(Boolean.FALSE);
        return false;
    }

    public void showHistory() {
        DocViewModel r0 = getDocViewModel();
        CharSequence r1 = (CharSequence) r0.getTitle().getValue();
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        touchWebViewIfNeeded();
        StringBuilder r3 = new StringBuilder("showHistory()... jsCallback null is ");
        if (this.mJsCallback != null) goto L9;
        boolean r4 = true;
    L10:
        r3.append(r4);
        tt5.a.b(TAG, r3.toString());
        if (this.mJsCallback == null) goto L14;
        JSONObject r5 = new JSONObject();
        r5.put(TITLE, r2);
        this.mJsCallback.b(r5);
        r0.isShowingHistory().setValue(Boolean.TRUE);
        return;
    L14:
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = "";
        goto L6
    }

    public HistoryPlugin() {
    }

    public static /* synthetic */ m access$102(HistoryPlugin r0, m r1) {
        r0.mJsCallback = r1;
        return r1;
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        bindBridgeHandlerAutoUnbind("biz.history.show", new b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
