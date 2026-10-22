package dvc;

import javax.annotation.Nullable;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Request f470238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Response f470239b;

    public d(Request r100, Response r101) {
        this.f470238a = r100;
        this.f470239b = r101;
    }

    public static boolean a(Response r100, Request r101) {
        int r102 = r100.code();
        if (r102 == 200) goto L35;
        if (r102 == 410) goto L35;
        if (r102 == 414) goto L35;
        if (r102 == 501) goto L35;
        if (r102 == 203) goto L35;
        if (r102 == 204) goto L35;
        if (r102 == 307) goto L25;
        if (r102 == 308) goto L35;
        if (r102 == 404) goto L35;
        if (r102 == 405) goto L35;
        switch(r102) {
            case 300: goto L35;
            case 301: goto L35;
            case 302: goto L25;
            default: goto L33;
        };
    L33:
        return false;
    L25:
        if (r100.header("Expires") != null) goto L35;
        if (r100.cacheControl().maxAgeSeconds() != (-1)) goto L35;
        if (r100.cacheControl().isPublic() == true) goto L35;
        if (r100.cacheControl().isPrivate() == false) goto L33;
    L35:
        if (r100.cacheControl().noStore() == false) goto L37;
        return false;
    L37:
        if (r101.cacheControl().noStore() == true) goto L41;
        return true;
    L41:
        return false;
    }
}
