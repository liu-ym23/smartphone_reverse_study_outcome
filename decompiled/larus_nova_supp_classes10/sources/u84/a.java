package u84;

import android.content.SharedPreferences;
import com.bytedance.bdnavigationsdk.contants.Constants;
import com.bytedance.bdnavigationsdk.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final tpa.a a;

    /* JADX INFO: renamed from: u84.a$a, reason: collision with other inner class name */
    public static final class C0176a {
    }

    static {
    }

    public a() {
        com.bytedance.bdnavigationsdk.b r0 = d.a;     // Catch: Exception -> L8
        if (d.c == false) goto L7;
        SharedPreferences r1 = com.bytedance.bdnavigationsdk.a.a.getContext().getSharedPreferences(Constants.BDNavigationSDK.getValue(), 0);     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L8
        tpa.a r2 = new tpa.a(r1);     // Catch: Exception -> L8
    L10:
        this.a = r2;
        return;
    L7:
        throw new Exception("BDNAInit尚未初始化");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        r84.a.b("创建 Settings 失败", e, 1);
        r2 = null;
        goto L10
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        tpa.a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }
}
