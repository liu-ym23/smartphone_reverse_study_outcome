package xb3;

import com.bytedance.android.shopping.commentfeed.api.CommentFeedListApi;
import com.bytedance.android.shopping.commentfeed.model.CommentListResponse;
import com.bytedance.jedi.model.fetcher.AbstractFetcher;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import zb3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends AbstractFetcher<d, CommentListResponse, d, CommentListResponse> {
    public b() {
    }

    public final Object d(Object r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "req");
        return r3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Observable g(Object r10) {
        d r11 = (d) r10;
        Intrinsics.checkNotNullParameter(r11, "req");
        CommentFeedListApi.a.getClass();
        Intrinsics.checkNotNullParameter(r11, "params");
        CommentFeedListApi r1 = CommentFeedListApi.a.a;
        if (r1 == null) goto L12;
        String r0 = r11.a;
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        long r3 = r11.c;
        long r5 = r11.b;
        String r7 = r11.d;
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        Observable<CommentListResponse> r12 = r1.getCommentList(r0, r3, r5, r7, r11.e ? 1 : 0);
        if (r12 == null) goto L12;
    L14:
        return r12.subscribeOn(Schedulers.io());
    L12:
        r12 = Observable.error(new Exception("CommentFeedListApi.INSTANCE is null"));
        goto L14
    }

    public final Object e(Object r2, Object r3) {
        CommentListResponse r4 = (CommentListResponse) r3;
        Intrinsics.checkNotNullParameter((d) r2, "req");
        Intrinsics.checkNotNullParameter(r4, "resp");
        return r4;
    }
}
