package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.Context;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ShareDocInfo f237085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShareParams f237086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f237087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f237088d;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f237087c;
    }

    public f(ShareDocInfo r100, ShareParams r101, Context r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "dismissDialog");
        this.f237085a = r100;
        this.f237086b = r101;
        this.f237087c = r102;
        this.f237088d = r103;
    }
}
