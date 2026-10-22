package hc6;

import com.bytedance.android.scope.m;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final <T extends dn0.b> T a(bn0.b r100, KClass<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "multiLinkRoomScope");
        Intrinsics.checkNotNullParameter(r101, NsdHelper.serviceTypeKey);
        m.f163449e.getClass();
        Object r102 = m.b(r100).a(r101);
        Intrinsics.checkNotNull(r102);
        return (T) r102;
    }
}
