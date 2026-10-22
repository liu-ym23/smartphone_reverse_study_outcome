package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.im.bean.message.Message;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f345353a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Message> f345354b = null;

    public j0() {
    }

    static {
        f345353a = new j0();
        f345354b = new ConcurrentHashMap();
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "briefMessages");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        f345354b.putAll(r100);
    }
}
