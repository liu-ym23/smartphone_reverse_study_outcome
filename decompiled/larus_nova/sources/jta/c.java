package jta;

import android.os.Environment;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.io.IOUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f500360a;

    public final void a() {
        ArrayList r100 = new ArrayList();
    L12:
        th = move-exception;
        th.printStackTrace();
    L15:
        if (this.f500360a.f500362b == false) goto L42;
    L27:
        Iterator r101 = r100.iterator();
    L29:
        if (r101.hasNext() == false) goto L35;
        IOUtils.deletePath((String) r101.next());     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.printStackTrace();
        goto L29
    L35:
        return;
    L42:
        r100.add(Environment.getExternalStorageDirectory().getPath() + nta.d.a("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));     // Catch: Throwable -> L18
    L36:
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L25
        r102.append(Environment.getExternalStorageDirectory().getPath());     // Catch: Throwable -> L25
        r102.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(nta.d.f520542a) == false) goto L23;
        nta.d.f520542a = nta.d.a("Ynl0ZWRhbmNl");     // Catch: Throwable -> L25
    L23:
        r102.append(nta.d.f520542a);     // Catch: Throwable -> L25
        r100.add(r102.toString());     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L4:
        if (this.f500360a.f500362b == false) goto L7;
        String r103 = "device_id";
    L10:
        r100.add(this.f500360a.f500361a.getExternalCacheDir().getParent() + HTTP.URL_DEFAULT + r103);     // Catch: Throwable -> L12
        goto L15
    L7:
        if (TextUtils.isEmpty(nta.d.f520542a) == false) goto L9;
        nta.d.f520542a = nta.d.a("Ynl0ZWRhbmNl");     // Catch: Throwable -> L12
    L9:
        r103 = nta.d.f520542a;     // Catch: Throwable -> L12
        goto L10
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

    public c(d r100) {
        this.f500360a = r100;
    }
}
