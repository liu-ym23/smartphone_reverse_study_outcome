package com.bytedance.ee.bear.bitable.panel;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010X\u001a\u0004\u0018\u0001HY\"\u0004\b\u0000\u0010Y¢\u0006\u0002\u0010ZJ\u0006\u0010[\u001a\u00020\u000fJ\u0006\u0010\\\u001a\u00020]R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\nR\u001e\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R\u001c\u0010<\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010\nR\u001c\u0010?\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\b\"\u0004\bA\u0010\nR\u001c\u0010B\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010.\"\u0004\bD\u00100R\u001e\u0010E\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\bF\u0010'\"\u0004\bG\u0010)R\u001e\u0010H\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\bI\u0010'\"\u0004\bJ\u0010)R\u001e\u0010K\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\bK\u0010\u0011\"\u0004\bL\u0010\u0013R\u001c\u0010M\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\b\"\u0004\bO\u0010\nR\u001e\u0010P\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\bP\u0010\u0011\"\u0004\bQ\u0010\u0013R\u001c\u0010R\u001a\u0004\u0018\u00010SX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006^"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/BitablePanelItem;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "groupId", "getGroupId", "setGroupId", "enable", "", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "editable", "getEditable", "setEditable", GXTemplateKey.GAIAX_PLACEHOLDER, "getPlaceholder", "setPlaceholder", "checkbox", "Lcom/bytedance/ee/bear/bitable/panel/CheckboxValue;", "getCheckbox", "()Lcom/bytedance/ee/bear/bitable/panel/CheckboxValue;", "setCheckbox", "(Lcom/bytedance/ee/bear/bitable/panel/CheckboxValue;)V", "leftText", "getLeftText", "setLeftText", "maxLines", "", "getMaxLines", "()Ljava/lang/Integer;", "setMaxLines", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "leftIcon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "getLeftIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setLeftIcon", "(Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "leftIconTag", "getLeftIconTag", "setLeftIconTag", "leftStyle", "getLeftStyle", "()I", "setLeftStyle", "(I)V", "leftIconStyle", "getLeftIconStyle", "setLeftIconStyle", "tagText", "getTagText", "setTagText", "rightText", "getRightText", "setRightText", "rightIcon", "getRightIcon", "setRightIcon", "rightStyle", "getRightStyle", "setRightStyle", "rightIconStyle", "getRightIconStyle", "setRightIconStyle", "isHidden", "setHidden", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "isSwitchOn", "setSwitchOn", "customItem", "Lcom/bytedance/ee/bear/bitable/panel/ExtendItemDataWrapper;", "getCustomItem", "()Lcom/bytedance/ee/bear/bitable/panel/ExtendItemDataWrapper;", "setCustomItem", "(Lcom/bytedance/ee/bear/bitable/panel/ExtendItemDataWrapper;)V", "getExtendItemData", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "showPressStatus", "getExtendItem", "Lcom/bytedance/ee/bear/bitable/panel/ExtendItemEnum;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitablePanelItem extends GroupMultiItemModel {
    private CheckboxValue checkbox;
    private ExtendItemDataWrapper customItem;
    private String desc;
    private Boolean editable;
    private Boolean enable;
    private String groupId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f214807id;
    private Boolean isHidden;
    private Boolean isSwitchOn;
    private Icon leftIcon;
    private Integer leftIconStyle;
    private Icon leftIconTag;
    private int leftStyle;
    private String leftText;
    private Integer maxLines;
    private String placeholder;
    private Icon rightIcon;
    private Integer rightIconStyle;
    private Integer rightStyle;
    private String rightText;
    private String tagText;

    public final ExtendItemEnum getExtendItem() {
        ExtendItemDataWrapper r100 = this.customItem;
        if (r100 == null) goto L5;
        ExtendItemData r101 = r100.getData();
    L6:
        if (r101 == null) goto L9;
        return r101.getExtendItem();
    L9:
        if (this.isSwitchOn == null) goto L12;
        return ExtendItemEnum.ITEM_SWITCH;
    L12:
        return ExtendItemEnum.ITEM_COMMON_PANEL_ITEM;
    L5:
        r101 = null;
        goto L6
    }

    public final <T> T getExtendItemData() {
        ExtendItemDataWrapper r100 = this.customItem;
        if (r100 == null) goto L5;
        ExtendItemData r101 = r100.getData();
    L6:
        if (r101 != null) goto L9;
        return null;
    L9:
        return (T) r101;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean showPressStatus() {
        if (Intrinsics.areEqual(this.enable, Boolean.TRUE) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.leftStyle == Style.Disable.getValue()) goto L7;
        return true;
    }

    public BitablePanelItem() {
        this.enable = Boolean.TRUE;
        this.editable = Boolean.FALSE;
        this.leftStyle = 1;
    }

    public final CheckboxValue getCheckbox() {
        return this.checkbox;
    }

    public final ExtendItemDataWrapper getCustomItem() {
        return this.customItem;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Boolean getEditable() {
        return this.editable;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel
    public String getGroupId() {
        return this.groupId;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel
    public String getId() {
        return this.f214807id;
    }

    public final Icon getLeftIcon() {
        return this.leftIcon;
    }

    public final Integer getLeftIconStyle() {
        return this.leftIconStyle;
    }

    public final Icon getLeftIconTag() {
        return this.leftIconTag;
    }

    public final int getLeftStyle() {
        return this.leftStyle;
    }

    public final String getLeftText() {
        return this.leftText;
    }

    public final Integer getMaxLines() {
        return this.maxLines;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final Icon getRightIcon() {
        return this.rightIcon;
    }

    public final Integer getRightIconStyle() {
        return this.rightIconStyle;
    }

    public final Integer getRightStyle() {
        return this.rightStyle;
    }

    public final String getRightText() {
        return this.rightText;
    }

    public final String getTagText() {
        return this.tagText;
    }

    public final Boolean isHidden() {
        return this.isHidden;
    }

    public final Boolean isSwitchOn() {
        return this.isSwitchOn;
    }

    public final void setCheckbox(CheckboxValue r100) {
        this.checkbox = r100;
    }

    public final void setCustomItem(ExtendItemDataWrapper r100) {
        this.customItem = r100;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setEditable(Boolean r100) {
        this.editable = r100;
    }

    public final void setEnable(Boolean r100) {
        this.enable = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel
    public void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setHidden(Boolean r100) {
        this.isHidden = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel
    public void setId(String r100) {
        this.f214807id = r100;
    }

    public final void setLeftIcon(Icon r100) {
        this.leftIcon = r100;
    }

    public final void setLeftIconStyle(Integer r100) {
        this.leftIconStyle = r100;
    }

    public final void setLeftIconTag(Icon r100) {
        this.leftIconTag = r100;
    }

    public final void setLeftStyle(int r100) {
        this.leftStyle = r100;
    }

    public final void setLeftText(String r100) {
        this.leftText = r100;
    }

    public final void setMaxLines(Integer r100) {
        this.maxLines = r100;
    }

    public final void setPlaceholder(String r100) {
        this.placeholder = r100;
    }

    public final void setRightIcon(Icon r100) {
        this.rightIcon = r100;
    }

    public final void setRightIconStyle(Integer r100) {
        this.rightIconStyle = r100;
    }

    public final void setRightStyle(Integer r100) {
        this.rightStyle = r100;
    }

    public final void setRightText(String r100) {
        this.rightText = r100;
    }

    public final void setSwitchOn(Boolean r100) {
        this.isSwitchOn = r100;
    }

    public final void setTagText(String r100) {
        this.tagText = r100;
    }
}
