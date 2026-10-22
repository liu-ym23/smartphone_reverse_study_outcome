package t66;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends s66.a {
    public a() {
    }

    @Override // s66.a
    public final void e(com.bytedance.ies.xbridge.model.params.b r100, s66.a.C7573a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Context r103 = (Context) provideContext(Context.class);
        if (r103 != null) goto L6;
        r101.a("Context not provided in host");
        return;
    L6:
        Set<String> r104 = com.bytedance.ies.xbridge.storage.utils.a.a(r103).c();
        u66.a r105 = new u66.a();
        r105.f548928a = CollectionsKt.toList(r104);
        r101.b(r105, "");
    }
}
