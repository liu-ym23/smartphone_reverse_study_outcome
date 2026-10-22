package w1c;

import com.bytedance.lark.pb.contact.v2.I18nVal;
import java.text.BreakIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yob.e;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static final String a(I18nVal r100) {
        e.a().getClass();
        int r101 = com.ss.android.lark.language.service.impl.a.f431092f;
        apb.b r102 = com.ss.android.lark.language.service.impl.a.b.f431098a;
        String r103 = r102.d(r102.getCacheLanguageSetting());
        String r104 = null;
        if (r100 == null) goto L7;
        Map<String, String> r105 = r100.i18n_vals;
        if (r105 == null) goto L7;
        Intrinsics.checkNotNull(r103);
        String r106 = r105.get(r103.toLowerCase(Locale.ROOT));
    L8:
        String r107 = "";
        if (r106 != null) goto L12;
        r106 = "";
    L12:
        if (r106.length() != 0) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L23;
        if (r100 == null) goto L18;
        r104 = r100.default_val;
    L18:
        if (r104 == null) goto L22;
        r107 = r104;
    L22:
        return r107;
    L23:
        return r106;
    L14:
        r108 = false;
    L7:
        r106 = null;
        goto L8
    }

    public static final String b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        BreakIterator r102 = BreakIterator.getCharacterInstance(Locale.getDefault());
        r102.setText(r100);
        int r103 = r102.first();
        int r104 = 0;
    L4:
        if (r103 == (-1)) goto L7;
        if (r104 >= r101) goto L7;
        r103 = r102.next();
        r104 = r104 + 1;
    L7:
        if (r103 != (-1)) goto L10;
        return r100;
    L10:
        return r100.substring(0, r103);
    }
}
