package com.bytedance.ee.bear.bitable.toolbox.model.panel;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.bitable.cardview.GridViewLayoutType;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.io.NonProguardWithoutSerializable;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u00049:;<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR.\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010-j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006="}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "action", "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "baseId", "getBaseId", "setBaseId", "tableId", "getTableId", "setTableId", "viewId", "getViewId", "setViewId", "viewEditable", "", "getViewEditable", "()Z", "setViewEditable", "(Z)V", WsConstants.KEY_PAYLOAD, "", "getPayload", "()Ljava/lang/Object;", "setPayload", "(Ljava/lang/Object;)V", "srcObjToken", "getSrcObjToken", "setSrcObjToken", "srcObjType", "", "getSrcObjType", "()Ljava/lang/Integer;", "setSrcObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "currTab", "getCurrTab", "setCurrTab", "tabs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTabs", "()Ljava/util/ArrayList;", "setTabs", "(Ljava/util/ArrayList;)V", "button", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButton;", "getButton", "()Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButton;", "setButton", "(Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButton;)V", "Companion", "ViewSettingParams", "TopBarButton", "TopBarButtonStatus", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelData implements NonProguard {
    public static final a Companion = null;
    public static final String TAB_FILTER = "filter";
    public static final String TAB_SORT = "sort";
    public static final String TAB_VIEW_SETTING = "view_setting";
    private String action;
    private String baseId;
    private TopBarButton button;
    private String currTab;
    private Object payload;
    private String srcObjToken;
    private Integer srcObjType;
    private String tableId;
    private ArrayList<String> tabs;
    private boolean viewEditable;
    private String viewId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButton;", "Lcom/bytedance/ee/util/io/NonProguard;", "text", "", "state", "btnAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getState", "getBtnAction", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TopBarButton implements NonProguard {
        private final String btnAction;
        private final String state;
        private final String text;

        public final String getBtnAction() {
            return this.btnAction;
        }

        public final String getState() {
            return this.state;
        }

        public final String getText() {
            return this.text;
        }

        public TopBarButton(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r102, "btnAction");
            this.text = r100;
            this.state = r101;
            this.btnAction = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButtonStatus;", "", "status", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "STATUS_SHOW", "STATUS_LOADING", "STATUS_FINISH", "STATUS_HIDE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TopBarButtonStatus extends Enum<TopBarButtonStatus> {
        public static final TopBarButtonStatus STATUS_FINISH = null;
        public static final TopBarButtonStatus STATUS_HIDE = null;
        public static final TopBarButtonStatus STATUS_LOADING = null;
        public static final TopBarButtonStatus STATUS_SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TopBarButtonStatus[] f216002a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f216003b = null;
        private final String status;

        public static EnumEntries<TopBarButtonStatus> getEntries() {
            return f216003b;
        }

        static {
            TopBarButtonStatus r100 = new TopBarButtonStatus("STATUS_SHOW", 0, "show");
            STATUS_SHOW = r100;
            TopBarButtonStatus r101 = new TopBarButtonStatus("STATUS_LOADING", 1, "loading");
            STATUS_LOADING = r101;
            TopBarButtonStatus r102 = new TopBarButtonStatus("STATUS_FINISH", 2, VideoEventOneOutSync.END_TYPE_FINISH);
            STATUS_FINISH = r102;
            TopBarButtonStatus r103 = new TopBarButtonStatus("STATUS_HIDE", 3, "hide");
            STATUS_HIDE = r103;
            TopBarButtonStatus[] r104 = {r100, r101, r102, r103};
            f216002a = r104;
            f216003b = EnumEntriesKt.enumEntries(r104);
        }

        public static TopBarButtonStatus[] values() {
            return (TopBarButtonStatus[]) f216002a.clone();
        }

        public final String getStatus() {
            return this.status;
        }

        public static TopBarButtonStatus valueOf(String r100) {
            return (TopBarButtonStatus) r27.a.a(TopBarButtonStatus.class, r100);
        }

        public TopBarButtonStatus(String r100, int r101, String r102) {
            super(r100, r101);
            this.status = r102;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010)\u001a\u00020*R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001c\u0010&\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$ViewSettingParams;", "Lcom/bytedance/ee/util/io/NonProguardWithoutSerializable;", "<init>", "()V", "columnCount", "", "getColumnCount", "()I", "setColumnCount", "(I)V", "padColumnCount", "getPadColumnCount", "setPadColumnCount", "showCover", "", "getShowCover", "()Z", "setShowCover", "(Z)V", "visibleFieldIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getVisibleFieldIds", "()Ljava/util/ArrayList;", "setVisibleFieldIds", "(Ljava/util/ArrayList;)V", "gridViewLayoutType", "getGridViewLayoutType", "setGridViewLayoutType", "titleFieldId", "getTitleFieldId", "()Ljava/lang/String;", "setTitleFieldId", "(Ljava/lang/String;)V", "subtitleFieldId", "getSubtitleFieldId", "setSubtitleFieldId", "coverFieldId", "getCoverFieldId", "setCoverFieldId", "optEGridViewType", "Lcom/bytedance/ee/bear/bitable/cardview/GridViewLayoutType;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewSettingParams implements NonProguardWithoutSerializable {
        private int columnCount;
        private String coverFieldId;
        private int gridViewLayoutType;
        private int padColumnCount;
        private boolean showCover;
        private String subtitleFieldId;
        private String titleFieldId;
        private ArrayList<String> visibleFieldIds;

        public final GridViewLayoutType optEGridViewType() {
            if (this.gridViewLayoutType != 2) goto L7;
            return GridViewLayoutType.CardViewLayout;
        L7:
            return GridViewLayoutType.GridViewLayout;
        }

        public ViewSettingParams() {
            this.columnCount = 3;
            this.padColumnCount = 4;
            this.gridViewLayoutType = 1;
        }

        public final int getColumnCount() {
            return this.columnCount;
        }

        public final String getCoverFieldId() {
            return this.coverFieldId;
        }

        public final int getGridViewLayoutType() {
            return this.gridViewLayoutType;
        }

        public final int getPadColumnCount() {
            return this.padColumnCount;
        }

        public final boolean getShowCover() {
            return this.showCover;
        }

        public final String getSubtitleFieldId() {
            return this.subtitleFieldId;
        }

        public final String getTitleFieldId() {
            return this.titleFieldId;
        }

        public final ArrayList<String> getVisibleFieldIds() {
            return this.visibleFieldIds;
        }

        public final void setColumnCount(int r100) {
            this.columnCount = r100;
        }

        public final void setCoverFieldId(String r100) {
            this.coverFieldId = r100;
        }

        public final void setGridViewLayoutType(int r100) {
            this.gridViewLayoutType = r100;
        }

        public final void setPadColumnCount(int r100) {
            this.padColumnCount = r100;
        }

        public final void setShowCover(boolean r100) {
            this.showCover = r100;
        }

        public final void setSubtitleFieldId(String r100) {
            this.subtitleFieldId = r100;
        }

        public final void setTitleFieldId(String r100) {
            this.titleFieldId = r100;
        }

        public final void setVisibleFieldIds(ArrayList<String> r100) {
            this.visibleFieldIds = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PanelData() {
    }

    public final String getAction() {
        return this.action;
    }

    public final String getBaseId() {
        return this.baseId;
    }

    public final TopBarButton getButton() {
        return this.button;
    }

    public final String getCurrTab() {
        return this.currTab;
    }

    public final Object getPayload() {
        return this.payload;
    }

    public final String getSrcObjToken() {
        return this.srcObjToken;
    }

    public final Integer getSrcObjType() {
        return this.srcObjType;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final ArrayList<String> getTabs() {
        return this.tabs;
    }

    public final boolean getViewEditable() {
        return this.viewEditable;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final void setAction(String r100) {
        this.action = r100;
    }

    public final void setBaseId(String r100) {
        this.baseId = r100;
    }

    public final void setButton(TopBarButton r100) {
        this.button = r100;
    }

    public final void setCurrTab(String r100) {
        this.currTab = r100;
    }

    public final void setPayload(Object r100) {
        this.payload = r100;
    }

    public final void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public final void setSrcObjType(Integer r100) {
        this.srcObjType = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setTabs(ArrayList<String> r100) {
        this.tabs = r100;
    }

    public final void setViewEditable(boolean r100) {
        this.viewEditable = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }
}
