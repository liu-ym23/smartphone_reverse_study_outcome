package v7b;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class r {
    static {
    }

    public static String a(s r100, boolean r101) {
        StringBuilder r102 = new StringBuilder();
        if (r100 == null) goto L6;
        b(r100, "", true, r102, r101);
    L6:
        return r102.toString();
    }

    public static void b(s r100, String r101, boolean r102, StringBuilder r103, boolean r104) {
        StringBuilder r105 = new StringBuilder("\n");
        r105.append(r101);
        if (r102 == false) goto L5;
        String r106 = "└── ";
    L6:
        r105.append(r106);
        if (r104 == false) goto L9;
        String r107 = r100.toString();
        Intrinsics.checkNotNull(r107);
    L10:
        r105.append(r107);
        r103.append(r105.toString());
        s r108 = r100.f553569e;
    L11:
        if (r108 == null) goto L21;
        StringBuilder r109 = new StringBuilder();
        r109.append(r101);
        if (r102 == false) goto L15;
        String r110 = LineContent.FOUR_SPACE;
    L16:
        r109.append(r110);
        String r111 = r109.toString();
        if (r108.f553572h != null) goto L19;
        boolean r112 = true;
    L20:
        b(r108, r111, r112, r103, r104);
        r108 = r108.f553572h;
        goto L11
    L19:
        r112 = false;
        goto L20
    L15:
        r110 = "│   ";
        goto L16
    L21:
        return;
    L9:
        r107 = r100.getClass().getSimpleName();
        Intrinsics.checkNotNull(r107);
        goto L10
    L5:
        r106 = "├── ";
        goto L6
    }
}
