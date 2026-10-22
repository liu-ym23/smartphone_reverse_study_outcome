package com.bytedance.ee.bear.bitable.infoarch.toolbar;

import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/toolbar/ToolbarContainerModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", CloudControlInf.STAT, "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getStat", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setStat", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "toolMenu", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getToolMenu", "()Ljava/util/ArrayList;", "setToolMenu", "(Ljava/util/ArrayList;)V", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToolbarContainerModel implements NonProguard {
    private SimpleItemModel stat;
    private ArrayList<SimpleItemModel> toolMenu;

    public ToolbarContainerModel() {
    }

    public String toString() {
        return "ToolbarData(viewStat=" + this.stat + ", menu=" + this.toolMenu + ')';
    }

    public final SimpleItemModel getStat() {
        return this.stat;
    }

    public final ArrayList<SimpleItemModel> getToolMenu() {
        return this.toolMenu;
    }

    public final void setStat(SimpleItemModel r100) {
        this.stat = r100;
    }

    public final void setToolMenu(ArrayList<SimpleItemModel> r100) {
        this.toolMenu = r100;
    }
}
