package y1c;

import android.content.Context;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.g;
import com.ss.android.lark.sp.AbstractSharedPreferences;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes37.dex */
public final class b extends AbstractSharedPreferences {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f565681b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f565682a;

    public b() {
        Context r100 = g.getContext();
        this.f565682a = new b1c.b(r100).a("lark");
        b1c.c r101 = null;
        m4c.a.C6771a r102 = null;
        if (DevEnvUtil.isDebugMode(r100) == false) goto L11;
    L9:
        setBaseSharedPreferences(new h5c.a(r100.getSharedPreferences("lark", 0), r101));
        return;
    L11:
        v8b.a.a().getClass();     // Catch: GeneralSecurityException -> L6
        r102 = m4c.b.a.f511910a.b();     // Catch: GeneralSecurityException -> L6
    L8:
        r101 = new b1c.c(r100, r102, this.f565682a);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // com.ss.android.lark.sp.AbstractSharedPreferences
    public final String getSpName() {
        return this.f565682a;
    }
}
