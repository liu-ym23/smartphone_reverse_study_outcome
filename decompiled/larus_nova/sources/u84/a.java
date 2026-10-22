package u84;

import android.content.SharedPreferences;
import com.bytedance.bdnavigationsdk.contants.Constants;
import com.bytedance.bdnavigationsdk.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tpa.a f549176a;

    /* JADX INFO: renamed from: u84.a$a, reason: collision with other inner class name */
    public static final class C7846a {
    }

    static {
    }

    public a() {
        com.bytedance.bdnavigationsdk.b r100 = d.f200007a;     // Catch: Exception -> L8
        if (d.f200009c == false) goto L7;
        SharedPreferences r101 = com.bytedance.bdnavigationsdk.a.f199985a.getContext().getSharedPreferences(Constants.BDNavigationSDK.getValue(), 0);     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L8
        tpa.a r102 = new tpa.a(r101);     // Catch: Exception -> L8
    L10:
        this.f549176a = r102;
        return;
    L7:
        throw new Exception("BDNAInit尚未初始化");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        r84.a.b("创建 Settings 失败", e, 1);
        r102 = null;
        goto L10
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        tpa.a r101 = this.f549176a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }
}
