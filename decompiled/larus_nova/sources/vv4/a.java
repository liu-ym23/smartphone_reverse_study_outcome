package vv4;

import android.content.Context;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes16.dex */
public class a implements m {
    private static final String TAG = "BaseWebService";
    private Set<String> autoUnbinds;
    private boolean visibleToUser;

    /* JADX INFO: renamed from: web, reason: collision with root package name */
    private k f557384web;

    public k getWeb() {
        if (this.f557384web != null) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.e(TAG, "getWeb: Web not attached or detached !");
    L6:
        return this.f557384web;
    }

    public a() {
        this.autoUnbinds = new HashSet();
    }

    public Context getContext() {
        k r100 = getWeb();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getContext();
    }

    public boolean isVisibleToUser() {
        return this.visibleToUser;
    }

    public void onAttachToWeb(k r100) {
        this.f557384web = r100;
    }

    @Override // vv4.m
    public void onDetachFromWeb(k r100) {
        Iterator<String> r101 = this.autoUnbinds.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        unbindBridgeHandler(r101.next());
        goto L4
    L6:
        this.autoUnbinds.clear();
        this.f557384web = null;
    }

    public void unbindBridgeHandler(String r100) {
        k r101 = getWeb();
        if (r101 == null) goto L5;
        r101.unbindJSHandler(r100);
        return;
    L5:
        com.ss.android.lark.officesdk.utils.di.j.b(TAG, "unbindBridgeHandler while web null");
    }

    public boolean bindBridgeHandler(String r100, tb5.i r101) {
        k r102 = getWeb();
        if (r102 == null) goto L6;
        r102.h(r100, r101);
        return true;
    L6:
        com.ss.android.lark.officesdk.utils.di.j.b(TAG, "bindBridgeHandler while web null");
        return false;
    }

    public void bindBridgeHandlerAutoUnbind(String r100, tb5.i r101) {
        if (bindBridgeHandler(r100, r101) == false) goto L6;
        this.autoUnbinds.add(r100);
        return;
    }

    public void execJS(String r100, JSONObject r101) {
        execJS(r100, r101, null);
    }

    @Override // vv4.m
    public void onAttachToWeb(h r100, k r101) {
        onAttachToWeb(r101);
    }

    @Override // vv4.m
    public void onUserVisibleChanged(k r100, boolean r101) {
        this.visibleToUser = r101;
    }

    public void execJS(String r100, NonProguard r101) {
        execJS(r100, r101, null);
    }

    public void execJS(String r100, JSONObject r101, ValueCallback<String> r102) {
        k r103 = getWeb();
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }

    public void execJS(String r100, NonProguard r101, ValueCallback<String> r102) {
        k r103 = getWeb();
        if (r103 == null) goto L6;
        r103.k(r100, r101, r102);
        return;
    }
}
