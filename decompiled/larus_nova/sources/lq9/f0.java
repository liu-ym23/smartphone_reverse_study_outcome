package lq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f510331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f510332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f510333c;

    public final boolean a(String r100) {
        int r101 = b(r100);
        if (this.f510331a == true) goto L5;
    L9:
        return false;
    L5:
        if (r101 != 2) goto L7;
    L8:
        return true;
    L7:
        if (r101 != 3) goto L9;
        goto L8
    }

    public final int b(String r100) {
        if (this.f510333c.isEmpty() == true) goto L19;
        if (r100 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L19;
        if (this.f510333c.contains(r100) == true) goto L19;
        int r102 = this.f510332b;
        if (r102 != 3) goto L20;
        return 2;
    L20:
        return r102;
    L6:
        if (r100.length() == 0) goto L9;
        r101 = false;
    L19:
        return this.f510332b;
    }

    public f0(boolean r100, int r101, List r102) {
        Intrinsics.checkNotNullParameter(r102, "supportMixLanguage");
        this.f510331a = r100;
        this.f510332b = r101;
        this.f510333c = r102;
    }
}
