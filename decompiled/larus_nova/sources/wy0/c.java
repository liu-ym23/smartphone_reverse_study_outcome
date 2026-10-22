package wy0;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
public abstract class c<P extends j<P>, R> extends com.bytedance.ies.web.jsbridge2.g<Object, R> {
    public abstract Type j();

    public abstract R k(P r100, CallContext r101);

    public c() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final R invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callContext");
        if ((r100 instanceof JsonObject) == false) goto L5;
        Type r102 = j();
        JsonObject r103 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r102, "metaType");
        Intrinsics.checkNotNullParameter(r103, "json");
        return k((j) GsonProtectorUtils.fromJson(l97.a.f508113a, r103, r102), r101);
    L5:
        Intrinsics.checkNotNullParameter(r100, "$this$isSerializableObject");
        if ((r100 instanceof j) == false) goto L10;
        return k((j) r100, r101);
    L10:
        throw new IllegalArgumentException("blame lifengji for more help");
    }
}
