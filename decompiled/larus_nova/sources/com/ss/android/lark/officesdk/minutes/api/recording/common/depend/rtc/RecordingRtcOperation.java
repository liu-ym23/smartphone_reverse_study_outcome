package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.rtc;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/rtc/RecordingRtcOperation;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", ErrorCode.INIT, "JOIN", "CAPTURE", "PUBLISH", "EXTERNAL_PUSH", "CAPTURE_STOP", "LEAVE", "DESTROY", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordingRtcOperation extends Enum<RecordingRtcOperation> {
    public static final RecordingRtcOperation CAPTURE = null;
    public static final RecordingRtcOperation CAPTURE_STOP = null;
    public static final RecordingRtcOperation DESTROY = null;
    public static final RecordingRtcOperation EXTERNAL_PUSH = null;
    public static final RecordingRtcOperation INIT = null;
    public static final RecordingRtcOperation JOIN = null;
    public static final RecordingRtcOperation LEAVE = null;
    public static final RecordingRtcOperation PUBLISH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordingRtcOperation[] f433551a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433552b = null;
    private final String value;

    public static EnumEntries<RecordingRtcOperation> getEntries() {
        return f433552b;
    }

    static {
        RecordingRtcOperation r100 = new RecordingRtcOperation(ErrorCode.INIT, 0, "init");
        INIT = r100;
        RecordingRtcOperation r101 = new RecordingRtcOperation("JOIN", 1, "join");
        JOIN = r101;
        RecordingRtcOperation r102 = new RecordingRtcOperation("CAPTURE", 2, "capture");
        CAPTURE = r102;
        RecordingRtcOperation r103 = new RecordingRtcOperation("PUBLISH", 3, "publish");
        PUBLISH = r103;
        RecordingRtcOperation r104 = new RecordingRtcOperation("EXTERNAL_PUSH", 4, "external_push");
        EXTERNAL_PUSH = r104;
        RecordingRtcOperation r105 = new RecordingRtcOperation("CAPTURE_STOP", 5, "capture_stop");
        CAPTURE_STOP = r105;
        RecordingRtcOperation r110 = new RecordingRtcOperation("LEAVE", 6, "leave");
        LEAVE = r110;
        RecordingRtcOperation r111 = new RecordingRtcOperation("DESTROY", 7, MapMonitorConst.EVENT_DESTROY);
        DESTROY = r111;
        RecordingRtcOperation[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f433551a = r112;
        f433552b = EnumEntriesKt.enumEntries(r112);
    }

    public static RecordingRtcOperation[] values() {
        return (RecordingRtcOperation[]) f433551a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static RecordingRtcOperation valueOf(String r100) {
        return (RecordingRtcOperation) a.a(RecordingRtcOperation.class, r100);
    }

    public RecordingRtcOperation(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
