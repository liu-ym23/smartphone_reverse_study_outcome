package nr3;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.rts.foundation.j;
import com.bytedance.rts.foundation.r;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Deprecated(message = "请使用 com.bytedance.salamander:core 中提供的 RelaxImageRedirectListener")
public final class a implements kpa.a {
    public final Context a;

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final String a(String r6) {
        if (r6 != null) goto L5;
        return r6;
    L5:
        if (r.g(r6, "sl://") == false) goto L21;
        ArrayList r0 = r.f(r.e(r6, 5, r6.length()), "/", -1);
        if (j.d(r0) != 2) goto L22;
        String r7 = (String) ListProtector.get(r0, 0);
        String r1 = (String) ListProtector.get(r0, 1);
        Context r2 = this.a;
        Integer r3 = null;
        Context r4 = null;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r2 = null;
    L12:
        Resources r5 = r2.getResources();
        if (r5 == null) goto L20;
        Context r8 = this.a;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L18:
        r3 = Integer.valueOf(r5.getIdentifier(r1, r7, r4.getPackageName()));
        goto L20
    L17:
        r4 = r8;
    L20:
        return "res:///" + r3;
    L22:
        return r6;
    L21:
        return r6;
    }
}
