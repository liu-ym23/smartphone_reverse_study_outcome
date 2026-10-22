package com.bytedance.ee.bear.bitable.fieldedit.model;

import android.text.TextUtils;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.common.widgets.group.GroupMultiItemModel;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0010\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0088\u0001\u001a\u00030\u0087\u0001J\u0011\u0010\u0089\u0001\u001a\f\u0012\u0005\u0012\u00030\u0087\u0001\u0018\u00010\u008a\u0001J\u0007\u0010\u008b\u0001\u001a\u00020_J\u0007\u0010\u008c\u0001\u001a\u00020_R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\u000e\u0010'\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0013\u0010(\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000eR\u001c\u0010*\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010J\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0018\u0010X\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010ZR\u001c\u0010[\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000e\"\u0004\b]\u0010\u0010R\u001a\u0010^\u001a\u00020_X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020_X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010a\"\u0004\bf\u0010cR\u001e\u0010g\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\bh\u0010\u0007\"\u0004\bi\u0010\tR\u001a\u0010j\u001a\u00020_X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010a\"\u0004\bl\u0010cR\u001c\u0010m\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u000e\"\u0004\bo\u0010\u0010R\u001c\u0010p\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u000e\"\u0004\br\u0010\u0010R\u001c\u0010s\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u000e\"\u0004\bu\u0010\u0010R\u001e\u0010v\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\bw\u0010\u0007\"\u0004\bx\u0010\tR\u001c\u0010y\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u000e\"\u0004\b{\u0010\u0010R\u001f\u0010|\u001a\u0004\u0018\u00010_X\u0086\u000e¢\u0006\u0011\n\u0003\u0010\u0080\u0001\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\"\u0010\u0081\u0001\u001a\u0004\u0018\u00010_X\u0086\u000e¢\u0006\u0013\n\u0003\u0010\u0080\u0001\u001a\u0005\b\u0081\u0001\u0010}\"\u0005\b\u0082\u0001\u0010\u007fR\u001f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u000e\"\u0005\b\u0085\u0001\u0010\u0010R\u0012\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0095\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "baseId", "", "getBaseId", "()Ljava/lang/String;", "setBaseId", "(Ljava/lang/String;)V", "tableId", "getTableId", "setTableId", "tableNameMap", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$TableBean;", "getTableNameMap", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$TableBean;", "setTableNameMap", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$TableBean;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$TableBean;", "viewId", "getViewId", "setViewId", "fieldIndex", "getFieldIndex", "()I", "setFieldIndex", "(I)V", "fieldId", "getFieldId", "setFieldId", "fieldType", "fieldUIType", "getFieldUIType", "fieldName", "getFieldName", "setFieldName", "fieldDesc", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$DescriptionBean;", "getFieldDesc", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$DescriptionBean;", "setFieldDesc", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$DescriptionBean;)V", "fieldTips", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$FieldTipsBean;", "getFieldTips", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$FieldTipsBean;", "setFieldTips", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$FieldTipsBean;)V", "fieldProperty", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "getFieldProperty", "()Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "setFieldProperty", "(Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;)V", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "getAllowedEditModes", "()Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "setAllowedEditModes", "(Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;)V", "dependentTables", "getDependentTables", "()[Ljava/lang/String;", "setDependentTables", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "operationItems", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$OperationItem;", "getOperationItems", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$OperationItem;", "setOperationItems", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$OperationItem;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$OperationItem;", "fieldExtendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "getFieldExtendInfo", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "setFieldExtendInfo", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;)V", "configurableFieldTypeList", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$FieldTypeList;", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$FieldTypeList;", "statTypeId", "getStatTypeId", "setStatTypeId", "displayTimeZone", "", "getDisplayTimeZone", "()Z", "setDisplayTimeZone", "(Z)V", "allowEmptyTitle", "getAllowEmptyTitle", "setAllowEmptyTitle", "editNotice", "getEditNotice", "setEditNotice", "canShowAIConfig", "getCanShowAIConfig", "setCanShowAIConfig", "showAIConfigTx", "getShowAIConfigTx", "setShowAIConfigTx", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "getSceneType", "setSceneType", "srcObjToken", "getSrcObjToken", "setSrcObjToken", "srcObjType", "getSrcObjType", "setSrcObjType", "baseLocale", "getBaseLocale", "setBaseLocale", "isPartial", "()Ljava/lang/Boolean;", "setPartial", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isPartialLoadSchemaVersion", "setPartialLoadSchemaVersion", "extensionId", "getExtensionId", "setExtensionId", "fieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "getFieldCompositeType", "getConfigurableFieldTypeList", "", "isEditOptionMode", "disableConvertField", "TableBean", "OperationItem", "DescriptionBean", "FieldTipsBean", "FieldTypeList", "EPanelAction", "EFieldOperationAction", "EEditNotice", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldEditPanelData implements NonProguard {
    private boolean allowEmptyTitle;
    private AllowedEditModes allowedEditModes;
    private String baseId;
    private String baseLocale;
    private boolean canShowAIConfig;
    private final FieldTypeList[] configurableFieldTypeList;
    private String[] dependentTables;
    private boolean displayTimeZone;
    private Integer editNotice;
    private String extensionId;
    private FieldCompositeType fieldCompositeType;
    private DescriptionBean fieldDesc;
    private FieldExtendInfo fieldExtendInfo;
    private String fieldId;
    private int fieldIndex;
    private String fieldName;
    private FieldProperty fieldProperty;
    private FieldTipsBean fieldTips;
    private final int fieldType;
    private final String fieldUIType;
    private Boolean isPartial;
    private Boolean isPartialLoadSchemaVersion;
    private OperationItem[] operationItems;
    private String sceneType;
    private String showAIConfigTx;
    private String srcObjToken;
    private Integer srcObjType;
    private String statTypeId;
    private String tableId;
    private TableBean[] tableNameMap;
    private Integer type;
    private String viewId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$DescriptionBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "content", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/SegmentModel;", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DescriptionBean implements NonProguard {
        private List<? extends SegmentModel> content;

        public DescriptionBean() {
        }

        public final List<SegmentModel> getContent() {
            return this.content;
        }

        public final void setContent(List<? extends SegmentModel> r100) {
            this.content = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$EEditNotice;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EXTEND_FIELD_OWNER_CHANGED_OWNER", "EXTEND_FIELD_OWNER_CHANGED_OTHER", "EXTEND_FIELD_ORIGIN_DELETE_OWNER", "EXTEND_FIELD_ORIGIN_DELETE_OTHER", "EXTEND_FIELD_ORIGIN_MULTIPLE_ENABLE", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EEditNotice extends Enum<EEditNotice> {
        public static final a Companion = null;
        public static final EEditNotice EXTEND_FIELD_ORIGIN_DELETE_OTHER = null;
        public static final EEditNotice EXTEND_FIELD_ORIGIN_DELETE_OWNER = null;
        public static final EEditNotice EXTEND_FIELD_ORIGIN_MULTIPLE_ENABLE = null;
        public static final EEditNotice EXTEND_FIELD_OWNER_CHANGED_OTHER = null;
        public static final EEditNotice EXTEND_FIELD_OWNER_CHANGED_OWNER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EEditNotice[] f211126a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f211127b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static EEditNotice a(Integer r100) {
                EEditNotice[] r101 = EEditNotice.values();
                int r102 = r101.length;
                int r103 = 0;
            L3:
                if (r103 >= r102) goto L11;
                EEditNotice r104 = r101[r103];
                int r105 = r104.getValue();
                if (r100 == null) goto L10;
                if (r105 != r100.intValue()) goto L10;
                return r104;
            L10:
                r103 = r103 + 1;
                goto L3
            L11:
                return null;
            }
        }

        @JvmStatic
        public static final EEditNotice getEditNotice(Integer r100) {
            Companion.getClass();
            return a.a(r100);
        }

        public static EnumEntries<EEditNotice> getEntries() {
            return f211127b;
        }

        static {
            EEditNotice r100 = new EEditNotice("EXTEND_FIELD_OWNER_CHANGED_OWNER", 0, 1);
            EXTEND_FIELD_OWNER_CHANGED_OWNER = r100;
            EEditNotice r101 = new EEditNotice("EXTEND_FIELD_OWNER_CHANGED_OTHER", 1, 2);
            EXTEND_FIELD_OWNER_CHANGED_OTHER = r101;
            EEditNotice r102 = new EEditNotice("EXTEND_FIELD_ORIGIN_DELETE_OWNER", 2, 3);
            EXTEND_FIELD_ORIGIN_DELETE_OWNER = r102;
            EEditNotice r103 = new EEditNotice("EXTEND_FIELD_ORIGIN_DELETE_OTHER", 3, 4);
            EXTEND_FIELD_ORIGIN_DELETE_OTHER = r103;
            EEditNotice r104 = new EEditNotice("EXTEND_FIELD_ORIGIN_MULTIPLE_ENABLE", 4, 5);
            EXTEND_FIELD_ORIGIN_MULTIPLE_ENABLE = r104;
            EEditNotice[] r110 = {r100, r101, r102, r103, r104};
            f211126a = r110;
            f211127b = EnumEntriesKt.enumEntries(r110);
            Companion = new a();
        }

        public static EEditNotice[] values() {
            return (EEditNotice[]) f211126a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static EEditNotice valueOf(String r100) {
            return (EEditNotice) r27.a.a(EEditNotice.class, r100);
        }

        public EEditNotice(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0016\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$EFieldOperationAction;", "", "id", "", "iconResId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getIconResId", "()I", "MODIFY_FIELD", "COPY_FIELD", "INSERT_LEFT_COLUMN", "INSERT_RIGHT_COLUMN", LocalSubStickerItem.BEAUTY_TYPE_FILTER, "POSITIVE_SORT", "REVERSE_SORT", "DELETE_FIELD", "SELECT_COUNT_TYPE", "UNKNOWN", "getReportText", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EFieldOperationAction extends Enum<EFieldOperationAction> {
        public static final EFieldOperationAction COPY_FIELD = null;
        public static final a Companion = null;
        public static final EFieldOperationAction DELETE_FIELD = null;
        public static final EFieldOperationAction FILTER = null;
        public static final EFieldOperationAction INSERT_LEFT_COLUMN = null;
        public static final EFieldOperationAction INSERT_RIGHT_COLUMN = null;
        public static final EFieldOperationAction MODIFY_FIELD = null;
        public static final EFieldOperationAction POSITIVE_SORT = null;
        public static final EFieldOperationAction REVERSE_SORT = null;
        public static final EFieldOperationAction SELECT_COUNT_TYPE = null;
        public static final EFieldOperationAction UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EFieldOperationAction[] f211128a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f211129b = null;
        private final int iconResId;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f211130id;

        public static final class a {
            public a() {
            }
        }

        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f211131a = null;

            static {
                int[] r100 = new int[EFieldOperationAction.values().length];
                r100[EFieldOperationAction.MODIFY_FIELD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
            L27:
                r100[EFieldOperationAction.COPY_FIELD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
            L43:
                r100[EFieldOperationAction.INSERT_LEFT_COLUMN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
            L31:
                r100[EFieldOperationAction.INSERT_RIGHT_COLUMN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
            L35:
                r100[EFieldOperationAction.FILTER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
            L25:
                r100[EFieldOperationAction.POSITIVE_SORT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
            L37:
                r100[EFieldOperationAction.REVERSE_SORT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
            L39:
                r100[EFieldOperationAction.DELETE_FIELD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
            L29:
                r100[EFieldOperationAction.SELECT_COUNT_TYPE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
            L33:
                r100[EFieldOperationAction.UNKNOWN.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
            L13:
                f211131a = r100;
            }
        }

        public static EnumEntries<EFieldOperationAction> getEntries() {
            return f211129b;
        }

        static {
            EFieldOperationAction r100 = new EFieldOperationAction("MODIFY_FIELD", 0, "modifyField", R.drawable.ud_icon_ccm_edit_outlined);
            MODIFY_FIELD = r100;
            EFieldOperationAction r101 = new EFieldOperationAction("COPY_FIELD", 1, "copyField", R.drawable.ud_icon_copy_outlined);
            COPY_FIELD = r101;
            EFieldOperationAction r102 = new EFieldOperationAction("INSERT_LEFT_COLUMN", 2, "insertLeftColumn", R.drawable.ud_icon_insert_left_outlined);
            INSERT_LEFT_COLUMN = r102;
            EFieldOperationAction r103 = new EFieldOperationAction("INSERT_RIGHT_COLUMN", 3, "insertRightColumn", R.drawable.ud_icon_insert_right_outlined);
            INSERT_RIGHT_COLUMN = r103;
            EFieldOperationAction r104 = new EFieldOperationAction(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 4, "filter", R.drawable.ud_icon_filter_outlined);
            FILTER = r104;
            EFieldOperationAction r105 = new EFieldOperationAction("POSITIVE_SORT", 5, "positiveSort", R.drawable.ud_icon_sort_a_to_z_outlined);
            POSITIVE_SORT = r105;
            EFieldOperationAction r110 = new EFieldOperationAction("REVERSE_SORT", 6, "reverseSort", R.drawable.ud_icon_sort_z_to_a_outlined);
            REVERSE_SORT = r110;
            EFieldOperationAction r111 = new EFieldOperationAction("DELETE_FIELD", 7, "deleteField", R.drawable.ud_icon_delete_trash_outlined);
            DELETE_FIELD = r111;
            EFieldOperationAction r112 = new EFieldOperationAction("SELECT_COUNT_TYPE", 8, "selectStatType", R.drawable.ud_icon_functions_outlined);
            SELECT_COUNT_TYPE = r112;
            EFieldOperationAction r106 = new EFieldOperationAction("UNKNOWN", 9, "", 0);
            UNKNOWN = r106;
            EFieldOperationAction[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r106};
            f211128a = r113;
            f211129b = EnumEntriesKt.enumEntries(r113);
            Companion = new a();
        }

        public static EFieldOperationAction[] values() {
            return (EFieldOperationAction[]) f211128a.clone();
        }

        public final String getReportText() {
            switch(b.f211131a[ordinal()]) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                case 10: goto L6;
                default: goto L5;
            };
        L6:
            return "unknown";
        L7:
            return "statistics_change";
        L8:
            return "delete";
        L9:
            return "inverse_order";
        L10:
            return "order";
        L11:
            return "filter";
        L12:
            return "right_field_insert";
        L13:
            return "left_field_insert";
        L14:
            return "field_duplicate";
        L15:
            return "field_modify";
        L5:
            throw new NoWhenBranchMatchedException();
        }

        public final int getIconResId() {
            return this.iconResId;
        }

        public final String getId() {
            return this.f211130id;
        }

        @JvmStatic
        public static final EFieldOperationAction findActionById(String r100) {
            Companion.getClass();
            Intrinsics.checkNotNullParameter(r100, "id");
            EFieldOperationAction[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            EFieldOperationAction r104 = r101[r103];
            if (TextUtils.equals(r100, r104.getId()) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L9:
            return UNKNOWN;
        }

        public static EFieldOperationAction valueOf(String r100) {
            return (EFieldOperationAction) r27.a.a(EFieldOperationAction.class, r100);
        }

        public EFieldOperationAction(String r100, int r101, String r102, int r103) {
            super(r100, r101);
            this.f211130id = r102;
            this.iconResId = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$EPanelAction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EDIT_FIELD", "ADD_FIELD", "CLOSE", "UPDATE", "OPEN_SECONDARY_PANEL", "EDIT_OPTION", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EPanelAction extends Enum<EPanelAction> {
        public static final EPanelAction ADD_FIELD = null;
        public static final EPanelAction CLOSE = null;
        public static final a Companion = null;
        public static final EPanelAction EDIT_FIELD = null;
        public static final EPanelAction EDIT_OPTION = null;
        public static final EPanelAction OPEN_SECONDARY_PANEL = null;
        public static final EPanelAction UPDATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EPanelAction[] f211132a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f211133b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static EPanelAction a(Integer r100) {
                EPanelAction[] r101 = EPanelAction.values();
                int r102 = r101.length;
                int r103 = 0;
            L3:
                if (r103 >= r102) goto L12;
                EPanelAction r104 = r101[r103];
                int r105 = r104.getValue();
                if (r100 == null) goto L10;
                if (r105 != r100.intValue()) goto L10;
                return r104;
            L10:
                r103 = r103 + 1;
                goto L3
            L12:
                return EPanelAction.CLOSE;
            }
        }

        public static EnumEntries<EPanelAction> getEntries() {
            return f211133b;
        }

        @JvmStatic
        public static final EPanelAction getPanelAction(Integer r100) {
            Companion.getClass();
            return a.a(r100);
        }

        static {
            EPanelAction r100 = new EPanelAction("EDIT_FIELD", 0, 1);
            EDIT_FIELD = r100;
            EPanelAction r101 = new EPanelAction("ADD_FIELD", 1, 2);
            ADD_FIELD = r101;
            EPanelAction r102 = new EPanelAction("CLOSE", 2, 3);
            CLOSE = r102;
            EPanelAction r103 = new EPanelAction("UPDATE", 3, 4);
            UPDATE = r103;
            EPanelAction r104 = new EPanelAction("OPEN_SECONDARY_PANEL", 4, 5);
            OPEN_SECONDARY_PANEL = r104;
            EPanelAction r110 = new EPanelAction("EDIT_OPTION", 5, 6);
            EDIT_OPTION = r110;
            EPanelAction[] r111 = {r100, r101, r102, r103, r104, r110};
            f211132a = r111;
            f211133b = EnumEntriesKt.enumEntries(r111);
            Companion = new a();
        }

        public static EPanelAction[] values() {
            return (EPanelAction[]) f211132a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static EPanelAction valueOf(String r100) {
            return (EPanelAction) r27.a.a(EPanelAction.class, r100);
        }

        public EPanelAction(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$FieldTipsBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "iconType", "", "getIconType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "text", "", "getText", "()Ljava/lang/String;", "IconType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FieldTipsBean implements NonProguard {
        private final Integer iconType;
        private final String text;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$FieldTipsBean$IconType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CALCULATING", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum IconType extends Enum<IconType> {
            public static final IconType CALCULATING = null;
            public static final a Companion = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ IconType[] f211134a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f211135b = null;
            private final int value;

            public static final class a {
                public a() {
                }
            }

            public static EnumEntries<IconType> getEntries() {
                return f211135b;
            }

            static {
                IconType r100 = new IconType();
                CALCULATING = r100;
                IconType[] r101 = {r100};
                f211134a = r101;
                f211135b = EnumEntriesKt.enumEntries(r101);
                Companion = new a();
            }

            public IconType() {
                super("CALCULATING", 0);
                this.value = 1;
            }

            public static IconType[] values() {
                return (IconType[]) f211134a.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static IconType valueOf(String r100) {
                return (IconType) r27.a.a(IconType.class, r100);
            }
        }

        public FieldTipsBean() {
        }

        public final Integer getIconType() {
            return this.iconType;
        }

        public final String getText() {
            return this.text;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$FieldTypeList;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fieldType", "", "getFieldType", "()I", "fieldUIType", "", "getFieldUIType", "()Ljava/lang/String;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FieldTypeList implements NonProguard {
        private final int fieldType;
        private final String fieldUIType;

        public FieldTypeList() {
        }

        public final int getFieldType() {
            return this.fieldType;
        }

        public final String getFieldUIType() {
            return this.fieldUIType;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$OperationItem;", "Lcom/bytedance/ee/bear/bitable/common/widgets/group/GroupMultiItemModel;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "disableReason", "", "getDisableReason", "()Ljava/lang/Integer;", "setDisableReason", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "shouldShowWarningIcon", "getShouldShowWarningIcon", "setShouldShowWarningIcon", "DisableReason", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OperationItem extends GroupMultiItemModel {
        private Integer disableReason;
        private boolean enable;
        private boolean shouldShowWarningIcon;
        private String title;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$OperationItem$DisableReason;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNEDITABLE", "UNSUPPORT_CAS", "UNREADABLE", "TABLE_SYNC_DATA", "NO_PERMISSION_COPY", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum DisableReason extends Enum<DisableReason> {
            public static final DisableReason NO_PERMISSION_COPY = null;
            public static final DisableReason TABLE_SYNC_DATA = null;
            public static final DisableReason UNEDITABLE = null;
            public static final DisableReason UNREADABLE = null;
            public static final DisableReason UNSUPPORT_CAS = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ DisableReason[] f211136a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f211137b = null;
            private final int value;

            public static EnumEntries<DisableReason> getEntries() {
                return f211137b;
            }

            static {
                DisableReason r100 = new DisableReason("UNEDITABLE", 0, 0);
                UNEDITABLE = r100;
                DisableReason r101 = new DisableReason("UNSUPPORT_CAS", 1, 1);
                UNSUPPORT_CAS = r101;
                DisableReason r102 = new DisableReason("UNREADABLE", 2, 2);
                UNREADABLE = r102;
                DisableReason r103 = new DisableReason("TABLE_SYNC_DATA", 3, 3);
                TABLE_SYNC_DATA = r103;
                DisableReason r104 = new DisableReason("NO_PERMISSION_COPY", 4, 4);
                NO_PERMISSION_COPY = r104;
                DisableReason[] r105 = {r100, r101, r102, r103, r104};
                f211136a = r105;
                f211137b = EnumEntriesKt.enumEntries(r105);
            }

            public static DisableReason[] values() {
                return (DisableReason[]) f211136a.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static DisableReason valueOf(String r100) {
                return (DisableReason) r27.a.a(DisableReason.class, r100);
            }

            public DisableReason(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public OperationItem() {
            this.enable = true;
            this.disableReason = 0;
        }

        public final Integer getDisableReason() {
            return this.disableReason;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final boolean getShouldShowWarningIcon() {
            return this.shouldShowWarningIcon;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setDisableReason(Integer r100) {
            this.disableReason = r100;
        }

        public final void setEnable(boolean r100) {
            this.enable = r100;
        }

        public final void setShouldShowWarningIcon(boolean r100) {
            this.shouldShowWarningIcon = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldEditPanelData$TableBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "tableName", "", "getTableName", "()Ljava/lang/String;", "setTableName", "(Ljava/lang/String;)V", "tableId", "getTableId", "setTableId", "readPerimission", "", "getReadPerimission", "()Z", "setReadPerimission", "(Z)V", "isPartialDenied", "()Ljava/lang/Boolean;", "setPartialDenied", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isSyncTable", "setSyncTable", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class TableBean implements NonProguard {
        private Boolean isPartialDenied;
        private boolean isSyncTable;
        private boolean readPerimission;
        private String tableId;
        private String tableName;

        public TableBean() {
            this.readPerimission = true;
        }

        public final boolean getReadPerimission() {
            return this.readPerimission;
        }

        public final String getTableId() {
            return this.tableId;
        }

        public final String getTableName() {
            return this.tableName;
        }

        public final Boolean isPartialDenied() {
            return this.isPartialDenied;
        }

        public final boolean isSyncTable() {
            return this.isSyncTable;
        }

        public final void setPartialDenied(Boolean r100) {
            this.isPartialDenied = r100;
        }

        public final void setReadPerimission(boolean r100) {
            this.readPerimission = r100;
        }

        public final void setSyncTable(boolean r100) {
            this.isSyncTable = r100;
        }

        public final void setTableId(String r100) {
            this.tableId = r100;
        }

        public final void setTableName(String r100) {
            this.tableName = r100;
        }
    }

    public FieldEditPanelData() {
    }

    public final boolean disableConvertField() {
        if (Intrinsics.areEqual(this.isPartialLoadSchemaVersion, Boolean.TRUE) == true) goto L5;
        return false;
    L5:
        if (StringsKt.contentEquals(EFieldUIType.SINGLE_LINK.getValue(), this.fieldUIType) == false) goto L7;
        return true;
    L7:
        if (StringsKt.contentEquals(EFieldUIType.DUPLEX_LINK.getValue(), this.fieldUIType) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final List<FieldCompositeType> getConfigurableFieldTypeList() {
        FieldTypeList[] r100 = this.configurableFieldTypeList;
        if (r100 == null) goto L7;
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        FieldTypeList r104 = r100[r103];
        r101.add(new FieldCompositeType(Integer.valueOf(r104.getFieldType()), r104.getFieldUIType()));
        r103 = r103 + 1;
        goto L5
    L10:
        return r101;
    L7:
        return null;
    }

    public final FieldCompositeType getFieldCompositeType() {
        FieldCompositeType r100 = this.fieldCompositeType;
        if (r100 != null) goto L6;
        FieldCompositeType r101 = new FieldCompositeType(Integer.valueOf(this.fieldType), this.fieldUIType);
        this.fieldCompositeType = r101;
        return r101;
    L6:
        return r100;
    }

    public final boolean isEditOptionMode() {
        int r100 = EPanelAction.EDIT_OPTION.getValue();
        Integer r101 = this.type;
        if (r101 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100 != r101.intValue()) goto L8;
        return true;
    }

    public final boolean getAllowEmptyTitle() {
        return this.allowEmptyTitle;
    }

    public final AllowedEditModes getAllowedEditModes() {
        return this.allowedEditModes;
    }

    public final String getBaseId() {
        return this.baseId;
    }

    public final String getBaseLocale() {
        return this.baseLocale;
    }

    public final boolean getCanShowAIConfig() {
        return this.canShowAIConfig;
    }

    public final String[] getDependentTables() {
        return this.dependentTables;
    }

    public final boolean getDisplayTimeZone() {
        return this.displayTimeZone;
    }

    public final Integer getEditNotice() {
        return this.editNotice;
    }

    public final String getExtensionId() {
        return this.extensionId;
    }

    public final DescriptionBean getFieldDesc() {
        return this.fieldDesc;
    }

    public final FieldExtendInfo getFieldExtendInfo() {
        return this.fieldExtendInfo;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final FieldProperty getFieldProperty() {
        return this.fieldProperty;
    }

    public final FieldTipsBean getFieldTips() {
        return this.fieldTips;
    }

    public final String getFieldUIType() {
        return this.fieldUIType;
    }

    public final OperationItem[] getOperationItems() {
        return this.operationItems;
    }

    public final String getSceneType() {
        return this.sceneType;
    }

    public final String getShowAIConfigTx() {
        return this.showAIConfigTx;
    }

    public final String getSrcObjToken() {
        return this.srcObjToken;
    }

    public final Integer getSrcObjType() {
        return this.srcObjType;
    }

    public final String getStatTypeId() {
        return this.statTypeId;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final TableBean[] getTableNameMap() {
        return this.tableNameMap;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final Boolean isPartial() {
        return this.isPartial;
    }

    public final Boolean isPartialLoadSchemaVersion() {
        return this.isPartialLoadSchemaVersion;
    }

    public final void setAllowEmptyTitle(boolean r100) {
        this.allowEmptyTitle = r100;
    }

    public final void setAllowedEditModes(AllowedEditModes r100) {
        this.allowedEditModes = r100;
    }

    public final void setBaseId(String r100) {
        this.baseId = r100;
    }

    public final void setBaseLocale(String r100) {
        this.baseLocale = r100;
    }

    public final void setCanShowAIConfig(boolean r100) {
        this.canShowAIConfig = r100;
    }

    public final void setDependentTables(String[] r100) {
        this.dependentTables = r100;
    }

    public final void setDisplayTimeZone(boolean r100) {
        this.displayTimeZone = r100;
    }

    public final void setEditNotice(Integer r100) {
        this.editNotice = r100;
    }

    public final void setExtensionId(String r100) {
        this.extensionId = r100;
    }

    public final void setFieldDesc(DescriptionBean r100) {
        this.fieldDesc = r100;
    }

    public final void setFieldExtendInfo(FieldExtendInfo r100) {
        this.fieldExtendInfo = r100;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setFieldIndex(int r100) {
        this.fieldIndex = r100;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setFieldProperty(FieldProperty r100) {
        this.fieldProperty = r100;
    }

    public final void setFieldTips(FieldTipsBean r100) {
        this.fieldTips = r100;
    }

    public final void setOperationItems(OperationItem[] r100) {
        this.operationItems = r100;
    }

    public final void setPartial(Boolean r100) {
        this.isPartial = r100;
    }

    public final void setPartialLoadSchemaVersion(Boolean r100) {
        this.isPartialLoadSchemaVersion = r100;
    }

    public final void setSceneType(String r100) {
        this.sceneType = r100;
    }

    public final void setShowAIConfigTx(String r100) {
        this.showAIConfigTx = r100;
    }

    public final void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public final void setSrcObjType(Integer r100) {
        this.srcObjType = r100;
    }

    public final void setStatTypeId(String r100) {
        this.statTypeId = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setTableNameMap(TableBean[] r100) {
        this.tableNameMap = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }
}
