package com.larus.bmhome.chat.trace.multimodal;

import androidx.collection.LruCache;
import com.bytedance.apm.ApmAgent;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.utils.c;
import com.larus.platform.service.o;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.m0;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: classes26.dex */
public final class MultimodalSendCostTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f310239a = 0;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0012\"\u0004\b\u0018\u0010\u0014R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000f¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$LoadImgStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "toskey", "", b.f276353c, "isByCache", "", "src", "isMultiImg", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getToskey", "()Ljava/lang/String;", "setToskey", "(Ljava/lang/String;)V", "getMessageID", "setMessageID", "()Ljava/lang/Integer;", "setByCache", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSrc", "setSrc", "setMultiImg", "getExtra", "setExtra", "getDurationInterval", "", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadImgStepRecord extends StepRecord {

        @SerializedName("extra")
        private String extra;

        @SerializedName("is_open_by_cache")
        private Integer isByCache;

        @SerializedName("is_multi_img")
        private Integer isMultiImg;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String messageID;

        /* JADX INFO: renamed from: src, reason: collision with root package name */
        @SerializedName("src")
        private String f310240src;

        @SerializedName("toskey")
        private String toskey;

        public LoadImgStepRecord() {
            this(null, null, null, null, null, null, 63, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "message_image_load_success";
        }

        public final String getExtra() {
            return this.extra;
        }

        public final String getMessageID() {
            return this.messageID;
        }

        public final String getSrc() {
            return this.f310240src;
        }

        public final String getToskey() {
            return this.toskey;
        }

        public final Integer isByCache() {
            return this.isByCache;
        }

        public final Integer isMultiImg() {
            return this.isMultiImg;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
            return -1L;
        }

        public final void setByCache(Integer r100) {
            this.isByCache = r100;
        }

        public final void setExtra(String r100) {
            this.extra = r100;
        }

        public final void setMessageID(String r100) {
            this.messageID = r100;
        }

        public final void setMultiImg(Integer r100) {
            this.isMultiImg = r100;
        }

        public final void setSrc(String r100) {
            this.f310240src = r100;
        }

        public final void setToskey(String r100) {
            this.toskey = r100;
        }

        public LoadImgStepRecord(String r100, String r101, Integer r110, String r111, Integer r112, String r113) {
            super(0, null, null, 7, null);
            this.toskey = r100;
            this.messageID = r101;
            this.isByCache = r110;
            this.f310240src = r111;
            this.isMultiImg = r112;
            this.extra = r113;
        }

        public /* synthetic */ LoadImgStepRecord(String r100, String r101, Integer r102, String r103, Integer r110, String r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            String r114 = null;
        L7:
            if ((r112 & 2) == 0) goto L9;
            String r104 = null;
        L11:
            if ((r112 & 4) == 0) goto L13;
            Integer r105 = null;
        L15:
            if ((r112 & 8) == 0) goto L17;
            String r106 = null;
        L19:
            if ((r112 & 16) == 0) goto L21;
            Integer r107 = null;
        L23:
            if ((r112 & 32) == 0) goto L25;
            String r115 = null;
        L26:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L25:
            r115 = r111;
            goto L26
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L13:
            r105 = r102;
            goto L15
        L9:
            r104 = r101;
            goto L11
        L5:
            r114 = r100;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$LoadVideoStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", b.f276353c, "", "videoParam", "enterMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageID", "()Ljava/lang/String;", "setMessageID", "(Ljava/lang/String;)V", "getVideoParam", "setVideoParam", "getEnterMethod", "setEnterMethod", "getDurationInterval", "", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadVideoStepRecord extends StepRecord {

        @SerializedName("enter_method")
        private String enterMethod;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String messageID;

        @SerializedName("video_param")
        private String videoParam;

        public LoadVideoStepRecord() {
            this(null, null, null, 7, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "message_video_load_success";
        }

        public final String getEnterMethod() {
            return this.enterMethod;
        }

        public final String getMessageID() {
            return this.messageID;
        }

        public final String getVideoParam() {
            return this.videoParam;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
            return -1L;
        }

        public final void setEnterMethod(String r100) {
            this.enterMethod = r100;
        }

        public final void setMessageID(String r100) {
            this.messageID = r100;
        }

        public final void setVideoParam(String r100) {
            this.videoParam = r100;
        }

        public LoadVideoStepRecord(String r100, String r101, String r110) {
            super(0, null, null, 7, null);
            this.messageID = r100;
            this.videoParam = r101;
            this.enterMethod = r110;
        }

        public /* synthetic */ LoadVideoStepRecord(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$OpenFileStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "toskey", "", b.f276353c, "isByCache", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getToskey", "()Ljava/lang/String;", "setToskey", "(Ljava/lang/String;)V", "getMessageID", "setMessageID", "()Ljava/lang/Integer;", "setByCache", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "resourceCenterEnabled", "", "getResourceCenterEnabled", "()Z", "getDurationInterval", "", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpenFileStepRecord extends StepRecord {

        @SerializedName("is_open_by_cache")
        private Integer isByCache;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String messageID;

        @SerializedName("resource_center_enabled")
        private final boolean resourceCenterEnabled;

        @SerializedName("toskey")
        private String toskey;

        public OpenFileStepRecord() {
            this(null, null, null, 7, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "message_file_open_success";
        }

        public final String getMessageID() {
            return this.messageID;
        }

        public final boolean getResourceCenterEnabled() {
            return this.resourceCenterEnabled;
        }

        public final String getToskey() {
            return this.toskey;
        }

        public final Integer isByCache() {
            return this.isByCache;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
            return -1L;
        }

        public final void setByCache(Integer r100) {
            this.isByCache = r100;
        }

        public final void setMessageID(String r100) {
            this.messageID = r100;
        }

        public final void setToskey(String r100) {
            this.toskey = r100;
        }

        public OpenFileStepRecord(String r100, String r101, Integer r110) {
            super(0, null, null, 7, null);
            this.toskey = r100;
            this.messageID = r101;
            this.isByCache = r110;
        }

        public /* synthetic */ OpenFileStepRecord(String r100, String r101, Integer r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$PreProcessingStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "<init>", "()V", "getDurationInterval", "", "fileIdentifier", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreProcessingStepRecord extends StepRecord {
        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "im_send_multimodal_preprocess_success";
        }

        public PreProcessingStepRecord() {
            super(0, null, null, 7, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
            MultimodalCommonParamManager.CommonParam r101 = MultimodalCommonParamManager.a(r100);
            if (r101 == null) goto L7;
            Long r102 = r101.getStartProcessTime();
            if (r102 == null) goto L7;
            long r103 = r102.longValue();
            return Long.valueOf(getStepTime() - r103);
        L7:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$ProcessingStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "<init>", "()V", "getDurationInterval", "", "fileIdentifier", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProcessingStepRecord extends StepRecord {
        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "im_send_multimodal_process_success";
        }

        public ProcessingStepRecord() {
            super(0, null, null, 7, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
            MultimodalCommonParamManager.CommonParam r101 = MultimodalCommonParamManager.a(r100);
            if (r101 == null) goto L7;
            Long r102 = r101.getPreProcessReadyTime();
            if (r102 == null) goto L7;
            long r103 = r102.longValue();
            Long r104 = Long.valueOf(RangesKt.coerceAtLeast(getStepTime() - r103, 0));
        L8:
            MultimodalCommonParamManager.CommonParam r105 = MultimodalCommonParamManager.a(r100);
            if (r105 == null) goto L11;
            r105.setLocalProcessDuration(r104);
        L11:
            return r104;
        L7:
            r104 = null;
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$ResourceCenterOpenFileStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "toskey", "", b.f276353c, "isByCache", "", "resourceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getToskey", "()Ljava/lang/String;", "setToskey", "(Ljava/lang/String;)V", "getMessageID", "setMessageID", "()Ljava/lang/Integer;", "setByCache", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getResourceId", "setResourceId", "resourceCenterEnabled", "", "getResourceCenterEnabled", "()Z", "getDurationInterval", "", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResourceCenterOpenFileStepRecord extends StepRecord {

        @SerializedName("is_open_by_cache")
        private Integer isByCache;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private String messageID;

        @SerializedName("resource_center_enabled")
        private final boolean resourceCenterEnabled;

        @SerializedName("resource_id")
        private String resourceId;

        @SerializedName("toskey")
        private String toskey;

        public ResourceCenterOpenFileStepRecord() {
            this(null, null, null, null, 15, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "message_file_open_success";
        }

        public final String getMessageID() {
            return this.messageID;
        }

        public final boolean getResourceCenterEnabled() {
            return this.resourceCenterEnabled;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final String getToskey() {
            return this.toskey;
        }

        public final Integer isByCache() {
            return this.isByCache;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
            return -1L;
        }

        public final void setByCache(Integer r100) {
            this.isByCache = r100;
        }

        public final void setMessageID(String r100) {
            this.messageID = r100;
        }

        public final void setResourceId(String r100) {
            this.resourceId = r100;
        }

        public final void setToskey(String r100) {
            this.toskey = r100;
        }

        public ResourceCenterOpenFileStepRecord(String r100, String r101, Integer r110, String r111) {
            super(0, null, null, 7, null);
            this.toskey = r100;
            this.messageID = r101;
            this.isByCache = r110;
            this.resourceId = r111;
            this.resourceCenterEnabled = true;
        }

        public /* synthetic */ ResourceCenterOpenFileStepRecord(String r100, String r101, Integer r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = null;
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0003H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010'\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\"\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$ResourceCenterUploadStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "toskey", "", "resourceId", "resourceSceneId", "durationPreProcess", "", "durationProcess", "durationUpload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getToskey", "()Ljava/lang/String;", "setToskey", "(Ljava/lang/String;)V", "getResourceId", "setResourceId", "getResourceSceneId", "setResourceSceneId", "getDurationPreProcess", "()Ljava/lang/Long;", "setDurationPreProcess", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDurationProcess", "setDurationProcess", "getDurationUpload", "setDurationUpload", "registerDuration", "getRegisterDuration", "setRegisterDuration", "resourceCenterEnabled", "", "getResourceCenterEnabled", "()Z", "setResourceCenterEnabled", "(Z)V", "getDurationInterval", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "report", "", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResourceCenterUploadStepRecord extends StepRecord {

        @SerializedName("duration_preprocess")
        private Long durationPreProcess;

        @SerializedName("duration_process")
        private Long durationProcess;

        @SerializedName("duration_upload")
        private Long durationUpload;

        @SerializedName("duration_register")
        private Long registerDuration;

        @SerializedName("resource_center_enabled")
        private boolean resourceCenterEnabled;

        @SerializedName("resource_id")
        private String resourceId;

        @SerializedName("resource_scene_id")
        private String resourceSceneId;

        @SerializedName("toskey")
        private String toskey;

        public ResourceCenterUploadStepRecord() {
            this(null, null, null, null, null, null, 63, null);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "im_send_multimodal_upload_success";
        }

        public final Long getDurationPreProcess() {
            return this.durationPreProcess;
        }

        public final Long getDurationProcess() {
            return this.durationProcess;
        }

        public final Long getDurationUpload() {
            return this.durationUpload;
        }

        public final Long getRegisterDuration() {
            return this.registerDuration;
        }

        public final boolean getResourceCenterEnabled() {
            return this.resourceCenterEnabled;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final String getResourceSceneId() {
            return this.resourceSceneId;
        }

        public final String getToskey() {
            return this.toskey;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
            MultimodalCommonParamManager.CommonParam r101 = MultimodalCommonParamManager.a(r100);
            if (r101 == null) goto L7;
            Long r102 = r101.getPreProcessReadyTime();
            if (r102 == null) goto L7;
            long r103 = r102.longValue();
            return Long.valueOf(getStepTime() - r103);
        L7:
            return null;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public void report(String r110) {
            Intrinsics.checkNotNullParameter(r110, "fileIdentifier");
            MultimodalCommonParamManager.CommonParam r100 = MultimodalCommonParamManager.a(r110);
            if (r100 == null) goto L28;
            long r101 = System.currentTimeMillis();
            Long r102 = r100.getPreProcessReadyTime();
            if (r102 == null) goto L7;
            long r103 = r102.longValue();
        L8:
            Long r104 = r100.getUploadedToServerTime();
            if (r104 == null) goto L11;
            long r105 = r104.longValue();
        L12:
            Long r106 = r100.getStartProcessTime();
            if (r106 == null) goto L15;
            long r107 = r106.longValue();
        L16:
            Long r108 = r100.getPreProcessReadyTime();
            if (r108 == null) goto L19;
            r101 = r108.longValue();
        L19:
            Long r109 = r100.getLocalProcessDuration();
            if (r109 == null) goto L22;
            long r111 = r109.longValue();
        L23:
            long r112 = RangesKt.coerceAtLeast(r111, 0);
            this.durationPreProcess = Long.valueOf(RangesKt.coerceAtLeast(r101 - r107, 0));
            this.durationProcess = Long.valueOf(r112);
            this.durationUpload = Long.valueOf(RangesKt.coerceAtLeast((r105 - r103) - r112, 0));
            Long r113 = getDurationInternal();
            if (r113 == null) goto L26;
            long r114 = r113.longValue();
        L27:
            this.registerDuration = Long.valueOf(RangesKt.coerceAtLeast(r114 - r105, 0));
            goto L28
        L26:
            r114 = getStepTime();
            goto L27
        L22:
            r111 = 0;
            goto L23
        L15:
            r107 = r101;
            goto L16
        L11:
            r105 = r101;
            goto L12
        L7:
            r103 = r101;
        L28:
            super.report(r110);
        }

        public final void setDurationPreProcess(Long r100) {
            this.durationPreProcess = r100;
        }

        public final void setDurationProcess(Long r100) {
            this.durationProcess = r100;
        }

        public final void setDurationUpload(Long r100) {
            this.durationUpload = r100;
        }

        public final void setRegisterDuration(Long r100) {
            this.registerDuration = r100;
        }

        public final void setResourceCenterEnabled(boolean r100) {
            this.resourceCenterEnabled = r100;
        }

        public final void setResourceId(String r100) {
            this.resourceId = r100;
        }

        public final void setResourceSceneId(String r100) {
            this.resourceSceneId = r100;
        }

        public final void setToskey(String r100) {
            this.toskey = r100;
        }

        public ResourceCenterUploadStepRecord(String r100, String r101, String r110, Long r111, Long r112, Long r113) {
            super(0, null, null, 7, null);
            this.toskey = r100;
            this.resourceId = r101;
            this.resourceSceneId = r110;
            this.durationPreProcess = r111;
            this.durationProcess = r112;
            this.durationUpload = r113;
            this.resourceCenterEnabled = true;
        }

        public /* synthetic */ ResourceCenterUploadStepRecord(String r100, String r101, String r102, Long r103, Long r110, Long r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 1) == 0) goto L5;
            String r114 = null;
        L7:
            if ((r112 & 2) == 0) goto L9;
            String r104 = null;
        L11:
            if ((r112 & 4) == 0) goto L13;
            String r105 = null;
        L15:
            if ((r112 & 8) == 0) goto L17;
            Long r106 = null;
        L19:
            if ((r112 & 16) == 0) goto L21;
            Long r107 = null;
        L23:
            if ((r112 & 32) == 0) goto L25;
            Long r115 = null;
        L26:
            this(r114, r104, r105, r106, r107, r115);
            return;
        L25:
            r115 = r111;
            goto L26
        L21:
            r107 = r110;
            goto L23
        L17:
            r106 = r103;
            goto L19
        L13:
            r105 = r102;
            goto L15
        L9:
            r104 = r101;
            goto L11
        L5:
            r114 = r100;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$SendStartStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "<init>", "()V", "getDurationInterval", "", "fileIdentifier", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SendStartStepRecord extends StepRecord {
        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
            return null;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "im_send_multimodal_start";
        }

        public SendStartStepRecord() {
            super(0, null, null, 7, null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0017\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001a\u00020\u0016H&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "", "stepTime", "", "duration", "durationInternal", "<init>", "(JLjava/lang/Long;Ljava/lang/Long;)V", "getStepTime", "()J", "setStepTime", "(J)V", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDurationInternal", "setDurationInternal", "report", "", "fileIdentifier", "", "(Ljava/lang/String;)Ljava/lang/Long;", "getDurationInterval", "getEventKey", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class StepRecord {

        @SerializedName("duration")
        private Long duration;

        @SerializedName("duration_internal")
        private Long durationInternal;
        private transient long stepTime;

        public StepRecord() {
            this(0, null, null, 7, null);
        }

        public abstract Long getDurationInterval(String r100);

        public abstract String getEventKey();

        public final Long getDuration() {
            return this.duration;
        }

        public final Long getDurationInternal() {
            return this.durationInternal;
        }

        public final long getStepTime() {
            return this.stepTime;
        }

        private final Long getDuration(String r100) {
            MultimodalCommonParamManager.CommonParam r101 = MultimodalCommonParamManager.a(r100);
            if (r101 == null) goto L7;
            Long r102 = r101.getStartProcessTime();
            if (r102 == null) goto L7;
            long r103 = r102.longValue();
            return Long.valueOf(this.stepTime - r103);
        L7:
            return null;
        }

        public void report(String r110) {
            Intrinsics.checkNotNullParameter(r110, "fileIdentifier");
            Long r100 = getDuration(r110);
            boolean r101 = false;
            if (r100 != null) goto L5;
        L13:
            Long r102 = getDurationInterval(r110);
            if (r102 != null) goto L16;
        L23:
            String r103 = getEventKey();
            int r104 = com.larus.bmhome.chat.trace.appreciable.a.f310106a;
            JSONObject r111 = com.larus.bmhome.chat.trace.appreciable.a.b(MultimodalCommonParamManager.a(r110), this);
            FLogger.f375446a.d("MultimodalSendCostTrace", "reportEvent, event=" + r103 + ", param=" + r111);
            if (r111 == null) goto L33;
            o.f365780a.reportEvent(r103, r111);
            JSONObject r105 = new JSONObject();
            if (r111.has("duration") == false) goto L29;
            r105.put("duration", r111.optLong("duration"));
        L29:
            if (r111.has("send_file_size") == false) goto L31;
            r105.put("send_file_size", r111.optLong("send_file_size"));
        L31:
            Lazy r106 = c.f314979a;
            Intrinsics.checkNotNullParameter(r103, "event");
            ((Set) c.f314979a.getValue()).contains(r103);
            ApmAgent.monitorEvent(r103, r111, r105, null);
            return;
        L33:
            return;
        L16:
            if (r102.longValue() < 0) goto L18;
            r101 = true;
        L18:
            if (r101 == true) goto L21;
            r102 = null;
        L21:
            if (r102 == null) goto L23;
            this.durationInternal = Long.valueOf(r102.longValue());
            goto L23
        L5:
            if (r100.longValue() < 0) goto L7;
            boolean r107 = true;
        L8:
            if (r107 == true) goto L11;
            r100 = null;
        L11:
            if (r100 == null) goto L13;
            this.duration = Long.valueOf(r100.longValue());
            goto L13
        L7:
            r107 = false;
            goto L8
        }

        public final void setDuration(Long r100) {
            this.duration = r100;
        }

        public final void setDurationInternal(Long r100) {
            this.durationInternal = r100;
        }

        public final void setStepTime(long r100) {
            this.stepTime = r100;
        }

        public StepRecord(long r100, Long r101, Long r102) {
            this.stepTime = r100;
            this.duration = r101;
            this.durationInternal = r102;
        }

        public /* synthetic */ StepRecord(long r100, Long r101, Long r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = System.currentTimeMillis();
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$UploadStepRecord;", "Lcom/larus/bmhome/chat/trace/multimodal/MultimodalSendCostTrace$StepRecord;", "toskey", "", "durationUpload", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "getToskey", "()Ljava/lang/String;", "setToskey", "(Ljava/lang/String;)V", "getDurationUpload", "()Ljava/lang/Long;", "setDurationUpload", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "resourceCenterEnabled", "", "getResourceCenterEnabled", "()Z", "getDurationInterval", "fileIdentifier", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventKey", "report", "", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UploadStepRecord extends StepRecord {

        @SerializedName("duration_upload")
        private Long durationUpload;

        @SerializedName("resource_center_enabled")
        private final boolean resourceCenterEnabled;

        @SerializedName("toskey")
        private String toskey;

        /* JADX WARN: Multi-variable type inference failed */
        public UploadStepRecord() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public String getEventKey() {
            return "im_send_multimodal_upload_success";
        }

        public final Long getDurationUpload() {
            return this.durationUpload;
        }

        public final boolean getResourceCenterEnabled() {
            return this.resourceCenterEnabled;
        }

        public final String getToskey() {
            return this.toskey;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public Long getDurationInterval(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
            MultimodalCommonParamManager.CommonParam r101 = MultimodalCommonParamManager.a(r100);
            if (r101 == null) goto L7;
            Long r102 = r101.getPreProcessReadyTime();
            if (r102 == null) goto L7;
            long r103 = r102.longValue();
            return Long.valueOf(getStepTime() - r103);
        L7:
            return null;
        }

        @Override // com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace.StepRecord
        public void report(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
            this.durationUpload = getDurationInterval(r100);
            super.report(r100);
        }

        public final void setDurationUpload(Long r100) {
            this.durationUpload = r100;
        }

        public final void setToskey(String r100) {
            this.toskey = r100;
        }

        public UploadStepRecord(String r100, Long r101) {
            super(0, null, null, 7, null);
            this.toskey = r100;
            this.durationUpload = r101;
        }

        public /* synthetic */ UploadStepRecord(String r100, Long r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    static {
    }

    public MultimodalSendCostTrace() {
    }

    public static void a(String r100, m0 r101) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        PreProcessingStepRecord r102 = new PreProcessingStepRecord();
        MultimodalCommonParamManager.CommonParam r103 = MultimodalCommonParamManager.a(r100);
        if (r103 == null) goto L23;
        r103.setPreProcessReadyTime(Long.valueOf(r102.getStepTime()));
        String r104 = null;
        if (r101 == null) goto L7;
        String r105 = r101.f489228f;
    L8:
        r103.setFileMD5(r105);
        if (r101 == null) goto L11;
        Integer r106 = Integer.valueOf((int) r101.f489225c);
    L12:
        r103.setFileSize(r106);
        if (r101 == null) goto L20;
        String r107 = r101.f489224b;
        if (r107 == null) goto L20;
        String r108 = StringsKt.substringAfterLast$default(r107, '.', null, 2, null);
        if (r108 == null) goto L20;
        r104 = r108;
    L22:
        r103.setFileType(r104);
    L20:
        if (r101 == null) goto L22;
        r104 = r101.f489226d;
        goto L22
    L11:
        r106 = null;
        goto L12
    L7:
        r105 = null;
    L23:
        r102.report(r100);
    }

    public static void d(String r110, m0 r111) {
        Intrinsics.checkNotNullParameter(r110, "fileIdentifier");
        ResourceCenter.f313541a.getClass();
        String r100 = null;
        boolean r101 = false;
        boolean r102 = false;
        boolean r103 = false;
        if (ResourceCenter.d(r110) == false) goto L9;
        ResourceCenterUploadStepRecord r104 = new ResourceCenterUploadStepRecord(null, null, null, null, null, null, 63, null);
        if (r111 == null) goto L7;
        String r105 = r111.f489230h;
    L8:
        r104.setToskey(r105);
        Intrinsics.checkNotNullParameter(r110, LocationMonitorConst.IDENTIFIER);
        r104.setResourceId(ResourceCenter.f313545e.get(r110));
        r104.setResourceSceneId(ResourceCenter.g(r110).getTitle());
        r104.setResourceCenterEnabled(true);
        StepRecord r106 = r104;
    L14:
        MultimodalCommonParamManager.CommonParam r107 = MultimodalCommonParamManager.a(r110);
        if (r107 == null) goto L20;
        r107.setUploadReadyTime(Long.valueOf(r106.getStepTime()));
        if (r111 == null) goto L19;
        r100 = r111.f489228f;
    L19:
        r107.setFileMD5(r100);
    L20:
        r106.report(r110);
        MultimodalCommonParamManager.b(r110);
        return;
    L7:
        r105 = null;
        goto L8
    L9:
        UploadStepRecord r108 = new UploadStepRecord(r103 ? 1 : 0, r102 ? 1 : 0, 3, r101 ? 1 : 0);
        if (r111 == null) goto L12;
        String r109 = r111.f489230h;
    L13:
        r108.setToskey(r109);
        r106 = r108;
        goto L14
    L12:
        r109 = null;
        goto L13
    }

    public static /* synthetic */ void c(String r100, String r101, String r110, String r111, AttachmentAreaType r112) {
        b(r100, r101, r110, r111, r112, null, null, null);
    }

    public static void f(String r100, String r101, String r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        if (o0.d(r104) == false) goto L5;
        StepRecord r105 = new ResourceCenterOpenFileStepRecord(r101, r102, Integer.valueOf(r103 ? 1 : 0), r104);
    L6:
        MultimodalCommonParamManager.CommonParam r106 = MultimodalCommonParamManager.a(r100);
        if (r106 == null) goto L9;
        r106.setProcessSuccessTime(Long.valueOf(r105.getStepTime()));
    L9:
        r105.report(r100);
        MultimodalCommonParamManager.b(r100);
        return;
    L5:
        r105 = new OpenFileStepRecord(r101, r102, Integer.valueOf(r103 ? 1 : 0));
        goto L6
    }

    public static void e(String r100, String r101, String r110, String r111, boolean r112, Map r113) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        Integer r102 = Integer.valueOf(r112 ? 1 : 0);
        if (r113 == null) goto L5;
        String r114 = new JSONObject(r113).toString();
    L6:
        LoadImgStepRecord r115 = new LoadImgStepRecord(r101, r110, 0, r111, r102, r114);
        MultimodalCommonParamManager.CommonParam r103 = MultimodalCommonParamManager.a(r100);
        if (r103 == null) goto L9;
        r103.setProcessSuccessTime(Long.valueOf(r115.getStepTime()));
    L9:
        r115.report(r100);
        MultimodalCommonParamManager.b(r100);
        return;
    L5:
        r114 = null;
        goto L6
    }

    public static void b(String r210, String r211, String r212, String r213, AttachmentAreaType r310, Integer r311, String r312, String r313) {
        Intrinsics.checkNotNullParameter(r210, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r310, "attachmentAreaType");
        SendStartStepRecord r100 = new SendStartStepRecord();
        LruCache<String, MultimodalCommonParamManager.CommonParam> r101 = MultimodalCommonParamManager.f310238a;
        long r102 = r100.getStepTime();
        int r103 = r310.getValue();
        Intrinsics.checkNotNullParameter(r210, "fileIdentifier");
        MultimodalCommonParamManager.CommonParam r104 = new MultimodalCommonParamManager.CommonParam(null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, 65535, null);
        MultimodalCommonParamManager.f310238a.put(r210, r104);
        r104.setScene(r213);
        r104.setLocalSendMsgId(r211);
        r104.setCvsId(r212);
        Integer r105 = null;
        if (r212 == null) goto L5;
        String r106 = BotInfoCache.INSTANCE.getBotId(r212);
    L6:
        r104.setBotId(r106);
        LruCache<String, e> r107 = ko8.a.f504531a;
        if (r212 == null) goto L11;
        e r108 = IAIChatControlTraceService.f365889a.ac().get(r212);
        if (r108 == null) goto L11;
        Integer r109 = r108.f559219v;
    L12:
        if (r212 == null) goto L14;
        r105 = BotInfoCache.INSTANCE.getBotType(r212);
    L14:
        if (r212 == null) goto L16;
        boolean r110 = BotInfoCache.INSTANCE.isOwnBot(r212);
    L17:
        r104.setChatType(ko8.a.f(r109, r105, r110));
        r104.setStartProcessTime(Long.valueOf(r102));
        r104.setFileAttachmentType(Integer.valueOf(r103));
        r104.setFileMD5(r312);
        r104.setFileSize(r311);
        r104.setFileType(r313);
        FLogger.f375446a.d("CommonParamManager", "createAndSave, param=" + r104);
        return;
    L16:
        r110 = true;
    L11:
        r109 = null;
        goto L12
    L5:
        r106 = null;
        goto L6
    }
}
