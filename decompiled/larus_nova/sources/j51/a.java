package j51;

import com.bytedance.live.kmp.core.KmpEnv;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "douyinV");
        Intrinsics.checkNotNullParameter(r101, "huoshanV");
        Intrinsics.checkNotNullParameter(r102, "saasV");
        KmpEnv r103 = KmpEnv.f255139a;
        if (KmpEnv.a() == false) goto L6;
        return r100;
    L6:
        if (KmpEnv.c() == false) goto L9;
        return r101;
    L9:
        return r102;
    }
}
