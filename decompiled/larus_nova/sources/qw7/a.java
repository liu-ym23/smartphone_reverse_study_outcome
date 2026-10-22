package qw7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import dxc.c;
import exc.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f535032a;

    public a() {
    }

    public static void a(Context r100) {
        e.c("SDKAccountManager", "init SDKAccountManager");
        List<dxc.a> r101 = c.f470511a;
        monitor-enter(c.class);
        String r102 = cxc.a.a(r100);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r102) == false) goto L22;
    L9:
        int r103 = -1;
    L11:
        if (r103 >= 3) goto L16;
        Iterator r104 = ((ArrayList) c.f470511a).iterator();     // Catch: Throwable -> L19
    L14:
        if (r104.hasNext() == false) goto L16;
        ((dxc.a) r104.next()).a(r100, r103);     // Catch: Throwable -> L19
    L16:
        cxc.a.f(r100, String.valueOf(3));     // Catch: Throwable -> L19
        monitor-exit(c.class);
        return;
    L22:
        r103 = CastIntegerProtector.parseInt(r102);     // Catch: Exception -> L8 Throwable -> L19
    L8:
        e.b("VersionUpdateHelper", "parse encryptversion error:");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }
}
