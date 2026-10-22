package com.bytedance.ee.bear.doc.structure;

import com.bytedance.ee.bear.bizwidget.CatalogHelper;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.b;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import ku5.c;
import mz4.x;
import oj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class StructureMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String NAME = "structureV2";
    private static final String TAG = "StructureMoreItemV2";
    private DocumentPluginHost pluginHost;

    public int getIcon() {
        return 2131255955;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return NAME;
    }

    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.-CC.$default$getMoreAction(this);
    }

    public String getStateTips() {
        return "";
    }

    public String getUnableTips() {
        return "";
    }

    public boolean isEnable() {
        return true;
    }

    public boolean needShowBadge() {
        return false;
    }

    public void onDisableClick() {
    }

    private void showFixedStructure() {
        this.pluginHost.findPluginToDo(StructurePlugin.class, new x());
    }

    public boolean isVisible() {
        boolean r1 = false;
        if (((StructurePlugin) this.pluginHost.findPlugin(StructurePlugin.class)) == null) goto L5;
        boolean r0 = true;
    L7:
        if (y.a() == true) goto L11;
        y.c(TAG, getId());
        return r0;
    L11:
        if (c.k(this.pluginHost.getContext()) == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r0 == false) goto L19;
        if (r3 == true) goto L19;
        r1 = true;
    L19:
        y.b(TAG, getId(), r1, r1, "", "structure_device,baselineVisible=" + r0 + ",padCatalogHandled=" + r3 + ",isEditionDoc=" + this.pluginHost.a().isEditionDoc());
        return r1;
    L13:
        if (((Boolean) CatalogHelper.a.getValue()).booleanValue() == false) goto L15;
        r3 = true;
        goto L16
    L5:
        r0 = false;
        goto L7
    }

    public String getTitle() {
        return getString(2131887673);
    }

    public void onClick() {
        showFixedStructure();
        if ((getMoreInfo() instanceof oj5.a) == false) goto L5;
        oj5.a r0 = getMoreInfo();
        ((b) org.koin.java.a.a(b.class)).c(new i(getHost().getHostFragment().getArguments(), r0.c, r0.getType(), false, r0.b(), "catalog", "none", "", "", r0 instanceof f, r0.k, r0.r, r0.isOwner(), r0.L()));
    L5:
        getHost().a();
    }

    public StructureMoreItemV2(DocumentPluginHost r1) {
        this.pluginHost = r1;
    }
}
