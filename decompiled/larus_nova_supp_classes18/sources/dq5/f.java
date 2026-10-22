package dq5;

import android.os.Bundle;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.mylib.HomeLibraryFragment;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.o;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements com.bytedance.ee.bear.wikiv2.searchv2.b.a {
    public final /* synthetic */ HomeLibraryFragment a;

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void onExitSearch() {
        WikiSearchPickerView r0 = this.a.m;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public f(HomeLibraryFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void a(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r11, "spaceId");
        TreeNode r4 = this.a.Y90().g(r10);
        HomeLibraryFragment r5 = this.a;
        if (r4 == null) goto L5;
        WikiInfo r6 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.b(r4);
    L6:
        AnalyticConstant.OpenType r7 = AnalyticConstant.OpenType.WIKI_ALL;
        if (r12 != null) goto L9;
        String r8 = "";
    L10:
        Intrinsics.checkNotNullParameter(r11, "spaceId");
        Intrinsics.checkNotNullParameter(r10, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r8, "visibleSpaceId");
        r5.getClass();
        if (Intrinsics.areEqual(null, Boolean.TRUE) == false) goto L13;
        g3.a.a.a(r5.Y90().c());
    L13:
        Bundle r3 = new Bundle();
        if (r7 == null) goto L16;
        String r1 = r7.getType();
    L17:
        r3.putString("ccm_open_type", r1);
        r3.putSerializable("wiki_info", r6);
        r3.putString("unique_ui_id", null);
        r3.putString("extra_from", null);
        o.b(r11, "", r10, r3, Boolean.FALSE, null, r8);
        return;
    L16:
        r1 = null;
        goto L17
    L9:
        r8 = r12;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
