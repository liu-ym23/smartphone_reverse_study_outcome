package dq5;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.o;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends WikiTreeCtrlView.d {
    public final /* synthetic */ HomeLibraryFragment a;

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void a(Throwable r1) {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void l() {
        this.a.X90().setSearchEnable(true);
        this.a.V90().setVisibility(0);
    }

    public d(HomeLibraryFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "newToken");
        Intrinsics.checkNotNullParameter(r11, "uniqueUiId");
        TreeNode r0 = this.a.Y90().g(r10);
        if (r0 != null) goto L5;
        return;
    L5:
        HomeLibraryFragment r1 = this.a;
        String r2 = r0.space_id;
        Serializable r3 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.b(r0);
        AnalyticConstant.OpenType r4 = AnalyticConstant.OpenType.WIKI_CREATE_NEW;
        Boolean r5 = Boolean.TRUE;
        String r7 = null;
        if ((128 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((128 & 8) == 0) goto L12;
        r11 = null;
    L12:
        if ((128 & 16) == 0) goto L15;
        r4 = null;
    L15:
        if ((128 & 32) == 0) goto L18;
        r5 = null;
    L18:
        if ((128 & 64) == 0) goto L20;
        String r6 = null;
    L22:
        if ((128 & 128) == 0) goto L24;
        String r8 = "";
    L25:
        Intrinsics.checkNotNullParameter(r2, "spaceId");
        Intrinsics.checkNotNullParameter(r10, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r8, "visibleSpaceId");
        r1.getClass();
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L28;
        g3.a.a.a(r1.Y90().c());
    L28:
        Bundle r9 = new Bundle();
        if (r4 == null) goto L31;
        r7 = r4.getType();
    L31:
        r9.putString("ccm_open_type", r7);
        r9.putSerializable("wiki_info", r3);
        r9.putString("unique_ui_id", r11);
        r9.putString("extra_from", r6);
        o.b(r2, "", r10, r9, Boolean.FALSE, null, r8);
        return;
    L24:
        r8 = null;
        goto L25
    L20:
        r6 = "tab_create";
        goto L22
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void f(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r12, "uniqueUiId");
        TreeNode r1 = this.a.Y90().g(r11);
        if (r1 != null) goto L5;
        return;
    L5:
        HomeLibraryFragment r2 = this.a;
        String r3 = r1.space_id;
        Serializable r4 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.b(r1);
        AnalyticConstant.OpenType r5 = AnalyticConstant.OpenType.WIKI_ALL;
        Boolean r6 = Boolean.TRUE;
        if ((192 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((192 & 8) == 0) goto L12;
        r12 = null;
    L12:
        if ((192 & 16) == 0) goto L15;
        r5 = null;
    L15:
        if ((192 & 32) == 0) goto L18;
        r6 = null;
    L18:
        if ((192 & 128) == 0) goto L20;
        String r9 = "";
    L21:
        Intrinsics.checkNotNullParameter(r3, "spaceId");
        Intrinsics.checkNotNullParameter(r11, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r9, "visibleSpaceId");
        r2.getClass();
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L24;
        g3.a.a.a(r2.Y90().c());
    L24:
        Bundle r7 = new Bundle();
        if (r5 == null) goto L27;
        String r0 = r5.getType();
    L28:
        r7.putString("ccm_open_type", r0);
        r7.putSerializable("wiki_info", r4);
        r7.putString("unique_ui_id", r12);
        r7.putString("extra_from", null);
        o.b(r3, "", r11, r7, Boolean.FALSE, null, r9);
        return;
    L27:
        r0 = null;
        goto L28
    L20:
        r9 = null;
        goto L21
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void g(String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "toSpaceId");
        Intrinsics.checkNotNullParameter(r13, "toToken");
        Intrinsics.checkNotNullParameter(r14, "toSpaceName");
        HomeLibraryFragment r15 = this.a;
        AnalyticConstant.OpenType r0 = AnalyticConstant.OpenType.WIKI_CREATE_NEW;
        if ((236 & 16) == 0) goto L6;
        r0 = null;
    L6:
        if ((236 & 128) == 0) goto L8;
        String r10 = "";
    L9:
        Intrinsics.checkNotNullParameter(r12, "spaceId");
        Intrinsics.checkNotNullParameter(r13, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r10, "visibleSpaceId");
        r15.getClass();
        if (Intrinsics.areEqual(null, Boolean.TRUE) == false) goto L12;
        g3.a.a.a(r15.Y90().c());
    L12:
        Bundle r7 = new Bundle();
        if (r0 == null) goto L15;
        String r16 = r0.getType();
    L16:
        r7.putString("ccm_open_type", r16);
        r7.putSerializable("wiki_info", null);
        r7.putString("unique_ui_id", null);
        r7.putString("extra_from", null);
        o.b(r12, "", r13, r7, Boolean.FALSE, null, r10);
        return;
    L15:
        r16 = null;
        goto L16
    L8:
        r10 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void o(String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "toSpaceId");
        Intrinsics.checkNotNullParameter(r13, "toToken");
        Intrinsics.checkNotNullParameter(r14, "toSpaceName");
        HomeLibraryFragment r15 = this.a;
        AnalyticConstant.OpenType r0 = AnalyticConstant.OpenType.WIKI_CREATE_NEW;
        if ((236 & 16) == 0) goto L6;
        r0 = null;
    L6:
        if ((236 & 128) == 0) goto L8;
        String r10 = "";
    L9:
        Intrinsics.checkNotNullParameter(r12, "spaceId");
        Intrinsics.checkNotNullParameter(r13, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r10, "visibleSpaceId");
        r15.getClass();
        if (Intrinsics.areEqual(null, Boolean.TRUE) == false) goto L12;
        g3.a.a.a(r15.Y90().c());
    L12:
        Bundle r7 = new Bundle();
        if (r0 == null) goto L15;
        String r16 = r0.getType();
    L16:
        r7.putString("ccm_open_type", r16);
        r7.putSerializable("wiki_info", null);
        r7.putString("unique_ui_id", null);
        r7.putString("extra_from", null);
        o.b(r12, "", r13, r7, Boolean.FALSE, null, r10);
        return;
    L15:
        r16 = null;
        goto L16
    L8:
        r10 = null;
        goto L9
    }
}
