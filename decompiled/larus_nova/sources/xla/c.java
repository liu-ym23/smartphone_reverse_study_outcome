package xla;

import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class c {
    public static final void a(TextView r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "message");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (StringsKt.contains$default(r101, '\n', false, 2, null) == false) goto L5;
        r102.width = -1;
    L6:
        r100.setLayoutParams(r102);
        return;
    L5:
        r102.width = -2;
        goto L6
    }
}
