package az3;

import com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a<V extends com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a> {
    public final wy3.a a;
    public V b;

    public void A(V r2) {
        Intrinsics.checkNotNullParameter(r2, "viewProvider");
    }

    public void C() {
    }

    public void D() {
    }

    public a(wy3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cmtContext");
        this.a = r2;
    }
}
