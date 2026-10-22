package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.download.api.utils.ToolUtils;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadEventModel {
    private final JSONObject mAdExtraDataObject;
    private final long mAdId;
    private String mCategory;
    private final List<String> mClickTrackUrl;
    private final int mEventSource;
    private final JSONObject mExtJson;
    private final long mExtValue;
    private final Object mExtraObject;
    private final boolean mIsAd;
    private final boolean mIsV3;
    private final String mLabel;
    private final String mLogExtra;
    private final JSONObject mParamsJson;
    private final String mRefer;
    private final String mTag;
    private final String mV3EventName;
    private final JSONObject mV3EventParams;

    public static class Builder {
        private JSONObject mAdExtraDataObject;
        private long mAdId;
        private String mCategory;
        private List<String> mClickTrackUrl;
        private Map<String, Object> mEventMap;
        private int mEventSource;
        private JSONObject mExtJson;
        private long mExtValue;
        private Object mExtraObject;
        private boolean mIsAd;
        private boolean mIsV3;
        private String mLabel;
        private String mLogExtra;
        private JSONObject mParamsJson;
        private String mRefer;
        private String mTag;
        private String mV3EventName;
        private JSONObject mV3EventParams;

        public DownloadEventModel build() {
            if (TextUtils.isEmpty(this.mCategory) == false) goto L5;
            this.mCategory = "umeng";
        L5:
            JSONObject r100 = new JSONObject();
            if (this.mExtJson != null) goto L63;
            this.mExtJson = new JSONObject();
        L63:
            Map<String, Object> r101 = this.mEventMap;     // Catch: Exception -> L59
            if (r101 == null) goto L20;
            if (r101.isEmpty() == true) goto L20;
            Iterator<Map.Entry<String, Object>> r102 = this.mEventMap.entrySet().iterator();     // Catch: Exception -> L59
        L14:
            if (r102.hasNext() == false) goto L20;
            Map.Entry<String, Object> r103 = r102.next();     // Catch: Exception -> L59
            if (this.mExtJson.has(r103.getKey()) == true) goto L14;
            this.mExtJson.putOpt(r103.getKey(), r103.getValue());     // Catch: Exception -> L59
        L20:
            if (this.mIsV3 == false) goto L43;
            this.mV3EventName = this.mLabel;     // Catch: Exception -> L59
            JSONObject r104 = new JSONObject();     // Catch: Exception -> L59
            this.mV3EventParams = r104;     // Catch: Exception -> L59
            if (this.mIsAd == false) goto L24;
            r104.put("ad_extra_data", this.mExtJson.toString());     // Catch: Exception -> L59
        L28:
            this.mV3EventParams.put("category", this.mCategory);     // Catch: Exception -> L59
            this.mV3EventParams.put("tag", this.mTag);     // Catch: Exception -> L59
            this.mV3EventParams.put("value", this.mAdId);     // Catch: Exception -> L59
            this.mV3EventParams.put("ext_value", this.mExtValue);     // Catch: Exception -> L59
            if (TextUtils.isEmpty(this.mRefer) == true) goto L31;
            this.mV3EventParams.put("refer", this.mRefer);     // Catch: Exception -> L59
        L31:
            JSONObject r105 = this.mParamsJson;     // Catch: Exception -> L59
            if (r105 == null) goto L35;
            this.mV3EventParams = ToolUtils.mergeJson(new JSONObject[]{r105, this.mV3EventParams});     // Catch: Exception -> L59
        L35:
            if (this.mIsAd == false) goto L43;
            if (this.mV3EventParams.has("log_extra") == false) goto L39;
        L41:
            this.mV3EventParams.put("is_ad_event", "1");     // Catch: Exception -> L59
            goto L43
        L39:
            if (TextUtils.isEmpty(this.mLogExtra) == true) goto L41;
            this.mV3EventParams.put("log_extra", this.mLogExtra);     // Catch: Exception -> L59
            goto L41
        L24:
            Iterator<String> r106 = this.mExtJson.keys();     // Catch: Exception -> L59
        L26:
            if (r106.hasNext() == false) goto L28;
            String r110 = r106.next();     // Catch: Exception -> L59
            this.mV3EventParams.put(r110, this.mExtJson.get(r110));     // Catch: Exception -> L59
        L43:
            if (this.mIsAd == false) goto L50;
            r100.put("ad_extra_data", this.mExtJson.toString());     // Catch: Exception -> L59
            if (r100.has("log_extra") == false) goto L47;
        L49:
            r100.put("is_ad_event", "1");     // Catch: Exception -> L59
        L52:
            if (TextUtils.isEmpty(this.mRefer) == true) goto L54;
            r100.putOpt("refer", this.mRefer);     // Catch: Exception -> L59
        L54:
            JSONObject r107 = this.mParamsJson;     // Catch: Exception -> L59
            if (r107 == null) goto L57;
            r100 = ToolUtils.mergeJson(new JSONObject[]{r107, r100});     // Catch: Exception -> L59
        L57:
            this.mExtJson = r100;     // Catch: Exception -> L59
        L62:
            return new DownloadEventModel(this);
        L47:
            if (TextUtils.isEmpty(this.mLogExtra) == true) goto L49;
            r100.put("log_extra", this.mLogExtra);     // Catch: Exception -> L59
            goto L49
        L50:
            r100.put("extra", this.mExtJson);     // Catch: Exception -> L59
            r100.put("ad_extra_data", this.mExtJson.toString());     // Catch: Exception -> L59
        L59:
            e = move-exception;
            GlobalInfo.getTTMonitor().monitorException(e, "DownloadEventModel build");
            goto L62
        }

        public Builder() {
            this.mIsAd = false;
            this.mIsV3 = false;
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.mCategory;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.mTag;
        }

        public static /* synthetic */ int access$1000(Builder r100) {
            return r100.mEventSource;
        }

        public static /* synthetic */ Object access$1100(Builder r100) {
            return r100.mExtraObject;
        }

        public static /* synthetic */ JSONObject access$1200(Builder r100) {
            return r100.mAdExtraDataObject;
        }

        public static /* synthetic */ boolean access$1300(Builder r100) {
            return r100.mIsV3;
        }

        public static /* synthetic */ String access$1400(Builder r100) {
            return r100.mV3EventName;
        }

        public static /* synthetic */ JSONObject access$1500(Builder r100) {
            return r100.mV3EventParams;
        }

        public static /* synthetic */ String access$1600(Builder r100) {
            return r100.mRefer;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.mLabel;
        }

        public static /* synthetic */ boolean access$300(Builder r100) {
            return r100.mIsAd;
        }

        public static /* synthetic */ long access$400(Builder r100) {
            return r100.mAdId;
        }

        public static /* synthetic */ String access$500(Builder r100) {
            return r100.mLogExtra;
        }

        public static /* synthetic */ long access$600(Builder r100) {
            return r100.mExtValue;
        }

        public static /* synthetic */ JSONObject access$700(Builder r100) {
            return r100.mExtJson;
        }

        public static /* synthetic */ JSONObject access$800(Builder r100) {
            return r100.mParamsJson;
        }

        public static /* synthetic */ List access$900(Builder r100) {
            return r100.mClickTrackUrl;
        }

        public Builder setAdExtraDataObject(JSONObject r100) {
            this.mAdExtraDataObject = r100;
            return this;
        }

        public Builder setAdId(long r100) {
            this.mAdId = r100;
            return this;
        }

        public Builder setCategory(String r100) {
            this.mCategory = r100;
            return this;
        }

        public Builder setClickTrackUrl(List<String> r100) {
            this.mClickTrackUrl = r100;
            return this;
        }

        public Builder setEventMap(Map<String, Object> r100) {
            this.mEventMap = r100;
            return this;
        }

        public Builder setEventSource(int r100) {
            this.mEventSource = r100;
            return this;
        }

        public Builder setExtJson(JSONObject r100) {
            this.mExtJson = r100;
            return this;
        }

        public Builder setExtValue(long r100) {
            this.mExtValue = r100;
            return this;
        }

        public Builder setExtraObject(Object r100) {
            this.mExtraObject = r100;
            return this;
        }

        public Builder setIsAd(boolean r100) {
            this.mIsAd = r100;
            return this;
        }

        public Builder setIsV3(boolean r100) {
            this.mIsV3 = r100;
            return this;
        }

        public Builder setLabel(String r100) {
            this.mLabel = r100;
            return this;
        }

        public Builder setLogExtra(String r100) {
            this.mLogExtra = r100;
            return this;
        }

        public Builder setParamsJson(JSONObject r100) {
            this.mParamsJson = r100;
            return this;
        }

        public Builder setRefer(String r100) {
            this.mRefer = r100;
            return this;
        }

        public Builder setTag(String r100) {
            this.mTag = r100;
            return this;
        }
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("category: ");
        r100.append(this.mCategory);
        r100.append("\ttag: ");
        r100.append(this.mTag);
        r100.append("\tlabel: ");
        r100.append(this.mLabel);
        r100.append("\nisAd: ");
        r100.append(this.mIsAd);
        r100.append("\tadId: ");
        r100.append(this.mAdId);
        r100.append("\tlogExtra: ");
        r100.append(this.mLogExtra);
        r100.append("\textValue: ");
        r100.append(this.mExtValue);
        r100.append("\nextJson: ");
        r100.append(this.mExtJson);
        r100.append("\nparamsJson: ");
        r100.append(this.mParamsJson);
        r100.append("\nclickTrackUrl: ");
        List<String> r101 = this.mClickTrackUrl;
        String r102 = "";
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        r100.append(r103);
        r100.append("\teventSource: ");
        r100.append(this.mEventSource);
        r100.append("\textraObject: ");
        Object r104 = this.mExtraObject;
        if (r104 == null) goto L9;
        String r105 = r104.toString();
    L10:
        r100.append(r105);
        r100.append("\nisV3: ");
        r100.append(this.mIsV3);
        r100.append("\tV3EventName: ");
        r100.append(this.mV3EventName);
        r100.append("\tV3EventParams: ");
        JSONObject r106 = this.mV3EventParams;
        if (r106 == null) goto L13;
        r102 = r106.toString();
    L13:
        r100.append(r102);
        return r100.toString();
    L9:
        r105 = "";
        goto L10
    L5:
        r103 = "";
        goto L6
    }

    public JSONObject getAdExtraDataObject() {
        return this.mAdExtraDataObject;
    }

    public long getAdId() {
        return this.mAdId;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public List<String> getClickTrackUrl() {
        return this.mClickTrackUrl;
    }

    public int getEventSource() {
        return this.mEventSource;
    }

    public JSONObject getExtJson() {
        return this.mExtJson;
    }

    public long getExtValue() {
        return this.mExtValue;
    }

    public Object getExtraObject() {
        return this.mExtraObject;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getLogExtra() {
        return this.mLogExtra;
    }

    public JSONObject getParamsJson() {
        return this.mParamsJson;
    }

    public String getRefer() {
        return this.mRefer;
    }

    public String getTag() {
        return this.mTag;
    }

    public String getV3EventName() {
        return this.mV3EventName;
    }

    public JSONObject getV3EventParams() {
        return this.mV3EventParams;
    }

    public boolean isAd() {
        return this.mIsAd;
    }

    public boolean isV3() {
        return this.mIsV3;
    }

    public DownloadEventModel(Builder r100) {
        this.mCategory = Builder.access$000(r100);
        this.mTag = Builder.access$100(r100);
        this.mLabel = Builder.access$200(r100);
        this.mIsAd = Builder.access$300(r100);
        this.mAdId = Builder.access$400(r100);
        this.mLogExtra = Builder.access$500(r100);
        this.mExtValue = Builder.access$600(r100);
        this.mExtJson = Builder.access$700(r100);
        this.mParamsJson = Builder.access$800(r100);
        this.mClickTrackUrl = Builder.access$900(r100);
        this.mEventSource = Builder.access$1000(r100);
        this.mExtraObject = Builder.access$1100(r100);
        this.mAdExtraDataObject = Builder.access$1200(r100);
        this.mIsV3 = Builder.access$1300(r100);
        this.mV3EventName = Builder.access$1400(r100);
        this.mV3EventParams = Builder.access$1500(r100);
        this.mRefer = Builder.access$1600(r100);
    }
}
