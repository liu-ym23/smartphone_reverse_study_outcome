package dq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T, R> implements Function {
    public final /* synthetic */ ce5.a a;

    public l(ce5.a r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        SpaceInfo r5 = (SpaceInfo) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        int r0 = j.a;
        String r1 = r5.space_id;
        ((by4.d) this.a.a(by4.d.class)).b("preference_my_library_info").putString("library_id", r1);
        int r2 = up5.b.b;
        return new up5.b(r5.space_id);
    }
}
