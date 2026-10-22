package ita;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<eua.c> f495754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495755b;

    public final String d() {
        if (((ArrayList) this.f495754a).isEmpty() == true) goto L5;
        List<eua.c> r100 = this.f495754a;
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = ((ArrayList) r100).iterator();
    L8:
        if (r102.hasNext() == false) goto L26;
        cua.c r103 = (cua.c) r102.next();
        String r104 = URLEncoder.encode(r103.getName(), "UTF-8");     // Catch: UnsupportedEncodingException -> L23
        String r105 = r103.getValue();
        if (r105 != null) goto L39;
        String r106 = "";
    L20:
        if (r101.length() <= 0) goto L22;
        r101.append("&");
    L22:
        r101.append(r104);
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(r106);
        goto L8
    L39:
        r106 = URLEncoder.encode(r105, "UTF-8");     // Catch: UnsupportedEncodingException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L23:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L26:
        String r107 = r101.toString();
        String r108 = this.f495755b;
        if (r108 != null) goto L29;
        return r107;
    L29:
        if (r108.length() != 0) goto L32;
        return r107;
    L32:
        if (this.f495755b.indexOf(63) < 0) goto L36;
        return this.f495755b + "&" + r107;
    L36:
        return this.f495755b + "?" + r107;
    L5:
        return this.f495755b;
    }

    public final String toString() {
        return d();
    }

    public l(String r100) {
        this.f495754a = new ArrayList();
        this.f495755b = r100;
    }

    public final void a(String r100, int r101) {
        List<eua.c> r102 = this.f495754a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new eua.c(r100, String.valueOf(r101)));
    }

    public final void b(String r100, long r101) {
        List<eua.c> r102 = this.f495754a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new eua.c(r100, String.valueOf(r101)));
    }

    public final void c(String r100, String r101) {
        List<eua.c> r102 = this.f495754a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new eua.c(r100, r101));
    }
}
