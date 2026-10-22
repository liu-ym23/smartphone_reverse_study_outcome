package pd2;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import mb0.g;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends mb0.a<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528643c;

    public a() {
        this.f528642b = "func2";
        this.f528643c = "1";
    }

    @Override // mb0.a
    public final long c(b r100) {
        b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "param");
        return r101.f528644a.c();
    }

    @Override // mb0.a
    public final /* bridge */ /* synthetic */ void d(String r100, b r101) {
        e(r100, r101);
    }

    public final void e(String r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "param");
        HashMap<String, String> r102 = r101.f528645b;
        if (r102 == null) goto L5;
        r102.put(this.f528642b, this.f528643c);
    L5:
        d r103 = d.f528658n;
        MusicPanel r104 = r101.f528644a;
        HashMap<String, String> r105 = r101.f528645b;
        r103.getClass();
        d.t(r100, r104, r105);
    }

    public final void f(String r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "param");
        d r102 = d.f528658n;
        r102.getClass();
        String r103 = d.P(r100);
        switch(r103.hashCode()) {
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
        Intrinsics.checkNotNullParameter(r103, "path");
        b(c(r101)).add(new g(r103, r101));
        return;
    L6:
        if (r103.equals("check_auth_permission_failed") == false) goto L26;
    L25:
        Intrinsics.checkNotNullParameter(r103, "path");
        Intrinsics.checkNotNullParameter(r101, "param");
        r102.getClass();
        a(d.P(r103), r101);
        return;
    L9:
        if (r103.equals("api_fail") == false) goto L26;
    L12:
        if (r103.equals("song_limt") == false) goto L26;
    L15:
        if (r103.equals("download_failed") == false) goto L26;
    L18:
        if (r103.equals("check_followed_permission_failed") == false) goto L26;
    L21:
        if (r103.equals("start_sing") == false) goto L26;
        e(r103, r101);
        return;
    L24:
        if (r103.equals("success") == false) goto L26;
        goto L25
    }
}
