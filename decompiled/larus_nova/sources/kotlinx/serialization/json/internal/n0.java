package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class n0 extends m0 {
    @Override // kotlinx.serialization.json.internal.m0, kotlinx.serialization.json.internal.a
    public final byte e() {
        String r100 = this.f505447e;
        int r101 = u();
        if (r101 < r100.length()) goto L5;
        return 10;
    L5:
        if (r101 == (-1)) goto L11;
        this.f505376a = r101 + 1;
        return b.a(r100.charAt(r101));
    L11:
        return 10;
    }

    @Override // kotlinx.serialization.json.internal.a
    public final byte r() {
        String r100 = this.f505447e;
        int r101 = u();
        if (r101 < r100.length()) goto L5;
        return 10;
    L5:
        if (r101 == (-1)) goto L11;
        this.f505376a = r101;
        return b.a(r100.charAt(r101));
    L11:
        return 10;
    }

    @Override // kotlinx.serialization.json.internal.m0, kotlinx.serialization.json.internal.a
    public final int u() {
        int r100 = this.f505376a;
        if (r100 != (-1)) goto L5;
        return r100;
    L5:
        String r101 = this.f505447e;
    L7:
        if (r100 >= r101.length()) goto L38;
        char r102 = r101.charAt(r100);
        if (r102 != ' ') goto L11;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == true) goto L30;
        if (r102 != '/') goto L38;
        int r104 = r100 + 1;
        if (r104 >= r101.length()) goto L38;
        char r105 = r101.charAt(r104);
        if (r105 == '/') goto L27;
        if (r105 != '*') goto L38;
        int r106 = StringsKt.indexOf$default(r101, "*/", r100 + 2, false, 4, null);
        if (r106 == (-1)) goto L36;
        r100 = r106 + 2;
        goto L7
    L36:
        this.f505376a = r101.length();
        a.m(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6);
        throw null;
    L27:
        r100 = StringsKt.indexOf$default(r101, '\n', r100 + 2, false, 4, null);
        if (r100 != (-1)) goto L30;
        r100 = r101.length();
    L30:
        r100 = r100 + 1;
        goto L7
    L11:
        if (r102 == '\n') goto L18;
        if (r102 == '\r') goto L18;
        if (r102 == '\t') goto L18;
        r103 = false;
    L38:
        this.f505376a = r100;
        return r100;
    }

    @Override // kotlinx.serialization.json.internal.m0, kotlinx.serialization.json.internal.a
    public final boolean b() {
        int r100 = u();
        if (r100 < this.f505447e.length()) goto L5;
        return false;
    L5:
        if (r100 == (-1)) goto L22;
        char r101 = this.f505447e.charAt(r100);
        if (r101 != '}') goto L10;
        return false;
    L10:
        if (r101 != ']') goto L12;
        return false;
    L12:
        if (r101 != ':') goto L14;
        return false;
    L14:
        if (r101 == ',') goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    }

    public n0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        super(r100);
    }

    @Override // kotlinx.serialization.json.internal.m0, kotlinx.serialization.json.internal.a
    public final void g(char r100) {
        String r101 = this.f505447e;
        int r102 = u();
        if (r102 >= r101.length()) goto L10;
        if (r102 == (-1)) goto L10;
        char r103 = r101.charAt(r102);
        this.f505376a = r102 + 1;
        if (r103 != r100) goto L8;
        return;
    L8:
        x(r100);
        throw null;
    L10:
        this.f505376a = -1;
        x(r100);
        throw null;
    }
}
