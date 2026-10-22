package com.bytedance.ee.bear.document.adapter;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.OpenStatus;
import com.ss.android.lark.chameleon.pluginapi.RouterState;
import com.ss.android.lark.chameleon.pluginapi.WebviewStatus;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements IChameleonLoader {
    public e() {
    }

    public final void addLoadCallback(IChameleonLoader.LoadingCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
    }

    public final void addTitleBarCallback(IChameleonLoader.IChameleonTitleBarCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
    }

    public final boolean getVisible() {
        return true;
    }

    public final void load(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
    }

    public final void onLoadFailed(int r1, Throwable r2) {
    }

    public final void onLoadSuccess() {
    }

    public final void release() {
    }

    public final void reload() {
    }

    public final void removeLoadCallback(IChameleonLoader.LoadingCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
    }

    public final void removeTitleBarCallback(IChameleonLoader.IChameleonTitleBarCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
    }

    public final void reportOpenStatus(OpenStatus r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, TipCallBackData.RESULT);
    }

    public final void setRouteState(RouterState<Serializable> r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final RouterState<Serializable> getRouterState() {
        return new RouterState("", null);
    }

    public final WebviewStatus getStatus() {
        return WebviewStatus.Visible;
    }
}
