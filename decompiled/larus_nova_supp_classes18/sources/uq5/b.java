package uq5;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements com.bytedance.ee.bear.wikiv2.searchv2.b.a {
    public final /* synthetic */ WikiTreePanelDialog a;

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void b() {
        WikiTreeCtrlView r0 = this.a.ea0();
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void onExitSearch() {
        WikiTreeCtrlView r0 = this.a.ea0();
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    public b(WikiTreePanelDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void a(String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r16, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r17, "spaceId");
        WikiTreePanelDialog r13 = this.a;
        if (r18 != null) goto L5;
        String r11 = "";
    L6:
        a r14 = new a(r16, false, null, null, null, null, false, null, null, r11, 1020);
        int r1 = WikiTreePanelDialog.w;
        r13.fa0(r14);
        return;
    L5:
        r11 = r18;
        goto L6
    }
}
