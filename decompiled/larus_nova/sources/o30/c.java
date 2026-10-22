package o30;

import android.net.Uri;
import com.bytedance.android.live.browser.service.AnnieExternalServiceImpl;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f521865b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ff1.a> f521866a;

    static {
        f521865b = new c();
    }

    public c() {
        LinkedList r100 = new LinkedList();
        this.f521866a = r100;
        r100.add(new d());
        r100.add(new b());
        r100.add(new a());
    }

    public static String a(String r100) {
        Uri.Builder r101 = UriProtector.parse("liveresource://file").buildUpon();
        r101.scheme("liveresource").appendQueryParameter("path", r100);
        return r101.build().toString();
    }

    public final void b(String r100) {
        Iterator<ff1.a> r101 = this.f521866a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        ff1.a r102 = r101.next();
        if ((r102 instanceof a) == false) goto L4;
        a r103 = (a) r102;
        r103.getClass();
        r103.f521864a = r100 + File.separator;
        goto L4
    L8:
        String r104 = AnnieExternalServiceImpl.f64265b;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        AnnieExternalServiceImpl.f64265b = r100;
    }
}
