package pta;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.n;
import com.bytedance.bdinstall.o0;
import i84.h;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static C7245a f530683a;

    /* JADX INFO: renamed from: pta.a$a, reason: collision with other inner class name */
    public static class C7245a extends e<String> {
        public C7245a() {
        }

        @Override // pta.e
        public final String a(Object[] r100) {
            if (r100[0] != null) goto L5;
            return null;
        L5:
            String r101 = h.c();
            SharedPreferences r102 = ((Context) r100[0]).getSharedPreferences(r101, 0);
            String r103 = r102.getString("cdid", "");
            if (TextUtils.isEmpty(r103) == false) goto L9;
            r103 = UUID.randomUUID().toString();
            r102.edit().putString("cdid", r103).apply();
        L9:
            return r103;
        }
    }

    static {
        f530683a = new C7245a();
    }

    public static String a(Context r100) {
        o0 r101 = i.f199652b.f199674a;
        if (r101 == null) goto L5;
        String r102 = n.b(r101);
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        return f530683a.b(new Object[]{r100});
    L5:
        r102 = null;
        goto L6
    }
}
