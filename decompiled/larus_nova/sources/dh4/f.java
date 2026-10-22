package dh4;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends i {
    public final void i() {
        a(',');
    }

    public final void j() {
        a('{');
    }

    public final void k() {
        a('}');
    }

    public f(String r100) {
        super(r100);
    }

    public final void h(String r100) {
        this.f468608a.a(Typography.quote);
        d(r100);
        this.f468608a.a(Typography.quote);
        this.f468608a.a(':');
        a(' ');
    }

    public final void l(String r100) {
        a(Typography.quote);
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L32;
        char r103 = r100.charAt(r102);
        if (r103 != '\f') goto L11;
        d("\\f");
    L31:
        r102 = r102 + 1;
        goto L7
    L11:
        if (r103 != '\r') goto L13;
        d("\\r");
        goto L31
    L13:
        if (r103 == '\"') goto L28;
        if (r103 == '\\') goto L28;
        if (r103 != 8232) goto L18;
    L27:
        d(String.format("\\u%04x", new Object[]{Integer.valueOf(r103)}));
        goto L31
    L18:
        if (r103 == 8233) goto L27;
        switch(r103) {
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            default: goto L21;
        };
    L23:
        d("\\n");
        goto L31
    L24:
        d("\\t");
        goto L31
    L25:
        d("\\b");
        goto L31
    L21:
        if (r103 > 31) goto L26;
        d(String.format("\\u%04x", new Object[]{Integer.valueOf(r103)}));
        goto L31
    L26:
        a(r103);
    L28:
        a('\\');
        a(r103);
        goto L31
    L32:
        a(Typography.quote);
        return;
    L5:
        r101 = r100.length();
        goto L6
    }
}
