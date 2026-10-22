package db5;

import android.net.Uri;
import android.text.TextUtils;
import io.reactivex.functions.Function;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements Function<a, String> {
    public f() {
    }

    public final Object apply(Object r4) throws Exception {
        a r5 = (a) r4;
        StringBuilder r0 = new StringBuilder(r5.a);
        int r1 = r5.b.length;
    L3:
        r1 = r1 - 1;
        if (r1 < 0) goto L7;
        c(r0, r5.b[r1]);
        goto L3
    L7:
        return r0.toString();
    }

    public static void c(StringBuilder r14, bo4.a r16) {
        String r0 = Uri.encode(r16.x);
        if (TextUtils.isEmpty(r0) == true) goto L17;
        if (r16.c != 16) goto L13;
        if (r16.d == (-1)) goto L13;
        if (kn4.f.a().d() == false) goto L11;
        r14.replace(r16.a, r16.b, String.format(Locale.ENGLISH, "<at icon_info=\"%s\" type=\"%d\" sub_type=\"%d\" href=\"%s\" token=\"%s\" icon='{\"type\":%d,\"key\":\"%s\",\"fs_unit\":\"%s\"}'>%s</at>", new Object[]{r0, Integer.valueOf(r16.c), Integer.valueOf(r16.d), r16.f, r16.e, Integer.valueOf(r16.p), r16.o, r16.n, r16.g}));
        return;
    L11:
        r14.replace(r16.a, r16.b, String.format(Locale.ENGLISH, "<at icon_info=\"%s\" type=\"%d\" sub_type=\"%d\" href=\"%s\" token=\"%s\">%s</at>", new Object[]{r0, Integer.valueOf(r16.c), Integer.valueOf(r16.d), r16.f, r16.e, r16.g}));
        return;
    L13:
        if (kn4.f.a().d() == false) goto L15;
        r14.replace(r16.a, r16.b, String.format(Locale.ENGLISH, "<at icon_info=\"%s\" type=\"%d\" href=\"%s\" token=\"%s\" icon='{\"type\":%d,\"key\":\"%s\",\"fs_unit\":\"%s\"}'>%s</at>", new Object[]{r0, Integer.valueOf(r16.c), r16.f, r16.e, Integer.valueOf(r16.p), r16.o, r16.n, r16.g}));
        return;
    L15:
        r14.replace(r16.a, r16.b, String.format(Locale.ENGLISH, "<at icon_info=\"%s\" type=\"%d\" href=\"%s\" token=\"%s\">%s</at>", new Object[]{r0, Integer.valueOf(r16.c), r16.f, r16.e, r16.g}));
        return;
    L17:
        if (r16.c != 16) goto L25;
        if (r16.d == (-1)) goto L25;
        if (kn4.f.a().d() == false) goto L23;
        r14.replace(r16.a, r16.b, String.format(Locale.ENGLISH, "<at type=\"%d\" sub_type=\"%d\" href=\"%s\" token=\"%s\" icon='{\"type\":%d,\"key\":\"%s\",\"fs_unit\":\"%s\"}'>%s</at>", new Object[]{Integer.valueOf(r16.c), Integer.valueOf(r16.d), r16.f, r16.e, Integer.valueOf(r16.p), r16.o, r16.n, r16.g}));
        return;
    L23:
        r14.replace(r16.a, r16.b, String.format(Locale.ENGLISH, "<at type=\"%d\" sub_type=\"%d\" href=\"%s\" token=\"%s\">%s</at>", new Object[]{Integer.valueOf(r16.c), Integer.valueOf(r16.d), r16.f, r16.e, r16.g}));
        return;
    L25:
        if (kn4.f.a().d() == false) goto L27;
        r14.replace(r16.a, r16.b, String.format(Locale.ENGLISH, "<at type=\"%d\" href=\"%s\" token=\"%s\" icon='{\"type\":%d,\"key\":\"%s\",\"fs_unit\":\"%s\"}'>%s</at>", new Object[]{Integer.valueOf(r16.c), r16.f, r16.e, Integer.valueOf(r16.p), r16.o, r16.n, r16.g}));
        return;
    L27:
        r14.replace(r16.a, r16.b, String.format(Locale.ENGLISH, "<at type=\"%d\" href=\"%s\" token=\"%s\">%s</at>", new Object[]{Integer.valueOf(r16.c), r16.f, r16.e, r16.g}));
    }
}
