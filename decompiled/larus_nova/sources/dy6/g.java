package dy6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.l;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class g extends e<Integer> {
    @Override // dy6.e
    public final Integer c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "string");
        Integer r100 = null;
    L20:
        String r111 = StringsKt.replace$default(r110, "#", "", false, 4, null);     // Catch: Exception -> L37
        gq6.a r101 = l.e(Dito.f257280a);     // Catch: Exception -> L37
        if (r101 == null) goto L25;
        r101.e();     // Catch: Exception -> L37
        Context r102 = en6.a.f473165a.b();     // Catch: Exception -> L37
    L26:
        if (r102 == null) goto L30;
        Resources r103 = r102.getResources();     // Catch: Exception -> L37
        if (r103 == null) goto L30;
        Integer r112 = Integer.valueOf(r103.getIdentifier(r111, "color", r102.getPackageName()));     // Catch: Exception -> L37
    L31:
        if (r102 == null) goto L36;
        Resources r104 = r102.getResources();     // Catch: Exception -> L37
        if (r104 == null) goto L36;
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L37
        r100 = Integer.valueOf(r104.getColor(r112.intValue()));     // Catch: Exception -> L37
    L30:
        r112 = null;
        goto L31
    L25:
        r102 = null;
        goto L26
    L4:
        if (StringsKt.startsWith$default(r110, "#", false, 2, null) == false) goto L6;
        String r105 = r110.substring(1);     // Catch: Exception -> L20
    L7:
        int r106 = r105.length();     // Catch: Exception -> L20
        if (r106 != 3) goto L11;
        r105 = "#FF" + r105.charAt(0) + r105.charAt(0) + r105.charAt(1) + r105.charAt(1) + r105.charAt(2) + r105.charAt(2);     // Catch: Exception -> L20
    L18:
        return Integer.valueOf(Color.parseColor(r105));
    L11:
        if (r106 != 6) goto L13;
        r105 = "#FF".concat(r105);     // Catch: Exception -> L20
        goto L18
    L13:
        if (r106 != 8) goto L18;
        r105 = "#" + StringsKt.takeLast(r105, 2) + StringsKt.dropLast(r105, 2);     // Catch: Exception -> L20
        goto L18
    L6:
        r105 = r110;
    L36:
        return r100;
    }

    public g(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        a(r100, r101, null);
    }
}
