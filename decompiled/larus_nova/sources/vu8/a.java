package vu8;

import com.bytedance.common.utility.StringUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f557365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f557366b;

    public final boolean a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (StringUtils.equal(this.f557365a, r100.f557365a) == true) goto L5;
    L7:
        return false;
    L5:
        if (StringUtils.equal(this.f557366b, r100.f557366b) == false) goto L7;
        return true;
    }

    public a(String r100, String r101) {
        this.f557365a = r100;
        this.f557366b = r101;
    }
}
