package com.bytedance.ee.bear.bitable.loading.loadingview;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import du4.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class ViewContentLoadingFactory implements d {
    public ViewContentLoadingFactory() {
    }

    @Override // du4.d
    public final View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        RecyclerView r101 = new RecyclerView(r100);
        r101.setAdapter(new ViewContentLoadingFactory$createLoading$1(r100));
        r101.setLayoutManager(new ViewContentLoadingFactory$createLoading$2(r100));
        return r101;
    }

    @Override // du4.d
    public final View b(Context r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new LoadingLayout(r100, r101, r102);
    }
}
