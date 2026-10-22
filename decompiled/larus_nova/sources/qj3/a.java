package qj3;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.utils.CJPayLargeScreenUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f533289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f533290b;

    /* JADX INFO: renamed from: qj3.a$a, reason: collision with other inner class name */
    public static final class C7335a {
    }

    static {
    }

    public final c getRecommendHeader() {
        return this.f533290b;
    }

    public final TextView getTextView() {
        return this.f533289a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setGravity(17);
        TextView r101 = new TextView(r100);
        r101.setTextColor(CJPayLargeScreenUtils.LARGE_SCREEN_MASK_COLOR);
        r101.setTextSize(1, 12.0f);
        r101.setPadding(0, 0, 0, com.bytedance.android.shopping.extensions.b.b(10));
        Unit r102 = Unit.INSTANCE;
        addView(r101, new LinearLayout.LayoutParams(-2, -2));
        this.f533289a = r101;
        c r103 = new c(r100);
        r103.setPadding(0, com.bytedance.android.shopping.extensions.b.b(16), 0, 0);
        this.f533290b = r103;
        addView(r103, new LinearLayout.LayoutParams(-2, -2));
    }

    public final void setRecommendHeader(c r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f533290b = r100;
    }

    public final void setTextView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f533289a = r100;
    }
}
