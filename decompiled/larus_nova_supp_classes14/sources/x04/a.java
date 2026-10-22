package x04;

import android.widget.TextView;
import com.bytedance.awemeopen.infra.util.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final void a(TextView r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setText(k.b(r2));
    }

    public static final void b(TextView r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r6, "zeroDisplayText");
        if (r4 != 0) goto L6;
        r3.setText(r6);
        return;
    L6:
        r3.setText(k.b(r4));
    }
}
