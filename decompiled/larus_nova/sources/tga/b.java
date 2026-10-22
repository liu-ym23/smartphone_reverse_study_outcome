package tga;

import com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f545914a = null;

    static {
        f545914a = LazyKt.lazy(new a());
    }

    public static String a() {
        IObricPrivacyAndPermissionUiService r100 = (IObricPrivacyAndPermissionUiService) f545914a.getValue();
        if (r100 == null) goto L5;
        String r101 = r100.a();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }
}
