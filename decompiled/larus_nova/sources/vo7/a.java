package vo7;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.List;
import xo7.d;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f556507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f556508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f556509c;

    /* JADX INFO: renamed from: vo7.a$a, reason: collision with other inner class name */
    public static class C8028a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f556510a = null;

        static {
            f556510a = new a();
        }
    }

    public a() {
        this.f556507a = "";
    }

    public final void a(List<String> r100) {
        d r101 = bp7.a.C0335a.f19983a.f19980c;
        if (r101 == null) goto L5;
        r101.j();
        String r102 = "ro.channel.com.larus.nova";
    L6:
        String r103 = bp7.a.c(r102);
        if (TextUtils.isEmpty(r103) == true) goto L20;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103);
        if (r104.exists() == true) goto L11;
    L18:
        this.f556507a = r103;
        return;
    L11:
        if (r104.canRead() == false) goto L18;
        if (r104.isFile() == false) goto L18;
        ArrayList r105 = (ArrayList) r100;
        if (r105.contains(r103) == true) goto L21;
        r105.add(r103);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r102 = "";
        goto L6
    }
}
