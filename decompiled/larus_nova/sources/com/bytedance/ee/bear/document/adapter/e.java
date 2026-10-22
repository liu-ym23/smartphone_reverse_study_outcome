package com.bytedance.ee.bear.document.adapter;

import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.OpenStatus;
import com.ss.android.lark.chameleon.pluginapi.RouterState;
import com.ss.android.lark.chameleon.pluginapi.WebviewStatus;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements IChameleonLoader {
    public e() {
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void addLoadCallback(IChameleonLoader.LoadingCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void addTitleBarCallback(IChameleonLoader.IChameleonTitleBarCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final boolean getVisible() {
        return true;
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void load(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void onLoadFailed(int r100, Throwable r101) {
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void onLoadSuccess() {
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void release() {
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void reload() {
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void removeLoadCallback(IChameleonLoader.LoadingCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void removeTitleBarCallback(IChameleonLoader.IChameleonTitleBarCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void reportOpenStatus(OpenStatus r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final void setRouteState(RouterState<Serializable> r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final RouterState<Serializable> getRouterState() {
        return new RouterState("", null);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
    public final WebviewStatus getStatus() {
        return WebviewStatus.Visible;
    }
}
