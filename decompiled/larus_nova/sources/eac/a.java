package eac;

import android.content.Context;
import b1c.c;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.g;
import com.ss.android.lark.sp.AbstractSharedPreferences;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends AbstractSharedPreferences {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f471765b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f471766a;

    public static synchronized a a() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f471765b != null) goto L7;
        f471765b = new a();     // Catch: Throwable -> L10
    L7:
        a r100 = f471765b;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r100;
    }

    public a() {
        Context r100 = g.getContext();
        b1c.b r101 = new b1c.b(r100);
        this.f471766a = r101.a("lark");
        c r102 = null;
        m4c.a.C6771a r103 = null;
        if (DevEnvUtil.isDebugMode(r100) == false) goto L11;
    L9:
        setBaseSharedPreferences(g5c.c.a(r100, "lark", r102, r101));
        return;
    L11:
        v8b.a.a().getClass();     // Catch: GeneralSecurityException -> L6
        r103 = m4c.b.a.f511910a.b();     // Catch: GeneralSecurityException -> L6
    L8:
        r102 = new c(r100, r103, this.f471766a);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // com.ss.android.lark.sp.AbstractSharedPreferences
    public final String getSpName() {
        return this.f471766a;
    }
}
