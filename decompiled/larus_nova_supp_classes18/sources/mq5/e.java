package mq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T1, T2, R> implements BiFunction {
    public static final e<T1, T2, R> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r3, Object r4) {
        WikiRelation r5 = (WikiRelation) r3;
        SpacePerm r6 = (SpacePerm) r4;
        Intrinsics.checkNotNullParameter(r5, "relation");
        Intrinsics.checkNotNullParameter(r6, "rootPermInfo");
        r5.space_perm = r6;
        r5.init();
        tt5.a.h("PersonalTreeDataManager", "requestPersonal, load relation from network. valid= " + r5.isValid());
        return r5;
    }
}
