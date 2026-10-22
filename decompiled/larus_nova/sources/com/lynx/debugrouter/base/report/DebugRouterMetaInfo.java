package com.lynx.debugrouter.base.report;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/lynx/debugrouter/base/report/DebugRouterMetaInfo;", "", "debugRouterVersion", "", "appProcessName", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppProcessName", "()Ljava/lang/String;", "setAppProcessName", "(Ljava/lang/String;)V", "getDebugRouterVersion", "setDebugRouterVersion", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebugRouterMetaInfo {
    public String appProcessName;
    public String debugRouterVersion;

    public final String getAppProcessName() {
        String r100 = this.appProcessName;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("appProcessName");
        return null;
    }

    public final String getDebugRouterVersion() {
        String r100 = this.debugRouterVersion;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("debugRouterVersion");
        return null;
    }

    public final void setAppProcessName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appProcessName = r100;
    }

    public final void setDebugRouterVersion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.debugRouterVersion = r100;
    }

    public DebugRouterMetaInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "debugRouterVersion");
        Intrinsics.checkNotNullParameter(r101, "appProcessName");
        setDebugRouterVersion(r100);
        setAppProcessName(r101);
    }
}
