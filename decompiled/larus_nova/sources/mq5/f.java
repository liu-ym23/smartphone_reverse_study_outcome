package mq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import yq5.s;

/* JADX INFO: loaded from: classes18.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T, R> f514889a = null;

    static {
        f514889a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        WikiRelation r101 = (WikiRelation) r100;
        Intrinsics.checkNotNullParameter(r101, "relation");
        tt5.a.h("PersonalTreeDataManager", "requestPersonal, save relation to db. ");
        WikiDatabase.c().d().a(s.b(r101));
        return kq5.d.a(new c(ResultCode.DECO), r101);
    }
}
