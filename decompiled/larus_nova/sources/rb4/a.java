package rb4;

import android.text.TextUtils;
import com.bytedance.bdturing.EventReport;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.io.InputStream;
import qb4.n;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f536913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f536914b;

    public final void a() {
        String r100 = null;
        SsResponse<TypedInput> r101 = ec4.h.b(this.f536913a.f536934b).doGet(false, this.f536913a.f536934b, null, null).execute();     // Catch: Exception -> L32
        if (r101 != null) goto L6;
    L30:
        String r102 = this.f536913a.f536933a;     // Catch: Exception -> L32
        int r103 = n.f532367a;     // Catch: Exception -> L32
        return;
    L6:
        if (r101.code() != 200) goto L30;
        InputStream r104 = r101.body().in();     // Catch: Exception -> L32
        long r105 = r101.body().length();     // Catch: Exception -> L32
        String r106 = this.f536914b.g();     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r106) == false) goto L11;
        r104.close();     // Catch: Exception -> L32
        return;
    L11:
        StringBuilder r107 = new StringBuilder();     // Catch: Exception -> L32
        r107.append(r106);     // Catch: Exception -> L32
        String r108 = File.separator;     // Catch: Exception -> L32
        r107.append(r108);     // Catch: Exception -> L32
        r107.append(this.f536913a.f536933a);     // Catch: Exception -> L32
        String r109 = r107.toString();     // Catch: Exception -> L32
        hc4.c.e(r109);     // Catch: Exception -> L32
        File r110 = hc4.c.c(r104, r109);     // Catch: Exception -> L32
        if (r110 != null) goto L14;
        return;
    L14:
        if (r110.exists() == true) goto L16;
        return;
    L16:
        if (r110.length() != r105) goto L40;
        String r111 = hc4.c.g(r110);     // Catch: Exception -> L32
        String r112 = this.f536913a.f536933a;     // Catch: Exception -> L32
        int r113 = n.f532367a;     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r111) == false) goto L20;
    L29:
        hc4.c.f(r110);     // Catch: Exception -> L32
        EventReport.u(1, "url=" + this.f536913a.f536934b);     // Catch: Exception -> L32
        String r114 = this.f536913a.f536933a;     // Catch: Exception -> L32
        return;
    L20:
        if (r111.equals(this.f536913a.f536935c) == false) goto L29;
        String r115 = r110.getAbsolutePath();     // Catch: Exception -> L32
        c r116 = this.f536914b;     // Catch: Exception -> L32
        String r117 = this.f536913a.f536933a;     // Catch: Exception -> L32
        r116.getClass();     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r117) == false) goto L36;
    L28:
        hc4.c.d(r115, r100);     // Catch: Exception -> L32
        String r118 = this.f536913a.f536933a;     // Catch: Exception -> L32
        int r119 = n.f532367a;     // Catch: Exception -> L32
        return;
    L36:
        r100 = r116.g() + r108 + c.f(r117);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L32
        goto L28
    L40:
        return;
    L32:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(c r100, h r101) {
        this.f536914b = r100;
        this.f536913a = r101;
    }
}
