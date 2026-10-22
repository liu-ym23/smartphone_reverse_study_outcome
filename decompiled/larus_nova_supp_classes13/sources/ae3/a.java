package ae3;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.bytedance.android.shopping.extensions.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static void a(Context r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "content");
        FrameLayout r0 = new FrameLayout(r5);
        r0.setPadding(b.b(16), b.b(10), b.b(16), b.b(10));
        r0.setBackgroundResource(2131233423);
        TextView r1 = new TextView(r5);
        r1.setText(r6);
        r1.setTextColor(ContextCompat.getColor(r5, 2131100037));
        r1.setTextSize(14.0f);
        r0.addView(r1);
        Toast r8 = new Toast(r5);
        r8.setGravity(17, 0, 0);
        r8.setDuration(r7);
        r8.setView(r0);
        r8.show();
    }
}
