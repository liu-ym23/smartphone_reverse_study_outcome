package mq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import yq5.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T, R> implements Function {
    public static final f<T, R> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r3) {
        WikiRelation r4 = (WikiRelation) r3;
        Intrinsics.checkNotNullParameter(r4, "relation");
        tt5.a.h("PersonalTreeDataManager", "requestPersonal, save relation to db. ");
        WikiDatabase.c().d().a(s.b(r4));
        return kq5.d.a(new c(ResultCode.DECO), r4);
    }
}
