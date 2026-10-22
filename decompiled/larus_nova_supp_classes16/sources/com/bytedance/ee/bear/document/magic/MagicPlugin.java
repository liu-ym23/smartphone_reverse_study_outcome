package com.bytedance.ee.bear.document.magic;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.comment.CommentPanelViewModel;
import com.bytedance.ee.bear.document.feed.FeedPanelViewModel;
import com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import java.util.Iterator;
import ocb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class MagicPlugin extends DocumentPlugin implements a {
    private static final String TAG = "MagicPlugin";
    private boolean isKeyboardShowing;

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean canShowMagicPanel() {
        if (this.isKeyboardShowing == false) goto L6;
        tt5.a.h(TAG, "can not show MagicPanel >> keyboard is showing");
        return false;
    L6:
        g45.a r0 = (g45.a) ((DocumentPluginHost) getHost()).b().getActiveEditPanel().getValue();
        if (r0 == null) goto L10;
        tt5.a.h(TAG, "can not show MagicPanel >> activeEditPanel = " + r0);
        return false;
    L10:
        BaseSelectionPlugin r1 = (BaseSelectionPlugin) findPlugin(BaseSelectionPlugin.class);
        if (r1 != null) goto L13;
    L16:
        CommentPanelViewModel r2 = (CommentPanelViewModel) viewModel(CommentPanelViewModel.class);
        if (r2 != null) goto L19;
    L22:
        FeedPanelViewModel r3 = (FeedPanelViewModel) viewModel(FeedPanelViewModel.class);
        if (r3 != null) goto L25;
    L28:
        Iterator r4 = getActivity().getSupportFragmentManager().getFragments().iterator();
    L30:
        if (r4.hasNext() == false) goto L35;
        Fragment r5 = (Fragment) r4.next();
        if ((r5 instanceof DialogFragment) == false) goto L30;
        tt5.a.h(TAG, "can not show MagicPanel >> DialogFragment " + r5.getClass().getSimpleName() + " is showing");
        return false;
    L35:
        Iterator r6 = ((DocumentPluginHost) getHost()).getHostFragment().getChildFragmentManager().getFragments().iterator();
    L37:
        if (r6.hasNext() == false) goto L42;
        Fragment r7 = (Fragment) r6.next();
        if ((r7 instanceof DialogFragment) == false) goto L37;
        tt5.a.h(TAG, "can not show MagicPanel >> DialogFragment " + r7.getClass().getSimpleName() + " is showing");
        return false;
    L42:
        tt5.a.h(TAG, "can show MagicPanel");
        return true;
    L25:
        if (r3.isShowing() == false) goto L28;
        tt5.a.h(TAG, "can not show MagicPanel >> feed panel is showing");
        return false;
    L19:
        if (r2.isShowingComment().getValue() != Boolean.TRUE) goto L22;
        tt5.a.h(TAG, "can not show MagicPanel >> comment panel is showing");
        return false;
    L13:
        if (r1.isShowingActionMode() == false) goto L16;
        tt5.a.h(TAG, "can not show MagicPanel >> ActionMode is showing");
        return false;
    }

    private String getDocumentScenarioId() {
        String r0 = getDocViewModel().getOriginBearUrl().a;
        if (r0 != null) goto L5;
        return "";
    L5:
        byte r3 = -1;
        switch(r0.hashCode()) {
            case -1363649724: goto L29;
            case -102775833: goto L25;
            case 99640: goto L21;
            case 3088960: goto L17;
            case 3649456: goto L13;
            case 109403487: goto L9;
            default: goto L32;
        };
    L32:
        switch(r3) {
            case 0: goto L44;
            case 1: goto L42;
            case 2: goto L40;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L34;
            default: goto L33;
        };
    L33:
        return "";
    L34:
        return "ccm_sheet_content";
    L36:
        return "ccm_wiki_content";
    L38:
        return "ccm_docx_content";
    L40:
        return "ccm_doc_content";
    L42:
        return "ccm_bitable_content";
    L44:
        return "ccm_mindnote_content";
    L9:
        if (r0.equals("sheet") == false) goto L32;
        r3 = 5;
        goto L32
    L13:
        if (r0.equals(FileInfoPuller.CALLER_WIKI) == false) goto L32;
        r3 = 4;
        goto L32
    L17:
        if (r0.equals("docx") == false) goto L32;
        r3 = 3;
        goto L32
    L21:
        if (r0.equals("doc") == false) goto L32;
        r3 = 2;
        goto L32
    L25:
        if (r0.equals("bitable") == false) goto L32;
        r3 = 1;
        goto L32
    L29:
        if (r0.equals("mindnote") == false) goto L32;
        r3 = 0;
        goto L32
    }

    public MagicPlugin() {
    }

    public void onAttachToUIContainer(DocumentPluginHost r3, t r4) {
        super.onAttachToUIContainer(r3, r4);
        pcb.a.a.b(r3.getActivity()).c(this);
        ((yw4.a) org.koin.java.a.a(yw4.a.class)).b(getDocumentScenarioId(), getContext(), new x15.a());
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        pcb.a.a.b(r1.getActivity()).a(this);
        ((yw4.a) org.koin.java.a.a(yw4.a.class)).a(getDocumentScenarioId());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        if (r2 <= 0) goto L4;
        boolean r4 = true;
    L5:
        this.isKeyboardShowing = r4;
        return;
    L4:
        r4 = false;
        goto L5
    }
}
