package com.ss.android.lark.chat.service.impl;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.tencent.connect.share.QzonePublish;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\bq\b\u0003\u0018\u00002\u00020\u0001BÓ\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010#\u001a\u00020!\u0012\b\b\u0002\u0010$\u001a\u00020!\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\b\b\u0002\u0010(\u001a\u00020\u0007\u0012\b\b\u0002\u0010)\u001a\u00020!\u0012\b\b\u0002\u0010*\u001a\u00020\u0007\u0012\b\b\u0002\u0010+\u001a\u00020!\u0012\b\b\u0002\u0010,\u001a\u00020!\u0012\b\b\u0002\u0010-\u001a\u00020!\u0012\b\b\u0002\u0010.\u001a\u00020!\u0012\b\b\u0002\u0010/\u001a\u00020!\u0012\b\b\u0002\u00100\u001a\u00020!\u0012\b\b\u0002\u00101\u001a\u00020!\u0012\b\b\u0002\u00102\u001a\u00020\u0007\u0012\b\b\u0002\u00103\u001a\u00020!¢\u0006\u0004\b4\u00105R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00107\"\u0004\b=\u00109R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010?\"\u0004\bC\u0010AR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00107\"\u0004\bG\u00109R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00107\"\u0004\bI\u00109R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010?\"\u0004\bK\u0010AR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00107\"\u0004\bM\u00109R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00107\"\u0004\bO\u00109R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00107\"\u0004\bQ\u00109R\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010?\"\u0004\bS\u0010AR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010?\"\u0004\bU\u0010AR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00107\"\u0004\bW\u00109R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010\u0015\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010Y\"\u0004\b]\u0010[R\u001a\u0010\u0016\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010Y\"\u0004\b_\u0010[R\u001a\u0010\u0017\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010Y\"\u0004\ba\u0010[R\u001a\u0010\u0018\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010Y\"\u0004\bc\u0010[R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010Y\"\u0004\be\u0010[R\u001a\u0010\u001a\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010Y\"\u0004\bg\u0010[R\u001a\u0010\u001b\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010Y\"\u0004\bi\u0010[R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010Y\"\u0004\bk\u0010[R\u001a\u0010\u001d\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010Y\"\u0004\bm\u0010[R\u001a\u0010\u001e\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010Y\"\u0004\bo\u0010[R\u001a\u0010\u001f\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010Y\"\u0004\bq\u0010[R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010r\"\u0004\bs\u0010tR\u001a\u0010\"\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010r\"\u0004\bu\u0010tR\u001a\u0010#\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010r\"\u0004\bw\u0010tR\u001a\u0010$\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010r\"\u0004\by\u0010tR\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010?\"\u0004\b{\u0010AR\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010?\"\u0004\b}\u0010AR\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010?\"\u0004\b\u007f\u0010AR\u001c\u0010(\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010?\"\u0005\b\u0081\u0001\u0010AR\u001c\u0010)\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010r\"\u0005\b\u0083\u0001\u0010tR\u001c\u0010*\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010?\"\u0005\b\u0085\u0001\u0010AR\u001c\u0010+\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010r\"\u0005\b\u0087\u0001\u0010tR\u001b\u0010,\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b,\u0010r\"\u0005\b\u0088\u0001\u0010tR\u001b\u0010-\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b-\u0010r\"\u0005\b\u0089\u0001\u0010tR\u001b\u0010.\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b.\u0010r\"\u0005\b\u008a\u0001\u0010tR\u001b\u0010/\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b/\u0010r\"\u0005\b\u008b\u0001\u0010tR\u001b\u00100\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b0\u0010r\"\u0005\b\u008c\u0001\u0010tR\u001b\u00101\u001a\u00020!X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b1\u0010r\"\u0005\b\u008d\u0001\u0010tR\u001c\u00102\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010?\"\u0005\b\u008f\u0001\u0010AR\u001c\u00103\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010r\"\u0005\b\u0091\u0001\u0010t¨\u0006\u0092\u0001"}, d2 = {"Lcom/ss/android/lark/chat/service/impl/MediaMessageReport;", "", "originFPS", "", "originFileSize", "originBitrate", "originVideoSize", "", "originVideoFormat", "originEncodeFormat", "originLastModifyDiff", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "videoSource", "resultFPS", "resultFileSize", "resultBitrate", "resultVideoSize", "resultEncodeFormat", "compressCoverFileSize", "pickStart", "", "sendStart", "preStart", "preMerged", "compressStart", "totalDuration", "pickDuration", "preDuration", "compressDuration", "uploadDuration", "compressUploadDuration", "sendDuration", "isRemux", "", "isHDR", "unenabledEemuxCode", "useWeakNetSetting", "compileScene", "compileQuality", "result", "errorType", "errorCode", "errorMsg", "errorStatus", "isRaw", "isOriginal", "isUseCache", "isMergePreCompress", "isCompressUpload", "isCompressUploadSuccess", "compressUploadFailedMsg", "sendNetStatus", "<init>", "(FFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FFLjava/lang/String;FFFLjava/lang/String;Ljava/lang/String;FJJJJJJJJJJJJIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIIIIIILjava/lang/String;I)V", "getOriginFPS", "()F", "setOriginFPS", "(F)V", "getOriginFileSize", "setOriginFileSize", "getOriginBitrate", "setOriginBitrate", "getOriginVideoSize", "()Ljava/lang/String;", "setOriginVideoSize", "(Ljava/lang/String;)V", "getOriginVideoFormat", "setOriginVideoFormat", "getOriginEncodeFormat", "setOriginEncodeFormat", "getOriginLastModifyDiff", "setOriginLastModifyDiff", "getVideoDuration", "setVideoDuration", "getVideoSource", "setVideoSource", "getResultFPS", "setResultFPS", "getResultFileSize", "setResultFileSize", "getResultBitrate", "setResultBitrate", "getResultVideoSize", "setResultVideoSize", "getResultEncodeFormat", "setResultEncodeFormat", "getCompressCoverFileSize", "setCompressCoverFileSize", "getPickStart", "()J", "setPickStart", "(J)V", "getSendStart", "setSendStart", "getPreStart", "setPreStart", "getPreMerged", "setPreMerged", "getCompressStart", "setCompressStart", "getTotalDuration", "setTotalDuration", "getPickDuration", "setPickDuration", "getPreDuration", "setPreDuration", "getCompressDuration", "setCompressDuration", "getUploadDuration", "setUploadDuration", "getCompressUploadDuration", "setCompressUploadDuration", "getSendDuration", "setSendDuration", "()I", "setRemux", "(I)V", "setHDR", "getUnenabledEemuxCode", "setUnenabledEemuxCode", "getUseWeakNetSetting", "setUseWeakNetSetting", "getCompileScene", "setCompileScene", "getCompileQuality", "setCompileQuality", "getResult", "setResult", "getErrorType", "setErrorType", "getErrorCode", "setErrorCode", "getErrorMsg", "setErrorMsg", "getErrorStatus", "setErrorStatus", "setRaw", "setOriginal", "setUseCache", "setMergePreCompress", "setCompressUpload", "setCompressUploadSuccess", "getCompressUploadFailedMsg", "setCompressUploadFailedMsg", "getSendNetStatus", "setSendNetStatus", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class MediaMessageReport {
    private String compileQuality;
    private String compileScene;
    private float compressCoverFileSize;
    private long compressDuration;
    private long compressStart;
    private long compressUploadDuration;
    private String compressUploadFailedMsg;
    private int errorCode;
    private String errorMsg;
    private int errorStatus;
    private String errorType;
    private int isCompressUpload;
    private int isCompressUploadSuccess;
    private int isHDR;
    private int isMergePreCompress;
    private int isOriginal;
    private int isRaw;
    private int isRemux;
    private int isUseCache;
    private float originBitrate;
    private String originEncodeFormat;
    private float originFPS;
    private float originFileSize;
    private float originLastModifyDiff;
    private String originVideoFormat;
    private String originVideoSize;
    private long pickDuration;
    private long pickStart;
    private long preDuration;
    private long preMerged;
    private long preStart;
    private String result;
    private float resultBitrate;
    private String resultEncodeFormat;
    private float resultFPS;
    private float resultFileSize;
    private String resultVideoSize;
    private long sendDuration;
    private int sendNetStatus;
    private long sendStart;
    private long totalDuration;
    private int unenabledEemuxCode;
    private long uploadDuration;
    private int useWeakNetSetting;
    private float videoDuration;
    private String videoSource;

    public MediaMessageReport() {
        this(0.0f, 0.0f, 0.0f, null, null, null, 0.0f, 0.0f, null, 0.0f, 0.0f, 0.0f, null, null, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0, null, 0, 0, 0, 0, 0, 0, 0, null, 0, -1, 16383, null);
    }

    public final String getCompileQuality() {
        return this.compileQuality;
    }

    public final String getCompileScene() {
        return this.compileScene;
    }

    public final float getCompressCoverFileSize() {
        return this.compressCoverFileSize;
    }

    public final long getCompressDuration() {
        return this.compressDuration;
    }

    public final long getCompressStart() {
        return this.compressStart;
    }

    public final long getCompressUploadDuration() {
        return this.compressUploadDuration;
    }

    public final String getCompressUploadFailedMsg() {
        return this.compressUploadFailedMsg;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final int getErrorStatus() {
        return this.errorStatus;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final float getOriginBitrate() {
        return this.originBitrate;
    }

    public final String getOriginEncodeFormat() {
        return this.originEncodeFormat;
    }

    public final float getOriginFPS() {
        return this.originFPS;
    }

    public final float getOriginFileSize() {
        return this.originFileSize;
    }

    public final float getOriginLastModifyDiff() {
        return this.originLastModifyDiff;
    }

    public final String getOriginVideoFormat() {
        return this.originVideoFormat;
    }

    public final String getOriginVideoSize() {
        return this.originVideoSize;
    }

    public final long getPickDuration() {
        return this.pickDuration;
    }

    public final long getPickStart() {
        return this.pickStart;
    }

    public final long getPreDuration() {
        return this.preDuration;
    }

    public final long getPreMerged() {
        return this.preMerged;
    }

    public final long getPreStart() {
        return this.preStart;
    }

    public final String getResult() {
        return this.result;
    }

    public final float getResultBitrate() {
        return this.resultBitrate;
    }

    public final String getResultEncodeFormat() {
        return this.resultEncodeFormat;
    }

    public final float getResultFPS() {
        return this.resultFPS;
    }

    public final float getResultFileSize() {
        return this.resultFileSize;
    }

    public final String getResultVideoSize() {
        return this.resultVideoSize;
    }

    public final long getSendDuration() {
        return this.sendDuration;
    }

    public final int getSendNetStatus() {
        return this.sendNetStatus;
    }

    public final long getSendStart() {
        return this.sendStart;
    }

    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final int getUnenabledEemuxCode() {
        return this.unenabledEemuxCode;
    }

    public final long getUploadDuration() {
        return this.uploadDuration;
    }

    public final int getUseWeakNetSetting() {
        return this.useWeakNetSetting;
    }

    public final float getVideoDuration() {
        return this.videoDuration;
    }

    public final String getVideoSource() {
        return this.videoSource;
    }

    public final int isCompressUpload() {
        return this.isCompressUpload;
    }

    public final int isCompressUploadSuccess() {
        return this.isCompressUploadSuccess;
    }

    public final int isHDR() {
        return this.isHDR;
    }

    public final int isMergePreCompress() {
        return this.isMergePreCompress;
    }

    public final int isOriginal() {
        return this.isOriginal;
    }

    public final int isRaw() {
        return this.isRaw;
    }

    public final int isRemux() {
        return this.isRemux;
    }

    public final int isUseCache() {
        return this.isUseCache;
    }

    public final void setCompileQuality(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.compileQuality = r100;
    }

    public final void setCompileScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.compileScene = r100;
    }

    public final void setCompressCoverFileSize(float r100) {
        this.compressCoverFileSize = r100;
    }

    public final void setCompressDuration(long r100) {
        this.compressDuration = r100;
    }

    public final void setCompressStart(long r100) {
        this.compressStart = r100;
    }

    public final void setCompressUpload(int r100) {
        this.isCompressUpload = r100;
    }

    public final void setCompressUploadDuration(long r100) {
        this.compressUploadDuration = r100;
    }

    public final void setCompressUploadFailedMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.compressUploadFailedMsg = r100;
    }

    public final void setCompressUploadSuccess(int r100) {
        this.isCompressUploadSuccess = r100;
    }

    public final void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public final void setErrorMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorMsg = r100;
    }

    public final void setErrorStatus(int r100) {
        this.errorStatus = r100;
    }

    public final void setErrorType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorType = r100;
    }

    public final void setHDR(int r100) {
        this.isHDR = r100;
    }

    public final void setMergePreCompress(int r100) {
        this.isMergePreCompress = r100;
    }

    public final void setOriginBitrate(float r100) {
        this.originBitrate = r100;
    }

    public final void setOriginEncodeFormat(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originEncodeFormat = r100;
    }

    public final void setOriginFPS(float r100) {
        this.originFPS = r100;
    }

    public final void setOriginFileSize(float r100) {
        this.originFileSize = r100;
    }

    public final void setOriginLastModifyDiff(float r100) {
        this.originLastModifyDiff = r100;
    }

    public final void setOriginVideoFormat(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originVideoFormat = r100;
    }

    public final void setOriginVideoSize(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originVideoSize = r100;
    }

    public final void setOriginal(int r100) {
        this.isOriginal = r100;
    }

    public final void setPickDuration(long r100) {
        this.pickDuration = r100;
    }

    public final void setPickStart(long r100) {
        this.pickStart = r100;
    }

    public final void setPreDuration(long r100) {
        this.preDuration = r100;
    }

    public final void setPreMerged(long r100) {
        this.preMerged = r100;
    }

    public final void setPreStart(long r100) {
        this.preStart = r100;
    }

    public final void setRaw(int r100) {
        this.isRaw = r100;
    }

    public final void setRemux(int r100) {
        this.isRemux = r100;
    }

    public final void setResult(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.result = r100;
    }

    public final void setResultBitrate(float r100) {
        this.resultBitrate = r100;
    }

    public final void setResultEncodeFormat(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resultEncodeFormat = r100;
    }

    public final void setResultFPS(float r100) {
        this.resultFPS = r100;
    }

    public final void setResultFileSize(float r100) {
        this.resultFileSize = r100;
    }

    public final void setResultVideoSize(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resultVideoSize = r100;
    }

    public final void setSendDuration(long r100) {
        this.sendDuration = r100;
    }

    public final void setSendNetStatus(int r100) {
        this.sendNetStatus = r100;
    }

    public final void setSendStart(long r100) {
        this.sendStart = r100;
    }

    public final void setTotalDuration(long r100) {
        this.totalDuration = r100;
    }

    public final void setUnenabledEemuxCode(int r100) {
        this.unenabledEemuxCode = r100;
    }

    public final void setUploadDuration(long r100) {
        this.uploadDuration = r100;
    }

    public final void setUseCache(int r100) {
        this.isUseCache = r100;
    }

    public final void setUseWeakNetSetting(int r100) {
        this.useWeakNetSetting = r100;
    }

    public final void setVideoDuration(float r100) {
        this.videoDuration = r100;
    }

    public final void setVideoSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoSource = r100;
    }

    public MediaMessageReport(float r110, float r111, float r112, String r113, String r114, String r210, float r211, float r212, String r213, float r214, float r215, float r216, String r217, String r218, float r219, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, int r512, int r513, int r514, int r515, String r516, String r517, String r610, String r611, int r612, String r613, int r614, int r615, int r616, int r617, int r618, int r619, int r710, String r711, int r712) {
        Intrinsics.checkNotNullParameter(r113, "originVideoSize");
        Intrinsics.checkNotNullParameter(r114, "originVideoFormat");
        Intrinsics.checkNotNullParameter(r210, "originEncodeFormat");
        Intrinsics.checkNotNullParameter(r213, "videoSource");
        Intrinsics.checkNotNullParameter(r217, "resultVideoSize");
        Intrinsics.checkNotNullParameter(r218, "resultEncodeFormat");
        Intrinsics.checkNotNullParameter(r516, "compileScene");
        Intrinsics.checkNotNullParameter(r517, "compileQuality");
        Intrinsics.checkNotNullParameter(r610, "result");
        Intrinsics.checkNotNullParameter(r611, "errorType");
        Intrinsics.checkNotNullParameter(r613, "errorMsg");
        Intrinsics.checkNotNullParameter(r711, "compressUploadFailedMsg");
        this.originFPS = r110;
        this.originFileSize = r111;
        this.originBitrate = r112;
        this.originVideoSize = r113;
        this.originVideoFormat = r114;
        this.originEncodeFormat = r210;
        this.originLastModifyDiff = r211;
        this.videoDuration = r212;
        this.videoSource = r213;
        this.resultFPS = r214;
        this.resultFileSize = r215;
        this.resultBitrate = r216;
        this.resultVideoSize = r217;
        this.resultEncodeFormat = r218;
        this.compressCoverFileSize = r219;
        this.pickStart = r310;
        this.sendStart = r311;
        this.preStart = r312;
        this.preMerged = r313;
        this.compressStart = r314;
        this.totalDuration = r410;
        this.pickDuration = r411;
        this.preDuration = r412;
        this.compressDuration = r413;
        this.uploadDuration = r414;
        this.compressUploadDuration = r510;
        this.sendDuration = r511;
        this.isRemux = r512;
        this.isHDR = r513;
        this.unenabledEemuxCode = r514;
        this.useWeakNetSetting = r515;
        this.compileScene = r516;
        this.compileQuality = r517;
        this.result = r610;
        this.errorType = r611;
        this.errorCode = r612;
        this.errorMsg = r613;
        this.errorStatus = r614;
        this.isRaw = r615;
        this.isOriginal = r616;
        this.isUseCache = r617;
        this.isMergePreCompress = r618;
        this.isCompressUpload = r619;
        this.isCompressUploadSuccess = r710;
        this.compressUploadFailedMsg = r711;
        this.sendNetStatus = r712;
    }

    public /* synthetic */ MediaMessageReport(float r510, float r511, float r610, String r611, String r612, String r613, float r614, float r615, String r616, float r617, float r618, float r619, String r710, String r711, float r712, long r713, long r714, long r715, long r716, long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, int r913, int r914, int r915, int r100, String r101, String r102, String r103, String r104, int r105, String r106, int r107, int r108, int r109, int r110, int r111, int r112, int r113, String r114, int r115, int r116, int r117, DefaultConstructorMarker r118) {
        if ((r116 & 1) == 0) goto L5;
        float r119 = 0.0f;
    L7:
        if ((r116 & 2) == 0) goto L9;
        float r120 = 0.0f;
    L11:
        if ((r116 & 4) == 0) goto L13;
        float r121 = 0.0f;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r122 = "";
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r123 = "";
    L23:
        if ((r116 & 32) == 0) goto L25;
        String r124 = "";
    L27:
        if ((r116 & 64) == 0) goto L29;
        float r125 = 0.0f;
    L31:
        if ((r116 & 128) == 0) goto L33;
        float r126 = 0.0f;
    L35:
        if ((r116 & 256) == 0) goto L37;
        String r127 = "";
    L39:
        if ((r116 & 512) == 0) goto L41;
        float r128 = 0.0f;
    L43:
        if ((r116 & 1024) == 0) goto L45;
        float r129 = 0.0f;
    L47:
        if ((r116 & 2048) == 0) goto L49;
        float r130 = 0.0f;
    L51:
        if ((r116 & 4096) == 0) goto L53;
        String r131 = "";
    L55:
        if ((r116 & 8192) == 0) goto L57;
        String r132 = "";
    L58:
        String r133 = r132;
        if ((r116 & 16384) == 0) goto L61;
        float r134 = 0.0f;
    L62:
        long r135 = 0;
        if ((r116 & 32768) == 0) goto L65;
        long r210 = 0;
    L67:
        if ((r116 & 65536) == 0) goto L69;
        long r211 = 0;
    L71:
        if ((r116 & 131072) == 0) goto L73;
        long r212 = 0;
    L75:
        if ((r116 & 262144) == 0) goto L77;
        long r213 = 0;
    L79:
        if ((r116 & 524288) == 0) goto L81;
        long r214 = 0;
    L83:
        if ((r116 & 1048576) == 0) goto L85;
        long r310 = 0;
    L87:
        if ((r116 & 2097152) == 0) goto L89;
        long r311 = 0;
    L91:
        if ((r116 & 4194304) == 0) goto L93;
        long r312 = 0;
    L95:
        if ((r116 & 8388608) == 0) goto L97;
        long r313 = 0;
    L99:
        if ((r116 & 16777216) == 0) goto L101;
        long r314 = 0;
    L103:
        if ((r116 & 33554432) == 0) goto L105;
        long r410 = 0;
    L107:
        if ((r116 & 67108864) != 0) goto L110;
        r135 = r912;
    L110:
        int r411 = 0;
        if ((r116 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r136 = 0;
    L115:
        if ((r116 & 268435456) == 0) goto L117;
        int r412 = 0;
    L119:
        if ((r116 & 536870912) == 0) goto L121;
        int r413 = 0;
    L123:
        if ((r116 & 1073741824) == 0) goto L125;
        int r414 = 0;
    L127:
        if ((r116 & Integer.MIN_VALUE) == 0) goto L129;
        String r137 = "";
    L131:
        if ((r117 & 1) == 0) goto L133;
        String r415 = "";
    L135:
        if ((r117 & 2) == 0) goto L137;
        String r416 = "";
    L139:
        if ((r117 & 4) == 0) goto L141;
        String r417 = "";
    L143:
        if ((r117 & 8) == 0) goto L145;
        int r418 = 0;
    L147:
        if ((r117 & 16) == 0) goto L149;
        String r512 = "";
    L151:
        if ((r117 & 32) == 0) goto L153;
        int r513 = 0;
    L155:
        if ((r117 & 64) == 0) goto L157;
        int r514 = 0;
    L158:
        String r1110 = r137;
        if ((r117 & 128) == 0) goto L161;
        int r138 = 0;
    L162:
        int r1111 = r138;
        if ((r117 & 256) == 0) goto L165;
        int r139 = 0;
    L166:
        int r515 = r139;
        if ((r117 & 512) == 0) goto L169;
        int r140 = 0;
    L170:
        int r516 = r140;
        if ((r117 & 1024) == 0) goto L173;
        int r141 = 0;
    L174:
        int r517 = r141;
        if ((r117 & 2048) == 0) goto L177;
        int r142 = 0;
    L178:
        int r518 = r142;
        if ((r117 & 4096) == 0) goto L181;
        String r143 = "";
    L183:
        if ((r117 & 8192) != 0) goto L186;
        r411 = r115;
    L186:
        this(r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r133, r134, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r410, r135, r136, r412, r413, r414, r1110, r415, r416, r417, r418, r512, r513, r514, r1111, r515, r516, r517, r518, r143, r411);
        return;
    L181:
        r143 = r114;
        goto L183
    L177:
        r142 = r113;
        goto L178
    L173:
        r141 = r112;
        goto L174
    L169:
        r140 = r111;
        goto L170
    L165:
        r139 = r110;
        goto L166
    L161:
        r138 = r109;
        goto L162
    L157:
        r514 = r108;
        goto L158
    L153:
        r513 = r107;
        goto L155
    L149:
        r512 = r106;
        goto L151
    L145:
        r418 = r105;
        goto L147
    L141:
        r417 = r104;
        goto L143
    L137:
        r416 = r103;
        goto L139
    L133:
        r415 = r102;
        goto L135
    L129:
        r137 = r101;
        goto L131
    L125:
        r414 = r100;
        goto L127
    L121:
        r413 = r915;
        goto L123
    L117:
        r412 = r914;
        goto L119
    L113:
        r136 = r913;
        goto L115
    L105:
        r410 = r911;
        goto L107
    L101:
        r314 = r910;
        goto L103
    L97:
        r313 = r814;
        goto L99
    L93:
        r312 = r813;
        goto L95
    L89:
        r311 = r812;
        goto L91
    L85:
        r310 = r811;
        goto L87
    L81:
        r214 = r810;
        goto L83
    L77:
        r213 = r716;
        goto L79
    L73:
        r212 = r715;
        goto L75
    L69:
        r211 = r714;
        goto L71
    L65:
        r210 = r713;
        goto L67
    L61:
        r134 = r712;
        goto L62
    L57:
        r132 = r711;
        goto L58
    L53:
        r131 = r710;
        goto L55
    L49:
        r130 = r619;
        goto L51
    L45:
        r129 = r618;
        goto L47
    L41:
        r128 = r617;
        goto L43
    L37:
        r127 = r616;
        goto L39
    L33:
        r126 = r615;
        goto L35
    L29:
        r125 = r614;
        goto L31
    L25:
        r124 = r613;
        goto L27
    L21:
        r123 = r612;
        goto L23
    L17:
        r122 = r611;
        goto L19
    L13:
        r121 = r610;
        goto L15
    L9:
        r120 = r511;
        goto L11
    L5:
        r119 = r510;
        goto L7
    }
}
