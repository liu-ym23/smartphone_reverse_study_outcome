package ez3;

import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.AbstractUIModule;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends zy3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.comment.write.refactor.g f474872d;

    public f(com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r100) {
        Intrinsics.checkNotNullParameter(r100, "inputContext");
        super(r100);
        this.f474872d = r100;
    }

    @Override // zy3.a
    public final az3.a<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> a(wy3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cmtContext");
        return new h(this.f474872d);
    }

    @Override // zy3.a
    public final AbstractUIModule<? extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> b(wy3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cmtContext");
        return new o(this.f474872d);
    }
}
