package dr9;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.platform.model.preview.ResourceRefKind;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static final String a(ResourceRef r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getKind() == ResourceRefKind.LOCAL_URI) goto L6;
        return null;
    L6:
        if (StringsKt.startsWith$default(r100.getUri(), HTTP.URL_DEFAULT, false, 2, null) == false) goto L9;
        return r100.getUri();
    L9:
        if (StringsKt.equals(UriProtector.parse(r100.getUri()).getScheme(), "file", true) == true) goto L11;
        return null;
    L11:
        return UriProtector.parse(r100.getUri()).getPath();
    }

    public static final ResourceRef b(String r100, String r101, int r110, int r111) {
        if (r100 != null) goto L5;
    L44:
        if (r101 != null) goto L46;
        return null;
    L46:
        if ((!StringsKt.isBlank(r101)) == false) goto L48;
        String r102 = r101;
    L49:
        if (r102 != null) goto L51;
        return null;
    L51:
        return new ResourceRef(r102, ResourceRefKind.REMOTE_KEY, r102, r110, r111);
    L48:
        r102 = null;
        goto L49
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        String r103 = r100;
    L8:
        if (r103 == null) goto L44;
        if (StringsKt.startsWith$default(r103, HTTP.URL_DEFAULT, false, 2, null) == false) goto L14;
        ResourceRefKind r104 = ResourceRefKind.LOCAL_URI;
    L13:
        ResourceRefKind r105 = r104;
        if (r101 != null) goto L38;
    L40:
        String r106 = null;
    L42:
        return new ResourceRef(r103, r105, r106, r110, r111);
    L38:
        if ((!StringsKt.isBlank(r101)) == false) goto L40;
        r106 = r101;
        goto L42
    L14:
        String r107 = UriProtector.parse(r103).getScheme();
        if (r107 == null) goto L17;
        String r108 = r107.toLowerCase(Locale.ROOT);
    L18:
        if (r108 != null) goto L20;
    L43:
        return null;
    L20:
        switch(r108.hashCode()) {
            case 3143036: goto L33;
            case 3213448: goto L29;
            case 99617003: goto L26;
            case 951530617: goto L23;
            default: goto L43;
        };
    L23:
        if (r108.equals("content") == false) goto L43;
    L35:
        r104 = ResourceRefKind.LOCAL_URI;
        goto L13
    L26:
        if (r108.equals("https") == false) goto L43;
    L31:
        r104 = ResourceRefKind.REMOTE_URL;
        goto L13
    L29:
        if (r108.equals("http") == true) goto L31;
    L33:
        if (r108.equals("file") == true) goto L35;
    L17:
        r108 = null;
        goto L18
    L7:
        r103 = null;
        goto L8
    }

    public static /* synthetic */ ResourceRef c(String r100, int r101, int r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 8) == 0) goto L9;
        r102 = 0;
    L9:
        return b(r100, null, r101, r102);
    }
}
