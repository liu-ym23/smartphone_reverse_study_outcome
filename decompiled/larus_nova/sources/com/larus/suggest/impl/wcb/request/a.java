package com.larus.suggest.impl.wcb.request;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.platform.model.chat.x;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import hx9.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f370087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f370088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f370089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile fx9.b f370090d;

    public a(hx9.a r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f370087a = r100;
        this.f370088b = z2.f365865a.H3();
        this.f370089c = true;
    }

    public final void a(fx9.b r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.INPUT_TYPE);
        if (this.f370089c == false) goto L6;
        this.f370090d = r100;
        FLogger.f375446a.i("WcbLog", "input triggered: " + r100.f479117a);
        return;
    }
}
