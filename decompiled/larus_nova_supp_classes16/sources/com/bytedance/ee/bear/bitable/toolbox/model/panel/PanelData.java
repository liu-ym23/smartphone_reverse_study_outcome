package com.bytedance.ee.bear.bitable.toolbox.model.panel;

import com.bytedance.ee.bear.bitable.cardview.GridViewLayoutType;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.io.NonProguardWithoutSerializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u00049:;<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR.\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010-j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006="}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", JSEventListener.ACTION, "", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "baseId", "getBaseId", "setBaseId", "tableId", "getTableId", "setTableId", "viewId", "getViewId", "setViewId", "viewEditable", "", "getViewEditable", "()Z", "setViewEditable", "(Z)V", "payload", "", "getPayload", "()Ljava/lang/Object;", "setPayload", "(Ljava/lang/Object;)V", "srcObjToken", "getSrcObjToken", "setSrcObjToken", "srcObjType", "", "getSrcObjType", "()Ljava/lang/Integer;", "setSrcObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "currTab", "getCurrTab", "setCurrTab", "tabs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTabs", "()Ljava/util/ArrayList;", "setTabs", "(Ljava/util/ArrayList;)V", "button", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButton;", "getButton", "()Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButton;", "setButton", "(Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButton;)V", "Companion", "ViewSettingParams", "TopBarButton", "TopBarButtonStatus", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public TopBarButton(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "text");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "btnAction");
            this.text = r2;
            this.state = r3;
            this.btnAction = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButtonStatus;", "", "status", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "STATUS_SHOW", "STATUS_LOADING", "STATUS_FINISH", "STATUS_HIDE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TopBarButtonStatus extends Enum<TopBarButtonStatus> {
        public static final TopBarButtonStatus STATUS_FINISH = null;
        public static final TopBarButtonStatus STATUS_HIDE = null;
        public static final TopBarButtonStatus STATUS_LOADING = null;
        public static final TopBarButtonStatus STATUS_SHOW = null;
        public static final /* synthetic */ TopBarButtonStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String status;

        public static EnumEntries<TopBarButtonStatus> getEntries() {
            return b;
        }

        static {
            TopBarButtonStatus r0 = new TopBarButtonStatus("STATUS_SHOW", 0, "show");
            STATUS_SHOW = r0;
            TopBarButtonStatus r1 = new TopBarButtonStatus("STATUS_LOADING", 1, "loading");
            STATUS_LOADING = r1;
            TopBarButtonStatus r2 = new TopBarButtonStatus("STATUS_FINISH", 2, "finish");
            STATUS_FINISH = r2;
            TopBarButtonStatus r4 = new TopBarButtonStatus("STATUS_HIDE", 3, "hide");
            STATUS_HIDE = r4;
            TopBarButtonStatus[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static TopBarButtonStatus[] values() {
            return (TopBarButtonStatus[]) a.clone();
        }

        public final String getStatus() {
            return this.status;
        }

        public static TopBarButtonStatus valueOf(String r1) {
            return (TopBarButtonStatus) r27.a.a(TopBarButtonStatus.class, r1);
        }

        public TopBarButtonStatus(String r1, int r2, String r3) {
            super(r1, r2);
            this.status = r3;
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

        public final void setColumnCount(int r1) {
            this.columnCount = r1;
        }

        public final void setCoverFieldId(String r1) {
            this.coverFieldId = r1;
        }

        public final void setGridViewLayoutType(int r1) {
            this.gridViewLayoutType = r1;
        }

        public final void setPadColumnCount(int r1) {
            this.padColumnCount = r1;
        }

        public final void setShowCover(boolean r1) {
            this.showCover = r1;
        }

        public final void setSubtitleFieldId(String r1) {
            this.subtitleFieldId = r1;
        }

        public final void setTitleFieldId(String r1) {
            this.titleFieldId = r1;
        }

        public final void setVisibleFieldIds(ArrayList<String> r1) {
            this.visibleFieldIds = r1;
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

    public final void setAction(String r1) {
        this.action = r1;
    }

    public final void setBaseId(String r1) {
        this.baseId = r1;
    }

    public final void setButton(TopBarButton r1) {
        this.button = r1;
    }

    public final void setCurrTab(String r1) {
        this.currTab = r1;
    }

    public final void setPayload(Object r1) {
        this.payload = r1;
    }

    public final void setSrcObjToken(String r1) {
        this.srcObjToken = r1;
    }

    public final void setSrcObjType(Integer r1) {
        this.srcObjType = r1;
    }

    public final void setTableId(String r1) {
        this.tableId = r1;
    }

    public final void setTabs(ArrayList<String> r1) {
        this.tabs = r1;
    }

    public final void setViewEditable(boolean r1) {
        this.viewEditable = r1;
    }

    public final void setViewId(String r1) {
        this.viewId = r1;
    }
}
