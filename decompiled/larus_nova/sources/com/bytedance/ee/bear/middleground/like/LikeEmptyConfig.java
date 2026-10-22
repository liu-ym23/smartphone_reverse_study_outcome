package com.bytedance.ee.bear.middleground.like;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.empty.Config;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class LikeEmptyConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f232709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f232710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Config> f232711c;

    public final Context getContext() {
        return this.f232709a;
    }

    public LikeEmptyConfig(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
        this.f232709a = r100;
        this.f232710b = r101;
        this.f232711c = new LikeEmptyConfig$value$1(this);
    }
}
