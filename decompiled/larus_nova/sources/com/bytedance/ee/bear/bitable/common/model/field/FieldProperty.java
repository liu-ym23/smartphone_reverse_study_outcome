package com.bytedance.ee.bear.bitable.common.model.field;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableMetaModel;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.AutoNumberRuleField;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.ButtonFieldProperty;
import com.bytedance.ee.bear.bitable.card.view.cell.formgrid.TableQuestionConfig;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeWatch;
import com.bytedance.ee.bear.bitable.filter.model.FilterInfo;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import com.bytedance.ee.util.io.NonProguard;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010¹\u0001\u001a\u00020\u00052\n\u0010º\u0001\u001a\u0005\u0018\u00010»\u0001H\u0096\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010$\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.X\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b<\u0010\u0007\"\u0004\b=\u0010\tR\u001e\u0010>\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b?\u0010\u0007\"\u0004\b@\u0010\tR\u001c\u0010A\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000e\"\u0004\bC\u0010\u0010R\u001c\u0010D\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000e\"\u0004\bF\u0010\u0010R\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010.X\u0086\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010S\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010.X\u0086\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\bT\u0010O\"\u0004\bU\u0010QR\u001c\u0010V\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000e\"\u0004\bX\u0010\u0010R\u001c\u0010Y\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u000e\"\u0004\b[\u0010\u0010R\u001c\u0010\\\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u000e\"\u0004\b^\u0010\u0010R:\u0010_\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020a\u0018\u00010`j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020a\u0018\u0001`bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001c\u0010g\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u000e\"\u0004\bi\u0010\u0010R\u001c\u0010j\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u000e\"\u0004\bl\u0010\u0010R\u001c\u0010m\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u000e\"\u0004\bo\u0010\u0010R\u001e\u0010p\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\bq\u0010\u0007\"\u0004\br\u0010\tR\u001e\u0010s\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\bt\u0010\u0007\"\u0004\bu\u0010\tR\u001e\u0010v\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\bw\u0010\u0007\"\u0004\bx\u0010\tR\u001e\u0010y\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\bz\u0010\u0007\"\u0004\b{\u0010\tR\u001e\u0010|\u001a\u0004\u0018\u00010}X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R+\u0010\u0082\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010.X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R%\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\n\u001a\u0005\b\u0089\u0001\u0010\u0007\"\u0005\b\u008a\u0001\u0010\tR%\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\n\u001a\u0005\b\u008c\u0001\u0010\u0007\"\u0005\b\u008d\u0001\u0010\tR!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0012\n\u0002\u0010\n\u001a\u0005\b\u008f\u0001\u0010\u0007\"\u0005\b\u0090\u0001\u0010\tR\u001f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u000e\"\u0005\b\u0093\u0001\u0010\u0010R\u001f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u000e\"\u0005\b\u0096\u0001\u0010\u0010R!\u0010\u0097\u0001\u001a\u0004\u0018\u00010aX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\"\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R!\u0010¢\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0012\n\u0002\u0010\n\u001a\u0005\b¢\u0001\u0010\u0007\"\u0005\b£\u0001\u0010\tR\"\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R!\u0010ª\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0012\n\u0002\u0010\n\u001a\u0005\b«\u0001\u0010\u0007\"\u0005\b¬\u0001\u0010\tR\u001f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u000e\"\u0005\b¯\u0001\u0010\u0010R\u001f\u0010°\u0001\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010\u000e\"\u0005\b²\u0001\u0010\u0010R\"\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001¨\u0006¼\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", BdpAppEventConstant.MULTIPLE, "", "getMultiple", "()Ljava/lang/Boolean;", "setMultiple", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "formatter", "", "getFormatter", "()Ljava/lang/String;", "setFormatter", "(Ljava/lang/String;)V", "currencyCode", "getCurrencyCode", "setCurrencyCode", "progress", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressBean;", "getProgress", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressBean;", "setProgress", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressBean;)V", "rangeCustomize", "getRangeCustomize", "setRangeCustomize", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", "getMin", "()Ljava/lang/Double;", "setMin", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "getMax", "setMax", "optionsType", "", "getOptionsType", "()I", "setOptionsType", "(I)V", "options", "", "Lcom/bytedance/ee/bear/bitable/common/model/field/RichOptionItem;", "getOptions", "()[Lcom/bytedance/ee/bear/bitable/common/model/field/RichOptionItem;", "setOptions", "([Lcom/bytedance/ee/bear/bitable/common/model/field/RichOptionItem;)V", "[Lcom/bytedance/ee/bear/bitable/common/model/field/RichOptionItem;", "optionsRule", "Lcom/bytedance/ee/bear/bitable/common/model/field/OptionsRule;", "getOptionsRule", "()Lcom/bytedance/ee/bear/bitable/common/model/field/OptionsRule;", "setOptionsRule", "(Lcom/bytedance/ee/bear/bitable/common/model/field/OptionsRule;)V", "optionCanDelete", "getOptionCanDelete", "setOptionCanDelete", "autoFill", "getAutoFill", "setAutoFill", "dateFormat", "getDateFormat", "setDateFormat", "timeFormat", "getTimeFormat", "setTimeFormat", "watch", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/ModifiedTimeWatch;", "getWatch", "()Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/ModifiedTimeWatch;", "setWatch", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/ModifiedTimeWatch;)V", "capture", "getCapture", "()[Ljava/lang/String;", "setCapture", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "acceptFileTypes", "getAcceptFileTypes", "setAcceptFileTypes", "baseId", "getBaseId", "setBaseId", "tableId", "getTableId", "setTableId", "viewId", "getViewId", "setViewId", SlcCommonAction.KEY_PARAMS, "Ljava/util/HashMap;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/TableMetaModel$FieldBean;", "Lkotlin/collections/HashMap;", "getFields", "()Ljava/util/HashMap;", "setFields", "(Ljava/util/HashMap;)V", "primaryFieldId", "getPrimaryFieldId", "setPrimaryFieldId", "backFieldId", "getBackFieldId", "setBackFieldId", "backFieldName", "getBackFieldName", "setBackFieldName", "tableVisible", "getTableVisible", "setTableVisible", "tableAddable", "getTableAddable", "setTableAddable", "linkFilterFieldDeny", "getLinkFilterFieldDeny", "setLinkFilterFieldDeny", "linkTableIsDelete", "getLinkTableIsDelete", "setLinkTableIsDelete", "filterInfo", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterInfo;", "getFilterInfo", "()Lcom/bytedance/ee/bear/bitable/filter/model/FilterInfo;", "setFilterInfo", "(Lcom/bytedance/ee/bear/bitable/filter/model/FilterInfo;)V", "ruleFieldOptions", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/AutoNumberRuleField;", "getRuleFieldOptions", "()[Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/AutoNumberRuleField;", "setRuleFieldOptions", "([Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/AutoNumberRuleField;)V", "[Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/AutoNumberRuleField;", "isAdvancedRules", "setAdvancedRules", "reformatExistingRecord", "getReformatExistingRecord", "setReformatExistingRecord", "displayTimeZone", "getDisplayTimeZone", "setDisplayTimeZone", RemoteMessageConst.INPUT_TYPE, "getInputType", "setInputType", ITTReaderViewWrapper.SELECTION_KEY_FORMULA, "getFormula", "setFormula", "proxyFieldMeta", "getProxyFieldMeta", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/TableMetaModel$FieldBean;", "setProxyFieldMeta", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/TableMetaModel$FieldBean;)V", "button", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/ButtonFieldProperty;", "getButton", "()Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/ButtonFieldProperty;", "setButton", "(Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/ButtonFieldProperty;)V", "isTriggerEnabled", "setTriggerEnabled", "rating", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberSymbol;", "getRating", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberSymbol;", "setRating", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberSymbol;)V", "enumerable", "getEnumerable", "setEnumerable", "rangeLimitMode", "getRangeLimitMode", "setRangeLimitMode", "convertMode", "getConvertMode", "setConvertMode", "tableQuestionConfig", "Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/TableQuestionConfig;", "getTableQuestionConfig", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/TableQuestionConfig;", "setTableQuestionConfig", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/TableQuestionConfig;)V", "equals", "other", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldProperty implements NonProguard {
    private String[] acceptFileTypes;
    private Boolean autoFill;
    private String backFieldId;
    private String backFieldName;
    private String baseId;
    private ButtonFieldProperty button;
    private String[] capture;
    private String convertMode;
    private String currencyCode;
    private String dateFormat;
    private Boolean displayTimeZone;
    private Boolean enumerable;
    private HashMap<String, TableMetaModel.FieldBean> fields;
    private FilterInfo filterInfo;
    private String formatter;
    private String formula;
    private String inputType;

    @JSONField(name = "isAdvancedRules")
    private Boolean isAdvancedRules;
    private Boolean isTriggerEnabled;
    private Boolean linkFilterFieldDeny;
    private Boolean linkTableIsDelete;
    private Double max;
    private Double min;
    private Boolean multiple;
    private Boolean optionCanDelete;
    private RichOptionItem[] options;
    private OptionsRule optionsRule;
    private int optionsType;
    private String primaryFieldId;
    private FieldConfigMetaModel.ProgressBean progress;
    private TableMetaModel.FieldBean proxyFieldMeta;
    private Boolean rangeCustomize;
    private String rangeLimitMode;
    private FieldConfigMetaModel.NumberSymbol rating;

    @JSONField(name = "reformatExistingRecord")
    private Boolean reformatExistingRecord;
    private AutoNumberRuleField[] ruleFieldOptions;
    private Boolean tableAddable;
    private String tableId;
    private TableQuestionConfig tableQuestionConfig;
    private Boolean tableVisible;
    private String timeFormat;
    private String viewId;
    private ModifiedTimeWatch watch;

    public FieldProperty() {
        this.optionsType = OptionsType.STATIC.getValue();
        Boolean r100 = Boolean.FALSE;
        this.autoFill = r100;
        this.displayTimeZone = r100;
    }

    public final String[] getAcceptFileTypes() {
        return this.acceptFileTypes;
    }

    public final Boolean getAutoFill() {
        return this.autoFill;
    }

    public final String getBackFieldId() {
        return this.backFieldId;
    }

    public final String getBackFieldName() {
        return this.backFieldName;
    }

    public final String getBaseId() {
        return this.baseId;
    }

    public final ButtonFieldProperty getButton() {
        return this.button;
    }

    public final String[] getCapture() {
        return this.capture;
    }

    public final String getConvertMode() {
        return this.convertMode;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getDateFormat() {
        return this.dateFormat;
    }

    public final Boolean getDisplayTimeZone() {
        return this.displayTimeZone;
    }

    public final Boolean getEnumerable() {
        return this.enumerable;
    }

    public final HashMap<String, TableMetaModel.FieldBean> getFields() {
        return this.fields;
    }

    public final FilterInfo getFilterInfo() {
        return this.filterInfo;
    }

    public final String getFormatter() {
        return this.formatter;
    }

    public final String getFormula() {
        return this.formula;
    }

    public final String getInputType() {
        return this.inputType;
    }

    public final Boolean getLinkFilterFieldDeny() {
        return this.linkFilterFieldDeny;
    }

    public final Boolean getLinkTableIsDelete() {
        return this.linkTableIsDelete;
    }

    public final Double getMax() {
        return this.max;
    }

    public final Double getMin() {
        return this.min;
    }

    public final Boolean getMultiple() {
        return this.multiple;
    }

    public final Boolean getOptionCanDelete() {
        return this.optionCanDelete;
    }

    public final RichOptionItem[] getOptions() {
        return this.options;
    }

    public final OptionsRule getOptionsRule() {
        return this.optionsRule;
    }

    public final int getOptionsType() {
        return this.optionsType;
    }

    public final String getPrimaryFieldId() {
        return this.primaryFieldId;
    }

    public final FieldConfigMetaModel.ProgressBean getProgress() {
        return this.progress;
    }

    public final TableMetaModel.FieldBean getProxyFieldMeta() {
        return this.proxyFieldMeta;
    }

    public final Boolean getRangeCustomize() {
        return this.rangeCustomize;
    }

    public final String getRangeLimitMode() {
        return this.rangeLimitMode;
    }

    public final FieldConfigMetaModel.NumberSymbol getRating() {
        return this.rating;
    }

    public final Boolean getReformatExistingRecord() {
        return this.reformatExistingRecord;
    }

    public final AutoNumberRuleField[] getRuleFieldOptions() {
        return this.ruleFieldOptions;
    }

    public final Boolean getTableAddable() {
        return this.tableAddable;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final TableQuestionConfig getTableQuestionConfig() {
        return this.tableQuestionConfig;
    }

    public final Boolean getTableVisible() {
        return this.tableVisible;
    }

    public final String getTimeFormat() {
        return this.timeFormat;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final ModifiedTimeWatch getWatch() {
        return this.watch;
    }

    public final Boolean isAdvancedRules() {
        return this.isAdvancedRules;
    }

    public final Boolean isTriggerEnabled() {
        return this.isTriggerEnabled;
    }

    public boolean equals(Object r100) {
        if (r100 == null) goto L5;
        Class<?> r101 = r100.getClass();
    L7:
        if (Intrinsics.areEqual(FieldProperty.class, r101) == true) goto L9;
        return false;
    L9:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.common.model.field.FieldProperty");
        FieldProperty r102 = (FieldProperty) r100;
        if (Intrinsics.areEqual(this.multiple, r102.multiple) == true) goto L13;
        return false;
    L13:
        if (TextUtils.equals(this.formatter, r102.formatter) == true) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.options, r102.options) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.autoFill, r102.autoFill) == true) goto L22;
        return false;
    L22:
        if (TextUtils.equals(this.dateFormat, r102.dateFormat) == true) goto L25;
        return false;
    L25:
        if (TextUtils.equals(this.timeFormat, r102.timeFormat) == true) goto L27;
        return false;
    L27:
        String[] r103 = this.capture;
        if (r103 == null) goto L30;
        int r104 = r103.length;
    L31:
        String[] r105 = r102.capture;
        if (r105 == null) goto L34;
        int r106 = r105.length;
    L35:
        if (r104 == r106) goto L38;
        return false;
    L38:
        if (Arrays.equals(this.acceptFileTypes, r102.acceptFileTypes) == true) goto L41;
        return false;
    L41:
        if (TextUtils.equals(this.tableId, r102.tableId) == true) goto L44;
        return false;
    L44:
        if (Arrays.equals(this.ruleFieldOptions, r102.ruleFieldOptions) == true) goto L47;
        return false;
    L47:
        if (Intrinsics.areEqual(this.isAdvancedRules, r102.isAdvancedRules) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.reformatExistingRecord, r102.reformatExistingRecord) == true) goto L53;
        return false;
    L53:
        if (Intrinsics.areEqual(this.optionsRule, r102.optionsRule) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.filterInfo, r102.filterInfo) == true) goto L59;
        return false;
    L59:
        if (Intrinsics.areEqual(this.rangeCustomize, r102.rangeCustomize) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.min, r102.min) == true) goto L65;
        return false;
    L65:
        if (Intrinsics.areEqual(this.max, r102.max) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.progress, r102.progress) == true) goto L71;
        return false;
    L71:
        if (Intrinsics.areEqual(this.button, r102.button) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.isTriggerEnabled, r102.isTriggerEnabled) == true) goto L77;
        return false;
    L77:
        if (Intrinsics.areEqual(this.rating, r102.rating) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.enumerable, r102.enumerable) == true) goto L83;
        return false;
    L83:
        if (TextUtils.equals(this.rangeLimitMode, r102.rangeLimitMode) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.watch, r102.watch) == true) goto L88;
        return false;
    L88:
        return true;
    L34:
        r106 = 0;
        goto L35
    L30:
        r104 = 0;
        goto L31
    L5:
        r101 = null;
        goto L7
    }

    public final void setAcceptFileTypes(String[] r100) {
        this.acceptFileTypes = r100;
    }

    public final void setAdvancedRules(Boolean r100) {
        this.isAdvancedRules = r100;
    }

    public final void setAutoFill(Boolean r100) {
        this.autoFill = r100;
    }

    public final void setBackFieldId(String r100) {
        this.backFieldId = r100;
    }

    public final void setBackFieldName(String r100) {
        this.backFieldName = r100;
    }

    public final void setBaseId(String r100) {
        this.baseId = r100;
    }

    public final void setButton(ButtonFieldProperty r100) {
        this.button = r100;
    }

    public final void setCapture(String[] r100) {
        this.capture = r100;
    }

    public final void setConvertMode(String r100) {
        this.convertMode = r100;
    }

    public final void setCurrencyCode(String r100) {
        this.currencyCode = r100;
    }

    public final void setDateFormat(String r100) {
        this.dateFormat = r100;
    }

    public final void setDisplayTimeZone(Boolean r100) {
        this.displayTimeZone = r100;
    }

    public final void setEnumerable(Boolean r100) {
        this.enumerable = r100;
    }

    public final void setFields(HashMap<String, TableMetaModel.FieldBean> r100) {
        this.fields = r100;
    }

    public final void setFilterInfo(FilterInfo r100) {
        this.filterInfo = r100;
    }

    public final void setFormatter(String r100) {
        this.formatter = r100;
    }

    public final void setFormula(String r100) {
        this.formula = r100;
    }

    public final void setInputType(String r100) {
        this.inputType = r100;
    }

    public final void setLinkFilterFieldDeny(Boolean r100) {
        this.linkFilterFieldDeny = r100;
    }

    public final void setLinkTableIsDelete(Boolean r100) {
        this.linkTableIsDelete = r100;
    }

    public final void setMax(Double r100) {
        this.max = r100;
    }

    public final void setMin(Double r100) {
        this.min = r100;
    }

    public final void setMultiple(Boolean r100) {
        this.multiple = r100;
    }

    public final void setOptionCanDelete(Boolean r100) {
        this.optionCanDelete = r100;
    }

    public final void setOptions(RichOptionItem[] r100) {
        this.options = r100;
    }

    public final void setOptionsRule(OptionsRule r100) {
        this.optionsRule = r100;
    }

    public final void setOptionsType(int r100) {
        this.optionsType = r100;
    }

    public final void setPrimaryFieldId(String r100) {
        this.primaryFieldId = r100;
    }

    public final void setProgress(FieldConfigMetaModel.ProgressBean r100) {
        this.progress = r100;
    }

    public final void setProxyFieldMeta(TableMetaModel.FieldBean r100) {
        this.proxyFieldMeta = r100;
    }

    public final void setRangeCustomize(Boolean r100) {
        this.rangeCustomize = r100;
    }

    public final void setRangeLimitMode(String r100) {
        this.rangeLimitMode = r100;
    }

    public final void setRating(FieldConfigMetaModel.NumberSymbol r100) {
        this.rating = r100;
    }

    public final void setReformatExistingRecord(Boolean r100) {
        this.reformatExistingRecord = r100;
    }

    public final void setRuleFieldOptions(AutoNumberRuleField[] r100) {
        this.ruleFieldOptions = r100;
    }

    public final void setTableAddable(Boolean r100) {
        this.tableAddable = r100;
    }

    public final void setTableId(String r100) {
        this.tableId = r100;
    }

    public final void setTableQuestionConfig(TableQuestionConfig r100) {
        this.tableQuestionConfig = r100;
    }

    public final void setTableVisible(Boolean r100) {
        this.tableVisible = r100;
    }

    public final void setTimeFormat(String r100) {
        this.timeFormat = r100;
    }

    public final void setTriggerEnabled(Boolean r100) {
        this.isTriggerEnabled = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }

    public final void setWatch(ModifiedTimeWatch r100) {
        this.watch = r100;
    }
}
