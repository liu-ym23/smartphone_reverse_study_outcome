package wu8;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.common.propertyconfig.Visibility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Visibility f561466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextRes f561467b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f561466a == r101.f561466a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f561467b, r101.f561467b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f561466a.hashCode() * 31) + this.f561467b.hashCode();
    }

    public final String toString() {
        return "AutoFillBtnUIState(visibility=" + this.f561466a + ", text=" + this.f561467b + ')';
    }

    public a(Visibility r100, TextRes.StringResId r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.VISIBILITY);
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f561466a = r100;
        this.f561467b = r101;
    }
}
