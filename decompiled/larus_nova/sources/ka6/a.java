package ka6;

import com.bytedance.kmp.ecom.arch.expr.error.SlcExprException;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f502189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f502190c;

    /* JADX INFO: renamed from: ka6.a$a, reason: collision with other inner class name */
    public static final class C6526a {
    }

    static {
    }

    public final char a() {
        if (this.f502190c < this.f502188a.length()) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return CharCompanionObject.MAX_VALUE;
    L9:
        String r101 = this.f502188a;
        int r102 = this.f502190c;
        this.f502190c = r102 + 1;
        return r101.charAt(r102);
    L5:
        r100 = false;
        goto L6
    }

    public final char d() {
        if (this.f502190c < this.f502188a.length()) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        return CharCompanionObject.MAX_VALUE;
    L10:
        return this.f502188a.charAt(this.f502190c);
    L5:
        r100 = false;
        goto L6
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "expr");
        this.f502188a = r100;
    }

    public final boolean b(char r100) {
        if (d() != r100) goto L6;
        a();
        return true;
    L6:
        return false;
    }

    public final b c(boolean r100) {
        boolean r101 = !r100;
    L3:
        char r102 = d();
        boolean r103 = false;
        if ('0' > r102) goto L7;
        if (r102 >= ':') goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        a();
        goto L3
    L10:
        char r105 = d();
        if (r100 == true) goto L25;
        if (r105 != '.') goto L23;
        a();
    L15:
        char r106 = d();
        if ('0' > r106) goto L19;
        if (r106 >= ':') goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        a();
        goto L15
    L22:
        r101 = false;
    L19:
        r107 = false;
    L23:
        r105 = d();
    L25:
        if (r105 != 'E') goto L27;
    L29:
        a();
        char r108 = d();
        if (r108 != '+') goto L32;
    L34:
        a();
    L35:
        char r109 = d();
        if ('0' > r109) goto L39;
        if (r109 >= ':') goto L39;
        boolean r110 = true;
    L40:
        if (r110 == false) goto L54;
    L41:
        char r111 = d();
        if ('0' > r111) goto L45;
        if (r111 >= ':') goto L45;
        boolean r112 = true;
    L46:
        if (r112 == false) goto L48;
        a();
    L48:
        if (r103 == false) goto L50;
        int r113 = 31;
    L51:
        String r114 = this.f502188a;
        int r115 = this.f502189b;
        int r116 = this.f502190c;
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type kotlin.String");
        return new b(r113, r114.substring(r115, r116));
    L50:
        r113 = 2;
    L45:
        r112 = false;
        goto L46
    L54:
        throw new SlcExprException("lexer_invalid_number", "科学计数法e后续必须跟随一个数字");
    L39:
        r110 = false;
        goto L40
    L32:
        if (r108 == '-') goto L34;
    L27:
        if (r105 == 'e') goto L29;
        r103 = r101;
    L7:
        r104 = false;
        goto L8
    }
}
