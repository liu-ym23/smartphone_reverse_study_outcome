package pc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerSource;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class g {
    public static final String a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.f528572e;
        if (r101 == null) goto L15;
        String r102 = StringsKt.trim(r101).toString();
        if (r102 == null) goto L16;
        boolean r103 = true;
        if ((!StringsKt.isBlank(r102)) == true) goto L9;
    L11:
        r103 = false;
    L12:
        if (r103 == true) goto L14;
        return null;
    L14:
        return r102;
    L9:
        if (Intrinsics.areEqual(r102, "-1") == true) goto L11;
    L16:
        return null;
    L15:
        return null;
    }

    public static final sc8.b b(e r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        d r100 = r110.f528577b;
        String r101 = r100.f528570c;
        String r102 = r110.f528576a;
        String r103 = r100.f528569b;
        String r104 = r110.b();
        d r105 = r110.f528577b;
        com.larus.bmhome.chat.bubble.floating.a r106 = r105.f528571d;
        String r107 = r106.f297481b;
        if (r107 != null) goto L5;
        r107 = "";
    L5:
        String r108 = r106.f297483d;
        String r109 = r106.f297482c;
        String r111 = r106.f297484e;
        h r112 = r105.f528573f;
        long r113 = r112.f528594c;
        int r114 = r112.f528597f;
        BubbleBannerSource r115 = r105.f528568a;
        c r116 = r105.f528574g;
        if (r116 == null) goto L8;
        Map<String, String> r117 = r116.f528567d;
    L10:
        return new sc8.b(r101, r102, r103, r104, r107, r108, r109, r111, r113, r114, r115, r116, r117);
    L8:
        r117 = null;
        goto L10
    }
}
