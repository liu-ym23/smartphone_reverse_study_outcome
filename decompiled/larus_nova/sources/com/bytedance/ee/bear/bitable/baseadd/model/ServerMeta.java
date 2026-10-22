package com.bytedance.ee.bear.bitable.baseadd.model;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableMetaModel;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.ee.util.io.NonProguard;
import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001:\u0006TUVWXYB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001c\u0010\"\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001c\u0010%\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R:\u0010.\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000200\u0018\u00010/j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000200\u0018\u0001`1X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R\u001e\u00109\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010?\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR:\u0010H\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020I\u0018\u00010/j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020I\u0018\u0001`1X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00103\"\u0004\bK\u00105R\u0019\u0010L\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010M8F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0019\u0010P\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010M8F¢\u0006\u0006\u001a\u0004\bQ\u0010O¨\u0006Z"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isFromCache", "", "()Z", "setFromCache", "(Z)V", "baseToken", "", "getBaseToken", "()Ljava/lang/String;", "setBaseToken", "(Ljava/lang/String;)V", "baseName", "getBaseName", "setBaseName", "schemaVersion", "", "getSchemaVersion", "()Ljava/lang/Integer;", "setSchemaVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", TimeZoneItemV2.TIME_ZONE, "getTimeZone", "setTimeZone", "subType", "getSubType", "setSubType", "tableID", "getTableID", "setTableID", "tableName", "getTableName", "setTableName", "primaryKey", "getPrimaryKey", "setPrimaryKey", "view", "Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$ServerView;", "getView", "()Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$ServerView;", "setView", "(Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$ServerView;)V", "fieldMap", "Ljava/util/HashMap;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/TableMetaModel$FieldBean;", "Lkotlin/collections/HashMap;", "getFieldMap", "()Ljava/util/HashMap;", "setFieldMap", "(Ljava/util/HashMap;)V", "exType", "getExType", "setExType", "manageable", "getManageable", "()Ljava/lang/Boolean;", "setManageable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "copyable", "getCopyable", "setCopyable", "recordPerm", "Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginRecordPerm;", "getRecordPerm", "()Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginRecordPerm;", "setRecordPerm", "(Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginRecordPerm;)V", "cellPerm", "Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginCellPerm;", "getCellPerm", "setCellPerm", "orderedFieldList", "", "getOrderedFieldList", "()Ljava/util/List;", "fieldIds", "getFieldIds", "isFieldSubmittable", "fieldID", "ServerView", "BTOriginViewProperty", "BTOriginColInfo", "BTOriginHierarchyConfig", "BTOriginRecordPerm", "BTOriginCellPerm", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ServerMeta implements NonProguard {
    private String baseName;
    private String baseToken;
    private HashMap<String, BTOriginCellPerm> cellPerm;
    private Boolean copyable;
    private Integer exType;
    private HashMap<String, TableMetaModel.FieldBean> fieldMap;
    private boolean isFromCache;
    private Boolean manageable;
    private String primaryKey;
    private BTOriginRecordPerm recordPerm;
    private Integer schemaVersion;
    private Integer subType;
    private String tableID;
    private String tableName;
    private String timeZone;
    private ServerView view;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginCellPerm;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "submittable", "", "getSubmittable", "()Ljava/lang/Boolean;", "setSubmittable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BTOriginCellPerm implements NonProguard {
        private Boolean submittable;

        public BTOriginCellPerm() {
        }

        public final Boolean getSubmittable() {
            return this.submittable;
        }

        public final void setSubmittable(Boolean r100) {
            this.submittable = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginColInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "width", "", "getWidth", "()Ljava/lang/Float;", "setWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "hidden", "", "getHidden", "()Ljava/lang/Boolean;", "setHidden", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BTOriginColInfo implements NonProguard {
        private Boolean hidden;
        private Float width;

        public BTOriginColInfo() {
        }

        public final Boolean getHidden() {
            return this.hidden;
        }

        public final Float getWidth() {
            return this.width;
        }

        public final void setHidden(Boolean r100) {
            this.hidden = r100;
        }

        public final void setWidth(Float r100) {
            this.width = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginHierarchyConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fieldId", "", "getFieldId", "()Ljava/lang/String;", "setFieldId", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BTOriginHierarchyConfig implements NonProguard {
        private String fieldId;

        public BTOriginHierarchyConfig() {
        }

        public final String getFieldId() {
            return this.fieldId;
        }

        public final void setFieldId(String r100) {
            this.fieldId = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginRecordPerm;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "addable", "", "getAddable", "()Ljava/lang/Boolean;", "setAddable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BTOriginRecordPerm implements NonProguard {
        private Boolean addable;

        public BTOriginRecordPerm() {
        }

        public final Boolean getAddable() {
            return this.addable;
        }

        public final void setAddable(Boolean r100) {
            this.addable = r100;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR:\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R:\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginViewProperty;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", SlcCommonAction.KEY_PARAMS, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFields", "()Ljava/util/ArrayList;", "setFields", "(Ljava/util/ArrayList;)V", "colInfos", "Ljava/util/HashMap;", "Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginColInfo;", "Lkotlin/collections/HashMap;", "getColInfos", "()Ljava/util/HashMap;", "setColInfos", "(Ljava/util/HashMap;)V", "sectionInfos", "getSectionInfos", "setSectionInfos", "rowHeightLevel", "", "getRowHeightLevel", "()Ljava/lang/Integer;", "setRowHeightLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "frozenColCount", "getFrozenColCount", "setFrozenColCount", "hierarchyConfig", "Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginHierarchyConfig;", "getHierarchyConfig", "()Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginHierarchyConfig;", "setHierarchyConfig", "(Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginHierarchyConfig;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BTOriginViewProperty implements NonProguard {
        private HashMap<String, BTOriginColInfo> colInfos;
        private ArrayList<String> fields;
        private Integer frozenColCount;
        private BTOriginHierarchyConfig hierarchyConfig;
        private Integer rowHeightLevel;
        private HashMap<String, BTOriginColInfo> sectionInfos;

        public BTOriginViewProperty() {
        }

        public final HashMap<String, BTOriginColInfo> getColInfos() {
            return this.colInfos;
        }

        public final ArrayList<String> getFields() {
            return this.fields;
        }

        public final Integer getFrozenColCount() {
            return this.frozenColCount;
        }

        public final BTOriginHierarchyConfig getHierarchyConfig() {
            return this.hierarchyConfig;
        }

        public final Integer getRowHeightLevel() {
            return this.rowHeightLevel;
        }

        public final HashMap<String, BTOriginColInfo> getSectionInfos() {
            return this.sectionInfos;
        }

        public final void setColInfos(HashMap<String, BTOriginColInfo> r100) {
            this.colInfos = r100;
        }

        public final void setFields(ArrayList<String> r100) {
            this.fields = r100;
        }

        public final void setFrozenColCount(Integer r100) {
            this.frozenColCount = r100;
        }

        public final void setHierarchyConfig(BTOriginHierarchyConfig r100) {
            this.hierarchyConfig = r100;
        }

        public final void setRowHeightLevel(Integer r100) {
            this.rowHeightLevel = r100;
        }

        public final void setSectionInfos(HashMap<String, BTOriginColInfo> r100) {
            this.sectionInfos = r100;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$ServerView;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "isPrivate", "", "()Ljava/lang/Boolean;", "setPrivate", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "owner", "getOwner", "setOwner", "publicLevel", "getPublicLevel", "setPublicLevel", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginViewProperty;", "getProperty", "()Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginViewProperty;", "setProperty", "(Lcom/bytedance/ee/bear/bitable/baseadd/model/ServerMeta$BTOriginViewProperty;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ServerView implements NonProguard {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f206982id;
        private Boolean isPrivate;
        private String name;
        private String owner;
        private BTOriginViewProperty property;
        private Integer publicLevel;
        private Integer type;

        public ServerView() {
        }

        public final String getId() {
            return this.f206982id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getOwner() {
            return this.owner;
        }

        public final BTOriginViewProperty getProperty() {
            return this.property;
        }

        public final Integer getPublicLevel() {
            return this.publicLevel;
        }

        public final Integer getType() {
            return this.type;
        }

        public final Boolean isPrivate() {
            return this.isPrivate;
        }

        public final void setId(String r100) {
            this.f206982id = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public final void setOwner(String r100) {
            this.owner = r100;
        }

        public final void setPrivate(Boolean r100) {
            this.isPrivate = r100;
        }

        public final void setProperty(BTOriginViewProperty r100) {
            this.property = r100;
        }

        public final void setPublicLevel(Integer r100) {
            this.publicLevel = r100;
        }

        public final void setType(Integer r100) {
            this.type = r100;
        }
    }

    public ServerMeta() {
    }

    public final List<String> getFieldIds() {
        ServerView r100 = this.view;
        if (r100 == null) goto L7;
        BTOriginViewProperty r101 = r100.getProperty();
        if (r101 == null) goto L7;
        return r101.getFields();
    L7:
        return null;
    }

    public final List<TableMetaModel.FieldBean> getOrderedFieldList() {
        ServerView r100 = this.view;
        if (r100 == null) goto L26;
        BTOriginViewProperty r101 = r100.getProperty();
        if (r101 == null) goto L27;
        ArrayList<String> r102 = r101.getFields();
        if (r102 == null) goto L28;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L20;
        String r105 = (String) r104.next();
        HashMap<String, TableMetaModel.FieldBean> r106 = this.fieldMap;
        if (r106 == null) goto L16;
        TableMetaModel.FieldBean r107 = r106.get(r105);
        if (r107 == null) goto L16;
        r107.f207100id = r105;
    L17:
        if (r107 == null) goto L10;
        r103.add(r107);
    L16:
        r107 = null;
        goto L17
    L20:
        return r103;
    L28:
        return null;
    L27:
        return null;
    L26:
        return null;
    }

    public final String getBaseName() {
        return this.baseName;
    }

    public final String getBaseToken() {
        return this.baseToken;
    }

    public final HashMap<String, BTOriginCellPerm> getCellPerm() {
        return this.cellPerm;
    }

    public final Boolean getCopyable() {
        return this.copyable;
    }

    public final Integer getExType() {
        return this.exType;
    }

    public final HashMap<String, TableMetaModel.FieldBean> getFieldMap() {
        return this.fieldMap;
    }

    public final Boolean getManageable() {
        return this.manageable;
    }

    public final String getPrimaryKey() {
        return this.primaryKey;
    }

    public final BTOriginRecordPerm getRecordPerm() {
        return this.recordPerm;
    }

    public final Integer getSchemaVersion() {
        return this.schemaVersion;
    }

    public final Integer getSubType() {
        return this.subType;
    }

    public final String getTableID() {
        return this.tableID;
    }

    public final String getTableName() {
        return this.tableName;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final ServerView getView() {
        return this.view;
    }

    public final boolean isFromCache() {
        return this.isFromCache;
    }

    public final boolean isFieldSubmittable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fieldID");
        HashMap<String, BTOriginCellPerm> r101 = this.cellPerm;
        if (r101 == null) goto L9;
        BTOriginCellPerm r102 = r101.get(r100);
        if (r102 == null) goto L9;
        Boolean r103 = r102.getSubmittable();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return false;
    }

    public final void setBaseName(String r100) {
        this.baseName = r100;
    }

    public final void setBaseToken(String r100) {
        this.baseToken = r100;
    }

    public final void setCellPerm(HashMap<String, BTOriginCellPerm> r100) {
        this.cellPerm = r100;
    }

    public final void setCopyable(Boolean r100) {
        this.copyable = r100;
    }

    public final void setExType(Integer r100) {
        this.exType = r100;
    }

    public final void setFieldMap(HashMap<String, TableMetaModel.FieldBean> r100) {
        this.fieldMap = r100;
    }

    public final void setFromCache(boolean r100) {
        this.isFromCache = r100;
    }

    public final void setManageable(Boolean r100) {
        this.manageable = r100;
    }

    public final void setPrimaryKey(String r100) {
        this.primaryKey = r100;
    }

    public final void setRecordPerm(BTOriginRecordPerm r100) {
        this.recordPerm = r100;
    }

    public final void setSchemaVersion(Integer r100) {
        this.schemaVersion = r100;
    }

    public final void setSubType(Integer r100) {
        this.subType = r100;
    }

    public final void setTableID(String r100) {
        this.tableID = r100;
    }

    public final void setTableName(String r100) {
        this.tableName = r100;
    }

    public final void setTimeZone(String r100) {
        this.timeZone = r100;
    }

    public final void setView(ServerView r100) {
        this.view = r100;
    }
}
