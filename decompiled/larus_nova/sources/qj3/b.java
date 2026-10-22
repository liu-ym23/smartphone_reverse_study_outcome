package qj3;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f533291a;

    public static final class a {
    }

    static {
    }

    public final TextView getTextView() {
        return this.f533291a;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setGravity(17);
        TextView r101 = new TextView(r100);
        r101.setText(R.string.ec_store_has_shown_all_products);
        r101.setTextColor(CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR);
        r101.setTextSize(1, 12.0f);
        Unit r102 = Unit.INSTANCE;
        r101.setGravity(17);
        addView(r101, new LinearLayout.LayoutParams(-1, ExtensionsKt.a(16)));
        this.f533291a = r101;
    }

    public final void setTextView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f533291a = r100;
    }
}
