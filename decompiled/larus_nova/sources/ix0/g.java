package ix0;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {
    public static final <T> T a(a r100, d<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$fromRemoteObject");
        Intrinsics.checkNotNullParameter(r101, "remoteObj");
        Intrinsics.checkNotNullParameter(r101, "$this$toObjectToken");
        Map<String, String> r102 = r101.getObjToken();
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.get("_obj_id");
    L7:
        if ((r104 instanceof String) == false) goto L10;
        r103 = r104;
    L10:
        if (r103 == null) goto L14;
        return (T) r100.e1(new b(r103));
    L14:
        throw new IllegalArgumentException("not a valid RemoteObject");
    L5:
        r104 = null;
        goto L7
    }

    public static final <T, R extends d<T>> R b(a r100, T r101, Function0<? extends R> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$toRemoteObject");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        Intrinsics.checkNotNullParameter(r102, "ctor");
        b<T> r103 = r100.f1(r101);
        Intrinsics.checkNotNullParameter(r103, "$this$toRemoteObject");
        Intrinsics.checkNotNullParameter(r102, "ctor");
        R r104 = r102.invoke();
        r104.P6(MapsKt.mapOf(TuplesKt.to("_obj_id", r103.f496314a)));
        return r104;
    }
}
