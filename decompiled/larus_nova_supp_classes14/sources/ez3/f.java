package ez3;

import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends zy3.a {
    public final com.bytedance.awemeopen.apps.framework.comment.write.refactor.g d;

    public f(com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r2) {
        Intrinsics.checkNotNullParameter(r2, "inputContext");
        super(r2);
        this.d = r2;
    }

    @Override // zy3.a
    public final az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> a(wy3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cmtContext");
        return new h(this.d);
    }

    @Override // zy3.a
    public final AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> b(wy3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cmtContext");
        return new o(this.d);
    }
}
