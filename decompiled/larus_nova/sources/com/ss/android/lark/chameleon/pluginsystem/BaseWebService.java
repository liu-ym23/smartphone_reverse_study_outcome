package com.ss.android.lark.chameleon.pluginsystem;

import android.content.Context;
import android.webkit.ValueCallback;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.NonProguard;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes35.dex */
public class BaseWebService implements WebService {
    private static final String TAG = "BaseWebService";
    private Set<String> autoUnbinds;
    private boolean visibleToUser;

    /* JADX INFO: renamed from: web, reason: collision with root package name */
    private Web f411104web;

    public Web getWeb() {
        if (this.f411104web != null) goto L6;
        Log.e(TAG, new IllegalStateException("Web not attached or detached !").toString());
    L6:
        return this.f411104web;
    }

    public BaseWebService() {
        this.autoUnbinds = new HashSet();
    }

    public Context getContext() {
        Web r100 = getWeb();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getContext();
    }

    public boolean isVisibleToUser() {
        return this.visibleToUser;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebService
    public void onAttachToWeb(Web r100) {
        this.f411104web = r100;
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebService
    public void onDetachFromWeb(Web r100) {
        Iterator<String> r101 = this.autoUnbinds.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        unbindBridgeHandler(r101.next());
        goto L4
    L6:
        this.autoUnbinds.clear();
        this.f411104web = null;
    }

    public void unbindBridgeHandler(String r100) {
        Web r101 = getWeb();
        if (r101 == null) goto L5;
        r101.unbindJSHandler(r100);
        return;
    L5:
        Log.e(TAG, "unbindBridgeHandler while web null");
    }

    public boolean bindBridgeHandler(String r100, BridgeHandlerV2 r101) {
        Web r102 = getWeb();
        if (r102 == null) goto L6;
        r102.bindJSHandler(r100, r101);
        return true;
    L6:
        Log.e(TAG, "bindBridgeHandler while web null");
        return false;
    }

    public void bindBridgeHandlerAutoUnbind(String r100, BridgeHandlerV2 r101) {
        if (bindBridgeHandler(r100, r101) == false) goto L6;
        this.autoUnbinds.add(r100);
        return;
    }

    public void execJS(String r100, JsonObject r101) {
        execJS(r100, r101, null);
    }

    @Override // com.ss.android.lark.chameleon.pluginsystem.WebService
    public void onUserVisibleChanged(Web r100, boolean r101) {
        this.visibleToUser = r101;
    }

    public void execJS(String r100, NonProguard r101) {
        execJS(r100, r101, null);
    }

    public void execJS(String r100, JsonObject r101, ValueCallback<String> r102) {
        Web r103 = getWeb();
        if (r103 == null) goto L6;
        r103.execJS(r100, r101, r102);
        return;
    }

    public void execJS(String r100, NonProguard r101, ValueCallback<String> r102) {
        Web r103 = getWeb();
        if (r103 == null) goto L6;
        r103.execJS(r100, r101, r102);
        return;
    }
}
