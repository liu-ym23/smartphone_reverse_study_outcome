package com.bytedance.ee.bear.bitable.uikit.catalog;

import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001c\u0010\"\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001a\u0010%\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001c\u0010/\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isSelected", "", "()Z", "setSelected", "(Z)V", "clickAction", "", "getClickAction", "()Ljava/lang/String;", "setClickAction", "(Ljava/lang/String;)V", "leftStyle", "", "getLeftStyle", "()Ljava/lang/Integer;", "setLeftStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "leftIcon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getLeftIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setLeftIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "rightIcon", "getRightIcon", "setRightIcon", "id", "getId", "setId", "leftText", "getLeftText", "setLeftText", "level", "getLevel", "()I", "setLevel", "(I)V", "enableCollapsed", "getEnableCollapsed", "setEnableCollapsed", "isCollapsed", "setCollapsed", "rightSecondaryIcon", "getRightSecondaryIcon", "setRightSecondaryIcon", "blockStatusTag", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getBlockStatusTag", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setBlockStatusTag", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogItemModel implements NonProguard {
    private SimpleItemModel blockStatusTag;
    private String clickAction;
    private boolean enableCollapsed;
    private String id;
    private boolean isCollapsed;
    private boolean isSelected;
    private Icon leftIcon;
    private Integer leftStyle;
    private String leftText;
    private int level;
    private Icon rightIcon;
    private Icon rightSecondaryIcon;

    public CatalogItemModel() {
    }

    public final SimpleItemModel getBlockStatusTag() {
        return this.blockStatusTag;
    }

    public final String getClickAction() {
        return this.clickAction;
    }

    public final boolean getEnableCollapsed() {
        return this.enableCollapsed;
    }

    public final String getId() {
        return this.id;
    }

    public final Icon getLeftIcon() {
        return this.leftIcon;
    }

    public final Integer getLeftStyle() {
        return this.leftStyle;
    }

    public final String getLeftText() {
        return this.leftText;
    }

    public final int getLevel() {
        return this.level;
    }

    public final Icon getRightIcon() {
        return this.rightIcon;
    }

    public final Icon getRightSecondaryIcon() {
        return this.rightSecondaryIcon;
    }

    public final boolean isCollapsed() {
        return this.isCollapsed;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setBlockStatusTag(SimpleItemModel r1) {
        this.blockStatusTag = r1;
    }

    public final void setClickAction(String r1) {
        this.clickAction = r1;
    }

    public final void setCollapsed(boolean r1) {
        this.isCollapsed = r1;
    }

    public final void setEnableCollapsed(boolean r1) {
        this.enableCollapsed = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setLeftIcon(Icon r1) {
        this.leftIcon = r1;
    }

    public final void setLeftStyle(Integer r1) {
        this.leftStyle = r1;
    }

    public final void setLeftText(String r1) {
        this.leftText = r1;
    }

    public final void setLevel(int r1) {
        this.level = r1;
    }

    public final void setRightIcon(Icon r1) {
        this.rightIcon = r1;
    }

    public final void setRightSecondaryIcon(Icon r1) {
        this.rightSecondaryIcon = r1;
    }

    public final void setSelected(boolean r1) {
        this.isSelected = r1;
    }
}
