package vv4;

import android.content.Context;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a implements m {
    private static final String TAG = "BaseWebService";
    private Set<String> autoUnbinds;
    private boolean visibleToUser;
    private k web;

    public k getWeb() {
        if (this.web != null) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.e(TAG, "getWeb: Web not attached or detached !");
    L6:
        return this.web;
    }

    public a() {
        this.autoUnbinds = new HashSet();
    }

    public Context getContext() {
        k r0 = getWeb();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getContext();
    }

    public boolean isVisibleToUser() {
        return this.visibleToUser;
    }

    public void onAttachToWeb(k r1) {
        this.web = r1;
    }

    @Override // vv4.m
    public void onDetachFromWeb(k r2) {
        Iterator<String> r3 = this.autoUnbinds.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        unbindBridgeHandler(r3.next());
        goto L4
    L6:
        this.autoUnbinds.clear();
        this.web = null;
    }

    public void unbindBridgeHandler(String r2) {
        k r0 = getWeb();
        if (r0 == null) goto L5;
        r0.unbindJSHandler(r2);
        return;
    L5:
        com.ss.android.lark.officesdk.utils.di.j.b(TAG, "unbindBridgeHandler while web null");
    }

    public boolean bindBridgeHandler(String r2, tb5.i r3) {
        k r0 = getWeb();
        if (r0 == null) goto L6;
        r0.h(r2, r3);
        return true;
    L6:
        com.ss.android.lark.officesdk.utils.di.j.b(TAG, "bindBridgeHandler while web null");
        return false;
    }

    public void bindBridgeHandlerAutoUnbind(String r1, tb5.i r2) {
        if (bindBridgeHandler(r1, r2) == false) goto L6;
        this.autoUnbinds.add(r1);
        return;
    }

    public void execJS(String r2, JSONObject r3) {
        execJS(r2, r3, null);
    }

    @Override // vv4.m
    public void onAttachToWeb(h r1, k r2) {
        onAttachToWeb(r2);
    }

    @Override // vv4.m
    public void onUserVisibleChanged(k r1, boolean r2) {
        this.visibleToUser = r2;
    }

    public void execJS(String r2, NonProguard r3) {
        execJS(r2, r3, null);
    }

    public void execJS(String r2, JSONObject r3, ValueCallback<String> r4) {
        k r0 = getWeb();
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }

    public void execJS(String r2, NonProguard r3, ValueCallback<String> r4) {
        k r0 = getWeb();
        if (r0 == null) goto L6;
        r0.k(r2, r3, r4);
        return;
    }
}
