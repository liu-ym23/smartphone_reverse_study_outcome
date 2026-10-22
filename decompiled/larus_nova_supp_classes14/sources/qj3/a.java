package qj3;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends LinearLayout {
    public TextView a;
    public c b;

    /* JADX INFO: renamed from: qj3.a$a, reason: collision with other inner class name */
    public static final class C0156a {
    }

    static {
    }

    public final c getRecommendHeader() {
        return this.b;
    }

    public final TextView getTextView() {
        return this.a;
    }

    public a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        setGravity(17);
        TextView r0 = new TextView(r5);
        r0.setTextColor(1461065763);
        r0.setTextSize(1, 12.0f);
        r0.setPadding(0, 0, 0, com.bytedance.android.shopping.extensions.b.b(10));
        Unit r1 = Unit.INSTANCE;
        addView(r0, new LinearLayout.LayoutParams(-2, -2));
        this.a = r0;
        c r2 = new c(r5);
        r2.setPadding(0, com.bytedance.android.shopping.extensions.b.b(16), 0, 0);
        this.b = r2;
        addView(r2, new LinearLayout.LayoutParams(-2, -2));
    }

    public final void setRecommendHeader(c r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setTextView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}
