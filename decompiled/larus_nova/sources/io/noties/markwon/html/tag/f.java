package io.noties.markwon.html.tag;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import wsc.o;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tsc.c f492630a;

    public f(tsc.c.a r100) {
        this.f492630a = r100;
    }

    public static o.a a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        int r101 = r100.length();
        int r102 = r101 - 1;
        int r103 = r102;
    L7:
        if (r103 <= (-1)) goto L19;
        if (Character.isDigit(r100.charAt(r103)) == true) goto L10;
        r103 = r103 - 1;
        goto L7
    L10:
        int r104 = r103 + 1;
        float r105 = CastFloatProtector.parseFloat(r100.substring(0, r104));     // Catch: NumberFormatException -> L17
        if (r103 != r102) goto L14;
        String r106 = null;
    L15:
        return new o.a(r105, r106);
    L14:
        r106 = r100.substring(r104, r101);     // Catch: NumberFormatException -> L17
    L17:
        return null;
    L19:
        return null;
    }
}
