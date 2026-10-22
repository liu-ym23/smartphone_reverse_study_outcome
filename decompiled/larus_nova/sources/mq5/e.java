package mq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T1, T2, R> f514888a = null;

    static {
        f514888a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        WikiRelation r102 = (WikiRelation) r100;
        SpacePerm r103 = (SpacePerm) r101;
        Intrinsics.checkNotNullParameter(r102, "relation");
        Intrinsics.checkNotNullParameter(r103, "rootPermInfo");
        r102.space_perm = r103;
        r102.init();
        tt5.a.h("PersonalTreeDataManager", "requestPersonal, load relation from network. valid= " + r102.isValid());
        return r102;
    }
}
