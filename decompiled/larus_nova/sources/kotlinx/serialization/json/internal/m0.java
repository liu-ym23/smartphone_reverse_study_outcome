package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public class m0 extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f505447e;

    @Override // kotlinx.serialization.json.internal.a
    public boolean b() {
        int r100 = this.f505376a;
        if (r100 != (-1)) goto L5;
        return false;
    L5:
        String r101 = this.f505447e;
    L7:
        if (r100 >= r101.length()) goto L32;
        char r102 = r101.charAt(r100);
        if (r102 != ' ') goto L11;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == false) goto L21;
        r100 = r100 + 1;
        goto L7
    L21:
        this.f505376a = r100;
        if (r102 != '}') goto L24;
        return false;
    L24:
        if (r102 != ']') goto L26;
        return false;
    L26:
        if (r102 != ':') goto L28;
        return false;
    L28:
        if (r102 == ',') goto L39;
        return true;
    L39:
        return false;
    L11:
        if (r102 == '\n') goto L18;
        if (r102 == '\r') goto L18;
        if (r102 == '\t') goto L18;
        r103 = false;
        goto L19
    L32:
        this.f505376a = r100;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.a
    public final String d() {
        g(Typography.quote);
        int r100 = this.f505376a;
        int r101 = StringsKt.indexOf$default(this.f505447e, Typography.quote, r100, false, 4, null);
        if (r101 == (-1)) goto L47;
        int r102 = r100;
    L5:
        if (r102 >= r101) goto L45;
        if (this.f505447e.charAt(r102) == '\\') goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        String r103 = this.f505447e;
        int r104 = this.f505376a;
        Intrinsics.checkNotNullParameter(r103, "source");
        char r105 = r103.charAt(r102);
        boolean r110 = false;
    L9:
        if (r105 == '\"') goto L39;
        if (r105 != '\\') goto L31;
        this.f505379d.append(p(), r104, r102);
        int r106 = t(r102 + 1);
        if (r106 == (-1)) goto L29;
        int r111 = r106 + 1;
        char r107 = this.f505447e.charAt(r106);
        if (r107 != 'u') goto L17;
        r111 = a(this.f505447e, r111);
    L22:
        r102 = t(r111);
        if (r102 == (-1)) goto L25;
    L35:
        r104 = r102;
        r110 = true;
    L38:
        r105 = r103.charAt(r102);
        goto L9
    L25:
        a.m(this, "Unexpected EOF", r102, null, 4);
        throw null;
    L17:
        if (r107 >= 'u') goto L19;
        char r108 = k.f505431a[r107];
    L20:
        if (r108 == 0) goto L27;
        this.f505379d.append(r108);
        goto L22
    L27:
        a.m(this, "Invalid escaped char '" + r107 + '\'', 0, null, 6);
        throw null;
    L19:
        r108 = 0;
        goto L20
    L29:
        a.m(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
        throw null;
    L31:
        r102 = r102 + 1;
        if (r102 < r103.length()) goto L38;
        this.f505379d.append(p(), r104, r102);
        r102 = t(r102);
        if (r102 != (-1)) goto L35;
        a.m(this, "Unexpected EOF", r102, null, 4);
        throw null;
    L39:
        if (r110 == true) goto L41;
        String r109 = ((String) p()).subSequence(r104, r102).toString();
    L42:
        this.f505376a = r102 + 1;
        return r109;
    L41:
        this.f505379d.append(p(), r104, r102);
        r109 = this.f505379d.toString();
        this.f505379d.setLength(0);
        goto L42
    L45:
        this.f505376a = r101 + 1;
        return this.f505447e.substring(r100, r101);
    L47:
        j();
        n((byte) 1, false);
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.a
    public byte e() {
        String r100 = this.f505447e;
        int r101 = this.f505376a;
    L4:
        if (r101 == (-1)) goto L21;
        if (r101 >= r100.length()) goto L21;
        int r102 = r101 + 1;
        char r103 = r100.charAt(r101);
        if (r103 == ' ') goto L16;
        if (r103 == '\n') goto L16;
        if (r103 == '\r') goto L16;
        if (r103 == '\t') goto L16;
        boolean r104 = false;
    L17:
        if (r104 == false) goto L18;
        r101 = r102;
        goto L4
    L18:
        this.f505376a = r102;
        return b.a(r103);
    L16:
        r104 = true;
    L21:
        this.f505376a = r100.length();
        return 10;
    }

    @Override // kotlinx.serialization.json.internal.a
    public int u() {
        int r100 = this.f505376a;
        if (r100 != (-1)) goto L5;
        return r100;
    L5:
        String r101 = this.f505447e;
    L7:
        if (r100 >= r101.length()) goto L21;
        char r102 = r101.charAt(r100);
        if (r102 != ' ') goto L11;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == false) goto L21;
        r100 = r100 + 1;
        goto L7
    L11:
        if (r102 == '\n') goto L18;
        if (r102 == '\r') goto L18;
        if (r102 == '\t') goto L18;
        r103 = false;
    L21:
        this.f505376a = r100;
        return r100;
    }

    @Override // kotlinx.serialization.json.internal.a
    public final CharSequence p() {
        return this.f505447e;
    }

    public m0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f505447e = r100;
    }

    @Override // kotlinx.serialization.json.internal.a
    public void g(char r100) {
        int r101 = this.f505376a;
        if (r101 == (-1)) goto L27;
        String r102 = this.f505447e;
    L6:
        if (r101 >= r102.length()) goto L25;
        int r103 = r101 + 1;
        char r104 = r102.charAt(r101);
        if (r104 != ' ') goto L10;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L19;
        r101 = r103;
        goto L6
    L19:
        this.f505376a = r103;
        if (r104 != r100) goto L22;
        return;
    L22:
        x(r100);
        throw null;
    L10:
        if (r104 == '\n') goto L17;
        if (r104 == '\r') goto L17;
        if (r104 == '\t') goto L17;
        r105 = false;
        goto L18
    L25:
        this.f505376a = -1;
        x(r100);
        throw null;
    L27:
        x(r100);
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.a
    public final int t(int r100) {
        if (r100 < this.f505447e.length()) goto L7;
        return -1;
    L7:
        return r100;
    }

    @Override // kotlinx.serialization.json.internal.a
    public final String q(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "keyToMatch");
        int r102 = this.f505376a;
    L17:
        th = move-exception;
        this.f505376a = r102;
        this.f505378c = null;
        throw th;
    L5:
        if (e() == 6) goto L9;
    L6:
        this.f505376a = r102;
        this.f505378c = null;
        return null;
    L9:
        if (Intrinsics.areEqual(s(r101), r100) == false) goto L6;
        this.f505378c = null;     // Catch: Throwable -> L17
        if (e() != 5) goto L6;
        String r103 = s(r101);     // Catch: Throwable -> L17
        this.f505376a = r102;
        this.f505378c = null;
        return r103;
    }
}
