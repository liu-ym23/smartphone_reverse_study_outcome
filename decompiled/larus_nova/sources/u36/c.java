package u36;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.e;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y36.p;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends e {
    @Override // t36.e
    public final String getName() {
        return "FallbackUrl";
    }

    public c() {
    }

    @Override // t36.e
    public final boolean b(com.bytedance.ies.bullet.service.sdk.d r110) {
        Intrinsics.checkNotNullParameter(r110, "schemaData");
        String r100 = (String) ((LinkedHashMap) r110.f248139p).get("fallback_url");
        if (r100 == null) goto L22;
        int r101 = StringsKt.indexOf$default(r100, '#', 0, false, 6, null);
        if (r101 != (-1)) goto L7;
        String r102 = r100;
    L8:
        if (r101 != (-1)) goto L10;
        String r103 = "";
    L11:
        StringBuilder r104 = new StringBuilder(r102);
        if (StringsKt.contains$default(r102, '?', false, 2, null) == true) goto L14;
        r104.append('?');
    L14:
        r104.append("&prev_kit_type=");
        r104.append(KitType.LYNX.name());
        String r105 = (String) ((LinkedHashMap) r110.f248139p).get("url");
        if (r105 == null) goto L21;
        int r106 = StringsKt.indexOf$default(r105, '?', 0, false, 6, null);
        r104.append("&prev_url=");
        if (r106 == (-1)) goto L20;
        r105 = r105.substring(0, r106);
    L20:
        r104.append(Uri.encode(r105));
    L21:
        r104.append(r103);
        r110.a("fallback_url", new p(r104.toString()), true);
        goto L22
    L10:
        r103 = r100.substring(r101, r100.length());
        goto L11
    L7:
        r102 = r100.substring(0, r101);
    L22:
        return true;
    }
}
