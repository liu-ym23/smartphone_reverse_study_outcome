package em;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f473046a = null;

    public b() {
    }

    static {
        f473046a = new b();
    }

    @Override // em.c
    public final boolean b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Lazy r102 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L8;
        if (r100 == 3) goto L8;
    L12:
        return false;
    L8:
        if (r100 < 2) goto L12;
        if (r100 >= 5) goto L12;
        return true;
    }

    @Override // em.c
    public final void a(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
        if (r102.length() >= 4000) goto L5;
        return;
    L5:
        int r103 = r102.length();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L15;
        int r105 = StringsKt.indexOf$default(r102, '\n', r104, false, 4, null);
        if (r105 != (-1)) goto L11;
        r105 = r103;
    L11:
        int r106 = Math.min(r105, r104 + 4000);
        r102.substring(r104, r106);
        if (r106 >= r105) goto L13;
        r104 = r106;
        goto L11
    L13:
        r104 = r106 + 1;
        goto L6
    }
}
