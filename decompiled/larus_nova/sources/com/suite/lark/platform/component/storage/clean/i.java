package com.suite.lark.platform.component.storage.clean;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f460606a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f460607b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f460608c = null;

    public static final class a {
    }

    static {
        f460606a = new i(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        f460607b = new i("file delete invoke failed!");
        f460608c = new i("io exception occurred");
        new i("rust erase failed");
        new i("clean engine internal error");
        new i("this is a mock error, plz ignore");
    }

    public i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }
}
