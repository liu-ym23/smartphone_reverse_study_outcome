package ka6;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f502191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502192b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f502191a == r101.f502191a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502192b, r101.f502192b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f502191a * 31) + this.f502192b.hashCode();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("(");
        switch(this.f502191a) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L4;
            case 9: goto L27;
            case 10: goto L26;
            case 11: goto L25;
            case 12: goto L24;
            case 13: goto L23;
            case 14: goto L22;
            case 15: goto L21;
            case 16: goto L20;
            case 17: goto L19;
            case 18: goto L18;
            case 19: goto L17;
            case 20: goto L16;
            case 21: goto L15;
            case 22: goto L14;
            case 23: goto L13;
            case 24: goto L12;
            case 25: goto L11;
            case 26: goto L10;
            case 27: goto L9;
            case 28: goto L8;
            case 29: goto L7;
            case 30: goto L6;
            case 31: goto L4;
            case 32: goto L5;
            default: goto L4;
        };
    L4:
        String r101 = "UNKNOWN";
    L36:
        r100.append(r101);
        r100.append(", ");
        r100.append(this.f502192b);
        r100.append(')');
        return r100.toString();
    L5:
        r101 = "Eof";
        goto L36
    L6:
        r101 = "Null";
        goto L36
    L7:
        r101 = BdpAppEventConstant.FALSE;
        goto L36
    L8:
        r101 = BdpAppEventConstant.TRUE;
        goto L36
    L9:
        r101 = "RightBracket";
        goto L36
    L10:
        r101 = "LeftBracket";
        goto L36
    L11:
        r101 = "RightParen";
        goto L36
    L12:
        r101 = "LeftParen";
        goto L36
    L13:
        r101 = "Comma";
        goto L36
    L14:
        r101 = "Dot";
        goto L36
    L15:
        r101 = "BitXor";
        goto L36
    L16:
        r101 = "BitOr";
        goto L36
    L17:
        r101 = "BitAnd";
        goto L36
    L18:
        r101 = "BitNot";
        goto L36
    L19:
        r101 = "LogicOr";
        goto L36
    L20:
        r101 = "LogicAnd";
        goto L36
    L21:
        r101 = "LogicNot";
        goto L36
    L22:
        r101 = "NotEqual";
        goto L36
    L23:
        r101 = "Equal";
        goto L36
    L24:
        r101 = "GreaterEqual";
        goto L36
    L25:
        r101 = "Greater";
        goto L36
    L26:
        r101 = "LessEqual";
        goto L36
    L27:
        r101 = "Less";
        goto L36
    L28:
        r101 = "Percent";
        goto L36
    L29:
        r101 = "Slash";
        goto L36
    L30:
        r101 = "Asterisk";
        goto L36
    L31:
        r101 = "Plus";
        goto L36
    L32:
        r101 = "Minus";
        goto L36
    L33:
        r101 = "Number";
        goto L36
    L34:
        r101 = "String";
        goto L36
    L35:
        r101 = "Identifier";
        goto L36
    }

    public b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f502191a = r100;
        this.f502192b = r101;
    }
}
