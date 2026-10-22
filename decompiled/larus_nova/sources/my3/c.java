package my3;

import android.app.Application;
import com.bytedance.awemeopen.apps.framework.utils.w;
import p24.e;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements tx3.b {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public static void a(String r110, long r111, String r112, String r113, int r114, int r115, int r210, p24.c r211) {
        d14.a r100 = b14.a.f16924a;
        e r101 = (e) b14.a.a(e.class);
        Application r102 = y54.a.a();
        Integer r103 = Integer.valueOf(r115);
        Integer r116 = Integer.valueOf(r210);
        int[] r104 = w.f197747a;
        if (r104 != null) goto L5;
        String r105 = "";
    L6:
        r101.I(r102, r110, r111, r112, r113, r114, r103, r116, r105, r211);
        return;
    L5:
        StringBuilder r106 = new StringBuilder();
        r106.append(r104[0]);
        r106.append('_');
        r106.append(r104[1]);
        r105 = r106.toString();
        goto L6
    }
}
