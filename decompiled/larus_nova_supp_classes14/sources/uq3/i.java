package uq3;

import android.graphics.Color;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final /* synthetic */ int f = 0;
    public ECUrlModel a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;

    public static final class a {
        public static i a(com.bytedance.android.window.shop.repository.dto.r r5) {
            Intrinsics.checkNotNullParameter(r5, "dto");
            String r0 = r5.a();     // Catch: Exception -> L8
            if (r0 != null) goto L6;
            r0 = "#FFFFFFFF";
        L6:
            int r1 = Color.parseColor(r0);     // Catch: Exception -> L8
        L10:
            String r2 = r5.e();
            if (r2 != null) goto L13;
            r2 = "";
        L13:
            i r3 = new i(r2, r1, r5.c(), r5.d());
            r3.a = r5.b();
            return r3;
        L8:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);
            r1 = (int) 4294967295L;
            goto L10
        }
    }

    static {
    }

    public i(String r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
