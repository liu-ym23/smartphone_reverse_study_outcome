package xkc;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public final class g extends k {
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public j call2() throws Exception {
        InetAddress[] r100 = InetAddress.getAllByName(this.f564428a);     // Catch: UnknownHostException -> L30
        ArrayList r101 = new ArrayList();     // Catch: UnknownHostException -> L30
        if (r100 == null) goto L26;
        if (r100.length <= 0) goto L26;
        int r102 = r100.length;     // Catch: UnknownHostException -> L30
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L26;
        String r104 = r100[r103].getHostAddress();     // Catch: UnknownHostException -> L30
        if (k.f564427b != null) goto L12;
        k.f564427b = PatternProtector.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");     // Catch: UnknownHostException -> L30
    L12:
        if (TextUtils.isEmpty(r104) == false) goto L14;
    L20:
        boolean r105 = false;
    L21:
        if (r105 == false) goto L24;
        r101.add(r104);     // Catch: UnknownHostException -> L30
    L24:
        r103 = r103 + 1;     // Catch: UnknownHostException -> L30
        goto L7
    L14:
        if (r104.length() < 7) goto L20;
        if (r104.length() > 15) goto L20;
        if (k.f564427b.matcher(r104).matches() == false) goto L20;
        r105 = true;
    L26:
        if (h.f564418a == false) goto L28;
        r101.toString();     // Catch: UnknownHostException -> L30
        h.a();     // Catch: UnknownHostException -> L30
    L28:
        return new j(this.f564428a, r101);
    L30:
        e = move-exception;
        e.printStackTrace();
        if (h.f564418a == false) goto L35;
        h.a();
    L35:
        return new j(this.f564428a, null);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ j call() throws Exception {
        return call2();
    }

    public g(String r100) {
        super(r100);
    }
}
