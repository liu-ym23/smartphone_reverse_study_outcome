package com.bytedance.ee.bear.bitable.fieldedit.model;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.AutoNumberRuleField;
import com.bytedance.ee.bear.bitable.celleditor.editor.location.LocationEditorModel;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.util.io.NonProguard;
import com.facebook.keyframes.model.KFAnimation;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.miniapp.alarm.AccountType;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001:\u00179:;<=>?@ABCDEFGHIJKLMNOB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R$\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006P"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fieldItems", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "getFieldItems", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "setFieldItems", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "commonDateTimeList", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$DateTimeFormatBean;", "getCommonDateTimeList", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$DateTimeFormatBean;", "setCommonDateTimeList", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$DateTimeFormatBean;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$DateTimeFormatBean;", "commonNumberFormatList", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberFormatBean;", "getCommonNumberFormatList", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberFormatBean;", "setCommonNumberFormatList", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberFormatBean;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberFormatBean;", "commonAutoNumberRuleTypeList", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberTypeOption;", "getCommonAutoNumberRuleTypeList", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberTypeOption;", "setCommonAutoNumberRuleTypeList", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberTypeOption;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberTypeOption;", "commonCurrencyCodeList", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CurrencyCodeBean;", "getCommonCurrencyCodeList", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CurrencyCodeBean;", "setCommonCurrencyCodeList", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CurrencyCodeBean;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CurrencyCodeBean;", "commonCurrencyDecimalList", "getCommonCurrencyDecimalList", "setCommonCurrencyDecimalList", "commonColorList", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "getCommonColorList", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "setCommonColorList", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "commonRatingSymbolList", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;", "getCommonRatingSymbolList", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;", "setCommonRatingSymbolList", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;", "FieldConfigItem", "Property", "LocationTypeBean", "DateTimeFormatBean", "NumberFormatBean", "ProgressBean", "CommonColor", "ProgressFormatConfig", "ProgressColorConfig", "CommonRange", "RangeConfig", "FormatTypeConfig", "AutoNumberTypeOption", "AutoNumberRuleOption", "CurrencyCodeBean", "RatingSymboInfo", "RatingSymbolConfig", "NumberSymbol", "EFormatterType", "ProgressColorType", "NumberFormatType", "RangeLimitMode", "RichColor", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldConfigMetaModel implements NonProguard {
    private AutoNumberTypeOption[] commonAutoNumberRuleTypeList;
    private CommonColor[] commonColorList;
    private CurrencyCodeBean[] commonCurrencyCodeList;
    private NumberFormatBean[] commonCurrencyDecimalList;
    private DateTimeFormatBean[] commonDateTimeList;
    private NumberFormatBean[] commonNumberFormatList;
    private RatingSymboInfo[] commonRatingSymbolList;
    private FieldConfigItem[] fieldItems;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001c\u001a\u00020\u0000H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberRuleOption;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/AutoNumberRuleField;", "", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "fixed", "", "getFixed", "()Z", "setFixed", "(Z)V", "optionList", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberRuleOption$TimeFormatBean;", "getOptionList", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberRuleOption$TimeFormatBean;", "setOptionList", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberRuleOption$TimeFormatBean;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberRuleOption$TimeFormatBean;", "clone", "TimeFormatBean", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AutoNumberRuleOption extends AutoNumberRuleField implements Cloneable {
        private String description;

        @JSONField(serialize = false)
        private boolean fixed;

        @JSONField(serialize = false)
        private TimeFormatBean[] optionList;
        private String title;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberRuleOption$TimeFormatBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", SubInfo.KEY_FORMAT, "", "getFormat", "()Ljava/lang/String;", "setFormat", "(Ljava/lang/String;)V", "text", "getText", "setText", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class TimeFormatBean implements NonProguard {
            private String format;
            private String text;

            public TimeFormatBean() {
            }

            public final String getFormat() {
                return this.format;
            }

            public final String getText() {
                return this.text;
            }

            public final void setFormat(String r100) {
                this.format = r100;
            }

            public final void setText(String r100) {
                this.text = r100;
            }
        }

        public AutoNumberRuleOption clone() {
            Object r100 = super.clone();
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel.AutoNumberRuleOption");
            return (AutoNumberRuleOption) r100;
        }

        public AutoNumberRuleOption() {
        }

        public final String getDescription() {
            return this.description;
        }

        public final boolean getFixed() {
            return this.fixed;
        }

        public final TimeFormatBean[] getOptionList() {
            return this.optionList;
        }

        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8312clone() {
            return clone();
        }

        public final void setDescription(String r100) {
            this.description = r100;
        }

        public final void setFixed(boolean r100) {
            this.fixed = r100;
        }

        public final void setOptionList(TimeFormatBean[] r100) {
            this.optionList = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberTypeOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isAdvancedRules", "", "()Z", "setAdvancedRules", "(Z)V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "ruleFieldOptions", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberRuleOption;", "getRuleFieldOptions", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberRuleOption;", "setRuleFieldOptions", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberRuleOption;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$AutoNumberRuleOption;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AutoNumberTypeOption implements NonProguard {
        private String description;
        private boolean isAdvancedRules;
        private AutoNumberRuleOption[] ruleFieldOptions;
        private String title;

        public AutoNumberTypeOption() {
        }

        public final String getDescription() {
            return this.description;
        }

        public final AutoNumberRuleOption[] getRuleFieldOptions() {
            return this.ruleFieldOptions;
        }

        public final String getTitle() {
            return this.title;
        }

        public final boolean isAdvancedRules() {
            return this.isAdvancedRules;
        }

        public final void setAdvancedRules(boolean r100) {
            this.isAdvancedRules = r100;
        }

        public final void setDescription(String r100) {
            this.description = r100;
        }

        public final void setRuleFieldOptions(AutoNumberRuleOption[] r100) {
            this.ruleFieldOptions = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "type", "getType", "setType", "color", "", "getColor", "()[Ljava/lang/String;", "setColor", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CommonColor implements NonProguard {
        private String[] color;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f211122id;
        private String name;
        private String type;

        public CommonColor() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f211122id, this.name, this.type, this.color});
        }

        public final String[] getColor() {
            return this.color;
        }

        public final String getId() {
            return this.f211122id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getType() {
            return this.type;
        }

        public boolean equals(Object r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (TextUtils.equals(this.f211122id, ((CommonColor) r100).f211122id) == true) goto L8;
            return false;
        L8:
            return true;
        }

        public final void setColor(String[] r100) {
            this.color = r100;
        }

        public final void setId(String r100) {
            this.f211122id = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public final void setType(String r100) {
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonRange;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "rangeCustomize", "", "getRangeCustomize", "()Ljava/lang/Boolean;", "setRangeCustomize", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", "getMin", "()Ljava/lang/Double;", "setMin", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "getMax", "setMax", "minRangeMin", "getMinRangeMin", "setMinRangeMin", "minRangeMax", "getMinRangeMax", "setMinRangeMax", "maxRangeMin", "getMaxRangeMin", "setMaxRangeMin", "maxRangeMax", "getMaxRangeMax", "setMaxRangeMax", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CommonRange implements NonProguard {
        private Double max;
        private Double maxRangeMax;
        private Double maxRangeMin;
        private Double min;
        private Double minRangeMax;
        private Double minRangeMin;
        private Boolean rangeCustomize;

        public CommonRange() {
        }

        public final Double getMax() {
            return this.max;
        }

        public final Double getMaxRangeMax() {
            return this.maxRangeMax;
        }

        public final Double getMaxRangeMin() {
            return this.maxRangeMin;
        }

        public final Double getMin() {
            return this.min;
        }

        public final Double getMinRangeMax() {
            return this.minRangeMax;
        }

        public final Double getMinRangeMin() {
            return this.minRangeMin;
        }

        public final Boolean getRangeCustomize() {
            return this.rangeCustomize;
        }

        public final void setMax(Double r100) {
            this.max = r100;
        }

        public final void setMaxRangeMax(Double r100) {
            this.maxRangeMax = r100;
        }

        public final void setMaxRangeMin(Double r100) {
            this.maxRangeMin = r100;
        }

        public final void setMin(Double r100) {
            this.min = r100;
        }

        public final void setMinRangeMax(Double r100) {
            this.minRangeMax = r100;
        }

        public final void setMinRangeMin(Double r100) {
            this.minRangeMin = r100;
        }

        public final void setRangeCustomize(Boolean r100) {
            this.rangeCustomize = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CurrencyCodeBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "currencyCode", "", "getCurrencyCode", "()Ljava/lang/String;", "setCurrencyCode", "(Ljava/lang/String;)V", "currencySymbol", "getCurrencySymbol", "setCurrencySymbol", "name", "getName", "setName", "formatCode", "getFormatCode", "setFormatCode", "getDisplaySymbol", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CurrencyCodeBean implements NonProguard {
        private String currencyCode;
        private String currencySymbol;
        private String formatCode;
        private String name;

        public CurrencyCodeBean() {
        }

        public final String getDisplaySymbol() {
            return this.currencyCode + " - " + this.currencySymbol;
        }

        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        public final String getCurrencySymbol() {
            return this.currencySymbol;
        }

        public final String getFormatCode() {
            return this.formatCode;
        }

        public final String getName() {
            return this.name;
        }

        public final void setCurrencyCode(String r100) {
            this.currencyCode = r100;
        }

        public final void setCurrencySymbol(String r100) {
            this.currencySymbol = r100;
        }

        public final void setFormatCode(String r100) {
            this.formatCode = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$DateTimeFormatBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "dateFormat", "", "getDateFormat", "()Ljava/lang/String;", "setDateFormat", "(Ljava/lang/String;)V", "timeFormat", "getTimeFormat", "setTimeFormat", "text", "getText", "setText", "displayTimeZone", "", "getDisplayTimeZone", "()Z", "setDisplayTimeZone", "(Z)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DateTimeFormatBean implements NonProguard {
        private String dateFormat;
        private boolean displayTimeZone;
        private String text;
        private String timeFormat;

        public DateTimeFormatBean() {
        }

        public final String getDateFormat() {
            return this.dateFormat;
        }

        public final boolean getDisplayTimeZone() {
            return this.displayTimeZone;
        }

        public final String getText() {
            return this.text;
        }

        public final String getTimeFormat() {
            return this.timeFormat;
        }

        public final void setDateFormat(String r100) {
            this.dateFormat = r100;
        }

        public final void setDisplayTimeZone(boolean r100) {
            this.displayTimeZone = r100;
        }

        public final void setText(String r100) {
            this.text = r100;
        }

        public final void setTimeFormat(String r100) {
            this.timeFormat = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$EFormatterType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "GENERAL", "NUMBER", "DATETIME", CardAdapter.TEXT, "PERCENTAGE", "CURRENCY", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EFormatterType extends Enum<EFormatterType> {
        public static final EFormatterType CURRENCY = null;
        public static final EFormatterType DATETIME = null;
        public static final EFormatterType GENERAL = null;
        public static final EFormatterType NUMBER = null;
        public static final EFormatterType PERCENTAGE = null;
        public static final EFormatterType TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EFormatterType[] f211123a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f211124b = null;
        private final int value;

        public static EnumEntries<EFormatterType> getEntries() {
            return f211124b;
        }

        static {
            EFormatterType r100 = new EFormatterType("GENERAL", 0, 0);
            GENERAL = r100;
            EFormatterType r101 = new EFormatterType("NUMBER", 1, 1);
            NUMBER = r101;
            EFormatterType r102 = new EFormatterType("DATETIME", 2, 2);
            DATETIME = r102;
            EFormatterType r103 = new EFormatterType(CardAdapter.TEXT, 3, 3);
            TEXT = r103;
            EFormatterType r104 = new EFormatterType("PERCENTAGE", 4, 4);
            PERCENTAGE = r104;
            EFormatterType r105 = new EFormatterType("CURRENCY", 5, 5);
            CURRENCY = r105;
            EFormatterType[] r110 = {r100, r101, r102, r103, r104, r105};
            f211123a = r110;
            f211124b = EnumEntriesKt.enumEntries(r110);
        }

        public static EFormatterType[] values() {
            return (EFormatterType[]) f211123a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static EFormatterType valueOf(String r100) {
            return (EFormatterType) r27.a.a(EFormatterType.class, r100);
        }

        public EFormatterType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "fieldUIType", "", "title", "getTitle", "()Ljava/lang/String;", "groupName", "getGroupName", "enable", "", "getEnable", "()Z", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$Property;", "getProperty", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$Property;", "allowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "getAllowedEditModes", "()Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "fieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "getFieldCompositeType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FieldConfigItem implements NonProguard {
        private final AllowedEditModes allowedEditModes;
        private final boolean enable;
        private FieldCompositeType fieldCompositeType;
        private final String fieldUIType;
        private final String groupName;
        private final Property property;
        private final String title;
        private final int type;

        public FieldConfigItem() {
        }

        public final FieldCompositeType getFieldCompositeType() {
            FieldCompositeType r100 = this.fieldCompositeType;
            if (r100 != null) goto L6;
            FieldCompositeType r101 = new FieldCompositeType(Integer.valueOf(this.type), this.fieldUIType);
            this.fieldCompositeType = r101;
            return r101;
        L6:
            return r100;
        }

        public final AllowedEditModes getAllowedEditModes() {
            return this.allowedEditModes;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final String getGroupName() {
            return this.groupName;
        }

        public final Property getProperty() {
            return this.property;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FormatTypeConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "defaultDecimalDigits", "getDefaultDecimalDigits", "setDefaultDecimalDigits", "decimalDigits", "", "getDecimalDigits", "()[Ljava/lang/Integer;", "setDecimalDigits", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FormatTypeConfig implements NonProguard {
        private Integer[] decimalDigits;
        private Integer defaultDecimalDigits;
        private Integer type;

        public FormatTypeConfig() {
        }

        public final Integer[] getDecimalDigits() {
            return this.decimalDigits;
        }

        public final Integer getDefaultDecimalDigits() {
            return this.defaultDecimalDigits;
        }

        public final Integer getType() {
            return this.type;
        }

        public final void setDecimalDigits(Integer[] r100) {
            this.decimalDigits = r100;
        }

        public final void setDefaultDecimalDigits(Integer r100) {
            this.defaultDecimalDigits = r100;
        }

        public final void setType(Integer r100) {
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$LocationTypeBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", RemoteMessageConst.INPUT_TYPE, "", "getInputType", "()Ljava/lang/String;", "setInputType", "(Ljava/lang/String;)V", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocationTypeBean implements NonProguard {
        public static final a Companion = null;
        private static final LocationTypeBean NOT_LIMIT = null;
        private static final LocationTypeBean ONLY_MOBILE = null;
        private String inputType;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
            LocationTypeBean r100 = new LocationTypeBean();
            r100.inputType = LocationEditorModel.NOT_LIMIT;
            NOT_LIMIT = r100;
            LocationTypeBean r101 = new LocationTypeBean();
            r101.inputType = LocationEditorModel.ONLY_MOBILE;
            ONLY_MOBILE = r101;
        }

        public LocationTypeBean() {
            this.inputType = LocationEditorModel.NOT_LIMIT;
        }

        public static final /* synthetic */ LocationTypeBean access$getNOT_LIMIT$cp() {
            return NOT_LIMIT;
        }

        public static final /* synthetic */ LocationTypeBean access$getONLY_MOBILE$cp() {
            return ONLY_MOBILE;
        }

        public final String getInputType() {
            return this.inputType;
        }

        public final void setInputType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.inputType = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberFormatBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "formatCode", "", "getFormatCode", "()Ljava/lang/String;", "setFormatCode", "(Ljava/lang/String;)V", "name", "getName", "setName", "sample", "getSample", "setSample", "formatterName", "getFormatterName", "setFormatterName", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NumberFormatBean implements NonProguard {
        private String formatCode;
        private String formatterName;
        private String name;
        private String sample;
        private Integer type;

        public NumberFormatBean() {
        }

        public final String getFormatCode() {
            return this.formatCode;
        }

        public final String getFormatterName() {
            return this.formatterName;
        }

        public final String getName() {
            return this.name;
        }

        public final String getSample() {
            return this.sample;
        }

        public final Integer getType() {
            return this.type;
        }

        public final void setFormatCode(String r100) {
            this.formatCode = r100;
        }

        public final void setFormatterName(String r100) {
            this.formatterName = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public final void setSample(String r100) {
            this.sample = r100;
        }

        public final void setType(Integer r100) {
            this.type = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberFormatType;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PERCENT", "NUMBER", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum NumberFormatType extends Enum<NumberFormatType> implements NonProguard {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ NumberFormatType[] $VALUES = null;
        public static final NumberFormatType NUMBER = null;
        public static final NumberFormatType PERCENT = null;
        private final int value;

        private static final /* synthetic */ NumberFormatType[] $values() {
            return new NumberFormatType[]{PERCENT, NUMBER};
        }

        public static EnumEntries<NumberFormatType> getEntries() {
            return $ENTRIES;
        }

        static {
            PERCENT = new NumberFormatType("PERCENT", 0, 4);
            NUMBER = new NumberFormatType("NUMBER", 1, 1);
            NumberFormatType[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static NumberFormatType[] values() {
            return (NumberFormatType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static NumberFormatType valueOf(String r100) {
            return (NumberFormatType) r27.a.a(NumberFormatType.class, r100);
        }

        private NumberFormatType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$NumberSymbol;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "symbol", "", "getSymbol", "()Ljava/lang/String;", "setSymbol", "(Ljava/lang/String;)V", "color", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RichColor;", "getColor", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RichColor;", "setColor", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RichColor;)V", "allowHalf", "", "getAllowHalf", "()Ljava/lang/Boolean;", "setAllowHalf", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "equals", "other", "", "hashCode", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NumberSymbol implements NonProguard {
        private Boolean allowHalf;
        private RichColor color;
        private String symbol;

        public NumberSymbol() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.symbol, this.color, this.allowHalf});
        }

        public final Boolean getAllowHalf() {
            return this.allowHalf;
        }

        public final RichColor getColor() {
            return this.color;
        }

        public final String getSymbol() {
            return this.symbol;
        }

        public boolean equals(Object r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            NumberSymbol r101 = (NumberSymbol) r100;
            if (TextUtils.equals(r101.symbol, this.symbol) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.allowHalf, r101.allowHalf) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final void setAllowHalf(Boolean r100) {
            this.allowHalf = r100;
        }

        public final void setColor(RichColor r100) {
            this.color = r100;
        }

        public final void setSymbol(String r100) {
            this.symbol = r100;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "color", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "getColor", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;", "setColor", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonColor;)V", "equals", "", "other", "", "hashCode", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProgressBean implements NonProguard {
        private CommonColor color;

        public ProgressBean() {
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.color});
        }

        public final CommonColor getColor() {
            return this.color;
        }

        public boolean equals(Object r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            CommonColor r101 = ((ProgressBean) r100).color;
            CommonColor r102 = this.color;
            if (r102 == null) goto L8;
            if (r101 != null) goto L8;
        L10:
            return false;
        L8:
            if (r102 != null) goto L11;
            if (r101 != null) goto L10;
        L11:
            if (r102 == null) goto L16;
            if (r101 != null) goto L14;
            return true;
        L14:
            if (Intrinsics.areEqual(r102, r101) == true) goto L19;
            return false;
        L19:
            return true;
        L16:
            return true;
        }

        public final void setColor(CommonColor r100) {
            this.color = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressColorConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "supportColorIds", "", "", "getSupportColorIds", "()[Ljava/lang/String;", "setSupportColorIds", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "defaultColorId", "getDefaultColorId", "()Ljava/lang/String;", "setDefaultColorId", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProgressColorConfig implements NonProguard {
        private String defaultColorId;
        private String[] supportColorIds;

        public ProgressColorConfig() {
        }

        public final String getDefaultColorId() {
            return this.defaultColorId;
        }

        public final String[] getSupportColorIds() {
            return this.supportColorIds;
        }

        public final void setDefaultColorId(String r100) {
            this.defaultColorId = r100;
        }

        public final void setSupportColorIds(String[] r100) {
            this.supportColorIds = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressColorType;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "<init>", "(Ljava/lang/String;I)V", "MULTI", "DEFAULT", "GRADIENT", "PURE", "UNKNOWN", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ProgressColorType extends Enum<ProgressColorType> implements NonProguard {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ProgressColorType[] $VALUES = null;
        public static final ProgressColorType DEFAULT = null;
        public static final ProgressColorType GRADIENT = null;
        public static final ProgressColorType MULTI = null;
        public static final ProgressColorType PURE = null;
        public static final ProgressColorType UNKNOWN = null;

        private static final /* synthetic */ ProgressColorType[] $values() {
            return new ProgressColorType[]{MULTI, DEFAULT, GRADIENT, PURE, UNKNOWN};
        }

        public static EnumEntries<ProgressColorType> getEntries() {
            return $ENTRIES;
        }

        static {
            MULTI = new ProgressColorType("MULTI", 0);
            DEFAULT = new ProgressColorType("DEFAULT", 1);
            GRADIENT = new ProgressColorType("GRADIENT", 2);
            PURE = new ProgressColorType("PURE", 3);
            UNKNOWN = new ProgressColorType("UNKNOWN", 4);
            ProgressColorType[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static ProgressColorType[] values() {
            return (ProgressColorType[]) $VALUES.clone();
        }

        public static ProgressColorType valueOf(String r100) {
            return (ProgressColorType) r27.a.a(ProgressColorType.class, r100);
        }

        private ProgressColorType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressFormatConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "types", "", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FormatTypeConfig;", "getTypes", "()[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FormatTypeConfig;", "setTypes", "([Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FormatTypeConfig;)V", "[Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FormatTypeConfig;", "defaultType", "", "getDefaultType", "()Ljava/lang/Integer;", "setDefaultType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProgressFormatConfig implements NonProguard {
        private Integer defaultType;
        private FormatTypeConfig[] types;

        public ProgressFormatConfig() {
        }

        public final Integer getDefaultType() {
            return this.defaultType;
        }

        public final FormatTypeConfig[] getTypes() {
            return this.types;
        }

        public final void setDefaultType(Integer r100) {
            this.defaultType = r100;
        }

        public final void setTypes(FormatTypeConfig[] r100) {
            this.types = r100;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "isAutoFill", "", "()Z", "setAutoFill", "(Z)V", "defaultDateTimeFormatIndex", "", "getDefaultDateTimeFormatIndex", "()Ljava/lang/Integer;", "setDefaultDateTimeFormatIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "defaultNumberFormatIndex", "getDefaultNumberFormatIndex", "setDefaultNumberFormatIndex", "defaultAutoNumberRuleTypeIndex", "getDefaultAutoNumberRuleTypeIndex", "setDefaultAutoNumberRuleTypeIndex", "defaultCurrencyCodeIndex", "getDefaultCurrencyCodeIndex", "setDefaultCurrencyCodeIndex", "defaultCurrencyDecimalIndex", "getDefaultCurrencyDecimalIndex", "setDefaultCurrencyDecimalIndex", "colorConfig", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressColorConfig;", "getColorConfig", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressColorConfig;", "setColorConfig", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressColorConfig;)V", "formatConfig", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressFormatConfig;", "getFormatConfig", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressFormatConfig;", "setFormatConfig", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$ProgressFormatConfig;)V", "rangeConfig", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RangeConfig;", "getRangeConfig", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RangeConfig;", "setRangeConfig", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RangeConfig;)V", "ratingSymbolConfig", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymbolConfig;", "getRatingSymbolConfig", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymbolConfig;", "setRatingSymbolConfig", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymbolConfig;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Property implements NonProguard {
        private ProgressColorConfig colorConfig;
        private Integer defaultAutoNumberRuleTypeIndex;
        private Integer defaultCurrencyCodeIndex;
        private Integer defaultCurrencyDecimalIndex;
        private Integer defaultDateTimeFormatIndex;
        private Integer defaultNumberFormatIndex;
        private ProgressFormatConfig formatConfig;
        private boolean isAutoFill;
        private RangeConfig rangeConfig;
        private RatingSymbolConfig ratingSymbolConfig;

        public Property() {
        }

        public final ProgressColorConfig getColorConfig() {
            return this.colorConfig;
        }

        public final Integer getDefaultAutoNumberRuleTypeIndex() {
            return this.defaultAutoNumberRuleTypeIndex;
        }

        public final Integer getDefaultCurrencyCodeIndex() {
            return this.defaultCurrencyCodeIndex;
        }

        public final Integer getDefaultCurrencyDecimalIndex() {
            return this.defaultCurrencyDecimalIndex;
        }

        public final Integer getDefaultDateTimeFormatIndex() {
            return this.defaultDateTimeFormatIndex;
        }

        public final Integer getDefaultNumberFormatIndex() {
            return this.defaultNumberFormatIndex;
        }

        public final ProgressFormatConfig getFormatConfig() {
            return this.formatConfig;
        }

        public final RangeConfig getRangeConfig() {
            return this.rangeConfig;
        }

        public final RatingSymbolConfig getRatingSymbolConfig() {
            return this.ratingSymbolConfig;
        }

        public final boolean isAutoFill() {
            return this.isAutoFill;
        }

        public final void setAutoFill(boolean r100) {
            this.isAutoFill = r100;
        }

        public final void setColorConfig(ProgressColorConfig r100) {
            this.colorConfig = r100;
        }

        public final void setDefaultAutoNumberRuleTypeIndex(Integer r100) {
            this.defaultAutoNumberRuleTypeIndex = r100;
        }

        public final void setDefaultCurrencyCodeIndex(Integer r100) {
            this.defaultCurrencyCodeIndex = r100;
        }

        public final void setDefaultCurrencyDecimalIndex(Integer r100) {
            this.defaultCurrencyDecimalIndex = r100;
        }

        public final void setDefaultDateTimeFormatIndex(Integer r100) {
            this.defaultDateTimeFormatIndex = r100;
        }

        public final void setDefaultNumberFormatIndex(Integer r100) {
            this.defaultNumberFormatIndex = r100;
        }

        public final void setFormatConfig(ProgressFormatConfig r100) {
            this.formatConfig = r100;
        }

        public final void setRangeConfig(RangeConfig r100) {
            this.rangeConfig = r100;
        }

        public final void setRatingSymbolConfig(RatingSymbolConfig r100) {
            this.ratingSymbolConfig = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RangeConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "defaultRange", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonRange;", "getDefaultRange", "()Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonRange;", "setDefaultRange", "(Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$CommonRange;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RangeConfig implements NonProguard {
        private CommonRange defaultRange;

        public RangeConfig() {
        }

        public final CommonRange getDefaultRange() {
            return this.defaultRange;
        }

        public final void setDefaultRange(CommonRange r100) {
            this.defaultRange = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RangeLimitMode;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", AccountType.ALL, UserProfileEvent.POSITION_NONE, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RangeLimitMode extends Enum<RangeLimitMode> implements NonProguard {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ RangeLimitMode[] $VALUES = null;
        public static final RangeLimitMode ALL = null;
        public static final RangeLimitMode NONE = null;
        private final String value;

        private static final /* synthetic */ RangeLimitMode[] $values() {
            return new RangeLimitMode[]{ALL, NONE};
        }

        public static EnumEntries<RangeLimitMode> getEntries() {
            return $ENTRIES;
        }

        static {
            ALL = new RangeLimitMode(AccountType.ALL, 0, "all");
            NONE = new RangeLimitMode(UserProfileEvent.POSITION_NONE, 1, "none");
            RangeLimitMode[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static RangeLimitMode[] values() {
            return (RangeLimitMode[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static RangeLimitMode valueOf(String r100) {
            return (RangeLimitMode) r27.a.a(RangeLimitMode.class, r100);
        }

        private RangeLimitMode(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymboInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "symbol", "", "getSymbol", "()Ljava/lang/String;", "setSymbol", "(Ljava/lang/String;)V", "name", "getName", "setName", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RatingSymboInfo implements NonProguard {
        private String name;
        private String symbol;

        public RatingSymboInfo() {
        }

        public final String getName() {
            return this.name;
        }

        public final String getSymbol() {
            return this.symbol;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public final void setSymbol(String r100) {
            this.symbol = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RatingSymbolConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "supportRatingSymbols", "", "", "getSupportRatingSymbols", "()[Ljava/lang/String;", "setSupportRatingSymbols", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "defaultRatingSymbol", "getDefaultRatingSymbol", "()Ljava/lang/String;", "setDefaultRatingSymbol", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RatingSymbolConfig implements NonProguard {
        private String defaultRatingSymbol;
        private String[] supportRatingSymbols;

        public RatingSymbolConfig() {
        }

        public final String getDefaultRatingSymbol() {
            return this.defaultRatingSymbol;
        }

        public final String[] getSupportRatingSymbols() {
            return this.supportRatingSymbols;
        }

        public final void setDefaultRatingSymbol(String r100) {
            this.defaultRatingSymbol = r100;
        }

        public final void setSupportRatingSymbols(String[] r100) {
            this.supportRatingSymbols = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$RichColor;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "type", "getType", "setType", "color", "", "", "getColor", "()[Ljava/lang/Object;", "setColor", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RichColor implements NonProguard {
        private Object[] color;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f211125id;
        private String name;
        private String type;

        public RichColor() {
        }

        public final Object[] getColor() {
            return this.color;
        }

        public final String getId() {
            return this.f211125id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getType() {
            return this.type;
        }

        public final void setColor(Object[] r100) {
            this.color = r100;
        }

        public final void setId(String r100) {
            this.f211125id = r100;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public final void setType(String r100) {
            this.type = r100;
        }
    }

    public FieldConfigMetaModel() {
    }

    public final AutoNumberTypeOption[] getCommonAutoNumberRuleTypeList() {
        return this.commonAutoNumberRuleTypeList;
    }

    public final CommonColor[] getCommonColorList() {
        return this.commonColorList;
    }

    public final CurrencyCodeBean[] getCommonCurrencyCodeList() {
        return this.commonCurrencyCodeList;
    }

    public final NumberFormatBean[] getCommonCurrencyDecimalList() {
        return this.commonCurrencyDecimalList;
    }

    public final DateTimeFormatBean[] getCommonDateTimeList() {
        return this.commonDateTimeList;
    }

    public final NumberFormatBean[] getCommonNumberFormatList() {
        return this.commonNumberFormatList;
    }

    public final RatingSymboInfo[] getCommonRatingSymbolList() {
        return this.commonRatingSymbolList;
    }

    public final FieldConfigItem[] getFieldItems() {
        return this.fieldItems;
    }

    public final void setCommonAutoNumberRuleTypeList(AutoNumberTypeOption[] r100) {
        this.commonAutoNumberRuleTypeList = r100;
    }

    public final void setCommonColorList(CommonColor[] r100) {
        this.commonColorList = r100;
    }

    public final void setCommonCurrencyCodeList(CurrencyCodeBean[] r100) {
        this.commonCurrencyCodeList = r100;
    }

    public final void setCommonCurrencyDecimalList(NumberFormatBean[] r100) {
        this.commonCurrencyDecimalList = r100;
    }

    public final void setCommonDateTimeList(DateTimeFormatBean[] r100) {
        this.commonDateTimeList = r100;
    }

    public final void setCommonNumberFormatList(NumberFormatBean[] r100) {
        this.commonNumberFormatList = r100;
    }

    public final void setCommonRatingSymbolList(RatingSymboInfo[] r100) {
        this.commonRatingSymbolList = r100;
    }

    public final void setFieldItems(FieldConfigItem[] r100) {
        this.fieldItems = r100;
    }
}
