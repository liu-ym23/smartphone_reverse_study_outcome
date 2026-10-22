package com.bytedance.ies.bullet.lynx.impl;

import android.content.Context;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f247316a;

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.lynx.impl.a$a, reason: collision with other inner class name */
    public static final class C3534a {
    }

    static {
    }

    public a(q1 r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxViewClient");
        this.f247316a = r100;
    }

    @Override // com.lynx.tasm.behavior.m
    public final String shouldRedirectImageUrl(String r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        HybridLogger.f("DefaultImageInterceptor", "shouldRedirectImageUrl: " + r100, null, 12);
        return this.f247316a.shouldRedirectImageUrl(r100);
    }

    @Override // com.lynx.tasm.behavior.m
    public final void loadImage(Context r100, String r110, String r111, float r112, float r113, Transformer r114, m.a r115) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r115, "handler");
        HybridLogger.f("DefaultImageInterceptor", "loadImage", null, 12);
        this.f247316a.loadImage(r100, r110, r111, r112, r113, null, r115);
    }
}
