package com.bytedance.ee.bear.bitable.loading.loadingview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import du4.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class GlobalShareRecordLoadingFactory implements d {

    public static final class a {
    }

    static {
    }

    public GlobalShareRecordLoadingFactory() {
    }

    @Override // du4.d
    public View a(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.bitable_record_share_loading_skeleton, null);
        RecyclerView r102 = (RecyclerView) r101.findViewById(R.id.recycler_view);
        r102.setAdapter(new GlobalShareRecordLoadingFactory$createLoading$1(r100));
        r102.setLayoutManager(new GlobalShareRecordLoadingFactory$createLoading$2(r100));
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    @Override // du4.d
    public final View b(Context r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new LoadingLayout(r100, r101, r102);
    }
}
