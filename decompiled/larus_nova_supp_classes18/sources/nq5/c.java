package nq5;

import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import yq5.f;
import yq5.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T, R> implements Function {
    public static final c<T, R> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object apply(Object r5) {
        Intrinsics.checkNotNullParameter((String) r5, "it");
        tt5.a.h("ShareTreeDataManager", "requestShare cacheDataFlow start");
        f r0 = WikiDatabase.c().d();
        VirtualNode r1 = e.a;
        WikiRelation r2 = s.e(r0.i(r1.getSpaceId()), r1.getRootToken());
        boolean r3 = r2.isValid();
        tt5.a.h("ShareTreeDataManager", "requestShare, load relation from db. valid= " + r3);
        if (r3 == false) goto L5;
        ResultCode r6 = ResultCode.DECO;
    L7:
        return kq5.d.a(new a(r6), r2);
    L5:
        r6 = ResultCode.DEC1;
        goto L7
    }
}
