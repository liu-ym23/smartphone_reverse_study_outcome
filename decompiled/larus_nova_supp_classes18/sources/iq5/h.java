package iq5;

import com.bytedance.ee.bear.list.dto.DocVersion;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.selector.d a;

    public h(com.bytedance.ee.bear.wikiv2.selector.d r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        DocVersion r4 = (DocVersion) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        this.a.b.C3(r4.getOwnerType());
        com.bytedance.ee.bear.wikiv2.selector.d r0 = this.a;
        r0.j = r4.getOwnerType();
        return this.a.b.o8();
    }
}
