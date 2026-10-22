package com.bytedance.kmp.gamecp.base.message.model;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/gamecp/base/message/model/a;", "Lvh7/c;", "Lyh6/c;", "kmp-gamecp-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a>, yh6.c {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // yh6.c
    /* synthetic */ m0 getCommonData();

    /* synthetic */ void setCommonData(m0 r100);
}
