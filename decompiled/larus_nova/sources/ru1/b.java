package ru1;

import com.bytedance.android.livesdk.dynamicstrategy.impl.express.exception.SimpleExpressException;
import java.util.ArrayList;
import java.util.List;
import su1.d;
import su1.f;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f539249a = 0;

    static {
    }

    public static void a(tu1.b r100, List r101) {
        tu1.b r102 = r100.f547596c;
        if (r102 == null) goto L5;
        a(r102, r101);
    L5:
        tu1.b r103 = r100.f547597d;
        if (r103 == null) goto L9;
        a(r103, r101);
    L9:
        switch(a.f539248a[r100.getType().ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        Object r104 = r100.f547595b;
        if (r104 == null) goto L16;
        Object r105 = new su1.b((String) r104);
    L23:
        ((ArrayList) r101).add(r105);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L17:
        r105 = new f();
        goto L23
    L18:
        r105 = new su1.a();
        goto L23
    L19:
        r105 = new su1.c(r100.f547595b);
        goto L23
    L20:
        Object r106 = r100.f547595b;
        if (r106 == null) goto L26;
        r105 = new d((String) r106);
        goto L23
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L11:
        throw new SimpleExpressException("create operation failed, unknown type " + r100.getType(), null, 2, null);
    }
}
