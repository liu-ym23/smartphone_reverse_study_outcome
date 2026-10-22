package com.bytedance.ee.bear.doc.vote;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.empty.Config;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class VoteOptionMemberEmptyConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f218388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f218389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Config> f218390c;

    public final Context getContext() {
        return this.f218388a;
    }

    public VoteOptionMemberEmptyConfig(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
        this.f218388a = r100;
        this.f218389b = r101;
        this.f218390c = new VoteOptionMemberEmptyConfig$value$1(this);
    }
}
