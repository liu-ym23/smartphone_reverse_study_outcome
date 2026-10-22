package i11;

import com.alipay.sdk.m.u.i;
import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f487930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487931b;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("InviteeUser{");
        r100.append("user=" + this.f487930a);
        r100.append(",");
        r100.append("panelType=" + this.f487931b);
        r100.append(i.f25855d);
        return r100.toString();
    }

    public d(IBaseUser r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "user");
        this.f487930a = r100;
        this.f487931b = r101;
    }
}
