package h35;

import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.y3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static EditPanelsManager a(ChameleonPluginHost r1) {
        Intrinsics.checkNotNullParameter(r1, "host");
        return (EditPanelsManager) ViewModelProviders.of(r1.getActivity()).get(EditPanelsManager.class);
    }

    public static b b(y3 r4) {
        Intrinsics.checkNotNullParameter(r4, "documentMetadata");
        boolean r2 = false;
        if (r4.getOpenSource() != DocsOpenSource.template_preview) goto L5;
        boolean r0 = true;
    L6:
        boolean r5 = r4.isCommonTemplatePreview();
        if (r5 == false) goto L9;
        r0 = false;
    L9:
        if (r0 == true) goto L11;
        if (r5 == true) goto L11;
    L13:
        return new b(r2, r0, r5);
    L11:
        r2 = true;
        goto L13
    L5:
        r0 = false;
        goto L6
    }
}
