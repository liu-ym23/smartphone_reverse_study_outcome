package com.ss.android.lark.chameleon.pluginsystem;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class WebServiceManager {
    private static final String TAG = "WebServiceManager";
    private Web mWeb;
    private List<WebService> mWebServices;

    public void onDestroy() {
        Log.i(TAG, LiveCommonConstants.REASON_ON_DEDTROY);
        Iterator<WebService> r100 = this.mWebServices.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        WebService r101 = r100.next();
        r100.remove();
        onDetachWebService(r101);
        goto L4
    L6:
        this.mWeb = null;
    }

    public void onWebBringToBackground() {
        Log.i(TAG, "onWebBringToBackground");
        Iterator<WebService> r100 = this.mWebServices.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onUserVisibleChanged(this.mWeb, false);
        goto L4
    }

    public void onWebBringToFront() {
        Log.i(TAG, "onWebBringToFront");
        Iterator<WebService> r100 = this.mWebServices.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onUserVisibleChanged(this.mWeb, true);
        goto L4
    }

    public WebServiceManager() {
        this.mWebServices = new ArrayList();
    }

    private void onAttachWebService(WebService r100) {
        if (this.mWeb != null) goto L6;
        Log.e(TAG, "onAttachWebService WEB NULL");
        return;
    L6:
        Log.i(TAG, "onAttachWebService:" + r100);
        r100.onAttachToWeb(this.mWeb);
    }

    private void onDetachWebService(WebService r100) {
        if (this.mWeb != null) goto L6;
        Log.e(TAG, "onDetachWebService WEB NULL");
        return;
    L6:
        Log.i(TAG, "onDetachWebService:" + r100);
        r100.onDetachFromWeb(this.mWeb);
    }

    public void addWebService(WebService r100) {
        if (this.mWebServices.contains(r100) == true) goto L6;
        this.mWebServices.add(r100);
        onAttachWebService(r100);
        return;
    }

    public <P extends WebService> P getWebService(Class<P> r100) {
        List<WebService> r101 = this.mWebServices;
        if (r101 == null) goto L11;
        if (r100 == null) goto L11;
        Iterator<WebService> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        P r103 = (P) r102.next();
        if (r103.getClass() != r100) goto L7;
        return r103;
    L11:
        Log.w(TAG, "WebService not found with type:" + r100);
        return null;
    }

    public void removeWebService(WebService r100) {
        if (this.mWebServices.remove(r100) == false) goto L6;
        onDetachWebService(r100);
        return;
    }

    public void onCreate(Web r100, List<WebService> r101) {
        Log.i(TAG, WidgetCostModule.TYPE_ON_CREATE);
        this.mWeb = r100;
        if (r101 == null) goto L8;
        Iterator<WebService> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        addWebService(r102.next());
        goto L6
    L10:
        return;
    }
}
