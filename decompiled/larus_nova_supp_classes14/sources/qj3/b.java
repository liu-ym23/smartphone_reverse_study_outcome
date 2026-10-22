package qj3;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends LinearLayout {
    public TextView a;

    public static final class a {
    }

    static {
    }

    public final TextView getTextView() {
        return this.a;
    }

    public b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        setGravity(17);
        TextView r1 = new TextView(r4);
        r1.setText(2131896854);
        r1.setTextColor(1461065763);
        r1.setTextSize(1, 12.0f);
        Unit r5 = Unit.INSTANCE;
        r1.setGravity(17);
        addView(r1, new LinearLayout.LayoutParams(-1, ExtensionsKt.a(16)));
        this.a = r1;
    }

    public final void setTextView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}
