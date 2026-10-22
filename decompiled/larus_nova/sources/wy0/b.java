package wy0;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b<P extends j<P>, R> extends a<Object, R> {
    public abstract Type k();

    public abstract void l(P r100, CallContext r101);

    @Override // com.bytedance.ies.web.jsbridge2.f
    public void onTerminate() {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callContext");
        if ((r100 instanceof JsonObject) == false) goto L5;
        Type r102 = k();
        JsonObject r103 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r102, "metaType");
        Intrinsics.checkNotNullParameter(r103, "json");
        l((j) GsonProtectorUtils.fromJson(l97.a.f508113a, r103, r102), r101);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100, "$this$isSerializableObject");
        if ((r100 instanceof j) == false) goto L10;
        l((j) r100, r101);
        return;
    L10:
        throw new IllegalArgumentException("jsb input params is not a valid type, blame lifengji for more help");
    }
}
