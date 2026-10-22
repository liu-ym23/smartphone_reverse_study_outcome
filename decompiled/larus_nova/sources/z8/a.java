package z8;

import android.content.Context;
import com.bytedance.android.annie.lynx.resource.h;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // z8.b
    public final List r1(Context r100, h r101) {
        Intrinsics.checkNotNullParameter(r101, "xResourceLoader");
        return null;
    }

    @Override // z8.b
    public final List<Object> M(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "url");
        return CollectionsKt.emptyList();
    }
}
