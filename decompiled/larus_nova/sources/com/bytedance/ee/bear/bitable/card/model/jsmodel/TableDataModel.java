package com.bytedance.ee.bear.bitable.card.model.jsmodel;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.bitable.card.model.enums.EFieldUneditableReason;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.permission.FieldPermission;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import nq4.d;

/* JADX INFO: loaded from: classes15.dex */
public class TableDataModel implements NonProguard, d {
    public boolean loaded;
    public List<RecordsBean> records;
    public boolean showRecordIndex;
    public long timestamp;
    public int total;
    public String transactionId;

    public static class RecordsBean implements NonProguard {
        public static final int NO_VALUE = -1;
        public boolean addable;
        public Integer commentCount;
        public ArrayList<String> commentIds;
        public boolean deletable;
        public boolean editable;
        public Map<String, FieldGroupNode> fieldGroupMap;
        public List<ContentBean> fields;
        public int globalIndex;
        public String groupValue;
        public boolean hasLeftMore;
        public boolean hasRightMore;
        public String headerBarColor;
        public boolean isArchived;
        public boolean isFiltered;
        public boolean isShowSubmitFailed;
        public String recordId;
        public String recordTitle;
        public ReportEvent recordViewEvent;
        public boolean shareable;
        public String switchLeftFailReason;
        public String switchRightFailReason;
        public boolean visible;

        public static class ContentBean implements NonProguard {
            public ReportEvent cellEditEvent;
            public ReportEvent cellViewEvent;
            public String disableReason;
            public boolean editable;
            public String fieldGroupId;

            @JSONField(name = "id")
            public String fieldId;
            public FieldPermission fieldPermission;
            public EFieldUIType fieldUIType;
            public Object fieldValue;
            public boolean isGroupLast;
            public boolean isPartialRecordVisible;
            public boolean supportAiPolish;
            public boolean supportVoiceInput;
            public boolean triggerAble;
            public EFieldType type;
            public EFieldUneditableReason uneditableReason;

            public ContentBean() {
            }
        }

        public RecordsBean() {
        }

        public String toString() {
            return this.recordId;
        }
    }

    public static class ReportEvent implements NonProguard {
        public String event;
        public JSONObject params;

        public ReportEvent() {
        }
    }

    @Override // nq4.d
    public boolean isLoading() {
        return !this.loaded;
    }

    public String toString() {
        return "TableDataModel{, records=" + this.records + '}';
    }

    public TableDataModel() {
        this.loaded = true;
        this.showRecordIndex = true;
    }
}
