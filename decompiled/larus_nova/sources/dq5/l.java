package dq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ce5.a f469677a;

    public l(ce5.a r100) {
        this.f469677a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SpaceInfo r101 = (SpaceInfo) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        int r102 = j.f469673a;
        String r103 = r101.space_id;
        ((by4.d) this.f469677a.a(by4.d.class)).b("preference_my_library_info").putString("library_id", r103);
        int r104 = up5.b.f551047b;
        return new up5.b(r101.space_id);
    }
}
