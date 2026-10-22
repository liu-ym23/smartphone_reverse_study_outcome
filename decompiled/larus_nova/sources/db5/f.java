package db5;

import android.net.Uri;
import android.text.TextUtils;
import io.reactivex.functions.Function;
import java.util.Locale;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements Function<a, String> {
    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final String apply(a r100) throws Exception {
        a r101 = r100;
        StringBuilder r102 = new StringBuilder(r101.f467804a);
        int r103 = r101.f467805b.length;
    L3:
        r103 = r103 - 1;
        if (r103 < 0) goto L7;
        c(r102, r101.f467805b[r103]);
        goto L3
    L7:
        return r102.toString();
    }

    public static void c(StringBuilder r110, bo4.a r111) {
        String r100 = Uri.encode(r111.f19834x);
        if (TextUtils.isEmpty(r100) == true) goto L17;
        if (r111.f19813c != 16) goto L13;
        if (r111.f19814d == (-1)) goto L13;
        if (kn4.f.a().d() == false) goto L11;
        r110.replace(r111.f19811a, r111.f19812b, String.format(Locale.ENGLISH, "<at icon_info=\"%s\" type=\"%d\" sub_type=\"%d\" href=\"%s\" token=\"%s\" icon='{\"type\":%d,\"key\":\"%s\",\"fs_unit\":\"%s\"}'>%s</at>", new Object[]{r100, Integer.valueOf(r111.f19813c), Integer.valueOf(r111.f19814d), r111.f19816f, r111.f19815e, Integer.valueOf(r111.f19826p), r111.f19825o, r111.f19824n, r111.f19817g}));
        return;
    L11:
        r110.replace(r111.f19811a, r111.f19812b, String.format(Locale.ENGLISH, "<at icon_info=\"%s\" type=\"%d\" sub_type=\"%d\" href=\"%s\" token=\"%s\">%s</at>", new Object[]{r100, Integer.valueOf(r111.f19813c), Integer.valueOf(r111.f19814d), r111.f19816f, r111.f19815e, r111.f19817g}));
        return;
    L13:
        if (kn4.f.a().d() == false) goto L15;
        r110.replace(r111.f19811a, r111.f19812b, String.format(Locale.ENGLISH, "<at icon_info=\"%s\" type=\"%d\" href=\"%s\" token=\"%s\" icon='{\"type\":%d,\"key\":\"%s\",\"fs_unit\":\"%s\"}'>%s</at>", new Object[]{r100, Integer.valueOf(r111.f19813c), r111.f19816f, r111.f19815e, Integer.valueOf(r111.f19826p), r111.f19825o, r111.f19824n, r111.f19817g}));
        return;
    L15:
        r110.replace(r111.f19811a, r111.f19812b, String.format(Locale.ENGLISH, "<at icon_info=\"%s\" type=\"%d\" href=\"%s\" token=\"%s\">%s</at>", new Object[]{r100, Integer.valueOf(r111.f19813c), r111.f19816f, r111.f19815e, r111.f19817g}));
        return;
    L17:
        if (r111.f19813c != 16) goto L25;
        if (r111.f19814d == (-1)) goto L25;
        if (kn4.f.a().d() == false) goto L23;
        r110.replace(r111.f19811a, r111.f19812b, String.format(Locale.ENGLISH, "<at type=\"%d\" sub_type=\"%d\" href=\"%s\" token=\"%s\" icon='{\"type\":%d,\"key\":\"%s\",\"fs_unit\":\"%s\"}'>%s</at>", new Object[]{Integer.valueOf(r111.f19813c), Integer.valueOf(r111.f19814d), r111.f19816f, r111.f19815e, Integer.valueOf(r111.f19826p), r111.f19825o, r111.f19824n, r111.f19817g}));
        return;
    L23:
        r110.replace(r111.f19811a, r111.f19812b, String.format(Locale.ENGLISH, "<at type=\"%d\" sub_type=\"%d\" href=\"%s\" token=\"%s\">%s</at>", new Object[]{Integer.valueOf(r111.f19813c), Integer.valueOf(r111.f19814d), r111.f19816f, r111.f19815e, r111.f19817g}));
        return;
    L25:
        if (kn4.f.a().d() == false) goto L27;
        r110.replace(r111.f19811a, r111.f19812b, String.format(Locale.ENGLISH, "<at type=\"%d\" href=\"%s\" token=\"%s\" icon='{\"type\":%d,\"key\":\"%s\",\"fs_unit\":\"%s\"}'>%s</at>", new Object[]{Integer.valueOf(r111.f19813c), r111.f19816f, r111.f19815e, Integer.valueOf(r111.f19826p), r111.f19825o, r111.f19824n, r111.f19817g}));
        return;
    L27:
        r110.replace(r111.f19811a, r111.f19812b, String.format(Locale.ENGLISH, "<at type=\"%d\" href=\"%s\" token=\"%s\">%s</at>", new Object[]{Integer.valueOf(r111.f19813c), r111.f19816f, r111.f19815e, r111.f19817g}));
    }
}
