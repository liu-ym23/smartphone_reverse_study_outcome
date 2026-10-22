package qj3;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends LinearLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f533292d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f533293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f533294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f533295c;

    public static final class a {
    }

    static {
        f533292d = com.bytedance.android.shopping.extensions.b.b(12);
    }

    public final ImageView getLeftImage() {
        return this.f533293a;
    }

    public final ImageView getRightImage() {
        return this.f533295c;
    }

    public final TextView getTextView() {
        return this.f533294b;
    }

    public c(Context r100) {
        int r101 = com.bytedance.android.shopping.extensions.b.b(44);
        int r102 = com.bytedance.android.shopping.extensions.b.b(8);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setGravity(17);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ImageView r103 = new ImageView(r100);
        ViewGroup.LayoutParams r104 = new LinearLayout.LayoutParams(r101, r102);
        r103.setImageResource(R.drawable.ec_store_ic_arrow_store_recommend_notice);
        r103.setAdjustViewBounds(true);
        addView(r103, r104);
        Unit r105 = Unit.INSTANCE;
        this.f533293a = r103;
        TextView r106 = new TextView(r100);
        r106.setTypeface(Typeface.DEFAULT_BOLD);
        r106.setTextColor(-15329245);
        r106.setTextSize(2, 15.0f);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        int r108 = f533292d;
        r107.leftMargin = r108;
        r107.rightMargin = r108;
        addView(r106, r107);
        this.f533294b = r106;
        ImageView r109 = new ImageView(r100);
        r109.setScaleX(-1.0f);
        r109.setImageResource(R.drawable.ec_store_ic_arrow_store_recommend_notice);
        r109.setAdjustViewBounds(true);
        addView(r109, new LinearLayout.LayoutParams(r101, r102));
        this.f533295c = r109;
    }

    public final void setLeftImage(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f533293a = r100;
    }

    public final void setRightImage(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f533295c = r100;
    }

    public final void setTextView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f533294b = r100;
    }
}
