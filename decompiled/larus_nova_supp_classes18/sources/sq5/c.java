package sq5;

import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements UDToast.b {
    public final /* synthetic */ TreeNode a;

    public c(TreeNode r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.compose.foundation.toast.b r3) {
        Intrinsics.checkNotNullParameter(r3, Notice.CLICK_TYPE_TOAST);
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(this.a.url);
    }
}
