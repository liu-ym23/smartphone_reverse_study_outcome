package com.ss.android.ugc.route_monitor.utils;

import android.os.Message;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "message", "Landroid/os/Message;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class RouteMonitorUtilsKt$findServiceStartCommandMessage$1 extends Lambda implements Function1<Message, Boolean> {
    public static final RouteMonitorUtilsKt$findServiceStartCommandMessage$1 INSTANCE = null;

    static {
        INSTANCE = new RouteMonitorUtilsKt$findServiceStartCommandMessage$1();
    }

    public RouteMonitorUtilsKt$findServiceStartCommandMessage$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Message r100) {
        return Boolean.valueOf(invoke2(r100));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Message r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.what == 115) goto L6;
        return true;
    }
}
