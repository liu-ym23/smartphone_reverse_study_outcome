package uh4;

import android.text.TextUtils;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileWrapper f550090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f550092c;

    public final boolean a() {
        if (this.f550090a.exists() == true) goto L22;
        return true;
    L22:
        long r100 = System.currentTimeMillis() / 1000;     // Catch: IOException -> L19
        long r101 = CastLongProtector.parseLong(h.d(this.f550090a.getAbsolutePath()));     // Catch: IOException -> L19
        if (r100 >= r101) goto L8;
        p.e(this.f550091b + ": time error currentTime is earlier than lastTime");     // Catch: IOException -> L19
        return false;
    L8:
        if ((r100 - r101) >= this.f550092c) goto L11;
        p.e(this.f550091b + ": CheckTime Less than " + this.f550092c + " seconds, lastTime:" + r101 + " currentTime:" + r100);     // Catch: IOException -> L19
        return false;
    L11:
        String r102 = this.f550090a.getAbsolutePath();     // Catch: IOException -> L19
        if (TextUtils.isEmpty(r102) == true) goto L15;
        h.b(new PolarisFileWrapper(r102));     // Catch: IOException -> L19
    L15:
        p.e(this.f550091b + ": deleteFile guard file");     // Catch: IOException -> L19
        return true;
    L19:
        p.e(this.f550091b + ": read guard file faild!");
        return false;
    }

    public final void b() {
        h.h(this.f550090a, String.valueOf(System.currentTimeMillis() / 1000), false);     // Catch: Throwable -> L4
        p.e(this.f550091b + ": createGuardFile success");     // Catch: Throwable -> L4
        return;
    L4:
        p.e(this.f550091b + ": createGuardFile fail");
    }

    public a(String r100, String r101) {
        this.f550090a = new PolarisFileWrapper(r100, r101);
        this.f550091b = r101;
        this.f550092c = 604800;
    }
}
