package pd2;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import mb0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends mb0.a<b> {
    public final String b;
    public final String c;

    public a() {
        this.b = "func2";
        this.c = "1";
    }

    public final long c(Object r3) {
        b r4 = (b) r3;
        Intrinsics.checkNotNullParameter(r4, "param");
        return r4.a.c();
    }

    public final /* bridge */ /* synthetic */ void d(String r1, Object r2) {
        e(r1, (b) r2);
    }

    public final void e(String r4, b r5) {
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r5, "param");
        HashMap<String, String> r0 = r5.b;
        if (r0 == null) goto L5;
        r0.put(this.b, this.c);
    L5:
        d r1 = d.n;
        MusicPanel r2 = r5.a;
        HashMap<String, String> r6 = r5.b;
        r1.getClass();
        d.t(r4, r2, r6);
    }

    public final void f(String r5, b r6) {
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "param");
        d r2 = d.n;
        r2.getClass();
        String r7 = d.P(r5);
        switch(r7.hashCode()) {
            case -1867169789: goto L24;
            case -1573175220: goto L21;
            case -263387179: goto L18;
            case 156934100: goto L15;
            case 360601806: goto L12;
            case 967005731: goto L9;
            case 1717498605: goto L6;
            default: goto L26;
        };
    L26:
        Intrinsics.checkNotNullParameter(r7, "path");
        b(c(r6)).add(new g(r7, r6));
        return;
    L6:
        if (r7.equals("check_auth_permission_failed") == false) goto L26;
    L25:
        Intrinsics.checkNotNullParameter(r7, "path");
        Intrinsics.checkNotNullParameter(r6, "param");
        r2.getClass();
        a(d.P(r7), r6);
        return;
    L9:
        if (r7.equals("api_fail") == false) goto L26;
    L12:
        if (r7.equals("song_limt") == false) goto L26;
    L15:
        if (r7.equals("download_failed") == false) goto L26;
    L18:
        if (r7.equals("check_followed_permission_failed") == false) goto L26;
    L21:
        if (r7.equals("start_sing") == false) goto L26;
        e(r7, r6);
        return;
    L24:
        if (r7.equals("success") == false) goto L26;
        goto L25
    }
}
