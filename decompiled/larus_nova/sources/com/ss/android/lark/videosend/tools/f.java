package com.ss.android.lark.videosend.tools;

import com.ss.android.vesdk.VEConfigCenter;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f445008a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f445009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile d f445010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f445011d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f445012e = false;

    static {
        f445008a = new AtomicBoolean(false);
        f445011d = new AtomicBoolean(false);
        f445012e = true;
    }

    @JvmStatic
    public static final void a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        VEConfigCenter.getInstance().updateValue(r100, Boolean.valueOf(r101));
    }
}
