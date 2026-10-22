package com.bytedance.ee.bear.bitable.managerpanel;

import com.alibaba.fastjson.JSON;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.util.io.NonProguard;
import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0005$%&'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J\b\u0010#\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "data", "", "Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BlockBean;", "getData", "()[Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BlockBean;", "setData", "([Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BlockBean;)V", "[Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BlockBean;", "bottomFixedDatas", "Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BottomFixedData;", "getBottomFixedDatas", "()[Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BottomFixedData;", "setBottomFixedDatas", "([Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BottomFixedData;)V", "[Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BottomFixedData;", "activeTableIndex", "", "getActiveTableIndex", "()Ljava/lang/Integer;", "setActiveTableIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "convert2MultiItemEntities", "", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "toString", "BlockBean", "ViewBean", "BottomFixedData", "MenuAction", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableManagerPanelData implements NonProguard {
    public static final a Companion = null;
    public static final int ITEM_FIRST_LEVEL = 1;
    public static final int ITEM_SECOND_LEVEL = 2;
    private Integer activeTableIndex;
    private BottomFixedData[] bottomFixedDatas;
    private BlockBean[] data;
    private String title;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010.\u001a\u00020\u001eJ\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010)\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001a\u0010+\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BlockBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/entity/AbstractExpandableItem;", "Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$ViewBean;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "type", "getType", "setType", "text", "getText", "setText", "icon", "getIcon", "setIcon", SlcCommonAction.KEY_ACTIONS, "", "getActions", "()[Ljava/lang/String;", "setActions", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "active", "", "getActive", "()Z", "setActive", "(Z)V", "views", "getViews", "()[Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$ViewBean;", "setViews", "([Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$ViewBean;)V", "[Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$ViewBean;", "isSync", "setSync", "shouldShowWarningIcon", "getShouldShowWarningIcon", "setShouldShowWarningIcon", "isActiveWithoutSubItem", "getItemType", "", "getLevel", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BlockBean extends AbstractExpandableItem<ViewBean> implements NonProguard, MultiItemEntity {
        private String[] actions;
        private boolean active;
        private String icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f214655id;
        private boolean isSync;
        private boolean shouldShowWarningIcon;
        private String text;
        private String type;
        private ViewBean[] views;

        @Override // com.chad.library.adapter.base.entity.MultiItemEntity
        public int getItemType() {
            return 1;
        }

        @Override // com.chad.library.adapter.base.entity.IExpandable
        public int getLevel() {
            return 0;
        }

        public final boolean isActiveWithoutSubItem() {
            if (hasSubItem() == false) goto L5;
        L7:
            return false;
        L5:
            if (this.active == false) goto L7;
            return true;
        }

        public BlockBean() {
        }

        public final String[] getActions() {
            return this.actions;
        }

        public final boolean getActive() {
            return this.active;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getId() {
            return this.f214655id;
        }

        public final boolean getShouldShowWarningIcon() {
            return this.shouldShowWarningIcon;
        }

        public final String getText() {
            return this.text;
        }

        public final String getType() {
            return this.type;
        }

        public final ViewBean[] getViews() {
            return this.views;
        }

        public final boolean isSync() {
            return this.isSync;
        }

        public final void setActions(String[] r100) {
            this.actions = r100;
        }

        public final void setActive(boolean r100) {
            this.active = r100;
        }

        public final void setIcon(String r100) {
            this.icon = r100;
        }

        public final void setId(String r100) {
            this.f214655id = r100;
        }

        public final void setShouldShowWarningIcon(boolean r100) {
            this.shouldShowWarningIcon = r100;
        }

        public final void setSync(boolean r100) {
            this.isSync = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }

        public final void setType(String r100) {
            this.type = r100;
        }

        public final void setViews(ViewBean[] r100) {
            this.views = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$BottomFixedData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "text", "getText", "setText", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "style", "getStyle", "setStyle", "showBadge", "getShowBadge", "setShowBadge", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BottomFixedData implements NonProguard {
        private boolean enable;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f214656id;
        private boolean showBadge;
        private String style;
        private String text;

        public BottomFixedData() {
            this.enable = true;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final String getId() {
            return this.f214656id;
        }

        public final boolean getShowBadge() {
            return this.showBadge;
        }

        public final String getStyle() {
            return this.style;
        }

        public final String getText() {
            return this.text;
        }

        public final void setEnable(boolean r100) {
            this.enable = r100;
        }

        public final void setId(String r100) {
            this.f214656id = r100;
        }

        public final void setShowBadge(boolean r100) {
            this.showBadge = r100;
        }

        public final void setStyle(String r100) {
            this.style = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$MenuAction;", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface MenuAction {
        public static final String ADD_VIEW = "add_view";
        public static final a Companion = null;
        public static final String MORE = "more";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f214657a = null;

            static {
                f214657a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f214657a;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010'\u001a\u00020(H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010\n¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/managerpanel/BitableManagerPanelData$ViewBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "type", "getType", "setType", "text", "getText", "setText", "icon", "getIcon", "setIcon", "iconUrl", "getIconUrl", "setIconUrl", SlcCommonAction.KEY_ACTIONS, "", "getActions", "()[Ljava/lang/String;", "setActions", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "active", "", "getActive", "()Z", "setActive", "(Z)V", "parentTableId", "getParentTableId", "setParentTableId", "getItemType", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewBean implements NonProguard, MultiItemEntity {
        private String[] actions;
        private boolean active;
        private String icon;
        private String iconUrl;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f214658id;
        private String parentTableId;
        private String text;
        private String type;

        public ViewBean() {
        }

        @Override // com.chad.library.adapter.base.entity.MultiItemEntity
        public int getItemType() {
            return 2;
        }

        public final String[] getActions() {
            return this.actions;
        }

        public final boolean getActive() {
            return this.active;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final String getId() {
            return this.f214658id;
        }

        public final String getParentTableId() {
            return this.parentTableId;
        }

        public final String getText() {
            return this.text;
        }

        public final String getType() {
            return this.type;
        }

        public final void setActions(String[] r100) {
            this.actions = r100;
        }

        public final void setActive(boolean r100) {
            this.active = r100;
        }

        public final void setIcon(String r100) {
            this.icon = r100;
        }

        public final void setIconUrl(String r100) {
            this.iconUrl = r100;
        }

        public final void setId(String r100) {
            this.f214658id = r100;
        }

        public final void setParentTableId(String r100) {
            this.parentTableId = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }

        public final void setType(String r100) {
            this.type = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BitableManagerPanelData() {
    }

    public final List<MultiItemEntity> convert2MultiItemEntities() {
        BlockBean[] r100 = this.data;
        if (r100 == null) goto L16;
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r103 >= r102) goto L15;
        BlockBean r105 = r100[r103];
        int r106 = r104 + 1;
        ViewBean[] r107 = r105.getViews();
        if (r107 == null) goto L11;
        int r108 = r107.length;
        int r110 = 0;
    L9:
        if (r110 >= r108) goto L11;
        ViewBean r111 = r107[r110];
        r105.addSubItem(r111);
        r111.setParentTableId(r105.getId());
        r110 = r110 + 1;
    L11:
        r101.add(r105);
        if (r105.getActive() == false) goto L14;
        this.activeTableIndex = Integer.valueOf(r104);
    L14:
        r103 = r103 + 1;
        r104 = r106;
        goto L5
    L15:
        return r101;
    L16:
        return null;
    }

    public String toString() {
        return "BitableManagerPanelData : title = " + this.title + " data = " + JSON.toJSONString(this.data) + " bottomFixedData = " + JSON.toJSONString(this.bottomFixedDatas);
    }

    public final Integer getActiveTableIndex() {
        return this.activeTableIndex;
    }

    public final BottomFixedData[] getBottomFixedDatas() {
        return this.bottomFixedDatas;
    }

    public final BlockBean[] getData() {
        return this.data;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setActiveTableIndex(Integer r100) {
        this.activeTableIndex = r100;
    }

    public final void setBottomFixedDatas(BottomFixedData[] r100) {
        this.bottomFixedDatas = r100;
    }

    public final void setData(BlockBean[] r100) {
        this.data = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
