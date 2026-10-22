package com.ss.android.download.api.model;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/ss/android/download/api/model/DelayInstallModel;", "", "builder", "Lcom/ss/android/download/api/model/DelayInstallModel$Builder;", "(Lcom/ss/android/download/api/model/DelayInstallModel$Builder;)V", "adId", "", "getAdId", "()J", "setAdId", "(J)V", "appName", "", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "downloadId", "getDownloadId", "setDownloadId", "extValue", "getExtValue", "setExtValue", "fileName", "getFileName", "setFileName", "logExtra", "getLogExtra", "setLogExtra", "packageName", "getPackageName", "setPackageName", "toJson", "Lorg/json/JSONObject;", "Builder", "Companion", "download-api_release"}, k = 1, mv = {1, 1, 16})
public final class DelayInstallModel {
    public static final Companion Companion = null;
    private long adId;
    private String appName;
    private long downloadId;
    private long extValue;
    private String fileName;
    private String logExtra;
    private String packageName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\nJ\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0004J\u0010\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\nJ\u0010\u0010%\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\nJ\u0010\u0010&\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000e¨\u0006'"}, d2 = {"Lcom/ss/android/download/api/model/DelayInstallModel$Builder;", "", "()V", "mAdId", "", "getMAdId", "()J", "setMAdId", "(J)V", NativeDownloadModel.JsonKey.APP_NAME, "", "getMAppName", "()Ljava/lang/String;", "setMAppName", "(Ljava/lang/String;)V", NativeDownloadModel.JsonKey.DOWNLOAD_ID, "getMDownloadId", "setMDownloadId", NativeDownloadModel.JsonKey.EXT_VALUE, "getMExtValue", "setMExtValue", "mFileName", "getMFileName", "setMFileName", NativeDownloadModel.JsonKey.LOG_EXTRA, "getMLogExtra", "setMLogExtra", NativeDownloadModel.JsonKey.PACKAGE_NAME, "getMPackageName", "setMPackageName", "adId", "appName", "build", "Lcom/ss/android/download/api/model/DelayInstallModel;", "downloadId", "extValue", "fileName", "logExtra", "packageName", "download-api_release"}, k = 1, mv = {1, 1, 16})
    public static final class Builder {
        private long mAdId;
        private String mAppName;
        private long mDownloadId;
        private long mExtValue;
        private String mFileName;
        private String mLogExtra;
        private String mPackageName;

        public Builder() {
        }

        public final DelayInstallModel build() {
            return new DelayInstallModel(this, null);
        }

        public final long getMAdId() {
            return this.mAdId;
        }

        public final String getMAppName() {
            return this.mAppName;
        }

        public final long getMDownloadId() {
            return this.mDownloadId;
        }

        public final long getMExtValue() {
            return this.mExtValue;
        }

        public final String getMFileName() {
            return this.mFileName;
        }

        public final String getMLogExtra() {
            return this.mLogExtra;
        }

        public final String getMPackageName() {
            return this.mPackageName;
        }

        public final Builder adId(long r100) {
            this.mAdId = r100;
            return this;
        }

        public final Builder appName(String r100) {
            this.mAppName = r100;
            return this;
        }

        public final Builder downloadId(long r100) {
            this.mDownloadId = r100;
            return this;
        }

        public final Builder extValue(long r100) {
            this.mExtValue = r100;
            return this;
        }

        public final Builder fileName(String r100) {
            this.mFileName = r100;
            return this;
        }

        public final Builder logExtra(String r100) {
            this.mLogExtra = r100;
            return this;
        }

        public final Builder packageName(String r100) {
            this.mPackageName = r100;
            return this;
        }

        public final void setMAdId(long r100) {
            this.mAdId = r100;
        }

        public final void setMAppName(String r100) {
            this.mAppName = r100;
        }

        public final void setMDownloadId(long r100) {
            this.mDownloadId = r100;
        }

        public final void setMExtValue(long r100) {
            this.mExtValue = r100;
        }

        public final void setMFileName(String r100) {
            this.mFileName = r100;
        }

        public final void setMLogExtra(String r100) {
            this.mLogExtra = r100;
        }

        public final void setMPackageName(String r100) {
            this.mPackageName = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/download/api/model/DelayInstallModel$Companion;", "", "()V", "fromJson", "Lcom/ss/android/download/api/model/DelayInstallModel;", "jsonObject", "Lorg/json/JSONObject;", "download-api_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final DelayInstallModel fromJson(JSONObject r100) {
            return new Builder().downloadId(r100.optLong("downloadId")).adId(r100.optLong("adId")).extValue(r100.optLong("extValue")).packageName(r100.optString("packageName")).appName(r100.optString("appName")).logExtra(r100.optString("logExtra")).fileName(r100.optString("fileName")).build();
        L4:
            return null;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("downloadId", Long.valueOf(this.downloadId));     // Catch: JSONException -> L5
        r100.putOpt("adId", Long.valueOf(this.adId));     // Catch: JSONException -> L5
        r100.putOpt("extValue", Long.valueOf(this.extValue));     // Catch: JSONException -> L5
        r100.putOpt("packageName", this.packageName);     // Catch: JSONException -> L5
        r100.putOpt("appName", this.appName);     // Catch: JSONException -> L5
        r100.putOpt("logExtra", this.logExtra);     // Catch: JSONException -> L5
        r100.putOpt("fileName", this.fileName);     // Catch: JSONException -> L5
    L4:
        return r100;
    }

    public final long getAdId() {
        return this.adId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final long getDownloadId() {
        return this.downloadId;
    }

    public final long getExtValue() {
        return this.extValue;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    private DelayInstallModel(Builder r100) {
        this.downloadId = r100.getMDownloadId();
        this.adId = r100.getMAdId();
        this.extValue = r100.getMExtValue();
        this.packageName = r100.getMPackageName();
        this.appName = r100.getMAppName();
        this.logExtra = r100.getMLogExtra();
        this.fileName = r100.getMFileName();
    }

    public final void setAdId(long r100) {
        this.adId = r100;
    }

    public final void setAppName(String r100) {
        this.appName = r100;
    }

    public final void setDownloadId(long r100) {
        this.downloadId = r100;
    }

    public final void setExtValue(long r100) {
        this.extValue = r100;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setLogExtra(String r100) {
        this.logExtra = r100;
    }

    public final void setPackageName(String r100) {
        this.packageName = r100;
    }

    public /* synthetic */ DelayInstallModel(Builder r100, DefaultConstructorMarker r101) {
        this(r100);
    }
}
