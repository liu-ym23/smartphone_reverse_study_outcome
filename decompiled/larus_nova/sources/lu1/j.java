package lu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.entity.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j {
    public static final n a(com.bytedance.android.livesdk.dynamicstrategy.api.entity.m r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toDynamicFactor");
        String r101 = r100.name;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return null;
    L13:
        if (r100.featureType != 6) goto L22;
        s r103 = r100.nfaInfo;
        if (r103 != null) goto L17;
        return null;
    L17:
        if (r103.c() == 2) goto L21;
        if (r103.c() == 3) goto L21;
        return null;
    L21:
        return new l(r101, r103);
    L22:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.n r104 = r100.featureValue;
        if (r104 != null) goto L26;
        return null;
    L26:
        switch(r104.valType) {
            case 1: goto L45;
            case 2: goto L43;
            case 3: goto L41;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L35;
            case 7: goto L33;
            case 8: goto L31;
            case 9: goto L29;
            default: goto L27;
        };
    L27:
        return null;
    L29:
        return new a(r101, r104);
    L31:
        return new i(r101, r104);
    L33:
        return new h(r101, r104);
    L35:
        return new g(r101, r104);
    L37:
        return new f(r101, r104);
    L39:
        return new e(r101, r104);
    L41:
        return new d(r101, r104);
    L43:
        return new c(r101, r104);
    L45:
        return new b(r101, r104);
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
