package x21;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.u1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final IBaseBattleSetting a(b.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$setting");
        c5 r101 = r100.f562205b;
        c3 r102 = r100.f562206c;
        if (r101 == null) goto L8;
        u1 r103 = r101.getBattleSetting();
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103;
    L8:
        if (r102 == null) goto L14;
        c1 r104 = r102.getBattleSetting();
        if (r104 != null) goto L12;
        return null;
    L12:
        return r104;
    L14:
        return null;
    }
}
