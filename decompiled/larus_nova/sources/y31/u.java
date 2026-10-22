package y31;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.link.model.p> f565838a;

    /* JADX WARN: Multi-variable type inference failed */
    public u(List<? extends com.bytedance.android.livesdk.link.model.p> r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorList");
        this.f565838a = r100;
        String r101 = iz.a.a(((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).b());
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        IBaseUser r104 = ((com.bytedance.android.livesdk.link.model.p) ListProtector.get(this.f565838a, r103)).getUser();
        if (r104 == null) goto L7;
        String r105 = r104.getIdString();
    L9:
        if (Intrinsics.areEqual(r105, r101) == true) goto L13;
        r103 = r103 + 1;
    L13:
        if (r103 != 0) goto L15;
        return;
    L15:
        if ((!this.f565838a.isEmpty()) == false) goto L21;
        Collections.swap(this.f565838a, 0, r103);
        return;
    L21:
        return;
    L7:
        r105 = null;
        goto L9
    L12:
        r103 = 0;
        goto L13
    }
}
