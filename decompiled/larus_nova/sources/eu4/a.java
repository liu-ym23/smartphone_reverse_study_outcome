package eu4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.loading.loadingview.ViewContentLoadingFactory$createLoading$1;
import com.bytedance.ee.bear.bitable.loading.loadingview.ViewContentLoadingFactory$createLoading$2;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements du4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f474064a = null;

    static {
        f474064a = new a();
    }

    public a() {
    }

    @Override // du4.d
    public final View b(Context r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // du4.d
    public final View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinearLayout r101 = new LinearLayout(r100);
        r101.setOrientation(1);
        r101.setBackgroundColor(r100.getColor(R.color.bg_body));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r101.addView(LayoutInflater.from(r100).inflate(R.layout.bitable_header_container_loading_sketelon, null), new LinearLayout.LayoutParams(-1, UIHelper.dp2px(66.0f)));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r101.addView(LayoutInflater.from(r100).inflate(R.layout.bitable_toolbar_loading_skeleton, null), new LinearLayout.LayoutParams(-1, UIHelper.dp2px(48.0f)));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        RecyclerView r102 = new RecyclerView(r100);
        r102.setAdapter(new ViewContentLoadingFactory$createLoading$1(r100));
        r102.setLayoutManager(new ViewContentLoadingFactory$createLoading$2(r100));
        r101.addView(r102, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return r101;
    }
}
