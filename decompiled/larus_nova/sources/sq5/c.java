package sq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements UDToast.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TreeNode f543010a;

    public c(TreeNode r100) {
        this.f543010a = r100;
    }

    @Override // com.larksuite.component.universe_design.toast.UDToast.b
    public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toast");
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(this.f543010a.url);
    }
}
