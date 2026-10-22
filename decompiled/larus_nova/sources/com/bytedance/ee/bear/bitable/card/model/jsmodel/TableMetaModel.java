package com.bytedance.ee.bear.bitable.card.model.jsmodel;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.enums.ECardType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.util.io.NonProguard;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class TableMetaModel implements NonProguard {
    public String baseLocale;
    public ECardType bizType;
    public LinkedList<ButtonColorBean> buttonColors;
    public String cardCloseReason;
    public String cardCoverId;
    public List<ColorsMap> colors;
    public boolean coverChangeAble;
    public DescriptionBean currentViewDescription;
    public String currentViewName;
    public boolean displayTimeZone;
    public Map<String, FieldBean> fields;
    public boolean isFormulaServiceSuspend;
    public boolean isPartial;
    public boolean isPro;
    public String primaryFieldId;
    public boolean recordAddable;
    public boolean shouldDiscloseHiddenFields;
    public String stackViewId;
    public boolean submitTopTipShowed;
    public String tableName;
    public String timeZone;
    public long timestamp;
    public String transactionId;
    public String viewType;
    public boolean viewUnreadableRequiredField;

    public static class ColorsMap implements NonProguard {
        public String borderColor;
        public String color;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f207099id;
        public String textColor;

        public ColorsMap() {
        }
    }

    public static class DescriptionBean implements NonProguard {
        public List<SegmentModel> content;

        public DescriptionBean() {
        }
    }

    public static class FieldBean implements NonProguard {
        public AllowedEditModes allowedEditModes;
        public DescriptionBean description;
        public FieldBeanExtendInfo extendInfo;
        public Object fieldDefaultValueRule;
        public EFieldUIType fieldUIType;
        public String fieldWarning;
        public boolean hidden;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f207100id;
        public boolean isSync;
        public String name;
        public FieldProperty property;
        public boolean required;
        public String title;
        public EFieldType type;

        public FieldBean() {
        }

        public DefaultValueRule getDefaultValueRule() {
            Object r100 = this.fieldDefaultValueRule;
            if ((r100 instanceof DefaultValueRule) == true) goto L7;
            return null;
        L7:
            return (DefaultValueRule) r100;
        }

        public String getFieldName() {
            String r100 = this.title;
            if (r100 == null) goto L6;
            return r100;
        L6:
            return this.name;
        }

        public boolean isExtend() {
            FieldBeanExtendInfo r100 = this.extendInfo;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (TextUtils.isEmpty(r100.originFieldId) == true) goto L7;
            return true;
        }
    }

    public static class FieldBeanExtendInfo implements NonProguard {
        public String extendFieldType;
        public String originFieldId;
        public String originFieldUIType;

        public FieldBeanExtendInfo() {
        }
    }

    public TableMetaModel() {
    }
}
