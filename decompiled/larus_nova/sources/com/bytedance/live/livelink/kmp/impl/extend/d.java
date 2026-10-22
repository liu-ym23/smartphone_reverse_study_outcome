package com.bytedance.live.livelink.kmp.impl.extend;

import hi6.e;
import hi6.f;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f255587b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f255588c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Object> f255589a;

    public static final class a {
    }

    static {
        f255587b = new f(false, null);
        f255588c = new f(true, null);
    }

    public d(e r100) {
        Intrinsics.checkNotNullParameter(r100, "baseCall");
        this.f255589a = r100.f485348c;
    }
}
