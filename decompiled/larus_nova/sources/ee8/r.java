package ee8;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class r {
    public static final void a(Bundle r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
    L10:
        if (r102 != null) goto L12;
        return;
    L12:
        if ((!StringsKt.isBlank(r102)) == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L19;
        r100.putString("interaction_agent_type", r102);
        return;
    L19:
        return;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L10;
        r100.putString("interaction_display_type", r101);
        goto L10
    }
}
