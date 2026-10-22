package com.bytedance.ee.bear.bitable.infoarch.header;

import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/header/HeaderContainerModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "mainTitle", "", "getMainTitle", "()Ljava/lang/String;", "setMainTitle", "(Ljava/lang/String;)V", "subTitle", "getSubTitle", "setSubTitle", "tableIcon", "getTableIcon", "setTableIcon", "tableStatusTag", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getTableStatusTag", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setTableStatusTag", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeaderContainerModel implements NonProguard {
    private Icon icon;
    private String mainTitle;
    private String subTitle;
    private Icon tableIcon;
    private SimpleItemModel tableStatusTag;

    public HeaderContainerModel() {
    }

    public String toString() {
        return "HeaderData(icon=" + this.icon + ", mainTitle=" + this.mainTitle + ", subTitle=" + this.subTitle + ')';
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final String getMainTitle() {
        return this.mainTitle;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final Icon getTableIcon() {
        return this.tableIcon;
    }

    public final SimpleItemModel getTableStatusTag() {
        return this.tableStatusTag;
    }

    public final void setIcon(Icon r100) {
        this.icon = r100;
    }

    public final void setMainTitle(String r100) {
        this.mainTitle = r100;
    }

    public final void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public final void setTableIcon(Icon r100) {
        this.tableIcon = r100;
    }

    public final void setTableStatusTag(SimpleItemModel r100) {
        this.tableStatusTag = r100;
    }
}
