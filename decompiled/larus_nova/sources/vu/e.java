package vu;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, c> f557316b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f557317a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f557318a = null;

        static {
            f557318a = new e();
        }
    }

    public e() {
    }

    static {
        HashMap r100 = new HashMap();
        f557316b = r100;
        r100.put("VIVO", new g());
        r100.put("MEIZU", new d());
        r100.put(SystemUtils.PRODUCT_HUAWEI, new b());
        r100.put("XIAOMI", new h());
        r100.put("OPPO", new f());
    }

    public final c c() {
        if (this.f557317a != null) goto L10;
        this.f557317a = new vu.a();
        String r100 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r100) == true) goto L10;
        String r101 = r100.toUpperCase(Locale.getDefault());
        Map<String, c> r102 = f557316b;
        if (((HashMap) r102).containsKey(r101) == false) goto L10;
        this.f557317a = (c) ((HashMap) r102).get(r101);
    L10:
        return this.f557317a;
    }

    @Override // vu.c
    public final boolean b() {
        return c().b();
    }

    @Override // vu.c
    public final Intent a(Context r100) {
        return c().a(r100);
    }
}
