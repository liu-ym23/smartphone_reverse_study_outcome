package com.bytedance.ee.bear.bitable.card.model.jsmodel;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.bitable.card.model.enums.ECardsAction;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public class CardActionModel implements NonProguard {
    public ECardsAction action;
    public DataBean data;
    public CardActionExtra extra;
    public Integer openDiscussPanelType;
    public String srcObjToken;
    public Integer srcObjType;
    public long timestamp;
    public String transactionId;

    public static class AddRecordResult implements NonProguard {
        public ApplyResult applyResult;
        public int result;
        public SubmitResult submitResult;

        public AddRecordResult() {
        }
    }

    public static class ApplyResult implements NonProguard {
        public int errorCode;
        public String recordShareToken;
        public int status;

        public ApplyResult() {
        }
    }

    public static class CardActionExtra implements NonProguard {
        public String editTraceId;
        public HashMap<String, Long> timeStampsMap;

        public CardActionExtra() {
        }
    }

    public static class DataBean implements NonProguard {
        public AddRecordResult addRecordResult;
        public String baseId;
        public String baseName;
        public boolean bitableIsReady;
        public String commentId;
        public int commentType;
        public boolean disableComment;
        public boolean disableExpandLinkRecord;

        @JSONField(name = "fieldId")
        public String focusFieldId;
        public boolean forbiddenSubmit;
        public ForbiddenSubmitReason forbiddenSubmitReason;
        public String groupValue;
        public int highLightType;
        public boolean isLinkTablePartial;
        public boolean isShowNormalCard;
        public String openSource;
        public String preMockRecordId;
        public String recordId;
        public TableDataModel recordsData;
        public String replyId;
        public String stackViewId;
        public int submitResultCode;
        public String tableId;
        public TableMetaModel tableMeta;
        public String tableType;
        public String topFieldId;
        public int topTipType;

        @JSONField(name = SlcCommonAction.KEY_PARAMS)
        public Map<String, ErrorBean> validateFields;
        public String viewId;

        public @interface HighLightType {
        }

        public boolean hasMergeTableMetaAndRecordsData() {
            if (this.tableMeta != null) goto L5;
        L7:
            return false;
        L5:
            if (this.recordsData == null) goto L7;
            return true;
        }

        public DataBean() {
            this.commentType = 0;
            this.bitableIsReady = true;
            this.submitResultCode = -1;
        }
    }

    public static class ErrorBean implements NonProguard {
        public int errorCode;
        public String errorMsg;
        public HashMap<Integer, ArrayList<String>> errorTableQuestion;

        public ErrorBean() {
        }
    }

    public static class ForbiddenSubmitReason implements NonProguard {
        public String icon;
        public String reason;
        public String title;

        public ForbiddenSubmitReason() {
        }
    }

    public static class SubmitResult implements NonProguard {
        public int errorCode;
        public String recordId;
        public long submitSuccessTime;
        public ArrayList<String> unpermittedFields;

        public SubmitResult() {
        }
    }

    public static final enum SubmitResultCode extends Enum<SubmitResultCode> {
        public static final SubmitResultCode CANCELED = null;
        public static final SubmitResultCode SUCCEED = null;
        public static final SubmitResultCode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SubmitResultCode[] f207095a = null;
        private int code;

        static {
            SubmitResultCode r100 = new SubmitResultCode("SUCCEED", 0, 0);
            SUCCEED = r100;
            SubmitResultCode r101 = new SubmitResultCode("UNKNOWN", 1, 1);
            UNKNOWN = r101;
            SubmitResultCode r102 = new SubmitResultCode("CANCELED", 2, 2);
            CANCELED = r102;
            f207095a = new SubmitResultCode[]{r100, r101, r102};
        }

        public static SubmitResultCode[] values() {
            return (SubmitResultCode[]) f207095a.clone();
        }

        public int getCode() {
            return this.code;
        }

        public static SubmitResultCode valueOf(String r100) {
            return (SubmitResultCode) a.a(SubmitResultCode.class, r100);
        }

        public SubmitResultCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public static final enum TopTipType extends Enum<TopTipType> {
        public static final TopTipType None = null;
        public static final TopTipType RecordLimit = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TopTipType[] f207096a = null;
        private int value;

        static {
            TopTipType r100 = new TopTipType("None", 0, 0);
            None = r100;
            TopTipType r101 = new TopTipType("RecordLimit", 1, 1);
            RecordLimit = r101;
            f207096a = new TopTipType[]{r100, r101};
        }

        public static TopTipType[] values() {
            return (TopTipType[]) f207096a.clone();
        }

        public int getTipValue() {
            return this.value;
        }

        public static TopTipType forNumber(int r100) {
            if (r100 == 1) goto L7;
            return None;
        L7:
            return RecordLimit;
        }

        public static TopTipType valueOf(String r100) {
            return (TopTipType) a.a(TopTipType.class, r100);
        }

        public TopTipType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public String getEditTraceId() {
        CardActionExtra r100 = this.extra;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.editTraceId;
    }

    public Map<String, Long> getTimeStampsMap() {
        CardActionExtra r100 = this.extra;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.timeStampsMap;
    }

    public String toString() {
        return "CardActionModel{action=" + this.action + '}';
    }

    public CardActionModel() {
        this.openDiscussPanelType = 0;
    }
}
