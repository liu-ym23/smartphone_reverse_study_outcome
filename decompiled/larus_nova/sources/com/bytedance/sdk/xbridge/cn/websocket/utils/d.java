package com.bytedance.sdk.xbridge.cn.websocket.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f270276a = 0;

    static {
    }

    public static void a(String r100, String r101, ef7.a r102) {
        Intrinsics.checkNotNullParameter(r100, "containerID");
        SocketManager.f270265b.getValue().getClass();
        Intrinsics.checkNotNullParameter(r100, "containerID");
        List r103 = SocketManager.b(r100, r101);
        String r104 = null;
        if (r103 == null) goto L9;
        Iterator r105 = ((ArrayList) r103).iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        ((c) r105.next()).a();
        goto L6
    L8:
        Unit r106 = Unit.INSTANCE;
    L10:
        if (r106 != null) goto L14;
        if (r101 == null) goto L13;
        r104 = "The socketTaskID doesn't exist";
        goto L14
    L13:
        r104 = "The containerID doesn't exist";
    L14:
        if (r104 != null) goto L17;
        if (r102 == null) goto L21;
        r102.b();
        return;
    L21:
        return;
    L17:
        if (r102 == null) goto L23;
        r102.a(r104);
        return;
    L23:
        return;
    L9:
        r106 = null;
        goto L10
    }
}
