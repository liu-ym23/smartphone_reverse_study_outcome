package w;

import bytedance.io.BdFile;
import bytedance.io.exception.IllegalPathException;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<y.b> f557763a;

    /* JADX INFO: renamed from: w.a$a, reason: collision with other inner class name */
    public static class C8054a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f557764a = null;

        static {
            f557764a = new a();
        }
    }

    public a() {
        this.f557763a = new LinkedList();
    }

    public static BdFile a(File r100) throws IllegalPathException {
        if ((r100 instanceof BdFile) == false) goto L7;
        return (BdFile) r100;
    L7:
        return new BdFile(r100.getPath());
    }

    public final String b(String r100) throws IllegalPathException {
        if (r100 != null) goto L4;
        return r100;
    L4:
        y.a r101 = new y.a(r100);
        return new b(this.f557763a, 0).a(r101).f565555a;
    }

    public final String c(String r100, String r101) throws IllegalPathException {
        if (r101 != null) goto L4;
        return r101;
    L4:
        if (r100 == null) goto L23;
        if (r100.isEmpty() == true) goto L23;
        if (r101.isEmpty() == true) goto L21;
        if (r101.equals(HTTP.URL_DEFAULT) == true) goto L21;
        if (r101.charAt(0) == '/') goto L15;
    L18:
        y.a r102 = new y.a(r100, r101);
        return new b(this.f557763a, 0).a(r102).f565555a;
    L15:
        if (r100.equals(HTTP.URL_DEFAULT) == false) goto L18;
        return b(r101);
    L21:
        return b(r100);
    L23:
        return b(r101);
    }
}
