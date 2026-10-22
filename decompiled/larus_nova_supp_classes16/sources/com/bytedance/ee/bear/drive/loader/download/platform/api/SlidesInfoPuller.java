package com.bytedance.ee.bear.drive.loader.download.platform.api;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.SlidesInfoV1Puller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.imfile.SlidesInfoV2Puller;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller;", "", "<init>", "()V", "Companion", "Params", "Result", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesInfoPuller {
    public static final Companion Companion = null;
    public static final String TAG = "DrivePlatform_SlidesInfoPuller";

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Companion;", "", "<init>", "()V", "TAG", "", "v1", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/IApiPuller;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Params;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Result;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "canRetry", "", "v2", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final IApiPuller<Params, Result> v1(NetService r2) {
            Intrinsics.checkNotNullParameter(r2, "netService");
            return v1(r2, true);
        }

        public final IApiPuller<Params, Result> v2(NetService r2) {
            Intrinsics.checkNotNullParameter(r2, "netService");
            return v2(r2, true);
        }

        public final IApiPuller<Params, Result> v1(NetService r2, final boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "netService");
            final SlidesInfoV1Puller r0 = new SlidesInfoV1Puller(r2);
            return new SlidesInfoPuller$Companion$v1$1(r0, r3);
        }

        public final IApiPuller<Params, Result> v2(NetService r2, final boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "netService");
            final SlidesInfoV2Puller r0 = new SlidesInfoV2Puller(r2);
            return new SlidesInfoPuller$Companion$v2$1(r0, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Params;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/BasePuller$Params;", "<init>", "()V", "loadListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "getLoadListener", "()Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "setLoadListener", "(Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;)V", "fileToken", "", "getFileToken", "()Ljava/lang/String;", "setFileToken", "(Ljava/lang/String;)V", "fileName", "getFileName", "setFileName", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Params extends BasePuller.Params {
        private String fileName;
        private String fileToken;
        private transient u75.b.a loadListener;

        public Params() {
            this.fileToken = "";
            this.fileName = "";
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final String getFileToken() {
            return this.fileToken;
        }

        public final u75.b.a getLoadListener() {
            return this.loadListener;
        }

        public final void setFileName(String r1) {
            this.fileName = r1;
        }

        public final void setFileToken(String r1) {
            this.fileToken = r1;
        }

        public final void setLoadListener(u75.b.a r1) {
            this.loadListener = r1;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Result;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/BasePuller$Result;", "<init>", "()V", "editType", "", "getEditType", "()Ljava/lang/Integer;", "setEditType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "slidesToken", "", "getSlidesToken", "()Ljava/lang/String;", "setSlidesToken", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "toString", "isTypeNeedTrain", "", "isTypeUseSlides", "Companion", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Result extends BasePuller.Result {
        public static final Companion Companion = null;

        @SerializedName("edit_type")
        @JSONField(name = "edit_type")
        private Integer editType;

        @SerializedName("token")
        @JSONField(name = "token")
        private String slidesToken;

        @SerializedName("url")
        @JSONField(name = "url")
        private String url;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Result$Companion;", "", "<init>", "()V", "buildWpsResult", "Lcom/bytedance/ee/bear/drive/loader/download/platform/api/SlidesInfoPuller$Result;", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final Result buildWpsResult() {
                Result r0 = new Result();
                r0.setEditType(1);
                return r0;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public final boolean isTypeNeedTrain() {
            return DriveDocumentEditType.Companion.isTypeNeedTrain(this.editType);
        }

        public final boolean isTypeUseSlides() {
            if (DriveDocumentEditType.Companion.isTypeUseSheetOrSlides(this.editType) == true) goto L5;
        L7:
            return false;
        L5:
            if (TextUtils.isEmpty(this.url) == true) goto L7;
            return true;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("Result(editType=");
            r0.append(this.editType);
            r0.append(", slidesToken=");
            r0.append(du5.b.g(this.slidesToken));
            r0.append(", url=");
            String r1 = this.url;
            if (r1 != null) goto L5;
            r1 = null;
        L5:
            r0.append(du5.b.f(r1));
            r0.append(')');
            return r0.toString();
        }

        public Result() {
            this.editType = 0;
        }

        public final Integer getEditType() {
            return this.editType;
        }

        public final String getSlidesToken() {
            return this.slidesToken;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setEditType(Integer r1) {
            this.editType = r1;
        }

        public final void setSlidesToken(String r1) {
            this.slidesToken = r1;
        }

        public final void setUrl(String r1) {
            this.url = r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SlidesInfoPuller() {
    }
}
