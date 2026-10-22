package com.ss.android.lark.inline.ai.api.creationai;

import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010,\u001a\u00020\u000eH\u0016J\u0013\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010/H\u0096\u0002J\b\u00100\u001a\u00020 H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "Ljava/io/Serializable;", "<init>", "()V", "disabled", "", "getDisabled", "()Z", "setDisabled", "(Z)V", "selected", "getSelected", "setSelected", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "type", "getType", "setType", "icon", "getIcon", "setIcon", "text", "getText", "setText", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "badgeNum", "", "getBadgeNum", "()Ljava/lang/Integer;", "setBadgeNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "rightItem", "Lcom/ss/android/lark/inline/ai/api/creationai/ItemContainer;", "getRightItem", "()Lcom/ss/android/lark/inline/ai/api/creationai/ItemContainer;", "setRightItem", "(Lcom/ss/android/lark/inline/ai/api/creationai/ItemContainer;)V", "toString", "equals", "other", "", "hashCode", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuItem implements Serializable {
    private Integer badgeNum;
    private String desc;
    private boolean disabled;
    private String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f426816id;
    private ItemContainer rightItem;
    private boolean selected;
    private String text;
    private String type;

    public int hashCode() {
        int r100 = 1231;
        if (this.disabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((((((r101 * 31) + this.f426816id.hashCode()) * 31) + this.type.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.text.hashCode()) * 31) + this.desc.hashCode()) * 31;
        Integer r103 = this.badgeNum;
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.hashCode();
    L10:
        int r106 = (r102 + r105) * 31;
        if (this.selected == true) goto L14;
        r100 = 1237;
    L14:
        int r107 = (r106 + r100) * 31;
        ItemContainer r108 = this.rightItem;
        if (r108 == null) goto L18;
        r104 = r108.hashCode();
    L18:
        return r107 + r104;
    L9:
        r105 = 0;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "MenuItem(disabled=" + this.disabled + ", selected=" + this.selected + ", id='" + this.f426816id + "', type='" + this.type + "', icon='" + this.icon + "', text='" + this.text + "', desc='" + this.desc + "', badgeNum=" + this.badgeNum + ')';
    }

    public MenuItem() {
        this.f426816id = "";
        this.type = "";
        this.icon = "";
        this.text = "";
        this.desc = "";
    }

    public final Integer getBadgeNum() {
        return this.badgeNum;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f426816id;
    }

    public final ItemContainer getRightItem() {
        return this.rightItem;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(MenuItem.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.api.creationai.MenuItem");
        MenuItem r102 = (MenuItem) r100;
        if (this.disabled == r102.disabled) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f426816id, r102.f426816id) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.type, r102.type) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.icon, r102.icon) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.text, r102.text) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.desc, r102.desc) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.badgeNum, r102.badgeNum) == true) goto L34;
        return false;
    L34:
        if (this.selected == r102.selected) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual(this.rightItem, r102.rightItem) == true) goto L39;
        return false;
    L39:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setBadgeNum(Integer r100) {
        this.badgeNum = r100;
    }

    public final void setDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.desc = r100;
    }

    public final void setDisabled(boolean r100) {
        this.disabled = r100;
    }

    public final void setIcon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.icon = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f426816id = r100;
    }

    public final void setRightItem(ItemContainer r100) {
        this.rightItem = r100;
    }

    public final void setSelected(boolean r100) {
        this.selected = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }
}
