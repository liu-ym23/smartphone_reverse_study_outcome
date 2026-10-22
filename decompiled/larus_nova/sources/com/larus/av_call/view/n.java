package com.larus.av_call.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class n implements p<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o<Object> f290684a;

    public n(o<Object> r100) {
        this.f290684a = r100;
    }

    @Override // com.larus.av_call.view.p
    public final View a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        return LayoutInflater.from(r100).inflate(R.layout.larus_item_realtime_call_suggest_text, r101, false);
    }

    @Override // com.larus.av_call.view.p
    public final void b(Object r100, int r101) {
        this.f290684a.f290688b.invoke(r100, Integer.valueOf(r101));
    }
}
