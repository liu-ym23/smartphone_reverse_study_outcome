package com.bytedance.ee.bear.bitable.card.model.jsmodel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.ee.bear.bitable.card.model.enums.ECardOperation;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class CardOperationModel implements NonProguard {

    @JSONField(serialzeFeatures = {SerializerFeature.WriteEnumUsingToString})
    private ECardOperation action;
    private String baseId;
    private HashMap<String, String> extra;
    public FormRecordParams formRecordParams;
    public boolean isForm;
    private PayloadBean payload;
    private RecordPaginationParam recordsParams;
    private String tableId;
    private long timestamp;
    private String transactionId;
    public String viewId;

    public static class FormRecordParams implements NonProguard {
        public int recordIndex;
        public String tableQuestionID;

        public String toString() {
            return "FormRecordParams{tableQuestionID='" + this.tableQuestionID + "', recordIndex=" + this.recordIndex + '}';
        }

        public FormRecordParams(String r100) {
            this.tableQuestionID = r100;
        }

        public FormRecordParams(String r100, int r101) {
            this.tableQuestionID = r100;
            this.recordIndex = r101;
        }
    }

    public static class PayloadBean implements NonProguard {
        private String baseId;
        private String groupValue;

        @JSONField(name = "isCreated")
        private boolean isCreated;

        @JSONField(name = "isDisclosed")
        private boolean isDisclosed;
        private LinkSourceInfoBean linkSourceInfo;
        private String newRecordId;
        private boolean notify;
        private String oldRecordId;
        private int openDiscussPanelType;
        private String recordId;
        private String tableId;
        private TargetBean target;
        private int topTipType;
        private String type;

        @JSONField(serialzeFeatures = {SerializerFeature.WriteMapNullValue})
        private Object value;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EditType {
            public static final String ADD = "add";
            public static final String ADD_LOCAL = "localAdd";
            public static final String COVER = "cover";
            public static final String DELETE = "delete";
            public static final String DELETE_LOCAL = "localDelete";
            public static final String PRE_ADD = "preAdd";
        }

        public static class LinkSourceInfoBean implements NonProguard {
            private String baseId;
            private String fieldId;
            private String recordId;
            private String tableId;

            public String getBaseId() {
                return this.baseId;
            }

            public String getFieldId() {
                return this.fieldId;
            }

            public String getRecordId() {
                return this.recordId;
            }

            public String getTableId() {
                return this.tableId;
            }

            public void setBaseId(String r100) {
                this.baseId = r100;
            }

            public void setFieldId(String r100) {
                this.fieldId = r100;
            }

            public void setRecordId(String r100) {
                this.recordId = r100;
            }

            public void setTableId(String r100) {
                this.tableId = r100;
            }

            public LinkSourceInfoBean(String r100, String r101, String r102, String r103) {
                this.baseId = r100;
                this.tableId = r101;
                this.recordId = r102;
                this.fieldId = r103;
            }
        }

        public static class TargetBean implements NonProguard {
            private String baseId;
            private String fieldId;
            private String recordId;
            private String tableId;
            private String viewId;

            public String getBaseId() {
                return this.baseId;
            }

            public String getFieldId() {
                return this.fieldId;
            }

            public String getRecordId() {
                return this.recordId;
            }

            public String getTableId() {
                return this.tableId;
            }

            public String getViewId() {
                return this.viewId;
            }

            public void setBaseId(String r100) {
                this.baseId = r100;
            }

            public void setFieldId(String r100) {
                this.fieldId = r100;
            }

            public void setRecordId(String r100) {
                this.recordId = r100;
            }

            public void setTableId(String r100) {
                this.tableId = r100;
            }

            public void setViewId(String r100) {
                this.viewId = r100;
            }

            public TargetBean(String r100, String r101) {
                this.tableId = r100;
                this.viewId = r101;
            }
        }

        public PayloadBean() {
        }

        public String getBaseId() {
            return this.baseId;
        }

        public String getGroupValue() {
            return this.groupValue;
        }

        public LinkSourceInfoBean getLinkSourceInfo() {
            return this.linkSourceInfo;
        }

        public String getNewRecordId() {
            return this.newRecordId;
        }

        public String getOldRecordId() {
            return this.oldRecordId;
        }

        public int getOpenDiscussPanelType() {
            return this.openDiscussPanelType;
        }

        public String getRecordId() {
            return this.recordId;
        }

        public String getTableId() {
            return this.tableId;
        }

        public TargetBean getTarget() {
            return this.target;
        }

        public int getTopTipType() {
            return this.topTipType;
        }

        public String getType() {
            return this.type;
        }

        public Object getValue() {
            return this.value;
        }

        public boolean isCreated() {
            return this.isCreated;
        }

        public boolean isDisclosed() {
            return this.isDisclosed;
        }

        public boolean isNotify() {
            return this.notify;
        }

        public void setBaseId(String r100) {
            this.baseId = r100;
        }

        public void setCreated(boolean r100) {
            this.isCreated = r100;
        }

        public void setDisclosed(boolean r100) {
            this.isDisclosed = r100;
        }

        public void setGroupValue(String r100) {
            this.groupValue = r100;
        }

        public void setLinkSourceInfo(LinkSourceInfoBean r100) {
            this.linkSourceInfo = r100;
        }

        public void setNewRecordId(String r100) {
            this.newRecordId = r100;
        }

        public void setNotify(boolean r100) {
            this.notify = r100;
        }

        public void setOldRecordId(String r100) {
            this.oldRecordId = r100;
        }

        public void setOpenDiscussPanelType(int r100) {
            this.openDiscussPanelType = r100;
        }

        public void setRecordId(String r100) {
            this.recordId = r100;
        }

        public void setTableId(String r100) {
            this.tableId = r100;
        }

        public void setTarget(TargetBean r100) {
            this.target = r100;
        }

        public void setTopTipType(int r100) {
            this.topTipType = r100;
        }

        public void setType(String r100) {
            this.type = r100;
        }

        public void setValue(Object r100) {
            this.value = r100;
        }
    }

    public static class RecordPaginationParam implements NonProguard {
        private int length;
        private int offset;
        private String recordId;
        private String tableId;
        private String tableType;
        private String viewId;

        public RecordPaginationParam() {
        }

        public int getLength() {
            return this.length;
        }

        public int getOffset() {
            return this.offset;
        }

        public String getRecordId() {
            return this.recordId;
        }

        public String getTableId() {
            return this.tableId;
        }

        public String getTableType() {
            return this.tableType;
        }

        public String getViewId() {
            return this.viewId;
        }

        public void setLength(int r100) {
            this.length = r100;
        }

        public void setOffset(int r100) {
            this.offset = r100;
        }

        public void setRecordId(String r100) {
            this.recordId = r100;
        }

        public void setTableId(String r100) {
            this.tableId = r100;
        }

        public void setTableType(String r100) {
            this.tableType = r100;
        }

        public void setViewId(String r100) {
            this.viewId = r100;
        }
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    public ECardOperation getAction() {
        return this.action;
    }

    public String getBaseId() {
        return this.baseId;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public PayloadBean getPayload() {
        return this.payload;
    }

    public RecordPaginationParam getRecordsParams() {
        return this.recordsParams;
    }

    public String getTableId() {
        return this.tableId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setAction(ECardOperation r100) {
        this.action = r100;
    }

    public void setBaseId(String r100) {
        this.baseId = r100;
    }

    public void setEditTraceId(String r100) {
        if (this.extra != null) goto L5;
        this.extra = new HashMap();
    L5:
        this.extra.put("editTraceId", r100);
    }

    public void setPayload(PayloadBean r100) {
        this.payload = r100;
    }

    public void setRecordsParams(RecordPaginationParam r100) {
        this.recordsParams = r100;
    }

    public void setTableId(String r100) {
        this.tableId = r100;
    }

    public void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    public void setTransactionId(String r100) {
        this.transactionId = r100;
    }

    public CardOperationModel(String r100, String r101) {
        this.baseId = r100;
        this.tableId = r101;
    }

    public CardOperationModel(String r100, String r101, ECardOperation r102) {
        this.baseId = r100;
        this.tableId = r101;
        this.action = r102;
    }
}
