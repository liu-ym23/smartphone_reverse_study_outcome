package x04;

import android.widget.TextView;
import com.bytedance.awemeopen.infra.util.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static final void a(TextView r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setText(k.b(r101));
    }

    public static final void b(TextView r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "zeroDisplayText");
        if (r101 != 0) goto L6;
        r100.setText(r102);
        return;
    L6:
        r100.setText(k.b(r101));
    }
}
