package lnc;

import com.bytedance.android.alog.Alog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(com.suite.component.logger.c r110) {
        Intrinsics.checkNotNullParameter(r110, "entity");
        if (pqb.e.f530322a == null) goto L11;
        int r100 = r110.f460115a.getValue();
        pqb.b.a r101 = pqb.b.f530315a;
        String r102 = pqb.b.a.a(r110.f460116b, r110.f460122h, Integer.valueOf(r110.f460123i));
        if (r102 != null) goto L7;
        r102 = r110.f460116b;
    L7:
        String r103 = r102;
        String r104 = r110.f460117c;
        long r105 = r110.f460125k;
        long r106 = r110.f460129o;
        Intrinsics.checkNotNullParameter(r103, "tag");
        int r107 = r100 - 2;
        Alog r108 = com.bytedance.android.alog.e.f38378a;
        if (r108 == null) goto L12;
        r108.o(r107, r103, r104, r105, r106);
        return;
    L12:
        return;
    }
}
